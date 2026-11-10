package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold;

    public FadeProvider() {
        super();
        this.incomingEndThreshold = 1f;
    }

    public Animator createAppear(ViewGroup arg7, View arg8) {
        float v7 = arg8.getAlpha() == 0f ? 1f : arg8.getAlpha();
        return FadeProvider.createFadeAnimator(arg8, 0f, v7, 0f, this.incomingEndThreshold, v7);
    }

    public Animator createDisappear(ViewGroup arg7, View arg8) {
        float v6 = arg8.getAlpha() == 0f ? 1f : arg8.getAlpha();
        return FadeProvider.createFadeAnimator(arg8, v6, 0f, 0f, 1f, v6);
    }

    private static Animator createFadeAnimator(View arg7, float arg8, float arg9, float arg10, float arg11, float arg12) {
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

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float arg1) {
        this.incomingEndThreshold = arg1;
    }
}

