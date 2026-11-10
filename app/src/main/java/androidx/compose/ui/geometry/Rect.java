package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0001ZB\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010&\u001A\u00020\u00002\u0006\u0010\'\u001A\u00020(H\u0007¢\u0006\u0004\b)\u0010*J\u0018\u0010&\u001A\u00020\u00002\u0006\u0010+\u001A\u00020\u00032\u0006\u0010,\u001A\u00020\u0003H\u0007J\u0010\u0010-\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0003H\u0007J\u0010\u0010/\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0003H\u0007J\u0010\u00100\u001A\u00020\u00002\u0006\u00101\u001A\u00020\u0000H\u0007J(\u00100\u001A\u00020\u00002\u0006\u00102\u001A\u00020\u00032\u0006\u00103\u001A\u00020\u00032\u0006\u00104\u001A\u00020\u00032\u0006\u00105\u001A\u00020\u0003H\u0007J\u000E\u00106\u001A\u00020\u001F2\u0006\u00101\u001A\u00020\u0000J\u0018\u0010M\u001A\u00020\u001F2\u0006\u0010\'\u001A\u00020(H\u0086\u0002¢\u0006\u0004\bN\u0010OJ\b\u0010P\u001A\u00020QH\u0016J\t\u0010R\u001A\u00020\u0003HÆ\u0003J\t\u0010S\u001A\u00020\u0003HÆ\u0003J\t\u0010T\u001A\u00020\u0003HÆ\u0003J\t\u0010U\u001A\u00020\u0003HÆ\u0003J1\u0010V\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010W\u001A\u00020\u001F2\b\u00101\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001A\u00020YHÖ\u0001R\u001C\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\fR\u001C\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\r\u0010\n\u001A\u0004\b\u000E\u0010\fR\u001C\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u000F\u0010\n\u001A\u0004\b\u0010\u0010\fR\u001C\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0011\u0010\n\u001A\u0004\b\u0012\u0010\fR\u001B\u0010\u0013\u001A\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\n\u001A\u0004\b\u0015\u0010\fR\u001B\u0010\u0016\u001A\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\n\u001A\u0004\b\u0018\u0010\fR\u001A\u0010\u0019\u001A\u00020\u001A8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001B\u0010\n\u001A\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u001F8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\n\u001A\u0004\b\u001E\u0010!R\u001A\u0010\"\u001A\u00020\u001F8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\n\u001A\u0004\b\"\u0010!R\u001A\u0010$\u001A\u00020\u001F8FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\n\u001A\u0004\b$\u0010!R\u0011\u00107\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b8\u0010\fR\u0011\u00109\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b:\u0010\fR\u0011\u0010;\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\b<\u0010\u001DR\u0011\u0010=\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\b>\u0010\u001DR\u0011\u0010?\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\b@\u0010\u001DR\u0011\u0010A\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\bB\u0010\u001DR\u0011\u0010C\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\bD\u0010\u001DR\u0011\u0010E\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\bF\u0010\u001DR\u0011\u0010G\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\bH\u0010\u001DR\u0011\u0010I\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\bJ\u0010\u001DR\u0011\u0010K\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\bL\u0010\u001D¨\u0006["}, d2={"Landroidx/compose/ui/geometry/Rect;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft$annotations", "()V", "getLeft", "()F", "getTop$annotations", "getTop", "getRight$annotations", "getRight", "getBottom$annotations", "getBottom", "width", "getWidth$annotations", "getWidth", "height", "getHeight$annotations", "getHeight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc$annotations", "getSize-NH-jbRc", "()J", "isInfinite", "", "isInfinite$annotations", "()Z", "isFinite", "isFinite$annotations", "isEmpty", "isEmpty$annotations", "translate", "offset", "Landroidx/compose/ui/geometry/Offset;", "translate-k-4lQ0M", "(J)Landroidx/compose/ui/geometry/Rect;", "translateX", "translateY", "inflate", "delta", "deflate", "intersect", "other", "otherLeft", "otherTop", "otherRight", "otherBottom", "overlaps", "minDimension", "getMinDimension", "maxDimension", "getMaxDimension", "topLeft", "getTopLeft-F1C5BW0", "topCenter", "getTopCenter-F1C5BW0", "topRight", "getTopRight-F1C5BW0", "centerLeft", "getCenterLeft-F1C5BW0", "center", "getCenter-F1C5BW0", "centerRight", "getCenterRight-F1C5BW0", "bottomLeft", "getBottomLeft-F1C5BW0", "bottomCenter", "getBottomCenter-F1C5BW0", "bottomRight", "getBottomRight-F1C5BW0", "contains", "contains-k-4lQ0M", "(J)Z", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "hashCode", "", "Companion", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Rect {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/geometry/Rect$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/Rect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/Rect;", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Rect getZero() {
            return Rect.Zero;
        }

        public static void getZero$annotations() {
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Rect Zero;
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    static {
        Rect.Companion = new Companion(null);
        Rect.Zero = new Rect(0f, 0f, 0f, 0f);
    }

    public Rect(float arg1, float arg2, float arg3, float arg4) {
        super();
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
    }

    public static final Rect access$getZero$cp() {
        return Rect.Zero;
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    public final boolean contains-k-4lQ0M(long arg5) {
        float v0 = Float.intBitsToFloat(((int)(arg5 >> 0x20)));
        float v5 = Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL)));
        int v1 = 1;
        int v6 = Float.compare(v0, this.left) >= 0 ? 1 : 0;
        int v0_1 = v0 < this.right ? 1 : 0;
        v6 &= v0_1;
        v0_1 = v5 >= this.top ? 1 : 0;
        v6 &= v0_1;
        if(v5 < this.bottom) {
        }
        else {
            v1 = 0;
        }

        return v6 & v1;
    }

    public final Rect copy(float arg1, float arg2, float arg3, float arg4) {
        return new Rect(arg1, arg2, arg3, arg4);
    }

    public static Rect copy$default(Rect arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.left;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.top;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.right;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.bottom;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public final Rect deflate(float arg1) {
        return this.inflate(-arg1);
    }

    public boolean equals(Object arg5) {
        if(this == (((Rect)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Rect)) {
            return 0;
        }

        if(Float.compare(this.left, ((Rect)arg5).left) != 0) {
            return 0;
        }

        if(Float.compare(this.top, ((Rect)arg5).top) != 0) {
            return 0;
        }

        if(Float.compare(this.right, ((Rect)arg5).right) != 0) {
            return 0;
        }

        if(Float.compare(this.bottom, ((Rect)arg5).bottom) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public static void getBottom$annotations() {
    }

    public final long getBottomCenter-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.left + (this.getRight() - this.getLeft()) / 2f))) << 0x20 | (((long)Float.floatToRawIntBits(this.bottom))) & 0xFFFFFFFFL);
    }

    public final long getBottomLeft-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.left))) << 0x20 | (((long)Float.floatToRawIntBits(this.bottom))) & 0xFFFFFFFFL);
    }

    public final long getBottomRight-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.right))) << 0x20 | (((long)Float.floatToRawIntBits(this.bottom))) & 0xFFFFFFFFL);
    }

    public final long getCenter-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.top + (this.getBottom() - this.getTop()) / 2f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.left + (this.getRight() - this.getLeft()) / 2f))) << 0x20);
    }

    public final long getCenterLeft-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.top + (this.getBottom() - this.getTop()) / 2f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.left))) << 0x20);
    }

    public final long getCenterRight-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.top + (this.getBottom() - this.getTop()) / 2f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.right))) << 0x20);
    }

    public final float getHeight() {
        return this.getBottom() - this.getTop();
    }

    public static void getHeight$annotations() {
    }

    public final float getLeft() {
        return this.left;
    }

    public static void getLeft$annotations() {
    }

    public final float getMaxDimension() {
        return Math.max(Math.abs(this.getRight() - this.getLeft()), Math.abs(this.getBottom() - this.getTop()));
    }

    public final float getMinDimension() {
        return Math.min(Math.abs(this.getRight() - this.getLeft()), Math.abs(this.getBottom() - this.getTop()));
    }

    public final float getRight() {
        return this.right;
    }

    public static void getRight$annotations() {
    }

    public final long getSize-NH-jbRc() {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(this.getBottom() - this.getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.getRight() - this.getLeft()))) << 0x20);
    }

    public static void getSize-NH-jbRc$annotations() {
    }

    public final float getTop() {
        return this.top;
    }

    public static void getTop$annotations() {
    }

    public final long getTopCenter-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.left + (this.getRight() - this.getLeft()) / 2f))) << 0x20 | (((long)Float.floatToRawIntBits(this.top))) & 0xFFFFFFFFL);
    }

    public final long getTopLeft-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.left))) << 0x20 | (((long)Float.floatToRawIntBits(this.top))) & 0xFFFFFFFFL);
    }

    public final long getTopRight-F1C5BW0() {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(this.right))) << 0x20 | (((long)Float.floatToRawIntBits(this.top))) & 0xFFFFFFFFL);
    }

    public final float getWidth() {
        return this.getRight() - this.getLeft();
    }

    public static void getWidth$annotations() {
    }

    public int hashCode() {
        return ((Float.hashCode(this.left) * 0x1F + Float.hashCode(this.top)) * 0x1F + Float.hashCode(this.right)) * 0x1F + Float.hashCode(this.bottom);
    }

    public final Rect inflate(float arg5) {
        return new Rect(this.left - arg5, this.top - arg5, this.right + arg5, this.bottom + arg5);
    }

    public final Rect intersect(Rect arg6) {
        return new Rect(Math.max(this.left, arg6.left), Math.max(this.top, arg6.top), Math.min(this.right, arg6.right), Math.min(this.bottom, arg6.bottom));
    }

    public final Rect intersect(float arg3, float arg4, float arg5, float arg6) {
        return new Rect(Math.max(this.left, arg3), Math.max(this.top, arg4), Math.min(this.right, arg5), Math.min(this.bottom, arg6));
    }

    public final boolean isEmpty() {
        int v1 = 1;
        int v0 = Float.compare(this.left, this.right) >= 0 ? 1 : 0;
        if(this.top >= this.bottom) {
        }
        else {
            v1 = 0;
        }

        return v0 | v1;
    }

    public static void isEmpty$annotations() {
    }

    public final boolean isFinite() {
        int v1 = 0x7FFFFFFF;
        int v2 = 1;
        int v4 = 0x7F800000;
        int v0 = (Float.floatToRawIntBits(this.left) & v1) < v4 ? 1 : 0;
        int v5 = (Float.floatToRawIntBits(this.top) & v1) < v4 ? 1 : 0;
        v0 &= v5;
        v5 = (Float.floatToRawIntBits(this.right) & v1) < v4 ? 1 : 0;
        v0 &= v5;
        if((Float.floatToRawIntBits(this.bottom) & v1) < v4) {
        }
        else {
            v2 = 0;
        }

        return v0 & v2;
    }

    public static void isFinite$annotations() {
    }

    public final boolean isInfinite() {
        float v1 = Infinityf;
        int v2 = 1;
        int v0 = Float.compare(this.left, v1) == 0 ? 1 : 0;
        int v4 = this.top == v1 ? 1 : 0;
        v0 |= v4;
        v4 = this.right == v1 ? 1 : 0;
        v0 |= v4;
        if(this.bottom == v1) {
        }
        else {
            v2 = 0;
        }

        return v0 | v2;
    }

    public static void isInfinite$annotations() {
    }

    public final boolean overlaps(Rect arg6) {
        int v1 = 1;
        int v0 = Float.compare(this.left, arg6.right) < 0 ? 1 : 0;
        int v3 = arg6.left < this.right ? 1 : 0;
        v0 &= v3;
        v3 = this.top < arg6.bottom ? 1 : 0;
        v0 &= v3;
        if(arg6.top < this.bottom) {
        }
        else {
            v1 = 0;
        }

        return v0 & v1;
    }

    public String toString() {
        return "Rect.fromLTRB(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    public final Rect translate(float arg5, float arg6) {
        return new Rect(this.left + arg5, this.top + arg6, this.right + arg5, this.bottom + arg6);
    }

    public final Rect translate-k-4lQ0M(long arg7) {
        int v2 = ((int)(arg7 >> 0x20));
        int v7 = ((int)(arg7 & 0xFFFFFFFFL));
        return new Rect(this.left + Float.intBitsToFloat(v2), this.top + Float.intBitsToFloat(v7), this.right + Float.intBitsToFloat(v2), this.bottom + Float.intBitsToFloat(v7));
    }
}

