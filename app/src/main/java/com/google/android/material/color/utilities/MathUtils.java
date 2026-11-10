package com.google.android.material.color.utilities;

public class MathUtils {
    private MathUtils() {
        super();
    }

    public static double clampDouble(double arg1, double arg3, double arg5) {
        if(arg5 < arg1) {
            return arg1;
        }

        if(arg5 > arg3) {
            return arg3;
        }

        return arg5;
    }

    public static int clampInt(int arg0, int arg1, int arg2) {
        if(arg2 < arg0) {
            return arg0;
        }

        if(arg2 > arg1) {
            return arg1;
        }

        return arg2;
    }

    public static double differenceDegrees(double arg0, double arg2) {
        return 180 - Math.abs(Math.abs(arg0 - arg2) - 180);
    }

    public static double lerp(double arg2, double arg4, double arg6) {
        return (1 - arg6) * arg2 + arg6 * arg4;
    }

    public static double[] matrixMultiply(double[] arg16, double[][] arg17) {
        return new double[]{arg17[0][0] * arg16[0] + arg17[0][1] * arg16[1] + arg17[0][2] * arg16[2], arg17[1][0] * arg16[0] + arg17[1][1] * arg16[1] + arg17[1][2] * arg16[2], arg16[0] * arg17[2][0] + arg16[1] * arg17[2][1] + arg16[2] * arg17[2][2]};
    }

    public static double rotationDirection(double arg0, double arg2) {
        if(MathUtils.sanitizeDegreesDouble(arg2 - arg0) <= 180) {
            return 1;
        }

        return -1;
    }

    public static double sanitizeDegreesDouble(double arg4) {
        double v0 = 360;
        arg4 %= v0;
        if(arg4 < 0) {
            arg4 += v0;
        }

        return arg4;
    }

    public static int sanitizeDegreesInt(int arg0) {
        arg0 %= 360;
        if(arg0 < 0) {
            arg0 += 360;
        }

        return arg0;
    }

    public static int signum(double arg3) {
        double v0 = 0;
        if(arg3 < v0) {
            return -1;
        }

        if(arg3 == v0) {
            return 0;
        }

        return 1;
    }
}

