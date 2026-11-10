package com.TryJeanPc.goldenmouse.macro.execution;

import java.util.concurrent.ThreadFactory;

public final class TimedMacroScheduler$$ExternalSyntheticLambda2 implements ThreadFactory {
    public TimedMacroScheduler$$ExternalSyntheticLambda2() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return TimedMacroScheduler.executor$lambda$1(arg1);
    }
}

