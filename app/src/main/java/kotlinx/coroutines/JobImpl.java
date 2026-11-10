package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001A\u00020\bH\u0016J\u0010\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u000B\u001A\u00020\bH\u0003R\u0014\u0010\u0007\u001A\u00020\b8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\n¨\u0006\u0011"}, d2={"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "onCancelComplete", "", "getOnCancelComplete$kotlinx_coroutines_core", "()Z", "handlesException", "getHandlesException$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class JobImpl extends JobSupport implements CompletableJob {
    private final boolean handlesException;

    public JobImpl(Job arg2) {
        super(true);
        this.initParentJob(arg2);
        this.handlesException = this.handlesException();
    }

    public boolean complete() {
        return this.makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    public boolean completeExceptionally(Throwable arg5) {
        return this.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(arg5, false, 2, null));
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return 1;
    }

    private final boolean handlesException() {
        ChildHandle v3 = this.getParentHandle$kotlinx_coroutines_core();
        ChildHandle v1 = null;
        if((v3 instanceof ChildHandleNode)) {
        }
        else {
            v3 = v1;
        }

        if(v3 != null) {
            JobSupport v3_1 = ((ChildHandleNode)v3).getJob();
            if(v3_1 == null) {
                return 0;
            }

            do {
                if(v3_1.getHandlesException$kotlinx_coroutines_core()) {
                    return 1;
                }

                v3 = ((JobSupport)v3).getParentHandle$kotlinx_coroutines_core();
                if((v3 instanceof ChildHandleNode)) {
                }
                else {
                    v3 = v1;
                }

                if(v3 == null) {
                    return 0;
                }

                v3_1 = ((ChildHandleNode)v3).getJob();
                if(v3_1 != null) {
                    continue;
                }

                return 0;
            }
            while(true);

            return 1;
        }

        return 0;
    }
}

