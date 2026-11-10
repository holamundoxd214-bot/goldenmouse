package com.TryJeanPc.goldenmouse.engine;

import java.util.concurrent.CompletableFuture;

public final class InputSessionManager$$ExternalSyntheticLambda0 implements Runnable {
    public InputSessionManager$$ExternalSyntheticLambda0(CompletableFuture arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        InputSessionManager.awaitIdle$lambda$38$lambda$37$lambda$36(this.f$0);
    }
}

