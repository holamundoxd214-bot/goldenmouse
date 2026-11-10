package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A$\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u000E\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0000¨\u0006\b"}, d2={"makeDefaultSelectionModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "layoutCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionControllerKt {
    public static final Modifier makeDefaultSelectionModifier(SelectionRegistrar arg2, long arg3, Function0 arg5) {
        SelectionControllerKt$makeDefaultSelectionModifier$longPressDragObserver$1 v0 = new SelectionControllerKt$makeDefaultSelectionModifier$longPressDragObserver$1(arg5, arg2, arg3);
        SelectionControllerKt$makeDefaultSelectionModifier$mouseSelectionObserver$1 v1 = new SelectionControllerKt$makeDefaultSelectionModifier$mouseSelectionObserver$1(arg5, arg2, arg3);
        return SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, v1, v0, new SelectionControllerKt$makeDefaultSelectionModifier$1(v1, v0));
    }
}

