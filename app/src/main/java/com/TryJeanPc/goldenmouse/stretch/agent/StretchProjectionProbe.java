package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\'\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\t¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProjectionProbe;", "", "token", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProbeEvidence;", "transactionMethod", "originalProjection", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProbeEvidence;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProbeEvidence;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProbeEvidence;)V", "getToken", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProbeEvidence;", "getTransactionMethod", "getOriginalProjection", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchProjectionProbe {
    public static final int $stable;
    private final StretchProbeEvidence originalProjection;
    private final StretchProbeEvidence token;
    private final StretchProbeEvidence transactionMethod;

    static {
    }

    public StretchProjectionProbe(StretchProbeEvidence arg2, StretchProbeEvidence arg3, StretchProbeEvidence arg4) {
        Intrinsics.checkNotNullParameter(arg2, "token");
        Intrinsics.checkNotNullParameter(arg3, "transactionMethod");
        Intrinsics.checkNotNullParameter(arg4, "originalProjection");
        super();
        this.token = arg2;
        this.transactionMethod = arg3;
        this.originalProjection = arg4;
    }

    public StretchProjectionProbe() {
        this(null, null, null, 7, null);
    }

    public StretchProjectionProbe(StretchProbeEvidence arg1, StretchProbeEvidence arg2, StretchProbeEvidence arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = StretchProbeEvidence.UNKNOWN;
        }

        if((arg4 & 2) != 0) {
            arg2 = StretchProbeEvidence.UNKNOWN;
        }

        if((arg4 & 4) != 0) {
            arg3 = StretchProbeEvidence.UNSUPPORTED;
        }

        this(arg1, arg2, arg3);
    }

    public final StretchProbeEvidence component1() {
        return this.token;
    }

    public final StretchProbeEvidence component2() {
        return this.transactionMethod;
    }

    public final StretchProbeEvidence component3() {
        return this.originalProjection;
    }

    public final StretchProjectionProbe copy(StretchProbeEvidence arg1, StretchProbeEvidence arg2, StretchProbeEvidence arg3) {
        Intrinsics.checkNotNullParameter(arg1, "token");
        Intrinsics.checkNotNullParameter(arg2, "transactionMethod");
        Intrinsics.checkNotNullParameter(arg3, "originalProjection");
        return new StretchProjectionProbe(arg1, arg2, arg3);
    }

    public static StretchProjectionProbe copy$default(StretchProjectionProbe arg0, StretchProbeEvidence arg1, StretchProbeEvidence arg2, StretchProbeEvidence arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.token;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.transactionMethod;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.originalProjection;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchProjectionProbe)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchProjectionProbe)) {
            return 0;
        }

        if(this.token != ((StretchProjectionProbe)arg5).token) {
            return 0;
        }

        if(this.transactionMethod != ((StretchProjectionProbe)arg5).transactionMethod) {
            return 0;
        }

        if(this.originalProjection != ((StretchProjectionProbe)arg5).originalProjection) {
            return 0;
        }

        return 1;
    }

    public final StretchProbeEvidence getOriginalProjection() {
        return this.originalProjection;
    }

    public final StretchProbeEvidence getToken() {
        return this.token;
    }

    public final StretchProbeEvidence getTransactionMethod() {
        return this.transactionMethod;
    }

    public int hashCode() {
        return (this.token.hashCode() * 0x1F + this.transactionMethod.hashCode()) * 0x1F + this.originalProjection.hashCode();
    }

    public String toString() {
        return "StretchProjectionProbe(token=" + this.token + ", transactionMethod=" + this.transactionMethod + ", originalProjection=" + this.originalProjection + ")";
    }
}

