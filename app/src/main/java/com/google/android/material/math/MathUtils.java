package com.google.android.material.math;

public final class MathUtils {
    public static final float DEFAULT_EPSILON = 0.0001f;

    private MathUtils() {
        super();
    }

    public static float dist(float arg0, float arg1, float arg2, float arg3) {
        return ((float)Math.hypot(((double)(arg2 - arg0)), ((double)(arg3 - arg1))));
    }

    public static float distanceToFurthestCorner(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6) {
        return MathUtils.max(MathUtils.dist(arg1, arg2, arg3, arg4), MathUtils.dist(arg1, arg2, arg5, arg4), MathUtils.dist(arg1, arg2, arg5, arg6), MathUtils.dist(arg1, arg2, arg3, arg6));
    }

    public static float floorMod(float arg3, int arg4) {
        float v0 = ((float)arg4);
        int v1 = ((int)(arg3 / v0));
        if(Math.signum(arg3) * v0 < 0f && (((float)(v1 * arg4))) != arg3) {
            --v1;
        }

        return arg3 - (((float)(v1 * arg4)));
    }

    public static int floorMod(int arg2, int arg3) {
        int v0 = arg2 / arg3;
        if((arg2 ^ arg3) < 0 && v0 * arg3 != arg2) {
            --v0;
        }

        return arg2 - v0 * arg3;
    }

    public static boolean geq(float arg0, float arg1, float arg2) {
        if(arg0 + arg2 >= arg1) {
            return 1;
        }

        return 0;
    }

    public static float lerp(float arg1, float arg2, float arg3) {
        return (1f - arg3) * arg1 + arg3 * arg2;
    }

    private static float max(float arg1, float arg2, float arg3, float arg4) {
        if(arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
            return arg1;
        }

        if(arg2 > arg3 && arg2 > arg4) {
            return arg2;
        }

        if(arg3 > arg4) {
            return arg3;
        }

        return arg4;
    }
}

