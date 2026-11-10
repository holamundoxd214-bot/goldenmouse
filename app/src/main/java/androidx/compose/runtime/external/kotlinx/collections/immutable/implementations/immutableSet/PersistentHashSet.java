package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\"B\u001D\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u001B\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001C\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u001B\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001C\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\"\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F0\u001AH\u0016J\u001C\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u0016\u0010\u001C\u001A\u00020\u000F2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\u000E\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u000F\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0096\u0002J\u000E\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0016R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006#"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "E", "Lkotlin/collections/AbstractSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "size", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;I)V", "getNode$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "addAll", "elements", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "retainAll", "containsAll", "clear", "iterator", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentHashSet extends AbstractSet implements PersistentSet {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0001\u0010\tH\u0000¢\u0006\u0002\b\nR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "", "emptyOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "emptyOf$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PersistentSet emptyOf$runtime() {
            return PersistentHashSet.EMPTY;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final PersistentHashSet EMPTY;
    private final TrieNode node;
    private final int size;

    static {
        PersistentHashSet.Companion = new Companion(null);
        PersistentHashSet.$stable = 8;
        PersistentHashSet.EMPTY = new PersistentHashSet(TrieNode.Companion.getEMPTY$runtime(), 0);
    }

    public PersistentHashSet(TrieNode arg1, int arg2) {
        super();
        this.node = arg1;
        this.size = arg2;
    }

    public static final PersistentHashSet access$getEMPTY$cp() {
        return PersistentHashSet.EMPTY;
    }

    public PersistentCollection add(Object arg1) {
        return this.add(arg1);
    }

    public PersistentSet add(Object arg4) {
        TrieNode v0 = this.node;
        int v2 = arg4 != null ? arg4.hashCode() : 0;
        TrieNode v4 = v0.add(v2, arg4, 0);
        if(this.node == v4) {
            return this;
        }

        return new PersistentHashSet(v4, this.size() + 1);
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
        return new PersistentHashSetBuilder(this);
    }

    public PersistentCollection clear() {
        return this.clear();
    }

    public PersistentSet clear() {
        return PersistentHashSet.Companion.emptyOf$runtime();
    }

    public boolean contains(Object arg3) {
        TrieNode v2 = this.node;
        int v1 = arg3 != null ? arg3.hashCode() : 0;
        return v2.contains(v1, arg3, 0);
    }

    public boolean containsAll(Collection arg3) {
        if((arg3 instanceof PersistentHashSet)) {
            return this.node.containsAll(((PersistentHashSet)arg3).node, 0);
        }

        if((arg3 instanceof PersistentHashSetBuilder)) {
            return this.node.containsAll(((PersistentHashSetBuilder)arg3).getNode$runtime(), 0);
        }

        return super.containsAll(arg3);
    }

    public final TrieNode getNode$runtime() {
        return this.node;
    }

    public int getSize() {
        return this.size;
    }

    public Iterator iterator() {
        return new PersistentHashSetIterator(this.node);
    }

    public PersistentCollection remove(Object arg1) {
        return this.remove(arg1);
    }

    public PersistentSet remove(Object arg4) {
        TrieNode v0 = this.node;
        int v2 = arg4 != null ? arg4.hashCode() : 0;
        TrieNode v4 = v0.remove(v2, arg4, 0);
        if(this.node == v4) {
            return this;
        }

        return new PersistentHashSet(v4, this.size() - 1);
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

