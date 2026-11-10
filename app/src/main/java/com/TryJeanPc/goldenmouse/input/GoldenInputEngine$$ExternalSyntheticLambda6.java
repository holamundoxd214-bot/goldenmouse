package com.TryJeanPc.goldenmouse.input;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class GoldenInputEngine$$ExternalSyntheticLambda6 implements Function1 {
    public GoldenInputEngine$$ExternalSyntheticLambda6(GoldenInputEngine arg1, ObjectRef arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Object invoke(Object arg2) {
        return GoldenInputEngine.createSession$lambda$41(this.f$0, this.f$1, ((InputDeviceDescriptor)arg2));
    }
}

