package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

class ArcCurveFit extends CurveFit {
    class Arc {
        private static final double EPSILON = 0.001;
        private static final String TAG = "Arc";
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;
        private static double[] ourPercent;

        static {
            Arc.ourPercent = new double[91];
        }

        Arc(int arg15, double arg16, double arg18, double arg20, double arg22, double arg24, double arg26) {
            double v0 = arg16;
            double v2 = arg18;
            super();
            int v4 = 0;
            this.linear = false;
            int v5 = 1;
            boolean v6 = arg15 == 1 ? true : false;
            this.mVertical = v6;
            this.mTime1 = v0;
            this.mTime2 = v2;
            this.mOneOverDeltaTime = 1 / (v2 - v0);
            if(3 == arg15) {
                this.linear = true;
                v4 = 1;
            }

            v0 = arg24 - arg20;
            v2 = arg26 - arg22;
            if(v4 == 0) {
                double v8 = 0.001;
                if(Math.abs(v0) >= v8) {
                    if(Math.abs(v2) < v8) {
                    }
                    else {
                        this.mLut = new double[101];
                        boolean v15 = this.mVertical;
                        v4 = -1;
                        int v6_1 = v15 ? v4 : 1;
                        this.mEllipseA = v0 * (((double)v6_1));
                        if(v15) {
                        }
                        else {
                            v5 = v4;
                        }

                        this.mEllipseB = v2 * (((double)v5));
                        v0 = v15 ? arg24 : arg20;
                        this.mEllipseCenterX = v0;
                        v0 = v15 ? arg22 : arg26;
                        this.mEllipseCenterY = v0;
                        this.buildTable(arg20, arg22, arg24, arg26);
                        this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                        return;
                    }
                }
            }

            this.linear = true;
            this.mX1 = arg20;
            this.mX2 = arg24;
            this.mY1 = arg22;
            this.mY2 = arg26;
            double v4_1 = Math.hypot(v2, v0);
            this.mArcDistance = v4_1;
            this.mArcVelocity = v4_1 * this.mOneOverDeltaTime;
            v4_1 = this.mTime2;
            double v6_2 = this.mTime1;
            this.mEllipseCenterX = v0 / (v4_1 - v6_2);
            this.mEllipseCenterY = v2 / (v4_1 - v6_2);
        }

        private void buildTable(double arg17, double arg19, double arg21, double arg23) {
            Arc v0 = this;
            double v1 = arg21 - arg17;
            double v3 = arg19 - arg23;
            int v8 = 0;
            double v9 = 0;
            double v11 = 0;
            double v13;
            for(v13 = 0; true; v13 = v5) {
                double[] v15 = Arc.ourPercent;
                arg17 = 0;
                if(v8 >= v15.length) {
                    break;
                }

                int v20 = v8;
                double v5 = Math.toRadians((((double)v8)) * 90 / (((double)(v15.length - 1))));
                double v7 = Math.sin(v5) * v1;
                v5 = Math.cos(v5) * v3;
                if(v20 > 0) {
                    v9 += Math.hypot(v7 - v11, v5 - v13);
                    Arc.ourPercent[v20] = v9;
                }

                v13 = v7;
                v8 = v20 + 1;
                v11 = v13;
            }

            v0.mArcDistance = v9;
            int v1_1;
            for(v1_1 = 0; true; ++v1_1) {
                double[] v2 = Arc.ourPercent;
                if(v1_1 >= v2.length) {
                    break;
                }

                v2[v1_1] /= v9;
            }

            int v7_1;
            for(v7_1 = 0; true; ++v7_1) {
                double[] v1_2 = v0.mLut;
                if(v7_1 >= v1_2.length) {
                    return;
                }

                double v2_1 = (((double)v7_1)) / (((double)(v1_2.length - 1)));
                v1_1 = Arrays.binarySearch(Arc.ourPercent, v2_1);
                if(v1_1 >= 0) {
                    v0.mLut[v7_1] = ((double)(v1_1 / (Arc.ourPercent.length - 1)));
                }
                else if(v1_1 == -1) {
                    v0.mLut[v7_1] = arg17;
                }
                else {
                    v1_1 = -v1_1;
                    int v4 = v1_1 - 2;
                    v0.mLut[v7_1] = ((((double)v4)) + (v2_1 - Arc.ourPercent[v4]) / (Arc.ourPercent[v1_1 - 1] - Arc.ourPercent[v4])) / (((double)(Arc.ourPercent.length - 1)));
                }
            }
        }

