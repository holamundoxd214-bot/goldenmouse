package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush$Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositeShaderBrush;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0010\u001A\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001AJ\u0018\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\u001CH\u0002JQ\u0010\u001E\u001A\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010#\u001A\u00020$H\u0014¢\u0006\u0004\b%\u0010&J/\u0010\'\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010(\u001A\u00020 2\u0006\u0010)\u001A\u00020 H\u0002¢\u0006\u0004\b*\u0010+J/\u0010\'\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010,\u001A\u00020 2\u0006\u0010)\u001A\u00020 2\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "path", "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "Landroidx/compose/ui/graphics/Brush;", "brush", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createOuterShadowBitmap", "radius", "spread", "createOuterShadowBitmap-Cqks5Fs", "(JLandroidx/compose/ui/graphics/Path;FF)Landroidx/compose/ui/graphics/ImageBitmap;", "shadowRadius", "createOuterShadowBitmap-D_oqF2M", "(JFFJ)Landroidx/compose/ui/graphics/ImageBitmap;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DropShadowRenderer extends ShadowRenderer {
    public static final int $stable = 8;
    private CompositeShaderBrush compositeShader;
    private final Paint paint;
    private final Shadow shadow;
    private ImageBitmap shadowBitmap;

    static {
    }

    public DropShadowRenderer(Shadow arg1, Outline arg2) {
        super(arg2);
        this.shadow = arg1;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    protected void buildShadow-_SMYjrA(DrawScope arg8, long arg9, long arg11, Path arg13) {
        ImageBitmap v7;
        DropShadowRenderer v1;
        float v5 = arg8.toPx-0680j_4(this.shadow.getRadius-D9Ej5fM());
        float v6 = arg8.toPx-0680j_4(this.shadow.getSpread-D9Ej5fM());
        if(arg13 != null) {
            v1 = this;
            v7 = v1.createOuterShadowBitmap-Cqks5Fs(arg9, arg13, v5, v6);
        }
        else {
            v1 = this;
            v7 = this.createOuterShadowBitmap-D_oqF2M(arg9, v5, v6, arg11);
        }

        v1.shadowBitmap = v7;
    }

    private final ImageBitmap createOuterShadowBitmap-Cqks5Fs(long arg18, Path arg20, float arg21, float arg22) {
        DropShadowRenderer v0 = this;
        Path v1 = arg20;
        float v2 = arg21;
        float v3 = 2f;
        float v4 = v2 * v3 + arg22 * v3;
        ImageBitmap v4_1 = ImageBitmapKt.ImageBitmap-x__-hDU$default(((int)(((float)Math.ceil(((double)(Float.intBitsToFloat(((int)(arg18 >> 0x20))) + v4)))))), ((int)(((float)Math.ceil(((double)(Float.intBitsToFloat(((int)(arg18 & 0xFFFFFFFFL))) + v4)))))), ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, null, 24, null);
        Canvas v5 = CanvasKt.Canvas(v4_1);
        BlurMaskFilter v8 = null;
        if(Float.compare(arg22, 0f) > 0) {
            float v7 = v2 + arg22;
            v5.translate(v7, v7);
            v5.drawPath(v1, v0.paint);
            Paint v9 = v0.paint;
            int v14 = PaintingStyle.Companion.getStroke-TiuSbCo();
            if(v2 > 0f) {
                v8 = Blur_androidKt.BlurFilter(v2);
            }

            Paint v0_1 = BlurKt.configureShadow-FoewPVk$default(v9, 0, 0, v8, v14, 3, null);
            v0_1.setStrokeWidth(arg22 * v3);
            v5.drawPath(v1, v0_1);
            return v4_1;
        }

        Paint v6 = v0.paint;
        if(v2 > 0f) {
            v8 = Blur_androidKt.BlurFilter(v2);
        }

        BlurKt.configureShadow-FoewPVk$default(v6, 0, 0, v8, 0, 11, null);
        v5.translate(v2, v2);
        v5.drawPath(v1, v0.paint);
        return v4_1;
    }

    private final ImageBitmap createOuterShadowBitmap-D_oqF2M(long arg22, float arg24, float arg25, long arg26) {
        float v1 = arg24 * 2f + 2f * arg25;
        float v2 = Float.intBitsToFloat(((int)(arg22 >> 0x20))) + v1;
        float v5 = Float.intBitsToFloat(((int)(arg22 & 0xFFFFFFFFL))) + v1;
        ImageBitmap v1_1 = ImageBitmapKt.ImageBitmap-x__-hDU$default(((int)(((float)Math.ceil(((double)v2))))), ((int)(((float)Math.ceil(((double)v5))))), ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, null, 24, null);
        Canvas v6 = CanvasKt.Canvas(v1_1);
        float v9 = v2 - arg24;
        float v10 = v5 - arg24;
        float v11 = Float.intBitsToFloat(((int)(arg26 >> 0x20)));
        float v12 = Float.intBitsToFloat(((int)(arg26 & 0xFFFFFFFFL)));
        Paint v13 = this.paint;
        BlurMaskFilter v0 = arg24 > 0f ? Blur_androidKt.BlurFilter(arg24) : null;
        v6.drawRoundRect(arg24, arg24, v9, v10, v11, v12, BlurKt.configureShadow-FoewPVk$default(v13, 0, 0, v0, 0, 11, null));
        return v1_1;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    private final Brush obtainCompositeBrush(ImageBitmap arg9, Brush arg10) {
        Brush v0_2;
        ShaderBrush v10;
        CompositeShaderBrush v0 = this.compositeShader;
        if(v0 == null || !Intrinsics.areEqual(v0.getSrcBrush(), arg10)) {
            Companion v0_1 = Brush.Companion;
            ShaderBrush v1 = BrushKt.ShaderBrush(ShaderKt.ImageShader-F49vj9s$default(arg9, 0, 0, 6, null));
            if((arg10 instanceof ShaderBrush)) {
                v10 = BrushKt.ShaderBrush(((ShaderBrush)arg10).createShader-uvyYCjk(Size.constructor-impl((((long)Float.floatToRawIntBits(((float)arg9.getWidth())))) << 0x20 | (((long)Float.floatToRawIntBits(((float)arg9.getHeight())))) & 0xFFFFFFFFL)));
            }

            Brush v9 = v0_1.composite-7EN7VTw(((Brush)v1), ((Brush)v10), BlendMode.Companion.getSrcIn-0nO6VwU());
            Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type androidx.compose.ui.graphics.CompositeShaderBrush");
            v0_2 = v9;
            this.compositeShader = ((CompositeShaderBrush)v0_2);
        }

        return v0_2;
    }

    protected void onDrawShadow-MLmccfk(DrawScope arg15, long arg16, long arg18, Path arg20, float arg21, ColorFilter arg22, Brush arg23, int arg24) {
        Brush v2 = arg23;
        ImageBitmap v3 = this.shadowBitmap;
        if(v3 != null) {
            float v13 = -(arg15.toPx-0680j_4(this.shadow.getRadius-D9Ej5fM()) + arg15.toPx-0680j_4(this.shadow.getSpread-D9Ej5fM()));
            long v4 = 0xFFFFFFFFL;
            int v6 = 0x20;
            if(v2 != null && arg22 == null) {
                v2 = this.obtainCompositeBrush(v3, v2);
                arg15.getDrawContext().getTransform().translate(v13, v13);
                try {
                    DrawScope.drawRect-AsUm42w$default(arg15, v2, 0, Size.constructor-impl((((long)Float.floatToRawIntBits(((float)v3.getHeight())))) & v4 | (((long)Float.floatToRawIntBits(((float)v3.getWidth())))) << v6), arg21, null, null, arg24, 50, null);
                }
                catch(Throwable v0) {
                    float v2_1 = -v13;
                    arg15.getDrawContext().getTransform().translate(v2_1, v2_1);
                    throw v0;
                }

                float v1 = -v13;
                arg15.getDrawContext().getTransform().translate(v1, v1);
                return;
            }

            DrawScope.drawImage-gbVJVH8$default(arg15, v3, Offset.constructor-impl((((long)Float.floatToRawIntBits(v13))) << v6 | v4 & (((long)Float.floatToRawIntBits(v13)))), arg21, null, arg22, arg24, 8, null);
        }
    }
}

