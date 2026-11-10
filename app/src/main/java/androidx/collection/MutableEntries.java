package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001C\u0010\f\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u000F\u001A\u00020\r2\u0018\u0010\u0010\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\u001D\u0010\u0014\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\"\u0010\u0015\u001A\u00020\r2\u0018\u0010\u0010\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0011H\u0016J\b\u0010\u0016\u001A\u00020\rH\u0016J\u001B\u0010\u0017\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0018H\u0096\u0002J\u001C\u0010\u0019\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u001A\u001A\u00020\r2\u0018\u0010\u0010\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0011H\u0016J\"\u0010\u001B\u001A\u00020\r2\u0018\u0010\u0010\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0011H\u0016R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u001C"}, d2={"Landroidx/collection/MutableEntries;", "K", "V", "", "", "parent", "Landroidx/collection/MutableScatterMap;", "(Landroidx/collection/MutableScatterMap;)V", "size", "", "getSize", "()I", "add", "", "element", "addAll", "elements", "", "clear", "", "contains", "containsAll", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class MutableEntries implements Set, KMutableSet {
    private final MutableScatterMap parent;

    public MutableEntries(MutableScatterMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super();
        this.parent = arg2;
    }

    public static final MutableScatterMap access$getParent$p(MutableEntries arg0) {
        return arg0.parent;
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
        this.parent.clear();
    }

    public final boolean contains(Object arg2) {
        if(!TypeIntrinsics.isMutableMapEntry(arg2)) {
            return 0;
        }

        return this.contains(((Map$Entry)arg2));
    }

    public boolean contains(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "element");
        return Intrinsics.areEqual(this.parent.get(arg2.getKey()), arg2.getValue());
    }

    public boolean containsAll(Collection arg5) {
        Intrinsics.checkNotNullParameter(arg5, "elements");
        if(arg5.isEmpty()) {
            return 1;
        }

        Iterator v5 = ((Iterable)arg5).iterator();
        do {
            if(!v5.hasNext()) {
                return 1;
            }

            Object v0 = v5.next();
        }
        while(Intrinsics.areEqual(this.parent.get(((Map$Entry)v0).getKey()), ((Map$Entry)v0).getValue()));

        return 0;
    }

    public int getSize() {
        return this.parent._size;
    }

    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    public Iterator iterator() {
        return new MutableEntries$iterator$1(this);
    }

    public final boolean remove(Object arg2) {
        if(!TypeIntrinsics.isMutableMapEntry(arg2)) {
            return 0;
        }

        return this.remove(((Map$Entry)arg2));
    }

    public boolean remove(Map$Entry arg22) {
        int v13;
        MutableEntries v0 = this;
        Map$Entry v2 = arg22;
        Intrinsics.checkNotNullParameter(v2, "element");
        MutableScatterMap v1 = v0.parent;
        Object v3 = v2.getKey();
        int v5 = v3 != null ? v3.hashCode() : 0;
        v5 *= 0xCC9E2D51;
        v5 ^= v5 << 16;
        int v6 = v5 & 0x7F;
        int v7 = ((ScatterMap)v1)._capacity;
        v5 = v5 >>> 7 & v7;
        int v8 = 0;
        while(true) {
            int v10 = v5 >> 3;
            int v11 = (v5 & 7) << 3;
            int v16 = v5;
            long v4 = -(((long)v11)) >> 0x3F & ((ScatterMap)v1).metadata[v10 + 1] << 0x40 - v11 | ((ScatterMap)v1).metadata[v10] >>> v11;
            long v9 = (((long)v6)) * 0x101010101010101L ^ v4;
            long v11_1 = -9187201950435737472L;
            v9 = ~v9 & v9 - 0x101010101010101L & v11_1;
            while(true) {
                long v17 = 0;
                if(v9 != v17) {
                    v13 = v16 + (Long.numberOfTrailingZeros(v9) >> 3) & v7;
                    long v19 = v11_1;
                    if(Intrinsics.areEqual(((ScatterMap)v1).keys[v13], v3)) {
                    }
                    else {
                        v9 &= v9 - 1;
                        v11_1 = v19;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_72;
            }

            if((v4 & ~v4 << 6 & v11_1) != v17) {
                v13 = -1;
            }
            else {
                goto label_83;
            }

        label_72:
            if(v13 >= 0 && (Intrinsics.areEqual(v0.parent.values[v13], v2.getValue()))) {
                v0.parent.removeValueAt(v13);
                return 1;
            }

            return 0;
        label_83:
            v8 += 8;
            v5 = v16 + v8 & v7;
        }
    }

    public boolean removeAll(Collection arg18) {
        MutableEntries v0 = this;
        Collection v2 = arg18;
        Intrinsics.checkNotNullParameter(v2, "elements");
        long[] v1 = v0.parent.metadata;
        int v3 = v1.length - 2;
        if(v3 >= 0) {
            int v5 = 0;
            boolean v6 = false;
            while(true) {
                long v7 = v1[v5];
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v10 = 8;
                    int v9 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v11;
                    for(v11 = 0; v11 < v9; ++v11) {
                        if((0xFF & v7) < 0x80) {
                            int v12 = (v5 << 3) + v11;
                            Iterator v13 = v2.iterator();
                            do {
                                if(v13.hasNext()) {
                                    Object v14 = v13.next();
                                    if(!Intrinsics.areEqual(((Map$Entry)v14).getKey(), v0.parent.keys[v12])) {
                                        continue;
                                    }

                                    if(!Intrinsics.areEqual(((Map$Entry)v14).getValue(), v0.parent.values[v12])) {
                                        continue;
                                    }

                                    break;
                                }

                                goto label_55;
                            }
                            while(true);

                            v0.parent.removeValueAt(v12);
                            v6 = true;
                        }

                    label_55:
                        v7 >>= v10;
                    }

                    if(v9 == v10) {
                        goto label_63;
                    }

                    return v6;
                }

            label_63:
                if(v5 == v3) {
                    return v6;
                }

                ++v5;
            }

            return v6;
        }

        return 0;
    }

    public boolean retainAll(Collection arg18) {
        MutableEntries v0 = this;
        Collection v2 = arg18;
        Intrinsics.checkNotNullParameter(v2, "elements");
        long[] v1 = v0.parent.metadata;
        int v3 = v1.length - 2;
        if(v3 >= 0) {
            int v5 = 0;
            boolean v6 = false;
            while(true) {
                long v7 = v1[v5];
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v10 = 8;
                    int v9 = 8 - (~(v5 - v3) >>> 0x1F);
                    int v11;
                    for(v11 = 0; v11 < v9; ++v11) {
                        if((0xFF & v7) < 0x80) {
                            int v12 = (v5 << 3) + v11;
                            Iterator v13 = v2.iterator();
                            do {
                                if(v13.hasNext()) {
                                    Object v14 = v13.next();
                                    if(!Intrinsics.areEqual(((Map$Entry)v14).getKey(), v0.parent.keys[v12])) {
                                        continue;
                                    }

                                    if(!Intrinsics.areEqual(((Map$Entry)v14).getValue(), v0.parent.values[v12])) {
                                        continue;
                                    }

                                    break;
                                }
                                else {
                                    goto label_50;
                                }
                            }
                            while(true);

                            goto label_57;
                        label_50:
                            v0.parent.removeValueAt(v12);
                            v6 = true;
                        }

                    label_57:
                        v7 >>= v10;
                    }

                    if(v9 == v10) {
                        goto label_65;
                    }

                    return v6;
                }

            label_65:
                if(v5 == v3) {
                    return v6;
                }

                ++v5;
            }

            return v6;
        }

        return 0;
    }

    public final int size() {
        return this.getSize();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        return CollectionToArray.toArray(((Collection)this), arg2);
    }
}

