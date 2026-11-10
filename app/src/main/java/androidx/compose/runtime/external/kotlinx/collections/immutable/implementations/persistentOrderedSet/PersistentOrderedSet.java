package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 (*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B/\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\u0016\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u001B\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0017\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001AJ\u001C\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0016J\u001B\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0017\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001AJ\u001C\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0016J\"\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010 \u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160!H\u0016J\u001C\u0010\"\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0016J\u000E\u0010#\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u000F\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0002J\u000E\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000\'H\u0016R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "E", "Lkotlin/collections/AbstractSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "firstElement", "", "lastElement", "hashMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "getFirstElement$runtime", "()Ljava/lang/Object;", "getLastElement$runtime", "getHashMap$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "addAll", "elements", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "retainAll", "clear", "iterator", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedSet extends AbstractSet implements PersistentSet {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0001\u0010\tH\u0000¢\u0006\u0002\b\nR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "", "emptyOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "emptyOf$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PersistentSet emptyOf$runtime() {
            return PersistentOrderedSet.EMPTY;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final PersistentOrderedSet EMPTY;
    private final Object firstElement;
    private final PersistentHashMap hashMap;
    private final Object lastElement;

    static {
        PersistentOrderedSet.Companion = new Companion(null);
        PersistentOrderedSet.$stable = 8;
        PersistentOrderedSet.EMPTY = new PersistentOrderedSet(EndOfChain.INSTANCE, EndOfChain.INSTANCE, PersistentHashMap.Companion.emptyOf$runtime());
    }

    public PersistentOrderedSet(Object arg1, Object arg2, PersistentHashMap arg3) {
        super();
        this.firstElement = arg1;
        this.lastElement = arg2;
        this.hashMap = arg3;
    }

    public static final PersistentOrderedSet access$getEMPTY$cp() {
        return PersistentOrderedSet.EMPTY;
    }

    public PersistentCollection add(Object arg1) {
        return this.add(arg1);
    }

    public PersistentSet add(Object arg4) {
        if(this.hashMap.containsKey(arg4)) {
            return this;
        }

        if(this.isEmpty()) {
            return new PersistentOrderedSet(arg4, arg4, this.hashMap.put(arg4, new Links()));
        }

        Object v0 = this.lastElement;
        Object v1 = this.hashMap.get(v0);
        Intrinsics.checkNotNull(v1);
        return new PersistentOrderedSet(this.firstElement, arg4, this.hashMap.put(v0, ((Links)v1).withNext(arg4)).put(arg4, new Links(v0)));
    }

    public PersistentCollection addAll(Collection arg1) {
        return this.addAll(arg1);
    }

    public PersistentSet addAll(Collection arg2) {
        Builder v1 = ((PersistentSet)this).builder();
        v1.addAll(arg2);
        return v1.build();
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder builder() {
        return this.builder();
    }

    public Builder builder() {
        return new PersistentOrderedSetBuilder(this);
    }

    public PersistentCollection clear() {
        return this.clear();
    }

    public PersistentSet clear() {
        return PersistentOrderedSet.Companion.emptyOf$runtime();
    }

    public boolean contains(Object arg1) {
        return this.hashMap.containsKey(arg1);
    }

    public final Object getFirstElement$runtime() {
        return this.firstElement;
    }

    public final PersistentHashMap getHashMap$runtime() {
        return this.hashMap;
    }

    public final Object getLastElement$runtime() {
        return this.lastElement;
    }

    public int getSize() {
        return this.hashMap.size();
    }

    public Iterator iterator() {
        return new PersistentOrderedSetIterator(this.firstElement, this.hashMap);
    }

    public PersistentCollection remove(Object arg1) {
        return this.remove(arg1);
    }

    public PersistentSet remove(Object arg5) {
        Object v1;
        Object v0 = this.hashMap.get(arg5);
        if(v0 == null) {
            return this;
        }

        PersistentHashMap v5 = this.hashMap.remove(arg5);
        if(((Links)v0).getHasPrevious()) {
            v1 = v5.get(((Links)v0).getPrevious());
            Intrinsics.checkNotNull(v1);
            v5 = v5.put(((Links)v0).getPrevious(), ((Links)v1).withNext(((Links)v0).getNext()));
        }

        if(((Links)v0).getHasNext()) {
            v1 = v5.get(((Links)v0).getNext());
            Intrinsics.checkNotNull(v1);
            v5 = v5.put(((Links)v0).getNext(), ((Links)v1).withPrevious(((Links)v0).getPrevious()));
        }

        v1 = !((Links)v0).getHasPrevious() ? ((Links)v0).getNext() : this.firstElement;
        Object v4 = !((Links)v0).getHasNext() ? ((Links)v0).getPrevious() : this.lastElement;
        return new PersistentOrderedSet(v1, v4, v5);
    }

    public PersistentCollection removeAll(Collection arg1) {
        return this.removeAll(arg1);
    }

    public PersistentSet removeAll(Collection arg2) {
        Builder v1 = ((PersistentSet)this).builder();
        v1.removeAll(arg2);
        return v1.build();
    }

    public PersistentCollection removeAll(Function1 arg1) {
        return this.removeAll(arg1);
    }

    public PersistentSet removeAll(Function1 arg2) {
        Builder v1 = ((PersistentSet)this).builder();
        CollectionsKt.removeAll(v1, arg2);
        return v1.build();
    }

    public PersistentCollection retainAll(Collection arg1) {
        return this.retainAll(arg1);
    }

    public PersistentSet retainAll(Collection arg2) {
        Builder v1 = ((PersistentSet)this).builder();
        v1.retainAll(arg2);
        return v1.build();
    }
}

