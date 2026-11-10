package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryCancellation;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryClock;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryScheduler;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001*BG\b\u0000\u0012\u0018\u0010\u0003\u001A\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u001DH\u0002J\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00070\u001F2\u0006\u0010 \u001A\u00020\u0005J\u0010\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0013H\u0002J$\u0010$\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u00132\b\u0010%\u001A\u0004\u0018\u00010\u00072\b\u0010&\u001A\u0004\u0018\u00010\'H\u0002J\u0006\u0010(\u001A\u00020\"J\b\u0010)\u001A\u00020\"H\u0016R \u0010\u0003\u001A\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCallSupervisor;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "transport", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "Ljava/util/concurrent/CompletionStage;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "clock", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;", "scheduler", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScheduler;", "timeoutMillis", "", "invocationWorker", "Ljava/util/concurrent/Executor;", "<init>", "(Lkotlin/jvm/functions/Function1;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScheduler;JLjava/util/concurrent/Executor;)V", "active", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCallSupervisor$Work;", "quarantined", "", "closed", "remoteExecutionUnknown", "getRemoteExecutionUnknown", "()Z", "failure", "r", "code", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCode;", "submit", "Ljava/util/concurrent/CompletableFuture;", "request", "expired", "", "work", "completed", "reply", "error", "", "peerDied", "close", "Work", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentCallSupervisor implements AutoCloseable {
    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0005HÆ\u0003J\u000F\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000B\u0010\u001A\u001A\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020 HÖ\u0001J\t\u0010!\u001A\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCallSupervisor$Work;", "", "request", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "deadline", "", "result", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "timer", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryCancellation;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;JLjava/util/concurrent/CompletableFuture;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryCancellation;)V", "getRequest", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "getDeadline", "()J", "getResult", "()Ljava/util/concurrent/CompletableFuture;", "getTimer", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryCancellation;", "setTimer", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryCancellation;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Work {
        private final long deadline;
        private final StretchAgentRequest request;
        private final CompletableFuture result;
        private RecoveryCancellation timer;

        public Work(StretchAgentRequest arg7, long arg8, CompletableFuture arg10, RecoveryCancellation arg11, int arg12, DefaultConstructorMarker arg13) {
            if((arg12 & 8) != 0) {
                arg11 = null;
            }

            this(arg7, arg8, arg10, arg11);
        }

        public Work(StretchAgentRequest arg2, long arg3, CompletableFuture arg5, RecoveryCancellation arg6) {
            Intrinsics.checkNotNullParameter(arg2, "request");
            Intrinsics.checkNotNullParameter(arg5, "result");
            super();
            this.request = arg2;
            this.deadline = arg3;
            this.result = arg5;
            this.timer = arg6;
        }

        public final StretchAgentRequest component1() {
            return this.request;
        }

        public final long component2() {
            return this.deadline;
        }

        public final CompletableFuture component3() {
            return this.result;
        }

        public final RecoveryCancellation component4() {
            return this.timer;
        }

        public final Work copy(StretchAgentRequest arg7, long arg8, CompletableFuture arg10, RecoveryCancellation arg11) {
            Intrinsics.checkNotNullParameter(arg7, "request");
            Intrinsics.checkNotNullParameter(arg10, "result");
            return new Work(arg7, arg8, arg10, arg11);
        }

        public static Work copy$default(Work arg0, StretchAgentRequest arg1, long arg2, CompletableFuture arg4, RecoveryCancellation arg5, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.request;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.deadline;
            }

            if((arg6 & 4) != 0) {
                arg4 = arg0.result;
            }

            if((arg6 & 8) != 0) {
                arg5 = arg0.timer;
            }

            return arg0.copy(arg1, arg2, arg4, arg5);
        }

        public boolean equals(Object arg8) {
            if(this == (((Work)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Work)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.request, ((Work)arg8).request)) {
                return 0;
            }

            if(this.deadline != ((Work)arg8).deadline) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.result, ((Work)arg8).result)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.timer, ((Work)arg8).timer)) {
                return 0;
            }

            return 1;
        }

        public final long getDeadline() {
            return this.deadline;
        }

        public final StretchAgentRequest getRequest() {
            return this.request;
        }

        public final CompletableFuture getResult() {
            return this.result;
        }

        public final RecoveryCancellation getTimer() {
            return this.timer;
        }

        public int hashCode() {
            int v0 = ((this.request.hashCode() * 0x1F + Long.hashCode(this.deadline)) * 0x1F + this.result.hashCode()) * 0x1F;
            RecoveryCancellation v3 = this.timer;
            int v3_1 = v3 == null ? 0 : v3.hashCode();
            return v0 + v3_1;
        }

        public final void setTimer(RecoveryCancellation arg1) {
            this.timer = arg1;
        }

        public String toString() {
            return "Work(request=" + this.request + ", deadline=" + this.deadline + ", result=" + this.result + ", timer=" + this.timer + ")";
        }
    }

    public static final int $stable = 8;
    private Work active;
    private final RecoveryClock clock;
    private boolean closed;
    private final Executor invocationWorker;
    private boolean quarantined;
    private final RecoveryScheduler scheduler;
    private final long timeoutMillis;
    private final Function1 transport;

    static {
    }

    public StretchAgentCallSupervisor(Function1 arg2, RecoveryClock arg3, RecoveryScheduler arg4, long arg5, Executor arg7) {
        Intrinsics.checkNotNullParameter(arg2, "transport");
        Intrinsics.checkNotNullParameter(arg3, "clock");
        Intrinsics.checkNotNullParameter(arg4, "scheduler");
        Intrinsics.checkNotNullParameter(arg7, "invocationWorker");
        super();
        this.transport = arg2;
        this.clock = arg3;
        this.scheduler = arg4;
        this.timeoutMillis = arg5;
        this.invocationWorker = arg7;
        if(1 <= arg5 && arg5 < 60001) {
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public StretchAgentCallSupervisor(Function1 arg17, RecoveryClock arg18, RecoveryScheduler arg19, long arg20, Executor arg22, int arg23, DefaultConstructorMarker arg24) {
        Executor v8_1;
        long v6 = (arg23 & 8) != 0 ? 2500 : arg20;
        if((arg23 & 16) != 0) {
            ThreadPoolExecutor v8 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new StretchAgentCallSupervisor$$ExternalSyntheticLambda3());
        }
        else {
            v8_1 = arg22;
        }

        this(arg17, arg18, arg19, v6, v8_1);
    }

    static final Thread _init_$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchAgentRpc");
        v0.setDaemon(true);
        return v0;
    }

    public void close() {
        __monitor_enter(this);
        try {
            if(!this.closed) {
                goto label_5;
            }
        }
        catch(Throwable v0) {
            goto label_36;
        }

        __monitor_exit(this);
        return;
    label_5:
        boolean v0_1 = true;
        try {
            this.closed = true;
            Work v1 = this.active;
            if(v1 != null) {
                RecoveryCancellation v2 = v1.getTimer();
                if(v2 != null) {
                    v2.cancel();
                }

                v1.getResult().complete(this.failure(v1.getRequest(), StretchAgentCode.OPERATION_UNKNOWN));
            }

            if(this.active == null) {
                if(this.quarantined) {
                }
                else {
                    v0_1 = false;
                }
            }

            this.quarantined = v0_1;
            this.scheduler.close();
            Executor v0_2 = this.invocationWorker;
            if((v0_2 instanceof ExecutorService)) {
            }
            else {
                v0_2 = null;
            }

            if(v0_2 != null) {
                ((ExecutorService)v0_2).shutdownNow();
            }
        }
        catch(Throwable v0) {
            try {
            label_36:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_36;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    private final void completed(Work arg10, StretchAgentReply arg11, Throwable arg12) {
        __monitor_enter(this);
        try {
            if(this.active == arg10) {
                if(this.closed) {
                }
                else {
                    RecoveryCancellation v0 = arg10.getTimer();
                    if(v0 != null) {
                        v0.cancel();
                    }

                    if(arg12 == null && arg11 != null && (Intrinsics.areEqual(arg11.getOperationId(), arg10.getRequest().getOperationId())) && (Intrinsics.areEqual(arg11.getAgentGeneration(), arg10.getRequest().getAgentGeneration()))) {
                        StretchAgentCode[] v12 = new StretchAgentCode[3];
                        int v2 = 0;
                        v12[0] = StretchAgentCode.OPERATION_UNKNOWN;
                        v12[1] = StretchAgentCode.TIMEOUT;
                        v12[2] = StretchAgentCode.RECOVERY_PENDING;
                        if(SetsKt.setOf(((Object[])v12)).contains(arg11.getCode())) {
                        }
                        else {
                            long v3 = this.clock.elapsedRealtimeMillis();
                            if((this.quarantined) || v3 >= arg10.getDeadline() || v3 < arg10.getDeadline() - this.timeoutMillis) {
                                v2 = 1;
                            }

                            this.active = null;
                            if(v2 != 0) {
                                this.quarantined = true;
                                arg10.getResult().complete(this.failure(arg10.getRequest(), StretchAgentCode.TIMEOUT));
                            }
                            else {
                                arg10.getResult().complete(arg11);
                            }

                            goto label_60;
                        }
                    }

                    goto label_62;
                }
            }

            goto label_70;
        }
        catch(Throwable v10) {
            goto label_73;
        }

    label_60:
        __monitor_exit(this);
        return;
        try {
        label_62:
            this.quarantined = true;
            arg10.getResult().complete(this.failure(arg10.getRequest(), StretchAgentCode.OPERATION_UNKNOWN));
        }
        catch(Throwable v10) {
            try {
            label_73:
                __monitor_exit(this);
            }
            catch(Throwable v10) {
                goto label_73;
            }

            throw v10;
        }

        __monitor_exit(this);
        return;
    label_70:
        __monitor_exit(this);
    }

    private final void expired(Work arg7) {
        __monitor_enter(this);
        try {
            if(this.active == arg7) {
                if(this.closed) {
                }
                else {
                    long v0 = this.clock.elapsedRealtimeMillis();
                    long v2 = arg7.getDeadline() - this.timeoutMillis;
                    if(v0 < arg7.getDeadline() && v2 <= v0) {
                        arg7.setTimer(this.scheduler.schedule(arg7.getDeadline() - v0, new StretchAgentCallSupervisor$$ExternalSyntheticLambda2(this, arg7)));
                        goto label_21;
                    }

                    goto label_24;
                }
            }

            goto label_32;
        }
        catch(Throwable v7) {
            goto label_35;
        }

    label_21:
        __monitor_exit(this);
        return;
        try {
        label_24:
            this.quarantined = true;
            arg7.getResult().complete(this.failure(arg7.getRequest(), StretchAgentCode.TIMEOUT));
        }
        catch(Throwable v7) {
            try {
            label_35:
                __monitor_exit(this);
            }
            catch(Throwable v7) {
                goto label_35;
            }

            throw v7;
        }

        __monitor_exit(this);
        return;
    label_32:
        __monitor_exit(this);
    }

    static final Unit expired$lambda$6(StretchAgentCallSupervisor arg0, Work arg1) {
        arg0.expired(arg1);
        return Unit.INSTANCE;
    }

    private final StretchAgentReply failure(StretchAgentRequest arg10, StretchAgentCode arg11) {
        return new StretchAgentReply(arg10.getOperationId(), arg10.getAgentGeneration(), arg11, StretchAgentPhase.RECOVERY_PENDING, null, null, 0x30, null);
    }

    public final boolean getRemoteExecutionUnknown() {
        __monitor_enter(this);
        try {
            if(!this.quarantined) {
                goto label_7;
            }
            else if(this.active == null) {
                goto label_7;
            }
        }
        catch(Throwable v0) {
            try {
            label_11:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_11;
            }

            throw v0;
        }

        boolean v0_1 = true;
        goto label_8;
    label_7:
        v0_1 = false;
    label_8:
        __monitor_exit(this);
        return v0_1;
    }

    public final void peerDied() {
        __monitor_enter(this);
        try {
            Work v0_1 = this.active;
            if(v0_1 != null) {
                RecoveryCancellation v1 = v0_1.getTimer();
                if(v1 != null) {
                    v1.cancel();
                }

                v0_1.getResult().complete(this.failure(v0_1.getRequest(), StretchAgentCode.BACKEND_DISCONNECTED));
            }

            this.active = null;
            this.quarantined = true;
            this.close();
        }
        catch(Throwable v0) {
            try {
            label_19:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_19;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    public final CompletableFuture submit(StretchAgentRequest arg12) {
        StretchAgentRequest v4;
        CompletableFuture v12;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg12, "request");
            if(!this.closed) {
                goto label_12;
            }

            v12 = CompletableFuture.completedFuture(this.failure(arg12, StretchAgentCode.CLOSED));
            Intrinsics.checkNotNullExpressionValue(v12, "completedFuture(...)");
        }
        catch(Throwable v0) {
            goto label_72;
        }

        __monitor_exit(this);
        return v12;
        try {
        label_12:
            if(this.active == null) {
                if(this.quarantined) {
                }
                else {
                    long v0_1 = this.clock.elapsedRealtimeMillis();
                    if(v0_1 >= 0) {
                        if(v0_1 > 0x7FFFFFFFFFFFFFFFL - this.timeoutMillis) {
                        }
                        else {
                            v4 = arg12;
                            Work v3 = new Work(v4, v0_1 + this.timeoutMillis, new CompletableFuture(), null, 8, null);
                            this.active = v3;
                            try {
                                v3.setTimer(this.scheduler.schedule(this.timeoutMillis, new StretchAgentCallSupervisor$$ExternalSyntheticLambda0(this, v3)));
                                this.invocationWorker.execute(new StretchAgentCallSupervisor$$ExternalSyntheticLambda1(this, v4, v3));
                                goto label_52;
                            }
                            catch(Exception v0_2) {
                                Exception v12_1 = v0_2;
                                try {
                                    this.completed(v3, null, ((Throwable)v12_1));
                                label_52:
                                    v12 = v3.getResult();
                                    goto label_53;
                                }
                                catch(Throwable v0) {
                                    goto label_72;
                                }
                            }
                        }
                    }

                    goto label_55;
                }
            }

            goto label_63;
        }
        catch(Throwable v0) {
            goto label_72;
        }

    label_53:
        __monitor_exit(this);
        return v12;
    label_55:
        v4 = arg12;
        try {
            v12 = CompletableFuture.completedFuture(this.failure(v4, StretchAgentCode.INVALID_REQUEST));
            Intrinsics.checkNotNullExpressionValue(v12, "completedFuture(...)");
        }
        catch(Throwable v0) {
            goto label_72;
        }

        __monitor_exit(this);
        return v12;
    label_63:
        v4 = arg12;
        try {
            v12 = CompletableFuture.completedFuture(this.failure(v4, StretchAgentCode.RECOVERY_PENDING));
            Intrinsics.checkNotNullExpressionValue(v12, "completedFuture(...)");
        }
        catch(Throwable v0) {
        label_72:
            Throwable v12_2 = v0;
            try {
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_72;
            }

            throw v12_2;
        }

        __monitor_exit(this);
        return v12;
    }

    static final Unit submit$lambda$2(StretchAgentCallSupervisor arg0, Work arg1) {
        arg0.expired(arg1);
        return Unit.INSTANCE;
    }

    static final void submit$lambda$5(StretchAgentCallSupervisor arg2, StretchAgentRequest arg3, Work arg4) {
        try {
            arg2.transport.invoke(arg3).whenComplete(new StretchAgentCallSupervisor$$ExternalSyntheticLambda5(new StretchAgentCallSupervisor$$ExternalSyntheticLambda4(arg2, arg4)));
            return;
        }
        catch(Exception v3) {
            arg2.completed(arg4, null, ((Throwable)v3));
            return;
        }
    }

    static final Unit submit$lambda$5$lambda$3(StretchAgentCallSupervisor arg0, Work arg1, StretchAgentReply arg2, Throwable arg3) {
        arg0.completed(arg1, arg2, arg3);
        return Unit.INSTANCE;
    }

    static final void submit$lambda$5$lambda$4(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }
}

