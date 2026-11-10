package com.TryJeanPc.goldenmouse.service;

import android.widget.TextView;
import com.TryJeanPc.goldenmouse.CpuIndicatorView;
import com.TryJeanPc.goldenmouse.RamIndicatorView;
import kotlin.jvm.functions.Function0;

public final class FloatingService$$ExternalSyntheticLambda72 implements Function0 {
    public FloatingService$$ExternalSyntheticLambda72(FloatingService arg1, long arg2, CpuIndicatorView arg4, float arg5, RamIndicatorView arg6, float arg7, TextView arg8, TextView arg9) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
        this.f$3 = arg5;
        this.f$4 = arg6;
        this.f$5 = arg7;
        this.f$6 = arg8;
        this.f$7 = arg9;
    }

    public final Object invoke() {
        return FloatingService.animarMonitoreo$lambda$204(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}

