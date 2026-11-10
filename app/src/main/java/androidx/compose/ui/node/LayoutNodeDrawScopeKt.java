package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2={"nextDrawNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LayoutNodeDrawScopeKt {
    public static final Node access$nextDrawNode(DelegatableNode arg0) {
        return LayoutNodeDrawScopeKt.nextDrawNode(arg0);
    }

    private static final Node nextDrawNode(DelegatableNode arg4) {
        int v0 = NodeKind.constructor-impl(4);
        int v1 = NodeKind.constructor-impl(2);
        Node v4 = arg4.getNode().getChild$ui();
        Node v2 = null;
        if(v4 == null) {
            return v2;
        }

        if((v4.getAggregateChildKindSet$ui() & v0) == 0) {
            return v2;
        }

        while(v4 != null) {
            if((v4.getKindSet$ui() & v1) != 0) {
                return v2;
            }

            if((v4.getKindSet$ui() & v0) != 0) {
                return v4;
            }

            v4 = v4.getChild$ui();
        }

        return v2;
    }
}

