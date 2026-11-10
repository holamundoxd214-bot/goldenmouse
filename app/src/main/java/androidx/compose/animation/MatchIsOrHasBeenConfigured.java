package androidx.compose.animation;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001A\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"Landroidx/compose/animation/MatchIsOrHasBeenConfigured;", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "<init>", "()V", "targetData", "Landroidx/compose/animation/TargetData;", "getTargetData", "()Landroidx/compose/animation/TargetData;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "matchIsOrHasBeenConfigured", "", "getMatchIsOrHasBeenConfigured", "()Z", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class MatchIsOrHasBeenConfigured extends State {
    public static final int $stable;

    static {
    }

    public MatchIsOrHasBeenConfigured() {
        super(null);
    }

    public abstract Rect getCurrentBounds();

    public boolean getMatchIsOrHasBeenConfigured() {
        return 1;
    }

    public abstract TargetData getTargetData();
}

