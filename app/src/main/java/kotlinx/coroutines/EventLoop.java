package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000B\u001A\u00020\u0005H\u0016J\u0006\u0010\u0011\u001A\u00020\u0007J\b\u0010\u0012\u001A\u00020\u0007H\u0016J\u0012\u0010\u0013\u001A\u00020\u00142\n\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\nJ\u0010\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u0007H\u0002J\u0010\u0010\u001B\u001A\u00020\u00142\b\b\u0002\u0010\u001A\u001A\u00020\u0007J\u0010\u0010\u001C\u001A\u00020\u00142\b\b\u0002\u0010\u001A\u001A\u00020\u0007J\u0018\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010!J\b\u0010\"\u001A\u00020\u0014H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0016\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\rR\u0011\u0010\u0017\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\r¨\u0006#"}, d2={"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "useCount", "", "shared", "", "unconfinedQueue", "Lkotlin/collections/ArrayDeque;", "Lkotlinx/coroutines/DispatchedTask;", "processNextEvent", "isEmpty", "()Z", "nextTime", "getNextTime", "()J", "processUnconfinedEvent", "shouldBeProcessedFromContext", "dispatchUnconfined", "", "task", "isActive", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "delta", "unconfined", "incrementUseCount", "decrementUseCount", "limitedParallelism", "parallelism", "", "name", "", "shutdown", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class EventLoop extends CoroutineDispatcher {
    private boolean shared;
    private ArrayDeque unconfinedQueue;
    private long useCount;

    public EventLoop() {
        super();
    }

    public final void decrementUseCount(boolean arg5) {
        long v0 = this.useCount - this.delta(arg5);
        this.useCount = v0;
        long v2 = 0;
        if(v0 > v2) {
        }
        else {
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(this.useCount == v2) {
                }
                else {
                    throw new AssertionError();
                }
            }

            if(!this.shared) {
                return;
            }

            this.shutdown();
        }
    }

    public static void decrementUseCount$default(EventLoop arg0, boolean arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            arg0.decrementUseCount(false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long delta(boolean arg1) {
        if(arg1) {
            return 0x100000000L;
        }

        return 1;
    }

    public final void dispatchUnconfined(DispatchedTask arg2) {
        ArrayDeque v0 = this.unconfinedQueue;
        if(v0 == null) {
            v0 = new ArrayDeque();
            this.unconfinedQueue = v0;
        }

        v0.addLast(arg2);
    }

    protected long getNextTime() {
        ArrayDeque v2 = this.unconfinedQueue;
        long v0 = 0x7FFFFFFFFFFFFFFFL;
        if(v2 == null) {
            return v0;
        }

        if(v2.isEmpty()) {
            return v0;
        }

        return 0;
    }

    public final void incrementUseCount(boolean arg5) {
        this.useCount += this.delta(arg5);
        if(!arg5) {
            this.shared = true;
        }
    }

    public static void incrementUseCount$default(EventLoop arg0, boolean arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            arg0.incrementUseCount(false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final boolean isActive() {
        if(this.useCount > 0) {
            return 1;
        }

        return 0;
    }

    protected boolean isEmpty() {
        return this.isUnconfinedQueueEmpty();
    }

    public final boolean isUnconfinedLoopActive() {
        if(this.useCount >= this.delta(true)) {
            return 1;
        }

        return 0;
    }

    public final boolean isUnconfinedQueueEmpty() {
        ArrayDeque v0 = this.unconfinedQueue;
        if(v0 != null) {
            return v0.isEmpty();
        }

        return 1;
    }

    public final CoroutineDispatcher limitedParallelism(int arg1, String arg2) {
        LimitedDispatcherKt.checkParallelism(arg1);
        return LimitedDispatcherKt.namedOrThis(((CoroutineDispatcher)this), arg2);
    }

    public long processNextEvent() {
        if(!this.processUnconfinedEvent()) {
            return 0x7FFFFFFFFFFFFFFFL;
        }

        return 0;
    }

    public final boolean processUnconfinedEvent() {
        ArrayDeque v1 = this.unconfinedQueue;
        if(v1 == null) {
            return 0;
        }

        Object v1_1 = v1.removeFirstOrNull();
        if(v1_1 == null) {
            return 0;
        }

        ((DispatchedTask)v1_1).run();
        return 1;
    }

    public boolean shouldBeProcessedFromContext() {
        return 0;
    }

    public void shutdown() {
    }
}

