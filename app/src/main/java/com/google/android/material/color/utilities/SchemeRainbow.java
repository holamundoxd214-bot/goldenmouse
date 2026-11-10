package com.google.android.material.color.utilities;

public class SchemeRainbow extends DynamicScheme {
    public SchemeRainbow(Hct arg12, boolean arg13, double arg14) {
        super(arg12, Variant.RAINBOW, arg13, arg14, TonalPalette.fromHueAndChroma(arg12.getHue(), 48), TonalPalette.fromHueAndChroma(arg12.getHue(), 16), TonalPalette.fromHueAndChroma(MathUtils.sanitizeDegreesDouble(arg12.getHue() + 60), 24), TonalPalette.fromHueAndChroma(arg12.getHue(), 0), TonalPalette.fromHueAndChroma(arg12.getHue(), 0));
    }
}

