package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u0014\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\u001A\u0014\u0010\b\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\u001A\f\u0010\t\u001A\u00020\u0004*\u00020\u0005H\u0000*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\n"}, d2={"PlacedAnnotation", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "getTextBeforeSelection", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "maxChars", "", "getTextAfterSelection", "getSelectedText", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldCharSequenceKt {
    public static final CharSequence getSelectedText(TextFieldCharSequence arg3) {
        return arg3.subSequence(TextRange.getMin-impl(arg3.getSelection-d9O1mEE()), TextRange.getMax-impl(arg3.getSelection-d9O1mEE()));
    }

    public static final CharSequence getTextAfterSelection(TextFieldCharSequence arg3, int arg4) {
        int v0 = TextRange.getMax-impl(arg3.getSelection-d9O1mEE());
        int v1 = TextRange.getMax-impl(arg3.getSelection-d9O1mEE());
        int v2 = v1 + arg4;
        if(((arg4 ^ v2) & (v1 ^ v2)) < 0) {
            v2 = arg3.length();
        }

        return arg3.subSequence(v0, Math.min(v2, arg3.length()));
    }

    public static final CharSequence getTextBeforeSelection(TextFieldCharSequence arg2, int arg3) {
        int v0 = TextRange.getMin-impl(arg2.getSelection-d9O1mEE());
        int v1 = v0 - arg3;
        if(((arg3 ^ v0) & (v0 ^ v1)) < 0) {
            v1 = 0;
        }

        return arg2.subSequence(Math.max(0, v1), TextRange.getMin-impl(arg2.getSelection-d9O1mEE()));
    }
}

