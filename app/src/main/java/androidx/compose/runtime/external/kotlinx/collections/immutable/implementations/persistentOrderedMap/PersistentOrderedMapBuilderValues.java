package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableCollection;
import kotlin.jvm.internal.markers.KMutableCollection;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\u000F\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0096\u0002R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0016"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderValues;", "K", "V", "", "Lkotlin/collections/AbstractMutableCollection;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "clear", "", "iterator", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMapBuilderValues extends AbstractMutableCollection implements Collection, KMutableCollection {
    public static final int $stable = 8;
    private final PersistentOrderedMapBuilder builder;

    static {
    }

    public PersistentOrderedMapBuilderValues(PersistentOrderedMapBuilder arg1) {
        super();
        this.builder = arg1;
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.builder.clear();
    }

    public boolean contains(Object arg1) {
        return this.builder.containsValue(arg1);
    }

    public int getSize() {
        return this.builder.size();
    }

    public Iterator iterator() {
        return new PersistentOrderedMapBuilderValuesIterator(this.builder);
    }
}

