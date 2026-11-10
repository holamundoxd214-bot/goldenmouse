package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BW\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\u0006\u0010\u0010\u001A\u00020\b\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001A\u00020\u0002H\u0016J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0002H\u0016J\f\u0010\u0019\u001A\u00020\u0017*\u00020\u001AH\u0016J\u0013\u0010\u001B\u001A\u00020\b2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\b\u0010\u001E\u001A\u00020\u001FH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/foundation/ScrollableAreaElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/ScrollableAreaNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseScrolling", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "useLocalOverscrollFactory", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;ZLandroidx/compose/foundation/OverscrollEffect;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class ScrollableAreaElement extends ModifierNodeElement {
    private final BringIntoViewSpec bringIntoViewSpec;
    private final boolean enabled;
    private final FlingBehavior flingBehavior;
    private final MutableInteractionSource interactionSource;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseScrolling;
    private final ScrollableState state;
    private final boolean useLocalOverscrollFactory;

    public ScrollableAreaElement(ScrollableState arg1, Orientation arg2, boolean arg3, boolean arg4, FlingBehavior arg5, MutableInteractionSource arg6, BringIntoViewSpec arg7, boolean arg8, OverscrollEffect arg9) {
        super();
        this.state = arg1;
        this.orientation = arg2;
        this.enabled = arg3;
        this.reverseScrolling = arg4;
        this.flingBehavior = arg5;
        this.interactionSource = arg6;
        this.bringIntoViewSpec = arg7;
        this.useLocalOverscrollFactory = arg8;
        this.overscrollEffect = arg9;
    }

    public ScrollableAreaNode create() {
        return new ScrollableAreaNode(this.state, this.orientation, this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec, this.useLocalOverscrollFactory, this.overscrollEffect);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((ScrollableAreaElement)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(!Intrinsics.areEqual(this.state, ((ScrollableAreaElement)arg5).state)) {
                return 0;
            }
            else if(this.orientation != ((ScrollableAreaElement)arg5).orientation) {
                return 0;
            }
            else if(this.enabled != ((ScrollableAreaElement)arg5).enabled) {
                return 0;
            }
            else if(this.reverseScrolling != ((ScrollableAreaElement)arg5).reverseScrolling) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.flingBehavior, ((ScrollableAreaElement)arg5).flingBehavior)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.interactionSource, ((ScrollableAreaElement)arg5).interactionSource)) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.bringIntoViewSpec, ((ScrollableAreaElement)arg5).bringIntoViewSpec)) {
                return 0;
            }
            else if(this.useLocalOverscrollFactory != ((ScrollableAreaElement)arg5).useLocalOverscrollFactory) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.overscrollEffect, ((ScrollableAreaElement)arg5).overscrollEffect)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public int hashCode() {
        int v0 = (((this.state.hashCode() * 0x1F + this.orientation.hashCode()) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F + Boolean.hashCode(this.reverseScrolling)) * 0x1F;
        FlingBehavior v1 = this.flingBehavior;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        MutableInteractionSource v1_2 = this.interactionSource;
        v1_1 = v1_2 != null ? v1_2.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        BringIntoViewSpec v1_3 = this.bringIntoViewSpec;
        v1_1 = v1_3 != null ? v1_3.hashCode() : 0;
        v0 = ((v0 + v1_1) * 0x1F + Boolean.hashCode(this.useLocalOverscrollFactory)) * 0x1F;
        OverscrollEffect v3 = this.overscrollEffect;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("scrollableArea");
        arg4.getProperties().set("state", this.state);
        arg4.getProperties().set("orientation", this.orientation);
        if(!this.useLocalOverscrollFactory) {
            arg4.getProperties().set("overscrollEffect", this.overscrollEffect);
        }

        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("reverseScrolling", Boolean.valueOf(this.reverseScrolling));
        arg4.getProperties().set("flingBehavior", this.flingBehavior);
        arg4.getProperties().set("interactionSource", this.interactionSource);
        arg4.getProperties().set("bringIntoViewSpec", this.bringIntoViewSpec);
    }

    public void update(ScrollableAreaNode arg11) {
        arg11.update(this.state, this.orientation, this.useLocalOverscrollFactory, this.overscrollEffect, this.enabled, this.reverseScrolling, this.flingBehavior, this.interactionSource, this.bringIntoViewSpec);
    }

    public void update(Node arg1) {
        this.update(((ScrollableAreaNode)arg1));
    }
}

