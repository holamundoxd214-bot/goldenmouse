package androidx.compose.foundation.contextmenu;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0002\u001A\u00020\u0003*\u00020\u0004H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2={"UNSPECIFIED_OFFSET_ERROR_MESSAGE", "", "close", "", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextMenuStateKt {
    private static final String UNSPECIFIED_OFFSET_ERROR_MESSAGE = "ContextMenuState.Status should never be open with an unspecified offset. Use ContextMenuState.Status.Closed instead.";

    public static final void close(ContextMenuState arg1) {
        arg1.setStatus(Closed.INSTANCE);
    }
}

