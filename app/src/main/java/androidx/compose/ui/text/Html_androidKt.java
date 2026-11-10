package androidx.compose.ui.text;

import android.graphics.Typeface;
import android.text.Layout$Alignment;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001 \u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b\u001A$\u0010\t\u001A\u00020\u0001*\u00020\n2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0001\u001A(\u0010\u000B\u001A\u00020\f*\u00020\r2\u0006\u0010\u000E\u001A\u00020\n2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0002\u001A8\u0010\u000F\u001A\u00020\f*\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0002\u001A\f\u0010\u0015\u001A\u00020\u0016*\u00020\u0017H\u0002\u001A\u000E\u0010\u0018\u001A\u0004\u0018\u00010\u0019*\u00020\u001AH\u0002\u001A\f\u0010\u0018\u001A\u00020\u0019*\u00020\u001BH\u0002\u001A\u0014\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0004H\u0002\"\u0010\u0010\u001F\u001A\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!\"\u000E\u0010\"\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010#\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010$\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010%\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"fromHtml", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/AnnotatedString$Companion;", "htmlString", "", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "linkInteractionListener", "Landroidx/compose/ui/text/LinkInteractionListener;", "toAnnotatedString", "Landroid/text/Spanned;", "addSpans", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "spanned", "addSpan", "span", "", "start", "", "end", "toParagraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "Landroid/text/style/AlignmentSpan;", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroid/text/style/StyleSpan;", "Landroid/text/style/TypefaceSpan;", "optionalFontFamilyFromName", "Landroidx/compose/ui/text/font/FontFamily;", "familyName", "TagHandler", "androidx/compose/ui/text/Html_androidKt$TagHandler$1", "Landroidx/compose/ui/text/Html_androidKt$TagHandler$1;", "ContentHandlerReplacementTag", "AnnotationTag", "Li", "Ul", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Html_androidKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Layout$Alignment.values().length];
            try {
                v0[Layout$Alignment.ALIGN_NORMAL.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Layout$Alignment.ALIGN_CENTER.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[Layout$Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private static final String AnnotationTag = "annotation";
    private static final String ContentHandlerReplacementTag = "ContentHandlerReplacementTag";
    private static final String Li = "li";
    private static final Html_androidKt$TagHandler$1 TagHandler = null;
    private static final String Ul = "ul";

    static {
        Html_androidKt.TagHandler = new Html_androidKt$TagHandler$1();
    }

    private static final void addSpan(Builder arg29, Object arg30, int arg31, int arg32, TextLinkStyles arg33, LinkInteractionListener arg34) {
        Builder v0 = arg29;
        Object v1 = arg30;
        int v4 = arg31;
        int v5 = arg32;
        if(!(v1 instanceof AbsoluteSizeSpan)) {
            if((v1 instanceof AlignmentSpan)) {
                v0.addStyle(Html_androidKt.toParagraphStyle(((AlignmentSpan)v1)), v4, v5);
                return;
            }
            else if((v1 instanceof AnnotationSpan)) {
                v0.addStringAnnotation(((AnnotationSpan)v1).getKey(), ((AnnotationSpan)v1).getValue(), v4, v5);
                return;
            }
            else if((v1 instanceof BackgroundColorSpan)) {
                v0.addStyle(new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, ColorKt.Color(((BackgroundColorSpan)v1).getBackgroundColor()), null, null, null, null, 0xF7FF, null), v4, v5);
                return;
            }
            else if((v1 instanceof BulletSpanWithLevel)) {
                long v2 = Bullet.Companion.getDefaultIndentation-XSAIIZE();
                int v6 = ((BulletSpanWithLevel)v1).getIndentationLevel();
                TextUnitKt.checkArithmetic--R2X_6o(v2);
                v0.addBullet-r9BaKPg(((BulletSpanWithLevel)v1).getBullet(), TextUnitKt.pack(TextUnit.getRawType-impl(v2), TextUnit.getValue-impl(v2) * (((float)v6))), v4, v5);
                return;
            }
            else if((v1 instanceof ForegroundColorSpan)) {
                v0.addStyle(new SpanStyle(ColorKt.Color(((ForegroundColorSpan)v1).getForegroundColor()), 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFFE, null), v4, v5);
                return;
            }
            else if((v1 instanceof RelativeSizeSpan)) {
                v0.addStyle(new SpanStyle(0, TextUnitKt.getEm(((RelativeSizeSpan)v1).getSizeChange()), null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFFD, null), v4, v5);
                return;
            }
            else if((v1 instanceof StrikethroughSpan)) {
                v0.addStyle(new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getLineThrough(), null, null, null, 0xEFFF, null), v4, v5);
                return;
            }
            else if((v1 instanceof StyleSpan)) {
                SpanStyle v1_1 = Html_androidKt.toSpanStyle(((StyleSpan)v1));
                if(v1_1 != null) {
                    v0.addStyle(v1_1, v4, v5);
                    return;
                }
            }
            else if((v1 instanceof SubscriptSpan)) {
                v0.addStyle(new SpanStyle(0, 0, null, null, null, null, null, 0, BaselineShift.box-impl(BaselineShift.Companion.getSubscript-y9eOQZs()), null, null, 0, null, null, null, null, 0xFEFF, null), v4, v5);
                return;
            }
            else if((v1 instanceof SuperscriptSpan)) {
                v0.addStyle(new SpanStyle(0, 0, null, null, null, null, null, 0, BaselineShift.box-impl(BaselineShift.Companion.getSuperscript-y9eOQZs()), null, null, 0, null, null, null, null, 0xFEFF, null), v4, v5);
                return;
            }
            else if((v1 instanceof TypefaceSpan)) {
                v0.addStyle(Html_androidKt.toSpanStyle(((TypefaceSpan)v1)), v4, v5);
                return;
            }
            else if((v1 instanceof UnderlineSpan)) {
                v0.addStyle(new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 0xEFFF, null), v4, v5);
                return;
            }
            else if((v1 instanceof URLSpan)) {
                String v1_2 = ((URLSpan)v1).getURL();
                if(v1_2 != null) {
                    v0.addLink(new Url(v1_2, arg33, arg34), v4, v5);
                }
            }
        }
    }

    private static final void addSpans(Builder arg9, Spanned arg10, TextLinkStyles arg11, LinkInteractionListener arg12) {
        int v2 = 0;
        Object[] v0 = arg10.getSpans(0, arg9.getLength(), Object.class);
        int v1 = v0.length;
        while(v2 < v1) {
            Object v4 = v0[v2];
            long v6 = TextRangeKt.TextRange(arg10.getSpanStart(v4), arg10.getSpanEnd(v4));
            Html_androidKt.addSpan(arg9, v4, TextRange.getStart-impl(v6), TextRange.getEnd-impl(v6), arg11, arg12);
            ++v2;
        }
    }

    public static final AnnotatedString fromHtml(Companion arg2, String arg3, TextLinkStyles arg4, LinkInteractionListener arg5) {
        return Html_androidKt.toAnnotatedString(HtmlCompat.fromHtml("<ContentHandlerReplacementTag />" + arg3, 0x3F, null, Html_androidKt.TagHandler), arg4, arg5);
    }

    public static AnnotatedString fromHtml$default(Companion arg1, String arg2, TextLinkStyles arg3, LinkInteractionListener arg4, int arg5, Object arg6) {
        TextLinkStyles v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = ((LinkInteractionListener)v0);
        }

        return Html_androidKt.fromHtml(arg1, arg2, arg3, arg4);
    }

    private static final FontFamily optionalFontFamilyFromName(String arg3) {
        String v0 = arg3;
        FontFamily v1 = null;
        if(v0 != null) {
            if(((CharSequence)v0).length() == 0) {
            }
            else {
                Typeface v3 = Typeface.create(arg3, 0);
                if((Intrinsics.areEqual(v3, Typeface.DEFAULT)) || (Intrinsics.areEqual(v3, Typeface.create(Typeface.DEFAULT, 0)))) {
                    v3 = ((Typeface)v1);
                }
                else {
                }

                if(v3 == null) {
                    return v1;
                }

                return AndroidTypeface_androidKt.FontFamily(v3);
            }
        }

        return v1;
    }

    public static final AnnotatedString toAnnotatedString(Spanned arg2, TextLinkStyles arg3, LinkInteractionListener arg4) {
        Builder v0 = new Builder(arg2.length()).append(arg2);
        Html_androidKt.addSpans(v0, arg2, arg3, arg4);
        return v0.toAnnotatedString();
    }

    public static AnnotatedString toAnnotatedString$default(Spanned arg1, TextLinkStyles arg2, LinkInteractionListener arg3, int arg4, Object arg5) {
        TextLinkStyles v0 = null;
        if((arg4 & 1) != 0) {
            arg2 = v0;
        }

        if((arg4 & 2) != 0) {
            arg3 = ((LinkInteractionListener)v0);
        }

        return Html_androidKt.toAnnotatedString(arg1, arg2, arg3);
    }

    private static final ParagraphStyle toParagraphStyle(AlignmentSpan arg13) {
        Layout$Alignment v13 = arg13.getAlignment();
        int v13_1 = v13 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v13.ordinal()];
        if(v13_1 == 1) {
            v13_1 = TextAlign.Companion.getStart-e0LSkKk();
        }
        else if(v13_1 == 2) {
            v13_1 = TextAlign.Companion.getCenter-e0LSkKk();
        }
        else if(v13_1 != 3) {
            v13_1 = TextAlign.Companion.getUnspecified-e0LSkKk();
        }
        else {
            v13_1 = TextAlign.Companion.getEnd-e0LSkKk();
        }

        return new ParagraphStyle(v13_1, 0, 0, null, null, null, 0, 0, null, 510, null);
    }

    private static final SpanStyle toSpanStyle(StyleSpan arg26) {
        int v0 = arg26.getStyle();
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    return null;
                }

                return new SpanStyle(0, 0, FontWeight.Companion.getBold(), FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFF3, null);
            }

            return new SpanStyle(0, 0, null, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFF7, null);
        }

        return new SpanStyle(0, 0, FontWeight.Companion.getBold(), null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFFB, null);
    }

    private static final SpanStyle toSpanStyle(TypefaceSpan arg24) {
        FontFamily v0_2;
        GenericFontFamily v0_1;
        String v0 = arg24.getFamily();
        if(Intrinsics.areEqual(v0, FontFamily.Companion.getCursive().getName())) {
            v0_1 = FontFamily.Companion.getCursive();
        }
        else if(Intrinsics.areEqual(v0, FontFamily.Companion.getMonospace().getName())) {
            v0_1 = FontFamily.Companion.getMonospace();
        }
        else if(Intrinsics.areEqual(v0, FontFamily.Companion.getSansSerif().getName())) {
            v0_1 = FontFamily.Companion.getSansSerif();
        }
        else if(Intrinsics.areEqual(v0, FontFamily.Companion.getSerif().getName())) {
            v0_1 = FontFamily.Companion.getSerif();
        }
        else {
            v0_2 = Html_androidKt.optionalFontFamilyFromName(arg24.getFamily());
        }

        GenericFontFamily v9 = ((GenericFontFamily)v0_2);
        return new SpanStyle(0, 0, null, null, null, ((FontFamily)v9), null, 0, null, null, null, 0, null, null, null, null, 0xFFDF, null);
    }
}

