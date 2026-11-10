package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0019H\u0007¢\u0006\u0004\b\u001A\u0010\u001BJ\u0018\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b\u001E\u0010\u001FJ\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\tH\u0087\u0002¢\u0006\u0004\b!\u0010\u001FJ\u000F\u0010(\u001A\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001A\u00020\u00192\b\u0010-\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001A\u00020/HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001B\u0010\b\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR\u001B\u0010\u000E\u001A\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\rR\u001A\u0010\"\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000B\u001A\u0004\b$\u0010\rR\u001A\u0010%\u001A\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u000B\u001A\u0004\b\'\u0010\r\u0088\u0001\u0002¨\u00061"}, d2={"Landroidx/compose/ui/geometry/Size;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "width", "", "getWidth$annotations", "()V", "getWidth-impl", "(J)F", "height", "getHeight$annotations", "getHeight-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-xjbvk4A", "(JFF)J", "isEmpty", "", "isEmpty-impl", "(J)Z", "times", "operand", "times-7Ah8Wj8", "(JF)J", "div", "div-7Ah8Wj8", "minDimension", "getMinDimension$annotations", "getMinDimension-impl", "maxDimension", "getMaxDimension$annotations", "getMaxDimension-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "other", "hashCode", "", "Companion", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Size {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\b¨\u0006\r"}, d2={"Landroidx/compose/ui/geometry/Size$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/Size;", "getZero-NH-jbRc$annotations", "getZero-NH-jbRc", "()J", "J", "Unspecified", "getUnspecified-NH-jbRc$annotations", "getUnspecified-NH-jbRc", "ui-geometry"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getUnspecified-NH-jbRc() {
            return Size.Unspecified;
        }

        public static void getUnspecified-NH-jbRc$annotations() {
        }

        public final long getZero-NH-jbRc() {
            return Size.Zero;
        }

        public static void getZero-NH-jbRc$annotations() {
        }
    }

    public static final Companion Companion;
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    static {
        Size.Companion = new Companion(null);
        Size.Zero = Size.constructor-impl(0);
        Size.Unspecified = Size.constructor-impl(0x7FC000007FC00000L);
    }

    private Size(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getUnspecified$cp() {
        return Size.Unspecified;
    }

    public static final long access$getZero$cp() {
        return Size.Zero;
    }

    public static final Size box-impl(long arg1) {
        return new Size(arg1);
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

    public static final long copy-xjbvk4A(long arg2, float arg4, float arg5) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(arg4))) << 0x20 | (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL);
    }

    public static long copy-xjbvk4A$default(long arg2, float arg4, float arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg4 = Float.intBitsToFloat(((int)(arg2 >> 0x20)));
        }

        if((arg6 & 2) != 0) {
            arg5 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg2)));
        }

        return Size.copy-xjbvk4A(arg2, arg4, arg5);
    }

    public static final long div-7Ah8Wj8(long arg6, float arg8) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) / arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) / arg8))) & 0xFFFFFFFFL);
    }

    public boolean equals(Object arg3) {
        return Size.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof Size)) {
            return 0;
        }

        if(arg4 != ((Size)arg6).unbox-impl()) {
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

    public static void getHeight$annotations() {
    }

    public static final float getHeight-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public static void getMaxDimension$annotations() {
    }

    public static final float getMaxDimension-impl(long arg4) {
        return Math.max(Float.intBitsToFloat(((int)(arg4 >> 0x20 & 0x7FFFFFFF))), Float.intBitsToFloat(((int)(arg4 & 0x7FFFFFFF))));
    }

    public static void getMinDimension$annotations() {
    }

    public static final float getMinDimension-impl(long arg4) {
        return Math.min(Float.intBitsToFloat(((int)(arg4 >> 0x20 & 0x7FFFFFFF))), Float.intBitsToFloat(((int)(arg4 & 0x7FFFFFFF))));
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public static void getWidth$annotations() {
    }

    public static final float getWidth-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public int hashCode() {
        return Size.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final boolean isEmpty-impl(long arg7) {
        int v1 = 1;
        int v0 = Long.compare(arg7, 0x7FC000007FC00000L) == 0 ? 1 : 0;
        int v3 = Float.intBitsToFloat(((int)(arg7 >> 0x20))) <= 0f ? 1 : 0;
        v0 |= v3;
        if(Float.intBitsToFloat(((int)(arg7 & 0xFFFFFFFFL))) <= 0f) {
        }
        else {
            v1 = 0;
        }

        return v0 | v1;
    }

    public static final long times-7Ah8Wj8(long arg6, float arg8) {
        return Size.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 >> 0x20))) * arg8))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) * arg8))) & 0xFFFFFFFFL);
    }

    public String toString() {
        return Size.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg5) {
        if(arg5 != 0x7FC000007FC00000L) {
            return "Size(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(((int)(arg5 >> 0x20))), 1) + ", " + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))), 1) + ')';
        }

        return "Size.Unspecified";
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

