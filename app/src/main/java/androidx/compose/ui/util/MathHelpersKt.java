package androidx.compose.ui.util;

import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\u001A\u001E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001\u001A\u001E\u0010\u0000\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0001\u001A\u001E\u0010\u0000\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00062\u0006\u0010\u0004\u001A\u00020\u0001\u001A)\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u0001H\u0086\b\u001A)\u0010\f\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u0001H\u0086\b\u001A\u001D\u0010\r\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\b\u001A\u0015\u0010\u0010\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u0001H\u0086\b\u001A\u0015\u0010\u0011\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0086\b\u001A\u001D\u0010\r\u001A\u00020\u0012*\u00020\u00122\u0006\u0010\u000E\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u0012H\u0086\b\u001A\u0015\u0010\u0010\u001A\u00020\u0012*\u00020\u00122\u0006\u0010\u000E\u001A\u00020\u0012H\u0086\b\u001A\u0015\u0010\u0011\u001A\u00020\u0012*\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u0012H\u0086\b\u001A\u001D\u0010\r\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0005H\u0086\b\u001A\u0015\u0010\u0010\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0086\b\u001A\u0015\u0010\u0011\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0005H\u0086\b\u001A\u001D\u0010\r\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0006H\u0086\b\u001A\u0015\u0010\u0010\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0006H\u0086\b\u001A\u0015\u0010\u0011\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0006H\u0086\b\u001A\r\u0010\u0013\u001A\u00020\u0014*\u00020\u0001H\u0086\b\u001A\r\u0010\u0013\u001A\u00020\u0014*\u00020\u0012H\u0086\b\u001A\u000E\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0001\u001A\u0011\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u0001H\u0086\b\u001A\u0011\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u0001H\u0086\b¨\u0006\u001A"}, d2={"lerp", "", "start", "stop", "fraction", "", "", "fastMinOf", "a", "b", "c", "d", "fastMaxOf", "fastCoerceIn", "minimumValue", "maximumValue", "fastCoerceAtLeast", "fastCoerceAtMost", "", "fastIsFinite", "", "fastCbrt", "x", "normalizedAngleSin", "normalizedDegrees", "normalizedAngleCos", "ui-util"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MathHelpersKt {
    public static final float fastCbrt(float arg4) {
        float v0 = Float.intBitsToFloat((((int)(((((long)Float.floatToRawIntBits(arg4))) & 0x1FFFFFFFFL) / 3))) + 0x2A510554);
        v0 -= (v0 - arg4 / (v0 * v0)) * 0.333333f;
        return v0 - (v0 - arg4 / (v0 * v0)) * 0.333333f;
    }

    public static final double fastCoerceAtLeast(double arg1, double arg3) {
        if(arg1 < arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final float fastCoerceAtLeast(float arg1, float arg2) {
        if(arg1 < arg2) {
            return arg2;
        }

        return arg1;
    }

    public static final int fastCoerceAtLeast(int arg0, int arg1) {
        if(arg0 < arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final long fastCoerceAtLeast(long arg1, long arg3) {
        if(arg1 < arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final double fastCoerceAtMost(double arg1, double arg3) {
        if(arg1 > arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final float fastCoerceAtMost(float arg1, float arg2) {
        if(arg1 > arg2) {
            return arg2;
        }

        return arg1;
    }

    public static final int fastCoerceAtMost(int arg0, int arg1) {
        if(arg0 > arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final long fastCoerceAtMost(long arg1, long arg3) {
        if(arg1 > arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final double fastCoerceIn(double arg1, double arg3, double arg5) {
        if(arg1 < arg3) {
            arg1 = arg3;
        }

        if(arg1 > arg5) {
            return arg5;
        }

        return arg1;
    }

    public static final float fastCoerceIn(float arg1, float arg2, float arg3) {
        if(arg1 < arg2) {
            arg1 = arg2;
        }

        if(arg1 > arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final int fastCoerceIn(int arg0, int arg1, int arg2) {
        if(arg0 < arg1) {
            arg0 = arg1;
        }

        if(arg0 > arg2) {
            return arg2;
        }

        return arg0;
    }

    public static final long fastCoerceIn(long arg1, long arg3, long arg5) {
        if(arg1 < arg3) {
            arg1 = arg3;
        }

        if(arg1 > arg5) {
            return arg5;
        }

        return arg1;
    }

    public static final boolean fastIsFinite(double arg2) {
        if((Double.doubleToRawLongBits(arg2) & 0x7FFFFFFFFFFFFFFFL) < 0x7FF0000000000000L) {
            return 1;
        }

        return 0;
    }

    public static final boolean fastIsFinite(float arg1) {
        if((Float.floatToRawIntBits(arg1) & 0x7FFFFFFF) < 0x7F800000) {
            return 1;
        }

        return 0;
    }

    public static final float fastMaxOf(float arg0, float arg1, float arg2, float arg3) {
        return Math.max(arg0, Math.max(arg1, Math.max(arg2, arg3)));
    }

    public static final float fastMinOf(float arg0, float arg1, float arg2, float arg3) {
        return Math.min(arg0, Math.min(arg1, Math.min(arg2, arg3)));
    }

    public static final float lerp(float arg1, float arg2, float arg3) {
        return (1f - arg3) * arg1 + arg3 * arg2;
    }

    public static final int lerp(int arg2, int arg3, float arg4) {
        return arg2 + (((int)Math.round((((double)(arg3 - arg2))) * (((double)arg4)))));
    }

    public static final long lerp(long arg2, long arg4, float arg6) {
        return arg2 + MathKt.roundToLong((((double)(arg4 - arg2))) * (((double)arg6)));
    }

    public static final float normalizedAngleCos(float arg3) {
        arg3 += 0.25f;
        arg3 -= ((float)Math.floor(((double)(0.5f + arg3))));
        float v1 = Math.abs(arg3) * 2f;
        float v0 = 1f - v1;
        return arg3 * 8f * v0 / (1.25f - v1 * v0);
    }

    public static final float normalizedAngleSin(float arg3) {
        arg3 -= ((float)Math.floor(((double)(0.5f + arg3))));
        float v1 = Math.abs(arg3) * 2f;
        float v0 = 1f - v1;
        return arg3 * 8f * v0 / (1.25f - v1 * v0);
    }
}

