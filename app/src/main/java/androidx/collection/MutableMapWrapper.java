package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\'\n\u0002\b\u0005\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u001F\u0010\u001B\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u001D\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001EJ\u001E\u0010\u001F\u001A\u00020\u001A2\u0014\u0010 \u001A\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0017\u0010\"\u001A\u0004\u0018\u00018\u00012\u0006\u0010\u001C\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010#R\u001C\u0010\b\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\n\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\f\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R&\u0010\u000E\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0012R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2={"Landroidx/collection/MutableMapWrapper;", "K", "V", "Landroidx/collection/MapWrapper;", "", "parent", "Landroidx/collection/MutableScatterMap;", "(Landroidx/collection/MutableScatterMap;)V", "_entries", "Landroidx/collection/MutableEntries;", "_keys", "Landroidx/collection/MutableKeys;", "_values", "Landroidx/collection/MutableValues;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class MutableMapWrapper extends MapWrapper implements Map, KMutableMap {
    private MutableEntries _entries;
    private MutableKeys _keys;
    private MutableValues _values;
    private final MutableScatterMap parent;

    public MutableMapWrapper(MutableScatterMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super(arg2);
        this.parent = arg2;
    }

    public void clear() {
        this.parent.clear();
    }

    public Set getEntries() {
        MutableEntries v0 = this._entries;
        if(v0 != null) {
            return ((Set)v0);
        }

        v0 = new MutableEntries(this.parent);
        this._entries = v0;
        return ((Set)v0);
    }

    public Set getKeys() {
        MutableKeys v0 = this._keys;
        if(v0 != null) {
            return ((Set)v0);
        }

        v0 = new MutableKeys(this.parent);
        this._keys = v0;
        return ((Set)v0);
    }

    public Collection getValues() {
        MutableValues v0 = this._values;
        if(v0 != null) {
            return ((Collection)v0);
        }

        v0 = new MutableValues(this.parent);
        this._values = v0;
        return ((Collection)v0);
    }

    public Object put(Object arg1, Object arg2) {
        return this.parent.put(arg1, arg2);
    }

    public void putAll(Map arg4) {
        Intrinsics.checkNotNullParameter(arg4, "from");
        Iterator v4 = arg4.entrySet().iterator();
        while(v4.hasNext()) {
            Object v0 = v4.next();
            this.parent.set(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }
    }

    public Object remove(Object arg1) {
        return this.parent.remove(arg1);
    }
}

