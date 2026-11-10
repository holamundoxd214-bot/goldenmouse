package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ResumeAwaitOnCompletion extends JobNode {
    private final CancellableContinuationImpl continuation;

    public ResumeAwaitOnCompletion(CancellableContinuationImpl arg1) {
        super();
        this.continuation = arg1;
    }

    public boolean getOnCancelling() {
        return 0;
    }

    public void invoke(Throwable arg2) {
        Object v2 = this.getJob().getState$kotlinx_coroutines_core();
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!(v2 instanceof Incomplete)) {
            }
            else {
                throw new AssertionError();
            }
        }

        CancellableContinuationImpl v1 = this.continuation;
        if((v2 instanceof CompletedExceptionally)) {
            ((Continuation)v1).resumeWith(Result.constructor-impl(ResultKt.createFailure(((CompletedExceptionally)v2).cause)));
            return;
        }

        ((Continuation)v1).resumeWith(Result.constructor-impl(JobSupportKt.unboxState(v2)));
    }
}

