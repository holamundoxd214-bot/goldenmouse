package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\"\u001A\u00020\u0003HÆ\u0003J\t\u0010#\u001A\u00020\u0005HÆ\u0003J\t\u0010$\u001A\u00020\u0005HÆ\u0003J\t\u0010%\u001A\u00020\u0005HÆ\u0003J\t\u0010&\u001A\u00020\u0005HÆ\u0003J\t\u0010\'\u001A\u00020\u0003HÆ\u0003J\t\u0010(\u001A\u00020\u000BHÆ\u0003J\u000B\u0010)\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010*\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001A\u00020\u0003HÆ\u0003J\u0010\u0010,\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0082\u0001\u0010-\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000E\u001A\u00020\u00032\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001A\u0002002\b\u00101\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001A\u00020\u0003HÖ\u0001J\t\u00103\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0015R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\f\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0015R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0015R\u0011\u0010\u000E\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0013R\u0015\u0010\u000F\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001A\u0004\b\u001F\u0010 ¨\u00064"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "", "protocol", "", "sessionId", "", "operationId", "ownerGeneration", "agentGeneration", "logicalDisplayId", "action", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentAction;", "snapshotDigest", "physicalIdentity", "factorHundredths", "originalEvidenceVersion", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentAction;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "getProtocol", "()I", "getSessionId", "()Ljava/lang/String;", "getOperationId", "getOwnerGeneration", "getAgentGeneration", "getLogicalDisplayId", "getAction", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentAction;", "getSnapshotDigest", "getPhysicalIdentity", "getFactorHundredths", "getOriginalEvidenceVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentAction;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentRequest {
    public static final int $stable;
    private final StretchAgentAction action;
    private final String agentGeneration;
    private final int factorHundredths;
    private final int logicalDisplayId;
    private final String operationId;
    private final Integer originalEvidenceVersion;
    private final String ownerGeneration;
    private final String physicalIdentity;
    private final int protocol;
    private final String sessionId;
    private final String snapshotDigest;

    static {
    }

    public StretchAgentRequest(int arg2, String arg3, String arg4, String arg5, String arg6, int arg7, StretchAgentAction arg8, String arg9, String arg10, int arg11, Integer arg12) {
        Intrinsics.checkNotNullParameter(arg3, "sessionId");
        Intrinsics.checkNotNullParameter(arg4, "operationId");
        Intrinsics.checkNotNullParameter(arg5, "ownerGeneration");
        Intrinsics.checkNotNullParameter(arg6, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg8, "action");
        super();
        this.protocol = arg2;
        this.sessionId = arg3;
        this.operationId = arg4;
        this.ownerGeneration = arg5;
        this.agentGeneration = arg6;
        this.logicalDisplayId = arg7;
        this.action = arg8;
        this.snapshotDigest = arg9;
        this.physicalIdentity = arg10;
        this.factorHundredths = arg11;
        this.originalEvidenceVersion = arg12;
    }

    public StretchAgentRequest(int arg2, String arg3, String arg4, String arg5, String arg6, int arg7, StretchAgentAction arg8, String arg9, String arg10, int arg11, Integer arg12, int arg13, DefaultConstructorMarker arg14) {
        String v0 = null;
        if((arg13 & 0x80) != 0) {
            arg9 = v0;
        }

        if((arg13 & 0x100) != 0) {
            arg10 = v0;
        }

        if((arg13 & 0x200) != 0) {
            arg11 = 0x6F;
        }

        if((arg13 & 0x400) != 0) {
            arg12 = ((Integer)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public final int component1() {
        return this.protocol;
    }

    public final int component10() {
        return this.factorHundredths;
    }

    public final Integer component11() {
        return this.originalEvidenceVersion;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.operationId;
    }

    public final String component4() {
        return this.ownerGeneration;
    }

    public final String component5() {
        return this.agentGeneration;
    }

    public final int component6() {
        return this.logicalDisplayId;
    }

    public final StretchAgentAction component7() {
        return this.action;
    }

    public final String component8() {
        return this.snapshotDigest;
    }

    public final String component9() {
        return this.physicalIdentity;
    }

    public final StretchAgentRequest copy(int arg13, String arg14, String arg15, String arg16, String arg17, int arg18, StretchAgentAction arg19, String arg20, String arg21, int arg22, Integer arg23) {
        Intrinsics.checkNotNullParameter(arg14, "sessionId");
        Intrinsics.checkNotNullParameter(arg15, "operationId");
        Intrinsics.checkNotNullParameter(arg16, "ownerGeneration");
        Intrinsics.checkNotNullParameter(arg17, "agentGeneration");
        Intrinsics.checkNotNullParameter(arg19, "action");
        return new StretchAgentRequest(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23);
    }

    public static StretchAgentRequest copy$default(StretchAgentRequest arg0, int arg1, String arg2, String arg3, String arg4, String arg5, int arg6, StretchAgentAction arg7, String arg8, String arg9, int arg10, Integer arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg1 = arg0.protocol;
        }

        if((arg12 & 2) != 0) {
            arg2 = arg0.sessionId;
        }

        if((arg12 & 4) != 0) {
            arg3 = arg0.operationId;
        }

        if((arg12 & 8) != 0) {
            arg4 = arg0.ownerGeneration;
        }

        if((arg12 & 16) != 0) {
            arg5 = arg0.agentGeneration;
        }

        if((arg12 & 0x20) != 0) {
            arg6 = arg0.logicalDisplayId;
        }

        if((arg12 & 0x40) != 0) {
            arg7 = arg0.action;
        }

        if((arg12 & 0x80) != 0) {
            arg8 = arg0.snapshotDigest;
        }

        if((arg12 & 0x100) != 0) {
            arg9 = arg0.physicalIdentity;
        }

        if((arg12 & 0x200) != 0) {
            arg10 = arg0.factorHundredths;
        }

        if((arg12 & 0x400) != 0) {
            arg11 = arg0.originalEvidenceVersion;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchAgentRequest)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchAgentRequest)) {
            return 0;
        }

        if(this.protocol != ((StretchAgentRequest)arg5).protocol) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((StretchAgentRequest)arg5).sessionId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.operationId, ((StretchAgentRequest)arg5).operationId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ownerGeneration, ((StretchAgentRequest)arg5).ownerGeneration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.agentGeneration, ((StretchAgentRequest)arg5).agentGeneration)) {
            return 0;
        }

        if(this.logicalDisplayId != ((StretchAgentRequest)arg5).logicalDisplayId) {
            return 0;
        }

        if(this.action != ((StretchAgentRequest)arg5).action) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshotDigest, ((StretchAgentRequest)arg5).snapshotDigest)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((StretchAgentRequest)arg5).physicalIdentity)) {
            return 0;
        }

        if(this.factorHundredths != ((StretchAgentRequest)arg5).factorHundredths) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.originalEvidenceVersion, ((StretchAgentRequest)arg5).originalEvidenceVersion)) {
            return 0;
        }

        return 1;
    }

    public final StretchAgentAction getAction() {
        return this.action;
    }

    public final String getAgentGeneration() {
        return this.agentGeneration;
    }

    public final int getFactorHundredths() {
        return this.factorHundredths;
    }

    public final int getLogicalDisplayId() {
        return this.logicalDisplayId;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final Integer getOriginalEvidenceVersion() {
        return this.originalEvidenceVersion;
    }

    public final String getOwnerGeneration() {
        return this.ownerGeneration;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final int getProtocol() {
        return this.protocol;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSnapshotDigest() {
        return this.snapshotDigest;
    }

    public int hashCode() {
        int v0 = ((((((Integer.hashCode(this.protocol) * 0x1F + this.sessionId.hashCode()) * 0x1F + this.operationId.hashCode()) * 0x1F + this.ownerGeneration.hashCode()) * 0x1F + this.agentGeneration.hashCode()) * 0x1F + Integer.hashCode(this.logicalDisplayId)) * 0x1F + this.action.hashCode()) * 0x1F;
        String v1 = this.snapshotDigest;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.physicalIdentity;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = ((v0 + v1_1) * 0x1F + Integer.hashCode(this.factorHundredths)) * 0x1F;
        Integer v3 = this.originalEvidenceVersion;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchAgentRequest(protocol=" + this.protocol + ", sessionId=" + this.sessionId + ", operationId=" + this.operationId + ", ownerGeneration=" + this.ownerGeneration + ", agentGeneration=" + this.agentGeneration + ", logicalDisplayId=" + this.logicalDisplayId + ", action=" + this.action + ", snapshotDigest=" + this.snapshotDigest + ", physicalIdentity=" + this.physicalIdentity + ", factorHundredths=" + this.factorHundredths + ", originalEvidenceVersion=" + this.originalEvidenceVersion + ")";
    }
}

