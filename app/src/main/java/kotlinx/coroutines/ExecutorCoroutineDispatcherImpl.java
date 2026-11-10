package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ConcurrentKt;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001C\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\n\u0010\r\u001A\u00060\u000Ej\u0002`\u000FH\u0016J\u001E\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\n0\u0014H\u0016J$\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0011\u001A\u00020\u00122\n\u0010\r\u001A\u00060\u000Ej\u0002`\u000F2\u0006\u0010\u000B\u001A\u00020\fH\u0016J.\u0010\u0017\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0018*\u00020\u00192\n\u0010\r\u001A\u00060\u000Ej\u0002`\u000F2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\u0012H\u0002J\u0018\u0010\u001A\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\u001CH\u0002J\b\u0010\u001D\u001A\u00020\nH\u0016J\b\u0010\u001E\u001A\u00020\u001FH\u0016J\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001A\u00020%H\u0016R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006&"}, d2={"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "scheduleResumeAfterDelay", "timeMillis", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "cancelJobOnRejection", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "toString", "", "equals", "", "other", "", "hashCode", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    private final Executor executor;

    public ExecutorCoroutineDispatcherImpl(Executor arg1) {
        super();
        this.executor = arg1;
        ConcurrentKt.removeFutureOnCancel(this.getExecutor());
    }

    private final void cancelJobOnRejection(CoroutineContext arg1, RejectedExecutionException arg2) {
        JobKt.cancel(arg1, ExceptionsKt.CancellationException("The task was rejected", ((Throwable)arg2)));
    }

    public void close() {
        Executor v1 = this.getExecutor();
        if((v1 instanceof ExecutorService)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null) {
            ((ExecutorService)v1).shutdown();
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") public Object delay(long arg1, Continuation arg3) {
        return DefaultImpls.delay(((Delay)this), arg1, arg3);
    }

    public void dispatch(CoroutineContext arg3, Runnable arg4) {
        Runnable v1_1;
        AbstractTimeSource v1;
        try {
            Executor v0_1 = this.getExecutor();
            v1 = AbstractTimeSourceKt.timeSource;
            if(v1 != null) {
                v1_1 = v1.wrapTask(arg4);
                if(v1_1 == null) {
                    goto label_5;
                }
            }
            else {
            label_5:
                v1_1 = arg4;
            }

            v0_1.execute(v1_1);
            return;
        }
        catch(RejectedExecutionException v0) {
            v1 = AbstractTimeSourceKt.timeSource;
            if(v1 != null) {
                v1.unTrackTask();
            }

            this.cancelJobOnRejection(arg3, v0);
            Dispatchers.getIO().dispatch(arg3, arg4);
            return;
        }
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof ExecutorCoroutineDispatcherImpl)) && ((ExecutorCoroutineDispatcherImpl)arg2).getExecutor() == this.getExecutor()) {
            return 1;
        }

        return 0;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public int hashCode() {
        return System.identityHashCode(this.getExecutor());
    }

    public DisposableHandle invokeOnTimeout(long arg10, Runnable arg12, CoroutineContext arg13) {
        CoroutineContext v6;
        Runnable v5;
        long v7;
        Executor v0 = this.getExecutor();
        ScheduledFuture v2 = null;
        Executor v4 = (v0 instanceof ScheduledExecutorService) ? v0 : ((Executor)v2);
        if(v4 != null) {
            v7 = arg10;
            v5 = arg12;
            v6 = arg13;
            v2 = this.scheduleBlock(((ScheduledExecutorService)v4), v5, v6, v7);
        }
        else {
            v7 = arg10;
            v5 = arg12;
            v6 = arg13;
        }

        if(v2 != null) {
            return new DisposableFutureHandle(((Future)v2));
        }

        return DefaultExecutor.INSTANCE.invokeOnTimeout(v7, v5, v6);
    }

    private final ScheduledFuture scheduleBlock(ScheduledExecutorService arg2, Runnable arg3, CoroutineContext arg4, long arg5) {
        ScheduledFuture v1;
        try {
            v1 = arg2.schedule(arg3, arg5, TimeUnit.MILLISECONDS);
            return v1;
        }
        catch(RejectedExecutionException v2) {
            ((ExecutorCoroutineDispatcherImpl)v1).cancelJobOnRejection(arg4, v2);
            return null;
        }
    }

    public void scheduleResumeAfterDelay(long arg10, CancellableContinuation arg12) {
        long v7;
        Executor v0 = this.getExecutor();
        ScheduledFuture v2 = null;
        Executor v4 = (v0 instanceof ScheduledExecutorService) ? v0 : ((Executor)v2);
        if(v4 != null) {
            v7 = arg10;
            v2 = this.scheduleBlock(((ScheduledExecutorService)v4), new ResumeUndispatchedRunnable(this, arg12), arg12.getContext(), v7);
        }
        else {
            v7 = arg10;
        }

        if(v2 != null) {
            CancellableContinuationKt.invokeOnCancellation(arg12, new CancelFutureOnCancel(((Future)v2)));
            return;
        }

        DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(v7, arg12);
    }

    public String toString() {
        return this.getExecutor().toString();
    }
}

