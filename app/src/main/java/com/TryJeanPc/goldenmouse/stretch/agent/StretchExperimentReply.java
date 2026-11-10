package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\u000B\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0019\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001B\u001A\u00020\tHÆ\u0003J\t\u0010\u001C\u001A\u00020\tHÆ\u0003J\t\u0010\u001D\u001A\u00020\tHÆ\u0003JI\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\tHÆ\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000B\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015¨\u0006%"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchExperimentReply;", "", "code", "", "endpoint", "Landroid/os/IBinder;", "appliedReadback", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "writesMillis", "", "projectionApplyMillis", "readbackMillis", "<init>", "(Ljava/lang/String;Landroid/os/IBinder;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;JJJ)V", "getCode", "()Ljava/lang/String;", "getEndpoint", "()Landroid/os/IBinder;", "getAppliedReadback", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "getWritesMillis", "()J", "getProjectionApplyMillis", "getReadbackMillis", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchExperimentReply {
    public static final int $stable = 8;
    private final StretchOriginalEvidence appliedReadback;
    private final String code;
    private final IBinder endpoint;
    private final long projectionApplyMillis;
    private final long readbackMillis;
    private final long writesMillis;

    static {
    }

    public StretchExperimentReply(String arg2, IBinder arg3, StretchOriginalEvidence arg4, long arg5, long arg7, long arg9) {
        Intrinsics.checkNotNullParameter(arg2, "code");
        super();
        this.code = arg2;
        this.endpoint = arg3;
        this.appliedReadback = arg4;
        this.writesMillis = arg5;
        this.projectionApplyMillis = arg7;
        this.readbackMillis = arg9;
    }

    public StretchExperimentReply(String arg3, IBinder arg4, StretchOriginalEvidence arg5, long arg6, long arg8, long arg10, int arg12, DefaultConstructorMarker arg13) {
        IBinder v0 = null;
        if((arg12 & 2) != 0) {
            arg4 = v0;
        }

        if((arg12 & 4) != 0) {
            arg5 = ((StretchOriginalEvidence)v0);
        }

        long v0_1 = -1;
        if((arg12 & 8) != 0) {
            arg6 = v0_1;
        }

        if((arg12 & 16) != 0) {
            arg8 = v0_1;
        }

        if((arg12 & 0x20) != 0) {
            arg10 = v0_1;
        }

        this(arg3, arg4, arg5, arg6, arg8, arg10);
    }

    public final String component1() {
        return this.code;
    }

    public final IBinder component2() {
        return this.endpoint;
    }

    public final StretchOriginalEvidence component3() {
        return this.appliedReadback;
    }

    public final long component4() {
        return this.writesMillis;
    }

    public final long component5() {
        return this.projectionApplyMillis;
    }

    public final long component6() {
        return this.readbackMillis;
    }

    public final StretchExperimentReply copy(String arg11, IBinder arg12, StretchOriginalEvidence arg13, long arg14, long arg16, long arg18) {
        Intrinsics.checkNotNullParameter(arg11, "code");
        return new StretchExperimentReply(arg11, arg12, arg13, arg14, arg16, arg18);
    }

    public static StretchExperimentReply copy$default(StretchExperimentReply arg0, String arg1, IBinder arg2, StretchOriginalEvidence arg3, long arg4, long arg6, long arg8, int arg10, Object arg11) {
        if((arg10 & 1) != 0) {
            arg1 = arg0.code;
        }

        if((arg10 & 2) != 0) {
            arg2 = arg0.endpoint;
        }

        if((arg10 & 4) != 0) {
            arg3 = arg0.appliedReadback;
        }

        if((arg10 & 8) != 0) {
            arg4 = arg0.writesMillis;
        }

        if((arg10 & 16) != 0) {
            arg6 = arg0.projectionApplyMillis;
        }

        if((arg10 & 0x20) != 0) {
            arg8 = arg0.readbackMillis;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg6, arg8);
    }

    public boolean equals(Object arg8) {
        if(this == (((StretchExperimentReply)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof StretchExperimentReply)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.code, ((StretchExperimentReply)arg8).code)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.endpoint, ((StretchExperimentReply)arg8).endpoint)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.appliedReadback, ((StretchExperimentReply)arg8).appliedReadback)) {
            return 0;
        }

        if(this.writesMillis != ((StretchExperimentReply)arg8).writesMillis) {
            return 0;
        }

        if(this.projectionApplyMillis != ((StretchExperimentReply)arg8).projectionApplyMillis) {
            return 0;
        }

        if(this.readbackMillis != ((StretchExperimentReply)arg8).readbackMillis) {
            return 0;
        }

        return 1;
    }

    public final StretchOriginalEvidence getAppliedReadback() {
        return this.appliedReadback;
    }

    public final String getCode() {
        return this.code;
    }

    public final IBinder getEndpoint() {
        return this.endpoint;
    }

    public final long getProjectionApplyMillis() {
        return this.projectionApplyMillis;
    }

    public final long getReadbackMillis() {
        return this.readbackMillis;
    }

    public final long getWritesMillis() {
        return this.writesMillis;
    }

    public int hashCode() {
        int v0 = this.code.hashCode() * 0x1F;
        IBinder v1 = this.endpoint;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        StretchOriginalEvidence v1_2 = this.appliedReadback;
        if(v1_2 == null) {
        }
        else {
            v2 = v1_2.hashCode();
        }

        return (((v0 + v2) * 0x1F + Long.hashCode(this.writesMillis)) * 0x1F + Long.hashCode(this.projectionApplyMillis)) * 0x1F + Long.hashCode(this.readbackMillis);
    }

    public String toString() {
        return "StretchExperimentReply(code=" + this.code + ", endpoint=" + this.endpoint + ", appliedReadback=" + this.appliedReadback + ", writesMillis=" + this.writesMillis + ", projectionApplyMillis=" + this.projectionApplyMillis + ", readbackMillis=" + this.readbackMillis + ")";
    }
}

