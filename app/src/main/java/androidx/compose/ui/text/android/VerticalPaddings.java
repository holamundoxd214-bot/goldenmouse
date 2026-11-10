package androidx.compose.ui.text.android;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\tJ\u0010\u0010\u0013\u001A\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0017"}, d2={"Landroidx/compose/ui/text/android/VerticalPaddings;", "", "packedValue", "", "constructor-impl", "(J)J", "topPadding", "", "getTopPadding-impl", "(J)I", "bottomPadding", "getBottomPadding-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class VerticalPaddings {
    private final long packedValue;

    private VerticalPaddings(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final VerticalPaddings box-impl(long arg1) {
        return new VerticalPaddings(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return VerticalPaddings.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof VerticalPaddings)) {
            return 0;
        }

        if(arg4 != ((VerticalPaddings)arg6).unbox-impl()) {
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

    public static final int getBottomPadding-impl(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }

    public static final int getTopPadding-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public int hashCode() {
        return VerticalPaddings.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return VerticalPaddings.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "VerticalPaddings(packedValue=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

