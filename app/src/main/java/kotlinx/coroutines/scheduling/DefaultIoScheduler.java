package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u001A\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0016J\u001C\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u00152\n\u0010\u0016\u001A\u00060\rj\u0002`\u0017H\u0016J\u001C\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u00152\n\u0010\u0016\u001A\u00060\rj\u0002`\u0017H\u0017J\b\u0010\u0019\u001A\u00020\u000BH\u0016J\b\u0010\u001A\u001A\u00020\u0012H\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u001B"}, d2={"Lkotlinx/coroutines/scheduling/DefaultIoScheduler;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "executor", "getExecutor", "()Ljava/util/concurrent/Executor;", "execute", "", "command", "Ljava/lang/Runnable;", "limitedParallelism", "parallelism", "", "name", "", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "close", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {
    public static final DefaultIoScheduler INSTANCE;
    private static final CoroutineDispatcher default;

    static {
        DefaultIoScheduler.INSTANCE = new DefaultIoScheduler();
        DefaultIoScheduler.default = CoroutineDispatcher.limitedParallelism$default(UnlimitedIoScheduler.INSTANCE, SystemPropsKt.systemProp$default("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(0x40, SystemPropsKt.getAVAILABLE_PROCESSORS()), 0, 0, 12, null), null, 2, null);
    }

    private DefaultIoScheduler() {
        super();
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void dispatch(CoroutineContext arg1, Runnable arg2) {
        DefaultIoScheduler.default.dispatch(arg1, arg2);
    }

    public void dispatchYield(CoroutineContext arg1, Runnable arg2) {
        DefaultIoScheduler.default.dispatchYield(arg1, arg2);
    }

    public void execute(Runnable arg2) {
        this.dispatch(EmptyCoroutineContext.INSTANCE, arg2);
    }

    public Executor getExecutor() {
        return this;
    }

    public CoroutineDispatcher limitedParallelism(int arg1, String arg2) {
        return UnlimitedIoScheduler.INSTANCE.limitedParallelism(arg1, arg2);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}

