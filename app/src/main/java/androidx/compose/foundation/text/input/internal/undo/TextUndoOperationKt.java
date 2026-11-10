package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\u001A\u0014\u0010\u0005\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000¨\u0006\u0006"}, d2={"undo", "", "Landroidx/compose/foundation/text/input/TextFieldState;", "op", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "redo", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextUndoOperationKt {
    public static final void redo(TextFieldState arg10, TextUndoOperation arg11) {
        arg10.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v0 = arg10.getMainBuffer$foundation();
        v0.replace(arg11.getIndex(), arg11.getIndex() + arg11.getPreText().length(), arg11.getPostText());
        TextFieldBufferKt.setSelectionCoerced(v0, TextRange.getStart-impl(arg11.getPostSelection-d9O1mEE()), TextRange.getEnd-impl(arg11.getPostSelection-d9O1mEE()));
        arg10.updateValueAndNotifyListeners(arg10.getValue$foundation(), TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(arg10.getMainBuffer$foundation(), 0, null, null, null, 15, null), true);
    }

    public static final void undo(TextFieldState arg10, TextUndoOperation arg11) {
        arg10.getMainBuffer$foundation().getChangeTracker$foundation().clearChanges();
        TextFieldBuffer v0 = arg10.getMainBuffer$foundation();
        v0.replace(arg11.getIndex(), arg11.getIndex() + arg11.getPostText().length(), arg11.getPreText());
        TextFieldBufferKt.setSelectionCoerced(v0, TextRange.getStart-impl(arg11.getPreSelection-d9O1mEE()), TextRange.getEnd-impl(arg11.getPreSelection-d9O1mEE()));
        arg10.updateValueAndNotifyListeners(arg10.getValue$foundation(), TextFieldBuffer.toTextFieldCharSequence-wFTz33Y$foundation$default(arg10.getMainBuffer$foundation(), 0, null, null, null, 15, null), true);
    }
}

