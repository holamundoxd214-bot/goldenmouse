package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CancellableContinuation$DefaultImpls;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001A\u00020\u0011H\u0016J\b\u0010\u0017\u001A\u00020\u0011H\u0016R\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\tR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\tR\u0016\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/material3/TooltipStateImpl;", "Landroidx/compose/material3/TooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "<init>", "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "()Z", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "isVisible", "job", "Lkotlinx/coroutines/CancellableContinuation;", "", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "onDispose", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TooltipStateImpl implements TooltipState {
    private final boolean isPersistent;
    private CancellableContinuation job;
    private final MutatorMutex mutatorMutex;
    private final MutableTransitionState transition;

    public TooltipStateImpl(boolean arg1, boolean arg2, MutatorMutex arg3) {
        super();
        this.isPersistent = arg2;
        this.mutatorMutex = arg3;
        this.transition = new MutableTransitionState(Boolean.valueOf(arg1));
    }

    public static final void access$setJob$p(TooltipStateImpl arg0, CancellableContinuation arg1) {
        arg0.job = arg1;
    }

    public void dismiss() {
        this.getTransition().setTargetState(Boolean.valueOf(false));
        if(this.isPersistent()) {
            CancellableContinuation v2 = this.job;
            if(v2 != null) {
                DefaultImpls.cancel$default(v2, null, 1, null);
            }
        }
    }

    public MutableTransitionState getTransition() {
        return this.transition;
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public boolean isVisible() {
        if(!this.getTransition().getCurrentState().booleanValue()) {
            if(this.getTransition().getTargetState().booleanValue()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public void onDispose() {
        CancellableContinuation v2 = this.job;
        if(v2 != null) {
            DefaultImpls.cancel$default(v2, null, 1, null);
        }
    }

    public Object show(MutatePriority arg5, Continuation arg6) {
        Object v4 = this.mutatorMutex.mutate(arg5, new TooltipStateImpl$show$2(this, new TooltipStateImpl$show$cancellableShow$1(this, null), arg5, null), arg6);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }
}

