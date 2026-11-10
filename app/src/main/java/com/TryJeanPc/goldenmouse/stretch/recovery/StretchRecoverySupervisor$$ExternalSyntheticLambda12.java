package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.jvm.functions.Function2;

public final class StretchRecoverySupervisor$$ExternalSyntheticLambda12 implements Function2 {
    public StretchRecoverySupervisor$$ExternalSyntheticLambda12(StretchRecoverySupervisor arg1, StretchRestoreRequest arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2, Object arg3) {
        return StretchRecoverySupervisor.rollback$lambda$32$lambda$29(this.f$0, this.f$1, ((StretchRestoreResult)arg2), ((Throwable)arg3));
    }
}

