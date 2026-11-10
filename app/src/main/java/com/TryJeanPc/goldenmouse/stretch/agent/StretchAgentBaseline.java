package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "", "snapshot", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "projection", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProjectionProbe;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProjectionProbe;)V", "getSnapshot", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRecoverySnapshot;", "getProjection", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProjectionProbe;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentBaseline {
    public static final int $stable;
    private final StretchProjectionProbe projection;
    private final StretchRecoverySnapshot snapshot;

    static {
    }

    public StretchAgentBaseline(StretchRecoverySnapshot arg2, StretchProjectionProbe arg3) {
        Intrinsics.checkNotNullParameter(arg2, "snapshot");
        Intrinsics.checkNotNullParameter(arg3, "projection");
        super();
        this.snapshot = arg2;
        this.projection = arg3;
    }

    public final StretchRecoverySnapshot component1() {
        return this.snapshot;
    }

    public final StretchProjectionProbe component2() {
        return this.projection;
    }

    public final StretchAgentBaseline copy(StretchRecoverySnapshot arg1, StretchProjectionProbe arg2) {
        Intrinsics.checkNotNullParameter(arg1, "snapshot");
        Intrinsics.checkNotNullParameter(arg2, "projection");
        return new StretchAgentBaseline(arg1, arg2);
    }

    public static StretchAgentBaseline copy$default(StretchAgentBaseline arg0, StretchRecoverySnapshot arg1, StretchProjectionProbe arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.snapshot;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.projection;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchAgentBaseline)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchAgentBaseline)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshot, ((StretchAgentBaseline)arg5).snapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.projection, ((StretchAgentBaseline)arg5).projection)) {
            return 0;
        }

        return 1;
    }

    public final StretchProjectionProbe getProjection() {
        return this.projection;
    }

    public final StretchRecoverySnapshot getSnapshot() {
        return this.snapshot;
    }

    public int hashCode() {
        return this.snapshot.hashCode() * 0x1F + this.projection.hashCode();
    }

    public String toString() {
        return "StretchAgentBaseline(snapshot=" + this.snapshot + ", projection=" + this.projection + ")";
    }
}

