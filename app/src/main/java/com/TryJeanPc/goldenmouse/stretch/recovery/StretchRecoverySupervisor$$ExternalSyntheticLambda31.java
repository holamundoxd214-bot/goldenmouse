package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.jvm.functions.Function0;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda31 implements Runnable {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda31(StretchRecoverySupervisor arg1, Function0 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        StretchRecoverySupervisor.post$lambda$1(this.f$0, this.f$1);
    }
}

