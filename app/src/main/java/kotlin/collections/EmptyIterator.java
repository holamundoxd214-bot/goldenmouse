package kotlin.collections;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0005\u001A\u00020\u0006H\u0096\u0082\u0004J\n\u0010\u0007\u001A\u00020\u0006H\u0096\u0080\u0004J\n\u0010\b\u001A\u00020\tH\u0096\u0080\u0004J\n\u0010\n\u001A\u00020\tH\u0096\u0080\u0004J\n\u0010\u000B\u001A\u00020\u0002H\u0096\u0082\u0004J\n\u0010\f\u001A\u00020\u0002H\u0096\u0080\u0004¨\u0006\r"}, d2={"Lkotlin/collections/EmptyIterator;", "", "", "<init>", "()V", "hasNext", "", "hasPrevious", "nextIndex", "", "previousIndex", "next", "previous", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class EmptyIterator implements ListIterator, KMappedMarker {
    public static final EmptyIterator INSTANCE;

    static {
        EmptyIterator.INSTANCE = new EmptyIterator();
    }

    private EmptyIterator() {
        super();
    }

    public void add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void add(Void arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean hasNext() {
        return 0;
    }

    public boolean hasPrevious() {
        return 0;
    }

    public Object next() {
        return this.next();
    }

    public Void next() {
        throw new NoSuchElementException();
    }

    public int nextIndex() {
        return 0;
    }

    public Object previous() {
        return this.previous();
    }

    public Void previous() {
        throw new NoSuchElementException();
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void set(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void set(Void arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

