package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryClock;
import java.nio.channels.OverlappingFileLockException;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0001\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u001A\u0010\n\u001A\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000E0\u000B\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010,\u001A\u00020-J:\u0010.\u001A\u00020%2\u0006\u0010/\u001A\u00020\u00032\u0006\u00100\u001A\u00020#2\u0006\u00101\u001A\u00020$2\b\u00102\u001A\u0004\u0018\u00010\f2\u0010\b\u0002\u00103\u001A\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\tJ\u001E\u00104\u001A\u00020\u001F2\u0006\u00102\u001A\u00020\f2\f\u00105\u001A\b\u0012\u0004\u0012\u00020\u00140\tH\u0002J&\u00106\u001A\u00020\u001F2\u0006\u00107\u001A\u00020\f2\u0006\u00101\u001A\u00020$2\f\u00105\u001A\b\u0012\u0004\u0012\u00020\u00140\tH\u0002J\u0010\u00108\u001A\u00020-2\u0006\u00109\u001A\u00020\u001FH\u0002J\u0010\u0010:\u001A\u00020\u001F2\b\b\u0002\u0010;\u001A\u00020\u0010J\"\u0010<\u001A\u00020%2\u0006\u00100\u001A\u00020\u00052\u0006\u0010=\u001A\u00020\u00052\b\u0010>\u001A\u0004\u0018\u00010\u0005H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001A\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000E0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u000E¢\u0006\u0002\n\u0000RZ\u0010 \u001AN\u0012\u0004\u0012\u00020\u0005\u0012\u001C\u0012\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"\u0012\u0004\u0012\u00020%0\"0!j&\u0012\u0004\u0012\u00020\u0005\u0012\u001C\u0012\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"\u0012\u0004\u0012\u00020%0\"`&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\'\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b(\u0010)R\u0011\u0010*\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b+\u0010)¨\u0006?"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalSession;", "", "ownerUid", "", "generation", "", "clock", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;", "bootId", "Lkotlin/Function0;", "io", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalIo;", "ownerAlive", "", "<init>", "(ILjava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "journal", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;", "pair", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalPair;", "binding", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryBinding;", "recoveryRequested", "Ljava/util/concurrent/atomic/AtomicBoolean;", "autoRecoveryAttempted", "restoreOnly", "recoveredWithoutMutation", "last", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPairResult;", "operations", "Ljava/util/LinkedHashMap;", "Lkotlin/Pair;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalOperation;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalReply;", "Lkotlin/collections/LinkedHashMap;", "retained", "getRetained", "()Z", "pending", "getPending", "requestRecovery", "", "execute", "callerUid", "operation", "request", "evidence", "openJournal", "prepare", "open", "resumeRestore", "current", "releaseVerified", "result", "poll", "ownerPresent", "snapshot", "code", "error", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalSession {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchPhysicalOperation.values().length];
            try {
                v0[StretchPhysicalOperation.PREPARE.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchPhysicalOperation.APPLY.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchPhysicalOperation.RESTORE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchPhysicalOperation.RELEASE.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[StretchPhysicalOperation.RECOVER_PERSISTED.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[StretchPhysicalOperation.STATUS.ordinal()] = 6;
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

    public static final int $stable = 8;
    private boolean autoRecoveryAttempted;
    private StretchRecoveryBinding binding;
    private final Function0 bootId;
    private final RecoveryClock clock;
    private final String generation;
    private final Function2 io;
    private StretchCandidateJournal journal;
    private StretchPairResult last;
    private final LinkedHashMap operations;
    private final Function0 ownerAlive;
    private final int ownerUid;
    private StretchPhysicalPair pair;
    private boolean recoveredWithoutMutation;
    private final AtomicBoolean recoveryRequested;
    private boolean restoreOnly;

    static {
    }

    public StretchPhysicalSession(int arg13, String arg14, RecoveryClock arg15, Function0 arg16, Function2 arg17, Function0 arg18) {
        Intrinsics.checkNotNullParameter(arg14, "generation");
        Intrinsics.checkNotNullParameter(arg15, "clock");
        Intrinsics.checkNotNullParameter(arg16, "bootId");
        Intrinsics.checkNotNullParameter(arg17, "io");
        Intrinsics.checkNotNullParameter(arg18, "ownerAlive");
        super();
        this.ownerUid = arg13;
        this.generation = arg14;
        this.clock = arg15;
        this.bootId = arg16;
        this.io = arg17;
        this.ownerAlive = arg18;
        this.recoveryRequested = new AtomicBoolean();
        this.last = new StretchPairResult("NOT_PREPARED", null, null, 0, 0, 0, 62, null);
        this.operations = new LinkedHashMap();
    }

    public final StretchPhysicalReply execute(int arg19, StretchPhysicalOperation arg20, StretchAgentRequest arg21, StretchOriginalEvidence arg22, Function0 arg23) {
        StretchPairResult v0_6;
        StretchPairResult v6_1;
        StretchPhysicalReply v0_3;
        Pair v5_1;
        StretchPhysicalSession v1 = this;
        StretchPhysicalOperation v0 = arg20;
        StretchAgentRequest v2 = arg21;
        StretchOriginalEvidence v3 = arg22;
        Function0 v4 = arg23;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v0, "operation");
            Intrinsics.checkNotNullParameter(v2, "request");
            int v5 = v1.ownerUid;
            if(arg19 == v5) {
                if(v5 < 10000) {
                }
                else {
                    if(v2.getProtocol() == 2 && (Intrinsics.areEqual(v2.getAgentGeneration(), v1.generation)) && v2.getAction() == StretchAgentAction.STATUS) {
                        if(!StretchAgentProtocolKt.validAgentText(v2.getOperationId())) {
                        }
                        else {
                            if(v3 != null) {
                                if(!StretchOriginalEvidenceRpc.INSTANCE.boundTo(v3, v2)) {
                                }
                                else {
                                    v5_1 = TuplesKt.to(arg20, arg21);
                                    Object v6 = v1.operations.get(v2.getOperationId());
                                    if(v6 != null) {
                                        if(Intrinsics.areEqual(((Pair)v6).getFirst(), v5_1)) {
                                            Object v0_2 = ((Pair)v6).getSecond();
                                        }
                                        else {
                                            v0_3 = StretchPhysicalSession.execute$reply$default(v1, v2, "OPERATION_ID_REUSED", null, 8, null);
                                        }

                                        goto label_50;
                                    }
                                    else {
                                        goto label_52;
                                    }
                                }
                            }

                            goto label_257;
                        }
                    }

                    goto label_264;
                }
            }

            goto label_273;
        }
        catch(Throwable v0_1) {
            goto label_283;
        }

    label_50:
        __monitor_exit(this);
        return v0_3;
        try {
        label_52:
            if(v1.operations.size() < 0x40) {
                goto label_64;
            }

            v0_3 = StretchPhysicalSession.execute$reply$default(v1, arg21, "LIMIT_REACHED", null, 8, null);
        }
        catch(Throwable v0_1) {
            goto label_283;
        }

        __monitor_exit(this);
        return v0_3;
    label_64:
        v2 = arg21;
        try {
            if(v0 != StretchPhysicalOperation.STATUS) {
                goto label_74;
            }

            v0_3 = StretchPhysicalSession.execute$reply(v1, v2, v1.last.getCode(), v1.last.getErrorType());
        }
        catch(Throwable v0_1) {
            goto label_283;
        }

        __monitor_exit(this);
        return v0_3;
        try {
        label_74:
            switch(WhenMappings.$EnumSwitchMapping$0[v0.ordinal()]) {
                case 1: {
                    goto label_206;
                }
                case 2: {
                    goto label_147;
                }
                case 3: {
                    goto label_98;
                }
                case 4: {
                    goto label_93;
                }
                case 5: {
                    goto label_85;
                }
                case 6: {
                    goto label_80;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_98:
            if(v1.recoveredWithoutMutation) {
                v6_1 = new StretchPairResult("NO_MUTATION_REQUESTED", null, null, 0, 0, 0, 62, null);
                goto label_246;
            }

            boolean v0_5 = v1.restoreOnly;
            if((v0_5) && v1.journal == null) {
                v0_6 = v1.last;
                goto label_247;
            }

            StretchPhysicalPair v3_1 = v1.pair;
            if(v3_1 != null) {
                StretchRecoveryBinding v4_1 = v1.binding;
                if(v4_1 != null) {
                    v0_6 = v3_1.restore(v4_1, true, v0_5);
                    if(v0_6 != null) {
                        if(Intrinsics.areEqual(v0_6.getCode(), "RESTORE_READBACK_MATCHED_UNACCREDITED")) {
                            v1.autoRecoveryAttempted = true;
                        }

                        v1.releaseVerified(v0_6);
                        goto label_247;
                    }
                }
                else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }

            v6_1 = new StretchPairResult("RECOVERY_EXECUTOR_UNAVAILABLE", null, null, 0, 0, 0, 62, null);
            goto label_246;
        label_147:
            if(v1.restoreOnly) {
                v6_1 = new StretchPairResult("RESTORE_ONLY_SESSION", null, null, 0, 0, 0, 62, null);
                goto label_246;
            }

            if(v2.getFactorHundredths() != 105) {
                v6_1 = new StretchPairResult("ONLY_CONTROLLED_105_SUPPORTED", null, null, 0, 0, 0, 62, null);
                goto label_246;
            }

            StretchPhysicalPair v6_2 = v1.pair;
            if(v6_2 != null) {
                StretchRecoveryBinding v7 = v1.binding;
                if(v7 != null) {
                    v0_6 = StretchPhysicalPair.apply$default(v6_2, v7, true, v1.bootId.invoke(), v1.clock.elapsedRealtimeMillis(), 0, 16, null);
                    if(v0_6 == null) {
                    }
                    else {
                        goto label_247;
                    }
                }
                else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }

            v6_1 = new StretchPairResult("NOT_PREPARED", null, null, 0, 0, 0, 62, null);
            goto label_246;
        label_85:
            if(v4 != null) {
                v0_6 = v1.resumeRestore(v3, v2, v4);
                goto label_247;
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        label_93:
            v1.requestRecovery();
            v1.poll(false);
            v0_6 = v1.last;
            goto label_247;
        label_206:
            if(v1.restoreOnly) {
                v6_1 = new StretchPairResult("RESTORE_ONLY_SESSION", null, null, 0, 0, 0, 62, null);
                goto label_246;
            }

            if(v4 != null) {
                v0_6 = v1.prepare(v3, v4);
                goto label_247;
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        label_80:
            throw new IllegalStateException("Handled above".toString());
        }
        catch(Throwable v0_1) {
        }
        catch(Exception v0_4) {
            try {
                String v3_2 = (v0_4 instanceof OverlappingFileLockException) ? "JOURNAL_BUSY" : "PHYSICAL_SESSION_ERROR";
                v6_1 = new StretchPairResult(v3_2, v0_4.getClass().getSimpleName(), null, 0, 0, 0, 60, null);
            label_246:
                v0_6 = v6_1;
            label_247:
                v1.last = v0_6;
                v0_3 = StretchPhysicalSession.execute$reply(v1, v2, v0_6.getCode(), v0_6.getErrorType());
                v1.operations.put(v2.getOperationId(), TuplesKt.to(v5_1, v0_3));
            }
            catch(Throwable v0_1) {
                goto label_283;
            }

            __monitor_exit(this);
            return v0_3;
            try {
            label_257:
                v0_3 = StretchPhysicalSession.execute$reply$default(v1, v2, "STALE_SESSION_OR_SNAPSHOT", null, 8, null);
            }
            catch(Throwable v0_1) {
                goto label_283;
            }

            __monitor_exit(this);
            return v0_3;
            try {
            label_264:
                v0_3 = StretchPhysicalSession.execute$reply$default(this, arg21, "INVALID_ENVELOPE", null, 8, null);
            }
            catch(Throwable v0_1) {
                goto label_283;
            }

            __monitor_exit(this);
            return v0_3;
            try {
            label_273:
                v0_3 = StretchPhysicalSession.execute$reply$default(this, arg21, "UNAUTHORIZED", null, 8, null);
            }
            catch(Throwable v0_1) {
                try {
                label_283:
                    __monitor_exit(this);
                }
                catch(Throwable v0_1) {
                    goto label_283;
                }

                throw v0_1;
            }
        }

        __monitor_exit(this);
        return v0_3;
    }

    public static StretchPhysicalReply execute$default(StretchPhysicalSession arg6, int arg7, StretchPhysicalOperation arg8, StretchAgentRequest arg9, StretchOriginalEvidence arg10, Function0 arg11, int arg12, Object arg13) {
        if((arg12 & 16) != 0) {
            arg11 = null;
        }

        return arg6.execute(arg7, arg8, arg9, arg10, arg11);
    }

    private static final StretchPhysicalReply execute$reply(StretchPhysicalSession arg0, StretchAgentRequest arg1, String arg2, String arg3) {
        return arg0.snapshot(arg1.getOperationId(), arg2, arg3);
    }

    static StretchPhysicalReply execute$reply$default(StretchPhysicalSession arg0, StretchAgentRequest arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 8) != 0) {
            arg3 = null;
        }

        return StretchPhysicalSession.execute$reply(arg0, arg1, arg2, arg3);
    }

    public final boolean getPending() {
        boolean v1;
        __monitor_enter(this);
        try {
            StretchCandidateJournal v0_1 = this.journal;
            v1 = false;
            if(v0_1 != null) {
                CandidateJournalRead v0_2 = v0_1.load();
                if(v0_2 != null) {
                    if((v0_2 instanceof Present)) {
                        if(v0_2.getRecord().getPhase() == CandidatePhase.RESTORED_VERIFIED) {
                            goto label_24;
                        }
                        else if((v0_2.getRecord().getIntentions().isEmpty()) && ((Present)v0_2).getRecord().getExecutorProbe() == CandidateExecutorProbe.NONE) {
                            goto label_24;
                        }
                    }

                    goto label_22;
                }
            }

            goto label_24;
        }
        catch(Throwable v0) {
            try {
            label_27:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_27;
            }

            throw v0;
        }

    label_22:
        v1 = true;
    label_24:
        __monitor_exit(this);
        return v1;
    }

    public final boolean getRetained() {
        __monitor_enter(this);
        try {
            if(this.journal == null) {
                goto label_5;
            }
        }
        catch(Throwable v0) {
            try {
            label_9:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

        boolean v0_1 = true;
        goto label_6;
    label_5:
        v0_1 = false;
    label_6:
        __monitor_exit(this);
        return v0_1;
    }

    public final StretchPairResult poll(boolean arg20) {
        StretchPairResult v7_1;
        long v11;
        Object v10;
        StretchPhysicalPair v7;
        CustodyEvent v9;
        StretchCandidateRecord v0_3;
        CandidateJournalRead v0_2;
        StretchCandidateJournal v6;
        int v4;
        int v3;
        StretchPairResult v0_1;
        StretchCandidateJournal v2;
        StretchPhysicalSession v1 = this;
        __monitor_enter(this);
        try {
            v2 = v1.journal;
            if(v2 != null) {
                goto label_7;
            }

            v0_1 = v1.last;
        }
        catch(Throwable v0) {
            goto label_190;
        }

        __monitor_exit(this);
        return v0_1;
    label_7:
        if(!arg20) {
            try {
                v1.requestRecovery();
            label_9:
                v3 = 2;
                v4 = 0;
                v6 = null;
                if(!v1.restoreOnly) {
                    goto label_42;
                }

                v0_2 = v2.load();
                if((v0_2 instanceof Present)) {
                }
                else {
                    v0_2 = ((CandidateJournalRead)v6);
                }

                if(v0_2 != null) {
                    v0_3 = ((Present)v0_2).getRecord();
                    if(v0_3 != null) {
                        CandidatePhase v0_4 = v0_3.getPhase();
                    }
                    else {
                        goto label_25;
                    }
                }
                else {
                label_25:
                    Object v0_5 = v6;
                }

                if(arg20) {
                    CandidatePhase[] v3_1 = new CandidatePhase[v3];
                    v3_1[0] = CandidatePhase.CLOSED_WITHOUT_MUTATION;
                    v3_1[1] = CandidatePhase.RESTORED_VERIFIED;
                    if(CollectionsKt.contains(SetsKt.setOf(((Object[])v3_1)), v0_4)) {
                        goto label_35;
                    }
                }
                else {
                label_35:
                    v2.close();
                    v1.journal = v6;
                    v1.pair = ((StretchPhysicalPair)v6);
                    v1.binding = ((StretchRecoveryBinding)v6);
                }

                v0_1 = v1.last;
                goto label_40;
            }
            catch(Throwable v0) {
                goto label_190;
            }
        }

        goto label_9;
    label_40:
        __monitor_exit(this);
        return v0_1;
        try {
        label_42:
            CustodyEvent v0_7 = v1.recoveryRequested.get() ? CustodyEvent.OWNER_PROCESS_LOST : CustodyEvent.POLL;
            v9 = v0_7;
            v7 = v1.pair;
            v10 = v1.bootId.invoke();
            v11 = v1.clock.elapsedRealtimeMillis();
            v0_2 = v2.load();
            if((v0_2 instanceof Present)) {
            }
            else {
                v0_2 = ((CandidateJournalRead)v6);
            }

            v0_3 = v0_2 != null ? ((Present)v0_2).getRecord() : ((StretchCandidateRecord)v6);
            StretchRecoveryCustody v8 = v0_3 != null ? v0_3.getCustody() : ((StretchRecoveryCustody)v6);
            if(v9 != CustodyEvent.POLL || v8 == null || !Intrinsics.areEqual(v10, v8.getBootId())) {
            label_96:
                v4 = 1;
            }
            else {
                if(v11 < v8.getStartedElapsedMillis()) {
                }
                else if(v11 < v8.getExpiresElapsedMillis()) {
                    CandidatePhase[] v8_1 = new CandidatePhase[4];
                    v8_1[0] = CandidatePhase.EXECUTION_UNKNOWN;
                    v8_1[1] = CandidatePhase.RESTORE_PENDING;
                    v8_1[v3] = CandidatePhase.RESTORE_PARTIAL;
                    v8_1[3] = CandidatePhase.RESTORE_UNVERIFIED;
                    Set v3_2 = SetsKt.setOf(((Object[])v8_1));
                    if(v0_3 != null) {
                        CandidatePhase v8_2 = v0_3.getPhase();
                    }
                    else {
                        Object v8_3 = v6;
                    }

                    if(!CollectionsKt.contains(((Iterable)v3_2), v8_3)) {
                        goto label_97;
                    }
                }
                else {
                }

                goto label_96;
            }

        label_97:
            if(v7 == null) {
                goto label_121;
            }

            if(v4 != 0 && v0_3 != null) {
                if((v0_3.getIntentions().isEmpty()) && v0_3.getExecutorProbe() == CandidateExecutorProbe.NONE) {
                    goto label_112;
                }

                if(!v1.autoRecoveryAttempted) {
                    goto label_111;
                }

                v0_1 = v1.last;
                goto label_109;
            }

            goto label_112;
        }
        catch(Exception v0_6) {
            goto label_145;
        }
        catch(Throwable v0) {
            goto label_190;
        }

    label_109:
        __monitor_exit(this);
        return v0_1;
        try {
        label_111:
            v1.autoRecoveryAttempted = true;
        label_112:
            StretchRecoveryBinding v8_4 = v1.binding;
            if(v8_4 != null) {
                v0_1 = v7.recoverOnLoss(v8_4, v9, ((String)v10), v11);
                goto label_157;
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        label_121:
            StretchCustodyResult v0_8 = new StretchRecoveryCustodian(v2).observe(CustodyEvent.AGENT_PROCESS_LOST, ((String)v10), v11);
            String v0_9 = v0_8.getCode() == CustodyCode.RESTORE_PENDING ? "PRIOR_SESSION_RECOVERY_REQUIRED" : v0_8.getCode().name();
            v7_1 = new StretchPairResult(v0_9, null, null, 0, 0, 0, 62, null);
            goto label_156;
        }
        catch(Throwable v0) {
        }
        catch(Exception v0_6) {
            try {
            label_145:
                v7_1 = new StretchPairResult("RECOVERY_PENDING", v0_6.getClass().getSimpleName(), null, 0, 0, 0, 60, null);
            label_156:
                v0_1 = v7_1;
            label_157:
                v1.last = v0_1;
                v0_2 = v2.load();
                if((v0_2 instanceof Present)) {
                }
                else {
                    v0_2 = ((CandidateJournalRead)v6);
                }

                v0_3 = v0_2 != null ? ((Present)v0_2).getRecord() : ((StretchCandidateRecord)v6);
                CandidatePhase v3_3 = v0_3 != null ? v0_3.getPhase() : ((CandidatePhase)v6);
                if(v3_3 != CandidatePhase.RESTORED_VERIFIED) {
                    v3_3 = v0_3 != null ? v0_3.getPhase() : ((CandidatePhase)v6);
                    if(v3_3 != CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                        goto label_186;
                    }

                    if(!v0_3.getIntentions().isEmpty()) {
                        goto label_186;
                    }

                    goto label_182;
                }
                else {
                label_182:
                    v2.close();
                    v1.journal = v6;
                    v1.pair = ((StretchPhysicalPair)v6);
                    v1.binding = ((StretchRecoveryBinding)v6);
                }

            label_186:
                v0_1 = v1.last;
            }
            catch(Throwable v0) {
                try {
                label_190:
                    __monitor_exit(this);
                }
                catch(Throwable v0) {
                    goto label_190;
                }

                throw v0;
            }
        }

        __monitor_exit(this);
        return v0_1;
    }

    public static StretchPairResult poll$default(StretchPhysicalSession arg0, boolean arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.ownerAlive.invoke().booleanValue();
        }

        return arg0.poll(arg1);
    }

    private final StretchPairResult prepare(StretchOriginalEvidence arg29, Function0 arg30) {
        StretchPhysicalSession v0 = this;
        StretchOriginalEvidence v5 = arg29;
        if(v0.journal != null) {
            return new StretchPairResult("JOURNAL_ALREADY_DELEGATED", null, null, 0, 0, 0, 62, null);
        }

        StretchRecoveryBinding v1 = StretchRecoveryBinding.Companion.from(v5);
        long v8 = v0.clock.elapsedRealtimeMillis();
        Object v7 = v0.bootId.invoke();
        StretchRecoveryCustody v6 = new StretchRecoveryCustody(((String)v7), v8, Math.addExact(v8, 15000));
        Object v2 = arg30.invoke();
        v0.journal = ((StretchCandidateJournal)v2);
        CandidateJournalRead v3 = ((StretchCandidateJournal)v2).load();
        if((v3 instanceof Blocked)) {
            return new StretchPairResult("JOURNAL_BLOCKED_" + ((Blocked)v3).getError().name(), null, null, 0, 0, 0, 62, null);
        }

        CandidateJournalRead v10 = null;
        if((v3 instanceof Present)) {
        }
        else {
            v3 = v10;
        }

        StretchCandidateRecord v3_1 = v3 != null ? ((Present)v3).getRecord() : ((StretchCandidateRecord)v10);
        if(v3_1 != null && v3_1.getPhase() != CandidatePhase.CLOSED_WITHOUT_MUTATION) {
            if(!v3_1.getIntentions().isEmpty()) {
                return new StretchPairResult("PRIOR_SESSION_RECOVERY_REQUIRED", null, null, 0, 0, 0, 62, null);
            }
            else {
                new StretchRecoveryCustodian(v2).observe(CustodyEvent.AGENT_PROCESS_LOST, ((String)v7), v8);
                v3 = ((StretchCandidateJournal)v2).load();
                if((v3 instanceof Present)) {
                }
                else {
                    v3 = v10;
                }

                v3_1 = v3 != null ? ((Present)v3).getRecord() : ((StretchCandidateRecord)v10);
                CandidatePhase v4 = v3_1 != null ? v3_1.getPhase() : ((CandidatePhase)v10);
                if(v4 == CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                    goto label_106;
                }

                return new StretchPairResult("PRIOR_SESSION_UNRESOLVED", null, null, 0, 0, 0, 62, null);
            }
        }

    label_106:
        long v3_2 = v3_1 != null ? v3_1.getRevision() : 0;
        v8 = Math.addExact(v3_2, 1);
        long v11 = v3_2;
        int v4_1 = v0.ownerUid;
        long v26 = v8;
        StretchRecoveryCustody v9 = v6;
        Object v0_1 = v2;
        StretchRecoveryBinding v23 = v1;
        v6 = v9;
        if(!((StretchCandidateJournal)v0_1).commit(new StretchCandidateRecord(v26, v4_1, v5, CandidatePhase.CAPTURED, null, null, v9, null, null, null, null, 0x7B0, null), v11)) {
            return new StretchPairResult("ORIGINAL_NOT_DURABLE", null, null, 0, 0, 0, 62, null);
        }

        this.binding = v23;
        this.recoveryRequested.set(false);
        this.autoRecoveryAttempted = false;
        this.restoreOnly = false;
        this.pair = new StretchPhysicalPair(v0_1, this.io.invoke(v5, null), this.ownerUid, null, new StretchPhysicalSession$$ExternalSyntheticLambda0(this, v6), 8, null);
        String v0_2 = StretchPhysicalPair.Companion.missingOriginal(v5).isEmpty() ? "PREPARED_READ_ONLY" : "ORIGINAL_INCOMPLETE";
        return new StretchPairResult(v0_2, null, null, 0, 0, 0, 62, null);
    }

    static final boolean prepare$lambda$4(StretchPhysicalSession arg6, StretchRecoveryCustody arg7) {
        long v0 = arg6.clock.elapsedRealtimeMillis();
        if(!arg6.recoveryRequested.get() && (arg6.ownerAlive.invoke().booleanValue())) {
            long v2 = arg7.getStartedElapsedMillis();
            if(v0 < arg7.getExpiresElapsedMillis() && v2 <= v0 && (Intrinsics.areEqual(arg6.bootId.invoke(), arg7.getBootId()))) {
                return 1;
            }
        }

        return 0;
    }

    private final void releaseVerified(StretchPairResult arg4) {
        if(SetsKt.setOf(new String[]{"RESTORE_VERIFIED_CLOSED", "ORIGINAL_VERIFIED_CLOSED"}).contains(arg4.getCode())) {
            StretchCandidateJournal v4 = this.journal;
            if(v4 != null) {
                v4.close();
            }

            this.journal = null;
            this.pair = null;
            this.binding = null;
        }
    }

    public final void requestRecovery() {
        this.recoveryRequested.set(true);
    }

    private final StretchPairResult resumeRestore(StretchOriginalEvidence arg22, StretchAgentRequest arg23, Function0 arg24) {
        StretchPairResult v0_3;
        StretchPhysicalSession v1 = this;
        if(v1.restoreOnly) {
            return new StretchPairResult("RESTORE_ONLY_SESSION", null, null, 0, 0, 0, 62, null);
        }

        if(v1.pair != null) {
            return new StretchPairResult("JOURNAL_ALREADY_DELEGATED", null, null, 0, 0, 0, 62, null);
        }

        StretchCandidateJournal v0 = v1.journal;
        if(v0 == null) {
            Object v0_1 = arg24.invoke();
            v1.journal = ((StretchCandidateJournal)v0_1);
        }

        StretchCandidateJournal v2 = v0;
        v1.restoreOnly = true;
        CandidateJournalRead v3 = v2.load();
        StretchCandidateJournal v5 = null;
        if((v3 instanceof Present)) {
        }
        else {
            v3 = ((CandidateJournalRead)v5);
        }

        if(v3 != null) {
            StretchCandidateRecord v6 = ((Present)v3).getRecord();
            if(v6 == null) {
            }
            else {
                if(v6.getOwnerUid() == v1.ownerUid) {
                    if(!Intrinsics.areEqual(v6.getEvidence().getSnapshot().getOriginal().getPhysicalIdentity(), arg22.getSnapshot().getOriginal().getPhysicalIdentity())) {
                    }
                    else {
                        if((v6.getIntentions().isEmpty()) && v6.getExecutorProbe() == CandidateExecutorProbe.NONE) {
                            if(v6.getPhase() == CandidatePhase.CAPTURED && !Intrinsics.areEqual(v6.getEvidence().getAgentGeneration(), v1.generation)) {
                                v1.restoreOnly = true;
                                try {
                                    StretchRestorationIdentity v11 = new StretchRestorationIdentity(v1.generation, arg23.getOwnerGeneration());
                                    v0_3 = new StretchPhysicalPair(v2, v1.io.invoke(v6.getEvidence(), v11), v1.ownerUid, v11, new StretchPhysicalSession$$ExternalSyntheticLambda1()).closeUnmutatedOriginal(StretchRecoveryBinding.Companion.from(v6.getEvidence()), v1.bootId.invoke(), v1.clock.elapsedRealtimeMillis());
                                    v1.recoveredWithoutMutation = Intrinsics.areEqual(v0_3.getCode(), "NO_MUTATION_CLOSED");
                                }
                                catch(Throwable v0_2) {
                                    v1.journal = v5;
                                    v2.close();
                                    throw v0_2;
                                }

                                v1.journal = v5;
                                v2.close();
                                return v0_3;
                            }

                            if(v6.getPhase() == CandidatePhase.CLOSED_WITHOUT_MUTATION) {
                                if(Intrinsics.areEqual(v6.getEvidence().getAgentGeneration(), v1.generation)) {
                                }
                                else {
                                    StretchRecoveryBinding.Companion.from(v6.getEvidence());
                                    v1.restoreOnly = true;
                                    v1.recoveredWithoutMutation = true;
                                    return new StretchPairResult("NO_MUTATION_REQUESTED", null, null, 0, 0, 0, 62, null);
                                }
                            }

                            return new StretchPairResult("RECOVERY_NOOP_NOT_ELIGIBLE", null, null, 0, 0, 0, 62, null);
                        }

                        StretchRestorationIdentity v3_1 = new StretchRestorationIdentity(v1.generation, arg23.getOwnerGeneration());
                        if(v6.getPhase() != CandidatePhase.RESTORED_VERIFIED) {
                            long v7 = Math.addExact(v6.getRevision(), 1);
                            CandidatePhase v11_1 = CandidatePhase.RESTORE_PENDING;
                            StretchRestorationIdentity v15 = v6.getReadback() == null ? v3_1 : v6.getRestorationIdentity();
                            if(v2.commit(StretchCandidateRecord.copy$default(v6, v7, 0, null, v11_1, null, null, null, v15, null, null, null, 1910, null), v6.getRevision())) {
                                goto label_183;
                            }

                            return new StretchPairResult("RECOVERY_HANDOFF_NOT_DURABLE", null, null, 0, 0, 0, 62, null);
                        }

                    label_183:
                        v1.restoreOnly = true;
                        v1.binding = StretchRecoveryBinding.Companion.from(v6.getEvidence());
                        v1.recoveryRequested.set(true);
                        StretchPhysicalPair v6_1 = new StretchPhysicalPair(v2, v1.io.invoke(v6.getEvidence(), v3_1), v1.ownerUid, v3_1, new StretchPhysicalSession$$ExternalSyntheticLambda2());
                        v1.pair = v6_1;
                        v1.autoRecoveryAttempted = true;
                        StretchRecoveryBinding v2_1 = v1.binding;
                        if(v2_1 != null) {
                            v0_3 = v6_1.restore(v2_1, true, true);
                            v1.releaseVerified(v0_3);
                            return v0_3;
                        }

                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }

                return new StretchPairResult("RECOVERY_TARGET_MISMATCH", null, null, 0, 0, 0, 62, null);
            }
        }

        return new StretchPairResult("JOURNAL_UNAVAILABLE", null, null, 0, 0, 0, 62, null);
    }

    static final boolean resumeRestore$lambda$6() {
        return 0;
    }

    static final boolean resumeRestore$lambda$8() {
        return 0;
    }

    private final StretchPhysicalReply snapshot(String arg9, String arg10, String arg11) {
        StretchPhysicalReply v0_1;
        __monitor_enter(this);
        try {
            String v2 = this.generation;
            StretchCandidateJournal v1 = this.journal;
            CandidatePhase v3 = null;
            CandidateJournalRead v1_1 = v1 != null ? v1.load() : ((CandidateJournalRead)v3);
            if((v1_1 instanceof Present)) {
            }
            else {
                v1_1 = ((CandidateJournalRead)v3);
            }

            if(v1_1 != null) {
                StretchCandidateRecord v1_2 = ((Present)v1_1).getRecord();
                if(v1_2 != null) {
                    v3 = v1_2.getPhase();
                }
            }

            v0_1 = new StretchPhysicalReply(arg9, v2, arg10, v3, this.getRetained(), this.getPending(), arg11);
        }
        catch(Throwable v0) {
        label_27:
            Throwable v9 = v0;
            try {
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_27;
            }

            throw v9;
        }

        __monitor_exit(this);
        return v0_1;
    }
}

