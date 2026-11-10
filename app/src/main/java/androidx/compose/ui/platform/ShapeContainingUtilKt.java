package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A8\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\bH\u0000\u001A \u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0002\u001A4\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u000E2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\b2\b\u0010\u0010\u001A\u0004\u0018\u00010\bH\u0002\u001A\f\u0010\u0011\u001A\u00020\u0001*\u00020\u0012H\u0002\u001A7\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001A4\u0010\u001A\u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002¨\u0006\u001C"}, d2={"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "isInPath", "path", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect arg6) {
        int v2 = 0x20;
        if(Float.intBitsToFloat(((int)(arg6.getTopLeftCornerRadius-kKHJgLs() >> v2))) + Float.intBitsToFloat(((int)(arg6.getTopRightCornerRadius-kKHJgLs() >> v2))) <= arg6.getWidth() && Float.intBitsToFloat(((int)(arg6.getBottomLeftCornerRadius-kKHJgLs() >> v2))) + Float.intBitsToFloat(((int)(arg6.getBottomRightCornerRadius-kKHJgLs() >> v2))) <= arg6.getWidth()) {
            long v2_1 = 0xFFFFFFFFL;
            if(Float.intBitsToFloat(((int)(arg6.getTopLeftCornerRadius-kKHJgLs() & v2_1))) + Float.intBitsToFloat(((int)(arg6.getBottomLeftCornerRadius-kKHJgLs() & v2_1))) <= arg6.getHeight() && Float.intBitsToFloat(((int)(arg6.getTopRightCornerRadius-kKHJgLs() & v2_1))) + Float.intBitsToFloat(((int)(arg6.getBottomRightCornerRadius-kKHJgLs() & v2_1))) <= arg6.getHeight()) {
                return 1;
            }
        }

        return 0;
    }

    public static final boolean isInOutline(Outline arg1, float arg2, float arg3, Path arg4, Path arg5) {
        if((arg1 instanceof Rectangle)) {
            return ShapeContainingUtilKt.isInRectangle(((Rectangle)arg1).getRect(), arg2, arg3);
        }

        if((arg1 instanceof Rounded)) {
            return ShapeContainingUtilKt.isInRoundedRect(((Rounded)arg1), arg2, arg3, arg4, arg5);
        }

        if((arg1 instanceof Generic)) {
            return ShapeContainingUtilKt.isInPath(((Generic)arg1).getPath(), arg2, arg3, arg4, arg5);
        }

        throw new NoWhenBranchMatchedException();
    }

    public static boolean isInOutline$default(Outline arg1, float arg2, float arg3, Path arg4, Path arg5, int arg6, Object arg7) {
        Path v0 = null;
        if((arg6 & 8) != 0) {
            arg4 = v0;
        }

        if((arg6 & 16) != 0) {
            arg5 = v0;
        }

        return ShapeContainingUtilKt.isInOutline(arg1, arg2, arg3, arg4, arg5);
    }

    private static final boolean isInPath(Path arg4, float arg5, float arg6, Path arg7, Path arg8) {
        Rect v0 = new Rect(arg5 - 0.005f, arg6 - 0.005f, arg5 + 0.005f, arg6 + 0.005f);
        if(arg7 == null) {
            arg7 = AndroidPath_androidKt.Path();
        }

        Path.addRect$default(arg7, v0, null, 2, null);
        if(arg8 == null) {
            arg8 = AndroidPath_androidKt.Path();
        }

        arg8.op-N5in7k0(arg4, arg7, PathOperation.Companion.getIntersect-b3I0S0c());
        boolean v4 = arg8.isEmpty();
        arg8.reset();
        arg7.reset();
        return (((int)v4)) ^ 1;
    }

    private static final boolean isInRectangle(Rect arg1, float arg2, float arg3) {
        if(arg1.getLeft() <= arg2 && arg2 < arg1.getRight() && arg1.getTop() <= arg3 && arg3 < arg1.getBottom()) {
            return 1;
        }

        return 0;
    }

    private static final boolean isInRoundedRect(Rounded arg14, float arg15, float arg16, Path arg17, Path arg18) {
        float v1 = arg16;
        Path v2 = arg18;
        RoundRect v14 = arg14.getRoundRect();
        if(arg15 >= v14.getLeft() && arg15 < v14.getRight() && v1 >= v14.getTop()) {
            if(v1 >= v14.getBottom()) {
            }
            else if(!ShapeContainingUtilKt.cornersFit(v14)) {
                Path v3 = v2 == null ? AndroidPath_androidKt.Path() : v2;
                Path.addRoundRect$default(v3, v14, null, 2, null);
                return ShapeContainingUtilKt.isInPath(v3, arg15, v1, arg17, v2);
            }
            else {
                float v4 = v14.getLeft() + Float.intBitsToFloat(((int)(v14.getTopLeftCornerRadius-kKHJgLs() >> 0x20)));
                float v2_1 = v14.getTop() + Float.intBitsToFloat(((int)(v14.getTopLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL)));
                float v3_1 = v14.getRight() - Float.intBitsToFloat(((int)(v14.getTopRightCornerRadius-kKHJgLs() >> 0x20)));
                float v6 = v14.getTop() + Float.intBitsToFloat(((int)(v14.getTopRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL)));
                float v7 = v14.getRight() - Float.intBitsToFloat(((int)(v14.getBottomRightCornerRadius-kKHJgLs() >> 0x20)));
                float v10 = v14.getBottom() - Float.intBitsToFloat(((int)(v14.getBottomRightCornerRadius-kKHJgLs() & 0xFFFFFFFFL)));
                float v11 = v14.getBottom() - Float.intBitsToFloat(((int)(0xFFFFFFFFL & v14.getBottomLeftCornerRadius-kKHJgLs())));
                float v8 = v14.getLeft() + Float.intBitsToFloat(((int)(v14.getBottomLeftCornerRadius-kKHJgLs() >> 0x20)));
                if(arg15 < v4 && v1 < v2_1) {
                    return ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(arg15, v1, v14.getTopLeftCornerRadius-kKHJgLs(), v4, v2_1);
                }

                if(arg15 < v8 && arg16 > v11) {
                    return ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(arg15, arg16, v14.getBottomLeftCornerRadius-kKHJgLs(), v8, v11);
                }

                if(arg15 > v3_1 && arg16 < v6) {
                    return ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(arg15, arg16, v14.getTopRightCornerRadius-kKHJgLs(), v3_1, v6);
                }

                if(arg15 > v7 && arg16 > v10) {
                    return ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(arg15, arg16, v14.getBottomRightCornerRadius-kKHJgLs(), v7, v10);
                }

                return 1;
            }
        }

        return 0;
    }

    private static final boolean isWithinEllipse-VE1yxkc(float arg2, float arg3, long arg4, float arg6, float arg7) {
        arg2 -= arg6;
        arg3 -= arg7;
        arg6 = Float.intBitsToFloat(((int)(arg4 >> 0x20)));
        float v4 = Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL)));
        if(arg2 * arg2 / (arg6 * arg6) + arg3 * arg3 / (v4 * v4) <= 1f) {
            return 1;
        }

        return 0;
    }
}

