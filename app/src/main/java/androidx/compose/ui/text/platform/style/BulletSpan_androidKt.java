package androidx.compose.ui.text.platform.style;

import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0002\u001A4\u0010\u0005\u001A\u00020\u0001*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000EH\u0002\u001A;\u0010\u000F\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u00142\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2={"setDrawStyle", "", "Landroid/graphics/Paint;", "value", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "draw", "Landroidx/compose/ui/graphics/Outline;", "canvas", "Landroid/graphics/Canvas;", "paint", "xStart", "", "yCenter", "dir", "", "setBrushAndDraw", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "size", "Landroidx/compose/ui/geometry/Size;", "Lkotlin/Function0;", "setBrushAndDraw-yzxVdVo", "(Landroid/graphics/Paint;Landroidx/compose/ui/graphics/Brush;FJLkotlin/jvm/functions/Function0;)V", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BulletSpan_androidKt {
    public static final void access$draw(Outline arg0, Canvas arg1, Paint arg2, float arg3, float arg4, int arg5) {
        BulletSpan_androidKt.draw(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final void access$setBrushAndDraw-yzxVdVo(Paint arg0, Brush arg1, float arg2, long arg3, Function0 arg5) {
        BulletSpan_androidKt.setBrushAndDraw-yzxVdVo(arg0, arg1, arg2, arg3, arg5);
    }

    public static final void access$setDrawStyle(Paint arg0, DrawStyle arg1) {
        BulletSpan_androidKt.setDrawStyle(arg0, arg1);
    }

    private static final void draw(Outline arg10, Canvas arg11, Paint arg12, float arg13, float arg14, int arg15) {
        Rect v3;
        String v6 = "Unable to obtain android.graphics.Path";
        float v7 = 2f;
        if((arg10 instanceof Generic)) {
            arg11.save();
            v3 = arg10.getBounds();
            arg11.translate(arg13, arg14 - (v3.getBottom() - v3.getTop()) / v7);
            Path v0 = arg10.getPath();
            if((v0 instanceof AndroidPath)) {
                arg11.drawPath(((AndroidPath)v0).getInternalPath(), arg12);
                arg11.restore();
                return;
            }

            throw new UnsupportedOperationException(v6);
        }

        if((arg10 instanceof Rounded)) {
            Outline v0_1 = arg10;
            if(!RoundRectKt.isSimple(((Rounded)v0_1).getRoundRect())) {
                Path v3_1 = AndroidPath_androidKt.Path();
                Path.addRoundRect$default(v3_1, ((Rounded)v0_1).getRoundRect(), null, 2, null);
                arg11.save();
                arg11.translate(arg13, arg14 - ((Rounded)v0_1).getRoundRect().getHeight() / v7);
                if((v3_1 instanceof AndroidPath)) {
                    arg11.drawPath(((AndroidPath)v3_1).getInternalPath(), arg12);
                    arg11.restore();
                    return;
                }

                throw new UnsupportedOperationException(v6);
            }

            float v4 = Float.intBitsToFloat(((int)(((Rounded)v0_1).getRoundRect().getTopLeftCornerRadius-kKHJgLs() >> 0x20)));
            arg11.drawRoundRect(arg13, arg14 - ((Rounded)v0_1).getRoundRect().getHeight() / v7, (((float)arg15)) * ((Rounded)v0_1).getRoundRect().getWidth() + arg13, ((Rounded)v0_1).getRoundRect().getHeight() / v7 + arg14, v4, v4, arg12);
            return;
        }

        if((arg10 instanceof Rectangle)) {
            Rect v1 = arg10.getRect();
            float v2 = arg14 - (v1.getBottom() - v1.getTop()) / v7;
            v3 = arg10.getRect();
            float v3_2 = arg13 + (((float)arg15)) * (v3.getRight() - v3.getLeft());
            Rect v0_2 = arg10.getRect();
            arg11.drawRect(arg13, v2, v3_2, arg14 + (v0_2.getBottom() - v0_2.getTop()) / v7, arg12);
            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    private static final void setBrushAndDraw-yzxVdVo(Paint arg5, Brush arg6, float arg7, long arg8, Function0 arg10) {
        float v0 = 255f;
        Integer v1 = null;
        if(arg6 == null) {
            if(!Float.isNaN(arg7)) {
                v1 = Integer.valueOf(arg5.getAlpha());
                v1.intValue();
                arg5.setAlpha(((int)(((float)Math.rint(((double)(arg7 * v0)))))));
            }

            arg10.invoke();
            if(v1 == null) {
                return;
            }

            arg5.setAlpha(((Number)v1).intValue());
            return;
        }
        else {
            if((arg6 instanceof SolidColor)) {
                int v8 = arg5.getColor();
                if(!Float.isNaN(arg7)) {
                    v1 = Integer.valueOf(arg5.getAlpha());
                    v1.intValue();
                    arg5.setAlpha(((int)(((float)Math.rint(((double)(arg7 * v0)))))));
                }

                arg5.setColor(ColorKt.toArgb-8_81llA(((SolidColor)arg6).getValue-0d7_KjU()));
                arg10.invoke();
                arg5.setColor(v8);
                if(v1 == null) {
                    return;
                }

                arg5.setAlpha(((Number)v1).intValue());
                return;
            }

            if(!(arg6 instanceof ShaderBrush)) {
                goto label_67;
            }

            Shader v2 = arg5.getShader();
            if(!Float.isNaN(arg7)) {
                v1 = Integer.valueOf(arg5.getAlpha());
                v1.intValue();
                arg5.setAlpha(((int)(((float)Math.rint(((double)(arg7 * v0)))))));
            }

            arg5.setShader(((ShaderBrush)arg6).createShader-uvyYCjk(arg8));
            arg10.invoke();
            arg5.setShader(v2);
            if(v1 == null) {
                return;
            }

            arg5.setAlpha(((Number)v1).intValue());
        }

        return;
    label_67:
        throw new NoWhenBranchMatchedException();
    }

    private static final void setDrawStyle(Paint arg1, DrawStyle arg2) {
        if(Intrinsics.areEqual(arg2, Fill.INSTANCE)) {
            arg1.setStyle(Paint$Style.FILL);
            return;
        }

        if((arg2 instanceof Stroke)) {
            arg1.setStyle(Paint$Style.STROKE);
            arg1.setStrokeWidth(((Stroke)arg2).getWidth());
            arg1.setStrokeMiter(((Stroke)arg2).getMiter());
            arg1.setStrokeCap(DrawStyleSpan_androidKt.toAndroidCap-BeK7IIE(((Stroke)arg2).getCap-KaPHkGw()));
            arg1.setStrokeJoin(DrawStyleSpan_androidKt.toAndroidJoin-Ww9F2mQ(((Stroke)arg2).getJoin-LxFBmk8()));
            PathEffect v2 = ((Stroke)arg2).getPathEffect();
            android.graphics.PathEffect v2_1 = v2 != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(v2) : null;
            arg1.setPathEffect(v2_1);
            return;
        }

        throw new NoWhenBranchMatchedException();
    }
}

