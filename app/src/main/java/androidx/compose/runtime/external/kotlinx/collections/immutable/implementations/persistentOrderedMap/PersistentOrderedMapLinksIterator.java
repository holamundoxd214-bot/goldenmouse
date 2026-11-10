package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B+\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001A\u00020\u0016H\u0096\u0002J\u000F\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002R\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER \u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\u00020\u0010X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapLinksIterator;", "K", "V", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "nextKey", "", "hashMap", "", "<init>", "(Ljava/lang/Object;Ljava/util/Map;)V", "getNextKey$runtime", "()Ljava/lang/Object;", "setNextKey$runtime", "(Ljava/lang/Object;)V", "index", "", "getIndex$runtime", "()I", "setIndex$runtime", "(I)V", "hasNext", "", "next", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class PersistentOrderedMapLinksIterator implements Iterator, KMappedMarker {
    public static final int $stable = 8;
    private final Map hashMap;
    private int index;
    private Object nextKey;

    static {
    }

    public PersistentOrderedMapLinksIterator(Object arg1, Map arg2) {
        super();
        this.nextKey = arg1;
        this.hashMap = arg2;
    }

    public final int getIndex$runtime() {
        return this.index;
    }

    public final Object getNextKey$runtime() {
        return this.nextKey;
    }

    public boolean hasNext() {
        if(this.index < this.hashMap.size()) {
            return 1;
        }

        return 0;
    }

    public LinkedValue next() {
        if(this.hasNext()) {
            Object v0 = this.hashMap.get(this.nextKey);
            if(v0 != null) {
                ++this.index;
                this.nextKey = ((LinkedValue)v0).getNext();
                return ((LinkedValue)v0);
            }

            throw new ConcurrentModificationException("Hash code of a key (" + this.nextKey + ") has changed after it was added to the persistent map.");
        }

        throw new NoSuchElementException();
    }

    public Object next() {
        return this.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex$runtime(int arg1) {
        this.index = arg1;
    }

    public final void setNextKey$runtime(Object arg1) {
        this.nextKey = arg1;
    }
}

