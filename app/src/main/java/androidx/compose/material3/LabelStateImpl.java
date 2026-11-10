package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0096@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001A\u00020\rH\u0016J\b\u0010\u0012\u001A\u00020\rH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0007R\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/compose/material3/LabelStateImpl;", "Landroidx/compose/material3/TooltipState;", "isVisible", "", "isPersistent", "<init>", "(ZZ)V", "()Z", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "show", "", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "onDispose", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class LabelStateImpl implements TooltipState {
    private final boolean isPersistent;
    private final boolean isVisible;
    private final MutableTransitionState transition;

    public LabelStateImpl(boolean arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(true, true);
    }

    public LabelStateImpl() {
        this(false, false, 3, null);
    }

    public LabelStateImpl(boolean arg1, boolean arg2) {
        super();
        this.isVisible = arg1;
        this.isPersistent = arg2;
        this.transition = new MutableTransitionState(Boolean.valueOf(false));
    }

    public void dismiss() {
    }

    public MutableTransitionState getTransition() {
        return this.transition;
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void onDispose() {
    }

    public Object show(MutatePriority arg1, Continuation arg2) {
        return Unit.INSTANCE;
    }
}

