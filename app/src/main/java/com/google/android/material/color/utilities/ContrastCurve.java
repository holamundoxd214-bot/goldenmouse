package com.google.android.material.color.utilities;

public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double arg1, double arg3, double arg5, double arg7) {
        super();
        this.low = arg1;
        this.normal = arg3;
        this.medium = arg5;
        this.high = arg7;
    }

    public double getContrast(double arg14) {
        double v0 = -1;
        if(arg14 <= v0) {
            return this.low;
        }

        double v2 = 0;
        double v5 = 1;
        if(Double.compare(arg14, v2) < 0) {
            return MathUtils.lerp(this.low, this.normal, (arg14 - v0) / v5);
        }

        v0 = 0.5;
        if(arg14 < v0) {
            return MathUtils.lerp(this.normal, this.medium, (arg14 - v2) / v0);
        }

        if(arg14 < v5) {
            return MathUtils.lerp(this.medium, this.high, (arg14 - v0) / v0);
        }

        return this.high;
    }
}

