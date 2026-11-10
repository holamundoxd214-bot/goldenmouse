package com.google.android.material.circularreveal;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class CircularRevealCompat {
    private CircularRevealCompat() {
        super();
    }

    public static Animator createCircularReveal(CircularRevealWidget arg6, float arg7, float arg8, float arg9) {
        ObjectAnimator v0 = ObjectAnimator.ofObject(arg6, CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealEvaluator.CIRCULAR_REVEAL, new RevealInfo[]{new RevealInfo(arg7, arg8, arg9)});
        RevealInfo v1 = arg6.getRevealInfo();
        if(v1 != null) {
            Animator v6 = ViewAnimationUtils.createCircularReveal(((View)arg6), ((int)arg7), ((int)arg8), v1.radius, arg9);
            AnimatorSet v7 = new AnimatorSet();
            v7.playTogether(new Animator[]{v0, v6});
            return ((Animator)v7);
        }

        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Animator createCircularReveal(CircularRevealWidget arg7, float arg8, float arg9, float arg10, float arg11) {
        ObjectAnimator v0 = ObjectAnimator.ofObject(arg7, CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealEvaluator.CIRCULAR_REVEAL, new RevealInfo[]{new RevealInfo(arg8, arg9, arg10), new RevealInfo(arg8, arg9, arg11)});
        Animator v7 = ViewAnimationUtils.createCircularReveal(((View)arg7), ((int)arg8), ((int)arg9), arg10, arg11);
        AnimatorSet v8 = new AnimatorSet();
        v8.playTogether(new Animator[]{v0, v7});
        return ((Animator)v8);
    }

    public static Animator$AnimatorListener createCircularRevealListener(CircularRevealWidget arg1) {
        return new AnimatorListenerAdapter(arg1) {
            public void onAnimationEnd(Animator arg1) {
                this.val$view.destroyCircularRevealCache();
            }

            public void onAnimationStart(Animator arg1) {
                this.val$view.buildCircularRevealCache();
            }
        };
    }
}

