package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.NotCompleted;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0013\u001A\u00020\u0011H\u0000¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001A\u00020\u0011H\u0000¢\u0006\u0002\b\u0016J\"\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\b2\b\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u001C\u001A\u00020\u001DH&J\u0006\u0010\u001E\u001A\u00020\u0018R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000B\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\t\u0010\u000E\u001A\u00020\u000FX\u0082\u0004R\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012¨\u0006\u001F"}, d2={"Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/NotCompleted;", "id", "", "prev", "pointers", "", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "numberOfSlots", "getNumberOfSlots", "()I", "cleanedAndPointers", "Lkotlinx/atomicfu/AtomicInt;", "isRemoved", "", "()Z", "tryIncPointers", "tryIncPointers$kotlinx_coroutines_core", "decPointers", "decPointers$kotlinx_coroutines_core", "onCancellation", "", "index", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "onSlotCleaned", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class Segment extends ConcurrentLinkedListNode implements NotCompleted {
    public final long id;

    static {
        Segment.cleanedAndPointers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers$volatile");
    }

    public Segment(long arg1, Segment arg3, int arg4) {
        super(((ConcurrentLinkedListNode)arg3));
        this.id = arg1;
        this.cleanedAndPointers$volatile = arg4 << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        if(Segment.getCleanedAndPointers$volatile$FU().addAndGet(this, 0xFFFF0000) == this.getNumberOfSlots() && !this.isTail()) {
            return 1;
        }

        return 0;
    }

    private final int getCleanedAndPointers$volatile() {
        return this.cleanedAndPointers$volatile;
    }

    private static final AtomicIntegerFieldUpdater getCleanedAndPointers$volatile$FU() {
        return Segment.cleanedAndPointers$volatile$FU;
    }

    public abstract int getNumberOfSlots();

    public boolean isRemoved() {
        if(Segment.getCleanedAndPointers$volatile$FU().get(this) == this.getNumberOfSlots() && !this.isTail()) {
            return 1;
        }

        return 0;
    }

    public abstract void onCancellation(int arg1, Throwable arg2, CoroutineContext arg3);

    public final void onSlotCleaned() {
        if(Segment.getCleanedAndPointers$volatile$FU().incrementAndGet(this) == this.getNumberOfSlots()) {
            this.remove();
        }
    }

    private final void setCleanedAndPointers$volatile(int arg1) {
        this.cleanedAndPointers$volatile = arg1;
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        AtomicIntegerFieldUpdater v0 = Segment.getCleanedAndPointers$volatile$FU();
        do {
            int v1 = v0.get(this);
            if(v1 == this.getNumberOfSlots()) {
                if(this.isTail()) {
                }
                else {
                    return 0;
                }
            }
        }
        while(!v0.compareAndSet(this, v1, 0x10000 + v1));

        return 1;
    }
}

