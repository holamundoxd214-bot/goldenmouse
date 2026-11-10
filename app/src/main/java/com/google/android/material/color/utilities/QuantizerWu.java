package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;

public final class QuantizerWu implements Quantizer {
    class com.google.android.material.color.utilities.QuantizerWu$1 {
        static {
            int[] v0 = new int[Direction.values().length];
            com.google.android.material.color.utilities.QuantizerWu$1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = v0;
            try {
                v0[Direction.RED.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    com.google.android.material.color.utilities.QuantizerWu$1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.GREEN.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        com.google.android.material.color.utilities.QuantizerWu$1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.BLUE.ordinal()] = 3;
                        return;
                    }
                    catch(NoSuchFieldError ) {
                        return;
                    }
                }
            }
        }
    }

    final class Box {
        int b0;
        int b1;
        int g0;
        int g1;
        int r0;
        int r1;
        int vol;

        Box(com.google.android.material.color.utilities.QuantizerWu$1 arg1) {
            this();
        }

        private Box() {
            super();
            this.r0 = 0;
            this.r1 = 0;
            this.g0 = 0;
            this.g1 = 0;
            this.b0 = 0;
            this.b1 = 0;
            this.vol = 0;
        }
    }

    final class CreateBoxesResult {
        int resultCount;

        CreateBoxesResult(int arg1, int arg2) {
            super();
            this.resultCount = arg2;
        }
    }

    enum Direction {
        public static final enum Direction BLUE;
        public static final enum Direction GREEN;
        public static final enum Direction RED;

        static {
            Direction v0 = new Direction("RED", 0);
            Direction.RED = v0;
            Direction v1 = new Direction("GREEN", 1);
            Direction.GREEN = v1;
            Direction v2 = new Direction("BLUE", 2);
            Direction.BLUE = v2;
            Direction.$VALUES = new Direction[]{v0, v1, v2};
        }

        private Direction(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Direction valueOf(String arg1) {
            return Enum.valueOf(Direction.class, arg1);
        }

        public static Direction[] values() {
            return Direction.$VALUES.clone();
        }
    }

    final class MaximizeResult {
        int cutLocation;
        double maximum;

        MaximizeResult(int arg1, double arg2) {
            super();
            this.cutLocation = arg1;
            this.maximum = arg2;
        }
    }

    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 0x8C61;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    public QuantizerWu() {
        super();
    }

    static int bottom(Box arg3, Direction arg4, int[] arg5) {
        int v3;
        int v4;
        int v0 = com.google.android.material.color.utilities.QuantizerWu$1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[arg4.ordinal()];
        if(v0 == 1) {
            v4 = -arg5[QuantizerWu.getIndex(arg3.r0, arg3.g1, arg3.b1)] + arg5[QuantizerWu.getIndex(arg3.r0, arg3.g1, arg3.b0)] + arg5[QuantizerWu.getIndex(arg3.r0, arg3.g0, arg3.b1)];
            v3 = arg5[QuantizerWu.getIndex(arg3.r0, arg3.g0, arg3.b0)];
        }
        else if(v0 == 2) {
            v4 = -arg5[QuantizerWu.getIndex(arg3.r1, arg3.g0, arg3.b1)] + arg5[QuantizerWu.getIndex(arg3.r1, arg3.g0, arg3.b0)] + arg5[QuantizerWu.getIndex(arg3.r0, arg3.g0, arg3.b1)];
            v3 = arg5[QuantizerWu.getIndex(arg3.r0, arg3.g0, arg3.b0)];
        }
        else if(v0 == 3) {
            v4 = -arg5[QuantizerWu.getIndex(arg3.r1, arg3.g1, arg3.b0)] + arg5[QuantizerWu.getIndex(arg3.r1, arg3.g0, arg3.b0)] + arg5[QuantizerWu.getIndex(arg3.r0, arg3.g1, arg3.b0)];
            v3 = arg5[QuantizerWu.getIndex(arg3.r0, arg3.g0, arg3.b0)];
        }
        else {
            throw new IllegalArgumentException("unexpected direction " + arg4);
        }

        return v4 - v3;
    }

    void constructHistogram(Map arg9) {
        this.weights = new int[0x8C61];
        this.momentsR = new int[0x8C61];
        this.momentsG = new int[0x8C61];
        this.momentsB = new int[0x8C61];
        this.moments = new double[0x8C61];
        Iterator v9 = arg9.entrySet().iterator();
        while(v9.hasNext()) {
            Object v0 = v9.next();
            int v1 = ((Map$Entry)v0).getKey().intValue();
            int v0_1 = ((Map$Entry)v0).getValue().intValue();
            int v2 = ColorUtils.redFromArgb(v1);
            int v3 = ColorUtils.greenFromArgb(v1);
            v1 = ColorUtils.blueFromArgb(v1);
            int v4 = QuantizerWu.getIndex((v2 >> 3) + 1, (v3 >> 3) + 1, (v1 >> 3) + 1);
            this.weights[v4] += v0_1;
            this.momentsR[v4] += v2 * v0_1;
            this.momentsG[v4] += v3 * v0_1;
            this.momentsB[v4] += v1 * v0_1;
            this.moments[v4] += ((double)(v0_1 * (v2 * v2 + v3 * v3 + v1 * v1)));
        }
    }

    CreateBoxesResult createBoxes(int arg14) {
        double v4_1;
        this.cubes = new Box[arg14];
        int v1;
        for(v1 = 0; v1 < arg14; ++v1) {
            this.cubes[v1] = new Box(null);
        }

        double[] v1_1 = new double[arg14];
        Box v2 = this.cubes[0];
        v2.r1 = 0x20;
        v2.g1 = 0x20;
        v2.b1 = 0x20;
        int v4 = 0;
        int v3 = 1;
        while(v3 < arg14) {
            double v6 = 0;
            if(this.cut(this.cubes[v4], this.cubes[v3]).booleanValue()) {
                double v8 = this.cubes[v4].vol > 1 ? this.variance(this.cubes[v4]) : v6;
                v1_1[v4] = v8;
                v4_1 = this.cubes[v3].vol > 1 ? this.variance(this.cubes[v3]) : v6;
                v1_1[v3] = v4_1;
            }
            else {
                v1_1[v4] = v6;
                --v3;
            }

            v4_1 = v1_1[0];
            int v8_1 = 0;
            int v9;
            for(v9 = 1; v9 <= v3; ++v9) {
                double v10 = v1_1[v9];
                if(v10 > v4_1) {
                    v8_1 = v9;
                    v4_1 = v10;
                }
            }

            if(v4_1 <= v6) {
                ++v3;
                goto label_70;
            }

            ++v3;
            v4 = v8_1;
        }

        v3 = arg14;
    label_70:
        return new CreateBoxesResult(arg14, v3);
    }

    void createMoments() {
        QuantizerWu v0 = this;
        int v2;
        for(v2 = 1; true; ++v2) {
            int v3 = 33;
            if(v2 >= v3) {
                return;
            }

            int[] v4 = new int[v3];
            int[] v5 = new int[v3];
            int[] v6 = new int[v3];
            int[] v7 = new int[v3];
            double[] v8 = new double[v3];
            int v9 = 1;
            while(v9 < v3) {
                int v10 = 0;
                int v13 = 0;
                double v14 = 0;
                int v1 = 1;
                int v11 = 0;
                int v12 = 0;
                while(v1 < v3) {
                    int v16 = QuantizerWu.getIndex(v2, v9, v1);
                    v10 += v0.weights[v16];
                    v11 += v0.momentsR[v16];
                    v12 += v0.momentsG[v16];
                    v13 += v0.momentsB[v16];
                    v14 += v0.moments[v16];
                    v4[v1] += v10;
                    v5[v1] += v11;
                    v6[v1] += v12;
                    v7[v1] += v13;
                    v8[v1] += v14;
                    v3 = QuantizerWu.getIndex(v2 - 1, v9, v1);
                    v0.weights[v16] = v0.weights[v3] + v4[v1];
                    v0.momentsR[v16] = v0.momentsR[v3] + v5[v1];
                    v0.momentsG[v16] = v0.momentsG[v3] + v6[v1];
                    v0.momentsB[v16] = v0.momentsB[v3] + v7[v1];
                    v0.moments[v16] = v0.moments[v3] + v8[v1];
                    ++v1;
                    v3 = 33;
                }

                ++v9;
                v3 = 33;
            }
        }
    }

    List createResult(int arg8) {
        ArrayList v0 = new ArrayList();
        int v1;
        for(v1 = 0; v1 < arg8; ++v1) {
            Box v2 = this.cubes[v1];
            int v3 = QuantizerWu.volume(v2, this.weights);
            if(v3 > 0) {
                ((List)v0).add(Integer.valueOf(QuantizerWu.volume(v2, this.momentsB) / v3 & 0xFF | ((QuantizerWu.volume(v2, this.momentsR) / v3 & 0xFF) << 16 | 0xFF000000 | (QuantizerWu.volume(v2, this.momentsG) / v3 & 0xFF) << 8)));
            }
        }

        return ((List)v0);
    }

    Boolean cut(Box arg12, Box arg13) {
        Direction v1_1;
        int v6 = QuantizerWu.volume(arg12, this.momentsR);
        int v7 = QuantizerWu.volume(arg12, this.momentsG);
        int v8 = QuantizerWu.volume(arg12, this.momentsB);
        int v9 = QuantizerWu.volume(arg12, this.weights);
        QuantizerWu v1 = this;
        Box v2 = arg12;
        MaximizeResult v11 = v1.maximize(v2, Direction.RED, arg12.r0 + 1, arg12.r1, v6, v7, v8, v9);
        MaximizeResult v12 = v1.maximize(v2, Direction.GREEN, v2.g0 + 1, v2.g1, v6, v7, v8, v9);
        MaximizeResult v0 = v1.maximize(v2, Direction.BLUE, v2.b0 + 1, v2.b1, v6, v7, v8, v9);
        double v3 = v11.maximum;
        double v5 = v12.maximum;
        double v7_1 = v0.maximum;
        if(v3 < v5 || v3 < v7_1) {
            if(v5 >= v3 && v5 >= v7_1) {
                v1_1 = Direction.GREEN;
                goto label_43;
            }

            v1_1 = Direction.BLUE;
        }
        else if(v11.cutLocation < 0) {
            return Boolean.valueOf(false);
        }
        else {
            v1_1 = Direction.RED;
        }

    label_43:
        arg13.r1 = v2.r1;
        arg13.g1 = v2.g1;
        arg13.b1 = v2.b1;
        int v1_2 = com.google.android.material.color.utilities.QuantizerWu$1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[v1_1.ordinal()];
        if(v1_2 == 1) {
            v2.r1 = v11.cutLocation;
            arg13.r0 = v2.r1;
            arg13.g0 = v2.g0;
            arg13.b0 = v2.b0;
        }
        else if(v1_2 == 2) {
            v2.g1 = v12.cutLocation;
            arg13.r0 = v2.r0;
            arg13.g0 = v2.g1;
            arg13.b0 = v2.b0;
        }
        else if(v1_2 != 3) {
        }
        else {
            v2.b1 = v0.cutLocation;
            arg13.r0 = v2.r0;
            arg13.g0 = v2.g0;
            arg13.b0 = v2.b1;
        }

        v2.vol = (v2.r1 - v2.r0) * (v2.g1 - v2.g0) * (v2.b1 - v2.b0);
        arg13.vol = (arg13.r1 - arg13.r0) * (arg13.g1 - arg13.g0) * (arg13.b1 - arg13.b0);
        return Boolean.valueOf(true);
    }

    static int getIndex(int arg2, int arg3, int arg4) {
        return (arg2 << 10) + (arg2 << 6) + arg2 + (arg3 << 5) + arg3 + arg4;
    }

    MaximizeResult maximize(Box arg19, Direction arg20, int arg21, int arg22, int arg23, int arg24, int arg25, int arg26) {
        QuantizerWu v0 = this;
        Box v1 = arg19;
        Direction v2 = arg20;
        int v3 = QuantizerWu.bottom(v1, v2, v0.momentsR);
        int v4 = QuantizerWu.bottom(v1, v2, v0.momentsG);
        int v5 = QuantizerWu.bottom(v1, v2, v0.momentsB);
        int v6 = QuantizerWu.bottom(v1, v2, v0.weights);
        int v11 = arg22;
        int v10 = -1;
        double v8 = 0;
        int v7 = arg21;
        while(v7 < v11) {
            int v12 = QuantizerWu.top(v1, v2, v7, v0.momentsR) + v3;
            int v13 = QuantizerWu.top(v1, v2, v7, v0.momentsG) + v4;
            int v14 = QuantizerWu.top(v1, v2, v7, v0.momentsB) + v5;
            int v15 = QuantizerWu.top(v1, v2, v7, v0.weights) + v6;
            if(v15 == 0) {
            }
            else {
                double v0_1 = (((double)(v12 * v12 + v13 * v13 + v14 * v14))) / (((double)v15));
                v12 = arg23 - v12;
                v13 = arg24 - v13;
                v14 = arg25 - v14;
                v15 = arg26 - v15;
                if(v15 == 0) {
                }
                else {
                    v0_1 += (((double)(v12 * v12 + v13 * v13 + v14 * v14))) / (((double)v15));
                    if(v0_1 > v8) {
                        v8 = v0_1;
                        v10 = v7;
                    }
                }
            }

            ++v7;
            v0 = this;
            v1 = arg19;
        }

        return new MaximizeResult(v10, v8);
    }

    public QuantizerResult quantize(int[] arg2, int arg3) {
        this.constructHistogram(new QuantizerMap().quantize(arg2, arg3).colorToCount);
        this.createMoments();
        List v1 = this.createResult(this.createBoxes(arg3).resultCount);
        LinkedHashMap v2 = new LinkedHashMap();
        Iterator v1_1 = v1.iterator();
        while(v1_1.hasNext()) {
            ((Map)v2).put(Integer.valueOf(v1_1.next().intValue()), Integer.valueOf(0));
        }

        return new QuantizerResult(((Map)v2));
    }

    static int top(Box arg2, Direction arg3, int arg4, int[] arg5) {
        int v2;
        int v3;
        int v0 = com.google.android.material.color.utilities.QuantizerWu$1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[arg3.ordinal()];
        if(v0 == 1) {
            v3 = arg5[QuantizerWu.getIndex(arg4, arg2.g1, arg2.b1)] - arg5[QuantizerWu.getIndex(arg4, arg2.g1, arg2.b0)] - arg5[QuantizerWu.getIndex(arg4, arg2.g0, arg2.b1)];
            v2 = arg5[QuantizerWu.getIndex(arg4, arg2.g0, arg2.b0)];
        }
        else if(v0 == 2) {
            v3 = arg5[QuantizerWu.getIndex(arg2.r1, arg4, arg2.b1)] - arg5[QuantizerWu.getIndex(arg2.r1, arg4, arg2.b0)] - arg5[QuantizerWu.getIndex(arg2.r0, arg4, arg2.b1)];
            v2 = arg5[QuantizerWu.getIndex(arg2.r0, arg4, arg2.b0)];
        }
        else if(v0 == 3) {
            v3 = arg5[QuantizerWu.getIndex(arg2.r1, arg2.g1, arg4)] - arg5[QuantizerWu.getIndex(arg2.r1, arg2.g0, arg4)] - arg5[QuantizerWu.getIndex(arg2.r0, arg2.g1, arg4)];
            v2 = arg5[QuantizerWu.getIndex(arg2.r0, arg2.g0, arg4)];
        }
        else {
            throw new IllegalArgumentException("unexpected direction " + arg3);
        }

        return v3 + v2;
    }

    double variance(Box arg10) {
        int v0 = QuantizerWu.volume(arg10, this.momentsR);
        int v1 = QuantizerWu.volume(arg10, this.momentsG);
        int v2 = QuantizerWu.volume(arg10, this.momentsB);
        return this.moments[QuantizerWu.getIndex(arg10.r1, arg10.g1, arg10.b1)] - this.moments[QuantizerWu.getIndex(arg10.r1, arg10.g1, arg10.b0)] - this.moments[QuantizerWu.getIndex(arg10.r1, arg10.g0, arg10.b1)] + this.moments[QuantizerWu.getIndex(arg10.r1, arg10.g0, arg10.b0)] - this.moments[QuantizerWu.getIndex(arg10.r0, arg10.g1, arg10.b1)] + this.moments[QuantizerWu.getIndex(arg10.r0, arg10.g1, arg10.b0)] + this.moments[QuantizerWu.getIndex(arg10.r0, arg10.g0, arg10.b1)] - this.moments[QuantizerWu.getIndex(arg10.r0, arg10.g0, arg10.b0)] - (((double)(v0 * v0 + v1 * v1 + v2 * v2))) / (((double)QuantizerWu.volume(arg10, this.weights)));
    }

    static int volume(Box arg4, int[] arg5) {
        return arg5[QuantizerWu.getIndex(arg4.r1, arg4.g1, arg4.b1)] - arg5[QuantizerWu.getIndex(arg4.r1, arg4.g1, arg4.b0)] - arg5[QuantizerWu.getIndex(arg4.r1, arg4.g0, arg4.b1)] + arg5[QuantizerWu.getIndex(arg4.r1, arg4.g0, arg4.b0)] - arg5[QuantizerWu.getIndex(arg4.r0, arg4.g1, arg4.b1)] + arg5[QuantizerWu.getIndex(arg4.r0, arg4.g1, arg4.b0)] + arg5[QuantizerWu.getIndex(arg4.r0, arg4.g0, arg4.b1)] - arg5[QuantizerWu.getIndex(arg4.r0, arg4.g0, arg4.b0)];
    }
}

