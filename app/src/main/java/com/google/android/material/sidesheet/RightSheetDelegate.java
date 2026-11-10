package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior sheetBehavior;

    RightSheetDelegate(SideSheetBehavior arg1) {
        super();
        this.sheetBehavior = arg1;
    }

    int calculateInnerMargin(ViewGroup$MarginLayoutParams arg1) {
        return arg1.rightMargin;
    }

    float calculateSlideOffset(int arg2) {
        float v0 = ((float)this.getHiddenOffset());
        return (v0 - (((float)arg2))) / (v0 - (((float)this.getExpandedOffset())));
    }

    int getCoplanarSiblingAdjacentMargin(ViewGroup$MarginLayoutParams arg1) {
        return arg1.rightMargin;
    }

    int getExpandedOffset() {
        return Math.max(0, this.getHiddenOffset() - this.sheetBehavior.getChildWidth() - this.sheetBehavior.getInnerMargin());
    }

    int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getParentWidth();
    }

    int getMinViewPositionHorizontal() {
        return this.getExpandedOffset();
    }

    int getOuterEdge(View arg1) {
        return arg1.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    public int getParentInnerEdge(CoordinatorLayout arg1) {
        return arg1.getRight();
    }

    int getSheetEdge() {
        return 0;
    }

    boolean isExpandingOutwards(float arg1) {
        if(arg1 < 0f) {
            return 1;
        }

        return 0;
    }

    boolean isReleasedCloseToInnerEdge(View arg2) {
        if(arg2.getLeft() > (this.getHiddenOffset() + this.getExpandedOffset()) / 2) {
            return 1;
        }

        return 0;
    }

    boolean isSwipeSignificant(float arg1, float arg2) {
        if((SheetUtils.isSwipeMostlyHorizontal(arg1, arg2)) && Math.abs(arg1) > (((float)this.sheetBehavior.getSignificantVelocityThreshold()))) {
            return 1;
        }

        return 0;
    }

    boolean shouldHide(View arg2, float arg3) {
        if(Math.abs((((float)arg2.getRight())) + arg3 * this.sheetBehavior.getHideFriction()) > this.sheetBehavior.getHideThreshold()) {
            return 1;
        }

        return 0;
    }

    void updateCoplanarSiblingAdjacentMargin(ViewGroup$MarginLayoutParams arg1, int arg2) {
        arg1.rightMargin = arg2;
    }

    void updateCoplanarSiblingLayoutParams(ViewGroup$MarginLayoutParams arg1, int arg2, int arg3) {
        int v0 = this.sheetBehavior.getParentWidth();
        if(arg2 <= v0) {
            arg1.rightMargin = v0 - arg2;
        }
    }
}

