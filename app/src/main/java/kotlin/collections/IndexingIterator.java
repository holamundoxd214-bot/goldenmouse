package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0017\bF\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001A\u00020\nH\u0086\u0082\u0004J\u0010\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0082\u0004R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "<init>", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class IndexingIterator implements Iterator, KMappedMarker {
    private int index;
    private final Iterator iterator;

    public IndexingIterator(Iterator arg2) {
        Intrinsics.checkNotNullParameter(arg2, "iterator");
        super();
        this.iterator = arg2;
    }

    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Object next() {
        return this.next();
    }

    public final IndexedValue next() {
        int v1 = this.index;
        this.index = v1 + 1;
        if(v1 < 0) {
            CollectionsKt.throwIndexOverflow();
        }

        return new IndexedValue(v1, this.iterator.next());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

