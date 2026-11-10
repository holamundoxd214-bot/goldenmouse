package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.concurrent.ThreadFactory;

public final class ShizukuStretchAgentConnection$$ExternalSyntheticLambda2 implements ThreadFactory {
    public ShizukuStretchAgentConnection$$ExternalSyntheticLambda2() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return ShizukuStretchAgentConnection.worker$lambda$1(arg1);
    }
}

