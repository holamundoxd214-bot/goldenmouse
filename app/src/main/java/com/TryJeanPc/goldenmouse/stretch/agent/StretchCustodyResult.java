package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCustodyResult;", "", "code", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CustodyCode;", "reason", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/CustodyCode;Ljava/lang/String;)V", "getCode", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/CustodyCode;", "getReason", "()Ljava/lang/String;", "physicalMutationAllowed", "", "getPhysicalMutationAllowed", "()Z", "physicalRecoveryAccredited", "getPhysicalRecoveryAccredited", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCustodyResult {
    public static final int $stable;
    private final CustodyCode code;
    private final String reason;

    static {
    }

    public StretchCustodyResult(CustodyCode arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "code");
        Intrinsics.checkNotNullParameter(arg3, "reason");
        super();
        this.code = arg2;
        this.reason = arg3;
    }

    public final CustodyCode component1() {
        return this.code;
    }

    public final String component2() {
        return this.reason;
    }

    public final StretchCustodyResult copy(CustodyCode arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "code");
        Intrinsics.checkNotNullParameter(arg2, "reason");
        return new StretchCustodyResult(arg1, arg2);
    }

    public static StretchCustodyResult copy$default(StretchCustodyResult arg0, CustodyCode arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.code;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.reason;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchCustodyResult)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchCustodyResult)) {
            return 0;
        }

        if(this.code != ((StretchCustodyResult)arg5).code) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reason, ((StretchCustodyResult)arg5).reason)) {
            return 0;
        }

        return 1;
    }

    public final CustodyCode getCode() {
        return this.code;
    }

    public final boolean getPhysicalMutationAllowed() {
        return 0;
    }

    public final boolean getPhysicalRecoveryAccredited() {
        return 0;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        return this.code.hashCode() * 0x1F + this.reason.hashCode();
    }

    public String toString() {
        return "StretchCustodyResult(code=" + this.code + ", reason=" + this.reason + ")";
    }
}

