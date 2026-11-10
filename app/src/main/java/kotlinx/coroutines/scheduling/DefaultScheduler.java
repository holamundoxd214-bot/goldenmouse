package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0016J\r\u0010\n\u001A\u00020\u000BH\u0000¢\u0006\u0002\b\fJ\b\u0010\r\u001A\u00020\u000BH\u0016J\b\u0010\u000E\u001A\u00020\tH\u0016¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "<init>", "()V", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "name", "", "shutdown", "", "shutdown$kotlinx_coroutines_core", "close", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DefaultScheduler extends SchedulerCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE;

    static {
        DefaultScheduler.INSTANCE = new DefaultScheduler();
    }

    private DefaultScheduler() {
        super(TasksKt.CORE_POOL_SIZE, TasksKt.MAX_POOL_SIZE, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, TasksKt.DEFAULT_SCHEDULER_NAME);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    public CoroutineDispatcher limitedParallelism(int arg2, String arg3) {
        LimitedDispatcherKt.checkParallelism(arg2);
        if(arg2 >= TasksKt.CORE_POOL_SIZE) {
            return LimitedDispatcherKt.namedOrThis(((CoroutineDispatcher)this), arg3);
        }

        return super.limitedParallelism(arg2, arg3);
    }

    public final void shutdown$kotlinx_coroutines_core() {
        super.close();
    }

    public String toString() {
        return "Dispatchers.Default";
    }
}

