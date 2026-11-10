package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00052\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAngleDevice;", "", "abi", "", "vulkan11", "", "provider", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getAbi", "()Ljava/lang/String;", "getVulkan11", "()Z", "getProvider", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsAngleDevice {
    public static final int $stable;
    private final String abi;
    private final String provider;
    private final boolean vulkan11;

    static {
    }

    public GraphicsAngleDevice(String arg2, boolean arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "abi");
        super();
        this.abi = arg2;
        this.vulkan11 = arg3;
        this.provider = arg4;
    }

    public GraphicsAngleDevice() {
        this(null, false, null, 7, null);
    }

    public GraphicsAngleDevice(String arg1, boolean arg2, String arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = "arm64-v8a";
        }

        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, false, arg3);
    }

    public final String component1() {
        return this.abi;
    }

    public final boolean component2() {
        return this.vulkan11;
    }

    public final String component3() {
        return this.provider;
    }

    public final GraphicsAngleDevice copy(String arg1, boolean arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg1, "abi");
        return new GraphicsAngleDevice(arg1, arg2, arg3);
    }

    public static GraphicsAngleDevice copy$default(GraphicsAngleDevice arg0, String arg1, boolean arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.abi;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.vulkan11;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.provider;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsAngleDevice)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsAngleDevice)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.abi, ((GraphicsAngleDevice)arg5).abi)) {
            return 0;
        }

        if(this.vulkan11 != ((GraphicsAngleDevice)arg5).vulkan11) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.provider, ((GraphicsAngleDevice)arg5).provider)) {
            return 0;
        }

        return 1;
    }

    public final String getAbi() {
        return this.abi;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final boolean getVulkan11() {
        return this.vulkan11;
    }

    public int hashCode() {
        int v0 = (this.abi.hashCode() * 0x1F + Boolean.hashCode(this.vulkan11)) * 0x1F;
        String v2 = this.provider;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public String toString() {
        return "GraphicsAngleDevice(abi=" + this.abi + ", vulkan11=" + this.vulkan11 + ", provider=" + this.provider + ")";
    }
}

