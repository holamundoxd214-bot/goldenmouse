package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001E\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "", "showTextToolbar", "", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideTextToolbar", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextToolbarHandler {
    void hideTextToolbar();

    Object showTextToolbar(TextFieldSelectionState arg1, Rect arg2, Continuation arg3);
}

