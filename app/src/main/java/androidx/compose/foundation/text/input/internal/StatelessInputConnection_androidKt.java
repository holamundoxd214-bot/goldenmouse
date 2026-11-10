package androidx.compose.foundation.text.input.internal;

import android.content.ClipData$Item;
import android.content.ClipData;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.inputmethod.ExtractedText;
import androidx.compose.foundation.content.PlatformTransferableContent;
import androidx.compose.foundation.content.TransferableContent$Source;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.text.AnnotatedString$Annotation;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000^\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\f\u0010\b\u001A\u00020\t*\u00020\nH\u0002\u001A\u0016\u0010\u000B\u001A\u00020\f*\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0000\u001A\u001E\u0010\u0010\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u0014\u0018\u00010\u0011*\u00020\u0015H\u0001\u001A\u000E\u0010\u0016\u001A\u0004\u0018\u00010\u0013*\u00020\u0017H\u0002\u001A\u000E\u0010\u0018\u001A\u0004\u0018\u00010\u0019*\u00020\u001AH\u0002\u001A\f\u0010\u0018\u001A\u00020\u0019*\u00020\u001BH\u0002\u001A\u0014\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0005H\u0002\"\u0016\u0010\u0000\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"SIC_DEBUG", "", "getSIC_DEBUG$annotations", "()V", "STATELESS_TAG", "", "DEBUG_CLASS", "EXTRA_INPUT_CONTENT_INFO", "toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "extras", "Landroid/os/Bundle;", "toAnnotationList", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "Landroid/text/Spanned;", "toAnnotation", "", "toSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "Landroid/text/style/StyleSpan;", "Landroid/text/style/TypefaceSpan;", "optionalFontFamilyFromName", "Landroidx/compose/ui/text/font/FontFamily;", "familyName", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StatelessInputConnection_androidKt {
    private static final String DEBUG_CLASS = "StatelessInputConnection";
    private static final String EXTRA_INPUT_CONTENT_INFO = "EXTRA_INPUT_CONTENT_INFO";
    public static final boolean SIC_DEBUG = false;
    private static final String STATELESS_TAG = "StatelessIC";

    public static final ExtractedText access$toExtractedText(TextFieldCharSequence arg0) {
        return StatelessInputConnection_androidKt.toExtractedText(arg0);
    }

    public static void getSIC_DEBUG$annotations() {
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

    private static final Annotation toAnnotation(Object arg25) {
        Object v0 = arg25;
        if((v0 instanceof BackgroundColorSpan)) {
            return new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, ColorKt.Color(((BackgroundColorSpan)v0).getBackgroundColor()), null, null, null, null, 0xF7FF, null);
        }

        if((v0 instanceof ForegroundColorSpan)) {
            return new SpanStyle(ColorKt.Color(((ForegroundColorSpan)v0).getForegroundColor()), 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFFE, null);
        }

        if((v0 instanceof StrikethroughSpan)) {
            return new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getLineThrough(), null, null, null, 0xEFFF, null);
        }

        if((v0 instanceof StyleSpan)) {
            return StatelessInputConnection_androidKt.toSpanStyle(((StyleSpan)v0));
        }

        if((v0 instanceof TypefaceSpan)) {
            return StatelessInputConnection_androidKt.toSpanStyle(((TypefaceSpan)v0));
        }

        if((v0 instanceof UnderlineSpan)) {
            return new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 0xEFFF, null);
        }

        return null;
    }

    public static final List toAnnotationList(Spanned arg8) {
        int v2 = 0;
        Object[] v0 = arg8.getSpans(0, arg8.length(), Object.class);
        int v1 = v0.length;
        ArrayList v3 = null;
        while(v2 < v1) {
            Object v4 = v0[v2];
            Annotation v5 = StatelessInputConnection_androidKt.toAnnotation(v4);
            if(v5 != null) {
                if(v3 == null) {
                    v3 = new ArrayList();
                }

                ((List)v3).add(new Range(v5, arg8.getSpanStart(v4), arg8.getSpanEnd(v4)));
            }

            ++v2;
        }

        return ((List)v3);
    }

    private static final ExtractedText toExtractedText(TextFieldCharSequence arg5) {
        ExtractedText v0 = new ExtractedText();
        v0.text = arg5;
        v0.startOffset = 0;
        v0.partialEndOffset = arg5.length();
        v0.partialStartOffset = -1;
        v0.selectionStart = TextRange.getMin-impl(arg5.getSelection-d9O1mEE());
        v0.selectionEnd = TextRange.getMax-impl(arg5.getSelection-d9O1mEE());
        v0.flags = StringsKt.contains$default(arg5, '\n', false, 2, null) ^ 1;
        return v0;
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
            v0_2 = StatelessInputConnection_androidKt.optionalFontFamilyFromName(arg24.getFamily());
        }

        GenericFontFamily v9 = ((GenericFontFamily)v0_2);
        return new SpanStyle(0, 0, null, null, null, ((FontFamily)v9), null, 0, null, null, null, 0, null, null, null, null, 0xFFDF, null);
    }

    public static final TransferableContent toTransferableContent(InputContentInfoCompat arg10, Bundle arg11) {
        ClipEntry v5 = AndroidClipboardManager_androidKt.toClipEntry(new ClipData(arg10.getDescription(), new ClipData$Item(arg10.getContentUri())));
        int v7 = Source.Companion.getKeyboard-kB6V9T0();
        ClipMetadata v6 = AndroidClipboardManager_androidKt.toClipMetadata(arg10.getDescription());
        Uri v10 = arg10.getLinkUri();
        if(arg11 == null) {
            arg11 = Bundle.EMPTY;
        }

        return new TransferableContent(v5, v6, v7, new PlatformTransferableContent(v10, arg11), null);
    }
}

