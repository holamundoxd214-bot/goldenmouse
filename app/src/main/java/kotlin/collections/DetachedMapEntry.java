package kotlin.collections;

import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\bF\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0082\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004J\n\u0010\u0012\u001A\u00020\u0013H\u0096\u0080\u0004R\u0017\u0010\u0004\u001A\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001A\u00028\u0001X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\u000B\u0010\t¨\u0006\u0014"}, d2={"Lkotlin/collections/DetachedMapEntry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class DetachedMapEntry implements Map$Entry, KMappedMarker {
    private final Object key;
    private final Object value;

    public DetachedMapEntry(Object arg1, Object arg2) {
        super();
        this.key = arg1;
        this.value = arg2;
    }

    public boolean equals(Object arg2) {
        return AbstractMap.Companion.entryEquals$kotlin_stdlib(((Map$Entry)this), arg2);
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return AbstractMap.Companion.entryHashCode$kotlin_stdlib(((Map$Entry)this));
    }

    public Object setValue(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return AbstractMap.Companion.entryToString$kotlin_stdlib(((Map$Entry)this));
    }
}

