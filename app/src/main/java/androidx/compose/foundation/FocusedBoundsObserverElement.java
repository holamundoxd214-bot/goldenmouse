package androidx.compose.foundation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001D\u0012\u0014\u0010\u0003\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0010\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u0002H\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\f\u0010\u0014\u001A\u00020\u0006*\u00020\u0015H\u0016R\u001F\u0010\u0003\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/FocusedBoundsObserverElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/FocusedBoundsObserverNode;", "onPositioned", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnPositioned", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class FocusedBoundsObserverElement extends ModifierNodeElement {
    private final Function1 onPositioned;

    public FocusedBoundsObserverElement(Function1 arg1) {
        super();
        this.onPositioned = arg1;
    }

    public FocusedBoundsObserverNode create() {
        return new FocusedBoundsObserverNode(this.onPositioned);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg3) {
        if(this == (((FocusedBoundsObserverElement)arg3))) {
            return 1;
        }

        if((arg3 instanceof FocusedBoundsObserverElement)) {
        }
        else {
            FocusedBoundsObserverElement v3 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if(this.onPositioned == v3.onPositioned) {
            return 1;
        }

        return 0;
    }

    public final Function1 getOnPositioned() {
        return this.onPositioned;
    }

    public int hashCode() {
        return this.onPositioned.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("onFocusedBoundsChanged");
        arg2.getProperties().set("onPositioned", this.onPositioned);
    }

    public void update(FocusedBoundsObserverNode arg1) {
        arg1.setOnPositioned(this.onPositioned);
    }

    public void update(Node arg1) {
        this.update(((FocusedBoundsObserverNode)arg1));
    }
}

