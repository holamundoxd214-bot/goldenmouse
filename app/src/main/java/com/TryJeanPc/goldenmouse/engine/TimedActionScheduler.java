package com.TryJeanPc.goldenmouse.engine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\fH\u0016J\b\u0010\r\u001A\u00020\bH\u0016R\u0016\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/TimedActionScheduler;", "Lcom/TryJeanPc/goldenmouse/engine/ActionScheduler;", "<init>", "()V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "schedule", "", "delayMs", "", "action", "Lkotlin/Function0;", "close", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TimedActionScheduler implements ActionScheduler {
    public static final int $stable = 8;
    private final ScheduledExecutorService executor;

    static {
    }

    public TimedActionScheduler() {
        super();
        this.executor = Executors.newSingleThreadScheduledExecutor(new TimedActionScheduler$$ExternalSyntheticLambda0());
    }

    public void close() {
        this.executor.shutdownNow();
    }

    static final Thread executor$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenTapActions");
        v0.setDaemon(true);
        return v0;
    }

    public void schedule(long arg2, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "action");
        this.executor.schedule(new TimedActionScheduler$$ExternalSyntheticLambda1(arg4), arg2, TimeUnit.MILLISECONDS);
    }

    static final void schedule$lambda$2(Function0 arg0) {
        arg0.invoke();
    }
}

