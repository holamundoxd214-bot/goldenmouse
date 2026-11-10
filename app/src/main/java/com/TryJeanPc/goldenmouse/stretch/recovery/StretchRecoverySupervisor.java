package com.TryJeanPc.goldenmouse.stretch.recovery;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 d2\u00060\u0001j\u0002`\u0002:\u0001dBO\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\f\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\'\u001A\u00020(H\u0002J \u0010)\u001A\u00020*2\n\b\u0002\u0010+\u001A\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001A\u0004\u0018\u00010!H\u0002J\u001C\u0010.\u001A\b\u0012\u0004\u0012\u00020*0/2\f\u00100\u001A\b\u0012\u0004\u0012\u00020*01H\u0002J\u0016\u00102\u001A\u00020(2\f\u00100\u001A\b\u0012\u0004\u0012\u00020(01H\u0002J\f\u00103\u001A\b\u0012\u0004\u0012\u00020*0/J\b\u00104\u001A\u00020(H\u0002J\u0010\u00105\u001A\u00020\u00162\u0006\u00106\u001A\u00020\u001AH\u0002J*\u00107\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u00108\u001A\u0002092\u0006\u0010:\u001A\u00020;2\f\u0010<\u001A\b\u0012\u0004\u0012\u00020>0=J\u0014\u0010?\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010@\u001A\u00020AJ\u0010\u0010-\u001A\u00020!2\u0006\u0010B\u001A\u00020\u001AH\u0002J\u001C\u0010C\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010@\u001A\u00020A2\u0006\u0010D\u001A\u00020>J\u0010\u0010E\u001A\u00020(2\u0006\u0010F\u001A\u00020!H\u0002J\u001C\u0010G\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010F\u001A\u00020!2\u0006\u0010H\u001A\u00020IJ\u0014\u0010J\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010K\u001A\u00020LJ\u0018\u0010M\u001A\u00020(2\u0006\u0010@\u001A\u00020A2\u0006\u0010N\u001A\u00020AH\u0002J\u001C\u0010O\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010@\u001A\u00020A2\u0006\u0010N\u001A\u00020AJ\u0014\u0010P\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010@\u001A\u00020AJ\u0014\u0010Q\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010@\u001A\u00020AJ\u0014\u0010R\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010S\u001A\u00020TJ\u001A\u0010U\u001A\u00020*2\b\u0010V\u001A\u0004\u0018\u00010,2\u0006\u0010W\u001A\u00020\u0016H\u0002J\u0010\u0010\"\u001A\u00020(2\u0006\u0010F\u001A\u00020!H\u0002J$\u0010X\u001A\u00020(2\u0006\u0010F\u001A\u00020!2\b\u0010Y\u001A\u0004\u0018\u00010Z2\b\u0010[\u001A\u0004\u0018\u00010\\H\u0002J\u0014\u0010]\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010^\u001A\u00020_J\u001C\u0010`\u001A\b\u0012\u0004\u0012\u00020*0/2\u0006\u0010@\u001A\u00020A2\u0006\u0010`\u001A\u00020aJ\f\u0010b\u001A\b\u0012\u0004\u0012\u00020*0/J\b\u0010c\u001A\u00020(H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010 \u001A\u0004\u0018\u00010!X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010$\u001A\u00020\u00148F¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006e"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySupervisor;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "store", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStore;", "executor", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryExecutor;", "clock", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;", "scheduler", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScheduler;", "confirmationWindowMillis", "", "operationTimeoutMillis", "actor", "Ljava/util/concurrent/Executor;", "invocationWorker", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStore;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryExecutor;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScheduler;JJLjava/util/concurrent/Executor;Ljava/util/concurrent/Executor;)V", "visible", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryView;", "closed", "", "initialized", "blocked", "record", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "confirmationTask", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryCancellation;", "operationTask", "applyDeadline", "restoreDeadline", "inFlight", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "restoreExpired", "externalStopRequired", "current", "getCurrent", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryView;", "publish", "", "reply", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryReply;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "ticket", "action", "Ljava/util/concurrent/CompletableFuture;", "block", "Lkotlin/Function0;", "post", "initialize", "load", "save", "candidate", "prepare", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "strategy", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;", "steps", "", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "requestRealApplication", "sessionId", "", "r", "intendStep", "step", "applyExpired", "t", "observeStep", "outcome", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepOutcome;", "awaitConfirmation", "proof", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryApplyVerification;", "confirmationExpired", "confirmationId", "confirm", "restore", "retryRollback", "emergency", "request", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryEmergencyRequest;", "rollback", "reason", "retry", "restored", "result", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;", "failure", "", "acknowledgeStopped", "ack", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStoppedAcknowledgement;", "signal", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoverySignal;", "closeAsync", "close", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoverySupervisor implements AutoCloseable {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001A\u00020\nH\u0002J\b\u0010\u000B\u001A\u00020\nH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySupervisor$Companion;", "", "<init>", "()V", "DEFAULT_CONFIRMATION_MILLIS", "", "DEFAULT_OPERATION_TIMEOUT_MILLIS", "MAX_RESTORE_ATTEMPTS", "", "serialWorker", "Ljava/util/concurrent/ThreadPoolExecutor;", "recoveryWorker", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final ThreadPoolExecutor access$recoveryWorker(Companion arg0) {
            return arg0.recoveryWorker();
        }

        public static final ThreadPoolExecutor access$serialWorker(Companion arg0) {
            return arg0.serialWorker();
        }

        private final ThreadPoolExecutor recoveryWorker() {
            return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new StretchRecoverySupervisor$Companion$$ExternalSyntheticLambda1());
        }

        static final Thread recoveryWorker$lambda$3(Runnable arg2) {
            Thread v0 = new Thread(arg2, "StretchSimulatedRestore");
            v0.setDaemon(true);
            return v0;
        }

        private final ThreadPoolExecutor serialWorker() {
            return new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(0x20), new StretchRecoverySupervisor$Companion$$ExternalSyntheticLambda0());
        }

        static final Thread serialWorker$lambda$1(Runnable arg2) {
            Thread v0 = new Thread(arg2, "StretchRecoveryJournal");
            v0.setDaemon(true);
            return v0;
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchRestoreStatus.values().length];
            try {
                v0[StretchRestoreStatus.BACKEND_ERROR.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchRestoreStatus.PERMISSION_LOST.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchRestoreStatus.DISPLAY_MISMATCH.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchRestoreStatus.UNKNOWN_BASELINE.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[StretchRestoreStatus.TIMEOUT.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[StretchRestoreStatus.PARTIAL.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                label_27:
                                    WhenMappings.$EnumSwitchMapping$0 = v0;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final long DEFAULT_CONFIRMATION_MILLIS = 15000;
    public static final long DEFAULT_OPERATION_TIMEOUT_MILLIS = 2500;
    public static final int MAX_RESTORE_ATTEMPTS = 2;
    private final Executor actor;
    private long applyDeadline;
    private boolean blocked;
    private final RecoveryClock clock;
    private volatile boolean closed;
    private RecoveryCancellation confirmationTask;
    private final long confirmationWindowMillis;
    private final StretchRecoveryExecutor executor;
    private boolean externalStopRequired;
    private RecoveryTicket inFlight;
    private boolean initialized;
    private final Executor invocationWorker;
    private RecoveryCancellation operationTask;
    private final long operationTimeoutMillis;
    private StretchRecoveryRecord record;
    private long restoreDeadline;
    private boolean restoreExpired;
    private final RecoveryScheduler scheduler;
    private final StretchRecoveryStore store;
    private volatile RecoveryView visible;

    static {
        StretchRecoverySupervisor.Companion = new Companion(null);
        StretchRecoverySupervisor.$stable = 8;
    }

    public StretchRecoverySupervisor(StretchRecoveryStore arg2, StretchRecoveryExecutor arg3, RecoveryClock arg4, RecoveryScheduler arg5, long arg6, long arg8, Executor arg10, Executor arg11) {
        Intrinsics.checkNotNullParameter(arg2, "store");
        Intrinsics.checkNotNullParameter(arg3, "executor");
        Intrinsics.checkNotNullParameter(arg4, "clock");
        Intrinsics.checkNotNullParameter(arg5, "scheduler");
        Intrinsics.checkNotNullParameter(arg10, "actor");
        Intrinsics.checkNotNullParameter(arg11, "invocationWorker");
        super();
        this.store = arg2;
        this.executor = arg3;
        this.clock = arg4;
        this.scheduler = arg5;
        this.confirmationWindowMillis = arg6;
        this.operationTimeoutMillis = arg8;
        this.actor = arg10;
        this.invocationWorker = arg11;
        long v4 = 1;
        if(v4 <= arg6) {
            long v10 = 60001;
            if(arg6 < v10 && v4 <= arg8 && arg8 < v10 && arg3.getScope() == RecoveryScope.SIMULATION_ONLY) {
                this.visible = new RecoveryView(RecoveryPhase.IDLE, null, null, 4, null);
                return;
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public StretchRecoverySupervisor(StretchRecoveryStore arg15, StretchRecoveryExecutor arg16, RecoveryClock arg17, RecoveryScheduler arg18, long arg19, long arg21, Executor arg23, Executor arg24, int arg25, DefaultConstructorMarker arg26) {
        Executor v13_1;
        Executor v12_1;
        int v0 = arg25;
        long v8 = (v0 & 16) != 0 ? 15000 : arg19;
        long v10 = (v0 & 0x20) != 0 ? 2500 : arg21;
        if((v0 & 0x40) != 0) {
            ThreadPoolExecutor v12 = Companion.access$serialWorker(StretchRecoverySupervisor.Companion);
        }
        else {
            v12_1 = arg23;
        }

        if((v0 & 0x80) != 0) {
            ThreadPoolExecutor v13 = Companion.access$recoveryWorker(StretchRecoverySupervisor.Companion);
        }
        else {
            v13_1 = arg24;
        }

        this(arg15, arg16, arg17, arg18, v8, v10, v12_1, v13_1);
    }

    public final CompletableFuture acknowledgeStopped(RecoveryStoppedAcknowledgement arg2) {
        Intrinsics.checkNotNullParameter(arg2, "ack");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda22(this, arg2));
    }

    static final RecoveryReply acknowledgeStopped$lambda$35(StretchRecoverySupervisor arg18, RecoveryStoppedAcknowledgement arg19) {
        StretchRecoverySupervisor v0 = arg18;
        StretchRecoveryRecord v1 = v0.record;
        int v2 = 2;
        RecoveryTicket v3 = null;
        if(v1 == null) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v3, v2, v3);
        }

        if((Intrinsics.areEqual(v0.inFlight, arg19.getTicket())) && v1.getPhase() == RecoveryPhase.RECOVERY_PENDING) {
            Object v4 = CollectionsKt.lastOrNull(v1.getRestores());
            if(v4 != null) {
                StretchRestoreRequest v4_1 = ((RecoveryRestoreAttempt)v4).getRequest();
                if(v4_1 != null) {
                    RecoveryTicket v4_2 = v4_1.getTicket();
                }
                else {
                    goto label_22;
                }
            }
            else {
            label_22:
                v4 = v3;
            }

            if(!Intrinsics.areEqual(v4, arg19.getTicket())) {
                goto label_94;
            }

            if(!v0.externalStopRequired) {
                return StretchRecoverySupervisor.reply$default(v0, RecoveryError.EXECUTOR_STILL_ACTIVE, v3, v2, v3);
            }

            v4 = CollectionsKt.last(v1.getRestores());
            StretchRestoreResult v5 = ((RecoveryRestoreAttempt)v4).getResult();
            if(v5 != null) {
                v5 = StretchRestoreResult.copy$default(v5, null, null, null, null, true, 15, null);
                if(v5 == null) {
                    goto label_45;
                }
            }
            else {
            label_45:
                v5 = new StretchRestoreResult(arg19.getTicket(), StretchRestoreStatus.PENDING, CollectionsKt.emptyList(), null, true);
            }

            if(!v0.save(StretchRecoveryRecord.copy$default(v1, 0, null, null, null, null, null, null, null, CollectionsKt.plus(CollectionsKt.dropLast(v1.getRestores(), 1), RecoveryRestoreAttempt.copy$default(((RecoveryRestoreAttempt)v4), ((StretchRestoreRequest)v3), v5, 1, v3)), null, null, 0x6FF, null))) {
                return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, null, 2, null);
            }

            v0.inFlight = null;
            return StretchRecoverySupervisor.reply$default(v0, null, null, 3, null);
        }

    label_94:
        return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v3, v2, v3);
    }

    private final CompletableFuture action(Function0 arg6) {
        CompletableFuture v0 = new CompletableFuture();
        int v2 = 2;
        RecoveryTicket v3 = null;
        if(this.closed) {
            CompletableFuture v5 = CompletableFuture.completedFuture(StretchRecoverySupervisor.reply$default(this, RecoveryError.CLOSED, v3, v2, v3));
            Intrinsics.checkNotNullExpressionValue(v5, "completedFuture(...)");
            return v5;
        }

        try {
            this.actor.execute(new StretchRecoverySupervisor$$ExternalSyntheticLambda16(this, v0, arg6));
            return v0;
        }
        catch(RejectedExecutionException ) {
            RecoveryError v6 = this.closed ? RecoveryError.CLOSED : RecoveryError.SESSION_BUSY;
            v0.complete(StretchRecoverySupervisor.reply$default(this, v6, v3, v2, v3));
            return v0;
        }
    }

    static final void action$lambda$0(StretchRecoverySupervisor arg5, CompletableFuture arg6, Function0 arg7) {
        RecoveryReply v7_1;
        int v1 = 2;
        RecoveryTicket v2 = null;
        if(arg5.closed) {
            arg6.complete(StretchRecoverySupervisor.reply$default(arg5, RecoveryError.CLOSED, v2, v1, v2));
            return;
        }

        try {
            if(!arg5.initialized) {
                arg5.load();
            }

            if(arg5.blocked) {
                RecoveryError v7 = arg5.visible.getError();
                if(v7 == null) {
                    v7 = RecoveryError.JOURNAL_WRITE_FAILED;
                }

                v7_1 = StretchRecoverySupervisor.reply$default(arg5, v7, v2, v1, v2);
            }
            else {
                Object v7_2 = arg7.invoke();
            }

            arg6.complete(v7_1);
            return;
        }
        catch(Exception ) {
            arg5.blocked = true;
            arg5.visible = new RecoveryView(RecoveryPhase.RECOVERY_PENDING, arg5.record, RecoveryError.JOURNAL_WRITE_FAILED);
            arg6.complete(StretchRecoverySupervisor.reply$default(arg5, RecoveryError.JOURNAL_WRITE_FAILED, v2, v1, v2));
            return;
        }
    }

    private final void applyExpired(RecoveryTicket arg20) {
        StretchRecoverySupervisor v0 = this;
        RecoveryTicket v1 = arg20;
        StretchRecoveryRecord v2 = v0.record;
        if(v2 == null) {
        }
        else if(v2.getPhase() == RecoveryPhase.APPLYING) {
            Object v3 = CollectionsKt.lastOrNull(v2.getSteps());
            if(v3 != null) {
                RecoveryTicket v3_1 = ((RecoveryStepRecord)v3).getTicket();
            }
            else {
                v3 = null;
            }

            if(!Intrinsics.areEqual(v3, v1)) {
                return;
            }

            long v3_2 = v0.clock.elapsedRealtimeMillis();
            long v5 = v0.applyDeadline;
            if(v3_2 < v5) {
                v0.operationTask = v0.scheduler.schedule(v5 - v0.clock.elapsedRealtimeMillis(), new StretchRecoverySupervisor$$ExternalSyntheticLambda1(v0, v1));
                return;
            }

            if(!v0.save(StretchRecoveryRecord.copy$default(v2, 0, null, null, null, RecoveryPhase.RECOVERY_PENDING, CollectionsKt.plus(CollectionsKt.dropLast(v2.getSteps(), 1), RecoveryStepRecord.copy$default(CollectionsKt.last(v2.getSteps()), null, null, RecoveryStepOutcome.UNKNOWN, 3, null)), null, null, null, RecoveryError.OPERATION_TIMEOUT, null, 0x5CF, null))) {
                return;
            }

            v0.rollback(RecoveryError.OPERATION_TIMEOUT, false);
        }
    }

    static final Unit applyExpired$lambda$11(StretchRecoverySupervisor arg1, RecoveryTicket arg2) {
        arg1.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda8(arg1, arg2));
        return Unit.INSTANCE;
    }

    static final Unit applyExpired$lambda$11$lambda$10(StretchRecoverySupervisor arg0, RecoveryTicket arg1) {
        arg0.applyExpired(arg1);
        return Unit.INSTANCE;
    }

    public final CompletableFuture awaitConfirmation(RecoveryApplyVerification arg2) {
        Intrinsics.checkNotNullParameter(arg2, "proof");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda0(this, arg2));
    }

    static final RecoveryReply awaitConfirmation$lambda$18(StretchRecoverySupervisor arg18, RecoveryApplyVerification arg19) {
        StretchRecoverySupervisor v0 = arg18;
        StretchRecoveryRecord v1 = v0.record;
        int v2 = 2;
        RecoveryTicket v3 = null;
        if(v1 == null) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.INVALID_TRANSITION, v3, v2, v3);
        }

        if((Intrinsics.areEqual(arg19.getSessionId(), v1.getSnapshot().getSessionId())) && (Intrinsics.areEqual(arg19.getSnapshotDigest(), StretchRecoveryCodec.INSTANCE.snapshotDigest(v1.getSnapshot())))) {
            Object v4 = v1.getSnapshot().getOriginal().getLogicalIdentity().getValue();
            if(v4 != null && arg19.getLogicalDisplayId() == ((StretchDisplayIdentity)v4).getLogicalId() && (Intrinsics.areEqual(arg19.getPhysicalIdentity(), v1.getSnapshot().getOriginal().getPhysicalIdentity().getValue()))) {
                List v4_1 = arg19.getVerifiedOperations();
                List v5 = v1.getSteps();
                int v7 = 10;
                ArrayList v6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v5), v7));
                Iterator v5_1 = ((Iterable)v5).iterator();
                while(v5_1.hasNext()) {
                    ((Collection)v6).add(v5_1.next().getTicket().getOperationId());
                }

                if(!Intrinsics.areEqual(v4_1, v6)) {
                }
                else {
                    if(v1.getPhase() == RecoveryPhase.VERIFYING) {
                        v4_1 = v1.getSteps();
                        ArrayList v5_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4_1), v7));
                        Iterator v4_2 = ((Iterable)v4_1).iterator();
                        while(v4_2.hasNext()) {
                            ((Collection)v5_2).add(v4_2.next().getStep());
                        }

                        if(Intrinsics.areEqual(v5_2, v1.getIntendedSteps())) {
                            v4_1 = v1.getSteps();
                            if(!(v4_1 instanceof Collection) || !v4_1.isEmpty()) {
                                v4_2 = ((Iterable)v4_1).iterator();
                                do {
                                    if(v4_2.hasNext()) {
                                        if(v4_2.next().getOutcome() == RecoveryStepOutcome.VERIFIED) {
                                            continue;
                                        }

                                        break;
                                    }

                                    goto label_83;
                                }
                                while(true);

                                goto label_134;
                            }
                            else {
                            }

                        label_83:
                            long v7_1 = v0.clock.elapsedRealtimeMillis();
                            String v6_1 = UUID.randomUUID().toString();
                            Intrinsics.checkNotNullExpressionValue(v6_1, "toString(...)");
                            RecoveryConfirmation v9 = new RecoveryConfirmation(v6_1, v7_1, Math.addExact(v7_1, v0.confirmationWindowMillis));
                            RecoveryConfirmation v5_3 = v9;
                            if(!v0.save(StretchRecoveryRecord.copy$default(v1, 0, null, null, null, RecoveryPhase.AWAITING_CONFIRMATION, null, v9, null, null, null, null, 0x7AF, null))) {
                                return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, null, 2, null);
                            }

                            v0.confirmationTask = v0.scheduler.schedule(v0.confirmationWindowMillis, new StretchRecoverySupervisor$$ExternalSyntheticLambda20(v0, v1, v5_3));
                            return StretchRecoverySupervisor.reply$default(v0, null, null, 3, null);
                        }
                    }

                label_134:
                    return StretchRecoverySupervisor.reply$default(v0, RecoveryError.INVALID_TRANSITION, v3, v2, v3);
                }
            }
        }

        return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v3, v2, v3);
    }

    static final Unit awaitConfirmation$lambda$18$lambda$17(StretchRecoverySupervisor arg1, StretchRecoveryRecord arg2, RecoveryConfirmation arg3) {
        arg1.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda2(arg1, arg2, arg3));
        return Unit.INSTANCE;
    }

    static final Unit awaitConfirmation$lambda$18$lambda$17$lambda$16(StretchRecoverySupervisor arg0, StretchRecoveryRecord arg1, RecoveryConfirmation arg2) {
        arg0.confirmationExpired(arg1.getSnapshot().getSessionId(), arg2.getId());
        return Unit.INSTANCE;
    }

    public void close() {
        this.closeAsync();
    }

    public final CompletableFuture closeAsync() {
        CompletableFuture v0 = new CompletableFuture();
        RecoveryError v2 = null;
        if(this.closed) {
            CompletableFuture v4 = CompletableFuture.completedFuture(StretchRecoverySupervisor.reply$default(this, v2, ((RecoveryTicket)v2), 3, v2));
            Intrinsics.checkNotNullExpressionValue(v4, "completedFuture(...)");
            return v4;
        }

        try {
            this.actor.execute(new StretchRecoverySupervisor$$ExternalSyntheticLambda3(this, v0));
            return v0;
        }
        catch(RejectedExecutionException ) {
            v0.complete(StretchRecoverySupervisor.reply$default(this, RecoveryError.CLOSED, ((RecoveryTicket)v2), 2, v2));
            return v0;
        }
    }

    static final void closeAsync$lambda$40(StretchRecoverySupervisor arg18, CompletableFuture arg19) {
        Object v0_3;
        StretchRecoverySupervisor v1 = arg18;
        RecoveryCancellation v0 = v1.confirmationTask;
        if(v0 != null) {
            v0.cancel();
        }

        v0 = v1.operationTask;
        if(v0 != null) {
            v0.cancel();
        }

        if(!v1.blocked) {
            StretchRecoveryRecord v0_1 = v1.record;
            if(v0_1 != null && !v0_1.getSteps().isEmpty() && v0_1.getPhase() != RecoveryPhase.RECOVERED) {
                StretchRecoveryRecord v3 = v1.record;
                Intrinsics.checkNotNull(v3);
                v1.save(StretchRecoveryRecord.copy$default(v3, 0, null, null, null, RecoveryPhase.RECOVERY_PENDING, null, null, null, null, RecoveryError.OWNER_CLOSED, null, 0x5EF, null));
            }
        }

        v1.closed = true;
        try {
            v1.store.close();
            v0_3 = Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v0_2) {
            v0_3 = Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        boolean v2 = Result.isSuccess-impl(v0_3);
        try {
            v1.scheduler.close();
            v0_3 = Result.constructor-impl(Unit.INSTANCE);
        }
        catch(Throwable v0_2) {
            v0_3 = Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        boolean v0_4 = Result.isSuccess-impl(v0_3);
        Executor v3_1 = v1.invocationWorker;
        RecoveryTicket v5 = null;
        if((v3_1 instanceof ExecutorService)) {
        }
        else {
            v3_1 = ((Executor)v5);
        }

        if(v3_1 != null) {
            ((ExecutorService)v3_1).shutdownNow();
        }

        RecoveryError v0_5 = !v2 || !v0_4 ? RecoveryError.JOURNAL_WRITE_FAILED : ((RecoveryError)v5);
        arg19.complete(StretchRecoverySupervisor.reply$default(v1, v0_5, v5, 2, v5));
        Executor v0_6 = v1.actor;
        if((v0_6 instanceof ExecutorService)) {
            Executor v5_1 = v0_6;
        }

        if((((Executor)v5)) != null) {
            ((ExecutorService)v5).shutdown();
        }
    }

    public final CompletableFuture confirm(String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        Intrinsics.checkNotNullParameter(arg3, "confirmationId");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda15(this, arg2, arg3));
    }

    static final RecoveryReply confirm$lambda$21(StretchRecoverySupervisor arg18, String arg19, String arg20) {
        StretchRecoverySupervisor v0 = arg18;
        StretchRecoveryRecord v1 = v0.record;
        int v2 = 2;
        RecoveryTicket v3 = null;
        if(v1 == null) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v3, v2, v3);
        }

        RecoveryConfirmation v4 = v1.getConfirmation();
        if((Intrinsics.areEqual(v1.getSnapshot().getSessionId(), arg19)) && v1.getPhase() == RecoveryPhase.AWAITING_CONFIRMATION) {
            if(v4 != null) {
                String v5 = v4.getId();
            }
            else {
                Object v5_1 = v3;
            }

            if(!Intrinsics.areEqual(v5, arg20)) {
                goto label_78;
            }

            long v5_2 = v0.clock.elapsedRealtimeMillis();
            if(v5_2 < v4.getExpiresElapsedMillis()) {
                if(v5_2 < v4.getStartedElapsedMillis()) {
                }
                else if(!v0.save(StretchRecoveryRecord.copy$default(v1, 0, null, null, null, RecoveryPhase.CONFIRMED, null, null, Long.valueOf(v5_2), null, null, null, 0x76F, null))) {
                    return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, null, 2, null);
                }
                else {
                    RecoveryError v13 = null;
                    RecoveryCancellation v1_1 = v0.confirmationTask;
                    if(v1_1 != null) {
                        v1_1.cancel();
                    }

                    return StretchRecoverySupervisor.reply$default(v0, v13, ((RecoveryTicket)v13), 3, v13);
                }
            }

            v0.rollback(RecoveryError.CONFIRMATION_EXPIRED, false);
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.CONFIRMATION_EXPIRED, v3, v2, v3);
        }

    label_78:
        return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v3, v2, v3);
    }

    private final void confirmationExpired(String arg7, String arg8) {
        StretchRecoveryRecord v0 = this.record;
        if(v0 == null) {
        }
        else {
            RecoveryConfirmation v1 = v0.getConfirmation();
            if(v1 == null) {
            }
            else if((Intrinsics.areEqual(v0.getSnapshot().getSessionId(), arg7)) && v0.getPhase() == RecoveryPhase.AWAITING_CONFIRMATION) {
                if(!Intrinsics.areEqual(v1.getId(), arg8)) {
                }
                else {
                    long v2 = this.clock.elapsedRealtimeMillis();
                    if(v2 < v1.getExpiresElapsedMillis()) {
                        if(v2 < v1.getStartedElapsedMillis()) {
                        }
                        else {
                            this.confirmationTask = this.scheduler.schedule(v1.getExpiresElapsedMillis() - v2, new StretchRecoverySupervisor$$ExternalSyntheticLambda24(this, arg7, arg8));
                            return;
                        }
                    }

                    this.rollback(RecoveryError.CONFIRMATION_EXPIRED, false);
                }
            }
        }
    }

    static final Unit confirmationExpired$lambda$20(StretchRecoverySupervisor arg1, String arg2, String arg3) {
        arg1.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda11(arg1, arg2, arg3));
        return Unit.INSTANCE;
    }

    static final Unit confirmationExpired$lambda$20$lambda$19(StretchRecoverySupervisor arg0, String arg1, String arg2) {
        arg0.confirmationExpired(arg1, arg2);
        return Unit.INSTANCE;
    }

    public final CompletableFuture emergency(RecoveryEmergencyRequest arg2) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda30(this, arg2));
    }

    static final RecoveryReply emergency$lambda$24(StretchRecoverySupervisor arg7, RecoveryEmergencyRequest arg8) {
        StretchRecoveryRecord v0 = arg7.record;
        int v1 = 2;
        RecoveryTicket v2 = null;
        if(v0 == null) {
            return StretchRecoverySupervisor.reply$default(arg7, RecoveryError.STALE_OPERATION, v2, v1, v2);
        }

        if((Intrinsics.areEqual(arg8.getSessionId(), v0.getSnapshot().getSessionId())) && arg8.getExpectedRevision() == v0.getRevision() && (Intrinsics.areEqual(arg8.getSnapshotDigest(), StretchRecoveryCodec.INSTANCE.snapshotDigest(v0.getSnapshot())))) {
            if(!Intrinsics.areEqual(arg8.getPhysicalIdentity(), v0.getSnapshot().getOriginal().getPhysicalIdentity().getValue())) {
            }
            else {
                return arg7.rollback(((RecoveryError)v2), false);
            }
        }

        return StretchRecoverySupervisor.reply$default(arg7, RecoveryError.STALE_OPERATION, v2, v1, v2);
    }

    public final RecoveryView getCurrent() {
        return this.visible;
    }

    public final CompletableFuture initialize() {
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda4(this));
    }

    static final RecoveryReply initialize$lambda$2(StretchRecoverySupervisor arg2) {
        return StretchRecoverySupervisor.reply$default(arg2, null, null, 3, null);
    }

    public final CompletableFuture intendStep(String arg2, RecoveryStep arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        Intrinsics.checkNotNullParameter(arg3, "step");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda21(this, arg2, arg3));
    }

    static final RecoveryReply intendStep$lambda$9(StretchRecoverySupervisor arg25, String arg26, RecoveryStep arg27) {
        StretchRecoverySupervisor v0 = arg25;
        RecoveryStep v1 = arg27;
        StretchRecoveryRecord v2 = v0.record;
        int v3 = 2;
        RecoveryTicket v4 = null;
        if(v2 == null) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.INVALID_TRANSITION, v4, v3, v4);
        }

        if(!Intrinsics.areEqual(v2.getSnapshot().getSessionId(), arg26)) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v4, v3, v4);
        }

        RecoveryPhase[] v5 = new RecoveryPhase[v3];
        v5[0] = RecoveryPhase.RECOVERY_READY;
        v5[1] = RecoveryPhase.VERIFYING;
        if(SetsKt.setOf(((Object[])v5)).contains(v2.getPhase())) {
            List v5_1 = v2.getSteps();
            if(!(v5_1 instanceof Collection) || !v5_1.isEmpty()) {
                Iterator v5_2 = ((Iterable)v5_1).iterator();
                do {
                    if(v5_2.hasNext()) {
                        if(v5_2.next().getOutcome() == RecoveryStepOutcome.VERIFIED) {
                            continue;
                        }

                        break;
                    }

                    goto label_43;
                }
                while(true);

                goto label_109;
            }
            else {
            }

        label_43:
            if(CollectionsKt.getOrNull(v2.getIntendedSteps(), v2.getSteps().size()) != v1) {
                goto label_109;
            }

            RecoveryTicket v5_3 = v0.ticket(v2);
            long v23 = Math.addExact(v0.clock.elapsedRealtimeMillis(), v0.operationTimeoutMillis);
            RecoveryTicket v22 = v5_3;
            if(!v0.save(StretchRecoveryRecord.copy$default(v2, 0, null, null, null, RecoveryPhase.APPLYING, CollectionsKt.plus(v2.getSteps(), new RecoveryStepRecord(v1, v5_3, RecoveryStepOutcome.REQUESTED)), null, null, null, null, null, 0x7CF, null))) {
                return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, null, 2, null);
            }

            RecoveryError v12 = null;
            v0.applyDeadline = v23;
            RecoveryCancellation v1_1 = v0.operationTask;
            if(v1_1 != null) {
                v1_1.cancel();
            }

            v0.operationTask = v0.scheduler.schedule(v0.operationTimeoutMillis, new StretchRecoverySupervisor$$ExternalSyntheticLambda23(v0, v22));
            return StretchRecoverySupervisor.reply$default(v0, v12, v22, 1, v12);
        }

    label_109:
        return StretchRecoverySupervisor.reply$default(v0, RecoveryError.INVALID_TRANSITION, v4, v3, v4);
    }

    static final Unit intendStep$lambda$9$lambda$8(StretchRecoverySupervisor arg1, RecoveryTicket arg2) {
        arg1.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda19(arg1, arg2));
        return Unit.INSTANCE;
    }

    static final Unit intendStep$lambda$9$lambda$8$lambda$7(StretchRecoverySupervisor arg0, RecoveryTicket arg1) {
        arg0.applyExpired(arg1);
        return Unit.INSTANCE;
    }

    private final void load() {
        StretchRecoverySupervisor v0 = this;
        boolean v1 = true;
        v0.initialized = true;
        RecoveryJournalRead v2 = v0.store.load();
        if(Intrinsics.areEqual(v2, Missing.INSTANCE)) {
            v0.visible = new RecoveryView(RecoveryPhase.IDLE, null, null, 4, null);
            return;
        }

        StretchRecoveryRecord v4 = null;
        if((v2 instanceof Blocked)) {
            v0.blocked = true;
            v0.visible = new RecoveryView(RecoveryPhase.RECOVERY_PENDING, v4, ((Blocked)v2).getError());
            return;
        }

        if((v2 instanceof Present)) {
            v0.record = ((Present)v2).getRecord();
            v0.publish();
            StretchRecoveryRecord v5 = ((Present)v2).getRecord();
            if((v5.getSteps().isEmpty()) || v5.getPhase() == RecoveryPhase.RECOVERED) {
                if(!SetsKt.setOf(new RecoveryPhase[]{RecoveryPhase.PREPARING, RecoveryPhase.BASELINE_CAPTURED, RecoveryPhase.RECOVERY_READY}).contains(v5.getPhase())) {
                    return;
                }

                v0.save(StretchRecoveryRecord.copy$default(v5, 0, null, null, null, RecoveryPhase.FAILED, null, null, null, null, RecoveryError.PROCESS_RESTART, null, 0x5EF, null));
            }
            else {
                Object v2_1 = CollectionsKt.lastOrNull(v5.getRestores());
                if(v2_1 != null) {
                    StretchRestoreResult v6 = ((RecoveryRestoreAttempt)v2_1).getResult();
                    int v6_1 = v6 == null || !v6.getExecutionStopped() ? 0 : 1;
                    if(v6_1 == 0) {
                    }
                    else {
                        v2_1 = v4;
                    }

                    if(v2_1 == null) {
                        goto label_57;
                    }

                    StretchRestoreRequest v2_2 = ((RecoveryRestoreAttempt)v2_1).getRequest();
                    if(v2_2 == null) {
                        goto label_57;
                    }

                    RecoveryTicket v4_1 = v2_2.getTicket();
                }

            label_57:
                v0.inFlight = ((RecoveryTicket)v4);
                if((((RecoveryTicket)v4)) != null) {
                }
                else {
                    v1 = false;
                }

                v0.externalStopRequired = v1;
                if(!v0.save(StretchRecoveryRecord.copy$default(v5, 0, null, null, null, RecoveryPhase.RECOVERY_PENDING, null, null, null, null, RecoveryError.PROCESS_RESTART, null, 0x5EF, null))) {
                    return;
                }

                if(!v5.getRestores().isEmpty()) {
                    return;
                }

                v0.rollback(RecoveryError.PROCESS_RESTART, false);
                return;
            }

            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    public final CompletableFuture observeStep(RecoveryTicket arg2, RecoveryStepOutcome arg3) {
        Intrinsics.checkNotNullParameter(arg2, "t");
        Intrinsics.checkNotNullParameter(arg3, "outcome");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda17(this, arg2, arg3));
    }

    static final RecoveryReply observeStep$lambda$12(StretchRecoverySupervisor arg20, RecoveryTicket arg21, RecoveryStepOutcome arg22) {
        StretchRecoverySupervisor v0 = arg20;
        RecoveryStepOutcome v4 = arg22;
        StretchRecoveryRecord v7 = v0.record;
        int v8 = 2;
        RecoveryTicket v9 = null;
        if(v7 == null) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v9, v8, v9);
        }

        if(v7.getPhase() == RecoveryPhase.APPLYING) {
            Object v1 = CollectionsKt.lastOrNull(v7.getSteps());
            if(v1 != null) {
                RecoveryTicket v1_1 = ((RecoveryStepRecord)v1).getTicket();
            }
            else {
                v1 = v9;
            }

            if(!Intrinsics.areEqual(v1_1, arg21)) {
                goto label_95;
            }

            if(v4 == RecoveryStepOutcome.REQUESTED) {
                goto label_95;
            }

            if(v0.clock.elapsedRealtimeMillis() >= v0.applyDeadline) {
                arg20.applyExpired(arg21);
                return StretchRecoverySupervisor.reply$default(v0, RecoveryError.OPERATION_TIMEOUT, v9, v8, v9);
            }

            RecoveryCancellation v1_2 = v0.operationTask;
            if(v1_2 != null) {
                v1_2.cancel();
            }

            int v16 = v4 == RecoveryStepOutcome.VERIFIED ? 1 : 0;
            RecoveryPhase v1_3 = v16 != 0 ? RecoveryPhase.VERIFYING : RecoveryPhase.RECOVERY_PENDING;
            RecoveryPhase v11 = v1_3;
            RecoveryError v12 = v16 != 0 ? ((RecoveryError)v9) : RecoveryError.APPLY_UNCERTAIN;
            if(!v0.save(StretchRecoveryRecord.copy$default(v7, 0, null, null, null, v11, CollectionsKt.plus(CollectionsKt.dropLast(v7.getSteps(), 1), RecoveryStepRecord.copy$default(CollectionsKt.last(v7.getSteps()), null, null, v4, 3, null)), null, null, null, v12, null, 0x5CF, null))) {
                return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, null, 2, null);
            }

            RecoveryError v13 = null;
            if(v16 == 0) {
                v0.rollback(RecoveryError.APPLY_UNCERTAIN, false);
            }

            return StretchRecoverySupervisor.reply$default(v0, v13, ((RecoveryTicket)v13), 3, v13);
        }

    label_95:
        return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v9, v8, v9);
    }

    private final void post(Function0 arg4) {
        if(!this.closed) {
            try {
                this.actor.execute(new StretchRecoverySupervisor$$ExternalSyntheticLambda31(this, arg4));
                return;
            }
            catch(RejectedExecutionException ) {
                if(this.closed) {
                    return;
                }

                this.blocked = true;
                this.visible = new RecoveryView(RecoveryPhase.RECOVERY_PENDING, this.record, RecoveryError.SESSION_BUSY);
            }
        }
    }

    static final void post$lambda$1(StretchRecoverySupervisor arg3, Function0 arg4) {
        if(!arg3.closed && !arg3.blocked) {
            try {
                arg4.invoke();
                return;
            }
            catch(Exception ) {
                arg3.blocked = true;
                arg3.visible = new RecoveryView(RecoveryPhase.RECOVERY_PENDING, arg3.record, RecoveryError.JOURNAL_WRITE_FAILED);
            }
        }
    }

    public final CompletableFuture prepare(StretchRecoverySnapshot arg2, StretchRecoveryStrategy arg3, List arg4) {
        Intrinsics.checkNotNullParameter(arg2, "snapshot");
        Intrinsics.checkNotNullParameter(arg3, "strategy");
        Intrinsics.checkNotNullParameter(arg4, "steps");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda5(this, arg2, arg3, arg4));
    }

    static final RecoveryReply prepare$lambda$4(StretchRecoverySupervisor arg20, StretchRecoverySnapshot arg21, StretchRecoveryStrategy arg22, List arg23) {
        RecoveryError v1_2;
        StretchRecoverySupervisor v0 = arg20;
        List v1 = arg23;
        StretchRecoveryRecord v2 = v0.record;
        int v3 = 2;
        RecoveryTicket v4 = null;
        if(v2 != null && v2.getPhase() != RecoveryPhase.RECOVERED) {
            RecoveryPhase[] v5 = new RecoveryPhase[v3];
            v5[0] = RecoveryPhase.FAILED;
            v5[1] = RecoveryPhase.NOT_RECOVERABLE;
            if((SetsKt.setOf(((Object[])v5)).contains(v2.getPhase())) && (v2.getSteps().isEmpty())) {
                goto label_26;
            }

            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.SESSION_BUSY, v4, v3, v4);
        }

    label_26:
        if(v2 != null) {
            StretchRecoverySnapshot v5_1 = v2.getSnapshot();
            if(v5_1 != null) {
                String v5_2 = v5_1.getSessionId();
            }
            else {
                goto label_31;
            }
        }
        else {
        label_31:
            Object v5_3 = v4;
        }

        if(Intrinsics.areEqual(v5_2, arg21.getSessionId())) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v4, v3, v4);
        }

        long v6 = v2 != null ? v2.getRevision() : 0;
        if(v0.save(new StretchRecoveryRecord(v6, arg21, StretchRecoveryStrategy.copy$default(arg22, null, null, null, CollectionsKt.toList(arg22.getSupportedSteps()), false, null, 55, null), CollectionsKt.toList(v1), RecoveryPhase.PREPARING, null, null, null, null, null, null, 0x7E0, null))) {
            StretchRecoveryRecord v5_4 = v0.record;
            Intrinsics.checkNotNull(v5_4);
            if(!v0.save(StretchRecoveryRecord.copy$default(v5_4, 0, null, null, null, RecoveryPhase.BASELINE_CAPTURED, null, null, null, null, null, null, 0x7EF, null))) {
            }
            else {
                boolean v1_1 = new StretchRecoveryValidator().validate(arg21, arg22, v1) instanceof SimulationReady;
                v5_4 = v0.record;
                Intrinsics.checkNotNull(v5_4);
                RecoveryPhase v2_1 = v1_1 ? RecoveryPhase.RECOVERY_READY : RecoveryPhase.NOT_RECOVERABLE;
                RecoveryPhase v11 = v2_1;
                RecoveryError v16 = v1_1 ? ((RecoveryError)v4) : RecoveryError.NOT_RECOVERABLE;
                if(!v0.save(StretchRecoveryRecord.copy$default(v5_4, 0, null, null, null, v11, null, null, null, null, v16, null, 0x5EF, null))) {
                    return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, v4, v3, v4);
                }

                v1_2 = v1_1 ? ((RecoveryError)v4) : RecoveryError.NOT_RECOVERABLE;
                return StretchRecoverySupervisor.reply$default(v0, v1_2, v4, v3, v4);
            }
        }

        v1_2 = v0.visible.getError();
        if(v1_2 == null) {
            v1_2 = RecoveryError.INVALID_REQUEST;
        }

        return StretchRecoverySupervisor.reply$default(v0, v1_2, v4, v3, v4);
    }

    private final void publish() {
        RecoveryError v3;
        RecoveryPhase v1_1;
        StretchRecoveryRecord v1 = this.record;
        if(v1 != null) {
            v1_1 = v1.getPhase();
            if(v1_1 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            v1_1 = this.visible.getPhase();
        }

        StretchRecoveryRecord v2 = this.record;
        if(v2 == null) {
            v3 = this.visible.getError();
        }
        else if(v2 != null) {
            v3 = v2.getError();
        }
        else {
            v3 = null;
        }

        this.visible = new RecoveryView(v1_1, v2, v3);
    }

    private final RecoveryReply reply(RecoveryError arg3, RecoveryTicket arg4) {
        boolean v1 = arg3 == null ? true : false;
        return new RecoveryReply(v1, this.visible, arg3, arg4);
    }

    static RecoveryReply reply$default(StretchRecoverySupervisor arg1, RecoveryError arg2, RecoveryTicket arg3, int arg4, Object arg5) {
        RecoveryError v0 = null;
        if((arg4 & 1) != 0) {
            arg2 = v0;
        }

        if((arg4 & 2) != 0) {
            arg3 = ((RecoveryTicket)v0);
        }

        return arg1.reply(arg2, arg3);
    }

    public final CompletableFuture requestRealApplication(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda7(this, arg2));
    }

    static final RecoveryReply requestRealApplication$lambda$5(StretchRecoverySupervisor arg2, String arg3) {
        Object v0_3;
        StretchRecoveryRecord v0 = arg2.record;
        RecoveryTicket v1 = null;
        if(v0 != null) {
            StretchRecoverySnapshot v0_1 = v0.getSnapshot();
            if(v0_1 != null) {
                String v0_2 = v0_1.getSessionId();
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            v0_3 = v1;
        }

        RecoveryError v3 = !Intrinsics.areEqual(v0_3, arg3) ? RecoveryError.STALE_OPERATION : RecoveryError.PHYSICAL_AGENT_UNAVAILABLE;
        return StretchRecoverySupervisor.reply$default(arg2, v3, v1, 2, v1);
    }

    public final CompletableFuture restore(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda26(this, arg2));
    }

    static final RecoveryReply restore$lambda$22(StretchRecoverySupervisor arg2, String arg3) {
        StretchRecoveryRecord v0 = arg2.record;
        RecoveryTicket v1 = null;
        if(v0 != null) {
            StretchRecoverySnapshot v0_1 = v0.getSnapshot();
            if(v0_1 != null) {
                String v0_2 = v0_1.getSessionId();
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            Object v0_3 = v1;
        }

        if(!Intrinsics.areEqual(v0_2, arg3)) {
            return StretchRecoverySupervisor.reply$default(arg2, RecoveryError.STALE_OPERATION, v1, 2, v1);
        }

        return arg2.rollback(((RecoveryError)v1), false);
    }

    private final void restoreExpired(RecoveryTicket arg17) {
        StretchRecoverySupervisor v0 = this;
        RecoveryTicket v1 = arg17;
        StretchRecoveryRecord v2 = v0.record;
        if(v2 == null) {
        }
        else if(Intrinsics.areEqual(v0.inFlight, v1)) {
            if(!Intrinsics.areEqual(v2.getSnapshot().getSessionId(), v1.getSessionId())) {
            }
            else {
                long v3 = v0.clock.elapsedRealtimeMillis();
                long v5 = v0.restoreDeadline;
                if(v3 < v5) {
                    v0.operationTask = v0.scheduler.schedule(v5 - v3, new StretchRecoverySupervisor$$ExternalSyntheticLambda6(v0, v1));
                    return;
                }
                else {
                    v0.restoreExpired = true;
                    v0.save(StretchRecoveryRecord.copy$default(v2, 0, null, null, null, RecoveryPhase.RECOVERY_PENDING, null, null, null, null, RecoveryError.OPERATION_TIMEOUT, null, 0x5EF, null));
                }
            }
        }
    }

    static final Unit restoreExpired$lambda$34(StretchRecoverySupervisor arg1, RecoveryTicket arg2) {
        arg1.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda28(arg1, arg2));
        return Unit.INSTANCE;
    }

    static final Unit restoreExpired$lambda$34$lambda$33(StretchRecoverySupervisor arg0, RecoveryTicket arg1) {
        arg0.restoreExpired(arg1);
        return Unit.INSTANCE;
    }

    private final void restored(RecoveryTicket arg33, StretchRestoreResult arg34, Throwable arg35) {
        RecoveryPhase v7;
        StretchRecoveryRecord v1_4;
        RecoveryError v2_1;
        StretchRecoverySupervisor v0 = this;
        RecoveryTicket v1 = arg33;
        StretchRecoveryRecord v2 = v0.record;
        if(v2 == null) {
        }
        else if(Intrinsics.areEqual(v0.inFlight, v1)) {
            Object v3 = CollectionsKt.lastOrNull(v2.getRestores());
            StretchRestoreRequest v4 = null;
            if(v3 != null) {
                StretchRestoreRequest v3_1 = ((RecoveryRestoreAttempt)v3).getRequest();
                if(v3_1 != null) {
                    RecoveryTicket v3_2 = v3_1.getTicket();
                }
                else {
                    goto label_16;
                }
            }
            else {
            label_16:
                v3 = v4;
            }

            if(!Intrinsics.areEqual(v3, v1)) {
                return;
            }

            if(!Intrinsics.areEqual(v2.getSnapshot().getSessionId(), v1.getSessionId())) {
                return;
            }

            RecoveryCancellation v3_3 = v0.operationTask;
            if(v3_3 != null) {
                v3_3.cancel();
            }

            if(arg35 == null && arg34 != null) {
                if(!Intrinsics.areEqual(arg34.getTicket(), v1)) {
                }
                else {
                    StretchRestoreResult v1_1 = StretchRestoreResult.copy$default(arg34, null, null, CollectionsKt.toList(arg34.getSteps()), null, false, 27, null);
                    List v11 = CollectionsKt.plus(CollectionsKt.dropLast(v2.getRestores(), 1), RecoveryRestoreAttempt.copy$default(CollectionsKt.last(v2.getRestores()), v4, v1_1, 1, v4));
                    int v5 = (v0.restoreExpired) || v0.clock.elapsedRealtimeMillis() >= v0.restoreDeadline ? 1 : 0;
                    if(arg34.getExecutionStopped()) {
                        v0.inFlight = ((RecoveryTicket)v4);
                    }
                    else {
                        v0.externalStopRequired = true;
                    }

                    if(v5 == 0) {
                        if(!arg34.getExecutionStopped()) {
                        }
                        else {
                            RecoveryError v16 = v4;
                            StretchRestoreResult v18 = v1_1;
                            if(!v0.save(StretchRecoveryRecord.copy$default(v2, 0, null, null, null, RecoveryPhase.VERIFYING_RESTORE, null, null, null, v11, null, null, 0x6EF, null))) {
                                return;
                            }
                            else {
                                StretchRecoveryValidator v1_2 = new StretchRecoveryValidator();
                                v2 = v0.record;
                                Intrinsics.checkNotNull(v2);
                                boolean v1_3 = v1_2.verifiedRestore$app(v2, v18);
                                switch(WhenMappings.$EnumSwitchMapping$0[arg34.getStatus().ordinal()]) {
                                    case 1: {
                                        v2_1 = RecoveryError.BACKEND_LOST;
                                        break;
                                    }
                                    case 2: {
                                        v2_1 = RecoveryError.PERMISSION_LOST;
                                        break;
                                    }
                                    case 3: {
                                        v2_1 = RecoveryError.DISPLAY_MISMATCH;
                                        break;
                                    }
                                    case 4: {
                                        v2_1 = RecoveryError.UNKNOWN_BASELINE;
                                        break;
                                    }
                                    case 5: {
                                        v2_1 = RecoveryError.OPERATION_TIMEOUT;
                                        break;
                                    }
                                    case 6: {
                                        v2_1 = RecoveryError.RESTORE_PARTIAL;
                                        break;
                                    }
                                    default: {
                                        v2_1 = RecoveryError.RESTORE_UNVERIFIED;
                                        break;
                                    }
                                }

                                RecoveryError v4_1 = v2_1;
                                v2 = v0.record;
                                Intrinsics.checkNotNull(v2);
                                RecoveryPhase v3_4 = v1_3 ? RecoveryPhase.RECOVERED : RecoveryPhase.RECOVERY_PENDING;
                                RecoveryPhase v23 = v3_4;
                                RecoveryError v28 = v1_3 ? v16 : v4_1;
                                RecoveryResolution v29 = v1_3 ? RecoveryResolution.SIMULATION_VERIFIED : ((RecoveryResolution)v16);
                                v0.save(StretchRecoveryRecord.copy$default(v2, 0, null, null, null, v23, null, null, null, null, v28, v29, 0x1EF, null));
                                return;
                            }
                        }
                    }

                    v1_4 = v2;
                    v7 = RecoveryPhase.RECOVERY_PENDING;
                    v2_1 = v5 != 0 ? RecoveryError.OPERATION_TIMEOUT : RecoveryError.EXECUTOR_STILL_ACTIVE;
                    v0.save(StretchRecoveryRecord.copy$default(v1_4, 0, null, null, null, v7, null, null, null, v11, v2_1, null, 0x4EF, null));
                    return;
                }
            }

            v1_4 = v2;
            StretchRestoreRequest v16_1 = v4;
            v0.externalStopRequired = true;
            v7 = RecoveryPhase.RECOVERY_PENDING;
            RecoveryTicket v4_2 = arg34 != null ? arg34.getTicket() : ((RecoveryTicket)v16_1);
            v2_1 = v4_2 != null ? RecoveryError.STALE_OPERATION : RecoveryError.EXECUTOR_ERROR;
            v0.save(StretchRecoveryRecord.copy$default(v1_4, 0, null, null, null, v7, null, null, null, null, v2_1, null, 0x5EF, null));
        }
    }

    public final CompletableFuture retryRollback(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda27(this, arg2));
    }

    static final RecoveryReply retryRollback$lambda$23(StretchRecoverySupervisor arg2, String arg3) {
        StretchRecoveryRecord v0 = arg2.record;
        RecoveryTicket v1 = null;
        if(v0 != null) {
            StretchRecoverySnapshot v0_1 = v0.getSnapshot();
            if(v0_1 != null) {
                String v0_2 = v0_1.getSessionId();
            }
            else {
                goto label_7;
            }
        }
        else {
        label_7:
            Object v0_3 = v1;
        }

        if(!Intrinsics.areEqual(v0_3, arg3)) {
            return StretchRecoverySupervisor.reply$default(arg2, RecoveryError.STALE_OPERATION, v1, 2, v1);
        }

        return arg2.rollback(((RecoveryError)v1), true);
    }

    private final RecoveryReply rollback(RecoveryError arg34, boolean arg35) {
        StretchRecoverySupervisor v0 = this;
        StretchRecoveryRecord v1 = v0.record;
        int v2 = 2;
        RecoveryTicket v3 = null;
        if(v1 == null) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.INVALID_TRANSITION, v3, v2, v3);
        }

        int v6 = 3;
        if(v1.getPhase() == RecoveryPhase.RECOVERED) {
            return StretchRecoverySupervisor.reply$default(v0, ((RecoveryError)v3), v3, v6, v3);
        }

        if(v0.inFlight != null) {
            RecoveryError v1_1 = arg35 ? RecoveryError.EXECUTOR_STILL_ACTIVE : ((RecoveryError)v3);
            return StretchRecoverySupervisor.reply$default(v0, v1_1, v3, v2, v3);
        }

        if(v1.getPhase() == RecoveryPhase.RECOVERY_PENDING && !v1.getRestores().isEmpty() && !arg35) {
            return StretchRecoverySupervisor.reply$default(v0, ((RecoveryError)v3), v3, v6, v3);
        }

        if(v1.getRestores().size() >= v2) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.ATTEMPT_LIMIT, v3, v2, v3);
        }

        RecoveryCancellation v4 = v0.confirmationTask;
        if(v4 != null) {
            v4.cancel();
        }

        v4 = v0.operationTask;
        if(v4 != null) {
            v4.cancel();
        }

        if(!v0.save(StretchRecoveryRecord.copy$default(v1, 0, null, null, null, RecoveryPhase.RESTORE_REQUESTED, null, null, null, null, arg34, null, 0x5EF, null))) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, null, 2, null);
        }

        int v4_1 = 2;
        RecoveryError v5 = null;
        boolean v1_2 = v1.getSteps().isEmpty();
        StretchRecoveryRecord v2_1 = v0.record;
        if(v1_2) {
            Intrinsics.checkNotNull(v2_1);
            if(v0.save(StretchRecoveryRecord.copy$default(v2_1, 0, null, null, null, RecoveryPhase.RECOVERED, null, null, null, null, null, RecoveryResolution.NO_CHANGE_REQUESTED, 1007, null))) {
                return StretchRecoverySupervisor.reply$default(v0, v5, ((RecoveryTicket)v5), 3, v5);
            }

            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, ((RecoveryTicket)v5), v4_1, v5);
        }

        v1 = v2_1;
        int v13 = 3;
        Intrinsics.checkNotNull(v1);
        if(!(new StretchRecoveryValidator().validate(v1.getSnapshot(), v1.getStrategy(), v1.getIntendedSteps()) instanceof SimulationReady)) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.NOT_RECOVERABLE, ((RecoveryTicket)v5), v4_1, v5);
        }

        RecoveryTicket v2_2 = v0.ticket(v1);
        StretchRecoverySnapshot v3_1 = v1.getSnapshot();
        List v6_1 = v1.getSteps();
        ArrayList v7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v6_1), 10));
        Iterator v6_2 = ((Iterable)v6_1).iterator();
        while(v6_2.hasNext()) {
            ((Collection)v7).add(v6_2.next().getStep());
        }

        StretchRestoreRequest v6_3 = new StretchRestoreRequest(v2_2, v3_1, ((List)v7));
        if(!v0.save(StretchRecoveryRecord.copy$default(v1, 0, null, null, null, RecoveryPhase.RESTORING, null, null, null, CollectionsKt.plus(v1.getRestores(), new RecoveryRestoreAttempt(v6_3, ((StretchRestoreResult)v5), v4_1, ((DefaultConstructorMarker)v5))), null, null, 0x6EF, null))) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, ((RecoveryTicket)v5), v4_1, v5);
        }

        v0.inFlight = v6_3.getTicket();
        v0.restoreExpired = false;
        v0.externalStopRequired = false;
        v0.restoreDeadline = Math.addExact(v0.clock.elapsedRealtimeMillis(), v0.operationTimeoutMillis);
        v0.operationTask = v0.scheduler.schedule(v0.operationTimeoutMillis, new StretchRecoverySupervisor$$ExternalSyntheticLambda9(v0, v6_3));
        try {
            v0.invocationWorker.execute(new StretchRecoverySupervisor$$ExternalSyntheticLambda10(v0, v6_3));
        }
        catch(RejectedExecutionException ) {
            v0.restored(v6_3.getTicket(), ((StretchRestoreResult)v5), new IllegalStateException());
        }

        return StretchRecoverySupervisor.reply$default(v0, v5, ((RecoveryTicket)v5), v13, v5);
    }

    static final Unit rollback$lambda$27(StretchRecoverySupervisor arg1, StretchRestoreRequest arg2) {
        arg1.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda29(arg1, arg2));
        return Unit.INSTANCE;
    }

    static final Unit rollback$lambda$27$lambda$26(StretchRecoverySupervisor arg0, StretchRestoreRequest arg1) {
        arg0.restoreExpired(arg1.getTicket());
        return Unit.INSTANCE;
    }

    static final void rollback$lambda$32(StretchRecoverySupervisor arg3, StretchRestoreRequest arg4) {
        try {
            arg3.executor.restore(arg4).whenComplete(new StretchRecoverySupervisor$$ExternalSyntheticLambda13(new StretchRecoverySupervisor$$ExternalSyntheticLambda12(arg3, arg4)));
            return;
        }
        catch(Exception v0) {
            arg3.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda14(arg3, arg4, v0));
            return;
        }
    }

    static final Unit rollback$lambda$32$lambda$29(StretchRecoverySupervisor arg1, StretchRestoreRequest arg2, StretchRestoreResult arg3, Throwable arg4) {
        arg1.post(new StretchRecoverySupervisor$$ExternalSyntheticLambda18(arg1, arg2, arg3, arg4));
        return Unit.INSTANCE;
    }

    static final Unit rollback$lambda$32$lambda$29$lambda$28(StretchRecoverySupervisor arg0, StretchRestoreRequest arg1, StretchRestoreResult arg2, Throwable arg3) {
        arg0.restored(arg1.getTicket(), arg2, arg3);
        return Unit.INSTANCE;
    }

    static final void rollback$lambda$32$lambda$30(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }

    static final Unit rollback$lambda$32$lambda$31(StretchRecoverySupervisor arg1, StretchRestoreRequest arg2, Exception arg3) {
        arg1.restored(arg2.getTicket(), null, ((Throwable)arg3));
        return Unit.INSTANCE;
    }

    private final boolean save(StretchRecoveryRecord arg41) {
        RecoveryPhase v4;
        StretchRecoverySupervisor v0 = this;
        StretchRecoveryRecord v1 = v0.record;
        if(!v0.blocked) {
            StretchRecoveryStateMachine v2 = StretchRecoveryStateMachine.INSTANCE;
            if(v1 != null) {
                v4 = v1.getPhase();
                if(v4 == null) {
                    goto label_9;
                }
            }
            else {
            label_9:
                v4 = RecoveryPhase.IDLE;
            }

            if(!v2.canTransition(v4, arg41.getPhase())) {
                return 0;
            }

            long v4_1 = 0;
            long v6 = v1 != null ? v1.getRevision() : v4_1;
            StretchRecoveryRecord v2_1 = StretchRecoveryRecord.copy$default(arg41, Math.addExact(v6, 1), null, null, null, null, null, null, null, null, null, null, 0x7FE, null);
            StretchRecoveryStore v6_1 = v0.store;
            if(v1 != null) {
                v4_1 = v1.getRevision();
            }

            if(!Intrinsics.areEqual(v6_1.commit(v2_1, v4_1), Committed.INSTANCE)) {
                v0.blocked = true;
                v0.record = StretchRecoveryRecord.copy$default(v2_1, 0, null, null, null, RecoveryPhase.RECOVERY_PENDING, null, null, null, null, RecoveryError.JOURNAL_WRITE_FAILED, null, 0x1EF, null);
                v0.publish();
                return 0;
            }

            v0.record = v2_1;
            v0.publish();
            return 1;
        }

        return 0;
    }

    public final CompletableFuture signal(String arg2, RecoverySignal arg3) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        Intrinsics.checkNotNullParameter(arg3, "signal");
        return this.action(new StretchRecoverySupervisor$$ExternalSyntheticLambda25(this, arg2, arg3));
    }

    static final RecoveryReply signal$lambda$36(StretchRecoverySupervisor arg19, String arg20, RecoverySignal arg21) {
        StretchRecoverySupervisor v0 = arg19;
        RecoverySignal v1 = arg21;
        StretchRecoveryRecord v2 = v0.record;
        int v3 = 2;
        RecoveryTicket v4 = null;
        if(v2 == null) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v4, v3, v4);
        }

        if(!Intrinsics.areEqual(v2.getSnapshot().getSessionId(), arg20)) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.STALE_OPERATION, v4, v3, v4);
        }

        int v7 = 3;
        if(v2.getPhase() == RecoveryPhase.RECOVERED) {
            return StretchRecoverySupervisor.reply$default(v0, ((RecoveryError)v4), v4, v7, v4);
        }

        if(v1 != RecoverySignal.BACKEND_LOST) {
            if(v1 == RecoverySignal.ORIENTATION_CHANGED) {
            }
            else if(!v2.getSteps().isEmpty()) {
                if(v1 == RecoverySignal.OPERATION_TIMEOUT) {
                    RecoveryError v4_1 = RecoveryError.OPERATION_TIMEOUT;
                }

                return v0.rollback(((RecoveryError)v4), false);
            }
            else {
                return StretchRecoverySupervisor.reply$default(v0, ((RecoveryError)v4), v4, v7, v4);
            }
        }

        if(v2.getSteps().isEmpty()) {
            RecoveryPhase[] v5 = new RecoveryPhase[v3];
            v5[0] = RecoveryPhase.FAILED;
            v5[1] = RecoveryPhase.NOT_RECOVERABLE;
            if(SetsKt.setOf(((Object[])v5)).contains(v2.getPhase())) {
                return StretchRecoverySupervisor.reply$default(v0, ((RecoveryError)v4), v4, v7, v4);
            }
        }

        RecoveryCancellation v5_1 = v0.confirmationTask;
        if(v5_1 != null) {
            v5_1.cancel();
        }

        v5_1 = v0.operationTask;
        if(v5_1 != null) {
            v5_1.cancel();
        }

        RecoveryPhase v5_2 = v2.getSteps().isEmpty() ? RecoveryPhase.FAILED : RecoveryPhase.RECOVERY_PENDING;
        RecoveryError v1_1 = v1 == RecoverySignal.BACKEND_LOST ? RecoveryError.BACKEND_LOST : RecoveryError.DISPLAY_MISMATCH;
        if(!v0.save(StretchRecoveryRecord.copy$default(v2, 0, null, null, null, v5_2, null, null, null, null, v1_1, null, 0x5EF, null))) {
            return StretchRecoverySupervisor.reply$default(v0, RecoveryError.JOURNAL_WRITE_FAILED, null, 2, null);
        }

        return StretchRecoverySupervisor.reply$default(v0, null, null, 3, null);
    }

    private final RecoveryTicket ticket(StretchRecoveryRecord arg12) {
        String v1 = arg12.getSnapshot().getSessionId();
        String v2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        long v3 = Math.addExact(arg12.getRevision(), 1);
        Object v11 = arg12.getSnapshot().getOriginal().getLogicalIdentity().getValue();
        Intrinsics.checkNotNull(v11);
        int v5 = ((StretchDisplayIdentity)v11).getLogicalId();
        v11 = arg12.getSnapshot().getOriginal().getPhysicalIdentity().getValue();
        Intrinsics.checkNotNull(v11);
        return new RecoveryTicket(v1, v2, v3, v5, v11, StretchRecoveryCodec.INSTANCE.snapshotDigest(arg12.getSnapshot()), null, 0x40, null);
    }
}

