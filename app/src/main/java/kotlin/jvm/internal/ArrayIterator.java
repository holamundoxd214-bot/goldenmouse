package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\bF\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\f\u001A\u00020\rH\u0096\u0082\u0004J\u000F\u0010\u000E\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000FR\u001D\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR\u000F\u0010\n\u001A\u00020\u000BX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "array", "", "<init>", "([Ljava/lang/Object;)V", "getArray", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "index", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class ArrayIterator implements Iterator, KMappedMarker {
    private final Object[] array;
    private int index;

    public ArrayIterator(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        super();
        this.array = arg2;
    }

    public final Object[] getArray() {
        return this.array;
    }

    public boolean hasNext() {
        if(this.index < this.array.length) {
            return 1;
        }

        return 0;
    }

    public Object next() {
        Object v3;
        try {
            Object[] v0_1 = this.array;
            int v1 = this.index;
            this.index = v1 + 1;
            v3 = v0_1[v1];
            return v3;
        }
        catch(ArrayIndexOutOfBoundsException v0) {
            --((ArrayIterator)v3).index;
            throw new NoSuchElementException(v0.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

