package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0000\u001A\u00020\u0004*\u00020\u0005H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0004*\u00020\u0005H\u0086\n\u001A\u0015\u0010\u0006\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0002H\u0086\n\u001A\u0015\u0010\u0006\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0005H\u0086\n\u001A\u0015\u0010\u0006\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\u0006\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001A\u00020\u0004H\u0086\n\u001A\u0015\u0010\t\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0002H\u0086\n\u001A\u0015\u0010\t\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0005H\u0086\n\u001A\u0015\u0010\t\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\t\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001A\u00020\u0004H\u0086\n\u001A\r\u0010\n\u001A\u00020\u0002*\u00020\u0002H\u0086\n\u001A\r\u0010\n\u001A\u00020\u0005*\u00020\u0005H\u0086\n\u001A\u0015\u0010\u000B\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001A\u00020\u0004H\u0086\n\u001A\u0015\u0010\u000B\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001A\u00020\u0004H\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001A\u00020\u0004H\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001A\u00020\u0004H\u0086\n\u001A\r\u0010\u000E\u001A\u00020\u0005*\u00020\u0002H\u0086\b\u001A\r\u0010\u000F\u001A\u00020\u0002*\u00020\u0005H\u0086\b¨\u0006\u0010"}, d2={"component1", "", "Landroid/graphics/Point;", "component2", "", "Landroid/graphics/PointF;", "plus", "p", "xy", "minus", "unaryMinus", "times", "scalar", "div", "toPointF", "toPoint", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PointKt {
    public static final float component1(PointF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.x;
    }

    public static final int component1(Point arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.x;
    }

    public static final float component2(PointF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.y;
    }

    public static final int component2(Point arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.y;
    }

    public static final Point div(Point arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new Point(Math.round((((float)arg2.x)) / arg3), Math.round((((float)arg2.y)) / arg3));
    }

    public static final PointF div(PointF arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new PointF(arg2.x / arg3, arg2.y / arg3);
    }

    public static final Point minus(Point arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Point v0 = new Point(arg2.x, arg2.y);
        int v2 = -arg3;
        v0.offset(v2, v2);
        return v0;
    }

    public static final Point minus(Point arg2, Point arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "p");
        Point v0 = new Point(arg2.x, arg2.y);
        v0.offset(-arg3.x, -arg3.y);
        return v0;
    }

    public static final PointF minus(PointF arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        PointF v0 = new PointF(arg2.x, arg2.y);
        float v2 = -arg3;
        v0.offset(v2, v2);
        return v0;
    }

    public static final PointF minus(PointF arg2, PointF arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "p");
        PointF v0 = new PointF(arg2.x, arg2.y);
        v0.offset(-arg3.x, -arg3.y);
        return v0;
    }

    public static final Point plus(Point arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Point v0 = new Point(arg2.x, arg2.y);
        v0.offset(arg3, arg3);
        return v0;
    }

    public static final Point plus(Point arg2, Point arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "p");
        Point v0 = new Point(arg2.x, arg2.y);
        v0.offset(arg3.x, arg3.y);
        return v0;
    }

    public static final PointF plus(PointF arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        PointF v0 = new PointF(arg2.x, arg2.y);
        v0.offset(arg3, arg3);
        return v0;
    }

    public static final PointF plus(PointF arg2, PointF arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "p");
        PointF v0 = new PointF(arg2.x, arg2.y);
        v0.offset(arg3.x, arg3.y);
        return v0;
    }

    public static final Point times(Point arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new Point(Math.round((((float)arg2.x)) * arg3), Math.round((((float)arg2.y)) * arg3));
    }

    public static final PointF times(PointF arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new PointF(arg2.x * arg3, arg2.y * arg3);
    }

    public static final Point toPoint(PointF arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new Point(((int)arg2.x), ((int)arg2.y));
    }

    public static final PointF toPointF(Point arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new PointF(arg1);
    }

    public static final Point unaryMinus(Point arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new Point(-arg2.x, -arg2.y);
    }

    public static final PointF unaryMinus(PointF arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new PointF(-arg2.x, -arg2.y);
    }
}

