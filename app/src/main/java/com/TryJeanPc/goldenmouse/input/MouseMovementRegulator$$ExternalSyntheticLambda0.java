package com.TryJeanPc.goldenmouse.input;

import kotlin.jvm.functions.Function0;

public final class MouseMovementRegulator$$ExternalSyntheticLambda0 implements Function0 {
    public MouseMovementRegulator$$ExternalSyntheticLambda0(MouseMovementRegulator arg1, long arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return MouseMovementRegulator.schedulePending$lambda$11(this.f$0, this.f$1);
    }
}

