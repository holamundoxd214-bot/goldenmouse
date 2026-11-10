package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u001C\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\n\u0010\f\u001A\u00060\rj\u0002`\u000EH\u0016R\u0010\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/lifecycle/PausingDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "isDispatchNeeded", "", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatch", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue;

    public PausingDispatcher() {
        super();
        this.dispatchQueue = new DispatchQueue();
    }

    public void dispatch(CoroutineContext arg2, Runnable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        Intrinsics.checkNotNullParameter(arg3, "block");
        this.dispatchQueue.dispatchAndEnqueue(arg2, arg3);
    }

    public boolean isDispatchNeeded(CoroutineContext arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        if(Dispatchers.getMain().getImmediate().isDispatchNeeded(arg2)) {
            return 1;
        }

        return this.dispatchQueue.canRun() ^ 1;
    }
}

