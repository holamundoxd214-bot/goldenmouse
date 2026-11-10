package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0015\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u0016\u001A\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00112\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryView;", "", "phase", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;", "record", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;)V", "getPhase", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryPhase;", "getRecord", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryRecord;", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryError;", "physicalMutationAllowed", "", "getPhysicalMutationAllowed", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryView {
    public static final int $stable = 8;
    private final RecoveryError error;
    private final RecoveryPhase phase;
    private final StretchRecoveryRecord record;

    static {
    }

    public RecoveryView(RecoveryPhase arg2, StretchRecoveryRecord arg3, RecoveryError arg4) {
        Intrinsics.checkNotNullParameter(arg2, "phase");
        super();
        this.phase = arg2;
        this.record = arg3;
        this.error = arg4;
    }

    public RecoveryView(RecoveryPhase arg1, StretchRecoveryRecord arg2, RecoveryError arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public final RecoveryPhase component1() {
        return this.phase;
    }

    public final StretchRecoveryRecord component2() {
        return this.record;
    }

    public final RecoveryError component3() {
        return this.error;
    }

    public final RecoveryView copy(RecoveryPhase arg1, StretchRecoveryRecord arg2, RecoveryError arg3) {
        Intrinsics.checkNotNullParameter(arg1, "phase");
        return new RecoveryView(arg1, arg2, arg3);
    }

    public static RecoveryView copy$default(RecoveryView arg0, RecoveryPhase arg1, StretchRecoveryRecord arg2, RecoveryError arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.phase;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.record;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.error;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryView)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryView)) {
            return 0;
        }

        if(this.phase != ((RecoveryView)arg5).phase) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.record, ((RecoveryView)arg5).record)) {
            return 0;
        }

        if(this.error != ((RecoveryView)arg5).error) {
            return 0;
        }

        return 1;
    }

    public final RecoveryError getError() {
        return this.error;
    }

    public final RecoveryPhase getPhase() {
        return this.phase;
    }

    public final boolean getPhysicalMutationAllowed() {
        return 0;
    }

    public final StretchRecoveryRecord getRecord() {
        return this.record;
    }

    public int hashCode() {
        int v0 = this.phase.hashCode() * 0x1F;
        StretchRecoveryRecord v1 = this.record;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        RecoveryError v3 = this.error;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "RecoveryView(phase=" + this.phase + ", record=" + this.record + ", error=" + this.error + ")";
    }
}

