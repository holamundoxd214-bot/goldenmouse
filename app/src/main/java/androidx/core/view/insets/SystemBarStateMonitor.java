package androidx.core.view.insets;

import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SystemBarStateMonitor {
    interface Callback {
        void onAnimationEnd();

        void onAnimationProgress(int arg1, Insets arg2, RectF arg3);

        void onAnimationStart();

        void onColorHintChanged(int arg1);

        void onInsetsChanged(Insets arg1, Insets arg2);
    }

    private final ArrayList mCallbacks;
    private int mColorHint;
    private final View mDetector;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;

    static ArrayList -$$Nest$fgetmCallbacks(SystemBarStateMonitor arg0) {
        return arg0.mCallbacks;
    }

    static int -$$Nest$fgetmColorHint(SystemBarStateMonitor arg0) {
        return arg0.mColorHint;
    }

    static void -$$Nest$fputmColorHint(SystemBarStateMonitor arg0, int arg1) {
        arg0.mColorHint = arg1;
    }

    static Insets -$$Nest$mgetInsets(SystemBarStateMonitor arg0, WindowInsetsCompat arg1) {
        return arg0.getInsets(arg1);
    }

    SystemBarStateMonitor(ViewGroup arg4) {
        super();
        this.mCallbacks = new ArrayList();
        this.mInsets = Insets.NONE;
        this.mInsetsIgnoringVisibility = Insets.NONE;
        Drawable v0 = arg4.getBackground();
        int v0_1 = (v0 instanceof ColorDrawable) ? ((ColorDrawable)v0).getColor() : 0;
        this.mColorHint = v0_1;
        androidx.core.view.insets.SystemBarStateMonitor$1 v0_2 = new View(arg4.getContext(), arg4) {
            protected void onConfigurationChanged(Configuration arg3) {
                Drawable v3 = this.val$rootView.getBackground();
                int v3_1 = (v3 instanceof ColorDrawable) ? ((ColorDrawable)v3).getColor() : 0;
                if(SystemBarStateMonitor.-$$Nest$fgetmColorHint(SystemBarStateMonitor.this) != v3_1) {
                    SystemBarStateMonitor.-$$Nest$fputmColorHint(SystemBarStateMonitor.this, v3_1);
                    int v0;
                    for(v0 = SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; v0 >= 0; --v0) {
                        SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(v0).onColorHintChanged(v3_1);
                    }
                }
            }
        };
        this.mDetector = ((View)v0_2);
        ((View)v0_2).setVisibility(8);
        ((View)v0_2).setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(((View)v0_2), new SystemBarStateMonitor$$ExternalSyntheticLambda0(this));
        ViewCompat.setWindowInsetsAnimationCallback(((View)v0_2), new androidx.core.view.WindowInsetsAnimationCompat$Callback(0) {
            private final HashMap mAnimationSidesMap;

            private boolean animatesSystemBars(WindowInsetsAnimationCompat arg1) {
                if((arg1.getTypeMask() & Type.systemBars()) != 0) {
                    return 1;
                }

                return 0;
            }

            public void onEnd(WindowInsetsAnimationCompat arg2) {
                if(!this.animatesSystemBars(arg2)) {
                }
                else {
                    this.mAnimationSidesMap.remove(arg2);
                    int v2;
                    for(v2 = SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; v2 >= 0; --v2) {
                        SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(v2).onAnimationEnd();
                    }
                }
            }

            public void onPrepare(WindowInsetsAnimationCompat arg2) {
                if(!this.animatesSystemBars(arg2)) {
                }
                else {
                    int v2;
                    for(v2 = SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; v2 >= 0; --v2) {
                        SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(v2).onAnimationStart();
                    }
                }
            }

            public WindowInsetsCompat onProgress(WindowInsetsCompat arg7, List arg8) {
                RectF v0 = new RectF(1f, 1f, 1f, 1f);
                int v1 = arg8.size() - 1;
                int v2 = 0;
                while(v1 >= 0) {
                    Object v3 = arg8.get(v1);
                    Object v4 = this.mAnimationSidesMap.get(v3);
                    if(v4 != null) {
                        int v4_1 = ((Integer)v4).intValue();
                        float v3_1 = ((WindowInsetsAnimationCompat)v3).getAlpha();
                        if((v4_1 & 1) != 0) {
                            v0.left = v3_1;
                        }

                        if((v4_1 & 2) != 0) {
                            v0.top = v3_1;
                        }

                        if((v4_1 & 4) != 0) {
                            v0.right = v3_1;
                        }

                        if((v4_1 & 8) != 0) {
                            v0.bottom = v3_1;
                        }

                        v2 |= v4_1;
                    }

                    --v1;
                }

                Insets v8 = SystemBarStateMonitor.-$$Nest$mgetInsets(SystemBarStateMonitor.this, arg7);
                for(v1 = SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).size() - 1; v1 >= 0; --v1) {
                    SystemBarStateMonitor.-$$Nest$fgetmCallbacks(SystemBarStateMonitor.this).get(v1).onAnimationProgress(v2, v8, v0);
                }

                return arg7;
            }

            public BoundsCompat onStart(WindowInsetsAnimationCompat arg6, BoundsCompat arg7) {
                if(!this.animatesSystemBars(arg6)) {
                    return arg7;
                }

                Insets v0 = arg7.getUpperBound();
                Insets v1 = arg7.getLowerBound();
                int v2 = v0.left != v1.left ? 1 : 0;
                if(v0.top != v1.top) {
                    v2 |= 2;
                }

                if(v0.right != v1.right) {
                    v2 |= 4;
                }

                if(v0.bottom != v1.bottom) {
                    v2 |= 8;
                }

                this.mAnimationSidesMap.put(arg6, Integer.valueOf(v2));
                return arg7;
            }
        });
        SystemBarStateMonitor.addViewWhenReady(arg4, ((View)v0_2), 0);
    }

    void addCallback(Callback arg3) {
        if(this.mCallbacks.contains(arg3)) {
            return;
        }

        this.mCallbacks.add(arg3);
        arg3.onInsetsChanged(this.mInsets, this.mInsetsIgnoringVisibility);
        arg3.onColorHintChanged(this.mColorHint);
    }

    private static void addViewWhenReady(ViewGroup arg4, View arg5, int arg6) {
        View v1;
        int v0 = arg4.getChildCount() - 1;
        while(true) {
            if(v0 >= 0) {
                v1 = arg4.getChildAt(v0);
                if(v1.isAttachedToWindow() != arg4.isAttachedToWindow()) {
                }
                else {
                    --v0;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_11;
        }

        v1 = null;
    label_11:
        if(v1 == null) {
            arg4.addView(arg5, arg6);
            return;
        }

        v1.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener(arg4, arg5, arg6) {
            public void onViewAttachedToWindow(View arg4) {
                this.val$group.addView(this.val$child, this.val$index);
                arg4.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
            }

            public void onViewDetachedFromWindow(View arg4) {
                this.val$group.addView(this.val$child, this.val$index);
                arg4.removeOnAttachStateChangeListener(((View$OnAttachStateChangeListener)this));
            }
        });
    }

    void detachFromWindow() {
        this.mDetector.post(new SystemBarStateMonitor$$ExternalSyntheticLambda1(this));
    }

    private Insets getInsets(WindowInsetsCompat arg2) {
        return Insets.min(arg2.getInsets(Type.systemBars()), arg2.getInsets(Type.tappableElement()));
    }

    private Insets getInsetsIgnoringVisibility(WindowInsetsCompat arg2) {
        return Insets.min(arg2.getInsetsIgnoringVisibility(Type.systemBars()), arg2.getInsetsIgnoringVisibility(Type.tappableElement()));
    }

    boolean hasCallback() {
        return this.mCallbacks.isEmpty() ^ 1;
    }

    void lambda$detachFromWindow$1$androidx-core-view-insets-SystemBarStateMonitor() {
        ViewParent v0 = this.mDetector.getParent();
        if((v0 instanceof ViewGroup)) {
            ((ViewGroup)v0).removeView(this.mDetector);
        }
    }

    WindowInsetsCompat lambda$new$0$androidx-core-view-insets-SystemBarStateMonitor(View arg4, WindowInsetsCompat arg5) {
        Insets v4 = this.getInsets(arg5);
        Insets v0 = this.getInsetsIgnoringVisibility(arg5);
        if(!v4.equals(this.mInsets) || !v0.equals(this.mInsetsIgnoringVisibility)) {
            this.mInsets = v4;
            this.mInsetsIgnoringVisibility = v0;
            int v1;
            for(v1 = this.mCallbacks.size() - 1; v1 >= 0; --v1) {
                this.mCallbacks.get(v1).onInsetsChanged(v4, v0);
            }
        }

        return arg5;
    }

    void removeCallback(Callback arg1) {
        this.mCallbacks.remove(arg1);
    }
}

