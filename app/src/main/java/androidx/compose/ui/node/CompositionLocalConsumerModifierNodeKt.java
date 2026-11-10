package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A#\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"currentValueOf", "T", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "local", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CompositionLocalConsumerModifierNodeKt {
    public static final Object currentValueOf(CompositionLocalConsumerModifierNode arg1, CompositionLocal arg2) {
        if(!arg1.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot read CompositionLocal because the Modifier node is not currently attached.");
        }

        return DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg1)).getCompositionLocalMap().get(arg2);
    }
}

