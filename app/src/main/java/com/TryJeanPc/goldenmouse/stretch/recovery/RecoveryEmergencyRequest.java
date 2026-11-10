package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0007HÆ\u0003J1\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryEmergencyRequest;", "", "sessionId", "", "snapshotDigest", "physicalIdentity", "expectedRevision", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getSessionId", "()Ljava/lang/String;", "getSnapshotDigest", "getPhysicalIdentity", "getExpectedRevision", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryEmergencyRequest {
    public static final int $stable;
    private final long expectedRevision;
    private final String physicalIdentity;
    private final String sessionId;
    private final String snapshotDigest;

    static {
    }

    public RecoveryEmergencyRequest(String arg2, String arg3, String arg4, long arg5) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        Intrinsics.checkNotNullParameter(arg3, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg4, "physicalIdentity");
        super();
        this.sessionId = arg2;
        this.snapshotDigest = arg3;
        this.physicalIdentity = arg4;
        this.expectedRevision = arg5;
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.snapshotDigest;
    }

    public final String component3() {
        return this.physicalIdentity;
    }

    public final long component4() {
        return this.expectedRevision;
    }

    public final RecoveryEmergencyRequest copy(String arg7, String arg8, String arg9, long arg10) {
        Intrinsics.checkNotNullParameter(arg7, "sessionId");
        Intrinsics.checkNotNullParameter(arg8, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg9, "physicalIdentity");
        return new RecoveryEmergencyRequest(arg7, arg8, arg9, arg10);
    }

    public static RecoveryEmergencyRequest copy$default(RecoveryEmergencyRequest arg0, String arg1, String arg2, String arg3, long arg4, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.sessionId;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.snapshotDigest;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.physicalIdentity;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.expectedRevision;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg6) {
        if(this == (((RecoveryEmergencyRequest)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof RecoveryEmergencyRequest)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((RecoveryEmergencyRequest)arg6).sessionId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshotDigest, ((RecoveryEmergencyRequest)arg6).snapshotDigest)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((RecoveryEmergencyRequest)arg6).physicalIdentity)) {
            return 0;
        }

        if(this.expectedRevision != ((RecoveryEmergencyRequest)arg6).expectedRevision) {
            return 0;
        }

        return 1;
    }

    public final long getExpectedRevision() {
        return this.expectedRevision;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSnapshotDigest() {
        return this.snapshotDigest;
    }

    public int hashCode() {
        return ((this.sessionId.hashCode() * 0x1F + this.snapshotDigest.hashCode()) * 0x1F + this.physicalIdentity.hashCode()) * 0x1F + Long.hashCode(this.expectedRevision);
    }

    public String toString() {
        return "RecoveryEmergencyRequest(sessionId=" + this.sessionId + ", snapshotDigest=" + this.snapshotDigest + ", physicalIdentity=" + this.physicalIdentity + ", expectedRevision=" + this.expectedRevision + ")";
    }
}

