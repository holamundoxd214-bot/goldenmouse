package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001A\'\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0004\b\u000B\u0010\f\u001A\u0014\u0010\r\u001A\u00020\u000E*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u000F\u0010\u0010\u001A\u001C\u0010\u0011\u001A\u00020\u000E*\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001C\u0010\u0015\u001A\u00020\u000E*\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001A\u001C\u0010\u0011\u001A\u00020\u000E*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u000EH\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001A\u001C\u0010\u0015\u001A\u00020\u000E*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u000EH\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0014\u001A\u0013\u0010\u0019\u001A\u00020\u0001*\u00020\u000EH\u0007¢\u0006\u0004\b\u001A\u0010\u0010¨\u0006\u001B"}, d2={"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "toOffset--gyyYBs", "(J)J", "plus", "offset", "plus-Nv-tHpc", "(JJ)J", "minus", "minus-Nv-tHpc", "plus-oCl6YwE", "minus-oCl6YwE", "round", "round-k-4lQ0M", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IntOffsetKt {
    public static final long IntOffset(int arg4, int arg5) {
        return IntOffset.constructor-impl((((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20);
    }

    public static final long lerp-81ZRxRo(long arg2, long arg4, float arg6) {
        return IntOffset.constructor-impl((((long)MathHelpersKt.lerp(IntOffset.getX-impl(arg2), IntOffset.getX-impl(arg4), arg6))) << 0x20 | (((long)MathHelpersKt.lerp(IntOffset.getY-impl(arg2), IntOffset.getY-impl(arg4), arg6))) & 0xFFFFFFFFL);
    }

    public static final long minus-Nv-tHpc(long arg6, long arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) - (((float)IntOffset.getX-impl(arg8)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) - (((float)IntOffset.getY-impl(arg8)))))) & 0xFFFFFFFFL);
    }

    public static final long minus-oCl6YwE(long arg6, long arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)IntOffset.getX-impl(arg6))) - Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits((((float)IntOffset.getY-impl(arg6))) - Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long plus-Nv-tHpc(long arg6, long arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) + (((float)IntOffset.getX-impl(arg8)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) + (((float)IntOffset.getY-impl(arg8)))))) & 0xFFFFFFFFL);
    }

    public static final long plus-oCl6YwE(long arg6, long arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)IntOffset.getX-impl(arg6))) + Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits((((float)IntOffset.getY-impl(arg6))) + Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long round-k-4lQ0M(long arg6) {
        return IntOffset.constructor-impl((((long)Math.round(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)Math.round(Float.intBitsToFloat(((int)(arg6 >> 0x20)))))) << 0x20);
    }

    public static final long toOffset--gyyYBs(long arg4) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)IntOffset.getY-impl(arg4))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)IntOffset.getX-impl(arg4))))) << 0x20);
    }
}

