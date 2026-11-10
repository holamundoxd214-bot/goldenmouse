package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A[\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001AQ\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2={"drawMultiParagraph", "", "Landroidx/compose/ui/text/MultiParagraph;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawMultiParagraph-7AXcY_I", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "drawParagraphs", "drawParagraphs-7AXcY_I", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidMultiParagraphDraw_androidKt {
    public static final void drawMultiParagraph-7AXcY_I(MultiParagraph arg14, Canvas arg15, Brush arg16, float arg17, Shadow arg18, TextDecoration arg19, DrawStyle arg20, int arg21) {
        Brush v0 = arg16;
        arg15.save();
        if(arg14.getParagraphInfoList$ui_text().size() <= 1) {
            AndroidMultiParagraphDraw_androidKt.drawParagraphs-7AXcY_I(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21);
        }
        else if((v0 instanceof SolidColor)) {
            AndroidMultiParagraphDraw_androidKt.drawParagraphs-7AXcY_I(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21);
        }
        else if((v0 instanceof ShaderBrush)) {
            List v1 = arg14.getParagraphInfoList$ui_text();
            int v2 = v1.size();
            int v3 = 0;
            int v5 = 0;
            float v6 = 0f;
            float v7 = 0f;
            while(v5 < v2) {
                Object v8 = v1.get(v5);
                v7 += ((ParagraphInfo)v8).getParagraph().getHeight();
                v6 = Math.max(v6, ((ParagraphInfo)v8).getParagraph().getWidth());
                ++v5;
            }

            Shader v0_1 = ((ShaderBrush)v0).createShader-uvyYCjk(Size.constructor-impl((((long)Float.floatToRawIntBits(v6))) << 0x20 | (((long)Float.floatToRawIntBits(v7))) & 0xFFFFFFFFL));
            Matrix v1_1 = new Matrix();
            v0_1.getLocalMatrix(v1_1);
            List v14 = arg14.getParagraphInfoList$ui_text();
            v2 = v14.size();
            while(v3 < v2) {
                Object v5_1 = v14.get(v3);
                ((ParagraphInfo)v5_1).getParagraph().paint-hn5TExg(arg15, BrushKt.ShaderBrush(v0_1), arg17, arg18, arg19, arg20, arg21);
                arg15.translate(0f, ((ParagraphInfo)v5_1).getParagraph().getHeight());
                v1_1.setTranslate(0f, -((ParagraphInfo)v5_1).getParagraph().getHeight());
                v0_1.setLocalMatrix(v1_1);
                ++v3;
            }
        }
        else {
            goto label_73;
        }

        arg15.restore();
        return;
    label_73:
        throw new NoWhenBranchMatchedException();
    }

    public static void drawMultiParagraph-7AXcY_I$default(MultiParagraph arg8, Canvas arg9, Brush arg10, float arg11, Shadow arg12, TextDecoration arg13, DrawStyle arg14, int arg15, int arg16, Object arg17) {
        if((arg16 & 4) != 0) {
            arg11 = NaNf;
        }

        float v3 = arg11;
        Shadow v0 = null;
        Shadow v4 = (arg16 & 8) != 0 ? v0 : arg12;
        TextDecoration v5 = (arg16 & 16) != 0 ? ((TextDecoration)v0) : arg13;
        DrawStyle v6 = (arg16 & 0x20) != 0 ? ((DrawStyle)v0) : arg14;
        int v7 = (arg16 & 0x40) != 0 ? BlendMode.Companion.getSrcOver-0nO6VwU() : arg15;
        AndroidMultiParagraphDraw_androidKt.drawMultiParagraph-7AXcY_I(arg8, arg9, arg10, v3, v4, v5, v6, v7);
    }

    private static final void drawParagraphs-7AXcY_I(MultiParagraph arg11, Canvas arg12, Brush arg13, float arg14, Shadow arg15, TextDecoration arg16, DrawStyle arg17, int arg18) {
        List v11 = arg11.getParagraphInfoList$ui_text();
        int v0 = v11.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = v11.get(v1);
            ((ParagraphInfo)v2).getParagraph().paint-hn5TExg(arg12, arg13, arg14, arg15, arg16, arg17, arg18);
            arg12.translate(0f, ((ParagraphInfo)v2).getParagraph().getHeight());
        }
    }
}

