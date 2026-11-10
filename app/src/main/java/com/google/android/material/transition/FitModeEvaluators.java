package com.google.android.material.transition;

import android.graphics.RectF;

class FitModeEvaluators {
    class com.google.android.material.transition.FitModeEvaluators$1 implements FitModeEvaluator {
        com.google.android.material.transition.FitModeEvaluators$1() {
            super();
        }

        public void applyMask(RectF arg1, float arg2, FitModeResult arg3) {
            arg1.bottom -= Math.abs(arg3.currentEndHeight - arg3.currentStartHeight) * arg2;
        }

        public FitModeResult evaluate(float arg7, float arg8, float arg9, float arg10, float arg11, float arg12, float arg13) {
            arg9 = TransitionUtils.lerp(arg10, arg12, arg8, arg9, arg7, true);
            arg7 = arg9 / arg10;
            arg8 = arg9 / arg12;
            return new FitModeResult(arg7, arg8, arg9, arg11 * arg7, arg9, arg13 * arg8);
        }

        public boolean shouldMaskStartBounds(FitModeResult arg1) {
            if(arg1.currentStartHeight > arg1.currentEndHeight) {
                return 1;
            }

            return 0;
        }
    }

    class com.google.android.material.transition.FitModeEvaluators$2 implements FitModeEvaluator {
        com.google.android.material.transition.FitModeEvaluators$2() {
            super();
        }

        public void applyMask(RectF arg2, float arg3, FitModeResult arg4) {
            float v1 = Math.abs(arg4.currentEndWidth - arg4.currentStartWidth) / 2f * arg3;
            arg2.left += v1;
            arg2.right -= v1;
        }

        public FitModeResult evaluate(float arg7, float arg8, float arg9, float arg10, float arg11, float arg12, float arg13) {
            float v6 = TransitionUtils.lerp(arg11, arg13, arg8, arg9, arg7, true);
            arg7 = v6 / arg11;
            arg8 = v6 / arg13;
            return new FitModeResult(arg7, arg8, arg10 * arg7, v6, arg12 * arg8, v6);
        }

        public boolean shouldMaskStartBounds(FitModeResult arg1) {
            if(arg1.currentStartWidth > arg1.currentEndWidth) {
                return 1;
            }

            return 0;
        }
    }

    private static final FitModeEvaluator HEIGHT;
    private static final FitModeEvaluator WIDTH;

    static {
        FitModeEvaluators.WIDTH = new com.google.android.material.transition.FitModeEvaluators$1();
        FitModeEvaluators.HEIGHT = new com.google.android.material.transition.FitModeEvaluators$2();
    }

    private FitModeEvaluators() {
        super();
    }

    static FitModeEvaluator get(int arg0, boolean arg1, RectF arg2, RectF arg3) {
        if(arg0 != 0) {
            if(arg0 != 1) {
                if(arg0 == 2) {
                    return FitModeEvaluators.HEIGHT;
                }

                throw new IllegalArgumentException("Invalid fit mode: " + arg0);
            }

            return FitModeEvaluators.WIDTH;
        }

        if(FitModeEvaluators.shouldAutoFitToWidth(arg1, arg2, arg3)) {
            return FitModeEvaluators.WIDTH;
        }

        return FitModeEvaluators.HEIGHT;
    }

    private static boolean shouldAutoFitToWidth(boolean arg4, RectF arg5, RectF arg6) {
        float v0 = arg5.width();
        float v5 = arg5.height();
        float v1 = arg6.width();
        float v6 = arg6.height();
        float v2 = v6 * v0 / v1;
        v1 = v1 * v5 / v0;
        if(arg4) {
            if(v2 >= v5) {
                return 1;
            }

            return 0;
        }

        if(v1 >= v6) {
            return 1;
        }

        return 0;
    }
}

