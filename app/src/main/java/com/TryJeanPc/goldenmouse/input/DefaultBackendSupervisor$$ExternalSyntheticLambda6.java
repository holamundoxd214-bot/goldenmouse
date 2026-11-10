package com.TryJeanPc.goldenmouse.input;

import kotlin.jvm.functions.Function1;

public final class DefaultBackendSupervisor$$ExternalSyntheticLambda6 implements Function1 {
    public DefaultBackendSupervisor$$ExternalSyntheticLambda6(int arg1, String arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return DefaultBackendSupervisor.releaseExclusiveHelper$lambda$16(this.f$0, this.f$1, ((CaptureStream)arg2));
    }
}

