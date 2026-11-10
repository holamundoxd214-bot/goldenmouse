package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow$Companion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BB-\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\n\u0010\u000EB-\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\n\u0010\u0011B[\b\u0017\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0014\b\u0002\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u001A\u001A\u00020\u001B\u0012\u0006\u0010\u001C\u001A\u00020\u001D¢\u0006\u0004\b\n\u0010\u001EB[\b\u0017\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u001A\u001A\u00020\u001B\u0012\u0006\u0010\u001F\u001A\u00020 \u0012\u0014\b\u0002\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\n\u0010!B[\b\u0017\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u001A\u001A\u00020\u001B\u0012\u0006\u0010\u001F\u001A\u00020 \u0012\u0014\b\u0002\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\n\u0010\"B[\b\u0016\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u001A\u001A\u00020\u001B\u0012\u0006\u0010\u001F\u001A\u00020 \u0012\u0014\b\u0002\u0010\u0016\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010#J9\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020E2\b\b\u0002\u0010F\u001A\u00020G2\n\b\u0002\u0010H\u001A\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001A\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bL\u0010MJM\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020E2\b\b\u0002\u0010F\u001A\u00020G2\n\b\u0002\u0010H\u001A\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001A\u0004\u0018\u00010K2\n\b\u0002\u0010N\u001A\u0004\u0018\u00010O2\b\b\u0002\u0010P\u001A\u00020Q¢\u0006\u0004\bR\u0010SJU\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020E2\u0006\u0010T\u001A\u00020U2\b\b\u0002\u0010V\u001A\u00020\u00102\n\b\u0002\u0010H\u001A\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001A\u0004\u0018\u00010K2\n\b\u0002\u0010N\u001A\u0004\u0018\u00010O2\b\b\u0002\u0010P\u001A\u00020Q¢\u0006\u0004\bW\u0010XJ\u0016\u0010Y\u001A\u00020Z2\u0006\u0010[\u001A\u00020\u00072\u0006\u0010\\\u001A\u00020\u0007J\u000E\u0010]\u001A\u00020\u00072\u0006\u0010^\u001A\u00020\u0010J\u0015\u0010_\u001A\u00020\u00072\u0006\u0010`\u001A\u00020a¢\u0006\u0004\bb\u0010cJ%\u0010d\u001A\u00020e2\u0006\u0010f\u001A\u00020<2\u0006\u0010g\u001A\u00020h2\u0006\u0010i\u001A\u00020j¢\u0006\u0004\bk\u0010lJ\u000E\u0010m\u001A\u00020<2\u0006\u0010n\u001A\u00020\u0007J\'\u0010o\u001A\u00020p2\u0006\u0010q\u001A\u00020e2\u0006\u0010r\u001A\u00020p2\b\b\u0001\u0010s\u001A\u00020\u0007¢\u0006\u0004\bt\u0010uJ\u0016\u0010v\u001A\u00020\u00102\u0006\u0010n\u001A\u00020\u00072\u0006\u0010w\u001A\u00020\rJ\u000E\u0010x\u001A\u00020y2\u0006\u0010n\u001A\u00020\u0007J\u000E\u0010z\u001A\u00020y2\u0006\u0010n\u001A\u00020\u0007J\u0015\u0010{\u001A\u00020e2\u0006\u0010n\u001A\u00020\u0007¢\u0006\u0004\b|\u0010}J\u000E\u0010~\u001A\u00020<2\u0006\u0010n\u001A\u00020\u0007J\u000E\u0010\u007F\u001A\u00020\u00072\u0006\u0010n\u001A\u00020\u0007J\u0010\u0010\u0080\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0010\u0010\u0082\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0010\u0010\u0083\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0010\u0010\u0084\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0010\u0010\u0085\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0010\u0010\u0086\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0010\u0010\u0087\u0001\u001A\u00020\u00102\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0010\u0010\u0088\u0001\u001A\u00020\u00072\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u001B\u0010\u0089\u0001\u001A\u00020\u00072\u0007\u0010\u0081\u0001\u001A\u00020\u00072\t\b\u0002\u0010\u008A\u0001\u001A\u00020\rJ\u0010\u0010\u008B\u0001\u001A\u00020\r2\u0007\u0010\u0081\u0001\u001A\u00020\u0007J\u0011\u0010\u008C\u0001\u001A\u00020C2\u0006\u0010n\u001A\u00020\u0007H\u0002J\u0011\u0010\u008D\u0001\u001A\u00020C2\u0006\u0010n\u001A\u00020\u0007H\u0002J\u0012\u0010\u008E\u0001\u001A\u00020C2\u0007\u0010\u0081\u0001\u001A\u00020\u0007H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0014\u0010\u0012\u001A\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b(\u0010)R\u0011\u0010*\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b+\u0010,R\u0011\u0010-\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b.\u0010,R\u0011\u0010/\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b0\u00101R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b2\u0010,R\u0011\u00103\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b4\u0010,R\u0011\u00105\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b6\u0010,R\u0011\u00107\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b8\u0010,R\u0011\u00109\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b:\u0010\'R\u0019\u0010;\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0017¢\u0006\b\n\u0000\u001A\u0004\b=\u0010>R\u001A\u0010?\u001A\b\u0012\u0004\u0012\u00020@0\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bA\u0010>¨\u0006\u008F\u0001"}, d2={"Landroidx/compose/ui/text/MultiParagraph;", "", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "maxLines", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "<init>", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "ellipsis", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "width", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getMaxLines", "()I", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "minIntrinsicWidth", "getMinIntrinsicWidth", "()F", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getWidth", "height", "getHeight", "firstBaseline", "getFirstBaseline", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "color", "Landroidx/compose/ui/graphics/Color;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getLineForVerticalPosition", "vertical", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getRangeForRect", "Landroidx/compose/ui/text/TextRange;", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getBoundingBox", "offset", "fillBoundingBoxes", "", "range", "array", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)[F", "getHorizontalPosition", "usePrimaryDirection", "getParagraphDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "getCursorRect", "getLineForOffset", "getLineLeft", "lineIndex", "getLineRight", "getLineTop", "getLineBaseline", "getLineBottom", "getLineHeight", "getLineWidth", "getLineStart", "getLineEnd", "visibleEnd", "isLineEllipsized", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MultiParagraph {
    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List paragraphInfoList;
    private final List placeholderRects;
    private final float width;

    static {
    }

    public MultiParagraph(MultiParagraphIntrinsics arg1, long arg2, int arg4, int arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg4, arg5);
    }

    @Deprecated(message="MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith="<_subannotation>") public MultiParagraph(AnnotatedString arg7, TextStyle arg8, float arg9, Density arg10, Resolver arg11, List arg12, int arg13, boolean arg14) {
        MultiParagraphIntrinsics v7 = new MultiParagraphIntrinsics(arg7, arg8, arg12, arg10, arg11);
        Companion v8 = TextOverflow.Companion;
        int v8_1 = arg14 ? v8.getEllipsis-gIe3tQ8() : v8.getClip-gIe3tQ8();
        this(v7, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(arg9), 0, 0, 13, null), arg13, v8_1, null);
    }

    public MultiParagraph(AnnotatedString arg12, TextStyle arg13, float arg14, Density arg15, Resolver arg16, List arg17, int arg18, boolean arg19, int arg20, DefaultConstructorMarker arg21) {
        int v0 = arg20;
        List v8 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg17;
        int v9 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg18;
        boolean v10 = (v0 & 0x80) != 0 ? false : arg19;
        this(arg12, arg13, arg14, arg15, arg16, v8, v9, v10);
    }

    private MultiParagraph(AnnotatedString arg7, TextStyle arg8, long arg9, Density arg11, Resolver arg12, List arg13, int arg14, int arg15) {
        this(new MultiParagraphIntrinsics(arg7, arg8, arg13, arg11, arg12), arg9, arg14, arg15, null);
    }

    public MultiParagraph(AnnotatedString arg14, TextStyle arg15, long arg16, Density arg18, Resolver arg19, List arg20, int arg21, int arg22, int arg23, DefaultConstructorMarker arg24) {
        int v0 = arg23;
        List v9 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg20;
        int v10 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg21;
        int v11 = (v0 & 0x80) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg22;
        this(arg14, arg15, arg16, arg18, arg19, v9, v10, v11, null);
    }

    public MultiParagraph(AnnotatedString arg1, TextStyle arg2, long arg3, Density arg5, Resolver arg6, List arg7, int arg8, int arg9, DefaultConstructorMarker arg10) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9);
    }

    private MultiParagraph(AnnotatedString arg7, TextStyle arg8, long arg9, Density arg11, Resolver arg12, List arg13, int arg14, boolean arg15) {
        MultiParagraphIntrinsics v7 = new MultiParagraphIntrinsics(arg7, arg8, arg13, arg11, arg12);
        Companion v8 = TextOverflow.Companion;
        int v8_1 = arg15 ? v8.getEllipsis-gIe3tQ8() : v8.getClip-gIe3tQ8();
        this(v7, arg9, arg14, v8_1, null);
    }

    public MultiParagraph(AnnotatedString arg14, TextStyle arg15, long arg16, Density arg18, Resolver arg19, List arg20, int arg21, boolean arg22, int arg23, DefaultConstructorMarker arg24) {
        int v0 = arg23;
        List v9 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg20;
        int v10 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg21;
        boolean v11 = (v0 & 0x80) != 0 ? false : arg22;
        this(arg14, arg15, arg16, arg18, arg19, v9, v10, v11, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Constructor with `ellipsis: Boolean` is deprecated, pass TextOverflow instead") public MultiParagraph(AnnotatedString arg1, TextStyle arg2, long arg3, Density arg5, Resolver arg6, List arg7, int arg8, boolean arg9, DefaultConstructorMarker arg10) {
        this(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9);
    }

    @Deprecated(message="Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith="<_subannotation>") public MultiParagraph(AnnotatedString arg7, TextStyle arg8, List arg9, int arg10, boolean arg11, float arg12, Density arg13, ResourceLoader arg14) {
        MultiParagraphIntrinsics v7 = new MultiParagraphIntrinsics(arg7, arg8, arg9, arg13, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(arg14));
        Companion v8 = TextOverflow.Companion;
        int v8_1 = arg11 ? v8.getEllipsis-gIe3tQ8() : v8.getClip-gIe3tQ8();
        this(v7, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(arg12), 0, 0, 13, null), arg10, v8_1, null);
    }

    public MultiParagraph(AnnotatedString arg10, TextStyle arg11, List arg12, int arg13, boolean arg14, float arg15, Density arg16, ResourceLoader arg17, int arg18, DefaultConstructorMarker arg19) {
        if((arg18 & 4) != 0) {
            arg12 = CollectionsKt.emptyList();
        }

        List v3 = arg12;
        if((arg18 & 8) != 0) {
            arg13 = 0x7FFFFFFF;
        }

        this(arg10, arg11, v3, arg13, false, arg15, arg16, arg17);
    }

    @Deprecated(message="MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith="<_subannotation>") public MultiParagraph(MultiParagraphIntrinsics arg14, int arg15, boolean arg16, float arg17) {
        long v8 = ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(arg17), 0, 0, 13, null);
        Companion v0 = TextOverflow.Companion;
        int v0_1 = arg16 ? v0.getEllipsis-gIe3tQ8() : v0.getClip-gIe3tQ8();
        this(arg14, v8, arg15, v0_1, null);
    }

    public MultiParagraph(MultiParagraphIntrinsics arg1, int arg2, boolean arg3, float arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 2) != 0) {
            arg2 = 0x7FFFFFFF;
        }

        this(arg1, arg2, false, arg4);
    }

    private MultiParagraph(MultiParagraphIntrinsics arg21, long arg22, int arg24, int arg25) {
        Object v6_1;
        int v12;
        float v14;
        Object v7;
        MultiParagraph v0 = this;
        super();
        MultiParagraphIntrinsics v1 = arg21;
        v0.intrinsics = v1;
        v0.maxLines = arg24;
        boolean v3 = true;
        int v4 = 0;
        int v2 = Constraints.getMinWidth-impl(arg22) != 0 || Constraints.getMinHeight-impl(arg22) != 0 ? 0 : 1;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }

        ArrayList v2_1 = new ArrayList();
        List v1_1 = v1.getInfoList$ui_text();
        int v5 = v1_1.size();
        int v11 = 0;
        float v13 = 0f;
        int v6 = 0;
        while(true) {
            if(v6 < v5) {
                v7 = v1_1.get(v6);
                ParagraphIntrinsics v8 = ((ParagraphIntrinsicInfo)v7).getIntrinsics();
                int v15 = Constraints.getMaxWidth-impl(arg22);
                int v9 = Constraints.getHasBoundedHeight-impl(arg22) ? RangesKt.coerceAtLeast(Constraints.getMaxHeight-impl(arg22) - ParagraphKt.ceilToInt(v13), 0) : Constraints.getMaxHeight-impl(arg22);
                Paragraph v8_1 = ParagraphKt.Paragraph-czeN-Hc(v8, ConstraintsKt.Constraints$default(0, v15, 0, v9, 5, null), v0.maxLines - v11, arg25);
                v14 = v13 + v8_1.getHeight();
                v12 = v11 + v8_1.getLineCount();
                ((List)v2_1).add(new ParagraphInfo(v8_1, v7.getStartIndex(), v7.getEndIndex(), v11, v12, v13, v14));
                if(!v8_1.getDidExceedMaxLines()) {
                    if(v12 == v0.maxLines && v6 != CollectionsKt.getLastIndex(v0.intrinsics.getInfoList$ui_text())) {
                        break;
                    }

                    ++v6;
                    v11 = v12;
                    v13 = v14;
                    continue;
                }

                break;
            }
            else {
                goto label_76;
            }
        }

        v11 = v12;
        v13 = v14;
        goto label_77;
    label_76:
        v3 = false;
    label_77:
        v0.height = v13;
        v0.lineCount = v11;
        v0.didExceedMaxLines = v3;
        v0.paragraphInfoList = ((List)v2_1);
        v0.width = ((float)Constraints.getMaxWidth-impl(arg22));
        ArrayList v1_2 = new ArrayList(((List)v2_1).size());
        int v3_1 = v2_1.size();
        for(v5 = 0; true; ++v5) {
            v6_1 = null;
            if(v5 >= v3_1) {
                break;
            }

            v7 = ((List)v2_1).get(v5);
            List v8_2 = ((ParagraphInfo)v7).getParagraph().getPlaceholderRects();
            ArrayList v9_1 = new ArrayList(v8_2.size());
            int v10 = v8_2.size();
            for(v11 = 0; v11 < v10; ++v11) {
                Object v12_1 = v8_2.get(v11);
                ArrayList v13_1 = v9_1;
                if(v12_1 != null) {
                    Rect v12_2 = ((ParagraphInfo)v7).toGlobal(((Rect)v12_1));
                }
                else {
                    v12_1 = v6_1;
                }

                ((Collection)v13_1).add(v12_1);
            }

            CollectionsKt.addAll(v1_2, ((Iterable)v9_1));
        }

        if(((List)v1_2).size() < v0.intrinsics.getPlaceholders().size()) {
            v2_1 = v1_2;
            v3_1 = v0.intrinsics.getPlaceholders().size() - ((List)v1_2).size();
            v1_2 = new ArrayList(v3_1);
            while(v4 < v3_1) {
                v1_2.add(v6_1);
                ++v4;
            }

            v1_1 = CollectionsKt.plus(((Collection)v2_1), ((Iterable)v1_2));
        }

        v0.placeholderRects = ((List)v1_2);
    }

    public MultiParagraph(MultiParagraphIntrinsics arg8, long arg9, int arg11, int arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 4) != 0) {
            arg11 = 0x7FFFFFFF;
        }

        int v4 = arg11;
        if((arg13 & 8) != 0) {
            arg12 = TextOverflow.Companion.getClip-gIe3tQ8();
        }

        this(arg8, arg9, v4, arg12, null);
    }

    private MultiParagraph(MultiParagraphIntrinsics arg8, long arg9, int arg11, boolean arg12) {
        int v12 = arg12 ? TextOverflow.Companion.getEllipsis-gIe3tQ8() : TextOverflow.Companion.getClip-gIe3tQ8();
        this(arg8, arg9, arg11, v12, null);
    }

    public MultiParagraph(MultiParagraphIntrinsics arg8, long arg9, int arg11, boolean arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 4) != 0) {
            arg11 = 0x7FFFFFFF;
        }

        this(arg8, arg9, arg11, false, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Constructor with `ellipsis: Boolean` is deprecated, pass TextOverflow instead") public MultiParagraph(MultiParagraphIntrinsics arg1, long arg2, int arg4, boolean arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg4, arg5);
    }

    public final float[] fillBoundingBoxes-8ffj60Q(long arg8, float[] arg10, int arg11) {
        this.requireIndexInRange(TextRange.getMin-impl(arg8));
        this.requireIndexInRangeInclusiveEnd(TextRange.getMax-impl(arg8));
        IntRef v5 = new IntRef();
        v5.element = arg11;
        MultiParagraphKt.findParagraphsByRange-Sb-Bc2M(this.paragraphInfoList, arg8, new MultiParagraph$$ExternalSyntheticLambda0(arg8, arg10, v5, new FloatRef()));
        return arg10;
    }

    static final Unit fillBoundingBoxes_8ffj60Q$lambda$0(long arg3, float[] arg5, IntRef arg6, FloatRef arg7, ParagraphInfo arg8) {
        int v0 = arg8.getStartIndex() > TextRange.getMin-impl(arg3) ? arg8.getStartIndex() : TextRange.getMin-impl(arg3);
        int v3 = arg8.getEndIndex() < TextRange.getMax-impl(arg3) ? arg8.getEndIndex() : TextRange.getMax-impl(arg3);
        arg3 = TextRangeKt.TextRange(arg8.toLocalIndex(v0), arg8.toLocalIndex(v3));
        arg8.getParagraph().fillBoundingBoxes-8ffj60Q(arg3, arg5, arg6.element);
        v0 = arg6.element + TextRange.getLength-impl(arg3) * 4;
        for(v3 = arg6.element; v3 < v0; v3 += 4) {
            int v4 = v3 + 1;
            arg5[v4] += arg7.element;
            v4 = v3 + 3;
            arg5[v4] += arg7.element;
        }

        arg6.element = v0;
        arg7.element += arg8.getParagraph().getHeight();
        return Unit.INSTANCE;
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public final ResolvedTextDirection getBidiRunDirection(int arg3) {
        this.requireIndexInRangeInclusiveEnd(arg3);
        int v0 = this.getAnnotatedString().length();
        List v1 = this.paragraphInfoList;
        v0 = arg3 == v0 ? CollectionsKt.getLastIndex(v1) : MultiParagraphKt.findParagraphByIndex(v1, arg3);
        Object v2 = this.paragraphInfoList.get(v0);
        return ((ParagraphInfo)v2).getParagraph().getBidiRunDirection(((ParagraphInfo)v2).toLocalIndex(arg3));
    }

    public final Rect getBoundingBox(int arg2) {
        this.requireIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).toGlobal(((ParagraphInfo)v1).getParagraph().getBoundingBox(((ParagraphInfo)v1).toLocalIndex(arg2)));
    }

    public final Rect getCursorRect(int arg3) {
        this.requireIndexInRangeInclusiveEnd(arg3);
        int v0 = this.getAnnotatedString().length();
        List v1 = this.paragraphInfoList;
        v0 = arg3 == v0 ? CollectionsKt.getLastIndex(v1) : MultiParagraphKt.findParagraphByIndex(v1, arg3);
        Object v2 = this.paragraphInfoList.get(v0);
        return ((ParagraphInfo)v2).toGlobal(((ParagraphInfo)v2).getParagraph().getCursorRect(((ParagraphInfo)v2).toLocalIndex(arg3)));
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getFirstBaseline() {
        if(this.paragraphInfoList.isEmpty()) {
            return 0;
        }

        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getHorizontalPosition(int arg3, boolean arg4) {
        this.requireIndexInRangeInclusiveEnd(arg3);
        int v0 = this.getAnnotatedString().length();
        List v1 = this.paragraphInfoList;
        v0 = arg3 == v0 ? CollectionsKt.getLastIndex(v1) : MultiParagraphKt.findParagraphByIndex(v1, arg3);
        Object v2 = this.paragraphInfoList.get(v0);
        return ((ParagraphInfo)v2).getParagraph().getHorizontalPosition(((ParagraphInfo)v2).toLocalIndex(arg3), arg4);
    }

    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final float getLastBaseline() {
        if(this.paragraphInfoList.isEmpty()) {
            return 0;
        }

        Object v1 = CollectionsKt.last(this.paragraphInfoList);
        return ((ParagraphInfo)v1).toGlobalYPosition(((ParagraphInfo)v1).getParagraph().getLastBaseline());
    }

    public final float getLineBaseline(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).toGlobalYPosition(((ParagraphInfo)v1).getParagraph().getLineBaseline(((ParagraphInfo)v1).toLocalLineIndex(arg2)));
    }

    public final float getLineBottom(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).toGlobalYPosition(((ParagraphInfo)v1).getParagraph().getLineBottom(((ParagraphInfo)v1).toLocalLineIndex(arg2)));
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getLineEnd(int arg2, boolean arg3) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).toGlobalIndex(((ParagraphInfo)v1).getParagraph().getLineEnd(((ParagraphInfo)v1).toLocalLineIndex(arg2), arg3));
    }

    public static int getLineEnd$default(MultiParagraph arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.getLineEnd(arg1, false);
    }

    public final int getLineForOffset(int arg2) {
        int v0;
        if(arg2 >= this.getAnnotatedString().length()) {
            v0 = CollectionsKt.getLastIndex(this.paragraphInfoList);
        }
        else if(arg2 < 0) {
            v0 = 0;
        }
        else {
            v0 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, arg2);
        }

        Object v1 = this.paragraphInfoList.get(v0);
        return ((ParagraphInfo)v1).toGlobalLineIndex(((ParagraphInfo)v1).getParagraph().getLineForOffset(((ParagraphInfo)v1).toLocalIndex(arg2)));
    }

    public final int getLineForVerticalPosition(float arg2) {
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, arg2));
        if(((ParagraphInfo)v1).getLength() == 0) {
            return ((ParagraphInfo)v1).getStartLineIndex();
        }

        return ((ParagraphInfo)v1).toGlobalLineIndex(((ParagraphInfo)v1).getParagraph().getLineForVerticalPosition(((ParagraphInfo)v1).toLocalYPosition(arg2)));
    }

    public final float getLineHeight(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).getParagraph().getLineHeight(((ParagraphInfo)v1).toLocalLineIndex(arg2));
    }

    public final float getLineLeft(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).getParagraph().getLineLeft(((ParagraphInfo)v1).toLocalLineIndex(arg2));
    }

    public final float getLineRight(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).getParagraph().getLineRight(((ParagraphInfo)v1).toLocalLineIndex(arg2));
    }

    public final int getLineStart(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).toGlobalIndex(((ParagraphInfo)v1).getParagraph().getLineStart(((ParagraphInfo)v1).toLocalLineIndex(arg2)));
    }

    public final float getLineTop(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).toGlobalYPosition(((ParagraphInfo)v1).getParagraph().getLineTop(((ParagraphInfo)v1).toLocalLineIndex(arg2)));
    }

    public final float getLineWidth(int arg2) {
        this.requireLineIndexInRange(arg2);
        Object v1 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2));
        return ((ParagraphInfo)v1).getParagraph().getLineWidth(((ParagraphInfo)v1).toLocalLineIndex(arg2));
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForPosition-k-4lQ0M(long arg4) {
        Object v3 = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg4)))));
        if(((ParagraphInfo)v3).getLength() == 0) {
            return ((ParagraphInfo)v3).getStartIndex();
        }

        return ((ParagraphInfo)v3).toGlobalIndex(((ParagraphInfo)v3).getParagraph().getOffsetForPosition-k-4lQ0M(((ParagraphInfo)v3).toLocal-MK-Hz9U(arg4)));
    }

    public final ResolvedTextDirection getParagraphDirection(int arg3) {
        this.requireIndexInRangeInclusiveEnd(arg3);
        int v0 = this.getAnnotatedString().length();
        List v1 = this.paragraphInfoList;
        v0 = arg3 == v0 ? CollectionsKt.getLastIndex(v1) : MultiParagraphKt.findParagraphByIndex(v1, arg3);
        Object v2 = this.paragraphInfoList.get(v0);
        return ((ParagraphInfo)v2).getParagraph().getParagraphDirection(((ParagraphInfo)v2).toLocalIndex(arg3));
    }

    public final List getParagraphInfoList$ui_text() {
        return this.paragraphInfoList;
    }

    public final Path getPathForRange(int arg5, int arg6) {
        int v0 = arg5 < 0 || arg5 > arg6 || arg6 > this.getAnnotatedString().getText().length() ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Start(" + arg5 + ") or End(" + arg6 + ") is out of range [0.." + this.getAnnotatedString().getText().length() + "), or start > end!");
        }

        if(arg5 == arg6) {
            return AndroidPath_androidKt.Path();
        }

        Path v0_1 = AndroidPath_androidKt.Path();
        MultiParagraphKt.findParagraphsByRange-Sb-Bc2M(this.paragraphInfoList, TextRangeKt.TextRange(arg5, arg6), new MultiParagraph$$ExternalSyntheticLambda1(v0_1, arg5, arg6));
        return v0_1;
    }

    static final Unit getPathForRange$lambda$1(Path arg6, int arg7, int arg8, ParagraphInfo arg9) {
        Path.addPath-Uv8p0NA$default(arg6, arg9.toGlobal(arg9.getParagraph().getPathForRange(arg9.toLocalIndex(arg7), arg9.toLocalIndex(arg8))), 0, 2, null);
        return Unit.INSTANCE;
    }

    public final List getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final long getRangeForRect-8-6BmAI(Rect arg12, int arg13, TextInclusionStrategy arg14) {
        int v0 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, arg12.getTop());
        if(this.paragraphInfoList.get(v0).getBottom() < arg12.getBottom()) {
            if(v0 == CollectionsKt.getLastIndex(this.paragraphInfoList)) {
            }
            else {
                int v1 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, arg12.getBottom());
                long v2 = TextRange.Companion.getZero-d9O1mEE();
                while(TextRange.equals-impl0(v2, TextRange.Companion.getZero-d9O1mEE())) {
                    if(v0 > v1) {
                        break;
                    }

                    Object v3 = this.paragraphInfoList.get(v0);
                    v2 = ParagraphInfo.toGlobal-xdX6-G0$default(((ParagraphInfo)v3), ((ParagraphInfo)v3).getParagraph().getRangeForRect-8-6BmAI(((ParagraphInfo)v3).toLocal(arg12), arg13, arg14), false, 1, null);
                    ++v0;
                }

                if(TextRange.equals-impl0(v2, TextRange.Companion.getZero-d9O1mEE())) {
                    return TextRange.Companion.getZero-d9O1mEE();
                }

                long v4 = TextRange.Companion.getZero-d9O1mEE();
                while(TextRange.equals-impl0(v4, TextRange.Companion.getZero-d9O1mEE())) {
                    if(v0 > v1) {
                        break;
                    }

                    Object v5 = this.paragraphInfoList.get(v1);
                    v4 = ParagraphInfo.toGlobal-xdX6-G0$default(((ParagraphInfo)v5), ((ParagraphInfo)v5).getParagraph().getRangeForRect-8-6BmAI(((ParagraphInfo)v5).toLocal(arg12), arg13, arg14), false, 1, null);
                    --v1;
                }

                if(TextRange.equals-impl0(v4, TextRange.Companion.getZero-d9O1mEE())) {
                    return v2;
                }

                return TextRangeKt.TextRange(TextRange.getStart-impl(v2), TextRange.getEnd-impl(v4));
            }
        }

        Object v0_1 = this.paragraphInfoList.get(v0);
        return ParagraphInfo.toGlobal-xdX6-G0$default(((ParagraphInfo)v0_1), ((ParagraphInfo)v0_1).getParagraph().getRangeForRect-8-6BmAI(((ParagraphInfo)v0_1).toLocal(arg12), arg13, arg14), false, 1, null);
    }

    public final float getWidth() {
        return this.width;
    }

    public final long getWordBoundary--jx7JFs(int arg3) {
        this.requireIndexInRangeInclusiveEnd(arg3);
        int v0 = this.getAnnotatedString().length();
        List v1 = this.paragraphInfoList;
        v0 = arg3 == v0 ? CollectionsKt.getLastIndex(v1) : MultiParagraphKt.findParagraphByIndex(v1, arg3);
        Object v2 = this.paragraphInfoList.get(v0);
        return ((ParagraphInfo)v2).toGlobal-xdX6-G0(((ParagraphInfo)v2).getParagraph().getWordBoundary--jx7JFs(((ParagraphInfo)v2).toLocalIndex(arg3)), false);
    }

    public final boolean isLineEllipsized(int arg2) {
        this.requireLineIndexInRange(arg2);
        return this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, arg2)).getParagraph().isLineEllipsized(arg2);
    }

    public final void paint-LG529CI(Canvas arg12, long arg13, Shadow arg15, TextDecoration arg16, DrawStyle arg17, int arg18) {
        arg12.save();
        List v11 = this.paragraphInfoList;
        int v0 = v11.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = v11.get(v1);
            ((ParagraphInfo)v2).getParagraph().paint-LG529CI(arg12, arg13, arg15, arg16, arg17, arg18);
            arg12.translate(0f, ((ParagraphInfo)v2).getParagraph().getHeight());
        }

        arg12.restore();
    }

    public static void paint-LG529CI$default(MultiParagraph arg6, Canvas arg7, long arg8, Shadow arg10, TextDecoration arg11, DrawStyle arg12, int arg13, int arg14, Object arg15) {
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
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the new paint function that takes canvas as the only required parameter.") public final void paint-RPmYEkk(Canvas arg14, long arg15, Shadow arg17, TextDecoration arg18) {
        arg14.save();
        List v13 = this.paragraphInfoList;
        int v0 = v13.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = v13.get(v1);
            Paragraph.paint-LG529CI$default(((ParagraphInfo)v2).getParagraph(), arg14, arg15, arg17, arg18, null, 0, 0x30, null);
            arg14.translate(0f, ((ParagraphInfo)v2).getParagraph().getHeight());
        }

        arg14.restore();
    }

    public static void paint-RPmYEkk$default(MultiParagraph arg6, Canvas arg7, long arg8, Shadow arg10, TextDecoration arg11, int arg12, Object arg13) {
        if((arg12 & 2) != 0) {
            arg8 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v2 = arg8;
        Shadow v9 = null;
        Shadow v4 = (arg12 & 4) != 0 ? v9 : arg10;
        TextDecoration v5 = (arg12 & 8) != 0 ? ((TextDecoration)v9) : arg11;
        arg6.paint-RPmYEkk(arg7, v2, v4, v5);
    }

    public final void paint-hn5TExg(Canvas arg1, Brush arg2, float arg3, Shadow arg4, TextDecoration arg5, DrawStyle arg6, int arg7) {
        AndroidMultiParagraphDraw_androidKt.drawMultiParagraph-7AXcY_I(this, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void paint-hn5TExg$default(MultiParagraph arg8, Canvas arg9, Brush arg10, float arg11, Shadow arg12, TextDecoration arg13, DrawStyle arg14, int arg15, int arg16, Object arg17) {
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
    }

    private final void requireIndexInRange(int arg3) {
        int v0 = 0;
        if(arg3 >= 0 && arg3 < this.getAnnotatedString().getText().length()) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + arg3 + ") is out of bounds [0, " + this.getAnnotatedString().length() + ')');
        }
    }

    private final void requireIndexInRangeInclusiveEnd(int arg3) {
        int v0 = 0;
        if(arg3 >= 0 && arg3 <= this.getAnnotatedString().getText().length()) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + arg3 + ") is out of bounds [0, " + this.getAnnotatedString().length() + ']');
        }
    }

    private final void requireLineIndexInRange(int arg3) {
        int v0 = 0;
        if(arg3 >= 0 && arg3 < this.lineCount) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("lineIndex(" + arg3 + ") is out of bounds [0, " + this.lineCount + ')');
        }
    }
}

