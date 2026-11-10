package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.jvm.functions.Function0;

public final class LocalRecoveryScheduler$$ExternalSyntheticLambda0 implements Runnable {
    public LocalRecoveryScheduler$$ExternalSyntheticLambda0(Function0 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void run() {
        LocalRecoveryScheduler.schedule$lambda$3(this.f$0);
    }
}

