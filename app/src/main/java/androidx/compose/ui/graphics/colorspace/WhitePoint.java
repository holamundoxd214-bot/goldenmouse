package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000B\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bB)\b\u0012\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\nJ\r\u0010\u000E\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0010J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u001B"}, d2={"Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "", "x", "", "y", "<init>", "(FF)V", "z", "(FFF)V", "sum", "(FFFF)V", "getX", "()F", "getY", "toXyz", "", "toXyz$ui_graphics", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WhitePoint {
    public static final int $stable;
    private final float x;
    private final float y;

    static {
    }

    public WhitePoint(float arg2, float arg3, float arg4) {
        this(arg2, arg3, arg4, arg2 + arg3 + arg4);
    }

    public WhitePoint(float arg1, float arg2) {
        super();
        this.x = arg1;
        this.y = arg2;
    }

    private WhitePoint(float arg1, float arg2, float arg3, float arg4) {
        this(arg1 / arg4, arg2 / arg4);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final WhitePoint copy(float arg1, float arg2) {
        return new WhitePoint(arg1, arg2);
    }

    public static WhitePoint copy$default(WhitePoint arg0, float arg1, float arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.x;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.y;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((WhitePoint)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof WhitePoint)) {
            return 0;
        }

        if(Float.compare(this.x, ((WhitePoint)arg5).x) != 0) {
            return 0;
        }

        if(Float.compare(this.y, ((WhitePoint)arg5).y) != 0) {
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
        return "WhitePoint(x=" + this.x + ", y=" + this.y + ')';
    }

    public final float[] toXyz$ui_graphics() {
        return new float[]{this.x / this.y, 1f, (1f - this.x - this.y) / this.y};
    }
}

