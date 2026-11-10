package androidx.compose.runtime.snapshots;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\"\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u001D\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "K", "V", "E", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "size", "", "getSize", "()I", "clear", "", "isEmpty", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) abstract class SnapshotMapSet implements Set, KMutableSet {
    private final SnapshotStateMap map;

    public SnapshotMapSet(SnapshotStateMap arg1) {
        super();
        this.map = arg1;
    }

    public void clear() {
        this.map.clear();
    }

    public final SnapshotStateMap getMap() {
        return this.map;
    }

    public int getSize() {
        return this.map.size();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final int size() {
        return this.getSize();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }
}

