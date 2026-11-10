package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0016J\u0013\u0010\u0011\u001A\u00020\b2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\f\u0010\u0016\u001A\u00020\u000F*\u00020\u0017H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/gestures/TransformableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/TransformableNode;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "lockRotationOnZoomPan", "enabled", "<init>", "(Landroidx/compose/foundation/gestures/TransformableState;Lkotlin/jvm/functions/Function1;ZZ)V", "create", "update", "", "node", "equals", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TransformableElement extends ModifierNodeElement {
    private final Function1 canPan;
    private final boolean enabled;
    private final boolean lockRotationOnZoomPan;
    private final TransformableState state;

    public TransformableElement(TransformableState arg1, Function1 arg2, boolean arg3, boolean arg4) {
        super();
        this.state = arg1;
        this.canPan = arg2;
        this.lockRotationOnZoomPan = arg3;
        this.enabled = arg4;
    }

    public TransformableNode create() {
        return new TransformableNode(this.state, this.canPan, this.lockRotationOnZoomPan, this.enabled);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((TransformableElement)arg5))) {
            return 1;
        }

        if(arg5 == null) {
            return 0;
        }

        if(this.getClass() != arg5.getClass()) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((TransformableElement)arg5).state)) {
            return 0;
        }

        if(this.canPan != ((TransformableElement)arg5).canPan) {
            return 0;
        }

        if(this.lockRotationOnZoomPan != ((TransformableElement)arg5).lockRotationOnZoomPan) {
            return 0;
        }

        if(this.enabled != ((TransformableElement)arg5).enabled) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return ((this.state.hashCode() * 0x1F + this.canPan.hashCode()) * 0x1F + Boolean.hashCode(this.lockRotationOnZoomPan)) * 0x1F + Boolean.hashCode(this.enabled);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("transformable");
        arg4.getProperties().set("state", this.state);
        arg4.getProperties().set("canPan", this.canPan);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("lockRotationOnZoomPan", Boolean.valueOf(this.lockRotationOnZoomPan));
    }

    public void update(TransformableNode arg4) {
        arg4.update(this.state, this.canPan, this.lockRotationOnZoomPan, this.enabled);
    }

    public void update(Node arg1) {
        this.update(((TransformableNode)arg1));
    }
}

