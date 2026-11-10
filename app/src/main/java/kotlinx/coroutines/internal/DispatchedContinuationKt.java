package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;

@Metadata(d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A%\u0010\u0003\u001A\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\n\u0010\b\u001A\u00060\tj\u0002`\nH\u0000¢\u0006\u0002\u0010\u000B\u001A\u0014\u0010\f\u001A\u00020\r*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\u001A+\u0010\u000E\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u000F*\b\u0012\u0004\u0012\u0002H\u000F0\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001A\u0012\u0010\u0014\u001A\u00020\r*\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0000\u001A;\u0010\u0016\u001A\u00020\r*\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\r2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00040\u001DH\u0082\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED", "safeDispatch", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Lkotlin/coroutines/CoroutineContext;", "runnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "safeIsDispatchNeeded", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "executeUnconfined", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DispatchedContinuationKt {
    public static final Symbol REUSABLE_CLAIMED;
    private static final Symbol UNDEFINED;

    static {
        DispatchedContinuationKt.UNDEFINED = new Symbol("UNDEFINED");
        DispatchedContinuationKt.REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    }

    public static final Symbol access$getUNDEFINED$p() {
        return DispatchedContinuationKt.UNDEFINED;
    }

    private static final boolean executeUnconfined(DispatchedContinuation arg3, Object arg4, int arg5, boolean arg6, Function0 arg7) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg5 != -1) {
            }
            else {
                throw new AssertionError();
            }
        }

        EventLoop v0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if((arg6) && (v0.isUnconfinedQueueEmpty())) {
            return 0;
        }

        if(v0.isUnconfinedLoopActive()) {
            arg3._state = arg4;
            arg3.resumeMode = arg5;
            v0.dispatchUnconfined(((DispatchedTask)arg3));
            return 1;
        }

        v0.incrementUseCount(true);
        try {
            arg7.invoke();
            do {
                if(v0.processUnconfinedEvent()) {
                    continue;
                }

                break;
            }
            while(true);
        }
        catch(Throwable v4) {
            goto label_28;
        }

        goto label_29;
        try {
        label_28:
            ((DispatchedTask)arg3).handleFatalException$kotlinx_coroutines_core(v4);
        }
        catch(Throwable v3) {
            v0.decrementUseCount(true);
            throw v3;
        }

    label_29:
        v0.decrementUseCount(true);
        return 0;
    }

    static boolean executeUnconfined$default(DispatchedContinuation arg1, Object arg2, int arg3, boolean arg4, Function0 arg5, int arg6, Object arg7) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg3 != -1) {
            }
            else {
                throw new AssertionError();
            }
        }

        EventLoop v6 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(0 != 0 && (v6.isUnconfinedQueueEmpty())) {
            return 0;
        }

        if(v6.isUnconfinedLoopActive()) {
            arg1._state = arg2;
            arg1.resumeMode = arg3;
            v6.dispatchUnconfined(((DispatchedTask)arg1));
            return 1;
        }

        v6.incrementUseCount(true);
        try {
            arg5.invoke();
            do {
                if(v6.processUnconfinedEvent()) {
                    continue;
                }

                break;
            }
            while(true);
        }
        catch(Throwable v2) {
            goto label_31;
        }

        goto label_32;
        try {
        label_31:
            ((DispatchedTask)arg1).handleFatalException$kotlinx_coroutines_core(v2);
        }
        catch(Throwable v1) {
            v6.decrementUseCount(true);
            throw v1;
        }

    label_32:
        v6.decrementUseCount(true);
        return 0;
    }

    public static final void resumeCancellableWith(Continuation arg7, Object arg8) {
        UndispatchedCoroutine v0_2;
        CoroutineContext v5;
        Object v4_1;
        if((arg7 instanceof DispatchedContinuation)) {
            Object v0 = CompletionStateKt.toState(arg8);
            if(DispatchedContinuationKt.safeIsDispatchNeeded(((DispatchedContinuation)arg7).dispatcher, ((DispatchedContinuation)arg7).getContext())) {
                ((DispatchedContinuation)arg7)._state = v0;
                ((DispatchedContinuation)arg7).resumeMode = 1;
                DispatchedContinuationKt.safeDispatch(((DispatchedContinuation)arg7).dispatcher, ((DispatchedContinuation)arg7).getContext(), ((Runnable)arg7));
                return;
            }

            DebugKt.getASSERTIONS_ENABLED();
            EventLoop v1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            if(v1.isUnconfinedLoopActive()) {
                ((DispatchedContinuation)arg7)._state = v0;
                ((DispatchedContinuation)arg7).resumeMode = 1;
                v1.dispatchUnconfined(((DispatchedTask)arg7));
                return;
            }

            Continuation v3 = arg7;
            v1.incrementUseCount(true);
            try {
                Element v4 = ((DispatchedContinuation)arg7).getContext().get(Job.Key);
                if(v4 == null || (((Job)v4).isActive())) {
                    Continuation v0_1 = ((DispatchedContinuation)arg7).continuation;
                    v4_1 = ((DispatchedContinuation)arg7).countOrElement;
                    v5 = v0_1.getContext();
                    v4_1 = ThreadContextKt.updateThreadContext(v5, v4_1);
                    if(v4_1 != ThreadContextKt.NO_THREAD_ELEMENTS) {
                        v0_2 = CoroutineContextKt.updateUndispatchedCompletion(v0_1, v5, v4_1);
                    }
                    else {
                        goto label_47;
                    }

                    goto label_48;
                }
                else {
                    CancellationException v8 = ((Job)v4).getCancellationException();
                    ((DispatchedContinuation)arg7).cancelCompletedResult$kotlinx_coroutines_core(v0, v8);
                    arg7.resumeWith(Result.constructor-impl(ResultKt.createFailure(((Throwable)v8))));
                }

                goto label_55;
            }
            catch(Throwable v7) {
                goto label_65;
            }

        label_47:
            v0_2 = null;
            try {
            label_48:
                ((DispatchedContinuation)arg7).continuation.resumeWith(arg8);
                if(v0_2 == null) {
                    goto label_54;
                }

                goto label_52;
            }
            catch(Throwable v7) {
                try {
                    if(v0_2 == null || (v0_2.clearThreadContext())) {
                        ThreadContextKt.restoreThreadContext(v5, v4_1);
                    }

                    throw v7;
                label_52:
                    if(!v0_2.clearThreadContext()) {
                        goto label_55;
                    }

                label_54:
                    ThreadContextKt.restoreThreadContext(v5, v4_1);
                    do {
                    label_55:
                    }
                    while(v1.processUnconfinedEvent());
                }
                catch(Throwable v7) {
                    try {
                    label_65:
                        ((DispatchedTask)v3).handleFatalException$kotlinx_coroutines_core(v7);
                    }
                    catch(Throwable v7) {
                        v1.decrementUseCount(true);
                        throw v7;
                    }
                }
            }

            v1.decrementUseCount(true);
            return;
        }

        arg7.resumeWith(arg8);
    }

    public static final void safeDispatch(CoroutineDispatcher arg1, CoroutineContext arg2, Runnable arg3) {
        try {
            arg1.dispatch(arg2, arg3);
            return;
        }
        catch(Throwable v3) {
            throw new DispatchException(v3, arg1, arg2);
        }
    }

    public static final boolean safeIsDispatchNeeded(CoroutineDispatcher arg2, CoroutineContext arg3) {
        boolean v2;
        try {
            v2 = arg2.isDispatchNeeded(arg3);
            return v2;
        }
        catch(Throwable v0) {
            throw new DispatchException(v0, ((CoroutineDispatcher)v2), arg3);
        }
    }

    public static final boolean yieldUndispatched(DispatchedContinuation arg5) {
        Unit v0 = Unit.INSTANCE;
        DebugKt.getASSERTIONS_ENABLED();
        EventLoop v1 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        boolean v3 = false;
        if(v1.isUnconfinedQueueEmpty()) {
            return 0;
        }

        if(v1.isUnconfinedLoopActive()) {
            arg5._state = v0;
            arg5.resumeMode = 1;
            v1.dispatchUnconfined(((DispatchedTask)arg5));
            return true;
        }

        DispatchedContinuation v0_1 = arg5;
        v1.incrementUseCount(true);
        try {
            arg5.run();
            do {
                if(v1.processUnconfinedEvent()) {
                    continue;
                }

                break;
            }
            while(true);
        }
        catch(Throwable v5) {
            goto label_23;
        }

        goto label_24;
        try {
        label_23:
            ((DispatchedTask)v0_1).handleFatalException$kotlinx_coroutines_core(v5);
        }
        catch(Throwable v5) {
            v1.decrementUseCount(true);
            throw v5;
        }

    label_24:
        v1.decrementUseCount(true);
        return v3;
    }
}

