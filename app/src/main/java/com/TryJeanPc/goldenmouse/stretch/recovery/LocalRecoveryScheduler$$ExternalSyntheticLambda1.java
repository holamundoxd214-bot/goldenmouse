package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.concurrent.ScheduledFuture;

public final class LocalRecoveryScheduler$$ExternalSyntheticLambda1 implements RecoveryCancellation {
    public LocalRecoveryScheduler$$ExternalSyntheticLambda1(ScheduledFuture arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void cancel() {
        LocalRecoveryScheduler.schedule$lambda$4(this.f$0);
    }
}

