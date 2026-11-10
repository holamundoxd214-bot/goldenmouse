package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001A\u00020\u000EH\u0016J\u000F\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0002J\u0015\u0010\u0011\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0016\u0010\u0016\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderKeys;", "K", "V", "", "Lkotlin/collections/AbstractMutableSet;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "add", "", "element", "(Ljava/lang/Object;)Z", "clear", "", "iterator", "", "remove", "size", "", "getSize", "()I", "contains", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMapBuilderKeys extends AbstractMutableSet implements Set, KMutableSet {
    public static final int $stable = 8;
    private final PersistentOrderedMapBuilder builder;

    static {
    }

    public PersistentOrderedMapBuilderKeys(PersistentOrderedMapBuilder arg1) {
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
        return this.builder.containsKey(arg1);
    }

    public int getSize() {
        return this.builder.size();
    }

    public Iterator iterator() {
        return new PersistentOrderedMapBuilderKeysIterator(this.builder);
    }

    public boolean remove(Object arg2) {
        if(this.builder.containsKey(arg2)) {
            this.builder.remove(arg2);
            return 1;
        }

        return 0;
    }
}

