package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001B\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001A\u00020\u000BH\u0096\u0002J\u000E\u0010\f\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rJ\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderKeysIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "internal", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderLinksIterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMapBuilderKeysIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentOrderedMapBuilderLinksIterator internal;

    static {
    }

    public PersistentOrderedMapBuilderKeysIterator(PersistentOrderedMapBuilder arg3) {
        super();
        this.internal = new PersistentOrderedMapBuilderLinksIterator(arg3.getFirstKey$runtime(), arg3);
    }

    public boolean hasNext() {
        return this.internal.hasNext();
    }

    public Object next() {
        this.internal.next();
        return this.internal.getLastIteratedKey$runtime();
    }

    public void remove() {
        this.internal.remove();
    }
}

