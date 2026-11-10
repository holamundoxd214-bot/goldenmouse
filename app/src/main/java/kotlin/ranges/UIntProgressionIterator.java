package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000B\u001A\u00020\fH\u0096\u0082\u0004J\u0011\u0010\r\u001A\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u000E\u0010\u000FR\u0011\u0010\t\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u000F\u0010\u000B\u001A\u00020\fX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\r\u001A\u00020\u0002X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0010"}, d2={"Lkotlin/ranges/UIntProgressionIterator;", "", "Lkotlin/UInt;", "first", "last", "step", "", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class UIntProgressionIterator implements Iterator, KMappedMarker {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public UIntProgressionIterator(int arg1, int arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private UIntProgressionIterator(int arg4, int arg5, int arg6) {
        super();
        this.finalElement = arg5;
        boolean v0 = true;
        int v2 = Integer.compareUnsigned(arg4, arg5);
        if(arg6 > 0) {
            if(v2 <= 0) {
            }
            else {
                goto label_10;
            }
        }
        else if(v2 >= 0) {
        }
        else {
        label_10:
            v0 = false;
        }

        this.hasNext = v0;
        this.step = UInt.constructor-impl(arg6);
        if(this.hasNext) {
        }
        else {
            arg4 = arg5;
        }

        this.next = arg4;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public Object next() {
        return UInt.box-impl(this.next-pVg5ArA());
    }

    public int next-pVg5ArA() {
        int v0 = this.next;
        if(v0 == this.finalElement) {
            if(this.hasNext) {
                this.hasNext = false;
                return v0;
            }

            throw new NoSuchElementException();
        }

        this.next = UInt.constructor-impl(this.step + v0);
        return v0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

