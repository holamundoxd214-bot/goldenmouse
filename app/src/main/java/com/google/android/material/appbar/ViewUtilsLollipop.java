package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.ThemeEnforcement;

class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS;

    static {
        ViewUtilsLollipop.STATE_LIST_ANIM_ATTRS = new int[]{0x1010448};
    }

    ViewUtilsLollipop() {
        super();
    }

    static void setBoundsViewOutlineProvider(View arg1) {
        arg1.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void setDefaultAppBarLayoutStateListAnimator(View arg11, float arg12) {
        int v0 = arg11.getResources().getInteger(integer.app_bar_elevation_anim_duration);
        StateListAnimator v1 = new StateListAnimator();
        long v9 = ((long)v0);
        v1.addState(new int[]{0x101009E, attr.state_liftable, -attr.state_lifted}, ObjectAnimator.ofFloat(arg11, "elevation", new float[]{0f}).setDuration(v9));
        v1.addState(new int[]{0x101009E}, ObjectAnimator.ofFloat(arg11, "elevation", new float[]{arg12}).setDuration(v9));
        v1.addState(new int[0], ObjectAnimator.ofFloat(arg11, "elevation", new float[]{0f}).setDuration(0));
        arg11.setStateListAnimator(v1);
    }

    static void setStateListAnimatorFromAttrs(View arg7, AttributeSet arg8, int arg9, int arg10) {
        Context v0 = arg7.getContext();
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, arg8, ViewUtilsLollipop.STATE_LIST_ANIM_ATTRS, arg9, arg10, new int[0]);
        try {
            if(v8.hasValue(0)) {
                arg7.setStateListAnimator(AnimatorInflater.loadStateListAnimator(v0, v8.getResourceId(0, 0)));
            }
        }
        catch(Throwable v0_1) {
            v8.recycle();
            throw v0_1;
        }

        v8.recycle();
    }
}

