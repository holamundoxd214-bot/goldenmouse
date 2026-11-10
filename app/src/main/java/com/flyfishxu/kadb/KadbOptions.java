package com.flyfishxu.kadb;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001A\u00020\u000EHÖ\u0081\u0004J\n\u0010\u000F\u001A\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Lcom/flyfishxu/kadb/KadbOptions;", "", "delayedAckMode", "Lcom/flyfishxu/kadb/DelayedAckMode;", "<init>", "(Lcom/flyfishxu/kadb/DelayedAckMode;)V", "getDelayedAckMode", "()Lcom/flyfishxu/kadb/DelayedAckMode;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class KadbOptions {
    private final DelayedAckMode delayedAckMode;

    public KadbOptions(DelayedAckMode arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = DelayedAckMode.AOSP_DEFAULT;
        }

        this(arg1);
    }

    public KadbOptions() {
        this(null, 1, null);
    }

    public KadbOptions(DelayedAckMode arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delayedAckMode");
        super();
        this.delayedAckMode = arg2;
    }

    public final DelayedAckMode component1() {
        return this.delayedAckMode;
    }

    public final KadbOptions copy(DelayedAckMode arg1) {
        Intrinsics.checkNotNullParameter(arg1, "delayedAckMode");
        return new KadbOptions(arg1);
    }

    public static KadbOptions copy$default(KadbOptions arg0, DelayedAckMode arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.delayedAckMode;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((KadbOptions)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof KadbOptions)) {
            return 0;
        }

        if(this.delayedAckMode != ((KadbOptions)arg4).delayedAckMode) {
            return 0;
        }

        return 1;
    }

    public final DelayedAckMode getDelayedAckMode() {
        return this.delayedAckMode;
    }

    public int hashCode() {
        return this.delayedAckMode.hashCode();
    }

    public String toString() {
        return "KadbOptions(delayedAckMode=" + this.delayedAckMode + ")";
    }
}

