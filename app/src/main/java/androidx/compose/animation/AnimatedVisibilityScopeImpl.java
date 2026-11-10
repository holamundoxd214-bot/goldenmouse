package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "<init>", "(Landroidx/compose/animation/core/Transition;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "targetSize", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "getTargetSize$animation", "()Landroidx/compose/runtime/MutableState;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimatedVisibilityScopeImpl implements AnimatedVisibilityScope {
    public static final int $stable = 8;
    private final MutableState targetSize;
    private Transition transition;

    static {
    }

    public AnimatedVisibilityScopeImpl(Transition arg3) {
        super();
        this.transition = arg3;
        this.targetSize = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
    }

    public final MutableState getTargetSize$animation() {
        return this.targetSize;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public void setTransition(Transition arg1) {
        this.transition = arg1;
    }
}

