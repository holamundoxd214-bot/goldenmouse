package com.google.android.material.color.utilities;

public class SchemeVibrant extends DynamicScheme {
    private static final double[] HUES;
    private static final double[] SECONDARY_ROTATIONS;
    private static final double[] TERTIARY_ROTATIONS;

    static {
        SchemeVibrant.HUES = new double[]{0, 41, 61, 101, 131, 181, 251, 301, 360};
        SchemeVibrant.SECONDARY_ROTATIONS = new double[]{18, 15, 10, 12, 15, 18, 15, 12, 12};
        SchemeVibrant.TERTIARY_ROTATIONS = new double[]{35, 30, 20, 25, 30, 35, 30, 25, 25};
    }

    public SchemeVibrant(Hct arg12, boolean arg13, double arg14) {
        super(arg12, Variant.VIBRANT, arg13, arg14, TonalPalette.fromHueAndChroma(arg12.getHue(), 200), TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(arg12, SchemeVibrant.HUES, SchemeVibrant.SECONDARY_ROTATIONS), 24), TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(arg12, SchemeVibrant.HUES, SchemeVibrant.TERTIARY_ROTATIONS), 32), TonalPalette.fromHueAndChroma(arg12.getHue(), 10), TonalPalette.fromHueAndChroma(arg12.getHue(), 12));
    }
}

