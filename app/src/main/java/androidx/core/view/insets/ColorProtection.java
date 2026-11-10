package androidx.core.view.insets;

import android.graphics.drawable.ColorDrawable;

public class ColorProtection extends Protection {
    private int mColor;
    private final ColorDrawable mDrawable;
    private boolean mHasColor;

    public ColorProtection(int arg1, int arg2) {
        this(arg1);
        this.setColor(arg2);
    }

    public ColorProtection(int arg1) {
        super(arg1);
        this.mDrawable = new ColorDrawable();
        this.mColor = 0;
    }

    void dispatchColorHint(int arg2) {
        if(!this.mHasColor) {
            this.setColorInner(arg2);
        }
    }

    public int getColor() {
        return this.mColor;
    }

    boolean occupiesCorners() {
        return 1;
    }

    public void setColor(int arg2) {
        this.mHasColor = true;
        this.setColorInner(arg2);
    }

    private void setColorInner(int arg2) {
        if(this.mColor != arg2) {
            this.mColor = arg2;
            this.mDrawable.setColor(arg2);
            this.setDrawable(this.mDrawable);
        }
    }
}

