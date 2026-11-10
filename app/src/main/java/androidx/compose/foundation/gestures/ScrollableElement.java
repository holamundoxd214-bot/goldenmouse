package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BO\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010#\u001A\u00020\u0002H\u0016J\u0010\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\u0002H\u0016J\b\u0010\'\u001A\u00020(H\u0016J\u0013\u0010)\u001A\u00020\n2\b\u0010*\u001A\u0004\u0018\u00010+H\u0096\u0002J\f\u0010,\u001A\u00020%*\u00020-H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u000B\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001BR\u0013\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"¨\u0006."}, d2={"Landroidx/compose/foundation/gestures/ScrollableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/ScrollableNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "getState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getEnabled", "()Z", "getReverseDirection", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getBringIntoViewSpec", "()Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ScrollableElement extends ModifierNodeElement {
    private final BringIntoViewSpec bringIntoViewSpec;
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState state;

    public ScrollableElement(ScrollableState arg1, Orientation arg2, OverscrollEffect arg3, boolean arg4, boolean arg5, FlingBehavior arg6, MutableInteractionSource arg7, BringIntoViewSpec arg8) {
        super();
        this.state = arg1;
        this.orientation = arg2;
        this.overscrollEffect = arg3;
        this.enabled = arg4;
        this.reverseDirection = arg5;
        this.flingBehavior = arg6;
        this.interactionSource = arg7;
        this.bringIntoViewSpec = arg8;
    }

    public ScrollableNode create() {
        return new ScrollableNode(this.state, this.overscrollEffect, this.flingBehavior, this.orientation, this.enabled, this.reverseDirection, this.interactionSource, this.bringIntoViewSpec);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((ScrollableElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ScrollableElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((ScrollableElement)arg5).state)) {
            return 0;
        }

        if(this.orientation != ((ScrollableElement)arg5).orientation) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.overscrollEffect, ((ScrollableElement)arg5).overscrollEffect)) {
            return 0;
        }

        if(this.enabled != ((ScrollableElement)arg5).enabled) {
            return 0;
        }

        if(this.reverseDirection != ((ScrollableElement)arg5).reverseDirection) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.flingBehavior, ((ScrollableElement)arg5).flingBehavior)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.interactionSource, ((ScrollableElement)arg5).interactionSource)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.bringIntoViewSpec, ((ScrollableElement)arg5).bringIntoViewSpec)) {
            return 0;
        }

        return 1;
    }

    public final BringIntoViewSpec getBringIntoViewSpec() {
        return this.bringIntoViewSpec;
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

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final ScrollableState getState() {
        return this.state;
    }

    public int hashCode() {
        int v0 = (this.state.hashCode() * 0x1F + this.orientation.hashCode()) * 0x1F;
        OverscrollEffect v1 = this.overscrollEffect;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (((v0 + v1_1) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F + Boolean.hashCode(this.reverseDirection)) * 0x1F;
        FlingBehavior v1_2 = this.flingBehavior;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        MutableInteractionSource v1_3 = this.interactionSource;
        v1_1 = v1_3 != null ? v1_3.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        BringIntoViewSpec v3 = this.bringIntoViewSpec;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("scrollable");
        arg4.getProperties().set("orientation", this.orientation);
        arg4.getProperties().set("state", this.state);
        arg4.getProperties().set("overscrollEffect", this.overscrollEffect);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        arg4.getProperties().set("flingBehavior", this.flingBehavior);
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("bringIntoViewSpec", this.bringIntoViewSpec);
    }

    public void update(ScrollableNode arg10) {
        arg10.update(this.state, this.orientation, this.overscrollEffect, this.enabled, this.reverseDirection, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
    }

    public void update(Node arg1) {
        this.update(((ScrollableNode)arg1));
    }
}

