package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\b\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/graphics/ImageBitmapConfig;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ImageBitmapConfig {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/ui/graphics/ImageBitmapConfig$Companion;", "", "<init>", "()V", "Argb8888", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getArgb8888-_sVssgQ", "()I", "I", "Alpha8", "getAlpha8-_sVssgQ", "Rgb565", "getRgb565-_sVssgQ", "F16", "getF16-_sVssgQ", "Gpu", "getGpu-_sVssgQ", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAlpha8-_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        public final int getArgb8888-_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        public final int getF16-_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        public final int getGpu-_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }

        public final int getRgb565-_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }
    }

    private static final int Alpha8;
    private static final int Argb8888;
    public static final Companion Companion;
    private static final int F16;
    private static final int Gpu;
    private static final int Rgb565;
    private final int value;

    static {
        ImageBitmapConfig.Companion = new Companion(null);
        ImageBitmapConfig.Argb8888 = ImageBitmapConfig.constructor-impl(0);
        ImageBitmapConfig.Alpha8 = ImageBitmapConfig.constructor-impl(1);
        ImageBitmapConfig.Rgb565 = ImageBitmapConfig.constructor-impl(2);
        ImageBitmapConfig.F16 = ImageBitmapConfig.constructor-impl(3);
        ImageBitmapConfig.Gpu = ImageBitmapConfig.constructor-impl(4);
    }

    private ImageBitmapConfig(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAlpha8$cp() {
        return ImageBitmapConfig.Alpha8;
    }

    public static final int access$getArgb8888$cp() {
        return ImageBitmapConfig.Argb8888;
    }

    public static final int access$getF16$cp() {
        return ImageBitmapConfig.F16;
    }

    public static final int access$getGpu$cp() {
        return ImageBitmapConfig.Gpu;
    }

    public static final int access$getRgb565$cp() {
        return ImageBitmapConfig.Rgb565;
    }

    public static final ImageBitmapConfig box-impl(int arg1) {
        return new ImageBitmapConfig(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ImageBitmapConfig.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ImageBitmapConfig)) {
            return 0;
        }

        if(arg2 != ((ImageBitmapConfig)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return ImageBitmapConfig.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ImageBitmapConfig.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Argb8888)) {
            return "Argb8888";
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Alpha8)) {
            return "Alpha8";
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Rgb565)) {
            return "Rgb565";
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.F16)) {
            return "F16";
        }

        if(ImageBitmapConfig.equals-impl0(arg1, ImageBitmapConfig.Gpu)) {
            return "Gpu";
        }

        return "Unknown";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

