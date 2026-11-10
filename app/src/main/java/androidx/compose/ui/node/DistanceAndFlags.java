package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001A\u00020\r2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000F\u0088\u0001\u0002¨\u0006\u001B"}, d2={"Landroidx/compose/ui/node/DistanceAndFlags;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "distance", "", "getDistance-impl", "(J)F", "isInLayer", "", "isInLayer-impl", "(J)Z", "isInExpandedBounds", "isInExpandedBounds-impl", "compareTo", "", "other", "compareTo-9YPOF3E", "(JJ)I", "equals", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class DistanceAndFlags {
    private final long packedValue;

    private DistanceAndFlags(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final DistanceAndFlags box-impl(long arg1) {
        return new DistanceAndFlags(arg1);
    }

    public static final int compareTo-9YPOF3E(long arg5, long arg7) {
        boolean v0 = DistanceAndFlags.isInLayer-impl(arg5);
        int v2 = -1;
        if(v0 != DistanceAndFlags.isInLayer-impl(arg7)) {
            if(v0) {
                return v2;
            }

            return 1;
        }

        int v0_1 = ((int)Math.signum(DistanceAndFlags.getDistance-impl(arg5) - DistanceAndFlags.getDistance-impl(arg7)));
        if(Math.min(DistanceAndFlags.getDistance-impl(arg5), DistanceAndFlags.getDistance-impl(arg7)) < 0f) {
        }
        else if(DistanceAndFlags.isInExpandedBounds-impl(arg5) != DistanceAndFlags.isInExpandedBounds-impl(arg7)) {
            if(DistanceAndFlags.isInExpandedBounds-impl(arg5)) {
                return v2;
            }
            else {
                return 1;
            }
        }

        return v0_1;
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return DistanceAndFlags.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof DistanceAndFlags)) {
            return 0;
        }

        if(arg4 != ((DistanceAndFlags)arg6).unbox-impl()) {
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

    public static final float getDistance-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return DistanceAndFlags.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final boolean isInExpandedBounds-impl(long arg2) {
        if((arg2 & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isInLayer-impl(long arg2) {
        if((arg2 & 1) != 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return DistanceAndFlags.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "DistanceAndFlags(packedValue=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

