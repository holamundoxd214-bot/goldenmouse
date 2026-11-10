package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder$DeathRecipient;
import java.util.concurrent.CompletableFuture;

public final class ShizukuStretchAgentConnection$$ExternalSyntheticLambda7 implements IBinder$DeathRecipient {
    public ShizukuStretchAgentConnection$$ExternalSyntheticLambda7(CompletableFuture arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void binderDied() {
        ShizukuStretchAgentConnection.closeAndAwaitAgentDeath$lambda$25(this.f$0);
    }
}

