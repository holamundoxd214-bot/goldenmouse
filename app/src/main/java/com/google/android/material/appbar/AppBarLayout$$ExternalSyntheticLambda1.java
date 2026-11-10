package com.google.android.material.appbar;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import com.google.android.material.shape.MaterialShapeDrawable;

public final class AppBarLayout$$ExternalSyntheticLambda1 implements ValueAnimator$AnimatorUpdateListener {
    public AppBarLayout$$ExternalSyntheticLambda1(AppBarLayout arg1, MaterialShapeDrawable arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onAnimationUpdate(ValueAnimator arg2) {
        this.f$0.lambda$initializeLiftOnScrollWithElevation$1$com-google-android-material-appbar-AppBarLayout(this.f$1, arg2);
    }
}

