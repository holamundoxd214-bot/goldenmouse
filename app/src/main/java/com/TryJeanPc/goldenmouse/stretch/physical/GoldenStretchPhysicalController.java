package com.TryJeanPc.goldenmouse.stretch.physical;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.os.Build$VERSION;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchGeometryPlan;
import com.TryJeanPc.goldenmouse.stretch.StretchProjection$Defined;
import com.TryJeanPc.goldenmouse.stretch.StretchProjection;
import com.TryJeanPc.goldenmouse.stretch.agent.AndroidStretchCandidateJournal;
import com.TryJeanPc.goldenmouse.stretch.agent.ShizukuStretchAgentConnection;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchAgentAction;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchAgentBaseline;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchAgentClient;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchAgentCode;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchAgentReply;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchAgentRequest;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchCompatibilityFailure;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchCompatibilityKt;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchCompositorState;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchExperimentOperation;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchExperimentReply;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchExperimentRpc;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchOriginalEvidence;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchOriginalEvidenceRpc;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchPairRoute;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchPhysicalPair;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchPhysicalReply;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchProbeEvidence;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchReadOnlyPreflightKt;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchRecoveryCustodianKt;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatumState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryCodec;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B/\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000B\u0010\fJ\u0006\u0010\u0018\u001A\u00020\nJ\b\u0010\u0019\u001A\u00020\nH\u0002J\u0010\u0010=\u001A\u00020\n2\u0006\u0010>\u001A\u00020\tH\u0002J\b\u0010?\u001A\u00020\tH\u0002J\u0018\u0010@\u001A\u00020;2\u0006\u0010A\u001A\u0002082\u0006\u0010B\u001A\u00020\tH\u0002J$\u0010C\u001A\u00020\t2\u0006\u0010D\u001A\u00020E2\b\b\u0002\u0010$\u001A\u00020\u00152\b\b\u0002\u0010F\u001A\u00020-H\u0002J\u0012\u0010G\u001A\u00020\n2\b\b\u0002\u0010H\u001A\u00020\u0015H\u0002J\u001C\u0010I\u001A\u00020\n2\u0006\u0010J\u001A\u00020+2\f\u0010K\u001A\b\u0012\u0004\u0012\u00020\n0LJ\u0006\u0010M\u001A\u00020\nJ>\u0010N\u001A\u00020\n2\b\b\u0002\u0010O\u001A\u00020\u00152\n\b\u0002\u0010P\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010Q\u001A\u0004\u0018\u00010\t2\u0014\b\u0002\u0010R\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\bJ\u0010\u0010S\u001A\u00020\u00152\u0006\u0010T\u001A\u00020\tH\u0002J\u0010\u0010U\u001A\u00020\t2\u0006\u0010V\u001A\u00020WH\u0002J\u0010\u0010X\u001A\u00020\t2\u0006\u0010V\u001A\u00020WH\u0002J\b\u0010Y\u001A\u00020\nH\u0002J\b\u0010Z\u001A\u00020\nH\u0002J\b\u0010[\u001A\u00020\nH\u0002J\b\u0010\\\u001A\u00020\nH\u0016R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001A\n \u000E*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001C\u001A\n \u000E*\u0004\u0018\u00010\u001D0\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001E\u001A\n \u000E*\u0004\u0018\u00010\u001D0\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001A\n \u000E*\u0004\u0018\u00010!0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010(\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020+X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020-X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020-X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010/\u001A\n \u000E*\u0004\u0018\u00010000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00101\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b1\u00102R\u0010\u00103\u001A\u0004\u0018\u000104X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00105\u001A\u0004\u0018\u000104X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00106\u001A\u0004\u0018\u000104X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00107\u001A\u0004\u0018\u000108X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00109\u001A\u0004\u0018\u000108X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010:\u001A\u0004\u0018\u00010;X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010<\u001A\u0004\u0018\u00010;X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchPhysicalController;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "context", "Landroid/content/Context;", "automaticCycle", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle$Cycle;", "show", "Lkotlin/Function1;", "", "", "<init>", "(Landroid/content/Context;Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle$Cycle;Lkotlin/jvm/functions/Function1;)V", "app", "kotlin.jvm.PlatformType", "lifecycle", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle;", "cycle", "originalEvidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "appliedSuccessfully", "", "restoreRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelPendingApply", "requireApplicationAllowed", "main", "Landroid/os/Handler;", "worker", "Ljava/util/concurrent/ExecutorService;", "restoreWorker", "restoring", "timer", "Ljava/util/concurrent/ScheduledExecutorService;", "closed", "started", "confirmed", "gateHeld", "cleanupStarted", "preparationStep", "preparation", "Ljava/util/concurrent/CompletableFuture;", "factor", "", "preparedAt", "", "preparationMillis", "rescueLocation", "Landroid/content/SharedPreferences;", "isBusy", "()Z", "sourceConnection", "Lcom/TryJeanPc/goldenmouse/stretch/agent/ShizukuStretchAgentConnection;", "rescueConnection", "recoveryConnection", "source", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentClient;", "rescue", "sourceRequest", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "rescueRequest", "publish", "text", "id", "open", "client", "prefix", "command", "op", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentOperation;", "timeoutNanos", "arm", "recoverUnmutated", "prepare", "selectedFactor", "onArmed", "Lkotlin/Function0;", "applyConfirmed", "restore", "automatic", "expectedOriginal", "expectedRescueTag", "onResult", "verifiedRestoreJournal", "code", "failureDetails", "error", "", "safeType", "releaseGate", "disconnect", "disconnectAsync", "close"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchPhysicalController implements AutoCloseable {
    public static final int $stable = 8;
    private final Context app;
    private volatile boolean appliedSuccessfully;
    private final Cycle automaticCycle;
    private final AtomicBoolean cleanupStarted;
    private final AtomicBoolean closed;
    private final AtomicBoolean confirmed;
    private volatile Cycle cycle;
    private int factor;
    private final AtomicBoolean gateHeld;
    private final GoldenStretchGameLifecycle lifecycle;
    private final Handler main;
    private volatile StretchOriginalEvidence originalEvidence;
    private CompletableFuture preparation;
    private long preparationMillis;
    private volatile String preparationStep;
    private long preparedAt;
    private volatile ShizukuStretchAgentConnection recoveryConnection;
    private volatile StretchAgentClient rescue;
    private ShizukuStretchAgentConnection rescueConnection;
    private final SharedPreferences rescueLocation;
    private volatile StretchAgentRequest rescueRequest;
    private final AtomicBoolean restoreRequested;
    private final ExecutorService restoreWorker;
    private final AtomicBoolean restoring;
    private final Function1 show;
    private volatile StretchAgentClient source;
    private ShizukuStretchAgentConnection sourceConnection;
    private volatile StretchAgentRequest sourceRequest;
    private final AtomicBoolean started;
    private final ScheduledExecutorService timer;
    private final ExecutorService worker;

    static {
    }

    public GoldenStretchPhysicalController(Context arg2, Cycle arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg4, "show");
        super();
        this.automaticCycle = arg3;
        this.show = arg4;
        arg2 = arg2.getApplicationContext();
        this.app = arg2;
        Companion v4 = GoldenStretchGameLifecycle.Companion;
        Intrinsics.checkNotNullExpressionValue(arg2, "app");
        this.lifecycle = v4.get(arg2);
        this.cycle = arg3;
        this.restoreRequested = new AtomicBoolean();
        this.main = new Handler(Looper.getMainLooper());
        this.worker = Executors.newSingleThreadExecutor(new GoldenStretchPhysicalController$$ExternalSyntheticLambda3());
        this.restoreWorker = Executors.newSingleThreadExecutor(new GoldenStretchPhysicalController$$ExternalSyntheticLambda4());
        this.restoring = new AtomicBoolean();
        this.timer = Executors.newSingleThreadScheduledExecutor(new GoldenStretchPhysicalController$$ExternalSyntheticLambda5());
        this.closed = new AtomicBoolean();
        this.started = new AtomicBoolean();
        this.confirmed = new AtomicBoolean();
        this.gateHeld = new AtomicBoolean();
        this.cleanupStarted = new AtomicBoolean();
        this.preparationStep = "JOURNAL_CHECK";
        this.factor = 0x6F;
        this.rescueLocation = arg2.getSharedPreferences("stretch_rescue_location", 0);
    }

    public GoldenStretchPhysicalController(Context arg1, Cycle arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2, arg3);
    }

    public final void applyConfirmed() {
        CompletableFuture v0 = this.preparation;
        if(v0 == null) {
        }
        else if(!this.closed.get() && (v0.isDone()) && !v0.isCompletedExceptionally()) {
            if(!this.confirmed.compareAndSet(false, true)) {
            }
            else {
                if(this.automaticCycle == null) {
                    this.cycle = this.lifecycle.beginManual(this, this.factor);
                }

                long v0_1 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.preparedAt);
                this.timer.scheduleWithFixedDelay(new GoldenStretchPhysicalController$$ExternalSyntheticLambda1(this), 0, 1, TimeUnit.SECONDS);
                this.worker.execute(new GoldenStretchPhysicalController$$ExternalSyntheticLambda2(this, v0_1));
            }
        }
    }

    static final void applyConfirmed$lambda$32(GoldenStretchPhysicalController arg15) {
        StretchAgentClient v0 = arg15.source;
        StretchAgentRequest v1 = arg15.sourceRequest;
        if(!arg15.closed.get() && v0 != null && v1 != null) {
            try {
                Result.constructor-impl(v0.submit(StretchAgentRequest.copy$default(v1, 0, null, arg15.id(), null, null, 0, StretchAgentAction.HEARTBEAT, null, null, 0, null, 0x7BB, null)));
                return;
            }
            catch(Throwable v0_1) {
                Result.constructor-impl(ResultKt.createFailure(v0_1));
            }
        }
    }

    static final void applyConfirmed$lambda$37(GoldenStretchPhysicalController arg29, long arg30) {
        Object v0_4;
        long v13;
        long v18;
        long v5;
        Object v4;
        long v2_2;
        StretchAgentClient v14;
        String v2_1;
        GoldenStretchPhysicalController v1 = arg29;
        String v0 = "RECOVER_UNMUTATED";
        String v8 = ". ";
        String v9 = "\nLectura real: lógico=";
        String v10 = "ACTIVE_READBACK_MATCHED. Permanece activo; RESTAURAR disponible.";
        long v11 = System.nanoTime();
        try {
            AndroidStretchCandidateJournal v2 = AndroidStretchCandidateJournal.INSTANCE;
            Context v3 = v1.app;
            Intrinsics.checkNotNullExpressionValue(v3, "app");
            v2_1 = StretchRecoveryCustodianKt.stretchTrialJournalAdmission(v2.inspectExisting(v3), Process.myUid());
            if(!SetsKt.setOf(new String[]{"READY", v0}).contains(v2_1)) {
                goto label_248;
            }

            v1.arm(Intrinsics.areEqual(v2_1, v0));
            v1.requireApplicationAllowed();
            v1.publish("Rescate externo armado. Comprobando el ejecutor con los originales…");
            v1.preparationStep = "VERIFY_EXECUTOR";
            v0 = GoldenStretchPhysicalController.command$default(v1, StretchExperimentOperation.VERIFY_EXECUTOR, true, 0, 4, null);
            if(!Intrinsics.areEqual(v0, "ORIGINAL_REASSERTED_READBACK_MATCHED")) {
                goto label_243;
            }

            v14 = v1.source;
        }
        catch(Exception v0_1) {
            goto label_256;
        }

        v0 = "Required value was null.";
        if(v14 == null) {
            goto label_238;
        }

        try {
            StretchAgentRequest v15 = v1.sourceRequest;
            if(v15 == null) {
                goto label_233;
            }

            if(v14.submit(StretchAgentRequest.copy$default(v15, 0, null, v1.id(), null, null, 0, StretchAgentAction.HEARTBEAT, null, null, 0, null, 0x7BB, null)).get(6, TimeUnit.SECONDS).getCode() != StretchAgentCode.ACCEPTED) {
                goto label_228;
            }

            v1.requireApplicationAllowed();
            v1.preparationStep = "APPLY_READBACK";
            v2_2 = System.nanoTime();
            v4 = StretchAgentClient.experiment$app$default(v14, StretchExperimentOperation.APPLY_EXPERIMENT, StretchAgentRequest.copy$default(v15, 0, null, v1.id(), null, null, 0, null, null, null, 0, null, 0x7FB, null), null, null, false, 28, null).get(20, TimeUnit.SECONDS);
            v5 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - v2_2);
            StretchOriginalEvidence v7 = ((StretchExperimentReply)v4).getAppliedReadback();
            if(v7 != null) {
                StretchCompositorState v14_1 = v7.getCompositor().getState();
                if(v14_1 != null) {
                    StretchFullProjection v0_2 = v14_1.getProjection();
                    Object v14_2 = v7.getSnapshot().getOriginal().getLogicalSize().getValue();
                    Object v15_1 = v7.getSizeOverride().getValue();
                    if(v15_1 == null) {
                        RecoveryDatumState v15_2 = v7.getSizeOverride().getState();
                    }

                    Object v16 = v7.getScaling().getValue();
                    if(v16 == null) {
                        RecoveryDatumState v16_1 = v7.getScaling().getState();
                    }

                    Object v7_1 = v16;
                    v18 = v2_2;
                    v0 = v9 + v14_2 + "; override=" + v15_1 + "; scaling=" + v7_1 + ".\nProyección: " + v0_2.getSource() + " → " + v0_2.getDestination() + "; orientación=" + v0_2.getRotation() + ".\nEstiramiento visual: pendiente de comparación por el usuario.";
                    if(v0 != null) {
                        goto label_156;
                    }

                    goto label_155;
                }
                else {
                    throw new IllegalArgumentException(v0.toString());
                }
            }
            else {
                v18 = v2_2;
            label_155:
                v0 = "\nLectura posterior: UNKNOWN.";
            }

        label_156:
            v1.requireApplicationAllowed();
            if(!Intrinsics.areEqual(((StretchExperimentReply)v4).getCode(), "APPLY_READBACK_MATCHED_UNACCREDITED")) {
                goto label_204;
            }

            v2_2 = v1.preparationMillis;
            v11 = TimeUnit.NANOSECONDS.toMillis(v18 - v11);
            v13 = ((StretchExperimentReply)v4).getWritesMillis();
            v9 = v8;
        }
        catch(Exception v0_1) {
        label_256:
            v9 = v8;
            goto label_257;
        }

        try {
            v1.publish(v10 + v0 + "\nTiempos ms: preparación=" + v2_2 + "; confirmación=" + arg30 + "; armado/verificación=" + v11 + "; RPC aplicar/lecturas=" + v5 + "; escrituras=" + v13 + "; Transaction.apply=" + ((StretchExperimentReply)v4).getProjectionApplyMillis() + "; lecturas posteriores=" + ((StretchExperimentReply)v4).getReadbackMillis() + " (-1=UNKNOWN).");
            v1.appliedSuccessfully = true;
            v1.disconnectAsync();
            return;
        label_204:
            v9 = v8;
            v1.publish(((StretchExperimentReply)v4).getCode() + v9 + StretchCompatibilityKt.stretchCompatibilityMessage(((StretchExperimentReply)v4).getCode()) + " Recuperación: " + GoldenStretchPhysicalController.command$default(v1, StretchExperimentOperation.RESTORE, false, 0, 6, null) + ". Verifica el estado de pantalla.");
            v1.disconnectAsync();
            return;
        label_228:
            v9 = v8;
            throw new IllegalStateException("Check failed.");
        label_233:
            v9 = v8;
            throw new IllegalArgumentException(v0.toString());
        label_238:
            v9 = v8;
            throw new IllegalArgumentException(v0.toString());
        label_243:
            v9 = v8;
            throw new IllegalStateException(v0.toString());
        label_248:
            v9 = v8;
            throw new IllegalStateException(v2_1.toString());
        }
        catch(Exception v0_1) {
        }

    label_257:
        v1.publish("APLICAR no confirmado en " + v1.preparationStep + v9 + v1.failureDetails(((Throwable)v0_1)) + " No se eliminan registros ni ubicaciones de rescate existentes.");
        try {
            v0_4 = Result.constructor-impl(GoldenStretchPhysicalController.command$default(v1, StretchExperimentOperation.RESTORE, false, 0, 6, null));
        }
        catch(Throwable v0_3) {
            v0_4 = Result.constructor-impl(ResultKt.createFailure(v0_3));
        }

        if(Result.isFailure-impl(v0_4)) {
            v0_4 = null;
        }

        if(v0_4 != null) {
            v2_1 = v1.verifiedRestoreJournal(((String)v0_4)) ? "Original verificado en el journal." : "Verificación pendiente; no se autoriza otro APLICAR.";
            v1.publish("Recuperación: " + (((String)v0_4)) + v9 + v2_1);
        }

        v1.disconnectAsync();
    }

    private final void arm(boolean arg32) {
        GoldenStretchPhysicalController v0 = this;
        v0.requireApplicationAllowed();
        v0.preparationStep = "SOURCE_CONNECT";
        com.TryJeanPc.goldenmouse.stretch.agent.ShizukuStretchAgentConnection$Companion v1 = ShizukuStretchAgentConnection.Companion;
        Context v2 = v0.app;
        String v3 = "app";
        Intrinsics.checkNotNullExpressionValue(v2, v3);
        int v5 = 2;
        Object v6 = null;
        ShizukuStretchAgentConnection v1_1 = com.TryJeanPc.goldenmouse.stretch.agent.ShizukuStretchAgentConnection$Companion.forManualTrial$default(v1, v2, false, v5, v6);
        v0.sourceConnection = v1_1;
        String v7 = "CONTROLLER_CLOSED";
        if(!v0.closed.get()) {
            Object v10 = v1_1.connect().get(14, TimeUnit.SECONDS);
            v0.source = ((StretchAgentClient)v10);
            Intrinsics.checkNotNull(v10);
            StretchAgentRequest v11 = v0.open(((StretchAgentClient)v10), "SOURCE");
            v0.sourceRequest = v11;
            v0.preparationStep = "SOURCE_ORIGINAL";
            long v12 = 6;
            Object v1_2 = ((StretchAgentClient)v10).readOriginal(StretchAgentRequest.copy$default(v11, 0, null, v0.id(), null, null, 0, null, null, null, 0, null, 0x7FB, null)).get(v12, TimeUnit.SECONDS);
            String v25 = "Failed requirement.";
            if(((StretchAgentReply)v1_2).getCode() == StretchAgentCode.ACCEPTED) {
                StretchOriginalEvidence v1_3 = ((StretchAgentReply)v1_2).getOriginalEvidence();
                String v2_1 = "Required value was null.";
                if(v1_3 != null) {
                    if(StretchOriginalEvidenceRpc.INSTANCE.boundTo(v1_3, v11)) {
                        Cycle v14 = v0.automaticCycle;
                        if(v14 != null) {
                            if(v0.lifecycle.acceptsOriginal(v14, v1_3)) {
                            }
                            else {
                                throw new IllegalStateException("RETURN_ORIGINAL_CHANGED".toString());
                            }
                        }

                        v0.originalEvidence = v1_3;
                        if(v1_3.getCompositor().getState() != null && (v1_3.getCompositor().getStable())) {
                            Object v14_1 = CollectionsKt.firstOrNull(StretchPhysicalPair.Companion.missingOriginal(v1_3));
                            if(v14_1 == null) {
                                v0.requireApplicationAllowed();
                                if(arg32) {
                                    v0.preparationStep = "JOURNAL_RECOVER_UNMUTATED";
                                    long v7_1 = v12;
                                    v1_2 = ((StretchAgentClient)v10).recoverPersistedPhysical(StretchAgentRequest.copy$default(v11, 0, null, v0.id(), null, null, 0, null, null, null, 0, null, 0x7FB, null)).get(5, TimeUnit.SECONDS);
                                    if((Intrinsics.areEqual(((StretchPhysicalReply)v1_2).getCode(), "NO_MUTATION_CLOSED")) && !((StretchPhysicalReply)v1_2).getJournalRetained() && !((StretchPhysicalReply)v1_2).getRecoveryPending()) {
                                        AndroidStretchCandidateJournal v1_4 = AndroidStretchCandidateJournal.INSTANCE;
                                        Context v9 = v0.app;
                                        Intrinsics.checkNotNullExpressionValue(v9, v3);
                                        if(Intrinsics.areEqual(StretchRecoveryCustodianKt.stretchTrialJournalAdmission(v1_4.inspectExisting(v9), Process.myUid()), "READY")) {
                                            v0.preparationStep = "JOURNAL_RECOVERY_CLOSE";
                                            StretchAgentCode v1_5 = ((StretchAgentClient)v10).submit(StretchAgentRequest.copy$default(v11, 0, null, v0.id(), null, null, 0, StretchAgentAction.CLOSE, null, null, 0, null, 0x7BB, null)).get(v7_1, TimeUnit.SECONDS).getCode();
                                            v7 = "Check failed.";
                                            if(v1_5 == StretchAgentCode.CLOSED) {
                                                v1_1 = v0.sourceConnection;
                                                if(v1_1 == null) {
                                                    throw new IllegalArgumentException(v2_1.toString());
                                                }
                                                else if(v1_1.closeAndAwaitAgentDeath$app()) {
                                                    v0.source = ((StretchAgentClient)v6);
                                                    v0.sourceRequest = ((StretchAgentRequest)v6);
                                                    GoldenStretchPhysicalController.arm$default(v0, false, 1, v6);
                                                    return;
                                                }
                                                else {
                                                    throw new IllegalStateException(v7);
                                                }
                                            }
                                            else {
                                                throw new IllegalStateException(v7);
                                            }
                                        }
                                        else {
                                            throw new IllegalStateException("JOURNAL_CLOSE_NOT_VERIFIED".toString());
                                        }
                                    }

                                    throw new IllegalStateException(((StretchPhysicalReply)v1_2).getCode().toString());
                                }
                                else {
                                    if(StretchPhysicalPair.Companion.route(v1_3) != StretchPairRoute.UNAVAILABLE) {
                                        StretchGeometryPlan v4 = StretchPhysicalPair.Companion.plan$app(v1_3, v0.factor);
                                        if(v4 != null) {
                                            StretchProjection v6_1 = v4.getProjection();
                                        }

                                        if(((((StretchProjection)v6)) instanceof Defined)) {
                                            v0.preparationStep = "SOURCE_ENDPOINT";
                                            Object v4_1 = StretchAgentClient.experiment$app$default(((StretchAgentClient)v10), StretchExperimentOperation.ENDPOINT, StretchAgentRequest.copy$default(v11, 0, null, v0.id(), null, null, 0, null, null, null, 0, null, 0x7FB, null), null, null, false, 28, null).get(v12, TimeUnit.SECONDS);
                                            if(Intrinsics.areEqual(((StretchExperimentReply)v4_1).getCode(), "APPLIER_ENDPOINT_READY")) {
                                                v0.requireApplicationAllowed();
                                                v0.preparationStep = "RESCUE_CONNECT";
                                                com.TryJeanPc.goldenmouse.stretch.agent.ShizukuStretchAgentConnection$Companion v6_2 = ShizukuStretchAgentConnection.Companion;
                                                Context v8 = v0.app;
                                                Intrinsics.checkNotNullExpressionValue(v8, v3);
                                                ShizukuStretchAgentConnection v3_1 = v6_2.forManualTrial(v8, true);
                                                v0.rescueConnection = v3_1;
                                                if(!v0.closed.get()) {
                                                    Object v15 = v3_1.connect().get(14, TimeUnit.SECONDS);
                                                    v0.rescue = ((StretchAgentClient)v15);
                                                    Intrinsics.checkNotNull(v15);
                                                    v0.rescueRequest = v0.open(((StretchAgentClient)v15), "RESCUE");
                                                    v0.preparationStep = "RESCUE_ARM";
                                                    SharedPreferences$Editor v3_2 = v0.rescueLocation.edit();
                                                    ShizukuStretchAgentConnection v5_1 = v0.rescueConnection;
                                                    if(v5_1 != null) {
                                                        if(v3_2.putString("tag", v5_1.getTagSuffix$app()).commit()) {
                                                            Cycle v3_3 = v0.cycle;
                                                            if(v3_3 != null) {
                                                                v5_1 = v0.rescueConnection;
                                                                if(v5_1 != null) {
                                                                    v3_3.setRescueTag(v5_1.getTagSuffix$app());
                                                                }
                                                                else {
                                                                    throw new IllegalArgumentException(v2_1.toString());
                                                                }
                                                            }

                                                            StretchExperimentOperation v16 = StretchExperimentOperation.ARM;
                                                            StretchAgentRequest v3_4 = v0.rescueRequest;
                                                            if(v3_4 != null) {
                                                                StretchAgentRequest v17 = StretchAgentRequest.copy$default(v3_4, 0, null, v0.id(), null, null, 0, null, null, null, 0, null, 0x7FB, null);
                                                                IBinder v19 = ((StretchExperimentReply)v4_1).getEndpoint();
                                                                if(v19 != null) {
                                                                    Object v0_1 = StretchAgentClient.experiment$app$default(((StretchAgentClient)v15), v16, v17, v1_3, v19, false, 16, null).get(8, TimeUnit.SECONDS);
                                                                    if(Intrinsics.areEqual(((StretchExperimentReply)v0_1).getCode(), "ARMED_READ_ONLY")) {
                                                                        return;
                                                                    }

                                                                    throw new IllegalStateException(((StretchExperimentReply)v0_1).getCode().toString());
                                                                }

                                                                throw new IllegalArgumentException(v2_1.toString());
                                                            }

                                                            throw new IllegalArgumentException(v2_1.toString());
                                                        }

                                                        throw new IllegalStateException("RESCUE_LOCATION_NOT_DURABLE".toString());
                                                    }

                                                    throw new IllegalArgumentException(v2_1.toString());
                                                }

                                                v3_1.close();
                                                throw new IllegalStateException(v7.toString());
                                            }

                                            throw new IllegalArgumentException(v25.toString());
                                        }

                                        throw new IllegalStateException("FACTOR_GEOMETRY_UNSUPPORTED".toString());
                                    }

                                    throw new IllegalStateException("ORIGINAL_GEOMETRY_UNSUPPORTED".toString());
                                }
                            }
                            else {
                                throw new StretchCompatibilityFailure(((String)v14_1), ((Throwable)v6), v5, ((DefaultConstructorMarker)v6));
                            }
                        }

                        throw new StretchCompatibilityFailure("COMPOSITOR_" + v1_3.getCompositor().getCode().name(), ((Throwable)v6), v5, ((DefaultConstructorMarker)v6));
                    }

                    throw new IllegalStateException("ORIGINAL_UNBOUND".toString());
                }

                throw new IllegalArgumentException(v2_1.toString());
            }

            throw new IllegalArgumentException(v25.toString());
        }

        v1_1.close();
        throw new IllegalStateException(v7.toString());
    }

    static void arm$default(GoldenStretchPhysicalController arg0, boolean arg1, int arg2, Object arg3) {
        arg0.arm(false);
    }

    public final void cancelPendingApply() {
        this.restoreRequested.set(true);
    }

    public void close() {
        if(!this.closed.compareAndSet(false, true)) {
            return;
        }

        CompletableFuture v0 = this.preparation;
        if(v0 != null) {
            v0.cancel(false);
        }

        this.timer.shutdownNow();
        this.worker.shutdownNow();
        this.restoreWorker.shutdownNow();
        this.disconnectAsync();
    }

    private final String command(StretchExperimentOperation arg18, boolean arg19, long arg20) {
        GoldenStretchPhysicalController v0 = this;
        StretchAgentClient v1 = v0.rescue;
        String v2 = "Required value was null.";
        if(v1 != null) {
            StretchAgentRequest v3 = v0.rescueRequest;
            if(v3 != null) {
                return StretchAgentClient.experiment$app$default(v1, arg18, StretchAgentRequest.copy$default(v3, 0, null, v0.id(), null, null, 0, null, null, null, 0, null, 0x7FB, null), null, null, arg19, 12, null).get(arg20, TimeUnit.NANOSECONDS).getCode();
            }

            throw new IllegalArgumentException(v2.toString());
        }

        throw new IllegalArgumentException(v2.toString());
    }

    static String command$default(GoldenStretchPhysicalController arg0, StretchExperimentOperation arg1, boolean arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = TimeUnit.SECONDS.toNanos(20);
        }

        return arg0.command(arg1, false, arg3);
    }

    private final void disconnect() {
        ShizukuStretchAgentConnection v0 = this.sourceConnection;
        if(v0 != null) {
            v0.close();
        }

        v0 = this.rescueConnection;
        if(v0 != null) {
            v0.close();
        }

        this.timer.shutdownNow();
        this.releaseGate();
        Cycle v0_1 = this.cycle;
        if(v0_1 != null) {
            this.lifecycle.applicationFinished(v0_1, this.appliedSuccessfully, this.originalEvidence);
        }
    }

    private final void disconnectAsync() {
        if(this.cleanupStarted.compareAndSet(false, true)) {
            this.worker.shutdown();
            Thread v0 = new Thread(new GoldenStretchPhysicalController$$ExternalSyntheticLambda9(this), "StretchTrialCleanup");
            v0.setDaemon(true);
            v0.start();
        }
    }

    static final void disconnectAsync$lambda$60(GoldenStretchPhysicalController arg4) {
        if(arg4.worker.awaitTermination(45, TimeUnit.SECONDS)) {
            arg4.disconnect();
            return;
        }

        arg4.publish("APLICAR pendiente: ejecutor sin drenar; exclusividad y journal conservados.");
    }

    private final String failureDetails(Throwable arg18) {
        ShizukuStretchAgentConnection v0_1;
        GoldenStretchPhysicalController v0 = this;
        String v1 = this.safeType(arg18);
        int v5 = 2;
        Object v6 = null;
        if(StringsKt.startsWith$default(v0.preparationStep, "RESTORE", false, v5, v6)) {
            v0_1 = v0.recoveryConnection;
        }
        else if(StringsKt.startsWith$default(v0.preparationStep, "RESCUE", false, v5, v6)) {
            v0_1 = v0.rescueConnection;
        }
        else {
            v0_1 = v0.sourceConnection;
        }

        Map v0_2 = v0_1 != null ? v0_1.diagnosticSnapshot$app() : ((Map)v6);
        if(v0_2 == null) {
            v0_2 = MapsKt.emptyMap();
        }

        String[] v2 = new String[6];
        v2[0] = "connectionFailureStep";
        v2[1] = "connectionStep";
        v2[v5] = "backendUid";
        v2[3] = "backendVersion";
        v2[4] = "serviceConnected";
        v2[5] = "callbackVerified";
        List v2_1 = CollectionsKt.listOf(((Object[])v2));
        ArrayList v3 = new ArrayList();
        Iterator v2_2 = ((Iterable)v2_1).iterator();
        while(v2_2.hasNext()) {
            Object v8 = v2_2.next();
            Object v9 = v0_2.get(v8);
            String v8_1 = v9 != null ? (((String)v8)) + "=" + (((String)v9)) : ((String)v6);
            if(v8_1 == null) {
                continue;
            }

            ((Collection)v3).add(v8_1);
        }

        String v0_3 = CollectionsKt.joinToString$default(v3, ", ", null, null, 0, null, null, 62, null);
        v2 = new String[v5];
        v2[0] = Build.MANUFACTURER;
        v2[1] = Build.MODEL;
        return StretchCompatibilityKt.stretchCompatibilityMessage(v1) + " Código=" + v1 + ". API Android " + Build$VERSION.SDK_INT + "; " + CollectionsKt.joinToString$default(CollectionsKt.listOf(((Object[])v2)), " ", null, null, 0, null, new GoldenStretchPhysicalController$$ExternalSyntheticLambda15(), 30, null) + ". " + v0_3 + ".";
    }

    static final CharSequence failureDetails$lambda$52(String arg4) {
        if(arg4 == null) {
            arg4 = "";
        }

        StringBuilder v0 = new StringBuilder();
        int v1;
        for(v1 = 0; v1 < ((CharSequence)arg4).length(); ++v1) {
            char v2 = ((CharSequence)arg4).charAt(v1);
            if(!Character.isISOControl(v2)) {
                ((Appendable)v0).append(v2);
            }
        }

        return StringsKt.take(v0.toString(), 60);
    }

    private final String id() {
        String v1 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        return v1;
    }

    public final boolean isBusy() {
        if(!this.gateHeld.get()) {
            if(this.restoring.get()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final StretchAgentRequest open(StretchAgentClient arg21, String arg22) {
        GoldenStretchPhysicalController v0 = this;
        StretchAgentClient v1 = arg21;
        String v2 = arg22;
        String v5 = "Failed requirement.";
        if(v1.getAuthenticatedPeerUid() == 2000) {
            StretchAgentRequest v6 = new StretchAgentRequest(2, v0.id(), v0.id(), v0.id(), v1.getGeneration(), 0, StretchAgentAction.OPEN, null, null, 0, null, 0x780, null);
            v0.preparationStep = v2 + "_OPEN";
            long v7 = 6;
            if(v1.submit(v6).get(v7, TimeUnit.SECONDS).getCode() == StretchAgentCode.ACCEPTED) {
                v0.preparationStep = v2 + "_BASELINE";
                Object v1_1 = v1.submit(StretchAgentRequest.copy$default(v6, 0, null, v0.id(), null, null, 0, StretchAgentAction.READ_BASELINE, null, null, 0, null, 0x7BB, null)).get(v7, TimeUnit.SECONDS);
                if(((StretchAgentReply)v1_1).getCode() == StretchAgentCode.BASELINE_READ) {
                    StretchAgentBaseline v1_2 = ((StretchAgentReply)v1_1).getBaseline();
                    if(v1_2 != null) {
                        int v3 = 2;
                        String[] v4 = new String[v3];
                        v4[0] = "SOURCE";
                        v4[1] = "RESCUE";
                        if(SetsKt.setOf(((Object[])v4)).contains(v2)) {
                            Throwable v5_1 = null;
                            if(v1_2.getProjection().getToken() != StretchProbeEvidence.OBSERVED) {
                                throw new StretchCompatibilityFailure("DISPLAY_TOKEN_UNAVAILABLE", v5_1, v3, ((DefaultConstructorMarker)v5_1));
                            }
                            else if(v1_2.getProjection().getTransactionMethod() == StretchProbeEvidence.METHOD_PRESENT) {
                            }
                            else {
                                throw new StretchCompatibilityFailure("DISPLAY_CONTRACT_UNSUPPORTED", v5_1, v3, ((DefaultConstructorMarker)v5_1));
                            }
                        }

                        StretchRecoverySnapshot v1_3 = v1_2.getSnapshot();
                        return StretchAgentRequest.copy$default(v6, 0, null, null, null, null, 0, StretchAgentAction.STATUS, StretchRecoveryCodec.INSTANCE.snapshotDigest(v1_3), v1_3.getOriginal().getPhysicalIdentity().getValue(), v0.factor, null, 0x43F, null);
                    }

                    throw new IllegalArgumentException("Required value was null.".toString());
                }

                throw new IllegalArgumentException(v5.toString());
            }

            throw new IllegalArgumentException(v5.toString());
        }

        throw new IllegalArgumentException(v5.toString());
    }

    public final void prepare(int arg9, Function0 arg10) {
        Intrinsics.checkNotNullParameter(arg10, "onArmed");
        if(this.started.compareAndSet(false, true)) {
            if(this.closed.get()) {
            }
            else if(!StretchReadOnlyPreflightKt.beginStretchOperation()) {
                this.publish("APLICAR bloqueado: otra operación Stretch está activa.");
                this.disconnectAsync();
                return;
            }
            else {
                this.gateHeld.set(true);
                this.factor = arg9;
                long v0 = System.nanoTime();
                ScheduledExecutorService v2 = this.timer;
                Intrinsics.checkNotNullExpressionValue(v2, "timer");
                CompletableFuture v9 = StretchPreparationDeadlineKt.stretchPreparationDeadline$default(v2, new GoldenStretchPhysicalController$$ExternalSyntheticLambda11(this), 0, 4, null);
                this.preparation = v9;
                v9.whenComplete(new GoldenStretchPhysicalController$$ExternalSyntheticLambda13(new GoldenStretchPhysicalController$$ExternalSyntheticLambda12(this, v0, arg10)));
                this.worker.execute(new GoldenStretchPhysicalController$$ExternalSyntheticLambda14(this, v9));
            }
        }
    }

    static final String prepare$lambda$23(GoldenStretchPhysicalController arg0) {
        return arg0.preparationStep;
    }

    static final Unit prepare$lambda$26(GoldenStretchPhysicalController arg2, long arg3, Function0 arg5, Unit arg6, Throwable arg7) {
        if(arg7 == null) {
            arg2.preparationMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - arg3);
            arg2.preparedAt = System.nanoTime();
            arg2.publish("Preparación local completada. Confirma para verificar originales, armar el rescate y aplicar.");
            arg2.main.post(new GoldenStretchPhysicalController$$ExternalSyntheticLambda8(arg2, arg5));
        }
        else {
            arg2.publish("APLICAR bloqueado en " + arg2.preparationStep + ". " + arg2.failureDetails(arg7) + " No se autoriza la aplicación.");
            arg2.worker.shutdownNow();
            arg2.disconnectAsync();
        }

        return Unit.INSTANCE;
    }

    static final void prepare$lambda$26$lambda$25(GoldenStretchPhysicalController arg0, Function0 arg1) {
        if(!arg0.closed.get()) {
            arg1.invoke();
        }
    }

    static final void prepare$lambda$27(Function2 arg0, Object arg1, Object arg2) {
        arg0.invoke(arg1, arg2);
    }

    static final void prepare$lambda$30(GoldenStretchPhysicalController arg3, CompletableFuture arg4) {
        try {
            if(StretchExperimentRpc.INSTANCE.acceptsFactor(0, arg3.factor)) {
                AndroidStretchCandidateJournal v0 = AndroidStretchCandidateJournal.INSTANCE;
                Context v3_1 = arg3.app;
                Intrinsics.checkNotNullExpressionValue(v3_1, "app");
                String v3_2 = StretchRecoveryCustodianKt.stretchTrialJournalAdmission(v0.inspectExisting(v3_1), Process.myUid());
                if(SetsKt.setOf(new String[]{"READY", "RECOVER_UNMUTATED"}).contains(v3_2)) {
                    arg4.complete(Unit.INSTANCE);
                    return;
                }

                throw new IllegalStateException(v3_2.toString());
            }

            throw new IllegalStateException("FACTOR_REJECTED".toString());
        }
        catch(Exception v3) {
            arg4.completeExceptionally(((Throwable)v3));
            return;
        }
    }

    private final void publish(String arg3) {
        this.main.post(new GoldenStretchPhysicalController$$ExternalSyntheticLambda16(this, arg3));
    }

    static final void publish$lambda$9(GoldenStretchPhysicalController arg1, String arg2) {
        if(!arg1.closed.get()) {
            arg1.show.invoke(arg2);
        }
    }

    private final void releaseGate() {
        if(this.gateHeld.compareAndSet(true, false)) {
            StretchReadOnlyPreflightKt.endStretchOperation();
        }
    }

    private final void requireApplicationAllowed() {
        if(!this.closed.get() && !this.restoreRequested.get()) {
            Cycle v0 = this.cycle;
            if(v0 != null) {
                GoldenStretchGameLifecycle v1 = this.lifecycle;
                boolean v2 = this.automaticCycle != null ? true : false;
                if(v1.allowed(v0, v2)) {
                    return;
                }

                throw new IllegalStateException("GAME_CYCLE_REVOKED".toString());
            }

            return;
        }

        throw new IllegalStateException("APPLICATION_CANCELLED".toString());
    }

    public final void restore(boolean arg9, StretchOriginalEvidence arg10, String arg11, Function1 arg12) {
        Function1 v7;
        String v5;
        StretchOriginalEvidence v6;
        boolean v4;
        GoldenStretchPhysicalController v3;
        ExecutorService v1;
        Intrinsics.checkNotNullParameter(arg12, "onResult");
        if(!arg9) {
            this.lifecycle.cancelManualReturn();
        }

        this.restoreRequested.set(true);
        if((arg9) && arg10 == null && arg11 == null) {
            arg12.invoke(Boolean.valueOf(false));
            return;
        }

        if(this.closed.get()) {
            arg12.invoke(Boolean.valueOf(false));
            return;
        }

        if(!this.restoring.compareAndSet(false, true)) {
            this.publish("Restauración pendiente: ya hay una solicitud en curso.");
            arg12.invoke(Boolean.valueOf(false));
            return;
        }

        this.publish("RESTAURAR: verificando originales y recuperando el journal persistente…");
        try {
            v1 = this.restoreWorker;
            v3 = this;
            v4 = arg9;
            v6 = arg10;
            v5 = arg11;
            v7 = arg12;
        }
        catch(RejectedExecutionException ) {
            v3 = this;
            v7 = arg12;
            goto label_43;
        }

        try {
            v1.execute(new GoldenStretchPhysicalController$$ExternalSyntheticLambda10(v3, v4, v5, v6, v7));
            return;
        }
        catch(RejectedExecutionException ) {
        label_43:
            v3.restoring.set(false);
            v7.invoke(Boolean.valueOf(false));
            v3.publish("RESTAURAR: ejecutor cerrado. Reabre la ventana para recuperar el journal.");
            return;
        }
    }

    public static void restore$default(GoldenStretchPhysicalController arg1, boolean arg2, StretchOriginalEvidence arg3, String arg4, Function1 arg5, int arg6, Object arg7) {
        GoldenStretchPhysicalController$$ExternalSyntheticLambda0 v5;
        StretchOriginalEvidence v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = ((String)v0);
        }

        if((arg6 & 8) != 0) {
            v5 = new GoldenStretchPhysicalController$$ExternalSyntheticLambda0();
        }

        arg1.restore(false, arg3, arg4, ((Function1)v5));
    }

    static final Unit restore$lambda$38(boolean arg0) {
        return Unit.INSTANCE;
    }

    static final void restore$lambda$49(GoldenStretchPhysicalController arg41, boolean arg42, String arg43, StretchOriginalEvidence arg44, Function1 arg45) {
        // Method was not decompiled
    }

    static final Thread restoreWorker$lambda$6(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchManualRestore");
        v0.setDaemon(true);
        return v0;
    }

    private final String safeType(Throwable arg5) {
        Sequence v4 = SequencesKt.filter(SequencesKt.generateSequence(arg5, new GoldenStretchPhysicalController$$ExternalSyntheticLambda6()), GoldenStretchPhysicalController$safeType$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Object v4_1 = SequencesKt.firstOrNull(v4);
        if(v4_1 != null) {
            return ((StretchCompatibilityFailure)v4_1).getCode();
        }

        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlin.Throwable");
        v4_1 = SequencesKt.last(SequencesKt.generateSequence(arg5, new GoldenStretchPhysicalController$$ExternalSyntheticLambda7()));
        String v5 = v4_1.getClass().getSimpleName();
        Intrinsics.checkNotNull(v5);
        String v1 = null;
        if(new Regex("[A-Za-z0-9_]{1,80}").matches(v5)) {
        }
        else {
            v5 = v1;
        }

        if(v5 == null) {
            v5 = "ERROR";
        }

        String v4_2 = ((Throwable)v4_1).getMessage();
        if(v4_2 != null && (new Regex("[A-Z0-9_]{1,80}").matches(v4_2))) {
            v1 = v4_2;
        }

        if(v1 != null) {
            v4_2 = ":" + v1;
            if(v4_2 == null) {
                goto label_47;
            }
        }
        else {
        label_47:
            v4_2 = "";
        }

        return v5 + v4_2;
    }

    static final Throwable safeType$lambda$53(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.getCause();
    }

    static final Throwable safeType$lambda$55(Throwable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return arg1.getCause();
    }

    static final Thread timer$lambda$8(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchTrialHeartbeat");
        v0.setDaemon(true);
        return v0;
    }

    private final boolean verifiedRestoreJournal(String arg3) {
        AndroidStretchCandidateJournal v0 = AndroidStretchCandidateJournal.INSTANCE;
        Context v2 = this.app;
        Intrinsics.checkNotNullExpressionValue(v2, "app");
        return StretchCompatibilityKt.stretchRestoreClosureVerified(arg3, v0.inspectExisting(v2), Process.myUid());
    }

    static final Thread worker$lambda$4(Runnable arg2) {
        Thread v0 = new Thread(arg2, "StretchManualTrial");
        v0.setDaemon(true);
        return v0;
    }
}

