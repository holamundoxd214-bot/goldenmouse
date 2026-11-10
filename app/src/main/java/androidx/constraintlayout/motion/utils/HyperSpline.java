package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

public class HyperSpline {
    public class Cubic {
        public static final double HALF = 0.5;
        public static final double THIRD = 0.333333;
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double arg1, double arg3, double arg5, double arg7) {
            super();
            this.mA = arg1;
            this.mB = arg3;
            this.mC = arg5;
            this.mD = arg7;
        }

        public double eval(double arg5) {
            return ((this.mD * arg5 + this.mC) * arg5 + this.mB) * arg5 + this.mA;
        }

        public double vel(double arg7) {
            return (this.mD * 0.333333 * arg7 + this.mC * 0.5) * arg7 + this.mB;
        }
    }

    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public HyperSpline() {
        super();
    }

    public HyperSpline(double[][] arg1) {
        super();
        this.setup(arg1);
    }

    public double approxLength(Cubic[] arg15) {
        double v10;
        int v9;
        double v6;
        double[] v14 = new double[arg15.length];
        double v0 = 0;
        double v2 = v0;
        double v4 = v2;
        while(true) {
            v6 = 1;
            v9 = 0;
            if(Double.compare(v2, v6) < 0) {
                v6 = v0;
                while(v9 < arg15.length) {
                    v10 = v14[v9];
                    double v12 = arg15[v9].eval(v2);
                    v14[v9] = v12;
                    v10 -= v12;
                    v6 += v10 * v10;
                    ++v9;
                }

                if(v2 > v0) {
                    v4 += Math.sqrt(v6);
                }

                v2 += 0.1;
                continue;
            }

            break;
        }

        while(v9 < arg15.length) {
            v2 = v14[v9];
            v10 = arg15[v9].eval(v6);
            v14[v9] = v10;
            v2 -= v10;
            v0 += v2 * v2;
            ++v9;
        }

        return v4 + Math.sqrt(v0);
    }

    static Cubic[] calcNaturalCubic(int arg23, double[] arg24) {
        double v8;
        int v0 = arg23;
        double[] v1 = new double[v0];
        double[] v2 = new double[v0];
        double[] v3 = new double[v0];
        int v4 = v0 - 1;
        int v7 = 0;
        v1[0] = 0.5;
        int v5 = 1;
        int v6;
        for(v6 = 1; true; ++v6) {
            v8 = 1;
            if(v6 >= v4) {
                break;
            }

            v1[v6] = v8 / (4 - v1[v6 - 1]);
        }

        v0 += -2;
        double v12 = 2;
        v1[v4] = v8 / (v12 - v1[v0]);
        double v10 = 3;
        v2[0] = (arg24[1] - arg24[0]) * v10 * v1[0];
        while(v5 < v4) {
            v6 = v5 + 1;
            int v14 = v5 - 1;
            v2[v5] = ((arg24[v6] - arg24[v14]) * v10 - v2[v14]) * v1[v5];
            v5 = v6;
        }

        double v5_1 = ((arg24[v4] - arg24[v0]) * v10 - v2[v0]) * v1[v4];
        v2[v4] = v5_1;
        v3[v4] = v5_1;
        while(v0 >= 0) {
            v3[v0] = v2[v0] - v1[v0] * v3[v0 + 1];
            --v0;
        }

        Cubic[] v0_1 = new Cubic[v4];
        while(v7 < v4) {
            int v8_1 = v7 + 1;
            v0_1[v7] = new Cubic(((double)(((float)arg24[v7]))), v3[v7], (arg24[v8_1] - arg24[v7]) * v10 - v3[v7] * v12 - v3[v8_1], (arg24[v7] - arg24[v8_1]) * v12 + v3[v7] + v3[v8_1]);
            v7 = v8_1;
        }

        return v0_1;
    }

    public double getPos(double arg6, int arg8) {
        double[] v1;
        arg6 *= this.mTotalLength;
        int v0 = 0;
        while(true) {
            v1 = this.mCurveLength;
            if(v0 < v1.length - 1) {
                double v2 = v1[v0];
                if(v2 < arg6) {
                    arg6 -= v2;
                    ++v0;
                    continue;
                }
            }

            break;
        }

        return this.mCurve[arg8][v0].eval(arg6 / v1[v0]);
    }

    public void getPos(double arg7, double[] arg9) {
        arg7 *= this.mTotalLength;
        int v0 = 0;
        int v1 = 0;
        while(true) {
            double[] v2 = this.mCurveLength;
            if(v1 < v2.length - 1) {
                double v3 = v2[v1];
                if(v3 < arg7) {
                    arg7 -= v3;
                    ++v1;
                    continue;
                }
            }

            break;
        }

        while(v0 < arg9.length) {
            arg9[v0] = this.mCurve[v0][v1].eval(arg7 / this.mCurveLength[v1]);
            ++v0;
        }
    }

    public void getPos(double arg7, float[] arg9) {
        arg7 *= this.mTotalLength;
        int v0 = 0;
        int v1 = 0;
        while(true) {
            double[] v2 = this.mCurveLength;
            if(v1 < v2.length - 1) {
                double v3 = v2[v1];
                if(v3 < arg7) {
                    arg7 -= v3;
                    ++v1;
                    continue;
                }
            }

            break;
        }

        while(v0 < arg9.length) {
            arg9[v0] = ((float)this.mCurve[v0][v1].eval(arg7 / this.mCurveLength[v1]));
            ++v0;
        }
    }

    public void getVelocity(double arg7, double[] arg9) {
        arg7 *= this.mTotalLength;
        int v0 = 0;
        int v1 = 0;
        while(true) {
            double[] v2 = this.mCurveLength;
            if(v1 < v2.length - 1) {
                double v3 = v2[v1];
                if(v3 < arg7) {
                    arg7 -= v3;
                    ++v1;
                    continue;
                }
            }

            break;
        }

        while(v0 < arg9.length) {
            arg9[v0] = this.mCurve[v0][v1].vel(arg7 / this.mCurveLength[v1]);
            ++v0;
        }
    }

    public void setup(double[][] arg9) {
        int v1 = arg9[0].length;
        this.mDimensionality = v1;
        int v2 = arg9.length;
        this.mPoints = v2;
        int[] v3 = new int[2];
        v3[1] = v2;
        v3[0] = v1;
        this.mCtl = Array.newInstance(Double.TYPE, v3);
        this.mCurve = new Cubic[this.mDimensionality][];
        for(v1 = 0; v1 < this.mDimensionality; ++v1) {
            for(v2 = 0; v2 < this.mPoints; ++v2) {
                this.mCtl[v1][v2] = arg9[v2][v1];
            }
        }

        int v9;
        for(v9 = 0; true; ++v9) {
            v1 = this.mDimensionality;
            if(v9 >= v1) {
                break;
            }

            this.mCurve[v9] = HyperSpline.calcNaturalCubic(this.mCtl[v9].length, this.mCtl[v9]);
        }

        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0;
        Cubic[] v9_1 = new Cubic[v1];
        for(v1 = 0; v1 < this.mCurveLength.length; ++v1) {
            for(v2 = 0; v2 < this.mDimensionality; ++v2) {
                v9_1[v2] = this.mCurve[v2][v1];
            }

            double v2_1 = this.mTotalLength;
            double[] v4 = this.mCurveLength;
            double v5 = this.approxLength(v9_1);
            v4[v1] = v5;
            this.mTotalLength = v2_1 + v5;
        }
    }
}

