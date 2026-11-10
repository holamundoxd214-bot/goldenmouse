package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A)\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001A\u001E\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t\u001A\u001F\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001A\u0002H\u0002¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2={"completeWith", "", "T", "Lkotlinx/coroutines/CompletableDeferred;", "result", "Lkotlin/Result;", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "CompletableDeferred", "parent", "Lkotlinx/coroutines/Job;", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompletableDeferredKt {
    public static final CompletableDeferred CompletableDeferred(Job arg1) {
        return new CompletableDeferredImpl(arg1);
    }

    public static final CompletableDeferred CompletableDeferred(Object arg2) {
        CompletableDeferredImpl v0 = new CompletableDeferredImpl(null);
        v0.complete(arg2);
        return ((CompletableDeferred)v0);
    }

    public static CompletableDeferred CompletableDeferred$default(Job arg0, int arg1, Object arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        return CompletableDeferredKt.CompletableDeferred(arg0);
    }

    public static final boolean completeWith(CompletableDeferred arg1, Object arg2) {
        Throwable v0 = Result.exceptionOrNull-impl(arg2);
        if(v0 == null) {
            return arg1.complete(arg2);
        }

        return arg1.completeExceptionally(v0);
    }
}

