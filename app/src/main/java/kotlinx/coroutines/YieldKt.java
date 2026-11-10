package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A\u000E\u0010\u0000\u001A\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2={"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class YieldKt {
    public static final Object yield(Continuation arg4) {
        Object v0_2;
        Unit v0_1;
        CoroutineContext v0 = arg4.getContext();
        JobKt.ensureActive(v0);
        Continuation v1 = IntrinsicsKt.intercepted(arg4);
        if((v1 instanceof DispatchedContinuation)) {
        }
        else {
            v1 = null;
        }

        if(v1 == null) {
            v0_1 = Unit.INSTANCE;
        }
        else {
            if(DispatchedContinuationKt.safeIsDispatchNeeded(((DispatchedContinuation)v1).dispatcher, v0)) {
                ((DispatchedContinuation)v1).dispatchYield$kotlinx_coroutines_core(v0, Unit.INSTANCE);
            }
            else {
                YieldContext v2 = new YieldContext();
                ((DispatchedContinuation)v1).dispatchYield$kotlinx_coroutines_core(v0.plus(v2), Unit.INSTANCE);
                if(v2.dispatcherWasUnconfined) {
                    if(DispatchedContinuationKt.yieldUndispatched(((DispatchedContinuation)v1))) {
                        v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    }
                    else {
                        v0_1 = Unit.INSTANCE;
                    }

                    goto label_31;
                }
            }

            v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }

    label_31:
        if((((Unit)v0_2)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg4);
        }

        if((((Unit)v0_2)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0_2;
        }

        return Unit.INSTANCE;
    }
}

