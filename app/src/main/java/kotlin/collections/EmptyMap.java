package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\u001E\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00060\u0004j\u0002`\u0005B\t\bB¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0002H\u0096\u0082\u0004J\n\u0010\r\u001A\u00020\u000EH\u0096\u0080\u0004J\n\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0014\u001A\u00020\u000BH\u0096\u0080\u0004J\u0014\u0010\u0015\u001A\u00020\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u0096\u0080\u0004J\u0012\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u0003H\u0096\u0080\u0004J\u0016\u0010\u0019\u001A\u0004\u0018\u00010\u00032\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u0096\u0082\u0004J\n\u0010%\u001A\u00020\u0002H\u0082\u0080\u0004R\u000F\u0010\b\u001A\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0011\u001A\u00020\u000E8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R)\u0010\u001A\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u001C0\u001B8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u001D\u0010\u001F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001B8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b \u0010\u001ER\u001B\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00030\"8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b#\u0010$¨\u0006&"}, d2={"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "equals", "", "other", "hashCode", "", "toString", "", "size", "getSize", "()I", "isEmpty", "containsKey", "key", "containsValue", "value", "get", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "readResolve", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class EmptyMap implements Serializable, Map, KMappedMarker {
    public static final EmptyMap INSTANCE = null;
    private static final long serialVersionUID = 0x72723771CB044CD2L;

    static {
        EmptyMap.INSTANCE = new EmptyMap();
    }

    private EmptyMap() {
        super();
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object arg1) {
        return 0;
    }

    public final boolean containsValue(Object arg2) {
        if(!(arg2 instanceof Void)) {
            return 0;
        }

        return this.containsValue(((Void)arg2));
    }

    public boolean containsValue(Void arg1) {
        Intrinsics.checkNotNullParameter(arg1, "value");
        return 0;
    }

    public final Set entrySet() {
        return this.getEntries();
    }

    public boolean equals(Object arg1) {
        if(((arg1 instanceof Map)) && (((Map)arg1).isEmpty())) {
            return 1;
        }

        return 0;
    }

    public Object get(Object arg1) {
        return this.get(arg1);
    }

    public Void get(Object arg1) {
        return null;
    }

    public Set getEntries() {
        return EmptySet.INSTANCE;
    }

    public Set getKeys() {
        return EmptySet.INSTANCE;
    }

    public int getSize() {
        return 0;
    }

    public Collection getValues() {
        return EmptyList.INSTANCE;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return 1;
    }

    public final Set keySet() {
        return this.getKeys();
    }

    public Object put(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void put(Object arg1, Void arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private final Object readResolve() {
        return EmptyMap.INSTANCE;
    }

    public Object remove(Object arg1) {
        return this.remove(arg1);
    }

    public Void remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public String toString() {
        return "{}";
    }

    public final Collection values() {
        return this.getValues();
    }
}

