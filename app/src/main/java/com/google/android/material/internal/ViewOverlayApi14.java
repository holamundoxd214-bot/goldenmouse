package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14 implements ViewOverlayImpl {
    class OverlayViewGroup extends ViewGroup {
        private boolean disposed;
        ArrayList drawables;
        ViewGroup hostView;
        static Method invalidateChildInParentFastMethod;
        View requestingView;
        ViewOverlayApi14 viewOverlay;

        static {
            try {
                OverlayViewGroup.invalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
                return;
            }
            catch(NoSuchMethodException ) {
                return;
            }
        }

        OverlayViewGroup(Context arg1, ViewGroup arg2, View arg3, ViewOverlayApi14 arg4) {
            super(arg1);
            this.drawables = null;
            this.hostView = arg2;
            this.requestingView = arg3;
            this.setRight(arg2.getWidth());
            this.setBottom(arg2.getHeight());
            arg2.addView(((View)this));
            this.viewOverlay = arg4;
        }

        public void add(Drawable arg2) {
            this.assertNotDisposed();
            ArrayList v0 = this.drawables;
            if(v0 == null) {
                v0 = new ArrayList();
                this.drawables = v0;
            }

            if(!v0.contains(arg2)) {
                this.drawables.add(arg2);
                this.invalidate(arg2.getBounds());
                arg2.setCallback(((Drawable$Callback)this));
            }
        }

        public void add(View arg6) {
            this.assertNotDisposed();
            if((arg6.getParent() instanceof ViewGroup)) {
                ViewParent v0 = arg6.getParent();
                if(v0 != this.hostView && ((ViewGroup)v0).getParent() != null && (ViewCompat.isAttachedToWindow(((View)v0)))) {
                    int[] v2 = new int[2];
                    int[] v1 = new int[2];
                    ((ViewGroup)v0).getLocationOnScreen(v2);
                    this.hostView.getLocationOnScreen(v1);
                    ViewCompat.offsetLeftAndRight(arg6, v2[0] - v1[0]);
                    ViewCompat.offsetTopAndBottom(arg6, v2[1] - v1[1]);
                }

                ((ViewGroup)v0).removeView(arg6);
                if(arg6.getParent() == null) {
                    goto label_31;
                }

                ((ViewGroup)v0).removeView(arg6);
            }

        label_31:
            super.addView(arg6);
        }

        private void assertNotDisposed() {
            if(!this.disposed) {
                return;
            }

            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        protected void dispatchDraw(Canvas arg6) {
            int[] v1 = new int[2];
            int[] v0 = new int[2];
            this.hostView.getLocationOnScreen(v1);
            this.requestingView.getLocationOnScreen(v0);
            int v2 = 0;
            arg6.translate(((float)(v0[0] - v1[0])), ((float)(v0[1] - v1[1])));
            arg6.clipRect(new Rect(0, 0, this.requestingView.getWidth(), this.requestingView.getHeight()));
            super.dispatchDraw(arg6);
            ArrayList v0_1 = this.drawables;
            int v0_2 = v0_1 == null ? 0 : v0_1.size();
            while(v2 < v0_2) {
                this.drawables.get(v2).draw(arg6);
                ++v2;
            }
        }

        public boolean dispatchTouchEvent(MotionEvent arg1) {
            return 0;
        }

        private void disposeIfEmpty() {
            if(this.getChildCount() == 0) {
                ArrayList v0 = this.drawables;
                if(v0 != null && v0.size() != 0) {
                    return;
                }

                this.disposed = true;
                this.hostView.removeView(((View)this));
            }
        }

        private void getOffset(int[] arg5) {
            int[] v1 = new int[2];
            int[] v0 = new int[2];
            this.hostView.getLocationOnScreen(v1);
            this.requestingView.getLocationOnScreen(v0);
            arg5[0] = v0[0] - v1[0];
            arg5[1] = v0[1] - v1[1];
        }

        public ViewParent invalidateChildInParent(int[] arg5, Rect arg6) {
            if(this.hostView != null) {
                arg6.offset(arg5[0], arg5[1]);
                if(this.hostView != null) {
                    arg5[0] = 0;
                    arg5[1] = 0;
                    int[] v1 = new int[2];
                    this.getOffset(v1);
                    arg6.offset(v1[0], v1[1]);
                    return super.invalidateChildInParent(arg5, arg6);
                }
                else {
                    this.invalidate(arg6);
                }
            }

            return null;
        }

        protected ViewParent invalidateChildInParentFast(int arg2, int arg3, Rect arg4) {
            if(this.hostView != null && OverlayViewGroup.invalidateChildInParentFastMethod != null) {
                int v0 = 2;
                try {
                    this.getOffset(new int[v0]);
                    OverlayViewGroup.invalidateChildInParentFastMethod.invoke(this.hostView, Integer.valueOf(arg2), Integer.valueOf(arg3), arg4);
                }
                catch(InvocationTargetException v1) {
                    v1.printStackTrace();
                }
                catch(IllegalAccessException v1_1) {
                    v1_1.printStackTrace();
                }
            }

            return null;
        }

        public void invalidateDrawable(Drawable arg1) {
            this.invalidate(arg1.getBounds());
        }

        protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        }

        public void remove(Drawable arg2) {
            ArrayList v0 = this.drawables;
            if(v0 != null) {
                v0.remove(arg2);
                this.invalidate(arg2.getBounds());
                arg2.setCallback(null);
                this.disposeIfEmpty();
            }
        }

        public void remove(View arg1) {
            super.removeView(arg1);
            this.disposeIfEmpty();
        }

        protected boolean verifyDrawable(Drawable arg2) {
            if(!super.verifyDrawable(arg2)) {
                ArrayList v1 = this.drawables;
                if(v1 != null && (v1.contains(arg2))) {
                    return 1;
                }

                return 0;
            }

            return 1;
        }
    }

    protected OverlayViewGroup overlayViewGroup;

    ViewOverlayApi14(Context arg2, ViewGroup arg3, View arg4) {
        super();
        this.overlayViewGroup = new OverlayViewGroup(arg2, arg3, arg4, this);
    }

    public void add(Drawable arg1) {
        this.overlayViewGroup.add(arg1);
    }

    static ViewOverlayApi14 createFrom(View arg5) {
        ViewGroup v0 = ViewUtils.getContentView(arg5);
        if(v0 != null) {
            int v1 = v0.getChildCount();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                View v3 = v0.getChildAt(v2);
                if((v3 instanceof OverlayViewGroup)) {
                    return ((OverlayViewGroup)v3).viewOverlay;
                }
            }

            return new ViewGroupOverlayApi14(v0.getContext(), v0, arg5);
        }

        return null;
    }

    public void remove(Drawable arg1) {
        this.overlayViewGroup.remove(arg1);
    }
}

