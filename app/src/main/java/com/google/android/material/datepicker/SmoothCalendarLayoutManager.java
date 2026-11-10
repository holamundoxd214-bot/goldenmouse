package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView;

class SmoothCalendarLayoutManager extends LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100f;

    SmoothCalendarLayoutManager(Context arg1, int arg2, boolean arg3) {
        super(arg1, arg2, arg3);
    }

    public void smoothScrollToPosition(RecyclerView arg1, State arg2, int arg3) {
        com.google.android.material.datepicker.SmoothCalendarLayoutManager$1 v2 = new LinearSmoothScroller(arg1.getContext()) {
            protected float calculateSpeedPerPixel(DisplayMetrics arg1) {
                return 100f / (((float)arg1.densityDpi));
            }
        };
        ((LinearSmoothScroller)v2).setTargetPosition(arg3);
        this.startSmoothScroll(((SmoothScroller)v2));
    }
}

