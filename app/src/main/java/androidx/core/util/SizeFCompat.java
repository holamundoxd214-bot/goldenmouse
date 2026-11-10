package androidx.core.util;

import android.util.SizeF;

public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    public SizeFCompat(float arg2, float arg3) {
        super();
        this.mWidth = Preconditions.checkArgumentFinite(arg2, "width");
        this.mHeight = Preconditions.checkArgumentFinite(arg3, "height");
    }

    public boolean equals(Object arg5) {
        if(this == (((SizeFCompat)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SizeFCompat)) {
            return 0;
        }

        if(((SizeFCompat)arg5).mWidth == this.mWidth && ((SizeFCompat)arg5).mHeight == this.mHeight) {
            return 1;
        }

        return 0;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.mHeight) ^ Float.floatToIntBits(this.mWidth);
    }

    public SizeF toSizeF() {
        return new SizeF(this.getWidth(), this.getHeight());
    }

    public static SizeFCompat toSizeFCompat(SizeF arg2) {
        return new SizeFCompat(arg2.getWidth(), arg2.getHeight());
    }

    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}

