package com.google.android.material.color.utilities;

public final class PointProviderLab implements PointProvider {
    public PointProviderLab() {
        super();
    }

    public double distance(double[] arg7, double[] arg8) {
        double v0 = arg7[0] - arg8[0];
        double v2 = arg7[1] - arg8[1];
        double v4 = arg7[2] - arg8[2];
        return v0 * v0 + v2 * v2 + v4 * v4;
    }

    public double[] fromInt(int arg9) {
        double[] v8 = ColorUtils.labFromArgb(arg9);
        return new double[]{v8[0], v8[1], v8[2]};
    }

    public int toInt(double[] arg7) {
        return ColorUtils.argbFromLab(arg7[0], arg7[1], arg7[2]);
    }
}

