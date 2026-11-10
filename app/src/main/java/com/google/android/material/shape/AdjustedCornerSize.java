package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class AdjustedCornerSize implements CornerSize {
    private final float adjustment;
    private final CornerSize other;

    public AdjustedCornerSize(float arg2, CornerSize arg3) {
        super();
        while((arg3 instanceof AdjustedCornerSize)) {
            arg3 = ((AdjustedCornerSize)arg3).other;
            arg2 += arg3.adjustment;
        }

        this.other = arg3;
        this.adjustment = arg2;
    }

    public boolean equals(Object arg5) {
        if(this == (((AdjustedCornerSize)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AdjustedCornerSize)) {
            return 0;
        }

        if((this.other.equals(((AdjustedCornerSize)arg5).other)) && this.adjustment == ((AdjustedCornerSize)arg5).adjustment) {
            return 1;
        }

        return 0;
    }

    public float getCornerSize(RectF arg2) {
        return Math.max(0f, this.other.getCornerSize(arg2) + this.adjustment);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.other, Float.valueOf(this.adjustment)});
    }
}

