package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u0007\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\rH\u0007¢\u0006\u0004\b\u000E\u0010\u000F\u001A \u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\rH\u0007¨\u0006\u0014"}, d2={"Rect", "Landroidx/compose/ui/geometry/Rect;", "offset", "Landroidx/compose/ui/geometry/Offset;", "size", "Landroidx/compose/ui/geometry/Size;", "Rect-tz77jQw", "(JJ)Landroidx/compose/ui/geometry/Rect;", "topLeft", "bottomRight", "Rect-0a9Yr6o", "center", "radius", "", "Rect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/Rect;", "lerp", "start", "stop", "fraction", "ui-geometry"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RectKt {
    public static final Rect Rect-0a9Yr6o(long arg7, long arg9) {
        return new Rect(Float.intBitsToFloat(((int)(arg7 >> 0x20))), Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg9 >> 0x20))), Float.intBitsToFloat(((int)(arg9 & 0xFFFFFFFFL))));
    }

    public static final Rect Rect-3MmeM6k(long arg5, float arg7) {
        int v1 = ((int)(arg5 >> 0x20));
        int v5 = ((int)(arg5 & 0xFFFFFFFFL));
        return new Rect(Float.intBitsToFloat(v1) - arg7, Float.intBitsToFloat(v5) - arg7, Float.intBitsToFloat(v1) + arg7, Float.intBitsToFloat(v5) + arg7);
    }

    public static final Rect Rect-tz77jQw(long arg8, long arg10) {
        int v2 = ((int)(arg8 >> 0x20));
        int v8 = ((int)(arg8 & 0xFFFFFFFFL));
        return new Rect(Float.intBitsToFloat(v2), Float.intBitsToFloat(v8), Float.intBitsToFloat(v2) + Float.intBitsToFloat(((int)(arg10 >> 0x20))), Float.intBitsToFloat(v8) + Float.intBitsToFloat(((int)(arg10 & 0xFFFFFFFFL))));
    }

    public static final Rect lerp(Rect arg5, Rect arg6, float arg7) {
        return new Rect(MathHelpersKt.lerp(arg5.getLeft(), arg6.getLeft(), arg7), MathHelpersKt.lerp(arg5.getTop(), arg6.getTop(), arg7), MathHelpersKt.lerp(arg5.getRight(), arg6.getRight(), arg7), MathHelpersKt.lerp(arg5.getBottom(), arg6.getBottom(), arg7));
    }
}

