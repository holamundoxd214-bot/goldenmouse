package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\'\u0010\b\u001A#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0014\u001A\u00020\u0002H\u0016J\u0010\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u0002H\u0016J\f\u0010\u0017\u001A\u00020\u0006*\u00020\u0018H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u001C\u001A\u00020\u001DH\u0016R\"\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R4\u0010\b\u001A#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/draganddrop/LegacyDragAndDropSourceElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/LegacyDragAndDropSourceNode;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getDrawDragDecoration", "()Lkotlin/jvm/functions/Function1;", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LegacyDragAndDropSourceElement extends ModifierNodeElement {
    private final Function2 dragAndDropSourceHandler;
    private final Function1 drawDragDecoration;

    public LegacyDragAndDropSourceElement(Function1 arg1, Function2 arg2) {
        super();
        this.drawDragDecoration = arg1;
        this.dragAndDropSourceHandler = arg2;
    }

    public LegacyDragAndDropSourceNode create() {
        return new LegacyDragAndDropSourceNode(this.drawDragDecoration, this.dragAndDropSourceHandler);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((LegacyDragAndDropSourceElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof LegacyDragAndDropSourceElement)) {
            return 0;
        }

        if(this.drawDragDecoration != ((LegacyDragAndDropSourceElement)arg5).drawDragDecoration) {
            return 0;
        }

        if(this.dragAndDropSourceHandler != ((LegacyDragAndDropSourceElement)arg5).dragAndDropSourceHandler) {
            return 0;
        }

        return 1;
    }

    public final Function2 getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final Function1 getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    public int hashCode() {
        return this.drawDragDecoration.hashCode() * 0x1F + this.dragAndDropSourceHandler.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("dragSource");
        arg4.getProperties().set("drawDragDecoration", this.drawDragDecoration);
        arg4.getProperties().set("dragAndDropSourceHandler", this.dragAndDropSourceHandler);
    }

    public void update(LegacyDragAndDropSourceNode arg2) {
        arg2.setDrawDragDecoration(this.drawDragDecoration);
        arg2.setDragAndDropSourceHandler(this.dragAndDropSourceHandler);
    }

    public void update(Node arg1) {
        this.update(((LegacyDragAndDropSourceNode)arg1));
    }
}