        double getDX() {
            double v0 = this.mEllipseA * this.mTmpCosAngle;
            double v4 = this.mArcVelocity / Math.hypot(v0, -this.mEllipseB * this.mTmpSinAngle);
            if(this.mVertical) {
                return -v0 * v4;
            }

            return v0 * v4;
        }

        double getDY() {
            double v0 = this.mEllipseA * this.mTmpCosAngle;
            double v2 = -this.mEllipseB * this.mTmpSinAngle;
            double v4 = this.mArcVelocity / Math.hypot(v0, v2);
            if(this.mVertical) {
                return -v2 * v4;
            }

            return v2 * v4;
        }

        public double getLinearDX(double arg1) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double arg1) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double arg5) {
            return this.mX1 + (arg5 - this.mTime1) * this.mOneOverDeltaTime * (this.mX2 - this.mX1);
        }

        public double getLinearY(double arg5) {
            return this.mY1 + (arg5 - this.mTime1) * this.mOneOverDeltaTime * (this.mY2 - this.mY1);
        }

        double getX() {
            return this.mEllipseCenterX + this.mEllipseA * this.mTmpSinAngle;
        }

        double getY() {
            return this.mEllipseCenterY + this.mEllipseB * this.mTmpCosAngle;
        }

        double lookup(double arg6) {
            double v0 = 0;
            if(arg6 <= v0) {
                return v0;
            }

            v0 = 1;
            if(arg6 >= v0) {
                return v0;
            }

            double[] v5 = this.mLut;
            arg6 *= ((double)(v5.length - 1));
            int v0_1 = ((int)arg6);
            return v5[v0_1] + (arg6 - (((double)v0_1))) * (v5[v0_1 + 1] - v5[v0_1]);
        }

        void setPoint(double arg3) {
            double v0 = this.mVertical ? this.mTime2 - arg3 : arg3 - this.mTime1;
            v0 = this.lookup(v0 * this.mOneOverDeltaTime) * 1.570796;
            this.mTmpSinAngle = Math.sin(v0);
            this.mTmpCosAngle = Math.cos(v0);
        }
    }

    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    public ArcCurveFit(int[] arg24, double[] arg25, double[][] arg26) {
        ArcCurveFit v0 = this;
        double[] v1 = arg25;
        super();
        v0.mTime = v1;
        v0.mArcs = new Arc[v1.length - 1];
        int v4 = 0;
        int v5 = 1;
        int v6;
        for(v6 = 1; true; v6 = v9) {
            Arc[] v7 = v0.mArcs;
            if(v4 >= v7.length) {
                return;
            }

            int v8 = arg24[v4];
            int v9 = 3;
            if(v8 != 0) {
                if(v8 != 1) {
                    int v10 = 2;
                    if(v8 != v10) {
                        if(v8 != v9) {
                            v9 = v6;
                            goto label_30;
                        }
                        else {
                            if(v5 == 1) {
                                goto label_26;
                            }

                            goto label_28;
                        }
                    }

                label_26:
                    v5 = v10;
                }
                else {
                label_28:
                    v5 = 1;
                }

                v9 = v5;
            }

        label_30:
            v6 = v4 + 1;
            v7[v4] = new Arc(v9, v1[v4], v1[v6], arg26[v4][0], arg26[v4][1], arg26[v6][0], arg26[v6][1]);
            v4 = v6;
        }
    }

    public double getPos(double arg5, int arg7) {
        Arc[] v4;
        int v1 = 0;
        int v0 = Double.compare(arg5, this.mArcs[0].mTime1);
        Arc[] v2 = this.mArcs;
        if(v0 < 0) {
            arg5 = v2[0].mTime1;
        }
        else if(arg5 > v2[v2.length - 1].mTime2) {
            arg5 = this.mArcs[this.mArcs.length - 1].mTime2;
        }

        while(true) {
            Arc[] v0_1 = this.mArcs;
            if(v1 >= v0_1.length) {
                return NaN;
            }

            if(arg5 <= v0_1[v1].mTime2) {
                if(this.mArcs[v1].linear) {
                    v4 = this.mArcs;
                    if(arg7 == 0) {
                        return v4[v1].getLinearX(arg5);
                    }

                    return v4[v1].getLinearY(arg5);
                }

                this.mArcs[v1].setPoint(arg5);
                v4 = this.mArcs;
                if(arg7 == 0) {
                    return v4[v1].getX();
                }

                return v4[v1].getY();
            }

            ++v1;
        }

        return NaN;
    }

    public void getPos(double arg7, double[] arg9) {
        if(arg7 < this.mArcs[0].mTime1) {
            arg7 = this.mArcs[0].mTime1;
        }

        if(arg7 > this.mArcs[this.mArcs.length - 1].mTime2) {
            arg7 = this.mArcs[this.mArcs.length - 1].mTime2;
        }

        int v0;
        for(v0 = 0; true; ++v0) {
            Arc[] v2 = this.mArcs;
            if(v0 >= v2.length) {
                return;
            }

            if(arg7 <= v2[v0].mTime2) {
                boolean v2_1 = this.mArcs[v0].linear;
                Arc[] v4 = this.mArcs;
                if(v2_1) {
                    arg9[0] = v4[v0].getLinearX(arg7);
                    arg9[1] = this.mArcs[v0].getLinearY(arg7);
                    return;
                }

                v4[v0].setPoint(arg7);
                arg9[0] = this.mArcs[v0].getX();
                arg9[1] = this.mArcs[v0].getY();
                return;
            }
        }
    }

    public void getPos(double arg7, float[] arg9) {
        int v0 = Double.compare(arg7, this.mArcs[0].mTime1);
        Arc[] v2 = this.mArcs;
        if(v0 < 0) {
            arg7 = v2[0].mTime1;
        }
        else if(arg7 > v2[v2.length - 1].mTime2) {
            arg7 = this.mArcs[this.mArcs.length - 1].mTime2;
        }

        for(v0 = 0; true; ++v0) {
            v2 = this.mArcs;
            if(v0 >= v2.length) {
                return;
            }

            if(arg7 <= v2[v0].mTime2) {
                boolean v2_1 = this.mArcs[v0].linear;
                Arc[] v4 = this.mArcs;
                if(v2_1) {
                    arg9[0] = ((float)v4[v0].getLinearX(arg7));
                    arg9[1] = ((float)this.mArcs[v0].getLinearY(arg7));
                    return;
                }

                v4[v0].setPoint(arg7);
                arg9[0] = ((float)this.mArcs[v0].getX());
                arg9[1] = ((float)this.mArcs[v0].getY());
                return;
            }
        }
    }

    public double getSlope(double arg5, int arg7) {
        Arc[] v4;
        int v1 = 0;
        if(arg5 < this.mArcs[0].mTime1) {
            arg5 = this.mArcs[0].mTime1;
        }

        if(arg5 > this.mArcs[this.mArcs.length - 1].mTime2) {
            arg5 = this.mArcs[this.mArcs.length - 1].mTime2;
        }

        while(true) {
            Arc[] v0 = this.mArcs;
            if(v1 >= v0.length) {
                return NaN;
            }

            if(arg5 <= v0[v1].mTime2) {
                if(this.mArcs[v1].linear) {
                    v4 = this.mArcs;
                    if(arg7 == 0) {
                        return v4[v1].getLinearDX(arg5);
                    }

                    return v4[v1].getLinearDY(arg5);
                }

                this.mArcs[v1].setPoint(arg5);
                v4 = this.mArcs;
                if(arg7 == 0) {
                    return v4[v1].getDX();
                }

                return v4[v1].getDY();
            }

            ++v1;
        }

        return NaN;
    }

    public void getSlope(double arg7, double[] arg9) {
        int v0 = Double.compare(arg7, this.mArcs[0].mTime1);
        Arc[] v2 = this.mArcs;
        if(v0 < 0) {
            arg7 = v2[0].mTime1;
        }
        else if(arg7 > v2[v2.length - 1].mTime2) {
            arg7 = this.mArcs[this.mArcs.length - 1].mTime2;
        }

        for(v0 = 0; true; ++v0) {
            v2 = this.mArcs;
            if(v0 >= v2.length) {
                return;
            }

            if(arg7 <= v2[v0].mTime2) {
                boolean v2_1 = this.mArcs[v0].linear;
                Arc[] v4 = this.mArcs;
                if(v2_1) {
                    arg9[0] = v4[v0].getLinearDX(arg7);
                    arg9[1] = this.mArcs[v0].getLinearDY(arg7);
                    return;
                }

                v4[v0].setPoint(arg7);
                arg9[0] = this.mArcs[v0].getDX();
                arg9[1] = this.mArcs[v0].getDY();
                return;
            }
        }
    }

    public double[] getTimePoints() {
        return this.mTime;
    }
}

