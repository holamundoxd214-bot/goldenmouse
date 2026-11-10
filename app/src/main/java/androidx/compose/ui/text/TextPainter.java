package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle$Unspecified;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Landroidx/compose/ui/text/TextPainter;", "", "<init>", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextPainter {
    public static final int $stable;
    public static final TextPainter INSTANCE;

    static {
        TextPainter.INSTANCE = new TextPainter();
    }

    private TextPainter() {
        super();
    }

    public final void paint(Canvas arg13, TextLayoutResult arg14) {
        Object v11;
        int v10;
        MultiParagraph v2;
        Canvas v3;
        Throwable v14;
        float v0_2;
        Brush v4;
        Fill v1_4;
        int v12 = !arg14.getHasVisualOverflow() || (TextOverflow.equals-impl0(arg14.getLayoutInput().getOverflow-gIe3tQ8(), TextOverflow.Companion.getVisible-gIe3tQ8())) ? 0 : 1;
        if(v12 != 0) {
            Rect v1 = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(arg14.getSize-YbymL2g() & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)(((int)(arg14.getSize-YbymL2g() >> 0x20))))))) << 0x20));
            arg13.save();
            Canvas.clipRect-mtrdD-E$default(arg13, v1, 0, 2, null);
        }

        SpanStyle v0 = arg14.getLayoutInput().getStyle().getSpanStyle$ui_text();
        TextDecoration v1_1 = v0.getTextDecoration();
        if(v1_1 == null) {
            v1_1 = TextDecoration.Companion.getNone();
        }

        TextDecoration v7 = v1_1;
        Shadow v1_2 = v0.getShadow();
        if(v1_2 == null) {
            v1_2 = Shadow.Companion.getNone();
        }

        Shadow v6 = v1_2;
        DrawStyle v1_3 = v0.getDrawStyle();
        if(v1_3 == null) {
            v1_4 = Fill.INSTANCE;
        }

        DrawStyle v8 = ((DrawStyle)v1_4);
        try {
            v4 = v0.getBrush();
            if(v4 == null) {
                goto label_76;
            }
            else if(v0.getTextForegroundStyle$ui_text() != Unspecified.INSTANCE) {
            }
            else {
                goto label_67;
            }
        }
        catch(Throwable v0_1) {
            goto label_97;
        }

        try {
            v0_2 = v0.getTextForegroundStyle$ui_text().getAlpha();
            goto label_68;
        }
        catch(Throwable v0_1) {
            v14 = v0_1;
            v3 = arg13;
            goto label_99;
        }

    label_67:
        v0_2 = 1f;
    label_68:
        float v5 = v0_2;
        try {
            v2 = arg14.getMultiParagraph();
            v10 = 0x40;
            v11 = null;
            v3 = arg13;
        }
        catch(Throwable v0_1) {
        label_97:
            v3 = arg13;
            goto label_98;
        }

        try {
            MultiParagraph.paint-hn5TExg$default(v2, v3, v4, v5, v6, v7, v8, 0, v10, v11);
            goto label_91;
        label_76:
            v3 = arg13;
            long v0_3 = v0.getTextForegroundStyle$ui_text() != Unspecified.INSTANCE ? v0.getTextForegroundStyle$ui_text().getColor-0d7_KjU() : Color.Companion.getBlack-0d7_KjU();
            MultiParagraph.paint-LG529CI$default(arg14.getMultiParagraph(), v3, v0_3, v6, v7, v8, 0, 0x20, null);
            goto label_91;
        }
        catch(Throwable v0_1) {
        }

    label_98:
        v14 = v0_1;
    label_99:
        if(v12 != 0) {
            v3.restore();
        }

        throw v14;
    label_91:
        if(v12 != 0) {
            v3.restore();
        }
    }
}

