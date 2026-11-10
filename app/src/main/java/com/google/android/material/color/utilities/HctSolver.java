package com.google.android.material.color.utilities;

public class HctSolver {
    static final double[] CRITICAL_PLANES;
    static final double[][] LINRGB_FROM_SCALED_DISCOUNT;
    static final double[][] SCALED_DISCOUNT_FROM_LINRGB;
    static final double[] Y_FROM_LINRGB;

    static {
        HctSolver.SCALED_DISCOUNT_FROM_LINRGB = new double[][]{new double[]{0.001201, 0.00239, 0.00028}, new double[]{0.000589, 0.002979, 0.000327}, new double[]{0.000101, 0.000536, 0.003298}};
        HctSolver.LINRGB_FROM_SCALED_DISCOUNT = new double[][]{new double[]{1373.219871, -1100.425119, -7.278681}, new double[]{-271.815969, 559.658047, -32.460475}, new double[]{1.96229, -57.173815, 308.72332}};
        HctSolver.Y_FROM_LINRGB = new double[]{0.2126, 0.7152, 0.0722};
        HctSolver.CRITICAL_PLANES = new double[]{0.015176, 0.045529, 0.075882, 0.106234, 0.136587, 0.16694, 0.197293, 0.227645, 0.257998, 0.288351, 0.31883, 0.350926, 0.384831, 0.420575, 0.458183, 0.497684, 0.539102, 0.582465, 0.627797, 0.675123, 0.724467, 0.775853, 0.829305, 0.884845, 0.942497, 1.002283, 1.064224, 1.128342, 1.194659, 1.263196, 1.333973, 1.407011, 1.48233, 1.55995, 1.639891, 1.722172, 1.806811, 1.893829, 1.983244, 2.075074, 2.169338, 2.266054, 2.365239, 2.466911, 2.571089, 2.677788, 2.787027, 2.898822, 3.01319, 3.130148, 3.249712, 3.371899, 3.496724, 3.624204, 3.754355, 3.887193, 4.022732, 4.160989, 4.301978, 4.445716, 4.592217, 4.741496, 4.893569, 5.048448, 5.206151, 5.36669, 5.53008, 5.696336, 5.865472, 6.037501, 6.212438, 6.390297, 6.571092, 6.754835, 6.941541, 7.131224, 7.323896, 7.51957, 7.718262, 7.919982, 8.124744, 8.332562, 8.543449, 8.757416, 8.974477, 9.194644, 9.41793, 9.644348, 9.873909, 10.106627, 10.342513, 10.58158, 10.82384, 11.069305, 11.317986, 11.569897, 11.825048, 12.083452, 12.34512, 12.610064, 12.878295, 13.149826, 13.424667, 13.702831, 13.984327, 14.269169, 14.557366, 14.848931, 15.143873, 15.442206, 15.743939, 16.049083, 16.357649, 16.669649, 16.985093, 17.303992, 17.626356, 17.952197, 18.281525, 18.61435, 18.950683, 19.290535, 19.633915, 19.980835, 20.331305, 20.685334, 21.042934, 21.404114, 21.768885, 22.137256, 22.509239, 22.884842, 23.264076, 23.646951, 24.033477, 24.423664, 24.817521, 25.215058, 25.616285, 26.021212, 26.429848, 26.842204, 27.258288, 27.67811, 28.101681, 28.529008, 28.960102, 29.394973, 29.833629, 30.27608, 30.722335, 31.172404, 31.626296, 32.084019, 32.545584, 33.010999, 33.480274, 33.953417, 34.430438, 34.911346, 35.396149, 35.884857, 36.377478, 36.874022, 37.374498, 37.878913, 38.387278, 38.8996, 39.415889, 39.936153, 40.460401, 40.988641, 41.520883, 42.057135, 42.597405, 43.141702, 43.690035, 44.242412, 44.798841, 45.359332, 45.923891, 46.492529, 47.065253, 47.642071, 48.222992, 48.808025, 49.397176, 49.990456, 50.587871, 51.18943, 51.795142, 52.405014, 53.019054, 53.637272, 54.259673, 54.886268, 55.517063, 56.152068, 56.791289, 57.434734, 58.082413, 58.734332, 59.390499, 60.050923, 60.715611, 61.384572, 62.057812, 62.735339, 63.417163, 64.103289, 64.793726, 65.488482, 66.187564, 66.89098, 67.598738, 68.310845, 69.027308, 69.748136, 70.473336, 71.202916, 71.936882, 72.675243, 73.418006, 74.165179, 74.916768, 75.672782, 76.433228, 77.198112, 77.967444, 78.741229, 79.519475, 80.30219, 81.089381, 81.881055, 82.677219, 83.477881, 84.283048, 85.092727, 85.906925, 86.72565, 87.548908, 88.376707, 89.209054, 90.045956, 90.88742, 91.733453, 92.584063, 93.439256, 94.299039, 95.163419, 96.032404, 96.906, 97.784214, 98.667053, 99.554525};
    }

