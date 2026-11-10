package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CancellableContinuation$DefaultImpls;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0012H\u0016J\b\u0010\u0018\u001A\u00020\u0012H\u0016R\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\tR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000B\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u00038V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u000B\u0010\t\"\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/BasicTooltipStateImpl;", "Landroidx/compose/foundation/BasicTooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "<init>", "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "()Z", "<set-?>", "isVisible", "setVisible", "(Z)V", "isVisible$delegate", "Landroidx/compose/runtime/MutableState;", "job", "Lkotlinx/coroutines/CancellableContinuation;", "", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismiss", "onDispose", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class BasicTooltipStateImpl implements BasicTooltipState {
    private final boolean isPersistent;
    private final MutableState isVisible$delegate;
    private CancellableContinuation job;
    private final MutatorMutex mutatorMutex;

    public BasicTooltipStateImpl(boolean arg1, boolean arg2, MutatorMutex arg3) {
        super();
        this.isPersistent = arg2;
        this.mutatorMutex = arg3;
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arg1), null, 2, null);
    }

    public static final void access$setJob$p(BasicTooltipStateImpl arg0, CancellableContinuation arg1) {
        arg0.job = arg1;
    }

    public void dismiss() {
        this.setVisible(false);
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

