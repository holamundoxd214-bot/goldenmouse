package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005\u001A\'\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000B\u001A\"\u0010\u0018\u001A\u00020\u0001*\u00020\u00012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00010\u001AH\u0086\b¢\u0006\u0004\b\u001B\u0010\u001C\"\u001F\u0010\f\u001A\u00020\r*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011\"\u001F\u0010\u0012\u001A\u00020\r*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000F\u001A\u0004\b\u0014\u0010\u0011\"\u001F\u0010\u0015\u001A\u00020\r*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u000F\u001A\u0004\b\u0017\u0010\u0011¨\u0006\u001D"}, d2={"Offset", "Landroidx/compose/ui/geometry/Offset;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "isFinite", "", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OffsetKt {
    public static final long Offset(float arg4, float arg5) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    public static final boolean isFinite-k-4lQ0M(long arg2) {
        if(((arg2 & 0x7F8000007F800000L ^ 0x7F8000007F800000L) - 0x100000001L & -9223372034707292160L) == 0) {
            return 1;
        }

        return 0;
    }

    public static void isFinite-k-4lQ0M$annotations(long arg0) {
    }

    public static final boolean isSpecified-k-4lQ0M(long arg2) {
        if((arg2 & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isSpecified-k-4lQ0M$annotations(long arg0) {
    }

    public static final boolean isUnspecified-k-4lQ0M(long arg2) {
        if((arg2 & 0x7FFFFFFF7FFFFFFFL) == 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isUnspecified-k-4lQ0M$annotations(long arg0) {
    }

    public static final long lerp-Wko1d7g(long arg4, long arg6, float arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg6 >> 0x20))), arg8)))) << 0x20 | (((long)Float.floatToRawIntBits(MathHelpersKt.lerp(Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))), arg8)))) & 0xFFFFFFFFL);
    }

    public static final long takeOrElse-3MmeM6k(long arg4, Function0 arg6) {
        if((0x7FFFFFFF7FFFFFFFL & arg4) != 0x7FC000007FC00000L) {
            return arg4;
        }

        return arg6.invoke().unbox-impl();
    }
}

