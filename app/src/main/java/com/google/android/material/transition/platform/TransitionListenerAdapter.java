package com.google.android.material.transition.platform;

import android.transition.Transition$TransitionListener;
import android.transition.Transition;

abstract class TransitionListenerAdapter implements Transition$TransitionListener {
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

