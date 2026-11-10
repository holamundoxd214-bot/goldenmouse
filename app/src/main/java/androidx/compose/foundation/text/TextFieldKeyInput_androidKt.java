package androidx.compose.foundation.text;

import android.view.KeyEvent;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"isTypedEvent", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isTypedEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldKeyInput_androidKt {
    public static final boolean isTypedEvent-ZmokQxo(KeyEvent arg1) {
        if(arg1.getAction() == 0 && !Character.isISOControl(arg1.getUnicodeChar())) {
            return 1;
        }

        return 0;
    }
}

