package com.google.android.material.appbar;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.google.android.material.shape.MaterialShapeDrawable;

public final class AppBarLayout$$ExternalSyntheticLambda0 implements ValueAnimator$AnimatorUpdateListener {
    public AppBarLayout$$ExternalSyntheticLambda0(AppBarLayout arg1, ColorStateList arg2, ColorStateList arg3, MaterialShapeDrawable arg4, Integer arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final void onAnimationUpdate(ValueAnimator arg7) {
        this.f$0.lambda$initializeLiftOnScrollWithColor$0$com-google-android-material-appbar-AppBarLayout(this.f$1, this.f$2, this.f$3, this.f$4, arg7);
    }
}

