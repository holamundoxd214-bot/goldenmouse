package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0011\u001A\u00020\u0012\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00130\u00152#\b\u0002\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00060\n2\u000E\b\u0002\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u001BR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001D\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/gestures/AnchoredDraggableDefaults;", "", "<init>", "()V", "SnapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "PositionalThreshold", "Lkotlin/Function1;", "getPositionalThreshold", "()Lkotlin/jvm/functions/Function1;", "DecayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "T", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "positionalThreshold", "Lkotlin/ParameterName;", "name", "totalDistance", "animationSpec", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnchoredDraggableDefaults {
    public static final int $stable;
    private static final DecayAnimationSpec DecayAnimationSpec;
    public static final AnchoredDraggableDefaults INSTANCE;
    private static final Function1 PositionalThreshold;
    private static final AnimationSpec SnapAnimationSpec;

    static {
        AnchoredDraggableDefaults.INSTANCE = new AnchoredDraggableDefaults();
        AnchoredDraggableDefaults.SnapAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
        AnchoredDraggableDefaults.PositionalThreshold = new AnchoredDraggableDefaults$$ExternalSyntheticLambda0();
        AnchoredDraggableDefaults.DecayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0f, 0f, 3, null);
        AnchoredDraggableDefaults.$stable = 8;
    }

    private AnchoredDraggableDefaults() {
        super();
    }

    static final float PositionalThreshold$lambda$0(float arg1) {
        return arg1 / 2f;
    }

    public final TargetedFlingBehavior flingBehavior(AnchoredDraggableState arg5, Function1 arg6, AnimationSpec arg7, Composer arg8, int arg9, int arg10) {
        int v0 = 0xC7364F78;
        ComposerKt.sourceInformationMarkerStart(arg8, v0, "C(flingBehavior)N(state,positionalThreshold,animationSpec)1524@67363L7,1525@67386L306:AnchoredDraggable.kt#8bwon0");
        if((arg10 & 2) != 0) {
            arg6 = AnchoredDraggableDefaults.PositionalThreshold;
        }

        int v4 = 4;
        if((arg10 & v4) != 0) {
            arg7 = AnchoredDraggableDefaults.SnapAnimationSpec;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg9, -1, "androidx.compose.foundation.gestures.AnchoredDraggableDefaults.flingBehavior (AnchoredDraggable.kt:1523)");
        }

        ProvidableCompositionLocal v10 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v10_1 = arg8.consume(((CompositionLocal)v10));
        ComposerKt.sourceInformationMarkerEnd(arg8);
        ComposerKt.sourceInformationMarkerStart(arg8, -757041014, "CC(remember):AnchoredDraggable.kt#9igjgp");
        boolean v0_1 = arg8.changed(v10_1);
        int v2 = 0;
        v4 = (arg9 & 14 ^ 6) > v4 && (arg8.changed(arg5)) || (arg9 & 6) == v4 ? 1 : 0;
        v4 |= ((int)v0_1);
        int v1 = 0x20;
        if((arg9 & 0x70 ^ 0x30) > v1 && (arg8.changed(arg6)) || (arg9 & 0x30) == v1) {
            v2 = 1;
        }

        v4 = v4 | v2 | arg8.changed(arg7);
        Object v9 = arg8.rememberedValue();
        if(v4 != 0 || v9 == Composer.Companion.getEmpty()) {
            TargetedFlingBehavior v9_1 = AnchoredDraggableKt.anchoredDraggableFlingBehavior(arg5, ((Density)v10_1), arg6, arg7);
            arg8.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((TargetedFlingBehavior)v9);
    }

    public final DecayAnimationSpec getDecayAnimationSpec() {
        return AnchoredDraggableDefaults.DecayAnimationSpec;
    }

    public final Function1 getPositionalThreshold() {
        return AnchoredDraggableDefaults.PositionalThreshold;
    }

    public final AnimationSpec getSnapAnimationSpec() {
        return AnchoredDraggableDefaults.SnapAnimationSpec;
    }
}

