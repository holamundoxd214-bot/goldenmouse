package com.TryJeanPc.goldenmouse.cursor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u001D\u001EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005J\u001E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\rJ\u001E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\rJ\u001E\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\bJ\u0016\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u000FJ.\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0019\u001A\u00020\b2\u0006\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u0005¨\u0006\u001F"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorGeometry;", "", "<init>", "()V", "lastPixel", "", "dimension", "imageHotspot", "Lcom/TryJeanPc/goldenmouse/cursor/CursorGeometry$Point;", "intrinsicWidth", "", "intrinsicHeight", "builtIn", "", "imageBounds", "Lcom/TryJeanPc/goldenmouse/cursor/CursorGeometry$Rectangle;", "hotspotBounds", "viewport", "image", "hotspot", "clamp", "point", "limits", "translation", "display", "imageHotspotInView", "hostOrigin", "viewLeft", "viewTop", "Point", "Rectangle", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CursorGeometry {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorGeometry$Point;", "", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Point {
        public static final int $stable;
        private final float x;
        private final float y;

        static {
        }

        public Point(float arg1, float arg2) {
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

        public final Point copy(float arg1, float arg2) {
            return new Point(arg1, arg2);
        }

        public static Point copy$default(Point arg0, float arg1, float arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.x;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.y;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Point)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Point)) {
                return 0;
            }

            if(Float.compare(this.x, ((Point)arg5).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((Point)arg5).y) != 0) {
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
            return "Point(x=" + this.x + ", y=" + this.y + ")";
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorGeometry$Rectangle;", "", "left", "", "top", "right", "bottom", "<init>", "(FFFF)V", "getLeft", "()F", "getTop", "getRight", "getBottom", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Rectangle {
        public static final int $stable;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        static {
        }

        public Rectangle(float arg1, float arg2, float arg3, float arg4) {
            super();
            this.left = arg1;
            this.top = arg2;
            this.right = arg3;
            this.bottom = arg4;
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

        public final Rectangle copy(float arg1, float arg2, float arg3, float arg4) {
            return new Rectangle(arg1, arg2, arg3, arg4);
        }

        public static Rectangle copy$default(Rectangle arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
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

        public boolean equals(Object arg5) {
            if(this == (((Rectangle)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Rectangle)) {
                return 0;
            }

            if(Float.compare(this.left, ((Rectangle)arg5).left) != 0) {
                return 0;
            }

            if(Float.compare(this.top, ((Rectangle)arg5).top) != 0) {
                return 0;
            }

            if(Float.compare(this.right, ((Rectangle)arg5).right) != 0) {
                return 0;
            }

            if(Float.compare(this.bottom, ((Rectangle)arg5).bottom) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getBottom() {
            return this.bottom;
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getTop() {
            return this.top;
        }

        public int hashCode() {
            return ((Float.hashCode(this.left) * 0x1F + Float.hashCode(this.top)) * 0x1F + Float.hashCode(this.right)) * 0x1F + Float.hashCode(this.bottom);
        }

        public String toString() {
            return "Rectangle(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }
    }

    public static final int $stable;
    public static final CursorGeometry INSTANCE;

    static {
        CursorGeometry.INSTANCE = new CursorGeometry();
    }

    private CursorGeometry() {
        super();
    }

    public final Point clamp(Point arg4, Rectangle arg5) {
        Intrinsics.checkNotNullParameter(arg4, "point");
        Intrinsics.checkNotNullParameter(arg5, "limits");
        return new Point(RangesKt.coerceIn(arg4.getX(), arg5.getLeft(), arg5.getRight()), RangesKt.coerceIn(arg4.getY(), arg5.getTop(), arg5.getBottom()));
    }

    public final Rectangle hotspotBounds(Rectangle arg6, Rectangle arg7, Point arg8) {
        Intrinsics.checkNotNullParameter(arg6, "viewport");
        Intrinsics.checkNotNullParameter(arg7, "image");
        Intrinsics.checkNotNullParameter(arg8, "hotspot");
        float v0 = RangesKt.coerceAtLeast(this.lastPixel(arg6.getRight()), arg6.getLeft());
        float v5 = RangesKt.coerceAtLeast(this.lastPixel(arg6.getBottom()), arg6.getTop());
        float v1 = RangesKt.coerceIn(arg6.getLeft() + arg8.getX() - arg7.getLeft(), arg6.getLeft(), v0);
        float v2 = RangesKt.coerceIn(arg6.getTop() + arg8.getY() - arg7.getTop(), arg6.getTop(), v5);
        return new Rectangle(v1, v2, RangesKt.coerceIn(arg6.getRight() + arg8.getX() - arg7.getRight(), v1, v0), RangesKt.coerceIn(arg6.getBottom() + arg8.getY() - arg7.getBottom(), v2, v5));
    }

    public final Rectangle imageBounds(int arg3, int arg4, boolean arg5) {
        if(arg5) {
            float v3 = ((float)arg3);
            float v4 = ((float)arg4);
            return new Rectangle(0.166667f * v3, 0.067692f * v4, v3 * 0.867521f, v4 * 0.932308f);
        }

        return new Rectangle(0f, 0f, ((float)arg3), ((float)arg4));
    }

    public final Point imageHotspot(int arg1, int arg2, boolean arg3) {
        if(arg3) {
            return new Point((((float)arg1)) * 0.166667f, (((float)arg2)) * 0.067692f);
        }

        return new Point(0f, 0f);
    }

    public final float lastPixel(float arg1) {
        return RangesKt.coerceAtLeast(arg1 - 1f, 0f);
    }

    public final Point translation(Point arg3, Point arg4, Point arg5, float arg6, float arg7) {
        Intrinsics.checkNotNullParameter(arg3, "display");
        Intrinsics.checkNotNullParameter(arg4, "imageHotspotInView");
        Intrinsics.checkNotNullParameter(arg5, "hostOrigin");
        return new Point(arg3.getX() - arg5.getX() - arg6 - arg4.getX(), arg3.getY() - arg5.getY() - arg7 - arg4.getY());
    }
}

