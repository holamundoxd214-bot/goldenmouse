package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u000F\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0013H\u0016J\u0016\u0010\u0014\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u0015\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\b\u0010\u0016\u001A\u00020\fH\u0016J\u000F\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0096\u0002J\u0015\u0010\u0019\u001A\u00020\f2\u0006\u0010\r\u001A\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u001A\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016J\u0016\u0010\u001B\u001A\u00020\f2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0016R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\u001C"}, d2={"Landroidx/collection/MutableValues;", "K", "V", "", "parent", "Landroidx/collection/MutableScatterMap;", "(Landroidx/collection/MutableScatterMap;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class MutableValues implements Collection, KMutableCollection {
    private final MutableScatterMap parent;

    public MutableValues(MutableScatterMap arg2) {
        Intrinsics.checkNotNullParameter(arg2, "parent");
        super();
        this.parent = arg2;
    }

    public static final MutableScatterMap access$getParent$p(MutableValues arg0) {
        return arg0.parent;
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.parent.clear();
    }

    public boolean contains(Object arg1) {
        return this.parent.containsValue(arg1);
    }

    public boolean containsAll(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        if(arg4.isEmpty()) {
            return 1;
        }

        Iterator v4 = ((Iterable)arg4).iterator();
        do {
            if(!v4.hasNext()) {
                return 1;
            }
        }
        while(this.parent.containsValue(v4.next()));

        return 0;
    }

    public int getSize() {
        return this.parent._size;
    }

    public boolean isEmpty() {
        return this.parent.isEmpty();
    }

    public Iterator iterator() {
        return new MutableValues$iterator$1(this);
    }

    public boolean remove(Object arg14) {
        long[] v0 = this.parent.metadata;
        int v1 = v0.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v0[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            int v9 = (v3 << 3) + v8;
                            if(Intrinsics.areEqual(this.parent.values[v9], arg14)) {
                                this.parent.removeValueAt(v9);
                                return 1;
                            }
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        return 0;
                    }
                }

                if(v3 == v1) {
                    return 0;
                }
            }
        }

        return 0;
    }

    public boolean removeAll(Collection arg15) {
        Intrinsics.checkNotNullParameter(arg15, "elements");
        long[] v0 = this.parent.metadata;
        int v1 = v0.length - 2;
        if(v1 >= 0) {
            int v3 = 0;
            boolean v4 = false;
            while(true) {
                long v5 = v0[v3];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v3 << 3) + v9;
                            if(CollectionsKt.contains(arg15, this.parent.values[v10])) {
                                this.parent.removeValueAt(v10);
                                v4 = true;
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 == v8) {
                        goto label_46;
                    }

                    return v4;
                }

            label_46:
                if(v3 == v1) {
                    return v4;
                }

                ++v3;
            }

            return v4;
        }

        return 0;
    }

    public boolean retainAll(Collection arg15) {
        Intrinsics.checkNotNullParameter(arg15, "elements");
        long[] v0 = this.parent.metadata;
        int v1 = v0.length - 2;
        if(v1 >= 0) {
            int v3 = 0;
            boolean v4 = false;
            while(true) {
                long v5 = v0[v3];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            int v10 = (v3 << 3) + v9;
                            if(!CollectionsKt.contains(arg15, this.parent.values[v10])) {
                                this.parent.removeValueAt(v10);
                                v4 = true;
                            }
                        }

                        v5 >>= v8;
                    }

                    if(v7 == v8) {
                        goto label_46;
                    }

                    return v4;
                }

            label_46:
                if(v3 == v1) {
                    return v4;
                }

                ++v3;
            }

            return v4;
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

