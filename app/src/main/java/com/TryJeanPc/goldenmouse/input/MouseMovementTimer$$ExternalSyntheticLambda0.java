package com.TryJeanPc.goldenmouse.input;

import java.util.concurrent.ThreadFactory;

public final class MouseMovementTimer$$ExternalSyntheticLambda0 implements ThreadFactory {
    public MouseMovementTimer$$ExternalSyntheticLambda0() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return MouseMovementTimer.schedule$lambda$1(arg1);
    }
}

