package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001eBk\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r\u0012\u0016\b\u0002\u0010\u000F\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020CH\u0002¢\u0006\u0004\bD\u0010?J\u001D\u0010E\u001A\u00020\u000B2\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020)¢\u0006\u0004\bI\u0010JJ\u001F\u0010K\u001A\u00020G2\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020)H\u0002¢\u0006\u0004\bL\u0010MJ\'\u00103\u001A\u00020+2\u0006\u0010H\u001A\u00020)2\u0006\u0010N\u001A\u00020G2\u0006\u0010O\u001A\u00020PH\u0002¢\u0006\u0004\bQ\u0010RJ\u0016\u0010S\u001A\u00020\r2\u0006\u0010T\u001A\u00020\r2\u0006\u0010H\u001A\u00020)Je\u0010U\u001A\u00020A2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0014\u0010\u000F\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001A\u00020\'2\u0006\u0010H\u001A\u00020)H\u0002J\u001F\u0010Y\u001A\u00020P2\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020)H\u0002¢\u0006\u0004\bZ\u0010[J%\u0010\\\u001A\u00020\u000B*\u0004\u0018\u00010+2\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020)H\u0002¢\u0006\u0004\b]\u0010^J\b\u0010_\u001A\u00020AH\u0002J\b\u0010`\u001A\u00020AH\u0002J\u000E\u0010a\u001A\u00020\r2\u0006\u0010H\u001A\u00020)J\u000E\u0010b\u001A\u00020\r2\u0006\u0010H\u001A\u00020)J\b\u0010c\u001A\u00020dH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0017R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000F\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001CR(\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u001D\u001A\u00020\u0005@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b$\u0010%R\u0010\u0010&\u001A\u0004\u0018\u00010\'X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010(\u001A\u0004\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010*\u001A\u0004\u0018\u00010+X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010.\u001A\b\u0018\u00010/R\u00020\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u00100\u001A\u00060/R\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b1\u00102R\u0011\u00103\u001A\u00020+8F¢\u0006\u0006\u001A\u0004\b4\u00105R\u0013\u00106\u001A\u0004\u0018\u00010+8F¢\u0006\u0006\u001A\u0004\b7\u00105R$\u00108\u001A\u0002098\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010;\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006f"}, d2={"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation", "(Landroidx/compose/ui/unit/Density;)V", "setStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutCache", "Landroidx/compose/ui/text/TextLayoutResult;", "cachedIntrinsicHeightInputWidth", "cachedIntrinsicHeight", "_textAutoSizeLayoutScope", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "fontSizeSearchScope", "getFontSizeSearchScope", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "layoutOrNull", "getLayoutOrNull", "historyFlag", "", "getHistoryFlag$foundation$annotations", "()V", "getHistoryFlag$foundation", "()J", "setHistoryFlag$foundation", "(J)V", "recordHistory", "", "op", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "recordHistory-4ETZmGE", "layoutWithConstraints", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "useMinLinesConstrainer", "useMinLinesConstrainer-Oh53vG4", "(JLandroidx/compose/ui/unit/LayoutDirection;)J", "finalConstraints", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "textLayoutResult-VKLhPVY", "(Landroidx/compose/ui/unit/LayoutDirection;JLandroidx/compose/ui/text/MultiParagraph;)Landroidx/compose/ui/text/TextLayoutResult;", "intrinsicHeight", "width", "update", "update-J2qo7bo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILjava/util/List;Landroidx/compose/foundation/text/TextAutoSize;)V", "setLayoutDirection", "layoutText", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-VKLhPVY", "(Landroidx/compose/ui/text/TextLayoutResult;JLandroidx/compose/ui/unit/LayoutDirection;)Z", "markDirty", "markStyleAffectedDirty", "maxIntrinsicWidth", "minIntrinsicWidth", "toString", "", "TextAutoSizeLayoutScopeImpl", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MultiParagraphLayoutCache {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001A\u00020\u0005*\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u0004\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\"\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\u000B@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "<init>", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "lastLayoutResult", "getLastLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "performLayout", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "performLayout-5ZSfY2I", "(JLandroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/TextLayoutResult;", "toPx", "toPx--R2X_6o", "(J)F", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextAutoSizeLayoutScopeImpl implements TextAutoSizeLayoutScope {
        private TextLayoutResult lastLayoutResult;

        public TextAutoSizeLayoutScopeImpl(MultiParagraphLayoutCache arg1) {
            MultiParagraphLayoutCache.this = arg1;
            super();
        }

        public float getDensity() {
            Density v0 = MultiParagraphLayoutCache.this.getDensity$foundation();
            Intrinsics.checkNotNull(v0);
            return v0.getDensity();
        }

        public float getFontScale() {
            Density v0 = MultiParagraphLayoutCache.this.getDensity$foundation();
            Intrinsics.checkNotNull(v0);
            return v0.getFontScale();
        }

        public final TextLayoutResult getLastLayoutResult() {
            return this.lastLayoutResult;
        }

        public TextLayoutResult performLayout-5ZSfY2I(long arg37, AnnotatedString arg39, long arg40) {
            long v2_1;
            TextAutoSizeLayoutScopeImpl v0 = this;
            TextStyle v1 = v0.this$0.style;
            long v7 = TextUnit.isEm-impl(arg40) ? MultiParagraphLayoutCacheKt.access$times-NB67dxo(v0.this$0.style.getFontSize-XSAIIZE(), arg40) : arg40;
            if(!TextUnit.equals-impl0(v7, v0.this$0.style.getFontSize-XSAIIZE())) {
                v0.this$0.setStyle(TextStyle.copy-p1EtxEg$default(v0.this$0.style, 0, v7, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFD, null));
            }

            if(v0.this$0.minLines > 1) {
                MultiParagraphLayoutCache v2 = v0.this$0;
                LayoutDirection v3 = v2.intrinsicsLayoutDirection;
                Intrinsics.checkNotNull(v3);
                v2_1 = v2.useMinLinesConstrainer-Oh53vG4(arg37, v3);
            }
            else {
                v2_1 = arg37;
            }

            MultiParagraphLayoutCache v4 = v0.this$0;
            LayoutDirection v5 = v4.intrinsicsLayoutDirection;
            Intrinsics.checkNotNull(v5);
            MultiParagraph v4_1 = v4.layoutText-K40F9xA(v2_1, v5);
            MultiParagraphLayoutCache v5_1 = v0.this$0;
            LayoutDirection v6 = v5_1.intrinsicsLayoutDirection;
            Intrinsics.checkNotNull(v6);
            TextLayoutResult v2_2 = v5_1.textLayoutResult-VKLhPVY(v6, v2_1, v4_1);
            v0.lastLayoutResult = v2_2;
            v0.this$0.setStyle(v1);
            return v2_2;
        }

        public float toPx--R2X_6o(long arg5) {
            if(TextUnit.isEm-impl(arg5)) {
                if(!TextUnit.isEm-impl(MultiParagraphLayoutCache.this.style.getFontSize-XSAIIZE())) {
                    if(!TextUnit.equals-impl0(MultiParagraphLayoutCache.this.style.getFontSize-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) {
                        return this.toPx--R2X_6o(MultiParagraphLayoutCache.this.style.getFontSize-XSAIIZE()) * TextUnit.getValue-impl(arg5);
                    }

                    throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is not set. Please specify a font size.".toString());
                }

                throw new IllegalStateException("InternalAutoSize -> toPx(): Cannot convert Em to Px when style.fontSize is Em\nDeclare the composable\'s style.fontSize with Sp units instead.".toString());
            }

            return this.toPx-0680j_4(this.toDp-GaN1DYA(arg5));
        }
    }

    public static final int $stable = 8;
    private TextAutoSizeLayoutScopeImpl _textAutoSizeLayoutScope;
    private TextAutoSize autoSize;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private Resolver fontFamilyResolver;
    private long historyFlag;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private TextLayoutResult layoutCache;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private MultiParagraphIntrinsics paragraphIntrinsics;
    private List placeholders;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;

    static {
    }

    private MultiParagraphLayoutCache(AnnotatedString arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, List arg8, TextAutoSize arg9) {
        super();
        this.text = arg1;
        this.fontFamilyResolver = arg3;
        this.overflow = arg4;
        this.softWrap = arg5;
        this.maxLines = arg6;
        this.minLines = arg7;
        this.placeholders = arg8;
        this.autoSize = arg9;
        this.lastDensity = InlineDensity.Companion.getUnspecified-L26CHvs();
        this.style = arg2;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    public MultiParagraphLayoutCache(AnnotatedString arg14, TextStyle arg15, Resolver arg16, int arg17, boolean arg18, int arg19, int arg20, List arg21, TextAutoSize arg22, int arg23, DefaultConstructorMarker arg24) {
        int v0 = arg23;
        int v6 = (v0 & 8) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg17;
        boolean v7 = (v0 & 16) != 0 ? true : arg18;
        int v8 = (v0 & 0x20) != 0 ? 0x7FFFFFFF : arg19;
        int v9 = (v0 & 0x40) != 0 ? 1 : arg20;
        List v2 = null;
        List v10 = (v0 & 0x80) != 0 ? v2 : arg21;
        TextAutoSize v11 = (v0 & 0x100) != 0 ? ((TextAutoSize)v2) : arg22;
        this(arg14, arg15, arg16, v6, v7, v8, v9, v10, v11, null);
    }

    public MultiParagraphLayoutCache(AnnotatedString arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, List arg8, TextAutoSize arg9, DefaultConstructorMarker arg10) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static final LayoutDirection access$getIntrinsicsLayoutDirection$p(MultiParagraphLayoutCache arg0) {
        return arg0.intrinsicsLayoutDirection;
    }

    public static final int access$getMinLines$p(MultiParagraphLayoutCache arg0) {
        return arg0.minLines;
    }

    public static final TextStyle access$getStyle$p(MultiParagraphLayoutCache arg0) {
        return arg0.style;
    }

    public static final MultiParagraph access$layoutText-K40F9xA(MultiParagraphLayoutCache arg0, long arg1, LayoutDirection arg3) {
        return arg0.layoutText-K40F9xA(arg1, arg3);
    }

    public static final void access$setStyle(MultiParagraphLayoutCache arg0, TextStyle arg1) {
        arg0.setStyle(arg1);
    }

    public static final TextLayoutResult access$textLayoutResult-VKLhPVY(MultiParagraphLayoutCache arg0, LayoutDirection arg1, long arg2, MultiParagraph arg4) {
        return arg0.textLayoutResult-VKLhPVY(arg1, arg2, arg4);
    }

    public static final long access$useMinLinesConstrainer-Oh53vG4(MultiParagraphLayoutCache arg0, long arg1, LayoutDirection arg3) {
        return arg0.useMinLinesConstrainer-Oh53vG4(arg1, arg3);
    }

    public final Density getDensity$foundation() {
        return this.density;
    }

    private final TextAutoSizeLayoutScopeImpl getFontSizeSearchScope() {
        TextAutoSizeLayoutScopeImpl v0 = this._textAutoSizeLayoutScope;
        if(v0 == null) {
            v0 = new TextAutoSizeLayoutScopeImpl(this);
            this._textAutoSizeLayoutScope = v0;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public final long getHistoryFlag$foundation() {
        return this.historyFlag;
    }

    public static void getHistoryFlag$foundation$annotations() {
    }

    public final TextLayoutResult getLayoutOrNull() {
        return this.layoutCache;
    }

    public final TextLayoutResult getTextLayoutResult() {
        TextLayoutResult v0 = this.layoutCache;
        if(v0 != null) {
            return v0;
        }

        throw new IllegalStateException("Internal Error: MultiParagraphLayoutCache could not provide TextLayoutResult during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: " + this);
    }

    public final int intrinsicHeight(int arg5, LayoutDirection arg6) {
        int v0 = this.cachedIntrinsicHeightInputWidth;
        int v1 = this.cachedIntrinsicHeight;
        if(arg5 == v0 && v0 != -1) {
            return v1;
        }

        long v0_1 = ConstraintsKt.Constraints(0, arg5, 0, 0x7FFFFFFF);
        if(this.minLines > 1) {
            v0_1 = this.useMinLinesConstrainer-Oh53vG4(v0_1, arg6);
        }

        int v6 = RangesKt.coerceAtLeast(TextDelegateKt.ceilToIntPx(this.layoutText-K40F9xA(v0_1, arg6).getHeight()), Constraints.getMinHeight-impl(v0_1));
        this.cachedIntrinsicHeightInputWidth = arg5;
        this.cachedIntrinsicHeight = v6;
        return v6;
    }

    private final MultiParagraph layoutText-K40F9xA(long arg8, LayoutDirection arg10) {
        MultiParagraphIntrinsics v1 = this.setLayoutDirection(arg10);
        return new MultiParagraph(v1, LayoutUtilsKt.finalConstraints-tfFHcEY(arg8, this.softWrap, this.overflow, v1.getMaxIntrinsicWidth()), LayoutUtilsKt.finalMaxLines-xdlQI24(this.softWrap, this.overflow, this.maxLines), this.overflow, null);
    }

    public final boolean layoutWithConstraints-K40F9xA(long arg43, LayoutDirection arg45) {
        TextLayoutResult v2;
        MultiParagraphLayoutCache v0 = this;
        LayoutDirection v1 = arg45;
        v0.recordHistory-4ETZmGE(LayoutCacheOperation.Companion.getLayoutWithConstraints-DEKiAbY());
        long v4 = v0.minLines > 1 ? this.useMinLinesConstrainer-Oh53vG4(arg43, arg45) : arg43;
        if(!v0.newLayoutWillBeDifferent-VKLhPVY(v0.layoutCache, v4, v1)) {
            v2 = v0.layoutCache;
            Intrinsics.checkNotNull(v2);
            if(Constraints.equals-impl0(v4, v2.getLayoutInput().getConstraints-msEJaDk())) {
                return 0;
            }

            v2 = v0.layoutCache;
            Intrinsics.checkNotNull(v2);
            v0.layoutCache = v0.textLayoutResult-VKLhPVY(v1, v4, v2.getMultiParagraph());
            return 1;
        }

        if(v0.autoSize != null) {
            v0.intrinsicsLayoutDirection = v1;
            long v6 = v0.style.getFontSize-XSAIIZE();
            TextAutoSize v2_1 = v0.autoSize;
            Intrinsics.checkNotNull(v2_1);
            long v8 = v2_1.getFontSize-Ci0_558(v0.getFontSizeSearchScope(), arg43, v0.text);
            if(TextUnit.isEm-impl(v8)) {
                v8 = MultiParagraphLayoutCacheKt.access$times-NB67dxo(v6, v8);
            }

            long v13 = v8;
            v2 = v0.getFontSizeSearchScope().getLastLayoutResult();
            if(v2 != null && (TextUnit.equals-impl0(v13, v2.getLayoutInput().getStyle().getFontSize-XSAIIZE())) && (TextOverflow.equals-impl0(v2.getLayoutInput().getOverflow-gIe3tQ8(), v0.overflow))) {
                v0.layoutCache = v2;
                return 1;
            }

            v0.setStyle(TextStyle.copy-p1EtxEg$default(v0.style, 0, v13, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFD, null));
        }

        v0.layoutCache = v0.textLayoutResult-VKLhPVY(v1, v4, v0.layoutText-K40F9xA(v4, v1));
        return 1;
    }

    private final void markDirty() {
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
        this.cachedIntrinsicHeight = -1;
        this.cachedIntrinsicHeightInputWidth = -1;
        this._textAutoSizeLayoutScope = null;
    }

    private final void markStyleAffectedDirty() {
        this.recordHistory-4ETZmGE(LayoutCacheOperation.Companion.getMarkDirtyStyle-DEKiAbY());
        this.paragraphIntrinsics = null;
        this.layoutCache = null;
        this.cachedIntrinsicHeight = -1;
        this.cachedIntrinsicHeightInputWidth = -1;
    }

    public final int maxIntrinsicWidth(LayoutDirection arg1) {
        return TextDelegateKt.ceilToIntPx(this.setLayoutDirection(arg1).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection arg1) {
        return TextDelegateKt.ceilToIntPx(this.setLayoutDirection(arg1).getMinIntrinsicWidth());
    }

    private final boolean newLayoutWillBeDifferent-VKLhPVY(TextLayoutResult arg4, long arg5, LayoutDirection arg7) {
        if(arg4 == null) {
            return 1;
        }

        if(arg4.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return 1;
        }

        if(arg7 != arg4.getLayoutInput().getLayoutDirection()) {
            return 1;
        }

        if(Constraints.equals-impl0(arg5, arg4.getLayoutInput().getConstraints-msEJaDk())) {
            return 0;
        }

        if(Constraints.getMaxWidth-impl(arg5) != Constraints.getMaxWidth-impl(arg4.getLayoutInput().getConstraints-msEJaDk())) {
            return 1;
        }

        if(Constraints.getMinWidth-impl(arg5) != Constraints.getMinWidth-impl(arg4.getLayoutInput().getConstraints-msEJaDk())) {
            return 1;
        }

        if((((float)Constraints.getMaxHeight-impl(arg5))) >= arg4.getMultiParagraph().getHeight()) {
            if(arg4.getMultiParagraph().getDidExceedMaxLines()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final void recordHistory-4ETZmGE(long arg4) {
        this.historyFlag = arg4 | this.historyFlag << 2;
    }

    public final void setDensity$foundation(Density arg6) {
        Density v0 = this.density;
        long v1 = arg6 != null ? InlineDensity.constructor-impl(arg6) : InlineDensity.Companion.getUnspecified-L26CHvs();
        if(v0 == null) {
            this.density = arg6;
            this.lastDensity = v1;
            return;
        }

        if(arg6 != null) {
            if(!InlineDensity.equals-impl0(this.lastDensity, v1)) {
            }
            else {
                return;
            }
        }

        this.density = arg6;
        this.lastDensity = v1;
        this.recordHistory-4ETZmGE(LayoutCacheOperation.Companion.getMarkDirtyDensity-DEKiAbY());
        this.markDirty();
    }

    public final void setHistoryFlag$foundation(long arg1) {
        this.historyFlag = arg1;
    }

    private final MultiParagraphIntrinsics setLayoutDirection(LayoutDirection arg9) {
        MultiParagraphIntrinsics v0 = this.paragraphIntrinsics;
        if(v0 == null || arg9 != this.intrinsicsLayoutDirection || (v0.getHasStaleResolvedFonts())) {
            this.intrinsicsLayoutDirection = arg9;
            AnnotatedString v3 = this.text;
            TextStyle v4 = TextStyleKt.resolveDefaults(this.style, arg9);
            Density v6 = this.density;
            Intrinsics.checkNotNull(v6);
            Resolver v7 = this.fontFamilyResolver;
            List v9 = this.placeholders;
            if(v9 == null) {
                v9 = CollectionsKt.emptyList();
            }

            v0 = new MultiParagraphIntrinsics(v3, v4, v9, v6, v7);
        }

        this.paragraphIntrinsics = v0;
        return v0;
    }

    private final void setStyle(TextStyle arg2) {
        boolean v0 = arg2.hasSameLayoutAffectingAttributes(this.style);
        this.style = arg2;
        if(!v0) {
            this.markStyleAffectedDirty();
        }
    }

    private final TextLayoutResult textLayoutResult-VKLhPVY(LayoutDirection arg17, long arg18, MultiParagraph arg20) {
        MultiParagraphLayoutCache v0 = this;
        float v1 = Math.min(arg20.getIntrinsics().getMaxIntrinsicWidth(), arg20.getWidth());
        AnnotatedString v4 = v0.text;
        TextStyle v5 = v0.style;
        List v6 = v0.placeholders;
        if(v6 == null) {
            v6 = CollectionsKt.emptyList();
        }

        int v7 = v0.maxLines;
        boolean v8 = v0.softWrap;
        int v9 = v0.overflow;
        Density v10 = v0.density;
        Intrinsics.checkNotNull(v10);
        return new TextLayoutResult(new TextLayoutInput(v4, v5, v6, v7, v8, v9, v10, arg17, v0.fontFamilyResolver, arg18, null), arg20, ConstraintsKt.constrain-4WqzIAM(arg18, IntSize.constructor-impl((((long)TextDelegateKt.ceilToIntPx(arg20.getHeight()))) & 0xFFFFFFFFL | (((long)TextDelegateKt.ceilToIntPx(v1))) << 0x20)), null);
    }

    public String toString() {
        Constraints v2_1;
        StringBuilder v0 = new StringBuilder("MultiParagraphLayoutCache(textLayoutResult=");
        String v2 = "null";
        String v1 = this.layoutCache != null ? "<TextLayoutResult>" : v2;
        v0 = v0.append(v1).append(", lastDensity=").append(InlineDensity.toString-impl(this.lastDensity)).append(", history=").append(this.historyFlag).append(", constraints=");
        TextLayoutResult v5 = this.layoutCache;
        if(v5 != null) {
            TextLayoutInput v5_1 = v5.getLayoutInput();
            if(v5_1 != null) {
                v2_1 = Constraints.box-impl(v5_1.getConstraints-msEJaDk());
            }
        }

        return v0.append(v2_1).append(')').toString();
    }

    public final void update-J2qo7bo(AnnotatedString arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, List arg8, TextAutoSize arg9) {
        this.text = arg1;
        this.setStyle(arg2);
        this.fontFamilyResolver = arg3;
        this.overflow = arg4;
        this.softWrap = arg5;
        this.maxLines = arg6;
        this.minLines = arg7;
        this.placeholders = arg8;
        this.autoSize = arg9;
        this.recordHistory-4ETZmGE(LayoutCacheOperation.Companion.getMarkDirtyNode-DEKiAbY());
        this.markDirty();
    }

    private final long useMinLinesConstrainer-Oh53vG4(long arg7, LayoutDirection arg9) {
        Companion v0 = MinLinesConstrainer.Companion;
        MinLinesConstrainer v1 = this.mMinLinesConstrainer;
        TextStyle v3 = this.style;
        Density v4 = this.density;
        Intrinsics.checkNotNull(v4);
        MinLinesConstrainer v9 = v0.from(v1, arg9, v3, v4, this.fontFamilyResolver);
        this.mMinLinesConstrainer = v9;
        return v9.coerceMinLines-Oh53vG4$foundation(arg7, this.minLines);
    }
}

