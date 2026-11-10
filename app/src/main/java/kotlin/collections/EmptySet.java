package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004B\t\bB¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0096\u0082\u0004J\n\u0010\r\u001A\u00020\u000EH\u0096\u0080\u0004J\n\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0014\u001A\u00020\nH\u0096\u0080\u0004J\u0012\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u0002H\u0096\u0082\u0004J\u0018\u0010\u0017\u001A\u00020\n2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0096\u0080\u0004J\u0010\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00020\u001BH\u0096\u0082\u0004J\n\u0010\u001C\u001A\u00020\fH\u0082\u0080\u0004R\u000F\u0010\u0007\u001A\u00020\bX\u0082Ô\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0011\u001A\u00020\u000E8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001D"}, d2={"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "contains", "element", "containsAll", "elements", "", "iterator", "", "readResolve", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class EmptySet implements Serializable, Set, KMappedMarker {
    public static final EmptySet INSTANCE = null;
    private static final long serialVersionUID = 0x2F46B01576D7E2F4L;

    static {
        EmptySet.INSTANCE = new EmptySet();
    }

    private EmptySet() {
        super();
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Void)) {
            return 0;
        }

        return this.contains(((Void)arg2));
    }

    public boolean contains(Void arg1) {
        Intrinsics.checkNotNullParameter(arg1, "element");
        return 0;
    }

    public boolean containsAll(Collection arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        return arg1.isEmpty();
    }

    public boolean equals(Object arg1) {
        if(((arg1 instanceof Set)) && (((Set)arg1).isEmpty())) {
            return 1;
        }

        return 0;
    }

    public int getSize() {
        return 0;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return 1;
    }

    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    private final Object readResolve() {
        return EmptySet.INSTANCE;
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
        return "[]";
    }
}

