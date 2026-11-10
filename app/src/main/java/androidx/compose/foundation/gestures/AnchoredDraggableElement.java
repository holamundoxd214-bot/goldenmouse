package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B[\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000E\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0016\u001A\u00020\u00172\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0013\u0010\u001B\u001A\u00020\t2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\f\u0010\u001E\u001A\u00020\u0017*\u00020\u001FH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/foundation/gestures/AnchoredDraggableElement;", "T", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "<init>", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Ljava/lang/Boolean;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;)V", "Ljava/lang/Boolean;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnchoredDraggableElement extends ModifierNodeElement {
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final Boolean reverseDirection;
    private final Boolean startDragImmediately;
    private final AnchoredDraggableState state;

    public AnchoredDraggableElement(AnchoredDraggableState arg1, Orientation arg2, boolean arg3, Boolean arg4, MutableInteractionSource arg5, Boolean arg6, OverscrollEffect arg7, FlingBehavior arg8) {
        super();
        this.state = arg1;
        this.orientation = arg2;
        this.enabled = arg3;
        this.reverseDirection = arg4;
        this.interactionSource = arg5;
        this.startDragImmediately = arg6;
        this.overscrollEffect = arg7;
        this.flingBehavior = arg8;
    }

    public AnchoredDraggableElement(AnchoredDraggableState arg2, Orientation arg3, boolean arg4, Boolean arg5, MutableInteractionSource arg6, Boolean arg7, OverscrollEffect arg8, FlingBehavior arg9, int arg10, DefaultConstructorMarker arg11) {
        Boolean v0 = null;
        if((arg10 & 0x20) != 0) {
            arg7 = v0;
        }

        if((arg10 & 0x80) != 0) {
            arg9 = ((FlingBehavior)v0);
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public AnchoredDraggableNode create() {
        return new AnchoredDraggableNode(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.overscrollEffect, this.startDragImmediately, this.flingBehavior);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((AnchoredDraggableElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AnchoredDraggableElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((AnchoredDraggableElement)arg5).state)) {
            return 0;
        }

        if(this.orientation != ((AnchoredDraggableElement)arg5).orientation) {
            return 0;
        }

        if(this.enabled != ((AnchoredDraggableElement)arg5).enabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.reverseDirection, ((AnchoredDraggableElement)arg5).reverseDirection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((AnchoredDraggableElement)arg5).interactionSource)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.startDragImmediately, ((AnchoredDraggableElement)arg5).startDragImmediately)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overscrollEffect, ((AnchoredDraggableElement)arg5).overscrollEffect)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.flingBehavior, ((AnchoredDraggableElement)arg5).flingBehavior)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        int v0 = ((this.state.hashCode() * 0x1F + this.orientation.hashCode()) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F;
        Boolean v1 = this.reverseDirection;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        MutableInteractionSource v1_2 = this.interactionSource;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.startDragImmediately;
        v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        OverscrollEffect v1_3 = this.overscrollEffect;
        v1_1 = v1_3 != null ? v1_3.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        FlingBehavior v3 = this.flingBehavior;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("anchoredDraggable");
        arg4.getProperties().set("state", this.state);
        arg4.getProperties().set("orientation", this.orientation);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("reverseDirection", this.reverseDirection);
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("startDragImmediately", this.startDragImmediately);
        arg4.getProperties().set("overscrollEffect", this.overscrollEffect);
        arg4.getProperties().set("flingBehavior", this.flingBehavior);
    }

    public void update(AnchoredDraggableNode arg10) {
        arg10.update(this.state, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.overscrollEffect, this.startDragImmediately, this.flingBehavior);
    }

    public void update(Node arg1) {
        this.update(((AnchoredDraggableNode)arg1));
    }
}

