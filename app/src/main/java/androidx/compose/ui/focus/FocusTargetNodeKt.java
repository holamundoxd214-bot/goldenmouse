package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2={"invalidateFocusTarget", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusTargetNodeKt {
    public static final void invalidateFocusTarget(FocusTargetNode arg1) {
        DelegatableNodeKt.requireOwner(arg1).getFocusOwner().scheduleInvalidation(arg1);
    }
}

