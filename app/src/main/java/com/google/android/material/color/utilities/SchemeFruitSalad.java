package com.google.android.material.color.utilities;

public class SchemeFruitSalad extends DynamicScheme {
    public SchemeFruitSalad(Hct arg12, boolean arg13, double arg14) {
        super(arg12, Variant.FRUIT_SALAD, arg13, arg14, TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(arg12.getHue() - 50), 48), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(arg12.getHue() - 50), 36), TonalPalette.fromHueAndChroma(arg12.getHue(), 36), TonalPalette.fromHueAndChroma(arg12.getHue(), 10), TonalPalette.fromHueAndChroma(arg12.getHue(), 16));
    }
}

