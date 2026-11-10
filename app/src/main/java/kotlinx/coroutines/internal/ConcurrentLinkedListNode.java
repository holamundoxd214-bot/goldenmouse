package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b \u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\f\u001A\u0004\u0018\u00018\u00002\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0086\b¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00028\u0000¢\u0006\u0002\u0010\u0017J\u0006\u0010\u001B\u001A\u00020\u001CJ\u0006\u0010\u001D\u001A\u00020\u0015J\u0006\u0010\u001F\u001A\u00020\u001CR\u0011\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007X\u0082\u0004R\u0011\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004R\u0016\u0010\t\u001A\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0011\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0018\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0003\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0013R\u0012\u0010\u001E\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0019R\u0016\u0010 \u001A\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0013R\u0014\u0010\"\u001A\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u0013¨\u0006$"}, d2={"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "nextOrClosed", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrIfClosed", "onClosedAction", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "next", "getNext", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "trySetNext", "", "value", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "isTail", "()Z", "getPrev", "cleanPrev", "", "markAsClosed", "isRemoved", "remove", "aliveSegmentLeft", "getAliveSegmentLeft", "aliveSegmentRight", "getAliveSegmentRight", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ConcurrentLinkedListNode {
    static {
        Class v0 = Object.class;
        Class v2 = ConcurrentLinkedListNode.class;
        ConcurrentLinkedListNode._next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_next$volatile");
        ConcurrentLinkedListNode._prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_prev$volatile");
    }

    public ConcurrentLinkedListNode(ConcurrentLinkedListNode arg1) {
        super();
        this._prev$volatile = arg1;
    }

    public static final Object access$getNextOrClosed(ConcurrentLinkedListNode arg0) {
        return arg0.getNextOrClosed();
    }

    public final void cleanPrev() {
        ConcurrentLinkedListNode.get_prev$volatile$FU().set(this, null);
    }

    private final ConcurrentLinkedListNode getAliveSegmentLeft() {
        Object v1;
        this = this.getPrev();
        while(this != null) {
            if(!this.isRemoved()) {
                break;
            }

            v1 = ConcurrentLinkedListNode.get_prev$volatile$FU().get(v1);
        }

        return ((ConcurrentLinkedListNode)v1);
    }

    private final ConcurrentLinkedListNode getAliveSegmentRight() {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!this.isTail()) {
            }
            else {
                throw new AssertionError();
            }
        }

        this = this.getNext();
        Intrinsics.checkNotNull(this);
        while(this.isRemoved()) {
            ConcurrentLinkedListNode v0 = this.getNext();
            if(v0 == null) {
            }
            else {
                this = v0;
                continue;
            }

            return this;
        }

        return this;
    }

    public final ConcurrentLinkedListNode getNext() {
        Object v1 = this.getNextOrClosed();
        if(v1 == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return null;
        }

        return ((ConcurrentLinkedListNode)v1);
    }

    private final Object getNextOrClosed() {
        return ConcurrentLinkedListNode.get_next$volatile$FU().get(this);
    }

    public final ConcurrentLinkedListNode getPrev() {
        return ConcurrentLinkedListNode.get_prev$volatile$FU().get(this);
    }

    private final Object get_next$volatile() {
        return this._next$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_next$volatile$FU() {
        return ConcurrentLinkedListNode._next$volatile$FU;
    }

    private final Object get_prev$volatile() {
        return this._prev$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_prev$volatile$FU() {
        return ConcurrentLinkedListNode._prev$volatile$FU;
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        if(this.getNext() == null) {
            return 1;
        }

        return 0;
    }

    public final boolean markAsClosed() {
        return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ConcurrentLinkedListNode.get_next$volatile$FU(), this, null, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    public final ConcurrentLinkedListNode nextOrIfClosed(Function0 arg2) {
        Object v1 = this.getNextOrClosed();
        if(v1 != ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return ((ConcurrentLinkedListNode)v1);
        }

        arg2.invoke();
        throw new KotlinNothingValueException();
    }

    public final void remove() {
        if((DebugKt.getASSERTIONS_ENABLED()) && !this.isRemoved()) {
            if(this.isTail()) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(this.isTail()) {
        }
        else {
            do {
                ConcurrentLinkedListNode v0 = this.getAliveSegmentLeft();
                ConcurrentLinkedListNode v1 = this.getAliveSegmentRight();
                AtomicReferenceFieldUpdater v2 = ConcurrentLinkedListNode.get_prev$volatile$FU();
                do {
                    Object v3 = v2.get(v1);
                    if(v3 == null) {
                        Object v4 = null;
                    }
                    else {
                        ConcurrentLinkedListNode v4_1 = v0;
                    }
                }
                while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v2, v1, v3, v4));

                if(v0 != null) {
                    ConcurrentLinkedListNode.get_next$volatile$FU().set(v0, v1);
                }

                if((v1.isRemoved()) && !v1.isTail()) {
                    continue;
                }

                if(v0 == null) {
                    return;
                }

                if(v0.isRemoved()) {
                    continue;
                }

                return;
            }
            while(true);
        }
    }

    private final void set_next$volatile(Object arg1) {
        this._next$volatile = arg1;
    }

    private final void set_prev$volatile(Object arg1) {
        this._prev$volatile = arg1;
    }

    public final boolean trySetNext(ConcurrentLinkedListNode arg3) {
        return AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ConcurrentLinkedListNode.get_next$volatile$FU(), this, null, arg3);
    }

    private final void update$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg2, Object arg3, Function1 arg4) {
        do {
            Object v1 = arg2.get(arg3);
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(arg2, arg3, v1, arg4.invoke(v1)));
    }
}

