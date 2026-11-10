package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u0000 -*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001-B#\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001A\u0010\u001A\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u0010H\u0002J\u001A\u0010\u0019\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u001BH\u0001J\u0015\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001FJ\u0018\u0010 \u001A\u0004\u0018\u00018\u00012\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010!J)\u0010\"\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001E\u001A\u00028\u00002\u0006\u0010#\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010$J!\u0010%\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010&J)\u0010%\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001E\u001A\u00028\u00002\u0006\u0010#\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010$J*\u0010\'\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010(\u001A\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)H\u0016J\u0014\u0010*\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u0014\u0010+\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,H\u0016R \u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001A\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0012¨\u0006."}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "K", "V", "Lkotlin/collections/AbstractMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getSize", "()I", "keys", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "getKeys", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "entries", "", "getEntries", "createEntries", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "putAll", "m", "", "clear", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class PersistentHashMap extends AbstractMap implements PersistentMap {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0005\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\tH\u0000¢\u0006\u0002\b\nR\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "", "emptyOf", "K", "V", "emptyOf$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PersistentHashMap emptyOf$runtime() {
            PersistentHashMap v1 = PersistentHashMap.EMPTY;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final PersistentHashMap EMPTY;
    private final TrieNode node;
    private final int size;

    static {
        PersistentHashMap.Companion = new Companion(null);
        PersistentHashMap.$stable = 8;
        PersistentHashMap.EMPTY = new PersistentHashMap(TrieNode.Companion.getEMPTY$runtime(), 0);
    }

    public PersistentHashMap(TrieNode arg1, int arg2) {
        super();
        this.node = arg1;
        this.size = arg2;
    }

    public static final PersistentHashMap access$getEMPTY$cp() {
        return PersistentHashMap.EMPTY;
    }

    public Builder builder() {
        return this.builder();
    }

    public PersistentHashMapBuilder builder() {
        return new PersistentHashMapBuilder(this);
    }

    public PersistentMap clear() {
        return PersistentHashMap.Companion.emptyOf$runtime();
    }

    public boolean containsKey(Object arg3) {
        TrieNode v2 = this.node;
        int v1 = arg3 != null ? arg3.hashCode() : 0;
        return v2.containsKey(v1, arg3, 0);
    }

    private final ImmutableSet createEntries() {
        return new PersistentHashMapEntries(this);
    }

    public final ImmutableSet entrySet() {
        return this.getEntries();
    }

    public Object get(Object arg3) {
        TrieNode v2 = this.node;
        int v1 = arg3 != null ? arg3.hashCode() : 0;
        return v2.get(v1, arg3, 0);
    }

    public ImmutableSet getEntries() {
        return this.createEntries();
    }

    public final Set getEntries() {
        return this.createEntries();
    }

    public ImmutableSet getKeys() {
        return new PersistentHashMapKeys(this);
    }

    public Set getKeys() {
        return this.getKeys();
    }

    public final TrieNode getNode$runtime() {
        return this.node;
    }

    public int getSize() {
        return this.size;
    }

    public ImmutableCollection getValues() {
        return new PersistentHashMapValues(this);
    }

    public Collection getValues() {
        return this.getValues();
    }

    public final ImmutableSet keySet() {
        return this.getKeys();
    }

    public PersistentMap put(Object arg1, Object arg2) {
        return this.put(arg1, arg2);
    }

    public PersistentHashMap put(Object arg4, Object arg5) {
        TrieNode v0 = this.node;
        int v2 = arg4 != null ? arg4.hashCode() : 0;
        ModificationResult v4 = v0.put(v2, arg4, arg5, 0);
        if(v4 == null) {
            return this;
        }

        return new PersistentHashMap(v4.getNode(), this.size() + v4.getSizeDelta());
    }

    public PersistentMap putAll(Map arg2) {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        Builder v1 = ((PersistentMap)this).builder();
        v1.putAll(arg2);
        return v1.build();
    }

    public PersistentMap remove(Object arg1) {
        return this.remove(arg1);
    }

    public PersistentHashMap remove(Object arg4) {
        TrieNode v0 = this.node;
        int v2 = arg4 != null ? arg4.hashCode() : 0;
        TrieNode v4 = v0.remove(v2, arg4, 0);
        if(this.node == v4) {
            return this;
        }

        if(v4 == null) {
            return PersistentHashMap.Companion.emptyOf$runtime();
        }

        return new PersistentHashMap(v4, this.size() - 1);
    }

    public PersistentMap remove(Object arg1, Object arg2) {
        return this.remove(arg1, arg2);
    }

    public PersistentHashMap remove(Object arg4, Object arg5) {
        TrieNode v0 = this.node;
        int v2 = arg4 != null ? arg4.hashCode() : 0;
        TrieNode v4 = v0.remove(v2, arg4, arg5, 0);
        if(this.node == v4) {
            return this;
        }

        if(v4 == null) {
            return PersistentHashMap.Companion.emptyOf$runtime();
        }

        return new PersistentHashMap(v4, this.size() - 1);
    }

    public final ImmutableCollection values() {
        return this.getValues();
    }
}

