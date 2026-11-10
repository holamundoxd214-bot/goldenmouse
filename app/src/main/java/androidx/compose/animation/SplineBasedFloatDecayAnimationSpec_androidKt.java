package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001A!\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0007¢\u0006\u0002\b\u0005\u001A\u0019\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0007¢\u0006\u0002\u0010\u000B\"\u0014\u0010\u0006\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\f"}, d2={"splineBasedDecayDeprecated", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "splineBasedDecay", "platformFlingScrollFriction", "", "getPlatformFlingScrollFriction", "()F", "rememberSplineBasedDecay", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/DecayAnimationSpec;", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SplineBasedFloatDecayAnimationSpec_androidKt {
    private static final float platformFlingScrollFriction;

    static {
        SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction = ViewConfiguration.getScrollFriction();
    }

    public static final float getPlatformFlingScrollFriction() {
        return SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction;
    }

    public static final DecayAnimationSpec rememberSplineBasedDecay(Composer arg3, int arg4) {
        int v1 = 0x35E8BF9B;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberSplineBasedDecay)43@1760L7,44@1779L114:SplineBasedFloatDecayAnimationSpec.android.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)");
        }

        ProvidableCompositionLocal v4 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        float v0 = ((Density)v4_1).getDensity();
        ComposerKt.sourceInformationMarkerStart(arg3, 1589078317, "CC(remember):SplineBasedFloatDecayAnimationSpec.android.kt#9igjgp");
        boolean v0_1 = arg3.changed(v0);
        Object v1_1 = arg3.rememberedValue();
        if((v0_1) || v1_1 == Composer.Companion.getEmpty()) {
            DecayAnimationSpec v1_2 = DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(((Density)v4_1)));
            arg3.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((DecayAnimationSpec)v1_1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Moved to common code") public static final DecayAnimationSpec splineBasedDecay(Density arg0) {
        return SplineBasedDecayKt.splineBasedDecay(arg0);
    }
}