    private HctSolver() {
        super();
    }

    static boolean areInCyclicOrder(double arg0, double arg2, double arg4) {
        if(HctSolver.sanitizeRadians(arg2 - arg0) < HctSolver.sanitizeRadians(arg4 - arg0)) {
            return 1;
        }

        return 0;
    }

    static double[] bisectToLimit(double arg19, double arg21) {
        int v8;
        int v7_1;
        double[][] v0 = HctSolver.bisectToSegment(arg19, arg21);
        double[] v2 = v0[0];
        double v3 = HctSolver.hueOf(v2);
        double[] v0_1 = v0[1];
        int v6;
        for(v6 = 0; v6 < 3; ++v6) {
            double v7 = v2[v6];
            double v9 = v0_1[v6];
            if(v7 != v9) {
                if(v7 < v9) {
                    v7_1 = HctSolver.criticalPlaneBelow(HctSolver.trueDelinearized(v7));
                    v8 = HctSolver.criticalPlaneAbove(HctSolver.trueDelinearized(v0_1[v6]));
                }
                else {
                    v7_1 = HctSolver.criticalPlaneAbove(HctSolver.trueDelinearized(v7));
                    v8 = HctSolver.criticalPlaneBelow(HctSolver.trueDelinearized(v0_1[v6]));
                }

                int v13 = 0;
                double v17 = v3;
                int v3_1 = v7_1;
                int v4 = v8;
                v7 = v17;
                while(v13 < 8) {
                    if(Math.abs(v4 - v3_1) <= 1) {
                    }
                    else {
                        int v14 = ((int)Math.floor((((double)(v3_1 + v4))) / 2));
                        double[] v15 = HctSolver.setCoordinate(v2, HctSolver.CRITICAL_PLANES[v14], v0_1, v6);
                        double v11 = HctSolver.hueOf(v15);
                        if(HctSolver.areInCyclicOrder(v7, arg21, v11)) {
                            v4 = v14;
                            v0_1 = v15;
                        }
                        else {
                            v7 = v11;
                            v3_1 = v14;
                            v2 = v15;
                        }

                        ++v13;
                        continue;
                    }

                    break;
                }

                v3 = v7;
            }
        }

        return HctSolver.midpoint(v2, v0_1);
    }

    static double[][] bisectToSegment(double arg19, double arg21) {
        double v17;
        double[] v0 = new double[]{-1, -1, -1};
        double v2 = 0;
        double[] v5 = v0;
        int v6 = 0;
        int v7 = 0;
        double v9 = v2;
        double v13 = v9;
        int v8 = 1;
        while(v6 < 12) {
            double[] v15 = HctSolver.nthVertex(arg19, v6);
            if(v15[0] < v2) {
                v17 = v13;
                goto label_38;
            }
            else {
                double v11 = HctSolver.hueOf(v15);
                if(v7 == 0) {
                    v7 = 1;
                    v9 = v11;
                    v13 = v9;
                    v0 = v15;
                    v5 = v0;
                }
                else {
                    if(v8 == 0) {
                        boolean v16 = HctSolver.areInCyclicOrder(v9, v11, v13);
                        v17 = v13;
                        v13 = v11;
                        if(v16) {
                        }
                        else {
                            goto label_38;
                        }
                    }
                    else {
                        v17 = v13;
                        v13 = v11;
                    }

                    if(HctSolver.areInCyclicOrder(v9, arg21, v13)) {
                        v8 = 0;
                        v5 = v15;
                        goto label_52;
                    }

                    v8 = 0;
                    v9 = v13;
                    v0 = v15;
                label_38:
                    v13 = v17;
                }
            }

        label_52:
            ++v6;
        }

        return new double[][]{v0, v5};
    }

