package com.TryJeanPc.goldenmouse.engine;

import java.util.concurrent.ThreadFactory;

public final class TimedActionScheduler$$ExternalSyntheticLambda0 implements ThreadFactory {
    public TimedActionScheduler$$ExternalSyntheticLambda0() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return TimedActionScheduler.executor$lambda$1(arg1);
    }
}

