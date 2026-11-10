package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.CompletableFuture;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda3 implements Runnable {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda3(StretchRecoverySupervisor arg1, CompletableFuture arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        StretchRecoverySupervisor.closeAsync$lambda$40(this.f$0, this.f$1);
    }
}

