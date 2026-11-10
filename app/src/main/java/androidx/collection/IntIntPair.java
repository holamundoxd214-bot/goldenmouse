package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\r\u001A\u00020\u0003H\u0086\n¢\u0006\u0004\b\u000E\u0010\u000BJ\u0010\u0010\u000F\u001A\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0010\u0010\u000BJ\u001A\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000BJ\u000F\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0011\u0010\u0002\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0010\u0010\u0007\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\f\u0010\u000B\u0088\u0001\u0007¨\u0006\u001C"}, d2={"Landroidx/collection/IntIntPair;", "", "first", "", "second", "constructor-impl", "(II)J", "packedValue", "", "(J)J", "getFirst-impl", "(J)I", "getSecond-impl", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "collection"}, k=1, mv={1, 9, 0}, xi=0x30) @JvmInline public final class IntIntPair {
    public final long packedValue;

    private IntIntPair(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final IntIntPair box-impl(long arg1) {
        return new IntIntPair(arg1);
    }

    public static final int component1-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static final int component2-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public static long constructor-impl(int arg4, int arg5) {
        return IntIntPair.constructor-impl((((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return IntIntPair.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof IntIntPair)) {
            return 0;
        }

        if(arg4 != ((IntIntPair)arg6).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(long arg0, long arg2) {
        if(arg0 == arg2) {
            return 1;
        }

        return 0;
    }

    public static final int getFirst-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static final int getSecond-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public int hashCode() {
        return IntIntPair.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return IntIntPair.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "(" + IntIntPair.getFirst-impl(arg2) + ", " + IntIntPair.getSecond-impl(arg2) + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

