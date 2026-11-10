package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000E\u001A\u00020\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u000FH\u0016J\b\u0010\u0011\u001A\u00020\u0004H\u0016J\b\u0010\u0012\u001A\u00020\u0004H\u0016J\r\u0010\u0013\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u0017R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0005\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000B¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "E", "", "index", "", "size", "<init>", "(II)V", "getIndex", "()I", "setIndex", "(I)V", "getSize", "setSize", "hasNext", "", "hasPrevious", "nextIndex", "previousIndex", "checkHasNext", "", "checkHasNext$runtime", "checkHasPrevious", "checkHasPrevious$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractListIterator implements ListIterator, KMappedMarker {
    public static final int $stable = 8;
    private int index;
    private int size;

    static {
    }

    public AbstractListIterator(int arg1, int arg2) {
        super();
        this.index = arg1;
        this.size = arg2;
    }

    public void add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void checkHasNext$runtime() {
        if(this.hasNext()) {
            return;
        }

        throw new NoSuchElementException();
    }

    public final void checkHasPrevious$runtime() {
        if(this.hasPrevious()) {
            return;
        }

        throw new NoSuchElementException();
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getSize() {
        return this.size;
    }

    public boolean hasNext() {
        if(this.index < this.size) {
            return 1;
        }

        return 0;
    }

    public boolean hasPrevious() {
        if(this.index > 0) {
            return 1;
        }

        return 0;
    }

    public Object next() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int nextIndex() {
        return this.index;
    }

    public int previousIndex() {
        return this.index - 1;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void set(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int arg1) {
        this.index = arg1;
    }

    public final void setSize(int arg1) {
        this.size = arg1;
    }
}

