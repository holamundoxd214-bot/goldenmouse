package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0013\u001A6\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u0003\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\f\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u0003\u001A\u001D\u0010\u0000\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000F\u0010\u0010\u001A=\u0010\u0000\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\n2\b\b\u0002\u0010\u0012\u001A\u00020\n2\b\b\u0002\u0010\u0013\u001A\u00020\n2\b\b\u0002\u0010\u0014\u001A\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u0019\u0010\u0017\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u001E\u00101\u001A\u00020\u00012\u0006\u00102\u001A\u00020\u00012\u0006\u00103\u001A\u00020\u00012\u0006\u00104\u001A\u00020\u0003\"\u0015\u0010\u001C\u001A\u00020\u000E*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E\"\u0015\u0010\u001F\u001A\u00020\u000E*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b \u0010\u001E\"\u0015\u0010!\u001A\u00020\"*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b!\u0010#\"\u0015\u0010$\u001A\u00020\"*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b$\u0010#\"\u0015\u0010%\u001A\u00020\"*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b%\u0010#\"\u0015\u0010&\u001A\u00020\"*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b&\u0010#\"\u0015\u0010\'\u001A\u00020\"*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\'\u0010#\"\u0015\u0010(\u001A\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b)\u0010*\"\u0015\u0010+\u001A\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b,\u0010*\"\u0015\u0010-\u001A\u00020\u0019*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b.\u0010/\"\u0015\u00100\u001A\u00020\"*\u00020\u00018F¢\u0006\u0006\u001A\u0004\b0\u0010#¨\u00065"}, d2={"RoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "left", "", "top", "right", "bottom", "radiusX", "radiusY", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "rect", "Landroidx/compose/ui/geometry/Rect;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "translate", "offset", "Landroidx/compose/ui/geometry/Offset;", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "boundingRect", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "safeInnerRect", "getSafeInnerRect", "isEmpty", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isFinite", "isRect", "isEllipse", "isCircle", "minDimension", "getMinDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "maxDimension", "getMaxDimension", "center", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isSimple", "lerp", "start", "stop", "fraction", "ui-geometry"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RoundRectKt {
    public static final RoundRect RoundRect(float arg16, float arg17, float arg18, float arg19, float arg20, float arg21) {
        long v7 = CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(arg20))) << 0x20 | (((long)Float.floatToRawIntBits(arg21))) & 0xFFFFFFFFL);
        return new RoundRect(arg16, arg17, arg18, arg19, v7, v7, v7, v7, null);
    }

    public static final RoundRect RoundRect(Rect arg6, float arg7, float arg8) {
        return RoundRectKt.RoundRect(arg6.getLeft(), arg6.getTop(), arg6.getRight(), arg6.getBottom(), arg7, arg8);
    }

    public static final RoundRect RoundRect-ZAM2FJo(Rect arg14, long arg15, long arg17, long arg19, long arg21) {
        return new RoundRect(arg14.getLeft(), arg14.getTop(), arg14.getRight(), arg14.getBottom(), arg15, arg17, arg19, arg21, null);
    }

    public static RoundRect RoundRect-ZAM2FJo$default(Rect arg8, long arg9, long arg11, long arg13, long arg15, int arg17, Object arg18) {
        long v0 = (arg17 & 2) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg9;
        long v2 = (arg17 & 4) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg11;
        long v4 = (arg17 & 8) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg13;
        long v16 = (arg17 & 16) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : arg15;
        return RoundRectKt.RoundRect-ZAM2FJo(arg8, v0, v2, v4, v16);
    }

    public static final RoundRect RoundRect-gG7oq9Y(float arg3, float arg4, float arg5, float arg6, long arg7) {
        return RoundRectKt.RoundRect(arg3, arg4, arg5, arg6, Float.intBitsToFloat(((int)(arg7 >> 0x20))), Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))));
    }

    public static final RoundRect RoundRect-sniSvfs(Rect arg3, long arg4) {
        return RoundRectKt.RoundRect(arg3, Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))));
    }

    public static final Rect getBoundingRect(RoundRect arg4) {
        return new Rect(arg4.getLeft(), arg4.getTop(), arg4.getRight(), arg4.getBottom());
    }

    public static final long getCenter(RoundRect arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6.getTop() + arg6.getHeight() / 2f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg6.getLeft() + arg6.getWidth() / 2f))) << 0x20);
    }

    public static final float getMaxDimension(RoundRect arg1) {
        return Math.max(Math.abs(arg1.getWidth()), Math.abs(arg1.getHeight()));
    }

    public static final float getMinDimension(RoundRect arg1) {
        return Math.min(Math.abs(arg1.getWidth()), Math.abs(arg1.getHeight()));
    }

    public static final Rect getSafeInnerRect(RoundRect arg9) {
        return new Rect(arg9.getLeft() + Math.max(Float.intBitsToFloat(((int)(arg9.getBottomLeftCornerRadius-kKHJgLs() >> 0x20))), Float.intBitsToFloat(((int)(arg9.getTopLeftCornerRadius-kKHJgLs() >> 0x20)))) * 0.292893f, arg9.getTop() + Math.max(Float.intBitsToFloat(((int)(arg9.getTopLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg9.getTopRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL)))) * 0.292893f, arg9.getRight() - Math.max(Float.intBitsToFloat(((int)(arg9.getTopRightCornerRadius-kKHJgLs() >> 0x20))), Float.intBitsToFloat(((int)(arg9.getBottomRightCornerRadius-kKHJgLs() >> 0x20)))) * 0.292893f, arg9.getBottom() - Math.max(Float.intBitsToFloat(((int)(arg9.getBottomRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(arg9.getBottomLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL)))) * 0.292893f);
    }

    public static final boolean isCircle(RoundRect arg2) {
        if(arg2.getWidth() == arg2.getHeight() && (RoundRectKt.isEllipse(arg2))) {
            return 1;
        }

        return 0;
    }

    public static final boolean isEllipse(RoundRect arg8) {
        if(arg8.getTopLeftCornerRadius-kKHJgLs() == arg8.getTopRightCornerRadius-kKHJgLs() && arg8.getTopRightCornerRadius-kKHJgLs() == arg8.getBottomRightCornerRadius-kKHJgLs() && arg8.getBottomRightCornerRadius-kKHJgLs() == arg8.getBottomLeftCornerRadius-kKHJgLs()) {
            double v4 = 2;
            if((((double)arg8.getWidth())) <= (((double)Float.intBitsToFloat(((int)(arg8.getTopLeftCornerRadius-kKHJgLs() >> 0x20))))) * v4 && (((double)arg8.getHeight())) <= (((double)Float.intBitsToFloat(((int)(arg8.getTopLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL))))) * v4) {
                return 1;
            }
        }

        return 0;
    }

    public static final boolean isEmpty(RoundRect arg2) {
        if(arg2.getLeft() < arg2.getRight()) {
            if(arg2.getTop() >= arg2.getBottom()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final boolean isFinite(RoundRect arg3) {
        int v1 = 0x7FFFFFFF;
        int v2 = 0x7F800000;
        if((Float.floatToRawIntBits(arg3.getLeft()) & v1) < v2 && (Float.floatToRawIntBits(arg3.getTop()) & v1) < v2 && (Float.floatToRawIntBits(arg3.getRight()) & v1) < v2 && (Float.floatToRawIntBits(arg3.getBottom()) & v1) < v2) {
            return 1;
        }

        return 0;
    }

    public static final boolean isRect(RoundRect arg12) {
        long v2 = 0x7FFFFFFF7FFFFFFFL;
        long v0 = arg12.getTopLeftCornerRadius-kKHJgLs() & v2;
        long v4 = 0x100000001L;
        long v6 = -9223372034707292160L;
        long v8 = 0;
        if((~v0 & v0 - v4 & v6) != v8) {
            v0 = arg12.getTopRightCornerRadius-kKHJgLs() & v2;
            if((~v0 & v0 - v4 & v6) != v8) {
                v0 = arg12.getBottomLeftCornerRadius-kKHJgLs() & v2;
                if((~v0 & v0 - v4 & v6) != v8) {
                    v0 = arg12.getBottomRightCornerRadius-kKHJgLs() & v2;
                    if((~v0 & v0 - v4 & v6) != v8) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    public static final boolean isSimple(RoundRect arg6) {
        long v0 = arg6.getTopLeftCornerRadius-kKHJgLs();
        if(v0 >>> 0x20 == (v0 & 0xFFFFFFFFL) && arg6.getTopLeftCornerRadius-kKHJgLs() == arg6.getTopRightCornerRadius-kKHJgLs() && arg6.getTopLeftCornerRadius-kKHJgLs() == arg6.getBottomRightCornerRadius-kKHJgLs() && arg6.getTopLeftCornerRadius-kKHJgLs() == arg6.getBottomLeftCornerRadius-kKHJgLs()) {
            return 1;
        }

        return 0;
    }

    public static final RoundRect lerp(RoundRect arg16, RoundRect arg17, float arg18) {
        return new RoundRect(MathHelpersKt.lerp(arg16.getLeft(), arg17.getLeft(), arg18), MathHelpersKt.lerp(arg16.getTop(), arg17.getTop(), arg18), MathHelpersKt.lerp(arg16.getRight(), arg17.getRight(), arg18), MathHelpersKt.lerp(arg16.getBottom(), arg17.getBottom(), arg18), CornerRadiusKt.lerp-3Ry4LBc(arg16.getTopLeftCornerRadius-kKHJgLs(), arg17.getTopLeftCornerRadius-kKHJgLs(), arg18), CornerRadiusKt.lerp-3Ry4LBc(arg16.getTopRightCornerRadius-kKHJgLs(), arg17.getTopRightCornerRadius-kKHJgLs(), arg18), CornerRadiusKt.lerp-3Ry4LBc(arg16.getBottomRightCornerRadius-kKHJgLs(), arg17.getBottomRightCornerRadius-kKHJgLs(), arg18), CornerRadiusKt.lerp-3Ry4LBc(arg16.getBottomLeftCornerRadius-kKHJgLs(), arg17.getBottomLeftCornerRadius-kKHJgLs(), arg18), null);
    }

    public static final RoundRect translate-Uv8p0NA(RoundRect arg14, long arg15) {
        int v2 = ((int)(arg15 >> 0x20));
        int v4 = ((int)(0xFFFFFFFFL & arg15));
        return new RoundRect(arg14.getLeft() + Float.intBitsToFloat(v2), arg14.getTop() + Float.intBitsToFloat(v4), arg14.getRight() + Float.intBitsToFloat(v2), Float.intBitsToFloat(v4) + arg14.getBottom(), arg14.getTopLeftCornerRadius-kKHJgLs(), arg14.getTopRightCornerRadius-kKHJgLs(), arg14.getBottomRightCornerRadius-kKHJgLs(), arg14.getBottomLeftCornerRadius-kKHJgLs(), null);
    }
}

