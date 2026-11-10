package com.TryJeanPc.goldenmouse.stretch.physical;

import java.util.concurrent.ThreadFactory;

public final class GoldenStretchPhysicalController$$ExternalSyntheticLambda3 implements ThreadFactory {
    public GoldenStretchPhysicalController$$ExternalSyntheticLambda3() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return GoldenStretchPhysicalController.worker$lambda$4(arg1);
    }
}

