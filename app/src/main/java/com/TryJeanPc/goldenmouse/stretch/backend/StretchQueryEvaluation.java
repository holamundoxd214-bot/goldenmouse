package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u0012\u001A\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryEvaluation;", "", "status", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;", "data", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "error", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;)V", "getStatus", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchExecutionStatus;", "getData", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryData;", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchQueryEvaluation {
    public static final int $stable = 8;
    private final StretchQueryData data;
    private final StretchTransportError error;
    private final StretchExecutionStatus status;

    static {
    }

    public StretchQueryEvaluation(StretchExecutionStatus arg2, StretchQueryData arg3, StretchTransportError arg4, int arg5, DefaultConstructorMarker arg6) {
        StretchQueryData v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = ((StretchTransportError)v0);
        }

        this(arg2, arg3, arg4);
    }

    public StretchQueryEvaluation(StretchExecutionStatus arg2, StretchQueryData arg3, StretchTransportError arg4) {
        Intrinsics.checkNotNullParameter(arg2, "status");
        super();
        this.status = arg2;
        this.data = arg3;
        this.error = arg4;
    }

    public final StretchExecutionStatus component1() {
        return this.status;
    }

    public final StretchQueryData component2() {
        return this.data;
    }

    public final StretchTransportError component3() {
        return this.error;
    }

    public final StretchQueryEvaluation copy(StretchExecutionStatus arg1, StretchQueryData arg2, StretchTransportError arg3) {
        Intrinsics.checkNotNullParameter(arg1, "status");
        return new StretchQueryEvaluation(arg1, arg2, arg3);
    }

    public static StretchQueryEvaluation copy$default(StretchQueryEvaluation arg0, StretchExecutionStatus arg1, StretchQueryData arg2, StretchTransportError arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.status;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.data;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.error;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchQueryEvaluation)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchQueryEvaluation)) {
            return 0;
        }

        if(this.status != ((StretchQueryEvaluation)arg5).status) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.data, ((StretchQueryEvaluation)arg5).data)) {
            return 0;
        }

        if(this.error != ((StretchQueryEvaluation)arg5).error) {
            return 0;
        }

        return 1;
    }

    public final StretchQueryData getData() {
        return this.data;
    }

    public final StretchTransportError getError() {
        return this.error;
    }

    public final StretchExecutionStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int v0 = this.status.hashCode() * 0x1F;
        StretchQueryData v1 = this.data;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchTransportError v3 = this.error;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchQueryEvaluation(status=" + this.status + ", data=" + this.data + ", error=" + this.error + ")";
    }
}

