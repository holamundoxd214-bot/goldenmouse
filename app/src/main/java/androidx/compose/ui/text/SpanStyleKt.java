package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\'\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0004\b\u000E\u0010\u000F\u001A+\u0010\u0010\u001A\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\n\u001A\u0002H\u00112\u0006\u0010\u000B\u001A\u0002H\u00112\u0006\u0010\u0012\u001A\u00020\rH\u0000¢\u0006\u0002\u0010\u0013\u001A\u001E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0012\u001A\u00020\r\u001A&\u0010\u0018\u001A\u0004\u0018\u00010\u00192\b\u0010\u0016\u001A\u0004\u0018\u00010\u00192\b\u0010\u0017\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001A\u00020\rH\u0002\u001A\u0010\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u0015H\u0000\u001A½\u0001\u0010\u001C\u001A\u00020\u0015*\u00020\u00152\u0006\u0010\u001D\u001A\u00020\u00052\b\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\u0006\u0010 \u001A\u00020\r2\u0006\u0010!\u001A\u00020\u00012\b\u0010\"\u001A\u0004\u0018\u00010#2\b\u0010$\u001A\u0004\u0018\u00010%2\b\u0010&\u001A\u0004\u0018\u00010\'2\b\u0010(\u001A\u0004\u0018\u00010)2\b\u0010*\u001A\u0004\u0018\u00010+2\u0006\u0010,\u001A\u00020\u00012\b\u0010-\u001A\u0004\u0018\u00010.2\b\u0010/\u001A\u0004\u0018\u0001002\b\u00101\u001A\u0004\u0018\u0001022\u0006\u00103\u001A\u00020\u00052\b\u00104\u001A\u0004\u0018\u0001052\b\u00106\u001A\u0004\u0018\u0001072\b\u00108\u001A\u0004\u0018\u00010\u00192\b\u00109\u001A\u0004\u0018\u00010:H\u0000¢\u0006\u0004\b;\u0010<\u001A\u0018\u0010=\u001A\u0004\u0018\u00010\u0019*\u00020\u00152\b\u0010>\u001A\u0004\u0018\u00010\u0019H\u0002\"\u0010\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2={"DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "DefaultLetterSpacing", "DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "DefaultColor", "DefaultColorForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "lerpTextUnitInheritable", "a", "b", "t", "", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "lerpDiscrete", "T", "fraction", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "resolveSpanStyleDefaults", "style", "fastMerge", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final TextForegroundStyle DefaultColorForegroundStyle;
    private static final long DefaultFontSize;
    private static final long DefaultLetterSpacing;

    static {
        SpanStyleKt.DefaultFontSize = TextUnitKt.getSp(14);
        SpanStyleKt.DefaultLetterSpacing = TextUnitKt.getSp(0);
        SpanStyleKt.DefaultBackgroundColor = Color.Companion.getTransparent-0d7_KjU();
        long v0 = Color.Companion.getBlack-0d7_KjU();
        SpanStyleKt.DefaultColor = v0;
        SpanStyleKt.DefaultColorForegroundStyle = TextForegroundStyle.Companion.from-8_81llA(v0);
    }

    public static final SpanStyle fastMerge-dSHsh3o(SpanStyle arg23, long arg24, Brush arg26, float arg27, long arg28, FontWeight arg30, FontStyle arg31, FontSynthesis arg32, FontFamily arg33, String arg34, long arg35, BaselineShift arg37, TextGeometricTransform arg38, LocaleList arg39, long arg40, TextDecoration arg42, Shadow arg43, PlatformSpanStyle arg44, DrawStyle arg45) {
        DrawStyle v5_1;
        long v7_1;
        TextGeometricTransform v14;
        long v11;
        long v1 = arg24;
        Brush v3 = arg26;
        FontWeight v5 = arg30;
        FontStyle v6 = arg31;
        FontSynthesis v7 = arg32;
        FontFamily v8 = arg33;
        String v9 = arg34;
        BaselineShift v10 = arg37;
        TextDecoration v15 = arg42;
        Shadow v0 = arg43;
        PlatformSpanStyle v4 = arg44;
        long v18 = 0;
        int v17 = 1;
        int v16 = Long.compare(TextUnit.getRawType-impl(arg28), v18) == 0 ? 1 : 0;
        long v21 = 16;
        if(v16 == 0) {
            v11 = arg28;
            if(TextUnit.equals-impl0(v11, arg23.getFontSize-XSAIIZE())) {
                goto label_32;
            }
            else {
                goto label_27;
            }
        }
        else {
            v11 = arg28;
        label_32:
            if((v3 != null || v1 == v21 || (Color.equals-impl0(v1, arg23.getTextForegroundStyle$ui_text().getColor-0d7_KjU()))) && (v6 == null || (Intrinsics.areEqual(v6, arg23.getFontStyle-4Lr2A7w()))) && (v5 == null || (Intrinsics.areEqual(v5, arg23.getFontWeight()))) && (v8 == null || v8 == arg23.getFontFamily())) {
                if(TextUnit.getRawType-impl(arg35) == v18) {
                }
                else {
                    v17 = 0;
                }

                if(v17 == 0) {
                    if(TextUnit.equals-impl0(arg35, arg23.getLetterSpacing-XSAIIZE())) {
                    }
                    else {
                        goto label_27;
                    }
                }

                if(v15 != null && !Intrinsics.areEqual(v15, arg23.getTextDecoration())) {
                    goto label_27;
                }

                if(Intrinsics.areEqual(v3, arg23.getTextForegroundStyle$ui_text().getBrush())) {
                    if(v3 != null && arg27 != arg23.getTextForegroundStyle$ui_text().getAlpha()) {
                        goto label_27;
                    }

                    if(v7 != null && !Intrinsics.areEqual(v7, arg23.getFontSynthesis-ZQGJjVo())) {
                        goto label_27;
                    }

                    if(v9 != null && !Intrinsics.areEqual(v9, arg23.getFontFeatureSettings())) {
                        goto label_27;
                    }

                    if(v10 != null && !Intrinsics.areEqual(v10, arg23.getBaselineShift-5SSeXJ0())) {
                        goto label_27;
                    }

                    if(arg38 != null) {
                        v14 = arg38;
                        if(Intrinsics.areEqual(v14, arg23.getTextGeometricTransform())) {
                        }
                        else {
                            goto label_28;
                        }
                    }
                    else {
                        v14 = arg38;
                    }

                    if(arg39 != null) {
                        if(Intrinsics.areEqual(arg39, arg23.getLocaleList())) {
                        }
                        else {
                            goto label_28;
                        }
                    }

                    if(arg40 != v21) {
                        v7_1 = arg40;
                        if(Color.equals-impl0(v7_1, arg23.getBackground-0d7_KjU())) {
                        }
                        else {
                            goto label_29;
                        }
                    }
                    else {
                        v7_1 = arg40;
                    }

                    if(v0 != null && !Intrinsics.areEqual(v0, arg23.getShadow())) {
                        goto label_29;
                    }

                    if(v4 != null && !Intrinsics.areEqual(v4, arg23.getPlatformStyle())) {
                        goto label_29;
                    }

                    v5_1 = arg45;
                    if(v5_1 != null && !Intrinsics.areEqual(v5_1, arg23.getDrawStyle())) {
                        goto label_120;
                    }

                    return arg23;
                }
            }

        label_27:
            v14 = arg38;
        label_28:
            v7_1 = arg40;
        label_29:
            v5_1 = arg45;
        }

    label_120:
        TextForegroundStyle v1_1 = v3 != null ? TextForegroundStyle.Companion.from(v3, arg27) : TextForegroundStyle.Companion.from-8_81llA(v1);
        v1_1 = arg23.getTextForegroundStyle$ui_text().merge(v1_1);
        FontFamily v2 = arg33 == null ? arg23.getFontFamily() : arg33;
        if(TextUnit.getRawType-impl(v11) == v18) {
            v11 = arg23.getFontSize-XSAIIZE();
        }

        FontWeight v3_1 = arg30 == null ? arg23.getFontWeight() : arg30;
        v6 = arg31 == null ? arg23.getFontStyle-4Lr2A7w() : arg31;
        FontSynthesis v13 = arg32 == null ? arg23.getFontSynthesis-ZQGJjVo() : arg32;
        if(v9 == null) {
            v9 = arg23.getFontFeatureSettings();
        }

        long v16_1 = TextUnit.getRawType-impl(arg35) == v18 ? arg23.getLetterSpacing-XSAIIZE() : arg35;
        if(v10 == null) {
            v10 = arg23.getBaselineShift-5SSeXJ0();
        }

        if(v14 == null) {
            v14 = arg23.getTextGeometricTransform();
        }

        LocaleList v18_1 = arg39 == null ? arg23.getLocaleList() : arg39;
        if(v7_1 != v21) {
        }
        else {
            v7_1 = arg23.getBackground-0d7_KjU();
        }

        if(v15 == null) {
            v15 = arg23.getTextDecoration();
        }

        if(v0 == null) {
            v0 = arg23.getShadow();
        }

        Shadow v40 = v0;
        SpanStyle v0_1 = arg23;
        v4 = SpanStyleKt.mergePlatformStyle(v0_1, v4);
        DrawStyle v0_2 = v5_1 == null ? v0_1.getDrawStyle() : v5_1;
        return new SpanStyle(v1_1, v11, v3_1, v6, v13, v2, v9, v16_1, v10, v14, v18_1, v7_1, v15, v40, v4, v0_2, null);
    }

    public static final SpanStyle lerp(SpanStyle arg28, SpanStyle arg29, float arg30) {
        float v0 = arg30;
        TextForegroundStyle v4 = TextDrawStyleKt.lerp(arg28.getTextForegroundStyle$ui_text(), arg29.getTextForegroundStyle$ui_text(), v0);
        Object v10 = SpanStyleKt.lerpDiscrete(arg28.getFontFamily(), arg29.getFontFamily(), v0);
        long v5 = SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(arg28.getFontSize-XSAIIZE(), arg29.getFontSize-XSAIIZE(), v0);
        FontWeight v1 = arg28.getFontWeight();
        if(v1 == null) {
            v1 = FontWeight.Companion.getNormal();
        }

        FontWeight v2 = arg29.getFontWeight();
        if(v2 == null) {
            v2 = FontWeight.Companion.getNormal();
        }

        FontWeight v7 = FontWeightKt.lerp(v1, v2, v0);
        Object v8 = SpanStyleKt.lerpDiscrete(arg28.getFontStyle-4Lr2A7w(), arg29.getFontStyle-4Lr2A7w(), v0);
        Object v9 = SpanStyleKt.lerpDiscrete(arg28.getFontSynthesis-ZQGJjVo(), arg29.getFontSynthesis-ZQGJjVo(), v0);
        Object v11 = SpanStyleKt.lerpDiscrete(arg28.getFontFeatureSettings(), arg29.getFontFeatureSettings(), v0);
        long v12 = SpanStyleKt.lerpTextUnitInheritable-C3pnCVY(arg28.getLetterSpacing-XSAIIZE(), arg29.getLetterSpacing-XSAIIZE(), v0);
        BaselineShift v1_1 = arg28.getBaselineShift-5SSeXJ0();
        float v1_2 = v1_1 != null ? v1_1.unbox-impl() : BaselineShift.constructor-impl(0f);
        BaselineShift v3 = arg29.getBaselineShift-5SSeXJ0();
        float v2_1 = v3 != null ? v3.unbox-impl() : BaselineShift.constructor-impl(0f);
        v1_2 = BaselineShiftKt.lerp-jWV1Mfo(v1_2, v2_1, v0);
        TextGeometricTransform v2_2 = arg28.getTextGeometricTransform();
        if(v2_2 == null) {
            v2_2 = TextGeometricTransform.Companion.getNone$ui_text();
        }

        TextGeometricTransform v3_1 = arg29.getTextGeometricTransform();
        if(v3_1 == null) {
            v3_1 = TextGeometricTransform.Companion.getNone$ui_text();
        }

        TextGeometricTransform v15 = TextGeometricTransformKt.lerp(v2_2, v3_1, v0);
        Object v16 = SpanStyleKt.lerpDiscrete(arg28.getLocaleList(), arg29.getLocaleList(), v0);
        TextForegroundStyle v14 = v4;
        long v17 = v5;
        long v2_3 = ColorKt.lerp-jxsXWHM(arg28.getBackground-0d7_KjU(), arg29.getBackground-0d7_KjU(), v0);
        Object v19 = SpanStyleKt.lerpDiscrete(arg28.getTextDecoration(), arg29.getTextDecoration(), v0);
        Shadow v4_1 = arg28.getShadow();
        if(v4_1 == null) {
            v4_1 = new Shadow(0, 0, 0f, 7, null);
        }

        Shadow v5_1 = arg29.getShadow();
        if(v5_1 == null) {
            v5_1 = new Shadow(0, 0, 0f, 7, null);
        }

        return new SpanStyle(v14, v17, v7, ((FontStyle)v8), ((FontSynthesis)v9), ((FontFamily)v10), ((String)v11), v12, BaselineShift.box-impl(v1_2), v15, ((LocaleList)v16), v2_3, ((TextDecoration)v19), ShadowKt.lerp(v4_1, v5_1, v0), SpanStyleKt.lerpPlatformStyle(arg28.getPlatformStyle(), arg29.getPlatformStyle(), v0), SpanStyleKt.lerpDiscrete(arg28.getDrawStyle(), arg29.getDrawStyle(), v0), null);
    }

    public static final Object lerpDiscrete(Object arg4, Object arg5, float arg6) {
        if((((double)arg6)) < 0.5) {
            return arg4;
        }

        return arg5;
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle arg0, PlatformSpanStyle arg1, float arg2) {
        if(arg0 == null && arg1 == null) {
            return null;
        }

        if(arg0 == null) {
            arg0 = PlatformSpanStyle.Companion.getDefault();
        }

        if(arg1 == null) {
            arg1 = PlatformSpanStyle.Companion.getDefault();
        }

        return AndroidTextStyle_androidKt.lerp(arg0, arg1, arg2);
    }

    public static final long lerpTextUnitInheritable-C3pnCVY(long arg4, long arg6, float arg8) {
        long v2 = 0;
        if(TextUnit.getRawType-impl(arg4) == v2) {
        }
        else {
            if(TextUnit.getRawType-impl(arg6) == v2) {
                goto label_6;
            }

            goto label_11;
        }

    label_6:
        return SpanStyleKt.lerpDiscrete(TextUnit.box-impl(arg4), TextUnit.box-impl(arg6), arg8).unbox-impl();
    label_11:
        return TextUnitKt.lerp-C3pnCVY(arg4, arg6, arg8);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle arg1, PlatformSpanStyle arg2) {
        if(arg1.getPlatformStyle() == null) {
            return arg2;
        }

        if(arg2 == null) {
            return arg1.getPlatformStyle();
        }

        return arg1.getPlatformStyle().merge(arg2);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle arg23) {
        Fill v2_14;
        TextForegroundStyle v3 = arg23.getTextForegroundStyle$ui_text().takeOrElse(new SpanStyleKt$$ExternalSyntheticLambda0());
        long v4 = 0;
        long v0 = TextUnit.getRawType-impl(arg23.getFontSize-XSAIIZE()) == v4 ? SpanStyleKt.DefaultFontSize : arg23.getFontSize-XSAIIZE();
        FontWeight v2 = arg23.getFontWeight();
        if(v2 == null) {
            v2 = FontWeight.Companion.getNormal();
        }

        FontWeight v6 = v2;
        FontStyle v2_1 = arg23.getFontStyle-4Lr2A7w();
        int v2_2 = v2_1 != null ? v2_1.unbox-impl() : FontStyle.Companion.getNormal-_-LCdwA();
        FontStyle v7 = FontStyle.box-impl(v2_2);
        FontSynthesis v2_3 = arg23.getFontSynthesis-ZQGJjVo();
        v2_2 = v2_3 != null ? v2_3.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU();
        FontSynthesis v8 = FontSynthesis.box-impl(v2_2);
        FontFamily v2_4 = arg23.getFontFamily();
        if(v2_4 == null) {
            SystemFontFamily v2_5 = FontFamily.Companion.getDefault();
        }

        FontFamily v9 = v2_4;
        String v2_6 = arg23.getFontFeatureSettings();
        if(v2_6 == null) {
            v2_6 = "";
        }

        String v10 = v2_6;
        v4 = TextUnit.getRawType-impl(arg23.getLetterSpacing-XSAIIZE()) == v4 ? SpanStyleKt.DefaultLetterSpacing : arg23.getLetterSpacing-XSAIIZE();
        long v11 = v4;
        BaselineShift v2_7 = arg23.getBaselineShift-5SSeXJ0();
        float v2_8 = v2_7 != null ? v2_7.unbox-impl() : BaselineShift.Companion.getNone-y9eOQZs();
        if(Float.isNaN(v2_8)) {
            v2_8 = BaselineShift.Companion.getNone-y9eOQZs();
        }

        BaselineShift v13 = BaselineShift.box-impl(v2_8);
        TextGeometricTransform v2_9 = arg23.getTextGeometricTransform();
        if(v2_9 == null) {
            v2_9 = TextGeometricTransform.Companion.getNone$ui_text();
        }

        TextGeometricTransform v14 = v2_9;
        LocaleList v2_10 = arg23.getLocaleList();
        if(v2_10 == null) {
            v2_10 = LocaleList.Companion.getCurrent();
        }

        LocaleList v15 = v2_10;
        v4 = arg23.getBackground-0d7_KjU();
        if(v4 != 16) {
        }
        else {
            v4 = SpanStyleKt.DefaultBackgroundColor;
        }

        long v16 = v4;
        TextDecoration v2_11 = arg23.getTextDecoration();
        if(v2_11 == null) {
            v2_11 = TextDecoration.Companion.getNone();
        }

        TextDecoration v18 = v2_11;
        Shadow v2_12 = arg23.getShadow();
        if(v2_12 == null) {
            v2_12 = Shadow.Companion.getNone();
        }

        Shadow v19 = v2_12;
        PlatformSpanStyle v20 = arg23.getPlatformStyle();
        DrawStyle v2_13 = arg23.getDrawStyle();
        if(v2_13 == null) {
            v2_14 = Fill.INSTANCE;
        }

        return new SpanStyle(v3, v0, v6, v7, v8, v9, v10, v11, v13, v14, v15, v16, v18, v19, v20, ((DrawStyle)v2_14), null);
    }

    static final TextForegroundStyle resolveSpanStyleDefaults$lambda$0() {
        return SpanStyleKt.DefaultColorForegroundStyle;
    }
}

