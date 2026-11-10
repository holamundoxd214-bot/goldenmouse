package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000¨\u0006\b"}, d2={"contextMenuGestures", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onOpenGesture", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenuGesturesKt {
    public static final Modifier contextMenuGestures(Modifier arg2, Function1 arg3) {
        return SuspendingPointerInputFilterKt.pointerInput(arg2, ContextMenuKey.INSTANCE, new ContextMenuGesturesKt$contextMenuGestures$2(arg3));
    }

    public static final Modifier contextMenuGestures(Modifier arg1, ContextMenuState arg2) {
        return ContextMenuGesturesKt.contextMenuGestures(arg1, new ContextMenuGesturesKt$$ExternalSyntheticLambda0(arg2));
    }

    static final Unit contextMenuGestures$lambda$0(ContextMenuState arg3, Offset arg4) {
        arg3.setStatus(new Open(arg4.unbox-impl(), null));
        return Unit.INSTANCE;
    }
}

