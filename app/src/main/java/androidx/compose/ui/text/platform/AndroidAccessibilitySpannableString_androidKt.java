package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build$VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation$Url;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A$\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007\u001A4\u0010\t\u001A\u00020\n*\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\u001A\u0018\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011*\b\u0012\u0004\u0012\u00020\u00130\u0011H\u0002¨\u0006\u0014"}, d2={"toAccessibilitySpannableString", "Landroid/text/SpannableString;", "Landroidx/compose/ui/text/AnnotatedString;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "setSpanStyle", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "toUrlLink", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "Landroidx/compose/ui/text/LinkAnnotation;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidAccessibilitySpannableString_androidKt {
    private static final void setSpanStyle(SpannableString arg13, SpanStyle arg14, int arg15, int arg16, Density arg17, Resolver arg18) {
        int v5 = arg16;
        SpannableString v0 = arg13;
        SpannableExtensions_androidKt.setColor-RPmYEkk(((Spannable)v0), arg14.getColor-0d7_KjU(), arg15, v5);
        SpannableExtensions_androidKt.setFontSize-KmRG4DE(((Spannable)v0), arg14.getFontSize-XSAIIZE(), arg17, arg15, v5);
        int v2 = 33;
        if(arg14.getFontWeight() != null || arg14.getFontStyle-4Lr2A7w() != null) {
            FontWeight v1 = arg14.getFontWeight();
            if(v1 == null) {
                v1 = FontWeight.Companion.getNormal();
            }

            FontStyle v3 = arg14.getFontStyle-4Lr2A7w();
            int v3_1 = v3 != null ? v3.unbox-impl() : FontStyle.Companion.getNormal-_-LCdwA();
            arg13.setSpan(new StyleSpan(AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(v1, v3_1)), arg15, v5, v2);
        }

        if(arg14.getFontFamily() != null) {
            if((arg14.getFontFamily() instanceof GenericFontFamily)) {
                arg13.setSpan(new TypefaceSpan(arg14.getFontFamily().getName()), arg15, v5, v2);
            }
            else if(Build$VERSION.SDK_INT >= 28) {
                FontFamily v7 = arg14.getFontFamily();
                FontSynthesis v1_1 = arg14.getFontSynthesis-ZQGJjVo();
                int v1_2 = v1_1 != null ? v1_1.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU();
                Object v1_3 = Resolver.resolve-DPcqOEQ$default(arg18, v7, null, 0, v1_2, 6, null).getValue();
                Intrinsics.checkNotNull(v1_3, "null cannot be cast to non-null type android.graphics.Typeface");
                arg13.setSpan(Api28Impl.INSTANCE.createTypefaceSpan(((Typeface)v1_3)), arg15, v5, v2);
            }
        }

        if(arg14.getTextDecoration() != null) {
            if(arg14.getTextDecoration().contains(TextDecoration.Companion.getUnderline())) {
                arg13.setSpan(new UnderlineSpan(), arg15, v5, v2);
            }

            if(!arg14.getTextDecoration().contains(TextDecoration.Companion.getLineThrough())) {
                goto label_79;
            }

            arg13.setSpan(new StrikethroughSpan(), arg15, v5, v2);
        }

    label_79:
        if(arg14.getTextGeometricTransform() != null) {
            arg13.setSpan(new ScaleXSpan(arg14.getTextGeometricTransform().getScaleX()), arg15, v5, v2);
        }

        SpannableExtensions_androidKt.setLocaleList(((Spannable)v0), arg14.getLocaleList(), arg15, v5);
        SpannableExtensions_androidKt.setBackground-RPmYEkk(((Spannable)v0), arg14.getBackground-0d7_KjU(), arg15, v5);
    }

    public static final SpannableString toAccessibilitySpannableString(AnnotatedString arg35, Density arg36, Resolver arg37, URLSpanCache arg38) {
        Object v7;
        int v6;
        AnnotatedString v0 = arg35;
        URLSpanCache v1 = arg38;
        SpannableString v2 = new SpannableString(v0.getText());
        List v8 = v0.getSpanStylesOrNull$ui_text();
        int v9 = 0;
        if(v8 != null) {
            int v10 = v8.size();
            int v11;
            for(v11 = 0; v11 < v10; ++v11) {
                Object v3 = v8.get(v11);
                AndroidAccessibilitySpannableString_androidKt.setSpanStyle(v2, SpanStyle.copy-GSF8kmg$default(((Range)v3).component1(), 0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFDF, null), ((Range)v3).component2(), ((Range)v3).component3(), arg36, arg37);
            }
        }

        List v3_1 = v0.getTtsAnnotations(0, v0.length());
        int v4 = v3_1.size();
        int v5;
        for(v5 = 0; true; ++v5) {
            v6 = 33;
            if(v5 >= v4) {
                break;
            }

            v7 = v3_1.get(v5);
            v2.setSpan(TtsAnnotationExtensions_androidKt.toSpan(((Range)v7).component1()), ((Range)v7).component2(), ((Range)v7).component3(), v6);
        }

        v3_1 = v0.getUrlAnnotations(0, v0.length());
        v4 = v3_1.size();
        for(v5 = 0; v5 < v4; ++v5) {
            v7 = v3_1.get(v5);
            v2.setSpan(v1.toURLSpan(((Range)v7).component1()), ((Range)v7).component2(), ((Range)v7).component3(), v6);
        }

        List v0_1 = v0.getLinkAnnotations(0, v0.length());
        int v3_2 = v0_1.size();
        while(v9 < v3_2) {
            Object v4_1 = v0_1.get(v9);
            if(((Range)v4_1).getStart() != ((Range)v4_1).getEnd()) {
                Object v5_1 = ((Range)v4_1).getItem();
                if(((v5_1 instanceof Url)) && ((Url)v5_1).getLinkInteractionListener() == null) {
                    v2.setSpan(v1.toURLSpan(AndroidAccessibilitySpannableString_androidKt.toUrlLink(((Range)v4_1))), ((Range)v4_1).getStart(), ((Range)v4_1).getEnd(), v6);
                    goto label_94;
                }

                v2.setSpan(v1.toClickableSpan(((Range)v4_1)), ((Range)v4_1).getStart(), ((Range)v4_1).getEnd(), v6);
            }

        label_94:
            ++v9;
        }

        return v2;
    }

    private static final Range toUrlLink(Range arg3) {
        Object v1 = arg3.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        return new Range(v1, arg3.getStart(), arg3.getEnd());
    }
}

