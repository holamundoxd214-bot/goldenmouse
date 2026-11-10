package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u0017\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A#\u0010\u0006\u001A\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000B\"\u0010\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000E\"\u000E\u0010\u000F\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"getRippleStartRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "getRippleStartRadius-uvyYCjk", "(J)F", "getRippleEndRadius", "Landroidx/compose/ui/unit/Density;", "bounded", "", "getRippleEndRadius-cSwnlzA", "(Landroidx/compose/ui/unit/Density;ZJ)F", "BoundedRippleExtraRadius", "Landroidx/compose/ui/unit/Dp;", "F", "FadeInDuration", "", "RadiusDuration", "FadeOutDuration", "material-ripple"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = 0f;
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 0xE1;

    static {
        RippleAnimationKt.BoundedRippleExtraRadius = Dp.constructor-impl(10f);
    }

    public static final float getRippleEndRadius-cSwnlzA(Density arg1, boolean arg2, long arg3) {
        float v3 = Offset.getDistance-impl(OffsetKt.Offset(Size.getWidth-impl(arg3), Size.getHeight-impl(arg3))) / 2f;
        if(arg2) {
            v3 += arg1.toPx-0680j_4(RippleAnimationKt.BoundedRippleExtraRadius);
        }

        return v3;
    }

    public static final float getRippleStartRadius-uvyYCjk(long arg1) {
        return Math.max(Size.getWidth-impl(arg1), Size.getHeight-impl(arg1)) * 0.3f;
    }
}

