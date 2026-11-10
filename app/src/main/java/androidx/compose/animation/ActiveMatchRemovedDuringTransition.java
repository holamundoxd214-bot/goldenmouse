package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AH\u0016J\u0010\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u0005H\u0016J\b\u0010\u001E\u001A\u00020\u0018H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR+\u0010\u0004\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u00058V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001F"}, d2={"Landroidx/compose/animation/ActiveMatchRemovedDuringTransition;", "Landroidx/compose/animation/MatchIsOrHasBeenConfigured;", "targetData", "Landroidx/compose/animation/TargetData;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/animation/TargetData;Landroidx/compose/ui/geometry/Rect;)V", "getTargetData", "()Landroidx/compose/animation/TargetData;", "<set-?>", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBounds$delegate", "Landroidx/compose/runtime/MutableState;", "alternativeTargetConfigured", "", "getAlternativeTargetConfigured", "()Z", "setAlternativeTargetConfigured", "(Z)V", "onMatchFound", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "previousTargetBoundsProvider", "Landroidx/compose/animation/BoundsProvider;", "updateBounds", "", "bounds", "onVisibleContentRemovedDuringTransition", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActiveMatchRemovedDuringTransition extends MatchIsOrHasBeenConfigured {
    public static final int $stable = 8;
    private boolean alternativeTargetConfigured;
    private final MutableState currentBounds$delegate;
    private final TargetData targetData;

    static {
    }

    public ActiveMatchRemovedDuringTransition(TargetData arg2, Rect arg3) {
        super();
        this.targetData = arg2;
        this.currentBounds$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
    }

    public final boolean getAlternativeTargetConfigured() {
        return this.alternativeTargetConfigured;
    }

    public Rect getCurrentBounds() {
        return this.currentBounds$delegate.getValue();
    }

    public TargetData getTargetData() {
        return this.targetData;
    }

    public State onMatchFound(BoundsProvider arg3) {
        return new ActiveMatchFoundConfigPending(arg3, this.getTargetData(), this.getCurrentBounds());
    }

    public State onVisibleContentRemovedDuringTransition() {
        return this;
    }

    public final void setAlternativeTargetConfigured(boolean arg1) {
        this.alternativeTargetConfigured = arg1;
    }

    private void setCurrentBounds(Rect arg1) {
        this.currentBounds$delegate.setValue(arg1);
    }

    public void updateBounds(Rect arg1) {
        this.setCurrentBounds(arg1);
    }
}