    static double chromaticAdaptation(double arg4) {
        double v0 = Math.pow(Math.abs(arg4), 0.42);
        return (((double)MathUtils.signum(arg4))) * 400 * v0 / (v0 + 27.13);
    }

    static int criticalPlaneAbove(double arg2) {
        return ((int)Math.ceil(arg2 - 0.5));
    }

    static int criticalPlaneBelow(double arg2) {
        return ((int)Math.floor(arg2 - 0.5));
    }

    static int findResultByJ(double arg35, double arg37, double arg39) {
        double[] v3;
        double v0 = Math.sqrt(arg39) * 11;
        ViewingConditions v4 = ViewingConditions.DEFAULT;
        double v7 = 1;
        double v5 = v7 / Math.pow(1.64 - Math.pow(0.29, v4.getN()), 0.73);
        double v9 = 2;
        double v11 = (Math.cos(arg35 + v9) + 3.8) * 0.25 * 3846.153846 * v4.getNc() * v4.getNcb();
        double v13 = Math.sin(arg35);
        double v15 = Math.cos(arg35);
        double v18 = 11;
        int v2 = 0;
        while(true) {
            if(v2 < 5) {
                double v22 = v7;
                v7 = v0 / 100;
                double v20 = 0;
                double v24 = arg37 == v20 || v0 == v20 ? v20 : arg37 / Math.sqrt(v7);
                double v26 = v9;
                arg35 = v0;
                v0 = Math.pow(v24 * v5, 1.111111);
                v9 = v4.getAw() * Math.pow(v7, v22 / v4.getC() / v4.getZ()) / v4.getNbb();
                v0 = (0.305 + v9) * 23 * v0 / (23 * v11 + v0 * v18 * v15 + 108 * v0 * v13);
                v7 = v0 * v15;
                v0 *= v13;
                v9 *= 460;
                v24 = (v9 + 451 * v7 + 288 * v0) / 1403;
                double v30 = (v9 - 891 * v7 - 261 * v0) / 1403;
                v9 = (v9 - v7 * 220 - v0 * 6300) / 1403;
                v0 = HctSolver.inverseChromaticAdaptation(v24);
                v7 = HctSolver.inverseChromaticAdaptation(v30);
                v9 = HctSolver.inverseChromaticAdaptation(v9);
                v3 = new double[3];
                v3[0] = v0;
                v3[1] = v7;
                int v1 = 2;
                v3[v1] = v9;
                v3 = MathUtils.matrixMultiply(v3, HctSolver.LINRGB_FROM_SCALED_DISCOUNT);
                v7 = v3[0];
                if(v7 < v20) {
                    return 0;
                }

                v9 = v3[1];
                if(v9 < v20) {
                    return 0;
                }

                v24 = v3[v1];
                if(v24 < v20) {
                    return 0;
                }

                double v29 = HctSolver.Y_FROM_LINRGB[0] * v7 + HctSolver.Y_FROM_LINRGB[1] * v9 + HctSolver.Y_FROM_LINRGB[v1] * v24;
                if(v29 <= v20) {
                    return 0;
                }

                if(v2 != 4) {
                    v7 = v29 - arg39;
                    if(Math.abs(v7) < 0.002) {
                    }
                    else {
                        v0 = arg35 - v7 * arg35 / (v29 * v26);
                        ++v2;
                        v7 = v22;
                        v9 = v26;
                        continue;
                    }
                }

                break;
            }

            return 0;
        }

        double v6 = 100.01;
        if(v3[0] <= v6 && v3[1] <= v6) {
            if(v3[v1] > v6) {
            }
            else {
                return ColorUtils.argbFromLinrgb(v3);
            }
        }

        return 0;
    }

    static double hueOf(double[] arg12) {
        arg12 = MathUtils.matrixMultiply(arg12, HctSolver.SCALED_DISCOUNT_FROM_LINRGB);
        double v0 = HctSolver.chromaticAdaptation(arg12[0]);
        double v2 = HctSolver.chromaticAdaptation(arg12[1]);
        double v4 = HctSolver.chromaticAdaptation(arg12[2]);
        return Math.atan2((v0 + v2 - v4 * 2) / 9, (v0 * 11 + -12 * v2 + v4) / 11);
    }

