package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsUncertain;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "message", "", "<init>", "(Ljava/lang/String;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsUncertain extends IllegalStateException {
    public static final int $stable = 8;

    static {
    }

    public GraphicsUncertain(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "message");
        super(arg2);
    }
}

