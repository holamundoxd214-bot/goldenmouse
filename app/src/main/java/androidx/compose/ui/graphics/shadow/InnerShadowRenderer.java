package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositeShaderBrush;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\u0011\u001A\u00020\u000FH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001A\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u0018\u0010\u001F\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020!H\u0002JQ\u0010\"\u001A\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010#\u001A\u00020$2\b\u0010%\u001A\u0004\u0018\u00010&2\b\u0010 \u001A\u0004\u0018\u00010!2\u0006\u0010\'\u001A\u00020(H\u0014¢\u0006\u0004\b)\u0010*J?\u0010+\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010,\u001A\u00020$2\u0006\u0010-\u001A\u00020$2\u0006\u0010.\u001A\u00020$2\u0006\u0010/\u001A\u00020$H\u0002¢\u0006\u0004\b0\u00101J?\u00102\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010,\u001A\u00020$2\u0006\u0010-\u001A\u00020$2\u0006\u0010.\u001A\u00020$2\u0006\u0010/\u001A\u00020$2\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¢\u0006\u0004\b3\u00104R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0010¨\u00065"}, d2={"Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowMask", "Landroidx/compose/ui/graphics/ShaderBrush;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "obtainMatrix", "obtainMatrix-sQKQjiQ", "()[F", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "path", "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createInnerPathShadowBrush", "radius", "spread", "offsetX", "offsetY", "createInnerPathShadowBrush-LjSzlW0", "(JLandroidx/compose/ui/graphics/Path;FFFF)Landroidx/compose/ui/graphics/ShaderBrush;", "createInnerShadowBrush", "createInnerShadowBrush-u1Psq-8", "(JFFFFJ)Landroidx/compose/ui/graphics/ShaderBrush;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InnerShadowRenderer extends ShadowRenderer {
    public static final int $stable = 8;
    private CompositeShaderBrush compositeShader;
    private float[] matrix;
    private final Paint paint;
    private final Shadow shadow;
    private ShaderBrush shadowMask;

    static {
    }

    public InnerShadowRenderer(Shadow arg1, Outline arg2) {
        super(arg2);
        this.shadow = arg1;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    protected void buildShadow-_SMYjrA(DrawScope arg10, long arg11, long arg13, Path arg15) {
        float v3 = arg10.toPx-0680j_4(this.shadow.getRadius-D9Ej5fM());
        float v4 = arg10.toPx-0680j_4(this.shadow.getSpread-D9Ej5fM());
        float v5 = arg10.toPx-0680j_4(DpOffset.getX-D9Ej5fM(this.shadow.getOffset-RKDOV3M()));
        float v6 = arg10.toPx-0680j_4(DpOffset.getY-D9Ej5fM(this.shadow.getOffset-RKDOV3M()));
        ShaderBrush v1 = arg15 != null ? this.createInnerPathShadowBrush-LjSzlW0(arg11, arg15, v3, v4, v5, v6) : this.createInnerShadowBrush-u1Psq-8(arg11, v3, v4, v5, v6, arg13);
        this.shadowMask = v1;
    }

    private final ShaderBrush createInnerPathShadowBrush-LjSzlW0(long arg25, Path arg27, float arg28, float arg29, float arg30, float arg31) {
        ImageBitmap v9_1;
        InnerShadowRenderer v0 = this;
        Path v1 = arg27;
        float v2 = arg28;
        int v3 = 0x20;
        int v4 = ((int)(((float)Math.ceil(((double)Float.intBitsToFloat(((int)(arg25 >> v3))))))));
        long v5 = 0xFFFFFFFFL;
        int v7 = ((int)(((float)Math.ceil(((double)Float.intBitsToFloat(((int)(arg25 & v5))))))));
        Object v10 = null;
        if(Float.compare(arg29, 0f) > 0) {
            Rect v9 = v1.getBounds();
            float v11 = v9.getRight() - v9.getLeft();
            float v12 = v9.getBottom() - v9.getTop();
            v9_1 = ImageBitmapKt.ImageBitmap-x__-hDU$default(((int)(((float)Math.ceil(((double)v11))))), ((int)(((float)Math.ceil(((double)v12))))), ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, null, 24, null);
            Canvas v13 = CanvasKt.Canvas(v9_1);
            v13.drawPath(v1, v0.paint);
            Canvas.clipRect-N_I0leg$default(v13, 0f, 0f, v11, v12, 0, 16, null);
            Paint v11_1 = BlurKt.configureShadow-FoewPVk$default(v0.paint, 0, BlendMode.Companion.getClear-0nO6VwU(), null, PaintingStyle.Companion.getStroke-TiuSbCo(), 5, null);
            v11_1.setStrokeWidth(2f * arg29);
            v13.drawPath(v1, v11_1);
        }
        else {
            v9_1 = ((ImageBitmap)v10);
        }

        int v11_2 = (((int)(((float)Math.ceil(((double)v2)))))) * 2;
        ImageBitmap v4_1 = ImageBitmapKt.ImageBitmap-x__-hDU$default(v4 + v11_2, v7 + v11_2, ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, null, 24, null);
        Canvas v11_3 = CanvasKt.Canvas(v4_1);
        v7 = 6;
        if(v9_1 != null) {
            v11_3.drawRect(0f, 0f, ((float)v4_1.getWidth()), ((float)v4_1.getHeight()), BlurKt.configureShadow-FoewPVk$default(v0.paint, 0, 0, null, 0, 15, null));
            v5 = Offset.constructor-impl(v5 & (((long)Float.floatToRawIntBits(arg31))) | (((long)Float.floatToRawIntBits(arg30))) << v3);
            Paint v0_1 = v0.paint;
            BlurMaskFilter v2_1 = v2 > 0f ? Blur_androidKt.BlurFilter(v2) : ((BlurMaskFilter)v10);
            v11_3.drawImage-d-4ec7I(v9_1, v5, BlurKt.configureShadow-FoewPVk$default(v0_1, 0, BlendMode.Companion.getXor-0nO6VwU(), v2_1, 0, 9, null));
            return BrushKt.ShaderBrush(ShaderKt.ImageShader-F49vj9s$default(v4_1, 0, 0, v7, v10));
        }

        v11_3.save();
        v11_3.translate(arg30, arg31);
        Paint v12_1 = v0.paint;
        BlurMaskFilter v16 = v2 > 0f ? Blur_androidKt.BlurFilter(v2) : ((BlurMaskFilter)v10);
        v11_3.drawPath(v1, BlurKt.configureShadow-FoewPVk$default(v12_1, 0, 0, v16, 0, 11, null));
        v11_3.restore();
        v11_3.drawRect(0f, 0f, ((float)v4_1.getWidth()), ((float)v4_1.getHeight()), BlurKt.configureShadow-FoewPVk$default(v0.paint, 0, BlendMode.Companion.getXor-0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.ImageShader-F49vj9s$default(v4_1, 0, 0, v7, v10));
    }

    private final ShaderBrush createInnerShadowBrush-u1Psq-8(long arg19, float arg21, float arg22, float arg23, float arg24, long arg25) {
        InnerShadowRenderer v0 = this;
        int v2 = ((int)(arg19 >> 0x20));
        int v3 = ((int)(arg19 & 0xFFFFFFFFL));
        ImageBitmap v4 = ImageBitmapKt.ImageBitmap-x__-hDU$default(((int)(((float)Math.ceil(((double)Float.intBitsToFloat(v2)))))), ((int)(((float)Math.ceil(((double)Float.intBitsToFloat(v3)))))), ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, null, 24, null);
        Canvas v5 = CanvasKt.Canvas(v4);
        float v6 = arg23 + arg22;
        float v7 = arg24 + arg22;
        float v2_1 = Math.max(v6, arg23 + Float.intBitsToFloat(v2) - arg22);
        float v3_1 = Math.max(v7, arg24 + Float.intBitsToFloat(v3) - arg22);
        float v1 = Float.intBitsToFloat(((int)(arg25 >> 0x20)));
        float v8 = Float.intBitsToFloat(((int)(arg25 & 0xFFFFFFFFL)));
        Paint v9 = v0.paint;
        Object v11 = null;
        BlurMaskFilter v10 = Float.compare(arg21, 0f) > 0 ? Blur_androidKt.BlurFilter(arg21) : ((BlurMaskFilter)v11);
        v5.drawRoundRect(v6, v7, v2_1, v3_1, v1, v8, BlurKt.configureShadow-FoewPVk$default(v9, 0, 0, v10, 0, 11, null));
        v5.drawRect(0f, 0f, ((float)v4.getWidth()), ((float)v4.getHeight()), BlurKt.configureShadow-FoewPVk$default(v0.paint, 0, BlendMode.Companion.getXor-0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.ImageShader-F49vj9s$default(v4, 0, 0, 6, v11));
    }

    private final CompositeShaderBrush obtainCompositeBrush(ShaderBrush arg4, Brush arg5) {
        CompositeShaderBrush v0 = this.compositeShader;
        if(v0 != null) {
            if(!Intrinsics.areEqual(v0.getSrcBrush(), arg5)) {
            }
            else {
                return v0;
            }
        }

        v0 = new CompositeShaderBrush(BrushKt.toShaderBrush(((Brush)arg4)), BrushKt.toShaderBrush(arg5), BlendMode.Companion.getSrcIn-0nO6VwU(), null);
        this.compositeShader = v0;
        return v0;
    }

    private final float[] obtainMatrix-sQKQjiQ() {
        float[] v0 = this.matrix;
        if(v0 == null) {
            v0 = Matrix.constructor-impl$default(null, 1, null);
            this.matrix = v0;
        }

        return v0;
    }

    protected void onDrawShadow-MLmccfk(DrawScope arg26, long arg27, long arg29, Path arg31, float arg32, ColorFilter arg33, Brush arg34, int arg35) {
        InnerShadowRenderer v0 = this;
        ShaderBrush v1 = v0.shadowMask;
        if(v1 != null) {
            if((v0.shadow.getBrush() instanceof ShaderBrush)) {
                CompositeShaderBrush v1_1 = v0.obtainCompositeBrush(v1, v0.shadow.getBrush());
            }

            if(arg31 != null) {
                DrawScope.drawPath-GBMwjPU$default(arg26, arg31, v1, arg32, null, arg33, arg35, 8, null);
                return;
            }

            long v4 = arg29;
            if(CornerRadius.equals-impl0(v4, CornerRadius.Companion.getZero-kKHJgLs())) {
                DrawScope.drawRect-AsUm42w$default(arg26, v1, 0, 0, arg32, null, arg33, arg35, 22, null);
                return;
            }

            DrawScope.drawRoundRect-ZuiqVtQ$default(arg26, v1, 0, 0, v4, arg32, null, arg33, v0.shadow.getBlendMode-0nO6VwU(), 38, null);
        }
    }
}

