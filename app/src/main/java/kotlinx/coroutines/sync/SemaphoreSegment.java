package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.concurrent.atomics.AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.Segment;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0010\u001A\u00020\u0006H\u0086\bJ\u001B\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u00062\b\u0010\u0013\u001A\u0004\u0018\u00010\u000BH\u0086\bJ%\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u00062\b\u0010\u0016\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0013\u001A\u0004\u0018\u00010\u000BH\u0086\bJ\u001D\u0010\u0017\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0010\u001A\u00020\u00062\b\u0010\u0013\u001A\u0004\u0018\u00010\u000BH\u0086\bJ\"\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u00062\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0016J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u000E\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\nR\u0014\u0010\f\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u001F"}, d2={"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "id", "", "prev", "pointers", "", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "acquirers", "Lkotlinx/atomicfu/AtomicArray;", "", "numberOfSlots", "getNumberOfSlots", "()I", "get", "index", "set", "", "value", "cas", "", "expected", "getAndSet", "onCancellation", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SemaphoreSegment extends Segment {
    public SemaphoreSegment(long arg1, SemaphoreSegment arg3, int arg4) {
        super(arg1, ((Segment)arg3), arg4);
        this.acquirers = new AtomicReferenceArray(SemaphoreKt.SEGMENT_SIZE);
    }

    public final boolean cas(int arg1, Object arg2, Object arg3) {
        return AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0.m(this.getAcquirers(), arg1, arg2, arg3);
    }

    public final Object get(int arg1) {
        return this.getAcquirers().get(arg1);
    }

    public final AtomicReferenceArray getAcquirers() {
        return this.acquirers;
    }

    public final Object getAndSet(int arg1, Object arg2) {
        return this.getAcquirers().getAndSet(arg1, arg2);
    }

    public int getNumberOfSlots() {
        return SemaphoreKt.SEGMENT_SIZE;
    }

    public void onCancellation(int arg1, Throwable arg2, CoroutineContext arg3) {
        this.getAcquirers().set(arg1, SemaphoreKt.CANCELLED);
        this.onSlotCleaned();
    }

    public final void set(int arg1, Object arg2) {
        this.getAcquirers().set(arg1, arg2);
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + this.hashCode() + ']';
    }
}

