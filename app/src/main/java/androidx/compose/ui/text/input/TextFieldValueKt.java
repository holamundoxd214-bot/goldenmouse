package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u0012\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001A\n\u0010\u0006\u001A\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2={"getTextBeforeSelection", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "maxChars", "", "getTextAfterSelection", "getSelectedText", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldValueKt {
    public static final AnnotatedString getSelectedText(TextFieldValue arg3) {
        return arg3.getAnnotatedString().subSequence-5zc-tL8(arg3.getSelection-d9O1mEE());
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue arg4, int arg5) {
        AnnotatedString v0 = arg4.getAnnotatedString();
        int v1 = TextRange.getMax-impl(arg4.getSelection-d9O1mEE());
        int v2 = TextRange.getMax-impl(arg4.getSelection-d9O1mEE());
        int v3 = v2 + arg5;
        if(((arg5 ^ v3) & (v2 ^ v3)) < 0) {
            v3 = arg4.getText().length();
        }

        return v0.subSequence(v1, Math.min(v3, arg4.getText().length()));
    }

    public static final AnnotatedString getTextBeforeSelection(TextFieldValue arg3, int arg4) {
        AnnotatedString v0 = arg3.getAnnotatedString();
        int v1 = TextRange.getMin-impl(arg3.getSelection-d9O1mEE());
        int v2 = v1 - arg4;
        if(((arg4 ^ v1) & (v1 ^ v2)) < 0) {
            v2 = 0;
        }

        return v0.subSequence(Math.max(0, v2), TextRange.getMin-impl(arg3.getSelection-d9O1mEE()));
    }
}

