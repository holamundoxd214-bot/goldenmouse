package androidx.compose.runtime.composer.gapbuffer;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\t\u0010\u0016\u001A\u00020\u0017H\u0096\u0002J\u000B\u0010\u0018\u001A\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u001A\u0010\u0011\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/DataIterator;", "", "", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "group", "", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;I)V", "getTable", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "start", "getStart", "()I", "end", "getEnd", "index", "getIndex", "setIndex", "(I)V", "iterator", "hasNext", "", "next", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class DataIterator implements Iterable, Iterator, KMappedMarker {
    private final int end;
    private int index;
    private final int start;
    private final SlotTable table;

    public DataIterator(SlotTable arg3, int arg4) {
        super();
        this.table = arg3;
        int v0 = arg3.getGroups()[arg4 * 5 + 4];
        this.start = v0;
        ++arg4;
        int v3 = arg4 < arg3.getGroupsSize() ? arg3.getGroups()[arg4 * 5 + 4] : arg3.getSlotsSize();
        this.end = v3;
        this.index = v0;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getStart() {
        return this.start;
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
        int v0 = this.index;
        Object v0_1 = v0 < 0 || v0 >= this.table.getSlots().length ? null : this.table.getSlots()[this.index];
        ++this.index;
        return v0_1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int arg1) {
        this.index = arg1;
    }
}

