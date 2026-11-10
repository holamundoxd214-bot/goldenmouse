package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R$color;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.List;

class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel arg1) {
            super(arg1);
        }

        public boolean isStateful() {
            return 1;
        }
    }

    private StateListAnimator stateListAnimator;

    FloatingActionButtonImplLollipop(FloatingActionButton arg1, ShadowViewDelegate arg2) {
        super(arg1, arg2);
    }

    BorderDrawable createBorderDrawable(int arg6, ColorStateList arg7) {
        Context v0 = this.view.getContext();
        BorderDrawable v1 = new BorderDrawable(Preconditions.checkNotNull(this.shapeAppearance));
        v1.setGradientColors(ContextCompat.getColor(v0, color.design_fab_stroke_top_outer_color), ContextCompat.getColor(v0, color.design_fab_stroke_top_inner_color), ContextCompat.getColor(v0, color.design_fab_stroke_end_inner_color), ContextCompat.getColor(v0, color.design_fab_stroke_end_outer_color));
        v1.setBorderWidth(((float)arg6));
        v1.setBorderTint(arg7);
        return v1;
    }

    private StateListAnimator createDefaultStateListAnimator(float arg8, float arg9, float arg10) {
        StateListAnimator v0 = new StateListAnimator();
        v0.addState(FloatingActionButtonImplLollipop.PRESSED_ENABLED_STATE_SET, this.createElevationAnimator(arg8, arg10));
        v0.addState(FloatingActionButtonImplLollipop.HOVERED_FOCUSED_ENABLED_STATE_SET, this.createElevationAnimator(arg8, arg9));
        v0.addState(FloatingActionButtonImplLollipop.FOCUSED_ENABLED_STATE_SET, this.createElevationAnimator(arg8, arg9));
        v0.addState(FloatingActionButtonImplLollipop.HOVERED_ENABLED_STATE_SET, this.createElevationAnimator(arg8, arg9));
        AnimatorSet v9 = new AnimatorSet();
        ArrayList v10 = new ArrayList();
        ((List)v10).add(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{arg8}).setDuration(0));
        ((List)v10).add(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{0f}).setDuration(100));
        v9.playSequentially(((List)v10).toArray(new Animator[0]));
        v9.setInterpolator(FloatingActionButtonImplLollipop.ELEVATION_ANIM_INTERPOLATOR);
        v0.addState(FloatingActionButtonImplLollipop.ENABLED_STATE_SET, ((Animator)v9));
        v0.addState(FloatingActionButtonImplLollipop.EMPTY_STATE_SET, this.createElevationAnimator(0f, 0f));
        return v0;
    }

    private Animator createElevationAnimator(float arg8, float arg9) {
        AnimatorSet v0 = new AnimatorSet();
        v0.play(ObjectAnimator.ofFloat(this.view, "elevation", new float[]{arg8}).setDuration(0)).with(ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Z, new float[]{arg9}).setDuration(100));
        v0.setInterpolator(FloatingActionButtonImplLollipop.ELEVATION_ANIM_INTERPOLATOR);
        return ((Animator)v0);
    }

    MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable(Preconditions.checkNotNull(this.shapeAppearance));
    }

    public float getElevation() {
        return this.view.getElevation();
    }

    void getPadding(Rect arg2) {
        if(this.shadowViewDelegate.isCompatPaddingEnabled()) {
            super.getPadding(arg2);
            return;
        }

        if(!this.shouldExpandBoundsForA11y()) {
            int v0 = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            arg2.set(v0, v0, v0, v0);
            return;
        }

        arg2.set(0, 0, 0, 0);
    }

    void initializeBackgroundDrawable(ColorStateList arg3, PorterDuff$Mode arg4, ColorStateList arg5, int arg6) {
        MaterialShapeDrawable v3_1;
        this.shapeDrawable = this.createShapeDrawable();
        this.shapeDrawable.setTintList(arg3);
        if(arg4 != null) {
            this.shapeDrawable.setTintMode(arg4);
        }

        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        BorderDrawable v4 = null;
        if(arg6 > 0) {
            this.borderDrawable = this.createBorderDrawable(arg6, arg3);
            LayerDrawable v3 = new LayerDrawable(new Drawable[]{Preconditions.checkNotNull(this.borderDrawable), Preconditions.checkNotNull(this.shapeDrawable)});
        }
        else {
            this.borderDrawable = v4;
            v3_1 = this.shapeDrawable;
        }

        this.rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(arg5), ((Drawable)v3_1), ((Drawable)v4));
        this.contentBackground = this.rippleDrawable;
    }

    void jumpDrawableToCurrentState() {
    }

    void onCompatShadowChanged() {
        this.updatePadding();
    }

    void onDrawableStateChanged(int[] arg1) {
    }

    void onElevationsChanged(float arg3, float arg4, float arg5) {
        if(this.view.getStateListAnimator() == this.stateListAnimator) {
            this.stateListAnimator = this.createDefaultStateListAnimator(arg3, arg4, arg5);
            this.view.setStateListAnimator(this.stateListAnimator);
        }

        if(this.shouldAddPadding()) {
            this.updatePadding();
        }
    }

    boolean requirePreDrawListener() {
        return 0;
    }

    void setRippleColor(ColorStateList arg2) {
        if((this.rippleDrawable instanceof RippleDrawable)) {
            this.rippleDrawable.setColor(RippleUtils.sanitizeRippleDrawableColor(arg2));
            return;
        }

        super.setRippleColor(arg2);
    }

    boolean shouldAddPadding() {
        if(!this.shadowViewDelegate.isCompatPaddingEnabled()) {
            if(!this.shouldExpandBoundsForA11y()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    void updateFromViewRotation() {
    }
}

