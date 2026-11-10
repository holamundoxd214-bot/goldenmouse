package com.TryJeanPc.goldenmouse.engine;

import java.util.concurrent.ThreadFactory;

public final class GoldenCoreController$$ExternalSyntheticLambda15 implements ThreadFactory {
    public GoldenCoreController$$ExternalSyntheticLambda15() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return GoldenCoreController.backendMonitor$lambda$8(arg1);
    }
}

