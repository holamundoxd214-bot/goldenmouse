package com.google.android.material.color.utilities;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public final class QuantizerWsmeans {
    final class Distance implements Comparable {
        double distance;
        int index;

        Distance() {
            super();
            this.index = -1;
            this.distance = -1;
        }

        public int compareTo(Distance arg3) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(arg3.distance));
        }

        public int compareTo(Object arg1) {
            return this.compareTo(((Distance)arg1));
        }
    }

    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3;

    private QuantizerWsmeans() {
        super();
    }

    public static Map quantize(int[] arg25, int[] arg26, int arg27) {
        double[] v18_2;
        double[] v15_1;
        int v7_1;
        int[][] v21;
        int v22;
        double v19;
        double v13_1;
        int v16;
        double v0_1;
        int v15;
        int v14;
        int v10;
        int v11;
        int[] v0 = arg25;
        int[] v1 = arg26;
        Random v2 = new Random(272008);
        LinkedHashMap v3 = new LinkedHashMap();
        double[][] v4 = new double[v0.length][];
        int[] v5 = new int[v0.length];
        PointProviderLab v6 = new PointProviderLab();
        int v8 = 0;
        int v9 = 0;
        while(true) {
            v11 = 1;
            if(v8 >= v0.length) {
                break;
            }

            v10 = v0[v8];
            Object v12 = ((Map)v3).get(Integer.valueOf(v10));
            if(v12 == null) {
                v4[v9] = ((PointProvider)v6).fromInt(v10);
                v5[v9] = v10;
                ++v9;
                ((Map)v3).put(Integer.valueOf(v10), Integer.valueOf(1));
            }
            else {
                ((Map)v3).put(Integer.valueOf(v10), Integer.valueOf(((Integer)v12).intValue() + 1));
            }

            ++v8;
        }

        v0 = new int[v9];
        for(v8 = 0; v8 < v9; ++v8) {
            v0[v8] = ((Map)v3).get(Integer.valueOf(v5[v8])).intValue();
        }

        int v3_1 = Math.min(arg27, v9);
        if(v1.length != 0) {
            v3_1 = Math.min(v3_1, v1.length);
        }

        double[][] v5_1 = new double[v3_1][];
        v8 = 0;
        v10 = 0;
        while(v8 < v1.length) {
            v5_1[v8] = ((PointProvider)v6).fromInt(v1[v8]);
            ++v10;
            ++v8;
        }

        int v1_1 = v3_1 - v10;
        if(v1_1 > 0) {
            for(v8 = 0; v8 < v1_1; ++v8) {
            }
        }

        v1 = new int[v9];
        for(v8 = 0; v8 < v9; ++v8) {
            v1[v8] = v2.nextInt(v3_1);
        }

        int[][] v2_1 = new int[v3_1][];
        for(v8 = 0; v8 < v3_1; ++v8) {
            v2_1[v8] = new int[v3_1];
        }

        Distance[][] v8_1 = new Distance[v3_1][];
        for(v10 = 0; v10 < v3_1; ++v10) {
            v8_1[v10] = new Distance[v3_1];
            int v12_1;
            for(v12_1 = 0; v12_1 < v3_1; ++v12_1) {
                v8_1[v10][v12_1] = new Distance();
            }
        }

        int[] v10_1 = new int[v3_1];
        v12_1 = 0;
        while(v12_1 < 10) {
            int v13 = 0;
            while(v13 < v3_1) {
                v14 = v13 + 1;
                v15 = v14;
                while(v15 < v3_1) {
                    arg25 = v0;
                    arg26 = v1;
                    v0_1 = ((PointProvider)v6).distance(v5_1[v13], v5_1[v15]);
                    v8_1[v15][v13].distance = v0_1;
                    v8_1[v15][v13].index = v13;
                    v8_1[v13][v15].distance = v0_1;
                    v8_1[v13][v15].index = v15;
                    ++v15;
                    v0 = arg25;
                    v1 = arg26;
                    v11 = v11;
                }

                arg25 = v0;
                arg26 = v1;
                v16 = v11;
                Arrays.sort(v8_1[v13]);
                int v0_2;
                for(v0_2 = 0; v0_2 < v3_1; ++v0_2) {
                    v2_1[v13][v0_2] = v8_1[v13][v0_2].index;
                }

                v0 = arg25;
                v1 = arg26;
                v13 = v14;
                v11 = v16;
            }

            arg25 = v0;
            arg26 = v1;
            v16 = v11;
            v0_2 = 0;
            v1_1 = 0;
            while(v0_2 < v9) {
                double[] v7 = v4[v0_2];
                v11 = arg26[v0_2];
                v13_1 = ((PointProvider)v6).distance(v7, v5_1[v11]);
                int v18 = v0_2;
                v19 = v13_1;
                v0_2 = -1;
                v15 = 0;
                while(v15 < v3_1) {
                    v22 = v1_1;
                    v21 = v2_1;
                    if(v8_1[v11][v15].distance >= 4 * v13_1) {
                    }
                    else {
                        double v1_2 = ((PointProvider)v6).distance(v7, v5_1[v15]);
                        if(v1_2 < v19) {
                            v19 = v1_2;
                            v0_2 = v15;
                        }
                    }

                    ++v15;
                    v2_1 = v21;
                    v1_1 = v22;
                }

                v22 = v1_1;
                v21 = v2_1;
                if(v0_2 == -1 || Math.abs(Math.sqrt(v19) - Math.sqrt(v13_1)) <= 3) {
                    v1_1 = v22;
                }
                else {
                    v1_1 = v22 + 1;
                    arg26[v18] = v0_2;
                }

                v0_2 = v18 + 1;
                v2_1 = v21;
            }

            v21 = v2_1;
            if(v1_1 == 0 && v12_1 != 0) {
                break;
            }

            double[] v0_3 = new double[v3_1];
            double[] v1_3 = new double[v3_1];
            double[] v2_2 = new double[v3_1];
            v7_1 = 0;
            Arrays.fill(v10_1, 0);
            v11 = 0;
            while(v11 < v9) {
                v14 = arg26[v11];
                v15_1 = v4[v11];
                int v17 = v7_1;
                v7_1 = arg25[v11];
                v10_1[v14] += v7_1;
                double v18_1 = v0_3[v14];
                int v20 = v14;
                v13_1 = ((double)v7_1);
                v0_3[v20] = v18_1 + v15_1[v17] * v13_1;
                v1_3[v20] += v15_1[v16] * v13_1;
                v2_2[v20] += v15_1[2] * v13_1;
                ++v11;
                v7_1 = 0;
            }

            arg27 = 2;
            v7_1 = 0;
            while(v7_1 < v3_1) {
                v11 = v10_1[v7_1];
                if(v11 == 0) {
                    v5_1[v7_1] = new double[]{0, 0, 0};
                    v15_1 = v0_3;
                    v18_2 = v1_3;
                }
                else {
                    v13_1 = v0_3[v7_1];
                    v15_1 = v0_3;
                    v18_2 = v1_3;
                    v0_1 = ((double)v11);
                    v13_1 /= v0_1;
                    v19 = v18_2[v7_1] / v0_1;
                    double v22_1 = v2_2[v7_1] / v0_1;
                    v0_3 = v5_1[v7_1];
                    v0_3[0] = v13_1;
                    v0_3[v16] = v19;
                    v0_3[arg27] = v22_1;
                }

                ++v7_1;
                v0_3 = v15_1;
                v1_3 = v18_2;
            }

            ++v12_1;
            v0 = arg25;
            v1 = arg26;
            v11 = v16;
            v2_1 = v21;
        }

        LinkedHashMap v0_4 = new LinkedHashMap();
        for(v7_1 = 0; v7_1 < v3_1; ++v7_1) {
            v1_1 = v10_1[v7_1];
            if(v1_1 == 0) {
            }
            else {
                int v2_3 = ((PointProvider)v6).toInt(v5_1[v7_1]);
                if(((Map)v0_4).containsKey(Integer.valueOf(v2_3))) {
                }
                else {
                    ((Map)v0_4).put(Integer.valueOf(v2_3), Integer.valueOf(v1_1));
                }
            }
        }

        return ((Map)v0_4);
    }
}

