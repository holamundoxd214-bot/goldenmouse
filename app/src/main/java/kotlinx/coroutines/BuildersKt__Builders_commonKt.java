package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001AL\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\'\u0010\u0007\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\b¢\u0006\u0002\b\f¢\u0006\u0002\u0010\r\u001AX\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00100\u000F\"\u0004\b\u0000\u0010\u0010*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\'\u0010\u0007\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\b¢\u0006\u0002\b\f¢\u0006\u0002\u0010\u0011\u001AR\u0010\u0012\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0003\u001A\u00020\u00042\'\u0010\u0007\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\b¢\u0006\u0002\b\fH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0013\u001AC\u0010\u0014\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u00020\u00152)\b\b\u0010\u0007\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\b¢\u0006\u0002\b\fH\u0086J¢\u0006\u0002\u0010\u0016\"\u000E\u0010\u0017\u001A\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0019\u001A\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001A\u001A\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"launch", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "async", "Lkotlinx/coroutines/Deferred;", "T", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "withContext", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UNDECIDED", "", "SUSPENDED", "RESUMED", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/BuildersKt") final class BuildersKt__Builders_commonKt {
    private static final int RESUMED = 2;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED;

    public static final Deferred async(CoroutineScope arg1, CoroutineContext arg2, CoroutineStart arg3, Function2 arg4) {
        LazyDeferredCoroutine v2;
        CoroutineContext v1 = CoroutineContextKt.newCoroutineContext(arg1, arg2);
        if(arg3.isLazy()) {
            v2 = new LazyDeferredCoroutine(v1, arg4);
        }
        else {
            DeferredCoroutine v2_1 = new DeferredCoroutine(v1, true);
        }

        ((DeferredCoroutine)v2).start(arg3, v2, arg4);
        return ((Deferred)v2);
    }

    public static Deferred async$default(CoroutineScope arg0, CoroutineContext arg1, CoroutineStart arg2, Function2 arg3, int arg4, Object arg5) {
        EmptyCoroutineContext v1;
        if((arg4 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            arg2 = CoroutineStart.DEFAULT;
        }

        return BuildersKt.async(arg0, ((CoroutineContext)v1), arg2, arg3);
    }

    public static final Object invoke(CoroutineDispatcher arg0, Function2 arg1, Continuation arg2) {
        return BuildersKt.withContext(((CoroutineContext)arg0), arg1, arg2);
    }

    private static final Object invoke$$forInline(CoroutineDispatcher arg0, Function2 arg1, Continuation arg2) {
        return BuildersKt.withContext(((CoroutineContext)arg0), arg1, arg2);
    }

    public static final Job launch(CoroutineScope arg1, CoroutineContext arg2, CoroutineStart arg3, Function2 arg4) {
        StandaloneCoroutine v2_1;
        CoroutineContext v1 = CoroutineContextKt.newCoroutineContext(arg1, arg2);
        if(arg3.isLazy()) {
            LazyStandaloneCoroutine v2 = new LazyStandaloneCoroutine(v1, arg4);
        }
        else {
            v2_1 = new StandaloneCoroutine(v1, true);
        }

        v2_1.start(arg3, v2_1, arg4);
        return ((Job)v2_1);
    }

    public static Job launch$default(CoroutineScope arg0, CoroutineContext arg1, CoroutineStart arg2, Function2 arg3, int arg4, Object arg5) {
        EmptyCoroutineContext v1;
        if((arg4 & 1) != 0) {
            v1 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            arg2 = CoroutineStart.DEFAULT;
        }

        return BuildersKt.launch(arg0, ((CoroutineContext)v1), arg2, arg3);
    }

    public static final Object withContext(CoroutineContext arg3, Function2 arg4, Continuation arg5) {
        Object v4_1;
        Object v3;
        CoroutineContext v0 = arg5.getContext();
        arg3 = CoroutineContextKt.newCoroutineContext(v0, arg3);
        JobKt.ensureActive(arg3);
        if(arg3 == v0) {
            ScopeCoroutine v0_1 = new ScopeCoroutine(arg3, arg5);
            v3 = UndispatchedKt.startUndispatchedOrReturn(v0_1, v0_1, arg4);
        }
        else if(Intrinsics.areEqual(arg3.get(ContinuationInterceptor.Key), v0.get(ContinuationInterceptor.Key))) {
            UndispatchedCoroutine v0_2 = new UndispatchedCoroutine(arg3, arg5);
            arg3 = v0_2.getContext();
            Object v1 = ThreadContextKt.updateThreadContext(arg3, null);
            try {
                v4_1 = UndispatchedKt.startUndispatchedOrReturn(v0_2, v0_2, arg4);
            }
            catch(Throwable v4) {
                ThreadContextKt.restoreThreadContext(arg3, v1);
                throw v4;
            }

            ThreadContextKt.restoreThreadContext(arg3, v1);
            v3 = v4_1;
        }
        else {
            DispatchedCoroutine v0_3 = new DispatchedCoroutine(arg3, arg5);
            CancellableKt.startCoroutineCancellable(arg4, v0_3, v0_3);
            v3 = v0_3.getResult$kotlinx_coroutines_core();
        }

        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg5);
        }

        return v3;
    }
}

