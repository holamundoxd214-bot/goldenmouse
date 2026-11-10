package com.google.android.material.color.utilities;

public final class Hct {
    private int argb;
    private double chroma;
    private double hue;
    private double tone;

    private Hct(int arg1) {
        super();
        this.setInternalState(arg1);
    }

    public static Hct from(double arg0, double arg2, double arg4) {
        return new Hct(HctSolver.solveToInt(arg0, arg2, arg4));
    }

    public static Hct fromInt(int arg1) {
        return new Hct(arg1);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getTone() {
        return this.tone;
    }

    public Hct inViewingConditions(ViewingConditions arg8) {
        double[] v7 = Cam16.fromInt(this.toInt()).xyzInViewingConditions(arg8, null);
        Cam16 v0 = Cam16.fromXyzInViewingConditions(v7[0], v7[1], v7[2], ViewingConditions.DEFAULT);
        return Hct.from(v0.getHue(), v0.getChroma(), ColorUtils.lstarFromY(v7[1]));
    }

    public void setChroma(double arg7) {
        this.setInternalState(HctSolver.solveToInt(this.hue, arg7, this.tone));
    }

    public void setHue(double arg7) {
        this.setInternalState(HctSolver.solveToInt(arg7, this.chroma, this.tone));
    }

    private void setInternalState(int arg4) {
        this.argb = arg4;
        Cam16 v0 = Cam16.fromInt(arg4);
        this.hue = v0.getHue();
        this.chroma = v0.getChroma();
        this.tone = ColorUtils.lstarFromArgb(arg4);
    }

    public void setTone(double arg7) {
        this.setInternalState(HctSolver.solveToInt(this.hue, this.chroma, arg7));
    }

    public int toInt() {
        return this.argb;
    }
}

