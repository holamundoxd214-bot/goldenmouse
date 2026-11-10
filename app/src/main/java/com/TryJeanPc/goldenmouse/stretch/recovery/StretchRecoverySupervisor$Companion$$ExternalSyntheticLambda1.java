package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.ThreadFactory;

public final class StretchRecoverySupervisor$Companion$$ExternalSyntheticLambda1 implements ThreadFactory {
    public StretchRecoverySupervisor$Companion$$ExternalSyntheticLambda1() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return Companion.recoveryWorker$lambda$3(arg1);
    }
}

