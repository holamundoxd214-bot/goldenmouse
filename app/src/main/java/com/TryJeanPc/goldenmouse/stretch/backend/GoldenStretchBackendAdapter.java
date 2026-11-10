package com.TryJeanPc.goldenmouse.stretch.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 52\u00060\u0001j\u0002`\u0002:\u000245B\u0017\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\b\b\u0002\u0010\u0016\u001A\u00020\u00112\b\b\u0002\u0010\u001F\u001A\u00020 J\u0006\u0010!\u001A\u00020\u0011J\u001A\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u00152\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0002J\u0010\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020\u0005H\u0002J:\u0010(\u001A\u00020\u00132\u0006\u0010$\u001A\u00020\u00152\u0006\u0010)\u001A\u00020*2\b\u0010+\u001A\u0004\u0018\u00010,2\n\b\u0002\u0010-\u001A\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001A\u0004\u0018\u000100H\u0002J \u00101\u001A\u00020#2\u0006\u0010$\u001A\u00020\u00152\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,H\u0002J\u0010\u00102\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0015H\u0002J\b\u00103\u001A\u00020#H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\n \f*\u0004\u0018\u00010\u000B0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000F\u001A\n \f*\u0004\u0018\u00010\u000B0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u00066"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/GoldenStretchBackendAdapter;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "transports", "", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryTransport;", "<init>", "(Ljava/util/List;)V", "lock", "", "worker", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "timer", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "cleanup", "session", "", "closed", "", "active", "Lcom/TryJeanPc/goldenmouse/stretch/backend/GoldenStretchBackendAdapter$Work;", "sessionId", "getSessionId", "()Ljava/lang/String;", "submit", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchPendingOperation;", "query", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "preferred", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "timeoutMillis", "", "newSession", "execute", "", "work", "observe", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "transport", "finish", "status", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "raw", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchRawResponse;", "data", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "stop", "closeChannel", "close", "Work", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchBackendAdapter implements AutoCloseable {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/GoldenStretchBackendAdapter$Companion;", "", "<init>", "()V", "DEFAULT_TIMEOUT_MILLIS", "", "MAX_TIMEOUT_MILLIS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchBackendState.values().length];
            try {
                v0[StretchBackendState.NOT_AUTHORIZED.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchBackendState.DISCONNECTED.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchBackendState.UNSUPPORTED.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchBackendState.ERROR.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[StretchBackendState.UNKNOWN.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u001AX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001A\u0010\u001F\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001A\b\u0012\u0004\u0012\u00020&0%X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001C\u0010+\u001A\u0004\u0018\u00010,X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u001C\u00101\u001A\u0004\u0018\u000102X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b3\u00104\"\u0004\b5\u00106R \u00107\u001A\b\u0012\u0002\b\u0003\u0018\u000108X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010=\u001A\u00020>¢\u0006\b\n\u0000\u001A\u0004\b?\u0010@R\u0011\u0010A\u001A\u00020B¢\u0006\b\n\u0000\u001A\u0004\bC\u0010D¨\u0006E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/GoldenStretchBackendAdapter$Work;", "", "session", "", "query", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "preferred", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;)V", "getSession", "()Ljava/lang/String;", "getQuery", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "id", "getId", "started", "", "getStarted", "()J", "result", "Ljava/util/concurrent/CompletableFuture;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchOperationResult;", "getResult", "()Ljava/util/concurrent/CompletableFuture;", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "backend", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "setBackend", "(Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;)V", "statuses", "", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "getStatuses", "()Ljava/util/List;", "setStatuses", "(Ljava/util/List;)V", "channel", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;", "getChannel", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;", "setChannel", "(Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;)V", "thread", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "setThread", "(Ljava/lang/Thread;)V", "deadline", "Ljava/util/concurrent/ScheduledFuture;", "getDeadline", "()Ljava/util/concurrent/ScheduledFuture;", "setDeadline", "(Ljava/util/concurrent/ScheduledFuture;)V", "closing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getClosing", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "cleanupDone", "Ljava/util/concurrent/CountDownLatch;", "getCleanupDone", "()Ljava/util/concurrent/CountDownLatch;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Work {
        private volatile StretchBackendType backend;
        private volatile StretchQueryChannel channel;
        private final CountDownLatch cleanupDone;
        private final AtomicBoolean closing;
        private ScheduledFuture deadline;
        private boolean finished;
        private final String id;
        private final StretchQuery query;
        private final CompletableFuture result;
        private final String session;
        private final long started;
        private volatile List statuses;
        private volatile Thread thread;

        public Work(String arg2, StretchQuery arg3, StretchBackendType arg4) {
            Intrinsics.checkNotNullParameter(arg2, "session");
            Intrinsics.checkNotNullParameter(arg3, "query");
            super();
            this.session = arg2;
            this.query = arg3;
            arg2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(arg2, "toString(...)");
            this.id = arg2;
            this.started = System.nanoTime();
            this.result = new CompletableFuture();
            if(arg4 == null) {
                arg4 = StretchBackendType.NONE;
            }

            this.backend = arg4;
            this.statuses = CollectionsKt.emptyList();
            this.closing = new AtomicBoolean(false);
            this.cleanupDone = new CountDownLatch(1);
        }

        public final StretchBackendType getBackend() {
            return this.backend;
        }

        public final StretchQueryChannel getChannel() {
            return this.channel;
        }

        public final CountDownLatch getCleanupDone() {
            return this.cleanupDone;
        }

        public final AtomicBoolean getClosing() {
            return this.closing;
        }

        public final ScheduledFuture getDeadline() {
            return this.deadline;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final String getId() {
            return this.id;
        }

        public final StretchQuery getQuery() {
            return this.query;
        }

        public final CompletableFuture getResult() {
            return this.result;
        }

        public final String getSession() {
            return this.session;
        }

        public final long getStarted() {
            return this.started;
        }

        public final List getStatuses() {
            return this.statuses;
        }

        public final Thread getThread() {
            return this.thread;
        }

        public final void setBackend(StretchBackendType arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.backend = arg2;
        }

        public final void setChannel(StretchQueryChannel arg1) {
            this.channel = arg1;
        }

        public final void setDeadline(ScheduledFuture arg1) {
            this.deadline = arg1;
        }

        public final void setFinished(boolean arg1) {
            this.finished = arg1;
        }

        public final void setStatuses(List arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.statuses = arg2;
        }

        public final void setThread(Thread arg1) {
            this.thread = arg1;
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final long DEFAULT_TIMEOUT_MILLIS = 2500;
    public static final long MAX_TIMEOUT_MILLIS = 60000;
    private Work active;
    private final ExecutorService cleanup;
    private boolean closed;
    private final Object lock;
    private String session;
    private final ScheduledThreadPoolExecutor timer;
    private final List transports;
    private final ExecutorService worker;

    static {
        GoldenStretchBackendAdapter.Companion = new Companion(null);
        GoldenStretchBackendAdapter.$stable = 8;
    }

    public GoldenStretchBackendAdapter(List arg3) {
        Intrinsics.checkNotNullParameter(arg3, "transports");
        super();
        this.transports = arg3;
        this.lock = new Object();
        this.worker = Executors.newSingleThreadExecutor(new GoldenStretchBackendAdapter$$ExternalSyntheticLambda0());
        ScheduledThreadPoolExecutor v3 = new ScheduledThreadPoolExecutor(1, new GoldenStretchBackendAdapter$$ExternalSyntheticLambda1());
        v3.setRemoveOnCancelPolicy(true);
        this.timer = v3;
        this.cleanup = Executors.newSingleThreadExecutor(new GoldenStretchBackendAdapter$$ExternalSyntheticLambda2());
        String v3_1 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v3_1, "toString(...)");
        this.session = v3_1;
    }

    static final Thread cleanup$lambda$6(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchQueryClose");
        v0.setDaemon(true);
        return v0;
    }

    public void close() {
        Work v1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.closed) {
                goto label_7;
            }
        }
        catch(Throwable v3) {
            goto label_23;
        }

        __monitor_exit(v0);
        return;
        try {
        label_7:
            this.closed = true;
            v1 = this.active;
        }
        catch(Throwable v3) {
        label_23:
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        if(v1 != null) {
            this.stop(v1, StretchExecutionStatus.SESSION_INVALIDATED, StretchTransportError.SESSION_INVALIDATED);
        }

        this.worker.shutdown();
        this.timer.shutdownNow();
        if(v1 == null) {
            this.cleanup.shutdown();
        }
    }

    private final void closeChannel(Work arg4) {
        StretchQueryChannel v3 = arg4.getChannel();
        if(v3 == null) {
        }
        else {
            if(!arg4.getClosing().compareAndSet(false, true)) {
                return;
            }

            goto label_9;
        }

        return;
        try {
        label_9:
            v3.close();
            goto label_10;
        }
        catch(Exception ) {
        label_10:
            arg4.getCleanupDone().countDown();
            return;
        }
        catch(Throwable v3_1) {
            arg4.getCleanupDone().countDown();
            throw v3_1;
        }
    }

    private final void execute(Work arg18, StretchBackendType arg19) {
        boolean v3_2;
        StretchTransportError v0_8;
        int v0_7;
        Object v9_3;
        Iterator v0_4;
        Iterator v8_2;
        StretchRawResponse v9_2;
        StretchQueryEvaluation v10_1;
        Object v11;
        Object v10;
        ArrayList v8_1;
        boolean v0_3;
        boolean v9;
        Object v8;
        GoldenStretchBackendAdapter v1 = this;
        Work v2 = arg18;
        StretchBackendType v0 = arg19;
        long v3 = 0;
        int v5 = 0;
        Thread v7 = null;
        try {
            v2.setThread(Thread.currentThread());
            v8 = v1.lock;
            __monitor_enter(v8);
        }
        catch(Throwable v0_1) {
            goto label_418;
        }
        catch(Exception v0_2) {
            goto label_354;
        }

        try {
            v9 = v2.getFinished();
            goto label_12;
        }
        catch(Throwable v0_1) {
            try {
                __monitor_exit(v8);
                throw v0_1;
            label_12:
                __monitor_exit(v8);
                if(!v9) {
                    goto label_50;
                }
            }
            catch(Throwable v0_1) {
                goto label_418;
            }
            catch(Exception v0_2) {
                goto label_354;
            }
        }

        this.closeChannel(arg18);
        while(v2.getChannel() != null) {
            if(v2.getCleanupDone().getCount() <= v3) {
                break;
            }

            try {
                v2.getCleanupDone().await();
            }
            catch(InterruptedException ) {
                v5 = 1;
            }
        }

        Object v3_1 = v1.lock;
        __monitor_enter(v3_1);
        try {
            v2.setThread(v7);
            if(v1.active == v2) {
                v1.active = ((Work)v7);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v3_1);
            throw v0_1;
        }

        __monitor_exit(v3_1);
        Object v2_1 = v1.lock;
        __monitor_enter(v2_1);
        try {
            v0_3 = v1.closed;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_1);
            throw v0_1;
        }

        __monitor_exit(v2_1);
        if(v0_3) {
            v1.cleanup.shutdown();
        }

        if(v5 == 0) {
            return;
        }

        goto label_41;
        try {
        label_50:
            v8_1 = new ArrayList();
            Iterator v9_1 = v1.transports.iterator();
            while(true) {
            label_54:
                if(!v9_1.hasNext()) {
                    goto label_103;
                }

                v10 = v9_1.next();
                v11 = v1.lock;
                __monitor_enter(v11);
                break;
            }
        }
        catch(Throwable v0_1) {
            goto label_418;
        }
        catch(Exception v0_2) {
            goto label_354;
        }

        try {
            boolean v12 = v2.getFinished();
            goto label_60;
        }
        catch(Throwable v0_1) {
            try {
                __monitor_exit(v11);
                throw v0_1;
            label_60:
                __monitor_exit(v11);
                if(!v12) {
                    goto label_96;
                }
            }
            catch(Throwable v0_1) {
                goto label_418;
            }
            catch(Exception v0_2) {
                goto label_354;
            }
        }

        this.closeChannel(arg18);
        goto label_63;
        try {
        label_96:
            v8_1.add(v1.observe(((StretchQueryTransport)v10)));
            goto label_54;
        label_103:
            v2.setStatuses(CollectionsKt.toList(((Iterable)v8_1)));
            v8 = v1.lock;
            __monitor_enter(v8);
        }
        catch(Throwable v0_1) {
            goto label_418;
        }
        catch(Exception v0_2) {
            goto label_354;
        }

        try {
            v9 = v2.getFinished();
            goto label_108;
        }
        catch(Throwable v0_1) {
            try {
                __monitor_exit(v8);
                throw v0_1;
            label_108:
                __monitor_exit(v8);
                if(!v9) {
                    goto label_144;
                }
            }
            catch(Throwable v0_1) {
                goto label_418;
            }
            catch(Exception v0_2) {
                goto label_354;
            }
        }

        this.closeChannel(arg18);
        goto label_111;
        try {
        label_144:
            if(v2.getQuery() == StretchQuery.BACKEND_STATUS) {
                v10_1 = new StretchQueryEvaluation(StretchExecutionStatus.SUCCEEDED, null, null, 6, null);
                v9_2 = ((StretchRawResponse)v7);
            }
            else {
                v2.setBackend(StretchBackendModelsKt.selectStretchBackend(v2.getStatuses(), v0));
                if(v2.getBackend() == StretchBackendType.NONE) {
                    v8_2 = v2.getStatuses().iterator();
                    goto label_164;
                }
                else {
                    v8 = v1.lock;
                    __monitor_enter(v8);
                    goto label_213;
                }
            }

            goto label_301;
        }
        catch(Throwable v0_1) {
            goto label_418;
        }
        catch(Exception v0_2) {
            goto label_354;
        }

        try {
        label_213:
            v0_3 = v2.getFinished();
            goto label_214;
        }
        catch(Throwable v0_1) {
            try {
                __monitor_exit(v8);
                throw v0_1;
            label_214:
                __monitor_exit(v8);
                if(!v0_3) {
                    v0_4 = v1.transports.iterator();
                    goto label_218;
                }
                else {
                }
            }
            catch(Throwable v0_1) {
                goto label_418;
            }
            catch(Exception v0_2) {
                goto label_354;
            }
        }

        v9_2 = ((StretchRawResponse)v7);
        v10_1 = ((StretchQueryEvaluation)v9_2);
        goto label_301;
        try {
            do {
            label_218:
                if(v0_4.hasNext()) {
                    v8 = v0_4.next();
                    if(v8.getBackend() != v2.getBackend()) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_295;
                }
            }
            while(true);

            v2.setChannel(((StretchQueryTransport)v8).open(v2.getQuery()));
            v9_3 = v1.lock;
            __monitor_enter(v9_3);
        }
        catch(Throwable v0_1) {
            goto label_418;
        }
        catch(Exception v0_2) {
            goto label_354;
        }

        try {
            v0_3 = v2.getFinished();
            goto label_231;
        }
        catch(Throwable v0_1) {
            try {
                __monitor_exit(v9_3);
                throw v0_1;
            label_231:
                __monitor_exit(v9_3);
                if(v0_3) {
                }
                else {
                    goto label_267;
                }
            }
            catch(Throwable v0_1) {
                goto label_418;
            }
            catch(Exception v0_2) {
                goto label_354;
            }
        }

        this.closeChannel(arg18);
        goto label_234;
        try {
        label_267:
            StretchQueryChannel v0_5 = v2.getChannel();
            Intrinsics.checkNotNull(v0_5);
            v9_2 = v0_5.collect();
        }
        catch(Exception v0_2) {
            goto label_354;
        }

        try {
            if(v9_2.getError() == StretchTransportError.TRANSPORT_FAILURE && v1.observe(((StretchQueryTransport)v8)).getState() == StretchBackendState.DISCONNECTED) {
                v9_2 = StretchRawResponse.copy$default(v9_2, null, null, null, false, StretchTransportError.DISCONNECTED, 15, null);
            }

            v10_1 = StretchQueryParser.INSTANCE.evaluate(v2.getQuery(), v9_2);
            goto label_301;
        }
        catch(Exception v0_2) {
            goto label_355;
        }

        try {
        label_295:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        catch(Throwable v0_1) {
            goto label_418;
        }
        catch(Exception v0_2) {
            goto label_354;
        }

    label_234:
        while(v2.getChannel() != null) {
            if(v2.getCleanupDone().getCount() <= v3) {
                break;
            }

            try {
                v2.getCleanupDone().await();
            }
            catch(InterruptedException ) {
                v5 = 1;
            }
        }

        v3_1 = v1.lock;
        __monitor_enter(v3_1);
        try {
            v2.setThread(v7);
            if(v1.active == v2) {
                v1.active = ((Work)v7);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v3_1);
            throw v0_1;
        }

        __monitor_exit(v3_1);
        v2_1 = v1.lock;
        __monitor_enter(v2_1);
        try {
            v0_3 = v1.closed;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_1);
            throw v0_1;
        }

        __monitor_exit(v2_1);
        if(v0_3) {
            v1.cleanup.shutdown();
        }

        if(v5 == 0) {
            return;
        }

        goto label_41;
        try {
            do {
            label_164:
                if(v8_2.hasNext()) {
                    v9_3 = v8_2.next();
                    if(v9_3.getBackend() != v0) {
                        continue;
                    }

                    break;
                }
                else {
                    goto label_171;
                }
            }
            while(true);

            goto label_172;
        label_171:
            v9_3 = v7;
        label_172:
            StretchBackendState v0_6 = v9_3 != null ? ((StretchBackendStatus)v9_3).getState() : ((StretchBackendState)v7);
            StretchExecutionStatus v9_4 = StretchExecutionStatus.REJECTED;
            v0_7 = v0_6 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v0_6.ordinal()];
            if(v0_7 == 1) {
                v0_8 = StretchTransportError.PERMISSION_DENIED;
            }
            else if(v0_7 == 2) {
                v0_8 = StretchTransportError.DISCONNECTED;
            }
            else if(v0_7 != 3) {
                if(v0_7 != 4 && v0_7 != 5) {
                    v0_8 = StretchTransportError.NO_BACKEND;
                    goto label_194;
                }

                v0_8 = StretchTransportError.TRANSPORT_FAILURE;
            }
            else {
                v0_8 = StretchTransportError.UNSUPPORTED;
            }

        label_194:
            StretchTransportError v11_1 = v0_8;
            StretchQueryEvaluation v8_3 = new StretchQueryEvaluation(v9_4, null, v11_1, 2, null);
            v9_2 = ((StretchRawResponse)v7);
            v10_1 = v8_3;
        }
        catch(Throwable v0_1) {
            goto label_418;
        }
        catch(Exception v0_2) {
            goto label_354;
        }

    label_301:
        this.closeChannel(arg18);
        v0_7 = 0;
        while(v2.getChannel() != null) {
            if(v2.getCleanupDone().getCount() <= v3) {
                break;
            }

            try {
                v2.getCleanupDone().await();
            }
            catch(InterruptedException ) {
                v0_7 = 1;
            }
        }

        v3_1 = v1.lock;
        __monitor_enter(v3_1);
        try {
            v2.setThread(v7);
            if(v1.active == v2) {
                v1.active = ((Work)v7);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v3_1);
            throw v0_1;
        }

        __monitor_exit(v3_1);
        if(v10_1 != null) {
            v1.finish(v2, v10_1.getStatus(), v10_1.getError(), v9_2, v10_1.getData());
        }

        v2_1 = v1.lock;
        __monitor_enter(v2_1);
        try {
            v3_2 = v1.closed;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_1);
            throw v0_1;
        }

        __monitor_exit(v2_1);
        if(v3_2) {
            v1.cleanup.shutdown();
        }

        if(v0_7 == 0) {
            return;
        }

        goto label_41;
    label_111:
        while(v2.getChannel() != null) {
            if(v2.getCleanupDone().getCount() <= v3) {
                break;
            }

            try {
                v2.getCleanupDone().await();
            }
            catch(InterruptedException ) {
                v5 = 1;
            }
        }

        v3_1 = v1.lock;
        __monitor_enter(v3_1);
        try {
            v2.setThread(v7);
            if(v1.active == v2) {
                v1.active = ((Work)v7);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v3_1);
            throw v0_1;
        }

        __monitor_exit(v3_1);
        v2_1 = v1.lock;
        __monitor_enter(v2_1);
        try {
            v0_3 = v1.closed;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_1);
            throw v0_1;
        }

        __monitor_exit(v2_1);
        if(v0_3) {
            v1.cleanup.shutdown();
        }

        if(v5 == 0) {
            return;
        }

        goto label_41;
    label_63:
        while(v2.getChannel() != null) {
            if(v2.getCleanupDone().getCount() <= v3) {
                break;
            }

            try {
                v2.getCleanupDone().await();
            }
            catch(InterruptedException ) {
                v5 = 1;
            }
        }

        v3_1 = v1.lock;
        __monitor_enter(v3_1);
        try {
            v2.setThread(v7);
            if(v1.active == v2) {
                v1.active = ((Work)v7);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v3_1);
            throw v0_1;
        }

        __monitor_exit(v3_1);
        v2_1 = v1.lock;
        __monitor_enter(v2_1);
        try {
            v0_3 = v1.closed;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_1);
            throw v0_1;
        }

        __monitor_exit(v2_1);
        if(v0_3) {
            v1.cleanup.shutdown();
        }

        if(v5 == 0) {
            return;
        }

        goto label_41;
    label_354:
        v9_2 = ((StretchRawResponse)v7);
        try {
        label_355:
            StretchExecutionStatus v11_2 = StretchExecutionStatus.FAILED;
            if((v0_2 instanceof StretchTransportException)) {
                v0_8 = ((StretchTransportException)v0_2).getReason();
            }
            else if((v0_2 instanceof SecurityException)) {
                v0_8 = StretchTransportError.PERMISSION_DENIED;
            }
            else if((v0_2 instanceof UnsupportedOperationException)) {
                v0_8 = StretchTransportError.UNSUPPORTED;
            }
            else {
                v0_8 = StretchTransportError.TRANSPORT_FAILURE;
            }

            StretchTransportError v13 = v0_8;
            v10_1 = new StretchQueryEvaluation(v11_2, null, v13, 2, null);
        }
        catch(Throwable v0_1) {
            goto label_418;
        }

        this.closeChannel(arg18);
        v0_7 = 0;
        while(v2.getChannel() != null) {
            if(v2.getCleanupDone().getCount() <= v3) {
                break;
            }

            try {
                v2.getCleanupDone().await();
            }
            catch(InterruptedException ) {
                v0_7 = 1;
            }
        }

        v3_1 = v1.lock;
        __monitor_enter(v3_1);
        try {
            v2.setThread(v7);
            if(v1.active == v2) {
                v1.active = ((Work)v7);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v3_1);
            throw v0_1;
        }

        __monitor_exit(v3_1);
        v1.finish(v2, v10_1.getStatus(), v10_1.getError(), v9_2, v10_1.getData());
        v2_1 = v1.lock;
        __monitor_enter(v2_1);
        try {
            v3_2 = v1.closed;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_1);
            throw v0_1;
        }

        __monitor_exit(v2_1);
        if(v3_2) {
            v1.cleanup.shutdown();
        }

        if(v0_7 != 0) {
        label_41:
            Thread.currentThread().interrupt();
        }

        return;
    label_418:
        this.closeChannel(arg18);
        while(v2.getChannel() != null) {
            if(v2.getCleanupDone().getCount() <= v3) {
                break;
            }

            try {
                v2.getCleanupDone().await();
            }
            catch(InterruptedException ) {
                v5 = 1;
            }
        }

        v3_1 = v1.lock;
        __monitor_enter(v3_1);
        try {
            v2.setThread(v7);
            if(v1.active == v2) {
                v1.active = ((Work)v7);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v3_1);
            throw v0_1;
        }

        __monitor_exit(v3_1);
        v2_1 = v1.lock;
        __monitor_enter(v2_1);
        try {
            v3_2 = v1.closed;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2_1);
            throw v0_1;
        }

        __monitor_exit(v2_1);
        if(v3_2) {
            v1.cleanup.shutdown();
        }

        if(v5 != 0) {
            Thread.currentThread().interrupt();
        }

        throw v0_1;
    }

    private final boolean finish(Work arg23, StretchExecutionStatus arg24, StretchTransportError arg25, StretchRawResponse arg26, StretchQueryData arg27) {
        StretchOperationResult v5_1;
        long v0_4;
        Object v21;
        String v22;
        TimeUnit v3_1;
        List v16;
        StretchTransportError v15;
        StretchQueryData v14;
        Integer v13_1;
        String v0_3;
        String v12;
        StretchExecutionStatus v10;
        StretchQuery v9;
        StretchBackendType v8;
        String v7;
        String v6;
        int v3;
        GoldenStretchBackendAdapter v0 = this;
        Object v1 = v0.lock;
        __monitor_enter(v1);
        try {
            v3 = 0;
            if(!arg23.getFinished()) {
                goto label_8;
            }
        }
        catch(Throwable v0_1) {
            goto label_80;
        }

        __monitor_exit(v1);
        return 0;
    label_8:
        Work v4 = arg23;
        try {
            v4.setFinished(true);
            ScheduledFuture v5 = v4.getDeadline();
            if(v5 != null) {
                v5.cancel(false);
            }

            if((v0.closed) || !Intrinsics.areEqual(v4.getSession(), v0.session)) {
                v3 = 1;
            }

            v6 = v4.getId();
            v7 = v4.getSession();
            v8 = v4.getBackend();
            v9 = v4.getQuery();
            v10 = v3 != 0 ? StretchExecutionStatus.SESSION_INVALIDATED : arg24;
            int v0_2 = 0x10000;
            String v11 = null;
            if(arg26 != null) {
                v12 = arg26.getStdout();
                if(v12 != null) {
                    v12 = StringsKt.take(v12, v0_2);
                }
                else {
                    goto label_38;
                }
            }
            else {
            label_38:
                v12 = v11;
            }

            if(v12 == null) {
                v12 = "";
            }

            if(arg26 != null) {
                String v13 = arg26.getStderr();
                if(v13 != null) {
                    v0_3 = StringsKt.take(v13, v0_2);
                }
                else {
                    goto label_46;
                }
            }
            else {
            label_46:
                v0_3 = v11;
            }

            if(v0_3 == null) {
                v0_3 = "";
            }

            v13_1 = arg26 != null ? arg26.getExitCode() : ((Integer)v11);
            v14 = v3 != 0 ? ((StretchQueryData)v11) : arg27;
            v15 = v3 != 0 ? StretchTransportError.SESSION_INVALIDATED : arg25;
            v16 = v4.getStatuses();
            v3_1 = TimeUnit.NANOSECONDS;
            v22 = v0_3;
            v21 = v1;
            v0_4 = System.nanoTime() - v4.getStarted();
        }
        catch(Throwable v0_1) {
        label_80:
            v21 = v1;
            goto label_81;
        }

        try {
            v5_1 = new StretchOperationResult(v6, v7, v8, v9, v10, v12, v22, v13_1, v14, v15, v16, v3_1.toMillis(v0_4));
            goto label_73;
        }
        catch(Throwable v0_1) {
        }

    label_81:
        __monitor_exit(v21);
        throw v0_1;
    label_73:
        __monitor_exit(v21);
        v4.getResult().complete(v5_1);
        return 1;
    }

    static boolean finish$default(GoldenStretchBackendAdapter arg1, Work arg2, StretchExecutionStatus arg3, StretchTransportError arg4, StretchRawResponse arg5, StretchQueryData arg6, int arg7, Object arg8) {
        StretchRawResponse v0 = null;
        if((arg7 & 8) != 0) {
            arg5 = v0;
        }

        if((arg7 & 16) != 0) {
            arg6 = ((StretchQueryData)v0);
        }

        return arg1.finish(arg2, arg3, arg4, arg5, arg6);
    }

    public final String getSessionId() {
        String v1_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.session;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final String newSession() {
        Work v1_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.closed) {
                goto label_17;
            }

            String v1 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
            this.session = v1;
            v1_1 = this.active;
        }
        catch(Throwable v3) {
            goto label_22;
        }

        __monitor_exit(v0);
        if(v1_1 != null) {
            this.stop(v1_1, StretchExecutionStatus.SESSION_INVALIDATED, StretchTransportError.SESSION_INVALIDATED);
        }

        return this.getSessionId();
        try {
        label_17:
            throw new IllegalStateException("Check failed.");
        }
        catch(Throwable v3) {
        label_22:
            __monitor_exit(v0);
            throw v3;
        }
    }

    private final StretchBackendStatus observe(StretchQueryTransport arg10) {
        try {
            return arg10.status();
        }
        catch(Exception ) {
            return new StretchBackendStatus(arg10.getBackend(), StretchBackendState.UNKNOWN, null, null, null, "Status query failed", 28, null);
        }
    }

    private final void stop(Work arg9, StretchExecutionStatus arg10, StretchTransportError arg11) {
        GoldenStretchBackendAdapter v0 = this;
        Work v1 = arg9;
        if(!GoldenStretchBackendAdapter.finish$default(v0, v1, arg10, arg11, null, null, 24, null)) {
        }
        else {
            Object v8 = v0.lock;
            __monitor_enter(v8);
            try {
                if(v0.active == v1) {
                    Thread v9 = v1.getThread();
                    if(v9 != null) {
                        v9.interrupt();
                    }
                }
            }
            catch(Throwable v0_1) {
                __monitor_exit(v8);
                throw v0_1;
            }

            __monitor_exit(v8);
            if(v1.getChannel() == null) {
                return;
            }

            try {
                v0.cleanup.execute(new GoldenStretchBackendAdapter$$ExternalSyntheticLambda6(v0, v1));
                return;
            }
            catch(RejectedExecutionException ) {
                return;
            }
        }
    }

    static final void stop$lambda$26(GoldenStretchBackendAdapter arg0, Work arg1) {
        arg0.closeChannel(arg1);
    }

    public final StretchPendingOperation submit(StretchQuery arg10, StretchBackendType arg11, String arg12, long arg13) {
        GoldenStretchBackendAdapter v1;
        Intrinsics.checkNotNullParameter(arg10, "query");
        Intrinsics.checkNotNullParameter(arg12, "sessionId");
        if(1 <= arg13 && arg13 < 60001) {
            Work v2 = new Work(arg12, arg10, arg11);
            Object v10 = this.lock;
            __monitor_enter(v10);
            try {
                if((this.closed) || !Intrinsics.areEqual(arg12, this.session)) {
                    v1 = this;
                    Boolean.valueOf(GoldenStretchBackendAdapter.finish$default(v1, v2, StretchExecutionStatus.SESSION_INVALIDATED, StretchTransportError.SESSION_INVALIDATED, null, null, 24, null));
                }
                else if(this.active != null) {
                    v1 = this;
                    Boolean.valueOf(GoldenStretchBackendAdapter.finish$default(v1, v2, StretchExecutionStatus.REJECTED, StretchTransportError.BUSY, null, null, 24, null));
                }
                else {
                    v1 = this;
                    v1.active = v2;
                    v2.setDeadline(v1.timer.schedule(new GoldenStretchBackendAdapter$$ExternalSyntheticLambda3(v1, v2), arg13, TimeUnit.MILLISECONDS));
                    v1.worker.execute(new GoldenStretchBackendAdapter$$ExternalSyntheticLambda4(v1, v2, arg11));
                }
            }
            catch(Throwable v0) {
                __monitor_exit(v10);
                throw v0;
            }

            __monitor_exit(v10);
            return new StretchPendingOperation(v2.getId(), arg12, v2.getResult(), new GoldenStretchBackendAdapter$$ExternalSyntheticLambda5(v1, v2));
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static StretchPendingOperation submit$default(GoldenStretchBackendAdapter arg6, StretchQuery arg7, StretchBackendType arg8, String arg9, long arg10, int arg12, Object arg13) {
        if((arg12 & 2) != 0) {
            arg8 = null;
        }

        StretchBackendType v2 = arg8;
        if((arg12 & 4) != 0) {
            arg9 = arg6.getSessionId();
        }

        String v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = 2500;
        }

        return arg6.submit(arg7, v2, v3, arg10);
    }

    static final void submit$lambda$10$lambda$8(GoldenStretchBackendAdapter arg2, Work arg3) {
        arg2.stop(arg3, StretchExecutionStatus.TIMED_OUT, StretchTransportError.TIMEOUT);
    }

    static final void submit$lambda$10$lambda$9(GoldenStretchBackendAdapter arg0, Work arg1, StretchBackendType arg2) {
        arg0.execute(arg1, arg2);
    }

    static final Unit submit$lambda$11(GoldenStretchBackendAdapter arg2, Work arg3) {
        arg2.stop(arg3, StretchExecutionStatus.CANCELLED, StretchTransportError.CANCELLED);
        return Unit.INSTANCE;
    }

    static final Thread timer$lambda$3(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchDeadline");
        v0.setDaemon(true);
        return v0;
    }

    static final Thread worker$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchQuery");
        v0.setDaemon(true);
        return v0;
    }
}

