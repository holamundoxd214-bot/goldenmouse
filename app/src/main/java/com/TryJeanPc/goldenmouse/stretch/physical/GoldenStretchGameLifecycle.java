package com.TryJeanPc.goldenmouse.stretch.physical;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display$Mode;
import android.view.Display;
import com.TryJeanPc.goldenmouse.input.GameForegroundObservation;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.agent.AndroidStretchCandidateJournal;
import com.TryJeanPc.goldenmouse.stretch.agent.CandidateJournalRead$Present;
import com.TryJeanPc.goldenmouse.stretch.agent.CandidateJournalRead;
import com.TryJeanPc.goldenmouse.stretch.agent.CandidatePhase;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchCandidateRecord;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchCandidateRecordCodec;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchOriginalEvidence;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchOriginalEvidenceCodec;
import com.TryJeanPc.goldenmouse.stretch.agent.StretchPhysicalPair;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 42\u00020\u0001:\u000234B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\tJ\u0006\u0010\u0015\u001A\u00020\u0018J\u0006\u0010\u001A\u001A\u00020\u0018J\u000E\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u0014J\u0010\u0010\u001D\u001A\u00020\u00162\u0006\u0010\u001E\u001A\u00020\u0012H\u0002J\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u00122\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#J\u0016\u0010$\u001A\u00020\u00162\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u0010%\u001A\u00020\u0016J\u0016\u0010&\u001A\u00020\u00162\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u0010\'\u001A\u00020(J \u0010)\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u0010*\u001A\u00020\u00162\b\u0010+\u001A\u0004\u0018\u00010(J\u0006\u0010,\u001A\u00020\u0018J\u0018\u0010-\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u0010.\u001A\u00020/H\u0002J\u0010\u00100\u001A\u00020\u00182\u0006\u0010\u001E\u001A\u00020\u0012H\u0002J\u0018\u00101\u001A\u00020\u00162\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u00102\u001A\u00020\tH\u0002R\u0016\u0010\u0006\u001A\n \u0007*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\n \u0007*\u0004\u0018\u00010\u000B0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "app", "kotlin.jvm.PlatformType", "processScope", "", "preferences", "Landroid/content/SharedPreferences;", "thread", "Landroid/os/HandlerThread;", "worker", "Landroid/os/Handler;", "selected", "current", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle$Cycle;", "latest", "Lcom/TryJeanPc/goldenmouse/input/GameForegroundObservation;", "goldenHomeRequested", "", "select", "", "packageName", "observationLost", "observe", "observation", "returnGeometryReady", "cycle", "beginManual", "controller", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchPhysicalController;", "factor", "", "allowed", "automatic", "acceptsOriginal", "evidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "applicationFinished", "success", "original", "cancelManualReturn", "act", "action", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy$Action;", "restore", "persist", "reason", "Cycle", "Companion"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchGameLifecycle {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle;", "get", "context", "Landroid/content/Context;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GoldenStretchGameLifecycle get(Context arg3) {
            Intrinsics.checkNotNullParameter(arg3, "context");
            GoldenStretchGameLifecycle v0 = GoldenStretchGameLifecycle.instance;
            if(v0 == null) {
                __monitor_enter(this);
                try {
                    v0 = GoldenStretchGameLifecycle.instance;
                    if(v0 == null) {
                        v0 = new GoldenStretchGameLifecycle(arg3, null);
                        GoldenStretchGameLifecycle.instance = v0;
                    }
                }
                catch(Throwable v3) {
                    __monitor_exit(this);
                    throw v3;
                }

                __monitor_exit(this);
                return v0;
            }

            return v0;
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\tR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u00020\u0013X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0013X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u0015\"\u0004\b\u001A\u0010\u0017R\u001A\u0010\u001B\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\t\"\u0004\b\u001D\u0010\u001ER\u001C\u0010\u001F\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\t\"\u0004\b!\u0010\u001ER\u001C\u0010\"\u001A\u0004\u0018\u00010#X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001C\u0010(\u001A\u0004\u0018\u00010)X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchGameLifecycle$Cycle;", "", "target", "", "factor", "", "<init>", "(Ljava/lang/String;I)V", "getTarget", "()Ljava/lang/String;", "getFactor", "()I", "id", "getId", "policy", "Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy;", "getPolicy", "()Lcom/TryJeanPc/goldenmouse/stretch/physical/StretchGameLifecyclePolicy;", "cancelled", "", "getCancelled", "()Z", "setCancelled", "(Z)V", "stopApply", "getStopApply", "setStopApply", "returnObserver", "getReturnObserver", "setReturnObserver", "(Ljava/lang/String;)V", "rescueTag", "getRescueTag", "setRescueTag", "original", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "getOriginal", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "setOriginal", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;)V", "controller", "Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchPhysicalController;", "getController", "()Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchPhysicalController;", "setController", "(Lcom/TryJeanPc/goldenmouse/stretch/physical/GoldenStretchPhysicalController;)V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Cycle {
        public static final int $stable = 8;
        private volatile boolean cancelled;
        private volatile GoldenStretchPhysicalController controller;
        private final int factor;
        private final String id;
        private volatile StretchOriginalEvidence original;
        private final StretchGameLifecyclePolicy policy;
        private volatile String rescueTag;
        private volatile String returnObserver;
        private volatile boolean stopApply;
        private final String target;

        static {
        }

        public Cycle(String arg3, int arg4) {
            Intrinsics.checkNotNullParameter(arg3, "target");
            super();
            this.target = arg3;
            this.factor = arg4;
            String v0 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
            this.id = v0;
            this.policy = new StretchGameLifecyclePolicy(arg3, arg4);
            this.returnObserver = "";
        }

        public final boolean getCancelled() {
            return this.cancelled;
        }

        public final GoldenStretchPhysicalController getController() {
            return this.controller;
        }

        public final int getFactor() {
            return this.factor;
        }

        public final String getId() {
            return this.id;
        }

        public final StretchOriginalEvidence getOriginal() {
            return this.original;
        }

        public final StretchGameLifecyclePolicy getPolicy() {
            return this.policy;
        }

        public final String getRescueTag() {
            return this.rescueTag;
        }

        public final String getReturnObserver() {
            return this.returnObserver;
        }

        public final boolean getStopApply() {
            return this.stopApply;
        }

        public final String getTarget() {
            return this.target;
        }

        public final void setCancelled(boolean arg1) {
            this.cancelled = arg1;
        }

        public final void setController(GoldenStretchPhysicalController arg1) {
            this.controller = arg1;
        }

        public final void setOriginal(StretchOriginalEvidence arg1) {
            this.original = arg1;
        }

        public final void setRescueTag(String arg1) {
            this.rescueTag = arg1;
        }

        public final void setReturnObserver(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.returnObserver = arg2;
        }

        public final void setStopApply(boolean arg1) {
            this.stopApply = arg1;
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Action.values().length];
            try {
                v0[Action.NONE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Action.CANCEL_APPLY.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Action.RESTORE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[Action.APPLY.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final String TAG = "GOLDEN_STRETCH_HOME";
    private final Context app;
    private volatile Cycle current;
    private boolean goldenHomeRequested;
    private static volatile GoldenStretchGameLifecycle instance;
    private volatile GameForegroundObservation latest;
    private final SharedPreferences preferences;
    private final String processScope;
    private volatile String selected;
    private final HandlerThread thread;
    private final Handler worker;

    static {
        GoldenStretchGameLifecycle.Companion = new Companion(null);
        GoldenStretchGameLifecycle.$stable = 8;
    }

    private GoldenStretchGameLifecycle(Context arg3) {
        super();
        arg3 = arg3.getApplicationContext();
        this.app = arg3;
        String v0 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
        this.processScope = v0;
        this.preferences = arg3.getSharedPreferences("stretch_game_cycle", 0);
        HandlerThread v3 = new HandlerThread("StretchGameLifecycle");
        v3.start();
        this.thread = v3;
        Handler v0_1 = new Handler(v3.getLooper());
        this.worker = v0_1;
        v0_1.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda9(this));
    }

    public GoldenStretchGameLifecycle(Context arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    static final void _init_$lambda$1(GoldenStretchGameLifecycle arg3) {
        arg3.preferences.edit().putString("state", "COLD_PROCESS_CANCELLED").putString("process", arg3.processScope).commit();
    }

    public final boolean acceptsOriginal(Cycle arg2, StretchOriginalEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg2, "cycle");
        Intrinsics.checkNotNullParameter(arg3, "evidence");
        StretchOriginalEvidence v1 = arg2.getOriginal();
        if(v1 != null && (StretchPhysicalPair.Companion.matchesRestoredState$app(v1, arg3))) {
            return 1;
        }

        return 0;
    }

    public static final GoldenStretchGameLifecycle access$getInstance$cp() {
        return GoldenStretchGameLifecycle.instance;
    }

    public static final void access$setInstance$cp(GoldenStretchGameLifecycle arg0) {
        GoldenStretchGameLifecycle.instance = arg0;
    }

    private final void act(Cycle arg3, Action arg4) {
        GoldenStretchPhysicalController v4_1;
        if(this.current == arg3) {
            if(arg3.getCancelled()) {
            }
            else {
                int v4 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
                if(v4 != 1) {
                    if(v4 == 2) {
                        arg3.setStopApply(true);
                        v4_1 = arg3.getController();
                        if(v4_1 != null) {
                            v4_1.cancelPendingApply();
                        }

                        this.persist(arg3, "EXIT_DURING_APPLY");
                    }
                    else if(v4 == 3) {
                        this.persist(arg3, "EXIT_CONFIRMED");
                        this.restore(arg3);
                        return;
                    }
                    else if(v4 == 4) {
                        arg3.setStopApply(false);
                        if(!this.persist(arg3, "RETURN_CONFIRMED")) {
                            arg3.setCancelled(true);
                            arg3.getPolicy().cancel();
                            return;
                        }
                        else {
                            Context v2 = this.app;
                            Intrinsics.checkNotNullExpressionValue(v2, "app");
                            v4_1 = new GoldenStretchPhysicalController(v2, arg3, new GoldenStretchGameLifecycle$$ExternalSyntheticLambda10());
                            arg3.setController(v4_1);
                            v4_1.prepare(arg3.getFactor(), new GoldenStretchGameLifecycle$$ExternalSyntheticLambda11(v4_1));
                            return;
                        }
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
    }

    static final Unit act$lambda$19(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        Log.i("GOLDEN_STRETCH_HOME", arg1);
        return Unit.INSTANCE;
    }

    static final Unit act$lambda$20(GoldenStretchPhysicalController arg0) {
        arg0.applyConfirmed();
        return Unit.INSTANCE;
    }

    public final boolean allowed(Cycle arg5, boolean arg6) {
        Intrinsics.checkNotNullParameter(arg5, "cycle");
        if(this.current == arg5 && !arg5.getCancelled() && !arg5.getStopApply()) {
            if(!Intrinsics.areEqual(this.selected, arg5.getTarget())) {
            }
            else if(!arg6) {
                return 1;
            }
            else {
                GameForegroundObservation v4 = this.latest;
                if(v4 == null) {
                    return 0;
                }
                else if((Intrinsics.areEqual(v4.getObserver(), arg5.getReturnObserver())) && (Intrinsics.areEqual(v4.getTarget(), arg5.getTarget())) && (Intrinsics.areEqual(v4.getTopPackage(), arg5.getTarget()))) {
                    Integer v6 = v4.getActivityType();
                    if(v6 == null) {
                    }
                    else if(v6.intValue() == 1) {
                        Set v6_1 = v4.getForegroundPackages();
                        if(v6_1 == null) {
                            v6_1 = SetsKt.emptySet();
                        }

                        if(!v6_1.contains(arg5.getTarget())) {
                            return 0;
                        }

                        long v5 = SystemClock.elapsedRealtime() - v4.getSampledAtMillis();
                        if(0 > v5) {
                            return 0;
                        }

                        if(v5 >= 1601) {
                            return 0;
                        }

                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    public final void applicationFinished(Cycle arg3, boolean arg4, StretchOriginalEvidence arg5) {
        Intrinsics.checkNotNullParameter(arg3, "cycle");
        this.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda0(this, arg3, arg5, arg4));
    }

    static final void applicationFinished$lambda$16(GoldenStretchGameLifecycle arg1, Cycle arg2, StretchOriginalEvidence arg3, boolean arg4) {
        if(arg1.current == arg2) {
            if(arg2.getCancelled()) {
            }
            else {
                if(arg3 != null) {
                    arg2.setOriginal(arg3);
                }

                Action v0 = arg2.getPolicy().applicationFinished(arg4);
                String v4 = arg4 ? "APPLY_VERIFIED" : "APPLY_FAILED";
                if(!arg1.persist(arg2, v4)) {
                    arg2.setCancelled(true);
                    arg2.getPolicy().cancel();
                    if(arg3 == null) {
                        return;
                    }

                    arg1.restore(arg2);
                    return;
                }

                arg1.act(arg2, v0);
            }
        }
    }

    public final Cycle beginManual(GoldenStretchPhysicalController arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "controller");
        Cycle v0 = this.current;
        if(v0 != null) {
            v0.setCancelled(true);
            GoldenStretchPhysicalController v0_1 = v0.getController();
            if(v0_1 != null) {
                v0_1.cancelPendingApply();
            }
        }

        String v0_2 = this.selected;
        if(v0_2 == null) {
            this.current = null;
            return null;
        }

        Cycle v1 = new Cycle(v0_2, arg4);
        this.current = v1;
        v1.setController(arg3);
        this.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda7(this, v1));
        return v1;
    }

    static final void beginManual$lambda$14$lambda$13(GoldenStretchGameLifecycle arg1, Cycle arg2) {
        arg1.goldenHomeRequested = false;
        arg1.persist(arg2, "MANUAL_APPLY_AUTHORIZED");
    }

    public final void cancelManualReturn() {
        Cycle v0 = this.current;
        if(v0 != null) {
            v0.setCancelled(true);
            GoldenStretchPhysicalController v1 = v0.getController();
            if(v1 != null) {
                v1.cancelPendingApply();
            }

            this.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda12(v0, this));
        }
    }

    static final void cancelManualReturn$lambda$18$lambda$17(Cycle arg1, GoldenStretchGameLifecycle arg2) {
        arg1.getPolicy().cancel();
        arg2.persist(arg1, "MANUAL_RESTORE");
    }

    public final void goldenHomeRequested() {
        this.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda4(this));
    }

    static final void goldenHomeRequested$lambda$3(GoldenStretchGameLifecycle arg1) {
        arg1.goldenHomeRequested = true;
    }

    public final void observationLost() {
        this.latest = null;
        this.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda3(this));
    }

    static final void observationLost$lambda$5(GoldenStretchGameLifecycle arg6) {
        Cycle v6 = arg6.current;
        if(v6 != null) {
            v6.getPolicy().observe("lost", SystemClock.elapsedRealtime(), com.TryJeanPc.goldenmouse.stretch.physical.StretchGameLifecyclePolicy$Context.UNKNOWN, null);
        }
    }

    public final void observe(GameForegroundObservation arg3) {
        Intrinsics.checkNotNullParameter(arg3, "observation");
        this.latest = arg3;
        this.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda5(this, arg3));
    }

    static final void observe$lambda$9(GoldenStretchGameLifecycle arg11, GameForegroundObservation arg12) {
        com.TryJeanPc.goldenmouse.stretch.physical.StretchGameLifecyclePolicy$Context v0_4;
        boolean v8;
        Object v0_1;
        Cycle v1 = arg11.current;
        if(v1 != null && !v1.getCancelled() && (Intrinsics.areEqual(arg11.selected, v1.getTarget())) && (Intrinsics.areEqual(arg12.getTarget(), v1.getTarget()))) {
            String v3 = arg12.getTopPackage();
            if(v1.getPolicy().getState() == State.WAITING_RETURN) {
                try {
                    v0_1 = Result.constructor-impl(Boolean.valueOf(arg11.returnGeometryReady(v1)));
                }
                catch(Throwable v0) {
                    v0_1 = Result.constructor-impl(ResultKt.createFailure(v0));
                }

                Boolean v2 = Boolean.valueOf(false);
                if(Result.isFailure-impl(v0_1)) {
                    Boolean v0_2 = v2;
                }

                if(v0_2.booleanValue()) {
                }
                else {
                    v8 = false;
                    goto label_40;
                }
            }

            v8 = true;
        label_40:
            long v4 = SystemClock.elapsedRealtime() - arg12.getSampledAtMillis();
            if(0 > v4 || v4 >= 1601) {
                v0_4 = com.TryJeanPc.goldenmouse.stretch.physical.StretchGameLifecyclePolicy$Context.UNKNOWN;
            }
            else {
                StretchGameLifecyclePolicy v2_1 = v1.getPolicy();
                Integer v4_1 = arg12.getActivityType();
                Set v0_3 = arg12.getForegroundPackages();
                if(v0_3 == null) {
                    v0_3 = SetsKt.emptySet();
                }

                boolean v5 = v0_3.contains(v1.getTarget());
                String v6 = arg11.app.getPackageName();
                Intrinsics.checkNotNullExpressionValue(v6, "getPackageName(...)");
                v0_4 = v2_1.classify(v3, v4_1, v5, v6, arg11.goldenHomeRequested, v8, new GoldenStretchGameLifecycle$$ExternalSyntheticLambda6(arg11, v3));
            }

            com.TryJeanPc.goldenmouse.stretch.physical.StretchGameLifecyclePolicy$Context v6_1 = v0_4;
            if(v6_1 == com.TryJeanPc.goldenmouse.stretch.physical.StretchGameLifecyclePolicy$Context.GAME) {
                arg11.goldenHomeRequested = false;
            }

            Action v0_5 = v1.getPolicy().observe(arg12.getObserver(), arg12.getSampledAtMillis(), v6_1, v3);
            if(v0_5 == Action.APPLY) {
                v1.setReturnObserver(arg12.getObserver());
            }

            arg11.act(v1, v0_5);
        }
    }

    static final boolean observe$lambda$9$lambda$8(GoldenStretchGameLifecycle arg1, String arg2) {
        Object v1_2;
        try {
            PackageManager v1_1 = arg1.app.getPackageManager();
            if(arg2 != null) {
                v1_2 = Result.constructor-impl(v1_1.getLaunchIntentForPackage(arg2));
                goto label_16;
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        }
        catch(Throwable v1) {
            v1_2 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

    label_16:
        if(Result.isFailure-impl(v1_2)) {
            v1_2 = null;
        }

        boolean v1_3 = v1_2 != null ? true : false;
        return v1_3;
    }

    private final boolean persist(Cycle arg7, String arg8) {
        Log.i("GOLDEN_STRETCH_HOME", "state=" + arg7.getPolicy().getState() + " reason=" + arg8 + " target=" + arg7.getTarget() + " factor=" + arg7.getFactor() + " cycle=" + arg7.getId());
        SharedPreferences$Editor v6 = this.preferences.edit().putString("process", this.processScope).putString("cycle", arg7.getId()).putString("target", arg7.getTarget()).putInt("factor", arg7.getFactor()).putString("state", arg7.getPolicy().getState().name()).putString("reason", arg8).putString("rescueTag", arg7.getRescueTag());
        boolean v8 = (arg7.getCancelled()) || !arg7.getPolicy().getApproved() ? false : true;
        v6 = v6.putBoolean("returnConsent", v8);
        StretchOriginalEvidence v7 = arg7.getOriginal();
        String v7_1 = v7 != null ? StretchOriginalEvidenceCodec.INSTANCE.encode(v7) : null;
        return v6.putString("original", v7_1).commit();
    }

    private final void restore(Cycle arg7) {
        Context v1 = this.app;
        Intrinsics.checkNotNullExpressionValue(v1, "app");
        GoldenStretchPhysicalController v0 = new GoldenStretchPhysicalController(v1, null, new GoldenStretchGameLifecycle$$ExternalSyntheticLambda13(), 2, null);
        v0.restore(true, arg7.getOriginal(), arg7.getRescueTag(), new GoldenStretchGameLifecycle$$ExternalSyntheticLambda1(this, v0, arg7));
    }

    static final Unit restore$lambda$21(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        Log.i("GOLDEN_STRETCH_HOME", arg1);
        return Unit.INSTANCE;
    }

    static final Unit restore$lambda$23(GoldenStretchGameLifecycle arg2, GoldenStretchPhysicalController arg3, Cycle arg4, boolean arg5) {
        arg2.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda8(arg3, arg2, arg4, arg5));
        return Unit.INSTANCE;
    }

    static final void restore$lambda$23$lambda$22(GoldenStretchPhysicalController arg4, GoldenStretchGameLifecycle arg5, Cycle arg6, boolean arg7) {
        int v1_1;
        arg4.close();
        if(arg5.current == arg6) {
            if(arg6.getCancelled()) {
            }
            else {
                AndroidStretchCandidateJournal v4 = AndroidStretchCandidateJournal.INSTANCE;
                Context v0 = arg5.app;
                Intrinsics.checkNotNullExpressionValue(v0, "app");
                CandidateJournalRead v4_1 = v4.inspectExisting(v0);
                StretchCandidateRecord v1 = null;
                if((v4_1 instanceof Present)) {
                }
                else {
                    v4_1 = ((CandidateJournalRead)v1);
                }

                if(v4_1 != null) {
                    v1 = ((Present)v4_1).getRecord();
                }

                boolean v4_2 = true;
                if(v1 == null || v1.getOwnerUid() != Process.myUid() || v1.getPhase() != CandidatePhase.RESTORED_VERIFIED || !Intrinsics.areEqual(v1.getEvidence(), arg6.getOriginal())) {
                label_42:
                    v1_1 = 0;
                }
                else {
                    Integer v2 = v1.getActiveFactor();
                    int v3 = arg6.getFactor();
                    if(v2 == null) {
                        goto label_42;
                    }
                    else if(v2.intValue() != v3) {
                        goto label_42;
                    }
                    else if(StretchCandidateRecordCodec.INSTANCE.valid(v1)) {
                        v1_1 = 1;
                    }
                    else {
                        goto label_42;
                    }
                }

                StretchGameLifecyclePolicy v2_1 = arg6.getPolicy();
                if(!arg7 || v1_1 == 0) {
                    v4_2 = false;
                }
                else {
                }

                v2_1.restorationFinished(v4_2);
                String v4_3 = !arg7 || v1_1 == 0 ? "RESTORE_PENDING" : "RESTORE_VERIFIED_WAITING_RETURN";
                arg5.persist(arg6, v4_3);
            }
        }
    }

    private final boolean returnGeometryReady(Cycle arg7) {
        StretchOriginalEvidence v7 = arg7.getOriginal();
        if(v7 == null) {
            return 0;
        }

        Object v6 = this.app.getSystemService(DisplayManager.class);
        if(v6 != null) {
            Display v6_1 = ((DisplayManager)v6).getDisplay(0);
            if(v6_1 == null) {
            }
            else if(v6_1.isValid()) {
                if(!SetsKt.setOf(new Integer[]{Integer.valueOf(1), Integer.valueOf(3)}).contains(Integer.valueOf(v6_1.getRotation()))) {
                }
                else {
                    Object v1 = v7.getSnapshot().getOriginal().getReferenceSize().getValue();
                    if(v1 == null) {
                        return 0;
                    }
                    else {
                        Display$Mode v3 = v6_1.getMode();
                        if(v3 == null) {
                            return 0;
                        }
                        else if(v3.getPhysicalWidth() == ((StretchSize)v1).getWidth()) {
                            if(v3.getPhysicalHeight() != ((StretchSize)v1).getHeight()) {
                            }
                            else {
                                Point v1_1 = new Point();
                                v6_1.getRealSize(v1_1);
                                v6 = v7.getSnapshot().getOriginal().getLogicalSize().getValue();
                                if(v6 == null) {
                                    return 0;
                                }
                                else if(v1_1.x == ((StretchSize)v6).getWidth() && v1_1.y == ((StretchSize)v6).getHeight() && v1_1.x > v1_1.y) {
                                    return 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public final void select(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "packageName");
        this.selected = arg3;
        Cycle v0 = this.current;
        if(v0 != null && !Intrinsics.areEqual(v0.getTarget(), arg3)) {
            v0.setCancelled(true);
            GoldenStretchPhysicalController v3 = v0.getController();
            if(v3 != null) {
                v3.cancelPendingApply();
            }

            this.worker.post(new GoldenStretchGameLifecycle$$ExternalSyntheticLambda2(v0, this));
        }
    }

    static final void select$lambda$2(Cycle arg1, GoldenStretchGameLifecycle arg2) {
        arg1.getPolicy().cancel();
        arg2.persist(arg1, "GAME_CHANGED");
        if(arg1.getOriginal() != null) {
            arg2.restore(arg1);
        }
    }
}

