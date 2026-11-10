package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$attr;
import com.google.android.material.animation.AnimationUtils;

public final class MaterialFade extends MaterialVisibility {
    private static final float DEFAULT_FADE_END_THRESHOLD_ENTER = 0.3f;
    private static final float DEFAULT_START_SCALE = 0.8f;
    private static final int DEFAULT_THEMED_INCOMING_DURATION_ATTR;
    private static final int DEFAULT_THEMED_INCOMING_EASING_ATTR;
    private static final int DEFAULT_THEMED_OUTGOING_DURATION_ATTR;
    private static final int DEFAULT_THEMED_OUTGOING_EASING_ATTR;

    static {
        MaterialFade.DEFAULT_THEMED_INCOMING_DURATION_ATTR = attr.motionDurationMedium4;
        MaterialFade.DEFAULT_THEMED_OUTGOING_DURATION_ATTR = attr.motionDurationShort3;
        MaterialFade.DEFAULT_THEMED_INCOMING_EASING_ATTR = attr.motionEasingEmphasizedDecelerateInterpolator;
        MaterialFade.DEFAULT_THEMED_OUTGOING_EASING_ATTR = attr.motionEasingEmphasizedAccelerateInterpolator;
    }

    public MaterialFade() {
        super(MaterialFade.createPrimaryAnimatorProvider(), MaterialFade.createSecondaryAnimatorProvider());
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider arg1) {
        super.addAdditionalAnimatorProvider(arg1);
    }

    public void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    private static FadeProvider createPrimaryAnimatorProvider() {
        FadeProvider v0 = new FadeProvider();
        v0.setIncomingEndThreshold(0.3f);
        return v0;
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        ScaleProvider v0 = new ScaleProvider();
        v0.setScaleOnDisappear(false);
        v0.setIncomingStartScale(0.8f);
        return ((VisibilityAnimatorProvider)v0);
    }

    TimeInterpolator getDefaultEasingInterpolator(boolean arg1) {
        return AnimationUtils.LINEAR_INTERPOLATOR;
    }

    int getDurationThemeAttrResId(boolean arg1) {
        if(arg1) {
            return MaterialFade.DEFAULT_THEMED_INCOMING_DURATION_ATTR;
        }

        return MaterialFade.DEFAULT_THEMED_OUTGOING_DURATION_ATTR;
    }

    int getEasingThemeAttrResId(boolean arg1) {
        if(arg1) {
            return MaterialFade.DEFAULT_THEMED_INCOMING_EASING_ATTR;
        }

        return MaterialFade.DEFAULT_THEMED_OUTGOING_EASING_ATTR;
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

