package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001A\u00020\u0005H\u0016J\b\u0010\t\u001A\u00020\nH\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/core/util/ContinuationRunnable;", "Ljava/lang/Runnable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "continuation", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/coroutines/Continuation;)V", "run", "toString", "", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final Continuation continuation;

    public ContinuationRunnable(Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg2, "continuation");
        super(false);
        this.continuation = arg2;
    }

    public void run() {
        if(this.compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }

    public String toString() {
        return "ContinuationRunnable(ran = " + this.get() + ")";
    }
}

