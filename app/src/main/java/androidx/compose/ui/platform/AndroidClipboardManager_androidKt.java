package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\r\u001A\n\u0010\u0002\u001A\u00020\u0003*\u00020\u0004\u001A\n\u0010\u0005\u001A\u00020\u0006*\u00020\u0007\u001A\u0010\u0010\n\u001A\u0004\u0018\u00010\u000B*\u0004\u0018\u00010\fH\u0000\u001A\f\u0010\r\u001A\u00020\f*\u00020\u000BH\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0015\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0016\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0017\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0018\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0019\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001A\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001B\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001C\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001D\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001E\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001F\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010 \u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010!\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\"\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010#\u001A\u00020\u000FX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010$\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010&\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\'\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010(\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010)\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010*\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010+\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010,\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010-\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010.\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010/\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00100\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00101\u001A\u00020%X\u0082T¢\u0006\u0002\n\u0000*\n\u0010\b\"\u00020\t2\u00020\t¨\u00062"}, d2={"PLAIN_TEXT_LABEL", "", "toClipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "Landroid/content/ClipData;", "toClipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "Landroid/content/ClipDescription;", "NativeClipboard", "Landroid/content/ClipboardManager;", "convertToAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "", "convertToCharSequence", "UNIT_TYPE_UNSPECIFIED", "", "UNIT_TYPE_SP", "UNIT_TYPE_EM", "FONT_STYLE_NORMAL", "FONT_STYLE_ITALIC", "FONT_SYNTHESIS_NONE", "FONT_SYNTHESIS_ALL", "FONT_SYNTHESIS_WEIGHT", "FONT_SYNTHESIS_STYLE", "COLOR_ID", "FONT_SIZE_ID", "FONT_WEIGHT_ID", "FONT_STYLE_ID", "FONT_SYNTHESIS_ID", "FONT_FEATURE_SETTINGS_ID", "LETTER_SPACING_ID", "BASELINE_SHIFT_ID", "TEXT_GEOMETRIC_TRANSFORM_ID", "BACKGROUND_ID", "TEXT_DECORATION_ID", "SHADOW_ID", "BYTE_SIZE", "", "INT_SIZE", "FLOAT_SIZE", "LONG_SIZE", "COLOR_SIZE", "TEXT_UNIT_SIZE", "FONT_WEIGHT_SIZE", "FONT_STYLE_SIZE", "FONT_SYNTHESIS_SIZE", "BASELINE_SHIFT_SIZE", "TEXT_GEOMETRIC_TRANSFORM_SIZE", "TEXT_DECORATION_SIZE", "SHADOW_SIZE", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidClipboardManager_androidKt {
    private static final byte BACKGROUND_ID = 10;
    private static final byte BASELINE_SHIFT_ID = 8;
    private static final int BASELINE_SHIFT_SIZE = 4;
    private static final int BYTE_SIZE = 1;
    private static final byte COLOR_ID = 1;
    private static final int COLOR_SIZE = 8;
    private static final int FLOAT_SIZE = 4;
    private static final byte FONT_FEATURE_SETTINGS_ID = 6;
    private static final byte FONT_SIZE_ID = 2;
    private static final byte FONT_STYLE_ID = 4;
    private static final byte FONT_STYLE_ITALIC = 1;
    private static final byte FONT_STYLE_NORMAL = 0;
    private static final int FONT_STYLE_SIZE = 1;
    private static final byte FONT_SYNTHESIS_ALL = 1;
    private static final byte FONT_SYNTHESIS_ID = 5;
    private static final byte FONT_SYNTHESIS_NONE = 0;
    private static final int FONT_SYNTHESIS_SIZE = 1;
    private static final byte FONT_SYNTHESIS_STYLE = 3;
    private static final byte FONT_SYNTHESIS_WEIGHT = 2;
    private static final byte FONT_WEIGHT_ID = 3;
    private static final int FONT_WEIGHT_SIZE = 4;
    private static final int INT_SIZE = 4;
    private static final byte LETTER_SPACING_ID = 7;
    private static final int LONG_SIZE = 8;
    private static final String PLAIN_TEXT_LABEL = "plain text";
    private static final byte SHADOW_ID = 12;
    private static final int SHADOW_SIZE = 20;
    private static final byte TEXT_DECORATION_ID = 11;
    private static final int TEXT_DECORATION_SIZE = 4;
    private static final byte TEXT_GEOMETRIC_TRANSFORM_ID = 9;
    private static final int TEXT_GEOMETRIC_TRANSFORM_SIZE = 8;
    private static final int TEXT_UNIT_SIZE = 5;
    private static final byte UNIT_TYPE_EM = 2;
    private static final byte UNIT_TYPE_SP = 1;
    private static final byte UNIT_TYPE_UNSPECIFIED;

    public static final AnnotatedString convertToAnnotatedString(CharSequence arg10) {
        AnnotatedString v0 = null;
        if(arg10 == null) {
            return v0;
        }

        if(!(arg10 instanceof Spanned)) {
            return new AnnotatedString(arg10.toString(), ((List)v0), 2, ((DefaultConstructorMarker)v0));
        }

        CharSequence v0_1 = arg10;
        int v3 = 0;
        Object[] v1 = ((Spanned)v0_1).getSpans(0, ((Spanned)v0_1).length(), Annotation.class);
        ArrayList v6 = new ArrayList();
        int v2 = ArraysKt.getLastIndex(v1);
        if(v2 >= 0) {
            while(true) {
                Object v4 = v1[v3];
                if(!Intrinsics.areEqual(((Annotation)v4).getKey(), "androidx.compose.text.SpanStyle")) {
                }
                else {
                    ((List)v6).add(new Range(new DecodeHelper(((Annotation)v4).getValue()).decodeSpanStyle(), ((Spanned)v0_1).getSpanStart(v4), ((Spanned)v0_1).getSpanEnd(v4)));
                }

                if(v3 == v2) {
                    break;
                }

                ++v3;
            }
        }

        return new AnnotatedString(arg10.toString(), ((List)v6), null, 4, null);
    }

    public static final CharSequence convertToCharSequence(AnnotatedString arg9) {
        if(arg9.getSpanStyles().isEmpty()) {
            return arg9.getText();
        }

        SpannableString v0 = new SpannableString(arg9.getText());
        EncodeHelper v1 = new EncodeHelper();
        List v9 = arg9.getSpanStyles();
        int v2 = v9.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = v9.get(v3);
            Object v5 = ((Range)v4).component1();
            int v6 = ((Range)v4).component2();
            int v4_1 = ((Range)v4).component3();
            v1.reset();
            v1.encode(((SpanStyle)v5));
            v0.setSpan(new Annotation("androidx.compose.text.SpanStyle", v1.encodedString()), v6, v4_1, 33);
        }

        return ((CharSequence)v0);
    }

    public static final ClipEntry toClipEntry(ClipData arg1) {
        return new ClipEntry(arg1);
    }

    public static final ClipMetadata toClipMetadata(ClipDescription arg1) {
        return new ClipMetadata(arg1);
    }
}

