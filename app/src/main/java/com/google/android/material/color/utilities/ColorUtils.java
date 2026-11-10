package com.google.android.material.color.utilities;

public class ColorUtils {
    static final double[][] SRGB_TO_XYZ;
    static final double[] WHITE_POINT_D65;
    static final double[][] XYZ_TO_SRGB;

    static {
        ColorUtils.SRGB_TO_XYZ = new double[][]{new double[]{0.412339, 0.357621, 0.18051}, new double[]{0.2126, 0.7152, 0.0722}, new double[]{0.019321, 0.119164, 0.950345}};
        ColorUtils.XYZ_TO_SRGB = new double[][]{new double[]{3.241377, -1.537665, -0.498854}, new double[]{-0.969145, 1.875885, 0.041566}, new double[]{0.055621, -0.203955, 1.05718}};
        ColorUtils.WHITE_POINT_D65 = new double[]{95.047, 100, 108.883};
    }

    private ColorUtils() {
        super();
    }

    public static int alphaFromArgb(int arg0) {
        return arg0 >> 24 & 0xFF;
    }

    public static int argbFromLab(double arg9, double arg11, double arg13) {
        arg9 = (arg9 + 16) / 116;
        return ColorUtils.argbFromXyz(ColorUtils.labInvf(arg11 / 500 + arg9) * ColorUtils.WHITE_POINT_D65[0], ColorUtils.labInvf(arg9) * ColorUtils.WHITE_POINT_D65[1], ColorUtils.labInvf(arg9 - arg13 / 200) * ColorUtils.WHITE_POINT_D65[2]);
    }

    public static int argbFromLinrgb(double[] arg4) {
        return ColorUtils.argbFromRgb(ColorUtils.delinearized(arg4[0]), ColorUtils.delinearized(arg4[1]), ColorUtils.delinearized(arg4[2]));
    }

    public static int argbFromLstar(double arg0) {
        int v0 = ColorUtils.delinearized(ColorUtils.yFromLstar(arg0));
        return ColorUtils.argbFromRgb(v0, v0, v0);
    }

    public static int argbFromRgb(int arg1, int arg2, int arg3) {
        return (arg1 & 0xFF) << 16 | 0xFF000000 | (arg2 & 0xFF) << 8 | arg3 & 0xFF;
    }

    public static int argbFromXyz(double arg11, double arg13, double arg15) {
        return ColorUtils.argbFromRgb(ColorUtils.delinearized(ColorUtils.XYZ_TO_SRGB[0][0] * arg11 + ColorUtils.XYZ_TO_SRGB[0][1] * arg13 + ColorUtils.XYZ_TO_SRGB[0][2] * arg15), ColorUtils.delinearized(ColorUtils.XYZ_TO_SRGB[1][0] * arg11 + ColorUtils.XYZ_TO_SRGB[1][1] * arg13 + ColorUtils.XYZ_TO_SRGB[1][2] * arg15), ColorUtils.delinearized(ColorUtils.XYZ_TO_SRGB[2][0] * arg11 + ColorUtils.XYZ_TO_SRGB[2][1] * arg13 + ColorUtils.XYZ_TO_SRGB[2][2] * arg15));
    }

    public static int blueFromArgb(int arg0) {
        return arg0 & 0xFF;
    }

    public static int delinearized(double arg2) {
        arg2 /= 100;
        if(arg2 <= 0.003131) {
            arg2 *= 12.92;
        }
        else {
            arg2 = Math.pow(arg2, 0.416667) * 1.055 - 0.055;
        }

        return MathUtils.clampInt(0, 0xFF, ((int)Math.round(arg2 * 255)));
    }

    public static int greenFromArgb(int arg0) {
        return arg0 >> 8 & 0xFF;
    }

    public static boolean isOpaque(int arg1) {
        if(ColorUtils.alphaFromArgb(arg1) >= 0xFF) {
            return 1;
        }

        return 0;
    }

    static double labF(double arg2) {
        if(arg2 > 0.008856) {
            return Math.pow(arg2, 0.333333);
        }

        return (arg2 * 903.296296 + 16) / 116;
    }

    public static double[] labFromArgb(int arg17) {
        double v0 = ColorUtils.linearized(ColorUtils.redFromArgb(arg17));
        double v2 = ColorUtils.linearized(ColorUtils.greenFromArgb(arg17));
        double v4 = ColorUtils.linearized(ColorUtils.blueFromArgb(arg17));
        double[][] v6 = ColorUtils.SRGB_TO_XYZ;
        double v9 = v6[0][0] * v0 + v6[0][1] * v2 + v6[0][2] * v4;
        double v13 = v6[1][0] * v0 + v6[1][1] * v2 + v6[1][2] * v4;
        double v15 = v6[2][0] * v0 + v6[2][1] * v2 + v6[2][2] * v4;
        double[] v0_1 = ColorUtils.WHITE_POINT_D65;
        v9 /= v0_1[0];
        v13 /= v0_1[1];
        v15 /= v0_1[2];
        v0 = ColorUtils.labF(v9);
        v2 = ColorUtils.labF(v13);
        return new double[]{116 * v2 - 16, (v0 - v2) * 500, (v2 - ColorUtils.labF(v15)) * 200};
    }

    static double labInvf(double arg4) {
        double v0 = arg4 * arg4 * arg4;
        if(v0 > 0.008856) {
            return v0;
        }

        return (arg4 * 116 - 16) / 903.296296;
    }

    public static double linearized(int arg6) {
        double v0 = (((double)arg6)) / 255;
        double v2 = 100;
        if(Double.compare(v0, 0.04045) <= 0) {
            v0 /= 12.92;
        }
        else {
            v0 = Math.pow((v0 + 0.055) / 1.055, 2.4);
        }

        return v0 * v2;
    }

    public static double lstarFromArgb(int arg4) {
        return ColorUtils.labF(ColorUtils.xyzFromArgb(arg4)[1] / 100) * 116 - 16;
    }

    public static double lstarFromY(double arg2) {
        return ColorUtils.labF(arg2 / 100) * 116 - 16;
    }

    public static int redFromArgb(int arg0) {
        return arg0 >> 16 & 0xFF;
    }

    public static double[] whitePointD65() {
        return ColorUtils.WHITE_POINT_D65;
    }

    public static double[] xyzFromArgb(int arg7) {
        return MathUtils.matrixMultiply(new double[]{ColorUtils.linearized(ColorUtils.redFromArgb(arg7)), ColorUtils.linearized(ColorUtils.greenFromArgb(arg7)), ColorUtils.linearized(ColorUtils.blueFromArgb(arg7))}, ColorUtils.SRGB_TO_XYZ);
    }

    public static double yFromLstar(double arg2) {
        return ColorUtils.labInvf((arg2 + 16) / 116) * 100;
    }
}

