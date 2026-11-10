package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0003H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2={"Landroidx/compose/ui/text/input/MoveCursorCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "amount", "", "<init>", "(I)V", "getAmount", "()I", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MoveCursorCommand implements EditCommand {
    public static final int $stable;
    private final int amount;

    static {
    }

    public MoveCursorCommand(int arg1) {
        super();
        this.amount = arg1;
    }

    public void applyTo(EditingBuffer arg6) {
        int v4;
        int v1 = -1;
        if(arg6.getCursor$ui_text() == v1) {
            arg6.setCursor$ui_text(arg6.getSelectionStart$ui_text());
        }

        int v0 = arg6.getSelectionStart$ui_text();
        String v2 = arg6.toString();
        int v5 = this.amount;
        int v3 = 0;
        if(v5 > 0) {
            while(v3 < v5) {
                v4 = JvmCharHelpers_androidKt.findFollowingBreak(v2, v0);
                if(v4 == v1) {
                    break;
                }

                ++v3;
                v0 = v4;
            }
        }
        else {
            v5 = -v5;
            while(v3 < v5) {
                v4 = JvmCharHelpers_androidKt.findPrecedingBreak(v2, v0);
                if(v4 == v1) {
                    break;
                }

                ++v3;
                v0 = v4;
            }
        }

        arg6.setCursor$ui_text(v0);
    }

    public boolean equals(Object arg4) {
        if(this == (((MoveCursorCommand)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof MoveCursorCommand)) {
            return 0;
        }

        if(this.amount != ((MoveCursorCommand)arg4).amount) {
            return 0;
        }

        return 1;
    }

    public final int getAmount() {
        return this.amount;
    }

    public int hashCode() {
        return this.amount;
    }

    public String toString() {
        return "MoveCursorCommand(amount=" + this.amount + ')';
    }
}

