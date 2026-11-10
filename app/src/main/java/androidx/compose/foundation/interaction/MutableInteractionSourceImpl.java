package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0006H\u0096@¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\u0006H\u0016R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/interaction/MutableInteractionSourceImpl;", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "()V", "interactions", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/compose/foundation/interaction/Interaction;", "getInteractions", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "emit", "", "interaction", "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MutableInteractionSourceImpl implements MutableInteractionSource {
    private final MutableSharedFlow interactions;

    public MutableInteractionSourceImpl() {
        super();
        this.interactions = SharedFlowKt.MutableSharedFlow$default(0, 16, BufferOverflow.DROP_OLDEST, 1, null);
    }

    public Object emit(Interaction arg1, Continuation arg2) {
        Object v0 = this.getInteractions().emit(arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public MutableSharedFlow getInteractions() {
        return this.interactions;
    }

    public Flow getInteractions() {
        return this.getInteractions();
    }

    public boolean tryEmit(Interaction arg1) {
        return this.getInteractions().tryEmit(arg1);
    }
}

