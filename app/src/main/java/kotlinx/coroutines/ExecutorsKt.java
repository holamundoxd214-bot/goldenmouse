package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0011\u0010\u0003\u001A\u00020\u0001*\u00020\u0004H\u0007¢\u0006\u0002\b\u0005\u001A\u0011\u0010\u0003\u001A\u00020\u0006*\u00020\u0007H\u0007¢\u0006\u0002\b\u0005\u001A\n\u0010\b\u001A\u00020\u0007*\u00020\u0006*\u0010\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\u0002\b\u0002¨\u0006\t"}, d2={"CloseableCoroutineDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/ExperimentalCoroutinesApi;", "asCoroutineDispatcher", "Ljava/util/concurrent/ExecutorService;", "from", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "asExecutor", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ExecutorsKt {
    public static void CloseableCoroutineDispatcher$annotations() {
    }

    public static final Executor asExecutor(CoroutineDispatcher arg1) {
        CoroutineDispatcher v0 = (arg1 instanceof ExecutorCoroutineDispatcher) ? arg1 : null;
        if(v0 != null) {
            Executor v0_1 = ((ExecutorCoroutineDispatcher)v0).getExecutor();
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return new DispatcherExecutor(arg1);
    }

    public static final CoroutineDispatcher from(Executor arg1) {
        Executor v0 = (arg1 instanceof DispatcherExecutor) ? arg1 : null;
        if(v0 != null) {
            CoroutineDispatcher v0_1 = ((DispatcherExecutor)v0).dispatcher;
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return new ExecutorCoroutineDispatcherImpl(arg1);
    }

    public static final ExecutorCoroutineDispatcher from(ExecutorService arg1) {
        return new ExecutorCoroutineDispatcherImpl(((Executor)arg1));
    }
}

