package com.TryJeanPc.goldenmouse.stretch.physical;

import java.util.concurrent.ThreadFactory;

public final class GoldenStretchPhysicalController$$ExternalSyntheticLambda4 implements ThreadFactory {
    public GoldenStretchPhysicalController$$ExternalSyntheticLambda4() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return GoldenStretchPhysicalController.restoreWorker$lambda$6(arg1);
    }
}

