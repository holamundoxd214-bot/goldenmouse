package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryStep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidateIntent;", "", "operationId", "", "step", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;)V", "getOperationId", "()Ljava/lang/String;", "getStep", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CandidateIntent {
    public static final int $stable;
    private final String operationId;
    private final RecoveryStep step;

    static {
    }

    public CandidateIntent(String arg2, RecoveryStep arg3) {
        Intrinsics.checkNotNullParameter(arg2, "operationId");
        Intrinsics.checkNotNullParameter(arg3, "step");
        super();
        this.operationId = arg2;
        this.step = arg3;
    }

    public final String component1() {
        return this.operationId;
    }

    public final RecoveryStep component2() {
        return this.step;
    }

    public final CandidateIntent copy(String arg1, RecoveryStep arg2) {
        Intrinsics.checkNotNullParameter(arg1, "operationId");
        Intrinsics.checkNotNullParameter(arg2, "step");
        return new CandidateIntent(arg1, arg2);
    }

    public static CandidateIntent copy$default(CandidateIntent arg0, String arg1, RecoveryStep arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.operationId;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.step;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((CandidateIntent)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CandidateIntent)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.operationId, ((CandidateIntent)arg5).operationId)) {
            return 0;
        }

        if(this.step != ((CandidateIntent)arg5).step) {
            return 0;
        }

        return 1;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final RecoveryStep getStep() {
        return this.step;
    }

    public int hashCode() {
        return this.operationId.hashCode() * 0x1F + this.step.hashCode();
    }

    public String toString() {
        return "CandidateIntent(operationId=" + this.operationId + ", step=" + this.step + ")";
    }
}

