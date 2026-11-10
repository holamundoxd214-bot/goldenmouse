package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\r2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewportRead;", "", "code", "Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "viewport", "Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewport;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewport;)V", "getCode", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "getViewport", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewport;", "physicallyRecoverable", "", "getPhysicallyRecoverable", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class OriginalViewportRead {
    public static final int $stable;
    private final OriginalReadCode code;
    private final OriginalViewport viewport;

    static {
    }

    public OriginalViewportRead(OriginalReadCode arg1, OriginalViewport arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public OriginalViewportRead(OriginalReadCode arg2, OriginalViewport arg3) {
        Intrinsics.checkNotNullParameter(arg2, "code");
        super();
        this.code = arg2;
        this.viewport = arg3;
    }

    public final OriginalReadCode component1() {
        return this.code;
    }

    public final OriginalViewport component2() {
        return this.viewport;
    }

    public final OriginalViewportRead copy(OriginalReadCode arg1, OriginalViewport arg2) {
        Intrinsics.checkNotNullParameter(arg1, "code");
        return new OriginalViewportRead(arg1, arg2);
    }

    public static OriginalViewportRead copy$default(OriginalViewportRead arg0, OriginalReadCode arg1, OriginalViewport arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.code;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.viewport;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((OriginalViewportRead)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof OriginalViewportRead)) {
            return 0;
        }

        if(this.code != ((OriginalViewportRead)arg5).code) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.viewport, ((OriginalViewportRead)arg5).viewport)) {
            return 0;
        }

        return 1;
    }

    public final OriginalReadCode getCode() {
        return this.code;
    }

    public final boolean getPhysicallyRecoverable() {
        return 0;
    }

    public final OriginalViewport getViewport() {
        return this.viewport;
    }

    public int hashCode() {
        int v0 = this.code.hashCode() * 0x1F;
        OriginalViewport v1 = this.viewport;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return v0 + v1_1;
    }

    public String toString() {
        return "OriginalViewportRead(code=" + this.code + ", viewport=" + this.viewport + ")";
    }
}

