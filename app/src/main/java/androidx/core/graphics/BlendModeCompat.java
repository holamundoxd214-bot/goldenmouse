package androidx.core.graphics;

public enum BlendModeCompat {
    public static final enum BlendModeCompat CLEAR;
    public static final enum BlendModeCompat COLOR;
    public static final enum BlendModeCompat COLOR_BURN;
    public static final enum BlendModeCompat COLOR_DODGE;
    public static final enum BlendModeCompat DARKEN;
    public static final enum BlendModeCompat DIFFERENCE;
    public static final enum BlendModeCompat DST;
    public static final enum BlendModeCompat DST_ATOP;
    public static final enum BlendModeCompat DST_IN;
    public static final enum BlendModeCompat DST_OUT;
    public static final enum BlendModeCompat DST_OVER;
    public static final enum BlendModeCompat EXCLUSION;
    public static final enum BlendModeCompat HARD_LIGHT;
    public static final enum BlendModeCompat HUE;
    public static final enum BlendModeCompat LIGHTEN;
    public static final enum BlendModeCompat LUMINOSITY;
    public static final enum BlendModeCompat MODULATE;
    public static final enum BlendModeCompat MULTIPLY;
    public static final enum BlendModeCompat OVERLAY;
    public static final enum BlendModeCompat PLUS;
    public static final enum BlendModeCompat SATURATION;
    public static final enum BlendModeCompat SCREEN;
    public static final enum BlendModeCompat SOFT_LIGHT;
    public static final enum BlendModeCompat SRC;
    public static final enum BlendModeCompat SRC_ATOP;
    public static final enum BlendModeCompat SRC_IN;
    public static final enum BlendModeCompat SRC_OUT;
    public static final enum BlendModeCompat SRC_OVER;
    public static final enum BlendModeCompat XOR;

    private static BlendModeCompat[] $values() {
        return new BlendModeCompat[]{BlendModeCompat.CLEAR, BlendModeCompat.SRC, BlendModeCompat.DST, BlendModeCompat.SRC_OVER, BlendModeCompat.DST_OVER, BlendModeCompat.SRC_IN, BlendModeCompat.DST_IN, BlendModeCompat.SRC_OUT, BlendModeCompat.DST_OUT, BlendModeCompat.SRC_ATOP, BlendModeCompat.DST_ATOP, BlendModeCompat.XOR, BlendModeCompat.PLUS, BlendModeCompat.MODULATE, BlendModeCompat.SCREEN, BlendModeCompat.OVERLAY, BlendModeCompat.DARKEN, BlendModeCompat.LIGHTEN, BlendModeCompat.COLOR_DODGE, BlendModeCompat.COLOR_BURN, BlendModeCompat.HARD_LIGHT, BlendModeCompat.SOFT_LIGHT, BlendModeCompat.DIFFERENCE, BlendModeCompat.EXCLUSION, BlendModeCompat.MULTIPLY, BlendModeCompat.HUE, BlendModeCompat.SATURATION, BlendModeCompat.COLOR, BlendModeCompat.LUMINOSITY};
    }

    static {
        BlendModeCompat.CLEAR = new BlendModeCompat("CLEAR", 0);
        BlendModeCompat.SRC = new BlendModeCompat("SRC", 1);
        BlendModeCompat.DST = new BlendModeCompat("DST", 2);
        BlendModeCompat.SRC_OVER = new BlendModeCompat("SRC_OVER", 3);
        BlendModeCompat.DST_OVER = new BlendModeCompat("DST_OVER", 4);
        BlendModeCompat.SRC_IN = new BlendModeCompat("SRC_IN", 5);
        BlendModeCompat.DST_IN = new BlendModeCompat("DST_IN", 6);
        BlendModeCompat.SRC_OUT = new BlendModeCompat("SRC_OUT", 7);
        BlendModeCompat.DST_OUT = new BlendModeCompat("DST_OUT", 8);
        BlendModeCompat.SRC_ATOP = new BlendModeCompat("SRC_ATOP", 9);
        BlendModeCompat.DST_ATOP = new BlendModeCompat("DST_ATOP", 10);
        BlendModeCompat.XOR = new BlendModeCompat("XOR", 11);
        BlendModeCompat.PLUS = new BlendModeCompat("PLUS", 12);
        BlendModeCompat.MODULATE = new BlendModeCompat("MODULATE", 13);
        BlendModeCompat.SCREEN = new BlendModeCompat("SCREEN", 14);
        BlendModeCompat.OVERLAY = new BlendModeCompat("OVERLAY", 15);
        BlendModeCompat.DARKEN = new BlendModeCompat("DARKEN", 16);
        BlendModeCompat.LIGHTEN = new BlendModeCompat("LIGHTEN", 17);
        BlendModeCompat.COLOR_DODGE = new BlendModeCompat("COLOR_DODGE", 18);
        BlendModeCompat.COLOR_BURN = new BlendModeCompat("COLOR_BURN", 19);
        BlendModeCompat.HARD_LIGHT = new BlendModeCompat("HARD_LIGHT", 20);
        BlendModeCompat.SOFT_LIGHT = new BlendModeCompat("SOFT_LIGHT", 21);
        BlendModeCompat.DIFFERENCE = new BlendModeCompat("DIFFERENCE", 22);
        BlendModeCompat.EXCLUSION = new BlendModeCompat("EXCLUSION", 23);
        BlendModeCompat.MULTIPLY = new BlendModeCompat("MULTIPLY", 24);
        BlendModeCompat.HUE = new BlendModeCompat("HUE", 25);
        BlendModeCompat.SATURATION = new BlendModeCompat("SATURATION", 26);
        BlendModeCompat.COLOR = new BlendModeCompat("COLOR", 27);
        BlendModeCompat.LUMINOSITY = new BlendModeCompat("LUMINOSITY", 28);
        BlendModeCompat.$VALUES = BlendModeCompat.$values();
    }

    private BlendModeCompat(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static BlendModeCompat valueOf(String arg1) {
        return Enum.valueOf(BlendModeCompat.class, arg1);
    }

    public static BlendModeCompat[] values() {
        return BlendModeCompat.$VALUES.clone();
    }
}

