package androidx.compose.material3.internal.colorUtil;

import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0016\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH\u0002J\u0010\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0002J\u0010\u0010\u0010\u001A\u00020\f2\u0006\u0010\u0011\u001A\u00020\fH\u0002J\u0010\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u0006H\u0002J \u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\fH\u0002J \u0010\u0019\u001A\u00020\f2\u0006\u0010\u001A\u001A\u00020\f2\u0006\u0010\u001B\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\fH\u0002J \u0010\u001D\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u0006H\u0002J(\u0010\u001F\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u00062\u0006\u0010!\u001A\u00020\"H\u0002J\u0010\u0010#\u001A\u00020\u00152\u0006\u0010$\u001A\u00020\fH\u0002J\u0018\u0010%\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\f2\u0006\u0010\'\u001A\u00020\"H\u0002J#\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010&\u001A\u00020\f2\u0006\u0010)\u001A\u00020\fH\u0002¢\u0006\u0002\u0010*J\u0010\u0010+\u001A\u00020\"2\u0006\u0010$\u001A\u00020\fH\u0002J\u0010\u0010,\u001A\u00020\"2\u0006\u0010$\u001A\u00020\fH\u0002J\u0018\u0010-\u001A\u00020\"2\u0006\u0010&\u001A\u00020\f2\u0006\u0010)\u001A\u00020\fH\u0002J\u0010\u0010.\u001A\u00020\f2\u0006\u0010/\u001A\u00020\fH\u0002J \u00100\u001A\u00020\"2\u0006\u00101\u001A\u00020\f2\u0006\u00102\u001A\u00020\f2\u0006\u0010&\u001A\u00020\fH\u0002J\u001E\u00103\u001A\u00020\"2\u0006\u00104\u001A\u00020\f2\u0006\u00102\u001A\u00020\f2\u0006\u00105\u001A\u00020\fJ\u0010\u00106\u001A\u00020\f2\u0006\u00107\u001A\u00020\fH\u0002R\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000E\u0010\t\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2={"Landroidx/compose/material3/internal/colorUtil/HctSolver;", "", "<init>", "()V", "SCALED_DISCOUNT_FROM_LINRGB", "", "", "[[D", "LINRGB_FROM_SCALED_DISCOUNT", "Y_FROM_LINRGB", "CRITICAL_PLANES", "sanitizeRadians", "", "angle", "trueDelinearized", "rgbComponent", "chromaticAdaptation", "component", "hueOf", "linrgb", "areInCyclicOrder", "", "a", "b", "c", "intercept", "source", "mid", "target", "lerpPoint", "t", "setCoordinate", "coordinate", "axis", "", "isBounded", "x", "nthVertex", "y", "n", "bisectToSegment", "targetHue", "(DD)[[D", "criticalPlaneBelow", "criticalPlaneAbove", "bisectToLimit", "inverseChromaticAdaptation", "adapted", "findResultByJ", "hueRadians", "chroma", "solveToInt", "hueDegrees", "lstar", "sanitizeDegreesDouble", "degrees", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HctSolver {
    public static final int $stable;
    private static final double[] CRITICAL_PLANES;
    public static final HctSolver INSTANCE;
    private static final double[][] LINRGB_FROM_SCALED_DISCOUNT;
    private static final double[][] SCALED_DISCOUNT_FROM_LINRGB;
    private static final double[] Y_FROM_LINRGB;

    static {
        HctSolver.INSTANCE = new HctSolver();
        HctSolver.SCALED_DISCOUNT_FROM_LINRGB = new double[][]{new double[]{0.001201, 0.00239, 0.00028}, new double[]{0.000589, 0.002979, 0.000327}, new double[]{0.000101, 0.000536, 0.003298}};
        HctSolver.LINRGB_FROM_SCALED_DISCOUNT = new double[][]{new double[]{1373.219871, -1100.425119, -7.278681}, new double[]{-271.815969, 559.658047, -32.460475}, new double[]{1.96229, -57.173815, 308.72332}};
        HctSolver.Y_FROM_LINRGB = new double[]{0.2126, 0.7152, 0.0722};
        HctSolver.CRITICAL_PLANES = new double[]{0.015176, 0.045529, 0.075882, 0.106234, 0.136587, 0.16694, 0.197293, 0.227645, 0.257998, 0.288351, 0.31883, 0.350926, 0.384831, 0.420575, 0.458183, 0.497684, 0.539102, 0.582465, 0.627797, 0.675123, 0.724467, 0.775853, 0.829305, 0.884845, 0.942497, 1.002283, 1.064224, 1.128342, 1.194659, 1.263196, 1.333973, 1.407011, 1.48233, 1.55995, 1.639891, 1.722172, 1.806811, 1.893829, 1.983244, 2.075074, 2.169338, 2.266054, 2.365239, 2.466911, 2.571089, 2.677788, 2.787027, 2.898822, 3.01319, 3.130148, 3.249712, 3.371899, 3.496724, 3.624204, 3.754355, 3.887193, 4.022732, 4.160989, 4.301978, 4.445716, 4.592217, 4.741496, 4.893569, 5.048448, 5.206151, 5.36669, 5.53008, 5.696336, 5.865472, 6.037501, 6.212438, 6.390297, 6.571092, 6.754835, 6.941541, 7.131224, 7.323896, 7.51957, 7.718262, 7.919982, 8.124744, 8.332562, 8.543449, 8.757416, 8.974477, 9.194644, 9.41793, 9.644348, 9.873909, 10.106627, 10.342513, 10.58158, 10.82384, 11.069305, 11.317986, 11.569897, 11.825048, 12.083452, 12.34512, 12.610064, 12.878295, 13.149826, 13.424667, 13.702831, 13.984327, 14.269169, 14.557366, 14.848931, 15.143873, 15.442206, 15.743939, 16.049083, 16.357649, 16.669649, 16.985093, 17.303992, 17.626356, 17.952197, 18.281525, 18.61435, 18.950683, 19.290535, 19.633915, 19.980835, 20.331305, 20.685334, 21.042934, 21.404114, 21.768885, 22.137256, 22.509239, 22.884842, 23.264076, 23.646951, 24.033477, 24.423664, 24.817521, 25.215058, 25.616285, 26.021212, 26.429848, 26.842204, 27.258288, 27.67811, 28.101681, 28.529008, 28.960102, 29.394973, 29.833629, 30.27608, 30.722335, 31.172404, 31.626296, 32.084019, 32.545584, 33.010999, 33.480274, 33.953417, 34.430438, 34.911346, 35.396149, 35.884857, 36.377478, 36.874022, 37.374498, 37.878913, 38.387278, 38.8996, 39.415889, 39.936153, 40.460401, 40.988641, 41.520883, 42.057135, 42.597405, 43.141702, 43.690035, 44.242412, 44.798841, 45.359332, 45.923891, 46.492529, 47.065253, 47.642071, 48.222992, 48.808025, 49.397176, 49.990456, 50.587871, 51.18943, 51.795142, 52.405014, 53.019054, 53.637272, 54.259673, 54.886268, 55.517063, 56.152068, 56.791289, 57.434734, 58.082413, 58.734332, 59.390499, 60.050923, 60.715611, 61.384572, 62.057812, 62.735339, 63.417163, 64.103289, 64.793726, 65.488482, 66.187564, 66.89098, 67.598738, 68.310845, 69.027308, 69.748136, 70.473336, 71.202916, 71.936882, 72.675243, 73.418006, 74.165179, 74.916768, 75.672782, 76.433228, 77.198112, 77.967444, 78.741229, 79.519475, 80.30219, 81.089381, 81.881055, 82.677219, 83.477881, 84.283048, 85.092727, 85.906925, 86.72565, 87.548908, 88.376707, 89.209054, 90.045956, 90.88742, 91.733453, 92.584063, 93.439256, 94.299039, 95.163419, 96.032404, 96.906, 97.784214, 98.667053, 99.554525};
        HctSolver.$stable = 8;
    }

    private HctSolver() {
        super();
    }

    private final boolean areInCyclicOrder(double arg1, double arg3, double arg5) {
        if(this.sanitizeRadians(arg3 - arg1) < this.sanitizeRadians(arg5 - arg1)) {
            return 1;
        }

        return 0;
    }

    private final int bisectToLimit(double arg23, double arg25) {
        double[] v18;
        int v11_1;
        int v6;
        int v16;
        double v9;
        HctSolver v0 = this;
        double[][] v1 = this.bisectToSegment(arg23, arg25);
        double[] v2 = v1[0];
        double v3 = v0.hueOf(v2);
        double[] v1_1 = v1[1];
        int v5 = 0;
        while(true) {
            v9 = 2;
            if(v5 >= 3) {
                break;
            }

            double v11 = v2[v5];
            double v13 = v1_1[v5];
            if(v11 == v13) {
                v16 = v5;
            }
            else {
                if(v11 < v13) {
                    v6 = v0.criticalPlaneBelow(v0.trueDelinearized(v11));
                    v11_1 = v0.criticalPlaneAbove(v0.trueDelinearized(v1_1[v5]));
                }
                else {
                    v6 = v0.criticalPlaneAbove(v0.trueDelinearized(v11));
                    v11_1 = v0.criticalPlaneBelow(v0.trueDelinearized(v1_1[v5]));
                }

                int v13_1 = v6;
                int v15 = 0;
                int v14 = v11_1;
                v11 = v3;
                double[] v4 = v1_1;
                v1_1 = v2;
                while(v15 < 8) {
                    if(Math.abs(((double)(v14 - v13_1))) <= 1) {
                    }
                    else {
                        v6 = ((int)Math.floor((((double)(v13_1 + v14))) / v9));
                        v2 = v0.setCoordinate(v1_1, HctSolver.CRITICAL_PLANES[v6], v4, v5);
                        double[] v17 = v1_1;
                        v18 = v4;
                        v16 = v5;
                        int v1_2 = v6;
                        double v5_1 = v0.hueOf(v2);
                        double v20 = v11;
                        v11_1 = v1_2;
                        double[] v12 = v2;
                        double v1_3 = v20;
                        if(v0.areInCyclicOrder(v1_3, arg25, v5_1)) {
                            v14 = v11_1;
                            v4 = v12;
                            v11 = v1_3;
                            v1_1 = v17;
                        }
                        else {
                            v13_1 = v11_1;
                            v1_1 = v12;
                            v4 = v18;
                            v11 = v5_1;
                        }

                        ++v15;
                        v0 = this;
                        v5 = v16;
                        continue;
                    }

                    break;
                }

                v18 = v4;
                v16 = v5;
                v3 = v11;
                v2 = v1_1;
                v1_1 = v18;
            }

            v5 = v16 + 1;
            v0 = this;
        }

        return CamUtils.INSTANCE.argbFromLinrgbComponents((v2[0] + v1_1[0]) / v9, (v2[1] + v1_1[1]) / v9, (v2[2] + v1_1[2]) / v9);
    }

    private final double[][] bisectToSegment(double arg21, double arg23) {
        double v18;
        HctSolver v0 = this;
        double[] v1 = new double[3];
        int v7 = 0;
        v1[0] = -1;
        v1[1] = -1;
        v1[2] = -1;
        double v9 = 0;
        double[] v11 = v1;
        double[] v12 = v11;
        int v13 = 0;
        int v14 = 0;
        int v15 = 1;
        double v1_1 = v9;
        double v5 = v1_1;
        while(v13 < 12) {
            int v16 = v7;
            double[] v7_1 = v0.nthVertex(arg21, v13);
            if(v7_1[v16] < v9) {
                v18 = v5;
                goto label_40;
            }
            else {
                double v3 = v0.hueOf(v7_1);
                if(v14 == 0) {
                    v1_1 = v3;
                    v5 = v1_1;
                    v11 = v7_1;
                    v12 = v11;
                    v14 = 1;
                }
                else {
                    if(v15 == 0) {
                        v18 = v5;
                        if(v0.areInCyclicOrder(v1_1, v3, v5)) {
                        }
                        else {
                            goto label_40;
                        }
                    }
                    else {
                        v18 = v5;
                    }

                    v5 = v3;
                    v3 = v5;
                    if(this.areInCyclicOrder(v1_1, arg23, v5)) {
                        v5 = v3;
                        v12 = v7_1;
                        v15 = v16;
                        goto label_57;
                    }

                    v1_1 = v3;
                    v11 = v7_1;
                    v15 = v16;
                label_40:
                    v5 = v18;
                }
            }

        label_57:
            ++v13;
            v0 = this;
            v7 = v16;
        }

        return new double[][]{v11, v12};
    }

    private final double chromaticAdaptation(double arg5) {
        double v0 = Math.pow(Math.abs(arg5), 0.42);
        return (((double)CamUtils.INSTANCE.signum(arg5))) * 400 * v0 / (v0 + 27.13);
    }

    private final int criticalPlaneAbove(double arg3) {
        return ((int)Math.ceil(arg3 - 0.5));
    }

    private final int criticalPlaneBelow(double arg3) {
        return ((int)Math.floor(arg3 - 0.5));
    }

    private final int findResultByJ(double arg42, double arg44, double arg46) {
        double v39;
        double v37;
        double v35;
        HctSolver v0 = this;
        double v1 = Math.sqrt(arg46) * 11;
        Frame v5 = Frame.Companion.getDefault();
        double v8 = 1;
        double v6 = v8 / Math.pow(1.64 - Math.pow(0.29, ((double)v5.getN())), 0.73);
        double v10 = 2;
        double v12 = (Math.cos(arg42 + v10) + 3.8) * 0.25 * 3846.153846 * (((double)v5.getNc())) * (((double)v5.getNcb()));
        double v14 = Math.sin(arg42);
        double v16 = Math.cos(arg42);
        double v19 = 11;
        int v3 = 0;
        while(true) {
            if(v3 < 5) {
                double v23 = v8;
                v8 = v1 / 100;
                double v21 = 0;
                double v25 = arg44 == v21 || v1 == v21 ? v21 : arg44 / Math.sqrt(v8);
                double v27 = v10;
                arg42 = v1;
                v25 = Math.pow(v25 * v6, 1.111111);
                v1 = (((double)v5.getAw())) * Math.pow(v8, v23 / (((double)v5.getC())) / (((double)v5.getZ()))) / (((double)v5.getNbb()));
                v8 = (0.305 + v1) * 23 * v25 / (23 * v12 + v19 * v25 * v16 + v25 * 108 * v14);
                v10 = v8 * v16;
                v8 *= v14;
                v1 *= 460;
                double v31 = v1;
                Frame v33 = v5;
                v1 = v0.inverseChromaticAdaptation((v1 + 451 * v10 + 288 * v8) / 1403);
                double v4 = v0.inverseChromaticAdaptation((v31 - 891 * v10 - 261 * v8) / 1403);
                v8 = v0.inverseChromaticAdaptation((v31 - v10 * 220 - v8 * 6300) / 1403);
                double[][] v10_1 = HctSolver.LINRGB_FROM_SCALED_DISCOUNT;
                int v30 = 2;
                v35 = v10_1[0][0] * v1 + v10_1[0][1] * v4 + v10_1[0][v30] * v8;
                v37 = v10_1[1][0] * v1 + v10_1[1][1] * v4 + v10_1[1][v30] * v8;
                v39 = v1 * v10_1[v30][0] + v4 * v10_1[v30][1] + v8 * v10_1[v30][v30];
                if(v35 < v21) {
                    return 0;
                }

                if(v37 < v21) {
                    return 0;
                }

                if(v39 < v21) {
                    return 0;
                }

                v4 = HctSolver.Y_FROM_LINRGB[0] * v35 + HctSolver.Y_FROM_LINRGB[1] * v37 + HctSolver.Y_FROM_LINRGB[v30] * v39;
                if(v4 <= v21) {
                    return 0;
                }

                if(v3 != 4) {
                    v1 = v4 - arg46;
                    if(Math.abs(v1) < 0.002) {
                    }
                    else {
                        v1 = arg42 - v1 * arg42 / (v27 * v4);
                        ++v3;
                        v8 = v23;
                        v10 = v27;
                        v5 = v33;
                        continue;
                    }
                }

                break;
            }

            return 0;
        }

        double v0_1 = 100.01;
        if(v35 <= v0_1 && v37 <= v0_1) {
            if(v39 > v0_1) {
            }
            else {
                return CamUtils.INSTANCE.argbFromLinrgbComponents(v35, v37, v39);
            }
        }

        return 0;
    }

    private final double hueOf(double[] arg19) {
        double[][] v1 = HctSolver.SCALED_DISCOUNT_FROM_LINRGB;
        double v3 = arg19[0];
        double[] v5 = v1[0];
        double v6 = v5[0] * v3;
        double v9 = arg19[1];
        v6 += v5[1] * v9;
        double v12 = arg19[2];
        v6 += v5[2] * v12;
        double v14 = v1[1][0] * v3 + v1[1][1] * v9 + v1[1][2] * v12;
        v3 = v3 * v1[2][0] + v9 * v1[2][1] + v12 * v1[2][2];
        double v1_1 = this.chromaticAdaptation(v6);
        double v5_1 = this.chromaticAdaptation(v14);
        v3 = this.chromaticAdaptation(v3);
        return Math.atan2((v1_1 + v5_1 - v3 * 2) / 9, (v1_1 * 11 + -12 * v5_1 + v3) / 11);
    }

    private final double intercept(double arg1, double arg3, double arg5) {
        if(arg5 == arg1) {
            return arg5;
        }

        return (arg3 - arg1) / (arg5 - arg1);
    }

    private final double inverseChromaticAdaptation(double arg7) {
        double v0 = Math.abs(arg7);
        return (((double)CamUtils.INSTANCE.signum(arg7))) * Math.pow(Math.max(0, 27.13 * v0 / (400 - v0)), 2.380952);
    }

    private final boolean isBounded(double arg4) {
        if(Double.compare(0, arg4) <= 0 && arg4 <= 100) {
            return 1;
        }

        return 0;
    }

    private final double[] lerpPoint(double[] arg11, double arg12, double[] arg14) {
        return new double[]{arg11[0] + (arg14[0] - arg11[0]) * arg12, arg11[1] + (arg14[1] - arg11[1]) * arg12, arg11[2] + (arg14[2] - arg11[2]) * arg12};
    }

    private final double[] nthVertex(double arg20, int arg22) {
        double v3;
        double[] v0_1;
        HctSolver v0 = this;
        int v1 = arg22;
        double[] v2 = HctSolver.Y_FROM_LINRGB;
        double v4 = v2[0];
        double v7 = v2[1];
        int v9 = 2;
        double v10 = v2[v9];
        double v12 = 0;
        double v14 = 100;
        double v16 = v1 % 4 <= 1 ? v12 : v14;
        if(v1 % 2 == 0) {
        }
        else {
            v12 = v14;
        }

        int v2_1 = 3;
        v14 = -1;
        if(v1 < 4) {
            v7 = (arg20 - v7 * v16 - v10 * v12) / v4;
            if(v0.isBounded(v7)) {
                v0_1 = new double[v2_1];
                v0_1[0] = v7;
                v0_1[1] = v16;
                v0_1[v9] = v12;
                return v0_1;
            }

            v0_1 = new double[v2_1];
            v0_1[0] = v14;
            v0_1[1] = v14;
            v0_1[v9] = v14;
            return v0_1;
        }

        if(v1 < 8) {
            v3 = (arg20 - v4 * v12 - v10 * v16) / v7;
            if(v0.isBounded(v3)) {
                v0_1 = new double[v2_1];
                v0_1[0] = v12;
                v0_1[1] = v3;
                v0_1[v9] = v16;
                return v0_1;
            }

            v0_1 = new double[v2_1];
            v0_1[0] = v14;
            v0_1[1] = v14;
            v0_1[v9] = v14;
            return v0_1;
        }

        v3 = (arg20 - v4 * v16 - v7 * v12) / v10;
        if(v0.isBounded(v3)) {
            v0_1 = new double[v2_1];
            v0_1[0] = v16;
            v0_1[1] = v12;
            v0_1[v9] = v3;
            return v0_1;
        }

        v0_1 = new double[v2_1];
        v0_1[0] = v14;
        v0_1[1] = v14;
        v0_1[v9] = v14;
        return v0_1;
    }

    private final double sanitizeDegreesDouble(double arg5) {
        double v0 = 360;
        arg5 %= v0;
        if(arg5 < 0) {
            arg5 += v0;
        }

        return arg5;
    }

    private final double sanitizeRadians(double arg3) {
        return (arg3 + 25.132741) % 6.283185;
    }

    private final double[] setCoordinate(double[] arg8, double arg9, double[] arg11, int arg12) {
        return this.lerpPoint(arg8, this.intercept(arg8[arg12], arg9, arg11[arg12]), arg11);
    }

    public final int solveToInt(double arg8, double arg10, double arg12) {
        double v0 = 0.0001;
        if(arg10 >= v0 && arg12 >= v0) {
            if(arg12 > 99.9999) {
            }
            else {
                double v1 = Math.toRadians(this.sanitizeDegreesDouble(arg8));
                double v5 = CamUtils.INSTANCE.yFromLstar(arg12);
                HctSolver v0_1 = this;
                int v7 = v0_1.findResultByJ(v1, arg10, v5);
                if(v7 != 0) {
                    return v7;
                }
                else {
                    return v0_1.bisectToLimit(v5, v1);
                }
            }
        }

        return CamUtils.INSTANCE.argbFromLstar(arg12);
    }

    private final double trueDelinearized(double arg3) {
        arg3 /= 100;
        if(arg3 <= 0.003131) {
            arg3 *= 12.92;
        }
        else {
            arg3 = Math.pow(arg3, 0.416667) * 1.055 - 0.055;
        }

        return arg3 * 255;
    }
}

