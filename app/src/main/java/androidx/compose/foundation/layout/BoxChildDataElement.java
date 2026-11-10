package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001A\u00020\u0002H\u0016J\u0010\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u0002H\u0016J\f\u0010\u0017\u001A\u00020\n*\u00020\tH\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\u0013\u0010\u001A\u001A\u00020\u00062\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/layout/BoxChildDataElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/BoxChildDataNode;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getMatchParentSize", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "hashCode", "", "equals", "other", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class BoxChildDataElement extends ModifierNodeElement {
    private final Alignment alignment;
    private final Function1 inspectorInfo;
    private final boolean matchParentSize;

    public BoxChildDataElement(Alignment arg1, boolean arg2, Function1 arg3) {
        super();
        this.alignment = arg1;
        this.matchParentSize = arg2;
        this.inspectorInfo = arg3;
    }

    public BoxChildDataNode create() {
        return new BoxChildDataNode(this.alignment, this.matchParentSize);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((BoxChildDataElement)arg5))) {
            return 1;
        }

        if((arg5 instanceof BoxChildDataElement)) {
        }
        else {
            BoxChildDataElement v5 = null;
        }

        if(0 == 0) {
            return 0;
        }

        if((Intrinsics.areEqual(this.alignment, v5.alignment)) && this.matchParentSize == v5.matchParentSize) {
            return 1;
        }

        return 0;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final Function1 getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }

    public int hashCode() {
        return this.alignment.hashCode() * 0x1F + Boolean.hashCode(this.matchParentSize);
    }

    public void inspectableProperties(InspectorInfo arg1) {
        this.inspectorInfo.invoke(arg1);
    }

    public void update(BoxChildDataNode arg2) {
        arg2.setAlignment(this.alignment);
        arg2.setMatchParentSize(this.matchParentSize);
    }

    public void update(Node arg1) {
        this.update(((BoxChildDataNode)arg1));
    }
}

