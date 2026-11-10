package com.google.android.material.sidesheet;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;

public final class SideSheetBehavior$$ExternalSyntheticLambda2 implements ValueAnimator$AnimatorUpdateListener {
    public SideSheetBehavior$$ExternalSyntheticLambda2(SideSheetBehavior arg1, ViewGroup$MarginLayoutParams arg2, int arg3, View arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void onAnimationUpdate(ValueAnimator arg4) {
        this.f$0.lambda$getCoplanarFinishAnimatorUpdateListener$1$com-google-android-material-sidesheet-SideSheetBehavior(this.f$1, this.f$2, this.f$3, arg4);
    }
}

