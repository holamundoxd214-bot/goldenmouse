package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuation;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A \u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A0\u0010\u0006\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001A\b\u0004\u0010\u0007\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0003\u0012\u0004\u0012\u00020\u00010\bH\u0086H¢\u0006\u0002\u0010\t\u001A0\u0010\n\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001A\b\u0004\u0010\u0007\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000B\u0012\u0004\u0012\u00020\u00010\bH\u0080H¢\u0006\u0002\u0010\t\u001A\"\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000B\"\u0004\b\u0000\u0010\u00022\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000EH\u0000\u001A\u0018\u0010\u000F\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0010\u001A\u00020\u0011H\u0007¨\u0006\u0012"}, d2={"invokeOnCancellation", "", "T", "Lkotlinx/coroutines/CancellableContinuation;", "handler", "Lkotlinx/coroutines/CancelHandler;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "Lkotlinx/coroutines/CancellableContinuationImpl;", "getOrCreateCancellableContinuation", "delegate", "Lkotlin/coroutines/Continuation;", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CancellableContinuationKt {
    public static final void disposeOnCancellation(CancellableContinuation arg1, DisposableHandle arg2) {
        CancellableContinuationKt.invokeOnCancellation(arg1, new DisposeOnCancel(arg2));
    }

    public static final CancellableContinuationImpl getOrCreateCancellableContinuation(Continuation arg2) {
        if(!(arg2 instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl(arg2, 1);
        }

        CancellableContinuationImpl v0 = arg2.claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if(v0 != null) {
            if(v0.resetStateReusable()) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                goto label_16;
            }

            return v0;
        }

    label_16:
        return new CancellableContinuationImpl(arg2, 2);
    }

    public static final void invokeOnCancellation(CancellableContinuation arg1, CancelHandler arg2) {
        if((arg1 instanceof CancellableContinuationImpl)) {
            ((CancellableContinuationImpl)arg1).invokeOnCancellationInternal$kotlinx_coroutines_core(arg2);
            return;
        }

        throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
    }

    public static final Object suspendCancellableCoroutine(Function1 arg3, Continuation arg4) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg4), 1);
        v0.initCancellability();
        arg3.invoke(v0);
        Object v3 = v0.getResult();
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg4);
        }

        return v3;
    }

    private static final Object suspendCancellableCoroutine$$forInline(Function1 arg3, Continuation arg4) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg4), 1);
        v0.initCancellability();
        arg3.invoke(v0);
        Object v3 = v0.getResult();
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg4);
        }

        return v3;
    }

    public static final Object suspendCancellableCoroutineReusable(Function1 arg1, Continuation arg2) {
        CancellableContinuationImpl v0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(arg2));
        try {
            arg1.invoke(v0);
        }
        catch(Throwable v1) {
            v0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw v1;
        }

        Object v1_1 = v0.getResult();
        if(v1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg2);
        }

        return v1_1;
    }

    private static final Object suspendCancellableCoroutineReusable$$forInline(Function1 arg1, Continuation arg2) {
        CancellableContinuationImpl v0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(arg2));
        try {
            arg1.invoke(v0);
        }
        catch(Throwable v1) {
            v0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw v1;
        }

        Object v1_1 = v0.getResult();
        if(v1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg2);
        }

        return v1_1;
    }
}

