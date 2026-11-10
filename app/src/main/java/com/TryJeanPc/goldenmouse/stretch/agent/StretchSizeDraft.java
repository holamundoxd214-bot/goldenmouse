package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchSizeDraft;", "", "logicalTarget", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "naturalTarget", "logicalDisplayId", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;I)V", "getLogicalTarget", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "getNaturalTarget", "getLogicalDisplayId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchSizeDraft {
    public static final int $stable;
    private final int logicalDisplayId;
    private final StretchSize logicalTarget;
    private final StretchSize naturalTarget;

    static {
    }

    public StretchSizeDraft(StretchSize arg2, StretchSize arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "logicalTarget");
        Intrinsics.checkNotNullParameter(arg3, "naturalTarget");
        super();
        this.logicalTarget = arg2;
        this.naturalTarget = arg3;
        this.logicalDisplayId = arg4;
    }

    public final StretchSize component1() {
        return this.logicalTarget;
    }

    public final StretchSize component2() {
        return this.naturalTarget;
    }

    public final int component3() {
        return this.logicalDisplayId;
    }

    public final StretchSizeDraft copy(StretchSize arg1, StretchSize arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "logicalTarget");
        Intrinsics.checkNotNullParameter(arg2, "naturalTarget");
        return new StretchSizeDraft(arg1, arg2, arg3);
    }

    public static StretchSizeDraft copy$default(StretchSizeDraft arg0, StretchSize arg1, StretchSize arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.logicalTarget;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.naturalTarget;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.logicalDisplayId;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchSizeDraft)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchSizeDraft)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.logicalTarget, ((StretchSizeDraft)arg5).logicalTarget)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.naturalTarget, ((StretchSizeDraft)arg5).naturalTarget)) {
            return 0;
        }

        if(this.logicalDisplayId != ((StretchSizeDraft)arg5).logicalDisplayId) {
            return 0;
        }

        return 1;
    }

    public final int getLogicalDisplayId() {
        return this.logicalDisplayId;
    }

    public final StretchSize getLogicalTarget() {
        return this.logicalTarget;
    }

    public final StretchSize getNaturalTarget() {
        return this.naturalTarget;
    }

    public int hashCode() {
        return (this.logicalTarget.hashCode() * 0x1F + this.naturalTarget.hashCode()) * 0x1F + Integer.hashCode(this.logicalDisplayId);
    }

    public String toString() {
        return "StretchSizeDraft(logicalTarget=" + this.logicalTarget + ", naturalTarget=" + this.naturalTarget + ", logicalDisplayId=" + this.logicalDisplayId + ")";
    }
}

