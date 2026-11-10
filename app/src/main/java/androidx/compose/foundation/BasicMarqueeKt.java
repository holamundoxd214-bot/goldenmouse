package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AO\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\r\u001AE\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001A&\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010\n\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0003H\u0002\u001A\u0015\u0010\u0019\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u000B¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2={"basicMarquee", "Landroidx/compose/ui/Modifier;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "repeatDelayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "targetValue", "delayMillis", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "MarqueeSpacing", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicMarqueeKt {
    public static final MarqueeSpacing MarqueeSpacing-0680j_4(float arg1) {
        return new BasicMarqueeKt$$ExternalSyntheticLambda0(arg1);
    }

    static final int MarqueeSpacing_0680j_4$lambda$0(float arg0, Density arg1, int arg2, int arg3) {
        return arg1.roundToPx-0680j_4(arg0);
    }

    public static final AnimationSpec access$createMarqueeAnimationSpec-Z4HSEVQ(int arg0, float arg1, int arg2, int arg3, float arg4, Density arg5) {
        return BasicMarqueeKt.createMarqueeAnimationSpec-Z4HSEVQ(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Modifier basicMarquee-1Mj1MLw(Modifier arg8, int arg9, int arg10, int arg11, int arg12, MarqueeSpacing arg13, float arg14) {
        return arg8.then(new MarqueeModifierElement(arg9, arg10, arg11, arg12, arg13, arg14, null));
    }

    public static Modifier basicMarquee-1Mj1MLw$default(Modifier arg0, int arg1, int arg2, int arg3, int arg4, MarqueeSpacing arg5, float arg6, int arg7, Object arg8) {
        if((arg7 & 1) != 0) {
            arg1 = MarqueeDefaults.INSTANCE.getIterations();
        }

        if((arg7 & 2) != 0) {
            arg2 = MarqueeAnimationMode.Companion.getImmediately-ZbEOnfQ();
        }

        if((arg7 & 4) != 0) {
            arg3 = MarqueeDefaults.INSTANCE.getRepeatDelayMillis();
        }

        if((arg7 & 8) != 0) {
            arg4 = MarqueeAnimationMode.equals-impl0(arg2, MarqueeAnimationMode.Companion.getImmediately-ZbEOnfQ()) ? arg3 : 0;
        }

        if((arg7 & 16) != 0) {
            arg5 = MarqueeDefaults.INSTANCE.getSpacing();
        }

        if((arg7 & 0x20) != 0) {
            arg6 = MarqueeDefaults.INSTANCE.getVelocity-D9Ej5fM();
        }

        return BasicMarqueeKt.basicMarquee-1Mj1MLw(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private static final AnimationSpec createMarqueeAnimationSpec-Z4HSEVQ(int arg7, float arg8, int arg9, int arg10, float arg11, Density arg12) {
        TweenSpec v8 = BasicMarqueeKt.velocityBasedTween(Math.abs(arg12.toPx-0680j_4(arg11)), arg8, arg10);
        long v2 = StartOffset.constructor-impl$default(-arg10 + arg9, 0, 2, null);
        if(arg7 == 0x7FFFFFFF) {
            return AnimationSpecKt.infiniteRepeatable-9IiC70o$default(v8, null, v2, 2, null);
        }

        return AnimationSpecKt.repeatable-91I0pcU$default(arg7, v8, null, v2, 4, null);
    }

    private static final TweenSpec velocityBasedTween(float arg1, float arg2, int arg3) {
        return AnimationSpecKt.tween(((int)(((float)Math.ceil(((double)(arg2 / (arg1 / 1000f))))))), arg3, EasingKt.getLinearEasing());
    }
}

