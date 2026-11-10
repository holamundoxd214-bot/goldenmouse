package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001A \u0010\f\u001A\u00020\r\"\u0004\b\u0000\u0010\u000E*\b\u0012\u0004\u0012\u0002H\u000E0\u000F2\u0006\u0010\u0010\u001A\u00020\u0001H\u0000\u001A.\u0010\u0011\u001A\u00020\r\"\u0004\b\u0000\u0010\u000E*\b\u0012\u0004\u0012\u0002H\u000E0\u000F2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u000E0\u00132\u0006\u0010\u0014\u001A\u00020\tH\u0000\u001A\u0010\u0010\u0015\u001A\u00020\r*\u0006\u0012\u0002\b\u00030\u000FH\u0002\u001A\'\u0010\u0016\u001A\u00020\r*\u0006\u0012\u0002\b\u00030\u000F2\u0006\u0010\u0017\u001A\u00020\u00182\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\r0\u001AH\u0080\b\u001A\u0019\u0010\u001B\u001A\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u001C\u001A\u00020\u001DH\u0080\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001A\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\b\u001A\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\n\"\u0018\u0010\u000B\u001A\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\n¨\u0006\u001E"}, d2={"MODE_ATOMIC", "", "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", "", "(I)Z", "isReusableMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "resumeWithStackTrace", "exception", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DispatchedTaskKt {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    public static final void dispatch(DispatchedTask arg3, int arg4) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg4 != -1) {
            }
            else {
                throw new AssertionError();
            }
        }

        Continuation v0 = arg3.getDelegate$kotlinx_coroutines_core();
        boolean v1 = arg4 == 4 ? true : false;
        if(!v1 && ((v0 instanceof DispatchedContinuation)) && DispatchedTaskKt.isCancellableMode(arg4) == DispatchedTaskKt.isCancellableMode(arg3.resumeMode)) {
            CoroutineDispatcher v4 = ((DispatchedContinuation)v0).dispatcher;
            CoroutineContext v0_1 = ((DispatchedContinuation)v0).getContext();
            if(DispatchedContinuationKt.safeIsDispatchNeeded(v4, v0_1)) {
                DispatchedContinuationKt.safeDispatch(v4, v0_1, ((Runnable)arg3));
                return;
            }
            else {
                DispatchedTaskKt.resumeUnconfined(arg3);
                return;
            }
        }

        DispatchedTaskKt.resume(arg3, v0, v1);
    }

    public static void getMODE_CANCELLABLE$annotations() {
    }

    public static final boolean isCancellableMode(int arg2) {
        if(arg2 != 1) {
            if(arg2 == 2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final boolean isReusableMode(int arg1) {
        if(arg1 == 2) {
            return 1;
        }

        return 0;
    }

    public static final void resume(DispatchedTask arg3, Continuation arg4, boolean arg5) {
        Object v0 = arg3.takeState$kotlinx_coroutines_core();
        Throwable v1 = arg3.getExceptionalResult$kotlinx_coroutines_core(v0);
        Object v3 = v1 != null ? ResultKt.createFailure(v1) : arg3.getSuccessfulResult$kotlinx_coroutines_core(v0);
        v3 = Result.constructor-impl(v3);
        if(arg5) {
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            Continuation v5 = ((DispatchedContinuation)arg4).continuation;
            v0 = ((DispatchedContinuation)arg4).countOrElement;
            CoroutineContext v1_1 = v5.getContext();
            v0 = ThreadContextKt.updateThreadContext(v1_1, v0);
            UndispatchedCoroutine v5_1 = v0 != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(v5, v1_1, v0) : null;
            try {
                ((DispatchedContinuation)arg4).continuation.resumeWith(v3);
                if(v5_1 == null) {
                    goto label_29;
                }
            }
            catch(Throwable v3_1) {
                if(v5_1 == null || (v5_1.clearThreadContext())) {
                    ThreadContextKt.restoreThreadContext(v1_1, v0);
                }

                throw v3_1;
            }

            if(v5_1.clearThreadContext()) {
            }
            else {
                return;
            }

        label_29:
            ThreadContextKt.restoreThreadContext(v1_1, v0);
            return;
        }

        arg4.resumeWith(v3);
    }

    private static final void resumeUnconfined(DispatchedTask arg3) {
        EventLoop v0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if(v0.isUnconfinedLoopActive()) {
            v0.dispatchUnconfined(arg3);
            return;
        }

        v0.incrementUseCount(true);
        try {
            DispatchedTaskKt.resume(arg3, arg3.getDelegate$kotlinx_coroutines_core(), true);
            do {
                if(v0.processUnconfinedEvent()) {
                    continue;
                }

                break;
            }
            while(true);
        }
        catch(Throwable v2) {
            goto label_14;
        }

        goto label_15;
        try {
        label_14:
            arg3.handleFatalException$kotlinx_coroutines_core(v2);
        }
        catch(Throwable v3) {
            v0.decrementUseCount(true);
            throw v3;
        }

    label_15:
        v0.decrementUseCount(true);
    }

    public static final void resumeWithStackTrace(Continuation arg1, Throwable arg2) {
        if(DebugKt.getRECOVER_STACK_TRACES()) {
            if(!(arg1 instanceof CoroutineStackFrame)) {
            }
            else {
                arg2 = StackTraceRecoveryKt.access$recoverFromStackFrame(arg2, arg1);
            }
        }

        arg1.resumeWith(Result.constructor-impl(ResultKt.createFailure(arg2)));
    }

    public static final void runUnconfinedEventLoop(DispatchedTask arg1, EventLoop arg2, Function0 arg3) {
        arg2.incrementUseCount(true);
        try {
            arg3.invoke();
            do {
                if(arg2.processUnconfinedEvent()) {
                    continue;
                }

                break;
            }
            while(true);
        }
        catch(Throwable v3) {
            goto label_8;
        }

        arg2.decrementUseCount(true);
        return;
        try {
        label_8:
            arg1.handleFatalException$kotlinx_coroutines_core(v3);
        }
        catch(Throwable v1) {
            arg2.decrementUseCount(true);
            throw v1;
        }

        arg2.decrementUseCount(true);
    }
}

