package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003B\u001D\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\n\u0010\u000BJ!\u0010\f\u001A\u00020\u00052\b\u0010\r\u001A\u0004\u0018\u00018\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\u00052\u0006\u0010\r\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0015H\u0014R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lkotlinx/coroutines/future/CompletableFutureCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Ljava/util/function/BiFunction;", "", "", "context", "Lkotlin/coroutines/CoroutineContext;", "future", "Ljava/util/concurrent/CompletableFuture;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CompletableFuture;)V", "apply", "value", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "onCompleted", "(Ljava/lang/Object;)V", "onCancelled", "cause", "handled", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class CompletableFutureCoroutine extends AbstractCoroutine implements BiFunction {
    private final CompletableFuture future;

    public CompletableFutureCoroutine(CoroutineContext arg2, CompletableFuture arg3) {
        super(arg2, true, true);
        this.future = arg3;
    }

    public Object apply(Object arg1, Object arg2) {
        this.apply(arg1, ((Throwable)arg2));
        return Unit.INSTANCE;
    }

    public void apply(Object arg1, Throwable arg2) {
        DefaultImpls.cancel$default(((Job)this), null, 1, null);
    }

    protected void onCancelled(Throwable arg1, boolean arg2) {
        this.future.completeExceptionally(arg1);
    }

    protected void onCompleted(Object arg1) {
        this.future.complete(arg1);
    }
}

