package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public class RectEvaluator implements TypeEvaluator {
    private final Rect rect;

    public RectEvaluator(Rect arg1) {
        super();
        this.rect = arg1;
    }

    public Rect evaluate(float arg6, Rect arg7, Rect arg8) {
        this.rect.set(arg7.left + (((int)((((float)(arg8.left - arg7.left))) * arg6))), arg7.top + (((int)((((float)(arg8.top - arg7.top))) * arg6))), arg7.right + (((int)((((float)(arg8.right - arg7.right))) * arg6))), arg7.bottom + (((int)((((float)(arg8.bottom - arg7.bottom))) * arg6))));
        return this.rect;
    }

    public Object evaluate(float arg1, Object arg2, Object arg3) {
        return this.evaluate(arg1, ((Rect)arg2), ((Rect)arg3));
    }
}

