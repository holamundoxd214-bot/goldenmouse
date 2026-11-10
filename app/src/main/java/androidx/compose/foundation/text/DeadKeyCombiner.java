package androidx.compose.foundation.text;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u0004\u0018\u00010\u00052\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BR\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2={"Landroidx/compose/foundation/text/DeadKeyCombiner;", "", "<init>", "()V", "deadKeyCode", "", "Ljava/lang/Integer;", "consume", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "consume-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Integer;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DeadKeyCombiner {
    public static final int $stable = 8;
    private Integer deadKeyCode;

    static {
    }

    public DeadKeyCombiner() {
        super();
    }

    public final Integer consume-ZmokQxo(KeyEvent arg3) {
        int v3 = KeyEvent_androidKt.getUtf16CodePoint-ZmokQxo(arg3);
        Integer v1 = null;
        if((0x80000000 & v3) != 0) {
            this.deadKeyCode = Integer.valueOf(v3 & 0x7FFFFFFF);
            return v1;
        }

        Integer v0 = this.deadKeyCode;
        if(v0 != null) {
            this.deadKeyCode = v1;
            Integer v2 = Integer.valueOf(KeyCharacterMap.getDeadChar(v0.intValue(), v3));
            if(v2.intValue() == 0) {
            }
            else {
                v1 = v2;
            }

            if(v1 != null) {
                v3 = v1.intValue();
            }

            return Integer.valueOf(v3);
        }

        return Integer.valueOf(v3);
    }
}

