package androidx.compose.ui.text.platform;

import android.graphics.Paint$Style;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u00104\u001A\u0002052\b\u0010\r\u001A\u0004\u0018\u00010\u000EJ\u0010\u00106\u001A\u0002052\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013J\u0015\u00107\u001A\u0002052\u0006\u00108\u001A\u00020\u001B¢\u0006\u0004\b9\u0010:J)\u0010;\u001A\u0002052\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0006\u0010<\u001A\u00020,2\b\b\u0002\u0010=\u001A\u00020\u0005¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001A\u0002052\b\u00102\u001A\u0004\u0018\u000103J\b\u0010G\u001A\u000205H\u0002R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0011R$\u0010\u0012\u001A\u00020\u00138\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\u001C\u001A\u0004\u0018\u00010\u001D8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u001E\u0010\u0015\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R*\u0010#\u001A\u0012\u0012\f\u0012\n\u0018\u00010%j\u0004\u0018\u0001`&\u0018\u00010$X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R&\u0010+\u001A\u0004\u0018\u00010,8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0015\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001A\u0004\u0018\u000103X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010B\u001A\u00020\u00102\u0006\u0010A\u001A\u00020\u00108F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2={"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "<init>", "(IF)V", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "composePaint", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "backingBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text$annotations", "()V", "getShadow$ui_text", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text", "(Landroidx/compose/ui/graphics/Shadow;)V", "lastColor", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text$annotations", "getBrush$ui_text", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text", "(Landroidx/compose/ui/graphics/Brush;)V", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShaderState$ui_text", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text", "(Landroidx/compose/runtime/State;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text$annotations", "getBrushSize-VsRJwc0$ui_text", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text", "(Landroidx/compose/ui/geometry/Size;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setTextDecoration", "", "setShadow", "setColor", "color", "setColor-8_81llA", "(J)V", "setBrush", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setDrawStyle", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "clearShader", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidTextPaint extends TextPaint {
    public static final int $stable = 8;
    private int backingBlendMode;
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private Color lastColor;
    private State shaderState;
    private Shadow shadow;
    private TextDecoration textDecoration;

    static {
    }

    public AndroidTextPaint(int arg1, float arg2) {
        super(arg1);
        this.density = arg2;
        this.textDecoration = TextDecoration.Companion.getNone();
        this.backingBlendMode = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
        this.shadow = Shadow.Companion.getNone();
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        this.setShader(null);
    }

    public final int getBlendMode-0nO6VwU() {
        return this.backingBlendMode;
    }

    public final Brush getBrush$ui_text() {
        return this.brush;
    }

    public static void getBrush$ui_text$annotations() {
    }

    public final Size getBrushSize-VsRJwc0$ui_text() {
        return this.brushSize;
    }

    public static void getBrushSize-VsRJwc0$ui_text$annotations() {
    }

    private final Paint getComposePaint() {
        Paint v0 = this.backingComposePaint;
        if(v0 != null) {
            return v0;
        }

        v0 = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = v0;
        return v0;
    }

    public final State getShaderState$ui_text() {
        return this.shaderState;
    }

    public final Shadow getShadow$ui_text() {
        return this.shadow;
    }

    public static void getShadow$ui_text$annotations() {
    }

    public final void setBlendMode-s9anfk8(int arg2) {
        if(BlendMode.equals-impl0(arg2, this.backingBlendMode)) {
            return;
        }

        this.getComposePaint().setBlendMode-s9anfk8(arg2);
        this.backingBlendMode = arg2;
    }

    public final void setBrush$ui_text(Brush arg1) {
        this.brush = arg1;
    }

    public final void setBrush-12SF9DM(Brush arg3, long arg4, float arg6) {
        Object v4_1;
        if(arg3 == null) {
            this.clearShader();
            return;
        }

        if((arg3 instanceof SolidColor)) {
            this.setColor-8_81llA(TextDrawStyleKt.modulate-DxMtmZc(((SolidColor)arg3).getValue-0d7_KjU(), arg6));
            return;
        }

        if((arg3 instanceof ShaderBrush)) {
            if(Intrinsics.areEqual(this.brush, arg3)) {
                Size v0 = this.brushSize;
                boolean v0_1 = v0 == null ? false : Size.equals-impl0(v0.unbox-impl(), arg4);
                if(v0_1) {
                    goto label_30;
                }

                goto label_21;
            }
            else {
            label_21:
                if(arg4 == 0x7FC000007FC00000L) {
                    goto label_30;
                }

                this.brush = arg3;
                this.brushSize = Size.box-impl(arg4);
                this.shaderState = SnapshotStateKt.derivedStateOf(new AndroidTextPaint$$ExternalSyntheticLambda0(arg3, arg4));
            }

        label_30:
            Paint v3 = this.getComposePaint();
            State v4 = this.shaderState;
            Color v5 = null;
            if(v4 != null) {
                v4_1 = v4.getValue();
            }
            else {
                Shader v4_2 = ((Shader)v5);
            }

            v3.setShader(((Shader)v4_1));
            this.lastColor = v5;
            AndroidTextPaint_androidKt.setAlpha(((TextPaint)this), arg6);
            return;
        }

        throw new NoWhenBranchMatchedException();
    }

    public static void setBrush-12SF9DM$default(AndroidTextPaint arg0, Brush arg1, long arg2, float arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg4 = NaNf;
        }

        arg0.setBrush-12SF9DM(arg1, arg2, arg4);
    }

    public final void setBrushSize-iaC8Vc4$ui_text(Size arg1) {
        this.brushSize = arg1;
    }

    static final Shader setBrush_12SF9DM$lambda$0(Brush arg0, long arg1) {
        return ((ShaderBrush)arg0).createShader-uvyYCjk(arg1);
    }

    public final void setColor-8_81llA(long arg3) {
        Color v0 = this.lastColor;
        boolean v0_1 = v0 == null ? false : Color.equals-impl0(v0.unbox-impl(), arg3);
        if(!v0_1 && arg3 != 16) {
            this.lastColor = Color.box-impl(arg3);
            this.setColor(ColorKt.toArgb-8_81llA(arg3));
            this.clearShader();
        }
    }

    public final void setDrawStyle(DrawStyle arg3) {
        if(arg3 == null) {
        }
        else if(!Intrinsics.areEqual(this.drawStyle, arg3)) {
            this.drawStyle = arg3;
            if(Intrinsics.areEqual(arg3, Fill.INSTANCE)) {
                this.setStyle(Paint$Style.FILL);
                return;
            }
            else if((arg3 instanceof Stroke)) {
                this.getComposePaint().setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
                this.getComposePaint().setStrokeWidth(((Stroke)arg3).getWidth());
                this.getComposePaint().setStrokeMiterLimit(((Stroke)arg3).getMiter());
                this.getComposePaint().setStrokeJoin-Ww9F2mQ(((Stroke)arg3).getJoin-LxFBmk8());
                this.getComposePaint().setStrokeCap-BeK7IIE(((Stroke)arg3).getCap-KaPHkGw());
                this.getComposePaint().setPathEffect(((Stroke)arg3).getPathEffect());
                return;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final void setShaderState$ui_text(State arg1) {
        this.shaderState = arg1;
    }

    public final void setShadow(Shadow arg6) {
        if(arg6 == null) {
        }
        else if(!Intrinsics.areEqual(this.shadow, arg6)) {
            this.shadow = arg6;
            if(Intrinsics.areEqual(arg6, Shadow.Companion.getNone())) {
                this.clearShadowLayer();
                return;
            }
            else {
                this.setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Float.intBitsToFloat(((int)(this.shadow.getOffset-F1C5BW0() >> 0x20))), Float.intBitsToFloat(((int)(this.shadow.getOffset-F1C5BW0() & 0xFFFFFFFFL))), ColorKt.toArgb-8_81llA(this.shadow.getColor-0d7_KjU()));
            }
        }
    }

    public final void setShadow$ui_text(Shadow arg1) {
        this.shadow = arg1;
    }

    public final void setTextDecoration(TextDecoration arg2) {
        if(arg2 == null) {
        }
        else if(!Intrinsics.areEqual(this.textDecoration, arg2)) {
            this.textDecoration = arg2;
            this.setUnderlineText(arg2.contains(TextDecoration.Companion.getUnderline()));
            this.setStrikeThruText(this.textDecoration.contains(TextDecoration.Companion.getLineThrough()));
        }
    }
}

