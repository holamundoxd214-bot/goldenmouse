package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;

public class ArgbEvaluator implements TypeEvaluator {
    private static final ArgbEvaluator sInstance;

    static {
        ArgbEvaluator.sInstance = new ArgbEvaluator();
    }

    public ArgbEvaluator() {
        super();
    }

    public Object evaluate(float arg11, Object arg12, Object arg13) {
        int v10 = ((Integer)arg12).intValue();
        float v12 = (((float)(v10 >> 24 & 0xFF))) / 255f;
        int v13 = ((Integer)arg13).intValue();
        float v1 = ((float)Math.pow(((double)((((float)(v10 >> 16 & 0xFF))) / 255f)), 2.2));
        float v2 = ((float)Math.pow(((double)((((float)(v10 >> 8 & 0xFF))) / 255f)), 2.2));
        float v10_1 = ((float)Math.pow(((double)((((float)(v10 & 0xFF))) / 255f)), 2.2));
        return Integer.valueOf(Math.round((((float)Math.pow(((double)(v10_1 + arg11 * ((((float)Math.pow(((double)((((float)(v13 & 0xFF))) / 255f)), 2.2))) - v10_1))), 0.454545))) * 255f) | (Math.round((((float)Math.pow(((double)(v1 + ((((float)Math.pow(((double)((((float)(v13 >> 16 & 0xFF))) / 255f)), 2.2))) - v1) * arg11)), 0.454545))) * 255f) << 16 | Math.round((v12 + ((((float)(v13 >> 24 & 0xFF))) / 255f - v12) * arg11) * 255f) << 24 | Math.round((((float)Math.pow(((double)(v2 + ((((float)Math.pow(((double)((((float)(v13 >> 8 & 0xFF))) / 255f)), 2.2))) - v2) * arg11)), 0.454545))) * 255f) << 8));
    }

    public static ArgbEvaluator getInstance() {
        return ArgbEvaluator.sInstance;
    }
}

