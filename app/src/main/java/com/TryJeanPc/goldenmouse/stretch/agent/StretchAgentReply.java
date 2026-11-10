package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0003HÆ\u0003J\t\u0010 \u001A\u00020\u0006HÆ\u0003J\t\u0010!\u001A\u00020\bHÆ\u0003J\u000B\u0010\"\u001A\u0004\u0018\u00010\nHÆ\u0003J\u000B\u0010#\u001A\u0004\u0018\u00010\fHÆ\u0003JI\u0010$\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010%\u001A\u00020\u001B2\b\u0010&\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\'\u001A\u00020(HÖ\u0001J\t\u0010)\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006*"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "", "operationId", "", "agentGeneration", "code", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCode;", "phase", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentPhase;", "baseline", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "originalEvidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCode;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentPhase;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;)V", "getOperationId", "()Ljava/lang/String;", "getAgentGeneration", "getCode", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentCode;", "getPhase", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentPhase;", "getBaseline", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "getOriginalEvidence", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "physicalMutationAllowed", "", "getPhysicalMutationAllowed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentReply {
    public static final int $stable;
    private final String agentGeneration;
    private final StretchAgentBaseline baseline;
    private final StretchAgentCode code;
    private final String operationId;
    private final StretchOriginalEvidence originalEvidence;
    private final StretchAgentPhase phase;

    static {
    }

    public StretchAgentReply(String arg2, String arg3, StretchAgentCode arg4, StretchAgentPhase arg5, StretchAgentBaseline arg6, StretchOriginalEvidence arg7, int arg8, DefaultConstructorMarker arg9) {
        StretchAgentBaseline v0 = null;
        if((arg8 & 16) != 0) {
            arg6 = v0;
        }

        if((arg8 & 0x20) != 0) {
            arg7 = ((StretchOriginalEvidence)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public StretchAgentReply(String arg2, String arg3, StretchAgentCode arg4, StretchAgentPhase arg5, StretchAgentBaseline arg6, StretchOriginalEvidence arg7) {
        Intrinsics.checkNotNullParameter(arg2, "operationId");
        Intrinsics.checkNotNullParameter(arg3, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg4, "code");
        Intrinsics.checkNotNullParameter(arg5, "phase");
        super();
        this.operationId = arg2;
        this.agentGeneration = arg3;
        this.code = arg4;
        this.phase = arg5;
        this.baseline = arg6;
        this.originalEvidence = arg7;
    }

    public final String component1() {
        return this.operationId;
    }

    public final String component2() {
        return this.agentGeneration;
    }

    public final StretchAgentCode component3() {
        return this.code;
    }

    public final StretchAgentPhase component4() {
        return this.phase;
    }

    public final StretchAgentBaseline component5() {
        return this.baseline;
    }

    public final StretchOriginalEvidence component6() {
        return this.originalEvidence;
    }

    public final StretchAgentReply copy(String arg8, String arg9, StretchAgentCode arg10, StretchAgentPhase arg11, StretchAgentBaseline arg12, StretchOriginalEvidence arg13) {
        Intrinsics.checkNotNullParameter(arg8, "operationId");
        Intrinsics.checkNotNullParameter(arg9, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg10, "code");
        Intrinsics.checkNotNullParameter(arg11, "phase");
        return new StretchAgentReply(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static StretchAgentReply copy$default(StretchAgentReply arg0, String arg1, String arg2, StretchAgentCode arg3, StretchAgentPhase arg4, StretchAgentBaseline arg5, StretchOriginalEvidence arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.operationId;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.agentGeneration;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.code;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.phase;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.baseline;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.originalEvidence;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchAgentReply)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchAgentReply)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.operationId, ((StretchAgentReply)arg5).operationId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.agentGeneration, ((StretchAgentReply)arg5).agentGeneration)) {
            return 0;
        }

        if(this.code != ((StretchAgentReply)arg5).code) {
            return 0;
        }

        if(this.phase != ((StretchAgentReply)arg5).phase) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.baseline, ((StretchAgentReply)arg5).baseline)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.originalEvidence, ((StretchAgentReply)arg5).originalEvidence)) {
            return 0;
        }

        return 1;
    }

    public final String getAgentGeneration() {
        return this.agentGeneration;
    }

    public final StretchAgentBaseline getBaseline() {
        return this.baseline;
    }

    public final StretchAgentCode getCode() {
        return this.code;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final StretchOriginalEvidence getOriginalEvidence() {
        return this.originalEvidence;
    }

    public final StretchAgentPhase getPhase() {
        return this.phase;
    }

    public final boolean getPhysicalMutationAllowed() {
        return 0;
    }

    public int hashCode() {
        int v0 = (((this.operationId.hashCode() * 0x1F + this.agentGeneration.hashCode()) * 0x1F + this.code.hashCode()) * 0x1F + this.phase.hashCode()) * 0x1F;
        StretchAgentBaseline v1 = this.baseline;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchOriginalEvidence v3 = this.originalEvidence;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchAgentReply(operationId=" + this.operationId + ", agentGeneration=" + this.agentGeneration + ", code=" + this.code + ", phase=" + this.phase + ", baseline=" + this.baseline + ", originalEvidence=" + this.originalEvidence + ")";
    }
}

