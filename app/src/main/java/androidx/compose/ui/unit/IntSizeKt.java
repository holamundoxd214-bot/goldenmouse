package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001A\u001C\u0010\u0006\u001A\u00020\u0001*\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0001H\u0087\n¢\u0006\u0004\b\b\u0010\t\u001A\u0013\u0010\n\u001A\u00020\u000B*\u00020\u0001H\u0007¢\u0006\u0004\b\f\u0010\r\u001A\u0013\u0010\u0014\u001A\u00020\u0015*\u00020\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0013\u001A\u0013\u0010\u0017\u001A\u00020\u0001*\u00020\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0013\u001A\u0013\u0010\u0019\u001A\u00020\u0001*\u00020\u0015H\u0007¢\u0006\u0004\b\u001A\u0010\u0013\"\u001E\u0010\u000E\u001A\u00020\u000F*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001B"}, d2={"IntSize", "Landroidx/compose/ui/unit/IntSize;", "width", "", "height", "(II)J", "times", "size", "times-O0kMr_c", "(IJ)J", "toIntRect", "Landroidx/compose/ui/unit/IntRect;", "toIntRect-ozmzZPI", "(J)Landroidx/compose/ui/unit/IntRect;", "center", "Landroidx/compose/ui/unit/IntOffset;", "getCenter-ozmzZPI$annotations", "(J)V", "getCenter-ozmzZPI", "(J)J", "toSize", "Landroidx/compose/ui/geometry/Size;", "toSize-ozmzZPI", "toIntSize", "toIntSize-uvyYCjk", "roundToIntSize", "roundToIntSize-uvyYCjk", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IntSizeKt {
    public static final long IntSize(int arg4, int arg5) {
        return IntSize.constructor-impl((((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20);
    }

    public static final long getCenter-ozmzZPI(long arg5) {
        return IntOffset.constructor-impl(arg5 << 0x20 >> 33 & 0xFFFFFFFFL | arg5 >> 33 << 0x20);
    }

    public static void getCenter-ozmzZPI$annotations(long arg0) {
    }

    public static final long roundToIntSize-uvyYCjk(long arg6) {
        return IntSize.constructor-impl((((long)Math.round(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | (((long)Math.round(Float.intBitsToFloat(((int)(arg6 >> 0x20)))))) << 0x20);
    }

    public static final long times-O0kMr_c(int arg0, long arg1) {
        return IntSize.times-YEO4UFw(arg1, arg0);
    }

    public static final IntRect toIntRect-ozmzZPI(long arg2) {
        return IntRectKt.IntRect-VbeCjmY(IntOffset.Companion.getZero-nOcc-ac(), arg2);
    }

    public static final long toIntSize-uvyYCjk(long arg6) {
        return IntSize.constructor-impl((((long)(((int)Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)(((int)Float.intBitsToFloat(((int)(arg6 >> 0x20))))))) << 0x20);
    }

    public static final long toSize-ozmzZPI(long arg6) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(arg6 & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(((int)(arg6 >> 0x20))))))) << 0x20);
    }
}

