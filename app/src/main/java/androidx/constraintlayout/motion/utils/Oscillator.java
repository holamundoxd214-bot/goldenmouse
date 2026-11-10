package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    double PI2;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    private boolean mNormalized;
    float[] mPeriod;
    double[] mPosition;
    int mType;

    static {
    }

    public Oscillator() {
        super();
        this.mPeriod = new float[0];
        this.mPosition = new double[0];
        this.PI2 = 6.283185;
        this.mNormalized = false;
    }

    public void addPoint(double arg5, float arg7) {
        int v0 = this.mPeriod.length + 1;
        int v1 = Arrays.binarySearch(this.mPosition, arg5);
        if(v1 < 0) {
            v1 = -v1 - 1;
        }

        this.mPosition = Arrays.copyOf(this.mPosition, v0);
        this.mPeriod = Arrays.copyOf(this.mPeriod, v0);
        this.mArea = new double[v0];
        System.arraycopy(this.mPosition, v1, this.mPosition, v1 + 1, v0 - v1 - 1);
        this.mPosition[v1] = arg5;
        this.mPeriod[v1] = arg7;
        this.mNormalized = false;
    }

    double getDP(double arg8) {
        double v0 = 0;
        if(arg8 <= v0) {
            arg8 = 0.00001;
        }
        else if(arg8 >= 1) {
            arg8 = 0.999999;
        }

        int v2 = Arrays.binarySearch(this.mPosition, arg8);
        if(v2 > 0) {
            return v0;
        }

        if(v2 != 0) {
            int v0_1 = -v2;
            int v1 = v0_1 - 1;
            float[] v2_1 = this.mPeriod;
            float v3 = v2_1[v1];
            v0_1 += -2;
            float v2_2 = v2_1[v0_1];
            double[] v7 = this.mPosition;
            double v3_1 = (((double)(v3 - v2_2))) / (v7[v1] - v7[v0_1]);
            return arg8 * v3_1 + ((((double)v2_2)) - v3_1 * v7[v0_1]);
        }

        return v0;
    }

    double getP(double arg13) {
        double v0 = 0;
        double v3 = 1;
        if(Double.compare(arg13, v0) < 0) {
            arg13 = v0;
        }
        else if(arg13 > v3) {
            arg13 = v3;
        }

        int v2 = Arrays.binarySearch(this.mPosition, arg13);
        if(v2 > 0) {
            return v3;
        }

        if(v2 != 0) {
            int v0_1 = -v2;
            int v1 = v0_1 - 1;
            float[] v2_1 = this.mPeriod;
            float v3_1 = v2_1[v1];
            v0_1 += -2;
            float v2_2 = v2_1[v0_1];
            double[] v5 = this.mPosition;
            v3 = (((double)(v3_1 - v2_2))) / (v5[v1] - v5[v0_1]);
            v0 = this.mArea[v0_1] + ((((double)v2_2)) - v3 * v5[v0_1]) * (arg13 - v5[v0_1]) + v3 * (arg13 * arg13 - v5[v0_1] * v5[v0_1]) / 2;
        }

        return v0;
    }

    public double getSlope(double arg10) {
        double v1 = 2;
        double v3 = 4;
        switch(this.mType) {
            case 1: {
                return 0;
            }
            case 2: {
                goto label_37;
            }
            case 3: {
                goto label_35;
            }
            case 4: {
                goto label_31;
            }
            case 5: {
                goto label_22;
            }
            case 6: {
                goto label_13;
            }
        }

        double v0 = this.PI2 * this.getDP(arg10);
        double v9 = Math.cos(this.PI2 * this.getP(arg10));
        goto label_11;
    label_35:
        v9 = this.getDP(arg10);
        goto label_33;
    label_37:
        double v5 = this.getDP(arg10) * v3;
        v9 = Math.signum((this.getP(arg10) * v3 + 3) % v3 - v1);
        goto label_20;
    label_22:
        v0 = -this.PI2 * this.getDP(arg10);
        v9 = Math.sin(this.PI2 * this.getP(arg10));
    label_11:
        return v0 * v9;
    label_13:
        v5 = this.getDP(arg10) * v3;
        v9 = (this.getP(arg10) * v3 + v1) % v3 - v1;
    label_20:
        return v5 * v9;
    label_31:
        v9 = -this.getDP(arg10);
    label_33:
        return v9 * v1;
    }

    public double getValue(double arg8) {
        double v1 = 4;
        double v3 = 2;
        double v5 = 1;
        switch(this.mType) {
            case 1: {
                goto label_42;
            }
            case 2: {
                goto label_35;
            }
            case 3: {
                goto label_29;
            }
            case 4: {
                goto label_24;
            }
            case 5: {
                goto label_19;
            }
            case 6: {
                goto label_10;
            }
        }

        return Math.sin(this.PI2 * this.getP(arg8));
    label_35:
        double v7 = Math.abs((this.getP(arg8) * v1 + v5) % v1 - v3);
        goto label_17;
    label_19:
        return Math.cos(this.PI2 * this.getP(arg8));
    label_24:
        v7 = (this.getP(arg8) * v3 + v5) % v3;
        goto label_17;
    label_42:
        return Math.signum(0.5 - this.getP(arg8) % v5);
    label_10:
        v7 = v5 - Math.abs(this.getP(arg8) * v1 % v1 - v3);
        v7 *= v7;
    label_17:
        return v5 - v7;
    label_29:
        return (this.getP(arg8) * v3 + v5) % v3 - v5;
    }

    public void normalize() {
        float v12;
        float[] v10;
        Oscillator v0 = this;
        double v1 = 0;
        double v5 = v1;
        int v4;
        for(v4 = 0; true; ++v4) {
            float[] v7 = v0.mPeriod;
            if(v4 >= v7.length) {
                break;
            }

            v5 += ((double)v7[v4]);
        }

        double v8 = v1;
        int v7_1;
        for(v7_1 = 1; true; ++v7_1) {
            v10 = v0.mPeriod;
            v12 = 2f;
            if(v7_1 >= v10.length) {
                break;
            }

            int v11 = v7_1 - 1;
            v8 += (v0.mPosition[v7_1] - v0.mPosition[v11]) * (((double)((v10[v11] + v10[v7_1]) / v12)));
        }

        for(v7_1 = 0; true; ++v7_1) {
            v10 = v0.mPeriod;
            if(v7_1 >= v10.length) {
                break;
            }

            v10[v7_1] = ((float)((((double)v10[v7_1])) * (v5 / v8)));
        }

        v0.mArea[0] = v1;
        int v1_1;
        for(v1_1 = 1; true; ++v1_1) {
            float[] v2 = v0.mPeriod;
            if(v1_1 >= v2.length) {
                break;
            }

            int v3 = v1_1 - 1;
            v0.mArea[v1_1] = v0.mArea[v3] + (v0.mPosition[v1_1] - v0.mPosition[v3]) * (((double)((v2[v3] + v2[v1_1]) / v12)));
        }

        v0.mNormalized = true;
    }

    public void setType(int arg1) {
        this.mType = arg1;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}

