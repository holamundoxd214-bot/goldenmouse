package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0017\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 72\u00020\u0001:\u00017B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\tH\u0007¢\u0006\u0004\b\u001D\u0010\rJ\u000F\u0010\u001E\u001A\u00020\tH\u0007¢\u0006\u0004\b\u001F\u0010\rJ\u0010\u0010 \u001A\u00020\u0000H\u0087\n¢\u0006\u0004\b!\u0010\u0005J\u0018\u0010\"\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b\'\u0010%J\u0018\u0010(\u001A\u00020\u00002\u0006\u0010)\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001A\u00020\u00002\u0006\u0010)\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b-\u0010+J\u0018\u0010.\u001A\u00020\u00002\u0006\u0010)\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b/\u0010+J\u000F\u00100\u001A\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0013\u00104\u001A\u00020\u00192\b\u0010#\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001A\u000206HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001B\u0010\b\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001B\u0010\u000E\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00068"}, d2={"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "isValid", "", "isValid-impl", "(J)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "unaryMinus", "unaryMinus-F1C5BW0", "minus", "other", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "times", "operand", "times-tuRUvjQ", "(JF)J", "div", "div-tuRUvjQ", "rem", "rem-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "", "Companion", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Offset {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\bR\u001E\u0010\r\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\b¨\u0006\u0010"}, d2={"Landroidx/compose/ui/geometry/Offset$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/Offset;", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "()J", "J", "Infinite", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getInfinite-F1C5BW0() {
            return Offset.Infinite;
        }

        public static void getInfinite-F1C5BW0$annotations() {
        }

        public final long getUnspecified-F1C5BW0() {
            return Offset.Unspecified;
        }

        public static void getUnspecified-F1C5BW0$annotations() {
        }

        public final long getZero-F1C5BW0() {
            return Offset.Zero;
        }

        public static void getZero-F1C5BW0$annotations() {
        }
    }

    public static final Companion Companion;
    private static final long Infinite;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    static {
        Offset.Companion = new Companion(null);
        Offset.Zero = Offset.constructor-impl(0);
        Offset.Infinite = Offset.constructor-impl(0x7F8000007F800000L);
        Offset.Unspecified = Offset.constructor-impl(0x7FC000007FC00000L);
    }

    private Offset(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getInfinite$cp() {
        return Offset.Infinite;
    }

    public static final long access$getUnspecified$cp() {
        return Offset.Unspecified;
    }

    public static final long access$getZero$cp() {
        return Offset.Zero;
    }

    public static final Offset box-impl(long arg1) {
        return new Offset(arg1);
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

    public static final long copy-dBAh8RU(long arg2, float arg4, float arg5) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg4))) << 0x20 | (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL);
    }

    public static long copy-dBAh8RU$default(long arg2, float arg4, float arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg4 = Float.intBitsToFloat(((int)(arg2 >> 0x20)));
        }

        if((arg6 & 2) != 0) {
            arg5 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg2)));
        }

        return Offset.copy-dBAh8RU(arg2, arg4, arg5);
    }

    public static final long div-tuRUvjQ(long arg6, float arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) / arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) / arg8))) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return Offset.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof Offset)) {
            return 0;
        }

        if(arg4 != ((Offset)arg6).unbox-impl()) {
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

    public static final float getDistance-impl(long arg3) {
        float v0 = Float.intBitsToFloat(((int)(arg3 >> 0x20)));
        float v3 = Float.intBitsToFloat(((int)(arg3 & 0xFFFFFFFFL)));
        return ((float)Math.sqrt(((double)(v0 * v0 + v3 * v3))));
    }

    public static final float getDistanceSquared-impl(long arg3) {
        float v0 = Float.intBitsToFloat(((int)(arg3 >> 0x20)));
        float v3 = Float.intBitsToFloat(((int)(arg3 & 0xFFFFFFFFL)));
        return v0 * v0 + v3 * v3;
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
        return Offset.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final boolean isValid-impl(long arg2) {
        if(((arg2 & 0x7FFFFFFF7FFFFFFFL) + 0x7FFFFF007FFFFFL & -9223372034707292160L) == 0) {
            return 1;
        }

        return 0;
    }

    public static final long minus-MK-Hz9U(long arg6, long arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) - Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) - Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long plus-MK-Hz9U(long arg6, long arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) + Float.intBitsToFloat(((int)(arg8 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) + Float.intBitsToFloat(((int)(arg8 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL);
    }

    public static final long rem-tuRUvjQ(long arg6, float arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) % arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) % arg8))) & 0xFFFFFFFFL);
    }

    public static final long times-tuRUvjQ(long arg6, float arg8) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) * arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) * arg8))) & 0xFFFFFFFFL);
    }

    public String toString() {
        return Offset.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg5) {
        if((0x7FFFFFFF7FFFFFFFL & arg5) != 0x7FC000007FC00000L) {
            return "Offset(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(((int)(arg5 >> 0x20))), 1) + ", " + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))), 1) + ')';
        }

        return "Offset.Unspecified";
    }

    public static final long unaryMinus-F1C5BW0(long arg2) {
        return Offset.constructor-impl(arg2 ^ -9223372034707292160L);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

