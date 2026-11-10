package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0012\u0010\f\u001A\u00020\t8Æ\u0002¢\u0006\u0006\u001A\u0004\b\r\u0010\u000B\u0088\u0001\u0002¨\u0006\u0015"}, d2={"Landroidx/compose/animation/core/Motion;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "value", "", "getValue-impl", "(J)F", "velocity", "getVelocity-impl", "equals", "", "other", "hashCode", "", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Motion {
    private final long packedValue;

    private Motion(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final Motion box-impl(long arg1) {
        return new Motion(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return Motion.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof Motion)) {
            return 0;
        }

        if(arg4 != ((Motion)arg6).unbox-impl()) {
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

    public final long getPackedValue() {
        return this.packedValue;
    }

    public static final float getValue-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static final float getVelocity-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public int hashCode() {
        return Motion.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return Motion.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "Motion(packedValue=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

