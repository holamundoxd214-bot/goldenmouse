package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate {
    class com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$2 extends Property {
        com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$2(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(LinearIndeterminateContiguousAnimatorDelegate arg1) {
            return Float.valueOf(arg1.getAnimationFraction());
        }

        public Object get(Object arg1) {
            return this.get(((LinearIndeterminateContiguousAnimatorDelegate)arg1));
        }

        public void set(LinearIndeterminateContiguousAnimatorDelegate arg1, Float arg2) {
            arg1.setAnimationFraction(arg2.floatValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((LinearIndeterminateContiguousAnimatorDelegate)arg1), ((Float)arg2));
        }
    }

    private static final Property ANIMATION_FRACTION = null;
    private static final int DURATION_PER_CYCLE_IN_MS = 333;
    private static final int TOTAL_DURATION_IN_MS = 667;
    private float animationFraction;
    private ObjectAnimator animator;
    private final BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private FastOutSlowInInterpolator interpolator;
    private int newIndicatorColorIndex;

    static {
        LinearIndeterminateContiguousAnimatorDelegate.ANIMATION_FRACTION = new com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$2(Float.class, "animationFraction");
    }

    public LinearIndeterminateContiguousAnimatorDelegate(LinearProgressIndicatorSpec arg2) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = ((BaseProgressIndicatorSpec)arg2);
        this.interpolator = new FastOutSlowInInterpolator();
    }

    static int access$000(LinearIndeterminateContiguousAnimatorDelegate arg0) {
        return arg0.newIndicatorColorIndex;
    }

    static int access$002(LinearIndeterminateContiguousAnimatorDelegate arg0, int arg1) {
        arg0.newIndicatorColorIndex = arg1;
        return arg1;
    }

    static BaseProgressIndicatorSpec access$100(LinearIndeterminateContiguousAnimatorDelegate arg0) {
        return arg0.baseSpec;
    }

    static boolean access$202(LinearIndeterminateContiguousAnimatorDelegate arg0, boolean arg1) {
        arg0.dirtyColors = arg1;
        return arg1;
    }

    static float access$300(LinearIndeterminateContiguousAnimatorDelegate arg0) {
        return arg0.getAnimationFraction();
    }

    public void cancelAnimatorImmediately() {
        ObjectAnimator v0 = this.animator;
        if(v0 != null) {
            v0.cancel();
        }
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    public void invalidateSpecValues() {
        this.resetPropertiesForNewStart();
    }

    private void maybeInitializeAnimators() {
        if(this.animator == null) {
            ObjectAnimator v0 = ObjectAnimator.ofFloat(this, LinearIndeterminateContiguousAnimatorDelegate.ANIMATION_FRACTION, new float[]{0f, 1f});
            this.animator = v0;
            v0.setDuration(333);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator arg4) {
                    super.onAnimationRepeat(arg4);
                    LinearIndeterminateContiguousAnimatorDelegate.this.newIndicatorColorIndex = (LinearIndeterminateContiguousAnimatorDelegate.this.newIndicatorColorIndex + 1) % LinearIndeterminateContiguousAnimatorDelegate.this.baseSpec.indicatorColors.length;
                    LinearIndeterminateContiguousAnimatorDelegate.this.dirtyColors = true;
                }
            });
        }
    }

    private void maybeUpdateSegmentColors() {
        if((this.dirtyColors) && this.segmentPositions[3] < 1f) {
            this.segmentColors[2] = this.segmentColors[1];
            this.segmentColors[1] = this.segmentColors[0];
            this.segmentColors[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.newIndicatorColorIndex], this.drawable.getAlpha());
            this.dirtyColors = false;
        }
    }

    public void registerAnimatorsCompleteCallback(AnimationCallback arg1) {
    }

    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha()));
    }

    void setAnimationFraction(float arg2) {
        this.animationFraction = arg2;
        this.updateSegmentPositions(((int)(arg2 * 333f)));
        this.maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }

    public void startAnimator() {
        this.maybeInitializeAnimators();
        this.resetPropertiesForNewStart();
        this.animator.start();
    }

    public void unregisterAnimatorsCompleteCallback() {
    }

    private void updateSegmentPositions(int arg5) {
        this.segmentPositions[0] = 0f;
        float v5 = this.getFractionInRange(arg5, 0, 667);
        float[] v0 = this.segmentPositions;
        float[] v1 = this.segmentPositions;
        float v2 = this.interpolator.getInterpolation(v5);
        v1[2] = v2;
        v0[1] = v2;
        v0 = this.segmentPositions;
        v1 = this.segmentPositions;
        v5 = this.interpolator.getInterpolation(v5 + 0.49925f);
        v1[4] = v5;
        v0[3] = v5;
        this.segmentPositions[5] = 1f;
    }
}

