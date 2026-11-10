package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 4*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u00014B5\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0018\u0010\b\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\b\u000B\u0010\fJ\u001A\u0010!\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001F0\u0017H\u0002J\u001A\u0010 \u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001F0\"H\u0001J\u0015\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010&J\u0018\u0010\'\u001A\u0004\u0018\u00018\u00012\u0006\u0010%\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010(J)\u0010)\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001A\u00028\u00002\u0006\u0010*\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010+J!\u0010,\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010-J)\u0010,\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001A\u00028\u00002\u0006\u0010*\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010+J*\u0010.\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010/\u001A\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0016J\u0014\u00101\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u0014\u00102\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103H\u0016R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER&\u0010\b\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00010\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR&\u0010\u001E\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001F0\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010\u0019¨\u00065"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "K", "V", "Lkotlin/collections/AbstractMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "firstKey", "", "lastKey", "hashMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "getFirstKey$runtime", "()Ljava/lang/Object;", "getLastKey$runtime", "getHashMap$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "size", "", "getSize", "()I", "keys", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "getKeys", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "entries", "", "getEntries", "createEntries", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "putAll", "m", "", "clear", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMap extends AbstractMap implements PersistentMap {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0005\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\tH\u0000¢\u0006\u0002\b\nR\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "", "emptyOf", "K", "V", "emptyOf$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final PersistentOrderedMap emptyOf$runtime() {
            PersistentOrderedMap v1 = PersistentOrderedMap.EMPTY;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf>");
            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final PersistentOrderedMap EMPTY;
    private final Object firstKey;
    private final PersistentHashMap hashMap;
    private final Object lastKey;

    static {
        PersistentOrderedMap.Companion = new Companion(null);
        PersistentOrderedMap.$stable = 8;
        PersistentOrderedMap.EMPTY = new PersistentOrderedMap(EndOfChain.INSTANCE, EndOfChain.INSTANCE, PersistentHashMap.Companion.emptyOf$runtime());
    }

    public PersistentOrderedMap(Object arg1, Object arg2, PersistentHashMap arg3) {
        super();
        this.firstKey = arg1;
        this.lastKey = arg2;
        this.hashMap = arg3;
    }

    public static final PersistentOrderedMap access$getEMPTY$cp() {
        return PersistentOrderedMap.EMPTY;
    }

    public Builder builder() {
        return new PersistentOrderedMapBuilder(this);
    }

    public PersistentMap clear() {
        return PersistentOrderedMap.Companion.emptyOf$runtime();
    }

    public boolean containsKey(Object arg1) {
        return this.hashMap.containsKey(arg1);
    }

    private final ImmutableSet createEntries() {
        return new PersistentOrderedMapEntries(this);
    }

    public final ImmutableSet entrySet() {
        return this.getEntries();
    }

    public Object get(Object arg1) {
        Object v0 = this.hashMap.get(arg1);
        if(v0 != null) {
            return ((LinkedValue)v0).getValue();
        }

        return null;
    }

    public ImmutableSet getEntries() {
        return this.createEntries();
    }

    public final Set getEntries() {
        return this.createEntries();
    }

    public final Object getFirstKey$runtime() {
        return this.firstKey;
    }

    public final PersistentHashMap getHashMap$runtime() {
        return this.hashMap;
    }

    public ImmutableSet getKeys() {
        return new PersistentOrderedMapKeys(this);
    }

    public Set getKeys() {
        return this.getKeys();
    }

    public final Object getLastKey$runtime() {
        return this.lastKey;
    }

    public int getSize() {
        return this.hashMap.size();
    }

    public ImmutableCollection getValues() {
        return new PersistentOrderedMapValues(this);
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

    public PersistentOrderedMap put(Object arg4, Object arg5) {
        boolean v0 = this.isEmpty();
        PersistentHashMap v1 = this.hashMap;
        if(v0) {
            return new PersistentOrderedMap(arg4, arg4, v1.put(arg4, new LinkedValue(arg5)));
        }

        Object v0_1 = v1.get(arg4);
        if(v0_1 != null) {
            if(((LinkedValue)v0_1).getValue() == arg5) {
                return this;
            }

            return new PersistentOrderedMap(this.firstKey, this.lastKey, this.hashMap.put(arg4, ((LinkedValue)v0_1).withValue(arg5)));
        }

        v0_1 = this.lastKey;
        Object v1_1 = this.hashMap.get(v0_1);
        Intrinsics.checkNotNull(v1_1);
        return new PersistentOrderedMap(this.firstKey, arg4, this.hashMap.put(v0_1, ((LinkedValue)v1_1).withNext(arg4)).put(arg4, new LinkedValue(arg5, v0_1)));
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

    public PersistentOrderedMap remove(Object arg5) {
        Object v1;
        Object v0 = this.hashMap.get(arg5);
        if(v0 == null) {
            return this;
        }

        PersistentHashMap v5 = this.hashMap.remove(arg5);
        if(((LinkedValue)v0).getHasPrevious()) {
            v1 = v5.get(((LinkedValue)v0).getPrevious());
            Intrinsics.checkNotNull(v1);
            v5 = v5.put(((LinkedValue)v0).getPrevious(), ((LinkedValue)v1).withNext(((LinkedValue)v0).getNext()));
        }

        if(((LinkedValue)v0).getHasNext()) {
            v1 = v5.get(((LinkedValue)v0).getNext());
            Intrinsics.checkNotNull(v1);
            v5 = v5.put(((LinkedValue)v0).getNext(), ((LinkedValue)v1).withPrevious(((LinkedValue)v0).getPrevious()));
        }

        v1 = !((LinkedValue)v0).getHasPrevious() ? ((LinkedValue)v0).getNext() : this.firstKey;
        Object v4 = !((LinkedValue)v0).getHasNext() ? ((LinkedValue)v0).getPrevious() : this.lastKey;
        return new PersistentOrderedMap(v1, v4, v5);
    }

    public PersistentMap remove(Object arg1, Object arg2) {
        return this.remove(arg1, arg2);
    }

    public PersistentOrderedMap remove(Object arg2, Object arg3) {
        Object v0 = this.hashMap.get(arg2);
        if(v0 == null) {
        }
        else if(Intrinsics.areEqual(((LinkedValue)v0).getValue(), arg3)) {
            this = this.remove(arg2);
        }

        return this;
    }

    public final ImmutableCollection values() {
        return this.getValues();
    }
}

