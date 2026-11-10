package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.AbstractMapBuilderEntries;
import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001C\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\b\u0010\f\u001A\u00020\rH\u0016J\u001B\u0010\u000E\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u000FH\u0096\u0002J\u001C\u0010\u0010\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u001C\u0010\u0016\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0016R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderEntries;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/AbstractMapBuilderEntries;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "add", "", "element", "clear", "", "iterator", "", "removeEntry", "", "size", "", "getSize", "()I", "containsEntry", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMapBuilderEntries extends AbstractMapBuilderEntries {
    public static final int $stable = 8;
    private final PersistentOrderedMapBuilder builder;

    static {
    }

    public PersistentOrderedMapBuilderEntries(PersistentOrderedMapBuilder arg1) {
        super();
        this.builder = arg1;
    }

    public boolean add(Object arg1) {
        return this.add(((Map$Entry)arg1));
    }

    public boolean add(Map$Entry arg1) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.builder.clear();
    }

    public boolean containsEntry(Map$Entry arg3) {
        Object v0 = this.builder.get(arg3.getKey());
        if(v0 != null) {
            return Intrinsics.areEqual(v0, arg3.getValue());
        }

        if(arg3.getValue() == null && (this.builder.containsKey(arg3.getKey()))) {
            return 1;
        }

        return 0;
    }

    public int getSize() {
        return this.builder.size();
    }

    public Iterator iterator() {
        return new PersistentOrderedMapBuilderEntriesIterator(this.builder);
    }

    public boolean removeEntry(Map$Entry arg2) {
        return this.builder.remove(arg2.getKey(), arg2.getValue());
    }
}

