package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000E\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u0016\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001DJ\u0015\u0010\u001E\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DJ\u0016\u0010\u001F\u001A\u00020\u001B2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010\"\u001A\u00020\u001B2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010#\u001A\u00020\u001B2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010$\u001A\u00020\u001B2\f\u0010 \u001A\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0015\u0010%\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001DJ\b\u0010&\u001A\u00020\'H\u0016J\u000F\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00000)H\u0096\u0002R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\t@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR*\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\r@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001E\u0010\u0012\u001A\u00020\u00112\u0006\u0010\b\u001A\u00020\u0011@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001A\u00020\u00112\u0006\u0010\b\u001A\u00020\u0011@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "E", "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;)V", "value", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "node", "getNode$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "modCount", "getModCount$runtime", "()I", "size", "getSize", "setSize", "(I)V", "build", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "addAll", "elements", "", "retainAll", "removeAll", "containsAll", "remove", "clear", "", "iterator", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentHashSetBuilder extends AbstractMutableSet implements Builder {
    public static final int $stable = 8;
    private int modCount;
    private TrieNode node;
    private MutabilityOwnership ownership;
    private PersistentHashSet set;
    private int size;

    static {
    }

    public PersistentHashSetBuilder(PersistentHashSet arg1) {
        super();
        this.set = arg1;
        this.ownership = new MutabilityOwnership();
        this.node = this.set.getNode$runtime();
        this.size = this.set.size();
    }

    public boolean add(Object arg5) {
        int v0 = this.size();
        TrieNode v1 = this.node;
        int v3 = arg5 != null ? arg5.hashCode() : 0;
        this.node = v1.mutableAdd(v3, arg5, 0, this);
        if(v0 != this.size()) {
            return 1;
        }

        return 0;
    }

    public boolean addAll(Collection arg7) {
        PersistentHashSet v0_1;
        DefaultConstructorMarker v1 = null;
        Collection v0 = (arg7 instanceof PersistentHashSet) ? arg7 : ((Collection)v1);
        if(v0 == null) {
            v0 = (arg7 instanceof PersistentHashSetBuilder) ? arg7 : ((Collection)v1);
            if(v0 != null) {
                v0_1 = ((PersistentHashSetBuilder)v0).build();
                goto label_16;
            }

            v0 = ((Collection)v1);
        }

    label_16:
        if((((Collection)v0_1)) != null) {
            DeltaCounter v2 = new DeltaCounter(0, 1, v1);
            int v1_1 = this.size();
            TrieNode v0_2 = this.node.mutableAddAll(v0_1.getNode$runtime(), 0, v2, this);
            int v7 = arg7.size() + v1_1 - v2.getCount();
            if(v1_1 != v7) {
                this.node = v0_2;
                this.setSize(v7);
            }

            if(v1_1 != this.size()) {
                return 1;
            }

            return 0;
        }

        return super.addAll(arg7);
    }

    public PersistentHashSet build() {
        PersistentHashSet v0;
        if(this.node == this.set.getNode$runtime()) {
            v0 = this.set;
        }
        else {
            this.ownership = new MutabilityOwnership();
            v0 = new PersistentHashSet(this.node, this.size());
        }

        this.set = v0;
        return v0;
    }

    public PersistentCollection build() {
        return this.build();
    }

    public PersistentSet build() {
        return this.build();
    }

    public void clear() {
        TrieNode v0 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = v0;
        this.setSize(0);
    }

    public boolean contains(Object arg3) {
        TrieNode v2 = this.node;
        int v1 = arg3 != null ? arg3.hashCode() : 0;
        return v2.contains(v1, arg3, 0);
    }

    public boolean containsAll(Collection arg3) {
        if((arg3 instanceof PersistentHashSet)) {
            return this.node.containsAll(((PersistentHashSet)arg3).getNode$runtime(), 0);
        }

        if((arg3 instanceof PersistentHashSetBuilder)) {
            return this.node.containsAll(((PersistentHashSetBuilder)arg3).node, 0);
        }

        return super.containsAll(arg3);
    }

    public final int getModCount$runtime() {
        return this.modCount;
    }

    public final TrieNode getNode$runtime() {
        return this.node;
    }

    public final MutabilityOwnership getOwnership$runtime() {
        return this.ownership;
    }

    public int getSize() {
        return this.size;
    }

    public Iterator iterator() {
        return new PersistentHashSetMutableIterator(this);
    }

    public boolean remove(Object arg5) {
        int v0 = this.size();
        TrieNode v1 = this.node;
        int v3 = arg5 != null ? arg5.hashCode() : 0;
        this.node = v1.mutableRemove(v3, arg5, 0, this);
        if(v0 != this.size()) {
            return 1;
        }

        return 0;
    }

    public boolean removeAll(Collection arg6) {
        DefaultConstructorMarker v1 = null;
        Collection v0 = (arg6 instanceof PersistentHashSet) ? arg6 : ((Collection)v1);
        if(v0 == null) {
            v0 = (arg6 instanceof PersistentHashSetBuilder) ? arg6 : ((Collection)v1);
            if(v0 != null) {
                PersistentHashSet v0_1 = ((PersistentHashSetBuilder)v0).build();
                goto label_16;
            }

            v0 = ((Collection)v1);
        }

    label_16:
        if(v0 != null) {
            DeltaCounter v6 = new DeltaCounter(0, 1, v1);
            int v1_1 = this.size();
            Object v0_2 = this.node.mutableRemoveAll(((PersistentHashSet)v0).getNode$runtime(), 0, v6, this);
            int v6_1 = v1_1 - v6.getCount();
            if(v6_1 == 0) {
                this.clear();
            }
            else if(v6_1 != v1_1) {
                Intrinsics.checkNotNull(v0_2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
                this.node = ((TrieNode)v0_2);
                this.setSize(v6_1);
            }

            if(v1_1 != this.size()) {
                return 1;
            }

            return 0;
        }

        return super.removeAll(arg6);
    }

    public boolean retainAll(Collection arg6) {
        DefaultConstructorMarker v1 = null;
        Collection v0 = (arg6 instanceof PersistentHashSet) ? arg6 : ((Collection)v1);
        if(v0 == null) {
            v0 = (arg6 instanceof PersistentHashSetBuilder) ? arg6 : ((Collection)v1);
            if(v0 != null) {
                PersistentHashSet v0_1 = ((PersistentHashSetBuilder)v0).build();
                goto label_16;
            }

            v0 = ((Collection)v1);
        }

    label_16:
        if(v0 != null) {
            DeltaCounter v6 = new DeltaCounter(0, 1, v1);
            int v1_1 = this.size();
            Object v0_2 = this.node.mutableRetainAll(((PersistentHashSet)v0).getNode$runtime(), 0, v6, this);
            int v6_1 = v6.getCount();
            if(v6_1 == 0) {
                this.clear();
            }
            else if(v6_1 != v1_1) {
                Intrinsics.checkNotNull(v0_2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
                this.node = ((TrieNode)v0_2);
                this.setSize(v6_1);
            }

            if(v1_1 != this.size()) {
                return 1;
            }

            return 0;
        }

        return super.retainAll(arg6);
    }

    public void setSize(int arg1) {
        this.size = arg1;
        ++this.modCount;
    }
}

