package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001E\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0002J\b\u0010\u000F\u001A\u00020\tH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0016\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001A\u00020\f2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0096\u0001J\u0016\u0010\u0018\u001A\u00028\u00002\u0006\u0010\u0019\u001A\u00020\tH\u0096\u0003¢\u0006\u0002\u0010\u001AJ\u0016\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001CJ\t\u0010\u001D\u001A\u00020\fH\u0096\u0001J\u000F\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0096\u0003J\u0016\u0010 \u001A\u00020\t2\u0006\u0010\u0013\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001CJ\u000F\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\"H\u0096\u0001J\u0017\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u0019\u001A\u00020\tH\u0096\u0001R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010#\u001A\u00020\tX\u0096\u0005¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u0006&"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/adapters/ImmutableListAdapter;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "impl", "<init>", "(Ljava/util/List;)V", "subList", "fromIndex", "", "toIndex", "equals", "", "other", "", "hashCode", "toString", "", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", "index", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "size", "getSize", "()I", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ImmutableListAdapter implements ImmutableList, List, KMappedMarker {
    public static final int $stable = 8;
    private final List impl;

    static {
    }

    public ImmutableListAdapter(List arg1) {
        super();
        this.impl = arg1;
    }

    public void add(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(int arg1, Collection arg2) {
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

    public Object get(int arg1) {
        return this.impl.get(arg1);
    }

    public int getSize() {
        return this.impl.size();
    }

    public int hashCode() {
        return this.impl.hashCode();
    }

    public int indexOf(Object arg1) {
        return this.impl.indexOf(arg1);
    }

    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    public Iterator iterator() {
        return this.impl.iterator();
    }

    public int lastIndexOf(Object arg1) {
        return this.impl.lastIndexOf(arg1);
    }

    public ListIterator listIterator() {
        return this.impl.listIterator();
    }

    public ListIterator listIterator(int arg1) {
        return this.impl.listIterator(arg1);
    }

    public Object remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object set(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public void sort(Comparator arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ImmutableList subList(int arg2, int arg3) {
        return new ImmutableListAdapter(this.impl.subList(arg2, arg3));
    }

    public List subList(int arg1, int arg2) {
        return this.subList(arg1, arg2);
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

