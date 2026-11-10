package com.google.android.material.transition;

import androidx.transition.Transition$TransitionListener;
import androidx.transition.Transition;

abstract class TransitionListenerAdapter implements TransitionListener {
    TransitionListenerAdapter() {
        super();
    }

    public void onTransitionCancel(Transition arg1) {
    }

    public void onTransitionEnd(Transition arg1) {
    }

    public void onTransitionPause(Transition arg1) {
    }

    public void onTransitionResume(Transition arg1) {
    }

    public void onTransitionStart(Transition arg1) {
    }
}

