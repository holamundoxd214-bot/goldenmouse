package com.TryJeanPc.goldenmouse.macro.editor;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroPoint;", "", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroPoint {
    public static final int $stable;
    private final float x;
    private final float y;

    static {
    }

    public MacroPoint(float arg1, float arg2) {
        super();
        this.x = arg1;
        this.y = arg2;
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final MacroPoint copy(float arg1, float arg2) {
        return new MacroPoint(arg1, arg2);
    }

    public static MacroPoint copy$default(MacroPoint arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.x;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.y;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((MacroPoint)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MacroPoint)) {
            return 0;
        }

        if(Float.compare(this.x, ((MacroPoint)arg5).x) != 0) {
            return 0;
        }

        if(Float.compare(this.y, ((MacroPoint)arg5).y) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.hashCode(this.x) * 0x1F + Float.hashCode(this.y);
    }

    public String toString() {
        return "MacroPoint(x=" + this.x + ", y=" + this.y + ")";
    }
}

