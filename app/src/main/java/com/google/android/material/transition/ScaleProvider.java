package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;

public final class ScaleProvider implements VisibilityAnimatorProvider {
    private boolean growing;
    private float incomingEndScale;
    private float incomingStartScale;
    private float outgoingEndScale;
    private float outgoingStartScale;
    private boolean scaleOnDisappear;

    public ScaleProvider(boolean arg3) {
        super();
        this.outgoingStartScale = 1f;
        this.outgoingEndScale = 1.1f;
        this.incomingStartScale = 0.8f;
        this.incomingEndScale = 1f;
        this.scaleOnDisappear = true;
        this.growing = arg3;
    }

    public ScaleProvider() {
        this(true);
    }

    public Animator createAppear(ViewGroup arg1, View arg2) {
        if(this.growing) {
            return ScaleProvider.createScaleAnimator(arg2, this.incomingStartScale, this.incomingEndScale);
        }

        return ScaleProvider.createScaleAnimator(arg2, this.outgoingEndScale, this.outgoingStartScale);
    }

    public Animator createDisappear(ViewGroup arg1, View arg2) {
        if(!this.scaleOnDisappear) {
            return null;
        }

        if(this.growing) {
            return ScaleProvider.createScaleAnimator(arg2, this.outgoingStartScale, this.outgoingEndScale);
        }

        return ScaleProvider.createScaleAnimator(arg2, this.incomingEndScale, this.incomingStartScale);
    }

    private static Animator createScaleAnimator(View arg9, float arg10, float arg11) {
        float v0 = arg9.getScaleX();
        float v1 = arg9.getScaleY();
        ObjectAnimator v10 = ObjectAnimator.ofPropertyValuesHolder(arg9, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{v0 * arg10, v0 * arg11}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{arg10 * v1, arg11 * v1})});
        v10.addListener(new AnimatorListenerAdapter(arg9, v0, v1) {
            public void onAnimationEnd(Animator arg2) {
                this.val$view.setScaleX(this.val$originalScaleX);
                this.val$view.setScaleY(this.val$originalScaleY);
            }
        });
        return ((Animator)v10);
    }

    public float getIncomingEndScale() {
        return this.incomingEndScale;
    }

    public float getIncomingStartScale() {
        return this.incomingStartScale;
    }

    public float getOutgoingEndScale() {
        return this.outgoingEndScale;
    }

    public float getOutgoingStartScale() {
        return this.outgoingStartScale;
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public boolean isScaleOnDisappear() {
        return this.scaleOnDisappear;
    }

    public void setGrowing(boolean arg1) {
        this.growing = arg1;
    }

    public void setIncomingEndScale(float arg1) {
        this.incomingEndScale = arg1;
    }

    public void setIncomingStartScale(float arg1) {
        this.incomingStartScale = arg1;
    }

    public void setOutgoingEndScale(float arg1) {
        this.outgoingEndScale = arg1;
    }

    public void setOutgoingStartScale(float arg1) {
        this.outgoingStartScale = arg1;
    }

    public void setScaleOnDisappear(boolean arg1) {
        this.scaleOnDisappear = arg1;
    }
}

