package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class AbsoluteCornerSize implements CornerSize {
    private final float size;

    public AbsoluteCornerSize(float arg1) {
        super();
        this.size = arg1;
    }

    public boolean equals(Object arg4) {
        if(this == (((AbsoluteCornerSize)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof AbsoluteCornerSize)) {
            return 0;
        }

        if(this.size == ((AbsoluteCornerSize)arg4).size) {
            return 1;
        }

        return 0;
    }

    public float getCornerSize() {
        return this.size;
    }

    public float getCornerSize(RectF arg1) {
        return this.size;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.size)});
    }
}

