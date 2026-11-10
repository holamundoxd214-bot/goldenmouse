package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u0016\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001DJ\u0015\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DJ\u0015\u0010\u001F\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DJ\b\u0010 \u001A\u00020!H\u0016J\u000F\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000#H\u0096\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\u0004\u0018\u00010\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0010\u0010\u000E\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R \u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;", "E", "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;)V", "firstElement", "", "getFirstElement$runtime", "()Ljava/lang/Object;", "setFirstElement$runtime", "(Ljava/lang/Object;)V", "lastElement", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "getHashMapBuilder$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "size", "", "getSize", "()I", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "remove", "clear", "", "iterator", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedSetBuilder extends AbstractMutableSet implements Builder {
    public static final int $stable = 8;
    private Object firstElement;
    private final PersistentHashMapBuilder hashMapBuilder;
    private Object lastElement;
    private PersistentOrderedSet set;

    static {
    }

    public PersistentOrderedSetBuilder(PersistentOrderedSet arg1) {
        super();
        this.set = arg1;
        this.firstElement = arg1.getFirstElement$runtime();
        this.lastElement = this.set.getLastElement$runtime();
        this.hashMapBuilder = this.set.getHashMap$runtime().builder();
    }

    public boolean add(Object arg5) {
        if(this.hashMapBuilder.containsKey(arg5)) {
            return 0;
        }

        if(this.isEmpty()) {
            this.firstElement = arg5;
            this.lastElement = arg5;
            this.hashMapBuilder.put(arg5, new Links());
            return 1;
        }

        Object v0 = this.hashMapBuilder.get(this.lastElement);
        Intrinsics.checkNotNull(v0);
        this.hashMapBuilder.put(this.lastElement, ((Links)v0).withNext(arg5));
        this.hashMapBuilder.put(arg5, new Links(this.lastElement));
        this.lastElement = arg5;
        return 1;
    }

    public PersistentSet build() {
        PersistentOrderedSet v0_2;
        PersistentHashMap v0 = this.hashMapBuilder.build();
        if(v0 == this.set.getHashMap$runtime()) {
            boolean v2 = true;
            boolean v0_1 = this.firstElement == this.set.getFirstElement$runtime() ? true : false;
            CommonFunctionsKt.assert(v0_1);
            if(this.lastElement == this.set.getLastElement$runtime()) {
            }
            else {
                v2 = false;
            }

            CommonFunctionsKt.assert(v2);
            v0_2 = this.set;
        }
        else {
            v0_2 = new PersistentOrderedSet(this.firstElement, this.lastElement, v0);
        }

        this.set = v0_2;
        return ((PersistentSet)v0_2);
    }

    public PersistentCollection build() {
        return this.build();
    }

    public void clear() {
        this.hashMapBuilder.clear();
        this.firstElement = EndOfChain.INSTANCE;
        this.lastElement = EndOfChain.INSTANCE;
    }

    public boolean contains(Object arg1) {
        return this.hashMapBuilder.containsKey(arg1);
    }

    public final Object getFirstElement$runtime() {
        return this.firstElement;
    }

    public final PersistentHashMapBuilder getHashMapBuilder$runtime() {
        return this.hashMapBuilder;
    }

    public int getSize() {
        return this.hashMapBuilder.size();
    }

    public Iterator iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    public boolean remove(Object arg5) {
        Object v0;
        arg5 = this.hashMapBuilder.remove(arg5);
        if(arg5 == null) {
            return 0;
        }

        if(((Links)arg5).getHasPrevious()) {
            v0 = this.hashMapBuilder.get(((Links)arg5).getPrevious());
            Intrinsics.checkNotNull(v0);
            this.hashMapBuilder.put(((Links)arg5).getPrevious(), ((Links)v0).withNext(((Links)arg5).getNext()));
        }
        else {
            this.firstElement = ((Links)arg5).getNext();
        }

        if(((Links)arg5).getHasNext()) {
            v0 = this.hashMapBuilder.get(((Links)arg5).getNext());
            Intrinsics.checkNotNull(v0);
            this.hashMapBuilder.put(((Links)arg5).getNext(), ((Links)v0).withPrevious(((Links)arg5).getPrevious()));
        }
        else {
            this.lastElement = ((Links)arg5).getPrevious();
        }

        return 1;
    }

    public final void setFirstElement$runtime(Object arg1) {
        this.firstElement = arg1;
    }
}

