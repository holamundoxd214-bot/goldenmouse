package androidx.compose.runtime.composer;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000BR\u001A\u0010\u0005\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\t\"\u0004\b\u000F\u0010\u000B¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/composer/GroupInfo;", "", "slotIndex", "", "nodeIndex", "nodeCount", "<init>", "(III)V", "getSlotIndex", "()I", "setSlotIndex", "(I)V", "getNodeIndex", "setNodeIndex", "getNodeCount", "setNodeCount", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class GroupInfo {
    public static final int $stable = 8;
    private int nodeCount;
    private int nodeIndex;
    private int slotIndex;

    static {
    }

    public GroupInfo(int arg1, int arg2, int arg3) {
        super();
        this.slotIndex = arg1;
        this.nodeIndex = arg2;
        this.nodeCount = arg3;
    }

    public final int getNodeCount() {
        return this.nodeCount;
    }

    public final int getNodeIndex() {
        return this.nodeIndex;
    }

    public final int getSlotIndex() {
        return this.slotIndex;
    }

    public final void setNodeCount(int arg1) {
        this.nodeCount = arg1;
    }

    public final void setNodeIndex(int arg1) {
        this.nodeIndex = arg1;
    }

    public final void setSlotIndex(int arg1) {
        this.slotIndex = arg1;
    }
}

