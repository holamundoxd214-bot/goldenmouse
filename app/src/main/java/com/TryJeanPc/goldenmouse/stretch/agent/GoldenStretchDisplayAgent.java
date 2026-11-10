package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryClock;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryCodec;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B=\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001E\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u00032\u0006\u0010 \u001A\u00020\u0011J\u0006\u0010!\u001A\u00020\"J\u0006\u0010#\u001A\u00020\"J%\u0010\'\u001A\u00020\u00182\u0006\u0010(\u001A\u00020\u00032\u0006\u0010 \u001A\u00020\u00112\u0006\u0010)\u001A\u00020\u0018H\u0000¢\u0006\u0002\b*R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000RB\u0010\u0019\u001A6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001C0\u001B0\u001Aj\u001A\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001C0\u001B`\u001DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010$\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b%\u0010&¨\u0006,"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/GoldenStretchDisplayAgent;", "", "ownerUid", "", "effectiveUid", "generation", "", "capture", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "clock", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;", "<init>", "(IILjava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;)V", "getGeneration", "()Ljava/lang/String;", "session", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "baseline", "phase", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentPhase;", "lastHeartbeat", "", "ownerUnavailable", "", "replies", "Ljava/util/LinkedHashMap;", "Lkotlin/Pair;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "Lkotlin/collections/LinkedHashMap;", "handle", "kernelCallerUid", "request", "tick", "", "ownerLost", "needsRecovery", "getNeedsRecovery", "()Z", "authorizePhysical", "callerUid", "allowRecovery", "authorizePhysical$app", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchDisplayAgent {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/GoldenStretchDisplayAgent$Companion;", "", "<init>", "()V", "PROTOCOL", "", "SHELL_UID", "OWNER_LEASE_MILLIS", "", "MAX_OPERATIONS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchAgentAction.values().length];
            try {
                v0[StretchAgentAction.READ_BASELINE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchAgentAction.PREPARE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchAgentAction.REQUEST_SIZE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchAgentAction.REQUEST_PROJECTION.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[StretchAgentAction.REQUEST_RESTORE.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[StretchAgentAction.CONFIRM.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[StretchAgentAction.HEARTBEAT.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_31:
                                            v0[StretchAgentAction.STATUS.ordinal()] = 8;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[StretchAgentAction.CLOSE.ordinal()] = 9;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_39:
                                                    v0[StretchAgentAction.OPEN.ordinal()] = 10;
                                                    goto label_43;
                                                }
                                                catch(NoSuchFieldError ) {
                                                label_43:
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
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int MAX_OPERATIONS = 0x40;
    public static final long OWNER_LEASE_MILLIS = 5000;
    public static final int PROTOCOL = 2;
    public static final int SHELL_UID = 2000;
    private StretchAgentBaseline baseline;
    private final Function1 capture;
    private final RecoveryClock clock;
    private final int effectiveUid;
    private final String generation;
    private volatile long lastHeartbeat;
    private final int ownerUid;
    private volatile boolean ownerUnavailable;
    private volatile StretchAgentPhase phase;
    private final LinkedHashMap replies;
    private volatile StretchAgentRequest session;

    static {
        GoldenStretchDisplayAgent.Companion = new Companion(null);
        GoldenStretchDisplayAgent.$stable = 8;
    }

    public GoldenStretchDisplayAgent(int arg2, int arg3, String arg4, Function1 arg5, RecoveryClock arg6) {
        Intrinsics.checkNotNullParameter(arg4, "generation");
        Intrinsics.checkNotNullParameter(arg5, "capture");
        Intrinsics.checkNotNullParameter(arg6, "clock");
        super();
        this.ownerUid = arg2;
        this.effectiveUid = arg3;
        this.generation = arg4;
        this.capture = arg5;
        this.clock = arg6;
        this.phase = StretchAgentPhase.IDLE;
        this.replies = new LinkedHashMap();
    }

    public final boolean authorizePhysical$app(int arg5, StretchAgentRequest arg6, boolean arg7) {
        boolean v1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg6, "request");
            this.tick();
            StretchAgentRequest v0 = this.session;
            v1 = false;
            if(v0 != null) {
                goto label_9;
            }
        }
        catch(Throwable v5) {
            goto label_63;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_9:
            StretchAgentBaseline v2 = this.baseline;
            if(v2 != null) {
                goto label_13;
            }
        }
        catch(Throwable v5) {
            goto label_63;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_13:
            int v3 = this.ownerUid;
            if(arg5 == v3 && v3 >= 10000 && this.effectiveUid == 2000 && arg6.getProtocol() == 2 && (Intrinsics.areEqual(arg6.getAgentGeneration(), this.generation)) && (Intrinsics.areEqual(arg6.getSessionId(), v0.getSessionId())) && (Intrinsics.areEqual(arg6.getOwnerGeneration(), v0.getOwnerGeneration())) && arg6.getLogicalDisplayId() == 0 && (StretchAgentProtocolKt.validAgentText(arg6.getOperationId())) && this.phase != StretchAgentPhase.CLOSED) {
                if((this.ownerUnavailable) && !arg7) {
                    goto label_60;
                }

                if(!Intrinsics.areEqual(arg6.getSnapshotDigest(), StretchRecoveryCodec.INSTANCE.snapshotDigest(v2.getSnapshot()))) {
                    goto label_60;
                }

                if(!Intrinsics.areEqual(arg6.getPhysicalIdentity(), v2.getSnapshot().getOriginal().getPhysicalIdentity().getValue())) {
                    goto label_60;
                }

                goto label_59;
            }

            goto label_60;
        }
        catch(Throwable v5) {
            try {
            label_63:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_63;
            }

            throw v5;
        }

    label_59:
        v1 = true;
    label_60:
        __monitor_exit(this);
        return v1;
    }

    public final String getGeneration() {
        return this.generation;
    }

    public final boolean getNeedsRecovery() {
        return this.ownerUnavailable;
    }

    public final StretchAgentReply handle(int arg8, StretchAgentRequest arg9) {
        Object v8_4;
        StretchAgentCode v7_2;
        boolean v2_1;
        StretchAgentReply v7;
        StretchAgentRequest v1;
        GoldenStretchDisplayAgent v2;
        Object v6;
        int v5;
        StretchAgentCode v3;
        int v0_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg9, "request");
            v0_1 = this.ownerUid;
            if(v0_1 >= 10000 && arg8 == v0_1) {
                if(this.effectiveUid != 2000) {
                }
                else {
                    v0_1 = 2;
                    if(arg9.getProtocol() != v0_1) {
                        v3 = StretchAgentCode.PROTOCOL_MISMATCH;
                        v5 = 8;
                        v6 = null;
                        v2 = this;
                        v1 = arg9;
                        goto label_20;
                    }
                    else {
                        goto label_27;
                    }
                }
            }

            goto label_296;
        }
        catch(Throwable v0) {
            goto label_306;
        }

        try {
        label_20:
            v7 = GoldenStretchDisplayAgent.handle$reply$default(v1, v2, v3, false, v5, v6);
        }
        catch(Throwable v0) {
            goto label_25;
        }

        __monitor_exit(v2);
        return v7;
    label_25:
        GoldenStretchDisplayAgent v1_1 = v2;
        goto label_307;
    label_27:
        v1_1 = this;
        StretchAgentRequest v7_1 = arg9;
        try {
            if(!Intrinsics.areEqual(v7_1.getAgentGeneration(), v1_1.generation)) {
                v7 = GoldenStretchDisplayAgent.handle$reply$default(v7_1, v1_1, StretchAgentCode.STALE_AGENT, false, 8, null);
            }
            else {
                goto label_41;
            }
        }
        catch(Throwable v0) {
            goto label_311;
        }

        __monitor_exit(v1_1);
        return v7;
    label_41:
        arg8 = 3;
        try {
            String[] v8 = new String[arg8];
            v2_1 = false;
            v8[0] = v7_1.getSessionId();
            v8[1] = v7_1.getOperationId();
            v8[v0_1] = v7_1.getOwnerGeneration();
            List v8_1 = CollectionsKt.listOf(((Object[])v8));
            if(!(v8_1 instanceof Collection) || !v8_1.isEmpty()) {
                Iterator v8_2 = ((Iterable)v8_1).iterator();
                goto label_59;
            }
            else {
                goto label_66;
            }
        }
        catch(Throwable v0) {
            goto label_311;
        }

    label_296:
        v1_1 = this;
        StretchAgentRequest v0_2 = arg9;
        try {
            v7 = GoldenStretchDisplayAgent.handle$reply$default(v0_2, v1_1, StretchAgentCode.UNAUTHORIZED, false, 8, null);
        }
        catch(Throwable v0) {
            goto label_311;
        }

        __monitor_exit(v1_1);
        return v7;
    label_306:
        v1_1 = this;
        goto label_307;
        try {
            do {
            label_59:
                if(!v8_2.hasNext()) {
                    break;
                }
                else if(StretchAgentProtocolKt.validAgentText(v8_2.next())) {
                    continue;
                }

                goto label_64;
            }
            while(true);

        label_66:
            String v8_3 = v7_1.getSnapshotDigest();
            if(v8_3 != null && (new Regex("[0-9a-f]{64}").matches(((CharSequence)v8_3)) ^ 1) == 1) {
                goto label_64;
            }

            v8_3 = v7_1.getPhysicalIdentity();
            if(v8_3 != null && (StretchAgentProtocolKt.validAgentText(v8_3) ^ 1) == 1) {
                goto label_64;
            }

            arg8 = v7_1.getFactorHundredths();
            if(100 > arg8) {
                goto label_64;
            }

            if(arg8 >= 200) {
                goto label_64;
            }

            if(v7_1.getLogicalDisplayId() == 0) {
                goto label_96;
            }

            v7 = GoldenStretchDisplayAgent.handle$reply$default(v7_1, v1_1, StretchAgentCode.DISPLAY_MISMATCH, false, 8, null);
        }
        catch(Throwable v0) {
            goto label_311;
        }

        __monitor_exit(v1_1);
        return v7;
    label_96:
        v0_2 = v7_1;
        try {
            v1_1.tick();
            v7_1 = v1_1.session;
            if(v7_1 != null) {
                if((Intrinsics.areEqual(v0_2.getSessionId(), v7_1.getSessionId())) && (Intrinsics.areEqual(v0_2.getOwnerGeneration(), v7_1.getOwnerGeneration()))) {
                    goto label_121;
                }

                v7_2 = v0_2.getAction() == StretchAgentAction.OPEN ? StretchAgentCode.SESSION_BUSY : StretchAgentCode.STALE_SESSION;
                v7 = GoldenStretchDisplayAgent.handle$reply$default(v0_2, v1_1, v7_2, false, 8, null);
                goto label_119;
            }

            goto label_121;
        }
        catch(Throwable v0) {
            goto label_311;
        }

    label_119:
        __monitor_exit(v1_1);
        return v7;
        try {
        label_121:
            v8_4 = v1_1.replies.get(v0_2.getOperationId());
            if(v8_4 != null && !Intrinsics.areEqual(((Pair)v8_4).getFirst(), v0_2)) {
                v7 = GoldenStretchDisplayAgent.handle$reply$default(v0_2, v1_1, StretchAgentCode.INVALID_REQUEST, false, 8, null);
                goto label_133;
            }

            goto label_135;
        }
        catch(Throwable v0) {
            goto label_311;
        }

    label_133:
        __monitor_exit(v1_1);
        return v7;
        try {
        label_135:
            if((v1_1.ownerUnavailable) && v0_2.getAction() != StretchAgentAction.STATUS) {
                v7 = GoldenStretchDisplayAgent.handle$reply$default(v0_2, v1_1, StretchAgentCode.RECOVERY_PENDING, false, 8, null);
                goto label_145;
            }

            goto label_147;
        }
        catch(Throwable v0) {
            goto label_311;
        }

    label_145:
        __monitor_exit(v1_1);
        return v7;
    label_147:
        if(v8_4 != null) {
            try {
                if(v0_2.getAction() != StretchAgentAction.STATUS) {
                    __monitor_exit(v1_1);
                    return ((Pair)v8_4).getSecond();
                }

            label_154:
                if(v1_1.replies.size() >= 0x40 && v8_4 == null) {
                    v7 = GoldenStretchDisplayAgent.handle$reply$default(v0_2, v1_1, StretchAgentCode.LIMIT_REACHED, false, 8, null);
                    goto label_164;
                }

                goto label_166;
            }
            catch(Throwable v0) {
                goto label_311;
            }
        }

        goto label_154;
    label_164:
        __monitor_exit(v1_1);
        return v7;
        try {
        label_166:
            if(WhenMappings.$EnumSwitchMapping$0[v0_2.getAction().ordinal()] == 10) {
                if(v1_1.session != null) {
                    v7_2 = StretchAgentCode.SESSION_BUSY;
                    goto label_272;
                }

                v1_1.lastHeartbeat = v1_1.clock.elapsedRealtimeMillis();
                v1_1.phase = StretchAgentPhase.OPEN;
                v1_1.session = v0_2;
                v7_2 = StretchAgentCode.ACCEPTED;
                goto label_272;
            }

            if(v7_1 != null) {
                if(v1_1.phase == StretchAgentPhase.CLOSED) {
                }
                else {
                    switch(WhenMappings.$EnumSwitchMapping$0[v0_2.getAction().ordinal()]) {
                        case 1: {
                            goto label_238;
                        }
                        case 2: 
                        case 3: 
                        case 4: 
                        case 5: {
                            goto label_213;
                        }
                        case 6: {
                            goto label_211;
                        }
                        case 7: {
                            goto label_206;
                        }
                        case 8: {
                            goto label_200;
                        }
                        case 9: {
                            goto label_196;
                        }
                    }

                    v7_2 = StretchAgentCode.INVALID_REQUEST;
                    goto label_272;
                label_196:
                    v1_1.phase = StretchAgentPhase.CLOSED;
                    v7_2 = StretchAgentCode.CLOSED;
                    goto label_272;
                label_200:
                    if(v1_1.ownerUnavailable) {
                        v7_2 = StretchAgentCode.RECOVERY_PENDING;
                    }
                    else {
                        v7_2 = StretchAgentCode.ACCEPTED;
                        goto label_272;
                    label_206:
                        v1_1.lastHeartbeat = v1_1.clock.elapsedRealtimeMillis();
                        v7_2 = StretchAgentCode.ACCEPTED;
                        goto label_272;
                    label_211:
                        v7_2 = StretchAgentCode.BLOCKED_BY_SAFETY;
                        goto label_272;
                    label_213:
                        StretchAgentBaseline v7_3 = v1_1.baseline;
                        if(v7_3 == null) {
                            v7_2 = StretchAgentCode.OUT_OF_ORDER;
                        }
                        else if(!Intrinsics.areEqual(v0_2.getSnapshotDigest(), StretchRecoveryCodec.INSTANCE.snapshotDigest(v7_3.getSnapshot()))) {
                            v7_2 = StretchAgentCode.SNAPSHOT_MISMATCH;
                        }
                        else if(!Intrinsics.areEqual(v0_2.getPhysicalIdentity(), v7_3.getSnapshot().getOriginal().getPhysicalIdentity().getValue())) {
                            v7_2 = StretchAgentCode.DISPLAY_MISMATCH;
                        }
                        else {
                            v1_1.phase = StretchAgentPhase.NOT_RECOVERABLE;
                            v7_2 = StretchAgentCode.RECOVERY_UNAVAILABLE;
                            goto label_272;
                        label_238:
                            if(v1_1.baseline != null) {
                                v7_2 = StretchAgentCode.OUT_OF_ORDER;
                            }
                            else {
                                try {
                                    Object v7_4 = v1_1.capture.invoke(v0_2.getSessionId());
                                    if(Intrinsics.areEqual(((StretchAgentBaseline)v7_4).getSnapshot().getSessionId(), v0_2.getSessionId())) {
                                        v8_4 = ((StretchAgentBaseline)v7_4).getSnapshot().getOriginal().getLogicalIdentity().getValue();
                                        if(v8_4 != null && ((StretchDisplayIdentity)v8_4).getLogicalId() == v0_2.getLogicalDisplayId()) {
                                            if(v1_1.ownerUnavailable) {
                                                v7_2 = StretchAgentCode.RECOVERY_PENDING;
                                            }
                                            else {
                                                v1_1.baseline = ((StretchAgentBaseline)v7_4);
                                                v1_1.phase = StretchAgentPhase.BASELINE_CAPTURED;
                                                v7_2 = StretchAgentCode.BASELINE_READ;
                                            }

                                            goto label_272;
                                        }
                                    }

                                    v7_2 = StretchAgentCode.DISPLAY_MISMATCH;
                                }
                                catch(Exception ) {
                                    v7_2 = StretchAgentCode.READ_FAILED;
                                }
                            }
                        }
                    }

                    goto label_272;
                }
            }

            v7_2 = StretchAgentCode.OUT_OF_ORDER;
        label_272:
            if(v1_1.ownerUnavailable) {
                v7_2 = StretchAgentCode.RECOVERY_PENDING;
            }

            if(v0_2.getAction() == StretchAgentAction.READ_BASELINE || v0_2.getAction() == StretchAgentAction.STATUS) {
                v2_1 = true;
            }

            v7 = GoldenStretchDisplayAgent.handle$reply(v0_2, v1_1, v7_2, v2_1);
            v1_1.replies.put(v0_2.getOperationId(), TuplesKt.to(v0_2, v7));
        }
        catch(Throwable v0) {
            goto label_311;
        }

        __monitor_exit(v1_1);
        return v7;
        try {
        label_64:
            v0_2 = v7_1;
            v7 = GoldenStretchDisplayAgent.handle$reply$default(v0_2, v1_1, StretchAgentCode.INVALID_REQUEST, false, 8, null);
        }
        catch(Throwable v0) {
            goto label_311;
        }

        __monitor_exit(v1_1);
        return v7;
    label_307:
        Throwable v7_5 = v0;
        try {
            __monitor_exit(v1_1);
        }
        catch(Throwable v0) {
            goto label_311;
        }

        throw v7_5;
    label_311:
        goto label_307;
    }

    private static final StretchAgentReply handle$reply(StretchAgentRequest arg9, GoldenStretchDisplayAgent arg10, StretchAgentCode arg11, boolean arg12) {
        String v1 = arg9.getOperationId();
        String v2 = arg10.generation;
        StretchAgentPhase v9 = arg10.ownerUnavailable ? StretchAgentPhase.RECOVERY_PENDING : arg10.phase;
        StretchAgentPhase v4 = v9;
        StretchAgentBaseline v9_1 = arg12 ? arg10.baseline : null;
        return new StretchAgentReply(v1, v2, arg11, v4, v9_1, null, 0x20, null);
    }

    static StretchAgentReply handle$reply$default(StretchAgentRequest arg0, GoldenStretchDisplayAgent arg1, StretchAgentCode arg2, boolean arg3, int arg4, Object arg5) {
        return GoldenStretchDisplayAgent.handle$reply(arg0, arg1, arg2, false);
    }

    public final void ownerLost() {
        if(this.session != null && this.phase != StretchAgentPhase.CLOSED) {
            this.ownerUnavailable = true;
        }
    }

    public final void tick() {
        if(this.session != null && this.phase != StretchAgentPhase.CLOSED && (this.clock.elapsedRealtimeMillis() < this.lastHeartbeat || this.clock.elapsedRealtimeMillis() - this.lastHeartbeat >= 5000)) {
            this.ownerUnavailable = true;
        }
    }
}

