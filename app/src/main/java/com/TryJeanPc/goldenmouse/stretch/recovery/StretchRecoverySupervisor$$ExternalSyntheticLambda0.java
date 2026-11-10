package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.jvm.functions.Function0;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda0 implements Function0 {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda0(StretchRecoverySupervisor arg1, RecoveryApplyVerification arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke() {
        return StretchRecoverySupervisor.awaitConfirmation$lambda$18(this.f$0, this.f$1);
    }
}

