package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0006H\u0016J\r\u0010\u0011\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001A\u00020\u0006H\u0016J\u0015\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001A\u00020\u000FH\u0096\u0002J\u000E\u0010\u0019\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u001A\u001A\u00020\u0015H\u0016J\u0015\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u001C\u001A\u00020\u0015H\u0002R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/compose/runtime/snapshots/StateListIterator;", "T", "", "list", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "offset", "", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;I)V", "getList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "index", "lastRequested", "structure", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "next", "remove", "set", "validateModification", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class StateListIterator implements ListIterator, KMutableListIterator {
    public static final int $stable = 8;
    private int index;
    private int lastRequested;
    private final SnapshotStateList list;
    private int structure;

    static {
    }

    public StateListIterator(SnapshotStateList arg1, int arg2) {
        super();
        this.list = arg1;
        this.index = arg2 - 1;
        this.lastRequested = -1;
        this.structure = SnapshotStateListKt.getStructure(arg1);
    }

    public void add(Object arg3) {
        this.validateModification();
        this.list.add(this.index + 1, arg3);
        this.lastRequested = -1;
        ++this.index;
        this.structure = SnapshotStateListKt.getStructure(this.list);
    }

    public final SnapshotStateList getList() {
        return this.list;
    }

    public boolean hasNext() {
        if(this.index < this.list.size() - 1) {
            return 1;
        }

        return 0;
    }

    public boolean hasPrevious() {
        if(this.index >= 0) {
            return 1;
        }

        return 0;
    }

    public Object next() {
        this.validateModification();
        int v0 = this.index + 1;
        this.lastRequested = v0;
        SnapshotStateListKt.validateRange(v0, this.list.size());
        Object v1 = this.list.get(v0);
        this.index = v0;
        return v1;
    }

    public int nextIndex() {
        return this.index + 1;
    }

    public Object previous() {
        this.validateModification();
        SnapshotStateListKt.validateRange(this.index, this.list.size());
        int v0 = this.index;
        this.lastRequested = v0;
        Object v0_1 = this.list.get(v0);
        --this.index;
        return v0_1;
    }

    public int previousIndex() {
        return this.index;
    }

    public void remove() {
        this.validateModification();
        this.list.remove(this.lastRequested);
        --this.index;
        this.lastRequested = -1;
        this.structure = SnapshotStateListKt.getStructure(this.list);
    }

    public void set(Object arg3) {
        this.validateModification();
        int v0 = this.lastRequested;
        if(v0 >= 0) {
            this.list.set(v0, arg3);
            this.structure = SnapshotStateListKt.getStructure(this.list);
            return;
        }

        SnapshotStateListKt.invalidIteratorSet();
        throw new KotlinNothingValueException();
    }

    private final void validateModification() {
        if(SnapshotStateListKt.getStructure(this.list) == this.structure) {
            return;
        }

        throw new ConcurrentModificationException();
    }
}

