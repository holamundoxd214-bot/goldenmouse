package com.TryJeanPc.goldenmouse.input;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\f\u001A\u00020\bH\u0016R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MouseMovementTimer;", "Lcom/TryJeanPc/goldenmouse/input/MouseMovementRegulator$Timer;", "<init>", "()V", "worker", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "schedule", "Lkotlin/Function0;", "", "delayNanos", "", "action", "stop", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MouseMovementTimer implements Timer {
    public static final int $stable = 8;
    private ScheduledThreadPoolExecutor worker;

    static {
    }

    public MouseMovementTimer() {
        super();
    }

    public Function0 schedule(long arg6, Function0 arg8) {
        MouseMovementTimer$$ExternalSyntheticLambda2 v7;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg8, "action");
            ScheduledThreadPoolExecutor v0 = this.worker;
            if(v0 == null) {
                v0 = new ScheduledThreadPoolExecutor(1, new MouseMovementTimer$$ExternalSyntheticLambda0());
                v0.setRemoveOnCancelPolicy(true);
                v0.setKeepAliveTime(0xFA, TimeUnit.MILLISECONDS);
                v0.allowCoreThreadTimeOut(true);
                this.worker = v0;
            }

            v7 = new MouseMovementTimer$$ExternalSyntheticLambda2(v0.schedule(new MouseMovementTimer$$ExternalSyntheticLambda1(arg8), arg6, TimeUnit.NANOSECONDS));
        }
        catch(Throwable v6) {
            try {
            label_25:
                __monitor_exit(this);
            }
            catch(Throwable v6) {
                goto label_25;
            }

            throw v6;
        }

        __monitor_exit(this);
        return ((Function0)v7);
    }

    static final Thread schedule$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "GoldenMouseHz");
        v0.setDaemon(true);
        return v0;
    }

    static final void schedule$lambda$4(Function0 arg0) {
        arg0.invoke();
    }

    static final Unit schedule$lambda$5(ScheduledFuture arg1) {
        arg1.cancel(false);
        return Unit.INSTANCE;
    }

    public void stop() {
        __monitor_enter(this);
        try {
            ScheduledThreadPoolExecutor v0_1 = this.worker;
            if(v0_1 != null) {
                v0_1.shutdownNow();
            }

            this.worker = null;
        }
        catch(Throwable v0) {
            try {
            label_9:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

        __monitor_exit(this);
    }
}

