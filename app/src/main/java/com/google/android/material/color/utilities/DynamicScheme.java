package com.google.android.material.color.utilities;

public class DynamicScheme {
    public final double contrastLevel;
    public final TonalPalette errorPalette;
    public final boolean isDark;
    public final TonalPalette neutralPalette;
    public final TonalPalette neutralVariantPalette;
    public final TonalPalette primaryPalette;
    public final TonalPalette secondaryPalette;
    public final int sourceColorArgb;
    public final Hct sourceColorHct;
    public final TonalPalette tertiaryPalette;
    public final Variant variant;

    public DynamicScheme(Hct arg2, Variant arg3, boolean arg4, double arg5, TonalPalette arg7, TonalPalette arg8, TonalPalette arg9, TonalPalette arg10, TonalPalette arg11) {
        super();
        this.sourceColorArgb = arg2.toInt();
        this.sourceColorHct = arg2;
        this.variant = arg3;
        this.isDark = arg4;
        this.contrastLevel = arg5;
        this.primaryPalette = arg7;
        this.secondaryPalette = arg8;
        this.tertiaryPalette = arg9;
        this.neutralPalette = arg10;
        this.neutralVariantPalette = arg11;
        this.errorPalette = TonalPalette.fromHueAndChroma(25, 84);
    }

    public static double getRotatedHue(Hct arg8, double[] arg9, double[] arg10) {
        double v0 = arg8.getHue();
        int v3 = 0;
        if(arg10.length == 1) {
            return MathUtils.sanitizeDegreesDouble(v0 + arg10[0]);
        }

        int v8 = arg9.length;
        while(v3 <= v8 - 2) {
            double v4 = arg9[v3];
            int v2 = v3 + 1;
            double v6 = arg9[v2];
            if(v4 < v0 && v0 < v6) {
                return MathUtils.sanitizeDegreesDouble(v0 + arg10[v3]);
            }

            v3 = v2;
        }

        return v0;
    }
}

