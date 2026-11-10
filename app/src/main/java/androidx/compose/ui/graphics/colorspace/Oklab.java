package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0005H\u0016J\u0010\u0010\u000E\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0005H\u0016J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016J%\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\f2\u0006\u0010 \u001A\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\n¨\u0006%"}, d2={"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics", "toZ", "toZ$ui_graphics", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Oklab extends ColorSpace {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/colorspace/Oklab$Companion;", "", "<init>", "()V", "M1", "", "M2", "InverseM1", "InverseM2", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final float[] InverseM1;
    private static final float[] InverseM2;
    private static final float[] M1;
    private static final float[] M2;

    static {
        Oklab.Companion = new Companion(null);
        float[] v1 = ColorSpaceKt.mul3x3(new float[]{0.818933f, 0.032985f, 0.0482f, 0.361867f, 0.929312f, 0.264366f, -0.12886f, 0.036146f, 0.633852f}, ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics(), Illuminant.INSTANCE.getD50().toXyz$ui_graphics(), Illuminant.INSTANCE.getD65().toXyz$ui_graphics()));
        Oklab.M1 = v1;
        float[] v0 = new float[]{0.210454f, 1.977998f, 0.025904f, 0.793618f, -2.428592f, 0.782772f, -0.004072f, 0.450594f, -0.808676f};
        Oklab.M2 = v0;
        Oklab.InverseM1 = ColorSpaceKt.inverse3x3(v1);
        Oklab.InverseM2 = ColorSpaceKt.inverse3x3(v0);
    }

    public Oklab(String arg8, int arg9) {
        super(arg8, ColorModel.Companion.getLab-xdoWZVw(), arg9, null);
    }

    public float[] fromXyz(float[] arg2) {
        ColorSpaceKt.mul3x3Float3(Oklab.M1, arg2);
        arg2[0] = MathHelpersKt.fastCbrt(arg2[0]);
        arg2[1] = MathHelpersKt.fastCbrt(arg2[1]);
        arg2[2] = MathHelpersKt.fastCbrt(arg2[2]);
        ColorSpaceKt.mul3x3Float3(Oklab.M2, arg2);
        return arg2;
    }

    public float getMaxValue(int arg1) {
        if(arg1 == 0) {
            return 1f;
        }

        return 0.5f;
    }

    public float getMinValue(int arg1) {
        if(arg1 == 0) {
            return 0;
        }

        return -0.5f;
    }

    public boolean isWideGamut() {
        return 1;
    }

    public long toXy$ui_graphics(float arg10, float arg11, float arg12) {
        if(arg10 < 0f) {
            arg10 = 0f;
        }

        float v9 = 1f;
        if(0f > v9) {
            arg10 = v9;
        }

        v9 = -0.5f;
        if(arg11 < v9) {
            arg11 = v9;
        }

        float v0 = 0.5f;
        if(arg11 > v0) {
            arg11 = v0;
        }

        if(arg12 < v9) {
            arg12 = v9;
        }

        if(arg12 > v0) {
        }
        else {
            v0 = arg12;
        }

        float[] v9_1 = Oklab.InverseM2;
        float v1 = v9_1[0] * arg10 + v9_1[3] * arg11 + v9_1[6] * v0;
        float v5 = v9_1[1] * arg10 + v9_1[4] * arg11 + v9_1[7] * v0;
        float v8 = v9_1[2] * arg10 + v9_1[5] * arg11 + v9_1[8] * v0;
        v9 = v1 * v1 * v1;
        arg10 = v5 * v5 * v5;
        arg11 = v8 * v8 * v8;
        return (((long)Float.floatToRawIntBits(Oklab.InverseM1[0] * v9 + Oklab.InverseM1[3] * arg10 + Oklab.InverseM1[6] * arg11))) << 0x20 | (((long)Float.floatToRawIntBits(Oklab.InverseM1[1] * v9 + Oklab.InverseM1[4] * arg10 + Oklab.InverseM1[7] * arg11))) & 0xFFFFFFFFL;
    }

    public float[] toXyz(float[] arg7) {
        float v0 = arg7[0];
        if(v0 < 0f) {
            v0 = 0f;
        }

        float v1 = 1f;
        if(v0 > v1) {
            v0 = v1;
        }

        arg7[0] = v0;
        v1 = arg7[1];
        float v2 = -0.5f;
        if(v1 < v2) {
            v1 = v2;
        }

        float v3 = 0.5f;
        if(v1 > v3) {
            v1 = v3;
        }

        arg7[1] = v1;
        int v1_1 = 2;
        float v4 = arg7[v1_1];
        if(v4 < v2) {
        }
        else {
            v2 = v4;
        }

        if(v2 > v3) {
        }
        else {
            v3 = v2;
        }

        arg7[v1_1] = v3;
        ColorSpaceKt.mul3x3Float3(Oklab.InverseM2, arg7);
        arg7[0] *= arg7[0] * arg7[0];
        arg7[1] *= arg7[1] * arg7[1];
        arg7[v1_1] *= arg7[v1_1] * arg7[v1_1];
        ColorSpaceKt.mul3x3Float3(Oklab.InverseM1, arg7);
        return arg7;
    }

    public float toZ$ui_graphics(float arg6, float arg7, float arg8) {
        if(arg6 < 0f) {
            arg6 = 0f;
        }

        float v5 = 1f;
        if(0f > v5) {
            arg6 = v5;
        }

        v5 = -0.5f;
        if(arg7 < v5) {
            arg7 = v5;
        }

        float v0 = 0.5f;
        if(arg7 > v0) {
            arg7 = v0;
        }

        if(arg8 < v5) {
            arg8 = v5;
        }

        if(arg8 > v0) {
        }
        else {
            v0 = arg8;
        }

        float[] v5_1 = Oklab.InverseM2;
        arg8 = v5_1[0] * arg6 + v5_1[3] * arg7 + v5_1[6] * v0;
        float v1 = v5_1[1] * arg6 + v5_1[4] * arg7 + v5_1[7] * v0;
        float v3 = v5_1[2] * arg6 + v5_1[5] * arg7 + v5_1[8] * v0;
        return Oklab.InverseM1[2] * (arg8 * arg8 * arg8) + Oklab.InverseM1[5] * (v1 * v1 * v1) + Oklab.InverseM1[8] * (v3 * v3 * v3);
    }

    public long xyzaToColor-JlNiLsg$ui_graphics(float arg12, float arg13, float arg14, float arg15, ColorSpace arg16) {
        float[] v11 = Oklab.M1;
        float v1 = v11[0] * arg12 + v11[3] * arg13 + v11[6] * arg14;
        float v5 = v11[1] * arg12 + v11[4] * arg13 + v11[7] * arg14;
        float v9 = v11[2] * arg12 + v11[5] * arg13 + v11[8] * arg14;
        float v11_1 = MathHelpersKt.fastCbrt(v1);
        v1 = MathHelpersKt.fastCbrt(v5);
        v5 = MathHelpersKt.fastCbrt(v9);
        return ColorKt.Color(Oklab.M2[0] * v11_1 + Oklab.M2[3] * v1 + Oklab.M2[6] * v5, Oklab.M2[1] * v11_1 + Oklab.M2[4] * v1 + Oklab.M2[7] * v5, Oklab.M2[2] * v11_1 + Oklab.M2[5] * v1 + Oklab.M2[8] * v5, arg15, arg16);
    }
}

