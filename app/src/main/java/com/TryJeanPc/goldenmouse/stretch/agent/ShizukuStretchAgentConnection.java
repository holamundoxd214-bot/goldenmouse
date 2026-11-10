package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder$DeathRecipient;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.StructStat;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import rikka.shizuku.Shizuku$UserServiceArgs;
import rikka.shizuku.Shizuku;

@Metadata(d1={"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002:=\b\u0007\u0018\u0000 S2\u00060\u0001j\u0002`\u0002:\u0001SB-\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BB\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\fJ\u0019\u00100\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t01H\u0000¢\u0006\u0002\b2J\f\u0010?\u001A\b\u0012\u0004\u0012\u00020\u001E0\u0015J\u0010\u0010@\u001A\u00020\t2\u0006\u0010A\u001A\u00020,H\u0002J\u0018\u0010B\u001A\u00020C2\u0006\u0010A\u001A\u00020,2\u0006\u0010D\u001A\u00020EH\u0002J\u001E\u0010F\u001A\b\u0012\u0004\u0012\u00020*0\u00152\u0006\u0010G\u001A\u00020H2\u0006\u0010D\u001A\u00020EH\u0002J:\u0010I\u001A\b\u0012\u0004\u0012\u00020J0\u00152\u0006\u0010G\u001A\u00020K2\u0006\u0010D\u001A\u00020E2\b\u0010L\u001A\u0004\u0018\u00010M2\b\u0010N\u001A\u0004\u0018\u00010,2\u0006\u0010O\u001A\u00020\u0006H\u0002J\r\u0010P\u001A\u00020\u0006H\u0000¢\u0006\u0002\bQJ\b\u0010R\u001A\u00020\u0016H\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0010\u001A\n \u0011*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001B\u001A\n \u0011*\u0004\u0018\u00010\u001C0\u001CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001E0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010)\u001A\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010+\u001A\u0004\u0018\u00010,X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010-\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R#\u00103\u001A\n \u0011*\u0004\u0018\u000104048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001A\u0004\b5\u00106R\u0010\u00109\u001A\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;R\u0010\u0010<\u001A\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>¨\u0006T"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "context", "Landroid/content/Context;", "rescueOnly", "", "freshTrial", "existingRescue", "", "<init>", "(Landroid/content/Context;ZZLjava/lang/String;)V", "(Landroid/content/Context;Z)V", "tagSuffix", "getTagSuffix$app", "()Ljava/lang/String;", "application", "kotlin.jvm.PlatformType", "closed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "bindingClosed", "Ljava/util/concurrent/CompletableFuture;", "", "started", "bound", "worker", "Ljava/util/concurrent/ThreadPoolExecutor;", "deadline", "Ljava/util/concurrent/ScheduledExecutorService;", "result", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentClient;", "challenge", "originalProgress", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalProgressTracker;", "attested", "Ljava/util/concurrent/atomic/AtomicReference;", "peerUid", "Ljava/util/concurrent/atomic/AtomicInteger;", "journalDelegated", "physicalBusy", "physicalUnknown", "activePhysical", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalReply;", "serviceBinder", "Landroid/os/IBinder;", "client", "diagnostics", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentConnectionDiagnostics;", "diagnosticSnapshot", "", "diagnosticSnapshot$app", "args", "Lrikka/shizuku/Shizuku$UserServiceArgs;", "getArgs", "()Lrikka/shizuku/Shizuku$UserServiceArgs;", "args$delegate", "Lkotlin/Lazy;", "callback", "com/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection$callback$1", "Lcom/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection$callback$1;", "connection", "com/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection$connection$1", "Lcom/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection$connection$1;", "connect", "attest", "service", "transact", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "request", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "physicalCall", "operation", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalOperation;", "experimentCall", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentReply;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentOperation;", "evidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "endpoint", "confirmed", "closeAndAwaitAgentDeath", "closeAndAwaitAgentDeath$app", "close", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ShizukuStretchAgentConnection implements AutoCloseable {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\fJ\u0016\u0010\r\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection$Companion;", "", "<init>", "()V", "CONNECT_TIMEOUT_SECONDS", "", "READ_TIMEOUT_MILLIS", "forManualTrial", "Lcom/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection;", "context", "Landroid/content/Context;", "rescueOnly", "", "existingRescue", "tag", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final ShizukuStretchAgentConnection existingRescue(Context arg7, String arg8) {
            Intrinsics.checkNotNullParameter(arg7, "context");
            Intrinsics.checkNotNullParameter(arg8, "tag");
            if(new Regex("_[0-9a-f-]{36}").matches(arg8)) {
                return new ShizukuStretchAgentConnection(arg7, true, false, arg8, null);
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public final ShizukuStretchAgentConnection forManualTrial(Context arg8, boolean arg9) {
            Intrinsics.checkNotNullParameter(arg8, "context");
            return new ShizukuStretchAgentConnection(arg8, arg9, true, null, 8, null);
        }

        public static ShizukuStretchAgentConnection forManualTrial$default(Companion arg0, Context arg1, boolean arg2, int arg3, Object arg4) {
            return arg0.forManualTrial(arg1, false);
        }
    }

    public static final int $stable = 0;
    public static final long CONNECT_TIMEOUT_SECONDS = 12;
    public static final Companion Companion = null;
    public static final long READ_TIMEOUT_MILLIS = 4000;
    private volatile CompletableFuture activePhysical;
    private final Context application;
    private final Lazy args$delegate;
    private final AtomicReference attested;
    private final CompletableFuture bindingClosed;
    private final AtomicBoolean bound;
    private final ShizukuStretchAgentConnection$callback$1 callback;
    private final String challenge;
    private volatile StretchAgentClient client;
    private final AtomicBoolean closed;
    private final ShizukuStretchAgentConnection$connection$1 connection;
    private final ScheduledExecutorService deadline;
    private final StretchAgentConnectionDiagnostics diagnostics;
    private final String existingRescue;
    private final AtomicBoolean journalDelegated;
    private final StretchOriginalProgressTracker originalProgress;
    private final AtomicInteger peerUid;
    private final AtomicBoolean physicalBusy;
    private volatile boolean physicalUnknown;
    private final boolean rescueOnly;
    private final CompletableFuture result;
    private volatile IBinder serviceBinder;
    private final AtomicBoolean started;
    private final String tagSuffix;
    private final ThreadPoolExecutor worker;

    static {
        ShizukuStretchAgentConnection.Companion = new Companion(null);
        ShizukuStretchAgentConnection.$stable = 8;
    }

    public ShizukuStretchAgentConnection(Context arg9, boolean arg10) {
        Intrinsics.checkNotNullParameter(arg9, "context");
        this(arg9, arg10, false, null, 8, null);
    }

    ShizukuStretchAgentConnection(Context arg1, boolean arg2, boolean arg3, String arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 8) != 0) {
            arg4 = null;
        }

        this(arg1, arg2, arg3, arg4);
    }

    public ShizukuStretchAgentConnection(Context arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, false);
    }

    private ShizukuStretchAgentConnection(Context arg9, boolean arg10, boolean arg11, String arg12) {
        String v10;
        super();
        this.rescueOnly = arg10;
        this.existingRescue = arg12;
        if(arg12 != null) {
            v10 = arg12;
        }
        else if(arg11) {
            v10 = "_" + UUID.randomUUID();
        }
        else {
            v10 = "";
        }

        this.tagSuffix = v10;
        this.application = arg9.getApplicationContext();
        this.closed = new AtomicBoolean();
        this.bindingClosed = new CompletableFuture();
        this.started = new AtomicBoolean();
        this.bound = new AtomicBoolean();
        this.worker = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(4), new ShizukuStretchAgentConnection$$ExternalSyntheticLambda2());
        this.deadline = Executors.newSingleThreadScheduledExecutor(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda3());
        this.result = new CompletableFuture();
        String v9 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v9, "toString(...)");
        this.challenge = v9;
        this.originalProgress = new StretchOriginalProgressTracker(v9);
        this.attested = new AtomicReference();
        this.peerUid = new AtomicInteger(-1);
        arg10 = arg12 != null ? true : false;
        this.journalDelegated = new AtomicBoolean(arg10);
        this.physicalBusy = new AtomicBoolean();
        this.diagnostics = new StretchAgentConnectionDiagnostics();
        this.args$delegate = LazyKt.lazy(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda4(this));
        this.callback = new ShizukuStretchAgentConnection$callback$1(this);
        this.connection = new ShizukuStretchAgentConnection$connection$1(this);
    }

    public ShizukuStretchAgentConnection(Context arg1, boolean arg2, boolean arg3, String arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public static final String access$attest(ShizukuStretchAgentConnection arg0, IBinder arg1) {
        return arg0.attest(arg1);
    }

    public static final CompletableFuture access$experimentCall(ShizukuStretchAgentConnection arg0, StretchExperimentOperation arg1, StretchAgentRequest arg2, StretchOriginalEvidence arg3, IBinder arg4, boolean arg5) {
        return arg0.experimentCall(arg1, arg2, arg3, arg4, arg5);
    }

    public static final AtomicReference access$getAttested$p(ShizukuStretchAgentConnection arg0) {
        return arg0.attested;
    }

    public static final String access$getChallenge$p(ShizukuStretchAgentConnection arg0) {
        return arg0.challenge;
    }

    public static final StretchAgentClient access$getClient$p(ShizukuStretchAgentConnection arg0) {
        return arg0.client;
    }

    public static final AtomicBoolean access$getClosed$p(ShizukuStretchAgentConnection arg0) {
        return arg0.closed;
    }

    public static final StretchAgentConnectionDiagnostics access$getDiagnostics$p(ShizukuStretchAgentConnection arg0) {
        return arg0.diagnostics;
    }

    public static final StretchOriginalProgressTracker access$getOriginalProgress$p(ShizukuStretchAgentConnection arg0) {
        return arg0.originalProgress;
    }

    public static final AtomicInteger access$getPeerUid$p(ShizukuStretchAgentConnection arg0) {
        return arg0.peerUid;
    }

    public static final boolean access$getPhysicalUnknown$p(ShizukuStretchAgentConnection arg0) {
        return arg0.physicalUnknown;
    }

    public static final CompletableFuture access$getResult$p(ShizukuStretchAgentConnection arg0) {
        return arg0.result;
    }

    public static final ThreadPoolExecutor access$getWorker$p(ShizukuStretchAgentConnection arg0) {
        return arg0.worker;
    }

    public static final CompletableFuture access$physicalCall(ShizukuStretchAgentConnection arg0, StretchPhysicalOperation arg1, StretchAgentRequest arg2) {
        return arg0.physicalCall(arg1, arg2);
    }

    public static final void access$setClient$p(ShizukuStretchAgentConnection arg0, StretchAgentClient arg1) {
        arg0.client = arg1;
    }

    public static final void access$setServiceBinder$p(ShizukuStretchAgentConnection arg0, IBinder arg1) {
        arg0.serviceBinder = arg1;
    }

    public static final StretchAgentReply access$transact(ShizukuStretchAgentConnection arg0, IBinder arg1, StretchAgentRequest arg2) {
        return arg0.transact(arg1, arg2);
    }

    static final UserServiceArgs args_delegate$lambda$4(ShizukuStretchAgentConnection arg4) {
        String v2 = arg4.application.getPackageName();
        Class v3 = arg4.rescueOnly ? GoldenStretchRescueService.class : GoldenStretchDisplayService.class;
        UserServiceArgs v0 = new UserServiceArgs(new ComponentName(v2, v3.getName()));
        v2 = "golden_stretch_rescue_v1";
        String v3_1 = "golden_stretch_display_v2";
        String v1 = arg4.rescueOnly ? v2 : v3_1;
        v0 = v0.processNameSuffix(v1);
        if(arg4.rescueOnly) {
        }
        else {
            v2 = v3_1;
        }

        return v0.tag(v2 + arg4.tagSuffix).version(13).debuggable(false).daemon(true);
    }

    private final String attest(IBinder arg5) {
        String v5_1;
        Parcel v0 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v0, "obtain(...)");
        Parcel v2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v2, "obtain(...)");
        try {
            v0.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.agent.v2");
            v0.writeInt(2);
            v0.writeString(this.challenge);
            v0.writeStrongBinder(this.callback);
            this.diagnostics.setStep(StretchConnectStep.ATTEST_TRANSACT);
            boolean v5 = arg5.transact(1, v0, v2, 0);
        }
        catch(Throwable v4) {
            goto label_50;
        }

        String v1 = "Failed requirement.";
        if(!v5) {
            goto label_45;
        }

        try {
            this.diagnostics.setStep(StretchConnectStep.ATTEST_REPLY);
            StretchAgentWire.INSTANCE.bounded(v2);
            v2.readException();
            this.diagnostics.setStep(StretchConnectStep.ATTEST_GENERATION);
            v5_1 = StretchAgentWire.INSTANCE.text(v2);
            StretchAgentWire.INSTANCE.exhausted(v2);
            if(!Intrinsics.areEqual(this.attested.get(), v5_1)) {
                goto label_41;
            }
        }
        catch(Throwable v4) {
            goto label_50;
        }

        v0.recycle();
        v2.recycle();
        return v5_1;
        try {
        label_41:
            throw new IllegalArgumentException(v1.toString());
        label_45:
            throw new IllegalArgumentException(v1.toString());
        }
        catch(Throwable v4) {
        label_50:
            v0.recycle();
            v2.recycle();
            throw v4;
        }
    }

    public void close() {
        if(!this.closed.compareAndSet(false, true)) {
            return;
        }

        this.originalProgress.end();
        CompletableFuture v0 = this.activePhysical;
        if(v0 != null) {
            v0.completeExceptionally(new IllegalStateException("Connection closed; remote result unknown"));
        }

        StretchAgentClient v0_1 = this.client;
        if(v0_1 != null) {
            v0_1.shutdown$app();
        }

        this.result.completeExceptionally(new IllegalStateException("Connection closed"));
        this.deadline.shutdownNow();
        this.worker.shutdownNow();
        StretchAgentBindingCleanupKt.closeStretchAgentBinding(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda8(this)).whenComplete(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda10(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda9(this)));
    }

    static final Unit close$lambda$27(ShizukuStretchAgentConnection arg2) {
        if(arg2.bound.get()) {
            Shizuku.unbindUserService(arg2.getArgs(), arg2.connection, arg2.journalDelegated.get() ^ 1);
        }

        return Unit.INSTANCE;
    }

    static final Unit close$lambda$28(ShizukuStretchAgentConnection arg0, Unit arg1, Throwable arg2) {
        CompletableFuture v0 = arg0.bindingClosed;
        if(arg2 == null) {
            v0.complete(Unit.INSTANCE);
        }
        else {
            v0.completeExceptionally(arg2);
        }

        return Unit.INSTANCE;
    }

    static final void close$lambda$29(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }

    public final boolean closeAndAwaitAgentDeath$app() {
        int v1_1;
        long v6;
        if(!this.journalDelegated.get() && !this.physicalUnknown) {
            IBinder v0 = this.serviceBinder;
            if(v0 != null) {
                CompletableFuture v1 = new CompletableFuture();
                ShizukuStretchAgentConnection$$ExternalSyntheticLambda7 v2 = new ShizukuStretchAgentConnection$$ExternalSyntheticLambda7(v1);
                try {
                    v6 = 3;
                    if(!v0.isBinderAlive()) {
                        this.close();
                        this.bindingClosed.get(v6, TimeUnit.SECONDS);
                    }
                    else {
                        goto label_30;
                    }
                }
                catch(Throwable v9) {
                    goto label_53;
                }

                try {
                    Result.constructor-impl(Boolean.valueOf(v0.unlinkToDeath(((IBinder$DeathRecipient)v2), 0)));
                    return 1;
                }
                catch(Throwable v9) {
                    Result.constructor-impl(ResultKt.createFailure(v9));
                    return 1;
                }

                try {
                label_30:
                    v0.linkToDeath(((IBinder$DeathRecipient)v2), 0);
                    this.close();
                    this.bindingClosed.get(v6, TimeUnit.SECONDS);
                    if(v0.isBinderAlive()) {
                        v1.get(6, TimeUnit.SECONDS);
                    }

                    v1_1 = v0.isBinderAlive() ^ 1;
                }
                catch(Throwable v9) {
                    try {
                    label_53:
                        Result.constructor-impl(Boolean.valueOf(v0.unlinkToDeath(((IBinder$DeathRecipient)v2), 0)));
                    }
                    catch(Throwable v0_1) {
                        Result.constructor-impl(ResultKt.createFailure(v0_1));
                    }

                    throw v9;
                }

                try {
                    Result.constructor-impl(Boolean.valueOf(v0.unlinkToDeath(((IBinder$DeathRecipient)v2), 0)));
                    return ((boolean)v1_1);
                }
                catch(Throwable v9) {
                    Result.constructor-impl(ResultKt.createFailure(v9));
                    return ((boolean)v1_1);
                }
            }
            else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }

        throw new IllegalStateException("Check failed.");
    }

    static final void closeAndAwaitAgentDeath$lambda$25(CompletableFuture arg1) {
        arg1.complete(Unit.INSTANCE);
    }

    public final CompletableFuture connect() {
        if(this.started.compareAndSet(false, true)) {
            if(this.closed.get()) {
            }
            else {
                this.deadline.schedule(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda11(this), 12, TimeUnit.SECONDS);
                this.worker.execute(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda12(this));
                this.result.whenComplete(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda1(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda13(this)));
                return this.result;
            }
        }

        CompletableFuture v5 = new CompletableFuture();
        v5.completeExceptionally(new IllegalStateException("Connection already used"));
        return v5;
    }

    static final void connect$lambda$10(ShizukuStretchAgentConnection arg6) {
        try {
            arg6.diagnostics.setStep(StretchConnectStep.SHIZUKU_CHECK);
            boolean v0_1 = Shizuku.pingBinder();
            arg6.diagnostics.setBackendRunning(v0_1);
            boolean v2 = !v0_1 || Shizuku.checkSelfPermission() != 0 ? false : true;
            int v3 = -1;
            int v4 = v2 ? Shizuku.getVersion() : v3;
            if(v2) {
                v3 = Shizuku.getUid();
            }

            arg6.diagnostics.setBackendVersion(v4);
            arg6.diagnostics.setBackendUid(v3);
            arg6.diagnostics.setPermissionGranted(v2);
            StretchCompatibilityKt.requireStretchShizuku(v0_1, v4, v3, v2);
            if(arg6.closed.get()) {
                return;
            }

            arg6.diagnostics.setStep(StretchConnectStep.USER_SERVICE_ARGS);
            UserServiceArgs v0_2 = arg6.getArgs();
            arg6.diagnostics.setStep(StretchConnectStep.BIND_USER_SERVICE);
            arg6.bound.set(true);
            if(arg6.existingRescue == null) {
                Shizuku.bindUserService(v0_2, arg6.connection);
            }
            else if(Shizuku.peekUserService(v0_2, arg6.connection) >= 0) {
            }
            else {
                throw new IllegalStateException("RESCUE_PROCESS_ABSENT".toString());
            }

            arg6.diagnostics.setBindReturned(true);
            if(!arg6.diagnostics.getServiceConnected()) {
                arg6.diagnostics.setStep(StretchConnectStep.WAIT_SERVICE);
            }

            if(!arg6.closed.get()) {
                return;
            }
        }
        catch(Exception v0) {
            goto label_82;
        }

        try {
            Shizuku.unbindUserService(arg6.getArgs(), arg6.connection, 1 ^ arg6.journalDelegated.get());
            Result.constructor-impl(Unit.INSTANCE);
            return;
        }
        catch(Throwable v0_3) {
            try {
                Result.constructor-impl(ResultKt.createFailure(v0_3));
            }
            catch(Exception v0) {
            label_82:
                StretchAgentConnectionDiagnostics.failed$default(arg6.diagnostics, v0, null, 2, null);
                arg6.result.completeExceptionally(((Throwable)v0));
                arg6.close();
            }
        }
    }

    static final Unit connect$lambda$11(ShizukuStretchAgentConnection arg0, StretchAgentClient arg1, Throwable arg2) {
        if(arg2 != null) {
            arg0.close();
        }

        return Unit.INSTANCE;
    }

    static final void connect$lambda$12(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }

    static final void connect$lambda$6(ShizukuStretchAgentConnection arg5) {
        if(!arg5.result.isDone()) {
            StretchCompatibilityFailure v0 = new StretchCompatibilityFailure("AGENT_CONNECT_TIMEOUT", null, 2, null);
            StretchAgentConnectionDiagnostics.failed$default(arg5.diagnostics, v0, null, 2, null);
            if(arg5.result.completeExceptionally(((Throwable)v0))) {
                arg5.close();
            }
        }
    }

    static final Thread deadline$lambda$3(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchAgentConnectDeadline");
        v0.setDaemon(true);
        return v0;
    }

    public final Map diagnosticSnapshot$app() {
        return MapsKt.plus(this.diagnostics.snapshot(), this.originalProgress.snapshot());
    }

    private final CompletableFuture experimentCall(StretchExperimentOperation arg10, StretchAgentRequest arg11, StretchOriginalEvidence arg12, IBinder arg13, boolean arg14) {
        CompletableFuture v7 = new CompletableFuture();
        if(this.closed.get()) {
            v7.completeExceptionally(new IllegalStateException("Connection closed"));
            return v7;
        }

        if(arg10 == StretchExperimentOperation.ARM) {
            this.journalDelegated.set(true);
        }

        try {
            this.worker.execute(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda0(this, arg11, arg10, arg12, arg13, arg14, v7));
            return v7;
        }
        catch(Exception v0) {
            v7.completeExceptionally(v0);
            return v7;
        }
    }

    static final void experimentCall$lambda$24(ShizukuStretchAgentConnection arg28, StretchAgentRequest arg29, StretchExperimentOperation arg30, StretchOriginalEvidence arg31, IBinder arg32, boolean arg33, CompletableFuture arg34) {
        StretchOriginalEvidence v11_1;
        ParcelFileDescriptor v2_2;
        int v6_1;
        ShizukuStretchAgentConnection v0 = arg28;
        StretchExperimentOperation v1 = arg30;
        StretchOriginalEvidence v2 = arg31;
        IBinder v3 = arg32;
        CompletableFuture v4 = arg34;
        Parcel v5 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v5, "obtain(...)");
        Parcel v7 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v7, "obtain(...)");
        try {
            boolean v6 = v0.closed.get();
        }
        catch(Exception v0_1) {
            goto label_198;
        }
        catch(Throwable v0_2) {
            goto label_200;
        }

        String v8 = "Check failed.";
        if(!v6) {
            try {
                if(Intrinsics.areEqual(arg29.getAgentGeneration(), v0.attested.get())) {
                    v5.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.agent.v2");
                    v6_1 = 3;
                    v5.writeInt(v6_1);
                    v5.writeString(v0.challenge);
                    v5.writeInt(v1.ordinal());
                    boolean v9 = StretchExperimentRpc.INSTANCE.acceptsFactor(arg29.getLogicalDisplayId(), arg29.getFactorHundredths());
                    goto label_31;
                }

                goto label_192;
            }
            catch(Exception v0_1) {
                goto label_198;
            }
            catch(Throwable v0_2) {
                goto label_200;
            }

        label_31:
            String v10 = "Failed requirement.";
            if(v9) {
                try {
                    StretchAgentWire.INSTANCE.writeRequest(v5, StretchAgentRequest.copy$default(arg29, 0, null, null, null, null, 0, StretchAgentAction.STATUS, null, null, 0, null, 0x7BF, null));
                    StretchExperimentOperation v9_1 = StretchExperimentOperation.ARM;
                }
                catch(Exception v0_1) {
                    goto label_198;
                }
                catch(Throwable v0_2) {
                    goto label_200;
                }

                Throwable v11 = null;
                String v12 = "Required value was null.";
                if(v1 == v9_1) {
                    try {
                        StretchOriginalEvidenceCodec v9_2 = StretchOriginalEvidenceCodec.INSTANCE;
                        if(v2 != null) {
                            v5.writeString(v9_2.encode(v2));
                            if(v3 != null) {
                                v5.writeStrongBinder(v3);
                                AndroidStretchCandidateJournal v2_1 = AndroidStretchCandidateJournal.INSTANCE;
                                Context v3_1 = v0.application;
                                Intrinsics.checkNotNullExpressionValue(v3_1, "application");
                                v2_2 = v2_1.delegate$app(v3_1);
                                goto label_66;
                            }
                            else {
                                goto label_83;
                            }
                        }
                        else {
                            goto label_87;
                        }

                        goto label_95;
                    }
                    catch(Exception v0_1) {
                        goto label_198;
                    }
                    catch(Throwable v0_2) {
                        goto label_200;
                    }

                label_66:
                    ParcelFileDescriptor v3_2 = v2_2;
                    try {
                        StructStat v9_3 = Os.fstat(v3_2.getFileDescriptor());
                        v5.writeLong(v9_3.st_dev);
                        v5.writeLong(v9_3.st_ino);
                        v3_2.writeToParcel(v5, 0);
                        goto label_75;
                    }
                    catch(Throwable v0_2) {
                        Throwable v1_1 = v0_2;
                        try {
                            throw v1_1;
                        }
                        catch(Throwable v0_2) {
                            try {
                                CloseableKt.closeFinally(((Closeable)v2_2), v1_1);
                                throw v0_2;
                            label_75:
                                CloseableKt.closeFinally(((Closeable)v2_2), v11);
                                goto label_95;
                            label_83:
                                throw new IllegalArgumentException(v12.toString());
                            label_87:
                                throw new IllegalArgumentException(v12.toString());
                            label_91:
                                if(v1 == StretchExperimentOperation.VERIFY_EXECUTOR) {
                                    v5.writeInt(arg33);
                                }

                            label_95:
                                StretchAgentWire.INSTANCE.bounded(v5);
                                IBinder v2_3 = v0.serviceBinder;
                                if(v2_3 != null) {
                                    if(v2_3.transact(5, v5, v7, 0)) {
                                        StretchAgentWire.INSTANCE.bounded(v7);
                                        v7.readException();
                                        String v15 = StretchAgentWire.INSTANCE.text(v7);
                                        IBinder v16 = v7.readStrongBinder();
                                        int v2_4 = v7.readInt();
                                        if(v2_4 >= 0) {
                                            int v3_3 = 2;
                                            if(v2_4 < v3_3) {
                                                if(v2_4 == 1) {
                                                    v11_1 = StretchOriginalEvidenceCodec.INSTANCE.decode(StretchExperimentRpc.INSTANCE.json(v7));
                                                }

                                                if(StretchExperimentRpc.INSTANCE.acceptsReadback(v1, arg29, v15, v11_1)) {
                                                    long v18 = v7.readLong();
                                                    long v20 = v7.readLong();
                                                    long v22 = v7.readLong();
                                                    Long[] v1_2 = new Long[v6_1];
                                                    v1_2[0] = Long.valueOf(v18);
                                                    v1_2[1] = Long.valueOf(v20);
                                                    v1_2[v3_3] = Long.valueOf(v22);
                                                    List v1_3 = CollectionsKt.listOf(((Object[])v1_2));
                                                    if(!(v1_3 instanceof Collection) || !v1_3.isEmpty()) {
                                                        Iterator v1_4 = ((Iterable)v1_3).iterator();
                                                        while(true) {
                                                            if(v1_4.hasNext()) {
                                                                if(v1_4.next().longValue() >= -1) {
                                                                    continue;
                                                                }
                                                                else {
                                                                    break;
                                                                }
                                                            }

                                                            goto label_151;
                                                        }

                                                        throw new IllegalArgumentException(v10.toString());
                                                    }
                                                    else {
                                                    }

                                                label_151:
                                                    StretchExperimentReply v14 = new StretchExperimentReply(v15, v16, v11_1, v18, v20, v22);
                                                    StretchAgentWire.INSTANCE.exhausted(v7);
                                                    String[] v1_5 = new String[v6_1];
                                                    v1_5[0] = "NO_MUTATION_CLOSED";
                                                    v1_5[1] = "RESTORE_VERIFIED_CLOSED";
                                                    v1_5[v3_3] = "ORIGINAL_VERIFIED_CLOSED";
                                                    if(SetsKt.setOf(((Object[])v1_5)).contains(v14.getCode())) {
                                                        v0.journalDelegated.set(false);
                                                    }

                                                    v4.complete(v14);
                                                    goto label_170;
                                                }

                                                throw new IllegalArgumentException(v10.toString());
                                            }
                                        }

                                        throw new IllegalArgumentException(v10.toString());
                                    }

                                    throw new IllegalStateException(v8);
                                }

                                throw new IllegalArgumentException(v12.toString());
                            label_188:
                                throw new IllegalArgumentException(v10.toString());
                            label_192:
                                throw new IllegalStateException(v8);
                            }
                            catch(Throwable v0_2) {
                            label_200:
                                v5.recycle();
                                v7.recycle();
                                throw v0_2;
                            }
                            catch(Exception v0_1) {
                                try {
                                label_198:
                                    v4.completeExceptionally(((Throwable)v0_1));
                                }
                                catch(Throwable v0_2) {
                                    goto label_200;
                                }

                            label_170:
                                v5.recycle();
                                v7.recycle();
                                return;
                            }
                        }
                    }
                }
                else {
                    goto label_91;
                }

                goto label_95;
            }
            else {
                goto label_188;
            }
        }

        goto label_192;
    }

    private final UserServiceArgs getArgs() {
        return this.args$delegate.getValue();
    }

    public final String getTagSuffix$app() {
        return this.tagSuffix;
    }

    private final CompletableFuture physicalCall(StretchPhysicalOperation arg10, StretchAgentRequest arg11) {
        StretchAgentRequest v2;
        StretchPhysicalOperation v3;
        ThreadPoolExecutor v8;
        ScheduledFuture v5;
        ShizukuStretchAgentConnection v1;
        Exception v10;
        CompletableFuture v6 = new CompletableFuture();
        if(!this.closed.get()) {
            if(!this.physicalBusy.compareAndSet(false, true)) {
            }
            else {
                boolean v4 = this.journalDelegated.getAndSet(true);
                this.activePhysical = v6;
                try {
                    if(arg10 != StretchPhysicalOperation.RECOVER_PERSISTED) {
                    }
                    else {
                        goto label_25;
                    }
                }
                catch(Exception v0) {
                    goto label_42;
                }

                try {
                    if(arg10 != StretchPhysicalOperation.RESTORE) {
                        goto label_19;
                    }
                }
                catch(Exception v0) {
                    v10 = v0;
                    v1 = this;
                    goto label_44;
                }

                goto label_25;
            label_19:
                long v0_1 = 4;
                goto label_26;
            label_25:
                v0_1 = 30;
                try {
                label_26:
                    v5 = this.deadline.schedule(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda5(this, v6), v0_1, TimeUnit.SECONDS);
                    v8 = this.worker;
                    v1 = this;
                    v3 = arg10;
                    v2 = arg11;
                }
                catch(Exception v0) {
                label_42:
                    v1 = this;
                    goto label_43;
                }

                try {
                    v8.execute(new ShizukuStretchAgentConnection$$ExternalSyntheticLambda6(v1, v2, v3, v4, v5, v6));
                    return v6;
                }
                catch(Exception v0) {
                }

            label_43:
                v10 = v0;
            label_44:
                v1.journalDelegated.set(v4);
                v1.physicalBusy.set(false);
                v1.activePhysical = null;
                v6.completeExceptionally(((Throwable)v10));
                return v6;
            }
        }

        v6.completeExceptionally(new IllegalStateException("Paired connection closed or busy"));
        return v6;
    }

    static final void physicalCall$lambda$15(ShizukuStretchAgentConnection arg1, CompletableFuture arg2) {
        arg1.physicalUnknown = true;
        arg2.completeExceptionally(new TimeoutException("Paired RPC outcome unknown"));
    }

    static final void physicalCall$lambda$19(ShizukuStretchAgentConnection arg26, StretchAgentRequest arg27, StretchPhysicalOperation arg28, boolean arg29, ScheduledFuture arg30, CompletableFuture arg31) {
        Exception v10_4;
        StretchPhysicalReply v10_3;
        int v11_2;
        ParcelFileDescriptor v10_2;
        IBinder v0_2;
        ShizukuStretchAgentConnection v1 = arg26;
        ScheduledFuture v2 = arg30;
        CompletableFuture v3 = arg31;
        String v4 = "Required value was null.";
        Parcel v5 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v5, "obtain(...)");
        Parcel v6 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v6, "obtain(...)");
        CompletableFuture v9 = null;
        try {
            if(!v1.closed.get() && (Intrinsics.areEqual(arg27.getAgentGeneration(), v1.attested.get()))) {
                v0_2 = v1.serviceBinder;
                if(v0_2 != null) {
                    v5.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.agent.v2");
                    v5.writeInt(1);
                    v5.writeString(v1.challenge);
                    v5.writeInt(arg28.ordinal());
                    StretchAgentWire.INSTANCE.writeRequest(v5, StretchAgentRequest.copy$default(arg27, 0, null, null, null, null, 0, StretchAgentAction.STATUS, null, null, 0, null, 0x3BF, null));
                    boolean v10 = SetsKt.setOf(new StretchPhysicalOperation[]{StretchPhysicalOperation.PREPARE, StretchPhysicalOperation.RECOVER_PERSISTED}).contains(arg28);
                    v5.writeInt(((int)v10));
                    if(v10) {
                        AndroidStretchCandidateJournal v10_1 = AndroidStretchCandidateJournal.INSTANCE;
                        Context v11 = v1.application;
                        Intrinsics.checkNotNullExpressionValue(v11, "application");
                        v10_2 = v10_1.delegate$app(v11);
                    }
                    else {
                        goto label_63;
                    }

                    goto label_64;
                }
                else {
                    goto label_147;
                }
            }

            goto label_151;
        }
        catch(Throwable v0) {
            goto label_156;
        }
        catch(Exception v0_1) {
            goto label_159;
        }

    label_63:
        v10_2 = ((ParcelFileDescriptor)v9);
    label_64:
        if(v10_2 != null) {
            try {
                StructStat v11_1 = Os.fstat(v10_2.getFileDescriptor());
                v5.writeLong(v11_1.st_dev);
                v5.writeLong(v11_1.st_ino);
                v10_2.writeToParcel(v5, 0);
            label_76:
                StretchAgentWire.INSTANCE.bounded(v5);
                v11_2 = 4;
                goto label_79;
            label_74:
                v11_2 = 0;
                goto label_140;
            }
            catch(Throwable v0) {
                goto label_74;
            }
        }

        goto label_76;
        try {
        label_79:
            boolean v0_3 = v0_2.transact(v11_2, v5, v6, 0);
        }
        catch(Throwable v0) {
            goto label_139;
        }

        String v11_3 = "Failed requirement.";
        if(!v0_3) {
            goto label_134;
        }

        if(v10_2 != null) {
            try {
                v10_2.close();
            label_89:
                StretchAgentWire.INSTANCE.bounded(v6);
                v6.readException();
                v10_3 = StretchPhysicalRpc.INSTANCE.readReply(v6);
                if((Intrinsics.areEqual(v10_3.getOperationId(), arg27.getOperationId())) && (Intrinsics.areEqual(v10_3.getAgentGeneration(), arg27.getAgentGeneration()))) {
                    v1.journalDelegated.set(v10_3.getJournalRetained());
                    v1.physicalUnknown = false;
                    goto label_106;
                }

                goto label_130;
            }
            catch(Exception v0_1) {
                goto label_86;
            }
            catch(Throwable v0) {
                goto label_156;
            }
        }

        goto label_89;
    label_106:
        v2.cancel(false);
        v5.recycle();
        v6.recycle();
        v1.physicalBusy.set(false);
        v1.activePhysical = v9;
        if(!v1.closed.get()) {
        }
        else if(!v1.journalDelegated.get()) {
            try {
                Shizuku.unbindUserService(v1.getArgs(), v1.connection, true);
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }
        }
        else {
        }

        goto label_193;
        try {
        label_130:
            throw new IllegalArgumentException(v11_3.toString());
        label_86:
            v10_4 = v0_1;
            v11_2 = 1;
            goto label_161;
        }
        catch(Exception v0_1) {
            goto label_86;
        }
        catch(Throwable v0) {
            goto label_156;
        }

        try {
        label_134:
            throw new IllegalArgumentException(v11_3.toString());
        }
        catch(Throwable v0) {
        label_139:
            v11_2 = 1;
        }

    label_140:
        if(v10_2 != null) {
            try {
                v10_2.close();
            label_146:
                throw v0;
            label_144:
                v10_4 = v0_1;
                goto label_161;
            }
            catch(Exception v0_1) {
                goto label_144;
            }
        }

        goto label_146;
        try {
        label_147:
            throw new IllegalArgumentException(v4.toString());
        label_151:
            throw new IllegalStateException("Check failed.");
        }
        catch(Exception v0_1) {
        label_159:
            v10_4 = v0_1;
            v11_2 = 0;
        }

    label_161:
        if(v11_2 == 0) {
            try {
                v1.journalDelegated.set(arg29);
                goto label_167;
            label_166:
                v1.physicalUnknown = true;
            }
            catch(Throwable v0) {
                goto label_156;
            }
        }
        else {
            goto label_166;
        }

    label_167:
        v2.cancel(false);
        v5.recycle();
        v6.recycle();
        v1.physicalBusy.set(false);
        v1.activePhysical = v9;
        if((v1.closed.get()) && !v1.journalDelegated.get()) {
            try {
                Shizuku.unbindUserService(v1.getArgs(), v1.connection, true);
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }
        }

        Exception v25 = v10_4;
        v10_3 = ((StretchPhysicalReply)v9);
        Exception v9_1 = v25;
    label_193:
        if(v9_1 != null) {
            v3.completeExceptionally(((Throwable)v9_1));
        }
        else if(v10_3 != null) {
            v3.complete(v10_3);
        }
        else {
            goto label_199;
        }

        return;
    label_199:
        throw new IllegalArgumentException(v4.toString());
    label_156:
        Throwable v3_1 = v0;
        v2.cancel(false);
        v5.recycle();
        v6.recycle();
        v1.physicalBusy.set(false);
        v1.activePhysical = v9;
        if((v1.closed.get()) && !v1.journalDelegated.get()) {
            try {
                Shizuku.unbindUserService(v1.getArgs(), v1.connection, true);
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v0) {
                Result.constructor-impl(ResultKt.createFailure(v0));
            }
        }

        throw v3_1;
    }

    private final StretchAgentReply transact(IBinder arg7, StretchAgentRequest arg8) {
        StretchAgentReply v7_3;
        Parcel v0 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v0, "obtain(...)");
        Parcel v2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v2, "obtain(...)");
        boolean v1 = arg8.getOriginalEvidenceVersion() != null ? true : false;
        if(v1) {
            try {
                this.originalProgress.begin(arg8);
            label_14:
                ShizukuStretchAgentConnection.transact$step(v1, this, StretchOriginalRpcStage.ENCODE_REQUEST);
                v0.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.agent.v2");
                Integer v4 = arg8.getOriginalEvidenceVersion();
                if(v4 != null) {
                    v0.writeInt(((Number)v4).intValue());
                }

                StretchAgentWire.INSTANCE.writeRequest(v0, arg8);
                StretchAgentWire.INSTANCE.bounded(v0);
                ShizukuStretchAgentConnection.transact$step(v1, this, StretchOriginalRpcStage.TRANSACT);
                int v4_1 = arg8.getOriginalEvidenceVersion() == null ? 2 : 3;
                boolean v7_2 = arg7.transact(v4_1, v0, v2, 0);
                goto label_34;
            }
            catch(Throwable v7) {
                goto label_89;
            }
            catch(Exception v7_1) {
                goto label_85;
            }
        }

        goto label_14;
    label_34:
        String v3 = "Failed requirement.";
        if(v7_2) {
            try {
                ShizukuStretchAgentConnection.transact$step(v1, this, StretchOriginalRpcStage.READ_EXCEPTION);
                StretchAgentWire.INSTANCE.bounded(v2);
                v2.readException();
                ShizukuStretchAgentConnection.transact$step(v1, this, StretchOriginalRpcStage.DECODE_REPLY);
                v7_3 = arg8.getOriginalEvidenceVersion() == null ? StretchAgentWire.INSTANCE.readReply(v2) : StretchOriginalEvidenceRpc.INSTANCE.readReply(v2);
                if(v1) {
                    this.diagnostics.originalReply(v7_3, arg8);
                }

                ShizukuStretchAgentConnection.transact$step(v1, this, StretchOriginalRpcStage.TRAILING_DATA);
                StretchAgentWire.INSTANCE.exhausted(v2);
                ShizukuStretchAgentConnection.transact$step(v1, this, StretchOriginalRpcStage.EVIDENCE_BINDING);
                if(v7_3.getOriginalEvidence() != null) {
                    if(StretchOriginalEvidenceRpc.INSTANCE.boundTo(v7_3.getOriginalEvidence(), arg8)) {
                    }
                    else {
                        throw new IllegalArgumentException(v3.toString());
                    }
                }

                ShizukuStretchAgentConnection.transact$step(v1, this, StretchOriginalRpcStage.COMPLETE);
                if(v1) {
                    goto label_73;
                }

                goto label_75;
            }
            catch(Throwable v7) {
                goto label_89;
            }
            catch(Exception v7_1) {
                goto label_85;
            }

        label_73:
            this.originalProgress.end();
        label_75:
            v0.recycle();
            v2.recycle();
            return v7_3;
        }

        try {
            throw new IllegalArgumentException(v3.toString());
        }
        catch(Throwable v7) {
        }
        catch(Exception v7_1) {
        label_85:
            if(v1) {
                try {
                    this.diagnostics.originalFailed(v7_1);
                label_88:
                    throw v7_1;
                }
                catch(Throwable v7) {
                label_89:
                    if(v1) {
                        this.originalProgress.end();
                    }

                    v0.recycle();
                    v2.recycle();
                    throw v7;
                }
            }

            goto label_88;
        }
    }

    private static final void transact$step(boolean arg0, ShizukuStretchAgentConnection arg1, StretchOriginalRpcStage arg2) {
        if(arg0) {
            arg1.diagnostics.setOriginalRpcStage(arg2);
        }
    }

    static final Thread worker$lambda$1(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchAgentConnection");
        v0.setDaemon(true);
        return v0;
    }
}

