package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fJ\b\u0010\u000E\u001A\u00020\fH\u0016R\u0014\u0010\u0005\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "<init>", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    public NodeList() {
        super();
    }

    public NodeList getList() {
        return this;
    }

    public final String getString(String arg4) {
        StringBuilder v0 = new StringBuilder("List{");
        v0.append(arg4);
        v0.append("}[");
        Object v4 = ((LockFreeLinkedListHead)this).getNext();
        Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        int v1 = 1;
        while(!Intrinsics.areEqual(v4, this)) {
            if((v4 instanceof JobNode)) {
                if(v1 != 0) {
                    v1 = 0;
                }
                else {
                    v0.append(", ");
                }

                v0.append(v4);
            }

            LockFreeLinkedListNode v4_1 = ((LockFreeLinkedListNode)v4).getNextNode();
        }

        v0.append("]");
        return v0.toString();
    }

    public boolean isActive() {
        return 1;
    }

    public String toString() {
        if(DebugKt.getDEBUG()) {
            return this.getString("Active");
        }

        return super.toString();
    }
}

