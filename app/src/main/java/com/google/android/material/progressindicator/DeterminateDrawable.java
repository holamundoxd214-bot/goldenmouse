package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.dynamicanimation.animation.DynamicAnimation$OnAnimationEndListener;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.color.MaterialColors;

public final class DeterminateDrawable extends DrawableWithAnimatedVisibilityChange {
    class com.google.android.material.progressindicator.DeterminateDrawable$1 extends FloatPropertyCompat {
        com.google.android.material.progressindicator.DeterminateDrawable$1(String arg1) {
            super(arg1);
        }

        public float getValue(DeterminateDrawable arg1) {
            return arg1.getIndicatorFraction() * 10000f;
        }

        public float getValue(Object arg1) {
            return this.getValue(((DeterminateDrawable)arg1));
        }

        public void setValue(DeterminateDrawable arg1, float arg2) {
            arg1.setIndicatorFraction(arg2 / 10000f);
        }

        public void setValue(Object arg1, float arg2) {
            this.setValue(((DeterminateDrawable)arg1), arg2);
        }
    }

    private static final FloatPropertyCompat INDICATOR_LENGTH_IN_LEVEL = null;
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50f;
    private DrawingDelegate drawingDelegate;
    private float indicatorFraction;
    private boolean skipAnimationOnLevelChange;
    private final SpringAnimation springAnimation;
    private final SpringForce springForce;

    static {
        DeterminateDrawable.INDICATOR_LENGTH_IN_LEVEL = new com.google.android.material.progressindicator.DeterminateDrawable$1("indicatorLevel");
    }

    DeterminateDrawable(Context arg2, BaseProgressIndicatorSpec arg3, DrawingDelegate arg4) {
        super(arg2, arg3);
        this.skipAnimationOnLevelChange = false;
        this.setDrawingDelegate(arg4);
        SpringForce v2 = new SpringForce();
        this.springForce = v2;
        v2.setDampingRatio(1f);
        v2.setStiffness(50f);
        SpringAnimation v4 = new SpringAnimation(this, DeterminateDrawable.INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation = v4;
        v4.setSpring(v2);
        this.setGrowFraction(1f);
    }

    static float access$000(DeterminateDrawable arg0) {
        return arg0.getIndicatorFraction();
    }

    static void access$100(DeterminateDrawable arg0, float arg1) {
        arg0.setIndicatorFraction(arg1);
    }

    public void addSpringAnimationEndListener(OnAnimationEndListener arg1) {
        this.springAnimation.addEndListener(arg1);
    }

    public void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public static DeterminateDrawable createCircularDrawable(Context arg2, CircularProgressIndicatorSpec arg3) {
        return new DeterminateDrawable(arg2, ((BaseProgressIndicatorSpec)arg3), new CircularDrawingDelegate(arg3));
    }

    public static DeterminateDrawable createLinearDrawable(Context arg2, LinearProgressIndicatorSpec arg3) {
        return new DeterminateDrawable(arg2, ((BaseProgressIndicatorSpec)arg3), new LinearDrawingDelegate(arg3));
    }

    public void draw(Canvas arg9) {
        Rect v0 = new Rect();
        if(!this.getBounds().isEmpty() && (this.isVisible())) {
            if(!arg9.getClipBounds(v0)) {
            }
            else {
                arg9.save();
                this.drawingDelegate.validateSpecAndAdjustCanvas(arg9, this.getBounds(), this.getGrowFraction());
                this.drawingDelegate.fillTrack(arg9, this.paint);
                this.drawingDelegate.fillIndicator(arg9, this.paint, 0f, this.getIndicatorFraction(), MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.getAlpha()));
                arg9.restore();
            }
        }
    }

    public int getAlpha() {
        return super.getAlpha();
    }

    DrawingDelegate getDrawingDelegate() {
        return this.drawingDelegate;
    }

    private float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public int getOpacity() {
        return super.getOpacity();
    }

    public boolean hideNow() {
        return super.hideNow();
    }

    public boolean isHiding() {
        return super.isHiding();
    }

    public boolean isRunning() {
        return super.isRunning();
    }

    public boolean isShowing() {
        return super.isShowing();
    }

    public void jumpToCurrentState() {
        this.springAnimation.skipToEnd();
        this.setIndicatorFraction((((float)this.getLevel())) / 10000f);
    }

    protected boolean onLevelChange(int arg4) {
        boolean v0 = this.skipAnimationOnLevelChange;
        SpringAnimation v1 = this.springAnimation;
        float v2 = 10000f;
        if(v0) {
            v1.skipToEnd();
            this.setIndicatorFraction((((float)arg4)) / v2);
        }
        else {
            v1.setStartValue(this.getIndicatorFraction() * v2);
            this.springAnimation.animateToFinalPosition(((float)arg4));
        }

        return 1;
    }

    public void registerAnimationCallback(AnimationCallback arg1) {
        super.registerAnimationCallback(arg1);
    }

    public void removeSpringAnimationEndListener(OnAnimationEndListener arg1) {
        this.springAnimation.removeEndListener(arg1);
    }

    public void setAlpha(int arg1) {
        super.setAlpha(arg1);
    }

    public void setColorFilter(ColorFilter arg1) {
        super.setColorFilter(arg1);
    }

    void setDrawingDelegate(DrawingDelegate arg1) {
        this.drawingDelegate = arg1;
        arg1.registerDrawable(((DrawableWithAnimatedVisibilityChange)this));
    }

    private void setIndicatorFraction(float arg1) {
        this.indicatorFraction = arg1;
        this.invalidateSelf();
    }

    void setLevelByFraction(float arg2) {
        this.setLevel(((int)(arg2 * 10000f)));
    }

    public boolean setVisible(boolean arg1, boolean arg2) {
        return super.setVisible(arg1, arg2);
    }

    public boolean setVisible(boolean arg1, boolean arg2, boolean arg3) {
        return super.setVisible(arg1, arg2, arg3);
    }

    boolean setVisibleInternal(boolean arg1, boolean arg2, boolean arg3) {
        arg1 = super.setVisibleInternal(arg1, arg2, arg3);
        float v2 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if(v2 == 0f) {
            this.skipAnimationOnLevelChange = true;
            return arg1;
        }

        this.skipAnimationOnLevelChange = false;
        this.springForce.setStiffness(50f / v2);
        return arg1;
    }

    public void start() {
        super.start();
    }

    public void stop() {
        super.stop();
    }

    public boolean unregisterAnimationCallback(AnimationCallback arg1) {
        return super.unregisterAnimationCallback(arg1);
    }
}

