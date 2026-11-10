package com.TryJeanPc.goldenmouse.engine;

import java.util.concurrent.ThreadFactory;

public final class GoldenCoreController$$ExternalSyntheticLambda4 implements ThreadFactory {
    public GoldenCoreController$$ExternalSyntheticLambda4() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return GoldenCoreController.sessionExecutor$lambda$34(arg1);
    }
}

