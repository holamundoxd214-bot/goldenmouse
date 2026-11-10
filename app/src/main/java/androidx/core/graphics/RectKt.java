package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region$Op;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0004\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0005\u001A\u00020\u0001*\u00020\u0002H\u0086\n\u001A\r\u0010\u0000\u001A\u00020\u0006*\u00020\u0007H\u0086\n\u001A\r\u0010\u0003\u001A\u00020\u0006*\u00020\u0007H\u0086\n\u001A\r\u0010\u0004\u001A\u00020\u0006*\u00020\u0007H\u0086\n\u001A\r\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001A\u00020\u0006H\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001A\u00020\u000BH\u0086\n\u001A\u0015\u0010\b\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001A\u00020\fH\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u000E*\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001A\u00020\u0006H\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001A\u00020\u000BH\u0086\n\u001A\u0015\u0010\r\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001A\u00020\fH\u0086\n\u001A\u0015\u0010\u000F\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\u000F\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0001H\u0086\n\u001A\u0015\u0010\u000F\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0006H\u0086\n\u001A\u0015\u0010\u0011\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0086\f\u001A\u0015\u0010\u0011\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0086\f\u001A\u0015\u0010\u0012\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0087\f\u001A\u0015\u0010\u0012\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0087\f\u001A\u0015\u0010\u0013\u001A\u00020\u000E*\u00020\u00022\u0006\u0010\t\u001A\u00020\u0002H\u0086\f\u001A\u0015\u0010\u0013\u001A\u00020\u000E*\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0086\f\u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u000BH\u0086\n\u001A\u0015\u0010\u0014\u001A\u00020\u0015*\u00020\u00072\u0006\u0010\u0016\u001A\u00020\fH\u0086\n\u001A\r\u0010\u0017\u001A\u00020\u0007*\u00020\u0002H\u0086\b\u001A\r\u0010\u0018\u001A\u00020\u0002*\u00020\u0007H\u0086\b\u001A\r\u0010\u0019\u001A\u00020\u000E*\u00020\u0002H\u0086\b\u001A\r\u0010\u0019\u001A\u00020\u000E*\u00020\u0007H\u0086\b\u001A\u0015\u0010\u001A\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001B\u001A\u00020\u001CH\u0086\b¨\u0006\u001D"}, d2={"component1", "", "Landroid/graphics/Rect;", "component2", "component3", "component4", "", "Landroid/graphics/RectF;", "plus", "r", "xy", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "Landroid/graphics/Region;", "times", "factor", "or", "and", "xor", "contains", "", "p", "toRectF", "toRect", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RectKt {
    public static final Rect and(Rect arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Rect v0 = new Rect(arg1);
        v0.intersect(arg2);
        return v0;
    }

    public static final RectF and(RectF arg1, RectF arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        RectF v0 = new RectF(arg1);
        v0.intersect(arg2);
        return v0;
    }

    public static final float component1(RectF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.left;
    }

    public static final int component1(Rect arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.left;
    }

    public static final float component2(RectF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.top;
    }

    public static final int component2(Rect arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.top;
    }

    public static final float component3(RectF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.right;
    }

    public static final int component3(Rect arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.right;
    }

    public static final float component4(RectF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.bottom;
    }

    public static final int component4(Rect arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.bottom;
    }

    public static final boolean contains(Rect arg1, Point arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "p");
        return arg1.contains(arg2.x, arg2.y);
    }

    public static final boolean contains(RectF arg1, PointF arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "p");
        return arg1.contains(arg2.x, arg2.y);
    }

    public static final Rect minus(Rect arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Rect v0 = new Rect(arg1);
        int v1 = -arg2;
        v0.offset(v1, v1);
        return v0;
    }

    public static final Rect minus(Rect arg1, Point arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "xy");
        Rect v0 = new Rect(arg1);
        v0.offset(-arg2.x, -arg2.y);
        return v0;
    }

    public static final RectF minus(RectF arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        RectF v0 = new RectF(arg1);
        float v1 = -arg2;
        v0.offset(v1, v1);
        return v0;
    }

    public static final RectF minus(RectF arg1, PointF arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "xy");
        RectF v0 = new RectF(arg1);
        v0.offset(-arg2.x, -arg2.y);
        return v0;
    }

    public static final Region minus(Rect arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.DIFFERENCE);
        return v0;
    }

    public static final Region minus(RectF arg2, RectF arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "r");
        Rect v1 = new Rect();
        arg2.roundOut(v1);
        Region v0 = new Region(v1);
        Rect v2 = new Rect();
        arg3.roundOut(v2);
        v0.op(v2, Region$Op.DIFFERENCE);
        return v0;
    }

    public static final Rect or(Rect arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Rect v0 = new Rect(arg1);
        v0.union(arg2);
        return v0;
    }

    public static final RectF or(RectF arg1, RectF arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        RectF v0 = new RectF(arg1);
        v0.union(arg2);
        return v0;
    }

    public static final Rect plus(Rect arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Rect v0 = new Rect(arg1);
        v0.offset(arg2, arg2);
        return v0;
    }

    public static final Rect plus(Rect arg1, Point arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "xy");
        Rect v0 = new Rect(arg1);
        v0.offset(arg2.x, arg2.y);
        return v0;
    }

    public static final Rect plus(Rect arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Rect v0 = new Rect(arg1);
        v0.union(arg2);
        return v0;
    }

    public static final RectF plus(RectF arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        RectF v0 = new RectF(arg1);
        v0.offset(arg2, arg2);
        return v0;
    }

    public static final RectF plus(RectF arg1, PointF arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "xy");
        RectF v0 = new RectF(arg1);
        v0.offset(arg2.x, arg2.y);
        return v0;
    }

    public static final RectF plus(RectF arg1, RectF arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        RectF v0 = new RectF(arg1);
        v0.union(arg2);
        return v0;
    }

    public static final Rect times(Rect arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Rect v0 = new Rect(arg1);
        v0.top *= arg2;
        v0.left *= arg2;
        v0.right *= arg2;
        v0.bottom *= arg2;
        return v0;
    }

    public static final RectF times(RectF arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        RectF v0 = new RectF(arg1);
        v0.top *= arg2;
        v0.left *= arg2;
        v0.right *= arg2;
        v0.bottom *= arg2;
        return v0;
    }

    public static final RectF times(RectF arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        float v2 = ((float)arg2);
        RectF v0 = new RectF(arg1);
        v0.top *= v2;
        v0.left *= v2;
        v0.right *= v2;
        v0.bottom *= v2;
        return v0;
    }

    public static final Rect toRect(RectF arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Rect v0 = new Rect();
        arg1.roundOut(v0);
        return v0;
    }

    public static final RectF toRectF(Rect arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new RectF(arg1);
    }

    public static final Region toRegion(Rect arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new Region(arg1);
    }

    public static final Region toRegion(RectF arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Rect v1 = new Rect();
        arg2.roundOut(v1);
        return new Region(v1);
    }

    public static final RectF transform(RectF arg1, Matrix arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "m");
        arg2.mapRect(arg1);
        return arg1;
    }

    public static final Region xor(Rect arg1, Rect arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "r");
        Region v0 = new Region(arg1);
        v0.op(arg2, Region$Op.XOR);
        return v0;
    }

    public static final Region xor(RectF arg2, RectF arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "r");
        Rect v1 = new Rect();
        arg2.roundOut(v1);
        Region v0 = new Region(v1);
        Rect v2 = new Rect();
        arg3.roundOut(v2);
        v0.op(v2, Region$Op.XOR);
        return v0;
    }
}

