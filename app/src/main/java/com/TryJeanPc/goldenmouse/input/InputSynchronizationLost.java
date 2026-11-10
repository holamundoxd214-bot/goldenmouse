package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputSynchronizationLost;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "path", "", "<init>", "(Ljava/lang/String;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InputSynchronizationLost extends IllegalStateException {
    public static final int $stable = 8;

    static {
    }

    public InputSynchronizationLost(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "path");
        super("SYN_DROPPED en " + arg3 + ": captura invalidada; el backend no ofrece consulta fiable del estado físico. Suelta los controles antes de recuperarlos.");
    }
}

