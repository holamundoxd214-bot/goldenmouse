package androidx.compose.ui.text;

import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001BBe\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0014\u001A\u00020\u0015\u0012\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001CBe\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\u0006\u0010\u0018\u001A\u00020\u0019¢\u0006\u0004\b\u001A\u0010\u001DJ\u007F\u00108\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\u0014\b\u0002\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0018\u001A\u00020\u0019H\u0007¢\u0006\u0004\b9\u0010:J\u0013\u0010;\u001A\u00020\r2\b\u0010<\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010=\u001A\u00020\u000BH\u0016J\b\u0010>\u001A\u00020?H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u001D\u0010\u0006\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b$\u0010%R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u0013\u0010\u000E\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010)\u001A\u0004\b(\u0010%R\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-R\u0011\u0010\u0016\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b.\u0010/R\u0013\u0010\u0018\u001A\u00020\u0019¢\u0006\n\n\u0002\u00102\u001A\u0004\b0\u00101R\u0010\u00103\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u0014\u001A\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b4\u00105\u001A\u0004\b6\u00107¨\u0006@"}, d2={"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getPlaceholders", "()Ljava/util/List;", "getMaxLines", "()I", "getSoftWrap", "()Z", "getOverflow-gIe3tQ8", "I", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getConstraints-msEJaDk", "()J", "J", "_developerSuppliedResourceLoader", "getResourceLoader$annotations", "()V", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextLayoutInput {
    public static final int $stable = 8;
    private ResourceLoader _developerSuppliedResourceLoader;
    private final long constraints;
    private final Density density;
    private final Resolver fontFamilyResolver;
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;
    private final List placeholders;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    static {
    }

    public TextLayoutInput(AnnotatedString arg1, TextStyle arg2, List arg3, int arg4, boolean arg5, int arg6, Density arg7, LayoutDirection arg8, Resolver arg9, long arg10, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    private TextLayoutInput(AnnotatedString arg14, TextStyle arg15, List arg16, int arg17, boolean arg18, int arg19, Density arg20, LayoutDirection arg21, ResourceLoader arg22, long arg23) {
        this(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(arg22), arg23);
    }

    private TextLayoutInput(AnnotatedString arg1, TextStyle arg2, List arg3, int arg4, boolean arg5, int arg6, Density arg7, LayoutDirection arg8, ResourceLoader arg9, Resolver arg10, long arg11) {
        super();
        this.text = arg1;
        this.style = arg2;
        this.placeholders = arg3;
        this.maxLines = arg4;
        this.softWrap = arg5;
        this.overflow = arg6;
        this.density = arg7;
        this.layoutDirection = arg8;
        this.fontFamilyResolver = arg10;
        this.constraints = arg11;
        this._developerSuppliedResourceLoader = arg9;
    }

    @Deprecated(message="Font.ResourceLoader is replaced with FontFamily.Resolver", replaceWith="<_subannotation>") public TextLayoutInput(AnnotatedString arg1, TextStyle arg2, List arg3, int arg4, boolean arg5, int arg6, Density arg7, LayoutDirection arg8, ResourceLoader arg9, long arg10, DefaultConstructorMarker arg12) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    private TextLayoutInput(AnnotatedString arg14, TextStyle arg15, List arg16, int arg17, boolean arg18, int arg19, Density arg20, LayoutDirection arg21, Resolver arg22, long arg23) {
        this(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, null, arg22, arg23);
    }

    @Deprecated(message="Font.ResourceLoader is deprecated", replaceWith="<_subannotation>") public final TextLayoutInput copy-hu-1Yfo(AnnotatedString arg14, TextStyle arg15, List arg16, int arg17, boolean arg18, int arg19, Density arg20, LayoutDirection arg21, ResourceLoader arg22, long arg23) {
        return new TextLayoutInput(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, this.fontFamilyResolver, arg23);
    }

    public static TextLayoutInput copy-hu-1Yfo$default(TextLayoutInput arg0, AnnotatedString arg1, TextStyle arg2, List arg3, int arg4, boolean arg5, int arg6, Density arg7, LayoutDirection arg8, ResourceLoader arg9, long arg10, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg1 = arg0.text;
        }

        if((arg12 & 2) != 0) {
            arg2 = arg0.style;
        }

        if((arg12 & 4) != 0) {
            arg3 = arg0.placeholders;
        }

        if((arg12 & 8) != 0) {
            arg4 = arg0.maxLines;
        }

        if((arg12 & 16) != 0) {
            arg5 = arg0.softWrap;
        }

        if((arg12 & 0x20) != 0) {
            arg6 = arg0.overflow;
        }

        if((arg12 & 0x40) != 0) {
            arg7 = arg0.density;
        }

        if((arg12 & 0x80) != 0) {
            arg8 = arg0.layoutDirection;
        }

        if((arg12 & 0x100) != 0) {
            arg9 = arg0.getResourceLoader();
        }

        if((arg12 & 0x200) != 0) {
            arg10 = arg0.constraints;
        }

        return arg0.copy-hu-1Yfo(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public boolean equals(Object arg6) {
        if(this == (((TextLayoutInput)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof TextLayoutInput)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.text, ((TextLayoutInput)arg6).text)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.style, ((TextLayoutInput)arg6).style)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.placeholders, ((TextLayoutInput)arg6).placeholders)) {
            return 0;
        }

        if(this.maxLines != ((TextLayoutInput)arg6).maxLines) {
            return 0;
        }

        if(this.softWrap != ((TextLayoutInput)arg6).softWrap) {
            return 0;
        }

        if(!TextOverflow.equals-impl0(this.overflow, ((TextLayoutInput)arg6).overflow)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.density, ((TextLayoutInput)arg6).density)) {
            return 0;
        }

        if(this.layoutDirection != ((TextLayoutInput)arg6).layoutDirection) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fontFamilyResolver, ((TextLayoutInput)arg6).fontFamilyResolver)) {
            return 0;
        }

        if(!Constraints.equals-impl0(this.constraints, ((TextLayoutInput)arg6).constraints)) {
            return 0;
        }

        return 1;
    }

    public final long getConstraints-msEJaDk() {
        return this.constraints;
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

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getOverflow-gIe3tQ8() {
        return this.overflow;
    }

    public final List getPlaceholders() {
        return this.placeholders;
    }

    public final ResourceLoader getResourceLoader() {
        ResourceLoader v0 = this._developerSuppliedResourceLoader;
        if(v0 == null) {
            return DeprecatedBridgeFontResourceLoader.Companion.from(this.fontFamilyResolver);
        }

        return v0;
    }

    @Deprecated(message="Replaced with FontFamily.Resolver", replaceWith="<_subannotation>") public static void getResourceLoader$annotations() {
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

    public int hashCode() {
        return ((((((((this.text.hashCode() * 0x1F + this.style.hashCode()) * 0x1F + this.placeholders.hashCode()) * 0x1F + this.maxLines) * 0x1F + Boolean.hashCode(this.softWrap)) * 0x1F + TextOverflow.hashCode-impl(this.overflow)) * 0x1F + this.density.hashCode()) * 0x1F + this.layoutDirection.hashCode()) * 0x1F + this.fontFamilyResolver.hashCode()) * 0x1F + Constraints.hashCode-impl(this.constraints);
    }

    public String toString() {
        return "TextLayoutInput(text=" + this.text + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + TextOverflow.toString-impl(this.overflow) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.toString-impl(this.constraints) + ')';
    }
}

