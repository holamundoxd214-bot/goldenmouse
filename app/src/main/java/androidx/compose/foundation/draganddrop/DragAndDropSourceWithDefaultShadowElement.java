package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BJ\u0012+\u0010\u0003\u001A\'\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004j\u0002`\n¢\u0006\u0002\b\t\u0012\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\f¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010\u001A\u001A\u00020\u0002H\u0016J\u0010\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u001C\u001A\u00020\u0002H\u0016J\f\u0010\u001D\u001A\u00020\u0007*\u00020\u001EH\u0016J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\"\u001A\u00020#H\u0016RA\u0010\u0003\u001A\'\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004j\u0002`\n¢\u0006\u0002\b\tX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2={"Landroidx/compose/foundation/draganddrop/DragAndDropSourceWithDefaultShadowElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/DragSourceNodeWithDefaultPainter;", "detectDragStart", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetector;", "transferData", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getDetectDragStart", "()Lkotlin/jvm/functions/Function2;", "setDetectDragStart", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getTransferData", "()Lkotlin/jvm/functions/Function1;", "setTransferData", "(Lkotlin/jvm/functions/Function1;)V", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DragAndDropSourceWithDefaultShadowElement extends ModifierNodeElement {
    private Function2 detectDragStart;
    private Function1 transferData;

    public DragAndDropSourceWithDefaultShadowElement(Function2 arg1, Function1 arg2) {
        super();
        this.detectDragStart = arg1;
        this.transferData = arg2;
    }

    public DragSourceNodeWithDefaultPainter create() {
        return new DragSourceNodeWithDefaultPainter(this.detectDragStart, this.transferData);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((DragAndDropSourceWithDefaultShadowElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DragAndDropSourceWithDefaultShadowElement)) {
            return 0;
        }

        if(this.detectDragStart != ((DragAndDropSourceWithDefaultShadowElement)arg5).detectDragStart) {
            return 0;
        }

        if(this.transferData != ((DragAndDropSourceWithDefaultShadowElement)arg5).transferData) {
            return 0;
        }

        return 1;
    }

    public final Function2 getDetectDragStart() {
        return this.detectDragStart;
    }

    public final Function1 getTransferData() {
        return this.transferData;
    }

    public int hashCode() {
        return this.detectDragStart.hashCode() * 0x1F + this.transferData.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("dragSourceWithDefaultPainter");
        arg4.getProperties().set("detectDragStart", this.detectDragStart);
        arg4.getProperties().set("transferData", this.transferData);
    }

    public final void setDetectDragStart(Function2 arg1) {
        this.detectDragStart = arg1;
    }

    public final void setTransferData(Function1 arg1) {
        this.transferData = arg1;
    }

    public void update(DragSourceNodeWithDefaultPainter arg2) {
        arg2.setDetectDragStart(this.detectDragStart);
        arg2.setTransferData(this.transferData);
    }

    public void update(Node arg1) {
        this.update(((DragSourceNodeWithDefaultPainter)arg1));
    }
}

