package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001A\u0013\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2={"defaultDecayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/DecayAnimationSpec;", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidActualDefaultDecayAnimationSpec_androidKt {
    @Deprecated(message="Replace with rememberSplineBasedDecay<Float>") public static final DecayAnimationSpec defaultDecayAnimationSpec(Composer arg3, int arg4) {
        int v1 = -1468328074;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(defaultDecayAnimationSpec)24@913L26:AndroidActualDefaultDecayAnimationSpec.android.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.animation.defaultDecayAnimationSpec (AndroidActualDefaultDecayAnimationSpec.android.kt:23)");
        }

        DecayAnimationSpec v4 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(arg3, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4;
    }
}

