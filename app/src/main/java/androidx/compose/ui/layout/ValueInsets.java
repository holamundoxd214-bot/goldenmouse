package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0012\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\tHÖ\u0001¢\u0006\u0004\b\u001C\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0012\u0010\u000E\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000BR\u0012\u0010\u0010\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000B\u0088\u0001\u0002¨\u0006\u001D"}, d2={"Landroidx/compose/ui/layout/ValueInsets;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "left", "", "getLeft-impl", "(J)I", "top", "getTop-impl", "right", "getRight-impl", "bottom", "getBottom-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ValueInsets {
    private final long packedValue;

    private ValueInsets(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final ValueInsets box-impl(long arg1) {
        return new ValueInsets(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return ValueInsets.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof ValueInsets)) {
            return 0;
        }

        if(arg4 != ((ValueInsets)arg6).unbox-impl()) {
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

    public static final int getBottom-impl(long arg2) {
        return ((int)(arg2 & 0xFFFF));
    }

    public static final int getLeft-impl(long arg2) {
        return ((int)(arg2 >>> 0x30 & 0xFFFF));
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public static final int getRight-impl(long arg2) {
        return ((int)(arg2 >>> 16 & 0xFFFF));
    }

    public static final int getTop-impl(long arg2) {
        return ((int)(arg2 >>> 0x20 & 0xFFFF));
    }

    public int hashCode() {
        return ValueInsets.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return ValueInsets.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg7) {
        return "ValueInsets(" + (((int)(arg7 >>> 0x30 & 0xFFFF))) + ", " + (((int)(arg7 >>> 0x20 & 0xFFFF))) + ", " + (((int)(arg7 >>> 16 & 0xFFFF))) + ", " + (((int)(arg7 & 0xFFFF))) + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

