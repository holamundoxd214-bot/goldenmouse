package com.TryJeanPc.goldenmouse.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u0014\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u0015\u001A\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00032\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputDeviceStatus;", "", "connected", "", "devicePath", "", "deviceName", "descriptor", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;)V", "getConnected", "()Z", "getDevicePath", "()Ljava/lang/String;", "getDeviceName", "getDescriptor", "()Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class InputDeviceStatus {
    public static final int $stable = 8;
    private final boolean connected;
    private final InputDeviceDescriptor descriptor;
    private final String deviceName;
    private final String devicePath;

    static {
    }

    public InputDeviceStatus(boolean arg1, String arg2, String arg3, InputDeviceDescriptor arg4) {
        super();
        this.connected = arg1;
        this.devicePath = arg2;
        this.deviceName = arg3;
        this.descriptor = arg4;
    }

    public InputDeviceStatus(boolean arg2, String arg3, String arg4, InputDeviceDescriptor arg5, int arg6, DefaultConstructorMarker arg7) {
        String v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        if((arg6 & 8) != 0) {
            arg5 = ((InputDeviceDescriptor)v0);
        }

        this(false, arg3, arg4, arg5);
    }

    public InputDeviceStatus() {
        this(false, null, null, null, 15, null);
    }

    public final boolean component1() {
        return this.connected;
    }

    public final String component2() {
        return this.devicePath;
    }

    public final String component3() {
        return this.deviceName;
    }

    public final InputDeviceDescriptor component4() {
        return this.descriptor;
    }

    public final InputDeviceStatus copy(boolean arg1, String arg2, String arg3, InputDeviceDescriptor arg4) {
        return new InputDeviceStatus(arg1, arg2, arg3, arg4);
    }

    public static InputDeviceStatus copy$default(InputDeviceStatus arg0, boolean arg1, String arg2, String arg3, InputDeviceDescriptor arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.connected;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.devicePath;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.deviceName;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.descriptor;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((InputDeviceStatus)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof InputDeviceStatus)) {
            return 0;
        }

        if(this.connected != ((InputDeviceStatus)arg5).connected) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.devicePath, ((InputDeviceStatus)arg5).devicePath)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.deviceName, ((InputDeviceStatus)arg5).deviceName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.descriptor, ((InputDeviceStatus)arg5).descriptor)) {
            return 0;
        }

        return 1;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final InputDeviceDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDevicePath() {
        return this.devicePath;
    }

    public int hashCode() {
        int v0 = Boolean.hashCode(this.connected) * 0x1F;
        String v1 = this.devicePath;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.deviceName;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        InputDeviceDescriptor v3 = this.descriptor;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "InputDeviceStatus(connected=" + this.connected + ", devicePath=" + this.devicePath + ", deviceName=" + this.deviceName + ", descriptor=" + this.descriptor + ")";
    }
}

