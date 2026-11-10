package androidx.compose.foundation;

import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/foundation/IndicationModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "indicationNode", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;)V", "update", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class IndicationModifierNode extends DelegatingNode {
    private DelegatableNode indicationNode;

    public IndicationModifierNode(DelegatableNode arg1) {
        super();
        this.indicationNode = arg1;
        this.delegate(arg1);
    }

    public final void update(DelegatableNode arg2) {
        this.undelegate(this.indicationNode);
        this.indicationNode = arg2;
        this.delegate(arg2);
    }
}

