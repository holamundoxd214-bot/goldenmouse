package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap$Entry;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\'\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B7\u0012\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0010\b\u001A\u00028\u0000\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0015\u0010\u000F\u001A\u00028\u00012\u0006\u0010\u0010\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011R \u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/MutableMapEntry;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "", "mutableMap", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "key", "links", "<init>", "(Ljava/util/Map;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class MutableMapEntry extends MapEntry implements Map$Entry, Entry {
    private LinkedValue links;
    private final Map mutableMap;

    public MutableMapEntry(Map arg2, Object arg3, LinkedValue arg4) {
        super(arg3, arg4.getValue());
        this.mutableMap = arg2;
        this.links = arg4;
    }

    public Object getValue() {
        return this.links.getValue();
    }

    public Object setValue(Object arg3) {
        Object v0 = this.links.getValue();
        this.links = this.links.withValue(arg3);
        this.mutableMap.put(this.getKey(), this.links);
        return v0;
    }
}

