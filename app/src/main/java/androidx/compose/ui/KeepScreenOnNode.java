package androidx.compose.ui;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\b\u0010\u0006\u001A\u00020\u0005H\u0016¨\u0006\u0007"}, d2={"Landroidx/compose/ui/KeepScreenOnNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "onAttach", "", "onDetach", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class KeepScreenOnNode extends Node {
    public KeepScreenOnNode() {
        super();
    }

    public void onAttach() {
        DelegatableNodeKt.requireOwner(((DelegatableNode)this)).incrementKeepScreenOnCount();
    }

    public void onDetach() {
        DelegatableNodeKt.requireOwner(((DelegatableNode)this)).decrementKeepScreenOnCount();
    }
}

