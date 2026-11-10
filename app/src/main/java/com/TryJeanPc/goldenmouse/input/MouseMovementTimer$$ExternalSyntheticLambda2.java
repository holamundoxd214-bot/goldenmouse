package com.TryJeanPc.goldenmouse.input;

import java.util.concurrent.ScheduledFuture;
import kotlin.jvm.functions.Function0;

public final class MouseMovementTimer$$ExternalSyntheticLambda2 implements Function0 {
    public MouseMovementTimer$$ExternalSyntheticLambda2(ScheduledFuture arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke() {
        return MouseMovementTimer.schedule$lambda$5(this.f$0);
    }
}

