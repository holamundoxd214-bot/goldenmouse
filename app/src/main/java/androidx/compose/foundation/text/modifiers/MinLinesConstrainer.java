package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB)\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u001CH\u0000¢\u0006\u0004\b\u001D\u0010\u001ER\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u000E\u0010\u0014\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "inputTextStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "<init>", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getInputTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolvedStyle", "lineHeightCache", "", "oneLineHeightCache", "coerceMinLines", "Landroidx/compose/ui/unit/Constraints;", "inConstraints", "minLines", "", "coerceMinLines-Oh53vG4$foundation", "(JI)J", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MinLinesConstrainer {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer$Companion;", "", "<init>", "()V", "last", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "from", "minMaxUtil", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "paramStyle", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final MinLinesConstrainer from(MinLinesConstrainer arg2, LayoutDirection arg3, TextStyle arg4, Density arg5, Resolver arg6) {
            if(arg2 != null && arg3 == arg2.getLayoutDirection() && (Intrinsics.areEqual(TextStyleKt.resolveDefaults(arg4, arg3), arg2.getInputTextStyle())) && arg5.getDensity() == arg2.getDensity().getDensity() && arg6 == arg2.getFontFamilyResolver()) {
                return arg2;
            }

            MinLinesConstrainer v1 = MinLinesConstrainer.last;
            if(v1 != null && arg3 == v1.getLayoutDirection() && (Intrinsics.areEqual(TextStyleKt.resolveDefaults(arg4, arg3), v1.getInputTextStyle())) && arg5.getDensity() == v1.getDensity().getDensity() && arg6 == v1.getFontFamilyResolver()) {
                return v1;
            }

            v1 = new MinLinesConstrainer(arg3, TextStyleKt.resolveDefaults(arg4, arg3), DensityKt.Density(arg5.getDensity(), arg5.getFontScale()), arg6);
            MinLinesConstrainer.last = v1;
            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final Density density;
    private final Resolver fontFamilyResolver;
    private final TextStyle inputTextStyle;
    private static MinLinesConstrainer last;
    private final LayoutDirection layoutDirection;
    private float lineHeightCache;
    private float oneLineHeightCache;
    private final TextStyle resolvedStyle;

    static {
        MinLinesConstrainer.Companion = new Companion(null);
        MinLinesConstrainer.$stable = 8;
    }

    public MinLinesConstrainer(LayoutDirection arg1, TextStyle arg2, Density arg3, Resolver arg4) {
        super();
        this.layoutDirection = arg1;
        this.inputTextStyle = arg2;
        this.density = arg3;
        this.fontFamilyResolver = arg4;
        this.resolvedStyle = TextStyleKt.resolveDefaults(arg2, arg1);
        this.lineHeightCache = NaNf;
        this.oneLineHeightCache = NaNf;
    }

    public static final MinLinesConstrainer access$getLast$cp() {
        return MinLinesConstrainer.last;
    }

    public static final void access$setLast$cp(MinLinesConstrainer arg0) {
        MinLinesConstrainer.last = arg0;
    }

    public final long coerceMinLines-Oh53vG4$foundation(long arg18, int arg20) {
        MinLinesConstrainer v0 = this;
        int v1 = arg20;
        float v2 = v0.oneLineHeightCache;
        float v3 = v0.lineHeightCache;
        if((Float.isNaN(v2)) || (Float.isNaN(v3))) {
            v2 = ParagraphKt.Paragraph-Ul8oQg4$default(MinLinesConstrainerKt.access$getEmptyTextReplacement$p(), v0.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), v0.density, v0.fontFamilyResolver, null, null, 1, TextOverflow.Companion.getClip-gIe3tQ8(), 0x60, null).getHeight();
            v3 = ParagraphKt.Paragraph-Ul8oQg4$default(MinLinesConstrainerKt.access$getTwoLineTextReplacement$p(), v0.resolvedStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), v0.density, v0.fontFamilyResolver, null, null, 2, TextOverflow.Companion.getClip-gIe3tQ8(), 0x60, null).getHeight() - v2;
            v0.oneLineHeightCache = v2;
            v0.lineHeightCache = v3;
        }

        int v0_1 = v1 != 1 ? RangesKt.coerceAtMost(RangesKt.coerceAtLeast(Math.round(v2 + v3 * (((float)(v1 - 1)))), 0), Constraints.getMaxHeight-impl(arg18)) : Constraints.getMinHeight-impl(arg18);
        return ConstraintsKt.Constraints(Constraints.getMinWidth-impl(arg18), Constraints.getMaxWidth-impl(arg18), v0_1, Constraints.getMaxHeight-impl(arg18));
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final TextStyle getInputTextStyle() {
        return this.inputTextStyle;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }
}

