package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016¨\u0006\u0010"}, d2={"Landroidx/compose/ui/text/input/BackspaceCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "<init>", "()V", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BackspaceCommand implements EditCommand {
    public static final int $stable;

    static {
    }

    public BackspaceCommand() {
        super();
    }

    public void applyTo(EditingBuffer arg3) {
        if(arg3.hasComposition$ui_text()) {
            arg3.delete$ui_text(arg3.getCompositionStart$ui_text(), arg3.getCompositionEnd$ui_text());
            return;
        }

        if(arg3.getCursor$ui_text() == -1) {
            int v2 = arg3.getSelectionStart$ui_text();
            int v0 = arg3.getSelectionEnd$ui_text();
            arg3.setCursor$ui_text(arg3.getSelectionStart$ui_text());
            arg3.delete$ui_text(v2, v0);
            return;
        }

        if(arg3.getCursor$ui_text() == 0) {
            return;
        }

        arg3.delete$ui_text(JvmCharHelpers_androidKt.findPrecedingBreak(arg3.toString(), arg3.getCursor$ui_text()), arg3.getCursor$ui_text());
    }

    public boolean equals(Object arg1) {
        return arg1 instanceof BackspaceCommand;
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(this.getClass()).hashCode();
    }

    public String toString() {
        return "BackspaceCommand()";
    }
}

