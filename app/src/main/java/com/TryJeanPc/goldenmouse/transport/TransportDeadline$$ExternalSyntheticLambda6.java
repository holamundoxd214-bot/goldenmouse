package com.TryJeanPc.goldenmouse.transport;

import java.util.concurrent.ThreadFactory;

public final class TransportDeadline$$ExternalSyntheticLambda6 implements ThreadFactory {
    public TransportDeadline$$ExternalSyntheticLambda6(TransportDeadline arg1, String arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final Thread newThread(Runnable arg2) {
        return TransportDeadline.lane$lambda$1(this.f$0, this.f$1, arg2);
    }
}

