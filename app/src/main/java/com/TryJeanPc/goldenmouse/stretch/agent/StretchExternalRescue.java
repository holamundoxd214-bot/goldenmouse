package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchGeometryPlan;
import com.TryJeanPc.goldenmouse.stretch.StretchProjection$Defined;
import com.TryJeanPc.goldenmouse.stretch.StretchProjection;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryClock;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryStep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0018\u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\r\u0012\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010-\u001A\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001A\b\u0012\u0004\u0012\u0002H.0\t¢\u0006\u0002\u00100J\u0006\u00101\u001A\u00020\u0012J*\u00102\u001A\u00020\u00052\u0006\u00103\u001A\u00020\u000E2\u0006\u00104\u001A\u00020\u00052\b\b\u0002\u00105\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u0012J\u0006\u00106\u001A\u000207J\u0006\u00108\u001A\u00020\u0012J\u0006\u00109\u001A\u00020\u0012J\u000E\u0010:\u001A\u00020\u00052\u0006\u0010;\u001A\u00020\u0012J\u0016\u0010<\u001A\u00020\u00122\u0006\u0010=\u001A\u00020\u00162\u0006\u0010>\u001A\u00020?J\u000E\u0010@\u001A\u00020\u00122\u0006\u0010A\u001A\u00020\u0003J\u0014\u0010B\u001A\u00020\u00052\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u000E0\tJ2\u0010C\u001A\u00020\u00122\f\u00106\u001A\b\u0012\u0004\u0012\u00020\u000E0\t2\u001C\b\u0002\u0010D\u001A\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F\u0018\u00010\rJ\u0006\u0010G\u001A\u00020\u0005J\u001A\u0010H\u001A\u00020\u00052\b\b\u0002\u0010I\u001A\u00020\u00122\b\b\u0002\u0010J\u001A\u00020\u0012J\u0010\u0010K\u001A\u00020\u00052\u0006\u0010L\u001A\u00020\u0016H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u000E\u0010\u001C\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010&\u001A\u00020\u00128F¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u001E\u0010)\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u0003@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u000E\u0010,\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExternalRescue;", "", "ownerUid", "", "generation", "", "clock", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;", "bootId", "Lkotlin/Function0;", "journal", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;", "io", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRestorationIdentity;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalIo;", "fenceAndAwaitDeath", "", "<init>", "(ILjava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryClock;Lkotlin/jvm/functions/Function0;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateJournal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "original", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "revoked", "value", "result", "getResult", "()Ljava/lang/String;", "attempted", "recovering", "sourceFenced", "applyReserved", "probeAttempted", "nextStep", "restoreOwner", "persistent", "projectionRepairUsed", "active", "healthyActive", "getHealthyActive", "()Z", "factorHundredths", "getFactorHundredths", "()I", "execution", "serializedIo", "T", "action", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "canReleaseForRecovery", "arm", "evidence", "ownerGeneration", "factor", "read", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateJournalRead;", "applyAllowed", "executorVerified", "verifyExecutor", "confirmed", "reserve", "next", "expected", "", "authorizeApplyStep", "step", "confirmActive", "checkActive", "repairProjection", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "", "sourceDied", "recover", "force", "retryFailed", "restoreFenced", "target", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchExternalRescue {
    public static final int $stable = 8;
    private volatile boolean active;
    private boolean applyReserved;
    private boolean attempted;
    private final Function0 bootId;
    private final RecoveryClock clock;
    private final Object execution;
    private int factorHundredths;
    private final Function0 fenceAndAwaitDeath;
    private final String generation;
    private final Function2 io;
    private final StretchCandidateJournal journal;
    private int nextStep;
    private StretchCandidateRecord original;
    private final int ownerUid;
    private boolean persistent;
    private boolean probeAttempted;
    private boolean projectionRepairUsed;
    private boolean recovering;
    private String restoreOwner;
    private volatile String result;
    private volatile boolean revoked;
    private boolean sourceFenced;

    static {
    }

    public StretchExternalRescue(int arg2, String arg3, RecoveryClock arg4, Function0 arg5, StretchCandidateJournal arg6, Function2 arg7, Function0 arg8) {
        Intrinsics.checkNotNullParameter(arg3, "generation");
        Intrinsics.checkNotNullParameter(arg4, "clock");
        Intrinsics.checkNotNullParameter(arg5, "bootId");
        Intrinsics.checkNotNullParameter(arg6, "journal");
        Intrinsics.checkNotNullParameter(arg7, "io");
        Intrinsics.checkNotNullParameter(arg8, "fenceAndAwaitDeath");
        super();
        this.ownerUid = arg2;
        this.generation = arg3;
        this.clock = arg4;
        this.bootId = arg5;
        this.journal = arg6;
        this.io = arg7;
        this.fenceAndAwaitDeath = arg8;
        this.result = "NOT_ARMED";
        this.restoreOwner = "";
        this.factorHundredths = 105;
        this.execution = new Object();
    }

    public final boolean applyAllowed() {
        boolean v1;
        StretchCandidateRecord v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.original;
            v1 = false;
            if(v0_1 != null) {
                goto label_6;
            }
        }
        catch(Throwable v0) {
            goto label_30;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_6:
            StretchRecoveryCustody v0_2 = v0_1.getCustody();
            if(v0_2 == null) {
                goto label_24;
            }

            if(!this.revoked && (Intrinsics.areEqual(this.bootId.invoke(), v0_2.getBootId()))) {
                long v2 = v0_2.getStartedElapsedMillis();
                long v4 = v0_2.getExpiresElapsedMillis();
                long v6 = this.clock.elapsedRealtimeMillis();
                if(v2 <= v6) {
                    goto label_20;
                }
            }

            goto label_22;
        }
        catch(Throwable v0) {
            goto label_30;
        }

    label_20:
        if(v6 < v4) {
            v1 = true;
        }

    label_22:
        __monitor_exit(this);
        return v1;
        try {
        label_24:
            throw new IllegalArgumentException("Required value was null.".toString());
        label_30:
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_30;
        }

        throw v0;
    }

    public final String arm(StretchOriginalEvidence arg21, String arg22, int arg23, boolean arg24) {
        StretchCandidateRecord v2_1;
        StretchCandidateRecord v17;
        CandidateJournalRead v4_2;
        StretchCandidateRecord v5;
        StretchExternalRescue v1 = this;
        StretchOriginalEvidence v6 = arg21;
        String v0 = arg22;
        int v2 = arg23;
        String v3 = "JOURNAL_";
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v6, "evidence");
            Intrinsics.checkNotNullParameter(v0, "ownerGeneration");
            if(v1.original == null) {
                if(v1.revoked) {
                }
                else {
                    if(101 <= v2 && v2 < 200) {
                        if(StretchPhysicalPair.Companion.missingOriginal(v6).isEmpty()) {
                            if(StretchPhysicalPair.Companion.route(v6) == StretchPairRoute.UNAVAILABLE) {
                            }
                            else {
                                StretchGeometryPlan v4 = StretchPhysicalPair.Companion.plan$app(v6, v2);
                                v5 = null;
                                StretchProjection v4_1 = v4 != null ? v4.getProjection() : ((StretchProjection)v5);
                                if((v4_1 instanceof Defined)) {
                                    goto label_40;
                                }

                                v0 = "FACTOR_GEOMETRY_UNSUPPORTED";
                                goto label_38;
                            }
                        }

                        goto label_142;
                    }

                    goto label_145;
                }
            }

            goto label_148;
        }
        catch(Throwable v0_1) {
            goto label_152;
        }

    label_38:
        __monitor_exit(this);
        return v0;
        try {
        label_40:
            v4_2 = v1.journal.load();
            if(!(v4_2 instanceof Blocked)) {
                goto label_52;
            }

            v0 = v3 + ((Blocked)v4_2).getError().name();
        }
        catch(Throwable v0_1) {
            goto label_152;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_52:
            if((v4_2 instanceof Present)) {
            }
            else {
                v4_2 = ((CandidateJournalRead)v5);
            }

            if(v4_2 != null) {
                v5 = ((Present)v4_2).getRecord();
            }

            v17 = v5;
            if(v17 != null) {
                if(v17.getOwnerUid() == v1.ownerUid && (SetsKt.setOf(new CandidatePhase[]{CandidatePhase.CLOSED_WITHOUT_MUTATION, CandidatePhase.RESTORED_VERIFIED}).contains(v17.getPhase()))) {
                    goto label_78;
                }

                v0 = "PRIOR_RECOVERY_PENDING";
                goto label_76;
            }

            goto label_78;
        }
        catch(Throwable v0_1) {
            goto label_152;
        }

    label_76:
        __monitor_exit(this);
        return v0;
    label_78:
        if(!arg24 && v2 == 0x6F && v17 == null) {
            try {
                v0 = "PREVIOUS_RECOVERY_NOT_VERIFIED";
            }
            catch(Throwable v0_1) {
                goto label_152;
            }

            __monitor_exit(this);
            return v0;
        }

        if(v17 != null) {
            try {
                if(!StretchPhysicalPair.Companion.matchesRestoredState$app(v17.getEvidence(), v6)) {
                    v0 = "PREVIOUS_ORIGINAL_CHANGED";
                    goto label_91;
                }

                goto label_93;
            }
            catch(Throwable v0_1) {
                goto label_152;
            }

        label_91:
            __monitor_exit(this);
            return v0;
        }

        try {
        label_93:
            long v9 = v1.clock.elapsedRealtimeMillis();
            long v18 = 0;
            long v3_1 = v17 != null ? v17.getRevision() : v18;
            v2_1 = new StretchCandidateRecord(v3_1 + 1, v1.ownerUid, v6, CandidatePhase.CAPTURED, null, null, new StretchRecoveryCustody(v1.bootId.invoke(), v9, Math.addExact(v9, 15000)), null, null, null, null, 0x7B0, null);
            StretchCandidateJournal v3_2 = v1.journal;
            if(v17 != null) {
                v18 = v17.getRevision();
            }

            if(v3_2.commit(v2_1, v18)) {
                goto label_131;
            }

            v0 = "ARM_NOT_DURABLE";
        }
        catch(Throwable v0_1) {
            goto label_152;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_131:
            v1.original = v2_1;
            v1.restoreOwner = v0;
            v1.factorHundredths = arg23;
            v1.persistent = arg24;
            v1.result = "ARMED_READ_ONLY";
            v0 = v1.result;
        }
        catch(Throwable v0_1) {
            goto label_152;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_142:
            v0 = "ORIGINAL_INCOMPLETE_OR_UNSUPPORTED";
        }
        catch(Throwable v0_1) {
            goto label_152;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_145:
            v0 = "EXPERIMENT_FACTOR_REJECTED";
        }
        catch(Throwable v0_1) {
            goto label_152;
        }

        __monitor_exit(this);
        return v0;
        try {
        label_148:
            v0 = "ALREADY_USED";
        }
        catch(Throwable v0_1) {
            try {
            label_152:
                __monitor_exit(this);
            }
            catch(Throwable v0_1) {
                goto label_152;
            }

            throw v0_1;
        }

        __monitor_exit(this);
        return v0;
    }

    public static String arm$default(StretchExternalRescue arg0, StretchOriginalEvidence arg1, String arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = 105;
        }

        return arg0.arm(arg1, arg2, arg3, false);
    }

    public final boolean authorizeApplyStep(int arg3) {
        __monitor_enter(this);
        try {
            if((this.applyReserved) && (this.applyAllowed()) && (this.executorVerified())) {
                int v0 = this.nextStep;
                if(arg3 == v0 && arg3 >= 0 && arg3 < 3) {
                    this.nextStep = v0 + 1;
                    goto label_15;
                }
            }

            goto label_17;
        }
        catch(Throwable v3) {
            try {
            label_21:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_21;
            }

            throw v3;
        }

    label_15:
        __monitor_exit(this);
        return 1;
    label_17:
        __monitor_exit(this);
        return 0;
    }

    public final boolean canReleaseForRecovery() {
        __monitor_enter(this);
        try {
            if(!this.revoked) {
                goto label_11;
            }
            else if(!this.attempted) {
                goto label_11;
            }
            else if(this.recovering) {
                goto label_11;
            }
            else if(!this.sourceFenced) {
                goto label_11;
            }
        }
        catch(Throwable v0) {
            try {
            label_15:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_15;
            }

            throw v0;
        }

        boolean v0_1 = true;
        goto label_12;
    label_11:
        v0_1 = false;
    label_12:
        __monitor_exit(this);
        return v0_1;
    }

    public final boolean checkActive(Function0 arg4, Function2 arg5) {
        boolean v4;
        Intrinsics.checkNotNullParameter(arg4, "read");
        if(!this.getHealthyActive()) {
            return 0;
        }

        try {
            v4 = this.serializedIo(new StretchExternalRescue$$ExternalSyntheticLambda2(this, arg4, arg5)).booleanValue();
        }
        catch(Exception ) {
            v4 = false;
        }

        if(!v4) {
            StretchExternalRescue.recover$default(this, true, false, 2, null);
        }

        return v4;
    }

    public static boolean checkActive$default(StretchExternalRescue arg0, Function0 arg1, Function2 arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return arg0.checkActive(arg1, arg2);
    }

    static final boolean checkActive$lambda$9(StretchExternalRescue arg12, Function0 arg13, Function2 arg14) {
        StretchCandidateRecord v0 = arg12.original;
        String v1 = "Required value was null.";
        if(v0 != null) {
            if(arg12.getHealthyActive()) {
                Object v2 = arg12.bootId.invoke();
                StretchRecoveryCustody v4 = v0.getCustody();
                CandidateJournalRead v5 = null;
                if(v4 != null) {
                    String v4_1 = v4.getBootId();
                }
                else {
                    Object v4_2 = v5;
                }

                if(!Intrinsics.areEqual(v2, v4_2)) {
                    return 0;
                }

                long v6 = arg12.clock.elapsedRealtimeMillis();
                StretchRecoveryCustody v2_1 = v0.getCustody();
                if(v2_1 != null) {
                    if(v6 < v2_1.getStartedElapsedMillis()) {
                        return 0;
                    }

                    CandidateJournalRead v2_2 = arg12.journal.load();
                    if((v2_2 instanceof Present)) {
                        v5 = v2_2;
                    }

                    if(v5 != null) {
                        StretchCandidateRecord v2_3 = ((Present)v5).getRecord();
                        if(v2_3 == null) {
                        }
                        else if(v2_3.getPhase() == CandidatePhase.ACTIVE) {
                            Integer v4_3 = v2_3.getActiveFactor();
                            int v5_1 = arg12.factorHundredths;
                            if(v4_3 == null) {
                            }
                            else if(v4_3.intValue() == v5_1 && (Intrinsics.areEqual(v2_3.getEvidence(), v0.getEvidence())) && v2_3.getOwnerUid() == arg12.ownerUid) {
                                if(!Intrinsics.areEqual(v2_3.getCustody(), v0.getCustody())) {
                                }
                                else {
                                    Object v6_1 = arg13.invoke();
                                    if(!Companion.matchesApplied$app$default(StretchPhysicalPair.Companion, v0.getEvidence(), ((StretchOriginalEvidence)v6_1), arg12.factorHundredths, false, 8, null) && arg14 != null && !arg12.projectionRepairUsed && (arg12.getHealthyActive()) && (StretchPhysicalPair.Companion.matchesApplied$app(v0.getEvidence(), ((StretchOriginalEvidence)v6_1), arg12.factorHundredths, false))) {
                                        arg12.projectionRepairUsed = true;
                                        StretchGeometryPlan v2_4 = StretchPhysicalPair.Companion.plan$app(v0.getEvidence(), arg12.factorHundredths);
                                        if(v2_4 != null) {
                                            StretchProjection v2_5 = v2_4.getProjection();
                                            Intrinsics.checkNotNull(v2_5, "null cannot be cast to non-null type com.TryJeanPc.goldenmouse.stretch.StretchProjection.Defined");
                                            StretchFullProjection v2_6 = ((Defined)v2_5).getGeometry();
                                            StretchCompositorState v5_2 = v0.getEvidence().getCompositor().getState();
                                            if(v5_2 != null) {
                                                arg14.invoke(v5_2.getPhysicalIdentity(), v2_6);
                                                v6_1 = arg13.invoke();
                                            }
                                            else {
                                                throw new IllegalArgumentException(v1.toString());
                                            }
                                        }
                                        else {
                                            throw new IllegalArgumentException(v1.toString());
                                        }
                                    }

                                    Object v7 = v6_1;
                                    if(!arg12.getHealthyActive()) {
                                        return 0;
                                    }

                                    if(!Companion.matchesApplied$app$default(StretchPhysicalPair.Companion, v0.getEvidence(), ((StretchOriginalEvidence)v7), arg12.factorHundredths, false, 8, null)) {
                                        return 0;
                                    }

                                    return 1;
                                }
                            }
                        }
                    }

                    return 0;
                }

                throw new IllegalArgumentException(v1.toString());
            }

            return 0;
        }

        throw new IllegalArgumentException(v1.toString());
    }

    public final String confirmActive(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "read");
        return this.serializedIo(new StretchExternalRescue$$ExternalSyntheticLambda3(this, arg2));
    }

    static final String confirmActive$lambda$8(StretchExternalRescue arg18, Function0 arg19) {
        String v0_2;
        StretchCandidateRecord v0_1;
        StretchExternalRescue v1 = arg18;
        __monitor_enter(arg18);
        try {
            v0_1 = v1.original;
            if(v0_1 != null) {
                goto label_7;
            }

            v0_2 = "NOT_ARMED";
        }
        catch(Throwable v0) {
            goto label_106;
        }

        __monitor_exit(arg18);
        return v0_2;
        try {
        label_7:
            if((v1.persistent) && (v1.applyAllowed()) && (v1.executorVerified()) && (v1.applyReserved)) {
                if(v1.nextStep != 3) {
                }
                else {
                    v1.revoked = true;
                    Object v6 = arg19.invoke();
                    StretchRecoveryCustody v3 = v0_1.getCustody();
                    if(v3 != null) {
                        if(Intrinsics.areEqual(v1.bootId.invoke(), v3.getBootId())) {
                            long v4 = v3.getStartedElapsedMillis();
                            long v7 = v3.getExpiresElapsedMillis();
                            long v9 = v1.clock.elapsedRealtimeMillis();
                            if(v4 <= v9 && v9 < v7) {
                                if(!Companion.matchesApplied$app$default(StretchPhysicalPair.Companion, v0_1.getEvidence(), ((StretchOriginalEvidence)v6), v1.factorHundredths, false, 8, null)) {
                                    v0_2 = "ACTIVE_READBACK_MISMATCH";
                                    goto label_45;
                                }
                                else {
                                    goto label_47;
                                }
                            }
                        }

                        goto label_94;
                    }
                    else {
                        goto label_97;
                    }
                }
            }

            goto label_102;
        }
        catch(Throwable v0) {
            goto label_106;
        }

    label_45:
        __monitor_exit(arg18);
        return v0_2;
        try {
        label_47:
            CandidateJournalRead v0_3 = v1.journal.load();
            if((v0_3 instanceof Present)) {
            }
            else {
                v0_3 = null;
            }

            if(v0_3 != null) {
                StretchCandidateRecord v3_1 = ((Present)v0_3).getRecord();
                if(v3_1 == null) {
                }
                else {
                    if(v3_1.getPhase() == CandidatePhase.INTENT_RESERVED) {
                        if(!v1.journal.commit(StretchCandidateRecord.copy$default(v3_1, Math.addExact(v3_1.getRevision(), 1), 0, null, CandidatePhase.ACTIVE, null, null, null, null, null, null, Integer.valueOf(v1.factorHundredths), 0x3F6, null), v3_1.getRevision())) {
                        }
                        else {
                            v1.active = true;
                            v1.result = "ACTIVE_READBACK_MATCHED";
                            v0_2 = v1.result;
                            goto label_86;
                        }
                    }

                    goto label_88;
                }
            }

            goto label_91;
        }
        catch(Throwable v0) {
            goto label_106;
        }

    label_86:
        __monitor_exit(arg18);
        return v0_2;
        try {
        label_88:
            v0_2 = "ACTIVE_NOT_DURABLE";
        }
        catch(Throwable v0) {
            goto label_106;
        }

        __monitor_exit(arg18);
        return v0_2;
        try {
        label_91:
            v0_2 = "JOURNAL_UNAVAILABLE";
        }
        catch(Throwable v0) {
            goto label_106;
        }

        __monitor_exit(arg18);
        return v0_2;
        try {
        label_94:
            v0_2 = "ACTIVE_LEASE_EXPIRED";
        }
        catch(Throwable v0) {
            goto label_106;
        }

        __monitor_exit(arg18);
        return v0_2;
        try {
        label_97:
            throw new IllegalArgumentException("Required value was null.".toString());
        label_102:
            v0_2 = "ACTIVE_NOT_AUTHORIZED";
        }
        catch(Throwable v0) {
        label_106:
            __monitor_exit(arg18);
            throw v0;
        }

        __monitor_exit(arg18);
        return v0_2;
    }

    public final boolean executorVerified() {
        __monitor_enter(this);
        try {
            if(!this.revoked) {
                CandidateJournalRead v0_1 = this.journal.load();
                CandidateExecutorProbe v2 = null;
                if((v0_1 instanceof Present)) {
                }
                else {
                    v0_1 = ((CandidateJournalRead)v2);
                }

                if(v0_1 != null) {
                    StretchCandidateRecord v0_2 = ((Present)v0_1).getRecord();
                    if(v0_2 != null) {
                        v2 = v0_2.getExecutorProbe();
                    }
                }

                if(v2 != CandidateExecutorProbe.MATCHED) {
                    goto label_18;
                }
            }
            else {
                goto label_18;
            }
        }
        catch(Throwable v0) {
            try {
            label_22:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_22;
            }

            throw v0;
        }

        boolean v0_3 = true;
        goto label_19;
    label_18:
        v0_3 = false;
    label_19:
        __monitor_exit(this);
        return v0_3;
    }

    public final int getFactorHundredths() {
        return this.factorHundredths;
    }

    public final boolean getHealthyActive() {
        if((this.active) && (Intrinsics.areEqual(this.result, "ACTIVE_READBACK_MATCHED"))) {
            return 1;
        }

        return 0;
    }

    public final String getResult() {
        return this.result;
    }

    public final CandidateJournalRead read() {
        CandidateJournalRead v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.journal.load();
        }
        catch(Throwable v0) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_6;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public final String recover(boolean arg11, boolean arg12) {
        StretchRecoveryCustody v2;
        String v11_1;
        StretchCandidateRecord v1;
        String v0 = "RECOVERY_PENDING_";
        __monitor_enter(this);
        try {
            v1 = this.original;
            if(v1 != null) {
                goto label_7;
            }

            v11_1 = this.result;
        }
        catch(Throwable v11) {
            goto label_136;
        }

        __monitor_exit(this);
        return v11_1;
        try {
        label_7:
            v2 = v1.getCustody();
            if(v2 == null) {
                goto label_130;
            }

            if((this.getHealthyActive()) && !arg11 && (Intrinsics.areEqual(this.bootId.invoke(), v2.getBootId())) && this.clock.elapsedRealtimeMillis() >= v2.getStartedElapsedMillis()) {
                v11_1 = this.result;
                goto label_22;
            }

            goto label_25;
        }
        catch(Throwable v11) {
            goto label_136;
        }

    label_22:
        __monitor_exit(this);
        return v11_1;
        try {
        label_25:
            this.active = false;
            if(!arg11 && (Intrinsics.areEqual(this.bootId.invoke(), v2.getBootId()))) {
                long v4 = v2.getStartedElapsedMillis();
                long v6 = v2.getExpiresElapsedMillis();
                long v8 = this.clock.elapsedRealtimeMillis();
                if(v4 <= v8 && v8 < v6) {
                    v11_1 = this.result;
                    goto label_39;
                }
            }

            goto label_42;
        }
        catch(Throwable v11) {
            goto label_136;
        }

    label_39:
        __monitor_exit(this);
        return v11_1;
        try {
        label_42:
            this.revoked = true;
            if(!this.recovering) {
                if(this.attempted) {
                    if(!arg12) {
                        goto label_127;
                    }
                    else if(SetsKt.setOf(new String[]{"NO_MUTATION_CLOSED", "RESTORE_VERIFIED_CLOSED", "ORIGINAL_VERIFIED_CLOSED"}).contains(this.result)) {
                        goto label_127;
                    }
                }

                this.attempted = true;
                this.recovering = true;
                this.result = "FENCING_APPLIER";
                goto label_66;
            }

            goto label_127;
        }
        catch(Throwable v11) {
            goto label_136;
        }

    label_66:
        __monitor_exit(this);
        try {
            if(this.fenceAndAwaitDeath.invoke().booleanValue()) {
                goto label_82;
            }

            this.result = "APPLIER_DEATH_UNCONFIRMED";
            v11_1 = this.result;
        }
        catch(Throwable v11) {
            goto label_119;
        }
        catch(Exception v11_2) {
            goto label_103;
        }

        __monitor_enter(this);
        try {
            this.recovering = false;
        }
        catch(Throwable v11) {
            __monitor_exit(this);
            throw v11;
        }

        __monitor_exit(this);
        return v11_1;
        try {
        label_82:
            __monitor_enter(this);
        }
        catch(Throwable v11) {
            goto label_119;
        }
        catch(Exception v11_2) {
            goto label_103;
        }

        try {
            this.sourceFenced = true;
            goto label_85;
        }
        catch(Throwable v11) {
            try {
                __monitor_exit(this);
                throw v11;
            label_85:
                __monitor_exit(this);
                this.result = this.serializedIo(new StretchExternalRescue$$ExternalSyntheticLambda0(this, v1));
            }
            catch(Throwable v11) {
            label_119:
                __monitor_enter(this);
                try {
                    this.recovering = false;
                }
                catch(Throwable v11) {
                    __monitor_exit(this);
                    throw v11;
                }

                __monitor_exit(this);
                throw v11;
            }
            catch(Exception v11_2) {
                try {
                label_103:
                    this.result = v0 + v11_2.getClass().getSimpleName();
                }
                catch(Throwable v11) {
                    goto label_119;
                }

                __monitor_enter(this);
                try {
                    this.recovering = false;
                    goto label_113;
                }
                catch(Throwable v11) {
                    __monitor_exit(this);
                    throw v11;
                }
            }
        }

        __monitor_enter(this);
        try {
            this.recovering = false;
        }
        catch(Throwable v11) {
            __monitor_exit(this);
            throw v11;
        }

    label_113:
        __monitor_exit(this);
        return this.result;
        try {
        label_127:
            v11_1 = this.result;
        }
        catch(Throwable v11) {
            goto label_136;
        }

        __monitor_exit(this);
        return v11_1;
        try {
        label_130:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        catch(Throwable v11) {
        label_136:
            __monitor_exit(this);
            throw v11;
        }
    }

    public static String recover$default(StretchExternalRescue arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        return arg1.recover(false, false);
    }

    static final String recover$lambda$12(StretchExternalRescue arg0, StretchCandidateRecord arg1) {
        return arg0.restoreFenced(arg1);
    }

    public final boolean reserve(StretchCandidateRecord arg11, long arg12) {
        boolean v12;
        StretchCandidateRecord v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg11, "next");
            v0 = this.original;
            if(v0 != null) {
                goto label_8;
            }
        }
        catch(Throwable v11) {
            goto label_105;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_8:
            if((this.applyAllowed()) && (this.executorVerified()) && arg11.getOwnerUid() == this.ownerUid && (Intrinsics.areEqual(arg11.getEvidence(), v0.getEvidence())) && (Intrinsics.areEqual(arg11.getCustody(), v0.getCustody())) && arg11.getReadback() == null) {
                if(arg11.getRestorationIdentity() != null) {
                }
                else {
                    CandidateJournalRead v0_1 = this.journal.load();
                    if((v0_1 instanceof Present)) {
                    }
                    else {
                        v0_1 = null;
                    }

                    if(v0_1 != null) {
                        v0 = ((Present)v0_1).getRecord();
                        if(v0 == null) {
                        }
                        else if(arg11.getExecutorProbe() != v0.getExecutorProbe()) {
                            goto label_41;
                        }
                        else {
                            goto label_43;
                        }
                    }

                    goto label_100;
                }
            }

            goto label_102;
        }
        catch(Throwable v11) {
            goto label_105;
        }

    label_41:
        __monitor_exit(this);
        return 0;
        try {
        label_43:
            EnumEntries v2 = RecoveryStep.getEntries();
            ArrayList v3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2), 10));
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                Object v4 = v2_1.next();
                ((Collection)v3).add(new CandidateIntent("apply-" + this.factorHundredths + "-" + ((RecoveryStep)v4).name(), ((RecoveryStep)v4)));
            }

            if(!Intrinsics.areEqual(arg11.getIntentions(), v3)) {
            }
            else {
                goto label_72;
            }
        }
        catch(Throwable v11) {
            goto label_105;
        }

        __monitor_exit(this);
        return 0;
        try {
        label_72:
            if(arg11.getPhase() != CandidatePhase.INTENT_RESERVED) {
                goto label_82;
            }
            else if(!this.applyReserved) {
                if(v0.getPhase() != CandidatePhase.CAPTURED) {
                    goto label_80;
                }

                goto label_88;
            }
        }
        catch(Throwable v11) {
            goto label_105;
        }

    label_80:
        __monitor_exit(this);
        return 0;
        try {
        label_82:
            if(arg11.getPhase() == CandidatePhase.EXECUTION_UNKNOWN) {
                if(!this.applyReserved) {
                }
                else {
                label_88:
                    v12 = this.journal.commit(arg11, arg12);
                    if((v12) && arg11.getPhase() == CandidatePhase.INTENT_RESERVED) {
                        this.applyReserved = true;
                    }

                    goto label_96;
                }
            }

            goto label_98;
        }
        catch(Throwable v11) {
            goto label_105;
        }

    label_96:
        __monitor_exit(this);
        return v12;
    label_98:
        __monitor_exit(this);
        return 0;
        try {
        label_105:
            __monitor_exit(this);
        }
        catch(Throwable v11) {
            goto label_105;
        }

        throw v11;
    label_100:
        __monitor_exit(this);
        return 0;
    label_102:
        __monitor_exit(this);
        return 0;
    }

    private final String restoreFenced(StretchCandidateRecord arg18) {
        StretchExternalRescue v0 = this;
        CandidateJournalRead v1 = v0.journal.load();
        if((v1 instanceof Present)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            StretchCandidateRecord v2 = ((Present)v1).getRecord();
            if(v2 == null) {
            }
            else {
                if(Intrinsics.areEqual(v2.getEvidence(), arg18.getEvidence())) {
                    if(v2.getOwnerUid() != v0.ownerUid) {
                    }
                    else {
                        long v3 = 1;
                        if((v2.getIntentions().isEmpty()) && v2.getExecutorProbe() == CandidateExecutorProbe.NONE) {
                            if(v0.journal.commit(StretchCandidateRecord.copy$default(v2, Math.addExact(v2.getRevision(), v3), 0, null, CandidatePhase.CLOSED_WITHOUT_MUTATION, null, null, null, null, null, null, null, 0x7F6, null), v2.getRevision())) {
                                return "NO_MUTATION_CLOSED";
                            }
                            else {
                                return "CLOSE_NOT_DURABLE";
                            }
                        }

                        StretchRestorationIdentity v1_1 = new StretchRestorationIdentity(v0.generation, v0.restoreOwner);
                        v3 = Math.addExact(v2.getRevision(), v3);
                        CandidatePhase v7 = CandidatePhase.RESTORE_PENDING;
                        StretchRestorationIdentity v11 = v2.getReadback() == null ? v1_1 : v2.getRestorationIdentity();
                        if(!v0.journal.commit(StretchCandidateRecord.copy$default(v2, v3, 0, null, v7, null, null, null, v11, null, null, null, 1910, null), v2.getRevision())) {
                            return "RESTORE_HANDOFF_NOT_DURABLE";
                        }

                        Object v3_1 = v0.io.invoke(arg18.getEvidence(), v1_1);
                        if(((StretchPhysicalIo)v3_1).getCanApply()) {
                            return "RESCUER_MUST_BE_RESTORE_ONLY";
                        }

                        return new StretchPhysicalPair(v0.journal, ((StretchPhysicalIo)v3_1), v0.ownerUid, v1_1, new StretchExternalRescue$$ExternalSyntheticLambda5()).restore(StretchRecoveryBinding.Companion.from(arg18.getEvidence()), true, true).safeCode();
                    }
                }

                return "RECOVERY_TARGET_MISMATCH";
            }
        }

        return "JOURNAL_UNAVAILABLE";
    }

    static final boolean restoreFenced$lambda$14() {
        return 0;
    }

    public final Object serializedIo(Function0 arg2) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg2, "action");
        Object v1 = this.execution;
        __monitor_enter(v1);
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            __monitor_exit(v1);
            throw v2;
        }

        __monitor_exit(v1);
        return v2_1;
    }

    public final String sourceDied() {
        boolean v0 = this.getHealthyActive();
        String v1 = this.result;
        if(v0) {
            return v1;
        }

        return this.recover(true, Intrinsics.areEqual(v1, "APPLIER_DEATH_UNCONFIRMED"));
    }

    public final String verifyExecutor(boolean arg19) {
        String v0_2;
        StretchCandidateRecord v0_1;
        StretchExternalRescue v1 = this;
        __monitor_enter(this);
        try {
            v0_1 = v1.original;
            if(v0_1 != null) {
                goto label_7;
            }

            v0_2 = "NOT_ARMED";
        }
        catch(Throwable v0) {
            goto label_80;
        }

        __monitor_exit(this);
        return v0_2;
    label_7:
        if(arg19) {
            try {
                if(v1.applyAllowed()) {
                    if(v1.probeAttempted) {
                    }
                    else {
                        v1.probeAttempted = true;
                        CandidateJournalRead v2 = v1.journal.load();
                        if((v2 instanceof Present)) {
                        }
                        else {
                            v2 = null;
                        }

                        if(v2 != null) {
                            StretchCandidateRecord v3 = ((Present)v2).getRecord();
                            if(v3 == null) {
                            }
                            else {
                                if(Intrinsics.areEqual(v3, v0_1)) {
                                    if(!v1.journal.commit(StretchCandidateRecord.copy$default(v3, Math.addExact(v3.getRevision(), 1), 0, null, null, null, null, null, null, CandidateExecutorProbe.RESERVED, null, null, 0x6FE, null), v3.getRevision())) {
                                        goto label_47;
                                    }
                                    else {
                                        goto label_48;
                                    }
                                }

                                goto label_70;
                            }
                        }

                        goto label_73;
                    }
                }

                goto label_76;
            }
            catch(Throwable v0) {
                goto label_80;
            }

        label_47:
            goto label_70;
        label_48:
            __monitor_exit(this);
            Object v0_3 = v1.serializedIo(new StretchExternalRescue$$ExternalSyntheticLambda4(v1, v0_1, new StretchRestorationIdentity(v1.generation, v1.restoreOwner)));
            __monitor_enter(this);
            try {
                if((v1.revoked) || !v1.applyAllowed()) {
                    v0_2 = "EXECUTOR_LEASE_EXPIRED";
                }
                else {
                    v1.result = ((String)v0_3);
                }
            }
            catch(Throwable v0) {
                __monitor_exit(this);
                throw v0;
            }

            __monitor_exit(this);
            return ((String)v0_3);
            try {
            label_70:
                v0_2 = "EXECUTOR_PROBE_NOT_DURABLE";
            }
            catch(Throwable v0) {
                goto label_80;
            }

            __monitor_exit(this);
            return v0_2;
            try {
            label_73:
                v0_2 = "JOURNAL_UNAVAILABLE";
            }
            catch(Throwable v0) {
                goto label_80;
            }

            __monitor_exit(this);
            return v0_2;
        }

        try {
        label_76:
            v0_2 = "EXECUTOR_PROBE_NOT_AUTHORIZED";
        }
        catch(Throwable v0) {
        label_80:
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
        return v0_2;
    }

    static final String verifyExecutor$lambda$3(StretchExternalRescue arg6, StretchCandidateRecord arg7, StretchRestorationIdentity arg8) {
        return new StretchPhysicalPair(arg6.journal, arg6.io.invoke(arg7.getEvidence(), arg8), arg6.ownerUid, arg8, new StretchExternalRescue$$ExternalSyntheticLambda1()).verifyOriginalExecutor(StretchRecoveryBinding.Companion.from(arg7.getEvidence())).safeCode();
    }

    static final boolean verifyExecutor$lambda$3$lambda$2() {
        return 0;
    }
}

