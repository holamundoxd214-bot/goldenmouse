package com.google.android.material.color.utilities;

public class Blend {
    private Blend() {
        super();
    }

    public static int cam16Ucs(int arg18, int arg19, double arg20) {
        Cam16 v0 = Cam16.fromInt(arg18);
        Cam16 v1 = Cam16.fromInt(arg19);
        double v2 = v0.getJstar();
        double v4 = v0.getAstar();
        double v6 = v0.getBstar();
        return Cam16.fromUcs(v2 + (v1.getJstar() - v2) * arg20, v4 + (v1.getAstar() - v4) * arg20, v6 + (v1.getBstar() - v6) * arg20).toInt();
    }

    public static int harmonize(int arg10, int arg11) {
        Hct v10 = Hct.fromInt(arg10);
        Hct v11 = Hct.fromInt(arg11);
        return Hct.from(MathUtils.sanitizeDegreesDouble(v10.getHue() + Math.min(MathUtils.differenceDegrees(v10.getHue(), v11.getHue()) * 0.5, 15) * MathUtils.rotationDirection(v10.getHue(), v11.getHue())), v10.getChroma(), v10.getTone()).toInt();
    }

    public static int hctHue(int arg6, int arg7, double arg8) {
        return Hct.from(Cam16.fromInt(Blend.cam16Ucs(arg6, arg7, arg8)).getHue(), Cam16.fromInt(arg6).getChroma(), ColorUtils.lstarFromArgb(arg6)).toInt();
    }
}

