package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2={"nestedScroll", "Landroidx/compose/ui/Modifier;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NestedScrollModifierKt {
    public static final Modifier nestedScroll(Modifier arg1, NestedScrollConnection arg2, NestedScrollDispatcher arg3) {
        return arg1.then(new NestedScrollElement(arg2, arg3));
    }

    public static Modifier nestedScroll$default(Modifier arg0, NestedScrollConnection arg1, NestedScrollDispatcher arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return NestedScrollModifierKt.nestedScroll(arg0, arg1, arg2);
    }
}

