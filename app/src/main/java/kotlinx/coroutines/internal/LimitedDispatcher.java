package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B!\u0012\u0006\u0010\u0003\u001A\u00020\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001A\u0010\u0014\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H\u0016J!\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u000Ej\u0002`\u000FH\u0016¢\u0006\u0002\u0010\u001AJ!\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u000Ej\u0002`\u000FH\u0017¢\u0006\u0002\u0010\u001AJ2\u0010\u001C\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u000Ej\u0002`\u000F2\u0016\u0010\u001D\u001A\u0012\u0012\b\u0012\u00060\u001FR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001EH\u0082\b¢\u0006\u0002\u0010 J\b\u0010!\u001A\u00020\"H\u0002J\u0015\u0010#\u001A\n\u0018\u00010\u000Ej\u0004\u0018\u0001`\u000FH\u0002¢\u0006\u0002\u0010$J\b\u0010%\u001A\u00020\u0007H\u0016J\u0016\u0010&\u001A\u00020\u00162\u0006\u0010\'\u001A\u00020(H\u0097A¢\u0006\u0002\u0010)J*\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020(2\n\u0010\u0019\u001A\u00060\u000Ej\u0002`\u000F2\u0006\u0010\u0017\u001A\u00020\u0018H\u0096\u0001¢\u0006\u0002\u0010-J\u001F\u0010.\u001A\u00020\u00162\u0006\u0010,\u001A\u00020(2\f\u0010/\u001A\b\u0012\u0004\u0012\u00020\u001600H\u0096\u0001R\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\n\u001A\u00020\u000BX\u0082\u0004R\u0018\u0010\f\u001A\f\u0012\b\u0012\u00060\u000Ej\u0002`\u000F0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00060\u0011j\u0002`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u00062"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "name", "", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;ILjava/lang/String;)V", "runningWorkers", "Lkotlinx/atomicfu/AtomicInt;", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Ljava/lang/Object;", "limitedParallelism", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "dispatchInternal", "startWorker", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "(Ljava/lang/Runnable;Lkotlin/jvm/functions/Function1;)V", "tryAllocateWorker", "", "obtainTaskOrDeallocateWorker", "()Ljava/lang/Runnable;", "toString", "delay", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Worker", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001A\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001A\u00020\bH\u0016R\u0014\u0010\u0003\u001A\u00060\u0001j\u0002`\u0002X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\t"}, d2={"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "<init>", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "Ljava/lang/Runnable;", "run", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Worker implements Runnable {
        private Runnable currentTask;

        public Worker(LimitedDispatcher arg1, Runnable arg2) {
            LimitedDispatcher.this = arg1;
            super();
            this.currentTask = arg2;
        }

        public void run() {
            int v0 = 0;
            try {
                do {
                label_1:
                    this.currentTask.run();
                    goto label_7;
                }
                while(true);
            }
            catch(Throwable v1) {
                try {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, v1);
                label_7:
                    Runnable v1_1 = LimitedDispatcher.this.obtainTaskOrDeallocateWorker();
                    if(v1_1 == null) {
                    }
                    else {
                        this.currentTask = v1_1;
                        ++v0;
                        if(v0 < 16) {
                            goto label_1;
                        }

                        if(!DispatchedContinuationKt.safeIsDispatchNeeded(LimitedDispatcher.this.dispatcher, LimitedDispatcher.this)) {
                            goto label_1;
                        }

                        DispatchedContinuationKt.safeDispatch(LimitedDispatcher.this.dispatcher, LimitedDispatcher.this, this);
                    }
                }
                catch(Throwable v0_1) {
                    Object v1_2 = LimitedDispatcher.this.workerAllocationLock;
                    LimitedDispatcher v3 = LimitedDispatcher.this;
                    __monitor_enter(v1_2);
                    try {
                        LimitedDispatcher.getRunningWorkers$volatile$FU().decrementAndGet(v3);
                    }
                    catch(Throwable v3_1) {
                        __monitor_exit(v1_2);
                        throw v3_1;
                    }

                    __monitor_exit(v1_2);
                    throw v0_1;
                }
            }
        }
    }

    private final CoroutineDispatcher dispatcher;
    private final String name;
    private final int parallelism;
    private final LockFreeTaskQueue queue;
    private final Object workerAllocationLock;

    static {
        LimitedDispatcher.runningWorkers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");
    }

    public LimitedDispatcher(CoroutineDispatcher arg2, int arg3, String arg4) {
        Delay v0_1;
        super();
        CoroutineDispatcher v0 = (arg2 instanceof Delay) ? arg2 : null;
        if(v0 == null) {
            v0_1 = DefaultExecutorKt.getDefaultDelay();
        }

        this.$$delegate_0 = v0_1;
        this.dispatcher = arg2;
        this.parallelism = arg3;
        this.name = arg4;
        this.queue = new LockFreeTaskQueue(false);
        this.workerAllocationLock = new Object();
    }

    public static final CoroutineDispatcher access$getDispatcher$p(LimitedDispatcher arg0) {
        return arg0.dispatcher;
    }

    public static final AtomicIntegerFieldUpdater access$getRunningWorkers$volatile$FU() {
        return LimitedDispatcher.getRunningWorkers$volatile$FU();
    }

    public static final Object access$getWorkerAllocationLock$p(LimitedDispatcher arg0) {
        return arg0.workerAllocationLock;
    }

    public static final Runnable access$obtainTaskOrDeallocateWorker(LimitedDispatcher arg0) {
        return arg0.obtainTaskOrDeallocateWorker();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") public Object delay(long arg1, Continuation arg3) {
        return this.$$delegate_0.delay(arg1, arg3);
    }

    public void dispatch(CoroutineContext arg2, Runnable arg3) {
        this.queue.addLast(arg3);
        if(LimitedDispatcher.getRunningWorkers$volatile$FU().get(this) < this.parallelism && (this.tryAllocateWorker())) {
            Runnable v2 = this.obtainTaskOrDeallocateWorker();
            if(v2 == null) {
            }
            else {
                try {
                    DispatchedContinuationKt.safeDispatch(this.dispatcher, this, new Worker(this, v2));
                    return;
                }
                catch(Throwable v2_1) {
                    LimitedDispatcher.getRunningWorkers$volatile$FU().decrementAndGet(this);
                    throw v2_1;
                }
            }
        }
    }

    private final void dispatchInternal(Runnable arg2, Function1 arg3) {
        this.queue.addLast(arg2);
        if(LimitedDispatcher.getRunningWorkers$volatile$FU().get(this) >= this.parallelism) {
        }
        else if(!this.tryAllocateWorker()) {
        }
        else {
            arg2 = this.obtainTaskOrDeallocateWorker();
            if(arg2 == null) {
                return;
            }

            goto label_13;
        }

        return;
        try {
        label_13:
            arg3.invoke(new Worker(this, arg2));
            return;
        }
        catch(Throwable v2) {
            LimitedDispatcher.getRunningWorkers$volatile$FU().decrementAndGet(this);
            throw v2;
        }
    }

    public void dispatchYield(CoroutineContext arg2, Runnable arg3) {
        this.queue.addLast(arg3);
        if(LimitedDispatcher.getRunningWorkers$volatile$FU().get(this) < this.parallelism && (this.tryAllocateWorker())) {
            Runnable v2 = this.obtainTaskOrDeallocateWorker();
            if(v2 == null) {
            }
            else {
                try {
                    this.dispatcher.dispatchYield(this, new Worker(this, v2));
                    return;
                }
                catch(Throwable v2_1) {
                    LimitedDispatcher.getRunningWorkers$volatile$FU().decrementAndGet(this);
                    throw v2_1;
                }
            }
        }
    }

    private final int getRunningWorkers$volatile() {
        return this.runningWorkers$volatile;
    }

    private static final AtomicIntegerFieldUpdater getRunningWorkers$volatile$FU() {
        return LimitedDispatcher.runningWorkers$volatile$FU;
    }

    public DisposableHandle invokeOnTimeout(long arg1, Runnable arg3, CoroutineContext arg4) {
        return this.$$delegate_0.invokeOnTimeout(arg1, arg3, arg4);
    }

    public CoroutineDispatcher limitedParallelism(int arg2, String arg3) {
        LimitedDispatcherKt.checkParallelism(arg2);
        if(arg2 >= this.parallelism) {
            return LimitedDispatcherKt.namedOrThis(((CoroutineDispatcher)this), arg3);
        }

        return super.limitedParallelism(arg2, arg3);
    }

    private final Runnable obtainTaskOrDeallocateWorker() {
        Object v0;
        while(true) {
            v0 = this.queue.removeFirstOrNull();
            if(v0 != null) {
                break;
            }

            v0 = this.workerAllocationLock;
            __monitor_enter(v0);
            try {
                LimitedDispatcher.getRunningWorkers$volatile$FU().decrementAndGet(this);
                if(this.queue.getSize() != 0) {
                    goto label_13;
                }
            }
            catch(Throwable v2) {
                goto label_18;
            }

            __monitor_exit(v0);
            return null;
            try {
            label_13:
                LimitedDispatcher.getRunningWorkers$volatile$FU().incrementAndGet(this);
            }
            catch(Throwable v2) {
            label_18:
                __monitor_exit(v0);
                throw v2;
            }

            __monitor_exit(v0);
        }

        return ((Runnable)v0);
    }

    public void scheduleResumeAfterDelay(long arg1, CancellableContinuation arg3) {
        this.$$delegate_0.scheduleResumeAfterDelay(arg1, arg3);
    }

    private final void setRunningWorkers$volatile(int arg1) {
        this.runningWorkers$volatile = arg1;
    }

    public String toString() {
        String v0 = this.name;
        if(v0 == null) {
            return this.dispatcher + ".limitedParallelism(" + this.parallelism + ')';
        }

        return v0;
    }

    private final boolean tryAllocateWorker() {
        Object v0 = this.workerAllocationLock;
        __monitor_enter(v0);
        try {
            if(LimitedDispatcher.getRunningWorkers$volatile$FU().get(this) < this.parallelism) {
                goto label_9;
            }
        }
        catch(Throwable v3) {
            goto label_15;
        }

        __monitor_exit(v0);
        return 0;
        try {
        label_9:
            LimitedDispatcher.getRunningWorkers$volatile$FU().incrementAndGet(this);
        }
        catch(Throwable v3) {
        label_15:
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return 1;
    }
}

