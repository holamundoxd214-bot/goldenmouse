package com.google.android.material.color.utilities;

public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4;
    public static final double RATIO_30 = 3;
    public static final double RATIO_45 = 4.5;
    public static final double RATIO_70 = 7;
    public static final double RATIO_MAX = 21;
    public static final double RATIO_MIN = 1;

    private Contrast() {
        super();
    }

    public static double darker(double arg11, double arg13) {
        double v0 = 0;
        double v3 = -1;
        if(Double.compare(arg11, v0) >= 0) {
            double v5 = 100;
            if(arg11 > v5) {
            }
            else {
                arg11 = ColorUtils.yFromLstar(arg11);
                double v9 = (arg11 + 5) / arg13 - 5;
                if(v9 >= v0) {
                    if(v9 > v5) {
                    }
                    else {
                        arg11 = Contrast.ratioOfYs(arg11, v9);
                        double v7 = Math.abs(arg11 - arg13);
                        if(arg11 < arg13 && v7 > 0.04) {
                            return v3;
                        }

                        arg11 = ColorUtils.lstarFromY(v9) - 0.4;
                        if(arg11 < v0) {
                            return v3;
                        }

                        if(arg11 > v5) {
                            return v3;
                        }

                        return arg11;
                    }
                }
            }
        }

        return v3;
    }

    public static double darkerUnsafe(double arg0, double arg2) {
        return Math.max(0, Contrast.darker(arg0, arg2));
    }

    public static double lighter(double arg11, double arg13) {
        double v0 = 0;
        double v3 = -1;
        if(Double.compare(arg11, v0) >= 0) {
            double v5 = 100;
            if(arg11 > v5) {
            }
            else {
                arg11 = ColorUtils.yFromLstar(arg11);
                double v9 = (arg11 + 5) * arg13 - 5;
                if(v9 >= v0) {
                    if(v9 > v5) {
                    }
                    else {
                        arg11 = Contrast.ratioOfYs(v9, arg11);
                        double v7 = Math.abs(arg11 - arg13);
                        if(arg11 < arg13 && v7 > 0.04) {
                            return v3;
                        }

                        arg11 = ColorUtils.lstarFromY(v9) + 0.4;
                        if(arg11 < v0) {
                            return v3;
                        }

                        if(arg11 > v5) {
                            return v3;
                        }

                        return arg11;
                    }
                }
            }
        }

        return v3;
    }

    public static double lighterUnsafe(double arg0, double arg2) {
        arg0 = Contrast.lighter(arg0, arg2);
        if(arg0 < 0) {
            arg0 = 100;
        }

        return arg0;
    }

    public static double ratioOfTones(double arg0, double arg2) {
        return Contrast.ratioOfYs(ColorUtils.yFromLstar(arg0), ColorUtils.yFromLstar(arg2));
    }

    public static double ratioOfYs(double arg3, double arg5) {
        double v0 = Math.max(arg3, arg5);
        if(v0 == arg5) {
        }
        else {
            arg3 = arg5;
        }

        return (v0 + 5) / (arg3 + 5);
    }
}

