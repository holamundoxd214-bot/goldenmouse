package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B§\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B¢\u0006\u0004\b\u001C\u0010\u001DJ\u0006\u0010Q\u001A\u00020RR\u001C\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u001C\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\b#\u0010\u001F\"\u0004\b$\u0010!R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u001C\u0010\f\u001A\u0004\u0018\u00010\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u001C\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b5\u00106\"\u0004\b7\u00108R\u001C\u0010\u0010\u001A\u00020\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\b9\u0010\u001F\"\u0004\b:\u0010!R\u001C\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001C\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001C\u0010\u0017\u001A\u00020\u0003X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\"\u001A\u0004\bG\u0010\u001F\"\u0004\bH\u0010!R\u001C\u0010\u0018\u001A\u0004\u0018\u00010\u0019X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001C\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006S"}, d2={"Landroidx/compose/ui/platform/MutableSpanStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "<init>", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "getFontSize-XSAIIZE", "setFontSize--R2X_6o", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "setFontWeight", "(Landroidx/compose/ui/text/font/FontWeight;)V", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "setFontStyle-mLjRB2g", "(Landroidx/compose/ui/text/font/FontStyle;)V", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "setFontSynthesis-tDdu0R4", "(Landroidx/compose/ui/text/font/FontSynthesis;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "setFontFamily", "(Landroidx/compose/ui/text/font/FontFamily;)V", "getFontFeatureSettings", "()Ljava/lang/String;", "setFontFeatureSettings", "(Ljava/lang/String;)V", "getLetterSpacing-XSAIIZE", "setLetterSpacing--R2X_6o", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-_isdbwI", "(Landroidx/compose/ui/text/style/BaselineShift;)V", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "setTextGeometricTransform", "(Landroidx/compose/ui/text/style/TextGeometricTransform;)V", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "setLocaleList", "(Landroidx/compose/ui/text/intl/LocaleList;)V", "getBackground-0d7_KjU", "setBackground-8_81llA", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "setTextDecoration", "(Landroidx/compose/ui/text/style/TextDecoration;)V", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow", "(Landroidx/compose/ui/graphics/Shadow;)V", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class MutableSpanStyle {
    private long background;
    private BaselineShift baselineShift;
    private long color;
    private FontFamily fontFamily;
    private String fontFeatureSettings;
    private long fontSize;
    private FontStyle fontStyle;
    private FontSynthesis fontSynthesis;
    private FontWeight fontWeight;
    private long letterSpacing;
    private LocaleList localeList;
    private Shadow shadow;
    private TextDecoration textDecoration;
    private TextGeometricTransform textGeometricTransform;

    public MutableSpanStyle(long arg20, long arg22, FontWeight arg24, FontStyle arg25, FontSynthesis arg26, FontFamily arg27, String arg28, long arg29, BaselineShift arg31, TextGeometricTransform arg32, LocaleList arg33, long arg34, TextDecoration arg36, Shadow arg37, int arg38, DefaultConstructorMarker arg39) {
        int v0 = arg38;
        long v1 = (v0 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        long v3 = (v0 & 2) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg22;
        FontWeight v5 = (v0 & 4) != 0 ? null : arg24;
        FontStyle v7 = (v0 & 8) != 0 ? null : arg25;
        FontSynthesis v8 = (v0 & 16) != 0 ? null : arg26;
        FontFamily v9 = (v0 & 0x20) != 0 ? null : arg27;
        String v10 = (v0 & 0x40) != 0 ? null : arg28;
        long v11 = (v0 & 0x80) != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg29;
        BaselineShift v13 = (v0 & 0x100) != 0 ? null : arg31;
        TextGeometricTransform v14 = (v0 & 0x200) != 0 ? null : arg32;
        LocaleList v15 = (v0 & 0x400) != 0 ? null : arg33;
        long v16 = (v0 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg34;
        TextDecoration v6 = (v0 & 0x1000) != 0 ? null : arg36;
        Shadow v0_1 = (v0 & 0x2000) != 0 ? null : arg37;
        this(v1, v3, v5, v7, v8, v9, v10, v11, v13, v14, v15, v16, v6, v0_1, null);
    }

    private MutableSpanStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18) {
        super();
        this.color = arg1;
        this.fontSize = arg3;
        this.fontWeight = arg5;
        this.fontStyle = arg6;
        this.fontSynthesis = arg7;
        this.fontFamily = arg8;
        this.fontFeatureSettings = arg9;
        this.letterSpacing = arg10;
        this.baselineShift = arg12;
        this.textGeometricTransform = arg13;
        this.localeList = arg14;
        this.background = arg15;
        this.textDecoration = arg17;
        this.shadow = arg18;
    }

    public MutableSpanStyle(long arg1, long arg3, FontWeight arg5, FontStyle arg6, FontSynthesis arg7, FontFamily arg8, String arg9, long arg10, BaselineShift arg12, TextGeometricTransform arg13, LocaleList arg14, long arg15, TextDecoration arg17, Shadow arg18, DefaultConstructorMarker arg19) {
        this(arg1, arg3, arg5, arg6, arg7, arg8, arg9, arg10, arg12, arg13, arg14, arg15, arg17, arg18);
    }

    public final long getBackground-0d7_KjU() {
        return this.background;
    }

    public final BaselineShift getBaselineShift-5SSeXJ0() {
        return this.baselineShift;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final long getFontSize-XSAIIZE() {
        return this.fontSize;
    }

    public final FontStyle getFontStyle-4Lr2A7w() {
        return this.fontStyle;
    }

    public final FontSynthesis getFontSynthesis-ZQGJjVo() {
        return this.fontSynthesis;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final long getLetterSpacing-XSAIIZE() {
        return this.letterSpacing;
    }

    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final void setBackground-8_81llA(long arg1) {
        this.background = arg1;
    }

    public final void setBaselineShift-_isdbwI(BaselineShift arg1) {
        this.baselineShift = arg1;
    }

    public final void setColor-8_81llA(long arg1) {
        this.color = arg1;
    }

    public final void setFontFamily(FontFamily arg1) {
        this.fontFamily = arg1;
    }

    public final void setFontFeatureSettings(String arg1) {
        this.fontFeatureSettings = arg1;
    }

    public final void setFontSize--R2X_6o(long arg1) {
        this.fontSize = arg1;
    }

    public final void setFontStyle-mLjRB2g(FontStyle arg1) {
        this.fontStyle = arg1;
    }

    public final void setFontSynthesis-tDdu0R4(FontSynthesis arg1) {
        this.fontSynthesis = arg1;
    }

    public final void setFontWeight(FontWeight arg1) {
        this.fontWeight = arg1;
    }

    public final void setLetterSpacing--R2X_6o(long arg1) {
        this.letterSpacing = arg1;
    }

    public final void setLocaleList(LocaleList arg1) {
        this.localeList = arg1;
    }

    public final void setShadow(Shadow arg1) {
        this.shadow = arg1;
    }

    public final void setTextDecoration(TextDecoration arg1) {
        this.textDecoration = arg1;
    }

    public final void setTextGeometricTransform(TextGeometricTransform arg1) {
        this.textGeometricTransform = arg1;
    }

    public final SpanStyle toSpanStyle() {
        return new SpanStyle(this.color, this.fontSize, this.fontWeight, this.fontStyle, this.fontSynthesis, this.fontFamily, this.fontFeatureSettings, this.letterSpacing, this.baselineShift, this.textGeometricTransform, this.localeList, this.background, this.textDecoration, this.shadow, null, null, 0xC000, null);
    }
}

