package com.google.android.material.transition;

class FadeModeEvaluators {
    class com.google.android.material.transition.FadeModeEvaluators$1 implements FadeModeEvaluator {
        com.google.android.material.transition.FadeModeEvaluators$1() {
            super();
        }

        public FadeModeResult evaluate(float arg1, float arg2, float arg3, float arg4) {
            return FadeModeResult.endOnTop(0xFF, TransitionUtils.lerp(0, 0xFF, arg2, arg3, arg1));
        }
    }

    class com.google.android.material.transition.FadeModeEvaluators$2 implements FadeModeEvaluator {
        com.google.android.material.transition.FadeModeEvaluators$2() {
            super();
        }

        public FadeModeResult evaluate(float arg1, float arg2, float arg3, float arg4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(0xFF, 0, arg2, arg3, arg1), 0xFF);
        }
    }

    class com.google.android.material.transition.FadeModeEvaluators$3 implements FadeModeEvaluator {
        com.google.android.material.transition.FadeModeEvaluators$3() {
            super();
        }

        public FadeModeResult evaluate(float arg2, float arg3, float arg4, float arg5) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(0xFF, 0, arg3, arg4, arg2), TransitionUtils.lerp(0, 0xFF, arg3, arg4, arg2));
        }
    }

    class com.google.android.material.transition.FadeModeEvaluators$4 implements FadeModeEvaluator {
        com.google.android.material.transition.FadeModeEvaluators$4() {
            super();
        }

        public FadeModeResult evaluate(float arg2, float arg3, float arg4, float arg5) {
            float v1 = (arg4 - arg3) * arg5 + arg3;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(0xFF, 0, arg3, v1, arg2), TransitionUtils.lerp(0, 0xFF, v1, arg4, arg2));
        }
    }

    private static final FadeModeEvaluator CROSS;
    private static final FadeModeEvaluator IN;
    private static final FadeModeEvaluator OUT;
    private static final FadeModeEvaluator THROUGH;

    static {
        FadeModeEvaluators.IN = new com.google.android.material.transition.FadeModeEvaluators$1();
        FadeModeEvaluators.OUT = new com.google.android.material.transition.FadeModeEvaluators$2();
        FadeModeEvaluators.CROSS = new com.google.android.material.transition.FadeModeEvaluators$3();
        FadeModeEvaluators.THROUGH = new com.google.android.material.transition.FadeModeEvaluators$4();
    }

    private FadeModeEvaluators() {
        super();
    }

    static FadeModeEvaluator get(int arg2, boolean arg3) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                if(arg2 != 2) {
                    if(arg2 == 3) {
                        return FadeModeEvaluators.THROUGH;
                    }

                    throw new IllegalArgumentException("Invalid fade mode: " + arg2);
                }

                return FadeModeEvaluators.CROSS;
            }

            if(arg3) {
                return FadeModeEvaluators.OUT;
            }

            return FadeModeEvaluators.IN;
        }

        if(arg3) {
            return FadeModeEvaluators.IN;
        }

        return FadeModeEvaluators.OUT;
    }
}

