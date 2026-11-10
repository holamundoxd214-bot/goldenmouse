package androidx.compose.foundation.content;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J\f\u0010\r\u001A\u00020\u000B*\u00020\u000EH\u0016J\t\u0010\u000F\u001A\u00020\u0004HÆ\u0003J\u0013\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/content/ReceiveContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/content/ReceiveContentNode;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "<init>", "(Landroidx/compose/foundation/content/ReceiveContentListener;)V", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ReceiveContentElement extends ModifierNodeElement {
    public static final int $stable;
    private final ReceiveContentListener receiveContentListener;

    static {
    }

    public ReceiveContentElement(ReceiveContentListener arg1) {
        super();
        this.receiveContentListener = arg1;
    }

    public final ReceiveContentListener component1() {
        return this.receiveContentListener;
    }

    public final ReceiveContentElement copy(ReceiveContentListener arg1) {
        return new ReceiveContentElement(arg1);
    }

    public static ReceiveContentElement copy$default(ReceiveContentElement arg0, ReceiveContentListener arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.receiveContentListener;
        }

        return arg0.copy(arg1);
    }

    public ReceiveContentNode create() {
        return new ReceiveContentNode(this.receiveContentListener);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((ReceiveContentElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ReceiveContentElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.receiveContentListener, ((ReceiveContentElement)arg4).receiveContentListener)) {
            return 0;
        }

        return 1;
    }

    public final ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public int hashCode() {
        return this.receiveContentListener.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        arg1.setName("receiveContent");
    }

    public String toString() {
        return "ReceiveContentElement(receiveContentListener=" + this.receiveContentListener + ')';
    }

    public void update(ReceiveContentNode arg1) {
        arg1.updateNode(this.receiveContentListener);
    }

    public void update(Node arg1) {
        this.update(((ReceiveContentNode)arg1));
    }
}

