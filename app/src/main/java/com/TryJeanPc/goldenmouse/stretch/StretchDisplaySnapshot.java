package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fJ\u000B\u0010\u0017\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\nHÆ\u0003JJ\u0010\u001C\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001DJ\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001A\u00020\u0007HÖ\u0001J\t\u0010\"\u001A\u00020#HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplaySnapshot;", "", "identity", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayIdentity;", "logicalSize", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "rotation", "", "modeReference", "logicalSizeSource", "Lcom/TryJeanPc/goldenmouse/stretch/StretchLogicalSizeSource;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayIdentity;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;Ljava/lang/Integer;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;Lcom/TryJeanPc/goldenmouse/stretch/StretchLogicalSizeSource;)V", "getIdentity", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayIdentity;", "getLogicalSize", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "getRotation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getModeReference", "getLogicalSizeSource", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchLogicalSizeSource;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayIdentity;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;Ljava/lang/Integer;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;Lcom/TryJeanPc/goldenmouse/stretch/StretchLogicalSizeSource;)Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplaySnapshot;", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchDisplaySnapshot {
    public static final int $stable;
    private final StretchDisplayIdentity identity;
    private final StretchSize logicalSize;
    private final StretchLogicalSizeSource logicalSizeSource;
    private final StretchSize modeReference;
    private final Integer rotation;

    static {
    }

    public StretchDisplaySnapshot(StretchDisplayIdentity arg1, StretchSize arg2, Integer arg3, StretchSize arg4, StretchLogicalSizeSource arg5) {
        super();
        this.identity = arg1;
        this.logicalSize = arg2;
        this.rotation = arg3;
        this.modeReference = arg4;
        this.logicalSizeSource = arg5;
    }

    public StretchDisplaySnapshot(StretchDisplayIdentity arg2, StretchSize arg3, Integer arg4, StretchSize arg5, StretchLogicalSizeSource arg6, int arg7, DefaultConstructorMarker arg8) {
        StretchSize v0 = null;
        if((arg7 & 8) != 0) {
            arg5 = v0;
        }

        if((arg7 & 16) != 0) {
            arg6 = ((StretchLogicalSizeSource)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6);
    }

    public final StretchDisplayIdentity component1() {
        return this.identity;
    }

    public final StretchSize component2() {
        return this.logicalSize;
    }

    public final Integer component3() {
        return this.rotation;
    }

    public final StretchSize component4() {
        return this.modeReference;
    }

    public final StretchLogicalSizeSource component5() {
        return this.logicalSizeSource;
    }

    public final StretchDisplaySnapshot copy(StretchDisplayIdentity arg1, StretchSize arg2, Integer arg3, StretchSize arg4, StretchLogicalSizeSource arg5) {
        return new StretchDisplaySnapshot(arg1, arg2, arg3, arg4, arg5);
    }

    public static StretchDisplaySnapshot copy$default(StretchDisplaySnapshot arg0, StretchDisplayIdentity arg1, StretchSize arg2, Integer arg3, StretchSize arg4, StretchLogicalSizeSource arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.identity;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.logicalSize;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.rotation;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.modeReference;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.logicalSizeSource;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchDisplaySnapshot)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchDisplaySnapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.identity, ((StretchDisplaySnapshot)arg5).identity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.logicalSize, ((StretchDisplaySnapshot)arg5).logicalSize)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.rotation, ((StretchDisplaySnapshot)arg5).rotation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.modeReference, ((StretchDisplaySnapshot)arg5).modeReference)) {
            return 0;
        }

        if(this.logicalSizeSource != ((StretchDisplaySnapshot)arg5).logicalSizeSource) {
            return 0;
        }

        return 1;
    }

    public final StretchDisplayIdentity getIdentity() {
        return this.identity;
    }

    public final StretchSize getLogicalSize() {
        return this.logicalSize;
    }

    public final StretchLogicalSizeSource getLogicalSizeSource() {
        return this.logicalSizeSource;
    }

    public final StretchSize getModeReference() {
        return this.modeReference;
    }

    public final Integer getRotation() {
        return this.rotation;
    }

    public int hashCode() {
        StretchDisplayIdentity v0 = this.identity;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        StretchSize v2 = this.logicalSize;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Integer v2_2 = this.rotation;
        v2_1 = v2_2 == null ? 0 : v2_2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.modeReference;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        StretchLogicalSizeSource v3 = this.logicalSizeSource;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "StretchDisplaySnapshot(identity=" + this.identity + ", logicalSize=" + this.logicalSize + ", rotation=" + this.rotation + ", modeReference=" + this.modeReference + ", logicalSizeSource=" + this.logicalSizeSource + ")";
    }
}

