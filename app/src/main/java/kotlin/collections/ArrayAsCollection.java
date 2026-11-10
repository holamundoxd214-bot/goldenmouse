package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\bF\u0012\u000E\u0010\u0003\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0011\u001A\u00020\u0006H\u0096\u0080\u0004J\u0017\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001A\u00020\u00062\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0080\u0004J\u0010\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0082\u0004J\u0019\u0010\u0019\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001A0\u0004H\u0086\u0080\u0004¢\u0006\u0002\u0010\nR\u001F\u0010\u0003\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000B\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\fR\u0015\u0010\r\u001A\u00020\u000E8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "<init>", "([Ljava/lang/Object;Z)V", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "()Z", "size", "", "getSize", "()I", "isEmpty", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "iterator", "", "toArray", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ArrayAsCollection implements Collection, KMappedMarker {
    private final boolean isVarargs;
    private final Object[] values;

    public ArrayAsCollection(Object[] arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "values");
        super();
        this.values = arg2;
        this.isVarargs = arg3;
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
        return ArraysKt.contains(this.values, arg1);
    }

    public boolean containsAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        if(arg3.isEmpty()) {
            return 1;
        }

        Iterator v3 = ((Iterable)arg3).iterator();
        do {
            if(!v3.hasNext()) {
                return 1;
            }
        }
        while(this.contains(v3.next()));

        return 0;
    }

    public int getSize() {
        return this.values.length;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public boolean isEmpty() {
        if(this.values.length == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isVarargs() {
        return this.isVarargs;
    }

    public Iterator iterator() {
        return ArrayIteratorKt.iterator(this.values);
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

    public final Object[] toArray() {
        return CollectionsKt.copyToArrayOfAny(this.values, this.isVarargs);
    }

    public Object[] toArray(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        return CollectionToArray.toArray(((Collection)this), arg2);
    }
}

