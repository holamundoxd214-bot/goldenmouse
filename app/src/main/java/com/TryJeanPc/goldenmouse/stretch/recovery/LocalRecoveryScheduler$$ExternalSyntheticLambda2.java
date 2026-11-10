package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.ThreadFactory;

public final class LocalRecoveryScheduler$$ExternalSyntheticLambda2 implements ThreadFactory {
    public LocalRecoveryScheduler$$ExternalSyntheticLambda2() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return LocalRecoveryScheduler.executor$lambda$1(arg1);
    }
}

