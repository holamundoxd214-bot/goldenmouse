package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001FJ\u0015\u0010 \u001A\u00020\u001D2\u0006\u0010!\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001FJ\u0013\u0010\"\u001A\u00020\u001D2\b\u0010#\u001A\u0004\u0018\u00010$H\u0096\u0002J\u0018\u0010%\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u001E\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010&J\b\u0010\'\u001A\u00020\u0015H\u0016J\b\u0010(\u001A\u00020\u001DH\u0016J\b\u0010)\u001A\u00020*H\u0016R\u001C\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\t\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\r\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000F0\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001B¨\u0006+"}, d2={"Landroidx/collection/MapWrapper;", "K", "V", "", "parent", "Landroidx/collection/ScatterMap;", "(Landroidx/collection/ScatterMap;)V", "_entries", "Landroidx/collection/Entries;", "_keys", "Landroidx/collection/Keys;", "_values", "Landroidx/collection/Values;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "equals", "other", "", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "isEmpty", "toString", "", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) class MapWrapper implements Map, KMappedMarker {
    private Entries _entries;
    private Keys _keys;
    private Values _values;
    private final ScatterMap parent;

    public MapWrapper(ScatterMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super();
        this.parent = arg2;
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object compute(Object arg1, BiFunction arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object computeIfAbsent(Object arg1, Function arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object computeIfPresent(Object arg1, BiFunction arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean containsKey(Object arg1) {
        return this.parent.containsKey(arg1);
    }

    public boolean containsValue(Object arg1) {
        return this.parent.containsValue(arg1);
    }

    public final Set entrySet() {
        return this.getEntries();
    }

    public boolean equals(Object arg3) {
        if(this == (((MapWrapper)arg3))) {
            return 1;
        }

        if(arg3 != null) {
            if(this.getClass() != arg3.getClass()) {
            }
            else {
                return Intrinsics.areEqual(this.parent, ((MapWrapper)arg3).parent);
            }
        }

        return 0;
    }

    public Object get(Object arg1) {
        return this.parent.get(arg1);
    }

    public Set getEntries() {
        Entries v0 = this._entries;
        if(v0 != null) {
            return ((Set)v0);
        }

        v0 = new Entries(this.parent);
        this._entries = v0;
        return ((Set)v0);
    }

    public Set getKeys() {
        Keys v0 = this._keys;
        if(v0 != null) {
            return ((Set)v0);
        }

        v0 = new Keys(this.parent);
        this._keys = v0;
        return ((Set)v0);
    }

    public int getSize() {
        return this.parent._size;
    }

    public Collection getValues() {
        Values v0 = this._values;
        if(v0 != null) {
            return ((Collection)v0);
        }

        v0 = new Values(this.parent);
        this._values = v0;
        return ((Collection)v0);
    }

    public int hashCode() {
        return this.parent.hashCode();
    }

    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    public final Set keySet() {
        return this.getKeys();
    }

    public Object merge(Object arg1, Object arg2, BiFunction arg3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object put(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object putIfAbsent(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object replace(Object arg1, Object arg2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace(Object arg1, Object arg2, Object arg3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(BiFunction arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.getSize();
    }

    public String toString() {
        return this.parent.toString();
    }

    public final Collection values() {
        return this.getValues();
    }
}

