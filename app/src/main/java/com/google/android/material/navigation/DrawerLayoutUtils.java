package com.google.android.material.navigation;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;

public class DrawerLayoutUtils {
    private static final int DEFAULT_SCRIM_ALPHA = 0;
    private static final int DEFAULT_SCRIM_COLOR = 0x99000000;

    static {
        DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA = Color.alpha(0x99000000);
    }

    private DrawerLayoutUtils() {
        super();
    }

    public static Animator$AnimatorListener getScrimCloseAnimatorListener(DrawerLayout arg1, View arg2) {
        return new AnimatorListenerAdapter(arg1, arg2) {
            public void onAnimationEnd(Animator arg3) {
                this.val$drawerLayout.closeDrawer(this.val$drawerView, false);
                this.val$drawerLayout.setScrimColor(0x99000000);
            }
        };
    }

    public static ValueAnimator$AnimatorUpdateListener getScrimCloseAnimatorUpdateListener(DrawerLayout arg1) {
        return new DrawerLayoutUtils$$ExternalSyntheticLambda0(arg1);
    }

    static void lambda$getScrimCloseAnimatorUpdateListener$0(DrawerLayout arg2, ValueAnimator arg3) {
        arg2.setScrimColor(ColorUtils.setAlphaComponent(0x99000000, AnimationUtils.lerp(DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA, 0, arg3.getAnimatedFraction())));
    }
}

