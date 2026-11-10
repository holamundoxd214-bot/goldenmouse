package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0002\"\u0010\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"isLowScrollingDelta", "", "", "AnimationThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "AnimationSpeed", "MaxAnimationDuration", "", "ScrollProgressTimeout", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MouseWheelScrollableKt {
    private static final float AnimationSpeed = 0f;
    private static final float AnimationThreshold = 0f;
    private static final int MaxAnimationDuration = 100;
    private static final long ScrollProgressTimeout = 50;

    static {
        MouseWheelScrollableKt.AnimationThreshold = Dp.constructor-impl(6f);
        MouseWheelScrollableKt.AnimationSpeed = Dp.constructor-impl(1f);
    }

    public static final float access$getAnimationSpeed$p() {
        return MouseWheelScrollableKt.AnimationSpeed;
    }

    public static final float access$getAnimationThreshold$p() {
        return MouseWheelScrollableKt.AnimationThreshold;
    }

    public static final boolean access$isLowScrollingDelta(float arg0) {
        return MouseWheelScrollableKt.isLowScrollingDelta(arg0);
    }

    private static final boolean isLowScrollingDelta(float arg1) {
        if(!Float.isNaN(arg1)) {
            if(Math.abs(arg1) < 0.5f) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

