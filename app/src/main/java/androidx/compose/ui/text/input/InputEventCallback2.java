package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message="Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.") @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0017\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u000EH&J8\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0011H&J\u0010\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u0019H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001AÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/text/input/InputEventCallback2;", "", "onEditCommands", "", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeAction", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "onKeyEvent", "event", "Landroid/view/KeyEvent;", "onRequestCursorAnchorInfo", "immediate", "", "monitor", "includeInsertionMarker", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "onConnectionClosed", "inputConnection", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface InputEventCallback2 {
    void onConnectionClosed(RecordingInputConnection arg1);

    void onEditCommands(List arg1);

    void onImeAction-KlQnJC8(int arg1);

    void onKeyEvent(KeyEvent arg1);

    void onRequestCursorAnchorInfo(boolean arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6);
}

