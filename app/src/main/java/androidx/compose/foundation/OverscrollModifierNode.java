package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\b\u0010\b\u001A\u00020\u0007H\u0016J\u0010\u0010\t\u001A\u00020\u00072\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003J\b\u0010\n\u001A\u00020\u0007H\u0002R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/OverscrollModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "overscrollNode", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;)V", "onAttach", "", "onDetach", "update", "attachIfNeeded", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class OverscrollModifierNode extends DelegatingNode {
    private DelegatableNode overscrollNode;

    public OverscrollModifierNode(DelegatableNode arg1) {
        super();
        this.overscrollNode = arg1;
    }

    private final void attachIfNeeded() {
        DelegatableNode v0 = this.overscrollNode;
        if(v0 != null) {
            Node v0_1 = v0.getNode();
            if(v0_1 == null) {
                goto label_10;
            }
            else if(!v0_1.isAttached()) {
                v0 = this.overscrollNode;
                Intrinsics.checkNotNull(v0);
                v0 = this.delegate(v0);
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            v0 = null;
        }

        this.overscrollNode = v0;
    }

    public void onAttach() {
        this.attachIfNeeded();
    }

    public void onDetach() {
        DelegatableNode v0 = this.overscrollNode;
        if(v0 != null) {
            this.undelegate(v0);
        }
    }

    public final void update(DelegatableNode arg2) {
        DelegatableNode v0 = this.overscrollNode;
        if(v0 != null) {
            this.undelegate(v0);
        }

        this.overscrollNode = arg2;
        this.attachIfNeeded();
    }
}

