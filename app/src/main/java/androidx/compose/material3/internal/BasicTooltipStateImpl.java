package androidx.compose.material3.internal;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CancellableContinuation$DefaultImpls;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001AJ\b\u0010\u001B\u001A\u00020\u0016H\u0016J\b\u0010\u001C\u001A\u00020\u0016H\u0016R\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\tR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000B\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00038V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u000B\u0010\t\"\u0004\b\f\u0010\rR\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/material3/internal/BasicTooltipStateImpl;", "Landroidx/compose/material3/TooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "<init>", "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "()Z", "<set-?>", "isVisible", "setVisible", "(Z)V", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "job", "Lkotlinx/coroutines/CancellableContinuation;", "", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "onDispose", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class BasicTooltipStateImpl implements TooltipState {
    private final boolean isPersistent;
    private final MutableState isVisible$delegate;
    private CancellableContinuation job;
    private final MutatorMutex mutatorMutex;
    private final MutableTransitionState transition;

    public BasicTooltipStateImpl(boolean arg1, boolean arg2, MutatorMutex arg3) {
        super();
        this.isPersistent = arg2;
        this.mutatorMutex = arg3;
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arg1), null, 2, null);
        this.transition = new MutableTransitionState(Boolean.valueOf(false));
    }

    public static final void access$setJob$p(BasicTooltipStateImpl arg0, CancellableContinuation arg1) {
        arg0.job = arg1;
    }

    public void dismiss() {
        this.setVisible(false);
    }

    public MutableTransitionState getTransition() {
        return this.transition;
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public boolean isVisible() {
        return this.isVisible$delegate.getValue().booleanValue();
    }

    public void onDispose() {
        CancellableContinuation v2 = this.job;
        if(v2 != null) {
            DefaultImpls.cancel$default(v2, null, 1, null);
        }
    }

    public void setVisible(boolean arg1) {
        this.isVisible$delegate.setValue(Boolean.valueOf(arg1));
    }

    public Object show(MutatePriority arg5, Continuation arg6) {
        Object v4 = this.mutatorMutex.mutate(arg5, new BasicTooltipStateImpl$show$2(this, new BasicTooltipStateImpl$show$cancellableShow$1(this, null), null), arg6);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }
}

