package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$attr;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialSharedAxis extends MaterialVisibility {
    @Retention(value=RetentionPolicy.SOURCE) @public interface Axis {
    }

    private static final int DEFAULT_THEMED_DURATION_ATTR = 0;
    private static final int DEFAULT_THEMED_EASING_ATTR = 0;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    private final int axis;
    private final boolean forward;

    static {
        MaterialSharedAxis.DEFAULT_THEMED_DURATION_ATTR = attr.motionDurationLong1;
        MaterialSharedAxis.DEFAULT_THEMED_EASING_ATTR = attr.motionEasingEmphasizedInterpolator;
    }

    public MaterialSharedAxis(int arg3, boolean arg4) {
        super(MaterialSharedAxis.createPrimaryAnimatorProvider(arg3, arg4), MaterialSharedAxis.createSecondaryAnimatorProvider());
        this.axis = arg3;
        this.forward = arg4;
    }

    public void addAdditionalAnimatorProvider(VisibilityAnimatorProvider arg1) {
        super.addAdditionalAnimatorProvider(arg1);
    }

    public void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    private static VisibilityAnimatorProvider createPrimaryAnimatorProvider(int arg2, boolean arg3) {
        int v3;
        if(arg2 != 0) {
            if(arg2 != 1) {
                if(arg2 == 2) {
                    return new ScaleProvider(arg3);
                }

                throw new IllegalArgumentException("Invalid axis: " + arg2);
            }

            v3 = arg3 ? 80 : 0x30;
            return new SlideDistanceProvider(v3);
        }

        v3 = arg3 ? 0x800005 : 0x800003;
        return new SlideDistanceProvider(v3);
    }

    private static VisibilityAnimatorProvider createSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }

    public int getAxis() {
        return this.axis;
    }

    int getDurationThemeAttrResId(boolean arg1) {
        return MaterialSharedAxis.DEFAULT_THEMED_DURATION_ATTR;
    }

    int getEasingThemeAttrResId(boolean arg1) {
        return MaterialSharedAxis.DEFAULT_THEMED_EASING_ATTR;
    }

    public VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.forward;
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

