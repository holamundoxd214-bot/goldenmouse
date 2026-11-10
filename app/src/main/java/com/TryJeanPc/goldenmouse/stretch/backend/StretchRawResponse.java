package com.TryJeanPc.goldenmouse.stretch.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001A\u001A\u00020\bHÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\nHÆ\u0003JD\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001DJ\u0013\u0010\u001E\u001A\u00020\b2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001A\u00020\u0006HÖ\u0001J\t\u0010!\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchRawResponse;", "", "stdout", "", "stderr", "exitCode", "", "complete", "", "error", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;)V", "getStdout", "()Ljava/lang/String;", "getStderr", "getExitCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getComplete", "()Z", "getError", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLcom/TryJeanPc/goldenmouse/stretch/backend/StretchTransportError;)Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchRawResponse;", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRawResponse {
    public static final int $stable;
    private final boolean complete;
    private final StretchTransportError error;
    private final Integer exitCode;
    private final String stderr;
    private final String stdout;

    static {
    }

    public StretchRawResponse(String arg7, String arg8, Integer arg9, boolean arg10, StretchTransportError arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 16) != 0) {
            arg11 = null;
        }

        this(arg7, arg8, arg9, true, arg11);
    }

    public StretchRawResponse(String arg2, String arg3, Integer arg4, boolean arg5, StretchTransportError arg6) {
        Intrinsics.checkNotNullParameter(arg2, "stdout");
        Intrinsics.checkNotNullParameter(arg3, "stderr");
        super();
        this.stdout = arg2;
        this.stderr = arg3;
        this.exitCode = arg4;
        this.complete = arg5;
        this.error = arg6;
    }

    public final String component1() {
        return this.stdout;
    }

    public final String component2() {
        return this.stderr;
    }

    public final Integer component3() {
        return this.exitCode;
    }

    public final boolean component4() {
        return this.complete;
    }

    public final StretchTransportError component5() {
        return this.error;
    }

    public final StretchRawResponse copy(String arg7, String arg8, Integer arg9, boolean arg10, StretchTransportError arg11) {
        Intrinsics.checkNotNullParameter(arg7, "stdout");
        Intrinsics.checkNotNullParameter(arg8, "stderr");
        return new StretchRawResponse(arg7, arg8, arg9, arg10, arg11);
    }

    public static StretchRawResponse copy$default(StretchRawResponse arg0, String arg1, String arg2, Integer arg3, boolean arg4, StretchTransportError arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.stdout;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.stderr;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.exitCode;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.complete;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.error;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchRawResponse)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchRawResponse)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stdout, ((StretchRawResponse)arg5).stdout)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.stderr, ((StretchRawResponse)arg5).stderr)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.exitCode, ((StretchRawResponse)arg5).exitCode)) {
            return 0;
        }

        if(this.complete != ((StretchRawResponse)arg5).complete) {
            return 0;
        }

        if(this.error != ((StretchRawResponse)arg5).error) {
            return 0;
        }

        return 1;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final StretchTransportError getError() {
        return this.error;
    }

    public final Integer getExitCode() {
        return this.exitCode;
    }

    public final String getStderr() {
        return this.stderr;
    }

    public final String getStdout() {
        return this.stdout;
    }

    public int hashCode() {
        int v0 = (this.stdout.hashCode() * 0x1F + this.stderr.hashCode()) * 0x1F;
        Integer v1 = this.exitCode;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = ((v0 + v1_1) * 0x1F + Boolean.hashCode(this.complete)) * 0x1F;
        StretchTransportError v3 = this.error;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "StretchRawResponse(stdout=" + this.stdout + ", stderr=" + this.stderr + ", exitCode=" + this.exitCode + ", complete=" + this.complete + ", error=" + this.error + ")";
    }
}

