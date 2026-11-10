package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0002H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\f\u0010\u0011\u001A\u00020\t*\u00020\u0012H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/foundation/HoverableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/HoverableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "create", "update", "", "node", "hashCode", "", "equals", "", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HoverableElement extends ModifierNodeElement {
    private final MutableInteractionSource interactionSource;

    public HoverableElement(MutableInteractionSource arg1) {
        super();
        this.interactionSource = arg1;
    }

    public HoverableNode create() {
        return new HoverableNode(this.interactionSource);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg4) {
        if(this == (((HoverableElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof HoverableElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(((HoverableElement)arg4).interactionSource, this.interactionSource)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return this.interactionSource.hashCode() * 0x1F;
    }

    public void inspectableProperties(InspectorInfo arg3) {
        arg3.setName("hoverable");
        arg3.getProperties().set("interactionSource", this.interactionSource);
        arg3.getProperties().set("enabled", Boolean.valueOf(true));
    }

    public void update(HoverableNode arg1) {
        arg1.updateInteractionSource(this.interactionSource);
    }

    public void update(Node arg1) {
        this.update(((HoverableNode)arg1));
    }
}

