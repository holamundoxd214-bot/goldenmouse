package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u000E\u0010\u000E\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u000FJ\u0015\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0015\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\u0019H\u0016R\u0014\u0010\b\u001A\u00020\t8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001A"}, d2={"Lkotlinx/coroutines/CompletableDeferredImpl;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableDeferred;", "parent", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "onCancelComplete", "", "getOnCancelComplete$kotlinx_coroutines_core", "()Z", "getCompleted", "()Ljava/lang/Object;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "complete", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class CompletableDeferredImpl extends JobSupport implements CompletableDeferred {
    public CompletableDeferredImpl(Job arg2) {
        super(true);
        this.initParentJob(arg2);
    }

    public Object await(Continuation arg1) {
        Object v0 = this.awaitInternal(arg1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return v0;
    }

    public boolean complete(Object arg1) {
        return this.makeCompleting$kotlinx_coroutines_core(arg1);
    }

    public boolean completeExceptionally(Throwable arg5) {
        return this.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(arg5, false, 2, null));
    }

    public Object getCompleted() {
        return this.getCompletedInternal$kotlinx_coroutines_core();
    }

    public SelectClause1 getOnAwait() {
        SelectClause1 v1 = this.getOnAwaitInternal();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return v1;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return 1;
    }
}

