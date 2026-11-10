package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;

public class CanvasCompat {
    public interface CanvasOperation {
        void run(Canvas arg1);
    }

    private CanvasCompat() {
        super();
    }

    public static int saveLayerAlpha(Canvas arg0, float arg1, float arg2, float arg3, float arg4, int arg5) {
        return arg0.saveLayerAlpha(arg1, arg2, arg3, arg4, arg5);
    }

    public static int saveLayerAlpha(Canvas arg0, RectF arg1, int arg2) {
        return arg0.saveLayerAlpha(arg1, arg2);
    }
}

