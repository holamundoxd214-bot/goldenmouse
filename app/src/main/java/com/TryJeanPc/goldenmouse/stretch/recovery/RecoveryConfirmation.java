package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryConfirmation;", "", "id", "", "startedElapsedMillis", "", "expiresElapsedMillis", "<init>", "(Ljava/lang/String;JJ)V", "getId", "()Ljava/lang/String;", "getStartedElapsedMillis", "()J", "getExpiresElapsedMillis", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoveryConfirmation {
    public static final int $stable;
    private final long expiresElapsedMillis;
    private final String id;
    private final long startedElapsedMillis;

    static {
    }

    public RecoveryConfirmation(String arg2, long arg3, long arg5) {
        Intrinsics.checkNotNullParameter(arg2, "id");
        super();
        this.id = arg2;
        this.startedElapsedMillis = arg3;
        this.expiresElapsedMillis = arg5;
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.startedElapsedMillis;
    }

    public final long component3() {
        return this.expiresElapsedMillis;
    }

    public final RecoveryConfirmation copy(String arg7, long arg8, long arg10) {
        Intrinsics.checkNotNullParameter(arg7, "id");
        return new RecoveryConfirmation(arg7, arg8, arg10);
    }

    public static RecoveryConfirmation copy$default(RecoveryConfirmation arg0, String arg1, long arg2, long arg4, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.id;
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
        if(this == (((RecoveryConfirmation)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof RecoveryConfirmation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.id, ((RecoveryConfirmation)arg8).id)) {
            return 0;
        }

        if(this.startedElapsedMillis != ((RecoveryConfirmation)arg8).startedElapsedMillis) {
            return 0;
        }

        if(this.expiresElapsedMillis != ((RecoveryConfirmation)arg8).expiresElapsedMillis) {
            return 0;
        }

        return 1;
    }

    public final long getExpiresElapsedMillis() {
        return this.expiresElapsedMillis;
    }

    public final String getId() {
        return this.id;
    }

    public final long getStartedElapsedMillis() {
        return this.startedElapsedMillis;
    }

    public int hashCode() {
        return (this.id.hashCode() * 0x1F + Long.hashCode(this.startedElapsedMillis)) * 0x1F + Long.hashCode(this.expiresElapsedMillis);
    }

    public String toString() {
        return "RecoveryConfirmation(id=" + this.id + ", startedElapsedMillis=" + this.startedElapsedMillis + ", expiresElapsedMillis=" + this.expiresElapsedMillis + ")";
    }
}

