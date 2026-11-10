package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00032\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0015\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\f\u0010\nR\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\r\u0010\nR\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\u000E\u0010\n¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/PermissionState;", "", "overlayGranted", "", "backgroundRestricted", "batteryOptimizationExempt", "powerSaveMode", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getOverlayGranted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBackgroundRestricted", "getBatteryOptimizationExempt", "getPowerSaveMode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/TryJeanPc/goldenmouse/PermissionState;", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class PermissionState {
    public static final int $stable;
    private final Boolean backgroundRestricted;
    private final Boolean batteryOptimizationExempt;
    private final Boolean overlayGranted;
    private final Boolean powerSaveMode;

    static {
    }

    public PermissionState(Boolean arg1, Boolean arg2, Boolean arg3, Boolean arg4) {
        super();
        this.overlayGranted = arg1;
        this.backgroundRestricted = arg2;
        this.batteryOptimizationExempt = arg3;
        this.powerSaveMode = arg4;
    }

    public final Boolean component1() {
        return this.overlayGranted;
    }

    public final Boolean component2() {
        return this.backgroundRestricted;
    }

    public final Boolean component3() {
        return this.batteryOptimizationExempt;
    }

    public final Boolean component4() {
        return this.powerSaveMode;
    }

    public final PermissionState copy(Boolean arg1, Boolean arg2, Boolean arg3, Boolean arg4) {
        return new PermissionState(arg1, arg2, arg3, arg4);
    }

    public static PermissionState copy$default(PermissionState arg0, Boolean arg1, Boolean arg2, Boolean arg3, Boolean arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.overlayGranted;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.backgroundRestricted;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.batteryOptimizationExempt;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.powerSaveMode;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((PermissionState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PermissionState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overlayGranted, ((PermissionState)arg5).overlayGranted)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.backgroundRestricted, ((PermissionState)arg5).backgroundRestricted)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.batteryOptimizationExempt, ((PermissionState)arg5).batteryOptimizationExempt)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.powerSaveMode, ((PermissionState)arg5).powerSaveMode)) {
            return 0;
        }

        return 1;
    }

    public final Boolean getBackgroundRestricted() {
        return this.backgroundRestricted;
    }

    public final Boolean getBatteryOptimizationExempt() {
        return this.batteryOptimizationExempt;
    }

    public final Boolean getOverlayGranted() {
        return this.overlayGranted;
    }

    public final Boolean getPowerSaveMode() {
        return this.powerSaveMode;
    }

    public int hashCode() {
        Boolean v0 = this.overlayGranted;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Boolean v2 = this.backgroundRestricted;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        v2 = this.batteryOptimizationExempt;
        v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Boolean v3 = this.powerSaveMode;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "PermissionState(overlayGranted=" + this.overlayGranted + ", backgroundRestricted=" + this.backgroundRestricted + ", batteryOptimizationExempt=" + this.batteryOptimizationExempt + ", powerSaveMode=" + this.powerSaveMode + ")";
    }
}

