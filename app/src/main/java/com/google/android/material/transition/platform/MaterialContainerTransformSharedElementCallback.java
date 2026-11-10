package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R$id;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    public interface ShapeProvider {
        ShapeAppearanceModel provideShape(View arg1);
    }

    public class ShapeableViewShapeProvider implements ShapeProvider {
        public ShapeableViewShapeProvider() {
            super();
        }

        public ShapeAppearanceModel provideShape(View arg1) {
            if((arg1 instanceof Shapeable)) {
                return ((Shapeable)arg1).getShapeAppearanceModel();
            }

            return null;
        }
    }

    private static WeakReference capturedSharedElement;
    private boolean entering;
    private Rect returnEndBounds;
    private ShapeProvider shapeProvider;
    private boolean sharedElementReenterTransitionEnabled;
    private boolean transparentWindowBackgroundEnabled;

    public MaterialContainerTransformSharedElementCallback() {
        super();
        this.entering = true;
        this.transparentWindowBackgroundEnabled = true;
        this.sharedElementReenterTransitionEnabled = false;
        this.shapeProvider = new ShapeableViewShapeProvider();
    }

    static void access$000(Window arg0) {
        MaterialContainerTransformSharedElementCallback.removeWindowBackground(arg0);
    }

    static void access$100(Window arg0) {
        MaterialContainerTransformSharedElementCallback.restoreWindowBackground(arg0);
    }

    static WeakReference access$200() {
        return MaterialContainerTransformSharedElementCallback.capturedSharedElement;
    }

    static WeakReference access$202(WeakReference arg0) {
        MaterialContainerTransformSharedElementCallback.capturedSharedElement = arg0;
        return arg0;
    }

    public ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    private static Drawable getWindowBackground(Window arg0) {
        return arg0.getDecorView().getBackground();
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    public Parcelable onCaptureSharedElementSnapshot(View arg2, Matrix arg3, RectF arg4) {
        MaterialContainerTransformSharedElementCallback.capturedSharedElement = new WeakReference(arg2);
        return super.onCaptureSharedElementSnapshot(arg2, arg3, arg4);
    }

    public View onCreateSnapshotView(Context arg2, Parcelable arg3) {
        View v2 = super.onCreateSnapshotView(arg2, arg3);
        if(v2 != null) {
            WeakReference v3 = MaterialContainerTransformSharedElementCallback.capturedSharedElement;
            if(v3 != null && this.shapeProvider != null) {
                Object v3_1 = v3.get();
                if(v3_1 != null) {
                    ShapeAppearanceModel v1 = this.shapeProvider.provideShape(((View)v3_1));
                    if(v1 != null) {
                        v2.setTag(id.mtrl_motion_snapshot_view, v1);
                    }
                }
            }
        }

        return v2;
    }

    public void onMapSharedElements(List arg2, Map arg3) {
        if(!arg2.isEmpty() && !arg3.isEmpty()) {
            Object v2 = arg3.get(arg2.get(0));
            if(v2 != null) {
                Activity v2_1 = ContextUtils.getActivity(((View)v2).getContext());
                if(v2_1 != null) {
                    Window v3 = v2_1.getWindow();
                    if(this.entering) {
                        this.setUpEnterTransform(v3);
                        return;
                    }
                    else {
                        this.setUpReturnTransform(v2_1, v3);
                    }
                }
            }
        }
    }

    public void onSharedElementEnd(List arg3, List arg4, List arg5) {
        if(!arg4.isEmpty() && ((arg4.get(0).getTag(id.mtrl_motion_snapshot_view) instanceof View))) {
            arg4.get(0).setTag(id.mtrl_motion_snapshot_view, null);
        }

        if(!this.entering && !arg4.isEmpty()) {
            this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(arg4.get(0));
        }

        this.entering = false;
    }

    public void onSharedElementStart(List arg3, List arg4, List arg5) {
        if(!arg4.isEmpty() && !arg5.isEmpty()) {
            arg4.get(0).setTag(id.mtrl_motion_snapshot_view, arg5.get(0));
        }

        if(!this.entering && !arg4.isEmpty() && this.returnEndBounds != null) {
            Object v3 = arg4.get(0);
            ((View)v3).measure(View$MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 0x40000000), View$MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 0x40000000));
            ((View)v3).layout(this.returnEndBounds.left, this.returnEndBounds.top, this.returnEndBounds.right, this.returnEndBounds.bottom);
        }
    }

    private static void removeWindowBackground(Window arg2) {
        Drawable v2 = MaterialContainerTransformSharedElementCallback.getWindowBackground(arg2);
        if(v2 == null) {
            return;
        }

        v2.mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    private static void restoreWindowBackground(Window arg0) {
        Drawable v0 = MaterialContainerTransformSharedElementCallback.getWindowBackground(arg0);
        if(v0 == null) {
            return;
        }

        v0.mutate().clearColorFilter();
    }

    public void setShapeProvider(ShapeProvider arg1) {
        this.shapeProvider = arg1;
    }

    public void setSharedElementReenterTransitionEnabled(boolean arg1) {
        this.sharedElementReenterTransitionEnabled = arg1;
    }

    public void setTransparentWindowBackgroundEnabled(boolean arg1) {
        this.transparentWindowBackgroundEnabled = arg1;
    }

    private void setUpEnterTransform(Window arg3) {
        Transition v0 = arg3.getSharedElementEnterTransition();
        if((v0 instanceof MaterialContainerTransform)) {
            if(!this.sharedElementReenterTransitionEnabled) {
                arg3.setSharedElementReenterTransition(null);
            }

            if(!this.transparentWindowBackgroundEnabled) {
                return;
            }

            MaterialContainerTransformSharedElementCallback.updateBackgroundFadeDuration(arg3, ((MaterialContainerTransform)v0));
            ((MaterialContainerTransform)v0).addListener(new TransitionListenerAdapter(arg3) {
                public void onTransitionEnd(Transition arg1) {
                    MaterialContainerTransformSharedElementCallback.restoreWindowBackground(this.val$window);
                }

                public void onTransitionStart(Transition arg1) {
                    MaterialContainerTransformSharedElementCallback.removeWindowBackground(this.val$window);
                }
            });
        }
    }

    private void setUpReturnTransform(Activity arg3, Window arg4) {
        Transition v0 = arg4.getSharedElementReturnTransition();
        if((v0 instanceof MaterialContainerTransform)) {
            ((MaterialContainerTransform)v0).setHoldAtEndEnabled(true);
            ((MaterialContainerTransform)v0).addListener(new TransitionListenerAdapter(arg3) {
                public void onTransitionEnd(Transition arg2) {
                    if(MaterialContainerTransformSharedElementCallback.capturedSharedElement != null) {
                        Object v2 = MaterialContainerTransformSharedElementCallback.capturedSharedElement.get();
                        if(v2 != null) {
                            ((View)v2).setAlpha(1f);
                            MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
                        }
                    }

                    this.val$activity.finish();
                    this.val$activity.overridePendingTransition(0, 0);
                }
            });
            if(this.transparentWindowBackgroundEnabled) {
                MaterialContainerTransformSharedElementCallback.updateBackgroundFadeDuration(arg4, ((MaterialContainerTransform)v0));
                ((MaterialContainerTransform)v0).addListener(new TransitionListenerAdapter(arg4) {
                    public void onTransitionStart(Transition arg1) {
                        MaterialContainerTransformSharedElementCallback.removeWindowBackground(this.val$window);
                    }
                });
            }
        }
    }

    private static void updateBackgroundFadeDuration(Window arg4, MaterialContainerTransform arg5) {
        if(arg5.getDuration() >= 0) {
            arg4.setTransitionBackgroundFadeDuration(arg5.getDuration());
        }
    }
}

