package com.TryJeanPc.goldenmouse.input;

import kotlin.jvm.functions.Function0;

public final class MouseMovementTimer$$ExternalSyntheticLambda1 implements Runnable {
    public MouseMovementTimer$$ExternalSyntheticLambda1(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        MouseMovementTimer.schedule$lambda$4(this.f$0);
    }
}

