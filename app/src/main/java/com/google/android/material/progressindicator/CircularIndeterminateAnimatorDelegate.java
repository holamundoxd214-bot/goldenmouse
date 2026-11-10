package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate {
    class com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$3 extends Property {
        com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$3(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(CircularIndeterminateAnimatorDelegate arg1) {
            return Float.valueOf(arg1.getAnimationFraction());
        }

        public Object get(Object arg1) {
            return this.get(((CircularIndeterminateAnimatorDelegate)arg1));
        }

        public void set(CircularIndeterminateAnimatorDelegate arg1, Float arg2) {
            arg1.setAnimationFraction(arg2.floatValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((CircularIndeterminateAnimatorDelegate)arg1), ((Float)arg2));
        }
    }

    class com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$4 extends Property {
        com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$4(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(CircularIndeterminateAnimatorDelegate arg1) {
            return Float.valueOf(arg1.getCompleteEndFraction());
        }

        public Object get(Object arg1) {
            return this.get(((CircularIndeterminateAnimatorDelegate)arg1));
        }

        public void set(CircularIndeterminateAnimatorDelegate arg1, Float arg2) {
            arg1.setCompleteEndFraction(arg2.floatValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((CircularIndeterminateAnimatorDelegate)arg1), ((Float)arg2));
        }
    }

    private static final Property ANIMATION_FRACTION = null;
    private static final Property COMPLETE_END_FRACTION = null;
    private static final int CONSTANT_ROTATION_DEGREES = 0x5F0;
    private static final int[] DELAY_TO_COLLAPSE_IN_MS = null;
    private static final int[] DELAY_TO_EXPAND_IN_MS = null;
    private static final int[] DELAY_TO_FADE_IN_MS = null;
    private static final int DURATION_TO_COLLAPSE_IN_MS = 667;
    private static final int DURATION_TO_COMPLETE_END_IN_MS = 333;
    private static final int DURATION_TO_EXPAND_IN_MS = 667;
    private static final int DURATION_TO_FADE_IN_MS = 333;
    private static final int EXTRA_DEGREES_PER_CYCLE = 0xFA;
    private static final int TAIL_DEGREES_OFFSET = -20;
    private static final int TOTAL_CYCLES = 4;
    private static final int TOTAL_DURATION_IN_MS = 5400;
    private float animationFraction;
    private ObjectAnimator animator;
    AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    private int indicatorColorIndexOffset;
    private final FastOutSlowInInterpolator interpolator;

    static {
        CircularIndeterminateAnimatorDelegate.DELAY_TO_EXPAND_IN_MS = new int[]{0, 1350, 2700, 4050};
        CircularIndeterminateAnimatorDelegate.DELAY_TO_COLLAPSE_IN_MS = new int[]{667, 2017, 0xD27, 4717};
        CircularIndeterminateAnimatorDelegate.DELAY_TO_FADE_IN_MS = new int[]{1000, 2350, 3700, 5050};
        Class v1 = Float.class;
        CircularIndeterminateAnimatorDelegate.ANIMATION_FRACTION = new com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$3(v1, "animationFraction");
        CircularIndeterminateAnimatorDelegate.COMPLETE_END_FRACTION = new com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$4(v1, "completeEndFraction");
    }

    public CircularIndeterminateAnimatorDelegate(CircularProgressIndicatorSpec arg2) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = ((BaseProgressIndicatorSpec)arg2);
        this.interpolator = new FastOutSlowInInterpolator();
    }

    static int access$000(CircularIndeterminateAnimatorDelegate arg0) {
        return arg0.indicatorColorIndexOffset;
    }

    static int access$002(CircularIndeterminateAnimatorDelegate arg0, int arg1) {
        arg0.indicatorColorIndexOffset = arg1;
        return arg1;
    }

    static BaseProgressIndicatorSpec access$100(CircularIndeterminateAnimatorDelegate arg0) {
        return arg0.baseSpec;
    }

    static float access$200(CircularIndeterminateAnimatorDelegate arg0) {
        return arg0.getAnimationFraction();
    }

    static float access$300(CircularIndeterminateAnimatorDelegate arg0) {
        return arg0.getCompleteEndFraction();
    }

    static void access$400(CircularIndeterminateAnimatorDelegate arg0, float arg1) {
        arg0.setCompleteEndFraction(arg1);
    }

    void cancelAnimatorImmediately() {
        ObjectAnimator v0 = this.animator;
        if(v0 != null) {
            v0.cancel();
        }
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    public void invalidateSpecValues() {
        this.resetPropertiesForNewStart();
    }

    private void maybeInitializeAnimators() {
        ObjectAnimator v0;
        int v1 = 2;
        if(this.animator == null) {
            v0 = ObjectAnimator.ofFloat(this, CircularIndeterminateAnimatorDelegate.ANIMATION_FRACTION, new float[]{0f, 1f});
            this.animator = v0;
            v0.setDuration(5400);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator arg2) {
                    super.onAnimationRepeat(arg2);
                    CircularIndeterminateAnimatorDelegate.this.indicatorColorIndexOffset = (CircularIndeterminateAnimatorDelegate.this.indicatorColorIndexOffset + 4) % CircularIndeterminateAnimatorDelegate.this.baseSpec.indicatorColors.length;
                }
            });
        }

        if(this.completeEndAnimator == null) {
            v0 = ObjectAnimator.ofFloat(this, CircularIndeterminateAnimatorDelegate.COMPLETE_END_FRACTION, new float[]{0f, 1f});
            this.completeEndAnimator = v0;
            v0.setDuration(333);
            this.completeEndAnimator.setInterpolator(this.interpolator);
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator arg1) {
                    super.onAnimationEnd(arg1);
                    CircularIndeterminateAnimatorDelegate.this.cancelAnimatorImmediately();
                    if(CircularIndeterminateAnimatorDelegate.this.animatorCompleteCallback != null) {
                        CircularIndeterminateAnimatorDelegate.this.animatorCompleteCallback.onAnimationEnd(CircularIndeterminateAnimatorDelegate.this.drawable);
                    }
                }
            });
        }
    }

    private void maybeUpdateSegmentColors(int arg5) {
        int v1;
        for(v1 = 0; v1 < 4; ++v1) {
            float v2 = this.getFractionInRange(arg5, CircularIndeterminateAnimatorDelegate.DELAY_TO_FADE_IN_MS[v1], 333);
            if(v2 >= 0f && v2 <= 1f) {
                v1 = (v1 + this.indicatorColorIndexOffset) % this.baseSpec.indicatorColors.length;
                this.segmentColors[0] = ArgbEvaluatorCompat.getInstance().evaluate(this.interpolator.getInterpolation(v2), Integer.valueOf(MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[v1], this.drawable.getAlpha())), Integer.valueOf(MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[(v1 + 1) % this.baseSpec.indicatorColors.length], this.drawable.getAlpha()))).intValue();
                return;
            }
        }
    }

    public void registerAnimatorsCompleteCallback(AnimationCallback arg1) {
        this.animatorCompleteCallback = arg1;
    }

    void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator v0 = this.completeEndAnimator;
        if(v0 != null) {
            if(v0.isRunning()) {
            }
            else if(this.drawable.isVisible()) {
                this.completeEndAnimator.start();
                return;
            }
            else {
                this.cancelAnimatorImmediately();
            }
        }
    }

    void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.segmentColors[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.completeEndFraction = 0f;
    }

    void setAnimationFraction(float arg2) {
        this.animationFraction = arg2;
        int v2 = ((int)(arg2 * 5400f));
        this.updateSegmentPositions(v2);
        this.maybeUpdateSegmentColors(v2);
        this.drawable.invalidateSelf();
    }

    private void setCompleteEndFraction(float arg1) {
        this.completeEndFraction = arg1;
    }

    void startAnimator() {
        this.maybeInitializeAnimators();
        this.resetPropertiesForNewStart();
        this.animator.start();
    }

    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }

    private void updateSegmentPositions(int arg9) {
        this.segmentPositions[0] = this.animationFraction * 1520f - 20f;
        this.segmentPositions[1] = this.animationFraction * 1520f;
        int v0;
        for(v0 = 0; v0 < 4; ++v0) {
            this.segmentPositions[1] += this.interpolator.getInterpolation(this.getFractionInRange(arg9, CircularIndeterminateAnimatorDelegate.DELAY_TO_EXPAND_IN_MS[v0], 667)) * 250f;
            this.segmentPositions[0] += this.interpolator.getInterpolation(this.getFractionInRange(arg9, CircularIndeterminateAnimatorDelegate.DELAY_TO_COLLAPSE_IN_MS[v0], 667)) * 250f;
        }

        this.segmentPositions[0] += (this.segmentPositions[1] - this.segmentPositions[0]) * this.completeEndFraction;
        this.segmentPositions[0] /= 360f;
        this.segmentPositions[1] /= 360f;
    }
}

