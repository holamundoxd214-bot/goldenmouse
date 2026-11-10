package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0017\b\u0002\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0015\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0000¢\u0006\u0002\b\u000BJ\u0015\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0000¢\u0006\u0002\b\rJ\u0011\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0002H\u0096\u0003J\u0017\u0010\u0011\u001A\u00020\u000F2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0096\u0001J\u0011\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u0016H\u0096\u0003J\u0011\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0010\u001A\u00020\u0002H\u0096\u0001J\t\u0010\u0018\u001A\u00020\u000FH\u0096\u0001J\u000F\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00020\u001AH\u0096\u0003J\u0011\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u0010\u001A\u00020\u0002H\u0096\u0001J\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00020\u001DH\u0096\u0001J\u0017\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00020\u001D2\u0006\u0010\u0015\u001A\u00020\u0016H\u0096\u0001J\u001F\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001F\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u0016H\u0096\u0001R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010!\u001A\u00020\u0016X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u0006%"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList$PinnedItem;", "items", "", "<init>", "(Ljava/util/List;)V", "()V", "pin", "", "item", "pin$foundation", "release", "release$foundation", "contains", "", "element", "containsAll", "elements", "", "get", "index", "", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "size", "getSize", "()I", "PinnedItem", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutPinnedItemList implements List, KMappedMarker {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b\u0082\u0001\u0001\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList$PinnedItem;", "", "key", "getKey", "()Ljava/lang/Object;", "index", "", "getIndex", "()I", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnableItem;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PinnedItem {
        int getIndex();

        Object getKey();
    }

    public static final int $stable = 8;
    private final List items;

    static {
    }

    public LazyLayoutPinnedItemList() {
        this(new SnapshotStateList());
    }

    private LazyLayoutPinnedItemList(List arg1) {
        super();
        this.items = arg1;
    }

    public void add(int arg1, PinnedItem arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(int arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(PinnedItem arg1) {
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

    public void addFirst(PinnedItem arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addFirst(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(PinnedItem arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void addLast(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(PinnedItem arg1) {
        return this.items.contains(arg1);
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof PinnedItem)) {
            return 0;
        }

        return this.contains(((PinnedItem)arg2));
    }

    public boolean containsAll(Collection arg1) {
        return this.items.containsAll(arg1);
    }

    public PinnedItem get(int arg1) {
        return this.items.get(arg1);
    }

    public Object get(int arg1) {
        return this.get(arg1);
    }

    public int getSize() {
        return this.items.size();
    }

    public int indexOf(PinnedItem arg1) {
        return this.items.indexOf(arg1);
    }

    public final int indexOf(Object arg2) {
        if(!(arg2 instanceof PinnedItem)) {
            return -1;
        }

        return this.indexOf(((PinnedItem)arg2));
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public Iterator iterator() {
        return this.items.iterator();
    }

    public int lastIndexOf(PinnedItem arg1) {
        return this.items.lastIndexOf(arg1);
    }

    public final int lastIndexOf(Object arg2) {
        if(!(arg2 instanceof PinnedItem)) {
            return -1;
        }

        return this.lastIndexOf(((PinnedItem)arg2));
    }

    public ListIterator listIterator() {
        return this.items.listIterator();
    }

    public ListIterator listIterator(int arg1) {
        return this.items.listIterator(arg1);
    }

    public final void pin$foundation(PinnedItem arg1) {
        this.items.add(arg1);
    }

    public final void release$foundation(PinnedItem arg1) {
        this.items.remove(arg1);
    }

    public PinnedItem remove(int arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    public PinnedItem removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public PinnedItem removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(UnaryOperator arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public PinnedItem set(int arg1, PinnedItem arg2) {
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

    public List subList(int arg1, int arg2) {
        return this.items.subList(arg1, arg2);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg1) {
        return CollectionToArray.toArray(((Collection)this), arg1);
    }
}

