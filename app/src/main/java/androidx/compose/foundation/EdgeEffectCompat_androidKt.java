package androidx.compose.foundation;

import android.view.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0001H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Inflection", "", "PlatformFlingScrollFriction", "GravityEarth", "InchesPerMeter", "DecelerationRate", "", "DecelMinusOne", "flingDistance", "density", "Landroidx/compose/ui/unit/Density;", "velocity", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EdgeEffectCompat_androidKt {
    private static final double DecelMinusOne = 0;
    private static final double DecelerationRate = 0;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.369999f;
    private static final float Inflection = 0.35f;
    private static final float PlatformFlingScrollFriction;

    static {
        EdgeEffectCompat_androidKt.PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
        double v0 = Math.log(0.78) / Math.log(0.9);
        EdgeEffectCompat_androidKt.DecelerationRate = v0;
        EdgeEffectCompat_androidKt.DecelMinusOne = v0 - 1;
    }

    public static final float access$flingDistance(Density arg0, float arg1) {
        return EdgeEffectCompat_androidKt.flingDistance(arg0, arg1);
    }

    private static final float flingDistance(Density arg6, float arg7) {
        double v0 = ((double)(arg6.getDensity() * 386.087799f * 160f * 0.84f));
        return ((float)((((double)EdgeEffectCompat_androidKt.PlatformFlingScrollFriction)) * v0 * Math.exp(EdgeEffectCompat_androidKt.DecelerationRate / EdgeEffectCompat_androidKt.DecelMinusOne * Math.log((((double)(Math.abs(arg7) * 0.35f))) / ((((double)EdgeEffectCompat_androidKt.PlatformFlingScrollFriction)) * v0)))));
    }
}

