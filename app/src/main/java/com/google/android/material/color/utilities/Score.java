package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;

public final class Score {
    class ScoredComparator implements Comparator {
        public ScoredComparator() {
            super();
        }

        public int compare(ScoredHCT arg3, ScoredHCT arg4) {
            return Double.compare(arg4.score, arg3.score);
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((ScoredHCT)arg1), ((ScoredHCT)arg2));
        }
    }

    class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct arg1, double arg2) {
            super();
            this.hct = arg1;
            this.score = arg2;
        }
    }

    private static final int BLUE_500 = 0xFF4285F4;
    private static final double CUTOFF_CHROMA = 5;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3;
    private static final double WEIGHT_CHROMA_BELOW = 0.1;
    private static final double WEIGHT_PROPORTION = 0.7;

    private Score() {
        super();
    }

    public static List score(Map arg3) {
        return Score.score(arg3, 4, 0xFF4285F4, true);
    }

    public static List score(Map arg12, int arg13, int arg14, boolean arg15) {
        int v5_1;
        ArrayList v0 = new ArrayList();
        int v1 = 360;
        int[] v2 = new int[v1];
        Iterator v12 = arg12.entrySet().iterator();
        double v3;
        for(v3 = 0; v12.hasNext(); v3 += ((double)v5_1)) {
            Object v5 = v12.next();
            Hct v6 = Hct.fromInt(((Map$Entry)v5).getKey().intValue());
            ((List)v0).add(v6);
            int v6_1 = ((int)Math.floor(v6.getHue()));
            v5_1 = ((Map$Entry)v5).getValue().intValue();
            v2[v6_1] += v5_1;
        }

        double[] v12_1 = new double[v1];
        for(v5_1 = 0; v5_1 < v1; ++v5_1) {
            double v6_2 = (((double)v2[v5_1])) / v3;
            int v8;
            for(v8 = v5_1 - 14; v8 < v5_1 + 16; ++v8) {
                int v9 = MathUtils.sanitizeDegreesInt(v8);
                v12_1[v9] += v6_2;
            }
        }

        ArrayList v1_1 = new ArrayList();
        Iterator v0_1 = ((List)v0).iterator();
        while(v0_1.hasNext()) {
            Object v2_1 = v0_1.next();
            v3 = v12_1[MathUtils.sanitizeDegreesInt(((int)Math.round(((Hct)v2_1).getHue())))];
            if(arg15) {
                if(((Hct)v2_1).getChroma() < 5) {
                    continue;
                }

                if(v3 <= 0.01) {
                    continue;
                }
            }

            v3 = v3 * 100 * 0.7;
            double v7 = 48;
            double v5_2 = ((Hct)v2_1).getChroma() < v7 ? 0.1 : 0.3;
            ((List)v1_1).add(new ScoredHCT(((Hct)v2_1), v3 + (((Hct)v2_1).getChroma() - v7) * v5_2));
        }

        Collections.sort(((List)v1_1), new ScoredComparator());
        ArrayList v12_2 = new ArrayList();
        int v15;
        for(v15 = 90; v15 >= 15; --v15) {
            ((List)v12_2).clear();
            v0_1 = ((List)v1_1).iterator();
            do {
                if(!v0_1.hasNext()) {
                    break;
                }

                Hct v2_2 = v0_1.next().hct;
                Iterator v3_1 = ((List)v12_2).iterator();
                do {
                    if(v3_1.hasNext()) {
                        if(MathUtils.differenceDegrees(v2_2.getHue(), v3_1.next().getHue()) >= (((double)v15))) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_102;
                    }
                }
                while(true);

                continue;
            label_102:
                ((List)v12_2).add(v2_2);
            }
            while(((List)v12_2).size() < arg13);

            if(((List)v12_2).size() >= arg13) {
                break;
            }
        }

        ArrayList v13 = new ArrayList();
        if(((List)v12_2).isEmpty()) {
            ((List)v13).add(Integer.valueOf(arg14));
            return ((List)v13);
        }

        v12 = ((List)v12_2).iterator();
        while(v12.hasNext()) {
            ((List)v13).add(Integer.valueOf(v12.next().toInt()));
        }

        return ((List)v13);
    }

    public static List score(Map arg2, int arg3) {
        return Score.score(arg2, arg3, 0xFF4285F4, true);
    }

    public static List score(Map arg1, int arg2, int arg3) {
        return Score.score(arg1, arg2, arg3, true);
    }
}

