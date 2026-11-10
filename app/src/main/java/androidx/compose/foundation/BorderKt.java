package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path$Direction;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001A\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0007\u001A-\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\u0003\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001A+\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0003\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000E\u001A\f\u0010\u000F\u001A\u00020\u0010*\u00020\u0011H\u0002\u001A;\u0010\u0012\u001A\u00020\u0010*\u00020\u00112\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¢\u0006\u0004\b\u001B\u0010\u001C\u001A(\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\u0018H\u0002\u001A\u0018\u0010#\u001A\u00020!2\u0006\u0010$\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020!H\u0002\u001A\u001B\u0010%\u001A\u00020&*\u00020&2\u0006\u0010\'\u001A\u00020\u001AH\u0002¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2={"border", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "fillArea", "", "strokeWidthPx", "", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "roundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "strokeWidth", "createInsetRoundedRect", "widthPx", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BorderKt {
    public static final Path access$createRoundRectPath(Path arg0, RoundRect arg1, float arg2, boolean arg3) {
        return BorderKt.createRoundRectPath(arg0, arg1, arg2, arg3);
    }

    public static final DrawResult access$drawContentWithoutBorder(CacheDrawScope arg0) {
        return BorderKt.drawContentWithoutBorder(arg0);
    }

    public static final DrawResult access$drawRectBorder-NsqcLGU(CacheDrawScope arg0, Brush arg1, long arg2, long arg4, boolean arg6, float arg7) {
        return BorderKt.drawRectBorder-NsqcLGU(arg0, arg1, arg2, arg4, arg6, arg7);
    }

    public static final long access$shrink-Kibmq7A(long arg0, float arg2) {
        return BorderKt.shrink-Kibmq7A(arg0, arg2);
    }

    public static final Modifier border(Modifier arg1, BorderStroke arg2, Shape arg3) {
        return BorderKt.border-ziNgDLE(arg1, arg2.getWidth-D9Ej5fM(), arg2.getBrush(), arg3);
    }

    public static Modifier border$default(Modifier arg0, BorderStroke arg1, Shape arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = RectangleShapeKt.getRectangleShape();
        }

        return BorderKt.border(arg0, arg1, arg2);
    }

    public static final Modifier border-xT4_qwU(Modifier arg2, float arg3, long arg4, Shape arg6) {
        return BorderKt.border-ziNgDLE(arg2, arg3, new SolidColor(arg4, null), arg6);
    }

    public static Modifier border-xT4_qwU$default(Modifier arg0, float arg1, long arg2, Shape arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg4 = RectangleShapeKt.getRectangleShape();
        }

        return BorderKt.border-xT4_qwU(arg0, arg1, arg2, arg4);
    }

    public static final Modifier border-ziNgDLE(Modifier arg2, float arg3, Brush arg4, Shape arg5) {
        return arg2.then(new BorderModifierNodeElement(arg3, arg4, arg5, null));
    }

    private static final RoundRect createInsetRoundedRect(float arg14, RoundRect arg15) {
        return new RoundRect(arg14, arg14, arg15.getWidth() - arg14, arg15.getHeight() - arg14, BorderKt.shrink-Kibmq7A(arg15.getTopLeftCornerRadius-kKHJgLs(), arg14), BorderKt.shrink-Kibmq7A(arg15.getTopRightCornerRadius-kKHJgLs(), arg14), BorderKt.shrink-Kibmq7A(arg15.getBottomRightCornerRadius-kKHJgLs(), arg14), BorderKt.shrink-Kibmq7A(arg15.getBottomLeftCornerRadius-kKHJgLs(), arg14), null);
    }

    private static final Path createRoundRectPath(Path arg2, RoundRect arg3, float arg4, boolean arg5) {
        arg2.reset();
        Direction v0 = null;
        int v1 = 2;
        Path.addRoundRect$default(arg2, arg3, v0, v1, v0);
        if(!arg5) {
            Path v5 = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(v5, BorderKt.createInsetRoundedRect(arg4, arg3), v0, v1, v0);
            arg2.op-N5in7k0(arg2, v5, PathOperation.Companion.getDifference-b3I0S0c());
        }

        return arg2;
    }

    private static final DrawResult drawContentWithoutBorder(CacheDrawScope arg1) {
        return arg1.onDrawWithContent(new BorderKt$$ExternalSyntheticLambda1());
    }

    static final Unit drawContentWithoutBorder$lambda$0(ContentDrawScope arg0) {
        arg0.drawContent();
        return Unit.INSTANCE;
    }

    private static final DrawResult drawRectBorder-NsqcLGU(CacheDrawScope arg16, Brush arg17, long arg18, long arg20, boolean arg22, float arg23) {
        Fill v0;
        long v4 = arg22 ? Offset.Companion.getZero-F1C5BW0() : arg18;
        long v6 = arg22 ? arg16.getSize-NH-jbRc() : arg20;
        if(arg22) {
            v0 = Fill.INSTANCE;
        }
        else {
            Stroke v0_1 = new Stroke(arg23, 0f, 0, 0, null, 30, null);
        }

        return arg16.onDrawWithContent(new BorderKt$$ExternalSyntheticLambda0(arg17, v4, v6, v0));
    }

    static final Unit drawRectBorder_NsqcLGU$lambda$0(Brush arg12, long arg13, long arg15, DrawStyle arg17, ContentDrawScope arg18) {
        arg18.drawContent();
        DrawScope.drawRect-AsUm42w$default(arg18, arg12, arg13, arg15, 0f, arg17, null, 0, 104, null);
        return Unit.INSTANCE;
    }

    private static final long shrink-Kibmq7A(long arg5, float arg7) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Math.max(0f, Float.intBitsToFloat(((int)(arg5 >> 0x20))) - arg7)))) << 0x20 | (((long)Float.floatToRawIntBits(Math.max(0f, Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))) - arg7)))) & 0xFFFFFFFFL);
    }
}

