package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B2\u0012!\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0012\u001A\u00020\u0002H\u0016J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0002H\u0016J\f\u0010\u0016\u001A\u00020\u0014*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001A\u00020\t2\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0096\u0002J\b\u0010\u001B\u001A\u00020\u001CH\u0016R,\u0010\u0003\u001A\u001D\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/draganddrop/DropTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/DragAndDropTargetNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)V", "getShouldStartDragAndDrop", "()Lkotlin/jvm/functions/Function1;", "getTarget", "()Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DropTargetElement extends ModifierNodeElement {
    private final Function1 shouldStartDragAndDrop;
    private final DragAndDropTarget target;

    public DropTargetElement(Function1 arg1, DragAndDropTarget arg2) {
        super();
        this.shouldStartDragAndDrop = arg1;
        this.target = arg2;
    }

    public DragAndDropTargetNode create() {
        return new DragAndDropTargetNode(this.shouldStartDragAndDrop, this.target);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((DropTargetElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DropTargetElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.target, ((DropTargetElement)arg5).target)) {
            return 0;
        }

        if(this.shouldStartDragAndDrop == ((DropTargetElement)arg5).shouldStartDragAndDrop) {
            return 1;
        }

        return 0;
    }

    public final Function1 getShouldStartDragAndDrop() {
        return this.shouldStartDragAndDrop;
    }

    public final DragAndDropTarget getTarget() {
        return this.target;
    }

    public int hashCode() {
        return this.target.hashCode() * 0x1F + this.shouldStartDragAndDrop.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("dropTarget");
        arg4.getProperties().set("target", this.target);
        arg4.getProperties().set("shouldStartDragAndDrop", this.shouldStartDragAndDrop);
    }

    public void update(DragAndDropTargetNode arg2) {
        arg2.update(this.shouldStartDragAndDrop, this.target);
    }

    public void update(Node arg1) {
        this.update(((DragAndDropTargetNode)arg1));
    }
}

