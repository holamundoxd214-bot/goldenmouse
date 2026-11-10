package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0010\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u0002H\u0016J\f\u0010\u0014\u001A\u00020\u0006*\u00020\u0015H\u0016R\u001D\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/ui/layout/OnGloballyPositionedElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/OnGloballyPositionedNode;", "onGloballyPositioned", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnGloballyPositioned", "()Lkotlin/jvm/functions/Function1;", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class OnGloballyPositionedElement extends ModifierNodeElement {
    private final Function1 onGloballyPositioned;

    public OnGloballyPositionedElement(Function1 arg1) {
        super();
        this.onGloballyPositioned = arg1;
    }

    public Node create() {
        return this.create();
    }

    public OnGloballyPositionedNode create() {
        return new OnGloballyPositionedNode(this.onGloballyPositioned);
    }

    public boolean equals(Object arg4) {
        if(this == (((OnGloballyPositionedElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof OnGloballyPositionedElement)) {
            return 0;
        }

        if(this.onGloballyPositioned == ((OnGloballyPositionedElement)arg4).onGloballyPositioned) {
            return 1;
        }

        return 0;
    }

    public final Function1 getOnGloballyPositioned() {
        return this.onGloballyPositioned;
    }

    public int hashCode() {
        return this.onGloballyPositioned.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("onGloballyPositioned");
        arg2.getProperties().set("onGloballyPositioned", this.onGloballyPositioned);
    }

    public void update(Node arg1) {
        this.update(((OnGloballyPositionedNode)arg1));
    }

    public void update(OnGloballyPositionedNode arg1) {
        arg1.setCallback(this.onGloballyPositioned);
    }
}

