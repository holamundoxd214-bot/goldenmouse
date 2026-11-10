package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import java.util.concurrent.CompletableFuture;

public final class ShizukuStretchAgentConnection$$ExternalSyntheticLambda0 implements Runnable {
    public ShizukuStretchAgentConnection$$ExternalSyntheticLambda0(ShizukuStretchAgentConnection arg1, StretchAgentRequest arg2, StretchExperimentOperation arg3, StretchOriginalEvidence arg4, IBinder arg5, boolean arg6, CompletableFuture arg7) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
        this.f$6 = arg7;
    }

    public final void run() {
        ShizukuStretchAgentConnection.experimentCall$lambda$24(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}

