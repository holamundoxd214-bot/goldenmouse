package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\bA\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\bH\u0086\u0082\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0010\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\u0002H\u0086\u0082\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0082\u0004¢\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u001E\u0010\u001FJ\u001F\u0010 \u001A\u00020\u001C2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001A\u00020\u001CH\u0096\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0014\u0010\'\u001A\u00020\u001C2\b\u0010(\u001A\u0004\u0018\u00010)HÖ\u0083\u0004J\n\u0010*\u001A\u00020\bHÖ\u0081\u0004J\n\u0010+\u001A\u00020,HÖ\u0081\u0004R\u0017\u0010\u0003\u001A\u00020\u00048\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000BR\u0015\u0010\u0007\u001A\u00020\b8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2={"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "storage", "", "constructor-impl", "([B)[B", "size", "", "(I)[B", "getStorage$annotations", "()V", "get", "index", "get-w2LRezQ", "([BI)B", "set", "", "value", "set-VurrAj0", "([BIB)V", "getSize-impl", "([B)I", "iterator", "", "iterator-impl", "([B)Ljava/util/Iterator;", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([B)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class UByteArray implements Collection, KMappedMarker {
    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001A\u00020\nH\u0096\u0082\u0004J\u0011\u0010\u000B\u001A\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rR\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlin/UByteArray$Iterator;", "", "Lkotlin/UByte;", "array", "", "<init>", "([B)V", "index", "", "hasNext", "", "next", "next-w2LRezQ", "()B", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Iterator implements java.util.Iterator, KMappedMarker {
        private final byte[] array;
        private int index;

        public Iterator(byte[] arg2) {
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
            return UByte.box-impl(this.next-w2LRezQ());
        }

        public byte next-w2LRezQ() {
            int v0 = this.index;
            byte[] v1 = this.array;
            if(v0 < v1.length) {
                this.index = v0 + 1;
                return UByte.constructor-impl(v1[v0]);
            }

            throw new NoSuchElementException(String.valueOf(this.index));
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private final byte[] storage;

    private UByteArray(byte[] arg1) {
        super();
        this.storage = arg1;
    }

    public boolean add(Object arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add-7apg3OU(byte arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection arg1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public static final UByteArray box-impl(byte[] arg1) {
        return new UByteArray(arg1);
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public static byte[] constructor-impl(int arg0) {
        return UByteArray.constructor-impl(new byte[arg0]);
    }

    public static byte[] constructor-impl(byte[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "storage");
        return arg1;
    }

    public final boolean contains(Object arg2) {
        if(!(arg2 instanceof UByte)) {
            return 0;
        }

        return this.contains-7apg3OU(((UByte)arg2).unbox-impl());
    }

    public static boolean contains-7apg3OU(byte[] arg0, byte arg1) {
        return ArraysKt.contains(arg0, arg1);
    }

    public boolean contains-7apg3OU(byte arg1) {
        return UByteArray.contains-7apg3OU(this.storage, arg1);
    }

    public boolean containsAll(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return UByteArray.containsAll-impl(this.storage, arg2);
    }

    public static boolean containsAll-impl(byte[] arg3, Collection arg4) {
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
            if(((v0 instanceof UByte)) && (ArraysKt.contains(arg3, ((UByte)v0).unbox-impl()))) {
                continue;
            }

            return 0;
        }

        return 0;
    }

    public boolean equals(Object arg1) {
        return UByteArray.equals-impl(this.storage, arg1);
    }

    public static boolean equals-impl(byte[] arg2, Object arg3) {
        if(!(arg3 instanceof UByteArray)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((UByteArray)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(byte[] arg0, byte[] arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final byte get-w2LRezQ(byte[] arg0, int arg1) {
        return UByte.constructor-impl(arg0[arg1]);
    }

    public int getSize() {
        return UByteArray.getSize-impl(this.storage);
    }

    public static int getSize-impl(byte[] arg0) {
        return arg0.length;
    }

    public static void getStorage$annotations() {
    }

    public int hashCode() {
        return UByteArray.hashCode-impl(this.storage);
    }

    public static int hashCode-impl(byte[] arg0) {
        return Arrays.hashCode(arg0);
    }

    public boolean isEmpty() {
        return UByteArray.isEmpty-impl(this.storage);
    }

    public static boolean isEmpty-impl(byte[] arg0) {
        if(arg0.length == 0) {
            return 1;
        }

        return 0;
    }

    public java.util.Iterator iterator() {
        return UByteArray.iterator-impl(this.storage);
    }

    public static java.util.Iterator iterator-impl(byte[] arg1) {
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

    public static final void set-VurrAj0(byte[] arg0, int arg1, byte arg2) {
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
        return UByteArray.toString-impl(this.storage);
    }

    public static String toString-impl(byte[] arg2) {
        return "UByteArray(storage=" + Arrays.toString(arg2) + ')';
    }

    public final byte[] unbox-impl() {
        return this.storage;
    }
}

