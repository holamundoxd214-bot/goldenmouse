package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0016\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u001C\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001DJ\u0016\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00028\u0001H\u0096\u0001¢\u0006\u0002\u0010\u001DJ\u0018\u0010 \u001A\u0004\u0018\u00018\u00012\u0006\u0010\u001C\u001A\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010!J\t\u0010\"\u001A\u00020\u0014H\u0096\u0001R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR&\u0010\u0010\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00110\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000BR\u0012\u0010#\u001A\u00020\u0018X\u0096\u0005¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u0006&"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/adapters/ImmutableMapAdapter;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "", "impl", "<init>", "(Ljava/util/Map;)V", "keys", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "getKeys", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "entries", "", "getEntries", "equals", "", "other", "", "hashCode", "", "toString", "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "size", "getSize", "()I", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ImmutableMapAdapter implements ImmutableMap, Map, KMappedMarker {
    public static final int $stable = 8;
    private final ImmutableSet entries;
    private final Map impl;
    private final ImmutableSet keys;
    private final ImmutableCollection values;

    static {
    }

    public ImmutableMapAdapter(Map arg3) {
        super();
        this.impl = arg3;
        this.keys = new ImmutableSetAdapter(arg3.keySet());
        this.values = new ImmutableCollectionAdapter(arg3.values());
        this.entries = new ImmutableSetAdapter(arg3.entrySet());
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
        return this.impl.containsKey(arg1);
    }

    public boolean containsValue(Object arg1) {
        return this.impl.containsValue(arg1);
    }

    public final ImmutableSet entrySet() {
        return this.getEntries();
    }

    public Set entrySet() {
        return this.entrySet();
    }

    public boolean equals(Object arg1) {
        return this.impl.equals(arg1);
    }

    public Object get(Object arg1) {
        return this.impl.get(arg1);
    }

    public ImmutableSet getEntries() {
        return this.entries;
    }

    public ImmutableSet getKeys() {
        return this.keys;
    }

    public int getSize() {
        return this.impl.size();
    }

    public ImmutableCollection getValues() {
        return this.values;
    }

    public int hashCode() {
        return this.impl.hashCode();
    }

    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    public final ImmutableSet keySet() {
        return this.getKeys();
    }

    public Set keySet() {
        return this.keySet();
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
        return this.impl.toString();
    }

    public final ImmutableCollection values() {
        return this.getValues();
    }

    public Collection values() {
        return this.values();
    }
}

