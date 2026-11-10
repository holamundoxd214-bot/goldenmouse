package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0087@\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\r\u001A\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u001A\u0010\fJ\u0010\u0010\u001B\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u001C\u0010\fJ\u0018\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u001EH\u0087\u0002¢\u0006\u0004\b\u001F\u0010 J\u0018\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020!H\u0087\u0002¢\u0006\u0004\b\u001F\u0010\"J\u0018\u0010#\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u001EH\u0087\u0002¢\u0006\u0004\b$\u0010 J\u0018\u0010#\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020!H\u0087\u0002¢\u0006\u0004\b$\u0010\"J\u000F\u0010%\u001A\u00020&H\u0017¢\u0006\u0004\b\'\u0010(J\u0013\u0010)\u001A\u00020*2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001A\u00020\u001EHÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000E\u0010\u0007\u001A\u0004\b\u000F\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006-"}, d2={"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "width", "Landroidx/compose/ui/unit/Dp;", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "(J)F", "height", "getHeight-D9Ej5fM$annotations", "getHeight-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "minus", "other", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "times", "", "times-Gh9hcWk", "(JI)J", "", "(JF)J", "div", "div-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "hashCode", "Companion", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class DpSize {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/unit/DpSize$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/DpSize;", "getZero-MYxV2XQ", "()J", "J", "Unspecified", "getUnspecified-MYxV2XQ", "ui-unit"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getUnspecified-MYxV2XQ() {
            return DpSize.Unspecified;
        }

        public final long getZero-MYxV2XQ() {
            return DpSize.Zero;
        }
    }

    public static final Companion Companion;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    static {
        DpSize.Companion = new Companion(null);
        DpSize.Zero = DpSize.constructor-impl(0);
        DpSize.Unspecified = DpSize.constructor-impl(0x7FC000007FC00000L);
    }

    private DpSize(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getUnspecified$cp() {
        return DpSize.Unspecified;
    }

    public static final long access$getZero$cp() {
        return DpSize.Zero;
    }

    public static final DpSize box-impl(long arg1) {
        return new DpSize(arg1);
    }

    public static final float component1-D9Ej5fM(long arg0) {
        return DpSize.getWidth-D9Ej5fM(arg0);
    }

    public static final float component2-D9Ej5fM(long arg0) {
        return DpSize.getHeight-D9Ej5fM(arg0);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long copy-DwJknco(long arg2, float arg4, float arg5) {
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(arg4))) << 0x20 | (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL);
    }

    public static long copy-DwJknco$default(long arg0, float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg2 = DpSize.getWidth-D9Ej5fM(arg0);
        }

        if((arg4 & 2) != 0) {
            arg3 = DpSize.getHeight-D9Ej5fM(arg0);
        }

        return DpSize.copy-DwJknco(arg0, arg2, arg3);
    }

    public static final long div-Gh9hcWk(long arg4, float arg6) {
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(arg4) / arg6)))) << 0x20 | (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(arg4) / arg6)))) & 0xFFFFFFFFL);
    }

    public static final long div-Gh9hcWk(long arg4, int arg6) {
        float v6 = ((float)arg6);
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(arg4) / v6)))) << 0x20 | (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(arg4) / v6)))) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return DpSize.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof DpSize)) {
            return 0;
        }

        if(arg4 != ((DpSize)arg6).unbox-impl()) {
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

    public static final float getHeight-D9Ej5fM(long arg2) {
        return Dp.constructor-impl(Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL))));
    }

    public static void getHeight-D9Ej5fM$annotations() {
    }

    public static void getPackedValue$annotations() {
    }

    public static final float getWidth-D9Ej5fM(long arg1) {
        return Dp.constructor-impl(Float.intBitsToFloat(((int)(arg1 >> 0x20))));
    }

    public static void getWidth-D9Ej5fM$annotations() {
    }

    public int hashCode() {
        return DpSize.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final long minus-e_xh8Ic(long arg2, long arg4) {
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(arg2) - DpSize.getWidth-D9Ej5fM(arg4))))) << 0x20 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(arg2) - DpSize.getHeight-D9Ej5fM(arg4))))));
    }

    public static final long plus-e_xh8Ic(long arg2, long arg4) {
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(arg2) + DpSize.getWidth-D9Ej5fM(arg4))))) << 0x20 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(arg2) + DpSize.getHeight-D9Ej5fM(arg4))))));
    }

    public static final long times-Gh9hcWk(long arg4, float arg6) {
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(arg4) * arg6)))) << 0x20 | (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(arg4) * arg6)))) & 0xFFFFFFFFL);
    }

    public static final long times-Gh9hcWk(long arg4, int arg6) {
        float v6 = ((float)arg6);
        return DpSize.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(arg4) * v6)))) << 0x20 | (((long)Float.floatToRawIntBits(Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(arg4) * v6)))) & 0xFFFFFFFFL);
    }

    public String toString() {
        return DpSize.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        if(arg2 != 0x7FC000007FC00000L) {
            return Dp.toString-impl(DpSize.getWidth-D9Ej5fM(arg2)) + " x " + Dp.toString-impl(DpSize.getHeight-D9Ej5fM(arg2));
        }

        return "DpSize.Unspecified";
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

