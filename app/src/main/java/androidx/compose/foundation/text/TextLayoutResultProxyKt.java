package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextLayoutResultProxyKt {
    public static final long access$coerceIn-3MmeM6k(long arg0, Rect arg2) {
        return TextLayoutResultProxyKt.coerceIn-3MmeM6k(arg0, arg2);
    }

    private static final long coerceIn-3MmeM6k(long arg6, Rect arg8) {
        float v6_1;
        float v1_1;
        int v0 = 0x20;
        int v1 = ((int)(arg6 >> v0));
        if(Float.intBitsToFloat(v1) < arg8.getLeft()) {
            v1_1 = arg8.getLeft();
        }
        else if(Float.intBitsToFloat(v1) > arg8.getRight()) {
            v1_1 = arg8.getRight();
        }
        else {
            v1_1 = Float.intBitsToFloat(v1);
        }

        long v2 = 0xFFFFFFFFL;
        int v6 = ((int)(arg6 & v2));
        if(Float.intBitsToFloat(v6) < arg8.getTop()) {
            v6_1 = arg8.getTop();
        }
        else if(Float.intBitsToFloat(v6) > arg8.getBottom()) {
            v6_1 = arg8.getBottom();
        }
        else {
            v6_1 = Float.intBitsToFloat(v6);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(v1_1))) << v0 | (((long)Float.floatToRawIntBits(v6_1))) & v2);
    }
}

