package com.google.android.material.carousel;

import android.view.View;

public abstract class CarouselStrategy {
    public CarouselStrategy() {
        super();
    }

    static int[] doubleCounts(int[] arg4) {
        int v0 = arg4.length;
        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = arg4[v2] * 2;
        }

        return v1;
    }

    static float getChildMaskPercentage(float arg0, float arg1, float arg2) {
        return 1f - (arg0 - arg2) / (arg1 - arg2);
    }

    boolean isContained() {
        return 1;
    }

    abstract KeylineState onFirstChildMeasuredWithMargins(Carousel arg1, View arg2);

    boolean shouldRefreshKeylineState(Carousel arg1, int arg2) {
        return 0;
    }
}

