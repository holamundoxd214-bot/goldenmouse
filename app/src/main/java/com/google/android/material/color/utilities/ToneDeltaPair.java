package com.google.android.material.color.utilities;

public final class ToneDeltaPair {
    private final double delta;
    private final TonePolarity polarity;
    private final DynamicColor roleA;
    private final DynamicColor roleB;
    private final boolean stayTogether;

    public ToneDeltaPair(DynamicColor arg1, DynamicColor arg2, double arg3, TonePolarity arg5, boolean arg6) {
        super();
        this.roleA = arg1;
        this.roleB = arg2;
        this.delta = arg3;
        this.polarity = arg5;
        this.stayTogether = arg6;
    }

    public double getDelta() {
        return this.delta;
    }

    public TonePolarity getPolarity() {
        return this.polarity;
    }

    public DynamicColor getRoleA() {
        return this.roleA;
    }

    public DynamicColor getRoleB() {
        return this.roleB;
    }

    public boolean getStayTogether() {
        return this.stayTogether;
    }
}

