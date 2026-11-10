package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AX\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\'\u0010\b\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\t¢\u0006\u0002\b\f¢\u0006\u0002\u0010\r\u001A\u001C\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000F\u001A\u0010\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u0001*\u00020\u0011\u001A\u0018\u0010\u0012\u001A\u00020\u0010*\u00020\u00112\n\u0010\u0000\u001A\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001A\u001C\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000F\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014\u001A\u001E\u0010\u0015\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2={"future", "Ljava/util/concurrent/CompletableFuture;", "T", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "asCompletableFuture", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/Job;", "setupCancellation", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class FutureKt {
    public static final CompletableFuture asCompletableFuture(Deferred arg2) {
        CompletableFuture v0 = new CompletableFuture();
        FutureKt.setupCancellation(arg2, v0);
        arg2.invokeOnCompletion(new FutureKt$$ExternalSyntheticLambda0(v0, arg2));
        return v0;
    }

    public static final CompletableFuture asCompletableFuture(Job arg2) {
        CompletableFuture v0 = new CompletableFuture();
        FutureKt.setupCancellation(arg2, v0);
        arg2.invokeOnCompletion(new FutureKt$$ExternalSyntheticLambda3(v0));
        return v0;
    }

    static final Unit asCompletableFuture$lambda$1(CompletableFuture arg0, Deferred arg1, Throwable arg2) {
        try {
            arg0.complete(arg1.getCompleted());
        }
        catch(Throwable v1) {
            arg0.completeExceptionally(v1);
        }

        return Unit.INSTANCE;
    }

    static final Unit asCompletableFuture$lambda$2(CompletableFuture arg0, Throwable arg1) {
        if(arg1 == null) {
            arg0.complete(Unit.INSTANCE);
        }
        else {
            arg0.completeExceptionally(arg1);
        }

        return Unit.INSTANCE;
    }

    public static final Deferred asDeferred(CompletionStage arg6) {
        CompletableFuture v0 = arg6.toCompletableFuture();
        Job v3 = null;
        if(v0.isDone()) {
            try {
                return CompletableDeferredKt.CompletableDeferred(v0.get());
            }
            catch(Throwable v6) {
                Throwable v0_1 = (v6 instanceof ExecutionException) ? v6 : ((Throwable)v3);
                if(v0_1 != null) {
                    v0_1 = ((ExecutionException)v0_1).getCause();
                    if(v0_1 == null) {
                    }
                    else {
                        v6 = v0_1;
                    }
                }

                CompletableDeferred v0_2 = CompletableDeferredKt.CompletableDeferred$default(v3, 1, v3);
                v0_2.completeExceptionally(v6);
                return ((Deferred)v0_2);
            }
        }

        CompletableDeferred v1 = CompletableDeferredKt.CompletableDeferred$default(v3, 1, v3);
        arg6.handle(new FutureKt$$ExternalSyntheticLambda2(new FutureKt$$ExternalSyntheticLambda1(v1)));
        JobKt.invokeOnCompletion$default(v1, false, new CancelFutureOnCompletion(((Future)v0)), 1, v3);
        return ((Deferred)v1);
    }

    static final Object asDeferred$lambda$5(CompletableDeferred arg0, Object arg1, Throwable arg2) {
        if(arg2 == null) {
            try {
                boolean v0_1 = arg0.complete(arg1);
                goto label_14;
            label_3:
                Throwable v1 = (arg2 instanceof CompletionException) ? arg2 : null;
                if(v1 != null) {
                    v1 = ((CompletionException)v1).getCause();
                    if(v1 == null) {
                    }
                    else {
                        arg2 = v1;
                    }
                }

                v0_1 = arg0.completeExceptionally(arg2);
            label_14:
                return Boolean.valueOf(v0_1);
            }
            catch(Throwable v0) {
                CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, v0);
                return Unit.INSTANCE;
            }
        }
        else {
            goto label_3;
        }

        goto label_14;
    }

    static final Object asDeferred$lambda$6(Function2 arg0, Object arg1, Throwable arg2) {
        return arg0.invoke(arg1, arg2);
    }

    public static final Object await(CompletionStage arg5, Continuation arg6) {
        ExecutionException v6_1;
        CompletableFuture v0 = arg5.toCompletableFuture();
        if(v0.isDone()) {
            try {
                return v0.get();
            }
            catch(ExecutionException v5) {
                Throwable v6 = v5.getCause();
                if(v6 == null) {
                    v6_1 = v5;
                }

                throw ((Throwable)v6_1);
            }
        }

        CancellableContinuationImpl v1 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg6), 1);
        v1.initCancellability();
        ContinuationHandler v3 = new ContinuationHandler(v1);
        arg5.handle(v3);
        v1.invokeOnCancellation(new FutureKt$await$2$1(v0, v3));
        Object v5_1 = v1.getResult();
        if(v5_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg6);
        }

        return v5_1;
    }

    public static final CompletableFuture future(CoroutineScope arg1, CoroutineContext arg2, CoroutineStart arg3, Function2 arg4) {
        if(!arg3.isLazy()) {
            CoroutineContext v1 = CoroutineContextKt.newCoroutineContext(arg1, arg2);
            CompletableFuture v2 = new CompletableFuture();
            CompletableFutureCoroutine v0 = new CompletableFutureCoroutine(v1, v2);
            v2.handle(v0);
            v0.start(arg3, v0, arg4);
            return v2;
        }

        throw new IllegalArgumentException(arg3 + " start is not supported".toString());
    }

    public static CompletableFuture future$default(CoroutineScope arg0, CoroutineContext arg1, CoroutineStart arg2, Function2 arg3, int arg4, Object arg5) {
        EmptyCoroutineContext v1;
        if((arg4 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            arg2 = CoroutineStart.DEFAULT;
        }

        return FutureKt.future(arg0, ((CoroutineContext)v1), arg2, arg3);
    }

    private static final void setupCancellation(Job arg1, CompletableFuture arg2) {
        arg2.handle(new FutureKt$$ExternalSyntheticLambda4(new FutureKt$setupCancellation$1(arg1)));
    }

    static final Unit setupCancellation$lambda$3(Function2 arg0, Object arg1, Throwable arg2) {
        return arg0.invoke(arg1, arg2);
    }
}

