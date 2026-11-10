package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R$anim;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate {
    class com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$3 extends Property {
        com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$3(Class arg1, String arg2) {
            super(arg1, arg2);
        }

        public Float get(LinearIndeterminateDisjointAnimatorDelegate arg1) {
            return Float.valueOf(arg1.getAnimationFraction());
        }

        public Object get(Object arg1) {
            return this.get(((LinearIndeterminateDisjointAnimatorDelegate)arg1));
        }

        public void set(LinearIndeterminateDisjointAnimatorDelegate arg1, Float arg2) {
            arg1.setAnimationFraction(arg2.floatValue());
        }

        public void set(Object arg1, Object arg2) {
            this.set(((LinearIndeterminateDisjointAnimatorDelegate)arg1), ((Float)arg2));
        }
    }

    private static final Property ANIMATION_FRACTION = null;
    private static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = null;
    private static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = null;
    private static final int TOTAL_DURATION_IN_MS = 1800;
    private float animationFraction;
    private ObjectAnimator animator;
    AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private boolean dirtyColors;
    private int indicatorColorIndex;
    private final Interpolator[] interpolatorArray;

    static {
        LinearIndeterminateDisjointAnimatorDelegate.DURATION_TO_MOVE_SEGMENT_ENDS = new int[]{533, 567, 850, 750};
        LinearIndeterminateDisjointAnimatorDelegate.DELAY_TO_MOVE_SEGMENT_ENDS = new int[]{0x4F3, 1000, 333, 0};
        LinearIndeterminateDisjointAnimatorDelegate.ANIMATION_FRACTION = new com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$3(Float.class, "animationFraction");
    }

    public LinearIndeterminateDisjointAnimatorDelegate(Context arg4, LinearProgressIndicatorSpec arg5) {
        super(2);
        this.indicatorColorIndex = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = ((BaseProgressIndicatorSpec)arg5);
        this.interpolatorArray = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(arg4, anim.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(arg4, anim.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(arg4, anim.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(arg4, anim.linear_indeterminate_line2_tail_interpolator)};
    }

    static int access$000(LinearIndeterminateDisjointAnimatorDelegate arg0) {
        return arg0.indicatorColorIndex;
    }

    static int access$002(LinearIndeterminateDisjointAnimatorDelegate arg0, int arg1) {
        arg0.indicatorColorIndex = arg1;
        return arg1;
    }

    static BaseProgressIndicatorSpec access$100(LinearIndeterminateDisjointAnimatorDelegate arg0) {
        return arg0.baseSpec;
    }

    static boolean access$202(LinearIndeterminateDisjointAnimatorDelegate arg0, boolean arg1) {
        arg0.dirtyColors = arg1;
        return arg1;
    }

    static float access$300(LinearIndeterminateDisjointAnimatorDelegate arg0) {
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
        ObjectAnimator v0;
        TimeInterpolator v1 = null;
        long v2 = 1800;
        if(this.animator == null) {
            v0 = ObjectAnimator.ofFloat(this, LinearIndeterminateDisjointAnimatorDelegate.ANIMATION_FRACTION, new float[]{0f, 1f});
            this.animator = v0;
            v0.setDuration(v2);
            this.animator.setInterpolator(v1);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator arg4) {
                    super.onAnimationRepeat(arg4);
                    LinearIndeterminateDisjointAnimatorDelegate.this.indicatorColorIndex = (LinearIndeterminateDisjointAnimatorDelegate.this.indicatorColorIndex + 1) % LinearIndeterminateDisjointAnimatorDelegate.this.baseSpec.indicatorColors.length;
                    LinearIndeterminateDisjointAnimatorDelegate.this.dirtyColors = true;
                }
            });
        }

        if(this.completeEndAnimator == null) {
            v0 = ObjectAnimator.ofFloat(this, LinearIndeterminateDisjointAnimatorDelegate.ANIMATION_FRACTION, new float[]{1f});
            this.completeEndAnimator = v0;
            v0.setDuration(v2);
            this.completeEndAnimator.setInterpolator(v1);
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator arg1) {
                    super.onAnimationEnd(arg1);
                    LinearIndeterminateDisjointAnimatorDelegate.this.cancelAnimatorImmediately();
                    if(LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteCallback != null) {
                        LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteCallback.onAnimationEnd(LinearIndeterminateDisjointAnimatorDelegate.this.drawable);
                    }
                }
            });
        }
    }

    private void maybeUpdateSegmentColors() {
        if(this.dirtyColors) {
            Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.indicatorColorIndex], this.drawable.getAlpha()));
            this.dirtyColors = false;
        }
    }

    public void registerAnimatorsCompleteCallback(AnimationCallback arg1) {
        this.animatorCompleteCallback = arg1;
    }

    public void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator v0 = this.completeEndAnimator;
        if(v0 != null) {
            if(v0.isRunning()) {
            }
            else {
                this.cancelAnimatorImmediately();
                if(this.drawable.isVisible()) {
                    this.completeEndAnimator.setFloatValues(new float[]{this.animationFraction, 1f});
                    this.completeEndAnimator.setDuration(((long)((1f - this.animationFraction) * 1800f)));
                    this.completeEndAnimator.start();
                }
            }
        }
    }

    void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        int v1 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.segmentColors[0] = v1;
        this.segmentColors[1] = v1;
    }

    void setAnimationFraction(float arg2) {
        this.animationFraction = arg2;
        this.updateSegmentPositions(((int)(arg2 * 1800f)));
        this.maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }

    public void startAnimator() {
        this.maybeInitializeAnimators();
        this.resetPropertiesForNewStart();
        this.animator.start();
    }

    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }

    private void updateSegmentPositions(int arg5) {
        int v0;
        for(v0 = 0; v0 < 4; ++v0) {
            this.segmentPositions[v0] = Math.max(0f, Math.min(1f, this.interpolatorArray[v0].getInterpolation(this.getFractionInRange(arg5, LinearIndeterminateDisjointAnimatorDelegate.DELAY_TO_MOVE_SEGMENT_ENDS[v0], LinearIndeterminateDisjointAnimatorDelegate.DURATION_TO_MOVE_SEGMENT_ENDS[v0]))));
        }
    }
}

