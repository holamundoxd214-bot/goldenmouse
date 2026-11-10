package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JU\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\u00022!\u0010\u000E\u001A\u001D\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000FH\u0096@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/gestures/snapping/TargetApproachAnimation;", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "approachAnimation", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "scope", "Landroidx/compose/foundation/gestures/ScrollScope;", "offset", "velocity", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TargetApproachAnimation implements ApproachAnimation {
    private final AnimationSpec animationSpec;

    public TargetApproachAnimation(AnimationSpec arg1) {
        super();
        this.animationSpec = arg1;
    }

    public Object approachAnimation(ScrollScope arg17, float arg18, float arg19, Function1 arg20, Continuation arg21) {
        Object v0 = SnapFlingBehaviorKt.animateWithTarget(arg17, Math.abs(arg18) * Math.signum(arg19), arg18, AnimationStateKt.AnimationState$default(0f, arg19, 0, 0, false, 28, null), this.animationSpec, arg20, arg21);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return v0;
    }

    public Object approachAnimation(ScrollScope arg7, Object arg8, Object arg9, Function1 arg10, Continuation arg11) {
        return this.approachAnimation(arg7, ((Number)arg8).floatValue(), ((Number)arg9).floatValue(), arg10, arg11);
    }
}

