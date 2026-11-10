package com.TryJeanPc.goldenmouse.controls;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ.\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "", "x", "", "y", "size", "", "<init>", "(FFLjava/lang/Integer;)V", "getX", "()F", "getY", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(FFLjava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/controls/ComponentPlacement;", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ComponentPlacement {
    public static final int $stable;
    private final Integer size;
    private final float x;
    private final float y;

    static {
    }

    public ComponentPlacement(float arg1, float arg2, Integer arg3) {
        super();
        this.x = arg1;
        this.y = arg2;
        this.size = arg3;
    }

    public ComponentPlacement(float arg1, float arg2, Integer arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final Integer component3() {
        return this.size;
    }

    public final ComponentPlacement copy(float arg1, float arg2, Integer arg3) {
        return new ComponentPlacement(arg1, arg2, arg3);
    }

    public static ComponentPlacement copy$default(ComponentPlacement arg0, float arg1, float arg2, Integer arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.x;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.y;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.size;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((ComponentPlacement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ComponentPlacement)) {
            return 0;
        }

        if(Float.compare(this.x, ((ComponentPlacement)arg5).x) != 0) {
            return 0;
        }

        if(Float.compare(this.y, ((ComponentPlacement)arg5).y) != 0) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.size, ((ComponentPlacement)arg5).size)) {
            return 0;
        }

        return 1;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        int v0 = (Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y)) * 0x1F;
        Integer v2 = this.size;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        return v0 + v2_1;
    }

    public String toString() {
        return "ComponentPlacement(x=" + this.x + ", y=" + this.y + ", size=" + this.size + ")";
    }
}

