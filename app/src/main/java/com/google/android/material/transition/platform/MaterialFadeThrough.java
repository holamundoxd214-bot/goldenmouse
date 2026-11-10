package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$attr;

public final class MaterialFadeThrough extends MaterialVisibility {
    private static final float DEFAULT_START_SCALE = 0.92f;
    private static final int DEFAULT_THEMED_DURATION_ATTR;
    private static final int DEFAULT_THEMED_EASING_ATTR;

    static {
        MaterialFadeThrough.DEFAULT_THEMED_DURATION_ATTR = attr.motionDurationLong1;
        MaterialFadeThrough.DEFAULT_THEMED_EASING_ATTR = attr.motionEasingEmphasizedInterpolator;
    }

    public MaterialFadeThrough() {
        super(MaterialFadeThrough.createPrimaryAnimatorProvider(), MaterialFadeThrough.createSecondaryAnimatorProvider());
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider arg1) {
        super.addAdditionalAnimatorProvider(arg1);
    }

    public void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    private static FadeThroughProvider createPrimaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        ScaleProvider v0 = new ScaleProvider();
        v0.setScaleOnDisappear(false);
        v0.setIncomingStartScale(0.92f);
        return ((VisibilityAnimatorProvider)v0);
    }

    int getDurationThemeAttrResId(boolean arg1) {
        return MaterialFadeThrough.DEFAULT_THEMED_DURATION_ATTR;
    }

    int getEasingThemeAttrResId(boolean arg1) {
        return MaterialFadeThrough.DEFAULT_THEMED_EASING_ATTR;
    }

    public VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
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

