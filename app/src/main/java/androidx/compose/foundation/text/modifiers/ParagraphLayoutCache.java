package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010A\u001A\u00020\u001D2\u0006\u0010B\u001A\u00020CH\u0002¢\u0006\u0004\bD\u00100J\u001D\u0010E\u001A\u00020\u000B2\u0006\u0010F\u001A\u0002082\u0006\u0010G\u001A\u000206¢\u0006\u0004\bH\u0010IJ)\u0010J\u001A\u0002082\u0006\u0010F\u001A\u0002082\u0006\u0010G\u001A\u0002062\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0002¢\u0006\u0004\bK\u0010LJ\u0016\u0010M\u001A\u00020\r2\u0006\u0010N\u001A\u00020\r2\u0006\u0010G\u001A\u000206JE\u0010O\u001A\u00020\u001D2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001A\u0002042\u0006\u0010G\u001A\u000206H\u0002J\u001F\u0010S\u001A\u00020!2\u0006\u0010F\u001A\u0002082\u0006\u0010G\u001A\u000206H\u0000¢\u0006\u0004\bT\u0010UJ\u001F\u0010V\u001A\u00020\u000B2\u0006\u0010F\u001A\u0002082\u0006\u0010G\u001A\u000206H\u0002¢\u0006\u0004\bW\u0010IJ\b\u0010X\u001A\u00020\u001DH\u0002J\u0010\u0010Y\u001A\u0004\u0018\u00010Z2\u0006\u0010\u0004\u001A\u00020\u0005J\u000E\u0010[\u001A\u00020\r2\u0006\u0010G\u001A\u000206J\u000E\u0010\\\u001A\u00020\r2\u0006\u0010G\u001A\u000206J\b\u0010]\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0011R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u00020\u0013X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0014R(\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016@@X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u001D8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u001C\u0010 \u001A\u0004\u0018\u00010!X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001A\u0010&\u001A\u00020\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001C\u0010+\u001A\u00020,X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0014\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u00101\u001A\u0004\u0018\u000102X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00103\u001A\u0004\u0018\u000104X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00105\u001A\u0004\u0018\u000106X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00107\u001A\u000208X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0014R\u000E\u00109\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010:\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010;\u001A\u00020<8\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010>\u001A\u0004\b?\u0010.\"\u0004\b@\u00100¨\u0006^"}, d2={"Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "lastDensity", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "J", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation", "(Landroidx/compose/ui/unit/Density;)V", "observeFontChanges", "", "getObserveFontChanges$foundation", "()Lkotlin/Unit;", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "getParagraph$foundation", "()Landroidx/compose/ui/text/Paragraph;", "setParagraph$foundation", "(Landroidx/compose/ui/text/Paragraph;)V", "didOverflow", "getDidOverflow$foundation", "()Z", "setDidOverflow$foundation", "(Z)V", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "getLayoutSize-YbymL2g$foundation", "()J", "setLayoutSize-ozmzZPI$foundation", "(J)V", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevConstraints", "Landroidx/compose/ui/unit/Constraints;", "cachedIntrinsicHeightInputWidth", "cachedIntrinsicHeight", "historyFlag", "", "getHistoryFlag$foundation$annotations", "()V", "getHistoryFlag$foundation", "setHistoryFlag$foundation", "recordHistory", "op", "Landroidx/compose/foundation/text/modifiers/LayoutCacheOperation;", "recordHistory-4ETZmGE", "layoutWithConstraints", "constraints", "layoutDirection", "layoutWithConstraints-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "useMinLinesConstrainer", "useMinLinesConstrainer-euUD3Qg", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;)J", "intrinsicHeight", "width", "update", "update-L6sJoHM", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZII)V", "setLayoutDirection", "layoutText", "layoutText-K40F9xA$foundation", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/Paragraph;", "newLayoutWillBeDifferent", "newLayoutWillBeDifferent-K40F9xA", "markDirty", "slowCreateTextLayoutResultOrNull", "Landroidx/compose/ui/text/TextLayoutResult;", "minIntrinsicWidth", "maxIntrinsicWidth", "toString", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParagraphLayoutCache {
    public static final int $stable = 8;
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private Resolver fontFamilyResolver;
    private long historyFlag;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    static {
    }

    private ParagraphLayoutCache(String arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7) {
        super();
        this.text = arg1;
        this.style = arg2;
        this.fontFamilyResolver = arg3;
        this.overflow = arg4;
        this.softWrap = arg5;
        this.maxLines = arg6;
        this.minLines = arg7;
        this.lastDensity = InlineDensity.Companion.getUnspecified-L26CHvs();
        this.layoutSize = IntSize.constructor-impl(0);
        this.prevConstraints = Constraints.Companion.fixed-JhjzzOo(0, 0);
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }

    public ParagraphLayoutCache(String arg10, TextStyle arg11, Resolver arg12, int arg13, boolean arg14, int arg15, int arg16, int arg17, DefaultConstructorMarker arg18) {
        if((arg17 & 8) != 0) {
            arg13 = TextOverflow.Companion.getClip-gIe3tQ8();
        }

        int v4 = arg13;
        boolean v5 = (arg17 & 16) != 0 ? true : arg14;
        int v6 = (arg17 & 0x20) != 0 ? 0x7FFFFFFF : arg15;
        int v7 = (arg17 & 0x40) != 0 ? 1 : arg16;
        this(arg10, arg11, arg12, v4, v5, v6, v7, null);
    }

    public ParagraphLayoutCache(String arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public final Density getDensity$foundation() {
        return this.density;
    }

    public final boolean getDidOverflow$foundation() {
        return this.didOverflow;
    }

    public final long getHistoryFlag$foundation() {
        return this.historyFlag;
    }

    public static void getHistoryFlag$foundation$annotations() {
    }

    public final long getLayoutSize-YbymL2g$foundation() {
        return this.layoutSize;
    }

    public final Unit getObserveFontChanges$foundation() {
        ParagraphIntrinsics v0 = this.paragraphIntrinsics;
        if(v0 != null) {
            v0.getHasStaleResolvedFonts();
        }

        return Unit.INSTANCE;
    }

    public final Paragraph getParagraph$foundation() {
        return this.paragraph;
    }

    public final int intrinsicHeight(int arg10, LayoutDirection arg11) {
        LayoutDirection v5;
        ParagraphLayoutCache v2;
        int v0 = this.cachedIntrinsicHeightInputWidth;
        int v1 = this.cachedIntrinsicHeight;
        if(arg10 == v0 && v0 != -1) {
            return v1;
        }

        long v3 = ConstraintsKt.Constraints(0, arg10, 0, 0x7FFFFFFF);
        if(this.minLines > 1) {
            v2 = this;
            v5 = arg11;
            v3 = ParagraphLayoutCache.useMinLinesConstrainer-euUD3Qg$default(v2, v3, v5, null, 4, null);
        }
        else {
            v2 = this;
            v5 = arg11;
        }

        int v9 = RangesKt.coerceAtLeast(TextDelegateKt.ceilToIntPx(v2.layoutText-K40F9xA$foundation(v3, v5).getHeight()), Constraints.getMinHeight-impl(v3));
        v2.cachedIntrinsicHeightInputWidth = arg10;
        v2.cachedIntrinsicHeight = v9;
        return v9;
    }

    public final Paragraph layoutText-K40F9xA$foundation(long arg4, LayoutDirection arg6) {
        ParagraphIntrinsics v6 = this.setLayoutDirection(arg6);
        return ParagraphKt.Paragraph-czeN-Hc(v6, LayoutUtilsKt.finalConstraints-tfFHcEY(arg4, this.softWrap, this.overflow, v6.getMaxIntrinsicWidth()), LayoutUtilsKt.finalMaxLines-xdlQI24(this.softWrap, this.overflow, this.maxLines), this.overflow);
    }

    public final boolean layoutWithConstraints-K40F9xA(long arg10, LayoutDirection arg12) {
        Paragraph v9;
        LayoutDirection v5;
        ParagraphLayoutCache v2;
        this.recordHistory-4ETZmGE(LayoutCacheOperation.Companion.getLayoutWithConstraints-DEKiAbY());
        boolean v1 = true;
        if(this.minLines > 1) {
            v2 = this;
            v5 = arg12;
            arg10 = ParagraphLayoutCache.useMinLinesConstrainer-euUD3Qg$default(v2, arg10, v5, null, 4, null);
        }
        else {
            v2 = this;
            v5 = arg12;
        }

        boolean v12 = false;
        long v3 = 0xFFFFFFFFL;
        int v0 = 0x20;
        if(!v2.newLayoutWillBeDifferent-K40F9xA(arg10, v5)) {
            if(!Constraints.equals-impl0(arg10, v2.prevConstraints)) {
                v9 = v2.paragraph;
                Intrinsics.checkNotNull(v9);
                long v5_1 = ConstraintsKt.constrain-4WqzIAM(arg10, IntSize.constructor-impl((((long)TextDelegateKt.ceilToIntPx(v9.getHeight()))) & v3 | (((long)TextDelegateKt.ceilToIntPx(Math.min(v9.getMaxIntrinsicWidth(), v9.getWidth())))) << v0));
                v2.layoutSize = v5_1;
                if(TextOverflow.equals-impl0(v2.overflow, TextOverflow.Companion.getVisible-gIe3tQ8())) {
                label_57:
                    v1 = false;
                }
                else if((((float)(((int)(v5_1 >> v0))))) >= v9.getWidth()) {
                    if((((float)(((int)(v3 & v5_1))))) < v9.getHeight()) {
                    }
                    else {
                        goto label_57;
                    }
                }

                v2.didOverflow = v1;
                v2.prevConstraints = arg10;
            }

            return 0;
        }

        v9 = v2.layoutText-K40F9xA$foundation(arg10, v5);
        v2.prevConstraints = arg10;
        arg10 = ConstraintsKt.constrain-4WqzIAM(arg10, IntSize.constructor-impl((((long)TextDelegateKt.ceilToIntPx(v9.getHeight()))) & v3 | (((long)TextDelegateKt.ceilToIntPx(v9.getWidth()))) << v0));
        v2.layoutSize = arg10;
        if(!TextOverflow.equals-impl0(v2.overflow, TextOverflow.Companion.getVisible-gIe3tQ8()) && ((((float)(((int)(arg10 >> v0))))) < v9.getWidth() || (((float)(((int)(arg10 & v3))))) < v9.getHeight())) {
            v12 = true;
        }

        v2.didOverflow = v12;
        v2.paragraph = v9;
        return 1;
    }

    private final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.Companion.fixed-JhjzzOo(0, 0);
        this.layoutSize = IntSize.constructor-impl(0);
        this.didOverflow = false;
    }

    public final int maxIntrinsicWidth(LayoutDirection arg1) {
        return TextDelegateKt.ceilToIntPx(this.setLayoutDirection(arg1).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection arg1) {
        return TextDelegateKt.ceilToIntPx(this.setLayoutDirection(arg1).getMinIntrinsicWidth());
    }

    private final boolean newLayoutWillBeDifferent-K40F9xA(long arg6, LayoutDirection arg8) {
        Paragraph v0 = this.paragraph;
        if(v0 == null) {
            return 1;
        }

        ParagraphIntrinsics v2 = this.paragraphIntrinsics;
        if(v2 == null) {
            return 1;
        }

        if(v2.getHasStaleResolvedFonts()) {
            return 1;
        }

        if(arg8 != this.intrinsicsLayoutDirection) {
            return 1;
        }

        if(Constraints.equals-impl0(arg6, this.prevConstraints)) {
            return 0;
        }

        if(Constraints.getMaxWidth-impl(arg6) != Constraints.getMaxWidth-impl(this.prevConstraints)) {
            return 1;
        }

        if(Constraints.getMinWidth-impl(arg6) != Constraints.getMinWidth-impl(this.prevConstraints)) {
            return 1;
        }

        if((((float)Constraints.getMaxHeight-impl(arg6))) >= v0.getHeight()) {
            if(v0.getDidExceedMaxLines()) {
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

    public final void setDidOverflow$foundation(boolean arg1) {
        this.didOverflow = arg1;
    }

    public final void setHistoryFlag$foundation(long arg1) {
        this.historyFlag = arg1;
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection arg9) {
        ParagraphIntrinsics v0 = this.paragraphIntrinsics;
        if(v0 == null || arg9 != this.intrinsicsLayoutDirection || (v0.getHasStaleResolvedFonts())) {
            this.intrinsicsLayoutDirection = arg9;
            String v2 = this.text;
            TextStyle v3 = TextStyleKt.resolveDefaults(this.style, arg9);
            List v4 = CollectionsKt.emptyList();
            Density v5 = this.density;
            Intrinsics.checkNotNull(v5);
            v0 = ParagraphIntrinsicsKt.ParagraphIntrinsics(v2, v3, v4, v5, this.fontFamilyResolver, CollectionsKt.emptyList());
        }

        this.paragraphIntrinsics = v0;
        return v0;
    }

    public final void setLayoutSize-ozmzZPI$foundation(long arg1) {
        this.layoutSize = arg1;
    }

    public final void setParagraph$foundation(Paragraph arg1) {
        this.paragraph = arg1;
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull(TextStyle arg20) {
        ParagraphLayoutCache v0 = this;
        LayoutDirection v9 = v0.intrinsicsLayoutDirection;
        TextLayoutResult v1 = null;
        if(v9 == null) {
            return v1;
        }

        Density v6 = v0.density;
        if(v6 == null) {
            return v1;
        }

        AnnotatedString v2 = new AnnotatedString(v0.text, ((List)v1), 2, ((DefaultConstructorMarker)v1));
        if(v0.paragraph == null) {
            return v1;
        }

        if(v0.paragraphIntrinsics == null) {
            return v1;
        }

        long v11 = Constraints.constructor-impl(v0.prevConstraints & -8589934589L);
        return new TextLayoutResult(new TextLayoutInput(v2, arg20, CollectionsKt.emptyList(), v0.maxLines, v0.softWrap, v0.overflow, v6, v9, v0.fontFamilyResolver, v11, null), new MultiParagraph(new MultiParagraphIntrinsics(v2, arg20, CollectionsKt.emptyList(), v6, v0.fontFamilyResolver), v11, v0.maxLines, v0.overflow, null), v0.layoutSize, null);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("ParagraphLayoutCache(paragraph=");
        String v1 = this.paragraph != null ? "<paragraph>" : "null";
        return v0.append(v1).append(", lastDensity=").append(InlineDensity.toString-impl(this.lastDensity)).append(", history=").append(this.historyFlag).append(", constraints=$)").toString();
    }

    public final void update-L6sJoHM(String arg1, TextStyle arg2, Resolver arg3, int arg4, boolean arg5, int arg6, int arg7) {
        this.text = arg1;
        this.style = arg2;
        this.fontFamilyResolver = arg3;
        this.overflow = arg4;
        this.softWrap = arg5;
        this.maxLines = arg6;
        this.minLines = arg7;
        this.recordHistory-4ETZmGE(LayoutCacheOperation.Companion.getMarkDirtyNode-DEKiAbY());
        this.markDirty();
    }

    private final long useMinLinesConstrainer-euUD3Qg(long arg7, LayoutDirection arg9, TextStyle arg10) {
        Companion v0 = MinLinesConstrainer.Companion;
        MinLinesConstrainer v1 = this.mMinLinesConstrainer;
        Density v4 = this.density;
        Intrinsics.checkNotNull(v4);
        MinLinesConstrainer v9 = v0.from(v1, arg9, arg10, v4, this.fontFamilyResolver);
        this.mMinLinesConstrainer = v9;
        return v9.coerceMinLines-Oh53vG4$foundation(arg7, this.minLines);
    }

    static long useMinLinesConstrainer-euUD3Qg$default(ParagraphLayoutCache arg0, long arg1, LayoutDirection arg3, TextStyle arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg4 = arg0.style;
        }

        return arg0.useMinLinesConstrainer-euUD3Qg(arg1, arg3, arg4);
    }
}

