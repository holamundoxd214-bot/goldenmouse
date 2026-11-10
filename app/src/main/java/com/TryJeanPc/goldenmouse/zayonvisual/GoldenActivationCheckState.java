package com.TryJeanPc.goldenmouse.zayonvisual;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001D\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/zayonvisual/GoldenActivationCheckState;", "", "busy", "", "message", "", "<init>", "(ZLjava/lang/String;)V", "getBusy", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenActivationCheckState {
    public static final int $stable;
    private final boolean busy;
    private final String message;

    static {
    }

    public GoldenActivationCheckState(boolean arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(false, arg2);
    }

    public GoldenActivationCheckState() {
        this(false, null, 3, null);
    }

    public GoldenActivationCheckState(boolean arg1, String arg2) {
        super();
        this.busy = arg1;
        this.message = arg2;
    }

    public final boolean component1() {
        return this.busy;
    }

    public final String component2() {
        return this.message;
    }

    public final GoldenActivationCheckState copy(boolean arg1, String arg2) {
        return new GoldenActivationCheckState(arg1, arg2);
    }

    public static GoldenActivationCheckState copy$default(GoldenActivationCheckState arg0, boolean arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.busy;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.message;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((GoldenActivationCheckState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GoldenActivationCheckState)) {
            return 0;
        }

        if(this.busy != ((GoldenActivationCheckState)arg5).busy) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.message, ((GoldenActivationCheckState)arg5).message)) {
            return 0;
        }

        return 1;
    }

    public final boolean getBusy() {
        return this.busy;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int v0 = Boolean.hashCode(this.busy) * 0x1F;
        String v1 = this.message;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "GoldenActivationCheckState(busy=" + this.busy + ", message=" + this.message + ")";
    }
}

