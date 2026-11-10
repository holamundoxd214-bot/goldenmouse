package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A}\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u0014\b\u0002\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\b\b\u0002\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001A\u001Ag\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u001B2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b\u001C\u0010\u001D\u001Ae\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020#2\n\b\u0002\u0010$\u001A\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001A\u0004\u0018\u00010\'2\n\b\u0002\u0010(\u001A\u0004\u0018\u00010)2\b\b\u0002\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b*\u0010+\u001Ac\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010,\u001A\u00020-2\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\"\u001A\u00020#2\n\b\u0002\u0010$\u001A\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001A\u0004\u0018\u00010\'2\n\b\u0002\u0010(\u001A\u0004\u0018\u00010)2\b\b\u0002\u0010\u0017\u001A\u00020\u0018¢\u0006\u0004\b.\u0010/\u001A\u0014\u00100\u001A\u00020\u0001*\u0002012\u0006\u0010\u001E\u001A\u00020\u001FH\u0002\u001A#\u00102\u001A\u000203*\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0007\u001A\u00020\bH\u0002¢\u0006\u0004\b4\u00105¨\u00066"}, d2={"drawText", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "clip", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextPainterKt {
    private static final void clip(DrawTransform arg9, TextLayoutResult arg10) {
        if((arg10.getHasVisualOverflow()) && !TextOverflow.equals-impl0(arg10.getLayoutInput().getOverflow-gIe3tQ8(), TextOverflow.Companion.getVisible-gIe3tQ8())) {
            DrawTransform.clipRect-N_I0leg$default(arg9, 0f, 0f, ((float)(((int)(arg10.getSize-YbymL2g() >> 0x20)))), ((float)(((int)(arg10.getSize-YbymL2g() & 0xFFFFFFFFL)))), 0, 16, null);
        }
    }

    public static final void drawText-JFhB2K4(DrawScope arg18, TextMeasurer arg19, AnnotatedString arg20, long arg21, TextStyle arg23, int arg24, boolean arg25, int arg26, List arg27, long arg28, int arg30) {
        DrawScope v0 = arg18;
        long v1 = arg21;
        TextLayoutResult v3 = TextMeasurer.measure-xDpz5zY$default(arg19, arg20, arg23, arg24, arg25, arg26, arg27, TextPainterKt.textLayoutConstraints-v_w8tDc(v0, arg28, v1), v0.getLayoutDirection(), v0, null, false, 0x600, null);
        DrawContext v4 = v0.getDrawContext();
        long v5 = v4.getSize-NH-jbRc();
        v4.getCanvas().save();
        try {
            DrawTransform v7 = v4.getTransform();
            v7.translate(Float.intBitsToFloat(((int)(v1 >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))));
            TextPainterKt.clip(v7, v3);
            MultiParagraph.paint-LG529CI$default(v3.getMultiParagraph(), v0.getDrawContext().getCanvas(), 0, null, null, null, arg30, 30, null);
        }
        catch(Throwable v0_1) {
            v4.getCanvas().restore();
            v4.setSize-uvyYCjk(v5);
            throw v0_1;
        }

        v4.getCanvas().restore();
        v4.setSize-uvyYCjk(v5);
    }

    public static void drawText-JFhB2K4$default(DrawScope arg16, TextMeasurer arg17, AnnotatedString arg18, long arg19, TextStyle arg21, int arg22, boolean arg23, int arg24, List arg25, long arg26, int arg28, int arg29, Object arg30) {
        int v0 = arg29;
        long v6 = (v0 & 4) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg19;
        TextStyle v8 = (v0 & 8) != 0 ? TextStyle.Companion.getDefault() : arg21;
        int v9 = (v0 & 16) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg22;
        boolean v10 = (v0 & 0x20) != 0 ? true : arg23;
        int v11 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg24;
        List v12 = (v0 & 0x80) != 0 ? CollectionsKt.emptyList() : arg25;
        long v13 = (v0 & 0x100) != 0 ? Size.Companion.getUnspecified-NH-jbRc() : arg26;
        int v15 = (v0 & 0x200) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg28;
        TextPainterKt.drawText-JFhB2K4(arg16, arg17, arg18, v6, v8, v9, v10, v11, v12, v13, v15);
    }

    public static final void drawText-LVfH_YU(DrawScope arg12, TextLayoutResult arg13, Brush arg14, long arg15, float arg17, Shadow arg18, TextDecoration arg19, DrawStyle arg20, int arg21) {
        Shadow v5 = arg18 == null ? arg13.getLayoutInput().getStyle().getShadow() : arg18;
        TextDecoration v6 = arg19 == null ? arg13.getLayoutInput().getStyle().getTextDecoration() : arg19;
        DrawStyle v7 = arg20 == null ? arg13.getLayoutInput().getStyle().getDrawStyle() : arg20;
        DrawContext v9 = arg12.getDrawContext();
        long v10 = v9.getSize-NH-jbRc();
        v9.getCanvas().save();
        try {
            DrawTransform v0_1 = v9.getTransform();
            v0_1.translate(Float.intBitsToFloat(((int)(arg15 >> 0x20))), Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg15))));
            TextPainterKt.clip(v0_1, arg13);
            MultiParagraph v1 = arg13.getMultiParagraph();
            Canvas v2 = arg12.getDrawContext().getCanvas();
            float v4 = !Float.isNaN(arg17) ? arg17 : arg13.getLayoutInput().getStyle().getAlpha();
            Brush v3 = arg14;
            int v8 = arg21;
            v1.paint-hn5TExg(v2, v3, v4, v5, v6, v7, v8);
        }
        catch(Throwable v0) {
            v9.getCanvas().restore();
            v9.setSize-uvyYCjk(v10);
            throw v0;
        }

        v9.getCanvas().restore();
        v9.setSize-uvyYCjk(v10);
    }

    public static void drawText-LVfH_YU$default(DrawScope arg13, TextLayoutResult arg14, Brush arg15, long arg16, float arg18, Shadow arg19, TextDecoration arg20, DrawStyle arg21, int arg22, int arg23, Object arg24) {
        int v0 = arg23;
        long v6 = (v0 & 4) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg16;
        float v8 = (v0 & 8) != 0 ? NaNf : arg18;
        Shadow v2 = null;
        Shadow v9 = (v0 & 16) != 0 ? v2 : arg19;
        TextDecoration v10 = (v0 & 0x20) != 0 ? ((TextDecoration)v2) : arg20;
        DrawStyle v11 = (v0 & 0x40) != 0 ? ((DrawStyle)v2) : arg21;
        int v12 = (v0 & 0x80) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg22;
        TextPainterKt.drawText-LVfH_YU(arg13, arg14, arg15, v6, v8, v9, v10, v11, v12);
    }

    public static final void drawText-TPWCCtM(DrawScope arg18, TextMeasurer arg19, String arg20, long arg21, TextStyle arg23, int arg24, boolean arg25, int arg26, long arg27, int arg29) {
        DrawScope v0 = arg18;
        long v1 = arg21;
        TextLayoutResult v3 = TextMeasurer.measure-xDpz5zY$default(arg19, new AnnotatedString(arg20, null, 2, null), arg23, arg24, arg25, arg26, null, TextPainterKt.textLayoutConstraints-v_w8tDc(v0, arg27, v1), v0.getLayoutDirection(), v0, null, false, 0x620, null);
        DrawContext v4 = v0.getDrawContext();
        long v5 = v4.getSize-NH-jbRc();
        v4.getCanvas().save();
        try {
            DrawTransform v7 = v4.getTransform();
            v7.translate(Float.intBitsToFloat(((int)(v1 >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))));
            TextPainterKt.clip(v7, v3);
            MultiParagraph.paint-LG529CI$default(v3.getMultiParagraph(), v0.getDrawContext().getCanvas(), 0, null, null, null, arg29, 30, null);
        }
        catch(Throwable v0_1) {
            v4.getCanvas().restore();
            v4.setSize-uvyYCjk(v5);
            throw v0_1;
        }

        v4.getCanvas().restore();
        v4.setSize-uvyYCjk(v5);
    }

    public static void drawText-TPWCCtM$default(DrawScope arg15, TextMeasurer arg16, String arg17, long arg18, TextStyle arg20, int arg21, boolean arg22, int arg23, long arg24, int arg26, int arg27, Object arg28) {
        int v0 = arg27;
        long v6 = (v0 & 4) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg18;
        TextStyle v8 = (v0 & 8) != 0 ? TextStyle.Companion.getDefault() : arg20;
        int v9 = (v0 & 16) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg21;
        boolean v10 = (v0 & 0x20) != 0 ? true : arg22;
        int v11 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg23;
        long v12 = (v0 & 0x80) != 0 ? Size.Companion.getUnspecified-NH-jbRc() : arg24;
        int v14 = (v0 & 0x100) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg26;
        TextPainterKt.drawText-TPWCCtM(arg15, arg16, arg17, v6, v8, v9, v10, v11, v12, v14);
    }

    public static final void drawText-d8-rzKo(DrawScope arg10, TextLayoutResult arg11, long arg12, long arg14, float arg16, Shadow arg17, TextDecoration arg18, DrawStyle arg19, int arg20) {
        DrawStyle v16;
        TextDecoration v15;
        Shadow v14;
        int v17;
        MultiParagraph v10_1;
        Canvas v11;
        float v13;
        Canvas v10;
        Shadow v0 = arg17 == null ? arg11.getLayoutInput().getStyle().getShadow() : arg17;
        TextDecoration v1 = arg18 == null ? arg11.getLayoutInput().getStyle().getTextDecoration() : arg18;
        DrawStyle v2 = arg19 == null ? arg11.getLayoutInput().getStyle().getDrawStyle() : arg19;
        DrawContext v3 = arg10.getDrawContext();
        long v4 = v3.getSize-NH-jbRc();
        v3.getCanvas().save();
        try {
            DrawTransform v6 = v3.getTransform();
            v6.translate(Float.intBitsToFloat(((int)(arg14 >> 0x20))), Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg14))));
            TextPainterKt.clip(v6, arg11);
            Brush v6_1 = arg11.getLayoutInput().getStyle().getBrush();
            long v7 = 16;
            if(v6_1 == null || arg12 != v7) {
                MultiParagraph v6_2 = arg11.getMultiParagraph();
                v10 = arg10.getDrawContext().getCanvas();
                if(arg12 == v7) {
                    arg12 = arg11.getLayoutInput().getStyle().getColor-0d7_KjU();
                }

                float v11_1 = arg16;
                v6_2.paint-LG529CI(v10, TextDrawStyleKt.modulate-DxMtmZc(arg12, v11_1), v0, v1, v2, arg20);
            }
            else {
                MultiParagraph v12 = arg11.getMultiParagraph();
                v10 = arg10.getDrawContext().getCanvas();
                if(!Float.isNaN(arg16)) {
                    v13 = arg16;
                    v11 = v10;
                    v10_1 = v12;
                    v17 = arg20;
                    v14 = v0;
                    v15 = v1;
                    v16 = v2;
                }
                else {
                    v13 = arg11.getLayoutInput().getStyle().getAlpha();
                    v17 = arg20;
                    v14 = v0;
                    v15 = v1;
                    v16 = v2;
                    v11 = v10;
                    v10_1 = v12;
                }

                Brush v12_1 = v6_1;
                v10_1.paint-hn5TExg(v11, v12_1, v13, v14, v15, v16, v17);
            }
        }
        catch(Throwable v0_1) {
            v3.getCanvas().restore();
            v3.setSize-uvyYCjk(v4);
            throw v0_1;
        }

        v3.getCanvas().restore();
        v3.setSize-uvyYCjk(v4);
    }

    public static void drawText-d8-rzKo$default(DrawScope arg10, TextLayoutResult arg11, long arg12, long arg14, float arg16, Shadow arg17, TextDecoration arg18, DrawStyle arg19, int arg20, int arg21, Object arg22) {
        int v0 = arg21;
        long v1 = (v0 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg12;
        long v3 = (v0 & 4) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg14;
        float v5 = (v0 & 8) != 0 ? NaNf : arg16;
        DrawStyle v7 = null;
        Shadow v6 = (v0 & 16) != 0 ? ((Shadow)v7) : arg17;
        TextDecoration v8 = (v0 & 0x20) != 0 ? ((TextDecoration)v7) : arg18;
        if((v0 & 0x40) != 0) {
        }
        else {
            v7 = arg19;
        }

        int v22 = (v0 & 0x80) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg20;
        TextPainterKt.drawText-d8-rzKo(arg10, arg11, v1, v3, v5, v6, v8, v7, v22);
    }

    private static final long textLayoutConstraints-v_w8tDc(DrawScope arg8, long arg9, long arg11) {
        int v8;
        int v3;
        int v0 = Long.compare(arg9, 0x7FC000007FC00000L);
        int v1 = 0;
        int v2 = 0x20;
        if(v0 == 0 || (Float.isNaN(Float.intBitsToFloat(((int)(arg9 >> v2)))))) {
            v3 = RangesKt.coerceAtLeast(Math.round(((float)Math.ceil(((double)(Float.intBitsToFloat(((int)(arg8.getSize-NH-jbRc() >> v2))) - Float.intBitsToFloat(((int)(arg11 >> v2)))))))), 0);
            v2 = 0;
        }
        else {
            v2 = Math.round(((float)Math.ceil(((double)Float.intBitsToFloat(((int)(arg9 >> v2)))))));
            v3 = v2;
        }

        long v4 = 0xFFFFFFFFL;
        if(v0 == 0 || (Float.isNaN(Float.intBitsToFloat(((int)(arg9 & v4)))))) {
            v8 = RangesKt.coerceAtLeast(Math.round(((float)Math.ceil(((double)(Float.intBitsToFloat(((int)(arg8.getSize-NH-jbRc() & v4))) - Float.intBitsToFloat(((int)(arg11 & v4)))))))), 0);
        }
        else {
            v1 = Math.round(((float)Math.ceil(((double)Float.intBitsToFloat(((int)(arg9 & v4)))))));
            v8 = v1;
        }

        return ConstraintsKt.Constraints(v2, v3, v1, v8);
    }
}

