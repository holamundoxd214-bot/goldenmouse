package com.google.android.material.internal;

import android.animation.TimeInterpolator;

public class ReversableAnimatedValueInterpolator implements TimeInterpolator {
    private final TimeInterpolator sourceInterpolator;

    public ReversableAnimatedValueInterpolator(TimeInterpolator arg1) {
        super();
        this.sourceInterpolator = arg1;
    }

    public float getInterpolation(float arg1) {
        return 1f - this.sourceInterpolator.getInterpolation(arg1);
    }

    public static TimeInterpolator of(boolean arg0, TimeInterpolator arg1) {
        if(arg0) {
            return arg1;
        }

        return new ReversableAnimatedValueInterpolator(arg1);
    }
}

