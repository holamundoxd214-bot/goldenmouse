package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u001D\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010 \u001A\u00020\tHÆ\u0003J\t\u0010!\u001A\u00020\tHÆ\u0003J\u000B\u0010\"\u001A\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001A\u00020\t2\b\u0010%\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001A\u00020\'HÖ\u0001J\t\u0010(\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000FR\u0011\u0010\u0018\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001A\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0015¨\u0006)"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalReply;", "", "operationId", "", "agentGeneration", "code", "phase", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;", "journalRetained", "", "recoveryPending", "errorType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;ZZLjava/lang/String;)V", "getOperationId", "()Ljava/lang/String;", "getAgentGeneration", "getCode", "getPhase", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/CandidatePhase;", "getJournalRetained", "()Z", "getRecoveryPending", "getErrorType", "physicalMutationAllowed", "getPhysicalMutationAllowed", "physicalRecoveryAccredited", "getPhysicalRecoveryAccredited", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalReply {
    public static final int $stable;
    private final String agentGeneration;
    private final String code;
    private final String errorType;
    private final boolean journalRetained;
    private final String operationId;
    private final CandidatePhase phase;
    private final boolean recoveryPending;

    static {
    }

    public StretchPhysicalReply(String arg2, String arg3, String arg4, CandidatePhase arg5, boolean arg6, boolean arg7, String arg8) {
        Intrinsics.checkNotNullParameter(arg2, "operationId");
        Intrinsics.checkNotNullParameter(arg3, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg4, "code");
        super();
        this.operationId = arg2;
        this.agentGeneration = arg3;
        this.code = arg4;
        this.phase = arg5;
        this.journalRetained = arg6;
        this.recoveryPending = arg7;
        this.errorType = arg8;
    }

    public StretchPhysicalReply(String arg10, String arg11, String arg12, CandidatePhase arg13, boolean arg14, boolean arg15, String arg16, int arg17, DefaultConstructorMarker arg18) {
        String v8 = (arg17 & 0x40) != 0 ? null : arg16;
        this(arg10, arg11, arg12, arg13, arg14, arg15, v8);
    }

    public final String component1() {
        return this.operationId;
    }

    public final String component2() {
        return this.agentGeneration;
    }

    public final String component3() {
        return this.code;
    }

    public final CandidatePhase component4() {
        return this.phase;
    }

    public final boolean component5() {
        return this.journalRetained;
    }

    public final boolean component6() {
        return this.recoveryPending;
    }

    public final String component7() {
        return this.errorType;
    }

    public final StretchPhysicalReply copy(String arg9, String arg10, String arg11, CandidatePhase arg12, boolean arg13, boolean arg14, String arg15) {
        Intrinsics.checkNotNullParameter(arg9, "operationId");
        Intrinsics.checkNotNullParameter(arg10, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg11, "code");
        return new StretchPhysicalReply(arg9, arg10, arg11, arg12, arg13, arg14, arg15);
    }

    public static StretchPhysicalReply copy$default(StretchPhysicalReply arg0, String arg1, String arg2, String arg3, CandidatePhase arg4, boolean arg5, boolean arg6, String arg7, int arg8, Object arg9) {
        if((arg8 & 1) != 0) {
            arg1 = arg0.operationId;
        }

        if((arg8 & 2) != 0) {
            arg2 = arg0.agentGeneration;
        }

        if((arg8 & 4) != 0) {
            arg3 = arg0.code;
        }

        if((arg8 & 8) != 0) {
            arg4 = arg0.phase;
        }

        if((arg8 & 16) != 0) {
            arg5 = arg0.journalRetained;
        }

        if((arg8 & 0x20) != 0) {
            arg6 = arg0.recoveryPending;
        }

        if((arg8 & 0x40) != 0) {
            arg7 = arg0.errorType;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchPhysicalReply)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchPhysicalReply)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.operationId, ((StretchPhysicalReply)arg5).operationId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.agentGeneration, ((StretchPhysicalReply)arg5).agentGeneration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.code, ((StretchPhysicalReply)arg5).code)) {
            return 0;
        }

        if(this.phase != ((StretchPhysicalReply)arg5).phase) {
            return 0;
        }

        if(this.journalRetained != ((StretchPhysicalReply)arg5).journalRetained) {
            return 0;
        }

        if(this.recoveryPending != ((StretchPhysicalReply)arg5).recoveryPending) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.errorType, ((StretchPhysicalReply)arg5).errorType)) {
            return 0;
        }

        return 1;
    }

    public final String getAgentGeneration() {
        return this.agentGeneration;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final boolean getJournalRetained() {
        return this.journalRetained;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final CandidatePhase getPhase() {
        return this.phase;
    }

    public final boolean getPhysicalMutationAllowed() {
        return 0;
    }

    public final boolean getPhysicalRecoveryAccredited() {
        return 0;
    }

    public final boolean getRecoveryPending() {
        return this.recoveryPending;
    }

    public int hashCode() {
        int v0 = ((this.operationId.hashCode() * 0x1F + this.agentGeneration.hashCode()) * 0x1F + this.code.hashCode()) * 0x1F;
        CandidatePhase v1 = this.phase;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (((v0 + v1_1) * 0x1F + Boolean.hashCode(this.journalRetained)) * 0x1F + Boolean.hashCode(this.recoveryPending)) * 0x1F;
        String v3 = this.errorType;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchPhysicalReply(operationId=" + this.operationId + ", agentGeneration=" + this.agentGeneration + ", code=" + this.code + ", phase=" + this.phase + ", journalRetained=" + this.journalRetained + ", recoveryPending=" + this.recoveryPending + ", errorType=" + this.errorType + ")";
    }
}

