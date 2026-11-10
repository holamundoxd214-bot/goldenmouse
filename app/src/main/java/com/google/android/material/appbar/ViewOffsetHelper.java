package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper {
    private boolean horizontalOffsetEnabled;
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private boolean verticalOffsetEnabled;
    private final View view;

    public ViewOffsetHelper(View arg2) {
        super();
        this.verticalOffsetEnabled = true;
        this.horizontalOffsetEnabled = true;
        this.view = arg2;
    }

    void applyOffsets() {
        ViewCompat.offsetTopAndBottom(this.view, this.offsetTop - (this.view.getTop() - this.layoutTop));
        ViewCompat.offsetLeftAndRight(this.view, this.offsetLeft - (this.view.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    public void setHorizontalOffsetEnabled(boolean arg1) {
        this.horizontalOffsetEnabled = arg1;
    }

    public boolean setLeftAndRightOffset(int arg2) {
        if((this.horizontalOffsetEnabled) && this.offsetLeft != arg2) {
            this.offsetLeft = arg2;
            this.applyOffsets();
            return 1;
        }

        return 0;
    }

    public boolean setTopAndBottomOffset(int arg2) {
        if((this.verticalOffsetEnabled) && this.offsetTop != arg2) {
            this.offsetTop = arg2;
            this.applyOffsets();
            return 1;
        }

        return 0;
    }

    public void setVerticalOffsetEnabled(boolean arg1) {
        this.verticalOffsetEnabled = arg1;
    }
}

