package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap$Entry;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B+\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00028\u0000\u0012\u0006\u0010\b\u001A\u00028\u0001¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00028\u00012\u0006\u0010\u0010\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\b\u001A\u00028\u0001X\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u000F\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MutableMapEntry;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "", "parentIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;", "key", "value", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class MutableMapEntry extends MapEntry implements Map$Entry, Entry {
    private final PersistentHashMapBuilderEntriesIterator parentIterator;
    private Object value;

    public MutableMapEntry(PersistentHashMapBuilderEntriesIterator arg1, Object arg2, Object arg3) {
        super(arg2, arg3);
        this.parentIterator = arg1;
        this.value = arg3;
    }

    public Object getValue() {
        return this.value;
    }

    public Object setValue(Object arg3) {
        Object v0 = this.getValue();
        this.setValue(arg3);
        this.parentIterator.setValue(this.getKey(), arg3);
        return v0;
    }

    public void setValue(Object arg1) {
        this.value = arg1;
    }
}

