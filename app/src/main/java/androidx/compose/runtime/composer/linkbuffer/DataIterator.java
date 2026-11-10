package androidx.compose.runtime.composer.linkbuffer;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0014\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\t\u0010\u0015\u001A\u00020\u0016H\u0096\u0002J\u000B\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\rR\u001A\u0010\u0010\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/DataIterator;", "", "", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "group", "", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getGroup", "()I", "end", "getEnd", "index", "getIndex", "setIndex", "(I)V", "iterator", "hasNext", "", "next", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class DataIterator implements Iterable, Iterator, KMappedMarker {
    private final int end;
    private final int group;
    private int index;
    private final SlotTable table;

    public DataIterator(SlotTable arg5, int arg6) {
        int v0_1;
        super();
        this.table = arg5;
        this.group = arg6;
        SlotTableAddressSpace v0 = arg5.getAddressSpace();
        int v1 = arg5.groupSlotRange$runtime(arg6);
        if(v1 == -1) {
            v0_1 = 0;
        }
        else {
            int v2 = (v1 & 15) + 1;
            v0_1 = v2 > 15 ? SlotTableAddressSpace.access$getLargeSizes(v0).get(v1 >> 4) : v2;
        }

        this.end = v0_1;
        this.index = GroupFlagsKt.utilitySlotsCountForFlags(arg5.groupFlags$runtime(arg6));
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getGroup() {
        return this.group;
    }

    public final int getIndex() {
        return this.index;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public boolean hasNext() {
        if(this.index < this.end) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return this;
    }

    public Object next() {
        SlotTable v0 = this.table;
        int v1 = this.group;
        int v2 = this.index;
        this.index = v2 + 1;
        return v0.groupSlotAtIndex$runtime(v1, v2);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int arg1) {
        this.index = arg1;
    }
}

