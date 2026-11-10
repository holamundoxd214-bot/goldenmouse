package androidx.compose.material3.internal.colorUtil;

import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0016J\u000E\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0016J \u0010\u0019\u001A\u00020\u00142\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u001B\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u0016H\u0002J\u001E\u0010\u001D\u001A\u00020\u00142\u0006\u0010\u001E\u001A\u00020\u00162\u0006\u0010\u001F\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u0016J\u0010\u0010!\u001A\u00020\u00142\u0006\u0010\"\u001A\u00020\u0016H\u0002J \u0010#\u001A\u00020\u00142\u0006\u0010$\u001A\u00020\u00142\u0006\u0010%\u001A\u00020\u00142\u0006\u0010&\u001A\u00020\u0014H\u0002J \u0010\'\u001A\u00020\u00142\u0006\u0010(\u001A\u00020\u00142\u0006\u0010)\u001A\u00020\u00142\u0006\u0010*\u001A\u00020\u0014H\u0002J\u000E\u0010+\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020,J\u000E\u0010-\u001A\u00020,2\u0006\u0010.\u001A\u00020\u0014J\u0010\u0010/\u001A\u00020,2\u0006\u0010\u001B\u001A\u00020,H\u0002J\u0010\u00100\u001A\u00020,2\u0006\u0010.\u001A\u00020\u0014H\u0002J\u000E\u00101\u001A\u00020\u00062\u0006\u0010.\u001A\u00020\u0014J\u000E\u00102\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0016J\u0010\u00103\u001A\u00020,2\u0006\u0010\"\u001A\u00020\u0014H\u0002R\u0019\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u000B\u0010\bR\u0011\u0010\f\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u00064"}, d2={"Landroidx/compose/material3/internal/colorUtil/CamUtils;", "", "<init>", "()V", "XYZ_TO_CAM16RGB", "", "", "getXYZ_TO_CAM16RGB", "()[[F", "[[F", "CAM16RGB_TO_XYZ", "getCAM16RGB_TO_XYZ", "WHITE_POINT_D65", "getWHITE_POINT_D65", "()[F", "SRGB_TO_XYZ", "", "[[D", "XYZ_TO_SRGB", "signum", "", "num", "", "argbFromLstar", "lstar", "argbFromXyz", "x", "y", "z", "argbFromLinrgbComponents", "r", "g", "b", "delinearized", "rgbComponent", "clampInt", "min", "max", "input", "argbFromRgb", "red", "green", "blue", "intFromLstar", "", "lstarFromInt", "argb", "lstarFromY", "yFromInt", "xyzFromInt", "yFromLstar", "linearized", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CamUtils {
    public static final int $stable;
    private static final float[][] CAM16RGB_TO_XYZ;
    public static final CamUtils INSTANCE;
    private static final double[][] SRGB_TO_XYZ;
    private static final float[] WHITE_POINT_D65;
    private static final float[][] XYZ_TO_CAM16RGB;
    private static final double[][] XYZ_TO_SRGB;

    static {
        CamUtils.INSTANCE = new CamUtils();
        CamUtils.XYZ_TO_CAM16RGB = new float[][]{new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
        CamUtils.CAM16RGB_TO_XYZ = new float[][]{new float[]{1.862068f, -1.011255f, 0.149187f}, new float[]{0.387527f, 0.621447f, -0.008974f}, new float[]{-0.015842f, -0.034123f, 1.049964f}};
        CamUtils.WHITE_POINT_D65 = new float[]{95.046997f, 100f, 108.883003f};
        CamUtils.SRGB_TO_XYZ = new double[][]{new double[]{0.412339, 0.357621, 0.18051}, new double[]{0.2126, 0.7152, 0.0722}, new double[]{0.019321, 0.119164, 0.950345}};
        CamUtils.XYZ_TO_SRGB = new double[][]{new double[]{3.241377, -1.537665, -0.498854}, new double[]{-0.969145, 1.875885, 0.041566}, new double[]{0.055621, -0.203955, 1.05718}};
        CamUtils.$stable = 8;
    }

    private CamUtils() {
        super();
    }

    public final int argbFromLinrgbComponents(double arg1, double arg3, double arg5) {
        return this.argbFromRgb(this.delinearized(arg1), this.delinearized(arg3), this.delinearized(arg5));
    }

    public final int argbFromLstar(double arg19) {
        double v0 = (arg19 + 16) / 116;
        double v3 = 903.296296;
        double v5 = Double.compare(arg19, 8) > 0 ? v0 * v0 * v0 : arg19 / v3;
        double v7 = v0 * v0 * v0;
        int v0_1 = Double.compare(v7, 0.008856) > 0 ? 1 : 0;
        double v9 = v0_1 != 0 ? v7 : arg19 / v3;
        if(v0_1 != 0) {
        }
        else {
            v7 = arg19 / v3;
        }

        return this.argbFromXyz(v9 * (((double)CamUtils.WHITE_POINT_D65[0])), v5 * (((double)CamUtils.WHITE_POINT_D65[1])), v7 * (((double)CamUtils.WHITE_POINT_D65[2])));
    }

    private final int argbFromRgb(int arg1, int arg2, int arg3) {
        return (arg1 & 0xFF) << 16 | 0xFF000000 | (arg2 & 0xFF) << 8 | arg3 & 0xFF;
    }

    private final int argbFromXyz(double arg12, double arg14, double arg16) {
        return this.argbFromRgb(this.delinearized(CamUtils.XYZ_TO_SRGB[0][0] * arg12 + CamUtils.XYZ_TO_SRGB[0][1] * arg14 + CamUtils.XYZ_TO_SRGB[0][2] * arg16), this.delinearized(CamUtils.XYZ_TO_SRGB[1][0] * arg12 + CamUtils.XYZ_TO_SRGB[1][1] * arg14 + CamUtils.XYZ_TO_SRGB[1][2] * arg16), this.delinearized(CamUtils.XYZ_TO_SRGB[2][0] * arg12 + CamUtils.XYZ_TO_SRGB[2][1] * arg14 + CamUtils.XYZ_TO_SRGB[2][2] * arg16));
    }

    private final int clampInt(int arg1, int arg2, int arg3) {
        if(arg3 < arg1) {
            return arg1;
        }

        if(arg3 > arg2) {
            return arg2;
        }

        return arg3;
    }

    private final int delinearized(double arg3) {
        arg3 /= 100;
        if(arg3 <= 0.003131) {
            arg3 *= 12.92;
        }
        else {
            arg3 = Math.pow(arg3, 0.416667) * 1.055 - 0.055;
        }

        return this.clampInt(0, 0xFF, ((int)Math.round(arg3 * 255)));
    }

    public final float[][] getCAM16RGB_TO_XYZ() {
        return CamUtils.CAM16RGB_TO_XYZ;
    }

    public final float[] getWHITE_POINT_D65() {
        return CamUtils.WHITE_POINT_D65;
    }

    public final float[][] getXYZ_TO_CAM16RGB() {
        return CamUtils.XYZ_TO_CAM16RGB;
    }

    public final int intFromLstar(float arg15) {
        if(arg15 < 1f) {
            return 0xFF000000;
        }

        if(arg15 > 99f) {
            return -1;
        }

        float v14 = 16f;
        float v1 = 116f;
        float v0 = (arg15 + v14) / v1;
        float v3 = 903.296326f;
        if(Float.compare(arg15, 8f) > 0) {
            arg15 = v0 * v0 * v0;
        }
        else {
            arg15 /= v3;
        }

        float v2 = v0 * v0 * v0;
        int v4 = Float.compare(v2, 0.008856f) > 0 ? 1 : 0;
        float v7 = v4 != 0 ? v2 : (v0 * v1 - v14) / v3;
        if(v4 != 0) {
        }
        else {
            v2 = (v0 * v1 - v14) / v3;
        }

        return ColorUtils.XYZToColor(((double)(v7 * CamUtils.WHITE_POINT_D65[0])), ((double)(arg15 * CamUtils.WHITE_POINT_D65[1])), ((double)(v2 * CamUtils.WHITE_POINT_D65[2])));
    }

    private final float linearized(int arg4) {
        float v3 = (((float)arg4)) / 255f;
        float v0 = 100f;
        if(Float.compare(v3, 0.04045f) <= 0) {
            v3 /= 12.92f;
        }
        else {
            v3 = ((float)Math.pow(((double)((v3 + 0.055f) / 1.055f)), 2.4));
        }

        return v3 * v0;
    }

    public final float lstarFromInt(int arg1) {
        return this.lstarFromY(this.yFromInt(arg1));
    }

    private final float lstarFromY(float arg1) {
        arg1 /= 100f;
        if(arg1 <= 0.008856f) {
            return arg1 * 903.296326f;
        }

        return (((float)Math.cbrt(((double)arg1)))) * 116f - 16f;
    }

    public final int signum(double arg3) {
        int v2 = Double.compare(arg3, 0);
        if(v2 < 0) {
            return -1;
        }

        if(v2 == 0) {
            return 0;
        }

        return 1;
    }

    public final float[] xyzFromInt(int arg18) {
        double v4 = ((double)this.linearized(arg18 >> 16 & 0xFF));
        double v9 = ((double)this.linearized(arg18 >> 8 & 0xFF));
        double v11 = ((double)this.linearized(arg18 & 0xFF));
        return new float[]{((float)(CamUtils.SRGB_TO_XYZ[0][0] * v4 + CamUtils.SRGB_TO_XYZ[0][1] * v9 + CamUtils.SRGB_TO_XYZ[0][2] * v11)), ((float)(CamUtils.SRGB_TO_XYZ[1][0] * v4 + CamUtils.SRGB_TO_XYZ[1][1] * v9 + CamUtils.SRGB_TO_XYZ[1][2] * v11)), ((float)(v4 * CamUtils.SRGB_TO_XYZ[2][0] + v9 * CamUtils.SRGB_TO_XYZ[2][1] + v11 * CamUtils.SRGB_TO_XYZ[2][2]))};
    }

    private final float yFromInt(int arg7) {
        return ((float)((((double)this.linearized(arg7 >> 16 & 0xFF))) * CamUtils.SRGB_TO_XYZ[1][0] + (((double)this.linearized(arg7 >> 8 & 0xFF))) * CamUtils.SRGB_TO_XYZ[1][1] + (((double)this.linearized(arg7 & 0xFF))) * CamUtils.SRGB_TO_XYZ[1][2]));
    }

    public final double yFromLstar(double arg5) {
        double v0 = 100;
        if(Double.compare(arg5, 8) > 0) {
            return Math.pow((arg5 + 16) / 116, 3) * v0;
        }

        return arg5 / 903.296296 * v0;
    }
}

