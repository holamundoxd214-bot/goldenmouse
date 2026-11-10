package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001A#\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u001A#\u0010\u0006\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0000¢\u0006\u0004\b\u000B\u0010\f\u001A\u001B\u0010\r\u001A\u00020\u000E*\u00020\u00072\u0006\u0010\u000F\u001A\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "findClosestRect", "Landroidx/compose/ui/geometry/Offset;", "rect1", "Landroidx/compose/ui/geometry/Rect;", "rect2", "findClosestRect-9KIMszo", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)I", "distanceSquaredToClosestCornerFromOutside", "", "rect", "distanceSquaredToClosestCornerFromOutside-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)F", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MathUtilsKt {
    public static final int addExactOrElse(int arg1, int arg2, Function0 arg3) {
        int v0 = arg1 + arg2;
        if(((arg1 ^ v0) & (arg2 ^ v0)) < 0) {
            return arg3.invoke().intValue();
        }

        return v0;
    }

    private static final float distanceSquaredToClosestCornerFromOutside-3MmeM6k(long arg3, Rect arg5) {
        if(SelectionManagerKt.containsInclusive-Uv8p0NA(arg5, arg3)) {
            return 0;
        }

        float v0 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(arg5.getTopLeft-F1C5BW0(), arg3));
        float v1 = 3.402823E+38f;
        if(v0 < v1) {
        }
        else {
            v0 = v1;
        }

        v1 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(arg5.getTopRight-F1C5BW0(), arg3));
        if(v1 < v0) {
            v0 = v1;
        }

        v1 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(arg5.getBottomLeft-F1C5BW0(), arg3));
        if(v1 < v0) {
            v0 = v1;
        }

        float v3 = Offset.getDistanceSquared-impl(Offset.minus-MK-Hz9U(arg5.getBottomRight-F1C5BW0(), arg3));
        if(v3 < v0) {
            return v3;
        }

        return v0;
    }

    public static final int findClosestRect-9KIMszo(long arg0, Rect arg2, Rect arg3) {
        int v0 = Float.compare(MathUtilsKt.distanceSquaredToClosestCornerFromOutside-3MmeM6k(arg0, arg2), MathUtilsKt.distanceSquaredToClosestCornerFromOutside-3MmeM6k(arg0, arg3));
        if(v0 == 0) {
            return 0;
        }

        if(v0 < 0) {
            return -1;
        }

        return 1;
    }

    public static final int subtractExactOrElse(int arg1, int arg2, Function0 arg3) {
        int v0 = arg1 - arg2;
        if(((arg1 ^ v0) & (arg2 ^ arg1)) < 0) {
            return arg3.invoke().intValue();
        }

        return v0;
    }
}

