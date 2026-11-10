package com.google.android.material.color.utilities;

public class SchemeTonalSpot extends DynamicScheme {
    public SchemeTonalSpot(Hct arg12, boolean arg13, double arg14) {
        super(arg12, Variant.TONAL_SPOT, arg13, arg14, TonalPalette.fromHueAndChroma(arg12.getHue(), 36), TonalPalette.fromHueAndChroma(arg12.getHue(), 16), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(arg12.getHue() + 60), 24), TonalPalette.fromHueAndChroma(arg12.getHue(), 6), TonalPalette.fromHueAndChroma(arg12.getHue(), 8));
    }
}

