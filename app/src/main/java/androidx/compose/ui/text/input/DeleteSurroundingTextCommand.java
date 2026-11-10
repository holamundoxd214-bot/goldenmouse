package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0003H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/text/input/DeleteSurroundingTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "<init>", "(II)V", "getLengthBeforeCursor", "()I", "getLengthAfterCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DeleteSurroundingTextCommand implements EditCommand {
    public static final int $stable;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    static {
    }

    public DeleteSurroundingTextCommand(int arg2, int arg3) {
        super();
        this.lengthBeforeCursor = arg2;
        this.lengthAfterCursor = arg3;
        int v1 = arg2 < 0 || arg3 < 0 ? 0 : 1;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + arg2 + " and " + arg3 + " respectively.");
        }
    }

    public void applyTo(EditingBuffer arg4) {
        int v0 = arg4.getSelectionEnd$ui_text();
        int v2 = v0 + this.lengthAfterCursor;
        if(((v0 ^ v2) & (this.lengthAfterCursor ^ v2)) < 0) {
            v2 = arg4.getLength$ui_text();
        }

        arg4.delete$ui_text(arg4.getSelectionEnd$ui_text(), Math.min(v2, arg4.getLength$ui_text()));
        v0 = arg4.getSelectionStart$ui_text();
        int v1 = v0 - this.lengthBeforeCursor;
        if(((this.lengthBeforeCursor ^ v0) & (v0 ^ v1)) < 0) {
            v1 = 0;
        }

        arg4.delete$ui_text(Math.max(0, v1), arg4.getSelectionStart$ui_text());
    }

    public boolean equals(Object arg5) {
        if(this == (((DeleteSurroundingTextCommand)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DeleteSurroundingTextCommand)) {
            return 0;
        }

        if(this.lengthBeforeCursor != ((DeleteSurroundingTextCommand)arg5).lengthBeforeCursor) {
            return 0;
        }

        if(this.lengthAfterCursor != ((DeleteSurroundingTextCommand)arg5).lengthAfterCursor) {
            return 0;
        }

        return 1;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public int hashCode() {
        return this.lengthBeforeCursor * 0x1F + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}

