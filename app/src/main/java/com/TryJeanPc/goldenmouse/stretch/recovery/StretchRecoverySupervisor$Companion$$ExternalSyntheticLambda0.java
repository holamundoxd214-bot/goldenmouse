package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.ThreadFactory;

public final class StretchRecoverySupervisor$Companion$$ExternalSyntheticLambda0 implements ThreadFactory {
    public StretchRecoverySupervisor$Companion$$ExternalSyntheticLambda0() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return Companion.serialWorker$lambda$1(arg1);
    }
}

