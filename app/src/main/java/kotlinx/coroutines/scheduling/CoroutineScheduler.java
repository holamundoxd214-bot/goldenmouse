package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003IJKB+\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0002J\"\u0010\u0015\u001A\u00020\u00162\n\u0010\u0017\u001A\u00060\u0018R\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u0004J\u0012\u0010\u001B\u001A\u00020\u00102\n\u0010\u0017\u001A\u00060\u0018R\u00020\u0000J\u000E\u0010\u001C\u001A\b\u0018\u00010\u0018R\u00020\u0000H\u0002J\u0014\u0010\u001D\u001A\u00020\u00042\n\u0010\u0017\u001A\u00060\u0018R\u00020\u0000H\u0002J\u0011\u0010!\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\u0007H\u0082\bJ\u0011\u0010\'\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\u0007H\u0082\bJ\u0011\u0010$\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\u0007H\u0086\bJ\t\u0010(\u001A\u00020\u0004H\u0082\bJ\t\u0010)\u001A\u00020\u0004H\u0082\bJ\t\u0010*\u001A\u00020\u0007H\u0082\bJ\t\u0010+\u001A\u00020\u0016H\u0082\bJ\t\u0010,\u001A\u00020\u0010H\u0082\bJ\t\u0010-\u001A\u00020\u0007H\u0082\bJ\u0014\u00102\u001A\u00020\u00162\n\u00103\u001A\u000604j\u0002`5H\u0016J\b\u00106\u001A\u00020\u0016H\u0016J\u000E\u00107\u001A\u00020\u00162\u0006\u00108\u001A\u00020\u0007J*\u00109\u001A\u00020\u00162\n\u0010:\u001A\u000604j\u0002`52\f\b\u0002\u0010;\u001A\u00060\u0010j\u0002`<2\b\b\u0002\u0010=\u001A\u00020\u0010J\u001E\u0010>\u001A\u00020\u00122\n\u0010:\u001A\u000604j\u0002`52\n\u0010;\u001A\u00060\u0010j\u0002`<J\u0010\u0010?\u001A\u00020\u00162\u0006\u0010@\u001A\u00020\u0007H\u0002J\u0006\u0010A\u001A\u00020\u0016J\u0012\u0010B\u001A\u00020\u00102\b\b\u0002\u0010&\u001A\u00020\u0007H\u0002J\b\u0010C\u001A\u00020\u0010H\u0002J\b\u0010D\u001A\u00020\u0004H\u0002J$\u0010E\u001A\u0004\u0018\u00010\u0012*\b\u0018\u00010\u0018R\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010=\u001A\u00020\u0010H\u0002J\u000E\u0010F\u001A\b\u0018\u00010\u0018R\u00020\u0000H\u0002J\b\u0010G\u001A\u00020\tH\u0016J\u000E\u0010H\u001A\u00020\u00162\u0006\u0010\u0011\u001A\u00020\u0012R\u0010\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010\u0013\u001A\u00020\u0014X\u0082\u0004R\u001A\u0010\u001E\u001A\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\u001F8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\t\u0010 \u001A\u00020\u0014X\u0082\u0004R\u0015\u0010!\u001A\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0015\u0010$\u001A\u00020\u00048Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010#R\t\u0010.\u001A\u00020/X\u0082\u0004R\u0011\u00100\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b0\u00101¨\u0006L"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "corePoolSize", "", "maxPoolSize", "idleWorkerKeepAliveNs", "", "schedulerName", "", "<init>", "(IIJLjava/lang/String;)V", "globalCpuQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "addToGlobalQueue", "", "task", "Lkotlinx/coroutines/scheduling/Task;", "parkedWorkersStack", "Lkotlinx/atomicfu/AtomicLong;", "parkedWorkersStackTopUpdate", "", "worker", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "oldIndex", "newIndex", "parkedWorkersStackPush", "parkedWorkersStackPop", "parkedWorkersStackNextIndex", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "controlState", "createdWorkers", "getCreatedWorkers", "()I", "availableCpuPermits", "getAvailableCpuPermits", "state", "blockingTasks", "incrementCreatedWorkers", "decrementCreatedWorkers", "incrementBlockingTasks", "decrementBlockingTasks", "tryAcquireCpuPermit", "releaseCpuPermit", "_isTerminated", "Lkotlinx/atomicfu/AtomicBoolean;", "isTerminated", "()Z", "execute", "command", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "close", "shutdown", "timeout", "dispatch", "block", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "fair", "createTask", "signalBlockingWork", "stateSnapshot", "signalCpuWork", "tryCreateWorker", "tryUnpark", "createNewWorker", "submitToLocalQueue", "currentWorker", "toString", "runSafely", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CoroutineScheduler implements Closeable, Executor {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "<init>", "()V", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "", "CLAIMED", "TERMINATED", "BLOCKING_SHIFT", "CREATED_MASK", "", "BLOCKING_MASK", "CPU_PERMITS_SHIFT", "CPU_PERMITS_MASK", "MIN_SUPPORTED_POOL_SIZE", "MAX_SUPPORTED_POOL_SIZE", "PARKED_INDEX_MASK", "PARKED_VERSION_MASK", "PARKED_VERSION_INC", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[WorkerState.values().length];
            try {
                v0[WorkerState.PARKING.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[WorkerState.BLOCKING.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[WorkerState.DORMANT.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[WorkerState.TERMINATED.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                            label_23:
                                WhenMappings.$EnumSwitchMapping$0 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010#\u001A\u00020$H\u0002J\u000E\u0010%\u001A\u00020$2\u0006\u0010&\u001A\u00020\u0016J\b\u0010\'\u001A\u00020(H\u0016J\b\u0010*\u001A\u00020(H\u0002J\u0006\u0010+\u001A\u00020\u001AJ\u0006\u0010,\u001A\u00020$J\b\u0010-\u001A\u00020(H\u0002J\b\u0010.\u001A\u00020$H\u0002J\u0010\u0010/\u001A\u00020(2\u0006\u00100\u001A\u00020\u0014H\u0002J\u000E\u00101\u001A\u00020\u00052\u0006\u00102\u001A\u00020\u0005J\b\u00103\u001A\u00020(H\u0002J\b\u00104\u001A\u00020(H\u0002J\u0010\u00105\u001A\u0004\u0018\u00010\u00142\u0006\u0010)\u001A\u00020$J\n\u00106\u001A\u0004\u0018\u00010\u0014H\u0002J\n\u00107\u001A\u0004\u0018\u00010\u0014H\u0002J\u0012\u00108\u001A\u0004\u0018\u00010\u00142\u0006\u00109\u001A\u00020$H\u0002J\n\u0010:\u001A\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010;\u001A\u0004\u0018\u00010\u00142\n\u0010<\u001A\u00060\u0005j\u0002`=H\u0002R$\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\r8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0010\u0010\u0010\u001A\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001A\u00020\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0006\u0010\u0017\u001A\u00020\u0018R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001B\u001A\u0004\u0018\u00010\u001CX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\u000E\u0010!\u001A\u00020\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0012\u0010)\u001A\u00020$8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006>"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "index", "", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "indexInArray", "getIndexInArray", "()I", "setIndexInArray", "(I)V", "scheduler", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "stolenTask", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlinx/coroutines/scheduling/Task;", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "workerCtl", "Lkotlinx/atomicfu/AtomicInt;", "terminationDeadline", "", "nextParkedWorker", "", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "tryAcquireCpuPermit", "", "tryReleaseCpu", "newState", "run", "", "mayHaveLocalTasks", "runWorker", "runSingleTask", "isIo", "tryPark", "inStack", "executeTask", "task", "nextInt", "upperBound", "park", "tryTerminateWorker", "findTask", "findBlockingTask", "findCpuTask", "findAnyTask", "scanLocalQueue", "pollGlobalQueues", "trySteal", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Worker extends Thread {
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private final ObjectRef stolenTask;
        private long terminationDeadline;

        static {
            Worker.workerCtl$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        }

        public Worker(CoroutineScheduler arg1, int arg2) {
            this(arg1);
            this.setIndexInArray(arg2);
        }

        private Worker(CoroutineScheduler arg3) {
            CoroutineScheduler.this = arg3;
            super();
            this.setDaemon(true);
            this.setContextClassLoader(arg3.getClass().getClassLoader());
            this.localQueue = new WorkQueue();
            this.stolenTask = new ObjectRef();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            int v3 = ((int)System.nanoTime());
            if(v3 != 0) {
            }
            else {
                v3 = 42;
            }

            this.rngState = v3;
        }

        public static final CoroutineScheduler access$getThis$0$p(Worker arg0) {
            return arg0.this$0;
        }

        private final void executeTask(Task arg4) {
            this.terminationDeadline = 0;
            if(this.state == WorkerState.PARKING) {
                if(DebugKt.getASSERTIONS_ENABLED()) {
                    if(arg4.taskContext) {
                    }
                    else {
                        throw new AssertionError();
                    }
                }

                this.state = WorkerState.BLOCKING;
            }

            if(arg4.taskContext) {
                if(this.tryReleaseCpu(WorkerState.BLOCKING)) {
                    CoroutineScheduler.this.signalCpuWork();
                }

                CoroutineScheduler.this.runSafely(arg4);
                CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState v4 = this.state;
                if(v4 != WorkerState.TERMINATED) {
                    if(DebugKt.getASSERTIONS_ENABLED()) {
                        if(v4 == WorkerState.BLOCKING) {
                        }
                        else {
                            throw new AssertionError();
                        }
                    }

                    this.state = WorkerState.DORMANT;
                }

                return;
            }

            CoroutineScheduler.this.runSafely(arg4);
        }

        private final Task findAnyTask(boolean arg2) {
            Task v2_1;
            Task v0;
            if(arg2) {
                int v2 = this.nextInt(CoroutineScheduler.this.corePoolSize * 2) == 0 ? 1 : 0;
                if(v2 != 0) {
                    v0 = this.pollGlobalQueues();
                    if(v0 != null) {
                        return v0;
                    }
                }

                v0 = this.localQueue.poll();
                if(v0 != null) {
                    return v0;
                }

                if(v2 != 0) {
                    goto label_24;
                }

                v2_1 = this.pollGlobalQueues();
                if(v2_1 == null) {
                    goto label_24;
                }

                return v2_1;
            }
            else {
                v2_1 = this.pollGlobalQueues();
                if(v2_1 == null) {
                    goto label_24;
                }

                return v2_1;
            }

        label_24:
            return this.trySteal(3);
        }

        private final Task findBlockingTask() {
            Task v0 = this.localQueue.pollBlocking();
            if(v0 == null) {
                Object v0_1 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                if(v0_1 == null) {
                    return this.trySteal(1);
                }
            }

            return v0;
        }

        private final Task findCpuTask() {
            Task v0 = this.localQueue.pollCpu();
            if(v0 == null) {
                Object v0_1 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
                if(v0_1 == null) {
                    return this.trySteal(2);
                }
            }

            return v0;
        }

        public final Task findTask(boolean arg2) {
            if(this.tryAcquireCpuPermit()) {
                return this.findAnyTask(arg2);
            }

            return this.findBlockingTask();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        public final int getWorkerCtl$volatile() {
            return this.workerCtl$volatile;
        }

        public static final AtomicIntegerFieldUpdater getWorkerCtl$volatile$FU() {
            return Worker.workerCtl$volatile$FU;
        }

        private final boolean inStack() {
            if(this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK) {
                return 1;
            }

            return 0;
        }

        public final boolean isIo() {
            if(this.state == WorkerState.BLOCKING) {
                return 1;
            }

            return 0;
        }

        public final int nextInt(int arg3) {
            int v0 = this.rngState ^ this.rngState << 13;
            v0 ^= v0 >> 17;
            v0 ^= v0 << 5;
            this.rngState = v0;
            int v2 = arg3 - 1;
            if((v2 & arg3) == 0) {
                return v2 & v0;
            }

            return (0x7FFFFFFF & v0) % arg3;
        }

        private final void park() {
            long v2 = 0;
            if(this.terminationDeadline == v2) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }

            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if(System.nanoTime() - this.terminationDeadline >= v2) {
                this.terminationDeadline = v2;
                this.tryTerminateWorker();
            }
        }

        private final Task pollGlobalQueues() {
            Object v0_1;
            int v0 = this.nextInt(2);
            CoroutineScheduler v1 = CoroutineScheduler.this;
            if(v0 == 0) {
                v0_1 = v1.globalCpuQueue.removeFirstOrNull();
                if(v0_1 != null) {
                    return ((Task)v0_1);
                }

                return CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }

            v0_1 = v1.globalBlockingQueue.removeFirstOrNull();
            if(v0_1 != null) {
                return ((Task)v0_1);
            }

            return CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        public void run() {
            this.runWorker();
        }

        public final long runSingleTask() {
            WorkerState v0 = this.state;
            int v1 = v0 == WorkerState.CPU_ACQUIRED ? 1 : 0;
            Task v2 = v1 != 0 ? this.findCpuTask() : this.findBlockingTask();
            long v3 = 0;
            if(v2 == null) {
                long v0_1 = this.minDelayUntilStealableTaskNs;
                if(v0_1 == v3) {
                    v0_1 = -1;
                }

                return v0_1;
            }

            CoroutineScheduler.this.runSafely(v2);
            if(v1 == 0) {
                CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, -2097152);
            }

            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(this.state == v0) {
                }
                else {
                    throw new AssertionError();
                }
            }

            return v3;
        }

        private final void runWorker() {
            while(true) {
            label_1:
                int v1 = 0;
                while(true) {
                label_2:
                    if(!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                        Task v2 = this.findTask(this.mayHaveLocalTasks);
                        long v3 = 0;
                        if(v2 != null) {
                            this.minDelayUntilStealableTaskNs = v3;
                            this.executeTask(v2);
                            goto label_1;
                        }
                        else {
                            this.mayHaveLocalTasks = false;
                            if(this.minDelayUntilStealableTaskNs == v3) {
                                break;
                            }
                            else if(v1 == 0) {
                                v1 = 1;
                                continue;
                            }
                            else {
                                this.tryReleaseCpu(WorkerState.PARKING);
                                Thread.interrupted();
                                LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                                this.minDelayUntilStealableTaskNs = v3;
                                goto label_1;
                            }
                        }
                    }

                    goto label_30;
                }
            }

            this.tryPark();
            goto label_2;
        label_30:
            this.tryReleaseCpu(WorkerState.TERMINATED);
        }

        public final void setIndexInArray(int arg3) {
            StringBuilder v0 = new StringBuilder().append(CoroutineScheduler.this.schedulerName).append("-worker-");
            String v1 = arg3 == 0 ? "TERMINATED" : String.valueOf(arg3);
            this.setName(v0.append(v1).toString());
            this.indexInArray = arg3;
        }

        public final void setNextParkedWorker(Object arg1) {
            this.nextParkedWorker = arg1;
        }

        public final void setWorkerCtl$volatile(int arg1) {
            this.workerCtl$volatile = arg1;
        }

        private final boolean tryAcquireCpuPermit() {
            if(this.state == WorkerState.CPU_ACQUIRED) {
                return 1;
            }

            CoroutineScheduler v4 = CoroutineScheduler.this;
            AtomicLongFieldUpdater v0 = CoroutineScheduler.getControlState$volatile$FU();
            do {
                long v5 = v0.get(v4);
                if((((int)((0x7FFFFC0000000000L & v5) >> 42))) == 0) {
                    return 0;
                }
            }
            while(!CoroutineScheduler.getControlState$volatile$FU().compareAndSet(v4, v5, v5 - 0x40000000000L));

            this.state = WorkerState.CPU_ACQUIRED;
            return 1;
        }

        private final void tryPark() {
            if(!this.inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush(this);
                return;
            }

            int v1 = -1;
            Worker.getWorkerCtl$volatile$FU().set(this, v1);
            while(this.inStack()) {
                if(Worker.getWorkerCtl$volatile$FU().get(this) != v1) {
                    return;
                }

                if(CoroutineScheduler.this.isTerminated()) {
                    return;
                }

                if(this.state == WorkerState.TERMINATED) {
                }
                else {
                    this.tryReleaseCpu(WorkerState.PARKING);
                    Thread.interrupted();
                    this.park();
                    continue;
                }

                return;
            }
        }

        public final boolean tryReleaseCpu(WorkerState arg7) {
            WorkerState v0 = this.state;
            boolean v1 = v0 == WorkerState.CPU_ACQUIRED ? true : false;
            if(v1) {
                CoroutineScheduler.getControlState$volatile$FU().addAndGet(CoroutineScheduler.this, 0x40000000000L);
            }

            if(v0 != arg7) {
                this.state = arg7;
            }

            return v1;
        }

        private final Task trySteal(int arg18) {
            long v10;
            Worker v0 = this;
            int v1 = ((int)(CoroutineScheduler.getControlState$volatile$FU().get(v0.this$0) & 0x1FFFFF));
            Task v3 = null;
            if(v1 < 2) {
                return v3;
            }

            int v2 = v0.nextInt(v1);
            CoroutineScheduler v4 = v0.this$0;
            long v5 = 0x7FFFFFFFFFFFFFFFL;
            int v7 = 0;
            long v8 = v5;
            while(true) {
                v10 = 0;
                if(v7 >= v1) {
                    break;
                }

                ++v2;
                if(v2 > v1) {
                    v2 = 1;
                }

                Object v12 = v4.workers.get(v2);
                if(v12 != null && (((Worker)v12)) != v0) {
                    long v12_1 = ((Worker)v12).localQueue.trySteal(arg18, v0.stolenTask);
                    if(v12_1 == -1) {
                        Object v1_1 = v0.stolenTask.element;
                        v0.stolenTask.element = v3;
                        return ((Task)v1_1);
                    }
                    else if(v12_1 > v10) {
                        v8 = Math.min(v8, v12_1);
                    }
                }

                ++v7;
            }

            if(v8 != v5) {
            }
            else {
                v8 = v10;
            }

            v0.minDelayUntilStealableTaskNs = v8;
            return v3;
        }

        private final void tryTerminateWorker() {
            long v4;
            ResizableAtomicArray v0 = CoroutineScheduler.this.workers;
            CoroutineScheduler v1 = CoroutineScheduler.this;
            __monitor_enter(v0);
            try {
                if(!v1.isTerminated()) {
                    goto label_8;
                }
            }
            catch(Throwable v8) {
                goto label_49;
            }

            __monitor_exit(v0);
            return;
            try {
            label_8:
                v4 = 0x1FFFFF;
                if((((int)(CoroutineScheduler.getControlState$volatile$FU().get(v1) & v4))) > v1.corePoolSize) {
                    goto label_17;
                }
            }
            catch(Throwable v8) {
                goto label_49;
            }

            __monitor_exit(v0);
            return;
            try {
            label_17:
                if(Worker.getWorkerCtl$volatile$FU().compareAndSet(this, -1, 1)) {
                    goto label_24;
                }
            }
            catch(Throwable v8) {
                goto label_49;
            }

            __monitor_exit(v0);
            return;
            try {
            label_24:
                int v2 = this.indexInArray;
                this.setIndexInArray(0);
                v1.parkedWorkersStackTopUpdate(this, v2, 0);
                int v3 = ((int)(CoroutineScheduler.getControlState$volatile$FU().getAndDecrement(v1) & v4));
                if(v3 != v2) {
                    Object v4_1 = v1.workers.get(v3);
                    Intrinsics.checkNotNull(v4_1);
                    v1.workers.setSynchronized(v2, v4_1);
                    ((Worker)v4_1).setIndexInArray(v2);
                    v1.parkedWorkersStackTopUpdate(((Worker)v4_1), v3, v2);
                }

                v1.workers.setSynchronized(v3, null);
            }
            catch(Throwable v8) {
            label_49:
                __monitor_exit(v0);
                throw v8;
            }

            __monitor_exit(v0);
            this.state = WorkerState.TERMINATED;
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2={"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public enum WorkerState {
        public static final enum WorkerState BLOCKING;
        public static final enum WorkerState CPU_ACQUIRED;
        public static final enum WorkerState DORMANT;
        public static final enum WorkerState PARKING;
        public static final enum WorkerState TERMINATED;

        private static final WorkerState[] $values() {
            return new WorkerState[]{WorkerState.CPU_ACQUIRED, WorkerState.BLOCKING, WorkerState.PARKING, WorkerState.DORMANT, WorkerState.TERMINATED};
        }

        static {
            WorkerState.CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
            WorkerState.BLOCKING = new WorkerState("BLOCKING", 1);
            WorkerState.PARKING = new WorkerState("PARKING", 2);
            WorkerState.DORMANT = new WorkerState("DORMANT", 3);
            WorkerState.TERMINATED = new WorkerState("TERMINATED", 4);
            WorkerState[] v0 = WorkerState.$values();
            WorkerState.$VALUES = v0;
            WorkerState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private WorkerState(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return WorkerState.$ENTRIES;
        }

        public static WorkerState valueOf(String arg1) {
            return Enum.valueOf(WorkerState.class, arg1);
        }

        public static WorkerState[] values() {
            return WorkerState.$VALUES.clone();
        }
    }

    private static final long BLOCKING_MASK = 0x3FFFFE00000L;
    private static final int BLOCKING_SHIFT = 21;
    private static final int CLAIMED = 0;
    private static final long CPU_PERMITS_MASK = 0x7FFFFC0000000000L;
    private static final int CPU_PERMITS_SHIFT = 42;
    private static final long CREATED_MASK = 0x1FFFFF;
    public static final Companion Companion = null;
    public static final int MAX_SUPPORTED_POOL_SIZE = 0x1FFFFE;
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    public static final Symbol NOT_IN_STACK = null;
    private static final int PARKED = -1;
    private static final long PARKED_INDEX_MASK = 0x1FFFFF;
    private static final long PARKED_VERSION_INC = 0x200000;
    private static final long PARKED_VERSION_MASK = -2097152;
    private static final int TERMINATED = 1;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    public final String schedulerName;
    public final ResizableAtomicArray workers;

    static {
        CoroutineScheduler.Companion = new Companion(null);
        Class v1 = CoroutineScheduler.class;
        CoroutineScheduler.parkedWorkersStack$volatile$FU = AtomicLongFieldUpdater.newUpdater(v1, "parkedWorkersStack$volatile");
        CoroutineScheduler.controlState$volatile$FU = AtomicLongFieldUpdater.newUpdater(v1, "controlState$volatile");
        CoroutineScheduler._isTerminated$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v1, "_isTerminated$volatile");
        CoroutineScheduler.NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    }

    public CoroutineScheduler(int arg3, int arg4, long arg5, String arg7) {
        super();
        this.corePoolSize = arg3;
        this.maxPoolSize = arg4;
        this.idleWorkerKeepAliveNs = arg5;
        this.schedulerName = arg7;
        if(arg3 >= 1) {
            arg7 = "Max pool size ";
            if(arg4 >= arg3) {
                if(arg4 <= 0x1FFFFE) {
                    if(arg5 > 0) {
                        this.globalCpuQueue = new GlobalQueue();
                        this.globalBlockingQueue = new GlobalQueue();
                        this.workers = new ResizableAtomicArray((arg3 + 1) * 2);
                        this.controlState$volatile = (((long)arg3)) << 42;
                        return;
                    }

                    throw new IllegalArgumentException("Idle worker keep alive time " + arg5 + " must be positive".toString());
                }

                throw new IllegalArgumentException(arg7 + arg4 + " should not exceed maximal supported number of threads 2097150".toString());
            }

            throw new IllegalArgumentException(arg7 + arg4 + " should be greater than or equals to core pool size " + arg3.toString());
        }

        throw new IllegalArgumentException("Core pool size " + arg3 + " should be at least 1".toString());
    }

    public CoroutineScheduler(int arg7, int arg8, long arg9, String arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 4) != 0) {
            arg9 = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }

        long v3 = arg9;
        if((arg12 & 8) != 0) {
            arg11 = TasksKt.DEFAULT_SCHEDULER_NAME;
        }

        this(arg7, arg8, v3, arg11);
    }

    public static final AtomicLongFieldUpdater access$getControlState$volatile$FU() {
        return CoroutineScheduler.getControlState$volatile$FU();
    }

    private final boolean addToGlobalQueue(Task arg2) {
        if(arg2.taskContext) {
            return this.globalBlockingQueue.addLast(arg2);
        }

        return this.globalCpuQueue.addLast(arg2);
    }

    public final int availableCpuPermits(long arg3) {
        return ((int)((arg3 & 0x7FFFFC0000000000L) >> 42));
    }

    private final int blockingTasks(long arg3) {
        return ((int)((arg3 & 0x3FFFFE00000L) >> 21));
    }

    public void close() {
        this.shutdown(10000);
    }

    private final int createNewWorker() {
        Worker v5_1;
        int v1_1;
        long v3;
        ResizableAtomicArray v0 = this.workers;
        __monitor_enter(v0);
        try {
            if(!this.isTerminated()) {
                goto label_7;
            }
        }
        catch(Throwable v8) {
            goto label_61;
        }

        __monitor_exit(v0);
        return -1;
        try {
        label_7:
            long v1 = CoroutineScheduler.getControlState$volatile$FU().get(this);
            v3 = 0x1FFFFF;
            int v5 = ((int)(v1 & v3));
            v1_1 = RangesKt.coerceAtLeast(v5 - (((int)((v1 & 0x3FFFFE00000L) >> 21))), 0);
            if(v1_1 < this.corePoolSize) {
                goto label_24;
            }
        }
        catch(Throwable v8) {
            goto label_61;
        }

        __monitor_exit(v0);
        return 0;
        try {
        label_24:
            if(v5 < this.maxPoolSize) {
                goto label_28;
            }
        }
        catch(Throwable v8) {
            goto label_61;
        }

        __monitor_exit(v0);
        return 0;
        try {
        label_28:
            int v2 = (((int)(CoroutineScheduler.getControlState$volatile$FU().get(this) & v3))) + 1;
            if(v2 > 0 && this.workers.get(v2) == null) {
                v5_1 = new Worker(this, v2);
                this.workers.setSynchronized(v2, v5_1);
                if(v2 == (((int)(v3 & CoroutineScheduler.getControlState$volatile$FU().incrementAndGet(this))))) {
                    goto label_46;
                }
                else {
                    goto label_50;
                }
            }

            goto label_55;
        }
        catch(Throwable v8) {
            goto label_61;
        }

    label_46:
        __monitor_exit(v0);
        v5_1.start();
        return v1_1 + 1;
        try {
        label_50:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_55:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        catch(Throwable v8) {
        label_61:
            __monitor_exit(v0);
            throw v8;
        }
    }

    public final Task createTask(Runnable arg3, boolean arg4) {
        long v0 = TasksKt.schedulerTimeSource.nanoTime();
        if((arg3 instanceof Task)) {
            ((Task)arg3).submissionTime = v0;
            ((Task)arg3).taskContext = arg4;
            return arg3;
        }

        return TasksKt.asTask(arg3, v0, arg4);
    }

    private final int createdWorkers(long arg3) {
        return ((int)(arg3 & 0x1FFFFF));
    }

    private final Worker currentWorker() {
        Thread v0 = Thread.currentThread();
        Worker v2 = null;
        if((v0 instanceof Worker)) {
        }
        else {
            v0 = ((Thread)v2);
        }

        if(v0 != null && (Intrinsics.areEqual(Worker.access$getThis$0$p(((Worker)v0)), this))) {
            return ((Worker)v0);
        }

        return v2;
    }

    private final void decrementBlockingTasks() {
        CoroutineScheduler.getControlState$volatile$FU().addAndGet(this, -2097152);
    }

    private final int decrementCreatedWorkers() {
        return ((int)(CoroutineScheduler.getControlState$volatile$FU().getAndDecrement(this) & 0x1FFFFF));
    }

    public final void dispatch(Runnable arg4, boolean arg5, boolean arg6) {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        if(v0 != null) {
            v0.trackTask();
        }

        Task v4 = this.createTask(arg4, arg5);
        arg5 = v4.taskContext;
        long v0_1 = arg5 ? CoroutineScheduler.getControlState$volatile$FU().addAndGet(this, 0x200000) : 0;
        v4 = this.submitToLocalQueue(this.currentWorker(), v4, arg6);
        if(v4 != null) {
            if(this.addToGlobalQueue(v4)) {
            }
            else {
                throw new RejectedExecutionException(this.schedulerName + " was terminated");
            }
        }

        if(arg5) {
            this.signalBlockingWork(v0_1);
            return;
        }

        this.signalCpuWork();
    }

    public static void dispatch$default(CoroutineScheduler arg1, Runnable arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        arg1.dispatch(arg2, false, false);
    }

    public void execute(Runnable arg7) {
        CoroutineScheduler.dispatch$default(this, arg7, false, false, 6, null);
    }

    private final int getAvailableCpuPermits() {
        return ((int)((CoroutineScheduler.getControlState$volatile$FU().get(this) & 0x7FFFFC0000000000L) >> 42));
    }

    private final long getControlState$volatile() {
        return this.controlState$volatile;
    }

    private static final AtomicLongFieldUpdater getControlState$volatile$FU() {
        return CoroutineScheduler.controlState$volatile$FU;
    }

    private final int getCreatedWorkers() {
        return ((int)(CoroutineScheduler.getControlState$volatile$FU().get(this) & 0x1FFFFF));
    }

    private final long getParkedWorkersStack$volatile() {
        return this.parkedWorkersStack$volatile;
    }

    private static final AtomicLongFieldUpdater getParkedWorkersStack$volatile$FU() {
        return CoroutineScheduler.parkedWorkersStack$volatile$FU;
    }

    private final int get_isTerminated$volatile() {
        return this._isTerminated$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_isTerminated$volatile$FU() {
        return CoroutineScheduler._isTerminated$volatile$FU;
    }

    private final long incrementBlockingTasks() {
        return CoroutineScheduler.getControlState$volatile$FU().addAndGet(this, 0x200000);
    }

    private final int incrementCreatedWorkers() {
        return ((int)(CoroutineScheduler.getControlState$volatile$FU().incrementAndGet(this) & 0x1FFFFF));
    }

    public final boolean isTerminated() {
        if(CoroutineScheduler.get_isTerminated$volatile$FU().get(this) == 1) {
            return 1;
        }

        return 0;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater arg3, Object arg4, Function1 arg5) {
        while(true) {
            arg5.invoke(Long.valueOf(arg3.get(arg4)));
        }
    }

    private final int parkedWorkersStackNextIndex(Worker arg1) {
        Object v0;
        for(v0 = arg1.getNextParkedWorker(); v0 != CoroutineScheduler.NOT_IN_STACK; v0 = ((Worker)v0).getNextParkedWorker()) {
            if(v0 == null) {
                return 0;
            }

            int v1 = ((Worker)v0).getIndexInArray();
            if(v1 != 0) {
                return v1;
            }
        }

        return -1;
    }

    private final Worker parkedWorkersStackPop() {
        AtomicLongFieldUpdater v0 = CoroutineScheduler.getParkedWorkersStack$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            Object v7 = this.workers.get(((int)(0x1FFFFF & v3)));
            if(v7 == null) {
                return null;
            }

            long v1 = 0x200000 + v3 & -2097152;
            int v5 = this.parkedWorkersStackNextIndex(((Worker)v7));
            if(v5 < 0) {
                continue;
            }

            long v8 = v1;
            CoroutineScheduler v2 = this;
            if(CoroutineScheduler.getParkedWorkersStack$volatile$FU().compareAndSet(v2, v3, (((long)v5)) | v8)) {
                ((Worker)v7).setNextParkedWorker(CoroutineScheduler.NOT_IN_STACK);
                return ((Worker)v7);
            }

            this = v2;
        }

        return null;
    }

    public final boolean parkedWorkersStackPush(Worker arg10) {
        if(arg10.getNextParkedWorker() != CoroutineScheduler.NOT_IN_STACK) {
            return 0;
        }

        AtomicLongFieldUpdater v0 = CoroutineScheduler.getParkedWorkersStack$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            int v1 = ((int)(0x1FFFFF & v3));
            long v5 = 0x200000 + v3 & -2097152;
            int v2 = arg10.getIndexInArray();
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(v2 != 0) {
                }
                else {
                    throw new AssertionError();
                }
            }

            arg10.setNextParkedWorker(this.workers.get(v1));
            v5 |= ((long)v2);
            CoroutineScheduler v2_1 = this;
            if(CoroutineScheduler.getParkedWorkersStack$volatile$FU().compareAndSet(v2_1, v3, v5)) {
                return 1;
            }

            this = v2_1;
        }
    }

    public final void parkedWorkersStackTopUpdate(Worker arg10, int arg11, int arg12) {
        AtomicLongFieldUpdater v0 = CoroutineScheduler.getParkedWorkersStack$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            int v1 = ((int)(0x1FFFFF & v3));
            long v5 = 0x200000 + v3 & -2097152;
            if(v1 == arg11) {
                v1 = arg12 == 0 ? this.parkedWorkersStackNextIndex(arg10) : arg12;
            }

            if(v1 < 0) {
                continue;
            }

            CoroutineScheduler v2 = this;
            if(CoroutineScheduler.getParkedWorkersStack$volatile$FU().compareAndSet(v2, v3, v5 | (((long)v1)))) {
                return;
            }

            this = v2;
        }
    }

    private final long releaseCpuPermit() {
        return CoroutineScheduler.getControlState$volatile$FU().addAndGet(this, 0x40000000000L);
    }

    public final void runSafely(Task arg2) {
        AbstractTimeSource v1_1;
        try {
            arg2.run();
        }
        catch(Throwable v1) {
            try {
                Thread v2 = Thread.currentThread();
                v2.getUncaughtExceptionHandler().uncaughtException(v2, v1);
            }
            catch(Throwable v1) {
                AbstractTimeSource v2_1 = AbstractTimeSourceKt.timeSource;
                if(v2_1 != null) {
                    v2_1.unTrackTask();
                }

                throw v1;
            }

            v1_1 = AbstractTimeSourceKt.timeSource;
            if(v1_1 == null) {
                return;
            }

            v1_1.unTrackTask();
            return;
        }

        v1_1 = AbstractTimeSourceKt.timeSource;
        if(v1_1 != null) {
            v1_1.unTrackTask();
            return;
        }
    }

    private final void setControlState$volatile(long arg1) {
        this.controlState$volatile = arg1;
    }

    private final void setParkedWorkersStack$volatile(long arg1) {
        this.parkedWorkersStack$volatile = arg1;
    }

    private final void set_isTerminated$volatile(int arg1) {
        this._isTerminated$volatile = arg1;
    }

    public final void shutdown(long arg8) {
        Task v8;
        long v3;
        if(!CoroutineScheduler.get_isTerminated$volatile$FU().compareAndSet(this, 0, 1)) {
            return;
        }

        Worker v0 = this.currentWorker();
        ResizableAtomicArray v1 = this.workers;
        __monitor_enter(v1);
        try {
            v3 = CoroutineScheduler.getControlState$volatile$FU().get(this);
        }
        catch(Throwable v7) {
            __monitor_exit(v1);
            throw v7;
        }

        int v3_1 = ((int)(v3 & 0x1FFFFF));
        __monitor_exit(v1);
        if(1 <= v3_1) {
            int v1_1;
            for(v1_1 = 1; true; ++v1_1) {
                Object v4 = this.workers.get(v1_1);
                Intrinsics.checkNotNull(v4);
                if((((Worker)v4)) != v0) {
                    while(((Worker)v4).getState() != Thread$State.TERMINATED) {
                        LockSupport.unpark(v4);
                        ((Worker)v4).join(arg8);
                    }

                    if(DebugKt.getASSERTIONS_ENABLED()) {
                        if(((Worker)v4).state == WorkerState.TERMINATED) {
                        }
                        else {
                            throw new AssertionError();
                        }
                    }

                    ((Worker)v4).localQueue.offloadAllWorkTo(this.globalBlockingQueue);
                }

                if(v1_1 == v3_1) {
                    break;
                }
            }
        }

        this.globalBlockingQueue.close();
        this.globalCpuQueue.close();
        while(true) {
            if(v0 != null) {
                v8 = v0.findTask(true);
                if(v8 == null) {
                    goto label_50;
                }
            }
            else {
            label_50:
                Object v8_1 = this.globalCpuQueue.removeFirstOrNull();
                if(v8_1 == null) {
                    v8_1 = this.globalBlockingQueue.removeFirstOrNull();
                    if(v8_1 == null) {
                        if(v0 != null) {
                            v0.tryReleaseCpu(WorkerState.TERMINATED);
                        }

                        if(DebugKt.getASSERTIONS_ENABLED()) {
                            if((((int)((CoroutineScheduler.getControlState$volatile$FU().get(this) & 0x7FFFFC0000000000L) >> 42))) == this.corePoolSize) {
                            }
                            else {
                                throw new AssertionError();
                            }
                        }

                        CoroutineScheduler.getParkedWorkersStack$volatile$FU().set(this, 0);
                        CoroutineScheduler.getControlState$volatile$FU().set(this, 0);
                        return;
                    }
                }
            }

            this.runSafely(v8);
        }
    }

    private final void signalBlockingWork(long arg2) {
        if(this.tryUnpark()) {
        }
        else {
            if(this.tryCreateWorker(arg2)) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        this.tryUnpark();
    }

    public final void signalCpuWork() {
        if(this.tryUnpark()) {
        }
        else {
            if(CoroutineScheduler.tryCreateWorker$default(this, 0, 1, null)) {
                return;
            }

            goto label_9;
        }

        return;
    label_9:
        this.tryUnpark();
    }

    private final Task submitToLocalQueue(Worker arg2, Task arg3, boolean arg4) {
        if(arg2 == null) {
        }
        else if(arg2.state == WorkerState.TERMINATED) {
        }
        else {
            if(!arg3.taskContext && arg2.state == WorkerState.BLOCKING) {
                return arg3;
            }

            goto label_12;
        }

        return arg3;
    label_12:
        arg2.mayHaveLocalTasks = true;
        return arg2.localQueue.add(arg3, arg4);
    }

    public String toString() {
        ArrayList v0 = new ArrayList();
        int v1 = this.workers.currentLength();
        int v2 = 0;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8;
        for(v8 = 1; v8 < v1; ++v8) {
            Object v9 = this.workers.get(v8);
            if(v9 == null) {
            }
            else {
                int v10 = ((Worker)v9).localQueue.getSize$kotlinx_coroutines_core();
                int v9_1 = WhenMappings.$EnumSwitchMapping$0[((Worker)v9).state.ordinal()];
                if(v9_1 == 1) {
                    ++v5;
                }
                else if(v9_1 == 2) {
                    ++v4;
                    v0.add(v10 + 'b');
                }
                else if(v9_1 == 3) {
                    ++v2;
                    v0.add(v10 + 'c');
                }
                else if(v9_1 == 4) {
                    ++v6;
                    if(v10 > 0) {
                        v0.add(v10 + 'd');
                    }
                }
                else if(v9_1 == 5) {
                    ++v7;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }

        long v8_1 = CoroutineScheduler.getControlState$volatile$FU().get(this);
        StringBuilder v1_1 = new StringBuilder();
        v1_1.append(this.schedulerName).append('@').append(DebugStringsKt.getHexAddress(this)).append("[Pool Size {core = ").append(this.corePoolSize).append(", max = ").append(this.maxPoolSize).append("}, Worker States {CPU = ").append(v2).append(", blocking = ").append(v4).append(", parked = ").append(v5).append(", dormant = ").append(v6).append(", terminated = ").append(v7).append("}, running workers queues = ").append(v0).append(", global CPU queue size = ").append(this.globalCpuQueue.getSize()).append(", global blocking queue size = ").append(this.globalBlockingQueue.getSize());
        v1_1.append(", Control State {created workers= ").append(((int)(0x1FFFFF & v8_1))).append(", blocking tasks = ").append(((int)((0x3FFFFE00000L & v8_1) >> 21))).append(", CPUs acquired = ").append(this.corePoolSize - (((int)((0x7FFFFC0000000000L & v8_1) >> 42)))).append("}]");
        return v1_1.toString();
    }

    private final boolean tryAcquireCpuPermit() {
        AtomicLongFieldUpdater v0 = CoroutineScheduler.getControlState$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            if((((int)((0x7FFFFC0000000000L & v3) >> 42))) == 0) {
                return 0;
            }

            CoroutineScheduler v2 = this;
            if(CoroutineScheduler.getControlState$volatile$FU().compareAndSet(v2, v3, v3 - 0x40000000000L)) {
                return 1;
            }

            this = v2;
        }

        return 0;
    }

    private final boolean tryCreateWorker(long arg4) {
        if(RangesKt.coerceAtLeast((((int)(0x1FFFFF & arg4))) - (((int)((arg4 & 0x3FFFFE00000L) >> 21))), 0) < this.corePoolSize) {
            int v5 = this.createNewWorker();
            if(v5 == 1 && this.corePoolSize > 1) {
                this.createNewWorker();
            }

            if(v5 <= 0) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    static boolean tryCreateWorker$default(CoroutineScheduler arg0, long arg1, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = CoroutineScheduler.getControlState$volatile$FU().get(arg0);
        }

        return arg0.tryCreateWorker(arg1);
    }

    private final boolean tryUnpark() {
        Worker v0;
        do {
            v0 = this.parkedWorkersStackPop();
            if(v0 == null) {
                return 0;
            }
        }
        while(!Worker.getWorkerCtl$volatile$FU().compareAndSet(v0, -1, 0));

        LockSupport.unpark(((Thread)v0));
        return 1;
    }
}

