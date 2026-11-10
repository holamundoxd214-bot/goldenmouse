package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryCustody;", "", "bootId", "", "startedElapsedMillis", "", "expiresElapsedMillis", "<init>", "(Ljava/lang/String;JJ)V", "getBootId", "()Ljava/lang/String;", "getStartedElapsedMillis", "()J", "getExpiresElapsedMillis", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryCustody {
    public static final int $stable;
    private final String bootId;
    private final long expiresElapsedMillis;
    private final long startedElapsedMillis;

    static {
    }

    public StretchRecoveryCustody(String arg3, long arg4, long arg6) {
        Intrinsics.checkNotNullParameter(arg3, "bootId");
        super();
        this.bootId = arg3;
        this.startedElapsedMillis = arg4;
        this.expiresElapsedMillis = arg6;
        boolean v2 = StretchAgentProtocolKt.validAgentText(arg3);
        arg3 = "Failed requirement.";
        if((v2) && arg4 >= 0 && arg4 <= 0x7FFFFFFFFFFFC567L) {
            if(arg6 > arg4 && arg6 - arg4 <= 15000) {
                return;
            }

            throw new IllegalArgumentException(arg3.toString());
        }

        throw new IllegalArgumentException(arg3.toString());
    }

    public final String component1() {
        return this.bootId;
    }

    public final long component2() {
        return this.startedElapsedMillis;
    }

    public final long component3() {
        return this.expiresElapsedMillis;
    }

    public final StretchRecoveryCustody copy(String arg7, long arg8, long arg10) {
        Intrinsics.checkNotNullParameter(arg7, "bootId");
        return new StretchRecoveryCustody(arg7, arg8, arg10);
    }

    public static StretchRecoveryCustody copy$default(StretchRecoveryCustody arg0, String arg1, long arg2, long arg4, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.bootId;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.startedElapsedMillis;
        }

        if((arg6 & 4) != 0) {
            arg4 = arg0.expiresElapsedMillis;
        }

        return arg0.copy(arg1, arg2, arg4);
    }

    public boolean equals(Object arg8) {
        if(this == (((StretchRecoveryCustody)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof StretchRecoveryCustody)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bootId, ((StretchRecoveryCustody)arg8).bootId)) {
            return 0;
        }

        if(this.startedElapsedMillis != ((StretchRecoveryCustody)arg8).startedElapsedMillis) {
            return 0;
        }

        if(this.expiresElapsedMillis != ((StretchRecoveryCustody)arg8).expiresElapsedMillis) {
            return 0;
        }

        return 1;
    }

    public final String getBootId() {
        return this.bootId;
    }

    public final long getExpiresElapsedMillis() {
        return this.expiresElapsedMillis;
    }

    public final long getStartedElapsedMillis() {
        return this.startedElapsedMillis;
    }

    public int hashCode() {
        return (this.bootId.hashCode() * 0x1F + Long.hashCode(this.startedElapsedMillis)) * 0x1F + Long.hashCode(this.expiresElapsedMillis);
    }

    public String toString() {
        return "StretchRecoveryCustody(bootId=" + this.bootId + ", startedElapsedMillis=" + this.startedElapsedMillis + ", expiresElapsedMillis=" + this.expiresElapsedMillis + ")";
    }
}

