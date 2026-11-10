package com.google.android.material.color.utilities;

public final class Cam16 {
    static final double[][] CAM16RGB_TO_XYZ;
    static final double[][] XYZ_TO_CAM16RGB;
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;
    private final double j;
    private final double jstar;
    private final double m;
    private final double q;
    private final double s;
    private final double[] tempArray;

    static {
        Cam16.XYZ_TO_CAM16RGB = new double[][]{new double[]{0.401288, 0.650173, -0.051461}, new double[]{-0.250268, 1.204414, 0.045854}, new double[]{-0.002079, 0.048952, 0.953127}};
        Cam16.CAM16RGB_TO_XYZ = new double[][]{new double[]{1.862068, -1.011255, 0.149187}, new double[]{0.387527, 0.621447, -0.008974}, new double[]{-0.015842, -0.034123, 1.049964}};
    }

    private Cam16(double arg2, double arg4, double arg6, double arg8, double arg10, double arg12, double arg14, double arg16, double arg18) {
        super();
        this.tempArray = new double[]{0, 0, 0};
        this.hue = arg2;
        this.chroma = arg4;
        this.j = arg6;
        this.q = arg8;
        this.m = arg10;
        this.s = arg12;
        this.jstar = arg14;
        this.astar = arg16;
        this.bstar = arg18;
    }

    double distance(Cam16 arg7) {
        double v0 = this.getJstar() - arg7.getJstar();
        double v2 = this.getAstar() - arg7.getAstar();
        double v4 = this.getBstar() - arg7.getBstar();
        return Math.pow(Math.sqrt(v0 * v0 + v2 * v2 + v4 * v4), 0.63) * 1.41;
    }

    public static Cam16 fromInt(int arg1) {
        return Cam16.fromIntInViewingConditions(arg1, ViewingConditions.DEFAULT);
    }

    static Cam16 fromIntInViewingConditions(int arg18, ViewingConditions arg19) {
        double v3 = ColorUtils.linearized((0xFF0000 & arg18) >> 16);
        double v1 = ColorUtils.linearized((0xFF00 & arg18) >> 8);
        double v5 = ColorUtils.linearized(arg18 & 0xFF);
        return Cam16.fromXyzInViewingConditions(0.412339 * v3 + 0.357621 * v1 + 0.18051 * v5, 0.2126 * v3 + 0.7152 * v1 + 0.0722 * v5, v3 * 0.019321 + v1 * 0.119164 + v5 * 0.950345, arg19);
    }

