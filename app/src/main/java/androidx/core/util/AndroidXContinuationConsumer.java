package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000BJ\b\u0010\f\u001A\u00020\rH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/core/util/AndroidXContinuationConsumer;", "T", "Landroidx/core/util/Consumer;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "continuation", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "accept", "", "value", "(Ljava/lang/Object;)V", "toString", "", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class AndroidXContinuationConsumer extends AtomicBoolean implements Consumer {
    private final Continuation continuation;

    public AndroidXContinuationConsumer(Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg2, "continuation");
        super(false);
        this.continuation = arg2;
    }

    public void accept(Object arg3) {
        if(this.compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.constructor-impl(arg3));
        }
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + this.get() + ")";
    }
}

