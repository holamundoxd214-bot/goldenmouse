package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u000F\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\b\u0010\u0012\u001A\u00020\fH\u0016J\u000F\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0002R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u0015"}, d2={"Landroidx/collection/Keys;", "K", "V", "", "parent", "Landroidx/collection/ScatterMap;", "(Landroidx/collection/ScatterMap;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "isEmpty", "iterator", "", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class Keys implements Set, KMappedMarker {
    private final ScatterMap parent;

    public Keys(ScatterMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super();
        this.parent = arg2;
    }

    public static final ScatterMap access$getParent$p(Keys arg0) {
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
        return this.parent.containsKey(arg1);
    }

    public boolean containsAll(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        if(arg4.isEmpty()) {
            return 1;
        }

        Iterator v4 = ((Iterable)arg4).iterator();
        do {
            if(!v4.hasNext()) {
                return 1;
            }
        }
        while(this.parent.containsKey(v4.next()));

        return 0;
    }

    public int getSize() {
        return this.parent._size;
    }

    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    public Iterator iterator() {
        return SequencesKt.iterator(new Keys$iterator$1(this, null));
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

