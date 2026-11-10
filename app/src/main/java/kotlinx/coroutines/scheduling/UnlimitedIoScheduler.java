package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\n\u0010\b\u001A\u00060\tj\u0002`\nH\u0017J\u001C\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\n\u0010\b\u001A\u00060\tj\u0002`\nH\u0016J\u001A\u0010\f\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0010H\u0016¨\u0006\u0012"}, d2={"Lkotlinx/coroutines/scheduling/UnlimitedIoScheduler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "dispatchYield", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "limitedParallelism", "parallelism", "", "name", "", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class UnlimitedIoScheduler extends CoroutineDispatcher {
    public static final UnlimitedIoScheduler INSTANCE;

    static {
        UnlimitedIoScheduler.INSTANCE = new UnlimitedIoScheduler();
    }

    private UnlimitedIoScheduler() {
        super();
    }

    public void dispatch(CoroutineContext arg2, Runnable arg3) {
        DefaultScheduler.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(arg3, true, false);
    }

    public void dispatchYield(CoroutineContext arg1, Runnable arg2) {
        DefaultScheduler.INSTANCE.dispatchWithContext$kotlinx_coroutines_core(arg2, true, true);
    }

    public CoroutineDispatcher limitedParallelism(int arg2, String arg3) {
        LimitedDispatcherKt.checkParallelism(arg2);
        if(arg2 >= TasksKt.MAX_POOL_SIZE) {
            return LimitedDispatcherKt.namedOrThis(((CoroutineDispatcher)this), arg3);
        }

        return super.limitedParallelism(arg2, arg3);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}

