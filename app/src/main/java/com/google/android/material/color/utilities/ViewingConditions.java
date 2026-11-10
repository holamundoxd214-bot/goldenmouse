package com.google.android.material.color.utilities;

public final class ViewingConditions {
    public static final ViewingConditions DEFAULT;
    private final double aw;
    private final double c;
    private final double fl;
    private final double flRoot;
    private final double n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;
    private final double z;

    static {
        ViewingConditions.DEFAULT = ViewingConditions.defaultWithBackgroundLstar(50);
    }

    private ViewingConditions(double arg1, double arg3, double arg5, double arg7, double arg9, double arg11, double[] arg13, double arg14, double arg16, double arg18) {
        super();
        this.n = arg1;
        this.aw = arg3;
        this.nbb = arg5;
        this.ncb = arg7;
        this.c = arg9;
        this.nc = arg11;
        this.rgbD = arg13;
        this.fl = arg14;
        this.flRoot = arg16;
        this.z = arg18;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double arg8) {
        return ViewingConditions.make(ColorUtils.whitePointD65(), ColorUtils.yFromLstar(50) * 63.661977 / 100, arg8, 2, false);
    }

    public double getAw() {
        return this.aw;
    }

    double getC() {
        return this.c;
    }

    double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.n;
    }

    public double getNbb() {
        return this.nbb;
    }

    double getNc() {
        return this.nc;
    }

    double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    double getZ() {
        return this.z;
    }

    public static ViewingConditions make(double[] arg43, double arg44, double arg46, double arg48, boolean arg50) {
        double v25;
        double v0 = arg44;
        double v2 = 0.1;
        double v4 = Math.max(v2, arg46);
        double[][] v6 = Cam16.XYZ_TO_CAM16RGB;
        double v8 = arg43[0];
        double[] v10 = v6[0];
        double v11 = v10[0] * v8;
        double v14 = arg43[1];
        v11 += v10[1] * v14;
        int v16 = 2;
        double v17 = arg43[v16];
        v11 += v10[v16] * v17;
        double v19 = v6[1][0] * v8 + v6[1][1] * v14 + v6[1][v16] * v17;
        v8 = v8 * v6[v16][0] + v14 * v6[v16][1] + v17 * v6[v16][v16];
        v14 = 10;
        double v21 = 0.8;
        double v34 = arg48 / v14 + v21;
        v17 = 0.9;
        v14 = v34 >= v17 ? MathUtils.lerp(0.59, 0.69, (v34 - v17) * v14) : MathUtils.lerp(0.525, 0.59, (v34 - v21) * v14);
        double v32 = v14;
        v14 = 1;
        if(arg50) {
            v17 = v2;
            v25 = v14;
        }
        else {
            v17 = v2;
            v25 = (v14 - Math.exp((-v0 - 42) / 92) * 0.277778) * v34;
        }

        v2 = MathUtils.clampDouble(0, 1, v25);
        double v23 = 100 / v11 * v2 + v14 - v2;
        v25 = 100 / v19 * v2 + v14 - v2;
        double v27 = 100 / v8 * v2 + v14 - v2;
        double[] v3 = new double[3];
        v3[0] = v23;
        v3[1] = v25;
        v3[v16] = v27;
        v23 = 5 * v0;
        v25 = v14 / (v23 + v14);
        v27 = v25 * v25 * v25 * v25;
        v14 -= v27;
        v0 = v27 * v0 + v14 * v17 * v14 * Math.cbrt(v23);
        v4 = ColorUtils.yFromLstar(v4) / arg43[1];
        double v41 = Math.sqrt(v4) + 1.48;
        double v28 = 0.725 / Math.pow(v4, 0.2);
        v14 = Math.pow(v3[0] * v0 * v11 / 100, 0.42);
        double v6_1 = Math.pow(v3[1] * v0 * v19 / 100, 0.42);
        v8 = Math.pow(v3[v16] * v0 * v8 / 100, 0.42);
        v10 = new double[3];
        v10[0] = v14;
        v10[1] = v6_1;
        v10[v16] = v8;
        v11 = v10[0] * 400 / (v10[0] + 27.13);
        v17 = v10[1] * 400 / (v10[1] + 27.13);
        v8 = 400 * v10[v16] / (v10[v16] + 27.13);
        double[] v2_1 = new double[3];
        v2_1[0] = v11;
        v2_1[1] = v17;
        v2_1[v16] = v8;
        return new ViewingConditions(v4, (v2_1[0] * 2 + v2_1[1] + v2_1[v16] * 0.05) * v28, v28, v28, v32, v34, v3, v0, Math.pow(v0, 0.25), v41);
    }
}

