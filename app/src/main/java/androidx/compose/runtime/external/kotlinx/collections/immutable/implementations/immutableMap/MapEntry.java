package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001A\u00020\rH\u0016J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0013H\u0016R\u0016\u0010\u0004\u001A\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001A\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\t¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "hashCode", "", "equals", "", "other", "", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class MapEntry implements Map$Entry, KMappedMarker {
    public static final int $stable;
    private final Object key;
    private final Object value;

    static {
    }

    public MapEntry(Object arg1, Object arg2) {
        super();
        this.key = arg1;
        this.value = arg2;
    }

    public boolean equals(Object arg4) {
        if((arg4 instanceof Map$Entry)) {
        }
        else {
            Map$Entry v4 = null;
        }

        if(0 != 0 && (Intrinsics.areEqual(v4.getKey(), this.getKey())) && (Intrinsics.areEqual(v4.getValue(), this.getValue()))) {
            return 1;
        }

        return 0;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object v0 = this.getKey();
        int v1 = 0;
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        Object v2 = this.getValue();
        if(v2 != null) {
            v1 = v2.hashCode();
        }

        return v0_1 ^ v1;
    }

    public Object setValue(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return this.getKey() + '=' + this.getValue();
    }
}

