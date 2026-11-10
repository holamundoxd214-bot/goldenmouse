package com.google.android.material.motion;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

public final class MaterialMainContainerBackHelper$$ExternalSyntheticLambda0 implements ValueAnimator$AnimatorUpdateListener {
    public MaterialMainContainerBackHelper$$ExternalSyntheticLambda0(ClippableRoundedCornerLayout arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onAnimationUpdate(ValueAnimator arg1) {
        MaterialMainContainerBackHelper.lambda$createCornerAnimator$0(this.f$0, arg1);
    }
}

