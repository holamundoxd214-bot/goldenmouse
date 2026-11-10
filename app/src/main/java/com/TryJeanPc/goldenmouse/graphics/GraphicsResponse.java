package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsResponse;", "", "out", "", "error", "exit", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getOut", "()Ljava/lang/String;", "getError", "getExit", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsResponse {
    public static final int $stable;
    private final String error;
    private final int exit;
    private final String out;

    static {
    }

    public GraphicsResponse(String arg2, String arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "out");
        Intrinsics.checkNotNullParameter(arg3, "error");
        super();
        this.out = arg2;
        this.error = arg3;
        this.exit = arg4;
    }

    public final String component1() {
        return this.out;
    }

    public final String component2() {
        return this.error;
    }

    public final int component3() {
        return this.exit;
    }

    public final GraphicsResponse copy(String arg1, String arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "out");
        Intrinsics.checkNotNullParameter(arg2, "error");
        return new GraphicsResponse(arg1, arg2, arg3);
    }

    public static GraphicsResponse copy$default(GraphicsResponse arg0, String arg1, String arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.out;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.error;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.exit;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsResponse)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsResponse)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.out, ((GraphicsResponse)arg5).out)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.error, ((GraphicsResponse)arg5).error)) {
            return 0;
        }

        if(this.exit != ((GraphicsResponse)arg5).exit) {
            return 0;
        }

        return 1;
    }

    public final String getError() {
        return this.error;
    }

    public final int getExit() {
        return this.exit;
    }

    public final String getOut() {
        return this.out;
    }

    public int hashCode() {
        return (this.out.hashCode() * 0x1F + this.error.hashCode()) * 0x1F + Integer.hashCode(this.exit);
    }

    public String toString() {
        return "GraphicsResponse(out=" + this.out + ", error=" + this.error + ", exit=" + this.exit + ")";
    }
}

