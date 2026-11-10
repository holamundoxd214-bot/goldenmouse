package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsChange;", "", "key", "", "before", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "after", "<init>", "(Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;)V", "getKey", "()Ljava/lang/String;", "getBefore", "()Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "getAfter", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsChange {
    public static final int $stable;
    private final GraphicsValue after;
    private final GraphicsValue before;
    private final String key;

    static {
    }

    public GraphicsChange(String arg2, GraphicsValue arg3, GraphicsValue arg4) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "before");
        Intrinsics.checkNotNullParameter(arg4, "after");
        super();
        this.key = arg2;
        this.before = arg3;
        this.after = arg4;
    }

    public final String component1() {
        return this.key;
    }

    public final GraphicsValue component2() {
        return this.before;
    }

    public final GraphicsValue component3() {
        return this.after;
    }

    public final GraphicsChange copy(String arg1, GraphicsValue arg2, GraphicsValue arg3) {
        Intrinsics.checkNotNullParameter(arg1, "key");
        Intrinsics.checkNotNullParameter(arg2, "before");
        Intrinsics.checkNotNullParameter(arg3, "after");
        return new GraphicsChange(arg1, arg2, arg3);
    }

    public static GraphicsChange copy$default(GraphicsChange arg0, String arg1, GraphicsValue arg2, GraphicsValue arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.key;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.before;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.after;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsChange)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsChange)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.key, ((GraphicsChange)arg5).key)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.before, ((GraphicsChange)arg5).before)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.after, ((GraphicsChange)arg5).after)) {
            return 0;
        }

        return 1;
    }

    public final GraphicsValue getAfter() {
        return this.after;
    }

    public final GraphicsValue getBefore() {
        return this.before;
    }

    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        return (this.key.hashCode() * 0x1F + this.before.hashCode()) * 0x1F + this.after.hashCode();
    }

    public String toString() {
        return "GraphicsChange(key=" + this.key + ", before=" + this.before + ", after=" + this.after + ")";
    }
}

