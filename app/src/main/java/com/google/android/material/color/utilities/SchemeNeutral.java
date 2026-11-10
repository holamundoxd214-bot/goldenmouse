package com.google.android.material.color.utilities;

public class SchemeNeutral extends DynamicScheme {
    public SchemeNeutral(Hct arg12, boolean arg13, double arg14) {
        super(arg12, Variant.NEUTRAL, arg13, arg14, TonalPalette.fromHueAndChroma(arg12.getHue(), 12), TonalPalette.fromHueAndChroma(arg12.getHue(), 8), TonalPalette.fromHueAndChroma(arg12.getHue(), 16), TonalPalette.fromHueAndChroma(arg12.getHue(), 2), TonalPalette.fromHueAndChroma(arg12.getHue(), 2));
    }
}

