package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1={"\u0000&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\u001A5\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001F\b\u0004\u0010\u0002\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0081H¢\u0006\u0002\u0010\u0007\u001A5\u0010\b\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001F\b\u0004\u0010\u0002\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0081H¢\u0006\u0002\u0010\u0007\u001A%\u0010\t\u001A\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000B2\u0006\u0010\f\u001A\u0002H\nH\u0002¢\u0006\u0002\u0010\r\u001A\u0018\u0010\u000E\u001A\u00020\u0005*\u0006\u0012\u0002\b\u00030\u000B2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002¨\u0006\u0011"}, d2={"selectOld", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUnbiasedOld", "resumeUndispatched", "T", "Lkotlinx/coroutines/CancellableContinuation;", "result", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SelectOldKt {
    public static final void access$resumeUndispatched(CancellableContinuation arg0, Object arg1) {
        SelectOldKt.resumeUndispatched(arg0, arg1);
    }

    public static final void access$resumeUndispatchedWithException(CancellableContinuation arg0, Throwable arg1) {
        SelectOldKt.resumeUndispatchedWithException(arg0, arg1);
    }

    private static final void resumeUndispatched(CancellableContinuation arg2, Object arg3) {
        Element v0 = arg2.getContext().get(CoroutineDispatcher.Key);
        if(v0 != null) {
            arg2.resumeUndispatched(((CoroutineDispatcher)v0), arg3);
            return;
        }

        ((Continuation)arg2).resumeWith(Result.constructor-impl(arg3));
    }

    private static final void resumeUndispatchedWithException(CancellableContinuation arg2, Throwable arg3) {
        Element v0 = arg2.getContext().get(CoroutineDispatcher.Key);
        if(v0 != null) {
            arg2.resumeUndispatchedWithException(((CoroutineDispatcher)v0), arg3);
            return;
        }

        ((Continuation)arg2).resumeWith(Result.constructor-impl(ResultKt.createFailure(arg3)));
    }

    public static final Object selectOld(Function1 arg1, Continuation arg2) {
        SelectBuilderImpl v0 = new SelectBuilderImpl(arg2);
        try {
            arg1.invoke(v0);
        }
        catch(Throwable v1) {
            v0.handleBuilderException(v1);
        }

        Object v1_1 = v0.getResult();
        if(v1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg2);
        }

        return v1_1;
    }

    private static final Object selectOld$$forInline(Function1 arg1, Continuation arg2) {
        SelectBuilderImpl v0 = new SelectBuilderImpl(arg2);
        try {
            arg1.invoke(v0);
        }
        catch(Throwable v1) {
            v0.handleBuilderException(v1);
        }

        Object v1_1 = v0.getResult();
        if(v1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg2);
        }

        return v1_1;
    }

    public static final Object selectUnbiasedOld(Function1 arg1, Continuation arg2) {
        UnbiasedSelectBuilderImpl v0 = new UnbiasedSelectBuilderImpl(arg2);
        try {
            arg1.invoke(v0);
        }
        catch(Throwable v1) {
            v0.handleBuilderException(v1);
        }

        Object v1_1 = v0.initSelectResult();
        if(v1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg2);
        }

        return v1_1;
    }

    private static final Object selectUnbiasedOld$$forInline(Function1 arg1, Continuation arg2) {
        UnbiasedSelectBuilderImpl v0 = new UnbiasedSelectBuilderImpl(arg2);
        try {
            arg1.invoke(v0);
        }
        catch(Throwable v1) {
            v0.handleBuilderException(v1);
        }

        Object v1_1 = v0.initSelectResult();
        if(v1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg2);
        }

        return v1_1;
    }
}

