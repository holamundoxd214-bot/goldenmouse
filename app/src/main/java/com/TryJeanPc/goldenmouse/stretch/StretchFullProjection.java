package com.TryJeanPc.goldenmouse.stretch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/StretchFullProjection;", "", "source", "Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "destination", "rotation", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;I)V", "getSource", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "getDestination", "getRotation", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchFullProjection {
    public static final int $stable;
    private final StretchRect destination;
    private final int rotation;
    private final StretchRect source;

    static {
    }

    public StretchFullProjection(StretchRect arg2, StretchRect arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        super();
        this.source = arg2;
        this.destination = arg3;
        this.rotation = arg4;
    }

    public final StretchRect component1() {
        return this.source;
    }

    public final StretchRect component2() {
        return this.destination;
    }

    public final int component3() {
        return this.rotation;
    }

    public final StretchFullProjection copy(StretchRect arg1, StretchRect arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        return new StretchFullProjection(arg1, arg2, arg3);
    }

    public static StretchFullProjection copy$default(StretchFullProjection arg0, StretchRect arg1, StretchRect arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.source;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.destination;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.rotation;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchFullProjection)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchFullProjection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.source, ((StretchFullProjection)arg5).source)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.destination, ((StretchFullProjection)arg5).destination)) {
            return 0;
        }

        if(this.rotation != ((StretchFullProjection)arg5).rotation) {
            return 0;
        }

        return 1;
    }

    public final StretchRect getDestination() {
        return this.destination;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final StretchRect getSource() {
        return this.source;
    }

    public int hashCode() {
        return (this.source.hashCode() * 0x1F + this.destination.hashCode()) * 0x1F + Integer.hashCode(this.rotation);
    }

    public String toString() {
        return "StretchFullProjection(source=" + this.source + ", destination=" + this.destination + ", rotation=" + this.rotation + ")";
    }
}