    static double intercept(double arg0, double arg2, double arg4) {
        return (arg2 - arg0) / (arg4 - arg0);
    }

    static double inverseChromaticAdaptation(double arg6) {
        double v0 = Math.abs(arg6);
        return (((double)MathUtils.signum(arg6))) * Math.pow(Math.max(0, 27.13 * v0 / (400 - v0)), 2.380952);
    }

    static boolean isBounded(double arg2) {
        if(0 <= arg2 && arg2 <= 100) {
            return 1;
        }

        return 0;
    }

    static double[] lerpPoint(double[] arg11, double arg12, double[] arg14) {
        return new double[]{arg11[0] + (arg14[0] - arg11[0]) * arg12, arg11[1] + (arg14[1] - arg11[1]) * arg12, arg11[2] + (arg14[2] - arg11[2]) * arg12};
    }

    static double[] midpoint(double[] arg11, double[] arg12) {
        return new double[]{(arg11[0] + arg12[0]) / 2, (arg11[1] + arg12[1]) / 2, (arg11[2] + arg12[2]) / 2};
    }

    static double[] nthVertex(double arg17, int arg19) {
        double[] v0_1;
        int v0 = arg19;
        double[] v1 = HctSolver.Y_FROM_LINRGB;
        double v3 = v1[0];
        double v6 = v1[1];
        int v8 = 2;
        double v9 = v1[v8];
        double v11 = 0;
        double v13 = 100;
        double v15 = v0 % 4 <= 1 ? v11 : v13;
        if(v0 % 2 == 0) {
        }
        else {
            v11 = v13;
        }

        int v1_1 = 3;
        if(v0 < 4) {
            v6 = (arg17 - v6 * v15 - v9 * v11) / v3;
            if(HctSolver.isBounded(v6)) {
                v0_1 = new double[v1_1];
                v0_1[0] = v6;
                v0_1[1] = v15;
                v0_1[v8] = v11;
                return v0_1;
            }

            return new double[]{-1, -1, -1};
        }

        if(v0 < 8) {
            v3 = (arg17 - v3 * v11 - v9 * v15) / v6;
            if(HctSolver.isBounded(v3)) {
                v0_1 = new double[v1_1];
                v0_1[0] = v11;
                v0_1[1] = v3;
                v0_1[v8] = v15;
                return v0_1;
            }

            return new double[]{-1, -1, -1};
        }

        v3 = (arg17 - v3 * v15 - v6 * v11) / v9;
        if(HctSolver.isBounded(v3)) {
            v0_1 = new double[v1_1];
            v0_1[0] = v15;
            v0_1[1] = v11;
            v0_1[v8] = v3;
            return v0_1;
        }

        return new double[]{-1, -1, -1};
    }

    static double sanitizeRadians(double arg2) {
        return (arg2 + 25.132741) % 6.283185;
    }

    static double[] setCoordinate(double[] arg6, double arg7, double[] arg9, int arg10) {
        return HctSolver.lerpPoint(arg6, HctSolver.intercept(arg6[arg10], arg7, arg9[arg10]), arg9);
    }

    public static Cam16 solveToCam(double arg0, double arg2, double arg4) {
        return Cam16.fromInt(HctSolver.solveToInt(arg0, arg2, arg4));
    }

    public static int solveToInt(double arg8, double arg10, double arg12) {
        double v0 = 0.0001;
        if(arg10 >= v0 && arg12 >= v0) {
            if(arg12 > 99.9999) {
            }
            else {
                double v2 = MathUtils.sanitizeDegreesDouble(arg8) / 180 * 3.141593;
                double v6 = ColorUtils.yFromLstar(arg12);
                int v8 = HctSolver.findResultByJ(v2, arg10, v6);
                if(v8 != 0) {
                    return v8;
                }
                else {
                    return ColorUtils.argbFromLinrgb(HctSolver.bisectToLimit(v6, v2));
                }
            }
        }

        return ColorUtils.argbFromLstar(arg12);
    }

    static double trueDelinearized(double arg2) {
        arg2 /= 100;
        if(arg2 <= 0.003131) {
            arg2 *= 12.92;
        }
        else {
            arg2 = Math.pow(arg2, 0.416667) * 1.055 - 0.055;
        }

        return arg2 * 255;
    }
}

