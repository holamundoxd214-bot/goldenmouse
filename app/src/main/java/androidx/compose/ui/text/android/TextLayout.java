package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint$FontMetricsInt;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build$VERSION;
import android.os.Trace;
import android.text.BoringLayout$Metrics;
import android.text.BoringLayout;
import android.text.Layout$Alignment;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.IndentationFixSpan_androidKt;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.LineHeightStyle$Mode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\t\u0012\b\b\u0002\u0010\r\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u000E\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001A\u00020\t\u0012\b\b\u0002\u0010\u0013\u001A\u00020\t\u0012\b\b\u0002\u0010\u0014\u001A\u00020\t\u0012\b\b\u0002\u0010\u0015\u001A\u00020\t\u0012\b\b\u0002\u0010\u0016\u001A\u00020\t\u0012\b\b\u0002\u0010\u0017\u001A\u00020\t\u0012\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001B\u001A\u00020\u001C¢\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010W\u001A\u00020\u00052\u0006\u0010X\u001A\u00020\tH\u0002J\u000E\u0010Y\u001A\u00020\u00052\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010[\u001A\u00020\u00052\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010\\\u001A\u00020\u00052\u0006\u0010X\u001A\u00020\tJ\u000E\u0010]\u001A\u00020\u00052\u0006\u0010X\u001A\u00020\tJ\u000E\u0010^\u001A\u00020\u00052\u0006\u0010X\u001A\u00020\tJ\u000E\u0010_\u001A\u00020\u00052\u0006\u0010X\u001A\u00020\tJ\u000E\u0010`\u001A\u00020\u00052\u0006\u0010X\u001A\u00020\tJ\u000E\u0010a\u001A\u00020\u00052\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010b\u001A\u00020\u00052\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010c\u001A\u00020\t2\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010d\u001A\u00020\t2\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010e\u001A\u00020\t2\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010f\u001A\u00020\u00102\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010g\u001A\u00020\t2\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010h\u001A\u00020\t2\u0006\u0010Z\u001A\u00020\tJ\u000E\u0010i\u001A\u00020\t2\u0006\u0010j\u001A\u00020\tJ\u0016\u0010k\u001A\u00020\t2\u0006\u0010X\u001A\u00020\t2\u0006\u0010l\u001A\u00020\u0005J\u0018\u0010m\u001A\u00020\u00052\u0006\u0010n\u001A\u00020\t2\b\b\u0002\u0010o\u001A\u00020\u0010J\u0018\u0010p\u001A\u00020\u00052\u0006\u0010n\u001A\u00020\t2\b\b\u0002\u0010o\u001A\u00020\u0010J\u000E\u0010q\u001A\u00020\t2\u0006\u0010n\u001A\u00020\tJ\u000E\u0010r\u001A\u00020\u00102\u0006\u0010n\u001A\u00020\tJ\u000E\u0010s\u001A\u00020\t2\u0006\u0010X\u001A\u00020\tJ\u001E\u0010t\u001A\u00020u2\u0006\u0010v\u001A\u00020\t2\u0006\u0010w\u001A\u00020\t2\u0006\u0010x\u001A\u00020yJ2\u0010z\u001A\u0004\u0018\u00010\u00192\u0006\u0010K\u001A\u00020{2\u0006\u0010|\u001A\u00020\t2\u0018\u0010}\u001A\u0014\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020\u00100~J \u0010\u007F\u001A\u00020u2\u0006\u0010Z\u001A\u00020\t2\b\u0010\u0080\u0001\u001A\u00030\u0081\u0001H\u0000¢\u0006\u0003\b\u0082\u0001J,\u0010\u0083\u0001\u001A\u00020u2\u0007\u0010\u0084\u0001\u001A\u00020\t2\u0007\u0010\u0085\u0001\u001A\u00020\t2\b\u0010\u0080\u0001\u001A\u00030\u0081\u00012\u0007\u0010\u0086\u0001\u001A\u00020\tJ\u000F\u0010\u0087\u0001\u001A\u00020{2\u0006\u0010n\u001A\u00020\tJ\u0011\u0010\u0088\u0001\u001A\u00020u2\b\u0010\u0089\u0001\u001A\u00030\u008A\u0001J\u000F\u0010\u008B\u0001\u001A\u00020\u0010H\u0000¢\u0006\u0003\b\u008C\u0001R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0011\u0010\u0011\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\"R\u0011\u0010\u001B\u001A\u00020\u001C¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010&\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u0011\u0010)\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b*\u0010(R\u0011\u0010+\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b,\u0010\"R\u0010\u0010-\u001A\u0004\u0018\u00010.X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010/\u001A\u00020.8F¢\u0006\u0006\u001A\u0004\b0\u00101R\u001C\u00102\u001A\u0002038\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b4\u00105\u001A\u0004\b6\u00107R\u0011\u00108\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b9\u0010:R\u001C\u0010;\u001A\u00020\t8\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b<\u00105\u001A\u0004\b=\u0010:R\u001C\u0010>\u001A\u00020\t8\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b?\u00105\u001A\u0004\b@\u0010:R\u000E\u0010A\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010B\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010C\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001A\u0004\u0018\u00010EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010G\u001A\n\u0012\u0004\u0012\u00020I\u0018\u00010HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010JR\u000E\u0010K\u001A\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001A\u0004\u0018\u00010NX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010O\u001A\u00020N8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bP\u0010QR\u0011\u0010R\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\bS\u0010TR\u0011\u0010U\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\bV\u0010:¨\u0006\u008D\u0001"}, d2={"Landroidx/compose/ui/text/android/TextLayout;", "", "charSequence", "", "width", "", "textPaint", "Landroid/text/TextPaint;", "alignment", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "textDirectionHeuristic", "lineSpacingMultiplier", "lineSpacingExtra", "includePadding", "", "fallbackLineSpacing", "maxLines", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "justificationMode", "leftIndents", "", "rightIndents", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "<init>", "(Ljava/lang/CharSequence;FLandroid/text/TextPaint;ILandroid/text/TextUtils$TruncateAt;IFFZZIIIIII[I[ILandroidx/compose/ui/text/android/LayoutIntrinsics;)V", "getTextPaint", "()Landroid/text/TextPaint;", "getIncludePadding", "()Z", "getFallbackLineSpacing", "getLayoutIntrinsics", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "didExceedMaxLines", "getDidExceedMaxLines", "backingWordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "wordIterator", "getWordIterator", "()Landroidx/compose/ui/text/android/selection/WordIterator;", "layout", "Landroid/text/Layout;", "getLayout$annotations", "()V", "getLayout", "()Landroid/text/Layout;", "lineCount", "getLineCount", "()I", "topPadding", "getTopPadding$ui_text$annotations", "getTopPadding$ui_text", "bottomPadding", "getBottomPadding$ui_text$annotations", "getBottomPadding$ui_text", "leftPadding", "rightPadding", "isBoringLayout", "lastLineFontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "lastLineExtra", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "rect", "Landroid/graphics/Rect;", "backingLayoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "layoutHelper", "getLayoutHelper", "()Landroidx/compose/ui/text/android/LayoutHelper;", "text", "getText", "()Ljava/lang/CharSequence;", "height", "getHeight", "getHorizontalPadding", "line", "getLineLeft", "lineIndex", "getLineRight", "getLineTop", "getLineBottom", "getLineAscent", "getLineBaseline", "getLineDescent", "getLineHeight", "getLineWidth", "getLineStart", "getLineEnd", "getLineVisibleEnd", "isLineEllipsized", "getLineEllipsisOffset", "getLineEllipsisCount", "getLineForVertical", "vertical", "getOffsetForHorizontal", "horizontal", "getPrimaryHorizontal", "offset", "upstream", "getSecondaryHorizontal", "getLineForOffset", "isRtlCharAt", "getParagraphDirection", "getSelectionPath", "", "start", "end", "dest", "Landroid/graphics/Path;", "getRangeForRect", "Landroid/graphics/RectF;", "granularity", "inclusionStrategy", "Lkotlin/Function2;", "fillLineHorizontalBounds", "array", "", "fillLineHorizontalBounds$ui_text", "fillBoundingBoxes", "startOffset", "endOffset", "arrayStart", "getBoundingBox", "paint", "canvas", "Landroid/graphics/Canvas;", "isFallbackLinespacingApplied", "isFallbackLinespacingApplied$ui_text", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLayout {
    public static final int $stable = 8;
    private LayoutHelper backingLayoutHelper;
    private WordIterator backingWordIterator;
    private final int bottomPadding;
    private final boolean didExceedMaxLines;
    private final TextUtils$TruncateAt ellipsize;
    private final boolean fallbackLineSpacing;
    private final boolean includePadding;
    private final boolean isBoringLayout;
    private final int lastLineExtra;
    private final Paint$FontMetricsInt lastLineFontMetrics;
    private final Layout layout;
    private final LayoutIntrinsics layoutIntrinsics;
    private final float leftPadding;
    private final int lineCount;
    private final LineHeightStyleSpan[] lineHeightSpans;
    private final Rect rect;
    private final float rightPadding;
    private final TextPaint textPaint;
    private final int topPadding;

    static {
    }

    public TextLayout(CharSequence arg24, float arg25, TextPaint arg26, int arg27, TextUtils$TruncateAt arg28, int arg29, float arg30, float arg31, boolean arg32, boolean arg33, int arg34, int arg35, int arg36, int arg37, int arg38, int arg39, int[] arg40, int[] arg41, LayoutIntrinsics arg42, int arg43, DefaultConstructorMarker arg44) {
        LayoutIntrinsics v22;
        TextPaint v6;
        CharSequence v4;
        int v0 = arg43;
        int v7 = (v0 & 8) != 0 ? 0 : arg27;
        TextUtils$TruncateAt v3 = null;
        TextUtils$TruncateAt v8 = (v0 & 16) != 0 ? v3 : arg28;
        int v9 = (v0 & 0x20) != 0 ? 2 : arg29;
        float v10 = (v0 & 0x40) != 0 ? 1f : arg30;
        float v11 = (v0 & 0x80) != 0 ? 0f : arg31;
        boolean v12 = (v0 & 0x100) != 0 ? false : arg32;
        boolean v13 = (v0 & 0x200) != 0 ? true : arg33;
        int v14 = (v0 & 0x400) != 0 ? 0x7FFFFFFF : arg34;
        int v15 = (v0 & 0x800) != 0 ? 0 : arg35;
        int v16 = (v0 & 0x1000) != 0 ? 0 : arg36;
        int v17 = (v0 & 0x2000) != 0 ? 0 : arg37;
        int v18 = (v0 & 0x4000) != 0 ? 0 : arg38;
        int v19 = (0x8000 & v0) != 0 ? 0 : arg39;
        int[] v20 = (0x10000 & v0) != 0 ? ((int[])v3) : arg40;
        int[] v21 = (0x20000 & v0) != 0 ? ((int[])v3) : arg41;
        if((v0 & 0x40000) != 0) {
            v4 = arg24;
            v6 = arg26;
            v22 = new LayoutIntrinsics(v4, v6, v9);
        }
        else {
            v4 = arg24;
            v6 = arg26;
            v22 = arg42;
        }

        this(v4, arg25, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22);
    }

    public TextLayout(CharSequence arg26, float arg27, TextPaint arg28, int arg29, TextUtils$TruncateAt arg30, int arg31, float arg32, float arg33, boolean arg34, boolean arg35, int arg36, int arg37, int arg38, int arg39, int arg40, int arg41, int[] arg42, int[] arg43, LayoutIntrinsics arg44) {
        long v6_2;
        boolean v13_1;
        Object v6_1;
        boolean v12;
        boolean v24;
        boolean v1_2;
        TextDirectionHeuristic v8_1;
        BoringLayout v2_1;
        int v13;
        TextLayout v0 = this;
        CharSequence v2 = arg26;
        float v1 = arg27;
        TextPaint v3 = arg28;
        super();
        v0.textPaint = v3;
        TextUtils$TruncateAt v9 = arg30;
        v0.ellipsize = v9;
        boolean v7 = arg34;
        v0.includePadding = v7;
        boolean v8 = arg35;
        v0.fallbackLineSpacing = v8;
        LayoutIntrinsics v4 = arg44;
        v0.layoutIntrinsics = v4;
        v0.rect = new Rect();
        int v5 = v2.length();
        TextDirectionHeuristic v11 = TextLayout_androidKt.getTextDirectionHeuristic(arg31);
        Layout$Alignment v6 = TextAlignmentAdapter.INSTANCE.get(arg29);
        v5 = !(v2 instanceof Spanned) || v2.nextSpanTransition(-1, v5, BaselineShiftSpan.class) >= v5 ? 0 : 1;
        Trace.beginSection("TextLayout:initLayout");
        int v10 = v5;
        try {
            BoringLayout$Metrics v5_1 = v4.getBoringMetrics();
            double v16 = ((double)v1);
            v13 = ((int)(((float)Math.ceil(v16))));
            if(v5_1 == null || v4.getMaxIntrinsicWidth() > v1 || v10 != 0) {
                v0.isBoringLayout = false;
                v10 = arg36;
                v24 = false;
                v8_1 = v11;
                v1_2 = true;
                StaticLayout v2_2 = StaticLayoutFactory.INSTANCE.create(arg26, arg28, v13, 0, arg26.length(), v8_1, v6, v10, arg30, ((int)(((float)Math.ceil(v16)))), arg32, arg33, arg41, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg43);
                v3 = arg28;
            }
            else {
                v0.isBoringLayout = true;
                BoringLayout v1_1 = BoringLayoutFactory.INSTANCE.create(v2, v3, v13, v5_1, v6, v7, v8, v9, v13);
                v3 = arg28;
                v10 = arg36;
                v2_1 = v1_1;
                v8_1 = v11;
                v1_2 = true;
                v24 = false;
            }

            v0.layout = ((Layout)v2_1);
        }
        catch(Throwable v0_1) {
            Trace.endSection();
            throw v0_1;
        }

        Trace.endSection();
        int v4_1 = Math.min(((Layout)v2_1).getLineCount(), v10);
        v0.lineCount = v4_1;
        v5 = v4_1 - 1;
        if(v4_1 >= v10) {
            if(((Layout)v2_1).getEllipsisCount(v5) <= 0 && ((Layout)v2_1).getLineEnd(v5) == arg26.length()) {
                goto label_97;
            }

            goto label_104;
        }
        else {
        label_97:
            v12 = v24;
            goto label_105;
        label_104:
            v12 = v1_2;
        }

    label_105:
        v0.didExceedMaxLines = v12;
        LineHeightStyleSpan[] v4_2 = TextLayout_androidKt.access$getLineHeightSpans(v0);
        v0.lineHeightSpans = v4_2;
        if(v4_2 != null) {
            v6_1 = ArraysKt.firstOrNull(((Object[])v4_2));
            if(v6_1 != null) {
                v12 = !((LineHeightStyleSpan)v6_1).getTrimFirstLineTop() || !Mode.equals-impl0(((LineHeightStyleSpan)v6_1).getMode-lzQqcRY(), Mode.Companion.getTight-lzQqcRY()) ? v24 : v1_2;
                v13_1 = v12;
            }
            else {
                goto label_123;
            }
        }
        else {
        label_123:
            v13_1 = v24;
        }

        if(v4_2 != null) {
            v6_1 = ArraysKt.firstOrNull(((Object[])v4_2));
            if(v6_1 == null) {
                goto label_136;
            }
            else if(!((LineHeightStyleSpan)v6_1).getTrimLastLineBottom()) {
                goto label_136;
            }
            else if(Mode.equals-impl0(((LineHeightStyleSpan)v6_1).getMode-lzQqcRY(), Mode.Companion.getTight-lzQqcRY())) {
                v12 = v1_2;
            }
            else {
                goto label_136;
            }
        }
        else {
        label_136:
            v12 = v24;
        }

        if(!v13_1 || !v12) {
            v6_2 = TextLayout_androidKt.access$getVerticalPaddings(v0);
            v13 = v13_1 ? ((int)v24) : VerticalPaddings.getTopPadding-impl(v6_2);
            int v1_3 = v12 ? ((int)v24) : VerticalPaddings.getBottomPadding-impl(v6_2);
            v6_2 = TextLayout_androidKt.VerticalPaddings(v13, v1_3);
        }
        else {
            v6_2 = TextLayout_androidKt.access$getZeroVerticalPadding$p();
        }

        long v9_1 = v4_2 != null ? TextLayout_androidKt.access$getLineHeightPaddings(v4_2) : TextLayout_androidKt.access$getZeroVerticalPadding$p();
        v0.topPadding = Math.max(VerticalPaddings.getTopPadding-impl(v6_2), VerticalPaddings.getTopPadding-impl(v9_1));
        v0.bottomPadding = Math.max(VerticalPaddings.getBottomPadding-impl(v6_2), VerticalPaddings.getBottomPadding-impl(v9_1));
        Paint$FontMetricsInt v1_4 = TextLayout_androidKt.access$getLastLineMetrics(v0, v3, v8_1, v4_2);
        v13 = v1_4 != null ? v1_4.bottom - (((int)v0.getLineHeight(v5))) : ((int)v24);
        v0.lastLineExtra = v13;
        v0.lastLineFontMetrics = v1_4;
        v0.leftPadding = IndentationFixSpan_androidKt.getEllipsizedLeftPadding$default(((Layout)v2_1), v5, null, 2, null);
        v0.rightPadding = IndentationFixSpan_androidKt.getEllipsizedRightPadding$default(((Layout)v2_1), v5, null, 2, null);
    }

    public final void fillBoundingBoxes(int arg17, int arg18, float[] arg19, int arg20) {
        float v5;
        float v15_1;
        TextLayout v0 = this;
        int v1 = arg17;
        int v2 = arg18;
        float[] v3 = arg19;
        int v4 = v0.getText().length();
        int v7 = v1 >= 0 ? 1 : 0;
        if(v7 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("startOffset must be > 0");
        }

        v7 = v1 < v4 ? 1 : 0;
        if(v7 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("startOffset must be less than text length");
        }

        v7 = v2 > v1 ? 1 : 0;
        if(v7 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("endOffset must be greater than startOffset");
        }

        v4 = v2 <= v4 ? 1 : 0;
        if(v4 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("endOffset must be smaller or equal to text length");
        }

        v4 = v3.length - arg20 >= (v2 - v1) * 4 ? 1 : 0;
        if(v4 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
        }

        v4 = this.getLineForOffset(arg17);
        v7 = v0.getLineForOffset(v2 - 1);
        HorizontalPositionCache v8 = new HorizontalPositionCache(v0);
        if(v4 <= v7) {
            int v9 = v4;
            v4 = arg20;
            while(true) {
                int v10 = v0.getLineStart(v9);
                int v11 = v0.getLineEnd(v9);
                v10 = Math.max(v1, v10);
                v11 = Math.min(v2, v11);
                float v12 = v0.getLineTop(v9);
                float v13 = v0.getLineBottom(v9);
                int v14 = v0.getParagraphDirection(v9) == 1 ? 1 : 0;
                while(v10 < v11) {
                    boolean v15 = v0.isRtlCharAt(v10);
                    if(v14 == 0 || (v15)) {
                        if(v14 != 0 && (v15)) {
                            v5 = v8.getSecondaryDownstream(v10);
                            v15_1 = v8.getSecondaryUpstream(v10 + 1);
                            goto label_88;
                        }

                        if(v14 == 0 && (v15)) {
                            v5 = v8.getPrimaryDownstream(v10);
                            v15_1 = v8.getPrimaryUpstream(v10 + 1);
                            goto label_88;
                        }

                        v15_1 = v8.getSecondaryDownstream(v10);
                        v5 = v8.getSecondaryUpstream(v10 + 1);
                    }
                    else {
                        v15_1 = v8.getPrimaryDownstream(v10);
                        v5 = v8.getPrimaryUpstream(v10 + 1);
                    }

                label_88:
                    v3[v4] = v15_1;
                    v3[v4 + 1] = v12;
                    v3[v4 + 2] = v5;
                    v3[v4 + 3] = v13;
                    v4 += 4;
                    ++v10;
                }

                if(v9 == v7) {
                    return;
                }

                ++v9;
            }
        }
    }

    public final void fillLineHorizontalBounds$ui_text(int arg7, float[] arg8) {
        float v3;
        float v7_1;
        int v0 = this.getLineStart(arg7);
        int v1 = this.getLineEnd(arg7);
        int v4 = 0;
        int v5 = 1;
        int v2 = arg8.length >= (v1 - v0) * 2 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }

        HorizontalPositionCache v2_1 = new HorizontalPositionCache(this);
        if(this.getParagraphDirection(arg7) == 1) {
        }
        else {
            v5 = 0;
        }

        while(v0 < v1) {
            boolean v7 = this.isRtlCharAt(v0);
            if(v5 == 0 || (v7)) {
                if(v5 != 0 && (v7)) {
                    v3 = v2_1.getSecondaryDownstream(v0);
                    v7_1 = v2_1.getSecondaryUpstream(v0 + 1);
                    goto label_42;
                }

                if(v7) {
                    v3 = v2_1.getPrimaryDownstream(v0);
                    v7_1 = v2_1.getPrimaryUpstream(v0 + 1);
                    goto label_42;
                }

                v7_1 = v2_1.getSecondaryDownstream(v0);
                v3 = v2_1.getSecondaryUpstream(v0 + 1);
            }
            else {
                v7_1 = v2_1.getPrimaryDownstream(v0);
                v3 = v2_1.getPrimaryUpstream(v0 + 1);
            }

        label_42:
            arg8[v4] = v7_1;
            arg8[v4 + 1] = v3;
            v4 += 2;
            ++v0;
        }
    }

    public final int getBottomPadding$ui_text() {
        return this.bottomPadding;
    }

    public static void getBottomPadding$ui_text$annotations() {
    }

    public final RectF getBoundingBox(int arg8) {
        float v7;
        float v0_1;
        int v0 = this.getLineForOffset(arg8);
        float v1 = this.getLineTop(v0);
        float v2 = this.getLineBottom(v0);
        v0 = this.getParagraphDirection(v0) == 1 ? 1 : 0;
        boolean v5 = this.layout.isRtlCharAt(arg8);
        if(v0 == 0 || (v5)) {
            if(v0 != 0 && (v5)) {
                v0_1 = this.getSecondaryHorizontal(arg8, false);
                v7 = this.getSecondaryHorizontal(arg8 + 1, true);
            }
            else if(v5) {
                v0_1 = this.getPrimaryHorizontal(arg8, false);
                v7 = this.getPrimaryHorizontal(arg8 + 1, true);
            }
            else {
                goto label_32;
            }

            float v6 = v0_1;
            v0_1 = v7;
            v7 = v6;
            goto label_35;
        label_32:
            v0_1 = this.getSecondaryHorizontal(arg8, false);
            v7 = this.getSecondaryHorizontal(arg8 + 1, true);
        }
        else {
            v0_1 = this.getPrimaryHorizontal(arg8, false);
            v7 = this.getPrimaryHorizontal(arg8 + 1, true);
        }

    label_35:
        return new RectF(v0_1, v1, v7, v2);
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final boolean getFallbackLineSpacing() {
        return this.fallbackLineSpacing;
    }

    public final int getHeight() {
        boolean v0 = this.didExceedMaxLines;
        Layout v1 = this.layout;
        int v0_1 = v0 ? v1.getLineBottom(this.lineCount - 1) : v1.getHeight();
        return v0_1 + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    private final float getHorizontalPadding(int arg2) {
        if(arg2 == this.lineCount - 1) {
            return this.leftPadding + this.rightPadding;
        }

        return 0;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public static void getLayout$annotations() {
    }

    private final LayoutHelper getLayoutHelper() {
        LayoutHelper v0 = this.backingLayoutHelper;
        if(v0 == null) {
            v0 = new LayoutHelper(this.layout);
            this.backingLayoutHelper = v0;
            return v0;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public final LayoutIntrinsics getLayoutIntrinsics() {
        return this.layoutIntrinsics;
    }

    public final float getLineAscent(int arg2) {
        int v1;
        if(arg2 == this.lineCount - 1) {
            Paint$FontMetricsInt v0 = this.lastLineFontMetrics;
            if(v0 != null) {
                v1 = v0.ascent;
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v1 = this.layout.getLineAscent(arg2);
        }

        return ((float)v1);
    }

    public final float getLineBaseline(int arg3) {
        float v0 = ((float)this.topPadding);
        float v3 = arg3 != this.lineCount - 1 || this.lastLineFontMetrics == null ? ((float)this.layout.getLineBaseline(arg3)) : this.getLineTop(arg3) - (((float)this.lastLineFontMetrics.ascent));
        return v0 + v3;
    }

    public final float getLineBottom(int arg3) {
        if(arg3 == this.lineCount - 1 && this.lastLineFontMetrics != null) {
            return (((float)this.layout.getLineBottom(arg3 - 1))) + (((float)this.lastLineFontMetrics.bottom));
        }

        float v0 = (((float)this.topPadding)) + (((float)this.layout.getLineBottom(arg3)));
        int v2 = arg3 == this.lineCount - 1 ? this.bottomPadding : 0;
        return v0 + (((float)v2));
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final float getLineDescent(int arg2) {
        int v1;
        if(arg2 == this.lineCount - 1) {
            Paint$FontMetricsInt v0 = this.lastLineFontMetrics;
            if(v0 != null) {
                v1 = v0.descent;
            }
            else {
                goto label_8;
            }
        }
        else {
        label_8:
            v1 = this.layout.getLineDescent(arg2);
        }

        return ((float)v1);
    }

    public final int getLineEllipsisCount(int arg1) {
        return this.layout.getEllipsisCount(arg1);
    }

    public final int getLineEllipsisOffset(int arg1) {
        return this.layout.getEllipsisStart(arg1);
    }

    public final int getLineEnd(int arg3) {
        if((TextLayout_androidKt.isLineEllipsized(this.layout, arg3)) && this.ellipsize == TextUtils$TruncateAt.END) {
            return this.layout.getText().length();
        }

        return this.layout.getLineEnd(arg3);
    }

    public final int getLineForOffset(int arg1) {
        return this.layout.getLineForOffset(arg1);
    }

    public final int getLineForVertical(int arg2) {
        return this.layout.getLineForVertical(arg2 - this.topPadding);
    }

    public final float getLineHeight(int arg2) {
        return this.getLineBottom(arg2) - this.getLineTop(arg2);
    }

    public final float getLineLeft(int arg3) {
        float v0 = this.layout.getLineLeft(arg3);
        float v2 = arg3 == this.lineCount - 1 ? this.leftPadding : 0f;
        return v0 + v2;
    }

    public final float getLineRight(int arg3) {
        float v0 = this.layout.getLineRight(arg3);
        float v2 = arg3 == this.lineCount - 1 ? this.rightPadding : 0f;
        return v0 + v2;
    }

    public final int getLineStart(int arg1) {
        return this.layout.getLineStart(arg1);
    }

    public final float getLineTop(int arg2) {
        float v0 = ((float)this.layout.getLineTop(arg2));
        int v1 = arg2 == 0 ? 0 : this.topPadding;
        return v0 + (((float)v1));
    }

    public final int getLineVisibleEnd(int arg3) {
        if((TextLayout_androidKt.isLineEllipsized(this.layout, arg3)) && this.ellipsize == TextUtils$TruncateAt.END) {
            return this.layout.getLineStart(arg3) + this.layout.getEllipsisStart(arg3);
        }

        return this.getLayoutHelper().getLineVisibleEnd(arg3);
    }

    public final float getLineWidth(int arg1) {
        return this.layout.getLineWidth(arg1);
    }

    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public final float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    public final int getOffsetForHorizontal(int arg3, float arg4) {
        return this.layout.getOffsetForHorizontal(arg3, arg4 + -1f * this.getHorizontalPadding(arg3));
    }

    public final int getParagraphDirection(int arg1) {
        return this.layout.getParagraphDirection(arg1);
    }

    public final float getPrimaryHorizontal(int arg3, boolean arg4) {
        return this.getLayoutHelper().getHorizontalPosition(arg3, true, arg4) + this.getHorizontalPadding(this.getLineForOffset(arg3));
    }

    public static float getPrimaryHorizontal$default(TextLayout arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.getPrimaryHorizontal(arg1, false);
    }

    public final int[] getRangeForRect(RectF arg7, int arg8, Function2 arg9) {
        if(Build$VERSION.SDK_INT >= 34) {
            return AndroidLayoutApi34.INSTANCE.getRangeForRect$ui_text(this, arg7, arg8, arg9);
        }

        return TextLayoutGetRangeForRectExtensions_androidKt.getRangeForRect(this, this.layout, this.getLayoutHelper(), arg7, arg8, arg9);
    }

    public final float getSecondaryHorizontal(int arg3, boolean arg4) {
        return this.getLayoutHelper().getHorizontalPosition(arg3, false, arg4) + this.getHorizontalPadding(this.getLineForOffset(arg3));
    }

    public static float getSecondaryHorizontal$default(TextLayout arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.getSecondaryHorizontal(arg1, false);
    }

    public final void getSelectionPath(int arg2, int arg3, Path arg4) {
        this.layout.getSelectionPath(arg2, arg3, arg4);
        if(this.topPadding != 0 && !arg4.isEmpty()) {
            arg4.offset(0f, ((float)this.topPadding));
        }
    }

    public final CharSequence getText() {
        return this.layout.getText();
    }

    public final TextPaint getTextPaint() {
        return this.textPaint;
    }

    public final int getTopPadding$ui_text() {
        return this.topPadding;
    }

    public static void getTopPadding$ui_text$annotations() {
    }

    public final WordIterator getWordIterator() {
        WordIterator v0 = this.backingWordIterator;
        if(v0 != null) {
            return v0;
        }

        v0 = new WordIterator(this.layout.getText(), 0, this.layout.getText().length(), this.textPaint.getTextLocale());
        this.backingWordIterator = v0;
        return v0;
    }

    public final boolean isFallbackLinespacingApplied$ui_text() {
        if(this.isBoringLayout) {
            BoringLayoutFactory v0 = BoringLayoutFactory.INSTANCE;
            Layout v3 = this.layout;
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type android.text.BoringLayout");
            return v0.isFallbackLineSpacingEnabled(((BoringLayout)v3));
        }

        StaticLayoutFactory v0_1 = StaticLayoutFactory.INSTANCE;
        Layout v1 = this.layout;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type android.text.StaticLayout");
        return v0_1.isFallbackLineSpacingEnabled(((StaticLayout)v1), this.fallbackLineSpacing);
    }

    public final boolean isLineEllipsized(int arg1) {
        return TextLayout_androidKt.isLineEllipsized(this.layout, arg1);
    }

    public final boolean isRtlCharAt(int arg1) {
        return this.layout.isRtlCharAt(arg1);
    }

    public final void paint(Canvas arg6) {
        if(!arg6.getClipBounds(this.rect)) {
        }
        else {
            int v0 = this.topPadding;
            if(v0 != 0) {
                arg6.translate(0f, ((float)v0));
            }

            ThreadLocal v0_1 = TextLayout_androidKt.getSharedTextAndroidCanvas();
            Object v2 = v0_1.get();
            if(v2 == null) {
                TextAndroidCanvas v2_1 = new TextAndroidCanvas();
                v0_1.set(v2_1);
            }

            ((TextAndroidCanvas)v2).set_nativeCanvas$ui_text(arg6);
            Canvas v0_2 = null;
            try {
                this.layout.draw(v2);
            }
            catch(Throwable v5) {
                ((TextAndroidCanvas)v2).set_nativeCanvas$ui_text(v0_2);
                throw v5;
            }

            ((TextAndroidCanvas)v2).set_nativeCanvas$ui_text(v0_2);
            int v5_1 = this.topPadding;
            if(v5_1 == 0) {
                return;
            }

            arg6.translate(0f, -1f * (((float)v5_1)));
        }
    }
}

