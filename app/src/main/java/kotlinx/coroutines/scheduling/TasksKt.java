package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\f\u001A\u00020\u00012\n\u0010\r\u001A\u00060\u000Bj\u0002`\u000EH\u0002\u001A$\u0010\u0014\u001A\u00020\u0012*\u00060\u0015j\u0002`\u00162\u0006\u0010\u0017\u001A\u00020\u00032\n\u0010\r\u001A\u00060\u000Bj\u0002`\u000EH\u0000\"\u0010\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001A\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\b\u001A\u00020\t8\u0000@\u0000X\u0081\u000E¢\u0006\u0002\n\u0000\"\u0012\u0010\u000F\u001A\u00060\u000Bj\u0002`\u000EX\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0010\u001A\u00060\u000Bj\u0002`\u000EX\u0080T¢\u0006\u0002\n\u0000\"\u001D\u0010\u0011\u001A\u00060\u000Bj\u0002`\u000E*\u00020\u00128À\u0002X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0013*\f\b\u0000\u0010\n\"\u00020\u000B2\u00020\u000B¨\u0006\u0018"}, d2={"DEFAULT_SCHEDULER_NAME", "", "WORK_STEALING_TIME_RESOLUTION_NS", "", "CORE_POOL_SIZE", "", "MAX_POOL_SIZE", "IDLE_WORKER_KEEP_ALIVE_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "TaskContext", "", "taskContextString", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "NonBlockingContext", "BlockingContext", "isBlocking", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "asTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TasksKt {
    public static final boolean BlockingContext = true;
    public static final int CORE_POOL_SIZE = 0;
    public static final String DEFAULT_SCHEDULER_NAME = null;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = 0;
    public static final int MAX_POOL_SIZE = 0;
    public static final boolean NonBlockingContext = false;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    public static SchedulerTimeSource schedulerTimeSource;

    static {
        TasksKt.DEFAULT_SCHEDULER_NAME = SystemPropsKt.systemProp("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");
        TasksKt.WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);
        TasksKt.CORE_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, null);
        TasksKt.MAX_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 0x1FFFFE, 0, 0x1FFFFE, 4, null);
        TasksKt.IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));
        TasksKt.schedulerTimeSource = NanoTimeSource.INSTANCE;
    }

    public static final String access$taskContextString(boolean arg0) {
        return TasksKt.taskContextString(arg0);
    }

    public static final Task asTask(Runnable arg1, long arg2, boolean arg4) {
        return new TaskImpl(arg1, arg2, arg4);
    }

    public static final boolean isBlocking(Task arg0) {
        return arg0.taskContext;
    }

    private static final String taskContextString(boolean arg0) {
        if(arg0) {
            return "Blocking";
        }

        return "Non-blocking";
    }
}

