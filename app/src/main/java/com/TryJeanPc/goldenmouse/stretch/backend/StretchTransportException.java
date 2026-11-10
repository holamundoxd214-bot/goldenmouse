package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reason", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;)V", "getReason", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchTransportException extends Exception {
    public static final int $stable = 8;
    private final StretchTransportError reason;

    static {
    }

    public StretchTransportException(StretchTransportError arg2) {
        Intrinsics.checkNotNullParameter(arg2, "reason");
        super(arg2.name());
        this.reason = arg2;
    }

    public final StretchTransportError getReason() {
        return this.reason;
    }
}

