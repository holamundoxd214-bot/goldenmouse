package androidx.compose.material.ripple;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A;\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\r\u0010\u000E\u001A-\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001A\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001A\u00020\u0018H\u0002\u001A\u0018\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0002\"\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00160\u001BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"createRippleModifierNode", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "createRippleModifierNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/DelegatableNode;", "rememberRipple", "Landroidx/compose/foundation/Indication;", "Landroidx/compose/ui/graphics/Color;", "rememberRipple-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "incomingStateLayerAnimationSpecFor", "Landroidx/compose/animation/core/AnimationSpec;", "", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingStateLayerAnimationSpecFor", "DefaultTweenSpec", "Landroidx/compose/animation/core/TweenSpec;", "material-ripple"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RippleKt {
    private static final TweenSpec DefaultTweenSpec;

    static {
        RippleKt.DefaultTweenSpec = new TweenSpec(15, 0, EasingKt.getLinearEasing(), 2, null);
    }

    public static final AnimationSpec access$incomingStateLayerAnimationSpecFor(Interaction arg0) {
        return RippleKt.incomingStateLayerAnimationSpecFor(arg0);
    }

    public static final AnimationSpec access$outgoingStateLayerAnimationSpecFor(Interaction arg0) {
        return RippleKt.outgoingStateLayerAnimationSpecFor(arg0);
    }

    public static final DelegatableNode createRippleModifierNode-TDGSqEk(InteractionSource arg0, boolean arg1, float arg2, ColorProducer arg3, Function0 arg4) {
        return Ripple_androidKt.createPlatformRippleNode-TDGSqEk(arg0, arg1, arg2, arg3, arg4);
    }

    private static final AnimationSpec incomingStateLayerAnimationSpecFor(Interaction arg7) {
        if((arg7 instanceof Enter)) {
            return RippleKt.DefaultTweenSpec;
        }

        if((arg7 instanceof Focus)) {
            return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null);
        }

        if((arg7 instanceof Start)) {
            return new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, null);
        }

        return RippleKt.DefaultTweenSpec;
    }

    private static final AnimationSpec outgoingStateLayerAnimationSpecFor(Interaction arg6) {
        if((arg6 instanceof Enter)) {
            return RippleKt.DefaultTweenSpec;
        }

        if((arg6 instanceof Focus)) {
            return RippleKt.DefaultTweenSpec;
        }

        if((arg6 instanceof Start)) {
            return new TweenSpec(150, 0, EasingKt.getLinearEasing(), 2, null);
        }

        return RippleKt.DefaultTweenSpec;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="rememberRipple has been deprecated - it returns an old Indication implementation that is not compatible with the new Indication APIs that provide notable performance improvements. Instead, use the new ripple APIs provided by design system libraries, such as material and material3. If you are implementing your own design system library, use createRippleNode to create your own custom ripple implementation that queries your own theme values. For a migration guide and background information, please visit developer.android.com") public static final Indication rememberRipple-9IZ8Weo(boolean arg4, float arg5, long arg6, Composer arg8, int arg9, int arg10) {
        PlatformRipple v9_1;
        int v1 = 0x61769D80;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberRipple)N(bounded,radius:c#ui.unit.Dp,color:c#ui.graphics.Color)145@7588L27,146@7627L73:Ripple.kt#vhb33q");
        int v2 = 1;
        if((arg10 & 2) != 0) {
            arg5 = Dp.Companion.getUnspecified-D9Ej5fM();
        }

        int v0 = 4;
        if((arg10 & v0) != 0) {
            arg6 = Color.Companion.getUnspecified-0d7_KjU();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material.ripple.rememberRipple (Ripple.kt:144)");
        }

        State v6 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(arg6), arg8, arg9 >> 6 & 14);
        ComposerKt.sourceInformationMarkerStart(arg8, 0xDE455649, "CC(remember):Ripple.kt#9igjgp");
        int v7 = (arg9 & 14 ^ 6) > v0 && (arg8.changed(true)) || (arg9 & 6) == v0 ? 1 : 0;
        v1 = 0x20;
        if((arg9 & 0x70 ^ 0x30) <= v1 || !arg8.changed(arg5)) {
            if((arg9 & 0x30) == v1) {
            }
            else {
                v2 = 0;
            }
        }

        Object v9 = arg8.rememberedValue();
        if((v7 | v2) != 0 || v9 == Composer.Companion.getEmpty()) {
            v9_1 = new PlatformRipple(true, arg5, v6, null);
            arg8.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((Indication)v9_1);
    }
}

