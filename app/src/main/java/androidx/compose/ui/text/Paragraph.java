package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0018\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u00152\u0006\u0010 \u001A\u00020\u0015H&J\u0010\u0010!\u001A\u00020\u001A2\u0006\u0010\"\u001A\u00020\u0015H&J\u0010\u0010#\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010%\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010&\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010\'\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010(\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010)\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010*\u001A\u00020\u00032\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010+\u001A\u00020\u00152\u0006\u0010$\u001A\u00020\u0015H&J\u001A\u0010,\u001A\u00020\u00152\u0006\u0010$\u001A\u00020\u00152\b\b\u0002\u0010-\u001A\u00020\u0011H&J\u0010\u0010.\u001A\u00020\u00112\u0006\u0010$\u001A\u00020\u0015H&J\u0010\u0010/\u001A\u00020\u00152\u0006\u0010\"\u001A\u00020\u0015H&J\u0018\u00100\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u00152\u0006\u00101\u001A\u00020\u0011H&J\u0010\u00102\u001A\u0002032\u0006\u0010\"\u001A\u00020\u0015H&J\u0010\u00104\u001A\u0002032\u0006\u0010\"\u001A\u00020\u0015H&J\u0010\u00105\u001A\u00020\u00152\u0006\u00106\u001A\u00020\u0003H&J\u0017\u00107\u001A\u00020\u00152\u0006\u00108\u001A\u000209H&¢\u0006\u0004\b:\u0010;J\'\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020\u001A2\u0006\u0010?\u001A\u00020@2\u0006\u0010A\u001A\u00020BH&¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001A\u00020\u001A2\u0006\u0010\"\u001A\u00020\u0015H&J)\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020=2\u0006\u0010I\u001A\u00020J2\b\b\u0001\u0010K\u001A\u00020\u0015H&¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001A\u00020=2\u0006\u0010\"\u001A\u00020\u0015H&¢\u0006\u0004\bO\u0010PJ9\u0010Q\u001A\u00020G2\u0006\u0010R\u001A\u00020S2\b\b\u0002\u0010T\u001A\u00020U2\n\b\u0002\u0010V\u001A\u0004\u0018\u00010W2\n\b\u0002\u0010X\u001A\u0004\u0018\u00010YH&¢\u0006\u0004\bZ\u0010[JO\u0010Q\u001A\u00020G2\u0006\u0010R\u001A\u00020S2\b\b\u0002\u0010T\u001A\u00020U2\n\b\u0002\u0010V\u001A\u0004\u0018\u00010W2\n\b\u0002\u0010X\u001A\u0004\u0018\u00010Y2\n\b\u0002\u0010\\\u001A\u0004\u0018\u00010]2\b\b\u0002\u0010^\u001A\u00020_H&¢\u0006\u0004\b`\u0010aJW\u0010Q\u001A\u00020G2\u0006\u0010R\u001A\u00020S2\u0006\u0010b\u001A\u00020c2\b\b\u0002\u0010d\u001A\u00020\u00032\n\b\u0002\u0010V\u001A\u0004\u0018\u00010W2\n\b\u0002\u0010X\u001A\u0004\u0018\u00010Y2\n\b\u0002\u0010\\\u001A\u0004\u0018\u00010]2\b\b\u0002\u0010^\u001A\u00020_H&¢\u0006\u0004\be\u0010fR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0005R\u0012\u0010\f\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u0005R\u0012\u0010\u000E\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0005R\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0019X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C\u0082\u0001\u0001gø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006hÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/text/Paragraph;", "", "width", "", "getWidth", "()F", "height", "getHeight", "minIntrinsicWidth", "getMinIntrinsicWidth", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "firstBaseline", "getFirstBaseline", "lastBaseline", "getLastBaseline", "didExceedMaxLines", "", "getDidExceedMaxLines", "()Z", "lineCount", "", "getLineCount", "()I", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getCursorRect", "offset", "getLineLeft", "lineIndex", "getLineRight", "getLineTop", "getLineBaseline", "getLineBottom", "getLineHeight", "getLineWidth", "getLineStart", "getLineEnd", "visibleEnd", "isLineEllipsized", "getLineForOffset", "getHorizontalPosition", "usePrimaryDirection", "getParagraphDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "getLineForVerticalPosition", "vertical", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getRangeForRect", "Landroidx/compose/ui/text/TextRange;", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getBoundingBox", "fillBoundingBoxes", "", "range", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "color", "Landroidx/compose/ui/graphics/Color;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "Landroidx/compose/ui/text/AndroidParagraph;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Paragraph {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static int getLineEnd$default(Paragraph arg0, int arg1, boolean arg2, int arg3, Object arg4) {
            return Paragraph.getLineEnd$default(arg0, arg1, arg2, arg3, arg4);
        }

        public static void paint-LG529CI$default(Paragraph arg0, Canvas arg1, long arg2, Shadow arg4, TextDecoration arg5, DrawStyle arg6, int arg7, int arg8, Object arg9) {
            Paragraph.paint-LG529CI$default(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg8, arg9);
        }

        public static void paint-RPmYEkk$default(Paragraph arg0, Canvas arg1, long arg2, Shadow arg4, TextDecoration arg5, int arg6, Object arg7) {
            Paragraph.paint-RPmYEkk$default(arg0, arg1, arg2, arg4, arg5, arg6, arg7);
        }

        public static void paint-hn5TExg$default(Paragraph arg0, Canvas arg1, Brush arg2, float arg3, Shadow arg4, TextDecoration arg5, DrawStyle arg6, int arg7, int arg8, Object arg9) {
            Paragraph.paint-hn5TExg$default(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        }
    }

    void fillBoundingBoxes-8ffj60Q(long arg1, float[] arg2, int arg3);

    ResolvedTextDirection getBidiRunDirection(int arg1);

    Rect getBoundingBox(int arg1);

    Rect getCursorRect(int arg1);

    boolean getDidExceedMaxLines();

    float getFirstBaseline();

    float getHeight();

    float getHorizontalPosition(int arg1, boolean arg2);

    float getLastBaseline();

    float getLineBaseline(int arg1);

    float getLineBottom(int arg1);

    int getLineCount();

    int getLineEnd(int arg1, boolean arg2);

    static int getLineEnd$default(Paragraph arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.getLineEnd(arg1, false);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEnd");
    }

    int getLineForOffset(int arg1);

    int getLineForVerticalPosition(float arg1);

    float getLineHeight(int arg1);

    float getLineLeft(int arg1);

    float getLineRight(int arg1);

    int getLineStart(int arg1);

    float getLineTop(int arg1);

    float getLineWidth(int arg1);

    float getMaxIntrinsicWidth();

    float getMinIntrinsicWidth();

    int getOffsetForPosition-k-4lQ0M(long arg1);

    ResolvedTextDirection getParagraphDirection(int arg1);

    Path getPathForRange(int arg1, int arg2);

    List getPlaceholderRects();

    long getRangeForRect-8-6BmAI(Rect arg1, int arg2, TextInclusionStrategy arg3);

    float getWidth();

    long getWordBoundary--jx7JFs(int arg1);

    boolean isLineEllipsized(int arg1);

    void paint-LG529CI(Canvas arg1, long arg2, Shadow arg3, TextDecoration arg4, DrawStyle arg5, int arg6);

    static void paint-LG529CI$default(Paragraph arg6, Canvas arg7, long arg8, Shadow arg10, TextDecoration arg11, DrawStyle arg12, int arg13, int arg14, Object arg15) {
        if(arg15 == null) {
            long v0 = (arg14 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg8;
            DrawStyle v3 = null;
            Shadow v2 = (arg14 & 4) != 0 ? ((Shadow)v3) : arg10;
            TextDecoration v4 = (arg14 & 8) != 0 ? ((TextDecoration)v3) : arg11;
            if((arg14 & 16) != 0) {
            }
            else {
                v3 = arg12;
            }

            int v15 = (arg14 & 0x20) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg13;
            arg6.paint-LG529CI(arg7, v0, v2, v4, v3, v15);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-LG529CI");
    }

    void paint-RPmYEkk(Canvas arg1, long arg2, Shadow arg3, TextDecoration arg4);

    static void paint-RPmYEkk$default(Paragraph arg6, Canvas arg7, long arg8, Shadow arg10, TextDecoration arg11, int arg12, Object arg13) {
        if(arg13 == null) {
            if((arg12 & 2) != 0) {
                arg8 = Color.Companion.getUnspecified-0d7_KjU();
            }

            long v2 = arg8;
            Shadow v9 = null;
            Shadow v4 = (arg12 & 4) != 0 ? v9 : arg10;
            TextDecoration v5 = (arg12 & 8) != 0 ? ((TextDecoration)v9) : arg11;
            arg6.paint-RPmYEkk(arg7, v2, v4, v5);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-RPmYEkk");
    }

    void paint-hn5TExg(Canvas arg1, Brush arg2, float arg3, Shadow arg4, TextDecoration arg5, DrawStyle arg6, int arg7);

    static void paint-hn5TExg$default(Paragraph arg8, Canvas arg9, Brush arg10, float arg11, Shadow arg12, TextDecoration arg13, DrawStyle arg14, int arg15, int arg16, Object arg17) {
        if(arg17 == null) {
            if((arg16 & 4) != 0) {
                arg11 = NaNf;
            }

            float v3 = arg11;
            Shadow v0 = null;
            Shadow v4 = (arg16 & 8) != 0 ? v0 : arg12;
            TextDecoration v5 = (arg16 & 16) != 0 ? ((TextDecoration)v0) : arg13;
            DrawStyle v6 = (arg16 & 0x20) != 0 ? ((DrawStyle)v0) : arg14;
            int v7 = (arg16 & 0x40) != 0 ? DrawScope.Companion.getDefaultBlendMode-0nO6VwU() : arg15;
            arg8.paint-hn5TExg(arg9, arg10, v3, v4, v5, v6, v7);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-hn5TExg");
    }
}

