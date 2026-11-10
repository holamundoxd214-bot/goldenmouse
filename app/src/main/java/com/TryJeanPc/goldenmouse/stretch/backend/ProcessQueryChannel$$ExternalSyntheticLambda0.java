package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.concurrent.ThreadFactory;

public final class ProcessQueryChannel$$ExternalSyntheticLambda0 implements ThreadFactory {
    public ProcessQueryChannel$$ExternalSyntheticLambda0() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return ProcessQueryChannel.drains$lambda$1(arg1);
    }
}

