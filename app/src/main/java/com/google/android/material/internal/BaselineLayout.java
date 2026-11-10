package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
    private int baseline;

    public BaselineLayout(Context arg3) {
        super(arg3, null, 0);
        this.baseline = -1;
    }

    public BaselineLayout(Context arg2, AttributeSet arg3) {
        super(arg2, arg3, 0);
        this.baseline = -1;
    }

    public BaselineLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.baseline = -1;
    }

    public int getBaseline() {
        return this.baseline;
    }

    protected void onLayout(boolean arg7, int arg8, int arg9, int arg10, int arg11) {
        int v7 = this.getChildCount();
        arg9 = this.getPaddingLeft();
        arg10 = arg10 - arg8 - this.getPaddingRight() - arg9;
        arg8 = this.getPaddingTop();
        for(arg11 = 0; arg11 < v7; ++arg11) {
            View v0 = this.getChildAt(arg11);
            if(v0.getVisibility() == 8) {
            }
            else {
                int v1 = v0.getMeasuredWidth();
                int v2 = v0.getMeasuredHeight();
                int v3 = (arg10 - v1) / 2 + arg9;
                int v5 = -1;
                int v4 = this.baseline == v5 || v0.getBaseline() == v5 ? arg8 : this.baseline + arg8 - v0.getBaseline();
                v0.layout(v3, v4, v1 + v3, v2 + v4);
            }
        }
    }

    protected void onMeasure(int arg12, int arg13) {
        int v0 = this.getChildCount();
        int v1 = 0;
        int v2 = -1;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = v2;
        int v7 = v6;
        while(v1 < v0) {
            View v8 = this.getChildAt(v1);
            if(v8.getVisibility() == 8) {
            }
            else {
                this.measureChild(v8, arg12, arg13);
                int v9 = v8.getBaseline();
                if(v9 != v2) {
                    v6 = Math.max(v6, v9);
                    v7 = Math.max(v7, v8.getMeasuredHeight() - v9);
                }

                v4 = Math.max(v4, v8.getMeasuredWidth());
                v3 = Math.max(v3, v8.getMeasuredHeight());
                v5 = View.combineMeasuredStates(v5, v8.getMeasuredState());
            }

            ++v1;
        }

        if(v6 != v2) {
            v3 = Math.max(v3, Math.max(v7, this.getPaddingBottom()) + v6);
            this.baseline = v6;
        }

        this.setMeasuredDimension(View.resolveSizeAndState(Math.max(v4, this.getSuggestedMinimumWidth()), arg12, v5), View.resolveSizeAndState(Math.max(v3, this.getSuggestedMinimumHeight()), arg13, v5 << 16));
    }
}

