package com.google.android.material.progressindicator;

import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;

abstract class IndeterminateAnimatorDelegate {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    protected IndeterminateAnimatorDelegate(int arg2) {
        super();
        this.segmentPositions = new float[arg2 * 2];
        this.segmentColors = new int[arg2];
    }

    abstract void cancelAnimatorImmediately();

    protected float getFractionInRange(int arg1, int arg2, int arg3) {
        return (((float)(arg1 - arg2))) / (((float)arg3));
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(AnimationCallback arg1);

    protected void registerDrawable(IndeterminateDrawable arg1) {
        this.drawable = arg1;
    }

    abstract void requestCancelAnimatorAfterCurrentCycle();

    abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}

