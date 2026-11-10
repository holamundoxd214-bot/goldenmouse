package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001A\"\u0010\u000F\u001A\u00020\u0001*\u00020\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001A\'\u0010\u0014\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001A\u001C\u0010\u001A\u001A\u00020\u0001*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0001H\u0087\n¢\u0006\u0004\b\u001D\u0010\u001E\u001A\u001C\u0010\u001A\u001A\u00020\u0001*\u00020\u001F2\u0006\u0010\u001C\u001A\u00020\u0001H\u0087\n¢\u0006\u0004\b\u001D\u0010 \u001A\u001C\u0010\u001A\u001A\u00020\u0001*\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u0001H\u0087\n¢\u0006\u0004\b\u001D\u0010!\u001A\u0013\u0010\"\u001A\u00020#*\u00020\u0001H\u0007¢\u0006\u0004\b$\u0010%\"\u001F\u0010\u0006\u001A\u00020\u0007*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B\"\u001F\u0010\f\u001A\u00020\u0007*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001A\u0004\b\u000E\u0010\u000B\"\u001E\u0010&\u001A\u00020\'*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\t\u001A\u0004\b)\u0010*¨\u0006+"}, d2={"Size", "Landroidx/compose/ui/geometry/Size;", "width", "", "height", "(FF)J", "isSpecified", "", "isSpecified-uvyYCjk$annotations", "(J)V", "isSpecified-uvyYCjk", "(J)Z", "isUnspecified", "isUnspecified-uvyYCjk$annotations", "isUnspecified-uvyYCjk", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-TmRCtEA", "(JLkotlin/jvm/functions/Function0;)J", "lerp", "start", "stop", "fraction", "lerp-VgWVRYQ", "(JJF)J", "times", "", "size", "times-d16Qtg0", "(IJ)J", "", "(DJ)J", "(FJ)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "toRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-uvyYCjk$annotations", "getCenter-uvyYCjk", "(J)J", "ui-geometry"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SizeKt {
    public static final long Size(float arg4, float arg5) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    public static final long getCenter-uvyYCjk(long arg5) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))) / 2f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg5 >> 0x20))) / 2f))) << 0x20);
    }

    public static void getCenter-uvyYCjk$annotations(long arg0) {
    }

    public static final boolean isSpecified-uvyYCjk(long arg2) {
        if(arg2 != 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isSpecified-uvyYCjk$annotations(long arg0) {
    }

    public static final boolean isUnspecified-uvyYCjk(long arg2) {
        if(arg2 == 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isUnspecified-uvyYCjk$annotations(long arg0) {
    }

    public static final long lerp-VgWVRYQ(long arg4, long arg6, float arg8) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg6 >> 0x20))), arg8)))) << 0x20 | (((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))), arg8)))) & 0xFFFFFFFFL);
    }

    public static final long takeOrElse-TmRCtEA(long arg2, Function0 arg4) {
        if(arg2 != 0x7FC000007FC00000L) {
            return arg2;
        }

        return arg4.invoke().unbox-impl();
    }

    public static final long times-d16Qtg0(double arg0, long arg2) {
        return Size.times-7Ah8Wj8(arg2, ((float)arg0));
    }

    public static final long times-d16Qtg0(float arg0, long arg1) {
        return Size.times-7Ah8Wj8(arg1, arg0);
    }

    public static final long times-d16Qtg0(int arg0, long arg1) {
        return Size.times-7Ah8Wj8(arg1, ((float)arg0));
    }

    public static final Rect toRect-uvyYCjk(long arg2) {
        return RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), arg2);
    }
}

