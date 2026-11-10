package com.google.android.material.animation;

import android.animation.TypeEvaluator;

public class ArgbEvaluatorCompat implements TypeEvaluator {
    private static final ArgbEvaluatorCompat instance;

    static {
        ArgbEvaluatorCompat.instance = new ArgbEvaluatorCompat();
    }

    public ArgbEvaluatorCompat() {
        super();
    }

    public Integer evaluate(float arg11, Integer arg12, Integer arg13) {
        int v10 = arg12.intValue();
        float v12 = (((float)(v10 >> 24 & 0xFF))) / 255f;
        int v13 = arg13.intValue();
        float v1 = ((float)Math.pow(((double)((((float)(v10 >> 16 & 0xFF))) / 255f)), 2.2));
        float v2 = ((float)Math.pow(((double)((((float)(v10 >> 8 & 0xFF))) / 255f)), 2.2));
        float v10_1 = ((float)Math.pow(((double)((((float)(v10 & 0xFF))) / 255f)), 2.2));
        return Integer.valueOf(Math.round((((float)Math.pow(((double)(v10_1 + arg11 * ((((float)Math.pow(((double)((((float)(v13 & 0xFF))) / 255f)), 2.2))) - v10_1))), 0.454545))) * 255f) | (Math.round((((float)Math.pow(((double)(v1 + ((((float)Math.pow(((double)((((float)(v13 >> 16 & 0xFF))) / 255f)), 2.2))) - v1) * arg11)), 0.454545))) * 255f) << 16 | Math.round((v12 + ((((float)(v13 >> 24 & 0xFF))) / 255f - v12) * arg11) * 255f) << 24 | Math.round((((float)Math.pow(((double)(v2 + ((((float)Math.pow(((double)((((float)(v13 >> 8 & 0xFF))) / 255f)), 2.2))) - v2) * arg11)), 0.454545))) * 255f) << 8));
    }

    public Object evaluate(float arg1, Object arg2, Object arg3) {
        return this.evaluate(arg1, ((Integer)arg2), ((Integer)arg3));
    }

    public static ArgbEvaluatorCompat getInstance() {
        return ArgbEvaluatorCompat.instance;
    }
}

