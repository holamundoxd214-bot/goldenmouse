package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A(\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0001¨\u0006\n"}, d2={"textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTextFieldMagnifier_androidKt {
    public static final TextFieldMagnifierNode textFieldMagnifierNode(TransformedTextFieldState arg3, TextFieldSelectionState arg4, TextLayoutState arg5, boolean arg6) {
        if(Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null)) {
            return new TextFieldMagnifierNodeImpl28(arg3, arg4, arg5, arg6);
        }

        return new AndroidTextFieldMagnifier_androidKt$textFieldMagnifierNode$1();
    }
}

