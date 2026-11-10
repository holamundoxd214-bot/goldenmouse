package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class RenderIntent {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/graphics/colorspace/RenderIntent$Companion;", "", "<init>", "()V", "Perceptual", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "getPerceptual-uksYyKA", "()I", "I", "Relative", "getRelative-uksYyKA", "Saturation", "getSaturation-uksYyKA", "Absolute", "getAbsolute-uksYyKA", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAbsolute-uksYyKA() {
            return RenderIntent.Absolute;
        }

        public final int getPerceptual-uksYyKA() {
            return RenderIntent.Perceptual;
        }

        public final int getRelative-uksYyKA() {
            return RenderIntent.Relative;
        }

        public final int getSaturation-uksYyKA() {
            return RenderIntent.Saturation;
        }
    }

    private static final int Absolute;
    public static final Companion Companion;
    private static final int Perceptual;
    private static final int Relative;
    private static final int Saturation;
    private final int value;

    static {
        RenderIntent.Companion = new Companion(null);
        RenderIntent.Perceptual = RenderIntent.constructor-impl(0);
        RenderIntent.Relative = RenderIntent.constructor-impl(1);
        RenderIntent.Saturation = RenderIntent.constructor-impl(2);
        RenderIntent.Absolute = RenderIntent.constructor-impl(3);
    }

    private RenderIntent(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAbsolute$cp() {
        return RenderIntent.Absolute;
    }

    public static final int access$getPerceptual$cp() {
        return RenderIntent.Perceptual;
    }

    public static final int access$getRelative$cp() {
        return RenderIntent.Relative;
    }

    public static final int access$getSaturation$cp() {
        return RenderIntent.Saturation;
    }

    public static final RenderIntent box-impl(int arg1) {
        return new RenderIntent(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return RenderIntent.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof RenderIntent)) {
            return 0;
        }

        if(arg2 != ((RenderIntent)arg3).unbox-impl()) {
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

    public int hashCode() {
        return RenderIntent.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return RenderIntent.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(RenderIntent.equals-impl0(arg1, RenderIntent.Perceptual)) {
            return "Perceptual";
        }

        if(RenderIntent.equals-impl0(arg1, RenderIntent.Relative)) {
            return "Relative";
        }

        if(RenderIntent.equals-impl0(arg1, RenderIntent.Saturation)) {
            return "Saturation";
        }

        if(RenderIntent.equals-impl0(arg1, RenderIntent.Absolute)) {
            return "Absolute";
        }

        return "Unknown";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

