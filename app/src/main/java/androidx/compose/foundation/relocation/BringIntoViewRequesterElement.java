package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0002H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\f\u0010\u000B\u001A\u00020\t*\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/relocation/BringIntoViewRequesterElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "requester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<init>", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class BringIntoViewRequesterElement extends ModifierNodeElement {
    private final BringIntoViewRequester requester;

    public BringIntoViewRequesterElement(BringIntoViewRequester arg1) {
        super();
        this.requester = arg1;
    }

    public BringIntoViewRequesterNode create() {
        return new BringIntoViewRequesterNode(this.requester);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg2) {
        if(this != (((BringIntoViewRequesterElement)arg2)) && (!(arg2 instanceof BringIntoViewRequesterElement) || !Intrinsics.areEqual(this.requester, ((BringIntoViewRequesterElement)arg2).requester))) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.requester.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("bringIntoViewRequester");
        arg2.getProperties().set("bringIntoViewRequester", this.requester);
    }

    public void update(BringIntoViewRequesterNode arg1) {
        arg1.updateRequester(this.requester);
    }

    public void update(Node arg1) {
        this.update(((BringIntoViewRequesterNode)arg1));
    }
}

