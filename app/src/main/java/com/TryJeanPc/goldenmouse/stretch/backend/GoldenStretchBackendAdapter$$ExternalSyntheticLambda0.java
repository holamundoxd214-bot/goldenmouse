package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.concurrent.ThreadFactory;

public final class GoldenStretchBackendAdapter$$ExternalSyntheticLambda0 implements ThreadFactory {
    public GoldenStretchBackendAdapter$$ExternalSyntheticLambda0() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return GoldenStretchBackendAdapter.worker$lambda$1(arg1);
    }
}

