package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0005H\u0016J\u0010\u0010\u000E\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0005H\u0016J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016J%\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\f2\u0006\u0010 \u001A\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\n¨\u0006%"}, d2={"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics", "toZ", "toZ$ui_graphics", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Lab extends ColorSpace {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/colorspace/Lab$Companion;", "", "<init>", "()V", "A", "", "B", "C", "D", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    private static final float A = 0.008856f;
    private static final float B = 7.787037f;
    private static final float C = 0.137931f;
    public static final Companion Companion = null;
    private static final float D = 0.206897f;

    static {
        Lab.Companion = new Companion(null);
    }

    public Lab(String arg8, int arg9) {
        super(arg8, ColorModel.Companion.getLab-xdoWZVw(), arg9, null);
    }

    public float[] fromXyz(float[] arg12) {
        float v0 = arg12[0] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        float v2 = arg12[1] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        int v3 = 2;
        float v4 = arg12[v3] / Illuminant.INSTANCE.getD50Xyz$ui_graphics()[v3];
        float v5 = 0.008856f;
        float v7 = 0.137931f;
        float v8 = 7.787037f;
        v0 = Float.compare(v0, v5) > 0 ? ((float)Math.cbrt(((double)v0))) : v0 * v8 + v7;
        v2 = v2 > v5 ? ((float)Math.cbrt(((double)v2))) : v2 * v8 + v7;
        v4 = v4 > v5 ? ((float)Math.cbrt(((double)v4))) : v4 * v8 + v7;
        v5 = 116f * v2 - 16f;
        v0 = (v0 - v2) * 500f;
        v2 = (v2 - v4) * 200f;
        if(v5 < 0f) {
            v5 = 0f;
        }

        v4 = 100f;
        if(v5 > v4) {
            v5 = v4;
        }

        arg12[0] = v5;
        float v11 = -128f;
        if(v0 < v11) {
            v0 = v11;
        }

        v4 = 128f;
        if(v0 > v4) {
            v0 = v4;
        }

        arg12[1] = v0;
        if(v2 < v11) {
            v2 = v11;
        }

        if(v2 > v4) {
        }
        else {
            v4 = v2;
        }

        arg12[v3] = v4;
        return arg12;
    }

    public float getMaxValue(int arg1) {
        if(arg1 == 0) {
            return 100f;
        }

        return 128f;
    }

    public float getMinValue(int arg1) {
        if(arg1 == 0) {
            return 0;
        }

        return -128f;
    }

    public boolean isWideGamut() {
        return 1;
    }

    public long toXy$ui_graphics(float arg3, float arg4, float arg5) {
        if(arg3 < 0f) {
            arg3 = 0f;
        }

        float v2 = 100f;
        if(0f > v2) {
            arg3 = v2;
        }

        v2 = -128f;
        if(arg4 < v2) {
            arg4 = v2;
        }

        v2 = 128f;
        if(arg4 > v2) {
            arg4 = v2;
        }

        arg3 = (arg3 + 16f) / 116f;
        arg4 = arg4 * 0.002f + arg3;
        v2 = 0.206897f;
        float v0 = 0.137931f;
        float v1 = 0.128419f;
        arg5 = Float.compare(arg4, v2) > 0 ? arg4 * arg4 * arg4 : (arg4 - v0) * v1;
        v2 = arg3 > v2 ? arg3 * arg3 * arg3 : (arg3 - v0) * v1;
        return (((long)Float.floatToRawIntBits(arg5 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0]))) << 0x20 | 0xFFFFFFFFL & (((long)Float.floatToRawIntBits(v2 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1])));
    }

    public float[] toXyz(float[] arg10) {
        float v0 = arg10[0];
        if(v0 < 0f) {
            v0 = 0f;
        }

        float v1 = 100f;
        if(v0 > v1) {
            v0 = v1;
        }

        arg10[0] = v0;
        float v2 = arg10[1];
        float v3 = -128f;
        if(v2 < v3) {
            v2 = v3;
        }

        float v4 = 128f;
        if(v2 > v4) {
            v2 = v4;
        }

        arg10[1] = v2;
        int v5 = 2;
        float v6 = arg10[v5];
        if(v6 < v3) {
        }
        else {
            v3 = v6;
        }

        if(v3 > v4) {
        }
        else {
            v4 = v3;
        }

        arg10[v5] = v4;
        v0 = (v0 + 16f) / 116f;
        v2 = v2 * 0.002f + v0;
        v3 = v0 - v4 * 0.005f;
        v4 = 0.206897f;
        float v7 = 0.137931f;
        float v8 = 0.128419f;
        v6 = Float.compare(v2, v4) > 0 ? v2 * v2 * v2 : (v2 - v7) * v8;
        v2 = v0 > v4 ? v0 * v0 * v0 : (v0 - v7) * v8;
        v0 = v3 > v4 ? v3 * v3 * v3 : (v3 - v7) * v8;
        arg10[0] = v6 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        arg10[1] = v2 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        arg10[v5] = v0 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[v5];
        return arg10;
    }

    public float toZ$ui_graphics(float arg1, float arg2, float arg3) {
        if(arg1 < 0f) {
            arg1 = 0f;
        }

        float v0 = 100f;
        if(0f > v0) {
            arg1 = v0;
        }

        v0 = -128f;
        if(arg3 < v0) {
            arg3 = v0;
        }

        v0 = 128f;
        if(arg3 > v0) {
            arg3 = v0;
        }

        arg1 = (arg1 + 16f) / 116f - arg3 * 0.005f;
        v0 = arg1 > 0.206897f ? arg1 * arg1 * arg1 : 0.128419f * (arg1 - 0.137931f);
        return v0 * Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
    }

    public long xyzaToColor-JlNiLsg$ui_graphics(float arg6, float arg7, float arg8, float arg9, ColorSpace arg10) {
        arg6 /= Illuminant.INSTANCE.getD50Xyz$ui_graphics()[0];
        arg7 /= Illuminant.INSTANCE.getD50Xyz$ui_graphics()[1];
        arg8 /= Illuminant.INSTANCE.getD50Xyz$ui_graphics()[2];
        float v5 = 0.008856f;
        float v1 = 0.137931f;
        float v2 = 7.787037f;
        arg6 = Float.compare(arg6, v5) > 0 ? ((float)Math.cbrt(((double)arg6))) : arg6 * v2 + v1;
        arg7 = arg7 > v5 ? ((float)Math.cbrt(((double)arg7))) : arg7 * v2 + v1;
        v5 = arg8 > v5 ? ((float)Math.cbrt(((double)arg8))) : arg8 * v2 + v1;
        arg8 = 116f * arg7 - 16f;
        arg6 = (arg6 - arg7) * 500f;
        arg7 = (arg7 - v5) * 200f;
        if(arg8 < 0f) {
            arg8 = 0f;
        }

        v5 = 100f;
        if(arg8 > v5) {
            arg8 = v5;
        }

        v5 = -128f;
        if(arg6 < v5) {
            arg6 = v5;
        }

        float v0 = 128f;
        if(arg6 > v0) {
            arg6 = v0;
        }

        if(arg7 < v5) {
            arg7 = v5;
        }

        if(arg7 > v0) {
        }
        else {
            v0 = arg7;
        }

        return ColorKt.Color(arg8, arg6, v0, arg9, arg10);
    }
}

