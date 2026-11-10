package androidx.core.os;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u0005B\u0015\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0015\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/core/os/ContinuationOutcomeReceiver;", "R", "E", "", "Landroid/os/OutcomeReceiver;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "continuation", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "onResult", "", "result", "(Ljava/lang/Object;)V", "onError", "error", "(Ljava/lang/Throwable;)V", "toString", "", "core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ContinuationOutcomeReceiver extends AtomicBoolean implements OutcomeReceiver {
    private final Continuation continuation;

    public ContinuationOutcomeReceiver(Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg2, "continuation");
        super(false);
        this.continuation = arg2;
    }

    public void onError(Throwable arg3) {
        Intrinsics.checkNotNullParameter(arg3, "error");
        if(this.compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(arg3)));
        }
    }

    public void onResult(Object arg3) {
        if(this.compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.constructor-impl(arg3));
        }
    }

    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + this.get() + ")";
    }
}

