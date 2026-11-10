package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior extends Behavior {
    private int tempLeftRightOffset;
    private int tempTopBottomOffset;
    private ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
        super();
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public ViewOffsetBehavior(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.tempTopBottomOffset = 0;
        this.tempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null) {
            return v0.getLeftAndRightOffset();
        }

        return 0;
    }

    public int getTopAndBottomOffset() {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null) {
            return v0.getTopAndBottomOffset();
        }

        return 0;
    }

    public boolean isHorizontalOffsetEnabled() {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null && (v0.isHorizontalOffsetEnabled())) {
            return 1;
        }

        return 0;
    }

    public boolean isVerticalOffsetEnabled() {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null && (v0.isVerticalOffsetEnabled())) {
            return 1;
        }

        return 0;
    }

    protected void layoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
        arg1.onLayoutChild(arg2, arg3);
    }

    public boolean onLayoutChild(CoordinatorLayout arg1, View arg2, int arg3) {
        this.layoutChild(arg1, arg2, arg3);
        ViewOffsetHelper v1 = this.viewOffsetHelper;
        if(v1 == null) {
            v1 = new ViewOffsetHelper(arg2);
            this.viewOffsetHelper = v1;
        }

        v1.onViewLayout();
        this.viewOffsetHelper.applyOffsets();
        int v1_1 = this.tempTopBottomOffset;
        if(v1_1 != 0) {
            this.viewOffsetHelper.setTopAndBottomOffset(v1_1);
            this.tempTopBottomOffset = 0;
        }

        v1_1 = this.tempLeftRightOffset;
        if(v1_1 != 0) {
            this.viewOffsetHelper.setLeftAndRightOffset(v1_1);
            this.tempLeftRightOffset = 0;
        }

        return 1;
    }

    public void setHorizontalOffsetEnabled(boolean arg1) {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null) {
            v0.setHorizontalOffsetEnabled(arg1);
        }
    }

    public boolean setLeftAndRightOffset(int arg2) {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null) {
            return v0.setLeftAndRightOffset(arg2);
        }

        this.tempLeftRightOffset = arg2;
        return 0;
    }

    public boolean setTopAndBottomOffset(int arg2) {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null) {
            return v0.setTopAndBottomOffset(arg2);
        }

        this.tempTopBottomOffset = arg2;
        return 0;
    }

    public void setVerticalOffsetEnabled(boolean arg1) {
        ViewOffsetHelper v0 = this.viewOffsetHelper;
        if(v0 != null) {
            v0.setVerticalOffsetEnabled(arg1);
        }
    }
}

