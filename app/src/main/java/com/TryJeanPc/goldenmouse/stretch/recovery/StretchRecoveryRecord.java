package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\t\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0003\u0012\u000E\b\u0002\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00130\t\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001A\u00020\u0003HÆ\u0003J\t\u00100\u001A\u00020\u0005HÆ\u0003J\t\u00101\u001A\u00020\u0007HÆ\u0003J\u000F\u00102\u001A\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u00103\u001A\u00020\fHÆ\u0003J\u000F\u00104\u001A\b\u0012\u0004\u0012\u00020\u000E0\tHÆ\u0003J\u000B\u00105\u001A\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00106\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000F\u00107\u001A\b\u0012\u0004\u0012\u00020\u00130\tHÆ\u0003J\u000B\u00108\u001A\u0004\u0018\u00010\u0015HÆ\u0003J\u000B\u00109\u001A\u0004\u0018\u00010\u0017HÆ\u0003J\u0096\u0001\u0010:\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\t2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00032\u000E\b\u0002\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00130\t2\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001A\u00020=2\b\u0010>\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001A\u00020@HÖ\u0001J\t\u0010A\u001A\u00020BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\t¢\u0006\b\n\u0000\u001A\u0004\b$\u0010!R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0015\u0010\u0011\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001A\u0004\b\'\u0010(R\u0017\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00130\t¢\u0006\b\n\u0000\u001A\u0004\b*\u0010!R\u0013\u0010\u0014\u001A\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001A\u0004\b-\u0010.¨\u0006C"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "", "revision", "", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "strategy", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;", "intendedSteps", "", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "phase", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;", "steps", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStepRecord;", "confirmation", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryConfirmation;", "confirmedAtElapsedMillis", "restores", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryRestoreAttempt;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "resolution", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryResolution;", "<init>", "(JLcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryConfirmation;Ljava/lang/Long;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryResolution;)V", "getRevision", "()J", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "getStrategy", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;", "getIntendedSteps", "()Ljava/util/List;", "getPhase", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;", "getSteps", "getConfirmation", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryConfirmation;", "getConfirmedAtElapsedMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRestores", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "getResolution", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryResolution;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JLcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryConfirmation;Ljava/lang/Long;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryResolution;)Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryRecord {
    public static final int $stable = 8;
    private final RecoveryConfirmation confirmation;
    private final Long confirmedAtElapsedMillis;
    private final RecoveryError error;
    private final List intendedSteps;
    private final RecoveryPhase phase;
    private final RecoveryResolution resolution;
    private final List restores;
    private final long revision;
    private final StretchRecoverySnapshot snapshot;
    private final List steps;
    private final StretchRecoveryStrategy strategy;

    static {
    }

    public StretchRecoveryRecord(long arg2, StretchRecoverySnapshot arg4, StretchRecoveryStrategy arg5, List arg6, RecoveryPhase arg7, List arg8, RecoveryConfirmation arg9, Long arg10, List arg11, RecoveryError arg12, RecoveryResolution arg13) {
        Intrinsics.checkNotNullParameter(arg4, "snapshot");
        Intrinsics.checkNotNullParameter(arg5, "strategy");
        Intrinsics.checkNotNullParameter(arg6, "intendedSteps");
        Intrinsics.checkNotNullParameter(arg7, "phase");
        Intrinsics.checkNotNullParameter(arg8, "steps");
        Intrinsics.checkNotNullParameter(arg11, "restores");
        super();
        this.revision = arg2;
        this.snapshot = arg4;
        this.strategy = arg5;
        this.intendedSteps = arg6;
        this.phase = arg7;
        this.steps = arg8;
        this.confirmation = arg9;
        this.confirmedAtElapsedMillis = arg10;
        this.restores = arg11;
        this.error = arg12;
        this.resolution = arg13;
    }

    public StretchRecoveryRecord(long arg16, StretchRecoverySnapshot arg18, StretchRecoveryStrategy arg19, List arg20, RecoveryPhase arg21, List arg22, RecoveryConfirmation arg23, Long arg24, List arg25, RecoveryError arg26, RecoveryResolution arg27, int arg28, DefaultConstructorMarker arg29) {
        StretchRecoveryRecord v2_1;
        RecoveryPhase v8;
        List v7;
        StretchRecoveryStrategy v6;
        StretchRecoverySnapshot v5;
        long v3;
        RecoveryResolution v14;
        int v0 = arg28;
        List v9 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg22;
        RecoveryConfirmation v2 = null;
        RecoveryConfirmation v10 = (v0 & 0x40) != 0 ? v2 : arg23;
        Long v11 = (v0 & 0x80) != 0 ? ((Long)v2) : arg24;
        List v12 = (v0 & 0x100) != 0 ? CollectionsKt.emptyList() : arg25;
        RecoveryError v13 = (v0 & 0x200) != 0 ? ((RecoveryError)v2) : arg26;
        if((v0 & 0x400) != 0) {
            v14 = ((RecoveryResolution)v2);
            v3 = arg16;
            v5 = arg18;
            v6 = arg19;
            v7 = arg20;
            v8 = arg21;
            v2_1 = this;
        }
        else {
            v14 = arg27;
            v2_1 = this;
            v3 = arg16;
            v5 = arg18;
            v6 = arg19;
            v7 = arg20;
            v8 = arg21;
        }

        this(v3, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14);
    }

    public final long component1() {
        return this.revision;
    }

    public final RecoveryError component10() {
        return this.error;
    }

    public final RecoveryResolution component11() {
        return this.resolution;
    }

    public final StretchRecoverySnapshot component2() {
        return this.snapshot;
    }

    public final StretchRecoveryStrategy component3() {
        return this.strategy;
    }

    public final List component4() {
        return this.intendedSteps;
    }

    public final RecoveryPhase component5() {
        return this.phase;
    }

    public final List component6() {
        return this.steps;
    }

    public final RecoveryConfirmation component7() {
        return this.confirmation;
    }

    public final Long component8() {
        return this.confirmedAtElapsedMillis;
    }

    public final List component9() {
        return this.restores;
    }

    public final StretchRecoveryRecord copy(long arg14, StretchRecoverySnapshot arg16, StretchRecoveryStrategy arg17, List arg18, RecoveryPhase arg19, List arg20, RecoveryConfirmation arg21, Long arg22, List arg23, RecoveryError arg24, RecoveryResolution arg25) {
        Intrinsics.checkNotNullParameter(arg16, "snapshot");
        Intrinsics.checkNotNullParameter(arg17, "strategy");
        Intrinsics.checkNotNullParameter(arg18, "intendedSteps");
        Intrinsics.checkNotNullParameter(arg19, "phase");
        Intrinsics.checkNotNullParameter(arg20, "steps");
        Intrinsics.checkNotNullParameter(arg23, "restores");
        return new StretchRecoveryRecord(arg14, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25);
    }

    public static StretchRecoveryRecord copy$default(StretchRecoveryRecord arg13, long arg14, StretchRecoverySnapshot arg16, StretchRecoveryStrategy arg17, List arg18, RecoveryPhase arg19, List arg20, RecoveryConfirmation arg21, Long arg22, List arg23, RecoveryError arg24, RecoveryResolution arg25, int arg26, Object arg27) {
        int v0 = arg26;
        if((v0 & 1) != 0) {
            arg14 = arg13.revision;
        }

        long v1 = arg14;
        StretchRecoverySnapshot v3 = (v0 & 2) != 0 ? arg13.snapshot : arg16;
        StretchRecoveryStrategy v4 = (v0 & 4) != 0 ? arg13.strategy : arg17;
        List v5 = (v0 & 8) != 0 ? arg13.intendedSteps : arg18;
        RecoveryPhase v6 = (v0 & 16) != 0 ? arg13.phase : arg19;
        List v7 = (v0 & 0x20) != 0 ? arg13.steps : arg20;
        RecoveryConfirmation v8 = (v0 & 0x40) != 0 ? arg13.confirmation : arg21;
        Long v9 = (v0 & 0x80) != 0 ? arg13.confirmedAtElapsedMillis : arg22;
        List v10 = (v0 & 0x100) != 0 ? arg13.restores : arg23;
        RecoveryError v11 = (v0 & 0x200) != 0 ? arg13.error : arg24;
        RecoveryResolution v12 = (v0 & 0x400) != 0 ? arg13.resolution : arg25;
        return arg13.copy(v1, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12);
    }

    public boolean equals(Object arg8) {
        if(this == (((StretchRecoveryRecord)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof StretchRecoveryRecord)) {
            return 0;
        }

        if(this.revision != ((StretchRecoveryRecord)arg8).revision) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshot, ((StretchRecoveryRecord)arg8).snapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.strategy, ((StretchRecoveryRecord)arg8).strategy)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.intendedSteps, ((StretchRecoveryRecord)arg8).intendedSteps)) {
            return 0;
        }

        if(this.phase != ((StretchRecoveryRecord)arg8).phase) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.steps, ((StretchRecoveryRecord)arg8).steps)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.confirmation, ((StretchRecoveryRecord)arg8).confirmation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.confirmedAtElapsedMillis, ((StretchRecoveryRecord)arg8).confirmedAtElapsedMillis)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.restores, ((StretchRecoveryRecord)arg8).restores)) {
            return 0;
        }

        if(this.error != ((StretchRecoveryRecord)arg8).error) {
            return 0;
        }

        if(this.resolution != ((StretchRecoveryRecord)arg8).resolution) {
            return 0;
        }

        return 1;
    }

    public final RecoveryConfirmation getConfirmation() {
        return this.confirmation;
    }

    public final Long getConfirmedAtElapsedMillis() {
        return this.confirmedAtElapsedMillis;
    }

    public final RecoveryError getError() {
        return this.error;
    }

    public final List getIntendedSteps() {
        return this.intendedSteps;
    }

    public final RecoveryPhase getPhase() {
        return this.phase;
    }

    public final RecoveryResolution getResolution() {
        return this.resolution;
    }

    public final List getRestores() {
        return this.restores;
    }

    public final long getRevision() {
        return this.revision;
    }

    public final StretchRecoverySnapshot getSnapshot() {
        return this.snapshot;
    }

    public final List getSteps() {
        return this.steps;
    }

    public final StretchRecoveryStrategy getStrategy() {
        return this.strategy;
    }

    public int hashCode() {
        int v0 = (((((Long.hashCode(this.revision) * 0x1F + this.snapshot.hashCode()) * 0x1F + this.strategy.hashCode()) * 0x1F + this.intendedSteps.hashCode()) * 0x1F + this.phase.hashCode()) * 0x1F + this.steps.hashCode()) * 0x1F;
        RecoveryConfirmation v1 = this.confirmation;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        Long v1_2 = this.confirmedAtElapsedMillis;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = ((v0 + v1_1) * 0x1F + this.restores.hashCode()) * 0x1F;
        RecoveryError v1_3 = this.error;
        v1_1 = v1_3 == null ? 0 : v1_3.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        RecoveryResolution v3 = this.resolution;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchRecoveryRecord(revision=" + this.revision + ", snapshot=" + this.snapshot + ", strategy=" + this.strategy + ", intendedSteps=" + this.intendedSteps + ", phase=" + this.phase + ", steps=" + this.steps + ", confirmation=" + this.confirmation + ", confirmedAtElapsedMillis=" + this.confirmedAtElapsedMillis + ", restores=" + this.restores + ", error=" + this.error + ", resolution=" + this.resolution + ")";
    }
}

