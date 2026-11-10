package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver$OnScrollChangedListener;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

public class InterpolateOnScrollPositionChangeHelper {
    class com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper$1 implements ViewTreeObserver$OnScrollChangedListener {
        com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper$1(InterpolateOnScrollPositionChangeHelper arg1) {
            InterpolateOnScrollPositionChangeHelper.this = arg1;
            super();
        }

        public void onScrollChanged() {
            InterpolateOnScrollPositionChangeHelper.this.updateInterpolationForScreenPosition();
        }
    }

    private final int[] containerLocation;
    private ScrollView containingScrollView;
    private MaterialShapeDrawable materialShapeDrawable;
    private final ViewTreeObserver$OnScrollChangedListener scrollChangedListener;
    private final int[] scrollLocation;
    private View shapedView;

    public InterpolateOnScrollPositionChangeHelper(View arg3, MaterialShapeDrawable arg4, ScrollView arg5) {
        super();
        this.scrollLocation = new int[2];
        this.containerLocation = new int[2];
        this.scrollChangedListener = new com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper$1(this);
        this.shapedView = arg3;
        this.materialShapeDrawable = arg4;
        this.containingScrollView = arg5;
    }

    public void setContainingScrollView(ScrollView arg1) {
        this.containingScrollView = arg1;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable arg1) {
        this.materialShapeDrawable = arg1;
    }

    public void startListeningForScrollChanges(ViewTreeObserver arg1) {
        arg1.addOnScrollChangedListener(this.scrollChangedListener);
    }

    public void stopListeningForScrollChanges(ViewTreeObserver arg1) {
        arg1.removeOnScrollChangedListener(this.scrollChangedListener);
    }

    public void updateInterpolationForScreenPosition() {
        ScrollView v0 = this.containingScrollView;
        if(v0 == null) {
        }
        else if(v0.getChildCount() != 0) {
            this.containingScrollView.getLocationInWindow(this.scrollLocation);
            this.containingScrollView.getChildAt(0).getLocationInWindow(this.containerLocation);
            int v0_1 = this.shapedView.getTop() - this.scrollLocation[1] + this.containerLocation[1];
            int v1 = this.shapedView.getHeight();
            int v2 = this.containingScrollView.getHeight();
            float v4 = 1f;
            if(v0_1 < 0) {
                this.materialShapeDrawable.setInterpolation(Math.max(0f, Math.min(v4, (((float)v0_1)) / (((float)v1)) + v4)));
                this.shapedView.invalidate();
                return;
            }
            else {
                v0_1 += v1;
                MaterialShapeDrawable v5 = this.materialShapeDrawable;
                if(v0_1 > v2) {
                    v5.setInterpolation(Math.max(0f, Math.min(v4, v4 - (((float)(v0_1 - v2))) / (((float)v1)))));
                    this.shapedView.invalidate();
                    return;
                }
                else if(v5.getInterpolation() != v4) {
                    this.materialShapeDrawable.setInterpolation(v4);
                    this.shapedView.invalidate();
                }
            }
        }
        else {
            goto label_61;
        }

        return;
    label_61:
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }
}

