package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.concurrent.ThreadFactory;

public final class ShizukuStretchAgentConnection$$ExternalSyntheticLambda3 implements ThreadFactory {
    public ShizukuStretchAgentConnection$$ExternalSyntheticLambda3() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return ShizukuStretchAgentConnection.deadline$lambda$3(arg1);
    }
}

