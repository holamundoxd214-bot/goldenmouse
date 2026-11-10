package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\'\n\u0002\b\u0005\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019H\u0016J\u0015\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u0018\u0010)\u001A\u0004\u0018\u00018\u00012\u0006\u0010\'\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010*J\u001F\u0010+\u001A\u0004\u0018\u00018\u00012\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\t\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010,J\u0017\u0010-\u001A\u0004\u0018\u00018\u00012\u0006\u0010\'\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u001B\u0010-\u001A\u00020&2\u0006\u0010\'\u001A\u00028\u00002\u0006\u0010\t\u001A\u00028\u0001¢\u0006\u0002\u0010.J\b\u0010/\u001A\u000200H\u0016R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\t\u001A\u0004\u0018\u00010\n@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0010\u0010\u000E\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\u000F\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R&\u0010\u001A\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001C0\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u001A\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010\u001ER\u001A\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$¨\u00061"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "value", "", "firstKey", "getFirstKey$runtime", "()Ljava/lang/Object;", "lastKey", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "getHashMapBuilder$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "size", "", "getSize", "()I", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class PersistentOrderedMapBuilder extends AbstractMutableMap implements Builder {
    public static final int $stable = 8;
    private Object firstKey;
    private final PersistentHashMapBuilder hashMapBuilder;
    private Object lastKey;
    private PersistentOrderedMap map;

    static {
    }

    public PersistentOrderedMapBuilder(PersistentOrderedMap arg1) {
        super();
        this.map = arg1;
        this.firstKey = arg1.getFirstKey$runtime();
        this.lastKey = this.map.getLastKey$runtime();
        this.hashMapBuilder = this.map.getHashMap$runtime().builder();
    }

    public PersistentMap build() {
        PersistentOrderedMap v0_2;
        PersistentHashMap v0 = this.hashMapBuilder.build();
        if(v0 == this.map.getHashMap$runtime()) {
            boolean v2 = true;
            boolean v0_1 = this.firstKey == this.map.getFirstKey$runtime() ? true : false;
            CommonFunctionsKt.assert(v0_1);
            if(this.lastKey == this.map.getLastKey$runtime()) {
            }
            else {
                v2 = false;
            }

            CommonFunctionsKt.assert(v2);
            v0_2 = this.map;
        }
        else {
            v0_2 = new PersistentOrderedMap(this.firstKey, this.lastKey, v0);
        }

        this.map = v0_2;
        return ((PersistentMap)v0_2);
    }

    public void clear() {
        this.hashMapBuilder.clear();
        this.firstKey = EndOfChain.INSTANCE;
        this.lastKey = EndOfChain.INSTANCE;
    }

    public boolean containsKey(Object arg1) {
        return this.hashMapBuilder.containsKey(arg1);
    }

    public Object get(Object arg1) {
        Object v0 = this.hashMapBuilder.get(arg1);
        if(v0 != null) {
            return ((LinkedValue)v0).getValue();
        }

        return null;
    }

    public Set getEntries() {
        return new PersistentOrderedMapBuilderEntries(this);
    }

    public final Object getFirstKey$runtime() {
        return this.firstKey;
    }

    public final PersistentHashMapBuilder getHashMapBuilder$runtime() {
        return this.hashMapBuilder;
    }

    public Set getKeys() {
        return new PersistentOrderedMapBuilderKeys(this);
    }

    public int getSize() {
        return this.hashMapBuilder.size();
    }

    public Collection getValues() {
        return new PersistentOrderedMapBuilderValues(this);
    }

    public Object put(Object arg5, Object arg6) {
        Object v0 = this.hashMapBuilder.get(arg5);
        if(v0 != null) {
            if(((LinkedValue)v0).getValue() == arg6) {
                return arg6;
            }

            this.hashMapBuilder.put(arg5, ((LinkedValue)v0).withValue(arg6));
            return ((LinkedValue)v0).getValue();
        }

        Object v1 = null;
        if(this.isEmpty()) {
            this.firstKey = arg5;
            this.lastKey = arg5;
            this.hashMapBuilder.put(arg5, new LinkedValue(arg6));
            return v1;
        }

        v0 = this.lastKey;
        Object v2 = this.hashMapBuilder.get(v0);
        Intrinsics.checkNotNull(v2);
        CommonFunctionsKt.assert(((LinkedValue)v2).getHasNext() ^ 1);
        this.hashMapBuilder.put(v0, ((LinkedValue)v2).withNext(arg5));
        this.hashMapBuilder.put(arg5, new LinkedValue(arg6, v0));
        this.lastKey = arg5;
        return v1;
    }

    public Object remove(Object arg5) {
        Object v0;
        arg5 = this.hashMapBuilder.remove(arg5);
        if(arg5 == null) {
            return null;
        }

        if(((LinkedValue)arg5).getHasPrevious()) {
            v0 = this.hashMapBuilder.get(((LinkedValue)arg5).getPrevious());
            Intrinsics.checkNotNull(v0);
            this.hashMapBuilder.put(((LinkedValue)arg5).getPrevious(), ((LinkedValue)v0).withNext(((LinkedValue)arg5).getNext()));
        }
        else {
            this.firstKey = ((LinkedValue)arg5).getNext();
        }

        if(((LinkedValue)arg5).getHasNext()) {
            v0 = this.hashMapBuilder.get(((LinkedValue)arg5).getNext());
            Intrinsics.checkNotNull(v0);
            this.hashMapBuilder.put(((LinkedValue)arg5).getNext(), ((LinkedValue)v0).withPrevious(((LinkedValue)arg5).getPrevious()));
        }
        else {
            this.lastKey = ((LinkedValue)arg5).getPrevious();
        }

        return ((LinkedValue)arg5).getValue();
    }

    public final boolean remove(Object arg3, Object arg4) {
        Object v0 = this.hashMapBuilder.get(arg3);
        if(v0 == null) {
            return 0;
        }

        if(!Intrinsics.areEqual(((LinkedValue)v0).getValue(), arg4)) {
            return 0;
        }

        this.remove(arg3);
        return 1;
    }
}