    static Cam16 fromJch(double arg7, double arg9, double arg11) {
        return Cam16.fromJchInViewingConditions(arg7, arg9, arg11, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double arg27, double arg29, double arg31, ViewingConditions arg33) {
        double v4 = arg27 / 100;
        double v15 = 4 / arg33.getC() * Math.sqrt(v4) * (arg33.getAw() + 4) * arg33.getFlRoot();
        double v17 = arg29 * arg33.getFlRoot();
        double v19 = Math.sqrt(arg29 / Math.sqrt(v4) * arg33.getC() / (arg33.getAw() + 4)) * 50;
        double v0 = Math.toRadians(arg31);
        double v2 = Math.log1p(0.0228 * v17) * 43.859649;
        return new Cam16(arg31, arg29, arg27, v15, v17, v19, 1.7 * arg27 / (0.007 * arg27 + 1), v2 * Math.cos(v0), v2 * Math.sin(v0));
    }

    public static Cam16 fromUcs(double arg7, double arg9, double arg11) {
        return Cam16.fromUcsInViewingConditions(arg7, arg9, arg11, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double arg4, double arg6, double arg8, ViewingConditions arg10) {
        double v0 = Math.expm1(Math.hypot(arg6, arg8) * 0.0228) / 0.0228 / arg10.getFlRoot();
        arg6 = Math.atan2(arg8, arg6) * 57.29578;
        if(arg6 < 0) {
            arg6 += 360;
        }

        return Cam16.fromJchInViewingConditions(arg4 / (1 - (arg4 - 100) * 0.007), v0, arg6, arg10);
    }

    static Cam16 fromXyzInViewingConditions(double arg35, double arg37, double arg39, ViewingConditions arg41) {
        double[][] v0 = Cam16.XYZ_TO_CAM16RGB;
        double v3 = v0[0][0] * arg35 + v0[0][1] * arg37 + v0[0][2] * arg39;
        double v7 = v0[1][0] * arg35 + v0[1][1] * arg37 + v0[1][2] * arg39;
        double v9 = v0[2][0] * arg35 + v0[2][1] * arg37 + v0[2][2] * arg39;
        double v1 = arg41.getRgbD()[0] * v3;
        v3 = arg41.getRgbD()[1] * v7;
        double v5 = arg41.getRgbD()[2] * v9;
        v7 = Math.pow(arg41.getFl() * Math.abs(v1) / 100, 0.42);
        double v13 = Math.pow(arg41.getFl() * Math.abs(v3) / 100, 0.42);
        arg35 = 100;
        v9 = Math.pow(arg41.getFl() * Math.abs(v5) / arg35, 0.42);
        double v0_1 = Math.signum(v1) * 400 * v7 / (v7 + 27.13);
        double v2 = Math.signum(v3) * 400 * v13 / (v13 + 27.13);
        double v4 = Math.signum(v5) * 400 * v9 / (v9 + 27.13);
        double v8 = (v0_1 * 11 + -12 * v2 + v4) / 11;
        double v10 = 2;
        double v6 = (v0_1 + v2 - v4 * v10) / 9;
        v2 *= 20;
        double v14 = (v0_1 * 20 + v2 + 21 * v4) / 20;
        v0_1 = (v0_1 * 40 + v2 + v4) / 20;
        v2 = Math.toDegrees(Math.atan2(v6, v8));
        double v12 = 360;
        if(Double.compare(v2, 0) < 0) {
            v2 += v12;
        }
        else if(v2 >= v12) {
            v2 -= v12;
        }

        double v17 = v2;
        v2 = Math.toRadians(v17);
        double v21 = Math.pow(v0_1 * arg41.getNbb() / arg41.getAw(), arg41.getC() * arg41.getZ()) * arg35;
        v4 = 4;
        double v19 = v21 / arg35;
        double v23 = arg41.getFlRoot() * (v4 / arg41.getC() * Math.sqrt(v19) * (arg41.getAw() + v4));
        v12 = v17 < 20.14 ? v17 + v12 : v17;
        v6 = Math.pow(1.64 - Math.pow(0.29, arg41.getN()), 0.73) * Math.pow((Math.cos(Math.toRadians(v12) + v10) + 3.8) * 0.25 * 3846.153846 * arg41.getNc() * arg41.getNcb() * Math.hypot(v8, v6) / (v14 + 0.305), 0.9);
        v19 = v6 * Math.sqrt(v19);
        double v25 = v19 * arg41.getFlRoot();
        double v27 = Math.sqrt(v6 * arg41.getC() / (arg41.getAw() + v4)) * 50;
        v0_1 = Math.log1p(0.0228 * v25) * 43.859649;
        return new Cam16(v17, v19, v21, v23, v25, v27, 1.7 * v21 / (0.007 * v21 + 1), v0_1 * Math.cos(v2), v0_1 * Math.sin(v2));
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.m;
    }

    public double getQ() {
        return this.q;
    }

    public double getS() {
        return this.s;
    }

    public int toInt() {
        return this.viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions arg7) {
        double[] v6 = this.xyzInViewingConditions(arg7, this.tempArray);
        return ColorUtils.argbFromXyz(v6[0], v6[1], v6[2]);
    }

    double[] xyzInViewingConditions(ViewingConditions arg21, double[] arg22) {
        double v2 = 0;
        double v4 = 100;
        double v0 = Double.compare(this.getChroma(), v2) == 0 || this.getJ() == v2 ? v2 : this.getChroma() / Math.sqrt(this.getJ() / v4);
        v0 = Math.pow(v0 / Math.pow(1.64 - Math.pow(0.29, arg21.getN()), 0.73), 1.111111);
        double v6 = Math.toRadians(this.getHue());
        double v8 = (Math.cos(2 + v6) + 3.8) * 0.25;
        double v10 = arg21.getAw() * Math.pow(this.getJ() / v4, 1 / arg21.getC() / arg21.getZ());
        v8 = v8 * 3846.153846 * arg21.getNc() * arg21.getNcb();
        v10 /= arg21.getNbb();
        double v12 = Math.sin(v6);
        v6 = Math.cos(v6);
        double v14 = (0.305 + v10) * 23 * v0 / (v8 * 23 + 11 * v0 * v6 + v0 * 108 * v12);
        v6 *= v14;
        v14 *= v12;
        v10 *= 460;
        v0 = (451 * v6 + v10 + 288 * v14) / 1403;
        v12 = (v10 - 891 * v6 - 261 * v14) / 1403;
        v10 = (v10 - v6 * 220 - v14 * 6300) / 1403;
        v0 = Math.signum(v0) * (v4 / arg21.getFl()) * Math.pow(Math.max(v2, Math.abs(v0) * 27.13 / (400 - Math.abs(v0))), 2.380952);
        v12 = Math.signum(v12) * (v4 / arg21.getFl()) * Math.pow(Math.max(v2, Math.abs(v12) * 27.13 / (400 - Math.abs(v12))), 2.380952);
        v6 = Math.signum(v10) * (v4 / arg21.getFl()) * Math.pow(Math.max(v2, Math.abs(v10) * 27.13 / (400 - Math.abs(v10))), 2.380952);
        v0 /= arg21.getRgbD()[0];
        v12 /= arg21.getRgbD()[1];
        int v5 = 2;
        v6 /= arg21.getRgbD()[v5];
        double[][] v2_1 = Cam16.CAM16RGB_TO_XYZ;
        double v9 = v2_1[0][0] * v0 + v2_1[0][1] * v12 + v2_1[0][v5] * v6;
        v14 = v2_1[1][0] * v0 + v2_1[1][1] * v12 + v2_1[1][v5] * v6;
        v0 = v0 * v2_1[v5][0] + v12 * v2_1[v5][1] + v6 * v2_1[v5][v5];
        if(arg22 != null) {
            arg22[0] = v9;
            arg22[1] = v14;
            arg22[v5] = v0;
            return arg22;
        }

        double[] v2_2 = new double[3];
        v2_2[0] = v9;
        v2_2[1] = v14;
        v2_2[v5] = v0;
        return v2_2;
    }
}

