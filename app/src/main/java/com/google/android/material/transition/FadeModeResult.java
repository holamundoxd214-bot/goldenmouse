package com.google.android.material.transition;

class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int arg1, int arg2, boolean arg3) {
        super();
        this.startAlpha = arg1;
        this.endAlpha = arg2;
        this.endOnTop = arg3;
    }

    static FadeModeResult endOnTop(int arg2, int arg3) {
        return new FadeModeResult(arg2, arg3, true);
    }

    static FadeModeResult startOnTop(int arg2, int arg3) {
        return new FadeModeResult(arg2, arg3, false);
    }
}

