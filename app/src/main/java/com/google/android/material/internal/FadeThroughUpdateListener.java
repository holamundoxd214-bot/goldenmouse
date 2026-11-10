package com.google.android.material.internal;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;

public class FadeThroughUpdateListener implements ValueAnimator$AnimatorUpdateListener {
    private final float[] alphas;
    private final View fadeInView;
    private final View fadeOutView;

    public FadeThroughUpdateListener(View arg1, View arg2) {
        super();
        this.fadeOutView = arg1;
        this.fadeInView = arg2;
        this.alphas = new float[2];
    }

    public void onAnimationUpdate(ValueAnimator arg3) {
        FadeThroughUtils.calculateFadeOutAndInAlphas(arg3.getAnimatedValue().floatValue(), this.alphas);
        View v3 = this.fadeOutView;
        if(v3 != null) {
            v3.setAlpha(this.alphas[0]);
        }

        v3 = this.fadeInView;
        if(v3 != null) {
            v3.setAlpha(this.alphas[1]);
        }
    }
}

