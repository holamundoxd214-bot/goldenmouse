package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0011\u001A\u00020\u0012J\u0013\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00028\u0000¢\u0006\u0002\u0010\u0015J\r\u0010\u0016\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u001A0\u0019\"\u0004\b\u0001\u0010\u001A2\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u001A0\u001CJ\u0006\u0010\u001D\u001A\u00020\u0004R\u001F\u0010\u0007\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\n0\bX\u0082\u0004R\u0011\u0010\u000B\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001E"}, d2={"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "<init>", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", "size", "", "getSize", "()I", "close", "", "addLast", "element", "(Ljava/lang/Object;)Z", "removeFirstOrNull", "()Ljava/lang/Object;", "map", "", "R", "transform", "Lkotlin/Function1;", "isClosed", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class LockFreeTaskQueue {
    static {
        LockFreeTaskQueue._cur$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur$volatile");
    }

    public LockFreeTaskQueue(boolean arg3) {
        super();
        this._cur$volatile = new LockFreeTaskQueueCore(8, arg3);
    }

    public final boolean addLast(Object arg5) {
        AtomicReferenceFieldUpdater v0 = LockFreeTaskQueue.get_cur$volatile$FU();
        while(true) {
            Object v1 = v0.get(this);
            int v2 = ((LockFreeTaskQueueCore)v1).addLast(arg5);
            if(v2 == 0) {
                return 1;
            }

            if(v2 != 1) {
                if(v2 != 2) {
                    continue;
                }

                return 0;
            }

            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueue.get_cur$volatile$FU(), this, v1, ((LockFreeTaskQueueCore)v1).next());
        }

        return 1;
    }

    public final void close() {
        AtomicReferenceFieldUpdater v0 = LockFreeTaskQueue.get_cur$volatile$FU();
        while(true) {
            Object v1 = v0.get(this);
            if(((LockFreeTaskQueueCore)v1).close()) {
                return;
            }

            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueue.get_cur$volatile$FU(), this, v1, ((LockFreeTaskQueueCore)v1).next());
        }
    }

    public final int getSize() {
        return LockFreeTaskQueue.get_cur$volatile$FU().get(this).getSize();
    }

    private final Object get_cur$volatile() {
        return this._cur$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_cur$volatile$FU() {
        return LockFreeTaskQueue._cur$volatile$FU;
    }

    public final boolean isClosed() {
        return LockFreeTaskQueue.get_cur$volatile$FU().get(this).isClosed();
    }

    public final boolean isEmpty() {
        return LockFreeTaskQueue.get_cur$volatile$FU().get(this).isEmpty();
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    public final List map(Function1 arg2) {
        return LockFreeTaskQueue.get_cur$volatile$FU().get(this).map(arg2);
    }

    public final Object removeFirstOrNull() {
        Object v2;
        AtomicReferenceFieldUpdater v0 = LockFreeTaskQueue.get_cur$volatile$FU();
        while(true) {
            Object v1 = v0.get(this);
            v2 = ((LockFreeTaskQueueCore)v1).removeFirstOrNull();
            if(v2 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return v2;
            }

            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueue.get_cur$volatile$FU(), this, v1, ((LockFreeTaskQueueCore)v1).next());
        }

        return v2;
    }

    private final void set_cur$volatile(Object arg1) {
        this._cur$volatile = arg1;
    }
}

