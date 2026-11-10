package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001A\u00020\u00052\u0016\u0010\u0006\u001A\u0012\u0012\b\u0012\u00060\u0001j\u0002`\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0086\bJ\u0006\u0010\t\u001A\u00020\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\r¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "forEach", "", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Node;", "remove", "", "isRemoved", "", "()Z", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public LockFreeLinkedListHead() {
        super();
    }

    public final void forEach(Function1 arg3) {
        Object v0 = this.getNext();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        while(!Intrinsics.areEqual(v0, this)) {
            arg3.invoke(v0);
            LockFreeLinkedListNode v0_1 = v0_1.getNextNode();
        }
    }

    public boolean isRemoved() {
        return 0;
    }

    public final Void remove() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public boolean remove() {
        return this.remove().booleanValue();
    }
}

