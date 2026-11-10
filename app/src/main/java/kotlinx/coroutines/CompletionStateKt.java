package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001F\u0010\u0000\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001A+\u0010\u0000\u001A\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001A1\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\b\u0010\t\u001A\u0004\u0018\u00010\u00012\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u000BH\u0000¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"toState", "", "T", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "recoverResult", "state", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompletionStateKt {
    public static final Object recoverResult(Object arg1, Continuation arg2) {
        if((arg1 instanceof CompletedExceptionally)) {
            Throwable v1 = ((CompletedExceptionally)arg1).cause;
            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(arg2 instanceof CoroutineStackFrame)) {
                }
                else {
                    v1 = StackTraceRecoveryKt.access$recoverFromStackFrame(v1, ((CoroutineStackFrame)arg2));
                }
            }

            return Result.constructor-impl(ResultKt.createFailure(v1));
        }

        return Result.constructor-impl(arg1);
    }

    public static final Object toState(Object arg4) {
        Throwable v0 = Result.exceptionOrNull-impl(arg4);
        if(v0 == null) {
            return arg4;
        }

        return new CompletedExceptionally(v0, false, 2, null);
    }

    public static final Object toState(Object arg3, CancellableContinuation arg4) {
        Throwable v0 = Result.exceptionOrNull-impl(arg3);
        if(v0 == null) {
            return arg3;
        }

        if(DebugKt.getRECOVER_STACK_TRACES()) {
            if(!(arg4 instanceof CoroutineStackFrame)) {
            }
            else {
                v0 = StackTraceRecoveryKt.access$recoverFromStackFrame(v0, ((CoroutineStackFrame)arg4));
            }
        }

        return new CompletedExceptionally(v0, false, 2, null);
    }
}

