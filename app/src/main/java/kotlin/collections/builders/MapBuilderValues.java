package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableCollection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001B\b@\u0012\u0010\u0010\u0004\u001A\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004J\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0014\u001A\u00020\u000F2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0080\bJ\n\u0010\u0017\u001A\u00020\u0018H\u0096\u0080\u0004J\u0010\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH\u0096\u0082\u0004J\u0017\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00028\u0000H\u0096\u0080\b¢\u0006\u0002\u0010\u0012J\u0018\u0010\u001C\u001A\u00020\u000F2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0080\bJ\u0018\u0010\u001D\u001A\u00020\u000F2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0080\bR\u001F\u0010\u0004\u001A\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\n\u001A\u00020\u000B8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u001E"}, d2={"Lkotlin/collections/builders/MapBuilderValues;", "V", "", "Lkotlin/collections/AbstractMutableCollection;", "backing", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", "", "getSize", "()I", "isEmpty", "", "contains", "element", "(Ljava/lang/Object;)Z", "add", "addAll", "elements", "", "clear", "", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class MapBuilderValues extends AbstractMutableCollection implements Collection, KMutableCollection {
    private final MapBuilder backing;

    public MapBuilderValues(MapBuilder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backing");
        super();
        this.backing = arg2;
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.backing.clear();
    }

    public boolean contains(Object arg1) {
        return this.backing.containsValue(arg1);
    }

    public final MapBuilder getBacking() {
        return this.backing;
    }

    public int getSize() {
        return this.backing.size();
    }

    public boolean isEmpty() {
        return this.backing.isEmpty();
    }

    public Iterator iterator() {
        return this.backing.valuesIterator$kotlin_stdlib();
    }

    public boolean remove(Object arg1) {
        return this.backing.removeValue$kotlin_stdlib(arg1);
    }

    public boolean removeAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.removeAll(arg2);
    }

    public boolean retainAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        this.backing.checkIsMutable$kotlin_stdlib();
        return super.retainAll(arg2);
    }
}

