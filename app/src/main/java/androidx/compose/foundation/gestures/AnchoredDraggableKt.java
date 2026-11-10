package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000À\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\\\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u001Ah\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001A\u00020\u00062\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0007\u001AT\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u001A`\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001A\u00020\u00062\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0007\u001AQ\u0010\u0014\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001626\u0010\u0017\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001B\u0012\u0013\u0012\u00110\u001C¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u00020\u00150\u0018H\u0086\b\u001A5\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u001F2\u001D\u0010 \u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020!\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\"\u001A\u0093\u0001\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001A\u0002H\u00022!\u0010%\u001A\u001D\u0012\u0013\u0012\u00110\u001C¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001C0\u00122\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u001C0(2\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u001C0*2\f\u0010+\u001A\b\u0012\u0004\u0012\u00020\u001C0,2#\b\u0002\u0010-\u001A\u001D\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u0010/\u001A¡\u0001\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001A\u0002H\u00022\f\u00100\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00162!\u0010%\u001A\u001D\u0012\u0013\u0012\u00110\u001C¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001C0\u00122\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u001C0(2\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u001C0*2\f\u0010+\u001A\b\u0012\u0004\u0012\u00020\u001C0,2#\b\u0002\u0010-\u001A\u001D\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u00101\u001A&\u00102\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001A\u0002H\u0002H\u0086@¢\u0006\u0002\u00104\u001AR\u00105\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00106\u001A\u00020\u001C2\u0006\u00107\u001A\u0002082\f\u00100\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u00109\u001A\u0002H\u00022\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u001C0*H\u0082@¢\u0006\u0002\u0010:\u001A6\u00105\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001A\u0002H\u00022\u000E\b\u0002\u0010;\u001A\b\u0012\u0004\u0012\u00020\u001C0*H\u0086@¢\u0006\u0002\u0010<\u001AN\u0010=\u001A\u00020\u001C\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001A\u0002H\u00022\u0006\u00106\u001A\u00020\u001C2\u000E\b\u0002\u0010)\u001A\b\u0012\u0004\u0012\u00020\u001C0*2\u000E\b\u0002\u0010+\u001A\b\u0012\u0004\u0012\u00020\u001C0,H\u0086@¢\u0006\u0002\u0010>\u001A^\u0010?\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010@\u001A\u00020\u001C2\u0006\u00106\u001A\u00020\u001C2!\u0010%\u001A\u001D\u0012\u0013\u0012\u00110\u001C¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001C0\u00122\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u001C0(H\u0002¢\u0006\u0002\u0010A\u001A\u0014\u0010B\u001A\u00020\u001C*\u00020\u001C2\u0006\u0010C\u001A\u00020\u001CH\u0002\u001AF\u0010D\u001A\u00020\u0015\"\u0004\b\u0000\u0010E2\f\u0010F\u001A\b\u0012\u0004\u0012\u0002HE0(2\"\u0010\u0017\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002HE\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150G\u0012\u0006\u0012\u0004\u0018\u00010\u001F0\u0018H\u0082@¢\u0006\u0002\u0010H\u001A\u0014\u0010I\u001A\b\u0012\u0004\u0012\u0002H\u00020J\"\u0004\b\u0000\u0010\u0002H\u0002\u001AU\u0010W\u001A\u00020X\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010Y\u001A\u00020Z2!\u0010%\u001A\u001D\u0012\u0013\u0012\u00110\u001C¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001C0\u00122\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u001C0*H\u0000\u001AM\u0010[\u001A\u00020\\\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042!\u0010%\u001A\u001D\u0012\u0013\u0012\u00110\u001C¢\u0006\f\b\u0019\u0012\b\b\u001A\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001C0\u00122\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u001C0(H\u0002\u001A\u0017\u0010_\u001A\u00020\u00152\f\u0010`\u001A\b\u0012\u0004\u0012\u00020S0(H\u0082\b\"\u001A\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010K\u001A\u000E\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001C0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010M\u001A\u00020NX\u0080\u0004¢\u0006\n\n\u0002\u0010Q\u001A\u0004\bO\u0010P\"\u000E\u0010R\u001A\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010T\u001A\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010U\u001A\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010V\u001A\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010]\u001A\b\u0012\u0004\u0012\u00020\u001C0,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010^\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006a"}, d2={"anchoredDraggable", "Landroidx/compose/ui/Modifier;", "T", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "reverseDirection", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "startDragImmediately", "AlwaysDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerType;", "forEach", "", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "", "position", "DraggableAnchors", "", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "Lkotlin/ExtensionFunctionType;", "AnchoredDraggableState", "initialValue", "positionalThreshold", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "anchors", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "snapTo", "targetValue", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "velocity", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "latestTarget", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "currentOffset", "(Landroidx/compose/foundation/gestures/DraggableAnchors;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "coerceToTarget", "target", "restartable", "I", "inputs", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyDraggableAnchors", "Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", "GetOrNan", "", "AnchoredDraggableMinFlingVelocity", "Landroidx/compose/ui/unit/Dp;", "getAnchoredDraggableMinFlingVelocity", "()F", "F", "ConfigurationMovedToModifier", "", "SettleWithVelocityDeprecated", "StartDragImmediatelyDeprecated", "ConfirmValueChangeDeprecated", "anchoredDraggableFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "density", "Landroidx/compose/ui/unit/Density;", "AnchoredDraggableLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "NoOpDecayAnimationSpec", "DEBUG", "debugLog", "generateMsg", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AnchoredDraggableKt {
    private static final Function1 AlwaysDrag = null;
    private static final float AnchoredDraggableMinFlingVelocity = 0f;
    private static final String ConfigurationMovedToModifier = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.";
    private static final String ConfirmValueChangeDeprecated = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.";
    private static final boolean DEBUG = false;
    private static final Function1 GetOrNan = null;
    private static final DecayAnimationSpec NoOpDecayAnimationSpec = null;
    private static final String SettleWithVelocityDeprecated = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.";
    private static final String StartDragImmediatelyDeprecated = "startDragImmediately has been removed without replacement. Modifier.anchoredDraggable sets startDragImmediately to true by default when animations are running.";

    public static Unit $r8$lambda$vOgvEmqqqo_wlVSeWVZGoKzaYNM(AnchoredDragScope arg0, FloatRef arg1, float arg2, float arg3) {
        return AnchoredDraggableKt.animateTo$lambda$0$1(arg0, arg1, arg2, arg3);
    }

    static {
        AnchoredDraggableKt.AlwaysDrag = new AnchoredDraggableKt$$ExternalSyntheticLambda3();
        AnchoredDraggableKt.GetOrNan = new AnchoredDraggableKt$$ExternalSyntheticLambda4();
        AnchoredDraggableKt.AnchoredDraggableMinFlingVelocity = Dp.constructor-impl(125f);
        AnchoredDraggableKt.NoOpDecayAnimationSpec = DecayAnimationSpecKt.generateDecayAnimationSpec(new AnchoredDraggableKt$NoOpDecayAnimationSpec$1());
    }

    static final boolean AlwaysDrag$lambda$0(PointerType arg0) {
        return 1;
    }

    private static final SnapLayoutInfoProvider AnchoredDraggableLayoutInfoProvider(AnchoredDraggableState arg1, Function1 arg2, Function0 arg3) {
        return new AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1(arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.") public static final AnchoredDraggableState AnchoredDraggableState(Object arg1, DraggableAnchors arg2, Function1 arg3, Function0 arg4, AnimationSpec arg5, DecayAnimationSpec arg6, Function1 arg7) {
        AnchoredDraggableState v0 = new AnchoredDraggableState(arg1, arg2, arg7);
        v0.setPositionalThreshold$foundation(arg3);
        v0.setVelocityThreshold$foundation(arg4);
        v0.setSnapAnimationSpec$foundation(arg5);
        v0.setDecayAnimationSpec$foundation(arg6);
        return v0;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.") public static final AnchoredDraggableState AnchoredDraggableState(Object arg1, Function1 arg2, Function0 arg3, AnimationSpec arg4, DecayAnimationSpec arg5, Function1 arg6) {
        AnchoredDraggableState v0 = new AnchoredDraggableState(arg1, arg6);
        v0.setPositionalThreshold$foundation(arg2);
        v0.setVelocityThreshold$foundation(arg3);
        v0.setSnapAnimationSpec$foundation(arg4);
        v0.setDecayAnimationSpec$foundation(arg5);
        return v0;
    }

    public static AnchoredDraggableState AnchoredDraggableState$default(Object arg7, DraggableAnchors arg8, Function1 arg9, Function0 arg10, AnimationSpec arg11, DecayAnimationSpec arg12, Function1 arg13, int arg14, Object arg15) {
        AnchoredDraggableKt$$ExternalSyntheticLambda0 v13;
        if((arg14 & 0x40) != 0) {
            v13 = new AnchoredDraggableKt$$ExternalSyntheticLambda0();
        }

        return AnchoredDraggableKt.AnchoredDraggableState(arg7, arg8, arg9, arg10, arg11, arg12, ((Function1)v13));
    }

    public static AnchoredDraggableState AnchoredDraggableState$default(Object arg6, Function1 arg7, Function0 arg8, AnimationSpec arg9, DecayAnimationSpec arg10, Function1 arg11, int arg12, Object arg13) {
        AnchoredDraggableKt$$ExternalSyntheticLambda2 v11;
        if((arg12 & 0x20) != 0) {
            v11 = new AnchoredDraggableKt$$ExternalSyntheticLambda2();
        }

        return AnchoredDraggableKt.AnchoredDraggableState(arg6, arg7, arg8, arg9, arg10, ((Function1)v11));
    }

    static final boolean AnchoredDraggableState$lambda$0(Object arg0) {
        return 1;
    }

    static final boolean AnchoredDraggableState$lambda$2(Object arg0) {
        return 1;
    }

    public static final DraggableAnchors DraggableAnchors(Function1 arg2) {
        DraggableAnchorsConfig v0 = new DraggableAnchorsConfig();
        arg2.invoke(v0);
        return new DefaultDraggableAnchors(v0.buildKeys$foundation(), v0.buildPositions$foundation());
    }

    static final float GetOrNan$lambda$0(int arg0) {
        return NaNf;
    }

    public static final Object access$animateTo(AnchoredDraggableState arg0, float arg1, AnchoredDragScope arg2, DraggableAnchors arg3, Object arg4, AnimationSpec arg5, Continuation arg6) {
        return AnchoredDraggableKt.animateTo(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final float access$coerceToTarget(float arg0, float arg1) {
        return AnchoredDraggableKt.coerceToTarget(arg0, arg1);
    }

    public static final Object access$computeTarget(DraggableAnchors arg0, float arg1, float arg2, Function1 arg3, Function0 arg4) {
        return AnchoredDraggableKt.computeTarget(arg0, arg1, arg2, arg3, arg4);
    }

    public static final DefaultDraggableAnchors access$emptyDraggableAnchors() {
        return AnchoredDraggableKt.emptyDraggableAnchors();
    }

    public static final Function1 access$getAlwaysDrag$p() {
        return AnchoredDraggableKt.AlwaysDrag;
    }

    public static final Function1 access$getGetOrNan$p() {
        return AnchoredDraggableKt.GetOrNan;
    }

    public static final Object access$restartable(Function0 arg0, Function2 arg1, Continuation arg2) {
        return AnchoredDraggableKt.restartable(arg0, arg1, arg2);
    }

    public static final Modifier anchoredDraggable(Modifier arg11, AnchoredDraggableState arg12, Orientation arg13, boolean arg14, MutableInteractionSource arg15, OverscrollEffect arg16, FlingBehavior arg17) {
        return arg11.then(new AnchoredDraggableElement(arg12, arg13, arg14, null, arg15, null, arg16, arg17, 0x20, null));
    }

    @Deprecated(message="startDragImmediately has been removed without replacement. Modifier.anchoredDraggable sets startDragImmediately to true by default when animations are running.") public static final Modifier anchoredDraggable(Modifier arg9, AnchoredDraggableState arg10, Orientation arg11, boolean arg12, MutableInteractionSource arg13, OverscrollEffect arg14, boolean arg15, FlingBehavior arg16) {
        return arg9.then(new AnchoredDraggableElement(arg10, arg11, arg12, null, arg13, Boolean.valueOf(arg15), arg14, arg16));
    }

    public static final Modifier anchoredDraggable(Modifier arg11, AnchoredDraggableState arg12, boolean arg13, Orientation arg14, boolean arg15, MutableInteractionSource arg16, OverscrollEffect arg17, FlingBehavior arg18) {
        return arg11.then(new AnchoredDraggableElement(arg12, arg14, arg15, Boolean.valueOf(arg13), arg16, null, arg17, arg18, 0x20, null));
    }

    @Deprecated(message="startDragImmediately has been removed without replacement. Modifier.anchoredDraggable sets startDragImmediately to true by default when animations are running.") public static final Modifier anchoredDraggable(Modifier arg9, AnchoredDraggableState arg10, boolean arg11, Orientation arg12, boolean arg13, MutableInteractionSource arg14, OverscrollEffect arg15, boolean arg16, FlingBehavior arg17) {
        return arg9.then(new AnchoredDraggableElement(arg10, arg12, arg13, Boolean.valueOf(arg11), arg14, Boolean.valueOf(arg16), arg15, arg17));
    }

    public static Modifier anchoredDraggable$default(Modifier arg7, AnchoredDraggableState arg8, Orientation arg9, boolean arg10, MutableInteractionSource arg11, OverscrollEffect arg12, FlingBehavior arg13, int arg14, Object arg15) {
        MutableInteractionSource v15 = null;
        MutableInteractionSource v4 = (arg14 & 8) != 0 ? v15 : arg11;
        OverscrollEffect v5 = (arg14 & 16) != 0 ? ((OverscrollEffect)v15) : arg12;
        FlingBehavior v6 = (arg14 & 0x20) != 0 ? ((FlingBehavior)v15) : arg13;
        return AnchoredDraggableKt.anchoredDraggable(arg7, arg8, arg9, true, v4, v5, v6);
    }

    public static Modifier anchoredDraggable$default(Modifier arg8, AnchoredDraggableState arg9, Orientation arg10, boolean arg11, MutableInteractionSource arg12, OverscrollEffect arg13, boolean arg14, FlingBehavior arg15, int arg16, Object arg17) {
        Modifier v0_1;
        Orientation v2;
        AnchoredDraggableState v1;
        FlingBehavior v7;
        MutableInteractionSource v0 = null;
        MutableInteractionSource v4 = (arg16 & 8) != 0 ? v0 : arg12;
        OverscrollEffect v5 = (arg16 & 16) != 0 ? ((OverscrollEffect)v0) : arg13;
        if((arg16 & 0x20) != 0) {
            arg14 = arg9.isAnimationRunning();
        }

        boolean v6 = arg14;
        if((arg16 & 0x40) != 0) {
            v7 = ((FlingBehavior)v0);
            v1 = arg9;
            v2 = arg10;
            v0_1 = arg8;
        }
        else {
            v7 = arg15;
            v0_1 = arg8;
            v1 = arg9;
            v2 = arg10;
        }

        return AnchoredDraggableKt.anchoredDraggable(v0_1, v1, v2, true, v4, v5, v6, v7);
    }

    public static Modifier anchoredDraggable$default(Modifier arg8, AnchoredDraggableState arg9, boolean arg10, Orientation arg11, boolean arg12, MutableInteractionSource arg13, OverscrollEffect arg14, FlingBehavior arg15, int arg16, Object arg17) {
        Modifier v0_1;
        Orientation v3;
        boolean v2;
        AnchoredDraggableState v1;
        FlingBehavior v7;
        MutableInteractionSource v0 = null;
        MutableInteractionSource v5 = (arg16 & 16) != 0 ? v0 : arg13;
        OverscrollEffect v6 = (arg16 & 0x20) != 0 ? ((OverscrollEffect)v0) : arg14;
        if((arg16 & 0x40) != 0) {
            v7 = ((FlingBehavior)v0);
            v1 = arg9;
            v2 = arg10;
            v3 = arg11;
            v0_1 = arg8;
        }
        else {
            v7 = arg15;
            v0_1 = arg8;
            v1 = arg9;
            v2 = arg10;
            v3 = arg11;
        }

        return AnchoredDraggableKt.anchoredDraggable(v0_1, v1, v2, v3, true, v5, v6, v7);
    }

    public static Modifier anchoredDraggable$default(Modifier arg9, AnchoredDraggableState arg10, boolean arg11, Orientation arg12, boolean arg13, MutableInteractionSource arg14, OverscrollEffect arg15, boolean arg16, FlingBehavior arg17, int arg18, Object arg19) {
        AnchoredDraggableState v1_1;
        Orientation v3;
        boolean v2;
        Modifier v0_1;
        FlingBehavior v8;
        int v0 = arg18;
        MutableInteractionSource v1 = null;
        MutableInteractionSource v5 = (v0 & 16) != 0 ? v1 : arg14;
        OverscrollEffect v6 = (v0 & 0x20) != 0 ? ((OverscrollEffect)v1) : arg15;
        boolean v7 = (v0 & 0x40) != 0 ? arg10.isAnimationRunning() : arg16;
        if((v0 & 0x80) != 0) {
            v8 = ((FlingBehavior)v1);
            v0_1 = arg9;
            v2 = arg11;
            v3 = arg12;
            v1_1 = arg10;
        }
        else {
            v8 = arg17;
            v0_1 = arg9;
            v1_1 = arg10;
            v2 = arg11;
            v3 = arg12;
        }

        return AnchoredDraggableKt.anchoredDraggable(v0_1, v1_1, v2, v3, true, v5, v6, v7, v8);
    }

    public static final TargetedFlingBehavior anchoredDraggableFlingBehavior(AnchoredDraggableState arg2, Density arg3, Function1 arg4, AnimationSpec arg5) {
        return SnapFlingBehaviorKt.snapFlingBehavior(AnchoredDraggableKt.AnchoredDraggableLayoutInfoProvider(arg2, arg4, new AnchoredDraggableKt$$ExternalSyntheticLambda5(arg3)), AnchoredDraggableKt.NoOpDecayAnimationSpec, arg5);
    }

    static final float anchoredDraggableFlingBehavior$lambda$0(Density arg1) {
        return arg1.toPx-0680j_4(Dp.constructor-impl(125f));
    }

    private static final Object animateTo(AnchoredDraggableState arg1, float arg2, AnchoredDragScope arg3, DraggableAnchors arg4, Object arg5, AnimationSpec arg6, Continuation arg7) {
        float v4 = arg4.positionOf(arg5);
        FloatRef v5 = new FloatRef();
        float v1 = Float.isNaN(arg1.getOffset()) ? 0f : arg1.getOffset();
        v5.element = v1;
        if(!Float.isNaN(v4)) {
            if(v5.element == v4) {
            }
            else {
                Object v1_1 = SuspendAnimationKt.animate(v5.element, v4, arg2, arg6, new AnchoredDraggableKt$$ExternalSyntheticLambda1(arg3, v5), arg7);
                if(v1_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v1_1;
                }
            }
        }

        return Unit.INSTANCE;
    }

    public static final Object animateTo(AnchoredDraggableState arg9, Object arg10, AnimationSpec arg11, Continuation arg12) {
        Object v9 = AnchoredDraggableState.anchoredDrag$default(arg9, arg10, null, new AnchoredDraggableKt$animateTo$4(arg9, arg11, null), arg12, 2, null);
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v9;
        }

        return Unit.INSTANCE;
    }

    public static Object animateTo$default(AnchoredDraggableState arg0, Object arg1, AnimationSpec arg2, Continuation arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.getUsePreModifierChangeBehavior$foundation() ? arg0.getSnapAnimationSpec() : AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
        }

        return AnchoredDraggableKt.animateTo(arg0, arg1, arg2, arg3);
    }

    private static final Unit animateTo$lambda$0$1(AnchoredDragScope arg0, FloatRef arg1, float arg2, float arg3) {
        arg0.dragTo(arg2, arg3);
        arg1.element = arg2;
        return Unit.INSTANCE;
    }

    public static final Object animateToWithDecay(AnchoredDraggableState arg10, Object arg11, float arg12, AnimationSpec arg13, DecayAnimationSpec arg14, Continuation arg15) {
        Object v2;
        float v1_3;
        AnchoredDraggableKt$animateToWithDecay$1 v1_1;
        if((arg15 instanceof AnchoredDraggableKt$animateToWithDecay$1)) {
            Continuation v1 = arg15;
            int v4 = 0x80000000;
            if((((AnchoredDraggableKt$animateToWithDecay$1)v1).label & v4) != 0) {
                ((AnchoredDraggableKt$animateToWithDecay$1)v1).label -= v4;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v1_1 = new AnchoredDraggableKt$animateToWithDecay$1(arg15);
        }

        Continuation v7 = ((Continuation)v1_1);
        Object v0 = ((AnchoredDraggableKt$animateToWithDecay$1)v7).result;
        Object v9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1_2 = ((AnchoredDraggableKt$animateToWithDecay$1)v7).label;
        if(v1_2 == 0) {
            ResultKt.throwOnFailure(v0);
            FloatRef v4_1 = new FloatRef();
            v4_1.element = arg12;
            FloatRef v0_1 = v4_1;
            AnchoredDraggableKt$animateToWithDecay$2 v5 = new AnchoredDraggableKt$animateToWithDecay$2(arg10, arg12, arg13, v4_1, arg14, null);
            ((AnchoredDraggableKt$animateToWithDecay$1)v7).L$0 = v0_1;
            ((AnchoredDraggableKt$animateToWithDecay$1)v7).F$0 = arg12;
            ((AnchoredDraggableKt$animateToWithDecay$1)v7).label = 1;
            if(AnchoredDraggableState.anchoredDrag$default(arg10, arg11, null, ((Function4)v5), v7, 2, null) == v9) {
                return v9;
            }
            else {
                v1_3 = arg12;
                FloatRef v2_1 = v0_1;
            }
        }
        else if(v1_2 == 1) {
            v1_3 = ((AnchoredDraggableKt$animateToWithDecay$1)v7).F$0;
            v2 = ((AnchoredDraggableKt$animateToWithDecay$1)v7).L$0;
            ResultKt.throwOnFailure(v0);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Boxing.boxFloat(v1_3 - ((FloatRef)v2).element);
    }

    public static Object animateToWithDecay$default(AnchoredDraggableState arg6, Object arg7, float arg8, AnimationSpec arg9, DecayAnimationSpec arg10, Continuation arg11, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg9 = arg6.getUsePreModifierChangeBehavior$foundation() ? arg6.getSnapAnimationSpec() : AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
        }

        AnimationSpec v3 = arg9;
        if((arg12 & 8) != 0) {
            DecayAnimationSpec v9 = arg6.getUsePreModifierChangeBehavior$foundation() ? arg6.getDecayAnimationSpec() : AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec();
            arg10 = v9;
        }

        return AnchoredDraggableKt.animateToWithDecay(arg6, arg7, arg8, v3, arg10, arg11);
    }

    private static final float coerceToTarget(float arg2, float arg3) {
        if(arg3 == 0f) {
            return 0;
        }

        if(arg3 > 0f) {
            return RangesKt.coerceAtMost(arg2, arg3);
        }

        return RangesKt.coerceAtLeast(arg2, arg3);
    }

    private static final Object computeTarget(DraggableAnchors arg5, float arg6, float arg7, Function1 arg8, Function0 arg9) {
        Object v5;
        if(Float.isNaN(arg6)) {
            goto label_57;
        }

        int v2 = 0;
        int v0 = Float.compare(Math.abs(arg7), 0f) > 0 ? 1 : 0;
        boolean v1 = v0 == 0 || arg7 <= 0f ? false : true;
        if(v0 == 0) {
            v5 = arg5.closestAnchor(arg6);
            Intrinsics.checkNotNull(v5);
            return v5;
        }

        if(Math.abs(arg7) >= Math.abs(arg9.invoke().floatValue())) {
            v5 = arg5.closestAnchor(arg6, v1);
            Intrinsics.checkNotNull(v5);
            return v5;
        }

        Object v7 = arg5.closestAnchor(arg6, false);
        Intrinsics.checkNotNull(v7);
        float v9 = arg5.positionOf(v7);
        Object v0_1 = arg5.closestAnchor(arg6, true);
        Intrinsics.checkNotNull(v0_1);
        float v5_1 = arg5.positionOf(v0_1);
        float v8 = Math.abs(arg8.invoke(Float.valueOf(Math.abs(v9 - v5_1))).floatValue());
        if(v1) {
        }
        else {
            v9 = v5_1;
        }

        if(Math.abs(v9 - arg6) >= v8) {
            v2 = 1;
        }

        if(v2 == 1) {
            if(v1) {
            }
            else {
                return v7;
            }
        }
        else if(v2 != 0) {
            goto label_54;
        }
        else if(v1) {
            return v7;
        }

        return v0_1;
    label_54:
        throw new NoWhenBranchMatchedException();
    label_57:
        throw new IllegalArgumentException("The offset provided to computeTarget must not be NaN.".toString());
    }

    private static final void debugLog(Function0 arg0) {
    }

    private static final DefaultDraggableAnchors emptyDraggableAnchors() {
        return new DefaultDraggableAnchors(CollectionsKt.emptyList(), new float[0]);
    }

    public static final void forEach(DraggableAnchors arg4, Function2 arg5) {
        int v0 = arg4.getSize();
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 >= v0) {
                return;
            }

            Object v2 = arg4.anchorAt(v1);
            if(v2 == null) {
                break;
            }

            arg5.invoke(v2, Float.valueOf(arg4.positionAt(v1)));
        }

        throw new IllegalArgumentException("There was no key at index " + v1 + ". Please report a bug.".toString());
    }

    public static final float getAnchoredDraggableMinFlingVelocity() {
        return AnchoredDraggableKt.AnchoredDraggableMinFlingVelocity;
    }

    private static final Object restartable(Function0 arg4, Function2 arg5, Continuation arg6) {
        AnchoredDraggableKt$restartable$1 v0_1;
        int v2;
        if((arg6 instanceof AnchoredDraggableKt$restartable$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((AnchoredDraggableKt$restartable$1)v0).label & v2) != 0) {
                ((AnchoredDraggableKt$restartable$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new AnchoredDraggableKt$restartable$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            try {
                AnchoredDraggableKt$restartable$2 v6_1 = new AnchoredDraggableKt$restartable$2(arg4, arg5, null);
                v0_1.label = 1;
                if(CoroutineScopeKt.coroutineScope(((Function2)v6_1), ((Continuation)v0_1)) == v1) {
                    return v1;
                }
            }
            catch(AnchoredDragFinishedSignal ) {
            }

            goto label_33;
            return v1;
        }
        else if(v2 == 1) {
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(AnchoredDragFinishedSignal ) {
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_33:
        return Unit.INSTANCE;
    }

    public static final Object snapTo(AnchoredDraggableState arg9, Object arg10, Continuation arg11) {
        Object v9 = AnchoredDraggableState.anchoredDrag$default(arg9, arg10, null, new AnchoredDraggableKt$snapTo$2(null), arg11, 2, null);
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v9;
        }

        return Unit.INSTANCE;
    }
}

