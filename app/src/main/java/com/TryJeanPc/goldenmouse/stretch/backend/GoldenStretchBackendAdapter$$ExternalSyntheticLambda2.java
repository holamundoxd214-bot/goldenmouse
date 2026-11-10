package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.concurrent.ThreadFactory;

public final class GoldenStretchBackendAdapter$$ExternalSyntheticLambda2 implements ThreadFactory {
    public GoldenStretchBackendAdapter$$ExternalSyntheticLambda2() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return GoldenStretchBackendAdapter.cleanup$lambda$6(arg1);
    }
}

