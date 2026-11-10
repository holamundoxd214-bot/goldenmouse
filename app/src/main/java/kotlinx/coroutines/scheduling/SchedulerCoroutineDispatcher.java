package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001A\u00020\u0010H\u0002J\u001C\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\n\u0010\u0016\u001A\u00060\u0017j\u0002`\u0018H\u0016J\u001C\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\n\u0010\u0016\u001A\u00060\u0017j\u0002`\u0018H\u0016J-\u0010\u001A\u001A\u00020\u00132\n\u0010\u0016\u001A\u00060\u0017j\u0002`\u00182\n\u0010\u0014\u001A\u00060\u001Bj\u0002`\u001C2\u0006\u0010\u001D\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001EJ\b\u0010\u001F\u001A\u00020\u0013H\u0016J\r\u0010 \u001A\u00020\u0013H\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001A\u00020\u00132\u0006\u0010#\u001A\u00020\u0006H\u0000¢\u0006\u0002\b$J\r\u0010%\u001A\u00020\u0013H\u0000¢\u0006\u0002\b&R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\'"}, d2={"Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "<init>", "(IIJLjava/lang/String;)V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "coroutineScheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "createScheduler", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "dispatchWithContext", "", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "dispatchWithContext$kotlinx_coroutines_core", "close", "usePrivateScheduler", "usePrivateScheduler$kotlinx_coroutines_core", "shutdown", "timeout", "shutdown$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    private CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private final String schedulerName;

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0, null, 15, null);
    }

    public SchedulerCoroutineDispatcher(int arg1, int arg2, long arg3, String arg5, int arg6, DefaultConstructorMarker arg7) {
        if((arg6 & 1) != 0) {
            arg1 = TasksKt.CORE_POOL_SIZE;
        }

        if((arg6 & 2) != 0) {
            arg2 = TasksKt.MAX_POOL_SIZE;
        }

        if((arg6 & 4) != 0) {
            arg3 = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }

        if((arg6 & 8) != 0) {
            arg5 = "CoroutineScheduler";
        }

        this(arg1, arg2, arg3, arg5);
    }

    public SchedulerCoroutineDispatcher(int arg1, int arg2, long arg3, String arg5) {
        super();
        this.corePoolSize = arg1;
        this.maxPoolSize = arg2;
        this.idleWorkerKeepAliveNs = arg3;
        this.schedulerName = arg5;
        this.coroutineScheduler = this.createScheduler();
    }

    public void close() {
        this.coroutineScheduler.close();
    }

    private final CoroutineScheduler createScheduler() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    public void dispatch(CoroutineContext arg7, Runnable arg8) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, arg8, false, false, 6, null);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable arg1, boolean arg2, boolean arg3) {
        this.coroutineScheduler.dispatch(arg1, arg2, arg3);
    }

    public void dispatchYield(CoroutineContext arg7, Runnable arg8) {
        CoroutineScheduler.dispatch$default(this.coroutineScheduler, arg8, false, true, 2, null);
    }

    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    public final void restore$kotlinx_coroutines_core() {
        this.usePrivateScheduler$kotlinx_coroutines_core();
    }

    public final void shutdown$kotlinx_coroutines_core(long arg2) {
        __monitor_enter(this);
        try {
            this.coroutineScheduler.shutdown(arg2);
        }
        catch(Throwable v2) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public final void usePrivateScheduler$kotlinx_coroutines_core() {
        __monitor_enter(this);
        try {
            this.coroutineScheduler.shutdown(1000);
            this.coroutineScheduler = this.createScheduler();
        }
        catch(Throwable v0) {
            try {
            label_9:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

        __monitor_exit(this);
    }
}

