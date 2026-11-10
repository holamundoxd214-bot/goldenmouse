package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001A\"\u0010\u000F\u001A\u00020\u0001*\u00020\u00012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001A\u001C\u0010\u0014\u001A\u00020\u0015*\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001A\u001C\u0010\u0014\u001A\u00020\u0015*\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u0015H\u0087\u0002¢\u0006\u0004\b\u001A\u0010\u0018\u001A\u001C\u0010\u001B\u001A\u00020\u0015*\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0001H\u0087\u0002¢\u0006\u0004\b\u001C\u0010\u0018\u001A\'\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\u00012\u0006\u0010\u001F\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\u0003H\u0007¢\u0006\u0004\b!\u0010\"\"\u001F\u0010\u0006\u001A\u00020\u0007*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B\"\u001F\u0010\f\u001A\u00020\u0007*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001A\u0004\b\u000E\u0010\u000B¨\u0006#"}, d2={"ScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "scaleX", "", "scaleY", "(FF)J", "isSpecified", "", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "times-UQTWf7w", "(JJ)J", "size", "times-m-w2e94", "div", "div-UQTWf7w", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScaleFactorKt {
    public static final long ScaleFactor(float arg4, float arg5) {
        return ScaleFactor.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    public static final long div-UQTWf7w(long arg6, long arg8) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) / Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final boolean isSpecified-FK8aYYs(long arg2) {
        if(arg2 != ScaleFactor.Companion.getUnspecified-_hLwfpc()) {
            return 1;
        }

        return 0;
    }

    public static void isSpecified-FK8aYYs$annotations(long arg0) {
    }

    public static final boolean isUnspecified-FK8aYYs(long arg2) {
        if(arg2 == ScaleFactor.Companion.getUnspecified-_hLwfpc()) {
            return 1;
        }

        return 0;
    }

    public static void isUnspecified-FK8aYYs$annotations(long arg0) {
    }

    public static final long lerp--bDIf60(long arg4, long arg6, float arg8) {
        return ScaleFactor.constructor-impl((((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg6 >> 0x20))), arg8)))) << 0x20 | (((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))), arg8)))) & 0xFFFFFFFFL);
    }

    public static final long takeOrElse-oyDd2qo(long arg2, Function0 arg4) {
        if(arg2 != ScaleFactor.Companion.getUnspecified-_hLwfpc()) {
            return arg2;
        }

        return arg4.invoke().unbox-impl();
    }

    public static final long times-UQTWf7w(long arg6, long arg8) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) * Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) * Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long times-m-w2e94(long arg0, long arg2) {
        return ScaleFactorKt.times-UQTWf7w(arg2, arg0);
    }
}

