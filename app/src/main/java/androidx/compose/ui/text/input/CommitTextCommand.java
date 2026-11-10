package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u0005H\u0016J\b\u0010\u001A\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Landroidx/compose/ui/text/input/CommitTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "newCursorPosition", "", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;I)V", "text", "", "(Ljava/lang/String;I)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getNewCursorPosition", "()I", "getText", "()Ljava/lang/String;", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CommitTextCommand implements EditCommand {
    public static final int $stable;
    private final AnnotatedString annotatedString;
    private final int newCursorPosition;

    static {
    }

    public CommitTextCommand(String arg4, int arg5) {
        this(new AnnotatedString(arg4, null, 2, null), arg5);
    }

    public CommitTextCommand(AnnotatedString arg1, int arg2) {
        super();
        this.annotatedString = arg1;
        this.newCursorPosition = arg2;
    }

    public void applyTo(EditingBuffer arg4) {
        if(arg4.hasComposition$ui_text()) {
            arg4.replace$ui_text(arg4.getCompositionStart$ui_text(), arg4.getCompositionEnd$ui_text(), this.getText());
        }
        else {
            arg4.replace$ui_text(arg4.getSelectionStart$ui_text(), arg4.getSelectionEnd$ui_text(), this.getText());
        }

        int v0 = arg4.getCursor$ui_text();
        int v1 = this.newCursorPosition;
        v0 = v1 > 0 ? v0 + v1 - 1 : v0 + v1 - this.getText().length();
        arg4.setCursor$ui_text(RangesKt.coerceIn(v0, 0, arg4.getLength$ui_text()));
    }

    public boolean equals(Object arg5) {
        if(this == (((CommitTextCommand)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CommitTextCommand)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getText(), ((CommitTextCommand)arg5).getText())) {
            return 0;
        }

        if(this.newCursorPosition != ((CommitTextCommand)arg5).newCursorPosition) {
            return 0;
        }

        return 1;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final int getNewCursorPosition() {
        return this.newCursorPosition;
    }

    public final String getText() {
        return this.annotatedString.getText();
    }

    public int hashCode() {
        return this.getText().hashCode() * 0x1F + this.newCursorPosition;
    }

    public String toString() {
        return "CommitTextCommand(text=\'" + this.getText() + "\', newCursorPosition=" + this.newCursorPosition + ')';
    }
}

