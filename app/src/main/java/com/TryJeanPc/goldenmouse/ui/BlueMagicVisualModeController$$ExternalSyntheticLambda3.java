package com.TryJeanPc.goldenmouse.ui;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class BlueMagicVisualModeController$$ExternalSyntheticLambda3 implements ValueAnimator$AnimatorUpdateListener {
    public BlueMagicVisualModeController$$ExternalSyntheticLambda3(BlueMagicVisualModeController arg1, float arg2, float arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void onAnimationUpdate(ValueAnimator arg3) {
        BlueMagicVisualModeController.selectNext$lambda$10$lambda$9(this.f$0, this.f$1, this.f$2, arg3);
    }
}

