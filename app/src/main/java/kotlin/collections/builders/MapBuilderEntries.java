package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u001D\b@\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\u001E\u0010\u0011\u001A\u00020\u00102\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001A\u00020\u0015H\u0096\u0080\u0004J\u001E\u0010\u0016\u001A\u00020\u00102\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0080\bJ$\u0010\u0017\u001A\u00020\u00102\u0018\u0010\u0018\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\bJ\u001E\u0010\u001A\u001A\u00020\u00102\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0080\bJ\u001C\u0010\u001B\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u001CH\u0096\u0082\u0004J$\u0010\u001D\u001A\u00020\u00102\u0018\u0010\u0018\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\u0004J$\u0010\u001E\u001A\u00020\u00102\u0018\u0010\u0018\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\bJ$\u0010\u001F\u001A\u00020\u00102\u0018\u0010\u0018\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0019H\u0096\u0080\bR!\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0015\u0010\u000B\u001A\u00020\f8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006 "}, d2={"Lkotlin/collections/builders/MapBuilderEntries;", "K", "V", "Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "", "backing", "Lkotlin/collections/builders/MapBuilder;", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", "", "getSize", "()I", "isEmpty", "", "containsEntry", "element", "", "clear", "", "add", "addAll", "elements", "", "remove", "iterator", "", "containsAll", "removeAll", "retainAll", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class MapBuilderEntries extends AbstractMapBuilderEntrySet {
    private final MapBuilder backing;

    public MapBuilderEntries(MapBuilder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "backing");
        super();
        this.backing = arg2;
    }

    public boolean add(Object arg1) {
        return this.add(((Map$Entry)arg1));
    }

    public boolean add(Map$Entry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "element");
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.backing.clear();
    }

    public boolean containsAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return this.backing.containsAllEntries$kotlin_stdlib(arg2);
    }

    public boolean containsEntry(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        return this.backing.containsEntry$kotlin_stdlib(arg2);
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
        return this.backing.entriesIterator$kotlin_stdlib();
    }

    public boolean remove(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        return this.backing.removeEntry$kotlin_stdlib(arg2);
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

