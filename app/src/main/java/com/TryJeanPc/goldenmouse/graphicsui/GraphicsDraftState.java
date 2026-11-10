package com.TryJeanPc.goldenmouse.graphicsui;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001A\u00020\u0000J\u0010\u0010\r\u001A\u00020\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\u0003J\u000E\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0003J\u0016\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00052\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/graphicsui/GraphicsDraftState;", "", "revision", "", "dirty", "", "<init>", "(Ljava/lang/String;Z)V", "getRevision", "()Ljava/lang/String;", "getDirty", "()Z", "edited", "confirmed", "savedRevision", "notice", "fallback", "status", "operation", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsDraftState {
    public static final int $stable;
    private final boolean dirty;
    private final String revision;

    static {
    }

    public GraphicsDraftState(String arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(arg1, "toString(...)");
        }

        this(arg1, false);
    }

    public GraphicsDraftState() {
        this(null, false, 3, null);
    }

    public GraphicsDraftState(String arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "revision");
        super();
        this.revision = arg2;
        this.dirty = arg3;
    }

    public final String component1() {
        return this.revision;
    }

    public final boolean component2() {
        return this.dirty;
    }

    public final GraphicsDraftState confirmed(String arg3) {
        if(Intrinsics.areEqual(arg3, this.revision)) {
            this = GraphicsDraftState.copy$default(this, null, false, 1, null);
        }

        return this;
    }

    public final GraphicsDraftState copy(String arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "revision");
        return new GraphicsDraftState(arg1, arg2);
    }

    public static GraphicsDraftState copy$default(GraphicsDraftState arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.revision;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.dirty;
        }

        return arg0.copy(arg1, arg2);
    }

    public final GraphicsDraftState edited() {
        return new GraphicsDraftState(null, true, 1, null);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsDraftState)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsDraftState)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.revision, ((GraphicsDraftState)arg5).revision)) {
            return 0;
        }

        if(this.dirty != ((GraphicsDraftState)arg5).dirty) {
            return 0;
        }

        return 1;
    }

    public final boolean getDirty() {
        return this.dirty;
    }

    public final String getRevision() {
        return this.revision;
    }

    public int hashCode() {
        return this.revision.hashCode() * 0x1F + Boolean.hashCode(this.dirty);
    }

    public final String notice(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "fallback");
        if(this.dirty) {
            return "CONFIGURACIÓN SOLICITADA · borrador sin guardar ni aplicar";
        }

        return arg2;
    }

    public final String status(String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "notice");
        Intrinsics.checkNotNullParameter(arg3, "operation");
        return this.notice(arg2) + "\n" + arg3;
    }

    public String toString() {
        return "GraphicsDraftState(revision=" + this.revision + ", dirty=" + this.dirty + ")";
    }
}

