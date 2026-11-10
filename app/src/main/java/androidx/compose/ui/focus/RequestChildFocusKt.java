package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0004¨\u0006\b"}, d2={"requestFocusForChildInRootBounds", "", "Landroidx/compose/ui/node/DelegatableNode;", "left", "", "top", "right", "bottom", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RequestChildFocusKt {
    public static final boolean requestFocusForChildInRootBounds(DelegatableNode arg7, int arg8, int arg9, int arg10, int arg11) {
        FocusTargetModifierNode v7 = DelegatableNodeKt.requireOwner(arg7).getRectManager().findFocusableNodeFromRect$ui(arg8, arg9, arg10, arg11, DelegatableNodeKt.requireLayoutNode(arg7).getSemanticsId());
        if(v7 != null) {
            return FocusTargetModifierNode.requestFocus-3ESFkO8$default(v7, 0, 1, null);
        }

        return 0;
    }
}

