package com.TryJeanPc.goldenmouse.stretch.recovery;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001D\u001A\u00020\nHÆ\u0003J\t\u0010\u001E\u001A\u00020\fHÆ\u0003JK\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\fHÆ\u0001J\u0013\u0010 \u001A\u00020\n2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoveryStrategy;", "", "id", "", "snapshotDigest", "physicalIdentity", "supportedSteps", "", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryStep;", "idempotent", "", "scope", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;)V", "getId", "()Ljava/lang/String;", "getSnapshotDigest", "getPhysicalIdentity", "getSupportedSteps", "()Ljava/util/List;", "getIdempotent", "()Z", "getScope", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryScope;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryStrategy {
    public static final int $stable = 8;
    private final String id;
    private final boolean idempotent;
    private final String physicalIdentity;
    private final RecoveryScope scope;
    private final String snapshotDigest;
    private final List supportedSteps;

    static {
    }

    public StretchRecoveryStrategy(String arg8, String arg9, String arg10, List arg11, boolean arg12, RecoveryScope arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 0x20) != 0) {
            arg13 = RecoveryScope.SIMULATION_ONLY;
        }

        this(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public StretchRecoveryStrategy(String arg2, String arg3, String arg4, List arg5, boolean arg6, RecoveryScope arg7) {
        Intrinsics.checkNotNullParameter(arg2, "id");
        Intrinsics.checkNotNullParameter(arg3, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg4, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg5, "supportedSteps");
        Intrinsics.checkNotNullParameter(arg7, "scope");
        super();
        this.id = arg2;
        this.snapshotDigest = arg3;
        this.physicalIdentity = arg4;
        this.supportedSteps = arg5;
        this.idempotent = arg6;
        this.scope = arg7;
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.snapshotDigest;
    }

    public final String component3() {
        return this.physicalIdentity;
    }

    public final List component4() {
        return this.supportedSteps;
    }

    public final boolean component5() {
        return this.idempotent;
    }

    public final RecoveryScope component6() {
        return this.scope;
    }

    public final StretchRecoveryStrategy copy(String arg8, String arg9, String arg10, List arg11, boolean arg12, RecoveryScope arg13) {
        Intrinsics.checkNotNullParameter(arg8, "id");
        Intrinsics.checkNotNullParameter(arg9, "snapshotDigest");
        Intrinsics.checkNotNullParameter(arg10, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg11, "supportedSteps");
        Intrinsics.checkNotNullParameter(arg13, "scope");
        return new StretchRecoveryStrategy(arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public static StretchRecoveryStrategy copy$default(StretchRecoveryStrategy arg0, String arg1, String arg2, String arg3, List arg4, boolean arg5, RecoveryScope arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = arg0.id;
        }

        if((arg7 & 2) != 0) {
            arg2 = arg0.snapshotDigest;
        }

        if((arg7 & 4) != 0) {
            arg3 = arg0.physicalIdentity;
        }

        if((arg7 & 8) != 0) {
            arg4 = arg0.supportedSteps;
        }

        if((arg7 & 16) != 0) {
            arg5 = arg0.idempotent;
        }

        if((arg7 & 0x20) != 0) {
            arg6 = arg0.scope;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchRecoveryStrategy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchRecoveryStrategy)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.id, ((StretchRecoveryStrategy)arg5).id)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshotDigest, ((StretchRecoveryStrategy)arg5).snapshotDigest)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((StretchRecoveryStrategy)arg5).physicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.supportedSteps, ((StretchRecoveryStrategy)arg5).supportedSteps)) {
            return 0;
        }

        if(this.idempotent != ((StretchRecoveryStrategy)arg5).idempotent) {
            return 0;
        }

        if(this.scope != ((StretchRecoveryStrategy)arg5).scope) {
            return 0;
        }

        return 1;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getIdempotent() {
        return this.idempotent;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final RecoveryScope getScope() {
        return this.scope;
    }

    public final String getSnapshotDigest() {
        return this.snapshotDigest;
    }

    public final List getSupportedSteps() {
        return this.supportedSteps;
    }

    public int hashCode() {
        return ((((this.id.hashCode() * 0x1F + this.snapshotDigest.hashCode()) * 0x1F + this.physicalIdentity.hashCode()) * 0x1F + this.supportedSteps.hashCode()) * 0x1F + Boolean.hashCode(this.idempotent)) * 0x1F + this.scope.hashCode();
    }

    public String toString() {
        return "StretchRecoveryStrategy(id=" + this.id + ", snapshotDigest=" + this.snapshotDigest + ", physicalIdentity=" + this.physicalIdentity + ", supportedSteps=" + this.supportedSteps + ", idempotent=" + this.idempotent + ", scope=" + this.scope + ")";
    }
}

