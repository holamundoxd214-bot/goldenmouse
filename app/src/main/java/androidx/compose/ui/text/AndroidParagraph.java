package androidx.compose.ui.text;

import android.graphics.Paint$FontMetricsInt;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.text.Spanned;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary_androidKt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BBk\b\u0016\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0014\u0010\u0010\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u0011\u0012\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00120\u0011\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\n\u0010\u001AJ\u0010\u0010N\u001A\u00020\u00052\u0006\u0010O\u001A\u00020-H\u0016J\u0017\u0010P\u001A\u00020\u00052\u0006\u0010Q\u001A\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\'\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u00020F2\u0006\u0010X\u001A\u00020Y2\u0006\u0010Z\u001A\u00020[H\u0016¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001A\u00020F2\u0006\u0010_\u001A\u00020\u0005H\u0016J)\u0010`\u001A\u00020a2\u0006\u0010b\u001A\u00020V2\u0006\u0010c\u001A\u00020d2\b\b\u0001\u0010e\u001A\u00020\u0005H\u0016¢\u0006\u0004\bf\u0010gJ\u0018\u0010h\u001A\u00020i2\u0006\u0010j\u001A\u00020\u00052\u0006\u0010k\u001A\u00020\u0005H\u0016J\u0010\u0010l\u001A\u00020F2\u0006\u0010_\u001A\u00020\u0005H\u0016J\u0017\u0010m\u001A\u00020V2\u0006\u0010_\u001A\u00020\u0005H\u0016¢\u0006\u0004\bn\u0010oJ\u0010\u0010p\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0010\u0010r\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0010\u0010s\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0015\u0010t\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0000¢\u0006\u0002\buJ\u0010\u0010v\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0015\u0010w\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0000¢\u0006\u0002\bxJ\u0010\u0010y\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0010\u0010z\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0010\u0010{\u001A\u00020-2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0010\u0010|\u001A\u00020\u00052\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0018\u0010}\u001A\u00020\u00052\u0006\u0010q\u001A\u00020\u00052\u0006\u0010~\u001A\u00020;H\u0016J\u0010\u0010\u007F\u001A\u00020;2\u0006\u0010q\u001A\u00020\u0005H\u0016J\u0017\u0010\u0080\u0001\u001A\u00020\u00052\u0006\u0010q\u001A\u00020\u0005H\u0000¢\u0006\u0003\b\u0081\u0001J\u0017\u0010\u0082\u0001\u001A\u00020\u00052\u0006\u0010q\u001A\u00020\u0005H\u0000¢\u0006\u0003\b\u0083\u0001J\u0011\u0010\u0084\u0001\u001A\u00020\u00052\u0006\u0010_\u001A\u00020\u0005H\u0016J\u001A\u0010\u0085\u0001\u001A\u00020-2\u0006\u0010_\u001A\u00020\u00052\u0007\u0010\u0086\u0001\u001A\u00020;H\u0016J\u0012\u0010\u0087\u0001\u001A\u00030\u0088\u00012\u0006\u0010_\u001A\u00020\u0005H\u0016J\u0012\u0010\u0089\u0001\u001A\u00030\u0088\u00012\u0006\u0010_\u001A\u00020\u0005H\u0016J\u001D\u0010\u008A\u0001\u001A\f\u0012\u0005\u0012\u00030\u008C\u0001\u0018\u00010\u008B\u0001*\u00020%H\u0002¢\u0006\u0003\u0010\u008D\u0001J\u001C\u0010\u008E\u0001\u001A\u00020;*\u00030\u008F\u00012\f\u0010\u0090\u0001\u001A\u0007\u0012\u0002\b\u00030\u0091\u0001H\u0002J>\u0010\u0092\u0001\u001A\u00020a2\b\u0010\u0093\u0001\u001A\u00030\u0094\u00012\b\u0010\u0095\u0001\u001A\u00030\u0096\u00012\n\u0010\u0097\u0001\u001A\u0005\u0018\u00010\u0098\u00012\n\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u009A\u0001H\u0016¢\u0006\u0006\b\u009B\u0001\u0010\u009C\u0001JT\u0010\u0092\u0001\u001A\u00020a2\b\u0010\u0093\u0001\u001A\u00030\u0094\u00012\b\u0010\u0095\u0001\u001A\u00030\u0096\u00012\n\u0010\u0097\u0001\u001A\u0005\u0018\u00010\u0098\u00012\n\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u009A\u00012\n\u0010\u009D\u0001\u001A\u0005\u0018\u00010\u009E\u00012\b\u0010\u009F\u0001\u001A\u00030 \u0001H\u0016¢\u0006\u0006\b¡\u0001\u0010¢\u0001J]\u0010\u0092\u0001\u001A\u00020a2\b\u0010\u0093\u0001\u001A\u00030\u0094\u00012\b\u0010£\u0001\u001A\u00030¤\u00012\u0007\u0010¥\u0001\u001A\u00020-2\n\u0010\u0097\u0001\u001A\u0005\u0018\u00010\u0098\u00012\n\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u009A\u00012\n\u0010\u009D\u0001\u001A\u0005\u0018\u00010\u009E\u00012\b\u0010\u009F\u0001\u001A\u00030 \u0001H\u0016¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0013\u0010\u0092\u0001\u001A\u00020a2\b\u0010\u0093\u0001\u001A\u00030\u0094\u0001H\u0002J]\u0010¨\u0001\u001A\u00020%2\u0007\u0010©\u0001\u001A\u00020\u00052\u0007\u0010ª\u0001\u001A\u00020\u00052\n\u0010«\u0001\u001A\u0005\u0018\u00010¬\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0007\u0010­\u0001\u001A\u00020\u00052\u0007\u0010®\u0001\u001A\u00020\u00052\u0007\u0010¯\u0001\u001A\u00020\u00052\u0007\u0010°\u0001\u001A\u00020\u00052\b\b\u0002\u0010&\u001A\u00020\'H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\u001F\u0010\u001ER\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010#\u001A\u0004\b!\u0010\"R\u000E\u0010$\u001A\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010&\u001A\u00020\'8\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b(\u0010)\u001A\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020-8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b.\u0010/R\u0014\u00100\u001A\u00020-8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b1\u0010/R\u0014\u00102\u001A\u00020-8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b3\u0010/R\u0014\u00104\u001A\u00020-8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b5\u0010/R\u0014\u00106\u001A\u00020-8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b7\u0010/R\u0014\u00108\u001A\u00020-8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b9\u0010/R\u0014\u0010:\u001A\u00020;8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b<\u0010=R\u001A\u0010>\u001A\u00020?8@X\u0081\u0004¢\u0006\f\u0012\u0004\b@\u0010)\u001A\u0004\bA\u0010BR\u0014\u0010C\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bD\u0010\u001ER\u001C\u0010E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010F0\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bG\u0010HR\u001A\u0010I\u001A\u00020J8@X\u0081\u0004¢\u0006\f\u0012\u0004\bK\u0010)\u001A\u0004\bL\u0010M¨\u0006±\u0001"}, d2={"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "maxLines", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IIJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "I", "getConstraints-msEJaDk", "()J", "J", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "charSequence", "", "getCharSequence$ui_text$annotations", "()V", "getCharSequence$ui_text", "()Ljava/lang/CharSequence;", "width", "", "getWidth", "()F", "height", "getHeight", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "minIntrinsicWidth", "getMinIntrinsicWidth", "firstBaseline", "getFirstBaseline", "lastBaseline", "getLastBaseline", "didExceedMaxLines", "", "getDidExceedMaxLines", "()Z", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text$annotations", "getTextLocale$ui_text", "()Ljava/util/Locale;", "lineCount", "getLineCount", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text$annotations", "getTextPaint$ui_text", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getLineForVerticalPosition", "vertical", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getRangeForRect", "Landroidx/compose/ui/text/TextRange;", "rect", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getBoundingBox", "offset", "fillBoundingBoxes", "", "range", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getCursorRect", "getWordBoundary", "getWordBoundary--jx7JFs", "(I)J", "getLineLeft", "lineIndex", "getLineRight", "getLineTop", "getLineAscent", "getLineAscent$ui_text", "getLineBaseline", "getLineDescent", "getLineDescent$ui_text", "getLineBottom", "getLineHeight", "getLineWidth", "getLineStart", "getLineEnd", "visibleEnd", "isLineEllipsized", "getLineEllipsisOffset", "getLineEllipsisOffset$ui_text", "getLineEllipsisCount", "getLineEllipsisCount$ui_text", "getLineForOffset", "getHorizontalPosition", "usePrimaryDirection", "getParagraphDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "hasSpan", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "color", "Landroidx/compose/ui/graphics/Color;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidParagraph implements Paragraph {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ResolvedTextDirection.values().length];
            try {
                v0[ResolvedTextDirection.Ltr.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ResolvedTextDirection.Rtl.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 8;
    private final CharSequence charSequence;
    private final long constraints;
    private final TextLayout layout;
    private final int maxLines;
    private final int overflow;
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    private final List placeholderRects;

    static {
    }

    private AndroidParagraph(AndroidParagraphIntrinsics arg22, int arg23, int arg24, long arg25) {
        float v8_1;
        Object v10_4;
        List v1_4;
        int v15;
        int v0_1;
        int v6_1;
        boolean v2_2;
        TextStyle v17;
        TextUtils$TruncateAt v11;
        AndroidParagraph v0 = this;
        int v4 = arg23;
        int v12 = arg24;
        super();
        AndroidParagraphIntrinsics v1 = arg22;
        v0.paragraphIntrinsics = v1;
        v0.maxLines = v4;
        v0.overflow = v12;
        long v13 = arg25;
        v0.constraints = v13;
        int v2 = Constraints.getMinHeight-impl(v13) != 0 || Constraints.getMinWidth-impl(v13) != 0 ? 0 : 1;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }

        v2 = v4 >= 1 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("maxLines should be greater than 0");
        }

        TextStyle v2_1 = v1.getStyle();
        CharSequence v1_1 = AndroidParagraph_androidKt.access$shouldAttachIndentationFixSpan(v2_1, TextOverflow.equals-impl0(v12, TextOverflow.Companion.getEllipsis-gIe3tQ8())) ? AndroidParagraph_androidKt.access$attachIndentationFixSpan(v1.getCharSequence$ui_text()) : v1.getCharSequence$ui_text();
        v0.charSequence = v1_1;
        int v5 = AndroidParagraph_androidKt.access$toLayoutAlign-aXe7zB0(v2_1.getTextAlign-e0LSkKk());
        boolean v6 = TextAlign.equals-impl0(v2_1.getTextAlign-e0LSkKk(), TextAlign.Companion.getJustify-e0LSkKk());
        int v7 = AndroidParagraph_androidKt.access$toLayoutHyphenationFrequency--3fSNIE(v2_1.getParagraphStyle$ui_text().getHyphens-vmbZdU8());
        int v8 = AndroidParagraph_androidKt.access$toLayoutBreakStrategy-xImikfE(LineBreak.getStrategy-fcGXIks(v2_1.getLineBreak-rAG3T2k()));
        int v9 = AndroidParagraph_androidKt.access$toLayoutLineBreakStyle-hpcqdu8(LineBreak.getStrictness-usljTpc(v2_1.getLineBreak-rAG3T2k()));
        int v10 = AndroidParagraph_androidKt.access$toLayoutLineBreakWordStyle-wPN0Rpw(LineBreak.getWordBreak-jp8hJ3c(v2_1.getLineBreak-rAG3T2k()));
        TextUtils$TruncateAt v16 = null;
        if(TextOverflow.equals-impl0(v12, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
            v11 = TextUtils$TruncateAt.END;
            goto label_64;
        }
        else if(TextOverflow.equals-impl0(v12, TextOverflow.Companion.getMiddleEllipsis-gIe3tQ8())) {
            v11 = TextUtils$TruncateAt.MIDDLE;
            goto label_64;
        }
        else if(TextOverflow.equals-impl0(v12, TextOverflow.Companion.getStartEllipsis-gIe3tQ8())) {
            v11 = TextUtils$TruncateAt.START;
        label_64:
            v17 = v2_1;
            v2_2 = v6;
            v6_1 = v8;
            v8 = v10;
        }
        else {
            v17 = v2_1;
            v2_2 = v6;
            v6_1 = v8;
            v8 = v10;
            v11 = v16;
        }

        TextUtils$TruncateAt v3 = v11;
        CharSequence v19 = v1_1;
        int v1_2 = v5;
        v5 = v7;
        v7 = v9;
        CharSequence v20 = v19;
        TextLayout v9_1 = AndroidParagraph.constructTextLayout$default(v0, v1_2, ((int)v2_2), v3, v4, v5, v6_1, v7, v8, null, 0x100, null);
        v10 = 2;
        if(Build$VERSION.SDK_INT >= 35 || this.getTextPaint$ui_text().getLetterSpacing() == 0f) {
        label_135:
            v4 = arg23;
            v15 = 1;
        }
        else {
            if(!TextOverflow.equals-impl0(v12, TextOverflow.Companion.getStartEllipsis-gIe3tQ8()) && !TextOverflow.equals-impl0(v12, TextOverflow.Companion.getMiddleEllipsis-gIe3tQ8())) {
                goto label_135;
            }

            if(v9_1.getLineEllipsisCount(0) <= 0) {
                goto label_135;
            }

            v0_1 = v9_1.getLineEllipsisOffset(0);
            v4 = v9_1.getLineEllipsisCount(0) + v0_1;
            CharSequence[] v9_2 = new CharSequence[3];
            v9_2[0] = v20.subSequence(0, v0_1);
            v15 = 1;
            v9_2[1] = "…";
            v9_2[v10] = v20.subSequence(v4, v20.length());
            v4 = arg23;
            v9_1 = this.constructTextLayout(v1_2, ((int)v2_2), v3, v4, v5, v6_1, v7, v8, TextUtils.concat(v9_2));
        }

        if(!TextOverflow.equals-impl0(v12, TextOverflow.Companion.getEllipsis-gIe3tQ8()) || v9_1.getHeight() <= Constraints.getMaxHeight-impl(v13) || v4 <= v15) {
            v0 = this;
            v12 = v10;
            v0.layout = v9_1;
        }
        else {
            v0_1 = AndroidParagraph_androidKt.access$numberOfLinesThatFitMaxHeight(v9_1, Constraints.getMaxHeight-impl(v13));
            if(v0_1 < 0 || v0_1 == v4) {
                v0 = this;
                v12 = v10;
            }
            else {
                v4 = RangesKt.coerceAtLeast(v0_1, v15);
                v12 = v10;
                v0 = this;
                v9_1 = AndroidParagraph.constructTextLayout$default(v0, v1_2, ((int)v2_2), v3, v4, v5, v6_1, v7, v8, null, 0x100, null);
            }

            v0.layout = v9_1;
        }

        v7 = 0x20;
        long v10_1 = 0xFFFFFFFFL;
        v0.getTextPaint$ui_text().setBrush-12SF9DM(v17.getBrush(), Size.constructor-impl((((long)Float.floatToRawIntBits(v0.getHeight()))) & v10_1 | (((long)Float.floatToRawIntBits(v0.getWidth()))) << v7), v17.getAlpha());
        ShaderBrushSpan[] v1_3 = v0.getShaderBrushSpans(v9_1);
        if(v1_3 != null) {
            v2 = v1_3.length;
            int v3_1;
            for(v3_1 = 0; v3_1 < v2; ++v3_1) {
                v1_3[v3_1].setSize-uvyYCjk(Size.constructor-impl((((long)Float.floatToRawIntBits(v0.getHeight()))) & v10_1 | (((long)Float.floatToRawIntBits(v0.getWidth()))) << v7));
            }
        }

        v1_1 = v0.charSequence;
        if(!(v1_1 instanceof Spanned)) {
            v1_4 = CollectionsKt.emptyList();
        }
        else {
            CharSequence v2_3 = v1_1;
            Object[] v1_5 = ((Spanned)v2_3).getSpans(0, v1_1.length(), PlaceholderSpan.class);
            ArrayList v3_2 = new ArrayList(v1_5.length);
            v5 = v1_5.length;
            for(v6_1 = 0; v6_1 < v5; ++v6_1) {
                Object v7_1 = v1_5[v6_1];
                v8 = ((Spanned)v2_3).getSpanStart(v7_1);
                v9 = ((Spanned)v2_3).getSpanEnd(v7_1);
                v10 = v0.layout.getLineForOffset(v8);
                int v11_1 = v10 >= v0.maxLines ? v15 : 0;
                int v13_1 = v0.layout.getLineEllipsisCount(v10) <= 0 || v9 <= v0.layout.getLineStart(v10) + v0.layout.getLineEllipsisOffset(v10) ? 0 : v15;
                v9 = v9 > v0.layout.getLineEnd(v10) ? v15 : 0;
                if(v13_1 != 0 || v9 != 0 || v11_1 != 0) {
                    v10_4 = v16;
                }
                else {
                    v9 = WhenMappings.$EnumSwitchMapping$0[v0.getBidiRunDirection(v8).ordinal()];
                    if(v9 == v15) {
                        v8_1 = v0.getHorizontalPosition(v8, ((boolean)v15));
                    }
                    else if(v9 == v12) {
                        v8_1 = v0.getHorizontalPosition(v8, ((boolean)v15)) - (((float)((PlaceholderSpan)v7_1).getWidthPx()));
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }

                    float v9_3 = (((float)((PlaceholderSpan)v7_1).getWidthPx())) + v8_1;
                    TextLayout v11_2 = v0.layout;
                    switch(((PlaceholderSpan)v7_1).getVerticalAlign()) {
                        case 0: {
                            goto label_312;
                        }
                        case 1: {
                            goto label_310;
                        }
                        case 2: {
                            goto label_307;
                        }
                        case 3: {
                            goto label_298;
                        }
                        case 4: {
                            goto label_292;
                        }
                        case 5: {
                            goto label_283;
                        }
                        case 6: {
                            goto label_273;
                        }
                    }

                    throw new IllegalStateException("unexpected verticalAlignment");
                label_273:
                    Paint$FontMetricsInt v13_2 = ((PlaceholderSpan)v7_1).getFontMetrics();
                    float v13_3 = ((float)((v13_2.ascent + v13_2.descent - ((PlaceholderSpan)v7_1).getHeightPx()) / v12));
                    float v10_2 = v11_2.getLineBaseline(v10);
                    goto label_296;
                label_307:
                    v10_2 = v11_2.getLineBottom(v10);
                    v11_1 = ((PlaceholderSpan)v7_1).getHeightPx();
                    goto label_314;
                label_292:
                    v13_3 = ((float)((PlaceholderSpan)v7_1).getFontMetrics().ascent);
                    v10_2 = v11_2.getLineBaseline(v10);
                label_296:
                    v13_3 += v10_2;
                    goto label_316;
                label_310:
                    v13_3 = v11_2.getLineTop(v10);
                    goto label_316;
                label_312:
                    v10_2 = v11_2.getLineBaseline(v10);
                    v11_1 = ((PlaceholderSpan)v7_1).getHeightPx();
                label_314:
                    v13_3 = v10_2 - (((float)v11_1));
                    goto label_316;
                label_298:
                    v13_3 = (v11_2.getLineTop(v10) + v11_2.getLineBottom(v10) - (((float)((PlaceholderSpan)v7_1).getHeightPx()))) / 2f;
                    goto label_316;
                label_283:
                    v13_3 = (((float)((PlaceholderSpan)v7_1).getFontMetrics().descent)) + v11_2.getLineBaseline(v10) - (((float)((PlaceholderSpan)v7_1).getHeightPx()));
                label_316:
                    Rect v10_3 = new Rect(v8_1, v13_3, v9_3, (((float)((PlaceholderSpan)v7_1).getHeightPx())) + v13_3);
                }

                ((Collection)v3_2).add(v10_4);
            }

            ArrayList v1_6 = v3_2;
        }

        v0.placeholderRects = v1_4;
    }

    public AndroidParagraph(AndroidParagraphIntrinsics arg1, int arg2, int arg3, long arg4, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4);
    }

    private AndroidParagraph(String arg8, TextStyle arg9, List arg10, List arg11, int arg12, int arg13, long arg14, Resolver arg16, Density arg17) {
        this(new AndroidParagraphIntrinsics(arg8, arg9, arg10, arg11, arg16, arg17), arg12, arg13, arg14, null);
    }

    public AndroidParagraph(String arg1, TextStyle arg2, List arg3, List arg4, int arg5, int arg6, long arg7, Resolver arg9, Density arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg9, arg10);
    }

    private final TextLayout constructTextLayout(int arg23, int arg24, TextUtils$TruncateAt arg25, int arg26, int arg27, int arg28, int arg29, int arg30, CharSequence arg31) {
        return new TextLayout(arg31, this.getWidth(), this.getTextPaint$ui_text(), arg23, arg25, this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text(), 1f, 0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, arg26, arg28, arg29, arg30, arg27, arg24, null, null, this.paragraphIntrinsics.getLayoutIntrinsics$ui_text(), 0x30080, null);
    }

    static TextLayout constructTextLayout$default(AndroidParagraph arg11, int arg12, int arg13, TextUtils$TruncateAt arg14, int arg15, int arg16, int arg17, int arg18, int arg19, CharSequence arg20, int arg21, Object arg22) {
        CharSequence v10 = (arg21 & 0x100) != 0 ? arg11.charSequence : arg20;
        return arg11.constructTextLayout(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, v10);
    }

    public void fillBoundingBoxes-8ffj60Q(long arg2, float[] arg4, int arg5) {
        this.layout.fillBoundingBoxes(TextRange.getMin-impl(arg2), TextRange.getMax-impl(arg2), arg4, arg5);
    }

    public ResolvedTextDirection getBidiRunDirection(int arg1) {
        if(this.layout.isRtlCharAt(arg1)) {
            return ResolvedTextDirection.Rtl;
        }

        return ResolvedTextDirection.Ltr;
    }

    public Rect getBoundingBox(int arg4) {
        int v0 = 0;
        if(arg4 >= 0 && arg4 < this.charSequence.length()) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + arg4 + ") is out of bounds [0," + this.charSequence.length() + ')');
        }

        RectF v3 = this.layout.getBoundingBox(arg4);
        return new Rect(v3.left, v3.top, v3.right, v3.bottom);
    }

    public final CharSequence getCharSequence$ui_text() {
        return this.charSequence;
    }

    public static void getCharSequence$ui_text$annotations() {
    }

    public final long getConstraints-msEJaDk() {
        return this.constraints;
    }

    public Rect getCursorRect(int arg5) {
        int v1 = arg5 < 0 || arg5 > this.charSequence.length() ? 0 : 1;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + arg5 + ") is out of bounds [0," + this.charSequence.length() + ']');
        }

        float v0 = TextLayout.getPrimaryHorizontal$default(this.layout, arg5, false, 2, null);
        arg5 = this.layout.getLineForOffset(arg5);
        return new Rect(v0, this.layout.getLineTop(arg5), v0, this.layout.getLineBottom(arg5));
    }

    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public float getFirstBaseline() {
        return this.getLineBaseline(0);
    }

    public float getHeight() {
        return ((float)this.layout.getHeight());
    }

    public float getHorizontalPosition(int arg4, boolean arg5) {
        TextLayout v3 = this.layout;
        Object v0 = null;
        int v1 = 2;
        if(arg5) {
            return TextLayout.getPrimaryHorizontal$default(v3, arg4, false, v1, v0);
        }

        return TextLayout.getSecondaryHorizontal$default(v3, arg4, false, v1, v0);
    }

    public float getLastBaseline() {
        return this.getLineBaseline(this.getLineCount() - 1);
    }

    public final float getLineAscent$ui_text(int arg1) {
        return this.layout.getLineAscent(arg1);
    }

    public float getLineBaseline(int arg1) {
        return this.layout.getLineBaseline(arg1);
    }

    public float getLineBottom(int arg1) {
        return this.layout.getLineBottom(arg1);
    }

    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public final float getLineDescent$ui_text(int arg1) {
        return this.layout.getLineDescent(arg1);
    }

    public final int getLineEllipsisCount$ui_text(int arg1) {
        return this.layout.getLineEllipsisCount(arg1);
    }

    public final int getLineEllipsisOffset$ui_text(int arg1) {
        return this.layout.getLineEllipsisOffset(arg1);
    }

    public int getLineEnd(int arg1, boolean arg2) {
        TextLayout v0 = this.layout;
        if(arg2) {
            return v0.getLineVisibleEnd(arg1);
        }

        return v0.getLineEnd(arg1);
    }

    public int getLineForOffset(int arg1) {
        return this.layout.getLineForOffset(arg1);
    }

    public int getLineForVerticalPosition(float arg1) {
        return this.layout.getLineForVertical(((int)arg1));
    }

    public float getLineHeight(int arg1) {
        return this.layout.getLineHeight(arg1);
    }

    public float getLineLeft(int arg1) {
        return this.layout.getLineLeft(arg1);
    }

    public float getLineRight(int arg1) {
        return this.layout.getLineRight(arg1);
    }

    public int getLineStart(int arg1) {
        return this.layout.getLineStart(arg1);
    }

    public float getLineTop(int arg1) {
        return this.layout.getLineTop(arg1);
    }

    public float getLineWidth(int arg1) {
        return this.layout.getLineWidth(arg1);
    }

    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    public int getOffsetForPosition-k-4lQ0M(long arg4) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical(((int)Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg4))))), Float.intBitsToFloat(((int)(arg4 >> 0x20))));
    }

    public final int getOverflow-gIe3tQ8() {
        return this.overflow;
    }

    public ResolvedTextDirection getParagraphDirection(int arg2) {
        if(this.layout.getParagraphDirection(this.layout.getLineForOffset(arg2)) == 1) {
            return ResolvedTextDirection.Ltr;
        }

        return ResolvedTextDirection.Rtl;
    }

    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    public Path getPathForRange(int arg3, int arg4) {
        int v0 = arg3 < 0 || arg3 > arg4 || arg4 > this.charSequence.length() ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start(" + arg3 + ") or end(" + arg4 + ") is out of range [0.." + this.charSequence.length() + "], or start > end!");
        }

        android.graphics.Path v0_1 = new android.graphics.Path();
        this.layout.getSelectionPath(arg3, arg4, v0_1);
        return AndroidPath_androidKt.asComposePath(v0_1);
    }

    public List getPlaceholderRects() {
        return this.placeholderRects;
    }

    public long getRangeForRect-8-6BmAI(Rect arg2, int arg3, TextInclusionStrategy arg4) {
        int[] v1 = this.layout.getRangeForRect(RectHelper_androidKt.toAndroidRectF(arg2), AndroidParagraph_androidKt.access$toLayoutTextGranularity-duNsdkg(arg3), new AndroidParagraph$$ExternalSyntheticLambda0(arg4));
        if(v1 == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }

        return TextRangeKt.TextRange(v1[0], v1[1]);
    }

    static final boolean getRangeForRect_8_6BmAI$lambda$0(TextInclusionStrategy arg0, RectF arg1, RectF arg2) {
        return arg0.isIncluded(RectHelper_androidKt.toComposeRect(arg1), RectHelper_androidKt.toComposeRect(arg2));
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout arg5) {
        ShaderBrushSpan[] v1 = null;
        if(!(arg5.getText() instanceof Spanned)) {
            return v1;
        }

        CharSequence v0 = arg5.getText();
        String v2 = "null cannot be cast to non-null type android.text.Spanned";
        Intrinsics.checkNotNull(v0, v2);
        Class v3 = ShaderBrushSpan.class;
        if(!this.hasSpan(((Spanned)v0), v3)) {
            return v1;
        }

        CharSequence v4 = arg5.getText();
        Intrinsics.checkNotNull(v4, v2);
        return ((Spanned)v4).getSpans(0, arg5.getText().length(), v3);
    }

    public final Locale getTextLocale$ui_text() {
        return this.paragraphIntrinsics.getTextPaint$ui_text().getTextLocale();
    }

    public static void getTextLocale$ui_text$annotations() {
    }

    public final AndroidTextPaint getTextPaint$ui_text() {
        return this.paragraphIntrinsics.getTextPaint$ui_text();
    }

    public static void getTextPaint$ui_text$annotations() {
    }

    public float getWidth() {
        return ((float)Constraints.getMaxWidth-impl(this.constraints));
    }

    public long getWordBoundary--jx7JFs(int arg2) {
        WordIterator v1 = this.layout.getWordIterator();
        return TextRangeKt.TextRange(WordBoundary_androidKt.getWordStart(v1, arg2), WordBoundary_androidKt.getWordEnd(v1, arg2));
    }

    private final boolean hasSpan(Spanned arg2, Class arg3) {
        if(arg2.nextSpanTransition(-1, arg2.length(), arg3) != arg2.length()) {
            return 1;
        }

        return 0;
    }

    public boolean isLineEllipsized(int arg1) {
        return this.layout.isLineEllipsized(arg1);
    }

    private final void paint(Canvas arg4) {
        android.graphics.Canvas v4 = AndroidCanvas_androidKt.getNativeCanvas(arg4);
        if(this.getDidExceedMaxLines()) {
            v4.save();
            v4.clipRect(0f, 0f, this.getWidth(), this.getHeight());
        }

        this.layout.paint(v4);
        if(this.getDidExceedMaxLines()) {
            v4.restore();
        }
    }

    public void paint-LG529CI(Canvas arg3, long arg4, Shadow arg6, TextDecoration arg7, DrawStyle arg8, int arg9) {
        int v0 = this.getTextPaint$ui_text().getBlendMode-0nO6VwU();
        AndroidTextPaint v1 = this.getTextPaint$ui_text();
        v1.setColor-8_81llA(arg4);
        v1.setShadow(arg6);
        v1.setTextDecoration(arg7);
        v1.setDrawStyle(arg8);
        v1.setBlendMode-s9anfk8(arg9);
        this.paint(arg3);
        this.getTextPaint$ui_text().setBlendMode-s9anfk8(v0);
    }

    public void paint-RPmYEkk(Canvas arg2, long arg3, Shadow arg5, TextDecoration arg6) {
        AndroidTextPaint v0 = this.getTextPaint$ui_text();
        v0.setColor-8_81llA(arg3);
        v0.setShadow(arg5);
        v0.setTextDecoration(arg6);
        this.paint(arg2);
    }

    public void paint-hn5TExg(Canvas arg9, Brush arg10, float arg11, Shadow arg12, TextDecoration arg13, DrawStyle arg14, int arg15) {
        int v0 = this.getTextPaint$ui_text().getBlendMode-0nO6VwU();
        AndroidTextPaint v1 = this.getTextPaint$ui_text();
        v1.setBrush-12SF9DM(arg10, Size.constructor-impl((((long)Float.floatToRawIntBits(this.getHeight()))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(this.getWidth()))) << 0x20), arg11);
        v1.setShadow(arg12);
        v1.setTextDecoration(arg13);
        v1.setDrawStyle(arg14);
        v1.setBlendMode-s9anfk8(arg15);
        this.paint(arg9);
        this.getTextPaint$ui_text().setBlendMode-s9anfk8(v0);
    }
}

