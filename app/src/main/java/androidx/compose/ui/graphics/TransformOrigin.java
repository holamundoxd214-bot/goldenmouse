package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000E\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u000F\u0010\u000BJ\u0010\u0010\u0010\u001A\u00020\tH\u0087\n¢\u0006\u0004\b\u0011\u0010\u000BJ!\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\f\u001A\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000B\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001D"}, d2={"Landroidx/compose/ui/graphics/TransformOrigin;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "pivotFractionX", "", "getPivotFractionX-impl", "(J)F", "pivotFractionY", "getPivotFractionY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-zey9I6w", "(JFF)J", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TransformOrigin {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/TransformOrigin$Companion;", "", "<init>", "()V", "Center", "Landroidx/compose/ui/graphics/TransformOrigin;", "getCenter-SzJe1aQ", "()J", "J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getCenter-SzJe1aQ() {
            return TransformOrigin.Center;
        }
    }

    private static final long Center;
    public static final Companion Companion;
    private final long packedValue;

    static {
        TransformOrigin.Companion = new Companion(null);
        TransformOrigin.Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);
    }

    private TransformOrigin(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getCenter$cp() {
        return TransformOrigin.Center;
    }

    public static final TransformOrigin box-impl(long arg1) {
        return new TransformOrigin(arg1);
    }

    public static final float component1-impl(long arg0) {
        return TransformOrigin.getPivotFractionX-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        return TransformOrigin.getPivotFractionY-impl(arg0);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long copy-zey9I6w(long arg0, float arg2, float arg3) {
        return TransformOriginKt.TransformOrigin(arg2, arg3);
    }

    public static long copy-zey9I6w$default(long arg0, float arg2, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg2 = TransformOrigin.getPivotFractionX-impl(arg0);
        }

        if((arg4 & 2) != 0) {
            arg3 = TransformOrigin.getPivotFractionY-impl(arg0);
        }

        return TransformOrigin.copy-zey9I6w(arg0, arg2, arg3);
    }

    public boolean equals(Object arg3) {
        return TransformOrigin.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof TransformOrigin)) {
            return 0;
        }

        if(arg4 != ((TransformOrigin)arg6).unbox-impl()) {
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

    public static void getPackedValue$annotations() {
    }

    public static final float getPivotFractionX-impl(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static final float getPivotFractionY-impl(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public int hashCode() {
        return TransformOrigin.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return TransformOrigin.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        return "TransformOrigin(packedValue=" + arg2 + ')';
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

