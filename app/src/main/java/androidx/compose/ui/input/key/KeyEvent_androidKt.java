package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\"\u0015\u0010\u0002\u001A\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\"\u0015\u0010\u0007\u001A\u00020\b*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\t\u0010\n\"\u0015\u0010\u000B\u001A\u00020\f*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\r\u0010\n\"\u0015\u0010\u000E\u001A\u00020\u000F*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001A\u00020\u000F*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011\"\u0015\u0010\u0014\u001A\u00020\u000F*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0011\"\u0015\u0010\u0016\u001A\u00020\u000F*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0011*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0018"}, d2={"NativeKeyEvent", "Landroid/view/KeyEvent;", "key", "Landroidx/compose/ui/input/key/Key;", "Landroidx/compose/ui/input/key/KeyEvent;", "getKey-ZmokQxo", "(Landroid/view/KeyEvent;)J", "utf16CodePoint", "", "getUtf16CodePoint-ZmokQxo", "(Landroid/view/KeyEvent;)I", "type", "Landroidx/compose/ui/input/key/KeyEventType;", "getType-ZmokQxo", "isAltPressed", "", "isAltPressed-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isCtrlPressed", "isCtrlPressed-ZmokQxo", "isMetaPressed", "isMetaPressed-ZmokQxo", "isShiftPressed", "isShiftPressed-ZmokQxo", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class KeyEvent_androidKt {
    public static final long getKey-ZmokQxo(KeyEvent arg2) {
        return Key_androidKt.Key(arg2.getKeyCode());
    }

    public static final int getType-ZmokQxo(KeyEvent arg1) {
        int v1 = arg1.getAction();
        if(v1 != 0) {
            if(v1 != 1) {
                return KeyEventType.Companion.getUnknown-CS__XNY();
            }

            return KeyEventType.Companion.getKeyUp-CS__XNY();
        }

        return KeyEventType.Companion.getKeyDown-CS__XNY();
    }

    public static final int getUtf16CodePoint-ZmokQxo(KeyEvent arg0) {
        return arg0.getUnicodeChar();
    }

    public static final boolean isAltPressed-ZmokQxo(KeyEvent arg0) {
        return arg0.isAltPressed();
    }

    public static final boolean isCtrlPressed-ZmokQxo(KeyEvent arg0) {
        return arg0.isCtrlPressed();
    }

    public static final boolean isMetaPressed-ZmokQxo(KeyEvent arg0) {
        return arg0.isMetaPressed();
    }

    public static final boolean isShiftPressed-ZmokQxo(KeyEvent arg0) {
        return arg0.isShiftPressed();
    }
}

