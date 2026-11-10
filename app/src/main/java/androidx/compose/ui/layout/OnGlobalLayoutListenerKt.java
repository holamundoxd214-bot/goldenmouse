package androidx.compose.ui.layout;

import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001A.\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¨\u0006\n"}, d2={"registerOnGlobalLayoutListener", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "Landroidx/compose/ui/node/DelegatableNode;", "throttleMillis", "", "debounceMillis", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OnGlobalLayoutListenerKt {
    public static final RegistrationHandle registerOnGlobalLayoutListener(DelegatableNode arg9, long arg10, long arg12, Function1 arg14) {
        LayoutNode v0 = DelegatableNodeKt.requireLayoutNode(arg9);
        return LayoutNodeKt.requireOwner(v0).getRectManager().registerOnGlobalLayoutCallback(v0.getSemanticsId(), arg10, arg12, arg9.getNode(), arg14);
    }
}

