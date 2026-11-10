package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0005B\u001B\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\u000E\u001A\u00020\u000F2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\u001B\u0010\u0011\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0012H\u0096\u0002R\u001A\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapEntries;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "Lkotlin/collections/AbstractSet;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "size", "", "getSize", "()I", "contains", "", "element", "iterator", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentHashMapEntries extends AbstractSet implements ImmutableSet {
    public static final int $stable = 8;
    private final PersistentHashMap map;

    static {
    }

    public PersistentHashMapEntries(PersistentHashMap arg1) {
        super();
        this.map = arg1;
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof Map$Entry)) {
            return 0;
        }

        return this.contains(((Map$Entry)arg2));
    }

    public boolean contains(Map$Entry arg4) {
        if(!(arg4 instanceof Map$Entry)) {
            return 0;
        }

        Object v0 = this.map.get(arg4.getKey());
        if(v0 != null) {
            return Intrinsics.areEqual(v0, arg4.getValue());
        }

        if(arg4.getValue() == null && (this.map.containsKey(arg4.getKey()))) {
            return 1;
        }

        return 0;
    }

    public int getSize() {
        return this.map.size();
    }

    public Iterator iterator() {
        return new PersistentHashMapEntriesIterator(this.map.getNode$runtime());
    }
}

