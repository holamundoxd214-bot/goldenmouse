package androidx.compose.runtime.snapshots;

import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B5\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0018\u0010\u0007\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\f\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/snapshots/StateMapMutableValuesIterator;", "K", "V", "Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "next", "()Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class StateMapMutableValuesIterator extends StateMapMutableIterator implements Iterator, KMutableIterator {
    public StateMapMutableValuesIterator(SnapshotStateMap arg1, Iterator arg2) {
        super(arg1, arg2);
    }

    public Object next() {
        Map$Entry v0 = this.getNext();
        if(v0 != null) {
            this.advance();
            return v0.getValue();
        }

        throw new IllegalStateException();
    }
}

