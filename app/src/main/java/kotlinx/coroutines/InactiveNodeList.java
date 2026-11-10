package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000B\u001A\u00020\fH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\n¨\u0006\r"}, d2={"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "<init>", "(Lkotlinx/coroutines/NodeList;)V", "getList", "()Lkotlinx/coroutines/NodeList;", "isActive", "", "()Z", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class InactiveNodeList implements Incomplete {
    private final NodeList list;

    public InactiveNodeList(NodeList arg1) {
        super();
        this.list = arg1;
    }

    public NodeList getList() {
        return this.list;
    }

    public boolean isActive() {
        return 0;
    }

    public String toString() {
        if(DebugKt.getDEBUG()) {
            return this.getList().getString("New");
        }

        return super.toString();
    }
}

