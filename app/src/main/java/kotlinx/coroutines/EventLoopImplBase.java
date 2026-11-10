package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004:;<=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u001E\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u00142\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00180\u001CH\u0016J!\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001A\u001A\u00020\u00142\n\u0010\u001F\u001A\u00060 j\u0002`!H\u0004¢\u0006\u0002\u0010\"J\b\u0010#\u001A\u00020\u0014H\u0016J\u001F\u0010$\u001A\u00020\u00182\u0006\u0010%\u001A\u00020&2\n\u0010\u001F\u001A\u00060 j\u0002`!¢\u0006\u0002\u0010\'J\u0019\u0010(\u001A\u00020\u00182\n\u0010)\u001A\u00060 j\u0002`!H\u0016¢\u0006\u0002\u0010*J\u0019\u0010+\u001A\u00020\r2\n\u0010)\u001A\u00060 j\u0002`!H\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001A\n\u0018\u00010 j\u0004\u0018\u0001`!H\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001A\u00020\u0018H\u0002J\b\u00100\u001A\u00020\u0018H\u0002J\u0016\u00101\u001A\u00020\u00182\u0006\u00102\u001A\u00020\u00142\u0006\u00103\u001A\u000204J\u0010\u00105\u001A\u00020\r2\u0006\u0010)\u001A\u000204H\u0002J\u0018\u00106\u001A\u0002072\u0006\u00102\u001A\u00020\u00142\u0006\u00103\u001A\u000204H\u0002J\b\u00108\u001A\u00020\u0018H\u0004J\b\u00109\u001A\u00020\u0018H\u0002R\u0011\u0010\u0005\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004R\u0011\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004R\t\u0010\n\u001A\u00020\u000BX\u0082\u0004R$\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r8B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u000FR\u0014\u0010\u0013\u001A\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006>"}, d2={"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "_queue", "Lkotlinx/atomicfu/AtomicRef;", "", "_delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_isCompleted", "Lkotlinx/atomicfu/AtomicBoolean;", "value", "", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "nextTime", "", "getNextTime", "()J", "shutdown", "", "scheduleResumeAfterDelay", "timeMillis", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "scheduleInvokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "enqueue", "task", "(Ljava/lang/Runnable;)V", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "dequeue", "()Ljava/lang/Runnable;", "enqueueDelayedTasks", "closeQueue", "schedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "shouldUnpark", "scheduleImpl", "", "resetAll", "rescheduleAllDelayed", "DelayedTask", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001A\u00020\u0006H\u0016J\b\u0010\n\u001A\u00020\u000BH\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation cont;

        public DelayedResumeTask(EventLoopImplBase arg1, long arg2, CancellableContinuation arg4) {
            EventLoopImplBase.this = arg1;
            super(arg2);
            this.cont = arg4;
        }

        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, Unit.INSTANCE);
        }

        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0014\u0010\u0004\u001A\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "(JLjava/lang/Runnable;)V", "Ljava/lang/Runnable;", "run", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long arg1, Runnable arg3) {
            super(arg1);
            this.block = arg3;
        }

        public void run() {
            this.block.run();
        }

        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000F\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0011\u0010\u001A\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u0000H\u0096\u0002J\u000E\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\tJ\u001E\u0010\u001F\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\t2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#J\u0006\u0010$\u001A\u00020%J\b\u0010&\u001A\u00020\'H\u0016R\u0012\u0010\b\u001A\u00020\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R0\u0010\u000F\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u000E2\f\u0010\r\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u000E8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u0015X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "nanoTime", "", "<init>", "(J)V", "_heap", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "timeToExecute", "", "now", "scheduleTask", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class DelayedTask implements Comparable, Runnable, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;
        private int index;
        public long nanoTime;

        public DelayedTask(long arg1) {
            super();
            this.nanoTime = arg1;
            this.index = -1;
        }

        public int compareTo(Object arg1) {
            return this.compareTo(((DelayedTask)arg1));
        }

        public int compareTo(DelayedTask arg3) {
            int v2 = Long.compare(this.nanoTime - arg3.nanoTime, 0);
            if(v2 > 0) {
                return 1;
            }

            if(v2 < 0) {
                return -1;
            }

            return 0;
        }

        public final void dispose() {
            Object v0_1;
            __monitor_enter(this);
            try {
                v0_1 = this._heap;
                if(v0_1 != EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    goto label_6;
                }
            }
            catch(Throwable v0) {
                goto label_19;
            }

            __monitor_exit(this);
            return;
            try {
            label_6:
                if((v0_1 instanceof DelayedTaskQueue)) {
                }
                else {
                    v0_1 = null;
                }

                if(v0_1 != null) {
                    ((DelayedTaskQueue)v0_1).remove(this);
                }

                this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();
            }
            catch(Throwable v0) {
            label_19:
                __monitor_exit(this);
                throw v0;
            }

            __monitor_exit(this);
        }

        public ThreadSafeHeap getHeap() {
            Object v1 = this._heap;
            if((v1 instanceof ThreadSafeHeap)) {
                return ((ThreadSafeHeap)v1);
            }

            return null;
        }

        public int getIndex() {
            return this.index;
        }

        public final int scheduleTask(long arg9, DelayedTaskQueue arg11, EventLoopImplBase arg12) {
            ThreadSafeHeapNode v1;
            DelayedTaskQueue v0;
            __monitor_enter(this);
            try {
                if(this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    goto label_7;
                }
            }
            catch(Throwable v9) {
                goto label_45;
            }

            __monitor_exit(this);
            return 2;
            try {
            label_7:
                v0 = arg11;
                __monitor_enter(v0);
            }
            catch(Throwable v9) {
                goto label_45;
            }

            try {
                v1 = ((ThreadSafeHeap)v0).firstImpl();
                if(!arg12.isCompleted()) {
                    goto label_16;
                }
            }
            catch(Throwable v9) {
                goto label_42;
            }

            try {
                __monitor_exit(v0);
            }
            catch(Throwable v9) {
                goto label_45;
            }

            __monitor_exit(this);
            return 1;
        label_16:
            long v2 = 0;
            if(v1 == null) {
                try {
                    arg11.timeNow = arg9;
                    goto label_29;
                label_20:
                    long v4 = ((DelayedTask)v1).nanoTime;
                    if(v4 - arg9 >= v2) {
                    }
                    else {
                        arg9 = v4;
                    }

                    if(arg9 - arg11.timeNow > v2) {
                        arg11.timeNow = arg9;
                    }

                label_29:
                    if(this.nanoTime - arg11.timeNow < v2) {
                        this.nanoTime = arg11.timeNow;
                    }

                    ((ThreadSafeHeap)v0).addImpl(this);
                    goto label_37;
                }
                catch(Throwable v9) {
                    try {
                    label_42:
                        __monitor_exit(v0);
                        throw v9;
                    label_37:
                        __monitor_exit(v0);
                        goto label_38;
                    }
                    catch(Throwable v9) {
                    label_45:
                        __monitor_exit(this);
                        throw v9;
                    }
                }
            }
            else {
                goto label_20;
            }

            goto label_29;
        label_38:
            __monitor_exit(this);
            return 0;
        }

        public void setHeap(ThreadSafeHeap arg3) {
            if(this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                this._heap = arg3;
                return;
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public void setIndex(int arg1) {
            this.index = arg1;
        }

        public final boolean timeToExecute(long arg3) {
            if(arg3 - this.nanoTime >= 0) {
                return 1;
            }

            return 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0003\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "<init>", "(J)V", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DelayedTaskQueue extends ThreadSafeHeap {
        public long timeNow;

        public DelayedTaskQueue(long arg1) {
            super();
            this.timeNow = arg1;
        }
    }

    static {
        Class v0 = Object.class;
        Class v2 = EventLoopImplBase.class;
        EventLoopImplBase._queue$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_queue$volatile");
        EventLoopImplBase._delayed$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_delayed$volatile");
        EventLoopImplBase._isCompleted$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v2, "_isCompleted$volatile");
    }

    public EventLoopImplBase() {
        super();
    }

    public static final boolean access$isCompleted(EventLoopImplBase arg0) {
        return arg0.isCompleted();
    }

    private final void closeQueue() {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.isCompleted()) {
            }
            else {
                throw new AssertionError();
            }
        }

        AtomicReferenceFieldUpdater v0 = EventLoopImplBase.get_queue$volatile$FU();
        do {
            Object v1 = v0.get(this);
            if(v1 == null) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_queue$volatile$FU(), this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p())) {
                    continue;
                }
            }
            else if((v1 instanceof LockFreeTaskQueueCore)) {
                ((LockFreeTaskQueueCore)v1).close();
                return;
            }
            else if(v1 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
            }
            else {
                LockFreeTaskQueueCore v2 = new LockFreeTaskQueueCore(8, true);
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Runnable");
                v2.addLast(v1);
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_queue$volatile$FU(), this, v1, v2)) {
                    continue;
                }
            }

            return;
        }
        while(true);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated without replacement as an internal method never intended for public use") public Object delay(long arg1, Continuation arg3) {
        return DefaultImpls.delay(((Delay)this), arg1, arg3);
    }

    private final Runnable dequeue() {
        Object v1;
        AtomicReferenceFieldUpdater v0 = EventLoopImplBase.get_queue$volatile$FU();
        do {
        label_1:
            v1 = v0.get(this);
            Runnable v2 = null;
            if(v1 == null) {
                return v2;
            }

            if((v1 instanceof LockFreeTaskQueueCore)) {
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                Object v2_1 = v1;
                Object v3 = ((LockFreeTaskQueueCore)v2_1).removeFirstOrNull();
                if(v3 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return ((Runnable)v3);
                }

                AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_queue$volatile$FU(), this, v1, ((LockFreeTaskQueueCore)v2_1).next());
                goto label_1;
            }

            if(v1 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return v2;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_queue$volatile$FU(), this, v1, v2));

        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Runnable");
        return ((Runnable)v1);
    }

    public final void dispatch(CoroutineContext arg1, Runnable arg2) {
        this.enqueue(arg2);
    }

    public void enqueue(Runnable arg2) {
        this.enqueueDelayedTasks();
        if(this.enqueueImpl(arg2)) {
            this.unpark();
            return;
        }

        DefaultExecutor.INSTANCE.enqueue(arg2);
    }

    private final void enqueueDelayedTasks() {
        ThreadSafeHeapNode v5;
        ThreadSafeHeapNode v4;
        Object v0 = EventLoopImplBase.get_delayed$volatile$FU().get(this);
        if(v0 != null && !((DelayedTaskQueue)v0).isEmpty()) {
            AbstractTimeSource v1 = AbstractTimeSourceKt.timeSource;
            long v1_1 = v1 != null ? v1.nanoTime() : System.nanoTime();
            do {
                Object v3 = v0;
                __monitor_enter(v3);
                try {
                    v4 = ((ThreadSafeHeap)v3).firstImpl();
                    v5 = null;
                    if(v4 == null) {
                    }
                    else {
                        goto label_17;
                    }
                }
                catch(Throwable v8) {
                    goto label_30;
                }

                __monitor_exit(v3);
                continue;
                try {
                label_17:
                    boolean v4_1 = ((DelayedTask)v4).timeToExecute(v1_1) ? this.enqueueImpl(((Runnable)v4)) : false;
                    if(v4_1) {
                        v5 = ((ThreadSafeHeap)v3).removeAtImpl(0);
                    }
                }
                catch(Throwable v8) {
                label_30:
                    __monitor_exit(v3);
                    throw v8;
                }

                __monitor_exit(v3);
            }
            while(v5 != null);
        }
    }

    private final boolean enqueueImpl(Runnable arg7) {
        AtomicReferenceFieldUpdater v0 = EventLoopImplBase.get_queue$volatile$FU();
        do {
        label_1:
            Object v1 = v0.get(this);
            if(this.isCompleted()) {
                return 0;
            }

            if(v1 == null) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_queue$volatile$FU(), this, null, arg7)) {
                    goto label_1;
                }

                return 1;
            }

            if((v1 instanceof LockFreeTaskQueueCore)) {
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                Object v4 = v1;
                int v5 = ((LockFreeTaskQueueCore)v4).addLast(arg7);
                if(v5 != 0) {
                    if(v5 != 1) {
                        if(v5 != 2) {
                            goto label_1;
                        }

                        return 0;
                    }

                    AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_queue$volatile$FU(), this, v1, ((LockFreeTaskQueueCore)v4).next());
                    goto label_1;
                }

                return 1;
            }

            if(v1 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return 0;
            }

            LockFreeTaskQueueCore v3 = new LockFreeTaskQueueCore(8, true);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.Runnable");
            v3.addLast(v1);
            v3.addLast(arg7);
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_queue$volatile$FU(), this, v1, v3));

        return 1;
    }

    protected long getNextTime() {
        long v2 = 0;
        if(super.getNextTime() == v2) {
            return v2;
        }

        Object v0 = EventLoopImplBase.get_queue$volatile$FU().get(this);
        long v4 = 0x7FFFFFFFFFFFFFFFL;
        if(v0 != null) {
            if((v0 instanceof LockFreeTaskQueueCore)) {
                if(!((LockFreeTaskQueueCore)v0).isEmpty()) {
                    return v2;
                }
            }
            else if(v0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                return v4;
            }
            else {
                return v2;
            }
        }

        Object v6 = EventLoopImplBase.get_delayed$volatile$FU().get(this);
        if(v6 != null) {
            ThreadSafeHeapNode v6_1 = ((DelayedTaskQueue)v6).peek();
            if(v6_1 == null) {
            }
            else {
                long v0_1 = ((DelayedTask)v6_1).nanoTime;
                AbstractTimeSource v6_2 = AbstractTimeSourceKt.timeSource;
                v4 = v6_2 != null ? v6_2.nanoTime() : System.nanoTime();
                return RangesKt.coerceAtLeast(v0_1 - v4, v2);
            }
        }

        return v4;
    }

    private final Object get_delayed$volatile() {
        return this._delayed$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_delayed$volatile$FU() {
        return EventLoopImplBase._delayed$volatile$FU;
    }

    private final int get_isCompleted$volatile() {
        return this._isCompleted$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_isCompleted$volatile$FU() {
        return EventLoopImplBase._isCompleted$volatile$FU;
    }

    private final Object get_queue$volatile() {
        return this._queue$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_queue$volatile$FU() {
        return EventLoopImplBase._queue$volatile$FU;
    }

    public DisposableHandle invokeOnTimeout(long arg1, Runnable arg3, CoroutineContext arg4) {
        return DefaultImpls.invokeOnTimeout(((Delay)this), arg1, arg3, arg4);
    }

    private final boolean isCompleted() {
        if(EventLoopImplBase.get_isCompleted$volatile$FU().get(this) == 1) {
            return 1;
        }

        return 0;
    }

    protected boolean isEmpty() {
        if(!this.isUnconfinedQueueEmpty()) {
            return 0;
        }

        Object v0 = EventLoopImplBase.get_delayed$volatile$FU().get(this);
        if(v0 != null && !((DelayedTaskQueue)v0).isEmpty()) {
            return 0;
        }

        Object v3 = EventLoopImplBase.get_queue$volatile$FU().get(this);
        if(v3 == null) {
            return 1;
        }

        if((v3 instanceof LockFreeTaskQueueCore)) {
            return ((LockFreeTaskQueueCore)v3).isEmpty();
        }

        if(v3 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
            return 1;
        }

        return 0;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    public long processNextEvent() {
        long v1 = 0;
        if(this.processUnconfinedEvent()) {
            return v1;
        }

        this.enqueueDelayedTasks();
        Runnable v0 = this.dequeue();
        if(v0 != null) {
            v0.run();
            return v1;
        }

        return this.getNextTime();
    }

    private final void rescheduleAllDelayed() {
        AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
        long v0_1 = v0 != null ? v0.nanoTime() : System.nanoTime();
        while(true) {
            Object v2 = EventLoopImplBase.get_delayed$volatile$FU().get(this);
            if(v2 != null) {
                ThreadSafeHeapNode v2_1 = ((DelayedTaskQueue)v2).removeFirstOrNull();
                if(v2_1 == null) {
                }
                else {
                    this.reschedule(v0_1, ((DelayedTask)v2_1));
                    continue;
                }
            }

            return;
        }
    }

    protected final void resetAll() {
        EventLoopImplBase.get_queue$volatile$FU().set(this, null);
        EventLoopImplBase.get_delayed$volatile$FU().set(this, null);
    }

    public final void schedule(long arg3, DelayedTask arg5) {
        int v0 = this.scheduleImpl(arg3, arg5);
        if(v0 != 0) {
            if(v0 == 1) {
                this.reschedule(arg3, arg5);
                return;
            }
            else if(v0 == 2) {
            }
            else {
                throw new IllegalStateException("unexpected result".toString());
            }
        }
        else if(this.shouldUnpark(arg5)) {
            this.unpark();
        }
    }

    private final int scheduleImpl(long arg4, DelayedTask arg6) {
        if(this.isCompleted()) {
            return 1;
        }

        Object v0 = EventLoopImplBase.get_delayed$volatile$FU().get(this);
        if(v0 == null) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(EventLoopImplBase.get_delayed$volatile$FU(), this, null, new DelayedTaskQueue(arg4));
            v0 = EventLoopImplBase.get_delayed$volatile$FU().get(this);
            Intrinsics.checkNotNull(v0);
        }

        return arg6.scheduleTask(arg4, ((DelayedTaskQueue)v0), this);
    }

    protected final DisposableHandle scheduleInvokeOnTimeout(long arg4, Runnable arg6) {
        arg4 = EventLoop_commonKt.delayToNanos(arg4);
        if(arg4 < 0x3FFFFFFFFFFFFFFFL) {
            AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
            long v0_1 = v0 != null ? v0.nanoTime() : System.nanoTime();
            DelayedRunnableTask v2 = new DelayedRunnableTask(arg4 + v0_1, arg6);
            this.schedule(v0_1, v2);
            return ((DisposableHandle)v2);
        }

        return NonDisposableHandle.INSTANCE;
    }

    public void scheduleResumeAfterDelay(long arg4, CancellableContinuation arg6) {
        arg4 = EventLoop_commonKt.delayToNanos(arg4);
        if(arg4 < 0x3FFFFFFFFFFFFFFFL) {
            AbstractTimeSource v0 = AbstractTimeSourceKt.timeSource;
            long v0_1 = v0 != null ? v0.nanoTime() : System.nanoTime();
            DelayedResumeTask v2 = new DelayedResumeTask(this, arg4 + v0_1, arg6);
            this.schedule(v0_1, v2);
            CancellableContinuationKt.disposeOnCancellation(arg6, ((DisposableHandle)v2));
        }
    }

    private final void setCompleted(boolean arg2) {
        EventLoopImplBase.get_isCompleted$volatile$FU().set(this, ((int)arg2));
    }

    private final void set_delayed$volatile(Object arg1) {
        this._delayed$volatile = arg1;
    }

    private final void set_isCompleted$volatile(int arg1) {
        this._isCompleted$volatile = arg1;
    }

    private final void set_queue$volatile(Object arg1) {
        this._queue$volatile = arg1;
    }

    private final boolean shouldUnpark(DelayedTask arg2) {
        Object v1 = EventLoopImplBase.get_delayed$volatile$FU().get(this);
        if(v1 != null) {
            ThreadSafeHeapNode v1_1 = ((DelayedTaskQueue)v1).peek();
        }
        else {
            DelayedTask v1_2 = null;
        }

        if(v1_2 == arg2) {
            return 1;
        }

        return 0;
    }

    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.setCompleted(true);
        this.closeQueue();
        do {
        }
        while(this.processNextEvent() <= 0);

        this.rescheduleAllDelayed();
    }
}

