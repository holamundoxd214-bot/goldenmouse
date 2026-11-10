package com.TryJeanPc.goldenmouse.graphics;

import android.content.Context;
import android.view.Display;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001AB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BJ\u001A\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0002J\u000E\u0010 \u001A\u00020\u001DH\u0082@¢\u0006\u0002\u0010!J\"\u0010\"\u001A\u0002H#\"\u0004\b\u0000\u0010#2\f\u0010$\u001A\b\u0012\u0004\u0012\u0002H#0%H\u0086@¢\u0006\u0002\u0010&J\u000E\u0010\'\u001A\u00020\u001D2\u0006\u0010\u0018\u001A\u00020\u0019J0\u0010(\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010)\u001A\u00020*2\u0006\u0010\u001A\u001A\u00020\u001B2\b\u0010+\u001A\u0004\u0018\u00010,2\u0006\u0010-\u001A\u00020*Jd\u0010.\u001A\u00020\u001D2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010)\u001A\u00020*2\u0006\u0010/\u001A\u00020*2\u0006\u0010\u001A\u001A\u00020\u001B2\b\u0010+\u001A\u0004\u0018\u00010,2\f\u00100\u001A\b\u0012\u0004\u0012\u00020\u00170%2\u001C\u00101\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001703\u0012\u0006\u0012\u0004\u0018\u00010\u000102H\u0086@¢\u0006\u0002\u00104J.\u00105\u001A\u00020\u001D2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010)\u001A\u00020*2\u0006\u0010/\u001A\u00020*2\u0006\u00106\u001A\u000207H\u0086@¢\u0006\u0002\u00108J\u000E\u00109\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019JT\u0010:\u001A\u00020*2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010)\u001A\u00020*2\u0006\u0010;\u001A\u00020*2\b\b\u0002\u0010<\u001A\u00020\u00172\"\u0010=\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020?\u0012\n\u0012\b\u0012\u0004\u0012\u00020*03\u0012\u0006\u0012\u0004\u0018\u00010\u00010>H\u0082@¢\u0006\u0002\u0010@R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006B"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRuntime;", "", "<init>", "()V", "worker", "Lkotlinx/coroutines/CoroutineScope;", "busy", "Ljava/util/concurrent/atomic/AtomicBoolean;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsStatus;", "status", "Lkotlinx/coroutines/flow/StateFlow;", "getStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "prepared", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsPreparedLaunch;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRuntime$Prepared;", "refreshPending", "watching", "recoverAfter", "", "needsPreparation", "", "context", "Landroid/content/Context;", "profile", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "watchSession", "", "initial", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readOnly", "T", "query", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "apply", "pkg", "", "display", "Landroid/view/Display;", "revision", "prepareLaunch", "attemptId", "isCurrent", "confirmRestart", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;Landroid/view/Display;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noteLaunch", "outcome", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsLaunchOutcome;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsLaunchOutcome;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restore", "perform", "source", "reserved", "action", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Prepared", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsRuntime {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000E\u0010\u000FJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0007HÆ\u0003J\u000F\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0015\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JM\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020\nHÖ\u0001J\t\u0010$\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u001D\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRuntime$Prepared;", "", "pkg", "", "access", "Lcom/TryJeanPc/goldenmouse/graphics/GoldenGraphicsBackend;", "audit", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "previousPids", "", "", "expected", "", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/graphics/GoldenGraphicsBackend;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;Ljava/util/Set;Ljava/util/Map;)V", "getPkg", "()Ljava/lang/String;", "getAccess", "()Lcom/TryJeanPc/goldenmouse/graphics/GoldenGraphicsBackend;", "getAudit", "()Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "getPreviousPids", "()Ljava/util/Set;", "getExpected", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Prepared {
        private final GoldenGraphicsBackend access;
        private final GraphicsAttemptLog audit;
        private final Map expected;
        private final String pkg;
        private final Set previousPids;

        public Prepared(String arg2, GoldenGraphicsBackend arg3, GraphicsAttemptLog arg4, Set arg5, Map arg6) {
            Intrinsics.checkNotNullParameter(arg2, "pkg");
            Intrinsics.checkNotNullParameter(arg3, "access");
            Intrinsics.checkNotNullParameter(arg4, "audit");
            Intrinsics.checkNotNullParameter(arg5, "previousPids");
            Intrinsics.checkNotNullParameter(arg6, "expected");
            super();
            this.pkg = arg2;
            this.access = arg3;
            this.audit = arg4;
            this.previousPids = arg5;
            this.expected = arg6;
        }

        public final String component1() {
            return this.pkg;
        }

        public final GoldenGraphicsBackend component2() {
            return this.access;
        }

        public final GraphicsAttemptLog component3() {
            return this.audit;
        }

        public final Set component4() {
            return this.previousPids;
        }

        public final Map component5() {
            return this.expected;
        }

        public final Prepared copy(String arg7, GoldenGraphicsBackend arg8, GraphicsAttemptLog arg9, Set arg10, Map arg11) {
            Intrinsics.checkNotNullParameter(arg7, "pkg");
            Intrinsics.checkNotNullParameter(arg8, "access");
            Intrinsics.checkNotNullParameter(arg9, "audit");
            Intrinsics.checkNotNullParameter(arg10, "previousPids");
            Intrinsics.checkNotNullParameter(arg11, "expected");
            return new Prepared(arg7, arg8, arg9, arg10, arg11);
        }

        public static Prepared copy$default(Prepared arg0, String arg1, GoldenGraphicsBackend arg2, GraphicsAttemptLog arg3, Set arg4, Map arg5, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.pkg;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.access;
            }

            if((arg6 & 4) != 0) {
                arg3 = arg0.audit;
            }

            if((arg6 & 8) != 0) {
                arg4 = arg0.previousPids;
            }

            if((arg6 & 16) != 0) {
                arg5 = arg0.expected;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5);
        }

        public boolean equals(Object arg5) {
            if(this == (((Prepared)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Prepared)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.pkg, ((Prepared)arg5).pkg)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.access, ((Prepared)arg5).access)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.audit, ((Prepared)arg5).audit)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.previousPids, ((Prepared)arg5).previousPids)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.expected, ((Prepared)arg5).expected)) {
                return 0;
            }

            return 1;
        }

        public final GoldenGraphicsBackend getAccess() {
            return this.access;
        }

        public final GraphicsAttemptLog getAudit() {
            return this.audit;
        }

        public final Map getExpected() {
            return this.expected;
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final Set getPreviousPids() {
            return this.previousPids;
        }

        public int hashCode() {
            return (((this.pkg.hashCode() * 0x1F + this.access.hashCode()) * 0x1F + this.audit.hashCode()) * 0x1F + this.previousPids.hashCode()) * 0x1F + this.expected.hashCode();
        }

        public String toString() {
            return "Prepared(pkg=" + this.pkg + ", access=" + this.access + ", audit=" + this.audit + ", previousPids=" + this.previousPids + ", expected=" + this.expected + ")";
        }
    }

    public static final int $stable;
    public static final GraphicsRuntime INSTANCE;
    private static final AtomicBoolean busy;
    private static final GraphicsPreparedLaunch prepared;
    private static volatile long recoverAfter;
    private static final AtomicBoolean refreshPending;
    private static final MutableStateFlow state;
    private static final StateFlow status;
    private static final AtomicBoolean watching;
    private static final CoroutineScope worker;

    static {
        GraphicsRuntime.INSTANCE = new GraphicsRuntime();
        GraphicsRuntime.worker = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        GraphicsRuntime.busy = new AtomicBoolean(false);
        MutableStateFlow v0 = StateFlowKt.MutableStateFlow(new GraphicsStatus(false, null, null, null, null, 0, false, null, null, false, 0x3FF, null));
        GraphicsRuntime.state = v0;
        GraphicsRuntime.status = FlowKt.asStateFlow(v0);
        GraphicsRuntime.prepared = new GraphicsPreparedLaunch();
        GraphicsRuntime.refreshPending = new AtomicBoolean(false);
        GraphicsRuntime.watching = new AtomicBoolean(false);
        GraphicsRuntime.$stable = 8;
    }

    private GraphicsRuntime() {
        super();
    }

    public static final Object access$awaitIdle(GraphicsRuntime arg0, Continuation arg1) {
        return arg0.awaitIdle(arg1);
    }

    public static final AtomicBoolean access$getBusy$p() {
        return GraphicsRuntime.busy;
    }

    public static final GraphicsPreparedLaunch access$getPrepared$p() {
        return GraphicsRuntime.prepared;
    }

    public static final long access$getRecoverAfter$p() {
        return GraphicsRuntime.recoverAfter;
    }

    public static final AtomicBoolean access$getRefreshPending$p() {
        return GraphicsRuntime.refreshPending;
    }

    public static final MutableStateFlow access$getState$p() {
        return GraphicsRuntime.state;
    }

    public static final AtomicBoolean access$getWatching$p() {
        return GraphicsRuntime.watching;
    }

    public static final Object access$perform(GraphicsRuntime arg0, Context arg1, String arg2, String arg3, boolean arg4, Function2 arg5, Continuation arg6) {
        return arg0.perform(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final void access$setRecoverAfter$p(long arg0) {
        GraphicsRuntime.recoverAfter = arg0;
    }

    public static final void access$watchSession(GraphicsRuntime arg0, Context arg1, GraphicsRecord arg2) {
        arg0.watchSession(arg1, arg2);
    }

    public final boolean apply(Context arg9, String arg10, GraphicsProfile arg11, Display arg12, String arg13) {
        Intrinsics.checkNotNullParameter(arg9, "context");
        Intrinsics.checkNotNullParameter(arg10, "pkg");
        Intrinsics.checkNotNullParameter(arg11, "profile");
        Intrinsics.checkNotNullParameter(arg13, "revision");
        if(!GraphicsStatusKt.beginGraphicsOperation(GraphicsRuntime.busy, GraphicsRuntime.state, "APLICAR")) {
            return 0;
        }

        BuildersKt.launch$default(GraphicsRuntime.worker, null, null, new GraphicsRuntime$apply$1(arg9, arg10, arg11, arg12, arg13, null), 3, null);
        return 1;
    }

    private final Object awaitIdle(Continuation arg6) {
        GraphicsRuntime$awaitIdle$1 v0_1;
        if((arg6 instanceof GraphicsRuntime$awaitIdle$1)) {
            Continuation v0 = arg6;
            int v2 = 0x80000000;
            if((((GraphicsRuntime$awaitIdle$1)v0).label & v2) != 0) {
                ((GraphicsRuntime$awaitIdle$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new GraphicsRuntime$awaitIdle$1(this, arg6);
        }

        Object v5 = v0_1.result;
        Object v6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = v0_1.label;
        if(v1 != 0) {
            if(v1 == 1) {
            }
            else {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }

        ResultKt.throwOnFailure(v5);
        do {
            if(GraphicsRuntime.busy.compareAndSet(false, true)) {
                goto label_34;
            }

            v0_1.label = 1;
        }
        while(DelayKt.delay(25, ((Continuation)v0_1)) != v6);

        return v6;
    label_34:
        return Unit.INSTANCE;
    }

    public final StateFlow getStatus() {
        return GraphicsRuntime.status;
    }

    public final boolean needsPreparation(Context arg1, GraphicsProfile arg2) {
        Intrinsics.checkNotNullParameter(arg1, "context");
        Intrinsics.checkNotNullParameter(arg2, "profile");
        return GraphicsLaunchKt.graphicsNeedsPreparation(arg2, new GraphicsJournal(arg1).read());
    }

    public final Object noteLaunch(Context arg7, String arg8, String arg9, GraphicsLaunchOutcome arg10, Continuation arg11) {
        Object v2 = GraphicsRuntime.prepared.take(arg9, arg8);
        if(v2 == null) {
            return Unit.INSTANCE;
        }

        Object v6 = BuildersKt.withContext(NonCancellable.INSTANCE.plus(Dispatchers.getIO()), new GraphicsRuntime$noteLaunch$2(arg7, ((Prepared)v2), arg10, arg8, null), arg11);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    private final Object perform(Context arg24, String arg25, String arg26, boolean arg27, Function2 arg28, Continuation arg29) {
        Exception v2_4;
        Object v20;
        Object v18;
        Object v1_2;
        boolean v2_3;
        Object v13_3;
        String v11_1;
        ObjectRef v3_1;
        boolean v1_1;
        Context v9_1;
        BooleanRef v14_1;
        Function2 v13_1;
        String v12_1;
        Function2 v14;
        GraphicsRuntime$perform$log$1 v12;
        String v13;
        CoroutineDispatcher v0_4;
        Continuation v6;
        Context v1 = arg24;
        String v2 = arg26;
        boolean v3 = arg27;
        Continuation v0 = arg29;
        String v4 = "CANCELADO · ";
        String v5 = "ERROR · ";
        if((v0 instanceof GraphicsRuntime$perform$1)) {
            v6 = v0;
            int v8 = 0x80000000;
            if((((GraphicsRuntime$perform$1)v6).label & v8) != 0) {
                ((GraphicsRuntime$perform$1)v6).label -= v8;
            }
            else {
                goto label_17;
            }
        }
        else {
        label_17:
            GraphicsRuntime$perform$1 v6_1 = new GraphicsRuntime$perform$1(this, v0);
        }

        Object v0_1 = ((GraphicsRuntime$perform$1)v6).result;
        Object v7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Continuation v10 = null;
        switch(((GraphicsRuntime$perform$1)v6).label) {
            case 0: {
                goto label_168;
            }
            case 1: {
                goto label_143;
            }
            case 2: {
                goto label_109;
            }
            case 3: {
                goto label_75;
            }
            case 4: {
                goto label_63;
            }
            case 5: {
                goto label_40;
            }
            case 6: {
                goto label_29;
            }
        }

        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_168:
        ResultKt.throwOnFailure(v0_1);
        if(!v3) {
            if(GraphicsStatusKt.beginGraphicsOperation(GraphicsRuntime.busy, GraphicsRuntime.state, v2)) {
            }
            else {
                throw new IllegalStateException("Hay una operación gráfica en curso".toString());
            }
        }

        ObjectRef v8_1 = new ObjectRef();
        BooleanRef v9 = new BooleanRef();
        ObjectRef v11 = new ObjectRef();
        v11.element = "ERROR · operación interrumpida";
        try {
            v0_4 = Dispatchers.getIO();
            v13 = arg25;
        }
        catch(Throwable v0_2) {
            v13 = arg25;
            goto label_343;
        }
        catch(Exception v0_3) {
            v13 = arg25;
            goto label_355;
        }

        try {
            v12 = new GraphicsRuntime$perform$log$1(v1, v13, v2, v10);
            ((GraphicsRuntime$perform$1)v6).L$0 = v1;
            ((GraphicsRuntime$perform$1)v6).L$1 = SpillingKt.nullOutSpilledVariable(v13);
            ((GraphicsRuntime$perform$1)v6).L$2 = v2;
            v14 = arg28;
            goto label_197;
        }
        catch(Throwable v0_2) {
        }
        catch(Exception v0_3) {
        label_355:
            v14 = arg28;
            goto label_356;
        }

    label_343:
        v14 = arg28;
        goto label_344;
        try {
        label_197:
            ((GraphicsRuntime$perform$1)v6).L$3 = v14;
            ((GraphicsRuntime$perform$1)v6).L$4 = v8_1;
            ((GraphicsRuntime$perform$1)v6).L$5 = v9;
            ((GraphicsRuntime$perform$1)v6).L$6 = v11;
            ((GraphicsRuntime$perform$1)v6).Z$0 = v3;
            ((GraphicsRuntime$perform$1)v6).label = 1;
            v0_1 = BuildersKt.withContext(((CoroutineContext)v0_4), ((Function2)v12), v6);
            if(v0_1 != v7) {
                goto label_207;
            }

            return v7;
        }
        catch(Throwable v0_2) {
        }
        catch(Exception v0_3) {
        label_356:
            v12_1 = v13;
            v13_1 = v14;
            v14_1 = v9;
            v9_1 = v1;
            v1_1 = v3;
            v3_1 = v11;
            v11_1 = v2;
            goto label_166;
        }

    label_344:
        ObjectRef v5_1 = v8_1;
        BooleanRef v4_1 = v9;
        v12_1 = v13;
        v13_1 = v14;
        v9_1 = v1;
        v1_1 = v3;
        v3_1 = v11;
        v11_1 = v2;
        goto label_420;
        return v7;
    label_207:
        v12_1 = v13;
        Context v13_2 = v1;
        v1_1 = v3;
        v3_1 = v11;
        v11_1 = v2;
        BooleanRef v2_1 = v9;
        Function2 v9_2 = v14;
        goto label_214;
    label_40:
        v1_1 = ((GraphicsRuntime$perform$1)v6).Z$0;
        Object v2_2 = ((GraphicsRuntime$perform$1)v6).L$7;
        Object v3_2 = ((GraphicsRuntime$perform$1)v6).L$6;
        Object v4_2 = ((GraphicsRuntime$perform$1)v6).L$5;
        Object v5_2 = ((GraphicsRuntime$perform$1)v6).L$4;
        Object v8_2 = ((GraphicsRuntime$perform$1)v6).L$3;
        Object v9_3 = ((GraphicsRuntime$perform$1)v6).L$2;
        Object v11_2 = ((GraphicsRuntime$perform$1)v6).L$1;
        Object v12_2 = ((GraphicsRuntime$perform$1)v6).L$0;
        try {
            ResultKt.throwOnFailure(v0_1);
            v0_1 = v2_2;
            v13_3 = v8_2;
            v2_3 = v1_1;
            v1_2 = v9_3;
            v9_3 = v12_2;
            goto label_411;
        }
        catch(Throwable v0_2) {
            v13_3 = v11_2;
            v11_2 = v9_3;
            v9_3 = v12_2;
            v12_2 = v13_3;
            v13_3 = v8_2;
            goto label_420;
        }

    label_75:
        v1_1 = ((GraphicsRuntime$perform$1)v6).Z$0;
        v2_2 = ((GraphicsRuntime$perform$1)v6).L$7;
        v3_2 = ((GraphicsRuntime$perform$1)v6).L$6;
        v8_2 = ((GraphicsRuntime$perform$1)v6).L$5;
        v11_2 = ((GraphicsRuntime$perform$1)v6).L$4;
        v12_2 = ((GraphicsRuntime$perform$1)v6).L$3;
        v13_3 = ((GraphicsRuntime$perform$1)v6).L$2;
        Object v14_2 = ((GraphicsRuntime$perform$1)v6).L$1;
        Object v15 = ((GraphicsRuntime$perform$1)v6).L$0;
        try {
            ResultKt.throwOnFailure(v0_1);
            v18 = v13_3;
            v20 = v15;
            v13_3 = v12_2;
            v12_2 = v14_2;
        }
        catch(Throwable v0_2) {
            v4_2 = v8_2;
            v5_2 = v11_2;
            v11_2 = v13_3;
            v9_3 = v15;
            v13_3 = v12_2;
            v12_2 = v14_2;
            goto label_420;
        }
        catch(Exception v0_3) {
            v2_2 = v14_2;
            v14_2 = v8_2;
            v8_2 = v11_2;
            v11_2 = v13_3;
            v13_3 = v12_2;
            v12_2 = v2_2;
            v2_4 = v0_3;
            v9_3 = v15;
            goto label_364;
        }

        goto label_271;
    label_109:
        v1_1 = ((GraphicsRuntime$perform$1)v6).Z$0;
        v2_2 = ((GraphicsRuntime$perform$1)v6).L$8;
        v3_2 = ((GraphicsRuntime$perform$1)v6).L$7;
        v8_2 = ((GraphicsRuntime$perform$1)v6).L$6;
        v11_2 = ((GraphicsRuntime$perform$1)v6).L$5;
        v12_2 = ((GraphicsRuntime$perform$1)v6).L$4;
        v13_3 = ((GraphicsRuntime$perform$1)v6).L$3;
        v14_2 = ((GraphicsRuntime$perform$1)v6).L$2;
        v15 = ((GraphicsRuntime$perform$1)v6).L$1;
        v9_3 = ((GraphicsRuntime$perform$1)v6).L$0;
        try {
            ResultKt.throwOnFailure(v0_1);
            Object v22 = v14_2;
            v14_2 = v11_2;
            v11_2 = v22;
            v22 = v15;
            v15 = v12_2;
            v12_2 = v22;
            goto label_241;
        }
        catch(Throwable v0_2) {
            v3_2 = v8_2;
            v4_2 = v11_2;
            v5_2 = v12_2;
            v11_2 = v14_2;
            v12_2 = v15;
            goto label_420;
        }
        catch(Exception v0_3) {
            v2_2 = v14_2;
            v14_2 = v11_2;
            v11_2 = v2_2;
            v2_4 = v0_3;
            v3_2 = v8_2;
            v8_2 = v12_2;
            v12_2 = v15;
            goto label_364;
        }

    label_29:
        v1_2 = ((GraphicsRuntime$perform$1)v6).L$7;
        ResultKt.throwOnFailure(v0_1);
        goto label_460;
    label_143:
        v1_1 = ((GraphicsRuntime$perform$1)v6).Z$0;
        v3_2 = ((GraphicsRuntime$perform$1)v6).L$6;
        v2_2 = ((GraphicsRuntime$perform$1)v6).L$5;
        v8_2 = ((GraphicsRuntime$perform$1)v6).L$4;
        v9_3 = ((GraphicsRuntime$perform$1)v6).L$3;
        v11_2 = ((GraphicsRuntime$perform$1)v6).L$2;
        v12_2 = ((GraphicsRuntime$perform$1)v6).L$1;
        v13_3 = ((GraphicsRuntime$perform$1)v6).L$0;
        try {
            ResultKt.throwOnFailure(v0_1);
        label_214:
            ((ObjectRef)v8_2).element = v0_1;
            ((GraphicsRuntime$perform$1)v6).L$0 = v13_3;
            ((GraphicsRuntime$perform$1)v6).L$1 = SpillingKt.nullOutSpilledVariable(v12_2);
            ((GraphicsRuntime$perform$1)v6).L$2 = v11_1;
            ((GraphicsRuntime$perform$1)v6).L$3 = SpillingKt.nullOutSpilledVariable(v9_3);
            ((GraphicsRuntime$perform$1)v6).L$4 = v8_2;
            ((GraphicsRuntime$perform$1)v6).L$5 = v2_2;
            ((GraphicsRuntime$perform$1)v6).L$6 = v3_2;
            ((GraphicsRuntime$perform$1)v6).L$7 = v0_1;
            ((GraphicsRuntime$perform$1)v6).L$8 = v3_2;
            ((GraphicsRuntime$perform$1)v6).Z$0 = v1_1;
            ((GraphicsRuntime$perform$1)v6).label = 2;
            v14_2 = ((Function2)v9_3).invoke(v0_1, v6);
            if(v14_2 != v7) {
                goto label_232;
            }
        }
        catch(Throwable v0_2) {
            v4_2 = v13_3;
            v13_3 = v9_3;
            v9_3 = v4_2;
            v4_2 = v2_2;
            v5_2 = v8_2;
            goto label_420;
        }
        catch(Exception v0_3) {
            v14_2 = v13_3;
            v13_3 = v9_3;
            v9_3 = v14_2;
            v14_2 = v2_2;
        label_166:
            v2_4 = v0_3;
            goto label_364;
        }

        return v7;
    label_232:
        v15 = v13_3;
        v13_3 = v9_3;
        v9_3 = v15;
        v15 = v8_2;
        v8_2 = v3_2;
        v3_2 = v0_1;
        v0_1 = v14_2;
        v14_2 = v2_2;
        v2_2 = v8_2;
        try {
        label_241:
            ((ObjectRef)v2_2).element = v0_1;
            v0_4 = Dispatchers.getIO();
            GraphicsRuntime$perform$3 v2_5 = new GraphicsRuntime$perform$3(((GraphicsAttemptLog)v3_2), ((ObjectRef)v8_2), v10);
            ((GraphicsRuntime$perform$1)v6).L$0 = v9_3;
            ((GraphicsRuntime$perform$1)v6).L$1 = SpillingKt.nullOutSpilledVariable(v12_2);
            ((GraphicsRuntime$perform$1)v6).L$2 = v11_1;
            ((GraphicsRuntime$perform$1)v6).L$3 = SpillingKt.nullOutSpilledVariable(v13_3);
            ((GraphicsRuntime$perform$1)v6).L$4 = v15;
            ((GraphicsRuntime$perform$1)v6).L$5 = v14_2;
            ((GraphicsRuntime$perform$1)v6).L$6 = v8_2;
            ((GraphicsRuntime$perform$1)v6).L$7 = SpillingKt.nullOutSpilledVariable(v3_2);
            ((GraphicsRuntime$perform$1)v6).L$8 = null;
            ((GraphicsRuntime$perform$1)v6).Z$0 = v1_1;
            ((GraphicsRuntime$perform$1)v6).label = 3;
            if(BuildersKt.withContext(((CoroutineContext)v0_4), ((Function2)v2_5), v6) != v7) {
                goto label_264;
            }
        }
        catch(Throwable v0_2) {
            v3_2 = v8_2;
            v4_2 = v14_2;
            v5_2 = v15;
            goto label_420;
        }
        catch(Exception v0_3) {
            v2_4 = v0_3;
            v3_2 = v8_2;
            v8_2 = v15;
            goto label_364;
        }

        return v7;
    label_264:
        v2_2 = v3_2;
        v3_2 = v8_2;
        v20 = v9_3;
        v18 = v11_1;
        v8_2 = v14_2;
        v11_2 = v15;
        try {
        label_271:
            ((BooleanRef)v8_2).element = true;
            v0_1 = ((ObjectRef)v3_2).element;
            goto label_273;
        }
        catch(Throwable v0_2) {
            v5_2 = v11_2;
            v11_2 = v18;
            v4_2 = v8_2;
            v9_3 = v20;
        }
        catch(Exception v0_3) {
            Object v19 = v8_2;
            v2_4 = v0_3;
            v8_2 = v11_2;
            v11_2 = v18;
            v14_2 = v19;
            v9_3 = v20;
            try {
            label_364:
                String v0_5 = (v2_4 instanceof CancellationException) ? v4 + v2_4.getMessage() + "; cualquier sesión ya escrita se conserva" : v5 + v2_4.getMessage();
                ((ObjectRef)v3_2).element = v0_5;
                CoroutineContext v0_6 = NonCancellable.INSTANCE.plus(Dispatchers.getIO());
                GraphicsRuntime$perform$4 v4_3 = new GraphicsRuntime$perform$4(((ObjectRef)v8_2), v2_4, ((ObjectRef)v3_2), null);
                ((GraphicsRuntime$perform$1)v6).L$0 = v9_3;
                ((GraphicsRuntime$perform$1)v6).L$1 = SpillingKt.nullOutSpilledVariable(v12_2);
                ((GraphicsRuntime$perform$1)v6).L$2 = v11_1;
                ((GraphicsRuntime$perform$1)v6).L$3 = SpillingKt.nullOutSpilledVariable(v13_1);
                ((GraphicsRuntime$perform$1)v6).L$4 = SpillingKt.nullOutSpilledVariable(v8_2);
                ((GraphicsRuntime$perform$1)v6).L$5 = v14_1;
                ((GraphicsRuntime$perform$1)v6).L$6 = v3_2;
                ((GraphicsRuntime$perform$1)v6).L$7 = v2_4;
                ((GraphicsRuntime$perform$1)v6).L$8 = null;
                ((GraphicsRuntime$perform$1)v6).Z$0 = v1_1;
                ((GraphicsRuntime$perform$1)v6).label = 5;
                if(BuildersKt.withContext(v0_6, ((Function2)v4_3), v6) != v7) {
                    goto label_405;
                }
            }
            catch(Throwable v0_2) {
                v5_2 = v8_2;
                v4_2 = v14_1;
                goto label_420;
            }

            return v7;
        label_405:
            v0_3 = v2_4;
            v5_2 = v8_2;
            v4_2 = v14_1;
            v2_3 = v1_1;
            v1_2 = v11_1;
            v11_2 = v12_2;
            try {
            label_411:
                throw v0_1;
            }
            catch(Throwable v0_2) {
                v12_2 = v11_2;
                v11_2 = v1_2;
                v1_1 = v2_3;
            }
        }

    label_420:
        CoroutineContext v2_6 = NonCancellable.INSTANCE.plus(Dispatchers.getIO());
        Object v24 = v3_2;
        GraphicsRuntime$perform$5 v3_3 = new GraphicsRuntime$perform$5(((ObjectRef)v24), v11_1, v4_1, v9_3, null);
        ((GraphicsRuntime$perform$1)v6).L$0 = SpillingKt.nullOutSpilledVariable(v9_3);
        ((GraphicsRuntime$perform$1)v6).L$1 = SpillingKt.nullOutSpilledVariable(v12_2);
        ((GraphicsRuntime$perform$1)v6).L$2 = SpillingKt.nullOutSpilledVariable(v11_1);
        ((GraphicsRuntime$perform$1)v6).L$3 = SpillingKt.nullOutSpilledVariable(v13_1);
        ((GraphicsRuntime$perform$1)v6).L$4 = SpillingKt.nullOutSpilledVariable(v5_1);
        ((GraphicsRuntime$perform$1)v6).L$5 = SpillingKt.nullOutSpilledVariable(v4_1);
        ((GraphicsRuntime$perform$1)v6).L$6 = SpillingKt.nullOutSpilledVariable(v24);
        ((GraphicsRuntime$perform$1)v6).L$7 = v0_2;
        ((GraphicsRuntime$perform$1)v6).L$8 = null;
        ((GraphicsRuntime$perform$1)v6).Z$0 = v1_1;
        ((GraphicsRuntime$perform$1)v6).label = 6;
        if(BuildersKt.withContext(v2_6, ((Function2)v3_3), v6) == v7) {
            return v7;
        }

        Throwable v1_3 = v0_2;
    label_460:
        throw v1_3;
    label_273:
        CoroutineContext v4_4 = NonCancellable.INSTANCE.plus(Dispatchers.getIO());
        Object v17 = v3_2;
        v3_3 = new GraphicsRuntime$perform$5(((ObjectRef)v17), ((String)v18), v8_2, ((Context)v20), null);
        ((GraphicsRuntime$perform$1)v6).L$0 = SpillingKt.nullOutSpilledVariable(v20);
        ((GraphicsRuntime$perform$1)v6).L$1 = SpillingKt.nullOutSpilledVariable(v12_2);
        ((GraphicsRuntime$perform$1)v6).L$2 = SpillingKt.nullOutSpilledVariable(v18);
        ((GraphicsRuntime$perform$1)v6).L$3 = SpillingKt.nullOutSpilledVariable(v13_3);
        ((GraphicsRuntime$perform$1)v6).L$4 = SpillingKt.nullOutSpilledVariable(v11_2);
        ((GraphicsRuntime$perform$1)v6).L$5 = SpillingKt.nullOutSpilledVariable(v8_2);
        ((GraphicsRuntime$perform$1)v6).L$6 = SpillingKt.nullOutSpilledVariable(v17);
        ((GraphicsRuntime$perform$1)v6).L$7 = SpillingKt.nullOutSpilledVariable(v2_2);
        ((GraphicsRuntime$perform$1)v6).L$8 = v0_1;
        ((GraphicsRuntime$perform$1)v6).Z$0 = v1_1;
        ((GraphicsRuntime$perform$1)v6).label = 4;
        if(BuildersKt.withContext(v4_4, ((Function2)v3_3), v6) == v7) {
            return v7;
        }

        return v0_1;
    label_63:
        v1_2 = ((GraphicsRuntime$perform$1)v6).L$8;
        ResultKt.throwOnFailure(v0_1);
        return v1_2;
    }

    static Object perform$default(GraphicsRuntime arg7, Context arg8, String arg9, String arg10, boolean arg11, Function2 arg12, Continuation arg13, int arg14, Object arg15) {
        return arg7.perform(arg8, arg9, arg10, false, arg12, arg13);
    }

    public final Object prepareLaunch(Context arg15, String arg16, String arg17, GraphicsProfile arg18, Display arg19, Function0 arg20, Function1 arg21, Continuation arg22) {
        Object v9;
        Object v7;
        Continuation v1;
        Continuation v0 = arg22;
        if((v0 instanceof GraphicsRuntime$prepareLaunch$1)) {
            v1 = v0;
            int v3 = 0x80000000;
            if((((GraphicsRuntime$prepareLaunch$1)v1).label & v3) != 0) {
                ((GraphicsRuntime$prepareLaunch$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            GraphicsRuntime$prepareLaunch$1 v1_1 = new GraphicsRuntime$prepareLaunch$1(this, v0);
        }

        Object v14 = ((GraphicsRuntime$prepareLaunch$1)v1).result;
        Object v0_1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2 = ((GraphicsRuntime$prepareLaunch$1)v1).label;
        Continuation v3_1 = null;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v14);
            CoroutineDispatcher v14_1 = Dispatchers.getIO();
            GraphicsRuntime$prepareLaunch$pending$1 v2_2 = new GraphicsRuntime$prepareLaunch$pending$1(arg15, v3_1);
            ((GraphicsRuntime$prepareLaunch$1)v1).L$0 = arg15;
            String v6_1 = arg16;
            ((GraphicsRuntime$prepareLaunch$1)v1).L$1 = v6_1;
            String v7_1 = arg17;
            ((GraphicsRuntime$prepareLaunch$1)v1).L$2 = v7_1;
            GraphicsProfile v8_1 = arg18;
            ((GraphicsRuntime$prepareLaunch$1)v1).L$3 = v8_1;
            Display v9_1 = arg19;
            ((GraphicsRuntime$prepareLaunch$1)v1).L$4 = v9_1;
            Function0 v10_1 = arg20;
            ((GraphicsRuntime$prepareLaunch$1)v1).L$5 = v10_1;
            Function1 v11_1 = arg21;
            ((GraphicsRuntime$prepareLaunch$1)v1).L$6 = v11_1;
            ((GraphicsRuntime$prepareLaunch$1)v1).label = 1;
            v14 = BuildersKt.withContext(((CoroutineContext)v14_1), ((Function2)v2_2), v1);
            if(v14 == v0_1) {
                return v0_1;
            }
            else {
                Function0 v12_1 = v10_1;
                GraphicsProfile v10_2 = v8_1;
                Function0 v8_2 = v12_1;
                Function1 v12_2 = v11_1;
                Display v11_2 = v9_1;
                Function1 v9_2 = v12_2;
                String v12_3 = v7_1;
                v7_1 = v6_1;
                Context v6_2 = arg15;
            label_83:
                GraphicsRuntime$prepareLaunch$2 v15_1 = new GraphicsRuntime$prepareLaunch$2(v6_2, ((String)v7), v8_2, v3_1);
                GraphicsRuntime$prepareLaunch$3 v5_1 = new GraphicsRuntime$prepareLaunch$3(v6_2, ((String)v7), v8_2, ((Function1)v9), v10_2, v11_2, v12_3, null);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$0 = SpillingKt.nullOutSpilledVariable(v6_2);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$1 = SpillingKt.nullOutSpilledVariable(v7);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$2 = SpillingKt.nullOutSpilledVariable(v12_3);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$3 = SpillingKt.nullOutSpilledVariable(v10_2);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$4 = SpillingKt.nullOutSpilledVariable(v11_2);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$5 = SpillingKt.nullOutSpilledVariable(v8_2);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$6 = SpillingKt.nullOutSpilledVariable(v9);
                ((GraphicsRuntime$prepareLaunch$1)v1).L$7 = SpillingKt.nullOutSpilledVariable(v14);
                ((GraphicsRuntime$prepareLaunch$1)v1).label = v4;
                if(GraphicsLaunchKt.prepareGraphicsTexture(v10_2, ((GraphicsRecord)v14), ((Function1)v15_1), ((Function1)v5_1), v1) == v0_1) {
                    return v0_1;
                }
            }
        }
        else if(v2 == 1) {
            Object v15 = ((GraphicsRuntime$prepareLaunch$1)v1).L$6;
            Object v2_1 = ((GraphicsRuntime$prepareLaunch$1)v1).L$5;
            Object v5 = ((GraphicsRuntime$prepareLaunch$1)v1).L$4;
            Object v6 = ((GraphicsRuntime$prepareLaunch$1)v1).L$3;
            v7 = ((GraphicsRuntime$prepareLaunch$1)v1).L$2;
            Object v8 = ((GraphicsRuntime$prepareLaunch$1)v1).L$1;
            v9 = ((GraphicsRuntime$prepareLaunch$1)v1).L$0;
            ResultKt.throwOnFailure(v14);
            Object v11 = v5;
            Object v10 = v6;
            Object v12 = v7;
            v7 = v8;
            v6 = v9;
            v9 = v15;
            v8 = v2_1;
            goto label_83;
        }
        else if(v2 == v4) {
            ResultKt.throwOnFailure(v14);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public final Object readOnly(Function0 arg7, Continuation arg8) {
        Object v7;
        int v2;
        Continuation v0;
        if((arg8 instanceof GraphicsRuntime$readOnly$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((GraphicsRuntime$readOnly$1)v0).label & v2) != 0) {
                ((GraphicsRuntime$readOnly$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            GraphicsRuntime$readOnly$1 v0_1 = new GraphicsRuntime$readOnly$1(this, arg8);
        }

        Object v8 = ((GraphicsRuntime$readOnly$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((GraphicsRuntime$readOnly$1)v0).label;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            ((GraphicsRuntime$readOnly$1)v0).L$0 = arg7;
            ((GraphicsRuntime$readOnly$1)v0).label = 1;
            if(this.awaitIdle(v0) == v1) {
                return v1;
            }
            else {
                try {
                label_41:
                    CoroutineDispatcher v6_1 = Dispatchers.getIO();
                    GraphicsRuntime$readOnly$2 v8_1 = new GraphicsRuntime$readOnly$2(((Function0)v7), null);
                    ((GraphicsRuntime$readOnly$1)v0).L$0 = SpillingKt.nullOutSpilledVariable(v7);
                    ((GraphicsRuntime$readOnly$1)v0).label = v4;
                    v8 = BuildersKt.withContext(((CoroutineContext)v6_1), ((Function2)v8_1), v0);
                    if(v8 != v1) {
                        goto label_51;
                    }
                }
                catch(Throwable v6) {
                label_54:
                    GraphicsRuntime.busy.set(false);
                    throw v6;
                }

                return v1;
            }
        }
        else if(v2 == 1) {
            v7 = ((GraphicsRuntime$readOnly$1)v0).L$0;
            ResultKt.throwOnFailure(v8);
            goto label_41;
        }
        else if(v2 == v4) {
            try {
                ResultKt.throwOnFailure(v8);
            }
            catch(Throwable v6) {
                goto label_54;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_51:
        GraphicsRuntime.busy.set(false);
        return v8;
    }

    public final void refresh(Context arg8) {
        Intrinsics.checkNotNullParameter(arg8, "context");
        GraphicsJournal v7 = new GraphicsJournal(arg8);
        if((v7.hasPending()) || GraphicsRuntime.state.getValue().getPendingPackage() != null) {
            if(!GraphicsRuntime.refreshPending.compareAndSet(false, true)) {
                return;
            }

            goto label_17;
        }
        else {
        }

        return;
    label_17:
        BuildersKt.launch$default(GraphicsRuntime.worker, null, null, new GraphicsRuntime$refresh$1(v7, arg8, null), 3, null);
    }

    public final boolean restore(Context arg7) {
        Intrinsics.checkNotNullParameter(arg7, "context");
        if(!GraphicsStatusKt.beginGraphicsOperation(GraphicsRuntime.busy, GraphicsRuntime.state, "RESTAURAR")) {
            return 0;
        }

        BuildersKt.launch$default(GraphicsRuntime.worker, null, null, new GraphicsRuntime$restore$1(arg7, null), 3, null);
        return 1;
    }

    private final void watchSession(Context arg7, GraphicsRecord arg8) {
        if(GraphicsLaunchKt.graphicsWatchRequired(arg8)) {
            if(!GraphicsRuntime.watching.compareAndSet(false, true)) {
            }
            else {
                BuildersKt.launch$default(GraphicsRuntime.worker, null, null, new GraphicsRuntime$watchSession$1(arg7, null), 3, null);
            }
        }
    }
}

