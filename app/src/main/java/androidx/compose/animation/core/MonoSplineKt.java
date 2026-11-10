package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001A8\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H\u0000\u001A8\u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"MonoSplineIsExtrapolate", "", "hermiteInterpolate", "", "h", "x", "y1", "y2", "t1", "t2", "hermiteDifferential", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MonoSplineKt {
    private static final boolean MonoSplineIsExtrapolate = true;

    public static final float hermiteDifferential(float arg3, float arg4, float arg5, float arg6, float arg7, float arg8) {
        float v0 = arg4 * arg4;
        return arg3 * (arg7 - 2f * arg4 * (2f * arg7 + arg8) + 3f * (arg7 + arg8) * v0) - 6f * (arg4 - v0) * (arg5 - arg6);
    }

    public static final float hermiteInterpolate(float arg4, float arg5, float arg6, float arg7, float arg8, float arg9) {
        float v0 = arg5 * arg5;
        float v1 = v0 * arg5;
        return arg8 * arg4 * (arg5 - 2f * v0 + v1) + arg4 * arg9 * (v1 - v0) + arg6 - (3f * v0 - 2f * v1) * (arg6 - arg7);
    }
}

