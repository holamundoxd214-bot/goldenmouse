package androidx.core.graphics;

import android.graphics.Color;
import androidx.core.content.res.CamColor;
import java.util.Objects;

public final class ColorUtils {
    class Api26Impl {
        private Api26Impl() {
            super();
        }

        static Color compositeColors(Color arg7, Color arg8) {
            if(Objects.equals(arg7.getModel(), arg8.getModel())) {
                if(Objects.equals(arg8.getColorSpace(), arg7.getColorSpace())) {
                }
                else {
                    arg7 = arg7.convert(arg8.getColorSpace());
                }

                float[] v0 = arg7.getComponents();
                float[] v1 = arg8.getComponents();
                float v7 = arg7.alpha();
                float v2 = arg8.alpha() * (1f - v7);
                int v3 = arg8.getComponentCount() - 1;
                float v4 = v7 + v2;
                v1[v3] = v4;
                if(v4 > 0f) {
                    v7 /= v4;
                    v2 /= v4;
                }

                int v4_1;
                for(v4_1 = 0; v4_1 < v3; ++v4_1) {
                    v1[v4_1] = v0[v4_1] * v7 + v1[v4_1] * v2;
                }

                return Color.valueOf(v1, arg8.getColorSpace());
            }

            throw new IllegalArgumentException("Color models must match (" + arg7.getModel() + " vs. " + arg8.getModel() + ")");
        }
    }

    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal TEMP_ARRAY = null;
    private static final double XYZ_EPSILON = 0.008856;
    private static final double XYZ_KAPPA = 903.3;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047;
    private static final double XYZ_WHITE_REFERENCE_Y = 100;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883;

    static {
        ColorUtils.TEMP_ARRAY = new ThreadLocal();
    }

    private ColorUtils() {
        super();
    }

    public static int HSLToColor(float[] arg6) {
        int v3;
        int v1_1;
        int v6_1;
        float v1 = arg6[0];
        float v2 = arg6[1];
        float v6 = arg6[2];
        float v4 = (1f - Math.abs(v6 * 2f - 1f)) * v2;
        v6 -= 0.5f * v4;
        float v5 = (1f - Math.abs(v1 / 60f % 2f - 1f)) * v4;
        v2 = 255f;
        switch((((int)v1)) / 60) {
            case 0: {
                v1_1 = Math.round((v4 + v6) * v2);
                v3 = Math.round((v5 + v6) * v2);
                v6_1 = Math.round(v6 * v2);
                break;
            }
            case 1: {
                v1_1 = Math.round((v5 + v6) * v2);
                v3 = Math.round((v4 + v6) * v2);
                v6_1 = Math.round(v6 * v2);
                break;
            }
            case 2: {
                v1_1 = Math.round(v6 * v2);
                v3 = Math.round((v4 + v6) * v2);
                v6_1 = Math.round((v5 + v6) * v2);
                break;
            }
            case 3: {
                v1_1 = Math.round(v6 * v2);
                v3 = Math.round((v5 + v6) * v2);
                v6_1 = Math.round((v4 + v6) * v2);
                break;
            }
            case 4: {
                v1_1 = Math.round((v5 + v6) * v2);
                v3 = Math.round(v6 * v2);
                v6_1 = Math.round((v4 + v6) * v2);
                break;
            }
            case 5: 
            case 6: {
                v1_1 = Math.round((v4 + v6) * v2);
                v3 = Math.round(v6 * v2);
                v6_1 = Math.round((v5 + v6) * v2);
                break;
            }
            default: {
                v6_1 = 0;
                v1_1 = 0;
                v3 = 0;
                break;
            }
        }

        return Color.rgb(ColorUtils.constrain(v1_1, 0, 0xFF), ColorUtils.constrain(v3, 0, 0xFF), ColorUtils.constrain(v6_1, 0, 0xFF));
    }

    public static int LABToColor(double arg7, double arg9, double arg11) {
        double[] v6 = ColorUtils.getTempDouble3Array();
        ColorUtils.LABToXYZ(arg7, arg9, arg11, v6);
        return ColorUtils.XYZToColor(v6[0], v6[1], v6[2]);
    }

