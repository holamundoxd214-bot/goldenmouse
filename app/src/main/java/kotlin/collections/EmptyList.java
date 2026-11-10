package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\t\bB¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0096\u0082\u0004J\n\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0016\u001A\u00020\fH\u0096\u0080\u0004J\u0012\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0002H\u0096\u0082\u0004J\u0018\u0010\u0019\u001A\u00020\f2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00020\u001BH\u0096\u0080\u0004J\u0012\u0010\u001C\u001A\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u0010H\u0096\u0082\u0004J\u0012\u0010\u001E\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u0002H\u0096\u0080\u0004J\u0012\u0010\u001F\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u0002H\u0096\u0080\u0004J\u0010\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00020!H\u0096\u0082\u0004J\u0010\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00020#H\u0096\u0080\u0004J\u0018\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00020#2\u0006\u0010\u001D\u001A\u00020\u0010H\u0096\u0080\u0004J \u0010$\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010%\u001A\u00020\u00102\u0006\u0010&\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\'\u001A\u00020\u000EH\u0082\u0080\u0004R\u000F\u0010\t\u001A\u00020\nX\u0082Ô\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0013\u001A\u00020\u00108VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006("}, d2={"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "contains", "element", "containsAll", "elements", "", "get", "index", "indexOf", "lastIndexOf", "iterator", "", "listIterator", "", "subList", "fromIndex", "toIndex", "readResolve", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class EmptyList implements Serializable, List, RandomAccess, KMappedMarker {
    public static final EmptyList INSTANCE = null;
    private static final long serialVersionUID = -7390468764508069838L;

    static {
        EmptyList.INSTANCE = new EmptyList();
    }

    private EmptyList() {
        super();
    }

    public void add(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int arg1, Void arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Void arg1) {
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
        if(((arg1 instanceof List)) && (((List)arg1).isEmpty())) {
            return 1;
        }

        return 0;
    }

    public Object get(int arg1) {
        return this.get(arg1);
    }

    public Void get(int arg3) {
        throw new IndexOutOfBoundsException("Empty list doesn\'t contain element at index " + arg3 + '.');
    }

    public int getSize() {
        return 0;
    }

    public int hashCode() {
        return 1;
    }

    public final int indexOf(Object arg2) {
        if(!(arg2 instanceof Void)) {
            return -1;
        }

        return this.indexOf(((Void)arg2));
    }

    public int indexOf(Void arg1) {
        Intrinsics.checkNotNullParameter(arg1, "element");
        return -1;
    }

    public boolean isEmpty() {
        return 1;
    }

    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    public final int lastIndexOf(Object arg2) {
        if(!(arg2 instanceof Void)) {
            return -1;
        }

        return this.lastIndexOf(((Void)arg2));
    }

    public int lastIndexOf(Void arg1) {
        Intrinsics.checkNotNullParameter(arg1, "element");
        return -1;
    }

    public ListIterator listIterator() {
        return EmptyIterator.INSTANCE;
    }

    public ListIterator listIterator(int arg3) {
        if(arg3 == 0) {
            return EmptyIterator.INSTANCE;
        }

        throw new IndexOutOfBoundsException("Index: " + arg3);
    }

    private final Object readResolve() {
        return EmptyList.INSTANCE;
    }

    public Object remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    public Object set(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void set(int arg1, Void arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public List subList(int arg3, int arg4) {
        if(arg3 == 0 && arg4 == 0) {
            return this;
        }

        throw new IndexOutOfBoundsException("fromIndex: " + arg3 + ", toIndex: " + arg4);
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

