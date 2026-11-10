package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001A\u0010\u001BJ\u0018\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001D\u0010\u001BJ\u000F\u0010\u001E\u001A\u00020\u001FH\u0016¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001A\u00020&HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001B\u0010\b\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001B\u0010\u000E\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u0006("}, d2={"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "scaleX", "", "getScaleX$annotations", "()V", "getScaleX-impl", "(J)F", "scaleY", "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-8GGzs04", "(JFF)J", "times", "operand", "times-44nBxM0", "(JF)J", "div", "div-44nBxM0", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ScaleFactor {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/ui/layout/ScaleFactor$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/layout/ScaleFactor;", "getUnspecified-_hLwfpc$annotations", "getUnspecified-_hLwfpc", "()J", "J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getUnspecified-_hLwfpc() {
            return ScaleFactor.Unspecified;
        }

        public static void getUnspecified-_hLwfpc$annotations() {
        }
    }

    public static final Companion Companion;
    private static final long Unspecified;
    private final long packedValue;

    static {
        ScaleFactor.Companion = new Companion(null);
        ScaleFactor.Unspecified = ScaleFactor.constructor-impl((((long)Float.floatToRawIntBits(NaNf))) << 0x20 | (((long)Float.floatToRawIntBits(NaNf))) & 0xFFFFFFFFL);
    }

    private ScaleFactor(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getUnspecified$cp() {
        return ScaleFactor.Unspecified;
    }

    public static final ScaleFactor box-impl(long arg1) {
        return new ScaleFactor(arg1);
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

    public static final long copy-8GGzs04(long arg2, float arg4, float arg5) {
        return ScaleFactor.constructor-impl((((long)Float.floatToRawIntBits(arg4))) << 0x20 | (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL);
    }

    public static long copy-8GGzs04$default(long arg2, float arg4, float arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg4 = Float.intBitsToFloat(((int)(arg2 >> 0x20)));
        }

        if((arg6 & 2) != 0) {
            arg5 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg2)));
        }

        return ScaleFactor.copy-8GGzs04(arg2, arg4, arg5);
    }

    public static final long div-44nBxM0(long arg6, float arg8) {
        return ScaleFactor.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) / arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) / arg8))) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return ScaleFactor.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof ScaleFactor)) {
            return 0;
        }

        if(arg4 != ((ScaleFactor)arg6).unbox-impl()) {
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

    public static void getScaleX$annotations() {
    }

    public static final float getScaleX-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static void getScaleY$annotations() {
    }

    public static final float getScaleY-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public int hashCode() {
        return ScaleFactor.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final long times-44nBxM0(long arg6, float arg8) {
        return ScaleFactor.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) * arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) * arg8))) & 0xFFFFFFFFL);
    }

    public String toString() {
        return ScaleFactor.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg3) {
        return "ScaleFactor(" + Float.intBitsToFloat(((int)(arg3 >> 0x20))) + ", " + Float.intBitsToFloat(((int)(arg3 & 0xFFFFFFFFL))) + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

