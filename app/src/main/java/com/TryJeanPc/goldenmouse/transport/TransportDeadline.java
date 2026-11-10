package com.TryJeanPc.goldenmouse.transport;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001&B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0004H\u0002J7\u0010\u0013\u001A\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u000E\b\u0002\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u0002H\u00140\u0018¢\u0006\u0002\u0010\u001BJE\u0010\u001C\u001A\u0002H\u0014\"\f\b\u0000\u0010\u0014*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0015\u001A\u00020\u00162\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00140\u00182\u0014\b\u0002\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u00020\u00190\u001F¢\u0006\u0002\u0010 J\u0018\u0010!\u001A\u0006\u0012\u0002\b\u00030\"2\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018J\u001C\u0010$\u001A\u00020\u00192\u0006\u0010\u0015\u001A\u00020\u00162\f\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018J\b\u0010%\u001A\u00020\u0019H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/transport/TransportDeadline;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "name", "", "<init>", "(Ljava/lang/String;)V", "lane", "Ljava/util/concurrent/ThreadPoolExecutor;", "suffix", "io", "cleanup", "pendingCloses", "Ljava/util/concurrent/atomic/AtomicInteger;", "uncertain", "Ljava/util/concurrent/atomic/AtomicBoolean;", "active", "", "cleanupFailed", "call", "T", "timeoutMillis", "", "abort", "Lkotlin/Function0;", "", "operation", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "open", "create", "initialize", "Lkotlin/Function1;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/AutoCloseable;", "closeAsync", "Ljava/util/concurrent/Future;", "action", "closeWithin", "close", "Budget", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TransportDeadline implements AutoCloseable {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0007\u001A\u00020\u0003R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/transport/TransportDeadline$Budget;", "", "timeoutMillis", "", "<init>", "(J)V", "end", "remainingMillis", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Budget {
        public static final int $stable;
        private final long end;

        static {
        }

        public Budget(long arg4) {
            super();
            this.end = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(arg4);
        }

        public final long remainingMillis() {
            long v0 = this.end - System.nanoTime();
            if(v0 > 0) {
                return RangesKt.coerceAtLeast(TimeUnit.NANOSECONDS.toMillis(v0), 1);
            }

            throw new TimeoutException("Plazo de transporte agotado");
        }
    }

    public static final int $stable = 8;
    private volatile boolean active;
    private final ThreadPoolExecutor cleanup;
    private volatile boolean cleanupFailed;
    private final ThreadPoolExecutor io;
    private final String name;
    private final AtomicInteger pendingCloses;
    private final AtomicBoolean uncertain;

    static {
    }

    public TransportDeadline(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        super();
        this.name = arg2;
        this.io = this.lane("IO");
        this.cleanup = this.lane("Close");
        this.pendingCloses = new AtomicInteger();
        this.uncertain = new AtomicBoolean();
    }

    public static final void access$open$abort(AtomicBoolean arg0, AtomicReference arg1, TransportDeadline arg2) {
        TransportDeadline.open$abort(arg0, arg1, arg2);
    }

    public final Object call(long arg5, Function0 arg7, Function0 arg8) {
        ThreadPoolExecutor v4_3;
        Object v4_2;
        long v1;
        Future v8;
        String v0 = "null cannot be cast to non-null type java.lang.Runnable";
        Intrinsics.checkNotNullParameter(arg7, "abort");
        Intrinsics.checkNotNullParameter(arg8, "operation");
        try {
            v8 = this.io.submit(new TransportDeadline$$ExternalSyntheticLambda9(this, arg8));
            v1 = 1;
        }
        catch(RejectedExecutionException v4) {
            throw new IOException("Transporte ocupado o cerrado", ((Throwable)v4));
        }

        try {
            v4_2 = v8.get(RangesKt.coerceAtLeast(arg5, v1), TimeUnit.MILLISECONDS);
            return v4_2;
        }
        catch(ExecutionException v4_1) {
            v5_2 = v4_1.getCause();
            if(v5_2 == null) {
                ExecutionException v5_3 = v4_1;
            }

            throw v5_2;
        }
        catch(InterruptedException v5) {
            ((TransportDeadline)v4_2).uncertain.set(true);
            try {
                arg7.invoke();
            }
            catch(Throwable v5_2) {
                v8.cancel(true);
                v4_3 = ((TransportDeadline)v4_2).io;
                Intrinsics.checkNotNull(v8, v0);
                v4_3.remove(((Runnable)v8));
                Thread.currentThread().interrupt();
                throw v5_2;
            }

            v8.cancel(true);
            v4_3 = ((TransportDeadline)v4_2).io;
            Intrinsics.checkNotNull(v8, v0);
            v4_3.remove(((Runnable)v8));
            Thread.currentThread().interrupt();
            throw v5;
        }
        catch(TimeoutException v5_1) {
            ((TransportDeadline)v4_2).uncertain.set(true);
            try {
                arg7.invoke();
            }
            catch(Throwable v5_2) {
                v8.cancel(true);
                v4_3 = ((TransportDeadline)v4_2).io;
                Intrinsics.checkNotNull(v8, v0);
                v4_3.remove(((Runnable)v8));
                throw v5_2;
            }

            v8.cancel(true);
            v4_3 = ((TransportDeadline)v4_2).io;
            Intrinsics.checkNotNull(v8, v0);
            v4_3.remove(((Runnable)v8));
            throw v5_1;
        }
    }

    public static Object call$default(TransportDeadline arg0, long arg1, Function0 arg3, Function0 arg4, int arg5, Object arg6) {
        TransportDeadline$$ExternalSyntheticLambda7 v3;
        if((arg5 & 2) != 0) {
            v3 = new TransportDeadline$$ExternalSyntheticLambda7();
        }

        return arg0.call(arg1, ((Function0)v3), arg4);
    }

    static final Unit call$lambda$2() {
        return Unit.INSTANCE;
    }

    static final Object call$lambda$3(TransportDeadline arg1, Function0 arg2) {
        Object v2_1;
        arg1.active = true;
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            arg1.active = false;
            throw v2;
        }

        arg1.active = false;
        return v2_1;
    }

    public void close() {
        this.io.shutdownNow();
        this.cleanup.shutdownNow();
    }

    public final Future closeAsync(Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "action");
        this.pendingCloses.incrementAndGet();
        try {
            Future v3_1 = this.cleanup.submit(new TransportDeadline$$ExternalSyntheticLambda5(arg3, this));
            Intrinsics.checkNotNull(v3_1);
            return v3_1;
        }
        catch(RejectedExecutionException v3) {
            this.pendingCloses.decrementAndGet();
            this.cleanupFailed = true;
            throw v3;
        }
    }

    static final void closeAsync$lambda$8(Function0 arg1, TransportDeadline arg2) {
        try {
            arg1.invoke();
        }
        catch(Throwable v1) {
            try {
                arg2.cleanupFailed = true;
                throw v1;
            }
            catch(Throwable v1) {
                arg2.pendingCloses.decrementAndGet();
                throw v1;
            }
        }

        arg2.pendingCloses.decrementAndGet();
    }

    public final void closeWithin(long arg3, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "action");
        Future v5 = this.closeAsync(arg5);
        try {
            v5.get(arg3, TimeUnit.MILLISECONDS);
            return;
        }
        catch(ExecutionException v2) {
            Throwable v3_2 = v2.getCause();
            if(v3_2 == null) {
                ExecutionException v3_3 = v2;
            }

            throw v3_2;
        }
        catch(InterruptedException v3) {
            this.uncertain.set(true);
            Thread.currentThread().interrupt();
            throw v3;
        }
        catch(TimeoutException v3_1) {
            this.uncertain.set(true);
            throw v3_1;
        }
    }

    private final ThreadPoolExecutor lane(String arg9) {
        return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(16), new TransportDeadline$$ExternalSyntheticLambda6(this, arg9));
    }

    static final Thread lane$lambda$1(TransportDeadline arg2, String arg3, Runnable arg4) {
        Thread v0 = new Thread(arg4, arg2.name + "-" + arg3);
        v0.setDaemon(true);
        return v0;
    }

    public final AutoCloseable open(long arg8, Function0 arg10, Function1 arg11) {
        Intrinsics.checkNotNullParameter(arg10, "create");
        Intrinsics.checkNotNullParameter(arg11, "initialize");
        if(!this.cleanupFailed) {
            if(this.uncertain.get()) {
                if(!this.active && this.pendingCloses.get() <= 0) {
                    this.uncertain.set(false);
                    goto label_22;
                }

                throw new IOException("Transporte anterior todavía sin cierre confirmado");
            }

        label_22:
            AtomicBoolean v3 = new AtomicBoolean();
            AtomicReference v2 = new AtomicReference();
            return this.call(arg8, new TransportDeadline$open$2(v3, v2, this), new TransportDeadline$$ExternalSyntheticLambda3(arg10, v2, v3, arg11, this));
        }

        throw new IOException("Limpieza anterior fallida; apertura en cuarentena");
    }

    private static final void open$abort(AtomicBoolean arg1, AtomicReference arg2, TransportDeadline arg3) {
        arg1.set(true);
        Object v1 = arg2.getAndSet(null);
        if(v1 != null) {
            arg3.closeAsync(new TransportDeadline$$ExternalSyntheticLambda8(((AutoCloseable)v1)));
        }
    }

    static final Unit open$abort$lambda$6$lambda$5(AutoCloseable arg0) {
        TransportDeadline$$ExternalSyntheticThrowIAE2.m(arg0);
        return Unit.INSTANCE;
    }

    public static AutoCloseable open$default(TransportDeadline arg0, long arg1, Function0 arg3, Function1 arg4, int arg5, Object arg6) {
        TransportDeadline$$ExternalSyntheticLambda4 v4;
        if((arg5 & 4) != 0) {
            v4 = new TransportDeadline$$ExternalSyntheticLambda4();
        }

        return arg0.open(arg1, arg3, ((Function1)v4));
    }

    static final Unit open$lambda$4(AutoCloseable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    static final AutoCloseable open$lambda$7(Function0 arg1, AtomicReference arg2, AtomicBoolean arg3, Function1 arg4, TransportDeadline arg5) {
        Object v1 = arg1.invoke();
        arg2.set(v1);
        try {
            if(!arg3.get()) {
                arg4.invoke(v1);
                if(!arg3.get()) {
                    return ((AutoCloseable)v1);
                }

                throw new TimeoutException("READY fuera de plazo");
            }

            TransportDeadline.open$abort(arg3, arg2, arg5);
            throw new TimeoutException("Apertura tardía descartada");
        }
        catch(Throwable v1_1) {
            TransportDeadline.open$abort(arg3, arg2, arg5);
            throw v1_1;
        }
    }
}

