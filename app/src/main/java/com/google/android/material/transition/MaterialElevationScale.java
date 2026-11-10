package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;

public final class MaterialElevationScale extends MaterialVisibility {
    private static final float DEFAULT_SCALE = 0.85f;
    private final boolean growing;

    public MaterialElevationScale(boolean arg3) {
        super(MaterialElevationScale.createPrimaryAnimatorProvider(arg3), MaterialElevationScale.createSecondaryAnimatorProvider());
        this.growing = arg3;
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider arg1) {
        super.addAdditionalAnimatorProvider(arg1);
    }

    public void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    private static ScaleProvider createPrimaryAnimatorProvider(boolean arg1) {
        ScaleProvider v0 = new ScaleProvider(arg1);
        v0.setOutgoingEndScale(0.85f);
        v0.setIncomingStartScale(0.85f);
        return v0;
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeProvider();
    }

    public VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isGrowing() {
        return this.growing;
    }

    public Animator onAppear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return super.onAppear(arg1, arg2, arg3, arg4);
    }

    public Animator onDisappear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return super.onDisappear(arg1, arg2, arg3, arg4);
    }

    public boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider arg1) {
        return super.removeAdditionalAnimatorProvider(arg1);
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider arg1) {
        super.setSecondaryAnimatorProvider(arg1);
    }
}

