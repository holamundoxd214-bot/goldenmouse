package com.TryJeanPc.goldenmouse.macro.execution;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0016J\b\u0010\r\u001A\u00020\fH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/TimedMacroScheduler;", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroScheduler;", "<init>", "()V", "executor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "schedule", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTask;", "delayMs", "", "action", "Lkotlin/Function0;", "", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TimedMacroScheduler implements MacroScheduler {
    public static final int $stable = 8;
    private final ScheduledThreadPoolExecutor executor;

    static {
    }

    public TimedMacroScheduler() {
        super();
        ScheduledThreadPoolExecutor v0 = new ScheduledThreadPoolExecutor(1, new TimedMacroScheduler$$ExternalSyntheticLambda2());
        v0.setRemoveOnCancelPolicy(true);
        this.executor = v0;
    }

    public void close() {
        this.executor.shutdownNow();
    }

    static final Thread executor$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenMacroPlayback");
        v0.setDaemon(true);
        return v0;
    }

    public MacroTask schedule(long arg4, Function0 arg6) {
        Intrinsics.checkNotNullParameter(arg6, "action");
        return new TimedMacroScheduler$$ExternalSyntheticLambda1(this.executor.schedule(new TimedMacroScheduler$$ExternalSyntheticLambda0(arg6), RangesKt.coerceAtLeast(arg4, 0), TimeUnit.MILLISECONDS));
    }

    static final void schedule$lambda$3(Function0 arg0) {
        arg0.invoke();
    }

    static final void schedule$lambda$4(ScheduledFuture arg1) {
        arg1.cancel(false);
    }
}

