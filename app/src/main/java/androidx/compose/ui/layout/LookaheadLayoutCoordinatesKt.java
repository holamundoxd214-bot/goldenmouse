package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"rootLookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "getRootLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)Landroidx/compose/ui/node/LookaheadDelegate;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LookaheadLayoutCoordinatesKt {
    public static final LookaheadDelegate getRootLookaheadDelegate(LookaheadDelegate arg2) {
        LayoutNode v1_1;
        LayoutNode v2 = arg2.getLayoutNode();
        while(true) {
            LayoutNode v0 = v2.getParent$ui();
            Object v1 = null;
            v0 = v0 != null ? v0.getLookaheadRoot$ui() : ((LayoutNode)v1);
            if(v0 == null) {
                break;
            }

            v0 = v2.getParent$ui();
            if(v0 != null) {
                v1_1 = v0.getLookaheadRoot$ui();
            }

            Intrinsics.checkNotNull(v1_1);
            if(v1_1.isVirtualLookaheadRoot$ui()) {
                v2 = v2.getParent$ui();
                Intrinsics.checkNotNull(v2);
                continue;
            }

            v2 = v2.getParent$ui();
            Intrinsics.checkNotNull(v2);
            v2 = v2.getLookaheadRoot$ui();
            Intrinsics.checkNotNull(v2);
        }

        arg2 = v2.getOuterCoordinator$ui().getLookaheadDelegate();
        Intrinsics.checkNotNull(arg2);
        return arg2;
    }
}

