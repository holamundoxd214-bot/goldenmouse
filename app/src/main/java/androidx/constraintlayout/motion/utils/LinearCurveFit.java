package androidx.constraintlayout.motion.utils;

public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] arg12, double[][] arg13) {
        super();
        this.mTotalLength = NaN;
        int v1 = arg13[0].length;
        this.mT = arg12;
        this.mY = arg13;
        if(v1 > 2) {
            double v1_1 = 0;
            int v3 = 0;
            double v4;
            for(v4 = v1_1; true; v4 = v9) {
                double v6 = v4;
                if(v3 >= arg12.length) {
                    break;
                }

                double v9 = arg13[v3][0];
                if(v3 > 0) {
                    Math.hypot(v9 - v4, v9 - v6);
                }

                ++v3;
            }

            this.mTotalLength = v1_1;
        }
    }

    private double getLength2D(double arg21) {
        LinearCurveFit v0 = this;
        double v2 = 0;
        if(Double.isNaN(v0.mTotalLength)) {
            return v2;
        }

        double[] v1 = v0.mT;
        int v4 = v1.length;
        if(arg21 <= v1[0]) {
            return v2;
        }

        --v4;
        if(arg21 >= v1[v4]) {
            return v0.mTotalLength;
        }

        double v7 = v2;
        double v9 = v7;
        double v11 = v9;
        int v1_1 = 0;
        while(v1_1 < v4) {
            double[] v13 = v0.mY[v1_1];
            double v14 = v13[0];
            double v16 = v13[1];
            if(v1_1 > 0) {
                v7 += Math.hypot(v14 - v9, v16 - v11);
            }

            double[] v9_1 = v0.mT;
            double v10 = v9_1[v1_1];
            if(arg21 == v10) {
                return v7;
            }

            int v12 = v1_1 + 1;
            double v18 = v9_1[v12];
            if(arg21 < v18) {
                v2 = (arg21 - v10) / (v18 - v10);
                double[][] v0_1 = v0.mY;
                v1 = v0_1[v1_1];
                v9 = v1[0];
                double[] v0_2 = v0_1[v12];
                double v4_1 = v0_2[0];
                v11 = v1[1];
                v18 = v0_2[1];
                double v0_3 = 1 - v2;
                return v7 + Math.hypot(v16 - (v11 * v0_3 + v18 * v2), v14 - (v9 * v0_3 + v4_1 * v2));
            }

            v1_1 = v12;
            v9 = v14;
            v11 = v16;
        }

        return v2;
    }

    public double getPos(double arg9, int arg11) {
        double[] v0 = this.mT;
        int v1 = v0.length;
        int v2 = 0;
        if(arg9 <= v0[0]) {
            return this.mY[0][arg11];
        }

        --v1;
        if(arg9 >= v0[v1]) {
            return this.mY[v1][arg11];
        }

        while(v2 < v1) {
            v0 = this.mT;
            double v3 = v0[v2];
            if(arg9 == v3) {
                return this.mY[v2][arg11];
            }

            int v5 = v2 + 1;
            double v6 = v0[v5];
            if(arg9 < v6) {
                arg9 = (arg9 - v3) / (v6 - v3);
                return this.mY[v2][arg11] * (1 - arg9) + this.mY[v5][arg11] * arg9;
            }

            v2 = v5;
        }

        return 0;
    }

    public void getPos(double arg13, double[] arg15) {
        double[] v0 = this.mT;
        int v1 = v0.length;
        int v3 = 0;
        int v2 = this.mY[0].length;
        if(arg13 <= v0[0]) {
            int v13;
            for(v13 = 0; v13 < v2; ++v13) {
                arg15[v13] = this.mY[0][v13];
            }
        }
        else {
            --v1;
            if(arg13 >= v0[v1]) {
                while(true) {
                    if(v3 >= v2) {
                        return;
                    }

                    arg15[v3] = this.mY[v1][v3];
                    ++v3;
                }
            }

            int v0_1;
            for(v0_1 = 0; v0_1 < v1; v0_1 = v5) {
                if(arg13 == this.mT[v0_1]) {
                    int v4;
                    for(v4 = 0; v4 < v2; ++v4) {
                        arg15[v4] = this.mY[v0_1][v4];
                    }
                }

                double[] v4_1 = this.mT;
                int v5 = v0_1 + 1;
                double v6 = v4_1[v5];
                if(arg13 < v6) {
                    arg13 = (arg13 - v4_1[v0_1]) / (v6 - v4_1[v0_1]);
                    while(true) {
                        if(v3 >= v2) {
                            return;
                        }

                        arg15[v3] = this.mY[v0_1][v3] * (1 - arg13) + this.mY[v5][v3] * arg13;
                        ++v3;
                    }
                }
            }
        }
    }

    public void getPos(double arg13, float[] arg15) {
        double[] v0 = this.mT;
        int v1 = v0.length;
        int v3 = 0;
        int v2 = this.mY[0].length;
        if(arg13 <= v0[0]) {
            int v13;
            for(v13 = 0; v13 < v2; ++v13) {
                arg15[v13] = ((float)this.mY[0][v13]);
            }
        }
        else {
            --v1;
            if(arg13 >= v0[v1]) {
                while(true) {
                    if(v3 >= v2) {
                        return;
                    }

                    arg15[v3] = ((float)this.mY[v1][v3]);
                    ++v3;
                }
            }

            int v0_1;
            for(v0_1 = 0; v0_1 < v1; v0_1 = v5) {
                if(arg13 == this.mT[v0_1]) {
                    int v4;
                    for(v4 = 0; v4 < v2; ++v4) {
                        arg15[v4] = ((float)this.mY[v0_1][v4]);
                    }
                }

                double[] v4_1 = this.mT;
                int v5 = v0_1 + 1;
                double v6 = v4_1[v5];
                if(arg13 < v6) {
                    arg13 = (arg13 - v4_1[v0_1]) / (v6 - v4_1[v0_1]);
                    while(true) {
                        if(v3 >= v2) {
                            return;
                        }

                        arg15[v3] = ((float)(this.mY[v0_1][v3] * (1 - arg13) + this.mY[v5][v3] * arg13));
                        ++v3;
                    }
                }
            }
        }
    }

    public double getSlope(double arg8, int arg10) {
        double[] v0 = this.mT;
        int v1 = v0.length;
        int v2 = 0;
        double v3 = v0[0];
        if(arg8 >= v3) {
            v3 = v0[v1 - 1];
            if(arg8 >= v3) {
                goto label_5;
            }
        }
        else {
        label_5:
            arg8 = v3;
        }

        while(v2 < v1 - 1) {
            v0 = this.mT;
            int v3_1 = v2 + 1;
            double v4 = v0[v3_1];
            if(arg8 <= v4) {
                return (this.mY[v3_1][arg10] - this.mY[v2][arg10]) / (v4 - v0[v2]);
            }

            v2 = v3_1;
        }

        return 0;
    }

    public void getSlope(double arg13, double[] arg15) {
        double v6;
        int v5;
        double[] v0 = this.mT;
        int v1 = v0.length;
        int v3 = 0;
        int v2 = this.mY[0].length;
        double v4 = v0[0];
        if(arg13 > v4) {
            v4 = v0[v1 - 1];
            if(arg13 >= v4) {
                goto label_8;
            }
        }
        else {
        label_8:
            arg13 = v4;
        }

        int v0_1 = 0;
        while(true) {
            if(v0_1 < v1 - 1) {
                double[] v4_1 = this.mT;
                v5 = v0_1 + 1;
                v6 = v4_1[v5];
                if(arg13 <= v6) {
                    v6 -= v4_1[v0_1];
                    break;
                }
                else {
                    v0_1 = v5;
                    continue;
                }
            }

            return;
        }

        while(v3 < v2) {
            arg15[v3] = (this.mY[v5][v3] - this.mY[v0_1][v3]) / v6;
            ++v3;
        }
    }

    public double[] getTimePoints() {
        return this.mT;
    }
}

