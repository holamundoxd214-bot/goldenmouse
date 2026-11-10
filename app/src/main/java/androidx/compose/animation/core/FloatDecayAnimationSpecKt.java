package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A*\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\u0001H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"ExponentialDecayFriction", "", "createAnimation", "Landroidx/compose/animation/core/Animation;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "startValue", "startVelocity", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FloatDecayAnimationSpecKt {
    private static final float ExponentialDecayFriction = -4.2f;

    public static final Animation createAnimation(FloatDecayAnimationSpec arg0, float arg1, float arg2) {
        return AnimationKt.DecayAnimation(arg0, arg1, arg2);
    }

    public static Animation createAnimation$default(FloatDecayAnimationSpec arg0, float arg1, float arg2, int arg3, Object arg4) {
        return FloatDecayAnimationSpecKt.createAnimation(arg0, arg1, 0f);
    }
}

