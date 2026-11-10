package kotlinx.coroutines.intrinsics;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AO\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001A\u0002H\u00022\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0000¢\u0006\u0002\u0010\t\u001AV\u0010\n\u001A\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u000B2\u0006\u0010\u0007\u001A\u0002H\u00022\'\u0010\f\u001A#\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\rH\u0000¢\u0006\u0002\u0010\u000E\u001AV\u0010\u000F\u001A\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u000B2\u0006\u0010\u0007\u001A\u0002H\u00022\'\u0010\f\u001A#\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\rH\u0000¢\u0006\u0002\u0010\u000E\u001A^\u0010\u0010\u001A\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u000B2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0007\u001A\u0002H\u00022\'\u0010\f\u001A#\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\rH\u0002¢\u0006\u0002\u0010\u0013\u001A\u0018\u0010\u0014\u001A\u00020\u0012*\u0006\u0012\u0002\b\u00030\u000B2\u0006\u0010\u0015\u001A\u00020\u0016H\u0002\u001A\u0018\u0010\u0017\u001A\u00020\u0018*\u0006\u0012\u0002\b\u00030\u000B2\u0006\u0010\u0019\u001A\u00020\u001AH\u0002¨\u0006\u001B"}, d2={"startCoroutineUndispatched", "", "R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "startUndspatched", "alwaysRethrow", "", "(Lkotlinx/coroutines/internal/ScopeCoroutine;ZLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "notOwnTimeout", "cause", "", "dispatchExceptionAndMakeCompleting", "", "e", "Lkotlinx/coroutines/DispatchException;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class UndispatchedKt {
    private static final Void dispatchExceptionAndMakeCompleting(ScopeCoroutine arg5, DispatchException arg6) {
        arg5.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(arg6.getCause(), false, 2, null));
        Throwable v6 = arg6.getCause();
        Continuation v5 = arg5.uCont;
        if(DebugKt.getRECOVER_STACK_TRACES()) {
            if(!(v5 instanceof CoroutineStackFrame)) {
            }
            else {
                v6 = StackTraceRecoveryKt.recoverFromStackFrame(v6, ((CoroutineStackFrame)v5));
            }
        }

        throw v6;
    }

    private static final boolean notOwnTimeout(ScopeCoroutine arg1, Throwable arg2) {
        if((arg2 instanceof TimeoutCancellationException)) {
            if(((TimeoutCancellationException)arg2).coroutine != arg1) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final void startCoroutineUndispatched(Function2 arg3, Object arg4, Continuation arg5) {
        Object v3_1;
        Object v1;
        CoroutineContext v0;
        arg5 = DebugProbesKt.probeCoroutineCreated(arg5);
        try {
            v0 = arg5.getContext();
            v1 = ThreadContextKt.updateThreadContext(v0, null);
        }
        catch(Throwable v3) {
            goto label_24;
        }

        try {
            DebugProbesKt.probeCoroutineResumed(arg5);
            v3_1 = !(arg3 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(arg3, arg4, arg5) : TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg3, 2).invoke(arg4, arg5);
            goto label_12;
        }
        catch(Throwable v3) {
            try {
                ThreadContextKt.restoreThreadContext(v0, v1);
                throw v3;
            label_12:
                ThreadContextKt.restoreThreadContext(v0, v1);
            }
            catch(Throwable v3) {
            label_24:
                if((v3 instanceof DispatchException)) {
                    v3 = ((DispatchException)v3).getCause();
                }

                arg5.resumeWith(Result.constructor-impl(ResultKt.createFailure(v3)));
                return;
            }
        }

        if(v3_1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            arg5.resumeWith(Result.constructor-impl(v3_1));
        }
    }

    public static final Object startUndispatchedOrReturn(ScopeCoroutine arg1, Object arg2, Function2 arg3) {
        return UndispatchedKt.startUndspatched(arg1, true, arg2, arg3);
    }

    public static final Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine arg1, Object arg2, Function2 arg3) {
        return UndispatchedKt.startUndspatched(arg1, false, arg2, arg3);
    }

    private static final Object startUndspatched(ScopeCoroutine arg3, boolean arg4, Object arg5, Function2 arg6) {
        Continuation v3;
        Throwable v4_1;
        CompletedExceptionally v5_1;
        int v0 = 2;
        try {
            if(!(arg6 instanceof BaseContinuationImpl)) {
                arg5 = IntrinsicsKt.wrapWithContinuationImpl(arg6, arg5, arg3);
                goto label_16;
            }

            arg5 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(arg6, v0).invoke(arg5, arg3);
        }
        catch(Throwable v5) {
            v5_1 = new CompletedExceptionally(v5, false, v0, null);
        }
        catch(DispatchException v4) {
            UndispatchedKt.dispatchExceptionAndMakeCompleting(arg3, v4);
            throw new KotlinNothingValueException();
        }

    label_16:
        if(v5_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }

        Object v6 = arg3.makeCompletingOnce$kotlinx_coroutines_core(v5_1);
        if(v6 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }

        arg3.afterCompletionUndispatched();
        if((v6 instanceof CompletedExceptionally)) {
            if(!arg4) {
                if(UndispatchedKt.notOwnTimeout(arg3, v6.cause)) {
                }
                else if((v5_1 instanceof CompletedExceptionally)) {
                    v4_1 = v5_1.cause;
                    v3 = arg3.uCont;
                    if(DebugKt.getRECOVER_STACK_TRACES()) {
                        if(!(v3 instanceof CoroutineStackFrame)) {
                        }
                        else {
                            v4_1 = StackTraceRecoveryKt.recoverFromStackFrame(v4_1, ((CoroutineStackFrame)v3));
                        }
                    }

                    throw v4_1;
                }
                else {
                    return v5_1;
                }
            }

            v4_1 = ((CompletedExceptionally)v6).cause;
            v3 = arg3.uCont;
            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(v3 instanceof CoroutineStackFrame)) {
                }
                else {
                    v4_1 = StackTraceRecoveryKt.recoverFromStackFrame(v4_1, ((CoroutineStackFrame)v3));
                }
            }

            throw v4_1;
        }
        else {
            arg5 = JobSupportKt.unboxState(v6);
        }

        return v5_1;
    }
}

