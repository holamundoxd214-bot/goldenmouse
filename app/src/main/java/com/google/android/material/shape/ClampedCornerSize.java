package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class ClampedCornerSize implements CornerSize {
    private final float target;

    public ClampedCornerSize(float arg1) {
        super();
        this.target = arg1;
    }

    public static ClampedCornerSize createFromCornerSize(AbsoluteCornerSize arg1) {
        return new ClampedCornerSize(arg1.getCornerSize());
    }

    public boolean equals(Object arg4) {
        if(this == (((ClampedCornerSize)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ClampedCornerSize)) {
            return 0;
        }

        if(this.target == ((ClampedCornerSize)arg4).target) {
            return 1;
        }

        return 0;
    }

    public float getCornerSize(RectF arg1) {
        return Math.min(this.target, ClampedCornerSize.getMaxCornerSize(arg1));
    }

    private static float getMaxCornerSize(RectF arg2) {
        return Math.min(arg2.width() / 2f, arg2.height() / 2f);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.target)});
    }
}

