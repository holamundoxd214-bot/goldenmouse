package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000F\u0010\u001A\u001A\u00020\u001BH\u0017¢\u0006\u0004\b\u001C\u0010\u001DJ\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001A\u00020!HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006#"}, d2={"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "()V", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "minus", "other", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class DpOffset {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/DpOffset;", "getZero-RKDOV3M", "()J", "J", "Unspecified", "getUnspecified-RKDOV3M", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getUnspecified-RKDOV3M() {
            return DpOffset.Unspecified;
        }

        public final long getZero-RKDOV3M() {
            return DpOffset.Zero;
        }
    }

    public static final Companion Companion;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    static {
        DpOffset.Companion = new Companion(null);
        DpOffset.Zero = DpOffset.constructor-impl(0);
        DpOffset.Unspecified = DpOffset.constructor-impl(0x7FC000007FC00000L);
    }

    private DpOffset(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getUnspecified$cp() {
        return DpOffset.Unspecified;
    }

    public static final long access$getZero$cp() {
        return DpOffset.Zero;
    }

    public static final DpOffset box-impl(long arg1) {
        return new DpOffset(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long copy-tPigGR8(long arg2, float arg4, float arg5) {
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(arg4))) << 0x20 | (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL);
    }

    public static long copy-tPigGR8$default(long arg0, float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg2 = DpOffset.getX-D9Ej5fM(arg0);
        }

        if((arg4 & 2) != 0) {
            arg3 = DpOffset.getY-D9Ej5fM(arg0);
        }

        return DpOffset.copy-tPigGR8(arg0, arg2, arg3);
    }

    public boolean equals(Object arg3) {
        return DpOffset.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof DpOffset)) {
            return 0;
        }

        if(arg4 != ((DpOffset)arg6).unbox-impl()) {
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

    public static final float getX-D9Ej5fM(long arg1) {
        return Dp.constructor-impl(Float.intBitsToFloat(((int)(arg1 >> 0x20))));
    }

    public static void getX-D9Ej5fM$annotations() {
    }

    public static final float getY-D9Ej5fM(long arg2) {
        return Dp.constructor-impl(Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL))));
    }

    public static void getY-D9Ej5fM$annotations() {
    }

    public int hashCode() {
        return DpOffset.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final long minus-CB-Mgk4(long arg2, long arg4) {
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpOffset.getX-D9Ej5fM(arg2) - DpOffset.getX-D9Ej5fM(arg4))))) << 0x20 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpOffset.getY-D9Ej5fM(arg2) - DpOffset.getY-D9Ej5fM(arg4))))));
    }

    public static final long plus-CB-Mgk4(long arg2, long arg4) {
        return DpOffset.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpOffset.getX-D9Ej5fM(arg2) + DpOffset.getX-D9Ej5fM(arg4))))) << 0x20 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpOffset.getY-D9Ej5fM(arg2) + DpOffset.getY-D9Ej5fM(arg4))))));
    }

    public String toString() {
        return DpOffset.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        if(arg2 != 0x7FC000007FC00000L) {
            return "(" + Dp.toString-impl(DpOffset.getX-D9Ej5fM(arg2)) + ", " + Dp.toString-impl(DpOffset.getY-D9Ej5fM(arg2)) + ')';
        }

        return "DpOffset.Unspecified";
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

