package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0011H\u0096\u0002J\t\u0010\u0012\u001A\u00020\u0002H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u000E\u0010\u000E\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/GroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "start", "", "end", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;II)V", "getTable", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "getEnd", "()I", "index", "version", "hasNext", "", "next", "validateRead", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class GroupIterator implements Iterator, KMappedMarker {
    private final int end;
    private int index;
    private final SlotTable table;
    private final int version;

    public GroupIterator(SlotTable arg1, int arg2, int arg3) {
        super();
        this.table = arg1;
        this.end = arg3;
        this.index = arg2;
        this.version = arg1.getVersion$runtime();
        if(arg1.getWriter$runtime()) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }

    public final int getEnd() {
        return this.end;
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

    public CompositionGroup next() {
        this.validateRead();
        int v0 = this.index;
        this.index = SlotTableKt.access$groupSize(this.table.getGroups(), v0) + v0;
        return new SlotTableGroup(this.table, v0, this.version);
    }

    public Object next() {
        return this.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final void validateRead() {
        if(this.table.getVersion$runtime() != this.version) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }
}

