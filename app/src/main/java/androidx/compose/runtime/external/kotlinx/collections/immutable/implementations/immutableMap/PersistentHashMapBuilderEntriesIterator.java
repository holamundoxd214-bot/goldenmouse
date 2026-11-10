package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000B\u001A\u00020\fH\u0096\u0002J\u0015\u0010\r\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\u001B\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u0001¢\u0006\u0002\u0010\u0013R,\u0010\t\u001A \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;", "K", "V", "", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)V", "base", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "hasNext", "", "next", "remove", "", "setValue", "key", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentHashMapBuilderEntriesIterator implements Iterator, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentHashMapBuilderBaseIterator base;

    static {
    }

    public PersistentHashMapBuilderEntriesIterator(PersistentHashMapBuilder arg5) {
        super();
        int v0 = 8;
        TrieNodeBaseIterator[] v1 = new TrieNodeBaseIterator[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = new TrieNodeMutableEntriesIterator(this);
        }

        this.base = new PersistentHashMapBuilderBaseIterator(arg5, v1);
    }

    public boolean hasNext() {
        return this.base.hasNext();
    }

    public Object next() {
        return this.next();
    }

    public Map$Entry next() {
        return this.base.next();
    }

    public void remove() {
        this.base.remove();
    }

    public final void setValue(Object arg1, Object arg2) {
        this.base.setValue(arg1, arg2);
    }
}

