package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B2\u0012!\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u000F\u001A\u00020\u0010H\u0016J1\u0010\u0011\u001A\u00020\u00102!\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001A\u00020\nJ\b\u0010\u0012\u001A\u00020\u0010H\u0016J\b\u0010\u0013\u001A\u00020\u0010H\u0002R)\u0010\u0002\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/draganddrop/DragAndDropTargetNode;", "Landroidx/compose/ui/node/DelegatingNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)V", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "onAttach", "", "update", "onDetach", "createAndAttachDragAndDropModifierNode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DragAndDropTargetNode extends DelegatingNode {
    private DragAndDropTargetModifierNode dragAndDropNode;
    private Function1 shouldStartDragAndDrop;
    private DragAndDropTarget target;

    public DragAndDropTargetNode(Function1 arg1, DragAndDropTarget arg2) {
        super();
        this.shouldStartDragAndDrop = arg1;
        this.target = arg2;
    }

    private final void createAndAttachDragAndDropModifierNode() {
        this.dragAndDropNode = this.delegate(DragAndDropNodeKt.DragAndDropTargetModifierNode(new DragAndDropTargetNode$$ExternalSyntheticLambda0(this), this.target));
    }

    static final boolean createAndAttachDragAndDropModifierNode$lambda$0(DragAndDropTargetNode arg0, DragAndDropEvent arg1) {
        return arg0.shouldStartDragAndDrop.invoke(arg1).booleanValue();
    }

    public void onAttach() {
        this.createAndAttachDragAndDropModifierNode();
    }

    public void onDetach() {
        DragAndDropTargetModifierNode v0 = this.dragAndDropNode;
        Intrinsics.checkNotNull(v0);
        this.undelegate(((DelegatableNode)v0));
    }

    public final void update(Function1 arg1, DragAndDropTarget arg2) {
        this.shouldStartDragAndDrop = arg1;
        if(!Intrinsics.areEqual(arg2, this.target)) {
            DragAndDropTargetModifierNode v1 = this.dragAndDropNode;
            if(v1 != null) {
                this.undelegate(((DelegatableNode)v1));
            }

            this.target = arg2;
            this.createAndAttachDragAndDropModifierNode();
        }
    }
}

