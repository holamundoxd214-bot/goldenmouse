package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

abstract class HeaderBehavior extends ViewOffsetBehavior {
    class FlingRunnable implements Runnable {
        private final View layout;
        private final CoordinatorLayout parent;

        FlingRunnable(HeaderBehavior arg1, CoordinatorLayout arg2, View arg3) {
            HeaderBehavior.this = arg1;
            super();
            this.parent = arg2;
            this.layout = arg3;
        }

        public void run() {
            if(this.layout != null && HeaderBehavior.this.scroller != null) {
                boolean v0 = HeaderBehavior.this.scroller.computeScrollOffset();
                HeaderBehavior v1 = HeaderBehavior.this;
                if(v0) {
                    v1.setHeaderTopBottomOffset(this.parent, this.layout, v1.scroller.getCurrY());
                    ViewCompat.postOnAnimation(this.layout, ((Runnable)this));
                    return;
                }
                else {
                    v1.onFlingFinished(this.parent, this.layout);
                }
            }
        }
    }

    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    OverScroller scroller;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    public HeaderBehavior() {
        super();
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    public HeaderBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.activePointerId = -1;
        this.touchSlop = -1;
    }

    boolean canDragView(View arg1) {
        return 0;
    }

    private void ensureVelocityTracker() {
        if(this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    final boolean fling(CoordinatorLayout arg12, View arg13, int arg14, int arg15, float arg16) {
        Runnable v0 = this.flingRunnable;
        if(v0 != null) {
            arg13.removeCallbacks(v0);
            this.flingRunnable = null;
        }

        OverScroller v0_1 = this.scroller;
        if(v0_1 == null) {
            v0_1 = new OverScroller(arg13.getContext());
            this.scroller = v0_1;
        }

        v0_1.fling(0, this.getTopAndBottomOffset(), 0, Math.round(arg16), 0, 0, arg14, arg15);
        if(this.scroller.computeScrollOffset()) {
            FlingRunnable v14 = new FlingRunnable(this, arg12, arg13);
            this.flingRunnable = ((Runnable)v14);
            ViewCompat.postOnAnimation(arg13, ((Runnable)v14));
            return 1;
        }

        this.onFlingFinished(arg12, arg13);
        return 0;
    }

    int getMaxDragOffset(View arg1) {
        return -arg1.getHeight();
    }

    int getScrollRangeForDragFling(View arg1) {
        return arg1.getHeight();
    }

    int getTopBottomOffsetForScrollingSibling() {
        return this.getTopAndBottomOffset();
    }

    void onFlingFinished(CoordinatorLayout arg1, View arg2) {
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout arg7, View arg8, MotionEvent arg9) {
        int v0;
        if(this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(arg7.getContext()).getScaledTouchSlop();
        }

        int v3 = -1;
        if(arg9.getActionMasked() == 2 && (this.isBeingDragged)) {
            v0 = this.activePointerId;
            if(v0 == v3) {
                return 0;
            }
            else {
                v0 = arg9.findPointerIndex(v0);
                if(v0 == v3) {
                    return 0;
                }
                else {
                    v0 = ((int)arg9.getY(v0));
                    if(Math.abs(v0 - this.lastMotionY) > this.touchSlop) {
                        this.lastMotionY = v0;
                        return 1;
                    }
                }
            }
        }

        if(arg9.getActionMasked() == 0) {
            this.activePointerId = v3;
            v0 = ((int)arg9.getX());
            int v1 = ((int)arg9.getY());
            boolean v7 = !this.canDragView(arg8) || !arg7.isPointInChildBounds(arg8, v0, v1) ? false : true;
            this.isBeingDragged = v7;
            if(!v7) {
                goto label_56;
            }

            this.lastMotionY = v1;
            this.activePointerId = arg9.getPointerId(0);
            this.ensureVelocityTracker();
            OverScroller v7_1 = this.scroller;
            if(v7_1 == null) {
                goto label_56;
            }

            if(v7_1.isFinished()) {
                goto label_56;
            }

            this.scroller.abortAnimation();
            return 1;
        }

    label_56:
        VelocityTracker v6 = this.velocityTracker;
        if(v6 != null) {
            v6.addMovement(arg9);
        }

        return 0;
    }

    public boolean onTouchEvent(CoordinatorLayout arg10, View arg11, MotionEvent arg12) {
        VelocityTracker v2;
        int v1 = arg12.getActionMasked();
        int v6 = -1;
        if(v1 != 1) {
            if(v1 == 2) {
                v1 = arg12.findPointerIndex(this.activePointerId);
                if(v1 == v6) {
                    return 0;
                }

                v1 = ((int)arg12.getY(v1));
                int v3 = this.lastMotionY - v1;
                this.lastMotionY = v1;
                this.scroll(arg10, arg11, v3, this.getMaxDragOffset(arg11), 0);
            }
            else if(v1 == 3) {
                goto label_60;
            }
            else if(v1 != 6) {
            }
            else {
                v1 = arg12.getActionIndex() == 0 ? 1 : 0;
                this.activePointerId = arg12.getPointerId(v1);
                this.lastMotionY = ((int)(arg12.getY(v1) + 0.5f));
            }

            v1 = 0;
        }
        else {
            VelocityTracker v1_1 = this.velocityTracker;
            if(v1_1 != null) {
                v1_1.addMovement(arg12);
                this.velocityTracker.computeCurrentVelocity(1000);
                this.fling(arg10, arg11, -this.getScrollRangeForDragFling(arg11), 0, this.velocityTracker.getYVelocity(this.activePointerId));
                v1 = 1;
            }
            else {
            label_60:
                v1 = 0;
            }

            this.isBeingDragged = false;
            this.activePointerId = v6;
            v2 = this.velocityTracker;
            if(v2 == null) {
                goto label_68;
            }

            v2.recycle();
            this.velocityTracker = null;
        }

    label_68:
        v2 = this.velocityTracker;
        if(v2 != null) {
            v2.addMovement(arg12);
        }

        if(!this.isBeingDragged) {
            if(v1 != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    final int scroll(CoordinatorLayout arg2, View arg3, int arg4, int arg5, int arg6) {
        return this.setHeaderTopBottomOffset(arg2, arg3, this.getTopBottomOffsetForScrollingSibling() - arg4, arg5, arg6);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout arg1, View arg2, int arg3, int arg4, int arg5) {
        int v1 = this.getTopAndBottomOffset();
        if(arg4 != 0 && v1 >= arg4 && v1 <= arg5) {
            int v2 = MathUtils.clamp(arg3, arg4, arg5);
            if(v1 != v2) {
                this.setTopAndBottomOffset(v2);
                return v1 - v2;
            }
        }

        return 0;
    }

    int setHeaderTopBottomOffset(CoordinatorLayout arg7, View arg8, int arg9) {
        return this.setHeaderTopBottomOffset(arg7, arg8, arg9, 0x80000000, 0x7FFFFFFF);
    }
}

