package com.google.android.material.color.utilities;

public enum TonePolarity {
    public static final enum TonePolarity DARKER;
    public static final enum TonePolarity FARTHER;
    public static final enum TonePolarity LIGHTER;
    public static final enum TonePolarity NEARER;

    static {
        TonePolarity v0 = new TonePolarity("DARKER", 0);
        TonePolarity.DARKER = v0;
        TonePolarity v1 = new TonePolarity("LIGHTER", 1);
        TonePolarity.LIGHTER = v1;
        TonePolarity v2 = new TonePolarity("NEARER", 2);
        TonePolarity.NEARER = v2;
        TonePolarity v3 = new TonePolarity("FARTHER", 3);
        TonePolarity.FARTHER = v3;
        TonePolarity.$VALUES = new TonePolarity[]{v0, v1, v2, v3};
    }

    private TonePolarity(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static TonePolarity valueOf(String arg1) {
        return Enum.valueOf(TonePolarity.class, arg1);
    }

    public static TonePolarity[] values() {
        return TonePolarity.$VALUES.clone();
    }
}

