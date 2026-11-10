package com.TryJeanPc.goldenmouse.service;

import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import com.TryJeanPc.goldenmouse.CpuIndicatorView;
import com.TryJeanPc.goldenmouse.RamIndicatorView;

public final class FloatingService$$ExternalSyntheticLambda73 implements ValueAnimator$AnimatorUpdateListener {
    public FloatingService$$ExternalSyntheticLambda73(FloatingService arg1, long arg2, CpuIndicatorView arg4, RamIndicatorView arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
    }

    public final void onAnimationUpdate(ValueAnimator arg7) {
        FloatingService.animarMonitoreo$lambda$206$lambda$205(this.f$0, this.f$1, this.f$2, this.f$3, arg7);
    }
}

