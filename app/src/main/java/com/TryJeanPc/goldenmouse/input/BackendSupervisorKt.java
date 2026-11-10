package com.TryJeanPc.goldenmouse.input;

import java.io.BufferedReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2={"closeCaptureProcess", "", "process", "Ljava/lang/Process;", "reader", "Ljava/io/BufferedReader;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class BackendSupervisorKt {
    public static final void closeCaptureProcess(Process arg1, BufferedReader arg2) {
        Intrinsics.checkNotNullParameter(arg1, "process");
        Intrinsics.checkNotNullParameter(arg2, "reader");
        try {
            arg1.destroy();
            Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v1) {
            Result.constructor-impl(ResultKt.createFailure(v1));
        }

        try {
            arg2.close();
            Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v1) {
            Result.constructor-impl(ResultKt.createFailure(v1));
        }
    }
}

