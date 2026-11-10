package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001A\u00020\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"isAttached", "", "Landroidx/compose/ui/node/PointerInputModifierNode;", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Z", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates", "(Landroidx/compose/ui/node/PointerInputModifierNode;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerInputModifierNodeKt {
    public static final LayoutCoordinates getLayoutCoordinates(PointerInputModifierNode arg1) {
        return DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)arg1), NodeKind.constructor-impl(16));
    }

    public static final boolean isAttached(PointerInputModifierNode arg0) {
        return arg0.getNode().isAttached();
    }
}

