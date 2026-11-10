package androidx.compose.material3;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001A\u00020\u0002H\u0016J\u0010\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u0005*\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0015"}, d2={"Landroidx/compose/material3/ExposedDropdownMenuAnchorElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ExposedDropdownMenuAnchorNode;", "updateStateOnAttach", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getUpdateStateOnAttach", "()Lkotlin/jvm/functions/Function0;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ExposedDropdownMenuAnchorElement extends ModifierNodeElement {
    private final Function0 updateStateOnAttach;

    public ExposedDropdownMenuAnchorElement(Function0 arg1) {
        super();
        this.updateStateOnAttach = arg1;
    }

    public ExposedDropdownMenuAnchorNode create() {
        return new ExposedDropdownMenuAnchorNode(this.updateStateOnAttach);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((ExposedDropdownMenuAnchorElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ExposedDropdownMenuAnchorElement)) {
            return 0;
        }

        if(this.updateStateOnAttach == ((ExposedDropdownMenuAnchorElement)arg4).updateStateOnAttach) {
            return 1;
        }

        return 0;
    }

    public final Function0 getUpdateStateOnAttach() {
        return this.updateStateOnAttach;
    }

    public int hashCode() {
        return this.updateStateOnAttach.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("exposedDropdownMenuAnchorType");
        arg2.getProperties().set("updateStateOnAttach", this.updateStateOnAttach);
    }

    public void update(ExposedDropdownMenuAnchorNode arg1) {
        arg1.setUpdateStateOnAttach(this.updateStateOnAttach);
    }

    public void update(Node arg1) {
        this.update(((ExposedDropdownMenuAnchorNode)arg1));
    }
}

