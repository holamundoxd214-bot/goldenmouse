package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0005H\u0016J7\u0010\u001F\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020!2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020%H\u0016¢\u0006\u0004\b\'\u0010(J\b\u0010)\u001A\u00020\u001DH\u0016J\u0010\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020\u0007H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR+\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00058F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00078V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006-"}, d2={"Landroidx/compose/animation/ActiveMatchConfigured;", "Landroidx/compose/animation/MatchIsOrHasBeenConfigured;", "targetData", "Landroidx/compose/animation/TargetData;", "targetBoundsProvider", "Landroidx/compose/animation/BoundsProvider;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/animation/TargetData;Landroidx/compose/animation/BoundsProvider;Landroidx/compose/ui/geometry/Rect;)V", "getTargetData", "()Landroidx/compose/animation/TargetData;", "activeMatchFound", "", "getActiveMatchFound", "()Z", "<set-?>", "getTargetBoundsProvider", "()Landroidx/compose/animation/BoundsProvider;", "setTargetBoundsProvider", "(Landroidx/compose/animation/BoundsProvider;)V", "targetBoundsProvider$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBounds$delegate", "onMatchFound", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "previousTargetBoundsProvider", "configureActiveMatch", "sharedElement", "Landroidx/compose/animation/SharedElement;", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "configureActiveMatch-38uP1EE", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsProvider;JJJ)Landroidx/compose/animation/SharedTransitionStateMachine$State;", "onVisibleContentRemovedDuringTransition", "updateBounds", "", "bounds", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActiveMatchConfigured extends MatchIsOrHasBeenConfigured {
    public static final int $stable;
    private final MutableState currentBounds$delegate;
    private final MutableState targetBoundsProvider$delegate;
    private final TargetData targetData;

    static {
    }

    public ActiveMatchConfigured(TargetData arg2, BoundsProvider arg3, Rect arg4) {
        super();
        this.targetData = arg2;
        this.targetBoundsProvider$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
        this.currentBounds$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
    }

    public State configureActiveMatch-38uP1EE(SharedElement arg9, BoundsProvider arg10, long arg11, long arg13, long arg15) {
        SharedTransitionStateMachineKt.access$updateTargetData-BGTQxF0(this.getTargetData(), arg11, arg13, arg15, Intrinsics.areEqual(this.getTargetBoundsProvider(), arg10) ^ 1);
        this.setTargetBoundsProvider(arg10);
        return this;
    }

    public boolean getActiveMatchFound() {
        return 1;
    }

    public Rect getCurrentBounds() {
        return this.currentBounds$delegate.getValue();
    }

    public final BoundsProvider getTargetBoundsProvider() {
        return this.targetBoundsProvider$delegate.getValue();
    }

    public TargetData getTargetData() {
        return this.targetData;
    }

    public State onMatchFound(BoundsProvider arg1) {
        return this;
    }

    public State onVisibleContentRemovedDuringTransition() {
        Rect v0 = this.getTargetBoundsProvider().calculateAlternativeTargetBounds(RectKt.Rect-tz77jQw(Offset.plus-MK-Hz9U(this.getTargetData().getCurrentMfrOffset-F1C5BW0(), this.getTargetData().getTargetStructuralOffset-F1C5BW0()), this.getTargetData().getSize-NH-jbRc()));
        if(v0 == null) {
            return NoMatchFound.INSTANCE;
        }

        TargetData v0_1 = new TargetData(v0.getSize-NH-jbRc(), this.getTargetData().getInitialMfrOffset-F1C5BW0(), Offset.minus-MK-Hz9U(v0.getTopLeft-F1C5BW0(), this.getTargetData().getCurrentMfrOffset-F1C5BW0()), null);
        v0_1.setCurrentMfrOffset-k-4lQ0M(this.getTargetData().getCurrentMfrOffset-F1C5BW0());
        return new ActiveMatchRemovedDuringTransition(v0_1, this.getCurrentBounds());
    }

    private void setCurrentBounds(Rect arg1) {
        this.currentBounds$delegate.setValue(arg1);
    }

    public final void setTargetBoundsProvider(BoundsProvider arg1) {
        this.targetBoundsProvider$delegate.setValue(arg1);
    }

    public void updateBounds(Rect arg1) {
        this.setCurrentBounds(arg1);
    }
}

