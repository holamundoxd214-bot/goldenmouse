package com.TryJeanPc.goldenmouse.service;

import kotlin.jvm.functions.Function0;

public final class FloatingService$$ExternalSyntheticLambda2 implements Runnable {
    public FloatingService$$ExternalSyntheticLambda2(FloatingService arg1, long arg2, Function0 arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg4;
    }

    public final void run() {
        FloatingService.postHudRingStart$lambda$198(this.f$0, this.f$1, this.f$2);
    }
}

