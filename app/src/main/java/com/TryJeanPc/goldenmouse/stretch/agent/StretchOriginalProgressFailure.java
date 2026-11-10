package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001A\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalProgressFailure;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalProgressFailure extends IllegalStateException {
    public static final int $stable = 8;

    static {
    }

    public StretchOriginalProgressFailure(Exception arg2) {
        Intrinsics.checkNotNullParameter(arg2, "cause");
        super("Original progress callback unavailable", ((Throwable)arg2));
    }
}

