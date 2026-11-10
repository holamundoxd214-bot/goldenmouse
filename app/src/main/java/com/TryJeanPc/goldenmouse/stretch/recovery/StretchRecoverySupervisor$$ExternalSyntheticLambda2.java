package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.jvm.functions.Function0;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda2 implements Function0 {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda2(StretchRecoverySupervisor arg1, StretchRecoveryRecord arg2, RecoveryConfirmation arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke() {
        return StretchRecoverySupervisor.awaitConfirmation$lambda$18$lambda$17$lambda$16(this.f$0, this.f$1, this.f$2);
    }
}

