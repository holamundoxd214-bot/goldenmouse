package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2={"requireView", "Landroid/view/View;", "Landroidx/compose/ui/node/DelegatableNode;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DelegatableNode_androidKt {
    public static final View requireView(DelegatableNode arg1) {
        if(!arg1.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get View because the Modifier node is not currently attached.");
        }

        Owner v1 = LayoutNodeKt.requireOwner(DelegatableNodeKt.requireLayoutNode(arg1));
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type android.view.View");
        return ((View)v1);
    }
}

