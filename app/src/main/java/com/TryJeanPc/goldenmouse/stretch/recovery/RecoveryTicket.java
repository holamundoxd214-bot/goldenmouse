package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001D\u001A\u00020\bHÆ\u0003J\t\u0010\u001E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001F\u001A\u00020\u0003HÆ\u0003J\t\u0010 \u001A\u00020\fHÆ\u0003JO\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\fHÆ\u0001J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001A\u00020\bHÖ\u0001J\t\u0010&\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryTicket;", "", "sessionId", "", "operationId", "revision", "", "logicalDisplayId", "", "physicalIdentity", "snapshotDigest", "scope", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;)V", "getSessionId", "()Ljava/lang/String;", "getOperationId", "getRevision", "()J", "getLogicalDisplayId", "()I", "getPhysicalIdentity", "getSnapshotDigest", "getScope", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryTicket {
    public static final int $stable;
    private final int logicalDisplayId;
    private final String operationId;
    private final String physicalIdentity;
    private final long revision;
    private final RecoveryScope scope;
    private final String sessionId;
    private final String snapshotDigest;

    static {
    }

    public RecoveryTicket(String arg2, String arg3, long arg4, int arg6, String arg7, String arg8, RecoveryScope arg9) {
        Intrinsics.checkNotNullParameter(arg2, "sessionId");
        Intrinsics.checkNotNullParameter(arg3, "operationId");
        Intrinsics.checkNotNullParameter(arg7, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg8, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg9, "scope");
        super();
        this.sessionId = arg2;
        this.operationId = arg3;
        this.revision = arg4;
        this.logicalDisplayId = arg6;
        this.physicalIdentity = arg7;
        this.snapshotDigest = arg8;
        this.scope = arg9;
    }

    public RecoveryTicket(String arg11, String arg12, long arg13, int arg15, String arg16, String arg17, RecoveryScope arg18, int arg19, DefaultConstructorMarker arg20) {
        RecoveryScope v9 = (arg19 & 0x40) != 0 ? RecoveryScope.SIMULATION_ONLY : arg18;
        this(arg11, arg12, arg13, arg15, arg16, arg17, v9);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.operationId;
    }

    public final long component3() {
        return this.revision;
    }

    public final int component4() {
        return this.logicalDisplayId;
    }

    public final String component5() {
        return this.physicalIdentity;
    }

    public final String component6() {
        return this.snapshotDigest;
    }

    public final RecoveryScope component7() {
        return this.scope;
    }

    public final RecoveryTicket copy(String arg10, String arg11, long arg12, int arg14, String arg15, String arg16, RecoveryScope arg17) {
        Intrinsics.checkNotNullParameter(arg10, "sessionId");
        Intrinsics.checkNotNullParameter(arg11, "operationId");
        Intrinsics.checkNotNullParameter(arg15, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg16, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg17, "scope");
        return new RecoveryTicket(arg10, arg11, arg12, arg14, arg15, arg16, arg17);
    }

    public static RecoveryTicket copy$default(RecoveryTicket arg0, String arg1, String arg2, long arg3, int arg5, String arg6, String arg7, RecoveryScope arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg1 = arg0.sessionId;
        }

        if((arg9 & 2) != 0) {
            arg2 = arg0.operationId;
        }

        if((arg9 & 4) != 0) {
            arg3 = arg0.revision;
        }

        if((arg9 & 8) != 0) {
            arg5 = arg0.logicalDisplayId;
        }

        if((arg9 & 16) != 0) {
            arg6 = arg0.physicalIdentity;
        }

        if((arg9 & 0x20) != 0) {
            arg7 = arg0.snapshotDigest;
        }

        if((arg9 & 0x40) != 0) {
            arg8 = arg0.scope;
        }

        return arg0.copy(arg1, arg2, arg3, arg5, arg6, arg7, arg8);
    }

    public boolean equals(Object arg8) {
        if(this == (((RecoveryTicket)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof RecoveryTicket)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sessionId, ((RecoveryTicket)arg8).sessionId)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.operationId, ((RecoveryTicket)arg8).operationId)) {
            return 0;
        }

        if(this.revision != ((RecoveryTicket)arg8).revision) {
            return 0;
        }

        if(this.logicalDisplayId != ((RecoveryTicket)arg8).logicalDisplayId) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((RecoveryTicket)arg8).physicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshotDigest, ((RecoveryTicket)arg8).snapshotDigest)) {
            return 0;
        }

        if(this.scope != ((RecoveryTicket)arg8).scope) {
            return 0;
        }

        return 1;
    }

    public final int getLogicalDisplayId() {
        return this.logicalDisplayId;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final long getRevision() {
        return this.revision;
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

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 0x1F + this.operationId.hashCode()) * 0x1F + Long.hashCode(this.revision)) * 0x1F + Integer.hashCode(this.logicalDisplayId)) * 0x1F + this.physicalIdentity.hashCode()) * 0x1F + this.snapshotDigest.hashCode()) * 0x1F + this.scope.hashCode();
    }

    public String toString() {
        return "RecoveryTicket(sessionId=" + this.sessionId + ", operationId=" + this.operationId + ", revision=" + this.revision + ", logicalDisplayId=" + this.logicalDisplayId + ", physicalIdentity=" + this.physicalIdentity + ", snapshotDigest=" + this.snapshotDigest + ", scope=" + this.scope + ")";
    }
}

