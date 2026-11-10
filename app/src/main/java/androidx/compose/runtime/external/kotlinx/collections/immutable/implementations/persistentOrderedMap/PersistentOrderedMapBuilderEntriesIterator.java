package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000B\u001A\u00020\fH\u0096\u0002J\u0015\u0010\r\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderEntriesIterator;", "K", "V", "", "", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "internal", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderLinksIterator;", "hasNext", "", "next", "remove", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMapBuilderEntriesIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentOrderedMapBuilderLinksIterator internal;

    static {
    }

    public PersistentOrderedMapBuilderEntriesIterator(PersistentOrderedMapBuilder arg3) {
        super();
        this.internal = new PersistentOrderedMapBuilderLinksIterator(arg3.getFirstKey$runtime(), arg3);
    }

    public boolean hasNext() {
        return this.internal.hasNext();
    }

    public Object next() {
        return this.next();
    }

    public Map$Entry next() {
        return new MutableMapEntry(this.internal.getBuilder$runtime().getHashMapBuilder$runtime(), this.internal.getLastIteratedKey$runtime(), this.internal.next());
    }

    public void remove() {
        this.internal.remove();
    }
}

