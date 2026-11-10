package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

public class NavigationRailMenuView extends NavigationBarMenuView {
    private int itemMinimumHeight;
    private final FrameLayout$LayoutParams layoutParams;

    public NavigationRailMenuView(Context arg3) {
        super(arg3);
        this.itemMinimumHeight = -1;
        FrameLayout$LayoutParams v0 = new FrameLayout$LayoutParams(-1, -2);
        this.layoutParams = v0;
        v0.gravity = 49;
        this.setLayoutParams(((ViewGroup$LayoutParams)v0));
        this.setItemActiveIndicatorResizeable(true);
    }

    protected NavigationBarItemView createNavigationBarItemView(Context arg1) {
        return new NavigationRailItemView(arg1);
    }

    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    boolean isTopGravity() {
        if((this.layoutParams.gravity & 0x70) == 0x30) {
            return 1;
        }

        return 0;
    }

    private int makeSharedHeightSpec(int arg2, int arg3, int arg4) {
        arg3 /= Math.max(1, arg4);
        int v1 = this.itemMinimumHeight;
        if(v1 != -1) {
        }
        else {
            v1 = View$MeasureSpec.getSize(arg2);
        }

        return View$MeasureSpec.makeMeasureSpec(Math.min(v1, arg3), 0);
    }

    private int measureChildHeight(View arg2, int arg3, int arg4) {
        if(arg2.getVisibility() != 8) {
            arg2.measure(arg3, arg4);
            return arg2.getMeasuredHeight();
        }

        return 0;
    }

    private int measureSharedChildHeights(int arg4, int arg5, int arg6, View arg7) {
        int v0 = 0;
        arg5 = arg7 == null ? this.makeSharedHeightSpec(arg4, arg5, arg6) : View$MeasureSpec.makeMeasureSpec(arg7.getMeasuredHeight(), 0);
        arg6 = this.getChildCount();
        int v1 = 0;
        while(v0 < arg6) {
            View v2 = this.getChildAt(v0);
            if(v2 != arg7) {
                v1 += this.measureChildHeight(v2, arg4, arg5);
            }

            ++v0;
        }

        return v1;
    }

    private int measureShiftingChildHeights(int arg3, int arg4, int arg5) {
        int v1;
        View v0 = this.getChildAt(this.getSelectedItemPosition());
        if(v0 != null) {
            v1 = this.measureChildHeight(v0, arg3, this.makeSharedHeightSpec(arg3, arg4, arg5));
            arg4 -= v1;
            --arg5;
        }
        else {
            v1 = 0;
        }

        return v1 + this.measureSharedChildHeights(arg3, arg4, arg5, v0);
    }

    protected void onLayout(boolean arg4, int arg5, int arg6, int arg7, int arg8) {
        int v4 = this.getChildCount();
        arg7 -= arg5;
        arg6 = 0;
        arg8 = 0;
        while(arg6 < v4) {
            View v0 = this.getChildAt(arg6);
            if(v0.getVisibility() != 8) {
                int v1 = v0.getMeasuredHeight() + arg8;
                v0.layout(0, arg8, arg7, v1);
                arg8 = v1;
            }

            ++arg6;
        }
    }

    protected void onMeasure(int arg4, int arg5) {
        int v0 = View$MeasureSpec.getSize(arg5);
        int v1 = this.getMenu().getVisibleItems().size();
        v0 = v1 <= 1 || !this.isShifting(this.getLabelVisibilityMode(), v1) ? this.measureSharedChildHeights(arg4, v0, v1, null) : this.measureShiftingChildHeights(arg4, v0, v1);
        this.setMeasuredDimension(View$MeasureSpec.getSize(arg4), View.resolveSizeAndState(v0, arg5, 0));
    }

    public void setItemMinimumHeight(int arg2) {
        if(this.itemMinimumHeight != arg2) {
            this.itemMinimumHeight = arg2;
            this.requestLayout();
        }
    }

    void setMenuGravity(int arg2) {
        if(this.layoutParams.gravity != arg2) {
            this.layoutParams.gravity = arg2;
            this.setLayoutParams(this.layoutParams);
        }
    }
}

