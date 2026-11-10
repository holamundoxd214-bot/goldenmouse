package com.TryJeanPc.goldenmouse.stretch.physical;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\u001A.\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001A\u00020\tH\u0000¨\u0006\n"}, d2={"stretchPreparationDeadline", "Ljava/util/concurrent/CompletableFuture;", "", "timer", "Ljava/util/concurrent/ScheduledExecutorService;", "step", "Lkotlin/Function0;", "", "timeoutMillis", "", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchPreparationDeadlineKt {
    public static final CompletableFuture stretchPreparationDeadline(ScheduledExecutorService arg2, Function0 arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "timer");
        Intrinsics.checkNotNullParameter(arg3, "step");
        CompletableFuture v0 = new CompletableFuture();
        v0.whenComplete(new StretchPreparationDeadlineKt$$ExternalSyntheticLambda2(new StretchPreparationDeadlineKt$$ExternalSyntheticLambda1(arg2.schedule(new StretchPreparationDeadlineKt$$ExternalSyntheticLambda0(v0, arg3), arg4, TimeUnit.MILLISECONDS))));
        return v0;
    }

    public static CompletableFuture stretchPreparationDeadline$default(ScheduledExecutorService arg0, Function0 arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg2 = 45000;
        }

        return StretchPreparationDeadlineKt.stretchPreparationDeadline(arg0, arg1, arg2);
    }

    static final void stretchPreparationDeadline$lambda$0(CompletableFuture arg3, Function0 arg4) {
        arg3.completeExceptionally(new TimeoutException("PREPARATION_TIMEOUT_" + arg4.invoke()));
    }

    static final Unit stretchPreparationDeadline$lambda$1(ScheduledFuture arg0, Unit arg1, Throwable arg2) {
        arg0.cancel(false);
        return Unit.INSTANCE;
    }

    static final void stretchPreparationDeadline$lambda$2(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }
}

