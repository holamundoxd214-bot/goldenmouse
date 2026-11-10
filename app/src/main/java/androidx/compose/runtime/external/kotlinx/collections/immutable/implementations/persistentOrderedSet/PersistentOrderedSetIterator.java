package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001A\u00020\u0013H\u0096\u0002J\u000E\u0010\u0014\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001A\u00020\u0017H\u0002R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\rX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetIterator;", "E", "", "nextElement", "", "map", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "<init>", "(Ljava/lang/Object;Ljava/util/Map;)V", "getMap$runtime", "()Ljava/util/Map;", "index", "", "getIndex$runtime", "()I", "setIndex$runtime", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "checkHasNext", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class PersistentOrderedSetIterator implements Iterator, KMappedMarker {
    public static final int $stable = 8;
    private int index;
    private final Map map;
    private Object nextElement;

    static {
    }

    public PersistentOrderedSetIterator(Object arg1, Map arg2) {
        super();
        this.nextElement = arg1;
        this.map = arg2;
    }

    private final void checkHasNext() {
        if(this.hasNext()) {
            return;
        }

        throw new NoSuchElementException();
    }

    public final int getIndex$runtime() {
        return this.index;
    }

    public final Map getMap$runtime() {
        return this.map;
    }

    public boolean hasNext() {
        if(this.index < this.map.size()) {
            return 1;
        }

        return 0;
    }

    public Object next() {
        this.checkHasNext();
        Object v0 = this.nextElement;
        ++this.index;
        Object v1 = this.map.get(v0);
        if(v1 != null) {
            this.nextElement = ((Links)v1).getNext();
            return v0;
        }

        throw new ConcurrentModificationException("Hash code of an element (" + v0 + ") has changed after it was added to the persistent set.");
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex$runtime(int arg1) {
        this.index = arg1;
    }
}

