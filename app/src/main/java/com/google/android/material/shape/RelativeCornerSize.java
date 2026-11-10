package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class RelativeCornerSize implements CornerSize {
    private final float percent;

    public RelativeCornerSize(float arg1) {
        super();
        this.percent = arg1;
    }

    public static RelativeCornerSize createFromCornerSize(RectF arg1, CornerSize arg2) {
        if((arg2 instanceof RelativeCornerSize)) {
            return arg2;
        }

        return new RelativeCornerSize(arg2.getCornerSize(arg1) / RelativeCornerSize.getMaxCornerSize(arg1));
    }

    public boolean equals(Object arg4) {
        if(this == (((RelativeCornerSize)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof RelativeCornerSize)) {
            return 0;
        }

        if(this.percent == ((RelativeCornerSize)arg4).percent) {
            return 1;
        }

        return 0;
    }

    public float getCornerSize(RectF arg1) {
        return this.percent * RelativeCornerSize.getMaxCornerSize(arg1);
    }

    private static float getMaxCornerSize(RectF arg1) {
        return Math.min(arg1.width(), arg1.height());
    }

    public float getRelativePercent() {
        return this.percent;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.percent)});
    }
}

