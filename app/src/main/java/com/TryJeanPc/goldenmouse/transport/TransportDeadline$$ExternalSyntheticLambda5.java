package com.TryJeanPc.goldenmouse.transport;

import kotlin.jvm.functions.Function0;

public final class TransportDeadline$$ExternalSyntheticLambda5 implements Runnable {
    public TransportDeadline$$ExternalSyntheticLambda5(Function0 arg1, TransportDeadline arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        TransportDeadline.closeAsync$lambda$8(this.f$0, this.f$1);
    }
}

