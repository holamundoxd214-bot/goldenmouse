package com.TryJeanPc.goldenmouse.stretch.recovery;

import com.TryJeanPc.goldenmouse.stretch.backend.StretchBackendType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001A\u00020\u0003HÆ\u0003J\t\u0010$\u001A\u00020\u0005HÆ\u0003J\t\u0010%\u001A\u00020\u0005HÆ\u0003J\t\u0010&\u001A\u00020\u0003HÆ\u0003J\t\u0010\'\u001A\u00020\u0005HÆ\u0003J\t\u0010(\u001A\u00020\u0005HÆ\u0003J\t\u0010)\u001A\u00020\u0003HÆ\u0003J\t\u0010*\u001A\u00020\fHÆ\u0003J\t\u0010+\u001A\u00020\u000EHÆ\u0003J\u000F\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003Js\u0010-\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0013\u0010.\u001A\u00020/2\b\u00100\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001A\u00020\u0003HÖ\u0001J\t\u00102\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0017R\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0017R\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0015R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0017\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"¨\u00063"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryAgentRegistration;", "", "protocolVersion", "", "sessionId", "", "snapshotDigest", "logicalDisplayId", "physicalIdentity", "ownerGeneration", "ownerUid", "backend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "plannedSteps", "", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;Ljava/util/List;)V", "getProtocolVersion", "()I", "getSessionId", "()Ljava/lang/String;", "getSnapshotDigest", "getLogicalDisplayId", "getPhysicalIdentity", "getOwnerGeneration", "getOwnerUid", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "getPlannedSteps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryAgentRegistration {
    public static final int $stable = 8;
    private final StretchBackendType backend;
    private final int logicalDisplayId;
    private final String ownerGeneration;
    private final int ownerUid;
    private final String physicalIdentity;
    private final List plannedSteps;
    private final int protocolVersion;
    private final String sessionId;
    private final StretchRecoverySnapshot snapshot;
    private final String snapshotDigest;

    static {
    }

    public RecoveryAgentRegistration(int arg2, String arg3, String arg4, int arg5, String arg6, String arg7, int arg8, StretchBackendType arg9, StretchRecoverySnapshot arg10, List arg11) {
        Intrinsics.checkNotNullParameter(arg3, "sessionId");
        Intrinsics.checkNotNullParameter(arg4, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg6, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg7, "ownerGeneration");
        Intrinsics.checkNotNullParameter(arg9, "backend");
        Intrinsics.checkNotNullParameter(arg10, "snapshot");
        Intrinsics.checkNotNullParameter(arg11, "plannedSteps");
        super();
        this.protocolVersion = arg2;
        this.sessionId = arg3;
        this.snapshotDigest = arg4;
        this.logicalDisplayId = arg5;
        this.physicalIdentity = arg6;
        this.ownerGeneration = arg7;
        this.ownerUid = arg8;
        this.backend = arg9;
        this.snapshot = arg10;
        this.plannedSteps = arg11;
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final List component10() {
        return this.plannedSteps;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.snapshotDigest;
    }

    public final int component4() {
        return this.logicalDisplayId;
    }

    public final String component5() {
        return this.physicalIdentity;
    }

    public final String component6() {
        return this.ownerGeneration;
    }

    public final int component7() {
        return this.ownerUid;
    }

    public final StretchBackendType component8() {
        return this.backend;
    }

    public final StretchRecoverySnapshot component9() {
        return this.snapshot;
    }

    public final RecoveryAgentRegistration copy(int arg12, String arg13, String arg14, int arg15, String arg16, String arg17, int arg18, StretchBackendType arg19, StretchRecoverySnapshot arg20, List arg21) {
        Intrinsics.checkNotNullParameter(arg13, "sessionId");
        Intrinsics.checkNotNullParameter(arg14, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg16, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg17, "ownerGeneration");
        Intrinsics.checkNotNullParameter(arg19, "backend");
        Intrinsics.checkNotNullParameter(arg20, "snapshot");
        Intrinsics.checkNotNullParameter(arg21, "plannedSteps");
        return new RecoveryAgentRegistration(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21);
    }

    public static RecoveryAgentRegistration copy$default(RecoveryAgentRegistration arg0, int arg1, String arg2, String arg3, int arg4, String arg5, String arg6, int arg7, StretchBackendType arg8, StretchRecoverySnapshot arg9, List arg10, int arg11, Object arg12) {
        if((arg11 & 1) != 0) {
            arg1 = arg0.protocolVersion;
        }

        if((arg11 & 2) != 0) {
            arg2 = arg0.sessionId;
        }

        if((arg11 & 4) != 0) {
            arg3 = arg0.snapshotDigest;
        }

        if((arg11 & 8) != 0) {
            arg4 = arg0.logicalDisplayId;
        }

        if((arg11 & 16) != 0) {
            arg5 = arg0.physicalIdentity;
        }

        if((arg11 & 0x20) != 0) {
            arg6 = arg0.ownerGeneration;
        }

        if((arg11 & 0x40) != 0) {
            arg7 = arg0.ownerUid;
        }

        if((arg11 & 0x80) != 0) {
            arg8 = arg0.backend;
        }

        if((arg11 & 0x100) != 0) {
            arg9 = arg0.snapshot;
        }

        if((arg11 & 0x200) != 0) {
            arg10 = arg0.plannedSteps;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryAgentRegistration)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryAgentRegistration)) {
            return 0;
        }

        if(this.protocolVersion != ((RecoveryAgentRegistration)arg5).protocolVersion) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((RecoveryAgentRegistration)arg5).sessionId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshotDigest, ((RecoveryAgentRegistration)arg5).snapshotDigest)) {
            return 0;
        }

        if(this.logicalDisplayId != ((RecoveryAgentRegistration)arg5).logicalDisplayId) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((RecoveryAgentRegistration)arg5).physicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.ownerGeneration, ((RecoveryAgentRegistration)arg5).ownerGeneration)) {
            return 0;
        }

        if(this.ownerUid != ((RecoveryAgentRegistration)arg5).ownerUid) {
            return 0;
        }

        if(this.backend != ((RecoveryAgentRegistration)arg5).backend) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshot, ((RecoveryAgentRegistration)arg5).snapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.plannedSteps, ((RecoveryAgentRegistration)arg5).plannedSteps)) {
            return 0;
        }

        return 1;
    }

    public final StretchBackendType getBackend() {
        return this.backend;
    }

    public final int getLogicalDisplayId() {
        return this.logicalDisplayId;
    }

    public final String getOwnerGeneration() {
        return this.ownerGeneration;
    }

    public final int getOwnerUid() {
        return this.ownerUid;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final List getPlannedSteps() {
        return this.plannedSteps;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final StretchRecoverySnapshot getSnapshot() {
        return this.snapshot;
    }

    public final String getSnapshotDigest() {
        return this.snapshotDigest;
    }

    public int hashCode() {
        return ((((((((Integer.hashCode(this.protocolVersion) * 0x1F + this.sessionId.hashCode()) * 0x1F + this.snapshotDigest.hashCode()) * 0x1F + Integer.hashCode(this.logicalDisplayId)) * 0x1F + this.physicalIdentity.hashCode()) * 0x1F + this.ownerGeneration.hashCode()) * 0x1F + Integer.hashCode(this.ownerUid)) * 0x1F + this.backend.hashCode()) * 0x1F + this.snapshot.hashCode()) * 0x1F + this.plannedSteps.hashCode();
    }

    public String toString() {
        return "RecoveryAgentRegistration(protocolVersion=" + this.protocolVersion + ", sessionId=" + this.sessionId + ", snapshotDigest=" + this.snapshotDigest + ", logicalDisplayId=" + this.logicalDisplayId + ", physicalIdentity=" + this.physicalIdentity + ", ownerGeneration=" + this.ownerGeneration + ", ownerUid=" + this.ownerUid + ", backend=" + this.backend + ", snapshot=" + this.snapshot + ", plannedSteps=" + this.plannedSteps + ")";
    }
}

