package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0007HÆ\u0003J)\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00072\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000F¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;", "", "code", "Lcom/TryJeanPc/goldenmouse/stretch/agent/CompositorReadCode;", "state", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorState;", "stable", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/CompositorReadCode;Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorState;Z)V", "getCode", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/CompositorReadCode;", "getState", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorState;", "getStable", "()Z", "physicalRecoveryAccredited", "getPhysicalRecoveryAccredited", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCompositorRead {
    public static final int $stable;
    private final CompositorReadCode code;
    private final boolean stable;
    private final StretchCompositorState state;

    static {
    }

    public StretchCompositorRead(CompositorReadCode arg1, StretchCompositorState arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = CompositorReadCode.UNKNOWN;
        }

        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2, false);
    }

    public StretchCompositorRead() {
        this(null, null, false, 7, null);
    }

    public StretchCompositorRead(CompositorReadCode arg4, StretchCompositorState arg5, boolean arg6) {
        Intrinsics.checkNotNullParameter(arg4, "code");
        super();
        this.code = arg4;
        this.state = arg5;
        this.stable = arg6;
        int v3 = 1;
        int v1 = arg5 != null ? 1 : 0;
        if(arg4 == CompositorReadCode.OBSERVED_COMPOSITOR_ONLY) {
        }
        else {
            v3 = 0;
        }

        String v4 = "Failed requirement.";
        if(v1 == v3) {
            if(arg6) {
                if(arg5 != null) {
                }
                else {
                    throw new IllegalArgumentException(v4.toString());
                }
            }

            return;
        }

        throw new IllegalArgumentException(v4.toString());
    }

    public final CompositorReadCode component1() {
        return this.code;
    }

    public final StretchCompositorState component2() {
        return this.state;
    }

    public final boolean component3() {
        return this.stable;
    }

    public final StretchCompositorRead copy(CompositorReadCode arg1, StretchCompositorState arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "code");
        return new StretchCompositorRead(arg1, arg2, arg3);
    }

    public static StretchCompositorRead copy$default(StretchCompositorRead arg0, CompositorReadCode arg1, StretchCompositorState arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.code;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.state;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.stable;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchCompositorRead)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchCompositorRead)) {
            return 0;
        }

        if(this.code != ((StretchCompositorRead)arg5).code) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((StretchCompositorRead)arg5).state)) {
            return 0;
        }

        if(this.stable != ((StretchCompositorRead)arg5).stable) {
            return 0;
        }

        return 1;
    }

    public final CompositorReadCode getCode() {
        return this.code;
    }

    public final boolean getPhysicalRecoveryAccredited() {
        return 0;
    }

    public final boolean getStable() {
        return this.stable;
    }

    public final StretchCompositorState getState() {
        return this.state;
    }

    public int hashCode() {
        int v0 = this.code.hashCode() * 0x1F;
        StretchCompositorState v1 = this.state;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return (v0 + v1_1) * 0x1F + Boolean.hashCode(this.stable);
    }

    public String toString() {
        return "StretchCompositorRead(code=" + this.code + ", state=" + this.state + ", stable=" + this.stable + ")";
    }
}

