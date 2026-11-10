package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001D\u0010\f\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u000F\u001A\u00020\r2\u0018\u0010\u0010\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0011H\u0016J\b\u0010\u0012\u001A\u00020\rH\u0016J\u001B\u0010\u0013\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0014H\u0096\u0002R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Landroidx/collection/Entries;", "K", "V", "", "", "parent", "Landroidx/collection/ScatterMap;", "(Landroidx/collection/ScatterMap;)V", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "isEmpty", "iterator", "", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class Entries implements Set, KMappedMarker {
    private final ScatterMap parent;

    public Entries(ScatterMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super();
        this.parent = arg2;
    }

    public static final ScatterMap access$getParent$p(Entries arg0) {
        return arg0.parent;
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Map$Entry arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Map$Entry)) {
            return 0;
        }

        return this.contains(((Map$Entry)arg2));
    }

    public boolean contains(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        return Intrinsics.areEqual(this.parent.get(arg2.getKey()), arg2.getValue());
    }

    public boolean containsAll(Collection arg5) {
        Intrinsics.checkNotNullParameter(arg5, "elements");
        if(arg5.isEmpty()) {
            return 1;
        }

        Iterator v5 = ((Iterable)arg5).iterator();
        do {
            if(!v5.hasNext()) {
                return 1;
            }

            Object v0 = v5.next();
        }
        while(Intrinsics.areEqual(this.parent.get(((Map$Entry)v0).getKey()), ((Map$Entry)v0).getValue()));

        return 0;
    }

    public int getSize() {
        return this.parent._size;
    }

    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    public Iterator iterator() {
        return SequencesKt.iterator(new Entries$iterator$1(this, null));
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

    public Object[] toArray(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        return CollectionToArray.toArray(((Collection)this), arg2);
    }
}

