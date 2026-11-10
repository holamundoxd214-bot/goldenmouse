package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001A\u00020\bH\u0002J\u0019\u0010\u0016\u001A\u00060\u0000j\u0002`\u00112\n\u0010\u0017\u001A\u00060\u0000j\u0002`\u0011H\u0082\u0010J\u0012\u0010\u0018\u001A\u00020\u000B2\n\u0010\u0019\u001A\u00060\u0000j\u0002`\u0011J\u001A\u0010\u001A\u001A\u00020\u000B2\n\u0010\u0019\u001A\u00060\u0000j\u0002`\u00112\u0006\u0010\u001B\u001A\u00020\u001CJ\u000E\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001CJ \u0010 \u001A\u00020\u000B2\n\u0010\u0019\u001A\u00060\u0000j\u0002`\u00112\n\u0010\r\u001A\u00060\u0000j\u0002`\u0011H\u0001J\b\u0010!\u001A\u00020\u000BH\u0016J\u0010\u0010\"\u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0011H\u0001J\u0014\u0010#\u001A\u00020\u001E2\n\u0010\r\u001A\u00060\u0000j\u0002`\u0011H\u0002J\u0011\u0010$\u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0011H\u0082\u0010J%\u0010%\u001A\u00020\u001E2\n\u0010&\u001A\u00060\u0000j\u0002`\u00112\n\u0010\r\u001A\u00060\u0000j\u0002`\u0011H\u0000¢\u0006\u0002\b\'J\b\u0010(\u001A\u00020)H\u0016R\u000F\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u0004R\u000F\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00000\u0005X\u0082\u0004R\u0011\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\fR\u0011\u0010\r\u001A\u00020\u00018F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0015\u0010\u0010\u001A\u00060\u0000j\u0002`\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001A\u00060\u0000j\u0002`\u00118F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013¨\u0006*"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "removed", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prevNode", "getPrevNode", "findPrevNonRemoved", "current", "addOneIfEmpty", "node", "addLast", "permissionsBitmask", "", "close", "", "forbiddenElementsBit", "addNext", "remove", "removeOrNext", "finishAdd", "correctPrev", "validateNode", "prev", "validateNode$kotlinx_coroutines_core", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class LockFreeLinkedListNode {
    static {
        Class v0 = Object.class;
        Class v2 = LockFreeLinkedListNode.class;
        LockFreeLinkedListNode._next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_next$volatile");
        LockFreeLinkedListNode._prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_prev$volatile");
        LockFreeLinkedListNode._removedRef$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_removedRef$volatile");
    }

    public LockFreeLinkedListNode() {
        super();
        this._next$volatile = this;
        this._prev$volatile = this;
    }

    public final boolean addLast(LockFreeLinkedListNode arg4, int arg5) {
        do {
            LockFreeLinkedListNode v0 = this.getPrevNode();
            if((v0 instanceof ListClosed)) {
                goto label_4;
            }
        }
        while(!v0.addNext(arg4, this));

        return 1;
    label_4:
        if((v0.forbiddenElementsBitmask & arg5) == 0 && (v0.addLast(arg4, arg5))) {
            return 1;
        }

        return 0;
    }

    public final boolean addNext(LockFreeLinkedListNode arg2, LockFreeLinkedListNode arg3) {
        LockFreeLinkedListNode.get_prev$volatile$FU().set(arg2, this);
        LockFreeLinkedListNode.get_next$volatile$FU().set(arg2, arg3);
        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.get_next$volatile$FU(), this, arg3, arg2)) {
            return 0;
        }

        arg2.finishAdd(arg3);
        return 1;
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode arg2) {
        LockFreeLinkedListNode.get_prev$volatile$FU().set(arg2, this);
        LockFreeLinkedListNode.get_next$volatile$FU().set(arg2, this);
        do {
            if(this.getNext() != this) {
                return 0;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.get_next$volatile$FU(), this, this, arg2));

        arg2.finishAdd(this);
        return 1;
    }

    public final void close(int arg2) {
        this.addLast(new ListClosed(arg2), arg2);
    }

    private final LockFreeLinkedListNode correctPrev() {
        Object v4;
        Object v3;
        Object v2;
        while(true) {
        label_0:
            Object v0 = LockFreeLinkedListNode.get_prev$volatile$FU().get(this);
            LockFreeLinkedListNode v1 = null;
            v2 = v0;
            while(true) {
            label_4:
                v3 = v1;
                while(true) {
                label_5:
                    v4 = LockFreeLinkedListNode.get_next$volatile$FU().get(v2);
                    if((((LockFreeLinkedListNode)v4)) == this) {
                        goto label_8;
                    }

                    if(this.isRemoved()) {
                        return v1;
                    }

                    if(!(v4 instanceof Removed)) {
                        goto label_31;
                    }

                    if(v3 == null) {
                        break;
                    }

                    if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.get_next$volatile$FU(), v3, v2, ((Removed)v4).ref)) {
                        goto label_0;
                    }

                    v2 = v3;
                    goto label_4;
                }
            }

            v2 = LockFreeLinkedListNode.get_prev$volatile$FU().get(v2);
            goto label_5;
        label_31:
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            v3 = v2;
            v2 = v4;
            goto label_5;
        label_8:
            if(v0 == v2) {
            }
            else if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.get_prev$volatile$FU(), this, v0, v2)) {
                continue;
            }

            break;
        }

        return ((LockFreeLinkedListNode)v2);
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode arg1) {
        Object v1;
        while(arg1.isRemoved()) {
            v1 = LockFreeLinkedListNode.get_prev$volatile$FU().get(v1);
        }

        return ((LockFreeLinkedListNode)v1);
    }

    private final void finishAdd(LockFreeLinkedListNode arg4) {
        AtomicReferenceFieldUpdater v0 = LockFreeLinkedListNode.get_prev$volatile$FU();
        do {
            Object v1 = v0.get(arg4);
            if(this.getNext() == arg4) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.get_prev$volatile$FU(), arg4, v1, this)) {
                    continue;
                }

                break;
            }
            else {
                goto label_4;
            }
        }
        while(true);

        if(this.isRemoved()) {
            arg4.correctPrev();
        label_4:
        }
    }

    public final Object getNext() {
        return LockFreeLinkedListNode.get_next$volatile$FU().get(this);
    }

    public final LockFreeLinkedListNode getNextNode() {
        Object v1 = this.getNext();
        Object v0 = (v1 instanceof Removed) ? v1 : null;
        if(v0 != null) {
            LockFreeLinkedListNode v0_1 = ((Removed)v0).ref;
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return ((LockFreeLinkedListNode)v1);
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode v0 = this.correctPrev();
        if(v0 == null) {
            return this.findPrevNonRemoved(LockFreeLinkedListNode.get_prev$volatile$FU().get(this));
        }

        return v0;
    }

    private final Object get_next$volatile() {
        return this._next$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_next$volatile$FU() {
        return LockFreeLinkedListNode._next$volatile$FU;
    }

    private final Object get_prev$volatile() {
        return this._prev$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_prev$volatile$FU() {
        return LockFreeLinkedListNode._prev$volatile$FU;
    }

    private final Object get_removedRef$volatile() {
        return this._removedRef$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_removedRef$volatile$FU() {
        return LockFreeLinkedListNode._removedRef$volatile$FU;
    }

    public boolean isRemoved() {
        return this.getNext() instanceof Removed;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    public boolean remove() {
        if(this.removeOrNext() == null) {
            return 1;
        }

        return 0;
    }

    public final LockFreeLinkedListNode removeOrNext() {
        Object v1;
        Object v0;
        do {
            v0 = this.getNext();
            if((v0 instanceof Removed)) {
                goto label_3;
            }

            if((((LockFreeLinkedListNode)v0)) == this) {
                return ((LockFreeLinkedListNode)v0);
            }

            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            v1 = v0;
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeLinkedListNode.get_next$volatile$FU(), this, v0, ((LockFreeLinkedListNode)v1).removed()));

        ((LockFreeLinkedListNode)v1).correctPrev();
        return null;
    label_3:
        return ((Removed)v0).ref;
    }

    private final Removed removed() {
        Object v0 = LockFreeLinkedListNode.get_removedRef$volatile$FU().get(this);
        if(v0 == null) {
            Removed v0_1 = new Removed(this);
            LockFreeLinkedListNode.get_removedRef$volatile$FU().set(this, v0_1);
        }

        return ((Removed)v0);
    }

    private final void set_next$volatile(Object arg1) {
        this._next$volatile = arg1;
    }

    private final void set_prev$volatile(Object arg1) {
        this._prev$volatile = arg1;
    }

    private final void set_removedRef$volatile(Object arg1) {
        this._removedRef$volatile = arg1;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode arg2, LockFreeLinkedListNode arg3) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg2 == LockFreeLinkedListNode.get_prev$volatile$FU().get(this)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg3 == LockFreeLinkedListNode.get_next$volatile$FU().get(this)) {
                return;
            }

            throw new AssertionError();
        }
    }
}

