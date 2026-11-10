package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

abstract class DrawingDelegate {
    protected DrawableWithAnimatedVisibilityChange drawable;
    BaseProgressIndicatorSpec spec;

    public DrawingDelegate(BaseProgressIndicatorSpec arg1) {
        super();
        this.spec = arg1;
    }

    abstract void adjustCanvas(Canvas arg1, Rect arg2, float arg3);

    abstract void fillIndicator(Canvas arg1, Paint arg2, float arg3, float arg4, int arg5);

    abstract void fillTrack(Canvas arg1, Paint arg2);

    abstract int getPreferredHeight();

    abstract int getPreferredWidth();

    protected void registerDrawable(DrawableWithAnimatedVisibilityChange arg1) {
        this.drawable = arg1;
    }

    void validateSpecAndAdjustCanvas(Canvas arg2, Rect arg3, float arg4) {
        this.spec.validateSpec();
        this.adjustCanvas(arg2, arg3, arg4);
    }
}

