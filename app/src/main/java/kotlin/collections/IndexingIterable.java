package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u001D\bF\u0012\u0012\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006H\u0096\u0082\u0004R\u001B\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class IndexingIterable implements Iterable, KMappedMarker {
    private final Function0 iteratorFactory;

    public IndexingIterable(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "iteratorFactory");
        super();
        this.iteratorFactory = arg2;
    }

    public Iterator iterator() {
        return new IndexingIterator(this.iteratorFactory.invoke());
    }
}

