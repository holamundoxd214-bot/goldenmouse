package com.TryJeanPc.goldenmouse.transport;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public final class TransportDeadline$$ExternalSyntheticLambda3 implements Function0 {
    public TransportDeadline$$ExternalSyntheticLambda3(Function0 arg1, AtomicReference arg2, AtomicBoolean arg3, Function1 arg4, TransportDeadline arg5) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
    }

    public final Object invoke() {
        return TransportDeadline.open$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

