package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001AK\u0010\u0005\u001A\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0003\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001AK\u0010\u0005\u001A\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0003\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u0011\u0010\u0017\u001A\u00020\u0018*\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001A\u001A\u0011\u0010\u001B\u001A\u00020\u001C*\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001A\u001A\u0011\u0010\u0017\u001A\u00020\u0018*\u00020\u001DH\u0002¢\u0006\u0002\u0010\u001E\u001A\u0011\u0010\u001B\u001A\u00020\u001C*\u00020\u001DH\u0002¢\u0006\u0002\u0010\u001E\u001A\u009F\u0001\u0010\u001F\u001A\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00042,\u0010 \u001A(\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b%2,\u0010&\u001A(\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u001D¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b%2,\u0010(\u001A(\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b%H\u0082\b\u001A\u001A\u0010\u0005\u001A\u00020\u0001*\u00020*2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010+\u001A\u00020,\u001A\f\u0010-\u001A\u00020.*\u00020\u001DH\u0002¨\u0006/"}, d2={"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;)J", "size", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/RoundRect;", "(Landroidx/compose/ui/geometry/RoundRect;)J", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "rrect", "drawPathBlock", "path", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "hasSameCornerRadius", "", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OutlineKt {
    public static final void addOutline(Path arg6, Outline arg7) {
        int v1 = 2;
        Direction v2 = null;
        if((arg7 instanceof Rectangle)) {
            Path.addRect$default(arg6, ((Rectangle)arg7).getRect(), v2, v1, v2);
            return;
        }

        if((arg7 instanceof Rounded)) {
            Path.addRoundRect$default(arg6, ((Rounded)arg7).getRoundRect(), v2, v1, v2);
            return;
        }

        if((arg7 instanceof Generic)) {
            Path.addPath-Uv8p0NA$default(arg6, ((Generic)arg7).getPath(), 0, 2, null);
            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    public static final void drawOutline(Canvas arg9, Outline arg10, Paint arg11) {
        if((arg10 instanceof Rectangle)) {
            arg9.drawRect(((Rectangle)arg10).getRect(), arg11);
            return;
        }

        if((arg10 instanceof Rounded)) {
            Path v0 = ((Rounded)arg10).getRoundRectPath$ui_graphics();
            if(v0 != null) {
                arg9.drawPath(v0, arg11);
                return;
            }

            arg9.drawRoundRect(((Rounded)arg10).getRoundRect().getLeft(), ((Rounded)arg10).getRoundRect().getTop(), ((Rounded)arg10).getRoundRect().getRight(), ((Rounded)arg10).getRoundRect().getBottom(), Float.intBitsToFloat(((int)(((Rounded)arg10).getRoundRect().getBottomLeftCornerRadius-kKHJgLs() >> 0x20))), Float.intBitsToFloat(((int)(((Rounded)arg10).getRoundRect().getBottomLeftCornerRadius-kKHJgLs() & 0xFFFFFFFFL))), arg11);
            return;
        }

        Canvas v1 = arg9;
        Paint v8 = arg11;
        if((arg10 instanceof Generic)) {
            v1.drawPath(((Generic)arg10).getPath(), v8);
            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    public static final void drawOutline-hn5TExg(DrawScope arg19, Outline arg20, Brush arg21, float arg22, DrawStyle arg23, ColorFilter arg24, int arg25) {
        Outline v0 = arg20;
        if((v0 instanceof Rectangle)) {
            Rect v0_1 = ((Rectangle)v0).getRect();
            arg19.drawRect-AsUm42w(arg21, OutlineKt.topLeft(v0_1), OutlineKt.size(v0_1), arg22, arg23, arg24, arg25);
            return;
        }

        if((v0 instanceof Rounded)) {
            Path v8 = ((Rounded)v0).getRoundRectPath$ui_graphics();
            if(v8 != null) {
                arg19.drawPath-GBMwjPU(v8, arg21, arg22, arg23, arg24, arg25);
                return;
            }

            RoundRect v0_2 = ((Rounded)v0).getRoundRect();
            float v1 = Float.intBitsToFloat(((int)(v0_2.getBottomLeftCornerRadius-kKHJgLs() >> 0x20)));
            arg19.drawRoundRect-ZuiqVtQ(arg21, OutlineKt.topLeft(v0_2), OutlineKt.size(v0_2), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v1))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v1))) << 0x20), arg22, arg23, arg24, arg25);
            return;
        }

        if((v0 instanceof Generic)) {
            arg19.drawPath-GBMwjPU(((Generic)v0).getPath(), arg21, arg22, arg23, arg24, arg25);
            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    public static void drawOutline-hn5TExg$default(DrawScope arg7, Outline arg8, Brush arg9, float arg10, DrawStyle arg11, ColorFilter arg12, int arg13, int arg14, Object arg15) {
        Fill v11;
        if((arg14 & 4) != 0) {
            arg10 = 1f;
        }

        float v3 = arg10;
        if((arg14 & 8) != 0) {
            v11 = Fill.INSTANCE;
        }

        DrawStyle v4 = ((DrawStyle)v11);
        if((arg14 & 16) != 0) {
            arg12 = null;
        }

        ColorFilter v5 = arg12;
        if((arg14 & 0x20) != 0) {
            arg13 = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
        }

        OutlineKt.drawOutline-hn5TExg(arg7, arg8, arg9, v3, v4, v5, arg13);
    }

    public static final void drawOutline-wDX37Ww(DrawScope arg21, Outline arg22, long arg23, float arg25, DrawStyle arg26, ColorFilter arg27, int arg28) {
        Outline v0 = arg22;
        if((v0 instanceof Rectangle)) {
            Rect v0_1 = ((Rectangle)v0).getRect();
            arg21.drawRect-n-J9OG0(arg23, OutlineKt.topLeft(v0_1), OutlineKt.size(v0_1), arg25, arg26, arg27, arg28);
            return;
        }

        if((v0 instanceof Rounded)) {
            Path v9 = ((Rounded)v0).getRoundRectPath$ui_graphics();
            if(v9 != null) {
                arg21.drawPath-LG529CI(v9, arg23, arg25, arg26, arg27, arg28);
                return;
            }

            RoundRect v0_2 = ((Rounded)v0).getRoundRect();
            float v1 = Float.intBitsToFloat(((int)(v0_2.getBottomLeftCornerRadius-kKHJgLs() >> 0x20)));
            arg21.drawRoundRect-u-Aw5IA(arg23, OutlineKt.topLeft(v0_2), OutlineKt.size(v0_2), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v1))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v1))) << 0x20), arg26, arg25, arg27, arg28);
            return;
        }

        if((v0 instanceof Generic)) {
            arg21.drawPath-LG529CI(((Generic)v0).getPath(), arg23, arg25, arg26, arg27, arg28);
            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    public static void drawOutline-wDX37Ww$default(DrawScope arg8, Outline arg9, long arg10, float arg12, DrawStyle arg13, ColorFilter arg14, int arg15, int arg16, Object arg17) {
        Fill v13;
        if((arg16 & 4) != 0) {
            arg12 = 1f;
        }

        float v4 = arg12;
        if((arg16 & 8) != 0) {
            v13 = Fill.INSTANCE;
        }

        DrawStyle v5 = ((DrawStyle)v13);
        if((arg16 & 16) != 0) {
            arg14 = null;
        }

        ColorFilter v6 = arg14;
        int v7 = (arg16 & 0x20) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg15;
        OutlineKt.drawOutline-wDX37Ww(arg8, arg9, arg10, v4, v5, v6, v7);
    }

    private static final void drawOutlineHelper(DrawScope arg1, Outline arg2, Function2 arg3, Function2 arg4, Function2 arg5) {
        if((arg2 instanceof Rectangle)) {
            arg3.invoke(arg1, ((Rectangle)arg2).getRect());
            return;
        }

        if((arg2 instanceof Rounded)) {
            Path v3 = ((Rounded)arg2).getRoundRectPath$ui_graphics();
            if(v3 != null) {
                arg5.invoke(arg1, v3);
                return;
            }

            arg4.invoke(arg1, ((Rounded)arg2).getRoundRect());
            return;
        }

        if((arg2 instanceof Generic)) {
            arg5.invoke(arg1, ((Generic)arg2).getPath());
            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    private static final boolean hasSameCornerRadius(RoundRect arg8) {
        int v2 = 0x20;
        int v0 = Float.compare(Float.intBitsToFloat(((int)(arg8.getBottomLeftCornerRadius-kKHJgLs() >> v2))), Float.intBitsToFloat(((int)(arg8.getBottomRightCornerRadius-kKHJgLs() >> v2)))) != 0 || Float.intBitsToFloat(((int)(arg8.getBottomRightCornerRadius-kKHJgLs() >> v2))) != Float.intBitsToFloat(((int)(arg8.getTopRightCornerRadius-kKHJgLs() >> v2))) || Float.intBitsToFloat(((int)(arg8.getTopRightCornerRadius-kKHJgLs() >> v2))) != Float.intBitsToFloat(((int)(arg8.getTopLeftCornerRadius-kKHJgLs() >> v2))) ? 0 : 1;
        long v6 = 0xFFFFFFFFL;
        int v8 = Float.intBitsToFloat(((int)(arg8.getBottomLeftCornerRadius-kKHJgLs() & v6))) != Float.intBitsToFloat(((int)(arg8.getBottomRightCornerRadius-kKHJgLs() & v6))) || Float.intBitsToFloat(((int)(arg8.getBottomRightCornerRadius-kKHJgLs() & v6))) != Float.intBitsToFloat(((int)(arg8.getTopRightCornerRadius-kKHJgLs() & v6))) || Float.intBitsToFloat(((int)(arg8.getTopRightCornerRadius-kKHJgLs() & v6))) != Float.intBitsToFloat(((int)(arg8.getTopLeftCornerRadius-kKHJgLs() & v6))) ? 0 : 1;
        if(v0 != 0 && v8 != 0) {
            return 1;
        }

        return 0;
    }

    private static final long size(Rect arg6) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(arg6.getBottom() - arg6.getTop()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg6.getRight() - arg6.getLeft()))) << 0x20);
    }

    private static final long size(RoundRect arg6) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(arg6.getWidth()))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.getHeight()))) & 0xFFFFFFFFL);
    }

    private static final long topLeft(Rect arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6.getLeft()))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.getTop()))) & 0xFFFFFFFFL);
    }

    private static final long topLeft(RoundRect arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6.getLeft()))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.getTop()))) & 0xFFFFFFFFL);
    }
}

