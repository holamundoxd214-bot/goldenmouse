package androidx.compose.ui.geometry;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\u001D\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001A\u001D\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005¢\u0006\u0004\b\f\u0010\t\u001A\u001D\u0010\u0003\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/MutableRect;", "MutableRect", "offset", "Landroidx/compose/ui/geometry/Offset;", "size", "Landroidx/compose/ui/geometry/Size;", "MutableRect-tz77jQw", "(JJ)Landroidx/compose/ui/geometry/MutableRect;", "topLeft", "bottomRight", "MutableRect-0a9Yr6o", "center", "radius", "", "MutableRect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/MutableRect;", "ui-geometry"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MutableRectKt {
    public static final MutableRect MutableRect-0a9Yr6o(long arg7, long arg9) {
        return new MutableRect(Float.intBitsToFloat(((int)(arg7 >> 0x20))), Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg9 >> 0x20))), Float.intBitsToFloat(((int)(arg9 & 0xFFFFFFFFL))));
    }

    public static final MutableRect MutableRect-3MmeM6k(long arg5, float arg7) {
        int v1 = ((int)(arg5 >> 0x20));
        int v5 = ((int)(arg5 & 0xFFFFFFFFL));
        return new MutableRect(Float.intBitsToFloat(v1) - arg7, Float.intBitsToFloat(v5) - arg7, Float.intBitsToFloat(v1) + arg7, Float.intBitsToFloat(v5) + arg7);
    }

    public static final MutableRect MutableRect-tz77jQw(long arg8, long arg10) {
        int v2 = ((int)(arg8 >> 0x20));
        int v8 = ((int)(arg8 & 0xFFFFFFFFL));
        return new MutableRect(Float.intBitsToFloat(v2), Float.intBitsToFloat(v8), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg10 >> 0x20))), Float.intBitsToFloat(v8) + Float.intBitsToFloat(((int)(arg10 & 0xFFFFFFFFL))));
    }

    public static final Rect toRect(MutableRect arg4) {
        return new Rect(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
    }
}

