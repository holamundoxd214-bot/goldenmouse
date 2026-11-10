package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.DebugKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001A\u0004\u0018\u00010\fJ\u001A\u0010\u0014\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001A\u00020\f2\b\b\u0002\u0010\u0016\u001A\u00020\u0017J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001A\u00020\fH\u0002J\"\u0010\u0019\u001A\u00020\u001A2\n\u0010\u001B\u001A\u00060\u0005j\u0002`\u001C2\u000E\u0010\u001D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001EJ\u0016\u0010\u001F\u001A\u0004\u0018\u00010\f2\n\u0010\u001B\u001A\u00060\u0005j\u0002`\u001CH\u0002J\b\u0010 \u001A\u0004\u0018\u00010\fJ\b\u0010!\u001A\u0004\u0018\u00010\fJ\u0012\u0010\"\u001A\u0004\u0018\u00010\f2\u0006\u0010#\u001A\u00020\u0017H\u0002J\u001A\u0010$\u001A\u0004\u0018\u00010\f2\u0006\u0010%\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\u0017H\u0002J\u000E\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020)J$\u0010*\u001A\u00020\u001A2\n\u0010\u001B\u001A\u00060\u0005j\u0002`\u001C2\u000E\u0010\u001D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001EH\u0002J\u0010\u0010+\u001A\u00020\u00172\u0006\u0010,\u001A\u00020)H\u0002J\n\u0010-\u001A\u0004\u0018\u00010\fH\u0002J\u000E\u0010.\u001A\u00020\'*\u0004\u0018\u00010\fH\u0002R\u0014\u0010\u0004\u001A\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000EX\u0082\u0004R\t\u0010\u000F\u001A\u00020\u0010X\u0082\u0004R\t\u0010\u0011\u001A\u00020\u0010X\u0082\u0004R\t\u0010\u0012\u001A\u00020\u0010X\u0082\u0004¨\u0006/"}, d2={"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "<init>", "()V", "bufferSize", "", "getBufferSize", "()I", "size", "getSize$kotlinx_coroutines_core", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Lkotlinx/coroutines/scheduling/Task;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicRef;", "producerIndex", "Lkotlinx/atomicfu/AtomicInt;", "consumerIndex", "blockingTasksInBuffer", "poll", "add", "task", "fair", "", "addLast", "trySteal", "", "stealingMode", "Lkotlinx/coroutines/scheduling/StealingMode;", "stolenTaskRef", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stealWithExclusiveMode", "pollBlocking", "pollCpu", "pollWithExclusiveMode", "onlyBlocking", "tryExtractFromTheMiddle", "index", "offloadAllWorkTo", "", "globalQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "tryStealLastScheduled", "pollTo", "queue", "pollBuffer", "decrementIfBlocking", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class WorkQueue {
    private final AtomicReferenceArray buffer;

    static {
        Class v0 = Object.class;
        Class v2 = WorkQueue.class;
        WorkQueue.lastScheduledTask$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "lastScheduledTask$volatile");
        WorkQueue.producerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v2, "producerIndex$volatile");
        WorkQueue.consumerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v2, "consumerIndex$volatile");
        WorkQueue.blockingTasksInBuffer$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v2, "blockingTasksInBuffer$volatile");
    }

    public WorkQueue() {
        super();
        this.buffer = new AtomicReferenceArray(0x80);
    }

    public final Task add(Task arg1, boolean arg2) {
        if(arg2) {
            return this.addLast(arg1);
        }

        Object v1 = WorkQueue.getLastScheduledTask$volatile$FU().getAndSet(this, arg1);
        if(v1 == null) {
            return null;
        }

        return this.addLast(((Task)v1));
    }

    public static Task add$default(WorkQueue arg0, Task arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.add(arg1, false);
    }

    private final Task addLast(Task arg3) {
        int v1 = 0x7F;
        if(this.getBufferSize() == v1) {
            return arg3;
        }

        if(arg3.taskContext) {
            WorkQueue.getBlockingTasksInBuffer$volatile$FU().incrementAndGet(this);
        }

        int v0 = WorkQueue.getProducerIndex$volatile$FU().get(this) & v1;
        while(this.buffer.get(v0) != null) {
            Thread.yield();
        }

        this.buffer.lazySet(v0, arg3);
        WorkQueue.getProducerIndex$volatile$FU().incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task arg1) {
        if(arg1 != null && (arg1.taskContext)) {
            int v0 = WorkQueue.getBlockingTasksInBuffer$volatile$FU().decrementAndGet(this);
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(v0 >= 0) {
                    return;
                }
                else {
                    throw new AssertionError();
                }
            }
        }
    }

    private final int getBlockingTasksInBuffer$volatile() {
        return this.blockingTasksInBuffer$volatile;
    }

    private static final AtomicIntegerFieldUpdater getBlockingTasksInBuffer$volatile$FU() {
        return WorkQueue.blockingTasksInBuffer$volatile$FU;
    }

    private final int getBufferSize() {
        return WorkQueue.getProducerIndex$volatile$FU().get(this) - WorkQueue.getConsumerIndex$volatile$FU().get(this);
    }

    private final int getConsumerIndex$volatile() {
        return this.consumerIndex$volatile;
    }

    private static final AtomicIntegerFieldUpdater getConsumerIndex$volatile$FU() {
        return WorkQueue.consumerIndex$volatile$FU;
    }

    private final Object getLastScheduledTask$volatile() {
        return this.lastScheduledTask$volatile;
    }

    private static final AtomicReferenceFieldUpdater getLastScheduledTask$volatile$FU() {
        return WorkQueue.lastScheduledTask$volatile$FU;
    }

    private final int getProducerIndex$volatile() {
        return this.producerIndex$volatile;
    }

    private static final AtomicIntegerFieldUpdater getProducerIndex$volatile$FU() {
        return WorkQueue.producerIndex$volatile$FU;
    }

    public final int getSize$kotlinx_coroutines_core() {
        Object v0 = WorkQueue.getLastScheduledTask$volatile$FU().get(this);
        int v1 = this.getBufferSize();
        if(v0 != null) {
            ++v1;
        }

        return v1;
    }

    public final void offloadAllWorkTo(GlobalQueue arg3) {
        Object v0 = WorkQueue.getLastScheduledTask$volatile$FU().getAndSet(this, null);
        if(v0 != null) {
            arg3.addLast(v0);
        }

        do {
        }
        while(this.pollTo(arg3));
    }

    public final Task poll() {
        Object v0 = WorkQueue.getLastScheduledTask$volatile$FU().getAndSet(this, null);
        if(v0 == null) {
            return this.pollBuffer();
        }

        return ((Task)v0);
    }

    public final Task pollBlocking() {
        return this.pollWithExclusiveMode(true);
    }

    private final Task pollBuffer() {
        Object v0_1;
        while(true) {
            int v0 = WorkQueue.getConsumerIndex$volatile$FU().get(this);
            Task v2 = null;
            if(v0 - WorkQueue.getProducerIndex$volatile$FU().get(this) == 0) {
                return v2;
            }

            int v1 = v0 & 0x7F;
            if(!WorkQueue.getConsumerIndex$volatile$FU().compareAndSet(this, v0, v0 + 1)) {
                continue;
            }

            v0_1 = this.buffer.getAndSet(v1, v2);
            if(v0_1 != null) {
                break;
            }
        }

        this.decrementIfBlocking(((Task)v0_1));
        return ((Task)v0_1);
    }

    public final Task pollCpu() {
        return this.pollWithExclusiveMode(false);
    }

    private final boolean pollTo(GlobalQueue arg1) {
        Task v0 = this.pollBuffer();
        if(v0 == null) {
            return 0;
        }

        arg1.addLast(v0);
        return 1;
    }

    private final Task pollWithExclusiveMode(boolean arg5) {
        Task v3;
        Object v1;
        Object v0;
        do {
            v0 = WorkQueue.getLastScheduledTask$volatile$FU().get(this);
            v1 = null;
            if(v0 == null) {
            }
            else if(((Task)v0).taskContext == arg5) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(WorkQueue.getLastScheduledTask$volatile$FU(), this, v0, v1)) {
                    continue;
                }

                break;
            }

            goto label_11;
        }
        while(true);

        return ((Task)v0);
    label_11:
        int v0_1 = WorkQueue.getConsumerIndex$volatile$FU().get(this);
        int v2 = WorkQueue.getProducerIndex$volatile$FU().get(this);
        do {
            if(v0_1 == v2) {
                goto label_25;
            }

            if((arg5) && WorkQueue.getBlockingTasksInBuffer$volatile$FU().get(this) == 0) {
                return ((Task)v1);
            }

            --v2;
            v3 = this.tryExtractFromTheMiddle(v2, arg5);
        }
        while(v3 == null);

        return v3;
    label_25:
        return ((Task)v1);
    }

    private final void setBlockingTasksInBuffer$volatile(int arg1) {
        this.blockingTasksInBuffer$volatile = arg1;
    }

    private final void setConsumerIndex$volatile(int arg1) {
        this.consumerIndex$volatile = arg1;
    }

    private final void setLastScheduledTask$volatile(Object arg1) {
        this.lastScheduledTask$volatile = arg1;
    }

    private final void setProducerIndex$volatile(int arg1) {
        this.producerIndex$volatile = arg1;
    }

    private final Task stealWithExclusiveMode(int arg5) {
        Task v0_1;
        int v0 = WorkQueue.getConsumerIndex$volatile$FU().get(this);
        int v1 = WorkQueue.getProducerIndex$volatile$FU().get(this);
        boolean v2 = true;
        if(arg5 == 1) {
        }
        else {
            v2 = false;
        }

        while(true) {
            Task v5 = null;
            if(v0 == v1) {
                return v5;
            }

            if((v2) && WorkQueue.getBlockingTasksInBuffer$volatile$FU().get(this) == 0) {
                return v5;
            }

            arg5 = v0 + 1;
            v0_1 = this.tryExtractFromTheMiddle(v0, v2);
            if(v0_1 != null) {
                return v0_1;
            }

            v0 = arg5;
        }

        return v0_1;
    }

    private final Task tryExtractFromTheMiddle(int arg4, boolean arg5) {
        arg4 &= 0x7F;
        Object v0 = this.buffer.get(arg4);
        Object v1 = null;
        if(v0 != null && ((Task)v0).taskContext == arg5 && (AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(this.buffer, arg4, v0, v1))) {
            if(arg5) {
                WorkQueue.getBlockingTasksInBuffer$volatile$FU().decrementAndGet(this);
            }

            return ((Task)v0);
        }

        return ((Task)v1);
    }

    public final long trySteal(int arg2, ObjectRef arg3) {
        Task v0 = arg2 == 3 ? this.pollBuffer() : this.stealWithExclusiveMode(arg2);
        if(v0 != null) {
            arg3.element = v0;
            return -1;
        }

        return this.tryStealLastScheduled(arg2, arg3);
    }

    private final long tryStealLastScheduled(int arg6, ObjectRef arg7) {
        Object v0;
        do {
            v0 = WorkQueue.getLastScheduledTask$volatile$FU().get(this);
            long v1 = -2;
            if(v0 == null) {
                return v1;
            }

            int v3 = ((Task)v0).taskContext ? 1 : 2;
            if((v3 & arg6) == 0) {
                return v1;
            }

            v1 = TasksKt.schedulerTimeSource.nanoTime() - ((Task)v0).submissionTime;
            if(v1 < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) {
                return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - v1;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(WorkQueue.getLastScheduledTask$volatile$FU(), this, v0, null));

        arg7.element = v0;
        return -1;
    }
}

