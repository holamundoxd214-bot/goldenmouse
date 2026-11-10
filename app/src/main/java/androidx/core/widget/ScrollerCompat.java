package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated public final class ScrollerCompat {
    OverScroller mScroller;

    ScrollerCompat(Context arg2, Interpolator arg3) {
        super();
        OverScroller v0 = arg3 != null ? new OverScroller(arg2, arg3) : new OverScroller(arg2);
        this.mScroller = v0;
    }

    @Deprecated public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated public static ScrollerCompat create(Context arg1) {
        return ScrollerCompat.create(arg1, null);
    }

    @Deprecated public static ScrollerCompat create(Context arg1, Interpolator arg2) {
        return new ScrollerCompat(arg1, arg2);
    }

    @Deprecated public void fling(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        this.mScroller.fling(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    @Deprecated public void fling(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        this.mScroller.fling(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    @Deprecated public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated public void notifyHorizontalEdgeReached(int arg1, int arg2, int arg3) {
        this.mScroller.notifyHorizontalEdgeReached(arg1, arg2, arg3);
    }

    @Deprecated public void notifyVerticalEdgeReached(int arg1, int arg2, int arg3) {
        this.mScroller.notifyVerticalEdgeReached(arg1, arg2, arg3);
    }

    @Deprecated public boolean springBack(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        return this.mScroller.springBack(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Deprecated public void startScroll(int arg1, int arg2, int arg3, int arg4) {
        this.mScroller.startScroll(arg1, arg2, arg3, arg4);
    }

    @Deprecated public void startScroll(int arg1, int arg2, int arg3, int arg4, int arg5) {
        this.mScroller.startScroll(arg1, arg2, arg3, arg4, arg5);
    }
}

