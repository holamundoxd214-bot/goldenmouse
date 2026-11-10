package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u000E\u001A\u00020\u000B2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0007H\u0016J\b\u0010\u0015\u001A\u00020\u000BH\u0016J\u000F\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0002J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u001A"}, d2={"Landroidx/collection/OrderedSetWrapper;", "E", "", "parent", "Landroidx/collection/OrderedScatterSet;", "(Landroidx/collection/OrderedScatterSet;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "toString", "", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) class OrderedSetWrapper implements Set, KMappedMarker {
    private final OrderedScatterSet parent;

    public OrderedSetWrapper(OrderedScatterSet arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super();
        this.parent = arg2;
    }

    public static final OrderedScatterSet access$getParent$p(OrderedSetWrapper arg0) {
        return arg0.parent;
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
        return this.parent.contains(arg1);
    }

    public boolean containsAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        Iterator v3 = ((Iterable)arg3).iterator();
        do {
            if(!v3.hasNext()) {
                return 1;
            }
        }
        while(this.parent.contains(v3.next()));

        return 0;
    }

    public boolean equals(Object arg3) {
        if(this == (((OrderedSetWrapper)arg3))) {
            return 1;
        }

        if(arg3 != null) {
            if(this.getClass() != arg3.getClass()) {
            }
            else {
                return Intrinsics.areEqual(this.parent, ((OrderedSetWrapper)arg3).parent);
            }
        }

        return 0;
    }

    public int getSize() {
        return this.parent._size;
    }

    public int hashCode() {
        return this.parent.hashCode();
    }

    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    public Iterator iterator() {
        return SequencesKt.iterator(new OrderedSetWrapper$iterator$1(this, null));
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

    public String toString() {
        return this.parent.toString();
    }
}

