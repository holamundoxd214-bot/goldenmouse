package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;

public final class ShizukuStretchAgentConnection$$ExternalSyntheticLambda6 implements Runnable {
    public ShizukuStretchAgentConnection$$ExternalSyntheticLambda6(ShizukuStretchAgentConnection arg1, StretchAgentRequest arg2, StretchPhysicalOperation arg3, boolean arg4, ScheduledFuture arg5, CompletableFuture arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final void run() {
        ShizukuStretchAgentConnection.physicalCall$lambda$19(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}

