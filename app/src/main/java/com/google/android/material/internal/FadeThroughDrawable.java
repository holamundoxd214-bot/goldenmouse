package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class FadeThroughDrawable extends Drawable {
    private final float[] alphas;
    private final Drawable fadeInDrawable;
    private final Drawable fadeOutDrawable;
    private float progress;

    public FadeThroughDrawable(Drawable arg1, Drawable arg2) {
        super();
        this.fadeOutDrawable = arg1.getConstantState().newDrawable().mutate();
        arg1 = arg2.getConstantState().newDrawable().mutate();
        this.fadeInDrawable = arg1;
        arg1.setAlpha(0);
        this.alphas = new float[2];
    }

    public void draw(Canvas arg2) {
        this.fadeOutDrawable.draw(arg2);
        this.fadeInDrawable.draw(arg2);
    }

    public int getIntrinsicHeight() {
        return Math.max(this.fadeOutDrawable.getIntrinsicHeight(), this.fadeInDrawable.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.fadeOutDrawable.getIntrinsicWidth(), this.fadeInDrawable.getIntrinsicWidth());
    }

    public int getMinimumHeight() {
        return Math.max(this.fadeOutDrawable.getMinimumHeight(), this.fadeInDrawable.getMinimumHeight());
    }

    public int getMinimumWidth() {
        return Math.max(this.fadeOutDrawable.getMinimumWidth(), this.fadeInDrawable.getMinimumWidth());
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        if(!this.fadeOutDrawable.isStateful()) {
            if(this.fadeInDrawable.isStateful()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void setAlpha(int arg4) {
        int v0 = Float.compare(this.progress, 0.5f);
        Drawable v1 = this.fadeOutDrawable;
        if(v0 <= 0) {
            v1.setAlpha(arg4);
            this.fadeInDrawable.setAlpha(0);
        }
        else {
            v1.setAlpha(0);
            this.fadeInDrawable.setAlpha(arg4);
        }

        this.invalidateSelf();
    }

    public void setBounds(int arg2, int arg3, int arg4, int arg5) {
        super.setBounds(arg2, arg3, arg4, arg5);
        this.fadeOutDrawable.setBounds(arg2, arg3, arg4, arg5);
        this.fadeInDrawable.setBounds(arg2, arg3, arg4, arg5);
    }

    public void setColorFilter(ColorFilter arg2) {
        this.fadeOutDrawable.setColorFilter(arg2);
        this.fadeInDrawable.setColorFilter(arg2);
        this.invalidateSelf();
    }

    public void setProgress(float arg4) {
        if(this.progress != arg4) {
            this.progress = arg4;
            FadeThroughUtils.calculateFadeOutAndInAlphas(arg4, this.alphas);
            this.fadeOutDrawable.setAlpha(((int)(this.alphas[0] * 255f)));
            this.fadeInDrawable.setAlpha(((int)(this.alphas[1] * 255f)));
            this.invalidateSelf();
        }
    }

    public boolean setState(int[] arg2) {
        boolean v0 = this.fadeOutDrawable.setState(arg2);
        boolean v1 = this.fadeInDrawable.setState(arg2);
        if(!v0) {
            if(v1) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

