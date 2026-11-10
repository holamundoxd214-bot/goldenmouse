package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2={"toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InputState_androidKt {
    public static final ExtractedText toExtractedText(TextFieldValue arg5) {
        ExtractedText v0 = new ExtractedText();
        v0.text = arg5.getText();
        v0.startOffset = 0;
        v0.partialEndOffset = arg5.getText().length();
        v0.partialStartOffset = -1;
        v0.selectionStart = TextRange.getMin-impl(arg5.getSelection-d9O1mEE());
        v0.selectionEnd = TextRange.getMax-impl(arg5.getSelection-d9O1mEE());
        v0.flags = StringsKt.contains$default(arg5.getText(), '\n', false, 2, null) ^ 1;
        return v0;
    }
}

