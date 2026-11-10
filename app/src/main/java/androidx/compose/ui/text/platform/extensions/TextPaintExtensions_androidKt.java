package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion$Linearity;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001AP\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012&\u0010\u0004\u001A\"\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0000\u001A3\u0010\u000F\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u0016\u0010\u0018\u001A\u00020\u0019*\u00020\u00022\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0000\u001A\f\u0010\u001C\u001A\u00020\u000E*\u00020\u0001H\u0000\u001A\u0010\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001EH\u0000¨\u0006 "}, d2={"applySpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "requiresLetterSpacing", "", "generateFallbackSpanStyle", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "hasFontAttributes", "correctBlurRadius", "", "blurRadius", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextPaintExtensions_androidKt {
    public static final SpanStyle applySpanStyle(AndroidTextPaint arg6, SpanStyle arg7, Function4 arg8, Density arg9, boolean arg10) {
        long v0 = TextUnit.getType-UIouoOA(arg7.getFontSize-XSAIIZE());
        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getSp-UIouoOA())) {
            arg6.setTextSize(arg9.toPx--R2X_6o(arg7.getFontSize-XSAIIZE()));
        }
        else if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getEm-UIouoOA())) {
            arg6.setTextSize(arg6.getTextSize() * TextUnit.getValue-impl(arg7.getFontSize-XSAIIZE()));
        }

        if(TextPaintExtensions_androidKt.hasFontAttributes(arg7)) {
            FontFamily v0_1 = arg7.getFontFamily();
            FontWeight v1 = arg7.getFontWeight();
            if(v1 == null) {
                v1 = FontWeight.Companion.getNormal();
            }

            FontStyle v2 = arg7.getFontStyle-4Lr2A7w();
            int v2_1 = v2 != null ? v2.unbox-impl() : FontStyle.Companion.getNormal-_-LCdwA();
            v2 = FontStyle.box-impl(v2_1);
            FontSynthesis v3 = arg7.getFontSynthesis-ZQGJjVo();
            int v3_1 = v3 != null ? v3.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU();
            arg6.setTypeface(arg8.invoke(v0_1, v1, v2, FontSynthesis.box-impl(v3_1)));
        }

        if(arg7.getLocaleList() != null && !Intrinsics.areEqual(arg7.getLocaleList(), LocaleList.Companion.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(arg6, arg7.getLocaleList());
        }

        if(arg7.getFontFeatureSettings() != null && !Intrinsics.areEqual(arg7.getFontFeatureSettings(), "")) {
            arg6.setFontFeatureSettings(arg7.getFontFeatureSettings());
        }

        if(arg7.getTextGeometricTransform() != null && !Intrinsics.areEqual(arg7.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text())) {
            arg6.setTextScaleX(arg6.getTextScaleX() * arg7.getTextGeometricTransform().getScaleX());
            arg6.setTextSkewX(arg6.getTextSkewX() + arg7.getTextGeometricTransform().getSkewX());
        }

        arg6.setColor-8_81llA(arg7.getColor-0d7_KjU());
        arg6.setBrush-12SF9DM(arg7.getBrush(), Size.Companion.getUnspecified-NH-jbRc(), arg7.getAlpha());
        arg6.setShadow(arg7.getShadow());
        arg6.setTextDecoration(arg7.getTextDecoration());
        arg6.setDrawStyle(arg7.getDrawStyle());
        if((TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg7.getLetterSpacing-XSAIIZE()), TextUnitType.Companion.getSp-UIouoOA())) && TextUnit.getValue-impl(arg7.getLetterSpacing-XSAIIZE()) != 0f) {
            float v8 = arg6.getTextSize() * arg6.getTextScaleX();
            float v9 = arg9.toPx--R2X_6o(arg7.getLetterSpacing-XSAIIZE());
            if(v8 == 0f) {
            }
            else {
                arg6.setLetterSpacing(v9 / v8);
            }
        }
        else if(TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg7.getLetterSpacing-XSAIIZE()), TextUnitType.Companion.getEm-UIouoOA())) {
            arg6.setLetterSpacing(TextUnit.getValue-impl(arg7.getLetterSpacing-XSAIIZE()));
        }

        return TextPaintExtensions_androidKt.generateFallbackSpanStyle-62GTOB8(arg7.getLetterSpacing-XSAIIZE(), arg10, arg7.getBackground-0d7_KjU(), arg7.getBaselineShift-5SSeXJ0());
    }

    public static SpanStyle applySpanStyle$default(AndroidTextPaint arg0, SpanStyle arg1, Function4 arg2, Density arg3, boolean arg4, int arg5, Object arg6) {
        return TextPaintExtensions_androidKt.applySpanStyle(arg0, arg1, arg2, arg3, false);
    }

    public static final float correctBlurRadius(float arg1) {
        return 1;
    }

    private static final SpanStyle generateFallbackSpanStyle-62GTOB8(long arg31, boolean arg33, long arg34, BaselineShift arg36) {
        long v0 = arg34;
        int v2 = 1;
        int v4 = !arg33 || !TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg31), TextUnitType.Companion.getSp-UIouoOA()) || TextUnit.getValue-impl(arg31) == 0f ? 0 : 1;
        int v5 = (Color.equals-impl0(v0, Color.Companion.getUnspecified-0d7_KjU())) || (Color.equals-impl0(v0, Color.Companion.getTransparent-0d7_KjU())) ? 0 : 1;
        if(arg36 == null || (BaselineShift.equals-impl0(arg36.unbox-impl(), BaselineShift.Companion.getNone-y9eOQZs()))) {
            v2 = 0;
        }
        else {
        }

        SpanStyle v3 = null;
        if(v4 == 0 && v5 == 0 && v2 == 0) {
            return v3;
        }

        long v18 = v4 != 0 ? arg31 : TextUnit.Companion.getUnspecified-XSAIIZE();
        if(v5 != 0) {
        }
        else {
            v0 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v23 = v0;
        BaselineShift v20 = v2 != 0 ? arg36 : ((BaselineShift)v3);
        return new SpanStyle(0, 0, null, null, null, null, null, v18, v20, null, null, v23, null, null, null, null, 0xF67F, null);
    }

    public static final boolean hasFontAttributes(SpanStyle arg1) {
        if(arg1.getFontFamily() == null && arg1.getFontStyle-4Lr2A7w() == null) {
            if(arg1.getFontWeight() != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final void setTextMotion(AndroidTextPaint arg2, TextMotion arg3) {
        if(arg3 == null) {
            arg3 = TextMotion.Companion.getStatic();
        }

        int v0 = arg3.getSubpixelTextPositioning$ui_text() ? arg2.getFlags() | 0x80 : arg2.getFlags() & 0xFFFFFF7F;
        arg2.setFlags(v0);
        int v3 = arg3.getLinearity-4e0Vf04$ui_text();
        if(Linearity.equals-impl0(v3, Linearity.Companion.getLinear-4e0Vf04())) {
            arg2.setFlags(arg2.getFlags() | 0x40);
            arg2.setHinting(0);
            return;
        }

        if(Linearity.equals-impl0(v3, Linearity.Companion.getFontHinting-4e0Vf04())) {
            arg2.getFlags();
            arg2.setHinting(1);
            return;
        }

        if(Linearity.equals-impl0(v3, Linearity.Companion.getNone-4e0Vf04())) {
            arg2.getFlags();
            arg2.setHinting(0);
            return;
        }

        arg2.getFlags();
    }
}