    public static void LABToXYZ(double arg19, double arg21, double arg23, double[] arg25) {
        double v0 = 16;
        double v4 = 116;
        double v2 = (arg19 + v0) / v4;
        double v6 = arg21 / 500 + v2;
        double v8 = v2 - arg23 / 200;
        double v10 = 3;
        double v12 = Math.pow(v6, v10);
        double v14 = 0.008856;
        double v17 = 903.3;
        if(Double.compare(v12, v14) > 0) {
        }
        else {
            v12 = (v6 * v4 - v0) / v17;
        }

        v2 = arg19 > 7.999625 ? Math.pow(v2, v10) : arg19 / v17;
        v6 = Math.pow(v8, v10);
        if(v6 > v14) {
        }
        else {
            v6 = (v8 * v4 - v0) / v17;
        }

        arg25[0] = v12 * 95.047;
        arg25[1] = v2 * 100;
        arg25[2] = v6 * 108.883;
    }

    public static int M3HCTToColor(float arg0, float arg1, float arg2) {
        return CamColor.toColor(arg0, arg1, arg2);
    }

    public static void RGBToHSL(int arg7, int arg8, int arg9, float[] arg10) {
        float v7 = (((float)arg7)) / 255f;
        float v8 = (((float)arg8)) / 255f;
        float v9 = (((float)arg9)) / 255f;
        float v0 = Math.max(v7, Math.max(v8, v9));
        float v1 = Math.min(v7, Math.min(v8, v9));
        float v2 = v0 - v1;
        float v4 = 2f;
        float v3 = (v0 + v1) / v4;
        float v5 = 1f;
        if(Float.compare(v0, v1) == 0) {
            v8 = 0f;
            v2 = 0f;
        }
        else {
            if(v0 == v7) {
                v8 = (v8 - v9) / v2 % 6f;
            }
            else if(v0 == v8) {
                v8 = (v9 - v7) / v2 + v4;
            }
            else {
                v8 = 4f + (v7 - v8) / v2;
            }

            v2 /= v5 - Math.abs(v4 * v3 - v5);
        }

        v7 = 360f;
        v8 = v8 * 60f % v7;
        if(v8 < 0f) {
            v8 += v7;
        }

        arg10[0] = ColorUtils.constrain(v8, 0f, v7);
        arg10[1] = ColorUtils.constrain(v2, 0f, v5);
        arg10[2] = ColorUtils.constrain(v3, 0f, v5);
    }

    public static void RGBToLAB(int arg7, int arg8, int arg9, double[] arg10) {
        ColorUtils.RGBToXYZ(arg7, arg8, arg9, arg10);
        ColorUtils.XYZToLAB(arg10[0], arg10[1], arg10[2], arg10);
    }

