package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010\u001D\u001A\u00020\u000BHÆ\u0003JK\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00032\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001A\u00020\u000BHÆ\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020\u0006HÖ\u0001J\t\u0010#\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryApplyVerification;", "", "sessionId", "", "snapshotDigest", "logicalDisplayId", "", "physicalIdentity", "verifiedOperations", "", "scope", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;)V", "getSessionId", "()Ljava/lang/String;", "getSnapshotDigest", "getLogicalDisplayId", "()I", "getPhysicalIdentity", "getVerifiedOperations", "()Ljava/util/List;", "getScope", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryApplyVerification {
    public static final int $stable = 8;
    private final int logicalDisplayId;
    private final String physicalIdentity;
    private final RecoveryScope scope;
    private final String sessionId;
    private final String snapshotDigest;
    private final List verifiedOperations;

    static {
    }

    public RecoveryApplyVerification(String arg2, String arg3, int arg4, String arg5, List arg6, RecoveryScope arg7) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        Intrinsics.checkNotNullParameter(arg3, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg5, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg6, "verifiedOperations");
        Intrinsics.checkNotNullParameter(arg7, "scope");
        super();
        this.sessionId = arg2;
        this.snapshotDigest = arg3;
        this.logicalDisplayId = arg4;
        this.physicalIdentity = arg5;
        this.verifiedOperations = arg6;
        this.scope = arg7;
    }

    public RecoveryApplyVerification(String arg8, String arg9, int arg10, String arg11, List arg12, RecoveryScope arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 0x20) != 0) {
            arg13 = RecoveryScope.SIMULATION_ONLY;
        }

        this(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.snapshotDigest;
    }

    public final int component3() {
        return this.logicalDisplayId;
    }

    public final String component4() {
        return this.physicalIdentity;
    }

    public final List component5() {
        return this.verifiedOperations;
    }

    public final RecoveryScope component6() {
        return this.scope;
    }

    public final RecoveryApplyVerification copy(String arg8, String arg9, int arg10, String arg11, List arg12, RecoveryScope arg13) {
        Intrinsics.checkNotNullParameter(arg8, "sessionId");
        Intrinsics.checkNotNullParameter(arg9, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg11, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg12, "verifiedOperations");
        Intrinsics.checkNotNullParameter(arg13, "scope");
        return new RecoveryApplyVerification(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static RecoveryApplyVerification copy$default(RecoveryApplyVerification arg0, String arg1, String arg2, int arg3, String arg4, List arg5, RecoveryScope arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.sessionId;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.snapshotDigest;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.logicalDisplayId;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.physicalIdentity;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.verifiedOperations;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.scope;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryApplyVerification)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryApplyVerification)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((RecoveryApplyVerification)arg5).sessionId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshotDigest, ((RecoveryApplyVerification)arg5).snapshotDigest)) {
            return 0;
        }

        if(this.logicalDisplayId != ((RecoveryApplyVerification)arg5).logicalDisplayId) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((RecoveryApplyVerification)arg5).physicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.verifiedOperations, ((RecoveryApplyVerification)arg5).verifiedOperations)) {
            return 0;
        }

        if(this.scope != ((RecoveryApplyVerification)arg5).scope) {
            return 0;
        }

        return 1;
    }

    public final int getLogicalDisplayId() {
        return this.logicalDisplayId;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final RecoveryScope getScope() {
        return this.scope;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSnapshotDigest() {
        return this.snapshotDigest;
    }

    public final List getVerifiedOperations() {
        return this.verifiedOperations;
    }

    public int hashCode() {
        return ((((this.sessionId.hashCode() * 0x1F + this.snapshotDigest.hashCode()) * 0x1F + Integer.hashCode(this.logicalDisplayId)) * 0x1F + this.physicalIdentity.hashCode()) * 0x1F + this.verifiedOperations.hashCode()) * 0x1F + this.scope.hashCode();
    }

    public String toString() {
        return "RecoveryApplyVerification(sessionId=" + this.sessionId + ", snapshotDigest=" + this.snapshotDigest + ", logicalDisplayId=" + this.logicalDisplayId + ", physicalIdentity=" + this.physicalIdentity + ", verifiedOperations=" + this.verifiedOperations + ", scope=" + this.scope + ")";
    }
}

