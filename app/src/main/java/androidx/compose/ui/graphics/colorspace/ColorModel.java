package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\f\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0007HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000B\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "packedValue", "", "constructor-impl", "(J)J", "componentCount", "", "getComponentCount$annotations", "()V", "getComponentCount-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ColorModel {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorModel$Companion;", "", "<init>", "()V", "Rgb", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "getRgb-xdoWZVw", "()J", "J", "Xyz", "getXyz-xdoWZVw", "Lab", "getLab-xdoWZVw", "Cmyk", "getCmyk-xdoWZVw", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getCmyk-xdoWZVw() {
            return ColorModel.Cmyk;
        }

        public final long getLab-xdoWZVw() {
            return ColorModel.Lab;
        }

        public final long getRgb-xdoWZVw() {
            return ColorModel.Rgb;
        }

        public final long getXyz-xdoWZVw() {
            return ColorModel.Xyz;
        }
    }

    private static final long Cmyk;
    public static final Companion Companion;
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;
    private final long packedValue;

    static {
        ColorModel.Companion = new Companion(null);
        ColorModel.Rgb = ColorModel.constructor-impl(0x300000000L);
        ColorModel.Xyz = ColorModel.constructor-impl(0x300000001L);
        ColorModel.Lab = ColorModel.constructor-impl(0x300000002L);
        ColorModel.Cmyk = ColorModel.constructor-impl(0x400000003L);
    }

    private ColorModel(long arg1) {
        super();
        this.packedValue = arg1;
    }

    public static final long access$getCmyk$cp() {
        return ColorModel.Cmyk;
    }

    public static final long access$getLab$cp() {
        return ColorModel.Lab;
    }

    public static final long access$getRgb$cp() {
        return ColorModel.Rgb;
    }

    public static final long access$getXyz$cp() {
        return ColorModel.Xyz;
    }

    public static final ColorModel box-impl(long arg1) {
        return new ColorModel(arg1);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public boolean equals(Object arg3) {
        return ColorModel.equals-impl(this.packedValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof ColorModel)) {
            return 0;
        }

        if(arg4 != ((ColorModel)arg6).unbox-impl()) {
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

    public static void getComponentCount$annotations() {
    }

    public static final int getComponentCount-impl(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public int hashCode() {
        return ColorModel.hashCode-impl(this.packedValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public String toString() {
        return ColorModel.toString-impl(this.packedValue);
    }

    public static String toString-impl(long arg2) {
        if(ColorModel.equals-impl0(arg2, ColorModel.Rgb)) {
            return "Rgb";
        }

        if(ColorModel.equals-impl0(arg2, ColorModel.Xyz)) {
            return "Xyz";
        }

        if(ColorModel.equals-impl0(arg2, ColorModel.Lab)) {
            return "Lab";
        }

        if(ColorModel.equals-impl0(arg2, ColorModel.Cmyk)) {
            return "Cmyk";
        }

        return "Unknown";
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}

