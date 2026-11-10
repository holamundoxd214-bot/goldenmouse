package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0019\u001A\u00020\u0002H\u0016J\u0010\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u0002H\u0016J\b\u0010\u001D\u001A\u00020\u001EH\u0016J\u0013\u0010\u001F\u001A\u00020\b2\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002J\f\u0010\"\u001A\u00020\u001B*\u00020#H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2={"Landroidx/compose/foundation/gestures/Scrollable2DElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/Scrollable2DNode;", "state", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getState", "()Landroidx/compose/foundation/gestures/Scrollable2DState;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getEnabled", "()Z", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Scrollable2DElement extends ModifierNodeElement {
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final OverscrollEffect overscrollEffect;
    private final Scrollable2DState state;

    public Scrollable2DElement(Scrollable2DState arg1, OverscrollEffect arg2, boolean arg3, FlingBehavior arg4, MutableInteractionSource arg5) {
        super();
        this.state = arg1;
        this.overscrollEffect = arg2;
        this.enabled = arg3;
        this.flingBehavior = arg4;
        this.interactionSource = arg5;
    }

    public Scrollable2DNode create() {
        return new Scrollable2DNode(this.state, this.overscrollEffect, this.flingBehavior, this.enabled, this.interactionSource);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((Scrollable2DElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Scrollable2DElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((Scrollable2DElement)arg5).state)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overscrollEffect, ((Scrollable2DElement)arg5).overscrollEffect)) {
            return 0;
        }

        if(this.enabled != ((Scrollable2DElement)arg5).enabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.flingBehavior, ((Scrollable2DElement)arg5).flingBehavior)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((Scrollable2DElement)arg5).interactionSource)) {
            return 0;
        }

        return 1;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final Scrollable2DState getState() {
        return this.state;
    }

    public int hashCode() {
        int v0 = this.state.hashCode() * 0x1F;
        OverscrollEffect v1 = this.overscrollEffect;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = ((v0 + v1_1) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F;
        FlingBehavior v1_2 = this.flingBehavior;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        MutableInteractionSource v3 = this.interactionSource;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("scrollable2D");
        arg4.getProperties().set("state", this.state);
        arg4.getProperties().set("overscrollEffect", this.overscrollEffect);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("flingBehavior", this.flingBehavior);
        arg4.getProperties().set("interactionSource", this.interactionSource);
    }

    public void update(Scrollable2DNode arg7) {
        arg7.update(this.state, this.overscrollEffect, this.enabled, this.flingBehavior, this.interactionSource);
    }

    public void update(Node arg1) {
        this.update(((Scrollable2DNode)arg1));
    }
}

