package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewport;", "", "physicalIdentity", "", "projection", "Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "deviceSize", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;)V", "getPhysicalIdentity", "()Ljava/lang/String;", "getProjection", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "getDeviceSize", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class OriginalViewport {
    public static final int $stable;
    private final StretchSize deviceSize;
    private final String physicalIdentity;
    private final StretchFullProjection projection;

    static {
    }

    public OriginalViewport(String arg2, StretchFullProjection arg3, StretchSize arg4) {
        Intrinsics.checkNotNullParameter(arg2, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg3, "projection");
        Intrinsics.checkNotNullParameter(arg4, "deviceSize");
        super();
        this.physicalIdentity = arg2;
        this.projection = arg3;
        this.deviceSize = arg4;
    }

    public final String component1() {
        return this.physicalIdentity;
    }

    public final StretchFullProjection component2() {
        return this.projection;
    }

    public final StretchSize component3() {
        return this.deviceSize;
    }

    public final OriginalViewport copy(String arg1, StretchFullProjection arg2, StretchSize arg3) {
        Intrinsics.checkNotNullParameter(arg1, "physicalIdentity");
        Intrinsics.checkNotNullParameter(arg2, "projection");
        Intrinsics.checkNotNullParameter(arg3, "deviceSize");
        return new OriginalViewport(arg1, arg2, arg3);
    }

    public static OriginalViewport copy$default(OriginalViewport arg0, String arg1, StretchFullProjection arg2, StretchSize arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.physicalIdentity;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.projection;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.deviceSize;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((OriginalViewport)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof OriginalViewport)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.physicalIdentity, ((OriginalViewport)arg5).physicalIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.projection, ((OriginalViewport)arg5).projection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.deviceSize, ((OriginalViewport)arg5).deviceSize)) {
            return 0;
        }

        return 1;
    }

    public final StretchSize getDeviceSize() {
        return this.deviceSize;
    }

    public final String getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public final StretchFullProjection getProjection() {
        return this.projection;
    }

    public int hashCode() {
        return (this.physicalIdentity.hashCode() * 0x1F + this.projection.hashCode()) * 0x1F + this.deviceSize.hashCode();
    }

    public String toString() {
        return "OriginalViewport(physicalIdentity=" + this.physicalIdentity + ", projection=" + this.projection + ", deviceSize=" + this.deviceSize + ")";
    }
}

