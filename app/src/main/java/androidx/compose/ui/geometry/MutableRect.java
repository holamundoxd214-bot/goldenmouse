package androidx.compose.ui.geometry;

import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#¢\u0006\u0004\b$\u0010%J\u0016\u0010 \u001A\u00020!2\u0006\u0010&\u001A\u00020\u00032\u0006\u0010\'\u001A\u00020\u0003J\u000E\u0010(\u001A\u00020!2\u0006\u0010)\u001A\u00020\u0003J\u000E\u0010*\u001A\u00020!2\u0006\u0010)\u001A\u00020\u0003J&\u0010+\u001A\u00020!2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003J\u000E\u0010,\u001A\u00020\u001C2\u0006\u0010-\u001A\u00020.J\u000E\u0010,\u001A\u00020\u001C2\u0006\u0010-\u001A\u00020\u0000J\u0018\u0010E\u001A\u00020\u001C2\u0006\u0010\"\u001A\u00020#H\u0086\u0002¢\u0006\u0004\bF\u0010GJ&\u0010H\u001A\u00020!2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003J\b\u0010I\u001A\u00020JH\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\n\"\u0004\b\u000E\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\n\"\u0004\b\u0010\u0010\fR\u001A\u0010\u0006\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u0012\u0010\u0013\u001A\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0014\u0010\nR\u0012\u0010\u0015\u001A\u00020\u00038Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001A\u00020\u00188F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u001B\u001A\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001DR\u0011\u0010\u001E\u001A\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001DR\u0011\u0010\u001F\u001A\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001DR\u0011\u0010/\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b0\u0010\nR\u0011\u00101\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b2\u0010\nR\u0011\u00103\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b4\u0010\u001AR\u0011\u00105\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b6\u0010\u001AR\u0011\u00107\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b8\u0010\u001AR\u0011\u00109\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b:\u0010\u001AR\u0011\u0010;\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b<\u0010\u001AR\u0011\u0010=\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b>\u0010\u001AR\u0011\u0010?\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b@\u0010\u001AR\u0011\u0010A\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\bB\u0010\u001AR\u0011\u0010C\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\bD\u0010\u001A¨\u0006K"}, d2={"Landroidx/compose/ui/geometry/MutableRect;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft", "()F", "setLeft", "(F)V", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "width", "getWidth", "height", "getHeight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "isInfinite", "", "()Z", "isFinite", "isEmpty", "translate", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "translate-k-4lQ0M", "(J)V", "translateX", "translateY", "inflate", "delta", "deflate", "intersect", "overlaps", "other", "Landroidx/compose/ui/geometry/Rect;", "minDimension", "getMinDimension", "maxDimension", "getMaxDimension", "topLeft", "getTopLeft-F1C5BW0", "topCenter", "getTopCenter-F1C5BW0", "topRight", "getTopRight-F1C5BW0", "centerLeft", "getCenterLeft-F1C5BW0", "center", "getCenter-F1C5BW0", "centerRight", "getCenterRight-F1C5BW0", "bottomLeft", "getBottomLeft-F1C5BW0", "bottomCenter", "getBottomCenter-F1C5BW0", "bottomRight", "getBottomRight-F1C5BW0", "contains", "contains-k-4lQ0M", "(J)Z", "set", "toString", "", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MutableRect {
    public static final int $stable = 8;
    private float bottom;
    private float left;
    private float right;
    private float top;

    static {
    }

    public MutableRect(float arg1, float arg2, float arg3, float arg4) {
        super();
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
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

    public final void deflate(float arg1) {
        this.inflate(-arg1);
    }

    public final float getBottom() {
        return this.bottom;
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

    public final float getLeft() {
        return this.left;
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

    public final long getSize-NH-jbRc() {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(this.getBottom() - this.getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.getRight() - this.getLeft()))) << 0x20);
    }

    public final float getTop() {
        return this.top;
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

    public final void inflate(float arg2) {
        this.left -= arg2;
        this.top -= arg2;
        this.right += arg2;
        this.bottom += arg2;
    }

    public final void intersect(float arg2, float arg3, float arg4, float arg5) {
        this.left = Math.max(arg2, this.left);
        this.top = Math.max(arg3, this.top);
        this.right = Math.min(arg4, this.right);
        this.bottom = Math.min(arg5, this.bottom);
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

    public final boolean overlaps(MutableRect arg4) {
        if(Float.compare(this.right, arg4.left) > 0) {
            if(arg4.right <= this.left) {
            }
            else if(this.bottom > arg4.top) {
                if(arg4.bottom <= this.top) {
                }
                else {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final boolean overlaps(Rect arg6) {
        int v1 = 1;
        int v0 = Float.compare(this.left, arg6.getRight()) < 0 ? 1 : 0;
        int v3 = arg6.getLeft() < this.right ? 1 : 0;
        v0 &= v3;
        v3 = this.top < arg6.getBottom() ? 1 : 0;
        v0 &= v3;
        if(arg6.getTop() < this.bottom) {
        }
        else {
            v1 = 0;
        }

        return v0 & v1;
    }

    public final void set(float arg1, float arg2, float arg3, float arg4) {
        this.left = arg1;
        this.top = arg2;
        this.right = arg3;
        this.bottom = arg4;
    }

    public final void setBottom(float arg1) {
        this.bottom = arg1;
    }

    public final void setLeft(float arg1) {
        this.left = arg1;
    }

    public final void setRight(float arg1) {
        this.right = arg1;
    }

    public final void setTop(float arg1) {
        this.top = arg1;
    }

    public String toString() {
        return "MutableRect(" + GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1) + ')';
    }

    public final void translate(float arg2, float arg3) {
        this.left += arg2;
        this.top += arg3;
        this.right += arg2;
        this.bottom += arg3;
    }

    public final void translate-k-4lQ0M(long arg4) {
        this.translate(Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))));
    }
}

