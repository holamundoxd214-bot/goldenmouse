package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00020\u0003B\u001B\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001A\u00020\u000BH\u0096\u0002J\u000E\u0010\f\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rR\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapValuesIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "internal", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapLinksIterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMapValuesIterator implements Iterator, KMappedMarker {
    public static final int $stable = 8;
    private final PersistentOrderedMapLinksIterator internal;

    static {
    }

    public PersistentOrderedMapValuesIterator(PersistentOrderedMap arg3) {
        super();
        this.internal = new PersistentOrderedMapLinksIterator(arg3.getFirstKey$runtime(), arg3.getHashMap$runtime());
    }

    public boolean hasNext() {
        return this.internal.hasNext();
    }

    public Object next() {
        return this.internal.next().getValue();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

