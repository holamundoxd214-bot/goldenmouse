package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0087\u0001\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\t2\u0014\b\u0002\u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001C0\u001B0\u001A2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020\u00072\b\b\u0002\u0010 \u001A\u00020\u00052\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u0017H\u0007¢\u0006\u0004\b#\u0010$Jq\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020%2\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020\u00072\b\b\u0002\u0010 \u001A\u00020\u00052\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u0017H\u0007¢\u0006\u0004\b&\u0010\'R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/compose/ui/text/TextMeasurer;", "", "defaultFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "defaultDensity", "Landroidx/compose/ui/unit/Density;", "defaultLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "<init>", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "", "measure-wNUYSr0", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;IZIJLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextMeasurer {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0002¨\u0006\b"}, d2={"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "<init>", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final TextLayoutResult access$layout(Companion arg0, TextLayoutInput arg1) {
            return arg0.layout(arg1);
        }

        private final TextLayoutResult layout(TextLayoutInput arg14) {
            int v1;
            MultiParagraphIntrinsics v0 = new MultiParagraphIntrinsics(arg14.getText(), TextStyleKt.resolveDefaults(arg14.getStyle(), arg14.getLayoutDirection()), arg14.getPlaceholders(), arg14.getDensity(), arg14.getFontFamilyResolver());
            int v13 = Constraints.getMinWidth-impl(arg14.getConstraints-msEJaDk());
            if(!arg14.getSoftWrap() && !TextMeasurerKt.access$isEllipsis-MW5-ApA(arg14.getOverflow-gIe3tQ8())) {
                goto label_22;
            }
            else if(Constraints.getHasBoundedWidth-impl(arg14.getConstraints-msEJaDk())) {
                v1 = Constraints.getMaxWidth-impl(arg14.getConstraints-msEJaDk());
            }
            else {
            label_22:
                v1 = 0x7FFFFFFF;
            }

            int v2 = (arg14.getSoftWrap()) || !TextMeasurerKt.access$isEllipsis-MW5-ApA(arg14.getOverflow-gIe3tQ8()) ? arg14.getMaxLines() : 1;
            int v10 = v2;
            if(v13 == v1) {
            }
            else {
                v1 = RangesKt.coerceIn(ParagraphKt.ceilToInt(v0.getMaxIntrinsicWidth()), v13, v1);
            }

            MultiParagraph v4 = new MultiParagraph(v0, Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(0, v1, 0, Constraints.getMaxHeight-impl(arg14.getConstraints-msEJaDk())), v10, arg14.getOverflow-gIe3tQ8(), null);
            return new TextLayoutResult(arg14, v4, ConstraintsKt.constrain-4WqzIAM(arg14.getConstraints-msEJaDk(), IntSize.constructor-impl((((long)(((int)(((float)Math.ceil(((double)v4.getWidth())))))))) << 0x20 | (((long)(((int)(((float)Math.ceil(((double)v4.getHeight())))))))) & 0xFFFFFFFFL)), null);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final int cacheSize;
    private final Density defaultDensity;
    private final Resolver defaultFontFamilyResolver;
    private final LayoutDirection defaultLayoutDirection;
    private final TextLayoutCache textLayoutCache;

    static {
        TextMeasurer.Companion = new Companion(null);
    }

    public TextMeasurer(Resolver arg1, Density arg2, LayoutDirection arg3, int arg4) {
        super();
        this.defaultFontFamilyResolver = arg1;
        this.defaultDensity = arg2;
        this.defaultLayoutDirection = arg3;
        this.cacheSize = arg4;
        TextLayoutCache v1 = arg4 > 0 ? new TextLayoutCache(arg4) : null;
        this.textLayoutCache = v1;
    }

    public TextMeasurer(Resolver arg1, Density arg2, LayoutDirection arg3, int arg4, int arg5, DefaultConstructorMarker arg6) {
        int v6 = 8;
        if((arg5 & v6) != 0) {
            arg4 = v6;
        }

        this(arg1, arg2, arg3, arg4);
    }

    public final TextLayoutResult measure-wNUYSr0(String arg16, TextStyle arg17, int arg18, boolean arg19, int arg20, long arg21, LayoutDirection arg23, Density arg24, Resolver arg25, boolean arg26) {
        return TextMeasurer.measure-xDpz5zY$default(this, new AnnotatedString(arg16, null, 2, null), arg17, arg18, arg19, arg20, null, arg21, arg23, arg24, arg25, arg26, 0x20, null);
    }

    public static TextLayoutResult measure-wNUYSr0$default(TextMeasurer arg12, String arg13, TextStyle arg14, int arg15, boolean arg16, int arg17, long arg18, LayoutDirection arg20, Density arg21, Resolver arg22, boolean arg23, int arg24, Object arg25) {
        int v0 = arg24;
        if((v0 & 2) != 0) {
            arg14 = TextStyle.Companion.getDefault();
        }

        TextStyle v2 = arg14;
        if((v0 & 4) != 0) {
            arg15 = TextOverflow.Companion.getClip-gIe3tQ8();
        }

        int v3 = arg15;
        boolean v4 = (v0 & 8) != 0 ? true : arg16;
        int v5 = (v0 & 16) != 0 ? 0x7FFFFFFF : arg17;
        long v6 = (v0 & 0x20) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : arg18;
        LayoutDirection v8 = (v0 & 0x40) != 0 ? arg12.defaultLayoutDirection : arg20;
        Density v9 = (v0 & 0x80) != 0 ? arg12.defaultDensity : arg21;
        Resolver v10 = (v0 & 0x100) != 0 ? arg12.defaultFontFamilyResolver : arg22;
        boolean v11 = (v0 & 0x200) != 0 ? false : arg23;
        return arg12.measure-wNUYSr0(arg13, v2, v3, v4, v5, v6, v8, v9, v10, v11);
    }

    public final TextLayoutResult measure-xDpz5zY(AnnotatedString arg14, TextStyle arg15, int arg16, boolean arg17, int arg18, List arg19, long arg20, LayoutDirection arg22, Density arg23, Resolver arg24, boolean arg25) {
        TextLayoutResult v14_1;
        TextLayoutInput v0 = new TextLayoutInput(arg14, arg15, arg19, arg18, arg17, arg16, arg23, arg22, arg24, arg20, null);
        if(!arg25) {
            TextLayoutCache v14 = this.textLayoutCache;
            if(v14 != null) {
                v14_1 = v14.get(v0);
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            v14_1 = null;
        }

        if(v14_1 != null) {
            return v14_1.copy-O0kMr_c(v0, ConstraintsKt.constrain-4WqzIAM(arg20, IntSize.constructor-impl((((long)ParagraphKt.ceilToInt(v14_1.getMultiParagraph().getWidth()))) << 0x20 | (((long)ParagraphKt.ceilToInt(v14_1.getMultiParagraph().getHeight()))) & 0xFFFFFFFFL)));
        }

        v14_1 = Companion.access$layout(TextMeasurer.Companion, v0);
        TextLayoutCache v13 = this.textLayoutCache;
        if(v13 != null) {
            v13.put(v0, v14_1);
        }

        return v14_1;
    }

    public static TextLayoutResult measure-xDpz5zY$default(TextMeasurer arg13, AnnotatedString arg14, TextStyle arg15, int arg16, boolean arg17, int arg18, List arg19, long arg20, LayoutDirection arg22, Density arg23, Resolver arg24, boolean arg25, int arg26, Object arg27) {
        int v0 = arg26;
        if((v0 & 2) != 0) {
            arg15 = TextStyle.Companion.getDefault();
        }

        TextStyle v2 = arg15;
        int v3 = (v0 & 4) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg16;
        boolean v4 = (v0 & 8) != 0 ? true : arg17;
        int v5 = (v0 & 16) != 0 ? 0x7FFFFFFF : arg18;
        List v6 = (v0 & 0x20) != 0 ? CollectionsKt.emptyList() : arg19;
        long v7 = (v0 & 0x40) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : arg20;
        LayoutDirection v9 = (v0 & 0x80) != 0 ? arg13.defaultLayoutDirection : arg22;
        Density v10 = (v0 & 0x100) != 0 ? arg13.defaultDensity : arg23;
        Resolver v11 = (v0 & 0x200) != 0 ? arg13.defaultFontFamilyResolver : arg24;
        boolean v12 = (v0 & 0x400) != 0 ? false : arg25;
        return arg13.measure-xDpz5zY(arg14, v2, v3, v4, v5, v6, v7, v9, v10, v11, v12);
    }
}

