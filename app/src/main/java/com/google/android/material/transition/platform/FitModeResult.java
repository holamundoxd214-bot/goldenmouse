package com.google.android.material.transition.platform;

class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    FitModeResult(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
        super();
        this.startScale = arg1;
        this.endScale = arg2;
        this.currentStartWidth = arg3;
        this.currentStartHeight = arg4;
        this.currentEndWidth = arg5;
        this.currentEndHeight = arg6;
    }
}

