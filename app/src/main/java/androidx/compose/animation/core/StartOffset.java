package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0007HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\r\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2={"Landroidx/compose/animation/core/StartOffset;", "", "value", "", "constructor-impl", "(J)J", "offsetMillis", "", "offsetType", "Landroidx/compose/animation/core/StartOffsetType;", "(II)J", "getOffsetMillis-impl", "(J)I", "getOffsetType-Eo1U57Q", "equals", "", "other", "hashCode", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class StartOffset {
    private final long value;

    private StartOffset(long arg1) {
        super();
        this.value = arg1;
    }

    public static final StartOffset box-impl(long arg1) {
        return new StartOffset(arg1);
    }

    public static long constructor-impl(int arg0, int arg1) {
        return StartOffset.constructor-impl(((long)(arg0 * arg1)));
    }

    private static long constructor-impl(long arg0) {
        return arg0;
    }

    public static long constructor-impl$default(int arg0, int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 2) != 0) {
            arg1 = StartOffsetType.Companion.getDelay-Eo1U57Q();
        }

        return StartOffset.constructor-impl(arg0, arg1);
    }

    public boolean equals(Object arg3) {
        return StartOffset.equals-impl(this.value, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof StartOffset)) {
            return 0;
        }

        if(arg4 != ((StartOffset)arg6).unbox-impl()) {
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

    public static final int getOffsetMillis-impl(long arg0) {
        return Math.abs(((int)arg0));
    }

    public static final int getOffsetType-Eo1U57Q(long arg2) {
        int v2 = Long.compare(arg2, 0) > 0 ? 1 : 0;
        if(v2 == 1) {
            return StartOffsetType.Companion.getFastForward-Eo1U57Q();
        }

        if(v2 == 0) {
            return StartOffsetType.Companion.getDelay-Eo1U57Q();
        }

        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        return StartOffset.hashCode-impl(this.value);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return StartOffset.toString-impl(this.value);
    }

    public static String toString-impl(long arg2) {
        return "StartOffset(value=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.value;
    }
}

