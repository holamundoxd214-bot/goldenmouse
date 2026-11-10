package com.google.android.material.internal;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class StateListAnimator {
    class com.google.android.material.internal.StateListAnimator$1 extends AnimatorListenerAdapter {
        com.google.android.material.internal.StateListAnimator$1(StateListAnimator arg1) {
            StateListAnimator.this = arg1;
            super();
        }

        public void onAnimationEnd(Animator arg2) {
            if(StateListAnimator.this.runningAnimator == arg2) {
                StateListAnimator.this.runningAnimator = null;
            }
        }
    }

    class Tuple {
        final ValueAnimator animator;
        final int[] specs;

        Tuple(int[] arg1, ValueAnimator arg2) {
            super();
            this.specs = arg1;
            this.animator = arg2;
        }
    }

    private final Animator$AnimatorListener animationListener;
    private Tuple lastMatch;
    ValueAnimator runningAnimator;
    private final ArrayList tuples;

    public StateListAnimator() {
        super();
        this.tuples = new ArrayList();
        this.lastMatch = null;
        this.runningAnimator = null;
        this.animationListener = new com.google.android.material.internal.StateListAnimator$1(this);
    }

    public void addState(int[] arg2, ValueAnimator arg3) {
        Tuple v0 = new Tuple(arg2, arg3);
        arg3.addListener(this.animationListener);
        this.tuples.add(v0);
    }

    private void cancel() {
        ValueAnimator v0 = this.runningAnimator;
        if(v0 != null) {
            v0.cancel();
            this.runningAnimator = null;
        }
    }

    public void jumpToCurrentState() {
        ValueAnimator v0 = this.runningAnimator;
        if(v0 != null) {
            v0.end();
            this.runningAnimator = null;
        }
    }

    public void setState(int[] arg5) {
        Object v2;
        int v0 = this.tuples.size();
        int v1 = 0;
        while(true) {
            if(v1 < v0) {
                v2 = this.tuples.get(v1);
                if(StateSet.stateSetMatches(((Tuple)v2).specs, arg5)) {
                }
                else {
                    ++v1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_13;
        }

        v2 = null;
    label_13:
        Tuple v5 = this.lastMatch;
        if(v2 == v5) {
        }
        else {
            if(v5 != null) {
                this.cancel();
            }

            this.lastMatch = ((Tuple)v2);
            if(v2 == null) {
                return;
            }

            this.start(((Tuple)v2));
        }
    }

    private void start(Tuple arg1) {
        ValueAnimator v1 = arg1.animator;
        this.runningAnimator = v1;
        v1.start();
    }
}

