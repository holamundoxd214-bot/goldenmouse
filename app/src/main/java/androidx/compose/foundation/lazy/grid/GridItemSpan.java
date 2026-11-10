package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0007HÖ\u0001J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0010"}, d2={"Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "", "packedValue", "", "constructor-impl", "(J)J", "currentLineSpan", "", "getCurrentLineSpan-impl", "(J)I", "equals", "", "other", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class GridItemSpan {
    private final long packedValue;

    private GridItemSpan(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final GridItemSpan box-impl(long arg1) {
        return new GridItemSpan(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return GridItemSpan.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof GridItemSpan)) {
            return 0;
        }

        if(arg4 != ((GridItemSpan)arg6).unbox-impl()) {
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

    public static final int getCurrentLineSpan-impl(long arg0) {
        return ((int)arg0);
    }

    public int hashCode() {
        return GridItemSpan.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return GridItemSpan.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "GridItemSpan(packedValue=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

