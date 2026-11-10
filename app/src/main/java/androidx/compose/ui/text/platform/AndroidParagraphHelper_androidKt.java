package androidx.compose.ui.text.platform;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.emoji2.text.EmojiCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000]\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u001B\u001A\u0082\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0014\u0010\b\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000B0\n0\t2\u0012\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\u0006\u0010\u000E\u001A\u00020\u000F2&\u0010\u0010\u001A\"\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00112\u0006\u0010\u0017\u001A\u00020\u0018H\u0000\u001A\f\u0010\u0019\u001A\u00020\u0018*\u00020\u0007H\u0000\"\u0010\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001C¨\u0006\u001D"}, d2={"createCharSequence", "", "text", "", "contextFontSize", "", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "useEmojiCompat", "", "isIncludeFontPaddingEnabled", "NoopSpan", "androidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1", "Landroidx/compose/ui/text/platform/AndroidParagraphHelper_androidKt$NoopSpan$1;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidParagraphHelper_androidKt {
    private static final AndroidParagraphHelper_androidKt$NoopSpan$1 NoopSpan;

    static {
        AndroidParagraphHelper_androidKt.NoopSpan = new AndroidParagraphHelper_androidKt$NoopSpan$1();
    }

    public static final CharSequence createCharSequence(String arg7, float arg8, TextStyle arg9, List arg10, List arg11, Density arg12, Function4 arg13, boolean arg14) {
        Density v5;
        float v4;
        int v6;
        EmojiSupportMatch v14_2;
        String v14_4;
        if(!arg14 || !EmojiCompat.isConfigured()) {
            v14_4 = arg7;
        }
        else {
            PlatformTextStyle v14 = arg9.getPlatformStyle();
            if(v14 != null) {
                PlatformParagraphStyle v14_1 = v14.getParagraphStyle();
                if(v14_1 != null) {
                    v14_2 = EmojiSupportMatch.box-impl(v14_1.getEmojiSupportMatch-_3YsG6Y());
                }
                else {
                    goto label_11;
                }
            }
            else {
            label_11:
                v14_2 = null;
            }

            int v1 = EmojiSupportMatch.Companion.getAll-_3YsG6Y();
            if(v14_2 == null) {
                v6 = 0;
            }
            else {
                boolean v6_1 = EmojiSupportMatch.equals-impl0(v14_2.unbox-impl(), v1);
            }

            CharSequence v14_3 = EmojiCompat.get().process(arg7, 0, arg7.length(), 0x7FFFFFFF, v6);
            Intrinsics.checkNotNull(v14_3);
        }

        if((arg10.isEmpty()) && (arg11.isEmpty()) && (Intrinsics.areEqual(arg9.getTextIndent(), TextIndent.Companion.getNone())) && TextUnit.getRawType-impl(arg9.getLineHeight-XSAIIZE()) == 0) {
            return ((CharSequence)v14_4);
        }

        if(((((CharSequence)v14_4)) instanceof Spannable)) {
        }
        else {
            SpannableString v14_5 = new SpannableString(((CharSequence)v14_4));
        }

        CharSequence v1_1 = ((CharSequence)v14_4);
        if(Intrinsics.areEqual(arg9.getTextDecoration(), TextDecoration.Companion.getUnderline())) {
            SpannableExtensions_androidKt.setSpan(((Spannable)v1_1), AndroidParagraphHelper_androidKt.NoopSpan, 0, arg7.length());
        }

        if(!AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(arg9) || arg9.getLineHeightStyle() != null) {
            LineHeightStyle v7 = arg9.getLineHeightStyle();
            if(v7 == null) {
                v7 = LineHeightStyle.Companion.getDefault();
            }

            v4 = arg8;
            v5 = arg12;
            SpannableExtensions_androidKt.setLineHeight-KmRG4DE(((Spannable)v1_1), arg9.getLineHeight-XSAIIZE(), v4, v5, v7);
        }
        else {
            SpannableExtensions_androidKt.setLineHeight-r9BaKPg(((Spannable)v1_1), arg9.getLineHeight-XSAIIZE(), arg8, arg12);
            v4 = arg8;
            v5 = arg12;
        }

        SpannableExtensions_androidKt.setTextIndent(((Spannable)v1_1), arg9.getTextIndent(), v4, v5);
        SpannableExtensions_androidKt.setSpanStyles(((Spannable)v1_1), arg9, arg10, v5, arg13);
        SpannableExtensions_androidKt.setBulletSpans(((Spannable)v1_1), arg10, v4, v5, arg9.getTextIndent());
        PlaceholderExtensions_androidKt.setPlaceholders(((Spannable)v1_1), arg11, v5);
        return v1_1;
    }

    public static final boolean isIncludeFontPaddingEnabled(TextStyle arg0) {
        PlatformTextStyle v0 = arg0.getPlatformStyle();
        if(v0 != null) {
            PlatformParagraphStyle v0_1 = v0.getParagraphStyle();
            if(v0_1 != null) {
                return v0_1.getIncludeFontPadding();
            }
        }

        return 0;
    }
}

