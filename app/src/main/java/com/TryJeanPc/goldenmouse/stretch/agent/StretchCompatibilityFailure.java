package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001B\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompatibilityFailure;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "code", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()Ljava/lang/String;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCompatibilityFailure extends IllegalStateException {
    public static final int $stable = 8;
    private final String code;

    static {
    }

    public StretchCompatibilityFailure(String arg1, Throwable arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public StretchCompatibilityFailure(String arg2, Throwable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "code");
        super(arg2, arg3);
        this.code = arg2;
    }

    public final String getCode() {
        return this.code;
    }
}

