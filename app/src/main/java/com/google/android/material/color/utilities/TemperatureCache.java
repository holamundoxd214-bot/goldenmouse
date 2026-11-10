package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List precomputedHctsByHue;
    private List precomputedHctsByTemp;
    private Map precomputedTempsByHct;

    public static int $r8$lambda$hQjdIIwNZ3zUpaMt273Bn5gwl-w(Double arg0, Double arg1) {
        return arg0.compareTo(arg1);
    }

    public TemperatureCache(Hct arg1) {
        super();
        this.input = arg1;
    }

    private TemperatureCache() {
        super();
        throw new UnsupportedOperationException();
    }

    public List getAnalogousColors(int arg20, int arg21) {
        int v4_2;
        Object v6;
        TemperatureCache v0 = this;
        int v1 = arg20;
        int v2 = arg21;
        int v3 = ((int)Math.round(v0.input.getHue()));
        Object v4 = v0.getHctsByHue().get(v3);
        double v5 = v0.getRelativeTemperature(((Hct)v4));
        ArrayList v7 = new ArrayList();
        ((List)v7).add(v4);
        double v8 = 0;
        double v12 = v8;
        int v11 = 0;
        while(true) {
            int v14 = 360;
            if(v11 >= v14) {
                break;
            }

            double v14_1 = v0.getRelativeTemperature(v0.getHctsByHue().get(MathUtils.sanitizeDegreesInt(v3 + v11)));
            v12 += Math.abs(v14_1 - v5);
            ++v11;
            v5 = v14_1;
        }

        v12 /= ((double)v2);
        double v4_1 = v0.getRelativeTemperature(((Hct)v4));
        v11 = 1;
        while(true) {
            if(((List)v7).size() < v2) {
                v6 = v0.getHctsByHue().get(MathUtils.sanitizeDegreesInt(v3 + v11));
                double v16 = v0.getRelativeTemperature(((Hct)v6));
                v8 += Math.abs(v16 - v4_1);
                v4_2 = v8 >= (((double)((List)v7).size())) * v12 ? 1 : 0;
                int v5_1 = 1;
                while(v4_2 != 0) {
                    if(((List)v7).size() >= v2) {
                        break;
                    }

                    ((List)v7).add(v6);
                    int v18 = v11;
                    v4_2 = v8 >= (((double)(((List)v7).size() + v5_1))) * v12 ? 1 : 0;
                    ++v5_1;
                    v11 = v18;
                }

                ++v11;
                if(v11 <= v14) {
                    v4_1 = v16;
                    continue;
                }

                break;
            }

            goto label_76;
        }

        while(((List)v7).size() < v2) {
            ((List)v7).add(v6);
        }

    label_76:
        ArrayList v2_1 = new ArrayList();
        ((List)v2_1).add(v0.input);
        int v0_1 = ((int)Math.floor(((((double)v1)) - 1) / 2));
        for(v3 = 1; v3 < v0_1 + 1; ++v3) {
            for(v4_2 = -v3; v4_2 < 0; v4_2 += ((List)v7).size()) {
            }

            if(v4_2 >= ((List)v7).size()) {
                v4_2 %= ((List)v7).size();
            }

            ((List)v2_1).add(0, ((List)v7).get(v4_2));
        }

        v0_1 = v1 - v0_1;
        int v6_1;
        for(v6_1 = 1; v6_1 < v0_1; ++v6_1) {
            for(v1 = v6_1; v1 < 0; v1 += ((List)v7).size()) {
            }

            if(v1 >= ((List)v7).size()) {
                v1 %= ((List)v7).size();
            }

            ((List)v2_1).add(((List)v7).get(v1));
        }

        return ((List)v2_1);
    }

    public List getAnalogousColors() {
        return this.getAnalogousColors(5, 12);
    }

    private Hct getColdest() {
        return this.getHctsByTemp().get(0);
    }

    public Hct getComplement() {
        double v20;
        TemperatureCache v0 = this;
        Hct v1 = v0.precomputedComplement;
        if(v1 != null) {
            return v1;
        }

        double v4 = v0.getColdest().getHue();
        double v8 = v0.getTempsByHct().get(v0.getColdest()).doubleValue();
        double v6 = v0.getWarmest().getHue();
        double v10 = v0.getTempsByHct().get(v0.getWarmest()).doubleValue() - v8;
        boolean v1_1 = TemperatureCache.isBetween(v0.input.getHue(), v4, v6);
        double v14 = v1_1 ? v6 : v4;
        double v16 = v1_1 ? v4 : v6;
        Object v1_2 = v0.getHctsByHue().get(((int)Math.round(v0.input.getHue())));
        v4 = 1;
        double v2 = v4 - v0.getRelativeTemperature(v0.input);
        v6 = 1000;
        double v18 = 0;
        while(v18 <= 360) {
            double v12 = MathUtils.sanitizeDegreesDouble(v4 * v18 + v14);
            if(!TemperatureCache.isBetween(v12, v14, v16)) {
                v20 = v4;
            }
            else {
                v20 = v4;
                Object v4_1 = v0.getHctsByHue().get(((int)Math.round(v12)));
                v12 = Math.abs(v2 - (v0.getTempsByHct().get(v4_1).doubleValue() - v8) / v10);
                if(v12 < v6) {
                    v1_2 = v4_1;
                    v6 = v12;
                }
            }

            v18 += v20;
            v4 = v20;
        }

        v0.precomputedComplement = ((Hct)v1_2);
        return ((Hct)v1_2);
    }

    private List getHctsByHue() {
        List v0 = this.precomputedHctsByHue;
        if(v0 != null) {
            return v0;
        }

        ArrayList v0_1 = new ArrayList();
        double v3;
        for(v3 = 0; v3 <= 360; ++v3) {
            ((List)v0_1).add(Hct.from(v3, this.input.getChroma(), this.input.getTone()));
        }

        v0 = Collections.unmodifiableList(((List)v0_1));
        this.precomputedHctsByHue = v0;
        return v0;
    }

    private List getHctsByTemp() {
        List v0 = this.precomputedHctsByTemp;
        if(v0 != null) {
            return v0;
        }

        ArrayList v0_1 = new ArrayList(this.getHctsByHue());
        ((List)v0_1).add(this.input);
        Collections.sort(((List)v0_1), Comparator.comparing(new TemperatureCache$$ExternalSyntheticLambda0(this), new TemperatureCache$$ExternalSyntheticLambda1()));
        this.precomputedHctsByTemp = ((List)v0_1);
        return ((List)v0_1);
    }

    public double getRelativeTemperature(Hct arg5) {
        double v0 = this.getTempsByHct().get(this.getWarmest()).doubleValue() - this.getTempsByHct().get(this.getColdest()).doubleValue();
        double v2 = this.getTempsByHct().get(arg5).doubleValue() - this.getTempsByHct().get(this.getColdest()).doubleValue();
        if(v0 == 0) {
            return 0.5;
        }

        return v2 / v0;
    }

    private Map getTempsByHct() {
        Map v0 = this.precomputedTempsByHct;
        if(v0 != null) {
            return v0;
        }

        ArrayList v0_1 = new ArrayList(this.getHctsByHue());
        ((List)v0_1).add(this.input);
        HashMap v1 = new HashMap();
        Iterator v0_2 = ((List)v0_1).iterator();
        while(v0_2.hasNext()) {
            Object v2 = v0_2.next();
            ((Map)v1).put(v2, Double.valueOf(TemperatureCache.rawTemperature(((Hct)v2))));
        }

        this.precomputedTempsByHct = ((Map)v1);
        return ((Map)v1);
    }

    private Hct getWarmest() {
        return this.getHctsByTemp().get(this.getHctsByTemp().size() - 1);
    }

    private static boolean isBetween(double arg3, double arg5, double arg7) {
        if(Double.compare(arg5, arg7) < 0) {
            if(arg5 <= arg3 && arg3 <= arg7) {
                return 1;
            }

            return 0;
        }

        if(arg5 > arg3) {
            if(arg3 <= arg7) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    Double lambda$getHctsByTemp$0$com-google-android-material-color-utilities-TemperatureCache(Hct arg1) {
        return this.getTempsByHct().get(arg1);
    }

    public static double rawTemperature(Hct arg7) {
        double[] v7 = ColorUtils.labFromArgb(arg7.toInt());
        return Math.pow(Math.hypot(v7[1], v7[2]), 1.07) * 0.02 * Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(v7[2], v7[1]))) - 50))) - 0.5;
    }
}

