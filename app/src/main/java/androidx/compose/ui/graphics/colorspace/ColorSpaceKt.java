package androidx.compose.ui.graphics.colorspace;

import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000B\u001A\'\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001A%\u0010\t\u001A\u00020\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\b\u001A\u001E\u0010\u000B\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007\u001A8\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0000\u001A8\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0000\u001AH\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0000\u001AH\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0000\u001A8\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0000\u001A8\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0011H\u0000\u001A\u001A\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0013\u001A\u00020\u001F2\b\u0010\u0014\u001A\u0004\u0018\u00010\u001FH\u0000\u001A\u0018\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\rH\u0000\u001A\u0018\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0013\u001A\u00020 2\u0006\u0010\u0014\u001A\u00020 H\u0000\u001A\u0010\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020 H\u0000\u001A\u0018\u0010#\u001A\u00020 2\u0006\u0010$\u001A\u00020 2\u0006\u0010%\u001A\u00020 H\u0000\u001A\u0018\u0010&\u001A\u00020 2\u0006\u0010$\u001A\u00020 2\u0006\u0010%\u001A\u00020 H\u0000\u001A)\u0010\'\u001A\u00020(2\u0006\u0010$\u001A\u00020 2\u0006\u0010)\u001A\u00020(2\u0006\u0010*\u001A\u00020(2\u0006\u0010+\u001A\u00020(H\u0080\b\u001A)\u0010,\u001A\u00020(2\u0006\u0010$\u001A\u00020 2\u0006\u0010)\u001A\u00020(2\u0006\u0010*\u001A\u00020(2\u0006\u0010+\u001A\u00020(H\u0080\b\u001A)\u0010-\u001A\u00020(2\u0006\u0010$\u001A\u00020 2\u0006\u0010)\u001A\u00020(2\u0006\u0010*\u001A\u00020(2\u0006\u0010+\u001A\u00020(H\u0080\b\u001A\u0018\u0010.\u001A\u00020 2\u0006\u0010$\u001A\u00020 2\u0006\u0010%\u001A\u00020 H\u0000\u001A \u0010/\u001A\u00020 2\u0006\u00100\u001A\u00020 2\u0006\u00101\u001A\u00020 2\u0006\u00102\u001A\u00020 H\u0000¨\u00063"}, d2={"createConnector", "Landroidx/compose/ui/graphics/colorspace/Connector;", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "createConnector-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "connect", "connect-YBCOT_4", "adapt", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "adaptation", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "rcpResponse", "", "x", "a", "b", "c", "d", "g", "response", "e", "f", "absRcpResponse", "absResponse", "compare", "", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "inverse3x3", "m", "mul3x3", "lhs", "rhs", "mul3x3Float3", "mul3x3Float3_0", "", "r0", "r1", "r2", "mul3x3Float3_1", "mul3x3Float3_2", "mul3x3Diag", "chromaticAdaptation", "matrix", "srcWhitePoint", "dstWhitePoint", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ColorSpaceKt {
    public static final double absRcpResponse(double arg16, double arg18, double arg20, double arg22, double arg24, double arg26) {
        double v0 = arg16;
        double v4 = v0 < 0 ? -v0 : v0;
        return Math.copySign(ColorSpaceKt.rcpResponse(v4, arg18, arg20, arg22, arg24, arg26), v0);
    }

    public static final double absResponse(double arg16, double arg18, double arg20, double arg22, double arg24, double arg26) {
        double v0 = arg16;
        double v4 = v0 < 0 ? -v0 : v0;
        return Math.copySign(ColorSpaceKt.response(v4, arg18, arg20, arg22, arg24, arg26), v0);
    }

    public static final ColorSpace adapt(ColorSpace arg2, WhitePoint arg3) {
        return ColorSpaceKt.adapt$default(arg2, arg3, null, 2, null);
    }

    public static final ColorSpace adapt(ColorSpace arg4, WhitePoint arg5, Adaptation arg6) {
        if(ColorModel.equals-impl0(arg4.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw())) {
            Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            ColorSpace v0 = arg4;
            if(ColorSpaceKt.compare(((Rgb)v0).getWhitePoint(), arg5)) {
            }
            else {
                return new Rgb(((Rgb)v0), ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(arg6.getTransform$ui_graphics(), ((Rgb)v0).getWhitePoint().toXyz$ui_graphics(), arg5.toXyz$ui_graphics()), ((Rgb)v0).getTransform$ui_graphics()), arg5);
            }
        }

        return arg4;
    }

    public static ColorSpace adapt$default(ColorSpace arg0, WhitePoint arg1, Adaptation arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = Adaptation.Companion.getBradford();
        }

        return ColorSpaceKt.adapt(arg0, arg1, arg2);
    }

    public static final float[] chromaticAdaptation(float[] arg5, float[] arg6, float[] arg7) {
        arg6 = ColorSpaceKt.mul3x3Float3(arg5, arg6);
        arg7 = ColorSpaceKt.mul3x3Float3(arg5, arg7);
        return ColorSpaceKt.mul3x3(ColorSpaceKt.inverse3x3(arg5), ColorSpaceKt.mul3x3Diag(new float[]{arg7[0] / arg6[0], arg7[1] / arg6[1], arg7[2] / arg6[2]}, arg5));
    }

    public static final boolean compare(WhitePoint arg3, WhitePoint arg4) {
        if(arg3 == arg4) {
            return 1;
        }

        float v2 = 0.001f;
        if(Math.abs(arg3.getX() - arg4.getX()) < v2 && Math.abs(arg3.getY() - arg4.getY()) < v2) {
            return 1;
        }

        return 0;
    }

    public static final boolean compare(TransferParameters arg6, TransferParameters arg7) {
        if(arg7 != null) {
            double v2 = 0.001;
            if(Math.abs(arg6.getA() - arg7.getA()) < v2 && Math.abs(arg6.getB() - arg7.getB()) < v2 && Math.abs(arg6.getC() - arg7.getC()) < v2 && Math.abs(arg6.getD() - arg7.getD()) < 0.002 && Math.abs(arg6.getE() - arg7.getE()) < v2 && Math.abs(arg6.getF() - arg7.getF()) < v2 && Math.abs(arg6.getGamma() - arg7.getGamma()) < v2) {
                return 1;
            }
        }

        return 0;
    }

    public static final boolean compare(float[] arg6, float[] arg7) {
        if(arg6 == arg7) {
            return 1;
        }

        int v1 = arg6.length;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            if(Float.compare(arg6[v3], arg7[v3]) != 0 && Math.abs(arg6[v3] - arg7[v3]) > 0.001f) {
                return 0;
            }
        }

        return 1;
    }

    public static final Connector connect-YBCOT_4(ColorSpace arg3, ColorSpace arg4, int arg5) {
        Connector v1_2;
        int v0 = arg3.getId$ui_graphics();
        int v1 = arg4.getId$ui_graphics();
        if((v0 | v1) < 0) {
            return ColorSpaceKt.createConnector-YBCOT_4(arg3, arg4, arg5);
        }

        MutableIntObjectMap v2 = ConnectorKt.getConnectors();
        v0 = v0 | v1 << 6 | arg5 << 12;
        Object v1_1 = v2.get(v0);
        if(v1_1 == null) {
            v1_2 = ColorSpaceKt.createConnector-YBCOT_4(arg3, arg4, arg5);
            v2.set(v0, v1_2);
        }

        return v1_2;
    }

    public static Connector connect-YBCOT_4$default(ColorSpace arg0, ColorSpace arg1, int arg2, int arg3, Object arg4) {
        Rgb v1;
        if((arg3 & 1) != 0) {
            v1 = ColorSpaces.INSTANCE.getSrgb();
        }

        if((arg3 & 2) != 0) {
            arg2 = RenderIntent.Companion.getPerceptual-uksYyKA();
        }

        return ColorSpaceKt.connect-YBCOT_4(arg0, ((ColorSpace)v1), arg2);
    }

    private static final Connector createConnector-YBCOT_4(ColorSpace arg6, ColorSpace arg7, int arg8) {
        if(arg6 == arg7) {
            return Connector.Companion.identity$ui_graphics(arg6);
        }

        DefaultConstructorMarker v1 = null;
        if((ColorModel.equals-impl0(arg6.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw())) && (ColorModel.equals-impl0(arg7.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw()))) {
            Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            return new RgbConnector(((Rgb)arg6), ((Rgb)arg7), arg8, v1);
        }

        return new Connector(arg6, arg7, arg8, v1);
    }

    public static final float[] inverse3x3(float[] arg24) {
        float v2 = arg24[0];
        float v4 = arg24[3];
        float v6 = arg24[6];
        float v8 = arg24[1];
        float v10 = arg24[4];
        float v12 = arg24[7];
        float v14 = arg24[2];
        float v16 = arg24[5];
        float v18 = arg24[8];
        float v19 = v10 * v18 - v12 * v16;
        float v20 = v12 * v14 - v8 * v18;
        float v21 = v8 * v16 - v10 * v14;
        float v22 = v2 * v19 + v4 * v20 + v6 * v21;
        float[] v0 = new float[arg24.length];
        v0[0] = v19 / v22;
        v0[1] = v20 / v22;
        v0[2] = v21 / v22;
        v0[3] = (v6 * v16 - v4 * v18) / v22;
        v0[4] = (v18 * v2 - v6 * v14) / v22;
        v0[5] = (v14 * v4 - v16 * v2) / v22;
        v0[6] = (v4 * v12 - v6 * v10) / v22;
        v0[7] = (v6 * v8 - v12 * v2) / v22;
        v0[8] = (v2 * v10 - v4 * v8) / v22;
        return v0;
    }

    public static final float[] mul3x3(float[] arg21, float[] arg22) {
        float[] v0 = arg21;
        float[] v1 = arg22;
        int v2 = 9;
        float[] v3 = new float[v2];
        if(v0.length < v2) {
        }
        else {
            if(v1.length < v2) {
                return v3;
            }

            goto label_10;
        }

        return v3;
    label_10:
        float v4 = v0[0] * v1[0];
        float v6 = v0[3];
        float v8 = v1[1];
        float v10 = v0[6];
        float v12 = v1[2];
        v3[0] = v4 + v6 * v8 + v10 * v12;
        v4 = v0[1];
        float v13 = v1[0];
        float v15 = v0[4];
        float v16 = v0[7];
        v3[1] = v4 * v13 + v8 * v15 + v16 * v12;
        v4 = v0[2] * v13;
        float v17 = v0[5];
        v4 += v1[1] * v17;
        float v19 = v0[8];
        v3[2] = v4 + v12 * v19;
        float v2_1 = v0[0];
        v4 = v1[3] * v2_1;
        v12 = v1[4];
        v4 += v6 * v12;
        v6 = v1[5];
        v3[3] = v4 + v10 * v6;
        v4 = v0[1];
        float v7 = v1[3];
        v3[4] = v4 * v7 + v15 * v12 + v16 * v6;
        float v11 = v0[2];
        v3[5] = v7 * v11 + v17 * v1[4] + v6 * v19;
        v2_1 *= v1[6];
        float v5 = v0[3];
        v6 = v1[7];
        v2_1 += v5 * v6;
        v5 = v1[8];
        v3[6] = v2_1 + v10 * v5;
        v2_1 = v1[6];
        v3[7] = v4 * v2_1 + v0[4] * v6 + v16 * v5;
        v3[8] = v11 * v2_1 + v0[5] * v1[7] + v19 * v5;
        return v3;
    }

    public static final float[] mul3x3Diag(float[] arg19, float[] arg20) {
        return new float[]{arg20[0] * arg19[0], arg20[1] * arg19[1], arg20[2] * arg19[2], arg20[3] * arg19[0], arg20[4] * arg19[1], arg20[5] * arg19[2], arg19[0] * arg20[6], arg19[1] * arg20[7], arg19[2] * arg20[8]};
    }

    public static final float[] mul3x3Float3(float[] arg8, float[] arg9) {
        int v1;
        if(arg8.length < 9) {
        }
        else {
            v1 = 3;
            if(arg9.length < v1) {
                return arg9;
            }

            goto label_8;
        }

        return arg9;
    label_8:
        float v2 = arg9[0];
        float v4 = arg9[1];
        float v6 = arg9[2];
        arg9[0] = arg8[0] * v2 + arg8[v1] * v4 + arg8[6] * v6;
        arg9[1] = arg8[1] * v2 + arg8[4] * v4 + arg8[7] * v6;
        arg9[2] = arg8[2] * v2 + arg8[5] * v4 + arg8[8] * v6;
        return arg9;
    }

    public static final float mul3x3Float3_0(float[] arg1, float arg2, float arg3, float arg4) {
        return arg1[0] * arg2 + arg1[3] * arg3 + arg1[6] * arg4;
    }

    public static final float mul3x3Float3_1(float[] arg1, float arg2, float arg3, float arg4) {
        return arg1[1] * arg2 + arg1[4] * arg3 + arg1[7] * arg4;
    }

    public static final float mul3x3Float3_2(float[] arg1, float arg2, float arg3, float arg4) {
        return arg1[2] * arg2 + arg1[5] * arg3 + arg1[8] * arg4;
    }

    public static final double rcpResponse(double arg0, double arg2, double arg4, double arg6, double arg8, double arg10) {
        if(arg0 >= arg8 * arg6) {
            return (Math.pow(arg0, 1 / arg10) - arg4) / arg2;
        }

        return arg0 / arg6;
    }

    public static final double rcpResponse(double arg0, double arg2, double arg4, double arg6, double arg8, double arg10, double arg12, double arg14) {
        if(arg0 >= arg8 * arg6) {
            return (Math.pow(arg0 - arg10, 1 / arg14) - arg4) / arg2;
        }

        return (arg0 - arg12) / arg6;
    }

    public static final double response(double arg0, double arg2, double arg4, double arg6, double arg8, double arg10) {
        if(arg0 >= arg8) {
            return Math.pow(arg2 * arg0 + arg4, arg10);
        }

        return arg6 * arg0;
    }

    public static final double response(double arg0, double arg2, double arg4, double arg6, double arg8, double arg10, double arg12, double arg14) {
        if(arg0 >= arg8) {
            return Math.pow(arg2 * arg0 + arg4, arg14) + arg10;
        }

        return arg6 * arg0 + arg12;
    }
}

