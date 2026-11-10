package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002Bg\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012H\u0010\u0006\u001AD\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\u0004\u0012\u00028\u00000\u000E0\u0007\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000E\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0015\u001A\u00020\u00162\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\u0096\u0002J\b\u0010\u001C\u001A\u00020\u001DH\u0016J\f\u0010\u001E\u001A\u00020\u0016*\u00020\u001FH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RP\u0010\u0006\u001AD\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\u0004\u0012\u00028\u00000\u000E0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/material3/internal/DraggableAnchorsElement;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/internal/DraggableAnchorsNode;", "state", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "anchors", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/material3/internal/AnchoredDraggableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/gestures/Orientation;)V", "create", "update", "", "node", "equals", "", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class DraggableAnchorsElement extends ModifierNodeElement {
    private final Function2 anchors;
    private final Orientation orientation;
    private final AnchoredDraggableState state;

    public DraggableAnchorsElement(AnchoredDraggableState arg1, Function2 arg2, Orientation arg3) {
        super();
        this.state = arg1;
        this.anchors = arg2;
        this.orientation = arg3;
    }

    public static final Function2 access$getAnchors$p(DraggableAnchorsElement arg0) {
        return arg0.anchors;
    }

    public static final Orientation access$getOrientation$p(DraggableAnchorsElement arg0) {
        return arg0.orientation;
    }

    public static final AnchoredDraggableState access$getState$p(DraggableAnchorsElement arg0) {
        return arg0.state;
    }

    public DraggableAnchorsNode create() {
        return new DraggableAnchorsNode(this.state, this.anchors, this.orientation);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((DraggableAnchorsElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DraggableAnchorsElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((DraggableAnchorsElement)arg5).state)) {
            return 0;
        }

        if(this.anchors != ((DraggableAnchorsElement)arg5).anchors) {
            return 0;
        }

        if(this.orientation != ((DraggableAnchorsElement)arg5).orientation) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        return (this.state.hashCode() * 0x1F + this.anchors.hashCode()) * 0x1F + this.orientation.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            new DraggableAnchorsElement$inspectableProperties$$inlined$debugInspectorInfo$1(this);
            return;
        }

        InspectableValueKt.getNoInspectorInfo();
    }

    public void update(DraggableAnchorsNode arg2) {
        arg2.setState(this.state);
        arg2.setAnchors(this.anchors);
        arg2.setOrientation(this.orientation);
    }

    public void update(Node arg1) {
        this.update(((DraggableAnchorsNode)arg1));
    }
}

