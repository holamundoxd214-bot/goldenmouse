package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001A\u00020\u0002H\u0016J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0002H\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\f\u0010\u0011\u001A\u00020\u0005*\u00020\u0012H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/text/handwriting/HandwritingDetectorElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/handwriting/HandwritingDetectorNode;", "callback", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "create", "update", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HandwritingDetectorElement extends ModifierNodeElement {
    private final Function0 callback;

    public HandwritingDetectorElement(Function0 arg1) {
        super();
        this.callback = arg1;
    }

    public HandwritingDetectorNode create() {
        return new HandwritingDetectorNode(this.callback);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        int v0 = 1;
        int v2 = this == (((HandwritingDetectorElement)arg5)) ? 1 : 0;
        if(!(arg5 instanceof HandwritingDetectorElement) || this.callback != ((HandwritingDetectorElement)arg5).callback) {
            v0 = 0;
        }
        else {
        }

        return v2 | v0;
    }

    public int hashCode() {
        return this.callback.hashCode() * 0x1F;
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("handwritingDetector");
        arg2.getProperties().set("callback", this.callback);
    }

    public void update(HandwritingDetectorNode arg1) {
        arg1.setCallback(this.callback);
    }

    public void update(Node arg1) {
        this.update(((HandwritingDetectorNode)arg1));
    }
}

