package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver$OnPreDrawListener;

class GhostViewPort extends ViewGroup implements GhostView {
    class androidx.transition.GhostViewPort$1 implements ViewTreeObserver$OnPreDrawListener {
        androidx.transition.GhostViewPort$1(GhostViewPort arg1) {
            GhostViewPort.this = arg1;
            super();
        }

        public boolean onPreDraw() {
            GhostViewPort.this.postInvalidateOnAnimation();
            if(GhostViewPort.this.mStartParent != null && GhostViewPort.this.mStartView != null) {
                GhostViewPort.this.mStartParent.endViewTransition(GhostViewPort.this.mStartView);
                GhostViewPort.this.mStartParent.postInvalidateOnAnimation();
                GhostViewPort.this.mStartParent = null;
                GhostViewPort.this.mStartView = null;
            }

            return 1;
        }
    }

    private Matrix mMatrix;
    private final ViewTreeObserver$OnPreDrawListener mOnPreDrawListener;
    int mReferences;
    ViewGroup mStartParent;
    View mStartView;
    final View mView;

    GhostViewPort(View arg2) {
        super(arg2.getContext());
        this.mOnPreDrawListener = new androidx.transition.GhostViewPort$1(this);
        this.mView = arg2;
        this.setWillNotDraw(false);
        this.setClipChildren(false);
        this.setLayerType(2, null);
    }

    static GhostViewPort addGhost(View arg4, ViewGroup arg5, Matrix arg6) {
        int v3;
        if((arg4.getParent() instanceof ViewGroup)) {
            GhostViewHolder v0 = GhostViewHolder.getHolder(arg5);
            GhostViewPort v1 = GhostViewPort.getGhostView(arg4);
            if(v1 != null) {
                ViewParent v2 = v1.getParent();
                if((((GhostViewHolder)v2)) != v0) {
                    v3 = v1.mReferences;
                    ((GhostViewHolder)v2).removeView(((View)v1));
                    v1 = null;
                }
                else {
                    goto label_12;
                }
            }
            else {
            label_12:
                v3 = 0;
            }

            if(v1 == null) {
                if(arg6 == null) {
                    arg6 = new Matrix();
                    GhostViewPort.calculateMatrix(arg4, arg5, arg6);
                }

                v1 = new GhostViewPort(arg4);
                v1.setMatrix(arg6);
                if(v0 == null) {
                    v0 = new GhostViewHolder(arg5);
                }
                else {
                    v0.popToOverlayTop();
                }

                GhostViewPort.copySize(((View)arg5), ((View)v0));
                GhostViewPort.copySize(((View)arg5), ((View)v1));
                v0.addGhostView(v1);
                v1.mReferences = v3;
            }
            else {
                if(arg6 == null) {
                    goto label_33;
                }

                v1.setMatrix(arg6);
            }

        label_33:
            ++v1.mReferences;
            return v1;
        }

        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void calculateMatrix(View arg1, ViewGroup arg2, Matrix arg3) {
        ViewParent v1 = arg1.getParent();
        arg3.reset();
        ViewUtils.transformMatrixToGlobal(((View)v1), arg3);
        arg3.preTranslate(((float)(-((ViewGroup)v1).getScrollX())), ((float)(-((ViewGroup)v1).getScrollY())));
        ViewUtils.transformMatrixToLocal(((View)arg2), arg3);
    }

    static void copySize(View arg4, View arg5) {
        ViewUtils.setLeftTopRightBottom(arg5, arg5.getLeft(), arg5.getTop(), arg5.getLeft() + arg4.getWidth(), arg5.getTop() + arg4.getHeight());
    }

    static GhostViewPort getGhostView(View arg1) {
        return arg1.getTag(id.ghost_view);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GhostViewPort.setGhostView(this.mView, this);
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 4);
        if(this.mView.getParent() != null) {
            this.mView.getParent().invalidate();
        }
    }

    protected void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        GhostViewPort.setGhostView(this.mView, null);
        if(this.mView.getParent() != null) {
            this.mView.getParent().invalidate();
        }

        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas arg5) {
        CanvasUtils.enableZ(arg5, true);
        arg5.setMatrix(this.mMatrix);
        ViewUtils.setTransitionVisibility(this.mView, 0);
        this.mView.invalidate();
        ViewUtils.setTransitionVisibility(this.mView, 4);
        this.drawChild(arg5, this.mView, this.getDrawingTime());
        CanvasUtils.enableZ(arg5, false);
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    static void removeGhost(View arg1) {
        GhostViewPort v1 = GhostViewPort.getGhostView(arg1);
        if(v1 != null) {
            int v0 = v1.mReferences - 1;
            v1.mReferences = v0;
            if(v0 <= 0) {
                v1.getParent().removeView(((View)v1));
            }
        }
    }

    public void reserveEndViewTransition(ViewGroup arg1, View arg2) {
        this.mStartParent = arg1;
        this.mStartView = arg2;
    }

    static void setGhostView(View arg1, GhostViewPort arg2) {
        arg1.setTag(id.ghost_view, arg2);
    }

    void setMatrix(Matrix arg1) {
        this.mMatrix = arg1;
    }

    public void setVisibility(int arg2) {
        super.setVisibility(arg2);
        if(GhostViewPort.getGhostView(this.mView) == this) {
            arg2 = arg2 == 0 ? 4 : 0;
            ViewUtils.setTransitionVisibility(this.mView, arg2);
        }
    }
}

