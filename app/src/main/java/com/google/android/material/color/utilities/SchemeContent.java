package com.google.android.material.color.utilities;

public class SchemeContent extends DynamicScheme {
    public SchemeContent(Hct arg16, boolean arg17, double arg18) {
        super(arg16, Variant.CONTENT, arg17, arg18, TonalPalette.fromHueAndChroma(arg16.getHue(), arg16.getChroma()), TonalPalette.fromHueAndChroma(arg16.getHue(), Math.max(arg16.getChroma() - 32, arg16.getChroma() * 0.5)), TonalPalette.fromHct(DislikeAnalyzer.fixIfDisliked(new TemperatureCache(arg16).getAnalogousColors(3, 6).get(2))), TonalPalette.fromHueAndChroma(arg16.getHue(), arg16.getChroma() / 8), TonalPalette.fromHueAndChroma(arg16.getHue(), arg16.getChroma() / 8 + 4));
    }
}