    public static void RGBToXYZ(int arg20, int arg21, int arg22, double[] arg23) {
        double[] v0 = arg23;
        if(v0.length == 3) {
            double v3 = 255;
            double v1 = (((double)arg20)) / v3;
            double v5 = 0.04045;
            double v8 = 12.92;
            double v10 = 2.4;
            double v12 = 1.055;
            double v14 = 0.055;
            if(Double.compare(v1, v5) < 0) {
                v1 /= v8;
            }
            else {
                v1 = Math.pow((v1 + v14) / v12, v10);
            }

            double v16 = v3;
            v3 = (((double)arg21)) / v16;
            if(v3 < v5) {
                v3 /= v8;
            }
            else {
                v3 = Math.pow((v3 + v14) / v12, v10);
            }

            double v18 = v5;
            v5 = (((double)arg22)) / v16;
            if(v5 < v18) {
                v5 /= v8;
            }
            else {
                v5 = Math.pow((v5 + v14) / v12, v10);
            }

            v0[0] = (0.4124 * v1 + 0.3576 * v3 + 0.1805 * v5) * 100;
            v0[1] = (0.2126 * v1 + 0.7152 * v3 + 0.0722 * v5) * 100;
            v0[2] = (v1 * 0.0193 + v3 * 0.1192 + v5 * 0.9505) * 100;
            return;
        }

        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int XYZToColor(double arg17, double arg19, double arg21) {
        double v0 = (3.2406 * arg17 + -1.5372 * arg19 + -0.4986 * arg21) / 100;
        double v4 = (-0.9689 * arg17 + 1.8758 * arg19 + 0.0415 * arg21) / 100;
        double v6 = (0.0557 * arg17 + -0.204 * arg19 + 1.057 * arg21) / 100;
        double v2 = 0.003131;
        double v9 = 0.055;
        double v11 = 0.416667;
        double v13 = 1.055;
        double v15 = 12.92;
        if(Double.compare(v0, v2) > 0) {
            v0 = Math.pow(v0, v11) * v13 - v9;
        }
        else {
            v0 *= v15;
        }

        if(v4 > v2) {
            v4 = Math.pow(v4, v11) * v13 - v9;
        }
        else {
            v4 *= v15;
        }

        v2 = v6 > v2 ? Math.pow(v6, v11) * v13 - v9 : v6 * v15;
        return Color.rgb(ColorUtils.constrain(((int)Math.round(v0 * 255)), 0, 0xFF), ColorUtils.constrain(((int)Math.round(v4 * 255)), 0, 0xFF), ColorUtils.constrain(((int)Math.round(v2 * 255)), 0, 0xFF));
    }

    public static void XYZToLAB(double arg4, double arg6, double arg8, double[] arg10) {
        if(arg10.length == 3) {
            arg4 = ColorUtils.pivotXyzComponent(arg4 / 95.047);
            arg6 = ColorUtils.pivotXyzComponent(arg6 / 100);
            arg8 = ColorUtils.pivotXyzComponent(arg8 / 108.883);
            arg10[0] = Math.max(0, 116 * arg6 - 16);
            arg10[1] = (arg4 - arg6) * 500;
            arg10[2] = (arg6 - arg8) * 200;
            return;
        }

        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    public static int blendARGB(int arg5, int arg6, float arg7) {
        float v0 = 1f - arg7;
        return Color.argb(((int)((((float)Color.alpha(arg5))) * v0 + (((float)Color.alpha(arg6))) * arg7)), ((int)((((float)Color.red(arg5))) * v0 + (((float)Color.red(arg6))) * arg7)), ((int)((((float)Color.green(arg5))) * v0 + (((float)Color.green(arg6))) * arg7)), ((int)((((float)Color.blue(arg5))) * v0 + (((float)Color.blue(arg6))) * arg7)));
    }

    public static void blendHSL(float[] arg4, float[] arg5, float arg6, float[] arg7) {
        if(arg7.length == 3) {
            float v0 = 1f - arg6;
            arg7[0] = ColorUtils.circularInterpolate(arg4[0], arg5[0], arg6);
            arg7[1] = arg4[1] * v0 + arg5[1] * arg6;
            arg7[2] = arg4[2] * v0 + arg5[2] * arg6;
            return;
        }

        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(double[] arg7, double[] arg8, double arg9, double[] arg11) {
        if(arg11.length == 3) {
            double v0 = 1 - arg9;
            arg11[0] = arg7[0] * v0 + arg8[0] * arg9;
            arg11[1] = arg7[1] * v0 + arg8[1] * arg9;
            arg11[2] = arg7[2] * v0 + arg8[2] * arg9;
            return;
        }

        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(int arg4, int arg5) {
        int v1 = 0xFF;
        if(Color.alpha(arg5) == v1) {
            if(Color.alpha(arg4) < v1) {
                arg4 = ColorUtils.compositeColors(arg4, arg5);
            }

            double v0 = ColorUtils.calculateLuminance(arg4) + 0.05;
            double v4 = ColorUtils.calculateLuminance(arg5) + 0.05;
            return Math.max(v0, v4) / Math.min(v0, v4);
        }

        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(arg5));
    }

    public static double calculateLuminance(int arg5) {
        double[] v0 = ColorUtils.getTempDouble3Array();
        ColorUtils.colorToXYZ(arg5, v0);
        return v0[1] / 100;
    }

    public static int calculateMinimumAlpha(int arg8, int arg9, float arg10) {
        int v1 = 0xFF;
        if(Color.alpha(arg9) == v1) {
            double v4 = ((double)arg10);
            if(ColorUtils.calculateContrast(ColorUtils.setAlphaComponent(arg8, v1), arg9) < v4) {
                return -1;
            }

            int v10 = 0;
            int v0 = 0;
            while(v10 <= 10) {
                if(v1 - v0 <= 1) {
                    return v1;
                }

                int v2 = (v0 + v1) / 2;
                if(ColorUtils.calculateContrast(ColorUtils.setAlphaComponent(arg8, v2), arg9) < v4) {
                    v0 = v2;
                }
                else {
                    v1 = v2;
                }

                ++v10;
            }

            return v1;
        }

        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(arg9));
    }

    static float circularInterpolate(float arg2, float arg3, float arg4) {
        float v1 = 360f;
        if(Float.compare(Math.abs(arg3 - arg2), 180f) > 0) {
            if(arg3 > arg2) {
                arg2 += v1;
            }
            else {
                arg3 += v1;
            }
        }

        return (arg2 + (arg3 - arg2) * arg4) % v1;
    }

    public static void colorToHSL(int arg2, float[] arg3) {
        ColorUtils.RGBToHSL(Color.red(arg2), Color.green(arg2), Color.blue(arg2), arg3);
    }

    public static void colorToLAB(int arg2, double[] arg3) {
        ColorUtils.RGBToLAB(Color.red(arg2), Color.green(arg2), Color.blue(arg2), arg3);
    }

    public static void colorToM3HCT(int arg0, float[] arg1) {
        CamColor.getM3HCTfromColor(arg0, arg1);
    }

    public static void colorToXYZ(int arg2, double[] arg3) {
        ColorUtils.RGBToXYZ(Color.red(arg2), Color.green(arg2), Color.blue(arg2), arg3);
    }

    private static int compositeAlpha(int arg0, int arg1) {
        return 0xFF - (0xFF - arg1) * (0xFF - arg0) / 0xFF;
    }

    public static int compositeColors(int arg6, int arg7) {
        int v0 = Color.alpha(arg7);
        int v1 = Color.alpha(arg6);
        int v2 = ColorUtils.compositeAlpha(v1, v0);
        return Color.argb(v2, ColorUtils.compositeComponent(Color.red(arg6), v1, Color.red(arg7), v0, v2), ColorUtils.compositeComponent(Color.green(arg6), v1, Color.green(arg7), v0, v2), ColorUtils.compositeComponent(Color.blue(arg6), v1, Color.blue(arg7), v0, v2));
    }

    public static Color compositeColors(Color arg0, Color arg1) {
        return Api26Impl.compositeColors(arg0, arg1);
    }

    private static int compositeComponent(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(arg4 == 0) {
            return 0;
        }

        return (arg0 * 0xFF * arg1 + arg2 * arg3 * (0xFF - arg1)) / (arg4 * 0xFF);
    }

    private static int constrain(int arg0, int arg1, int arg2) {
        if(arg0 < arg1) {
            return arg1;
        }

        return Math.min(arg0, arg2);
    }

    private static float constrain(float arg1, float arg2, float arg3) {
        if(arg1 < arg2) {
            return arg2;
        }

        return Math.min(arg1, arg3);
    }

    public static double distanceEuclidean(double[] arg9, double[] arg10) {
        return Math.sqrt(Math.pow(arg9[0] - arg10[0], 2) + Math.pow(arg9[1] - arg10[1], 2) + Math.pow(arg9[2] - arg10[2], 2));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal v0 = ColorUtils.TEMP_ARRAY;
        Object v1 = v0.get();
        if(v1 == null) {
            double[] v1_1 = new double[3];
            v0.set(v1_1);
        }

        return ((double[])v1);
    }

    private static double pivotXyzComponent(double arg2) {
        if(arg2 > 0.008856) {
            return Math.pow(arg2, 0.333333);
        }

        return (arg2 * 903.3 + 16) / 116;
    }

    public static int setAlphaComponent(int arg1, int arg2) {
        if(arg2 >= 0 && arg2 <= 0xFF) {
            return arg1 & 0xFFFFFF | arg2 << 24;
        }

        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}

