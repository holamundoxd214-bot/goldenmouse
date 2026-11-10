package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u001B\u0010\u0006\u001A\u00020\u0007*\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "isKeyCode", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldFocusModifier_androidKt {
    public static final boolean access$isKeyCode-YhN2O0w(KeyEvent arg0, int arg1) {
        return TextFieldFocusModifier_androidKt.isKeyCode-YhN2O0w(arg0, arg1);
    }

    public static final Modifier interceptDPadAndMoveFocus(Modifier arg1, LegacyTextFieldState arg2, FocusManager arg3) {
        return KeyInputModifierKt.onPreviewKeyEvent(arg1, new TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1(arg3, arg2));
    }

    private static final boolean isKeyCode-YhN2O0w(KeyEvent arg2, int arg3) {
        if(Key_androidKt.getNativeKeyCode-YVgTNJs(KeyEvent_androidKt.getKey-ZmokQxo(arg2)) == arg3) {
            return 1;
        }

        return 0;
    }
}

