package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000E\u001A\u00020\u000FH\u0096\u0002J\t\u0010\u0010\u001A\u00020\u0002H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00060\u0006j\u0002`\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/GroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "address", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "nextGroup", "version", "hasNext", "", "next", "validateRead", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class GroupIterator implements Iterator, KMappedMarker {
    private int nextGroup;
    private final SlotTable table;
    private final int version;

    public GroupIterator(SlotTable arg1, int arg2) {
        super();
        this.table = arg1;
        this.nextGroup = arg2;
        this.version = arg1.getVersion();
        if(arg1.getHasEditor()) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public boolean hasNext() {
        if(this.nextGroup != -1) {
            return 1;
        }

        return 0;
    }

    public CompositionGroup next() {
        this.validateRead();
        int v0 = this.nextGroup;
        this.nextGroup = this.table.nextSiblingOf$runtime(v0);
        return new SlotTableGroup(this.table, v0, this.version);
    }

    public Object next() {
        return this.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final void validateRead() {
        if(this.table.getVersion() != this.version) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }
}

