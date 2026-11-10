package com.TryJeanPc.goldenmouse.ui;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class BlueMagicVisualModeController$$ExternalSyntheticLambda2 implements ValueAnimator$AnimatorUpdateListener {
    public BlueMagicVisualModeController$$ExternalSyntheticLambda2(int[] arg1, BlueMagicVisualMode arg2, BlueMagicVisualModeController arg3, int[] arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void onAnimationUpdate(ValueAnimator arg4) {
        BlueMagicVisualModeController.selectNext$lambda$8$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, arg4);
    }
}

