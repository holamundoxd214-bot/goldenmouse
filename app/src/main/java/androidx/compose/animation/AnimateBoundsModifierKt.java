package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LookaheadScope;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b\"\u000E\u0010\t\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"animateBounds", "Landroidx/compose/ui/Modifier;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "modifier", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animateMotionFrameOfReference", "", "DefaultBoundsTransform", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnimateBoundsModifierKt {
    private static final BoundsTransform DefaultBoundsTransform;

    static {
        AnimateBoundsModifierKt.DefaultBoundsTransform = new AnimateBoundsModifierKt$$ExternalSyntheticLambda0();
    }

    static final FiniteAnimationSpec DefaultBoundsTransform$lambda$0(Rect arg1, Rect arg2) {
        return AnimationSpecKt.spring(1f, 400f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion));
    }

    public static final Modifier animateBounds(Modifier arg2, LookaheadScope arg3, Modifier arg4, BoundsTransform arg5, boolean arg6) {
        return arg2.then(new BoundsAnimationElement(arg3, arg5, AnimateBoundsModifierKt$animateBounds$1.INSTANCE, arg6)).then(arg4).then(new BoundsAnimationElement(arg3, arg5, AnimateBoundsModifierKt$animateBounds$2.INSTANCE, arg6));
    }

    public static Modifier animateBounds$default(Modifier arg0, LookaheadScope arg1, Modifier arg2, BoundsTransform arg3, boolean arg4, int arg5, Object arg6) {
        Companion v2;
        if((arg5 & 2) != 0) {
            v2 = Modifier.Companion;
        }

        if((arg5 & 4) != 0) {
            arg3 = AnimateBoundsModifierKt.DefaultBoundsTransform;
        }

        return AnimateBoundsModifierKt.animateBounds(arg0, arg1, ((Modifier)v2), arg3, false);
    }
}

