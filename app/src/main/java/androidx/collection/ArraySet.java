package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001F\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010)\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001?B\u0019\b\u0016\u0012\u0010\u0010\u0004\u001A\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u0019\b\u0016\u0012\u0010\u0010\b\u001A\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0011\b\u0007\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rJ\u0015\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u0010#\u001A\u00020$2\u000E\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000J\u0016\u0010#\u001A\u00020 2\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\b\u0010&\u001A\u00020$H\u0016J\u0016\u0010\'\u001A\u00020 2\u0006\u0010!\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\"J\u0016\u0010(\u001A\u00020 2\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u000E\u0010)\u001A\u00020$2\u0006\u0010*\u001A\u00020\fJ\u0013\u0010+\u001A\u00020 2\b\u0010,\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010-\u001A\u00020\fH\u0016J\u0010\u0010.\u001A\u00020\f2\b\u0010/\u001A\u0004\u0018\u00010\u0012J\b\u00100\u001A\u00020 H\u0016J\u000F\u00101\u001A\b\u0012\u0004\u0012\u00028\u000002H\u0096\u0002J\u0015\u00103\u001A\u00020 2\u0006\u0010!\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0016\u00104\u001A\u00020 2\u000E\u0010\b\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000J\u0016\u00104\u001A\u00020 2\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0013\u00105\u001A\u00028\u00002\u0006\u00106\u001A\u00020\f¢\u0006\u0002\u00107J\u0016\u00108\u001A\u00020 2\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J\u0013\u00109\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t¢\u0006\u0002\u0010\u0014J%\u00109\u001A\b\u0012\u0004\u0012\u0002H:0\t\"\u0004\b\u0001\u0010:2\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H:0\t¢\u0006\u0002\u0010;J\b\u0010<\u001A\u00020=H\u0016J\u0013\u0010>\u001A\u00028\u00002\u0006\u00106\u001A\u00020\f¢\u0006\u0002\u00107R\u001A\u0010\u000E\u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\rR$\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tX\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0016\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\nR\u001A\u0010\u0017\u001A\u00020\u0018X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0010¨\u0006@"}, d2={"Landroidx/collection/ArraySet;", "E", "", "", "set", "(Landroidx/collection/ArraySet;)V", "", "(Ljava/util/Collection;)V", "array", "", "([Ljava/lang/Object;)V", "capacity", "", "(I)V", "_size", "get_size$collection", "()I", "set_size$collection", "", "getArray$collection", "()[Ljava/lang/Object;", "setArray$collection", "[Ljava/lang/Object;", "hashes", "", "getHashes$collection", "()[I", "setHashes$collection", "([I)V", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "", "elements", "clear", "contains", "containsAll", "ensureCapacity", "minimumCapacity", "equals", "other", "hashCode", "indexOf", "key", "isEmpty", "iterator", "", "remove", "removeAll", "removeAt", "index", "(I)Ljava/lang/Object;", "retainAll", "toArray", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "valueAt", "ElementIterator", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) public final class ArraySet implements Collection, Set, KMutableCollection, KMutableSet {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001A\u00028\u00002\u0006\u0010\u0004\u001A\u00020\u0005H\u0014¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\u0005H\u0014¨\u0006\t"}, d2={"Landroidx/collection/ArraySet$ElementIterator;", "Landroidx/collection/IndexBasedArrayIterator;", "(Landroidx/collection/ArraySet;)V", "elementAt", "index", "", "(I)Ljava/lang/Object;", "removeAt", "", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) final class ElementIterator extends IndexBasedArrayIterator {
        public ElementIterator(ArraySet arg1) {
            ArraySet.this = arg1;
            super(arg1.get_size$collection());
        }

        protected Object elementAt(int arg1) {
            return ArraySet.this.valueAt(arg1);
        }

        protected void removeAt(int arg1) {
            ArraySet.this.removeAt(arg1);
        }
    }

    private int _size;
    private Object[] array;
    private int[] hashes;

    public ArraySet() {
        this(0, 1, null);
    }

    public ArraySet(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(0);
    }

    public ArraySet(int arg2) {
        super();
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if(arg2 > 0) {
            ArraySetKt.allocArrays(this, arg2);
        }
    }

    public ArraySet(ArraySet arg2) {
        this(0);
        if(arg2 != null) {
            this.addAll(arg2);
        }
    }

    public ArraySet(Collection arg2) {
        this(0);
        if(arg2 != null) {
            this.addAll(arg2);
        }
    }

    public ArraySet(Object[] arg2) {
        this(0);
        if(arg2 != null) {
            Iterator v2 = ArrayIteratorKt.iterator(arg2);
            while(v2.hasNext()) {
                this.add(v2.next());
            }
        }
    }

    public boolean add(Object arg18) {
        int v8;
        int v5;
        int v4;
        ArraySet v0 = this;
        Object v1 = arg18;
        int v2 = v0.get_size$collection();
        int v3 = 0;
        if(v1 == null) {
            v4 = ArraySetKt.indexOfNull(v0);
            v5 = 0;
        }
        else {
            v4 = v1.hashCode();
            v5 = v4;
            v4 = ArraySetKt.indexOf(v0, v1, v4);
        }

        if(v4 >= 0) {
            return 0;
        }

        v4 = ~v4;
        if(v2 >= v0.getHashes$collection().length) {
            int v6 = 8;
            if(v2 >= v6) {
                v6 = (v2 >> 1) + v2;
            }
            else {
                v8 = 4;
                if(v2 >= v8) {
                }
                else {
                    v6 = v8;
                }
            }

            int[] v8_1 = v0.getHashes$collection();
            Object[] v15 = v0.getArray$collection();
            ArraySetKt.allocArrays(v0, v6);
            if(v2 == v0.get_size$collection()) {
                if(v0.getHashes$collection().length == 0) {
                    v3 = 1;
                }

                if(v3 != 0) {
                    goto label_57;
                }

                ArraysKt.copyInto$default(v8_1, v0.getHashes$collection(), 0, 0, v8_1.length, 6, null);
                ArraysKt.copyInto$default(v15, v0.getArray$collection(), 0, 0, v15.length, 6, null);
                goto label_57;
            }

            throw new ConcurrentModificationException();
        }

    label_57:
        if(v4 < v2) {
            v8 = v4 + 1;
            ArraysKt.copyInto(v0.getHashes$collection(), v0.getHashes$collection(), v8, v4, v2);
            ArraysKt.copyInto(v0.getArray$collection(), v0.getArray$collection(), v8, v4, v2);
        }

        if(v2 == v0.get_size$collection() && v4 < v0.getHashes$collection().length) {
            v0.getHashes$collection()[v4] = v5;
            v0.getArray$collection()[v4] = v1;
            v0.set_size$collection(v0.get_size$collection() + 1);
            return 1;
        }

        throw new ConcurrentModificationException();
    }

    public final void addAll(ArraySet arg9) {
        Intrinsics.checkNotNullParameter(arg9, "array");
        int v5 = arg9.get_size$collection();
        this.ensureCapacity(this.get_size$collection() + v5);
        if(this.get_size$collection() != 0) {
            int v0;
            for(v0 = 0; v0 < v5; ++v0) {
                this.add(arg9.valueAt(v0));
            }
        }
        else if(v5 > 0) {
            ArraysKt.copyInto$default(arg9.getHashes$collection(), this.getHashes$collection(), 0, 0, v5, 6, null);
            ArraysKt.copyInto$default(arg9.getArray$collection(), this.getArray$collection(), 0, 0, v5, 6, null);
            if(this.get_size$collection() == 0) {
                this.set_size$collection(v5);
                return;
            }
            else {
                throw new ConcurrentModificationException();
            }
        }
    }

    public boolean addAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        this.ensureCapacity(this.get_size$collection() + arg3.size());
        Iterator v3 = arg3.iterator();
        int v0;
        for(v0 = 0; v3.hasNext(); v0 |= this.add(v3.next())) {
        }

        return ((boolean)v0);
    }

    public void clear() {
        if(this.get_size$collection() != 0) {
            this.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            this.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            this.set_size$collection(0);
        }

        if(this.get_size$collection() == 0) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    public boolean contains(Object arg1) {
        if(this.indexOf(arg1) >= 0) {
            return 1;
        }

        return 0;
    }

    public boolean containsAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        Iterator v2 = arg2.iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(this.contains(v2.next()));

        return 0;
    }

    public final void ensureCapacity(int arg11) {
        int v0 = this.get_size$collection();
        if(this.getHashes$collection().length < arg11) {
            int[] v2 = this.getHashes$collection();
            Object[] v1 = this.getArray$collection();
            ArraySetKt.allocArrays(this, arg11);
            if(this.get_size$collection() > 0) {
                ArraysKt.copyInto$default(v2, this.getHashes$collection(), 0, 0, this.get_size$collection(), 6, null);
                ArraysKt.copyInto$default(v1, this.getArray$collection(), 0, 0, this.get_size$collection(), 6, null);
            }
        }

        if(this.get_size$collection() == v0) {
            return;
        }

        throw new ConcurrentModificationException();
    }

    public boolean equals(Object arg7) {
        int v3;
        if(this == (((ArraySet)arg7))) {
            return 1;
        }

        if(!(arg7 instanceof Set)) {
            return 0;
        }

        if(this.size() != arg7.size()) {
            return 0;
        }

        try {
            int v1 = this.get_size$collection();
            v3 = 0;
            while(true) {
            label_13:
                if(v3 >= v1) {
                    return 1;
                }

                if(arg7.contains(this.valueAt(v3))) {
                    goto label_19;
                }

                return 0;
            }
        }
        catch(ClassCastException ) {
            return 0;
        }

        return 0;
    label_19:
        ++v3;
        goto label_13;
        return 1;
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    public int hashCode() {
        int[] v0 = this.getHashes$collection();
        int v4 = this.get_size$collection();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v4) {
            v2 += v0[v1];
            ++v1;
        }

        return v2;
    }

    public final int indexOf(Object arg2) {
        if(arg2 == null) {
            return ArraySetKt.indexOfNull(this);
        }

        return ArraySetKt.indexOf(this, arg2, arg2.hashCode());
    }

    public boolean isEmpty() {
        if(this.get_size$collection() <= 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return new ElementIterator(this);
    }

    public boolean remove(Object arg1) {
        int v1 = this.indexOf(arg1);
        if(v1 >= 0) {
            this.removeAt(v1);
            return 1;
        }

        return 0;
    }

    public final boolean removeAll(ArraySet arg6) {
        Intrinsics.checkNotNullParameter(arg6, "array");
        int v0 = arg6.get_size$collection();
        int v1 = this.get_size$collection();
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            this.remove(arg6.valueAt(v3));
        }

        if(v1 != this.get_size$collection()) {
            return 1;
        }

        return 0;
    }

    public boolean removeAll(Collection arg3) {
        Intrinsics.checkNotNullParameter(arg3, "elements");
        Iterator v3 = arg3.iterator();
        int v0;
        for(v0 = 0; v3.hasNext(); v0 |= this.remove(v3.next())) {
        }

        return ((boolean)v0);
    }

    public final Object removeAt(int arg15) {
        int v10;
        Object[] v7;
        int v0 = this.get_size$collection();
        Object v1 = this.getArray$collection()[arg15];
        if(v0 <= 1) {
            this.clear();
            return v1;
        }

        int v3 = v0 - 1;
        int v5 = 8;
        if(this.getHashes$collection().length <= v5 || this.get_size$collection() >= this.getHashes$collection().length / 3) {
            v10 = arg15;
            if(v10 < v3) {
                int v4 = v10 + 1;
                ArraysKt.copyInto(this.getHashes$collection(), this.getHashes$collection(), v10, v4, v0);
                ArraysKt.copyInto(this.getArray$collection(), this.getArray$collection(), v10, v4, v0);
            }

            this.getArray$collection()[v3] = null;
        }
        else {
            if(this.get_size$collection() > v5) {
                v5 = this.get_size$collection() + (this.get_size$collection() >> 1);
            }

            int[] v6 = this.getHashes$collection();
            Object[] v2 = this.getArray$collection();
            ArraySetKt.allocArrays(this, v5);
            if(arg15 > 0) {
                ArraysKt.copyInto$default(v6, this.getHashes$collection(), 0, 0, arg15, 6, null);
                v7 = v2;
                ArraysKt.copyInto$default(v7, this.getArray$collection(), 0, 0, arg15, 6, null);
                v10 = arg15;
            }
            else {
                v10 = arg15;
                v7 = v2;
            }

            if(v10 >= v3) {
                goto label_64;
            }

            int v2_1 = v10 + 1;
            ArraysKt.copyInto(v6, this.getHashes$collection(), v10, v2_1, v0);
            ArraysKt.copyInto(v7, this.getArray$collection(), v10, v2_1, v0);
        }

    label_64:
        if(v0 == this.get_size$collection()) {
            this.set_size$collection(v3);
            return v1;
        }

        throw new ConcurrentModificationException();
    }

    public boolean retainAll(Collection arg6) {
        Intrinsics.checkNotNullParameter(arg6, "elements");
        int v0 = this.get_size$collection() - 1;
        boolean v2 = false;
        while(-1 < v0) {
            if(!CollectionsKt.contains(arg6, this.getArray$collection()[v0])) {
                this.removeAt(v0);
                v2 = true;
            }

            --v0;
        }

        return v2;
    }

    public final void setArray$collection(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.array = arg2;
    }

    public final void setHashes$collection(int[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<set-?>");
        this.hashes = arg2;
    }

    public final void set_size$collection(int arg1) {
        this._size = arg1;
    }

    public final int size() {
        return this.getSize();
    }

    public final Object[] toArray() {
        return ArraysKt.copyOfRange(this.array, 0, this._size);
    }

    public final Object[] toArray(Object[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "array");
        arg3 = ArraySetJvmUtil.resizeForToArray(arg3, this._size);
        ArraysKt.copyInto(this.array, arg3, 0, 0, this._size);
        Intrinsics.checkNotNull(arg3);
        return arg3;
    }

    public String toString() {
        if(this.isEmpty()) {
            return "{}";
        }

        StringBuilder v1 = new StringBuilder(this.get_size$collection() * 14);
        v1.append('{');
        int v0 = this.get_size$collection();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(v2 > 0) {
                v1.append(", ");
            }

            Object v3 = this.valueAt(v2);
            if((((ArraySet)v3)) != this) {
                v1.append(v3);
            }
            else {
                v1.append("(this Set)");
            }
        }

        v1.append('}');
        String v4 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v4, "toString(...)");
        return v4;
    }

    public final Object valueAt(int arg1) {
        return this.getArray$collection()[arg1];
    }
}

