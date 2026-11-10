package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001A\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 62\u00020\u0001:\u00016B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000F\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010 \u001A\u00020\u0013H\u0087\n¢\u0006\u0004\b!\u0010\u0016J\u0010\u0010\"\u001A\u00020\u0013H\u0087\n¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001A\u00020\u0013H\u0087\n¢\u0006\u0004\b%\u0010\u0016J\u0010\u0010&\u001A\u00020\u0013H\u0087\n¢\u0006\u0004\b\'\u0010\u0016J\u0010\u0010(\u001A\u00020\nH\u0087\n¢\u0006\u0004\b)\u0010\u000EJ7\u0010*\u001A\u00020\u00002\b\b\u0002\u0010\u001D\u001A\u00020\u00132\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0017\u001A\u00020\u00132\b\b\u0002\u0010\u001A\u001A\u00020\u0013H\u0007¢\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0013\u00101\u001A\u0002022\b\u00103\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001A\u000205HÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\t\u001A\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u001A\u0010\u0012\u001A\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\f\u001A\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\f\u001A\u0004\b\u0019\u0010\u0016R\u001A\u0010\u001A\u001A\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001B\u0010\f\u001A\u0004\b\u001C\u0010\u0016R\u001A\u0010\u001D\u001A\u00020\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001E\u0010\f\u001A\u0004\b\u001F\u0010\u0016\u0088\u0001\u0002¨\u00067"}, d2={"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "getValue-s-VKNKU", "()J", "J", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "()V", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "red", "", "getRed$annotations", "getRed-impl", "(J)F", "green", "getGreen$annotations", "getGreen-impl", "blue", "getBlue$annotations", "getBlue-impl", "alpha", "getAlpha$annotations", "getAlpha-impl", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "copy", "copy-wmQWz5c", "(JFFFF)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "other", "hashCode", "", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Color {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010.\u001A\u00020\u00052\u0006\u0010/\u001A\u0002002\u0006\u00101\u001A\u0002002\u0006\u00102\u001A\u0002002\b\b\u0002\u00103\u001A\u0002002\b\b\u0002\u00104\u001A\u000205¢\u0006\u0004\b6\u00107J(\u00108\u001A\u0002002\u0006\u00109\u001A\u00020:2\u0006\u0010;\u001A\u0002002\u0006\u0010<\u001A\u0002002\u0006\u0010=\u001A\u000200H\u0002J9\u0010>\u001A\u00020\u00052\u0006\u0010/\u001A\u0002002\u0006\u00101\u001A\u0002002\u0006\u0010?\u001A\u0002002\b\b\u0002\u00103\u001A\u0002002\b\b\u0002\u00104\u001A\u000205¢\u0006\u0004\b@\u00107J(\u0010A\u001A\u0002002\u0006\u00109\u001A\u00020:2\u0006\u0010;\u001A\u0002002\u0006\u0010<\u001A\u0002002\u0006\u0010B\u001A\u000200H\u0002R\u001E\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\n\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\bR\u001E\u0010\r\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000E\u0010\u0003\u001A\u0004\b\u000F\u0010\bR\u001E\u0010\u0010\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001A\u0004\b\u0012\u0010\bR\u001E\u0010\u0013\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001A\u0004\b\u0015\u0010\bR\u001E\u0010\u0016\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001A\u0004\b\u0018\u0010\bR\u001E\u0010\u0019\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001A\u0010\u0003\u001A\u0004\b\u001B\u0010\bR\u001E\u0010\u001C\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001D\u0010\u0003\u001A\u0004\b\u001E\u0010\bR\u001E\u0010\u001F\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001A\u0004\b!\u0010\bR\u001E\u0010\"\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b#\u0010\u0003\u001A\u0004\b$\u0010\bR\u001E\u0010%\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b&\u0010\u0003\u001A\u0004\b\'\u0010\bR\u001E\u0010(\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b)\u0010\u0003\u001A\u0004\b*\u0010\bR\u001E\u0010+\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b,\u0010\u0003\u001A\u0004\b-\u0010\b¨\u0006C"}, d2={"Landroidx/compose/ui/graphics/Color$Companion;", "", "<init>", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "hsv", "hue", "", "saturation", "value", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsv-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hsvToRgbComponent", "n", "", "h", "s", "v", "hsl", "lightness", "hsl-JlNiLsg", "hslToRgbComponent", "l", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getBlack-0d7_KjU() {
            return Color.Black;
        }

        public static void getBlack-0d7_KjU$annotations() {
        }

        public final long getBlue-0d7_KjU() {
            return Color.Blue;
        }

        public static void getBlue-0d7_KjU$annotations() {
        }

        public final long getCyan-0d7_KjU() {
            return Color.Cyan;
        }

        public static void getCyan-0d7_KjU$annotations() {
        }

        public final long getDarkGray-0d7_KjU() {
            return Color.DarkGray;
        }

        public static void getDarkGray-0d7_KjU$annotations() {
        }

        public final long getGray-0d7_KjU() {
            return Color.Gray;
        }

        public static void getGray-0d7_KjU$annotations() {
        }

        public final long getGreen-0d7_KjU() {
            return Color.Green;
        }

        public static void getGreen-0d7_KjU$annotations() {
        }

        public final long getLightGray-0d7_KjU() {
            return Color.LightGray;
        }

        public static void getLightGray-0d7_KjU$annotations() {
        }

        public final long getMagenta-0d7_KjU() {
            return Color.Magenta;
        }

        public static void getMagenta-0d7_KjU$annotations() {
        }

        public final long getRed-0d7_KjU() {
            return Color.Red;
        }

        public static void getRed-0d7_KjU$annotations() {
        }

        public final long getTransparent-0d7_KjU() {
            return Color.Transparent;
        }

        public static void getTransparent-0d7_KjU$annotations() {
        }

        public final long getUnspecified-0d7_KjU() {
            return Color.Unspecified;
        }

        public static void getUnspecified-0d7_KjU$annotations() {
        }

        public final long getWhite-0d7_KjU() {
            return Color.White;
        }

        public static void getWhite-0d7_KjU$annotations() {
        }

        public final long getYellow-0d7_KjU() {
            return Color.Yellow;
        }

        public static void getYellow-0d7_KjU$annotations() {
        }

        public final long hsl-JlNiLsg(float arg5, float arg6, float arg7, float arg8, Rgb arg9) {
            int v0;
            if(Float.compare(0f, arg5) > 0 || arg5 > 360f || 0f > arg6) {
            label_13:
                v0 = 0;
            }
            else {
                float v1 = 1f;
                if(arg6 > v1) {
                    goto label_13;
                }
                else if(0f > arg7) {
                    goto label_13;
                }
                else if(arg7 <= v1) {
                    v0 = 1;
                }
                else {
                    goto label_13;
                }
            }

            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("HSL (" + arg5 + ", " + arg6 + ", " + arg7 + ") must be in range (0..360, 0..1, 0..1)");
            }

            return ColorKt.Color(this.hslToRgbComponent(0, arg5, arg6, arg7), this.hslToRgbComponent(8, arg5, arg6, arg7), this.hslToRgbComponent(4, arg5, arg6, arg7), arg8, ((ColorSpace)arg9));
        }

        public static long hsl-JlNiLsg$default(Companion arg6, float arg7, float arg8, float arg9, float arg10, Rgb arg11, int arg12, Object arg13) {
            if((arg12 & 8) != 0) {
                arg10 = 1f;
            }

            float v4 = arg10;
            if((arg12 & 16) != 0) {
                arg11 = ColorSpaces.INSTANCE.getSrgb();
            }

            return arg6.hsl-JlNiLsg(arg7, arg8, arg9, v4, arg11);
        }

        private final float hslToRgbComponent(int arg2, float arg3, float arg4, float arg5) {
            float v1 = ((((float)arg2)) + arg3 / 30f) % 12f;
            return arg5 - arg4 * Math.min(arg5, 1f - arg5) * Math.max(-1f, Math.min(v1 - 3f, Math.min(9f - v1, 1f)));
        }

        public final long hsv-JlNiLsg(float arg5, float arg6, float arg7, float arg8, Rgb arg9) {
            int v0;
            if(Float.compare(0f, arg5) > 0 || arg5 > 360f || 0f > arg6) {
            label_13:
                v0 = 0;
            }
            else {
                float v1 = 1f;
                if(arg6 > v1) {
                    goto label_13;
                }
                else if(0f > arg7) {
                    goto label_13;
                }
                else if(arg7 <= v1) {
                    v0 = 1;
                }
                else {
                    goto label_13;
                }
            }

            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("HSV (" + arg5 + ", " + arg6 + ", " + arg7 + ") must be in range (0..360, 0..1, 0..1)");
            }

            return ColorKt.Color(this.hsvToRgbComponent(5, arg5, arg6, arg7), this.hsvToRgbComponent(3, arg5, arg6, arg7), this.hsvToRgbComponent(1, arg5, arg6, arg7), arg8, ((ColorSpace)arg9));
        }

        public static long hsv-JlNiLsg$default(Companion arg6, float arg7, float arg8, float arg9, float arg10, Rgb arg11, int arg12, Object arg13) {
            if((arg12 & 8) != 0) {
                arg10 = 1f;
            }

            float v4 = arg10;
            if((arg12 & 16) != 0) {
                arg11 = ColorSpaces.INSTANCE.getSrgb();
            }

            return arg6.hsv-JlNiLsg(arg7, arg8, arg9, v4, arg11);
        }

        private final float hsvToRgbComponent(int arg1, float arg2, float arg3, float arg4) {
            float v0 = ((((float)arg1)) + arg2 / 60f) % 6f;
            return arg4 - arg3 * arg4 * Math.max(0f, Math.min(v0, Math.min(4f - v0, 1f)));
        }
    }

    private static final long Black;
    private static final long Blue;
    public static final Companion Companion;
    private static final long Cyan;
    private static final long DarkGray;
    private static final long Gray;
    private static final long Green;
    private static final long LightGray;
    private static final long Magenta;
    private static final long Red;
    private static final long Transparent;
    private static final long Unspecified;
    private static final long White;
    private static final long Yellow;
    private final long value;

    static {
        Color.Companion = new Companion(null);
        Color.Black = ColorKt.Color(0xFF000000L);
        Color.DarkGray = ColorKt.Color(0xFF444444L);
        Color.Gray = ColorKt.Color(0xFF888888L);
        Color.LightGray = ColorKt.Color(0xFFCCCCCCL);
        Color.White = ColorKt.Color(0xFFFFFFFFL);
        Color.Red = ColorKt.Color(0xFFFF0000L);
        Color.Green = ColorKt.Color(0xFF00FF00L);
        Color.Blue = ColorKt.Color(0xFF0000FFL);
        Color.Yellow = ColorKt.Color(0xFFFFFF00L);
        Color.Cyan = ColorKt.Color(0xFF00FFFFL);
        Color.Magenta = ColorKt.Color(0xFFFF00FFL);
        Color.Transparent = ColorKt.Color(0);
        Color.Unspecified = ColorKt.Color(0f, 0f, 0f, 0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics());
    }

    private Color(long arg1) {
        super();
        this.value = arg1;
    }

    public static final long access$getBlack$cp() {
        return Color.Black;
    }

    public static final long access$getBlue$cp() {
        return Color.Blue;
    }

    public static final long access$getCyan$cp() {
        return Color.Cyan;
    }

    public static final long access$getDarkGray$cp() {
        return Color.DarkGray;
    }

    public static final long access$getGray$cp() {
        return Color.Gray;
    }

    public static final long access$getGreen$cp() {
        return Color.Green;
    }

    public static final long access$getLightGray$cp() {
        return Color.LightGray;
    }

    public static final long access$getMagenta$cp() {
        return Color.Magenta;
    }

    public static final long access$getRed$cp() {
        return Color.Red;
    }

    public static final long access$getTransparent$cp() {
        return Color.Transparent;
    }

    public static final long access$getUnspecified$cp() {
        return Color.Unspecified;
    }

    public static final long access$getWhite$cp() {
        return Color.White;
    }

    public static final long access$getYellow$cp() {
        return Color.Yellow;
    }

    public static final Color box-impl(long arg1) {
        return new Color(arg1);
    }

    public static final float component1-impl(long arg0) {
        return Color.getRed-impl(arg0);
    }

    public static final float component2-impl(long arg0) {
        return Color.getGreen-impl(arg0);
    }

    public static final float component3-impl(long arg0) {
        return Color.getBlue-impl(arg0);
    }

    public static final float component4-impl(long arg0) {
        return Color.getAlpha-impl(arg0);
    }

    public static final ColorSpace component5-impl(long arg0) {
        return Color.getColorSpace-impl(arg0);
    }

    public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final long convert-vNxB06k(long arg4, ColorSpace arg6) {
        return ColorSpaceKt.connect-YBCOT_4$default(Color.getColorSpace-impl(arg4), arg6, 0, 2, null).transformToColor-l2rxGTc$ui_graphics(arg4);
    }

    public static final long copy-wmQWz5c(long arg0, float arg2, float arg3, float arg4, float arg5) {
        return ColorKt.Color(arg3, arg4, arg5, arg2, Color.getColorSpace-impl(arg0));
    }

    public static long copy-wmQWz5c$default(long arg6, float arg8, float arg9, float arg10, float arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg8 = Color.getAlpha-impl(arg6);
        }

        float v2 = arg8;
        if((arg12 & 2) != 0) {
            arg9 = Color.getRed-impl(arg6);
        }

        float v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = Color.getGreen-impl(arg6);
        }

        float v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = Color.getBlue-impl(arg6);
        }

        return Color.copy-wmQWz5c(arg6, v2, v3, v4, arg11);
    }

    public boolean equals(Object arg3) {
        return Color.equals-impl(this.value, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof Color)) {
            return 0;
        }

        if(arg4 != ((Color)arg6).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(long arg0, long arg2) {
        return ULong.equals-impl0(arg0, arg2);
    }

    public static void getAlpha$annotations() {
    }

    public static final float getAlpha-impl(long arg4) {
        float v5;
        float v4;
        if(ULong.constructor-impl(0x3F & arg4) == 0) {
            v4 = ((float)UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(arg4 >>> 56) & 0xFF)));
            v5 = 255f;
        }
        else {
            v4 = ((float)UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(arg4 >>> 6) & 0x3FF)));
            v5 = 1023f;
        }

        return v4 / v5;
    }

    public static void getBlue$annotations() {
    }

    public static final float getBlue-impl(long arg5) {
        if(ULong.constructor-impl(0x3F & arg5) == 0) {
            return (((float)UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(arg5 >>> 0x20) & 0xFF)))) / 255f;
        }

        short v5 = ((short)(((int)ULong.constructor-impl(ULong.constructor-impl(arg5 >>> 16) & 0xFFFF))));
        int v1 = 0x8000 & v5;
        int v2 = 0x1F;
        int v6 = (0xFFFF & v5) >>> 10 & v2;
        int v5_1 = v5 & 0x3FF;
        if(v6 != 0) {
            v5_1 <<= 13;
            if(v6 == v2) {
                v6 = 0xFF;
                if(v5_1 != 0) {
                    v5_1 |= 0x400000;
                }
            }
            else {
                v6 += 0x70;
            }

            int v4 = v6;
            v6 = v5_1;
            v5_1 = v4;
        }
        else if(v5_1 != 0) {
            float v5_2 = Float.intBitsToFloat(v5_1 + 0x3F000000) - Float16Kt.access$getFp32DenormalFloat$p();
            if(v1 == 0) {
                return v5_2;
            }
            else {
                return -v5_2;
            }
        }
        else {
            v5_1 = 0;
            v6 = 0;
        }

        return Float.intBitsToFloat(v5_1 << 23 | v1 << 16 | v6);
    }

    public static void getColorSpace$annotations() {
    }

    public static final ColorSpace getColorSpace-impl(long arg3) {
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics()[((int)ULong.constructor-impl(arg3 & 0x3F))];
    }

    public static void getGreen$annotations() {
    }

    public static final float getGreen-impl(long arg5) {
        if(ULong.constructor-impl(0x3F & arg5) == 0) {
            return (((float)UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(arg5 >>> 40) & 0xFF)))) / 255f;
        }

        short v5 = ((short)(((int)ULong.constructor-impl(ULong.constructor-impl(arg5 >>> 0x20) & 0xFFFF))));
        int v0 = 0x8000 & v5;
        int v1 = 0x1F;
        int v6 = (0xFFFF & v5) >>> 10 & v1;
        int v5_1 = v5 & 0x3FF;
        if(v6 != 0) {
            v5_1 <<= 13;
            if(v6 == v1) {
                v6 = 0xFF;
                if(v5_1 != 0) {
                    v5_1 |= 0x400000;
                }
            }
            else {
                v6 += 0x70;
            }

            int v4 = v6;
            v6 = v5_1;
            v5_1 = v4;
        }
        else if(v5_1 != 0) {
            float v5_2 = Float.intBitsToFloat(v5_1 + 0x3F000000) - Float16Kt.access$getFp32DenormalFloat$p();
            if(v0 == 0) {
                return v5_2;
            }
            else {
                return -v5_2;
            }
        }
        else {
            v5_1 = 0;
            v6 = 0;
        }

        return Float.intBitsToFloat(v5_1 << 23 | v0 << 16 | v6);
    }

    public static void getRed$annotations() {
    }

    public static final float getRed-impl(long arg5) {
        int v1 = 0x30;
        if(Long.compare(ULong.constructor-impl(0x3F & arg5), 0) == 0) {
            return (((float)UnsignedKt.ulongToDouble(ULong.constructor-impl(ULong.constructor-impl(arg5 >>> v1) & 0xFF)))) / 255f;
        }

        short v5 = ((short)(((int)ULong.constructor-impl(ULong.constructor-impl(arg5 >>> v1) & 0xFFFF))));
        int v0 = 0x8000 & v5;
        v1 = 0x1F;
        int v6 = (0xFFFF & v5) >>> 10 & v1;
        int v5_1 = v5 & 0x3FF;
        if(v6 != 0) {
            v5_1 <<= 13;
            if(v6 == v1) {
                v6 = 0xFF;
                if(v5_1 != 0) {
                    v5_1 |= 0x400000;
                }
            }
            else {
                v6 += 0x70;
            }

            int v4 = v6;
            v6 = v5_1;
            v5_1 = v4;
        }
        else if(v5_1 != 0) {
            float v5_2 = Float.intBitsToFloat(v5_1 + 0x3F000000) - Float16Kt.access$getFp32DenormalFloat$p();
            if(v0 == 0) {
                return v5_2;
            }
            else {
                return -v5_2;
            }
        }
        else {
            v5_1 = 0;
            v6 = 0;
        }

        return Float.intBitsToFloat(v5_1 << 23 | v0 << 16 | v6);
    }

    public final long getValue-s-VKNKU() {
        return this.value;
    }

    public int hashCode() {
        return Color.hashCode-impl(this.value);
    }

    public static int hashCode-impl(long arg0) {
        return ULong.hashCode-impl(arg0);
    }

    public String toString() {
        return Color.toString-impl(this.value);
    }

    public static String toString-impl(long arg3) {
        return "Color(" + Color.getRed-impl(arg3) + ", " + Color.getGreen-impl(arg3) + ", " + Color.getBlue-impl(arg3) + ", " + Color.getAlpha-impl(arg3) + ", " + Color.getColorSpace-impl(arg3).getName() + ')';
    }

    public final long unbox-impl() {
        return this.value;
    }
}

