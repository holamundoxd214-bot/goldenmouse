package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

class AnimatorTracker {
    private Animator currentAnimator;

    AnimatorTracker() {
        super();
    }

    public void cancelCurrent() {
        Animator v0 = this.currentAnimator;
        if(v0 != null) {
            v0.cancel();
        }
    }

    public void clear() {
        this.currentAnimator = null;
    }

    public void onNextAnimationStart(Animator arg1) {
        this.cancelCurrent();
        this.currentAnimator = arg1;
    }
}

