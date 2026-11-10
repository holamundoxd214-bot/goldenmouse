package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0012\u0010\u000F\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000ER\u0012\u0010\u0011\u001A\u00020\u00078Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u000E\u0088\u0001\u0002¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "", "packedValue", "", "constructor-impl", "(J)J", "lane", "", "span", "(II)J", "getPackedValue", "()J", "start", "getStart-impl", "(J)I", "end", "getEnd-impl", "size", "getSize-impl", "equals", "", "other", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class SpanRange {
    private final long packedValue;

    private SpanRange(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final SpanRange box-impl(long arg1) {
        return new SpanRange(arg1);
    }

    public static long constructor-impl(int arg4, int arg5) {
        return SpanRange.constructor-impl((((long)(arg5 + arg4))) & 0xFFFFFFFFL | (((long)arg4)) << 0x20);
    }

    private static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return SpanRange.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof SpanRange)) {
            return 0;
        }

        if(arg4 != ((SpanRange)arg6).unbox-impl()) {
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

    public static final int getEnd-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public static final int getSize-impl(long arg2) {
        return (((int)(0xFFFFFFFFL & arg2))) - (((int)(arg2 >> 0x20)));
    }

    public static final int getStart-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public int hashCode() {
        return SpanRange.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return SpanRange.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "SpanRange(packedValue=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

