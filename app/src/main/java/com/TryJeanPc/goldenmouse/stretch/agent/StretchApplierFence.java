package com.TryJeanPc.goldenmouse.stretch.agent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0001\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001A\u00020\u00072\b\b\u0002\u0010\u0011\u001A\u00020\u0012R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchApplierFence;", "", "death", "Ljava/util/concurrent/CompletableFuture;", "", "alive", "Lkotlin/Function0;", "", "request", "<init>", "(Ljava/util/concurrent/CompletableFuture;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "requestOutcome", "getRequestOutcome", "()Ljava/util/concurrent/CompletableFuture;", "requested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "awaitDeath", "timeoutMillis", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchApplierFence {
    public static final int $stable = 8;
    private final Function0 alive;
    private final CompletableFuture death;
    private final Function0 request;
    private final CompletableFuture requestOutcome;
    private final AtomicBoolean requested;

    static {
    }

    public StretchApplierFence(CompletableFuture arg2, Function0 arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "death");
        Intrinsics.checkNotNullParameter(arg3, "alive");
        Intrinsics.checkNotNullParameter(arg4, "request");
        super();
        this.death = arg2;
        this.alive = arg3;
        this.request = arg4;
        this.requestOutcome = new CompletableFuture();
        this.requested = new AtomicBoolean();
    }

    public final boolean awaitDeath(long arg6) {
        if(!this.alive.invoke().booleanValue()) {
            return 1;
        }

        if(this.requested.compareAndSet(false, true)) {
            Thread v0 = new Thread(new StretchApplierFence$$ExternalSyntheticLambda0(this), "StretchApplierFence");
            v0.setDaemon(true);
            v0.start();
        }

        try {
            this.death.get(arg6, TimeUnit.MILLISECONDS);
            goto label_22;
        }
        catch(TimeoutException ) {
        label_22:
            return this.alive.invoke().booleanValue() ^ 1;
        }
        catch(Exception ) {
            return 0;
        }
        catch(InterruptedException ) {
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    public static boolean awaitDeath$default(StretchApplierFence arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = 3000;
        }

        return arg0.awaitDeath(arg1);
    }

    static final void awaitDeath$lambda$0(StretchApplierFence arg2) {
        try {
            arg2.request.invoke();
            arg2.requestOutcome.complete(Unit.INSTANCE);
            return;
        }
        catch(Exception v0) {
            arg2.requestOutcome.completeExceptionally(((Throwable)v0));
            return;
        }
    }

    public final CompletableFuture getRequestOutcome() {
        return this.requestOutcome;
    }
}

