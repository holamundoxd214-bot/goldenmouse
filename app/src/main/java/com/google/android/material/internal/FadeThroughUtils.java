package com.google.android.material.internal;

final class FadeThroughUtils {
    static final float THRESHOLD_ALPHA = 0.5f;

    private FadeThroughUtils() {
        super();
    }

    static void calculateFadeOutAndInAlphas(float arg6, float[] arg7) {
        float v1 = 1f;
        float v2 = 2f;
        if(Float.compare(arg6, 0.5f) <= 0) {
            arg7[0] = v1 - arg6 * v2;
            arg7[1] = 0f;
            return;
        }

        arg7[0] = 0f;
        arg7[1] = arg6 * v2 - v1;
    }
}

