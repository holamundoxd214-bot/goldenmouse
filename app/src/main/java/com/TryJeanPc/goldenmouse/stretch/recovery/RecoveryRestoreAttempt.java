package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryRestoreAttempt;", "", "request", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreRequest;", "result", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreRequest;Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;)V", "getRequest", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreRequest;", "getResult", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchRestoreResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryRestoreAttempt {
    public static final int $stable = 8;
    private final StretchRestoreRequest request;
    private final StretchRestoreResult result;

    static {
    }

    public RecoveryRestoreAttempt(StretchRestoreRequest arg2, StretchRestoreResult arg3) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        super();
        this.request = arg2;
        this.result = arg3;
    }

    public RecoveryRestoreAttempt(StretchRestoreRequest arg1, StretchRestoreResult arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public final StretchRestoreRequest component1() {
        return this.request;
    }

    public final StretchRestoreResult component2() {
        return this.result;
    }

    public final RecoveryRestoreAttempt copy(StretchRestoreRequest arg1, StretchRestoreResult arg2) {
        Intrinsics.checkNotNullParameter(arg1, "request");
        return new RecoveryRestoreAttempt(arg1, arg2);
    }

    public static RecoveryRestoreAttempt copy$default(RecoveryRestoreAttempt arg0, StretchRestoreRequest arg1, StretchRestoreResult arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.request;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.result;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((RecoveryRestoreAttempt)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RecoveryRestoreAttempt)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.request, ((RecoveryRestoreAttempt)arg5).request)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.result, ((RecoveryRestoreAttempt)arg5).result)) {
            return 0;
        }

        return 1;
    }

    public final StretchRestoreRequest getRequest() {
        return this.request;
    }

    public final StretchRestoreResult getResult() {
        return this.result;
    }

    public int hashCode() {
        int v0 = this.request.hashCode() * 0x1F;
        StretchRestoreResult v1 = this.result;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "RecoveryRestoreAttempt(request=" + this.request + ", result=" + this.result + ")";
    }
}

