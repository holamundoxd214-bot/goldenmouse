package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000\u001A\u001B\u0010\u0007\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000B\"\u0018\u0010\u0002\u001A\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2={"createTextFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "isFromSoftKeyboard", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isFromSoftKeyboard-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isKeyCode", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldKeyEventHandler_androidKt {
    public static final boolean access$isKeyCode-YhN2O0w(KeyEvent arg0, int arg1) {
        return TextFieldKeyEventHandler_androidKt.isKeyCode-YhN2O0w(arg0, arg1);
    }

    public static final TextFieldKeyEventHandler createTextFieldKeyEventHandler() {
        return new AndroidTextFieldKeyEventHandler();
    }

    public static final boolean isFromSoftKeyboard-ZmokQxo(KeyEvent arg1) {
        if((arg1.getFlags() & 2) == 2) {
            return 1;
        }

        return 0;
    }

    private static final boolean isKeyCode-YhN2O0w(KeyEvent arg2, int arg3) {
        if(Key_androidKt.getNativeKeyCode-YVgTNJs(KeyEvent_androidKt.getKey-ZmokQxo(arg2)) == arg3) {
            return 1;
        }

        return 0;
    }
}

