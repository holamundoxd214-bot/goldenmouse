package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

public final class StretchExternalRescue$$ExternalSyntheticLambda2 implements Function0 {
    public StretchExternalRescue$$ExternalSyntheticLambda2(StretchExternalRescue arg1, Function0 arg2, Function2 arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final Object invoke() {
        return Boolean.valueOf(StretchExternalRescue.checkActive$lambda$9(this.f$0, this.f$1, this.f$2));
    }
}

