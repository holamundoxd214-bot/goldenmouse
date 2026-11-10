package com.google.android.material.color.utilities;

public class SchemeMonochrome extends DynamicScheme {
    public SchemeMonochrome(Hct arg12, boolean arg13, double arg14) {
        super(arg12, Variant.MONOCHROME, arg13, arg14, TonalPalette.fromHueAndChroma(arg12.getHue(), 0), TonalPalette.fromHueAndChroma(arg12.getHue(), 0), TonalPalette.fromHueAndChroma(arg12.getHue(), 0), TonalPalette.fromHueAndChroma(arg12.getHue(), 0), TonalPalette.fromHueAndChroma(arg12.getHue(), 0));
    }
}

