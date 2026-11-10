package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000BJ\u000E\u0010\f\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010\rR\u001A\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2={"Lkotlinx/coroutines/DeferredCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "getCompleted", "()Ljava/lang/Object;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) class DeferredCoroutine extends AbstractCoroutine implements Deferred {
    public DeferredCoroutine(CoroutineContext arg2, boolean arg3) {
        super(arg2, true, arg3);
    }

    public Object await(Continuation arg1) {
        return DeferredCoroutine.await$suspendImpl(this, arg1);
    }

    static Object await$suspendImpl(DeferredCoroutine arg0, Continuation arg1) {
        Object v0 = arg0.awaitInternal(arg1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return v0;
    }

    public Object getCompleted() {
        return this.getCompletedInternal$kotlinx_coroutines_core();
    }

    public SelectClause1 getOnAwait() {
        SelectClause1 v1 = this.getOnAwaitInternal();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return v1;
    }
}

