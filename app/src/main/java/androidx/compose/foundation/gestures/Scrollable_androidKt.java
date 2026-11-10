package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000\u001A\r\u0010\u0002\u001A\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2={"platformScrollableDefaultFlingBehavior", "Landroidx/compose/foundation/gestures/ScrollableDefaultFlingBehavior;", "rememberPlatformDefaultFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Scrollable_androidKt {
    public static final ScrollableDefaultFlingBehavior platformScrollableDefaultFlingBehavior() {
        return new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.getUnityDensity()), null, 2, null);
    }

    public static final FlingBehavior rememberPlatformDefaultFlingBehavior(Composer arg3, int arg4) {
        DefaultFlingBehavior v1_2;
        int v1 = 0x9B0896B;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberPlatformDefaultFlingBehavior)29@1128L33,30@1173L55:Scrollable.android.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.gestures.rememberPlatformDefaultFlingBehavior (Scrollable.android.kt:28)");
        }

        DecayAnimationSpec v4 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(arg3, 0);
        ComposerKt.sourceInformationMarkerStart(arg3, 0x5FB3EA82, "CC(remember):Scrollable.android.kt#9igjgp");
        boolean v0 = arg3.changed(v4);
        Object v1_1 = arg3.rememberedValue();
        if((v0) || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new DefaultFlingBehavior(v4, null, 2, null);
            arg3.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((FlingBehavior)v1_2);
    }
}

