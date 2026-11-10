package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class LeftSheetDelegate extends SheetDelegate {
    final SideSheetBehavior sheetBehavior;

    LeftSheetDelegate(SideSheetBehavior arg1) {
        super();
        this.sheetBehavior = arg1;
    }

    int calculateInnerMargin(ViewGroup$MarginLayoutParams arg1) {
        return arg1.leftMargin;
    }

    float calculateSlideOffset(int arg2) {
        float v0 = ((float)this.getHiddenOffset());
        return ((((float)arg2)) - v0) / ((((float)this.getExpandedOffset())) - v0);
    }

    int getCoplanarSiblingAdjacentMargin(ViewGroup$MarginLayoutParams arg1) {
        return arg1.leftMargin;
    }

    int getExpandedOffset() {
        return Math.max(0, this.sheetBehavior.getParentInnerEdge() + this.sheetBehavior.getInnerMargin());
    }

    int getHiddenOffset() {
        return -this.sheetBehavior.getChildWidth() - this.sheetBehavior.getInnerMargin();
    }

    int getMaxViewPositionHorizontal() {
        return this.sheetBehavior.getInnerMargin();
    }

    int getMinViewPositionHorizontal() {
        return -this.sheetBehavior.getChildWidth();
    }

    int getOuterEdge(View arg1) {
        return arg1.getRight() + this.sheetBehavior.getInnerMargin();
    }

    public int getParentInnerEdge(CoordinatorLayout arg1) {
        return arg1.getLeft();
    }

    int getSheetEdge() {
        return 1;
    }

    boolean isExpandingOutwards(float arg1) {
        if(arg1 > 0f) {
            return 1;
        }

        return 0;
    }

    boolean isReleasedCloseToInnerEdge(View arg2) {
        if(arg2.getRight() < (this.getExpandedOffset() - this.getHiddenOffset()) / 2) {
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
        if(Math.abs((((float)arg2.getLeft())) + arg3 * this.sheetBehavior.getHideFriction()) > this.sheetBehavior.getHideThreshold()) {
            return 1;
        }

        return 0;
    }

    void updateCoplanarSiblingAdjacentMargin(ViewGroup$MarginLayoutParams arg1, int arg2) {
        arg1.leftMargin = arg2;
    }

    void updateCoplanarSiblingLayoutParams(ViewGroup$MarginLayoutParams arg1, int arg2, int arg3) {
        if(arg2 <= this.sheetBehavior.getParentWidth()) {
            arg1.leftMargin = arg3;
        }
    }
}

