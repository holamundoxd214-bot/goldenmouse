package androidx.compose.animation;

import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u001A\u0018\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0001H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"GravityEarth", "", "InchesPerMeter", "DecelerationRate", "computeDeceleration", "friction", "density", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FlingCalculatorKt {
    private static final float DecelerationRate = 0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.369999f;

    static {
        FlingCalculatorKt.DecelerationRate = ((float)(Math.log(0.78) / Math.log(0.9)));
    }

    public static final float access$computeDeceleration(float arg0, float arg1) {
        return FlingCalculatorKt.computeDeceleration(arg0, arg1);
    }

    public static final float access$getDecelerationRate$p() {
        return FlingCalculatorKt.DecelerationRate;
    }

    private static final float computeDeceleration(float arg1, float arg2) {
        return arg2 * 386.087799f * 160f * arg1;
    }
}

