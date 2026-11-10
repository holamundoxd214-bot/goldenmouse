package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;

public class CircularRevealGridLayout extends GridLayout implements CircularRevealWidget {
    private final CircularRevealHelper helper;

    public CircularRevealGridLayout(Context arg2) {
        this(arg2, null);
    }

    public CircularRevealGridLayout(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
        this.helper = new CircularRevealHelper(((Delegate)this));
    }

    public void actualDraw(Canvas arg1) {
        super.draw(arg1);
    }

    public boolean actualIsOpaque() {
        return super.isOpaque();
    }

    public void buildCircularRevealCache() {
        this.helper.buildCircularRevealCache();
    }

    public void destroyCircularRevealCache() {
        this.helper.destroyCircularRevealCache();
    }

    public void draw(Canvas arg2) {
        CircularRevealHelper v0 = this.helper;
        if(v0 != null) {
            v0.draw(arg2);
            return;
        }

        super.draw(arg2);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.helper.getCircularRevealOverlayDrawable();
    }

    public int getCircularRevealScrimColor() {
        return this.helper.getCircularRevealScrimColor();
    }

    public RevealInfo getRevealInfo() {
        return this.helper.getRevealInfo();
    }

    public boolean isOpaque() {
        CircularRevealHelper v0 = this.helper;
        if(v0 != null) {
            return v0.isOpaque();
        }

        return super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(Drawable arg1) {
        this.helper.setCircularRevealOverlayDrawable(arg1);
    }

    public void setCircularRevealScrimColor(int arg1) {
        this.helper.setCircularRevealScrimColor(arg1);
    }

    public void setRevealInfo(RevealInfo arg1) {
        this.helper.setRevealInfo(arg1);
    }
}

