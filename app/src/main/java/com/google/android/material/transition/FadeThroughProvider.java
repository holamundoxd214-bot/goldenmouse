package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    static final float FADE_THROUGH_THRESHOLD = 0.35f;
    private float progressThreshold;

    public FadeThroughProvider() {
        super();
        this.progressThreshold = 0.35f;
    }

    public Animator createAppear(ViewGroup arg7, View arg8) {
        float v7 = arg8.getAlpha() == 0f ? 1f : arg8.getAlpha();
        return FadeThroughProvider.createFadeThroughAnimator(arg8, 0f, v7, this.progressThreshold, 1f, v7);
    }

    public Animator createDisappear(ViewGroup arg7, View arg8) {
        float v7 = arg8.getAlpha() == 0f ? 1f : arg8.getAlpha();
        return FadeThroughProvider.createFadeThroughAnimator(arg8, v7, 0f, 0f, this.progressThreshold, v7);
    }

    private static Animator createFadeThroughAnimator(View arg7, float arg8, float arg9, float arg10, float arg11, float arg12) {
        ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v0.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(arg7, arg8, arg9, arg10, arg11) {
            public void onAnimationUpdate(ValueAnimator arg5) {
                this.val$view.setAlpha(TransitionUtils.lerp(this.val$startValue, this.val$endValue, this.val$startFraction, this.val$endFraction, arg5.getAnimatedValue().floatValue()));
            }
        });
        v0.addListener(new AnimatorListenerAdapter(arg7, arg12) {
            public void onAnimationEnd(Animator arg1) {
                this.val$view.setAlpha(this.val$originalAlpha);
            }
        });
        return ((Animator)v0);
    }

    public float getProgressThreshold() {
        return this.progressThreshold;
    }

    public void setProgressThreshold(float arg1) {
        this.progressThreshold = arg1;
    }
}

