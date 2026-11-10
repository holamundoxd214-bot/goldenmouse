package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan$Standard;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.Bullet;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.CustomBulletSpan;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle$Trim;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A$\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000\u001A&\u0010\b\u001A\u00020\u0001*\u00020\u00022\b\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0000\u001A<\u0010\u000F\u001A\u00020\u0001*\u00020\u00022\u0014\u0010\u0010\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0000\u001A\'\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001A3\u0010\u0019\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u001CH\u0000¢\u0006\u0004\b\u001D\u0010\u001E\u001A+\u0010\u0019\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0000¢\u0006\u0004\b\u001F\u0010 \u001A\'\u0010!\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\"\u0010\u0018\u001A\u0010\u0010#\u001A\u00020$2\u0006\u0010\r\u001A\u00020\u000EH\u0002\u001AZ\u0010%\u001A\u00020\u0001*\u00020\u00022\u0006\u0010&\u001A\u00020\'2\u0014\u0010\u0010\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112\u0006\u0010\r\u001A\u00020\u000E2&\u0010(\u001A\"\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0)H\u0000\u001A,\u0010/\u001A\u00020\u0001*\u00020\u00022\u0006\u00100\u001A\u0002012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u000EH\u0002\u001AR\u00102\u001A\u00020\u0001*\u00020\u00022\u0006\u0010&\u001A\u00020\'2\u0014\u0010\u0010\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112&\u0010(\u001A\"\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0)H\u0002\u001AF\u00103\u001A\u00020\u00012\b\u00104\u001A\u0004\u0018\u0001012\u0012\u00105\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00120\u00112\u001E\u00106\u001A\u001A\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000107H\u0000\u001A!\u00108\u001A\u0004\u0018\u0001092\u0006\u0010:\u001A\u00020\u00162\u0006\u0010\r\u001A\u00020\u000EH\u0002¢\u0006\u0004\b;\u0010<\u001A&\u0010@\u001A\u00020\u0001*\u00020\u00022\b\u0010A\u001A\u0004\u0018\u00010B2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u001A&\u0010C\u001A\u00020\u0001*\u00020\u00022\b\u0010D\u001A\u0004\u0018\u00010E2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u001A+\u0010F\u001A\u00020\u0001*\u00020\u00022\u0006\u0010G\u001A\u00020H2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\bI\u0010J\u001A&\u0010K\u001A\u00020\u0001*\u00020\u00022\b\u0010L\u001A\u0004\u0018\u00010M2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000\u001A&\u0010N\u001A\u00020\u0001*\u00020\u00022\b\u0010O\u001A\u0004\u0018\u00010P2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u001A&\u0010Q\u001A\u00020\u0001*\u00020\u00022\b\u0010R\u001A\u0004\u0018\u00010S2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u001A3\u0010T\u001A\u00020\u0001*\u00020\u00022\u0006\u0010U\u001A\u00020\u00162\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\bV\u0010W\u001A&\u0010X\u001A\u00020\u0001*\u00020\u00022\b\u0010Y\u001A\u0004\u0018\u00010Z2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000\u001A+\u0010[\u001A\u00020\u0001*\u00020\u00022\u0006\u0010G\u001A\u00020H2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\\\u0010J\u001A+\u0010]\u001A\u00020\u0001*\u00020\u00022\b\u0010^\u001A\u0004\u0018\u00010_2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0002\b`\u001A.\u0010a\u001A\u00020\u0001*\u00020\u00022\b\u0010b\u001A\u0004\u0018\u00010c2\u0006\u0010d\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u001A\f\u0010e\u001A\u00020$*\u00020\'H\u0002\u001A\u0016\u0010f\u001A\u000201*\u0004\u0018\u0001012\u0006\u0010g\u001A\u000201H\u0002\"\u0018\u0010=\u001A\u00020$*\u0002018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b>\u0010?¨\u0006h"}, d2={"setSpan", "", "Landroid/text/Spannable;", "span", "", "start", "", "end", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "contextFontSize", "", "density", "Landroidx/compose/ui/unit/Density;", "setBulletSpans", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "resolveBulletTextUnitToPx", "size", "Landroidx/compose/ui/unit/TextUnit;", "resolveBulletTextUnitToPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "setLineHeight", "lineHeight", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "resolveLineHeightInPx", "resolveLineHeightInPx-o2QH7mI", "isNonLinearFontScalingActive", "", "setSpanStyles", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setSpanStyle", "style", "Landroidx/compose/ui/text/SpanStyle;", "setFontAttributes", "flattenFontStylesAndApply", "contextFontSpanStyle", "spanStyles", "block", "Lkotlin/Function3;", "createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "needsLetterSpacingSpan", "getNeedsLetterSpacingSpan", "(Landroidx/compose/ui/text/SpanStyle;)Z", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setDrawStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setBackground", "color", "Landroidx/compose/ui/graphics/Color;", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setColor", "setColor-RPmYEkk", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "hasFontAttributes", "merge", "spanStyle", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SpannableExtensions_androidKt {
    private static final MetricAffectingSpan createLetterSpacingSpan-eAf_CNQ(long arg4, Density arg6) {
        long v0 = TextUnit.getType-UIouoOA(arg4);
        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getSp-UIouoOA())) {
            return new LetterSpacingSpanPx(arg6.toPx--R2X_6o(arg4));
        }

        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getEm-UIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.getValue-impl(arg4));
        }

        return null;
    }

    public static final void flattenFontStylesAndApply(SpanStyle arg13, List arg14, Function3 arg15) {
        if(arg14.size() > 1) {
            int v0 = arg14.size();
            int v1 = v0 * 2;
            int[] v3 = new int[v1];
            List v4 = arg14;
            int v5 = ((Collection)v4).size();
            int v6;
            for(v6 = 0; v6 < v5; ++v6) {
                Object v7 = arg14.get(v6);
                v3[v6] = ((Range)v7).getStart();
                v3[v6 + v0] = ((Range)v7).getEnd();
            }

            ArraysKt.sort(v3);
            v0 = ArraysKt.first(v3);
            for(v5 = 0; v5 < v1; ++v5) {
                v6 = v3[v5];
                if(v6 == v0) {
                }
                else {
                    int v7_1 = ((Collection)v4).size();
                    SpanStyle v9 = arg13;
                    int v8;
                    for(v8 = 0; v8 < v7_1; ++v8) {
                        Object v10 = arg14.get(v8);
                        if(((Range)v10).getStart() != ((Range)v10).getEnd() && (AnnotatedStringKt.intersect(v0, v6, ((Range)v10).getStart(), ((Range)v10).getEnd()))) {
                            v9 = SpannableExtensions_androidKt.merge(v9, ((Range)v10).getItem());
                        }
                    }

                    if(v9 != null) {
                        arg15.invoke(v9, Integer.valueOf(v0), Integer.valueOf(v6));
                    }

                    v0 = v6;
                }
            }
        }
        else if(!arg14.isEmpty()) {
            arg15.invoke(SpannableExtensions_androidKt.merge(arg13, arg14.get(0).getItem()), Integer.valueOf(arg14.get(0).getStart()), Integer.valueOf(arg14.get(0).getEnd()));
            return;
        }
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle arg4) {
        if(!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg4.getLetterSpacing-XSAIIZE()), TextUnitType.Companion.getSp-UIouoOA())) {
            if(TextUnitType.equals-impl0(TextUnit.getType-UIouoOA(arg4.getLetterSpacing-XSAIIZE()), TextUnitType.Companion.getEm-UIouoOA())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean hasFontAttributes(TextStyle arg1) {
        if(!TextPaintExtensions_androidKt.hasFontAttributes(arg1.toSpanStyle())) {
            if(arg1.getFontSynthesis-ZQGJjVo() != null) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isNonLinearFontScalingActive(Density arg4) {
        if((((double)arg4.getFontScale())) > 1.05) {
            return 1;
        }

        return 0;
    }

    private static final SpanStyle merge(SpanStyle arg0, SpanStyle arg1) {
        if(arg0 == null) {
            return arg1;
        }

        return arg0.merge(arg1);
    }

    private static final float resolveBulletTextUnitToPx-o2QH7mI(long arg4, float arg6, Density arg7) {
        if(TextUnit.equals-impl0(arg4, TextUnit.Companion.getUnspecified-XSAIIZE())) {
            return arg6;
        }

        long v0 = TextUnit.getType-UIouoOA(arg4);
        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getSp-UIouoOA())) {
            return arg7.toPx--R2X_6o(arg4);
        }

        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getEm-UIouoOA())) {
            return TextUnit.getValue-impl(arg4) * arg6;
        }

        return NaNf;
    }

    private static final float resolveLineHeightInPx-o2QH7mI(long arg4, float arg6, Density arg7) {
        float v4;
        long v0 = TextUnit.getType-UIouoOA(arg4);
        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getSp-UIouoOA())) {
            if(!SpannableExtensions_androidKt.isNonLinearFontScalingActive(arg7)) {
                return arg7.toPx--R2X_6o(arg4);
            }
            else {
                v4 = TextUnit.getValue-impl(arg4) / TextUnit.getValue-impl(arg7.toSp-kPz2Gy4(arg6));
            }
        }
        else if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getEm-UIouoOA())) {
            v4 = TextUnit.getValue-impl(arg4);
        }
        else {
            return NaNf;
        }

        return v4 * arg6;
    }

    public static final void setBackground-RPmYEkk(Spannable arg2, long arg3, int arg5, int arg6) {
        if(arg3 != 16) {
            SpannableExtensions_androidKt.setSpan(arg2, new BackgroundColorSpan(ColorKt.toArgb-8_81llA(arg3)), arg5, arg6);
        }
    }

    private static final void setBaselineShift-0ocSgnM(Spannable arg1, BaselineShift arg2, int arg3, int arg4) {
        if(arg2 != null) {
            SpannableExtensions_androidKt.setSpan(arg1, new BaselineShiftSpan(arg2.unbox-impl()), arg3, arg4);
        }
    }

    private static final void setBrush(Spannable arg1, Brush arg2, float arg3, int arg4, int arg5) {
        if(arg2 != null) {
            if((arg2 instanceof SolidColor)) {
                SpannableExtensions_androidKt.setColor-RPmYEkk(arg1, ((SolidColor)arg2).getValue-0d7_KjU(), arg4, arg5);
                return;
            }

            if((arg2 instanceof ShaderBrush)) {
                SpannableExtensions_androidKt.setSpan(arg1, new ShaderBrushSpan(((ShaderBrush)arg2), arg3), arg4, arg5);
                return;
            }

            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void setBulletSpans(Spannable arg15, List arg16, float arg17, Density arg18, TextIndent arg19) {
        List v0 = arg16;
        float v1 = arg17;
        Density v10 = arg18;
        float v2 = 0f;
        if(arg19 != null) {
            long v3 = TextUnit.getType-UIouoOA(arg19.getFirstLine-XSAIIZE());
            if(TextUnitType.equals-impl0(v3, TextUnitType.Companion.getSp-UIouoOA())) {
                v2 = v10.toPx--R2X_6o(arg19.getFirstLine-XSAIIZE());
            }
            else if(TextUnitType.equals-impl0(v3, TextUnitType.Companion.getEm-UIouoOA())) {
                v2 = TextUnit.getValue-impl(arg19.getFirstLine-XSAIIZE()) * v1;
            }
        }

        float v11 = v2;
        int v12 = v0.size();
        int v13 = 0;
        while(v13 < v12) {
            Object v14 = v0.get(v13);
            Object v2_1 = ((Range)v14).getItem();
            if((v2_1 instanceof Bullet)) {
            }
            else {
                v2_1 = null;
            }

            if(v2_1 != null) {
                float v4 = SpannableExtensions_androidKt.resolveBulletTextUnitToPx-o2QH7mI(((Bullet)v2_1).getWidth-XSAIIZE(), v1, v10);
                float v5 = SpannableExtensions_androidKt.resolveBulletTextUnitToPx-o2QH7mI(((Bullet)v2_1).getHeight-XSAIIZE(), v1, v10);
                float v6 = SpannableExtensions_androidKt.resolveBulletTextUnitToPx-o2QH7mI(((Bullet)v2_1).getPadding-XSAIIZE(), v1, v10);
                if(!Float.isNaN(v4) && !Float.isNaN(v5) && !Float.isNaN(v6)) {
                    SpannableExtensions_androidKt.setSpan(arg15, new CustomBulletSpan(((Bullet)v2_1).getShape(), v4, v5, v6, ((Bullet)v2_1).getBrush(), ((Bullet)v2_1).getAlpha(), ((Bullet)v2_1).getDrawStyle(), v10, v11), ((Range)v14).getStart(), ((Range)v14).getEnd());
                }
            }

            ++v13;
            v10 = arg18;
        }
    }

    public static final void setColor-RPmYEkk(Spannable arg2, long arg3, int arg5, int arg6) {
        if(arg3 != 16) {
            SpannableExtensions_androidKt.setSpan(arg2, new ForegroundColorSpan(ColorKt.toArgb-8_81llA(arg3)), arg5, arg6);
        }
    }

    private static final void setDrawStyle(Spannable arg1, DrawStyle arg2, int arg3, int arg4) {
        if(arg2 != null) {
            SpannableExtensions_androidKt.setSpan(arg1, new DrawStyleSpan(arg2), arg3, arg4);
        }
    }

    private static final void setFontAttributes(Spannable arg25, TextStyle arg26, List arg27, Function4 arg28) {
        List v0 = arg27;
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = v0.get(v3);
            if(((((Range)v4).getItem() instanceof SpanStyle)) && ((TextPaintExtensions_androidKt.hasFontAttributes(((Range)v4).getItem())) || ((Range)v4).getItem().getFontSynthesis-ZQGJjVo() != null)) {
                Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
                v1.add(v4);
            }
        }

        SpanStyle v2_1 = SpannableExtensions_androidKt.hasFontAttributes(arg26) ? new SpanStyle(0, 0, arg26.getFontWeight(), arg26.getFontStyle-4Lr2A7w(), arg26.getFontSynthesis-ZQGJjVo(), arg26.getFontFamily(), null, 0, null, null, null, 0, null, null, null, null, 0xFFC3, null) : null;
        SpannableExtensions_androidKt.flattenFontStylesAndApply(v2_1, ((List)v1), new SpannableExtensions_androidKt$$ExternalSyntheticLambda0(arg25, arg28));
    }

    static final Unit setFontAttributes$lambda$2(Spannable arg4, Function4 arg5, SpanStyle arg6, int arg7, int arg8) {
        FontFamily v1 = arg6.getFontFamily();
        FontWeight v2 = arg6.getFontWeight();
        if(v2 == null) {
            v2 = FontWeight.Companion.getNormal();
        }

        FontStyle v3 = arg6.getFontStyle-4Lr2A7w();
        int v3_1 = v3 != null ? v3.unbox-impl() : FontStyle.Companion.getNormal-_-LCdwA();
        v3 = FontStyle.box-impl(v3_1);
        FontSynthesis v6 = arg6.getFontSynthesis-ZQGJjVo();
        int v6_1 = v6 != null ? v6.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU();
        arg4.setSpan(new TypefaceSpan(arg5.invoke(v1, v2, v3, FontSynthesis.box-impl(v6_1))), arg7, arg8, 33);
        return Unit.INSTANCE;
    }

    private static final void setFontFeatureSettings(Spannable arg1, String arg2, int arg3, int arg4) {
        if(arg2 != null) {
            SpannableExtensions_androidKt.setSpan(arg1, new FontFeatureSpan(arg2), arg3, arg4);
        }
    }

    public static final void setFontSize-KmRG4DE(Spannable arg4, long arg5, Density arg7, int arg8, int arg9) {
        long v0 = TextUnit.getType-UIouoOA(arg5);
        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getSp-UIouoOA())) {
            SpannableExtensions_androidKt.setSpan(arg4, new AbsoluteSizeSpan(MathKt.roundToInt(arg7.toPx--R2X_6o(arg5)), false), arg8, arg9);
            return;
        }

        if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getEm-UIouoOA())) {
            SpannableExtensions_androidKt.setSpan(arg4, new RelativeSizeSpan(TextUnit.getValue-impl(arg5)), arg8, arg9);
        }
    }

    private static final void setGeometricTransform(Spannable arg2, TextGeometricTransform arg3, int arg4, int arg5) {
        if(arg3 != null) {
            SpannableExtensions_androidKt.setSpan(arg2, new ScaleXSpan(arg3.getScaleX()), arg4, arg5);
            SpannableExtensions_androidKt.setSpan(arg2, new SkewXSpan(arg3.getSkewX()), arg4, arg5);
        }
    }

    public static final void setLineHeight-KmRG4DE(Spannable arg9, long arg10, float arg12, Density arg13, LineHeightStyle arg14) {
        float v1 = SpannableExtensions_androidKt.resolveLineHeightInPx-o2QH7mI(arg10, arg12, arg13);
        if(!Float.isNaN(v1)) {
            Spannable v10 = arg9;
            int v10_1 = ((CharSequence)v10).length() == 0 || StringsKt.last(((CharSequence)v10)) == 10 ? arg9.length() + 1 : arg9.length();
            int v3 = v10_1;
            SpannableExtensions_androidKt.setSpan(arg9, new LineHeightStyleSpan(v1, 0, v3, Trim.isTrimFirstLineTop-impl$ui_text(arg14.getTrim-EVpEnUU()), Trim.isTrimLastLineBottom-impl$ui_text(arg14.getTrim-EVpEnUU()), arg14.getAlignment-PIaL0Z0(), arg14.getMode-lzQqcRY(), null), 0, arg9.length());
        }
    }

    public static final void setLineHeight-r9BaKPg(Spannable arg0, long arg1, float arg3, Density arg4) {
        float v1 = SpannableExtensions_androidKt.resolveLineHeightInPx-o2QH7mI(arg1, arg3, arg4);
        if(!Float.isNaN(v1)) {
            SpannableExtensions_androidKt.setSpan(arg0, new LineHeightSpan(v1), 0, arg0.length());
        }
    }

    public static final void setLocaleList(Spannable arg1, LocaleList arg2, int arg3, int arg4) {
        if(arg2 != null) {
            SpannableExtensions_androidKt.setSpan(arg1, LocaleListHelperMethods.INSTANCE.localeSpan(arg2), arg3, arg4);
        }
    }

    private static final void setShadow(Spannable arg7, Shadow arg8, int arg9, int arg10) {
        if(arg8 != null) {
            SpannableExtensions_androidKt.setSpan(arg7, new ShadowSpan(ColorKt.toArgb-8_81llA(arg8.getColor-0d7_KjU()), Float.intBitsToFloat(((int)(arg8.getOffset-F1C5BW0() >> 0x20))), Float.intBitsToFloat(((int)(arg8.getOffset-F1C5BW0() & 0xFFFFFFFFL))), TextPaintExtensions_androidKt.correctBlurRadius(arg8.getBlurRadius())), arg9, arg10);
        }
    }

    public static final void setSpan(Spannable arg1, Object arg2, int arg3, int arg4) {
        arg1.setSpan(arg2, arg3, arg4, 33);
    }

    private static final void setSpanStyle(Spannable arg7, SpanStyle arg8, int arg9, int arg10, Density arg11) {
        SpannableExtensions_androidKt.setBaselineShift-0ocSgnM(arg7, arg8.getBaselineShift-5SSeXJ0(), arg9, arg10);
        SpannableExtensions_androidKt.setColor-RPmYEkk(arg7, arg8.getColor-0d7_KjU(), arg9, arg10);
        SpannableExtensions_androidKt.setBrush(arg7, arg8.getBrush(), arg8.getAlpha(), arg9, arg10);
        SpannableExtensions_androidKt.setTextDecoration(arg7, arg8.getTextDecoration(), arg9, arg10);
        SpannableExtensions_androidKt.setFontSize-KmRG4DE(arg7, arg8.getFontSize-XSAIIZE(), arg11, arg9, arg10);
        SpannableExtensions_androidKt.setFontFeatureSettings(arg7, arg8.getFontFeatureSettings(), arg9, arg10);
        SpannableExtensions_androidKt.setGeometricTransform(arg7, arg8.getTextGeometricTransform(), arg9, arg10);
        SpannableExtensions_androidKt.setLocaleList(arg7, arg8.getLocaleList(), arg9, arg10);
        SpannableExtensions_androidKt.setBackground-RPmYEkk(arg7, arg8.getBackground-0d7_KjU(), arg9, arg10);
        SpannableExtensions_androidKt.setShadow(arg7, arg8.getShadow(), arg9, arg10);
        SpannableExtensions_androidKt.setDrawStyle(arg7, arg8.getDrawStyle(), arg9, arg10);
    }

    public static final void setSpanStyles(Spannable arg7, TextStyle arg8, List arg9, Density arg10, Function4 arg11) {
        SpannableExtensions_androidKt.setFontAttributes(arg7, arg8, arg9, arg11);
        List v8 = arg9;
        int v11 = ((Collection)v8).size();
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
        while(v1 < v11) {
            Object v3 = arg9.get(v1);
            if((((Range)v3).getItem() instanceof SpanStyle)) {
                int v4 = ((Range)v3).getStart();
                int v5 = ((Range)v3).getEnd();
                if(v4 >= 0 && v4 < arg7.length() && v5 > v4) {
                    if(v5 > arg7.length()) {
                    }
                    else {
                        SpannableExtensions_androidKt.setSpanStyle(arg7, ((Range)v3).getItem(), v4, v5, arg10);
                        if(SpannableExtensions_androidKt.getNeedsLetterSpacingSpan(((Range)v3).getItem())) {
                            v2 = 1;
                        }
                    }
                }
            }

            ++v1;
        }

        if(v2 != 0) {
            int v8_1 = ((Collection)v8).size();
            while(v0 < v8_1) {
                Object v11_1 = arg9.get(v0);
                Object v1_1 = ((Range)v11_1).getItem();
                if((v1_1 instanceof SpanStyle)) {
                    v2 = ((Range)v11_1).getStart();
                    v11 = ((Range)v11_1).getEnd();
                    if(v2 >= 0 && v2 < arg7.length() && v11 > v2) {
                        if(v11 > arg7.length()) {
                        }
                        else {
                            MetricAffectingSpan v1_2 = SpannableExtensions_androidKt.createLetterSpacingSpan-eAf_CNQ(((SpanStyle)v1_1).getLetterSpacing-XSAIIZE(), arg10);
                            if(v1_2 != null) {
                                SpannableExtensions_androidKt.setSpan(arg7, v1_2, v2, v11);
                            }
                        }
                    }
                }

                ++v0;
            }
        }
    }

    public static final void setTextDecoration(Spannable arg3, TextDecoration arg4, int arg5, int arg6) {
        if(arg4 != null) {
            SpannableExtensions_androidKt.setSpan(arg3, new TextDecorationSpan(arg4.contains(TextDecoration.Companion.getUnderline()), arg4.contains(TextDecoration.Companion.getLineThrough())), arg5, arg6);
        }
    }

    public static final void setTextIndent(Spannable arg9, TextIndent arg10, float arg11, Density arg12) {
        float v0_1;
        if(arg10 != null && (!TextUnit.equals-impl0(arg10.getFirstLine-XSAIIZE(), TextUnitKt.getSp(0)) || !TextUnit.equals-impl0(arg10.getRestLine-XSAIIZE(), TextUnitKt.getSp(0)))) {
            long v3 = 0;
            if(TextUnit.getRawType-impl(arg10.getFirstLine-XSAIIZE()) == v3) {
                return;
            }

            if(TextUnit.getRawType-impl(arg10.getRestLine-XSAIIZE()) == v3) {
                return;
            }

            long v0 = TextUnit.getType-UIouoOA(arg10.getFirstLine-XSAIIZE());
            float v4 = 0f;
            if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getSp-UIouoOA())) {
                v0_1 = arg12.toPx--R2X_6o(arg10.getFirstLine-XSAIIZE());
            }
            else if(TextUnitType.equals-impl0(v0, TextUnitType.Companion.getEm-UIouoOA())) {
                v0_1 = TextUnit.getValue-impl(arg10.getFirstLine-XSAIIZE()) * arg11;
            }
            else {
                v0_1 = 0f;
            }

            long v5 = TextUnit.getType-UIouoOA(arg10.getRestLine-XSAIIZE());
            if(TextUnitType.equals-impl0(v5, TextUnitType.Companion.getSp-UIouoOA())) {
                v4 = arg12.toPx--R2X_6o(arg10.getRestLine-XSAIIZE());
            }
            else if(TextUnitType.equals-impl0(v5, TextUnitType.Companion.getEm-UIouoOA())) {
                v4 = TextUnit.getValue-impl(arg10.getRestLine-XSAIIZE()) * arg11;
            }

            SpannableExtensions_androidKt.setSpan(arg9, new LeadingMarginSpan$Standard(((int)(((float)Math.ceil(((double)v0_1))))), ((int)(((float)Math.ceil(((double)v4)))))), 0, arg9.length());
        }
    }
}

