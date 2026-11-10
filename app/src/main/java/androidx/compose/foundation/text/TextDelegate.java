package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 H2\u00020\u0001:\u0001HBe\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0014\b\u0002\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000E\u0010:\u001A\u00020;2\u0006\u0010<\u001A\u00020/J\u001F\u0010=\u001A\u00020>2\u0006\u0010?\u001A\u00020@2\u0006\u0010<\u001A\u00020/H\u0002¢\u0006\u0004\bA\u0010BJ)\u0010C\u001A\u00020D2\u0006\u0010?\u001A\u00020@2\u0006\u0010<\u001A\u00020/2\n\b\u0002\u0010E\u001A\u0004\u0018\u00010D¢\u0006\u0004\bF\u0010GR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001CR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0013\u0010\u000B\u001A\u00020\f¢\u0006\n\n\u0002\u0010!\u001A\u0004\b \u0010\u001CR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u001D\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u001C\u0010(\u001A\u0004\u0018\u00010)X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001C\u0010.\u001A\u0004\u0018\u00010/X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001A\u00020)8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b5\u0010+R\u0011\u00106\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b7\u0010\u001CR\u0011\u00108\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b9\u0010\u001C¨\u0006I"}, d2={"Landroidx/compose/foundation/text/TextDelegate;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "maxLines", "", "minLines", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IIZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getMaxLines", "()I", "getMinLines", "getSoftWrap", "()Z", "getOverflow-gIe3tQ8", "I", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getPlaceholders", "()Ljava/util/List;", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getParagraphIntrinsics$foundation", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "setParagraphIntrinsics$foundation", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;)V", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getIntrinsicsLayoutDirection$foundation", "()Landroidx/compose/ui/unit/LayoutDirection;", "setIntrinsicsLayoutDirection$foundation", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "nonNullIntrinsics", "getNonNullIntrinsics", "minIntrinsicWidth", "getMinIntrinsicWidth", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "layoutIntrinsics", "", "layoutDirection", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "prevResult", "layout-NN6Ew-U", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextDelegate {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Landroidx/compose/foundation/text/TextDelegate$Companion;", "", "<init>", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void paint(Canvas arg1, TextLayoutResult arg2) {
            TextPainter.INSTANCE.paint(arg1, arg2);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Density density;
    private final Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private final int maxLines;
    private final int minLines;
    private final int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private final List placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    static {
        TextDelegate.Companion = new Companion(null);
    }

    public TextDelegate(AnnotatedString arg14, TextStyle arg15, int arg16, int arg17, boolean arg18, int arg19, Density arg20, Resolver arg21, List arg22, int arg23, DefaultConstructorMarker arg24) {
        int v0 = arg23;
        int v5 = (v0 & 4) != 0 ? 0x7FFFFFFF : arg16;
        int v6 = (v0 & 8) != 0 ? 1 : arg17;
        boolean v7 = (v0 & 16) != 0 ? true : arg18;
        int v8 = (v0 & 0x20) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg19;
        List v11 = (v0 & 0x100) != 0 ? CollectionsKt.emptyList() : arg22;
        this(arg14, arg15, v5, v6, v7, v8, arg20, arg21, v11, null);
    }

    private TextDelegate(AnnotatedString arg1, TextStyle arg2, int arg3, int arg4, boolean arg5, int arg6, Density arg7, Resolver arg8, List arg9) {
        super();
        this.text = arg1;
        this.style = arg2;
        this.maxLines = arg3;
        this.minLines = arg4;
        this.softWrap = arg5;
        this.overflow = arg6;
        this.density = arg7;
        this.fontFamilyResolver = arg8;
        this.placeholders = arg9;
        int v0 = 1;
        int v2 = arg3 > 0 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("no maxLines");
        }

        v2 = arg4 > 0 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("no minLines");
        }

        if(arg4 <= arg3) {
        }
        else {
            v0 = 0;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("minLines greater than maxLines");
        }
    }

    public TextDelegate(AnnotatedString arg1, TextStyle arg2, int arg3, int arg4, boolean arg5, int arg6, Density arg7, Resolver arg8, List arg9, DefaultConstructorMarker arg10) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutDirection getIntrinsicsLayoutDirection$foundation() {
        return this.intrinsicsLayoutDirection;
    }

    public final int getMaxIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(this.getNonNullIntrinsics().getMaxIntrinsicWidth());
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getMinIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(this.getNonNullIntrinsics().getMinIntrinsicWidth());
    }

    public final int getMinLines() {
        return this.minLines;
    }

    private final MultiParagraphIntrinsics getNonNullIntrinsics() {
        MultiParagraphIntrinsics v1 = this.paragraphIntrinsics;
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    public final int getOverflow-gIe3tQ8() {
        return this.overflow;
    }

    public final MultiParagraphIntrinsics getParagraphIntrinsics$foundation() {
        return this.paragraphIntrinsics;
    }

    public final List getPlaceholders() {
        return this.placeholders;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextLayoutResult layout-NN6Ew-U(long arg19, LayoutDirection arg21, TextLayoutResult arg22) {
        // Method was not decompiled
    }

    public static TextLayoutResult layout-NN6Ew-U$default(TextDelegate arg0, long arg1, LayoutDirection arg3, TextLayoutResult arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg4 = null;
        }

        return arg0.layout-NN6Ew-U(arg1, arg3, arg4);
    }

    public final void layoutIntrinsics(LayoutDirection arg9) {
        MultiParagraphIntrinsics v0 = this.paragraphIntrinsics;
        if(v0 == null || arg9 != this.intrinsicsLayoutDirection || (v0.getHasStaleResolvedFonts())) {
            this.intrinsicsLayoutDirection = arg9;
            v0 = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, arg9), this.placeholders, this.density, this.fontFamilyResolver);
        }

        this.paragraphIntrinsics = v0;
    }

    private final MultiParagraph layoutText-K40F9xA(long arg10, LayoutDirection arg12) {
        int v0;
        this.layoutIntrinsics(arg12);
        int v12 = Constraints.getMinWidth-impl(arg10);
        if(!this.softWrap && !TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8())) {
            goto label_13;
        }
        else if(Constraints.getHasBoundedWidth-impl(arg10)) {
            v0 = Constraints.getMaxWidth-impl(arg10);
        }
        else {
        label_13:
            v0 = 0x7FFFFFFF;
        }

        int v1 = (this.softWrap) || !TextOverflow.equals-impl0(this.overflow, TextOverflow.Companion.getEllipsis-gIe3tQ8()) ? this.maxLines : 1;
        int v6 = v1;
        if(v12 == v0) {
        }
        else {
            v0 = RangesKt.coerceIn(this.getMaxIntrinsicWidth(), v12, v0);
        }

        return new MultiParagraph(this.getNonNullIntrinsics(), Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(0, v0, 0, Constraints.getMaxHeight-impl(arg10)), v6, this.overflow, null);
    }

    public final void setIntrinsicsLayoutDirection$foundation(LayoutDirection arg1) {
        this.intrinsicsLayoutDirection = arg1;
    }

    public final void setParagraphIntrinsics$foundation(MultiParagraphIntrinsics arg1) {
        this.paragraphIntrinsics = arg1;
    }
}

