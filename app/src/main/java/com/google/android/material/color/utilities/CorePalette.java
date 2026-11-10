package com.google.android.material.color.utilities;

public final class CorePalette {
    public TonalPalette a1;
    public TonalPalette a2;
    public TonalPalette a3;
    public TonalPalette error;
    public TonalPalette n1;
    public TonalPalette n2;

    private CorePalette(int arg11, boolean arg12) {
        super();
        Hct v11 = Hct.fromInt(arg11);
        double v0 = v11.getHue();
        double v2 = v11.getChroma();
        double v4 = 8;
        double v6 = 4;
        double v8 = 60;
        if(arg12) {
            this.a1 = TonalPalette.fromHueAndChroma(v0, v2);
            this.a2 = TonalPalette.fromHueAndChroma(v0, v2 / 3);
            this.a3 = TonalPalette.fromHueAndChroma(v8 + v0, v2 / 2);
            this.n1 = TonalPalette.fromHueAndChroma(v0, Math.min(v2 / 12, v6));
            this.n2 = TonalPalette.fromHueAndChroma(v0, Math.min(v2 / 6, v4));
        }
        else {
            this.a1 = TonalPalette.fromHueAndChroma(v0, Math.max(48, v2));
            this.a2 = TonalPalette.fromHueAndChroma(v0, 16);
            this.a3 = TonalPalette.fromHueAndChroma(v8 + v0, 24);
            this.n1 = TonalPalette.fromHueAndChroma(v0, v6);
            this.n2 = TonalPalette.fromHueAndChroma(v0, v4);
        }

        this.error = TonalPalette.fromHueAndChroma(25, 84);
    }

    public static CorePalette contentOf(int arg2) {
        return new CorePalette(arg2, true);
    }

    public static CorePalette of(int arg2) {
        return new CorePalette(arg2, false);
    }
}

