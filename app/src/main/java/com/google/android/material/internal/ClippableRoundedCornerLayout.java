package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path$Direction;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ClippableRoundedCornerLayout extends FrameLayout {
    private float cornerRadius;
    private Path path;

    public ClippableRoundedCornerLayout(Context arg1) {
        super(arg1);
    }

    public ClippableRoundedCornerLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public ClippableRoundedCornerLayout(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
    }

    protected void dispatchDraw(Canvas arg3) {
        if(this.path == null) {
            super.dispatchDraw(arg3);
            return;
        }

        int v0 = arg3.save();
        arg3.clipPath(this.path);
        super.dispatchDraw(arg3);
        arg3.restoreToCount(v0);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void resetClipBoundsAndCornerRadius() {
        this.path = null;
        this.cornerRadius = 0f;
        this.invalidate();
    }

    public void updateClipBoundsAndCornerRadius(float arg2, float arg3, float arg4, float arg5, float arg6) {
        this.updateClipBoundsAndCornerRadius(new RectF(arg2, arg3, arg4, arg5), arg6);
    }

    public void updateClipBoundsAndCornerRadius(RectF arg3, float arg4) {
        Path v0 = this.path;
        if(v0 == null) {
            v0 = new Path();
            this.path = v0;
        }

        this.cornerRadius = arg4;
        v0.reset();
        this.path.addRoundRect(arg3, arg4, arg4, Path$Direction.CW);
        this.path.close();
        this.invalidate();
    }

    public void updateClipBoundsAndCornerRadius(Rect arg8, float arg9) {
        this.updateClipBoundsAndCornerRadius(((float)arg8.left), ((float)arg8.top), ((float)arg8.right), ((float)arg8.bottom), arg9);
    }

    public void updateCornerRadius(float arg8) {
        this.updateClipBoundsAndCornerRadius(((float)this.getLeft()), ((float)this.getTop()), ((float)this.getRight()), ((float)this.getBottom()), arg8);
    }
}

