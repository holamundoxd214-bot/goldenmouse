package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.Map;

public final class TonalPalette {
    Map cache;
    double chroma;
    double hue;
    Hct keyColor;

    private TonalPalette(double arg2, double arg4, Hct arg6) {
        super();
        this.cache = new HashMap();
        this.hue = arg2;
        this.chroma = arg4;
        this.keyColor = arg6;
    }

    private static Hct createKeyColor(double arg15, double arg17) {
        double v4 = 50;
        Hct v6 = Hct.from(arg15, arg17, v4);
        double v0 = Math.abs(v6.getChroma() - arg17);
        double v2 = 1;
        double v13 = v2;
        while(v13 < 50) {
            if(Math.round(arg17) == Math.round(v6.getChroma())) {
            }
            else {
                Hct v11 = Hct.from(arg15, arg17, v4 + v13);
                double v7 = Math.abs(v11.getChroma() - arg17);
                if(v7 < v0) {
                    v0 = v7;
                    v6 = v11;
                }

                v11 = Hct.from(arg15, arg17, v4 - v13);
                v7 = Math.abs(v11.getChroma() - arg17);
                if(v7 < v0) {
                    v0 = v7;
                    v6 = v11;
                }

                v13 += v2;
                continue;
            }

            return v6;
        }

        return v6;
    }

    public static TonalPalette fromHct(Hct arg6) {
        return new TonalPalette(arg6.getHue(), arg6.getChroma(), arg6);
    }

    public static TonalPalette fromHueAndChroma(double arg6, double arg8) {
        return new TonalPalette(arg6, arg8, TonalPalette.createKeyColor(arg6, arg8));
    }

    public static TonalPalette fromInt(int arg0) {
        return TonalPalette.fromHct(Hct.fromInt(arg0));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double arg7) {
        return Hct.from(this.hue, this.chroma, arg7);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int arg8) {
        Integer v0_1;
        Object v0 = this.cache.get(Integer.valueOf(arg8));
        if(v0 == null) {
            v0_1 = Integer.valueOf(Hct.from(this.hue, this.chroma, ((double)arg8)).toInt());
            this.cache.put(Integer.valueOf(arg8), v0_1);
        }

        return v0_1.intValue();
    }
}

