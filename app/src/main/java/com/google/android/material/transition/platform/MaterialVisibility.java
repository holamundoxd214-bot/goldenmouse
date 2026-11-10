package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class MaterialVisibility extends Visibility {
    private final List additionalAnimatorProviders;
    private final VisibilityAnimatorProvider primaryAnimatorProvider;
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    protected MaterialVisibility(VisibilityAnimatorProvider arg2, VisibilityAnimatorProvider arg3) {
        super();
        this.additionalAnimatorProviders = new ArrayList();
        this.primaryAnimatorProvider = arg2;
        this.secondaryAnimatorProvider = arg3;
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider arg1) {
        this.additionalAnimatorProviders.add(arg1);
    }

    private static void addAnimatorIfNeeded(List arg0, VisibilityAnimatorProvider arg1, ViewGroup arg2, View arg3, boolean arg4) {
        if(arg1 == null) {
        }
        else {
            Animator v1 = arg4 ? arg1.createAppear(arg2, arg3) : arg1.createDisappear(arg2, arg3);
            if(v1 == null) {
                return;
            }

            arg0.add(v1);
        }
    }

    public void clearAdditionalAnimatorProvider() {
        this.additionalAnimatorProviders.clear();
    }

    private Animator createAnimator(ViewGroup arg5, View arg6, boolean arg7) {
        AnimatorSet v0 = new AnimatorSet();
        ArrayList v1 = new ArrayList();
        MaterialVisibility.addAnimatorIfNeeded(((List)v1), this.primaryAnimatorProvider, arg5, arg6, arg7);
        MaterialVisibility.addAnimatorIfNeeded(((List)v1), this.secondaryAnimatorProvider, arg5, arg6, arg7);
        Iterator v2 = this.additionalAnimatorProviders.iterator();
        while(v2.hasNext()) {
            MaterialVisibility.addAnimatorIfNeeded(((List)v1), v2.next(), arg5, arg6, arg7);
        }

        this.maybeApplyThemeValues(arg5.getContext(), arg7);
        AnimatorSetCompat.playTogether(v0, ((List)v1));
        return ((Animator)v0);
    }

    TimeInterpolator getDefaultEasingInterpolator(boolean arg1) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    int getDurationThemeAttrResId(boolean arg1) {
        return 0;
    }

    int getEasingThemeAttrResId(boolean arg1) {
        return 0;
    }

    public VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    private void maybeApplyThemeValues(Context arg2, boolean arg3) {
        TransitionUtils.maybeApplyThemeDuration(((Transition)this), arg2, this.getDurationThemeAttrResId(arg3));
        TransitionUtils.maybeApplyThemeInterpolator(((Transition)this), arg2, this.getEasingThemeAttrResId(arg3), this.getDefaultEasingInterpolator(arg3));
    }

    public Animator onAppear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return this.createAnimator(arg1, arg2, true);
    }

    public Animator onDisappear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return this.createAnimator(arg1, arg2, false);
    }

    public boolean removeAdditionalAnimatorProvider(VisibilityAnimatorProvider arg1) {
        return this.additionalAnimatorProviders.remove(arg1);
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider arg1) {
        this.secondaryAnimatorProvider = arg1;
    }
}

