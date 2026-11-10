package androidx.compose.material3.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A>\u0010\u0000\u001A\u00020\u0001*\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001A\u00020\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0080@¢\u0006\u0004\b\b\u0010\t\"\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/Dp;", "target", "from", "Landroidx/compose/foundation/interaction/Interaction;", "to", "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OutgoingSpecEasing", "Landroidx/compose/animation/core/Easing;", "DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ElevationKt {
    private static final TweenSpec DefaultIncomingSpec;
    private static final TweenSpec DefaultOutgoingSpec;
    private static final TweenSpec HoveredOutgoingSpec;
    private static final Easing OutgoingSpecEasing;

    static {
        CubicBezierEasing v8 = new CubicBezierEasing(0.4f, 0f, 0.6f, 1f);
        ElevationKt.OutgoingSpecEasing = ((Easing)v8);
        ElevationKt.DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
        ElevationKt.DefaultOutgoingSpec = new TweenSpec(150, 0, ((Easing)v8), 2, null);
        ElevationKt.HoveredOutgoingSpec = new TweenSpec(120, 0, ((Easing)v8), 2, null);
    }

    public static final TweenSpec access$getDefaultIncomingSpec$p() {
        return ElevationKt.DefaultIncomingSpec;
    }

    public static final TweenSpec access$getDefaultOutgoingSpec$p() {
        return ElevationKt.DefaultOutgoingSpec;
    }

    public static final TweenSpec access$getHoveredOutgoingSpec$p() {
        return ElevationKt.HoveredOutgoingSpec;
    }

    public static final Object animateElevation-rAjV9yQ(Animatable arg8, float arg9, Interaction arg10, Interaction arg11, Continuation arg12) {
        Object v8;
        AnimationSpec v10;
        if(arg11 != null) {
            v10 = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(arg11);
        }
        else if(arg10 != null) {
            v10 = ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(arg10);
        }
        else {
            v10 = null;
        }

        AnimationSpec v2 = v10;
        if(v2 != null) {
            v8 = Animatable.animateTo$default(arg8, Dp.box-impl(arg9), v2, null, null, arg12, 12, null);
            if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v8;
            }

            return Unit.INSTANCE;
        }

        v8 = arg8.snapTo(Dp.box-impl(arg9), arg12);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public static Object animateElevation-rAjV9yQ$default(Animatable arg1, float arg2, Interaction arg3, Interaction arg4, Continuation arg5, int arg6, Object arg7) {
        Interaction v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = v0;
        }

        return ElevationKt.animateElevation-rAjV9yQ(arg1, arg2, arg3, arg4, arg5);
    }
}

