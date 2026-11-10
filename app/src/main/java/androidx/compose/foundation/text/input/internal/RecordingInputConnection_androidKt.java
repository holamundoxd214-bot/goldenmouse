package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0005\u001A\u00020\u0006*\u00020\u0007H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"DEBUG", "", "TAG", "", "DEBUG_CLASS", "toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RecordingInputConnection_androidKt {
    public static final boolean DEBUG = false;
    private static final String DEBUG_CLASS = "RecordingInputConnection";
    public static final String TAG = "RecordingIC";

    public static final ExtractedText access$toExtractedText(TextFieldValue arg0) {
        return RecordingInputConnection_androidKt.toExtractedText(arg0);
    }

    private static final ExtractedText toExtractedText(TextFieldValue arg5) {
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

