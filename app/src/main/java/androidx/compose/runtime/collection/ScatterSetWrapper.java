package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001A\u00020\u000EH\u0016J\u000F\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0002J\u0016\u0010\u0011\u001A\u00020\u000E2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016J\u0016\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0015\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/collection/ScatterSetWrapper;", "T", "", "set", "Landroidx/collection/ScatterSet;", "<init>", "(Landroidx/collection/ScatterSet;)V", "getSet$runtime", "()Landroidx/collection/ScatterSet;", "size", "", "getSize", "()I", "isEmpty", "", "iterator", "", "containsAll", "elements", "", "contains", "element", "(Ljava/lang/Object;)Z", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ScatterSetWrapper implements Set, KMappedMarker {
    public static final int $stable = 8;
    private final ScatterSet set;

    static {
    }

    public ScatterSetWrapper(ScatterSet arg1) {
        super();
        this.set = arg1;
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object arg1) {
        return this.set.contains(arg1);
    }

    public boolean containsAll(Collection arg4) {
        if(((arg4 instanceof Collection)) && (arg4.isEmpty())) {
            return 1;
        }

        Iterator v4 = ((Iterable)arg4).iterator();
        do {
            if(!v4.hasNext()) {
                return 1;
            }
        }
        while(this.set.contains(v4.next()));

        return 0;
    }

    public final ScatterSet getSet$runtime() {
        return this.set;
    }

    public int getSize() {
        return this.set.getSize();
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    public Iterator iterator() {
        return SequencesKt.iterator(new ScatterSetWrapper$iterator$1(this, null));
    }

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

