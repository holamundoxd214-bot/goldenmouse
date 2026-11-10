package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.KeyEvent;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&J\u0017\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fH&¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H&J\u0010\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0015H&J\u0010\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0018H&J\u001A\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH&J\u0010\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u0010H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001FÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/input/internal/TextInputSession;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "sendKeyEvent", "", "keyEvent", "Landroid/view/KeyEvent;", "onImeAction", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "onCommitContent", "", "transferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "requestCursorUpdates", "cursorUpdateMode", "", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "updateTouchMode", "isInTouchMode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextInputSession extends ImeEditCommandScope {
    TextFieldCharSequence getText();

    boolean onCommitContent(TransferableContent arg1);

    void onImeAction-KlQnJC8(int arg1);

    int performHandwritingGesture(HandwritingGesture arg1);

    boolean previewHandwritingGesture(PreviewableHandwritingGesture arg1, CancellationSignal arg2);

    void requestCursorUpdates(int arg1);

    void sendKeyEvent(KeyEvent arg1);

    void updateTouchMode(boolean arg1);
}

