package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.concurrent.CompletableFuture;
import kotlin.jvm.functions.Function0;

public final class StretchAgentBindingCleanupKt$$ExternalSyntheticLambda0 implements Runnable {
    public StretchAgentBindingCleanupKt$$ExternalSyntheticLambda0(Function0 arg1, CompletableFuture arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        StretchAgentBindingCleanupKt.closeStretchAgentBinding$lambda$0(this.f$0, this.f$1);
    }
}

