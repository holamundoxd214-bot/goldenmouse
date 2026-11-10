package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A\b\u0010\u0005\u001A\u00020\u0006H\u0000¨\u0006\u0007"}, d2={"cancelsTextSelection", "", "Landroidx/compose/ui/input/key/KeyEvent;", "cancelsTextSelection-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "showCharacterPalette", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class KeyEventHelpers_androidKt {
    public static final boolean cancelsTextSelection-ZmokQxo(KeyEvent arg2) {
        if(arg2.getKeyCode() == 4 && (KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(arg2), KeyEventType.Companion.getKeyUp-CS__XNY()))) {
            return 1;
        }

        return 0;
    }

    public static final void showCharacterPalette() {
    }
}

