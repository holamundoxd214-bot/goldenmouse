package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0003H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2={"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "<init>", "(II)V", "getLengthBeforeCursor", "()I", "getLengthAfterCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    static {
    }

    public DeleteSurroundingTextInCodePointsCommand(int arg2, int arg3) {
        super();
        this.lengthBeforeCursor = arg2;
        this.lengthAfterCursor = arg3;
        int v1 = arg2 < 0 || arg3 < 0 ? 0 : 1;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + arg2 + " and " + arg3 + " respectively.");
        }
    }

    public void applyTo(EditingBuffer arg8) {
        int v0 = this.lengthBeforeCursor;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(true) {
            if(v2 < v0) {
                int v4 = v3 + 1;
                if(arg8.getSelectionStart$ui_text() > v4) {
                    if(EditCommandKt.access$isSurrogatePair(arg8.get$ui_text(arg8.getSelectionStart$ui_text() - v4 - 1), arg8.get$ui_text(arg8.getSelectionStart$ui_text() - v4))) {
                        v3 += 2;
                    }
                    else {
                        v3 = v4;
                    }

                    ++v2;
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_23;
        }

        v3 = arg8.getSelectionStart$ui_text();
    label_23:
        int v7 = this.lengthAfterCursor;
        v0 = 0;
        while(true) {
            if(v1 < v7) {
                v2 = v0 + 1;
                if(arg8.getSelectionEnd$ui_text() + v2 < arg8.getLength$ui_text()) {
                    if(EditCommandKt.access$isSurrogatePair(arg8.get$ui_text(arg8.getSelectionEnd$ui_text() + v2 - 1), arg8.get$ui_text(arg8.getSelectionEnd$ui_text() + v2))) {
                        v0 += 2;
                    }
                    else {
                        v0 = v2;
                    }

                    ++v1;
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_48;
        }

        v0 = arg8.getLength$ui_text() - arg8.getSelectionEnd$ui_text();
    label_48:
        arg8.delete$ui_text(arg8.getSelectionEnd$ui_text(), arg8.getSelectionEnd$ui_text() + v0);
        arg8.delete$ui_text(arg8.getSelectionStart$ui_text() - v3, arg8.getSelectionStart$ui_text());
    }

    public boolean equals(Object arg5) {
        if(this == (((DeleteSurroundingTextInCodePointsCommand)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return 0;
        }

        if(this.lengthBeforeCursor != ((DeleteSurroundingTextInCodePointsCommand)arg5).lengthBeforeCursor) {
            return 0;
        }

        if(this.lengthAfterCursor != ((DeleteSurroundingTextInCodePointsCommand)arg5).lengthAfterCursor) {
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
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}

