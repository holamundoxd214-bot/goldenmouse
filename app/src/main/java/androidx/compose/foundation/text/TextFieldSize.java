package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u0001¢\u0006\u0004\b\u000B\u0010\fJ.\u0010\'\u001A\u00020(2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0001J\u000F\u0010)\u001A\u00020\"H\u0002¢\u0006\u0004\b*\u0010%R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u001A\u0010\n\u001A\u00020\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R \u0010#\u001A\u00020\"2\u0006\u0010!\u001A\u00020\"@BX\u0086\u000E¢\u0006\n\n\u0002\u0010&\u001A\u0004\b$\u0010%¨\u0006+"}, d2={"Landroidx/compose/foundation/text/TextFieldSize;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolvedStyle", "Landroidx/compose/ui/text/TextStyle;", "typeface", "<init>", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/text/TextStyle;Ljava/lang/Object;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getResolvedStyle", "()Landroidx/compose/ui/text/TextStyle;", "setResolvedStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "getTypeface", "()Ljava/lang/Object;", "setTypeface", "(Ljava/lang/Object;)V", "value", "Landroidx/compose/ui/unit/IntSize;", "minSize", "getMinSize-YbymL2g", "()J", "J", "update", "", "computeMinSize", "computeMinSize-YbymL2g", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextFieldSize {
    private Density density;
    private Resolver fontFamilyResolver;
    private LayoutDirection layoutDirection;
    private long minSize;
    private TextStyle resolvedStyle;
    private Object typeface;

    public TextFieldSize(LayoutDirection arg1, Density arg2, Resolver arg3, TextStyle arg4, Object arg5) {
        super();
        this.layoutDirection = arg1;
        this.density = arg2;
        this.fontFamilyResolver = arg3;
        this.resolvedStyle = arg4;
        this.typeface = arg5;
        this.minSize = this.computeMinSize-YbymL2g();
    }

    private final long computeMinSize-YbymL2g() {
        return TextFieldDelegateKt.computeSizeForDefaultText$default(this.resolvedStyle, this.density, this.fontFamilyResolver, null, 0, 24, null);
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final long getMinSize-YbymL2g() {
        return this.minSize;
    }

    public final TextStyle getResolvedStyle() {
        return this.resolvedStyle;
    }

    public final Object getTypeface() {
        return this.typeface;
    }

    public final void setDensity(Density arg1) {
        this.density = arg1;
    }

    public final void setFontFamilyResolver(Resolver arg1) {
        this.fontFamilyResolver = arg1;
    }

    public final void setLayoutDirection(LayoutDirection arg1) {
        this.layoutDirection = arg1;
    }

    public final void setResolvedStyle(TextStyle arg1) {
        this.resolvedStyle = arg1;
    }

    public final void setTypeface(Object arg1) {
        this.typeface = arg1;
    }

    public final void update(LayoutDirection arg2, Density arg3, Resolver arg4, TextStyle arg5, Object arg6) {
        if(arg2 == this.layoutDirection && (Intrinsics.areEqual(arg3, this.density)) && (Intrinsics.areEqual(arg4, this.fontFamilyResolver)) && (Intrinsics.areEqual(arg5, this.resolvedStyle))) {
            if(!Intrinsics.areEqual(arg6, this.typeface)) {
            }
            else {
                return;
            }
        }

        this.layoutDirection = arg2;
        this.density = arg3;
        this.fontFamilyResolver = arg4;
        this.resolvedStyle = arg5;
        this.typeface = arg6;
        this.minSize = this.computeMinSize-YbymL2g();
    }
}

