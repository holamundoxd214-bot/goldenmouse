package com.TryJeanPc.goldenmouse.stretch.recovery;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0003\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000F\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000F\u0010 \u001A\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000F\u0010!\u001A\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000F\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0003HÆ\u0003J\u000F\u0010#\u001A\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\u000F\u0010$\u001A\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\u000F\u0010%\u001A\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000F\u0010&\u001A\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0003J\u0099\u0001\u0010\'\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u00032\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u00032\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u00032\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00032\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u00032\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u00032\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\b0\u00032\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0001J\u0013\u0010(\u001A\u00020)2\b\u0010*\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001A\u00020\rHÖ\u0001J\t\u0010,\u001A\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0015R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0015R\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0015R\u0017\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0015R\u0017\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0015R\u0017\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0015¨\u0006-"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchOriginalDisplayState;", "", "logicalIdentity", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "Lcom/TryJeanPc/goldenmouse/stretch/StretchDisplayIdentity;", "physicalIdentity", "", "logicalSize", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "sizeOverride", "scaling", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "density", "", "rotation", "referenceSize", "projection", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;)V", "getLogicalIdentity", "()Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "getPhysicalIdentity", "getLogicalSize", "getSizeOverride", "getScaling", "getDensity", "getRotation", "getReferenceSize", "getProjection", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalDisplayState {
    public static final int $stable;
    private final RecoveryDatum density;
    private final RecoveryDatum logicalIdentity;
    private final RecoveryDatum logicalSize;
    private final RecoveryDatum physicalIdentity;
    private final RecoveryDatum projection;
    private final RecoveryDatum referenceSize;
    private final RecoveryDatum rotation;
    private final RecoveryDatum scaling;
    private final RecoveryDatum sizeOverride;

    static {
    }

    public StretchOriginalDisplayState(RecoveryDatum arg2, RecoveryDatum arg3, RecoveryDatum arg4, RecoveryDatum arg5, RecoveryDatum arg6, RecoveryDatum arg7, RecoveryDatum arg8, RecoveryDatum arg9, RecoveryDatum arg10) {
        Intrinsics.checkNotNullParameter(arg2, "logicalIdentity");
        Intrinsics.checkNotNullParameter(arg3, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg4, "logicalSize");
        Intrinsics.checkNotNullParameter(arg5, "sizeOverride");
        Intrinsics.checkNotNullParameter(arg6, "scaling");
        Intrinsics.checkNotNullParameter(arg7, "density");
        Intrinsics.checkNotNullParameter(arg8, "rotation");
        Intrinsics.checkNotNullParameter(arg9, "referenceSize");
        Intrinsics.checkNotNullParameter(arg10, "projection");
        super();
        this.logicalIdentity = arg2;
        this.physicalIdentity = arg3;
        this.logicalSize = arg4;
        this.sizeOverride = arg5;
        this.scaling = arg6;
        this.density = arg7;
        this.rotation = arg8;
        this.referenceSize = arg9;
        this.projection = arg10;
    }

    public final RecoveryDatum component1() {
        return this.logicalIdentity;
    }

    public final RecoveryDatum component2() {
        return this.physicalIdentity;
    }

    public final RecoveryDatum component3() {
        return this.logicalSize;
    }

    public final RecoveryDatum component4() {
        return this.sizeOverride;
    }

    public final RecoveryDatum component5() {
        return this.scaling;
    }

    public final RecoveryDatum component6() {
        return this.density;
    }

    public final RecoveryDatum component7() {
        return this.rotation;
    }

    public final RecoveryDatum component8() {
        return this.referenceSize;
    }

    public final RecoveryDatum component9() {
        return this.projection;
    }

    public final StretchOriginalDisplayState copy(RecoveryDatum arg11, RecoveryDatum arg12, RecoveryDatum arg13, RecoveryDatum arg14, RecoveryDatum arg15, RecoveryDatum arg16, RecoveryDatum arg17, RecoveryDatum arg18, RecoveryDatum arg19) {
        Intrinsics.checkNotNullParameter(arg11, "logicalIdentity");
        Intrinsics.checkNotNullParameter(arg12, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg13, "logicalSize");
        Intrinsics.checkNotNullParameter(arg14, "sizeOverride");
        Intrinsics.checkNotNullParameter(arg15, "scaling");
        Intrinsics.checkNotNullParameter(arg16, "density");
        Intrinsics.checkNotNullParameter(arg17, "rotation");
        Intrinsics.checkNotNullParameter(arg18, "referenceSize");
        Intrinsics.checkNotNullParameter(arg19, "projection");
        return new StretchOriginalDisplayState(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    public static StretchOriginalDisplayState copy$default(StretchOriginalDisplayState arg0, RecoveryDatum arg1, RecoveryDatum arg2, RecoveryDatum arg3, RecoveryDatum arg4, RecoveryDatum arg5, RecoveryDatum arg6, RecoveryDatum arg7, RecoveryDatum arg8, RecoveryDatum arg9, int arg10, Object arg11) {
        if((arg10 & 1) != 0) {
            arg1 = arg0.logicalIdentity;
        }

        if((arg10 & 2) != 0) {
            arg2 = arg0.physicalIdentity;
        }

        if((arg10 & 4) != 0) {
            arg3 = arg0.logicalSize;
        }

        if((arg10 & 8) != 0) {
            arg4 = arg0.sizeOverride;
        }

        if((arg10 & 16) != 0) {
            arg5 = arg0.scaling;
        }

        if((arg10 & 0x20) != 0) {
            arg6 = arg0.density;
        }

        if((arg10 & 0x40) != 0) {
            arg7 = arg0.rotation;
        }

        if((arg10 & 0x80) != 0) {
            arg8 = arg0.referenceSize;
        }

        if((arg10 & 0x100) != 0) {
            arg9 = arg0.projection;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchOriginalDisplayState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchOriginalDisplayState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.logicalIdentity, ((StretchOriginalDisplayState)arg5).logicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((StretchOriginalDisplayState)arg5).physicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.logicalSize, ((StretchOriginalDisplayState)arg5).logicalSize)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.sizeOverride, ((StretchOriginalDisplayState)arg5).sizeOverride)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.scaling, ((StretchOriginalDisplayState)arg5).scaling)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.density, ((StretchOriginalDisplayState)arg5).density)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.rotation, ((StretchOriginalDisplayState)arg5).rotation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.referenceSize, ((StretchOriginalDisplayState)arg5).referenceSize)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.projection, ((StretchOriginalDisplayState)arg5).projection)) {
            return 0;
        }

        return 1;
    }

    public final RecoveryDatum getDensity() {
        return this.density;
    }

    public final RecoveryDatum getLogicalIdentity() {
        return this.logicalIdentity;
    }

    public final RecoveryDatum getLogicalSize() {
        return this.logicalSize;
    }

    public final RecoveryDatum getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final RecoveryDatum getProjection() {
        return this.projection;
    }

    public final RecoveryDatum getReferenceSize() {
        return this.referenceSize;
    }

    public final RecoveryDatum getRotation() {
        return this.rotation;
    }

    public final RecoveryDatum getScaling() {
        return this.scaling;
    }

    public final RecoveryDatum getSizeOverride() {
        return this.sizeOverride;
    }

    public int hashCode() {
        return (((((((this.logicalIdentity.hashCode() * 0x1F + this.physicalIdentity.hashCode()) * 0x1F + this.logicalSize.hashCode()) * 0x1F + this.sizeOverride.hashCode()) * 0x1F + this.scaling.hashCode()) * 0x1F + this.density.hashCode()) * 0x1F + this.rotation.hashCode()) * 0x1F + this.referenceSize.hashCode()) * 0x1F + this.projection.hashCode();
    }

    public String toString() {
        return "StretchOriginalDisplayState(logicalIdentity=" + this.logicalIdentity + ", physicalIdentity=" + this.physicalIdentity + ", logicalSize=" + this.logicalSize + ", sizeOverride=" + this.sizeOverride + ", scaling=" + this.scaling + ", density=" + this.density + ", rotation=" + this.rotation + ", referenceSize=" + this.referenceSize + ", projection=" + this.projection + ")";
    }
}

