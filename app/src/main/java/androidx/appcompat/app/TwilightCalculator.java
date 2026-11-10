package androidx.appcompat.app;

class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10472f;
    private static final float C1 = 0.03342f;
    private static final float C2 = 0.000349f;
    private static final float C3 = 0.000005f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453f;
    private static final float J0 = 0.0009f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.40928f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
        super();
    }

    public void calculateTwilight(long arg15, double arg17, double arg19) {
        long v0 = 946728000000L;
        float v2 = (((float)(arg15 - v0))) / 86400000f;
        float v3 = 0.017202f * v2 + 6.24006f;
        double v4 = ((double)v3);
        double v8 = Math.sin(v4) * 0.03342 + v4 + Math.sin(((double)(2f * v3))) * 0.000349 + Math.sin(((double)(v3 * 3f))) * 0.000005 + 1.796593 + 3.141593;
        double v6 = -arg19 / 360;
        double v2_1 = (((double)((((float)Math.round((((double)(v2 - 0.0009f))) - v6))) + 0.0009f))) + v6 + Math.sin(v4) * 0.0053 + Math.sin(2 * v8) * -0.0069;
        v4 = Math.asin(Math.sin(v8) * Math.sin(0.40928));
        v6 = 0.017453 * arg17;
        v8 = (Math.sin(-0.10472) - Math.sin(v6) * Math.sin(v4)) / (Math.cos(v6) * Math.cos(v4));
        long v6_1 = -1;
        if(Double.compare(v8, 1) >= 0) {
            this.state = 1;
            this.sunset = v6_1;
            this.sunrise = v6_1;
            return;
        }

        if(Double.compare(v8, -1) <= 0) {
            this.state = 0;
            this.sunset = v6_1;
            this.sunrise = v6_1;
            return;
        }

        v6 = ((double)(((float)(Math.acos(v8) / 6.283185))));
        this.sunset = Math.round((v2_1 + v6) * 86400000) + v0;
        long v2_2 = Math.round((v2_1 - v6) * 86400000) + v0;
        this.sunrise = v2_2;
        if(v2_2 < arg15 && this.sunset > arg15) {
            this.state = 0;
            return;
        }

        this.state = 1;
    }

    static TwilightCalculator getInstance() {
        TwilightCalculator v0 = TwilightCalculator.sInstance;
        if(v0 == null) {
            v0 = new TwilightCalculator();
            TwilightCalculator.sInstance = v0;
        }

        return v0;
    }
}

