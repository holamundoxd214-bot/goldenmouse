package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012\'\u0010\u0003\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u000F\u001A\u00020\u0002H\u0016J\u0010\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0002H\u0016J\f\u0010\u0012\u001A\u00020\u0007*\u00020\u0013H\u0016J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016R4\u0010\u0003\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/draganddrop/LegacyDragAndDropSourceWithDefaultShadowElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/LegacyDragSourceNodeWithDefaultPainter;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LegacyDragAndDropSourceWithDefaultShadowElement extends ModifierNodeElement {
    private final Function2 dragAndDropSourceHandler;

    public LegacyDragAndDropSourceWithDefaultShadowElement(Function2 arg1) {
        super();
        this.dragAndDropSourceHandler = arg1;
    }

    public LegacyDragSourceNodeWithDefaultPainter create() {
        return new LegacyDragSourceNodeWithDefaultPainter(this.dragAndDropSourceHandler);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg2) {
        if(this == (((LegacyDragAndDropSourceWithDefaultShadowElement)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof LegacyDragAndDropSourceWithDefaultShadowElement)) {
            return 0;
        }

        return Intrinsics.areEqual(this.dragAndDropSourceHandler, ((LegacyDragAndDropSourceWithDefaultShadowElement)arg2).dragAndDropSourceHandler);
    }

    public final Function2 getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public int hashCode() {
        return this.dragAndDropSourceHandler.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("dragSourceWithDefaultPainter");
        arg2.getProperties().set("dragAndDropSourceHandler", this.dragAndDropSourceHandler);
    }

    public void update(LegacyDragSourceNodeWithDefaultPainter arg1) {
        arg1.setDragAndDropSourceHandler(this.dragAndDropSourceHandler);
    }

    public void update(Node arg1) {
        this.update(((LegacyDragSourceNodeWithDefaultPainter)arg1));
    }
}

