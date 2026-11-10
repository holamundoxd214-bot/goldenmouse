package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

public final class Hold extends Visibility {
    public Hold() {
        super();
    }

    public Animator onAppear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return ValueAnimator.ofFloat(new float[]{0f});
    }

    public Animator onDisappear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return ValueAnimator.ofFloat(new float[]{0f});
    }
}

