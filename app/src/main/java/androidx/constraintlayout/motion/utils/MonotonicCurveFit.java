package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] arg22, double[][] arg23) {
        double v17;
        Object v15;
        double v13;
        MonotonicCurveFit v0 = this;
        double[] v1 = arg22;
        double[][] v2 = arg23;
        super();
        int v3 = v1.length;
        int v5 = v2[0].length;
        int v6 = v3 - 1;
        int[] v8 = new int[2];
        v8[1] = v5;
        v8[0] = v6;
        Object v8_1 = Array.newInstance(Double.TYPE, v8);
        int[] v10 = new int[2];
        v10[1] = v5;
        v10[0] = v3;
        Object v9 = Array.newInstance(Double.TYPE, v10);
        int v10_1;
        for(v10_1 = 0; v10_1 < v5; ++v10_1) {
            int v11;
            for(v11 = 0; v11 < v6; v11 = v12) {
                int v12 = v11 + 1;
                v13 = v1[v12] - v1[v11];
                v15 = v8_1[v11];
                v17 = (v2[v12][v10_1] - v2[v11][v10_1]) / v13;
                v15[v10_1] = v17;
                v9[v11][v10_1] = v11 == 0 ? v17 : (v8_1[v11 - 1][v10_1] + v17) * 0.5;
            }

            v9[v6][v10_1] = v8_1[v3 - 2][v10_1];
        }

        for(v3 = 0; v3 < v6; ++v3) {
            int v7;
            for(v7 = 0; v7 < v5; ++v7) {
                double v11_1 = v8_1[v3][v7];
                v13 = 0;
                if(v11_1 == v13) {
                    v9[v3][v7] = v13;
                    v9[v3 + 1][v7] = v13;
                }
                else {
                    v13 = v9[v3][v7] / v11_1;
                    v10_1 = v3 + 1;
                    v11_1 = v9[v10_1][v7] / v11_1;
                    double v15_1 = Math.hypot(v13, v11_1);
                    if(v15_1 > 9) {
                        v17 = 3 / v15_1;
                        v15 = v9[v3];
                        Object v16 = v8_1[v3];
                        v15[v7] = v13 * v17 * v16[v7];
                        v9[v10_1][v7] = v17 * v11_1 * v16[v7];
                    }
                }
            }
        }

        v0.mT = v1;
        v0.mY = v2;
        v0.mTangent = ((double[][])v9);
    }

    private static double diff(double arg10, double arg12, double arg14, double arg16, double arg18, double arg20) {
        double v0 = arg12 * arg12;
        double v6 = arg12 * 6;
        double v2 = -6 * v0 * arg16 + v6 * arg16 + 6 * v0 * arg14 - v6 * arg14;
        arg14 = 3 * arg10;
        return v2 + arg14 * arg20 * v0 + arg14 * arg18 * v0 - 2 * arg10 * arg20 * arg12 - 4 * arg10 * arg18 * arg12 + arg10 * arg18;
    }

    public double getPos(double arg22, int arg24) {
        MonotonicCurveFit v0 = this;
        double[] v1 = v0.mT;
        int v2 = v1.length;
        int v3 = 0;
        if(arg22 <= v1[0]) {
            return v0.mY[0][arg24];
        }

        --v2;
        if(arg22 >= v1[v2]) {
            return v0.mY[v2][arg24];
        }

        while(v3 < v2) {
            v1 = v0.mT;
            double v4 = v1[v3];
            if(arg22 == v4) {
                return v0.mY[v3][arg24];
            }

            int v6 = v3 + 1;
            double v7 = v1[v6];
            if(arg22 < v7) {
                double v9 = v7 - v4;
                return MonotonicCurveFit.interpolate(v9, (arg22 - v4) / v9, v0.mY[v3][arg24], v0.mY[v6][arg24], v0.mTangent[v3][arg24], v0.mTangent[v6][arg24]);
            }

            v3 = v6;
        }

        return 0;
    }

    public void getPos(double arg24, double[] arg26) {
        MonotonicCurveFit v0 = this;
        double[] v1 = v0.mT;
        int v2 = v1.length;
        int v4 = 0;
        int v3 = v0.mY[0].length;
        if(arg24 <= v1[0]) {
            int v1_1;
            for(v1_1 = 0; v1_1 < v3; ++v1_1) {
                arg26[v1_1] = v0.mY[0][v1_1];
            }
        }
        else {
            --v2;
            if(arg24 >= v1[v2]) {
                while(true) {
                    if(v4 >= v3) {
                        return;
                    }

                    arg26[v4] = v0.mY[v2][v4];
                    ++v4;
                }
            }

            for(v1_1 = 0; v1_1 < v2; v1_1 = v6) {
                if(arg24 == v0.mT[v1_1]) {
                    int v5;
                    for(v5 = 0; v5 < v3; ++v5) {
                        arg26[v5] = v0.mY[v1_1][v5];
                    }
                }

                double[] v5_1 = v0.mT;
                int v6 = v1_1 + 1;
                double v7 = v5_1[v6];
                if(arg24 < v7) {
                    double v11 = v7 - v5_1[v1_1];
                    double v13 = (arg24 - v5_1[v1_1]) / v11;
                    while(true) {
                        if(v4 >= v3) {
                            return;
                        }

                        arg26[v4] = MonotonicCurveFit.interpolate(v11, v13, v0.mY[v1_1][v4], v0.mY[v6][v4], v0.mTangent[v1_1][v4], v0.mTangent[v6][v4]);
                        ++v4;
                    }
                }
            }
        }
    }

    public void getPos(double arg24, float[] arg26) {
        MonotonicCurveFit v0 = this;
        double[] v1 = v0.mT;
        int v2 = v1.length;
        int v4 = 0;
        int v3 = v0.mY[0].length;
        if(arg24 <= v1[0]) {
            int v1_1;
            for(v1_1 = 0; v1_1 < v3; ++v1_1) {
                arg26[v1_1] = ((float)v0.mY[0][v1_1]);
            }
        }
        else {
            --v2;
            if(arg24 >= v1[v2]) {
                while(true) {
                    if(v4 >= v3) {
                        return;
                    }

                    arg26[v4] = ((float)v0.mY[v2][v4]);
                    ++v4;
                }
            }

            for(v1_1 = 0; v1_1 < v2; v1_1 = v6) {
                if(arg24 == v0.mT[v1_1]) {
                    int v5;
                    for(v5 = 0; v5 < v3; ++v5) {
                        arg26[v5] = ((float)v0.mY[v1_1][v5]);
                    }
                }

                double[] v5_1 = v0.mT;
                int v6 = v1_1 + 1;
                double v7 = v5_1[v6];
                if(arg24 < v7) {
                    double v11 = v7 - v5_1[v1_1];
                    double v13 = (arg24 - v5_1[v1_1]) / v11;
                    while(true) {
                        if(v4 >= v3) {
                            return;
                        }

                        arg26[v4] = ((float)MonotonicCurveFit.interpolate(v11, v13, v0.mY[v1_1][v4], v0.mY[v6][v4], v0.mTangent[v1_1][v4], v0.mTangent[v6][v4]));
                        ++v4;
                    }
                }
            }
        }
    }

    public double getSlope(double arg24, int arg26) {
        MonotonicCurveFit v0 = this;
        double[] v1 = v0.mT;
        int v2 = v1.length;
        int v3 = 0;
        double v4 = v1[0];
        if(arg24 < v4) {
        }
        else {
            v4 = v1[v2 - 1];
            if(arg24 >= v4) {
            }
            else {
                v4 = arg24;
            }
        }

        while(v3 < v2 - 1) {
            v1 = v0.mT;
            int v6 = v3 + 1;
            double v7 = v1[v6];
            if(v4 <= v7) {
                double v11 = v7 - v1[v3];
                return MonotonicCurveFit.diff(v11, (v4 - v1[v3]) / v11, v0.mY[v3][arg26], v0.mY[v6][arg26], v0.mTangent[v3][arg26], v0.mTangent[v6][arg26]) / v11;
            }

            v3 = v6;
        }

        return 0;
    }

    public void getSlope(double arg26, double[] arg28) {
        double v15;
        double v13;
        int v8;
        MonotonicCurveFit v0 = this;
        double[] v1 = v0.mT;
        int v2 = v1.length;
        int v4 = 0;
        int v3 = v0.mY[0].length;
        double v5 = v1[0];
        if(arg26 <= v5) {
        }
        else {
            v5 = v1[v2 - 1];
            if(arg26 >= v5) {
            }
            else {
                v5 = arg26;
            }
        }

        int v1_1 = 0;
        while(true) {
            if(v1_1 < v2 - 1) {
                double[] v7 = v0.mT;
                v8 = v1_1 + 1;
                double v9 = v7[v8];
                if(v5 <= v9) {
                    v13 = v9 - v7[v1_1];
                    v15 = (v5 - v7[v1_1]) / v13;
                    break;
                }
                else {
                    v1_1 = v8;
                    continue;
                }
            }

            return;
        }

        while(v4 < v3) {
            arg28[v4] = MonotonicCurveFit.diff(v13, v15, v0.mY[v1_1][v4], v0.mY[v8][v4], v0.mTangent[v1_1][v4], v0.mTangent[v8][v4]) / v13;
            ++v4;
        }
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    private static double interpolate(double arg12, double arg14, double arg16, double arg18, double arg20, double arg22) {
        double v0 = arg14 * arg14;
        double v2 = v0 * arg14;
        double v6 = 3 * v0;
        double v4 = -2 * v2 * arg18 + v6 * arg18 + v2 * 2 * arg16 - v6 * arg16 + arg16;
        v6 = arg12 * arg22;
        double v10 = arg12 * arg20;
        return v4 + v6 * v2 + v2 * v10 - v6 * v0 - arg12 * 2 * arg20 * v0 + v10 * arg14;
    }
}

