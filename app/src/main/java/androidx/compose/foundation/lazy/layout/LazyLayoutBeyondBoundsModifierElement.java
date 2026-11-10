package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u0015\u001A\u00020\u0002H\u0016J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0002H\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0013\u0010\u001B\u001A\u00020\b2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0002J\f\u0010\u001E\u001A\u00020\u0017*\u00020\u001FH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsProviderModifierNode;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/foundation/gestures/Orientation;)V", "getState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "getBeyondBoundsInfo", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getReverseLayout", "()Z", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "create", "update", "", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyLayoutBeyondBoundsModifierElement extends ModifierNodeElement {
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final LazyLayoutBeyondBoundsState state;

    public LazyLayoutBeyondBoundsModifierElement(LazyLayoutBeyondBoundsState arg1, LazyLayoutBeyondBoundsInfo arg2, boolean arg3, Orientation arg4) {
        super();
        this.state = arg1;
        this.beyondBoundsInfo = arg2;
        this.reverseLayout = arg3;
        this.orientation = arg4;
    }

    public LazyLayoutBeyondBoundsProviderModifierNode create() {
        return new LazyLayoutBeyondBoundsProviderModifierNode(this.state, this.beyondBoundsInfo, this.reverseLayout, this.orientation);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((LazyLayoutBeyondBoundsModifierElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof LazyLayoutBeyondBoundsModifierElement)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((LazyLayoutBeyondBoundsModifierElement)arg5).state)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.beyondBoundsInfo, ((LazyLayoutBeyondBoundsModifierElement)arg5).beyondBoundsInfo)) {
            return 0;
        }

        if(this.reverseLayout != ((LazyLayoutBeyondBoundsModifierElement)arg5).reverseLayout) {
            return 0;
        }

        if(this.orientation != ((LazyLayoutBeyondBoundsModifierElement)arg5).orientation) {
            return 0;
        }

        return 1;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final LazyLayoutBeyondBoundsState getState() {
        return this.state;
    }

    public int hashCode() {
        return ((this.state.hashCode() * 0x1F + this.beyondBoundsInfo.hashCode()) * 0x1F + Boolean.hashCode(this.reverseLayout)) * 0x1F + this.orientation.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(LazyLayoutBeyondBoundsProviderModifierNode arg4) {
        arg4.update(this.state, this.beyondBoundsInfo, this.reverseLayout, this.orientation);
    }

    public void update(Node arg1) {
        this.update(((LazyLayoutBeyondBoundsProviderModifierNode)arg1));
    }
}

