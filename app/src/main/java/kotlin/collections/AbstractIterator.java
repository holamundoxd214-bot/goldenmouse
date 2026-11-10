package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\t\u001A\u00020\nH\u0096\u0082\u0004J\u000F\u0010\u000B\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001A\u00020\nH\u0082\u0080\u0004J\n\u0010\u000E\u001A\u00020\u000FH¤\u0080\u0004J\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u0000H\u0084\u0080\u0004¢\u0006\u0002\u0010\u0012J\n\u0010\u0013\u001A\u00020\u000FH\u0084\u0080\u0004R\u000F\u0010\u0005\u001A\u00020\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u0004\u0018\u00018\u0000X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, d2={"Lkotlin/collections/AbstractIterator;", "T", "", "<init>", "()V", "state", "", "nextValue", "Ljava/lang/Object;", "hasNext", "", "next", "()Ljava/lang/Object;", "tryToComputeNext", "computeNext", "", "setNext", "value", "(Ljava/lang/Object;)V", "done", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class AbstractIterator implements Iterator, KMappedMarker {
    private Object nextValue;
    private int state;

    public AbstractIterator() {
        super();
    }

    protected abstract void computeNext();

    protected final void done() {
        this.state = 2;
    }

    public boolean hasNext() {
        int v0 = this.state;
        if(v0 != 0) {
            if(v0 != 1) {
                if(v0 == 2) {
                    return 0;
                }

                throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
            }

            return 1;
        }

        return this.tryToComputeNext();
    }

    public Object next() {
        int v0 = this.state;
        if(v0 == 1) {
            this.state = 0;
            return this.nextValue;
        }

        if(v0 != 2 && (this.tryToComputeNext())) {
            this.state = 0;
            return this.nextValue;
        }

        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected final void setNext(Object arg1) {
        this.nextValue = arg1;
        this.state = 1;
    }

    private final boolean tryToComputeNext() {
        this.state = 3;
        this.computeNext();
        if(this.state == 1) {
            return 1;
        }

        return 0;
    }
}

