package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

public class RippleDrawableCompat extends Drawable implements TintAwareDrawable, Shapeable {
    class com.google.android.material.ripple.RippleDrawableCompat$1 {
    }

    final class RippleDrawableCompatState extends Drawable$ConstantState {
        MaterialShapeDrawable delegate;
        boolean shouldDrawDelegate;

        public RippleDrawableCompatState(MaterialShapeDrawable arg1) {
            super();
            this.delegate = arg1;
            this.shouldDrawDelegate = false;
        }

        public RippleDrawableCompatState(RippleDrawableCompatState arg2) {
            super();
            this.delegate = arg2.delegate.getConstantState().newDrawable();
            this.shouldDrawDelegate = arg2.shouldDrawDelegate;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return this.newDrawable();
        }

        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this), null);
        }
    }

    private RippleDrawableCompatState drawableState;

    public RippleDrawableCompat(ShapeAppearanceModel arg3) {
        this(new RippleDrawableCompatState(new MaterialShapeDrawable(arg3)));
    }

    private RippleDrawableCompat(RippleDrawableCompatState arg1) {
        super();
        this.drawableState = arg1;
    }

    RippleDrawableCompat(RippleDrawableCompatState arg1, com.google.android.material.ripple.RippleDrawableCompat$1 arg2) {
        this(arg1);
    }

    public void draw(Canvas arg2) {
        if(this.drawableState.shouldDrawDelegate) {
            this.drawableState.delegate.draw(arg2);
        }
    }

    public Drawable$ConstantState getConstantState() {
        return this.drawableState;
    }

    public int getOpacity() {
        return this.drawableState.delegate.getOpacity();
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.delegate.getShapeAppearanceModel();
    }

    public boolean isStateful() {
        return 1;
    }

    public Drawable mutate() {
        return this.mutate();
    }

    public RippleDrawableCompat mutate() {
        this.drawableState = new RippleDrawableCompatState(this.drawableState);
        return this;
    }

    protected void onBoundsChange(Rect arg1) {
        super.onBoundsChange(arg1);
        this.drawableState.delegate.setBounds(arg1);
    }

    protected boolean onStateChange(int[] arg4) {
        boolean v0 = super.onStateChange(arg4);
        if(this.drawableState.delegate.setState(arg4)) {
            v0 = true;
        }

        boolean v4 = RippleUtils.shouldDrawRippleCompat(arg4);
        if(this.drawableState.shouldDrawDelegate != v4) {
            this.drawableState.shouldDrawDelegate = v4;
            return 1;
        }

        return v0;
    }

    public void setAlpha(int arg1) {
        this.drawableState.delegate.setAlpha(arg1);
    }

    public void setColorFilter(ColorFilter arg1) {
        this.drawableState.delegate.setColorFilter(arg1);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg1) {
        this.drawableState.delegate.setShapeAppearanceModel(arg1);
    }

    public void setTint(int arg1) {
        this.drawableState.delegate.setTint(arg1);
    }

    public void setTintList(ColorStateList arg1) {
        this.drawableState.delegate.setTintList(arg1);
    }

    public void setTintMode(PorterDuff$Mode arg1) {
        this.drawableState.delegate.setTintMode(arg1);
    }
}

