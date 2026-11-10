package com.TryJeanPc.goldenmouse.service;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import com.TryJeanPc.goldenmouse.CpuIndicatorView;
import com.TryJeanPc.goldenmouse.RamIndicatorView;

public final class FloatingService$$ExternalSyntheticLambda74 implements ValueAnimator$AnimatorUpdateListener {
    public FloatingService$$ExternalSyntheticLambda74(FloatingService arg1, long arg2, CpuIndicatorView arg4, float arg5, RamIndicatorView arg6, float arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg6;
        this.f$5 = arg7;
    }

    public final void onAnimationUpdate(ValueAnimator arg9) {
        FloatingService.animarMonitoreo$lambda$208$lambda$207(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg9);
    }
}

