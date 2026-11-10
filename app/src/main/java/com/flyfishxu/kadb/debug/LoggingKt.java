package com.flyfishxu.kadb.debug;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\u001A\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"ENABLED", "", "log", "", "block", "Lkotlin/Function0;", "", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class LoggingKt {
    private static final boolean ENABLED;

    static {
        LoggingKt.ENABLED = Intrinsics.areEqual("true", System.getenv("KADB_LOGGING"));
    }

    public static final void log(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "block");
        if(LoggingKt.ENABLED) {
            System.out.println(arg1.invoke());
        }
    }
}

