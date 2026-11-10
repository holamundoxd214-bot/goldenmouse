package com.TryJeanPc.goldenmouse.injector;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u00014B\u009D\u0001\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\b\u0002\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0003\u0012\u001A\b\u0002\u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\b0\r\u0012\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0014\b\u0002\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\'\u001A\u00020\bJ\u000E\u0010(\u001A\u00020\u00052\u0006\u0010)\u001A\u00020\u0004J\u0014\u0010*\u001A\b\u0012\u0004\u0012\u00020\u00050+2\u0006\u0010)\u001A\u00020\u0004J\u0006\u0010,\u001A\u00020\bJ\u000E\u0010-\u001A\u00020\u00052\u0006\u0010.\u001A\u00020\u0011J\n\u0010/\u001A\u0004\u0018\u00010\u0018H\u0002J\b\u00100\u001A\u00020\bH\u0002J\b\u00101\u001A\u00020\bH\u0002J\b\u00102\u001A\u00020\bH\u0002J\b\u00103\u001A\u00020\bH\u0002R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0019\u001A\u001E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00180\u001Aj\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u0018`\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0010\u0010!\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010%\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b%\u0010 R\u0011\u0010&\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b&\u0010 ¨\u00065"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/OrderedInjectionWorker;", "", "send", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "", "closeTransport", "Lkotlin/Function0;", "", "onTransportFailure", "", "onMoveResult", "onDepth", "Lkotlin/Function2;", "", "onMoveOffer", "onQueueWait", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "lock", "Ljava/lang/Object;", "queue", "Ljava/util/ArrayDeque;", "Lcom/TryJeanPc/goldenmouse/injector/OrderedInjectionWorker$Item;", "moves", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "closed", "value", "requiresRecovery", "getRequiresRecovery", "()Z", "inflight", "closeFinished", "thread", "Ljava/lang/Thread;", "isTerminated", "isAlive", "start", "offerMove", "command", "offerControl", "Ljava/util/concurrent/CompletableFuture;", "close", "awaitStopped", "timeoutMs", "next", "run", "flushMoves", "failPending", "depth", "Item", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class OrderedInjectionWorker {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u000F\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001A\u00020\bHÆ\u0003J/\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0010\b\u0002\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00062\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0019\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/OrderedInjectionWorker$Item;", "", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "completion", "Ljava/util/concurrent/CompletableFuture;", "", "queuedAtNanos", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;Ljava/util/concurrent/CompletableFuture;J)V", "getCommand", "()Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "getCompletion", "()Ljava/util/concurrent/CompletableFuture;", "getQueuedAtNanos", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Item {
        private final TouchCommand command;
        private final CompletableFuture completion;
        private final long queuedAtNanos;

        public Item(TouchCommand arg1, CompletableFuture arg2, long arg3, int arg5, DefaultConstructorMarker arg6) {
            if((arg5 & 4) != 0) {
                arg3 = System.nanoTime();
            }

            this(arg1, arg2, arg3);
        }

        public Item(TouchCommand arg2, CompletableFuture arg3, long arg4) {
            Intrinsics.checkNotNullParameter(arg2, "command");
            super();
            this.command = arg2;
            this.completion = arg3;
            this.queuedAtNanos = arg4;
        }

        public final TouchCommand component1() {
            return this.command;
        }

        public final CompletableFuture component2() {
            return this.completion;
        }

        public final long component3() {
            return this.queuedAtNanos;
        }

        public final Item copy(TouchCommand arg1, CompletableFuture arg2, long arg3) {
            Intrinsics.checkNotNullParameter(arg1, "command");
            return new Item(arg1, arg2, arg3);
        }

        public static Item copy$default(Item arg0, TouchCommand arg1, CompletableFuture arg2, long arg3, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.command;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.completion;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.queuedAtNanos;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg6) {
            if(this == (((Item)arg6))) {
                return 1;
            }

            if(!(arg6 instanceof Item)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.command, ((Item)arg6).command)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.completion, ((Item)arg6).completion)) {
                return 0;
            }

            if(this.queuedAtNanos != ((Item)arg6).queuedAtNanos) {
                return 0;
            }

            return 1;
        }

        public final TouchCommand getCommand() {
            return this.command;
        }

        public final CompletableFuture getCompletion() {
            return this.completion;
        }

        public final long getQueuedAtNanos() {
            return this.queuedAtNanos;
        }

        public int hashCode() {
            int v0 = this.command.hashCode() * 0x1F;
            CompletableFuture v1 = this.completion;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return (v0 + v1_1) * 0x1F + Long.hashCode(this.queuedAtNanos);
        }

        public String toString() {
            return "Item(command=" + this.command + ", completion=" + this.completion + ", queuedAtNanos=" + this.queuedAtNanos + ")";
        }
    }

    public static final int $stable = 8;
    private volatile boolean closeFinished;
    private final Function0 closeTransport;
    private volatile boolean closed;
    private Item inflight;
    private final Object lock;
    private final LinkedHashMap moves;
    private final Function2 onDepth;
    private final Function1 onMoveOffer;
    private final Function1 onMoveResult;
    private final Function1 onQueueWait;
    private final Function1 onTransportFailure;
    private final ArrayDeque queue;
    private volatile boolean requiresRecovery;
    private final Function1 send;
    private final Thread thread;

    public static void $r8$lambda$N49EurmKYgdN7BzqmjIEdZIOfWA(OrderedInjectionWorker arg0) {
        arg0.run();
    }

    static {
    }

    public OrderedInjectionWorker(Function1 arg2, Function0 arg3, Function1 arg4, Function1 arg5, Function2 arg6, Function1 arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg2, "send");
        Intrinsics.checkNotNullParameter(arg3, "closeTransport");
        Intrinsics.checkNotNullParameter(arg4, "onTransportFailure");
        Intrinsics.checkNotNullParameter(arg5, "onMoveResult");
        Intrinsics.checkNotNullParameter(arg6, "onDepth");
        Intrinsics.checkNotNullParameter(arg7, "onMoveOffer");
        Intrinsics.checkNotNullParameter(arg8, "onQueueWait");
        super();
        this.send = arg2;
        this.closeTransport = arg3;
        this.onTransportFailure = arg4;
        this.onMoveResult = arg5;
        this.onDepth = arg6;
        this.onMoveOffer = arg7;
        this.onQueueWait = arg8;
        this.lock = new Object();
        this.queue = new ArrayDeque();
        this.moves = new LinkedHashMap();
        this.thread = new Thread(new OrderedInjectionWorker$$ExternalSyntheticLambda5(this), "GoldenKadbInjection");
    }

    public OrderedInjectionWorker(Function1 arg9, Function0 arg10, Function1 arg11, Function1 arg12, Function2 arg13, Function1 arg14, Function1 arg15, int arg16, DefaultConstructorMarker arg17) {
        Function1 v7_1;
        OrderedInjectionWorker$$ExternalSyntheticLambda3 v14;
        OrderedInjectionWorker$$ExternalSyntheticLambda2 v13;
        OrderedInjectionWorker$$ExternalSyntheticLambda1 v12;
        OrderedInjectionWorker$$ExternalSyntheticLambda0 v11;
        if((arg16 & 4) != 0) {
            v11 = new OrderedInjectionWorker$$ExternalSyntheticLambda0();
        }

        Function1 v3 = ((Function1)v11);
        if((arg16 & 8) != 0) {
            v12 = new OrderedInjectionWorker$$ExternalSyntheticLambda1();
        }

        Function1 v4 = ((Function1)v12);
        if((arg16 & 16) != 0) {
            v13 = new OrderedInjectionWorker$$ExternalSyntheticLambda2();
        }

        Function2 v5 = ((Function2)v13);
        if((arg16 & 0x20) != 0) {
            v14 = new OrderedInjectionWorker$$ExternalSyntheticLambda3();
        }

        Function1 v6 = ((Function1)v14);
        if((arg16 & 0x40) != 0) {
            OrderedInjectionWorker$$ExternalSyntheticLambda4 v7 = new OrderedInjectionWorker$$ExternalSyntheticLambda4();
        }
        else {
            v7_1 = arg15;
        }

        this(arg9, arg10, v3, v4, v5, v6, v7_1);
    }

    static final Unit _init_$lambda$0(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$1(boolean arg0) {
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$2(int arg0, int arg1) {
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$3(boolean arg0) {
        return Unit.INSTANCE;
    }

    static final Unit _init_$lambda$4(long arg0) {
        return Unit.INSTANCE;
    }

    public final boolean awaitStopped(long arg7) {
        long v0 = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(arg7);
        Thread v2 = Thread.currentThread();
        Thread v3 = this.thread;
        if(v2 != v3 && arg7 > 0) {
            v3.join(arg7);
        }

        while(!this.closeFinished) {
            if(System.nanoTime() >= v0) {
                break;
            }

            Thread.sleep(1);
        }

        return this.isTerminated();
    }

    public final void close() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.closed) {
                goto label_7;
            }
        }
        catch(Throwable v4) {
            goto label_31;
        }

        __monitor_exit(v0);
        return;
        try {
        label_7:
            this.closed = true;
            Item v2 = this.inflight;
            if(v2 != null) {
                CompletableFuture v2_1 = v2.getCompletion();
                if(v2_1 != null) {
                    v2_1.complete(Boolean.valueOf(false));
                }
            }

            this.failPending();
            this.lock.notifyAll();
        }
        catch(Throwable v4) {
        label_31:
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        Thread v0_1 = new Thread(new OrderedInjectionWorker$$ExternalSyntheticLambda6(this), "GoldenKadbClose");
        v0_1.setDaemon(true);
        v0_1.start();
        this.thread.interrupt();
    }

    static final void close$lambda$11(OrderedInjectionWorker arg2) {
        Object v0_1;
        try {
            arg2.closeTransport.invoke();
            arg2.closeFinished = true;
            v0_1 = Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v0) {
            v0_1 = Result.constructor-impl(ResultKt.createFailure(v0));
        }

        v0 = Result.exceptionOrNull-impl(v0_1);
        if(v0 != null) {
            try {
                arg2.onTransportFailure.invoke(v0);
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v2) {
                Result.constructor-impl(ResultKt.createFailure(v2));
            }
        }
    }

    private final void depth() {
        this.onDepth.invoke(Integer.valueOf(this.moves.size()), Integer.valueOf(this.queue.size()));
    }

    private final void failPending() {
        Iterator v0 = this.queue.iterator();
        while(v0.hasNext()) {
            CompletableFuture v1 = v0.next().getCompletion();
            if(v1 == null) {
                continue;
            }

            v1.complete(Boolean.valueOf(false));
        }

        this.queue.clear();
        this.moves.clear();
        this.depth();
    }

    private final void flushMoves() {
        Collection v0 = this.moves.values();
        Intrinsics.checkNotNullExpressionValue(v0, "<get-values>(...)");
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            this.queue.addLast(v0_1.next());
        }

        this.moves.clear();
        this.depth();
    }

    public final boolean getRequiresRecovery() {
        return this.requiresRecovery;
    }

    public final boolean isAlive() {
        if(!this.closed && (this.thread.isAlive())) {
            return 1;
        }

        return 0;
    }

    public final boolean isTerminated() {
        if((this.closed) && !this.thread.isAlive() && (this.closeFinished)) {
            return 1;
        }

        return 0;
    }

    private final Item next() {
        Item v3_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            while(!this.closed) {
                if(!this.queue.isEmpty()) {
                    break;
                }

                if(!this.moves.isEmpty()) {
                    break;
                }

                this.lock.wait();
            }

            if(this.closed) {
                v3_1 = null;
            }
            else {
                if(this.queue.isEmpty()) {
                    this.flushMoves();
                }

                Object v1 = this.queue.removeFirst();
                this.inflight = v1;
                this.depth();
                Object v3_2 = v1;
            }

            __monitor_exit(v0);
            return v3_1;
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }
    }

    public final CompletableFuture offerControl(TouchCommand arg10) {
        CompletableFuture v4;
        Intrinsics.checkNotNullParameter(arg10, "command");
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            v4 = new CompletableFuture();
            if(!this.closed) {
                if((this.requiresRecovery) && arg10.getAction() != Action.ACTION_CANCEL) {
                    goto label_27;
                }

                this.flushMoves();
                this.queue.addLast(new Item(arg10, v4, 0, 4, null));
                this.depth();
                this.lock.notifyAll();
            }
            else {
            label_27:
                v4.complete(Boolean.valueOf(false));
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v4;
    }

    public final boolean offerMove(TouchCommand arg12) {
        boolean v2;
        Intrinsics.checkNotNullParameter(arg12, "command");
        Object v1 = this.lock;
        __monitor_enter(v1);
        try {
            v2 = false;
            if(!this.closed) {
                if(this.requiresRecovery) {
                }
                else {
                    if(this.moves.put(Integer.valueOf(arg12.getPointerId()), new Item(arg12, null, 0, 4, null)) != null) {
                        v2 = true;
                    }

                    this.onMoveOffer.invoke(Boolean.valueOf(v2));
                    this.depth();
                    this.lock.notifyAll();
                    v2 = true;
                }
            }
        }
        catch(Throwable v0) {
            __monitor_exit(v1);
            throw v0;
        }

        __monitor_exit(v1);
        return v2;
    }

    private final void run() {
        Object v3_2;
        CompletableFuture v3_1;
        Object v6;
        boolean v4;
        Throwable v1_1;
        Item v2_1;
        while(true) {
            Item v1 = null;
            try {
                v2_1 = this.next();
                if(v2_1 != null) {
                    goto label_6;
                }
            }
            catch(Throwable v2) {
                Throwable v8 = v2;
                v2_1 = v1;
                v1_1 = v8;
                goto label_74;
            }

            this.close();
            return;
            try {
            label_6:
                this.onQueueWait.invoke(Long.valueOf(RangesKt.coerceAtLeast(System.nanoTime() - v2_1.getQueuedAtNanos(), 0)));
                int v3 = v2_1.getCommand().getAction() == Action.ACTION_CANCEL ? 1 : 0;
                v4 = !this.requiresRecovery || v3 != 0 ? this.send.invoke(v2_1.getCommand()).booleanValue() : false;
                v6 = this.lock;
                __monitor_enter(v6);
                if(v4) {
                }
                else {
                    goto label_40;
                }
            }
            catch(Throwable v1_1) {
                goto label_69;
            }

            try {
                if(!this.closed) {
                    v4 = true;
                }
                else {
                label_40:
                    v4 = false;
                }

                if(!v4) {
                    this.requiresRecovery = true;
                }
                else if(v3 != 0) {
                    this.requiresRecovery = false;
                }
            }
            catch(Throwable v1_1) {
                break;
            }

            try {
                __monitor_exit(v6);
                v3_1 = v2_1.getCompletion();
                if(v3_1 != null) {
                    v3_1.complete(Boolean.valueOf(v4));
                }

                if(v2_1.getCompletion() == null) {
                    this.onMoveResult.invoke(Boolean.valueOf(v4));
                }

                v3_2 = this.lock;
                __monitor_enter(v3_2);
            }
            catch(Throwable v1_1) {
                goto label_69;
            }

            try {
                this.inflight = v1;
                goto label_63;
            }
            catch(Throwable v1_1) {
                try {
                    __monitor_exit(v3_2);
                    throw v1_1;
                label_63:
                    __monitor_exit(v3_2);
                    continue;
                }
                catch(Throwable v1_1) {
                    goto label_69;
                }
            }
        }

        try {
            __monitor_exit(v6);
            throw v1_1;
        }
        catch(Throwable v1_1) {
        label_69:
        }

    label_74:
        if(v2_1 != null) {
            try {
                v3_1 = v2_1.getCompletion();
                if(v3_1 != null) {
                    v3_1.complete(Boolean.valueOf(false));
                }

            label_82:
                if(v2_1 != null && v2_1.getCompletion() == null) {
                    this.onMoveResult.invoke(Boolean.valueOf(false));
                }

                if(!this.closed) {
                    this.onTransportFailure.invoke(v1_1);
                    goto label_92;
                label_81:
                    goto label_94;
                }

                goto label_92;
            }
            catch(Throwable v0) {
                goto label_81;
            }
        }

        goto label_82;
    label_94:
        this.close();
        throw v0;
    label_92:
        this.close();
    }

    public final void start() {
        this.thread.start();
    }
}

