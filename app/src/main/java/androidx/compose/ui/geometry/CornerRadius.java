package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001C\u001A\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001D\u0010\u001BJ\u0010\u0010\u001E\u001A\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001F\u0010\u0005J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010!\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001A\u00020\u00002\u0006\u0010!\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b%\u0010#J\u0018\u0010&\u001A\u00020\u00002\u0006\u0010\'\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001A\u00020\u00002\u0006\u0010\'\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b+\u0010)J\u000F\u0010,\u001A\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001A\u00020\u00192\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001A\u000202HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001B\u0010\b\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001B\u0010\u000E\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00064"}, d2={"Landroidx/compose/ui/geometry/CornerRadius;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-OHQCggk", "(JFF)J", "isZero", "", "isZero-impl", "(J)Z", "isCircular", "isCircular-impl", "unaryMinus", "unaryMinus-kKHJgLs", "minus", "other", "minus-vF7b-mM", "(JJ)J", "plus", "plus-vF7b-mM", "times", "operand", "times-Bz7bX_o", "(JF)J", "div", "div-Bz7bX_o", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "", "Companion", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class CornerRadius {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/ui/geometry/CornerRadius$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/CornerRadius;", "getZero-kKHJgLs$annotations", "getZero-kKHJgLs", "()J", "J", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getZero-kKHJgLs() {
            return CornerRadius.Zero;
        }

        public static void getZero-kKHJgLs$annotations() {
        }
    }

    public static final Companion Companion;
    private static final long Zero;
    private final long packedValue;

    static {
        CornerRadius.Companion = new Companion(null);
        CornerRadius.Zero = CornerRadius.constructor-impl(0);
    }

    private CornerRadius(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getZero$cp() {
        return CornerRadius.Zero;
    }

    public static final CornerRadius box-impl(long arg1) {
        return new CornerRadius(arg1);
    }

    public static final float component1-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static final float component2-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long copy-OHQCggk(long arg2, float arg4, float arg5) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(arg4))) << 0x20 | (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL);
    }

    public static long copy-OHQCggk$default(long arg2, float arg4, float arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg4 = Float.intBitsToFloat(((int)(arg2 >> 0x20)));
        }

        if((arg6 & 2) != 0) {
            arg5 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg2)));
        }

        return CornerRadius.copy-OHQCggk(arg2, arg4, arg5);
    }

    public static final long div-Bz7bX_o(long arg6, float arg8) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) / arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) / arg8))) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return CornerRadius.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof CornerRadius)) {
            return 0;
        }

        if(arg4 != ((CornerRadius)arg6).unbox-impl()) {
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

    public static void getX$annotations() {
    }

    public static final float getX-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static void getY$annotations() {
    }

    public static final float getY-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public int hashCode() {
        return CornerRadius.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final boolean isCircular-impl(long arg4) {
        if(arg4 >>> 0x20 == (arg4 & 0xFFFFFFFFL)) {
            return 1;
        }

        return 0;
    }

    public static final boolean isZero-impl(long arg2) {
        arg2 &= 0x7FFFFFFF7FFFFFFFL;
        if((~arg2 & arg2 - 0x100000001L & -9223372034707292160L) != 0) {
            return 1;
        }

        return 0;
    }

    public static final long minus-vF7b-mM(long arg6, long arg8) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) - Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long plus-vF7b-mM(long arg6, long arg8) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) + Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) + Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long times-Bz7bX_o(long arg6, float arg8) {
        return CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) * arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) * arg8))) & 0xFFFFFFFFL);
    }

    public String toString() {
        return CornerRadius.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg4) {
        int v0 = ((int)(arg4 >> 0x20));
        int v4 = ((int)(arg4 & 0xFFFFFFFFL));
        char v1 = ')';
        if(Float.compare(Float.intBitsToFloat(v0), Float.intBitsToFloat(v4)) == 0) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(v0), 1) + v1;
        }

        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(v0), 1) + ", " + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(v4), 1) + v1;
    }

    public static final long unaryMinus-kKHJgLs(long arg2) {
        return CornerRadius.constructor-impl(arg2 ^ -9223372034707292160L);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

