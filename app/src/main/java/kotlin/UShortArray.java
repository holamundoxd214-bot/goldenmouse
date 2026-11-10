package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\bA\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\bH\u0086\u0082\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\u0002H\u0086\u0082\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0082\u0004¢\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u001E\u0010\u001FJ\u001F\u0010 \u001A\u00020\u001C2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001A\u00020\u001CH\u0096\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0014\u0010\'\u001A\u00020\u001C2\b\u0010(\u001A\u0004\u0018\u00010)HÖ\u0083\u0004J\n\u0010*\u001A\u00020\bHÖ\u0081\u0004J\n\u0010+\u001A\u00020,HÖ\u0081\u0004R\u0017\u0010\u0003\u001A\u00020\u00048\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000BR\u0015\u0010\u0007\u001A\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2={"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "storage", "", "constructor-impl", "([S)[S", "size", "", "(I)[S", "getStorage$annotations", "()V", "get", "index", "get-Mh2AYeg", "([SI)S", "set", "", "value", "set-01HTLdE", "([SIS)V", "getSize-impl", "([S)I", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([S)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class UShortArray implements Collection, KMappedMarker {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001A\u00020\nH\u0096\u0082\u0004J\u0011\u0010\u000B\u001A\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rR\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlin/UShortArray$Iterator;", "", "Lkotlin/UShort;", "array", "", "<init>", "([S)V", "index", "", "hasNext", "", "next", "next-Mh2AYeg", "()S", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Iterator implements java.util.Iterator, KMappedMarker {
        private final short[] array;
        private int index;

        public Iterator(short[] arg2) {
            Intrinsics.checkNotNullParameter(arg2, "array");
            super();
            this.array = arg2;
        }

        public boolean hasNext() {
            if(this.index < this.array.length) {
                return 1;
            }

            return 0;
        }

        public Object next() {
            return UShort.box-impl(this.next-Mh2AYeg());
        }

        public short next-Mh2AYeg() {
            int v0 = this.index;
            short[] v1 = this.array;
            if(v0 < v1.length) {
                this.index = v0 + 1;
                return UShort.constructor-impl(v1[v0]);
            }

            throw new NoSuchElementException(String.valueOf(this.index));
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private final short[] storage;

    private UShortArray(short[] arg1) {
        super();
        this.storage = arg1;
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add-xj2QHRw(short arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public static final UShortArray box-impl(short[] arg1) {
        return new UShortArray(arg1);
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public static short[] constructor-impl(int arg0) {
        return UShortArray.constructor-impl(new short[arg0]);
    }

    public static short[] constructor-impl(short[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "storage");
        return arg1;
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof UShort)) {
            return 0;
        }

        return this.contains-xj2QHRw(((UShort)arg2).unbox-impl());
    }

    public static boolean contains-xj2QHRw(short[] arg0, short arg1) {
        return ArraysKt.contains(arg0, arg1);
    }

    public boolean contains-xj2QHRw(short arg1) {
        return UShortArray.contains-xj2QHRw(this.storage, arg1);
    }

    public boolean containsAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return UShortArray.containsAll-impl(this.storage, arg2);
    }

    public static boolean containsAll-impl(short[] arg3, Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "elements");
        if(arg4.isEmpty()) {
            return 1;
        }

        java.util.Iterator v4 = ((Iterable)arg4).iterator();
        while(true) {
            if(!v4.hasNext()) {
                return 1;
            }

            Object v0 = v4.next();
            if(((v0 instanceof UShort)) && (ArraysKt.contains(arg3, ((UShort)v0).unbox-impl()))) {
                continue;
            }

            return 0;
        }

        return 0;
    }

    public boolean equals(Object arg1) {
        return UShortArray.equals-impl(this.storage, arg1);
    }

    public static boolean equals-impl(short[] arg2, Object arg3) {
        if(!(arg3 instanceof UShortArray)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((UShortArray)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(short[] arg0, short[] arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final short get-Mh2AYeg(short[] arg0, int arg1) {
        return UShort.constructor-impl(arg0[arg1]);
    }

    public int getSize() {
        return UShortArray.getSize-impl(this.storage);
    }

    public static int getSize-impl(short[] arg0) {
        return arg0.length;
    }

    public static void getStorage$annotations() {
    }

    public int hashCode() {
        return UShortArray.hashCode-impl(this.storage);
    }

    public static int hashCode-impl(short[] arg0) {
        return Arrays.hashCode(arg0);
    }

    public boolean isEmpty() {
        return UShortArray.isEmpty-impl(this.storage);
    }

    public static boolean isEmpty-impl(short[] arg0) {
        if(arg0.length == 0) {
            return 1;
        }

        return 0;
    }

    public java.util.Iterator iterator() {
        return UShortArray.iterator-impl(this.storage);
    }

    public static java.util.Iterator iterator-impl(short[] arg1) {
        return new Iterator(arg1);
    }

    public boolean remove(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public static final void set-01HTLdE(short[] arg0, int arg1, short arg2) {
        arg0[arg1] = arg2;
    }

    public int size() {
        return this.getSize();
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(((Collection)this));
    }

    public Object[] toArray(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "array");
        return CollectionToArray.toArray(((Collection)this), arg2);
    }

    public String toString() {
        return UShortArray.toString-impl(this.storage);
    }

    public static String toString-impl(short[] arg2) {
        return "UShortArray(storage=" + Arrays.toString(arg2) + ')';
    }

    public final short[] unbox-impl() {
        return this.storage;
    }
}

