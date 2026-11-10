package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000B\u001A\u00020\fH\u0096\u0082\u0004J\u0011\u0010\r\u001A\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u000E\u0010\u000FR\u0011\u0010\t\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u000F\u0010\u000B\u001A\u00020\fX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\r\u001A\u00020\u0002X\u0082\u008E\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0010"}, d2={"Lkotlin/ranges/ULongProgressionIterator;", "", "Lkotlin/ULong;", "first", "last", "step", "", "<init>", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ULongProgressionIterator implements Iterator, KMappedMarker {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public ULongProgressionIterator(long arg1, long arg3, long arg5, DefaultConstructorMarker arg7) {
        this(arg1, arg3, arg5);
    }

    private ULongProgressionIterator(long arg4, long arg6, long arg8) {
        super();
        this.finalElement = arg6;
        boolean v1 = true;
        if(Long.compare(arg8, 0) > 0) {
            if(Long.compareUnsigned(arg4, arg6) <= 0) {
            }
            else {
                goto label_13;
            }
        }
        else if(Long.compareUnsigned(arg4, arg6) >= 0) {
        }
        else {
        label_13:
            v1 = false;
        }

        this.hasNext = v1;
        this.step = ULong.constructor-impl(arg8);
        if(this.hasNext) {
        }
        else {
            arg4 = arg6;
        }

        this.next = arg4;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public Object next() {
        return ULong.box-impl(this.next-s-VKNKU());
    }

    public long next-s-VKNKU() {
        long v0 = this.next;
        if(v0 == this.finalElement) {
            if(this.hasNext) {
                this.hasNext = false;
                return v0;
            }

            throw new NoSuchElementException();
        }

        this.next = ULong.constructor-impl(this.step + v0);
        return v0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

