package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\f\u001A\u0004\u0018\u00010\rH ¢\u0006\u0002\b\u000EJ\u001F\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001A\u00020\u0013H\u0010¢\u0006\u0002\b\u0014J\u001F\u0010\u0015\u001A\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0016\u001A\u0004\u0018\u00010\rH\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001A\u0004\u0018\u00010\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\rH\u0010¢\u0006\u0002\b\u001AJ\u0006\u0010\u001B\u001A\u00020\u0010J\u0015\u0010\u001C\u001A\u00020\u00102\u0006\u0010\u001D\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u001ER\u0012\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tX \u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u001F"}, d2={"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "<init>", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "takeState", "", "takeState$kotlinx_coroutines_core", "cancelCompletedResult", "", "takenState", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getSuccessfulResult", "state", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "run", "handleFatalException", "exception", "handleFatalException$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class DispatchedTask extends Task {
    public int resumeMode;

    public DispatchedTask(int arg1) {
        super();
        this.resumeMode = arg1;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object arg1, Throwable arg2) {
    }

    public abstract Continuation getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object arg2) {
        Throwable v0 = null;
        if((arg2 instanceof CompletedExceptionally)) {
        }
        else {
            arg2 = v0;
        }

        if(arg2 != null) {
            return ((CompletedExceptionally)arg2).cause;
        }

        return v0;
    }

    public Object getSuccessfulResult$kotlinx_coroutines_core(Object arg1) {
        return arg1;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable arg4) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to \'handleFatalException\' method and report this incident to maintainers", arg4));
    }

    public final void run() {
        Throwable v4_2;
        UndispatchedCoroutine v3;
        Element v4;
        CoroutineContext v2;
        Object v0_3;
        Continuation v1;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.resumeMode != -1) {
            }
            else {
                throw new AssertionError();
            }
        }

        try {
            Continuation v0_2 = this.getDelegate$kotlinx_coroutines_core();
            Intrinsics.checkNotNull(v0_2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            v1 = ((DispatchedContinuation)v0_2).continuation;
            v0_3 = ((DispatchedContinuation)v0_2).countOrElement;
            v2 = v1.getContext();
            v0_3 = ThreadContextKt.updateThreadContext(v2, v0_3);
            v4 = null;
            if(v0_3 != ThreadContextKt.NO_THREAD_ELEMENTS) {
                v3 = CoroutineContextKt.updateUndispatchedCompletion(v1, v2, v0_3);
            }
            else {
                goto label_21;
            }

            goto label_22;
        }
        catch(Throwable v0) {
            goto label_73;
        }
        catch(DispatchException v0_1) {
            goto label_79;
        }

    label_21:
        v3 = ((UndispatchedCoroutine)v4);
        try {
        label_22:
            CoroutineContext v5 = v1.getContext();
            Object v6 = this.takeState$kotlinx_coroutines_core();
            Throwable v7 = this.getExceptionalResult$kotlinx_coroutines_core(v6);
            if(v7 == null && (DispatchedTaskKt.isCancellableMode(this.resumeMode))) {
                v4 = v5.get(Job.Key);
            }

            if(v4 == null || (((Job)v4).isActive())) {
                if(v7 != null) {
                    v1.resumeWith(Result.constructor-impl(ResultKt.createFailure(v7)));
                    goto label_60;
                }

                v1.resumeWith(Result.constructor-impl(this.getSuccessfulResult$kotlinx_coroutines_core(v6)));
            }
            else {
                CancellationException v4_1 = ((Job)v4).getCancellationException();
                this.cancelCompletedResult$kotlinx_coroutines_core(v6, v4_1);
                if(DebugKt.getRECOVER_STACK_TRACES()) {
                    if(!(v1 instanceof CoroutineStackFrame)) {
                    }
                    else {
                        v4_2 = StackTraceRecoveryKt.access$recoverFromStackFrame(((Throwable)v4_1), v1);
                    }
                }

                Object v4_3 = ResultKt.createFailure(v4_2);
                v1.resumeWith(Result.constructor-impl(v4_3));
            }

        label_60:
            if(v3 == null) {
                goto label_64;
            }

            goto label_62;
        }
        catch(Throwable v1_1) {
            try {
                if(v3 == null || (v3.clearThreadContext())) {
                    ThreadContextKt.restoreThreadContext(v2, v0_3);
                }

                throw v1_1;
            label_62:
                if(!v3.clearThreadContext()) {
                    return;
                }

            label_64:
                ThreadContextKt.restoreThreadContext(v2, v0_3);
                return;
            }
            catch(Throwable v0) {
            label_73:
                this.handleFatalException$kotlinx_coroutines_core(v0);
            }
            catch(DispatchException v0_1) {
            label_79:
                CoroutineExceptionHandlerKt.handleCoroutineException(this.getDelegate$kotlinx_coroutines_core().getContext(), v0_1.getCause());
            }
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}

