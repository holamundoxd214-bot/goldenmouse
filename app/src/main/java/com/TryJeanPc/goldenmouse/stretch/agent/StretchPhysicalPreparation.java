package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatumState;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryJournalRead$Blocked;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryJournalRead$Present;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryJournalRead;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryPhase;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryReadiness$NotRecoverable;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoverySource;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryStep;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryCodec;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryRecord;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryStore;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryStrategy;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryValidator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalPreparation;", "", "store", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStore;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStore;)V", "assess", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalAssessment;", "baseline", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "authorized", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalPreparation {
    public static final int $stable = 8;
    private final StretchRecoveryStore store;

    static {
    }

    public StretchPhysicalPreparation(StretchRecoveryStore arg2) {
        Intrinsics.checkNotNullParameter(arg2, "store");
        super();
        this.store = arg2;
    }

    public final StretchPhysicalAssessment assess(StretchAgentBaseline arg13, boolean arg14) {
        Object v12;
        Intrinsics.checkNotNullParameter(arg13, "baseline");
        if(!arg14) {
            return new StretchPhysicalAssessment(StretchCompatibility.BACKEND_UNAUTHORIZED, SetsKt.setOf("BACKEND_NOT_AUTHORIZED"));
        }

        RecoveryJournalRead v14 = this.store.load();
        if((v14 instanceof Blocked)) {
            return new StretchPhysicalAssessment(StretchCompatibility.SAFETY_BLOCKED, SetsKt.setOf(((Blocked)v14).getError().name()));
        }

        Object v1 = null;
        if((v14 instanceof Present)) {
        }
        else {
            v14 = ((RecoveryJournalRead)v1);
        }

        StretchRecoveryRecord v14_1 = v14 != null ? ((Present)v14).getRecord() : ((StretchRecoveryRecord)v1);
        if(v14_1 != null && v14_1.getPhase() != RecoveryPhase.RECOVERED) {
            return new StretchPhysicalAssessment(StretchCompatibility.SAFETY_BLOCKED, SetsKt.setOf("EXISTING_JOURNAL_SESSION"));
        }

        StretchOriginalDisplayState v14_2 = arg13.getSnapshot().getOriginal();
        String[] v0 = new String[3];
        v0[0] = "PHYSICAL_VALIDATION_REQUIRED";
        v0[1] = "REMOTE_DURABLE_JOURNAL_UNAVAILABLE";
        int v5 = 2;
        v0[v5] = "INDEPENDENT_RESTORE_UNPROVEN";
        Set v2 = SetsKt.mutableSetOf(((Object[])v0));
        if(arg13.getSnapshot().getCaptureSource() == RecoverySource.SIMULATION) {
            v2.add("SIMULATION_CANNOT_AUTHORIZE_PHYSICAL");
        }

        if(v14_2.getPhysicalIdentity().getState() != RecoveryDatumState.KNOWN) {
            v2.add("UNKNOWN_PHYSICAL_IDENTITY");
        }

        RecoveryDatumState[] v0_1 = new RecoveryDatumState[v5];
        v0_1[0] = RecoveryDatumState.KNOWN;
        v0_1[1] = RecoveryDatumState.ABSENT;
        if(!SetsKt.setOf(((Object[])v0_1)).contains(v14_2.getSizeOverride().getState())) {
            v2.add("UNKNOWN_OVERRIDE");
        }

        if(v14_2.getScaling().getState() != RecoveryDatumState.KNOWN) {
            v2.add("UNKNOWN_SCALING");
        }

        if(v14_2.getProjection().getState() != RecoveryDatumState.KNOWN) {
            v2.add("ORIGINAL_PROJECTION_UNAVAILABLE");
        }

        try {
            v12 = Result.constructor-impl(StretchRecoveryCodec.INSTANCE.snapshotDigest(arg13.getSnapshot()));
        }
        catch(Throwable v0_2) {
            v12 = Result.constructor-impl(ResultKt.createFailure(v0_2));
        }

        if(Result.isFailure-impl(v12)) {
        }
        else {
            v1 = v12;
        }

        Object v5_1 = v1;
        if(v5_1 == null) {
            return new StretchPhysicalAssessment(StretchCompatibility.SAFETY_BLOCKED, SetsKt.setOf("INVALID_SNAPSHOT"));
        }

        v12 = v14_2.getPhysicalIdentity().getValue();
        if(v12 == null) {
            String v12_1 = "";
        }

        if((new StretchRecoveryValidator().validate(arg13.getSnapshot(), new StretchRecoveryStrategy("no-physical-strategy", ((String)v5_1), v12_1, CollectionsKt.toList(RecoveryStep.getEntries()), false, null, 0x20, null), CollectionsKt.toList(RecoveryStep.getEntries())) instanceof NotRecoverable)) {
            v2.add("RECOVERY_NOT_PROVEN");
        }

        StretchCompatibility v13 = arg13.getProjection().getTransactionMethod() != StretchProbeEvidence.METHOD_PRESENT ? StretchCompatibility.PROJECTION_UNSUPPORTED : StretchCompatibility.RECOVERY_UNAVAILABLE;
        return new StretchPhysicalAssessment(v13, CollectionsKt.toSet(((Iterable)v2)));
    }
}

