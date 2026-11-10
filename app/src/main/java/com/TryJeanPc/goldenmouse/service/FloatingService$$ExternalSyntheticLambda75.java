package com.TryJeanPc.goldenmouse.service;

import android.view.View;
import kotlin.jvm.functions.Function0;

public final class FloatingService$$ExternalSyntheticLambda75 implements Runnable {
    public FloatingService$$ExternalSyntheticLambda75(FloatingService arg1, View arg2, Function0 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        FloatingService.cerrarPanelFpsConAnimacion$lambda$109(this.f$0, this.f$1, this.f$2);
    }
}

