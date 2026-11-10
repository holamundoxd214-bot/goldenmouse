package androidx.compose.foundation.text.input;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u0011\u001A\u00020\u0010J\u0006\u0010\u0012\u001A\u00020\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001A\u00020\u00078F¢\u0006\f\u0012\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\f\u001A\u00020\u00078F¢\u0006\f\u0012\u0004\b\r\u0010\t\u001A\u0004\b\u000E\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/text/input/UndoState;", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldState;)V", "canUndo", "", "getCanUndo$annotations", "()V", "getCanUndo", "()Z", "canRedo", "getCanRedo$annotations", "getCanRedo", "undo", "", "redo", "clearHistory", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UndoState {
    public static final int $stable;
    private final TextFieldState state;

    static {
    }

    public UndoState(TextFieldState arg1) {
        super();
        this.state = arg1;
    }

    public final void clearHistory() {
        this.state.getTextUndoManager$foundation().clearHistory();
    }

    public final boolean getCanRedo() {
        return this.state.getTextUndoManager$foundation().getCanRedo();
    }

    public static void getCanRedo$annotations() {
    }

    public final boolean getCanUndo() {
        return this.state.getTextUndoManager$foundation().getCanUndo();
    }

    public static void getCanUndo$annotations() {
    }

    public final void redo() {
        this.state.getTextUndoManager$foundation().redo(this.state);
    }

    public final void undo() {
        this.state.getTextUndoManager$foundation().undo(this.state);
    }
}

