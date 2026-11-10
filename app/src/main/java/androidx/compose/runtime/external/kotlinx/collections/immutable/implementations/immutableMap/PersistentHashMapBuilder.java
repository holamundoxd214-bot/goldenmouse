package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0010\'\n\u0002\b\u0005\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010%\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0016J\u0015\u00101\u001A\u0002022\u0006\u00103\u001A\u00028\u0000H\u0016¢\u0006\u0002\u00104J\u0018\u00105\u001A\u0004\u0018\u00018\u00012\u0006\u00103\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00106J\u001F\u00107\u001A\u0004\u0018\u00018\u00012\u0006\u00103\u001A\u00028\u00002\u0006\u0010\t\u001A\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001E\u00109\u001A\u00020:2\u0014\u0010;\u001A\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010<H\u0016J\u0017\u0010=\u001A\u0004\u0018\u00018\u00012\u0006\u00103\u001A\u00028\u0000H\u0016¢\u0006\u0002\u00106J\u001B\u0010=\u001A\u0002022\u0006\u00103\u001A\u00028\u00002\u0006\u0010\t\u001A\u00028\u0001¢\u0006\u0002\u0010>J\b\u0010?\u001A\u00020:H\u0016R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n@DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR&\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001E\u0010\u0016\u001A\u0004\u0018\u00018\u0001X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u001B\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001C\u001A\u00020\u001DX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R$\u0010\"\u001A\u00020\u001D2\u0006\u0010\t\u001A\u00020\u001D@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u001F\"\u0004\b$\u0010!R&\u0010&\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010(0\'8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b)\u0010*R\u001A\u0010+\u001A\b\u0012\u0004\u0012\u00028\u00000\'8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b,\u0010*R\u001A\u0010-\u001A\b\u0012\u0004\u0012\u00028\u00010.8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b/\u00100¨\u0006@"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Lkotlin/collections/AbstractMutableMap;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "value", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnership", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getNode$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "operationResult", "getOperationResult$runtime", "()Ljava/lang/Object;", "setOperationResult$runtime", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "modCount", "", "getModCount$runtime", "()I", "setModCount$runtime", "(I)V", "size", "getSize", "setSize", "build", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "", "from", "", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class PersistentHashMapBuilder extends AbstractMutableMap implements Builder {
    public static final int $stable = 8;
    private PersistentHashMap map;
    private int modCount;
    private TrieNode node;
    private Object operationResult;
    private MutabilityOwnership ownership;
    private int size;

    static {
    }

    public PersistentHashMapBuilder(PersistentHashMap arg1) {
        super();
        this.map = arg1;
        this.ownership = new MutabilityOwnership();
        this.node = this.map.getNode$runtime();
        this.size = this.map.size();
    }

    public PersistentHashMap build() {
        PersistentHashMap v0;
        if(this.node == this.map.getNode$runtime()) {
            v0 = this.map;
        }
        else {
            this.ownership = new MutabilityOwnership();
            v0 = new PersistentHashMap(this.node, this.size());
        }

        this.map = v0;
        return v0;
    }

    public PersistentMap build() {
        return this.build();
    }

    public void clear() {
        TrieNode v0 = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = v0;
        this.setSize(0);
    }

    public boolean containsKey(Object arg3) {
        TrieNode v2 = this.node;
        int v1 = arg3 != null ? arg3.hashCode() : 0;
        return v2.containsKey(v1, arg3, 0);
    }

    public Object get(Object arg3) {
        TrieNode v2 = this.node;
        int v1 = arg3 != null ? arg3.hashCode() : 0;
        return v2.get(v1, arg3, 0);
    }

    public Set getEntries() {
        return new PersistentHashMapBuilderEntries(this);
    }

    public Set getKeys() {
        return new PersistentHashMapBuilderKeys(this);
    }

    public final int getModCount$runtime() {
        return this.modCount;
    }

    public final TrieNode getNode$runtime() {
        return this.node;
    }

    public final Object getOperationResult$runtime() {
        return this.operationResult;
    }

    public final MutabilityOwnership getOwnership() {
        return this.ownership;
    }

    public int getSize() {
        return this.size;
    }

    public Collection getValues() {
        return new PersistentHashMapBuilderValues(this);
    }

    public Object put(Object arg8, Object arg9) {
        this.operationResult = null;
        TrieNode v1 = this.node;
        int v0 = arg8 != null ? arg8.hashCode() : 0;
        this.node = v1.mutablePut(v0, arg8, arg9, 0, this);
        return this.operationResult;
    }

    public void putAll(Map arg7) {
        PersistentHashMap v0_1;
        DefaultConstructorMarker v1 = null;
        Map v0 = (arg7 instanceof PersistentHashMap) ? arg7 : ((Map)v1);
        if(v0 == null) {
            v0 = (arg7 instanceof PersistentHashMapBuilder) ? arg7 : ((Map)v1);
            if(v0 != null) {
                v0_1 = ((PersistentHashMapBuilder)v0).build();
                goto label_16;
            }

            v0 = ((Map)v1);
        }

    label_16:
        if((((Map)v0_1)) != null) {
            DeltaCounter v7 = new DeltaCounter(0, 1, v1);
            int v1_1 = this.size();
            TrieNode v2 = this.node;
            TrieNode v4 = v0_1.getNode$runtime();
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
            this.node = v2.mutablePutAll(v4, 0, v7, this);
            int v0_2 = v0_1.size() + v1_1 - v7.getCount();
            if(v1_1 != v0_2) {
                this.setSize(v0_2);
            }

            return;
        }

        super.putAll(arg7);
    }

    public Object remove(Object arg4) {
        this.operationResult = null;
        TrieNode v0 = this.node;
        int v2 = arg4 != null ? arg4.hashCode() : 0;
        TrieNode v4 = v0.mutableRemove(v2, arg4, 0, this);
        if(v4 == null) {
            v4 = TrieNode.Companion.getEMPTY$runtime();
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }

        this.node = v4;
        return this.operationResult;
    }

    public final boolean remove(Object arg9, Object arg10) {
        int v0 = this.size();
        TrieNode v1 = this.node;
        int v2 = arg9 != null ? arg9.hashCode() : 0;
        PersistentHashMapBuilder v6 = this;
        TrieNode v8 = v1.mutableRemove(v2, arg9, arg10, 0, v6);
        if(v8 == null) {
            v8 = TrieNode.Companion.getEMPTY$runtime();
            Intrinsics.checkNotNull(v8, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }

        v6.node = v8;
        if(v0 != v6.size()) {
            return 1;
        }

        return 0;
    }

    public final void setModCount$runtime(int arg1) {
        this.modCount = arg1;
    }

    public final void setNode$runtime(TrieNode arg1) {
        this.node = arg1;
    }

    public final void setOperationResult$runtime(Object arg1) {
        this.operationResult = arg1;
    }

    protected final void setOwnership(MutabilityOwnership arg1) {
        this.ownership = arg1;
    }

    public void setSize(int arg1) {
        this.size = arg1;
        ++this.modCount;
    }
}

