package com.google.android.material.color.utilities;

public enum Variant {
    public static final enum Variant CONTENT;
    public static final enum Variant EXPRESSIVE;
    public static final enum Variant FIDELITY;
    public static final enum Variant FRUIT_SALAD;
    public static final enum Variant MONOCHROME;
    public static final enum Variant NEUTRAL;
    public static final enum Variant RAINBOW;
    public static final enum Variant TONAL_SPOT;
    public static final enum Variant VIBRANT;

    static {
        Variant v0 = new Variant("MONOCHROME", 0);
        Variant.MONOCHROME = v0;
        Variant v1 = new Variant("NEUTRAL", 1);
        Variant.NEUTRAL = v1;
        Variant v2 = new Variant("TONAL_SPOT", 2);
        Variant.TONAL_SPOT = v2;
        Variant v3 = new Variant("VIBRANT", 3);
        Variant.VIBRANT = v3;
        Variant v4 = new Variant("EXPRESSIVE", 4);
        Variant.EXPRESSIVE = v4;
        Variant v5 = new Variant("FIDELITY", 5);
        Variant.FIDELITY = v5;
        Variant v6 = new Variant("CONTENT", 6);
        Variant.CONTENT = v6;
        Variant v7 = new Variant("RAINBOW", 7);
        Variant.RAINBOW = v7;
        Variant v8 = new Variant("FRUIT_SALAD", 8);
        Variant.FRUIT_SALAD = v8;
        Variant.$VALUES = new Variant[]{v0, v1, v2, v3, v4, v5, v6, v7, v8};
    }

    private Variant(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static Variant valueOf(String arg1) {
        return Enum.valueOf(Variant.class, arg1);
    }

    public static Variant[] values() {
        return Variant.$VALUES.clone();
    }
}

