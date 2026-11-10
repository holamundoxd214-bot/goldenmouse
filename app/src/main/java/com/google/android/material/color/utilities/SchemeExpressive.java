package com.google.android.material.color.utilities;

public class SchemeExpressive extends DynamicScheme {
    private static final double[] HUES;
    private static final double[] SECONDARY_ROTATIONS;
    private static final double[] TERTIARY_ROTATIONS;

    static {
        SchemeExpressive.HUES = new double[]{0, 21, 51, 121, 151, 191, 271, 321, 360};
        SchemeExpressive.SECONDARY_ROTATIONS = new double[]{45, 95, 45, 20, 45, 90, 45, 45, 45};
        SchemeExpressive.TERTIARY_ROTATIONS = new double[]{120, 120, 20, 45, 20, 15, 20, 120, 120};
    }

    public SchemeExpressive(Hct arg12, boolean arg13, double arg14) {
        super(arg12, Variant.EXPRESSIVE, arg13, arg14, TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(arg12.getHue() + 240), 40), TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(arg12, SchemeExpressive.HUES, SchemeExpressive.SECONDARY_ROTATIONS), 24), TonalPalette.fromHueAndChroma(DynamicScheme.getRotatedHue(arg12, SchemeExpressive.HUES, SchemeExpressive.TERTIARY_ROTATIONS), 32), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(arg12.getHue() + 15), 8), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(arg12.getHue() + 15), 12));
    }
}

