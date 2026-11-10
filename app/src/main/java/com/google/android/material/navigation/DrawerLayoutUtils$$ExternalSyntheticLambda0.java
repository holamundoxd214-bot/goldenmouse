package com.google.android.material.navigation;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import androidx.drawerlayout.widget.DrawerLayout;

public final class DrawerLayoutUtils$$ExternalSyntheticLambda0 implements ValueAnimator$AnimatorUpdateListener {
    public DrawerLayoutUtils$$ExternalSyntheticLambda0(DrawerLayout arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationUpdate(ValueAnimator arg1) {
        DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0(this.f$0, arg1);
    }
}

