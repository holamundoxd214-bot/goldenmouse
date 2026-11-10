package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u001A\"\u0010\n\u001A\u00020\u0002*\u00020\u00022\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00020\fH\u0086\b¢\u0006\u0004\b\r\u0010\u000E\u001A\u001C\u0010\u001A\u001A\u00020\u0002*\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001C\u0010\u001D\u001A\u001C\u0010\u001A\u001A\u00020\u0002*\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001C\u0010\u001E\u001A\u001C\u0010\u001A\u001A\u00020\u0002*\u00020\u00102\u0006\u0010\u001B\u001A\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001C\u0010\u001F\u001A \u0010 \u001A\u00020\u00022\u0006\u0010!\u001A\u00020\u00022\u0006\u0010\"\u001A\u00020\u0002H\u0087\b¢\u0006\u0004\b#\u0010\u001D\u001A \u0010$\u001A\u00020\u00022\u0006\u0010!\u001A\u00020\u00022\u0006\u0010\"\u001A\u00020\u0002H\u0087\b¢\u0006\u0004\b%\u0010\u001D\u001A$\u0010&\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\'\u001A\u00020\u00022\u0006\u0010(\u001A\u00020\u0002H\u0087\b¢\u0006\u0004\b)\u0010*\u001A\u001C\u0010+\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\'\u001A\u00020\u0002H\u0087\b¢\u0006\u0004\b,\u0010\u001D\u001A\u001C\u0010-\u001A\u00020\u0002*\u00020\u00022\u0006\u0010(\u001A\u00020\u0002H\u0087\b¢\u0006\u0004\b.\u0010\u001D\u001A\'\u00102\u001A\u00020\u00022\u0006\u00103\u001A\u00020\u00022\u0006\u00104\u001A\u00020\u00022\u0006\u00105\u001A\u00020\u0018H\u0007¢\u0006\u0004\b6\u0010*\u001A \u00107\u001A\u0002082\u0006\u00109\u001A\u00020\u00022\u0006\u0010:\u001A\u00020\u0002H\u0087\b¢\u0006\u0004\b;\u0010<\u001A\"\u0010\n\u001A\u000208*\u0002082\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002080\fH\u0086\b¢\u0006\u0004\bC\u0010D\u001A\'\u00102\u001A\u0002082\u0006\u00103\u001A\u0002082\u0006\u00104\u001A\u0002082\u0006\u00105\u001A\u00020\u0018H\u0007¢\u0006\u0004\bE\u0010F\u001A\u001F\u0010G\u001A\u00020H2\u0006\u0010I\u001A\u00020\u00022\u0006\u0010J\u001A\u00020\u0002H\u0007¢\u0006\u0004\bK\u0010<\u001A\"\u0010\n\u001A\u00020H*\u00020H2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020H0\fH\u0086\b¢\u0006\u0004\bP\u0010D\u001A\u001C\u0010\u001A\u001A\u00020H*\u00020\u00102\u0006\u0010U\u001A\u00020HH\u0087\n¢\u0006\u0004\bV\u0010W\u001A\u001C\u0010\u001A\u001A\u00020H*\u00020\u00182\u0006\u0010U\u001A\u00020HH\u0087\n¢\u0006\u0004\bV\u0010X\u001A\'\u00102\u001A\u00020H2\u0006\u00103\u001A\u00020H2\u0006\u00104\u001A\u00020H2\u0006\u00105\u001A\u00020\u0018H\u0007¢\u0006\u0004\bY\u0010F\"\u001F\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u001F\u0010\u0007\u001A\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001A\u0004\b\t\u0010\u0006\"\u001F\u0010\u000F\u001A\u00020\u0002*\u00020\u00108Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u001F\u0010\u000F\u001A\u00020\u0002*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0016\u001A\u0004\b\u0013\u0010\u0017\"\u001F\u0010\u000F\u001A\u00020\u0002*\u00020\u00188Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001A\u0004\b\u0013\u0010\u0019\"\u001F\u0010/\u001A\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001A\u0004\b1\u0010\u0006\"\u001F\u0010\u0000\u001A\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001A\u0004\b?\u0010@\"\u001F\u0010\u0007\u001A\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010>\u001A\u0004\bB\u0010@\"\u001F\u0010\u0000\u001A\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010>\u001A\u0004\bM\u0010@\"\u001F\u0010\u0007\u001A\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010>\u001A\u0004\bO\u0010@\"\u001E\u0010Q\u001A\u000208*\u00020H8FX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010>\u001A\u0004\bS\u0010T\"\u001F\u0010I\u001A\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\\\u001A\u0004\b]\u0010^\"\u001F\u0010J\u001A\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\\\u001A\u0004\b`\u0010^\"\u001F\u0010U\u001A\u00020H*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010\\\u001A\u0004\bb\u0010c¨\u0006d"}, d2={"isSpecified", "", "Landroidx/compose/ui/unit/Dp;", "isSpecified-0680j_4$annotations", "(F)V", "isSpecified-0680j_4", "(F)Z", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "dp", "", "getDp$annotations", "(I)V", "getDp", "(I)F", "", "(D)V", "(D)F", "", "(F)F", "times", "other", "times-3ABfNKs", "(FF)F", "(DF)F", "(IF)F", "min", "a", "b", "min-YgX7TsA", "max", "max-YgX7TsA", "coerceIn", "minimumValue", "maximumValue", "coerceIn-2z7ARbQ", "(FFF)F", "coerceAtLeast", "coerceAtLeast-YgX7TsA", "coerceAtMost", "coerceAtMost-YgX7TsA", "isFinite", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "DpOffset", "Landroidx/compose/ui/unit/DpOffset;", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "isSpecified-jo-Fl9I$annotations", "(J)V", "isSpecified-jo-Fl9I", "(J)Z", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "lerp-xhh869w", "(JJF)J", "DpSize", "Landroidx/compose/ui/unit/DpSize;", "width", "height", "DpSize-YgX7TsA", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "takeOrElse-itqla9I", "center", "getCenter-EaSLcWc$annotations", "getCenter-EaSLcWc", "(J)J", "size", "times-6HolHcs", "(IJ)J", "(FJ)J", "lerp-IDex15A", "Landroidx/compose/ui/unit/DpRect;", "getWidth$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getWidth", "(Landroidx/compose/ui/unit/DpRect;)F", "getHeight$annotations", "getHeight", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "ui-unit"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DpKt {
    public static final long DpOffset-YgX7TsA(float arg4, float arg5) {
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    public static final long DpSize-YgX7TsA(float arg4, float arg5) {
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20);
    }

    public static final float coerceAtLeast-YgX7TsA(float arg0, float arg1) {
        return Dp.constructor-impl(RangesKt.coerceAtLeast(arg0, arg1));
    }

    public static final float coerceAtMost-YgX7TsA(float arg0, float arg1) {
        return Dp.constructor-impl(RangesKt.coerceAtMost(arg0, arg1));
    }

    public static final float coerceIn-2z7ARbQ(float arg0, float arg1, float arg2) {
        return Dp.constructor-impl(RangesKt.coerceIn(arg0, arg1, arg2));
    }

    public static final long getCenter-EaSLcWc(long arg4) {
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(arg4) / 2f)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(arg4) / 2f)))) << 0x20);
    }

    public static void getCenter-EaSLcWc$annotations(long arg0) {
    }

    public static final float getDp(double arg0) {
        return Dp.constructor-impl(((float)arg0));
    }

    public static final float getDp(float arg0) {
        return Dp.constructor-impl(arg0);
    }

    public static final float getDp(int arg0) {
        return Dp.constructor-impl(((float)arg0));
    }

    public static void getDp$annotations(double arg0) {
    }

    public static void getDp$annotations(float arg0) {
    }

    public static void getDp$annotations(int arg0) {
    }

    public static final float getHeight(DpRect arg1) {
        return Dp.constructor-impl(arg1.getBottom-D9Ej5fM() - arg1.getTop-D9Ej5fM());
    }

    public static void getHeight$annotations(DpRect arg0) {
    }

    public static final long getSize(DpRect arg2) {
        return DpKt.DpSize-YgX7TsA(Dp.constructor-impl(arg2.getRight-D9Ej5fM() - arg2.getLeft-D9Ej5fM()), Dp.constructor-impl(arg2.getBottom-D9Ej5fM() - arg2.getTop-D9Ej5fM()));
    }

    public static void getSize$annotations(DpRect arg0) {
    }

    public static final float getWidth(DpRect arg1) {
        return Dp.constructor-impl(arg1.getRight-D9Ej5fM() - arg1.getLeft-D9Ej5fM());
    }

    public static void getWidth$annotations(DpRect arg0) {
    }

    public static final boolean isFinite-0680j_4(float arg1) {
        if((Float.floatToRawIntBits(arg1) & 0x7FFFFFFF) < 0x7F800000) {
            return 1;
        }

        return 0;
    }

    public static void isFinite-0680j_4$annotations(float arg0) {
    }

    public static final boolean isSpecified-0680j_4(float arg0) {
        return Float.isNaN(arg0) ^ 1;
    }

    public static void isSpecified-0680j_4$annotations(float arg0) {
    }

    public static final boolean isSpecified-EaSLcWc(long arg2) {
        if(arg2 != 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isSpecified-EaSLcWc$annotations(long arg0) {
    }

    public static final boolean isSpecified-jo-Fl9I(long arg2) {
        if(arg2 != 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isSpecified-jo-Fl9I$annotations(long arg0) {
    }

    public static final boolean isUnspecified-0680j_4(float arg0) {
        return Float.isNaN(arg0);
    }

    public static void isUnspecified-0680j_4$annotations(float arg0) {
    }

    public static final boolean isUnspecified-EaSLcWc(long arg2) {
        if(arg2 == 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isUnspecified-EaSLcWc$annotations(long arg0) {
    }

    public static final boolean isUnspecified-jo-Fl9I(long arg2) {
        if(arg2 == 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    public static void isUnspecified-jo-Fl9I$annotations(long arg0) {
    }

    public static final long lerp-IDex15A(long arg2, long arg4, float arg6) {
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(DpKt.lerp-Md-fbLM(DpSize.getWidth-D9Ej5fM(arg2), DpSize.getWidth-D9Ej5fM(arg4), arg6)))) << 0x20 | (((long)Float.floatToRawIntBits(DpKt.lerp-Md-fbLM(DpSize.getHeight-D9Ej5fM(arg2), DpSize.getHeight-D9Ej5fM(arg4), arg6)))) & 0xFFFFFFFFL);
    }

    public static final float lerp-Md-fbLM(float arg0, float arg1, float arg2) {
        return Dp.constructor-impl(MathHelpersKt.lerp(arg0, arg1, arg2));
    }

    public static final long lerp-xhh869w(long arg2, long arg4, float arg6) {
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(MathHelpersKt.lerp(DpOffset.getX-D9Ej5fM(arg2), DpOffset.getX-D9Ej5fM(arg4), arg6)))) << 0x20 | (((long)Float.floatToRawIntBits(MathHelpersKt.lerp(DpOffset.getY-D9Ej5fM(arg2), DpOffset.getY-D9Ej5fM(arg4), arg6)))) & 0xFFFFFFFFL);
    }

    public static final float max-YgX7TsA(float arg0, float arg1) {
        return Dp.constructor-impl(Math.max(arg0, arg1));
    }

    public static final float min-YgX7TsA(float arg0, float arg1) {
        return Dp.constructor-impl(Math.min(arg0, arg1));
    }

    public static final float takeOrElse-D5KLDUw(float arg1, Function0 arg2) {
        if(!Float.isNaN(arg1)) {
            return arg1;
        }

        return arg2.invoke().unbox-impl();
    }

    public static final long takeOrElse-gVKV90s(long arg2, Function0 arg4) {
        if(arg2 != 0x7FC000007FC00000L) {
            return arg2;
        }

        return arg4.invoke().unbox-impl();
    }

    public static final long takeOrElse-itqla9I(long arg2, Function0 arg4) {
        if(arg2 != 0x7FC000007FC00000L) {
            return arg2;
        }

        return arg4.invoke().unbox-impl();
    }

    public static final float times-3ABfNKs(double arg0, float arg2) {
        return Dp.constructor-impl((((float)arg0)) * arg2);
    }

    public static final float times-3ABfNKs(float arg0, float arg1) {
        return Dp.constructor-impl(arg0 * arg1);
    }

    public static final float times-3ABfNKs(int arg0, float arg1) {
        return Dp.constructor-impl((((float)arg0)) * arg1);
    }

    public static final long times-6HolHcs(float arg0, long arg1) {
        return DpSize.times-Gh9hcWk(arg1, arg0);
    }

    public static final long times-6HolHcs(int arg0, long arg1) {
        return DpSize.times-Gh9hcWk(arg1, arg0);
    }
}

