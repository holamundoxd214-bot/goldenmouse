package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001A\u00020\u0002H\u0016J\u0010\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u0002H\u0016J\u0013\u0010\u0017\u001A\u00020\u00062\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\f\u0010\u001C\u001A\u00020\n*\u00020\tH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/layout/IntrinsicWidthElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/IntrinsicWidthNode;", "width", "Landroidx/compose/foundation/layout/IntrinsicSize;", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/layout/IntrinsicSize;ZLkotlin/jvm/functions/Function1;)V", "getWidth", "()Landroidx/compose/foundation/layout/IntrinsicSize;", "getEnforceIncoming", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "equals", "other", "", "hashCode", "", "inspectableProperties", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class IntrinsicWidthElement extends ModifierNodeElement {
    private final boolean enforceIncoming;
    private final Function1 inspectorInfo;
    private final IntrinsicSize width;

    public IntrinsicWidthElement(IntrinsicSize arg1, boolean arg2, Function1 arg3) {
        super();
        this.width = arg1;
        this.enforceIncoming = arg2;
        this.inspectorInfo = arg3;
    }

    public IntrinsicWidthNode create() {
        return new IntrinsicWidthNode(this.width, this.enforceIncoming);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((IntrinsicWidthElement)arg5))) {
            return 1;
        }

        if((arg5 instanceof IntrinsicWidthElement)) {
        }
        else {
            IntrinsicWidthElement v5 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if(this.width == v5.width && this.enforceIncoming == v5.enforceIncoming) {
            return 1;
        }

        return 0;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final IntrinsicSize getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.width.hashCode() * 0x1F + Boolean.hashCode(this.enforceIncoming);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(IntrinsicWidthNode arg2) {
        arg2.setWidth(this.width);
        arg2.setEnforceIncoming(this.enforceIncoming);
    }

    public void update(Node arg1) {
        this.update(((IntrinsicWidthNode)arg1));
    }
}

