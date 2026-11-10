package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.concurrent.ThreadFactory;

public final class GoldenStretchBackendAdapter$$ExternalSyntheticLambda1 implements ThreadFactory {
    public GoldenStretchBackendAdapter$$ExternalSyntheticLambda1() {
        super();
    }

    public final Thread newThread(Runnable arg1) {
        return GoldenStretchBackendAdapter.timer$lambda$3(arg1);
    }
}

