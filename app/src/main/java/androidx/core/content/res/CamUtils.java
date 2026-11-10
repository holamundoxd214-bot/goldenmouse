package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

final class CamUtils {
    static final float[][] CAM16RGB_TO_XYZ;
    static final float[][] SRGB_TO_XYZ;
    static final float[] WHITE_POINT_D65;
    static final float[][] XYZ_TO_CAM16RGB;

    static {
        CamUtils.XYZ_TO_CAM16RGB = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        CamUtils.CAM16RGB_TO_XYZ = new float[][]{new float[]{1.862068f, -1.011255f, 0.149187f}, new float[]{0.387527f, 0.621447f, -0.008974f}, new float[]{-0.015842f, -0.034123f, 1.049964f}};
        CamUtils.WHITE_POINT_D65 = new float[]{95.046997f, 100f, 108.883003f};
        CamUtils.SRGB_TO_XYZ = new float[][]{new float[]{0.412339f, 0.357621f, 0.18051f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.019321f, 0.119164f, 0.950345f}};
    }

    private CamUtils() {
        super();
    }

    static int intFromLStar(float arg15) {
        if(arg15 < 1f) {
            return 0xFF000000;
        }

        if(arg15 > 99f) {
            return -1;
        }

        float v0 = 16f;
        float v2 = 116f;
        float v1 = (arg15 + v0) / v2;
        float v4 = 903.296326f;
        if(Float.compare(arg15, 8f) > 0) {
            arg15 = v1 * v1 * v1;
        }
        else {
            arg15 /= v4;
        }

        float v3 = v1 * v1 * v1;
        int v5 = Float.compare(v3, 0.008856f) > 0 ? 1 : 0;
        float v8 = v5 != 0 ? v3 : (v1 * v2 - v0) / v4;
        if(v5 != 0) {
        }
        else {
            v3 = (v1 * v2 - v0) / v4;
        }

        return ColorUtils.XYZToColor(((double)(v8 * CamUtils.WHITE_POINT_D65[0])), ((double)(arg15 * CamUtils.WHITE_POINT_D65[1])), ((double)(v3 * CamUtils.WHITE_POINT_D65[2])));
    }

    static float lStarFromInt(int arg0) {
        return CamUtils.lStarFromY(CamUtils.yFromInt(arg0));
    }

    static float lStarFromY(float arg2) {
        arg2 /= 100f;
        if(arg2 <= 0.008856f) {
            return arg2 * 903.296326f;
        }

        return (((float)Math.cbrt(((double)arg2)))) * 116f - 16f;
    }

    static float lerp(float arg0, float arg1, float arg2) {
        return arg0 + (arg1 - arg0) * arg2;
    }

    static float linearized(int arg6) {
        float v6 = (((float)arg6)) / 255f;
        float v1 = 100f;
        if(Float.compare(v6, 0.04045f) <= 0) {
            v6 /= 12.92f;
        }
        else {
            v6 = ((float)Math.pow(((double)((v6 + 0.055f) / 1.055f)), 2.4));
        }

        return v6 * v1;
    }

    static void xyzFromInt(int arg9, float[] arg10) {
        float v0 = CamUtils.linearized(Color.red(arg9));
        float v1 = CamUtils.linearized(Color.green(arg9));
        float v9 = CamUtils.linearized(Color.blue(arg9));
        float[][] v2 = CamUtils.SRGB_TO_XYZ;
        arg10[0] = v2[0][0] * v0 + v2[0][1] * v1 + v2[0][2] * v9;
        arg10[1] = v2[1][0] * v0 + v2[1][1] * v1 + v2[1][2] * v9;
        arg10[2] = v0 * v2[2][0] + v1 * v2[2][1] + v9 * v2[2][2];
    }

    static float yFromInt(int arg5) {
        return CamUtils.linearized(Color.red(arg5)) * CamUtils.SRGB_TO_XYZ[1][0] + CamUtils.linearized(Color.green(arg5)) * CamUtils.SRGB_TO_XYZ[1][1] + CamUtils.linearized(Color.blue(arg5)) * CamUtils.SRGB_TO_XYZ[1][2];
    }

    static float yFromLStar(float arg6) {
        float v1 = 100f;
        if(Float.compare(arg6, 8f) > 0) {
            arg6 = ((float)Math.pow(((((double)arg6)) + 16) / 116, 3));
        }
        else {
            arg6 /= 903.296326f;
        }

        return arg6 * v1;
    }
}

