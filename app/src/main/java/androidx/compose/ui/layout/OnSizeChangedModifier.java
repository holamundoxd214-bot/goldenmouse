package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u0002H\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\f\u0010\u0012\u001A\u00020\u0006*\u00020\u0013H\u0016R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/ui/layout/OnSizeChangedModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/OnSizeChangedNode;", "onSizeChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "create", "update", "node", "equals", "", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class OnSizeChangedModifier extends ModifierNodeElement {
    private final Function1 onSizeChanged;

    public OnSizeChangedModifier(Function1 arg1) {
        super();
        this.onSizeChanged = arg1;
    }

    public Node create() {
        return this.create();
    }

    public OnSizeChangedNode create() {
        return new OnSizeChangedNode(this.onSizeChanged);
    }

    public boolean equals(Object arg4) {
        if(this == (((OnSizeChangedModifier)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof OnSizeChangedModifier)) {
            return 0;
        }

        if(this.onSizeChanged == ((OnSizeChangedModifier)arg4).onSizeChanged) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.onSizeChanged.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("onSizeChanged");
        arg2.getProperties().set("onSizeChanged", this.onSizeChanged);
    }

    public void update(Node arg1) {
        this.update(((OnSizeChangedNode)arg1));
    }

    public void update(OnSizeChangedNode arg1) {
        arg1.update(this.onSizeChanged);
    }
}

