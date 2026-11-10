package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0006"}, d2={"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/ThreadPoolDispatcherKt") final class ThreadPoolDispatcherKt__ThreadPoolDispatcherKt {
    public static Thread $r8$lambda$iE9_27a--PEYAk7JOqaAHpuexdA(int arg0, String arg1, AtomicInteger arg2, Runnable arg3) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.newFixedThreadPoolContext$lambda$2$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(arg0, arg1, arg2, arg3);
    }

    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int arg2, String arg3) {
        if(arg2 >= 1) {
            return ExecutorsKt.from(Executors.unconfigurableExecutorService(Executors.newScheduledThreadPool(arg2, new ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(arg2, arg3, new AtomicInteger()))));
        }

        throw new IllegalArgumentException("Expected at least one thread, but " + arg2 + " specified".toString());
    }

    private static final Thread newFixedThreadPoolContext$lambda$2$ThreadPoolDispatcherKt__ThreadPoolDispatcherKt(int arg2, String arg3, AtomicInteger arg4, Runnable arg5) {
        if(arg2 == 1) {
        }
        else {
            arg3 = arg3 + '-' + arg4.incrementAndGet();
        }

        Thread v0 = new Thread(arg5, arg3);
        v0.setDaemon(true);
        return v0;
    }
}

