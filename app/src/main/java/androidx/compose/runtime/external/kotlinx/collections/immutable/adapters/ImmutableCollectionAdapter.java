package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\u0016\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001A\u00020\b2\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0001J\t\u0010\u0014\u001A\u00020\bH\u0096\u0001J\u000F\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0003R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001A\u00020\fX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/adapters/ImmutableCollectionAdapter;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "", "impl", "<init>", "(Ljava/util/Collection;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "size", "getSize", "()I", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class ImmutableCollectionAdapter implements ImmutableCollection, Collection, KMappedMarker {
    public static final int $stable = 8;
    private final Collection impl;

    static {
    }

    public ImmutableCollectionAdapter(Collection arg1) {
        super();
        this.impl = arg1;
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
        return this.impl.contains(arg1);
    }

    public boolean containsAll(Collection arg1) {
        return this.impl.containsAll(arg1);
    }

    public boolean equals(Object arg1) {
        return this.impl.equals(arg1);
    }

    public int getSize() {
        return this.impl.size();
    }

    public int hashCode() {
        return this.impl.hashCode();
    }

    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    public Iterator iterator() {
        return this.impl.iterator();
    }

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeIf(Predicate arg1) {
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

    public String toString() {
        return this.impl.toString();
    }
}

