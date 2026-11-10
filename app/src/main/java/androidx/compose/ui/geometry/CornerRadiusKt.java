package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001A\'\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CornerRadiusKt {
    public static final long CornerRadius(float arg4, float arg5) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    public static long CornerRadius$default(float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg3 = arg2;
        }

        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(arg3))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg2))) << 0x20);
    }

    public static final long lerp-3Ry4LBc(long arg4, long arg6, float arg8) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg6 >> 0x20))), arg8)))) << 0x20 | (((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))), arg8)))) & 0xFFFFFFFFL);
    }
}

