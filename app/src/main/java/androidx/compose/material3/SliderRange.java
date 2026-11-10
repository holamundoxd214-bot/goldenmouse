package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0011\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006\u001B"}, d2={"Landroidx/compose/material3/SliderRange;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "start", "", "getStart$annotations", "()V", "getStart-impl", "(J)F", "endInclusive", "getEndInclusive$annotations", "getEndInclusive-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class SliderRange {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/material3/SliderRange$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/material3/SliderRange;", "getUnspecified-FYbKRX4$annotations", "getUnspecified-FYbKRX4", "()J", "J", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getUnspecified-FYbKRX4() {
            return SliderRange.Unspecified;
        }

        public static void getUnspecified-FYbKRX4$annotations() {
        }
    }

    public static final Companion Companion;
    private static final long Unspecified;
    private final long packedValue;

    static {
        SliderRange.Companion = new Companion(null);
        SliderRange.Unspecified = SliderKt.SliderRange(NaNf, NaNf);
    }

    private SliderRange(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getUnspecified$cp() {
        return SliderRange.Unspecified;
    }

    public static final SliderRange box-impl(long arg1) {
        return new SliderRange(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return SliderRange.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof SliderRange)) {
            return 0;
        }

        if(arg4 != ((SliderRange)arg6).unbox-impl()) {
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

    public static void getEndInclusive$annotations() {
    }

    public static final float getEndInclusive-impl(long arg2) {
        if(arg2 != SliderRange.Unspecified) {
            return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
        }

        throw new IllegalStateException("SliderRange is unspecified".toString());
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public static void getStart$annotations() {
    }

    public static final float getStart-impl(long arg2) {
        if(arg2 != SliderRange.Unspecified) {
            return Float.intBitsToFloat(((int)(arg2 >> 0x20)));
        }

        throw new IllegalStateException("SliderRange is unspecified".toString());
    }

    public int hashCode() {
        return SliderRange.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return SliderRange.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        if(SliderKt.isSpecified-If1S1O4(arg2)) {
            return SliderRange.getStart-impl(arg2) + ".." + SliderRange.getEndInclusive-impl(arg2);
        }

        return "FloatRange.Unspecified";
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

