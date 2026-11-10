package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior {
    private int overlayTop;
    final Rect tempRect1;
    final Rect tempRect2;
    private int verticalLayoutGap;

    public HeaderScrollingViewBehavior() {
        super();
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    public HeaderScrollingViewBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.tempRect1 = new Rect();
        this.tempRect2 = new Rect();
        this.verticalLayoutGap = 0;
    }

    abstract View findFirstDependency(List arg1);

    final int getOverlapPixelsForOffset(View arg3) {
        if(this.overlayTop == 0) {
            return 0;
        }

        return MathUtils.clamp(((int)(this.getOverlapRatioForOffset(arg3) * (((float)this.overlayTop)))), 0, this.overlayTop);
    }

    float getOverlapRatioForOffset(View arg1) {
        return 1f;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    int getScrollRange(View arg1) {
        return arg1.getMeasuredHeight();
    }

    final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    protected void layoutChild(CoordinatorLayout arg9, View arg10, int arg11) {
        View v0 = this.findFirstDependency(arg9.getDependencies(arg10));
        if(v0 != null) {
            ViewGroup$LayoutParams v1 = arg10.getLayoutParams();
            Rect v5 = this.tempRect1;
            v5.set(arg9.getPaddingLeft() + ((LayoutParams)v1).leftMargin, v0.getBottom() + ((LayoutParams)v1).topMargin, arg9.getWidth() - arg9.getPaddingRight() - ((LayoutParams)v1).rightMargin, arg9.getHeight() + v0.getBottom() - arg9.getPaddingBottom() - ((LayoutParams)v1).bottomMargin);
            WindowInsetsCompat v2 = arg9.getLastWindowInsets();
            if(v2 != null && (ViewCompat.getFitsSystemWindows(((View)arg9))) && !ViewCompat.getFitsSystemWindows(arg10)) {
                v5.left += v2.getSystemWindowInsetLeft();
                v5.right -= v2.getSystemWindowInsetRight();
            }

            Rect v6 = this.tempRect2;
            GravityCompat.apply(HeaderScrollingViewBehavior.resolveGravity(((LayoutParams)v1).gravity), arg10.getMeasuredWidth(), arg10.getMeasuredHeight(), v5, v6, arg11);
            int v9 = this.getOverlapPixelsForOffset(v0);
            arg10.layout(v6.left, v6.top - v9, v6.right, v6.bottom - v9);
            this.verticalLayoutGap = v6.top - v0.getBottom();
            return;
        }

        super.layoutChild(arg9, arg10, arg11);
        this.verticalLayoutGap = 0;
    }

    public boolean onMeasureChild(CoordinatorLayout arg7, View arg8, int arg9, int arg10, int arg11, int arg12) {
        int v0 = arg8.getLayoutParams().height;
        int v1 = -1;
        if(v0 == v1 || v0 == -2) {
            View v2 = this.findFirstDependency(arg7.getDependencies(arg8));
            if(v2 != null) {
                arg11 = View$MeasureSpec.getSize(arg11);
                if(arg11 <= 0) {
                    arg11 = arg7.getHeight();
                }
                else if(ViewCompat.getFitsSystemWindows(v2)) {
                    WindowInsetsCompat v3 = arg7.getLastWindowInsets();
                    if(v3 != null) {
                        arg11 += v3.getSystemWindowInsetTop() + v3.getSystemWindowInsetBottom();
                    }
                }

                arg11 += this.getScrollRange(v2);
                int v2_1 = v2.getMeasuredHeight();
                if(this.shouldHeaderOverlapScrollingChild()) {
                    arg8.setTranslationY(((float)(-v2_1)));
                }
                else {
                    arg8.setTranslationY(0f);
                    arg11 -= v2_1;
                }

                int v6 = v0 == v1 ? 0x40000000 : 0x80000000;
                arg7.onMeasureChild(arg8, arg9, arg10, View$MeasureSpec.makeMeasureSpec(arg11, v6), arg12);
                return 1;
            }
        }

        return 0;
    }

    private static int resolveGravity(int arg0) {
        if(arg0 == 0) {
            arg0 = 0x800033;
        }

        return arg0;
    }

    public final void setOverlayTop(int arg1) {
        this.overlayTop = arg1;
    }

    protected boolean shouldHeaderOverlapScrollingChild() {
        return 0;
    }
}

