package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.CompletableFuture;
import kotlin.jvm.functions.Function0;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda16 implements Runnable {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda16(StretchRecoverySupervisor arg1, CompletableFuture arg2, Function0 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void run() {
        StretchRecoverySupervisor.action$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}

