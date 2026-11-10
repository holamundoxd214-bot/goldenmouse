package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(d1={"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A-\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001A3\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00152\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0016\u001A3\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00172\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0018\u001Aa\u0010\u001F\u001A\u0018\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0 R\b\u0012\u0004\u0012\u0002H\"0\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0%2\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010&\u001A\\\u0010\'\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\"0\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u0010(\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00020\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010-\u001AA\u0010.\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0006\u0010/\u001A\u0002H\u00022\u0006\u0010\u0003\u001A\u0002H\u00022\u0006\u00100\u001A\u00020\u0005H\u0001¢\u0006\u0002\u00101\u001A¦\u0001\u00102\u001A\b\u0012\u0004\u0012\u0002H\u000203\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0%2*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0002060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u0002H\u00020\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010:\u001Am\u0010;\u001A\b\u0012\u0004\u0012\u0002H\u000203\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u0006\u0010<\u001A\u0002H\u00022\u0006\u0010=\u001A\u0002H\u00022\f\u0010>\u001A\b\u0012\u0004\u0012\u0002H\u0002062\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0%2\u0006\u0010\u0004\u001A\u00020\u0005H\u0001¢\u0006\u0002\u0010?\u001Ai\u0010@\u001A\u00020\f\"\u0004\b\u0000\u0010\"\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010!*\u00020#*\b\u0012\u0004\u0012\u0002H\"0\u00012\u001C\u0010A\u001A\u0018\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0BR\b\u0012\u0004\u0012\u0002H\"0\u00012\u0006\u0010<\u001A\u0002H\u00022\u0006\u0010=\u001A\u0002H\u00022\f\u0010>\u001A\b\u0012\u0004\u0012\u0002H\u000206H\u0003¢\u0006\u0002\u0010C\u001A\u0082\u0001\u0010D\u001A\b\u0012\u0004\u0012\u00020\u001A03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001A060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001A0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001A\u0082\u0001\u0010F\u001A\b\u0012\u0004\u0012\u00020G03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020G060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020G0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001A\u0082\u0001\u0010H\u001A\b\u0012\u0004\u0012\u00020I03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020I060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020I0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001A\u0082\u0001\u0010J\u001A\b\u0012\u0004\u0012\u00020K03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020K060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020K0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001A\u0082\u0001\u0010L\u001A\b\u0012\u0004\u0012\u00020M03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020M060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020M0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001A\u0082\u0001\u0010N\u001A\b\u0012\u0004\u0012\u00020\b03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001A\u0082\u0001\u0010O\u001A\b\u0012\u0004\u0012\u00020P03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020P060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020P0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\u001A\u0082\u0001\u0010Q\u001A\b\u0012\u0004\u0012\u00020R03\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u0002H\"0\u00012*\b\n\u00104\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"05\u0012\n\u0012\b\u0012\u0004\u0012\u00020R060\n¢\u0006\u0002\b,¢\u0006\u0002\b72\b\b\u0002\u0010\u0004\u001A\u00020\u00052&\u00108\u001A\"\u0012\u0013\u0012\u0011H\"¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020R0\n¢\u0006\u0002\b,H\u0087\b¢\u0006\u0002\u0010E\"\u000E\u0010\u0007\u001A\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u001E\u0010\t\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000B\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001B\u0010\r\u001A\u00020\u000E8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u000F\u0010\u0010\"\u000E\u0010\u0019\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001B\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001C\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001D\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001E\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000¨\u0006S"}, d2={"updateTransition", "Landroidx/compose/animation/core/Transition;", "T", "targetState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "AnimationDebugDurationScale", "", "SeekableTransitionStateTotalDurationChanged", "Lkotlin/Function1;", "Landroidx/compose/animation/core/SeekableTransitionState;", "", "SeekableStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "Lkotlin/Lazy;", "rememberTransition", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "NoReset", "", "ResetNoSnap", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "V", "S", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createChildTransition", "transformToChildState", "Lkotlin/ParameterName;", "name", "parentState", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "animateValue", "Landroidx/compose/runtime/State;", "transitionSpec", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "state", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "UpdateInitialAndTargetValues", "transitionAnimation", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)V", "animateFloat", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDp", "Landroidx/compose/ui/unit/Dp;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateInt", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;
    private static final float NoReset = -1f;
    private static final float ResetAnimationSnap = -3f;
    private static final float ResetAnimationSnapCurrent = -4f;
    private static final float ResetAnimationSnapTarget = -5f;
    private static final float ResetNoSnap = -2f;
    private static final Lazy SeekableStateObserver$delegate;
    private static final Function1 SeekableTransitionStateTotalDurationChanged;

    public static Unit $r8$lambda$Am6FPiy7Uy7AZ5PZ4f99UClJjTY(Function0 arg0) {
        return TransitionKt.SeekableStateObserver_delegate$lambda$0$0(arg0);
    }

    public static DisposableEffectResult $r8$lambda$eW0PesiXiKrzG_FaJw6sBSld3zk(Transition arg0, Transition arg1, DisposableEffectScope arg2) {
        return TransitionKt.createChildTransitionInternal$lambda$1$0(arg0, arg1, arg2);
    }

    public static DisposableEffectResult $r8$lambda$fqopTCcPRIi9RIZ84IQEwSVIQ2E(Transition arg0, DisposableEffectScope arg1) {
        return TransitionKt.updateTransition$lambda$1$0(arg0, arg1);
    }

    public static DisposableEffectResult $r8$lambda$pC_6J8dZrzuaBCXHu88De9TwnbY(Transition arg0, TransitionAnimationState arg1, DisposableEffectScope arg2) {
        return TransitionKt.createTransitionAnimation$lambda$1$0(arg0, arg1, arg2);
    }

    public static DisposableEffectResult $r8$lambda$pSIn4BF4LGAr_OKYtfPav9YYX_U(Transition arg0, DeferredAnimation arg1, DisposableEffectScope arg2) {
        return TransitionKt.createDeferredAnimation$lambda$1$0(arg0, arg1, arg2);
    }

    public static DisposableEffectResult $r8$lambda$x2eM6c-orMRPRTLBbNCu0jTM06Q(Transition arg0, DisposableEffectScope arg1) {
        return TransitionKt.rememberTransition$lambda$2$0(arg0, arg1);
    }

    static {
        TransitionKt.SeekableTransitionStateTotalDurationChanged = new TransitionKt$$ExternalSyntheticLambda3();
        TransitionKt.SeekableStateObserver$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TransitionKt$$ExternalSyntheticLambda4());
    }

    static final SnapshotStateObserver SeekableStateObserver_delegate$lambda$0() {
        SnapshotStateObserver v0 = new SnapshotStateObserver(new TransitionKt$$ExternalSyntheticLambda6());
        v0.start();
        return v0;
    }

    private static final Unit SeekableStateObserver_delegate$lambda$0$0(Function0 arg0) {
        arg0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit SeekableTransitionStateTotalDurationChanged$lambda$0(SeekableTransitionState arg0) {
        arg0.onTotalDurationChanged$animation_core();
        return Unit.INSTANCE;
    }

    private static final void UpdateInitialAndTargetValues(Transition arg7, TransitionAnimationState arg8, Object arg9, Object arg10, FiniteAnimationSpec arg11, Composer arg12, int arg13) {
        boolean v2_1;
        int v2;
        int v1;
        int v0 = 0x33AE021D;
        arg12 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg12, "C(UpdateInitialAndTargetValues)N(transitionAnimation,initialValue,targetValue,animationSpec):Transition.kt#pdpnli");
        if((arg13 & 6) == 0) {
            v1 = arg12.changed(arg7) ? 4 : 2;
            v1 |= arg13;
        }
        else {
            v1 = arg13;
        }

        if((arg13 & 0x30) == 0) {
            v2 = arg12.changed(arg8) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg13 & 0x180) == 0) {
            v2_1 = (arg13 & 0x200) == 0 ? arg12.changed(arg9) : arg12.changedInstance(arg9);
            v2 = v2_1 ? 0x100 : 0x80;
            v1 |= v2;
        }

        if((arg13 & 0xC00) == 0) {
            v2_1 = (arg13 & 0x1000) == 0 ? arg12.changed(arg10) : arg12.changedInstance(arg10);
            v2 = v2_1 ? 0x800 : 0x400;
            v1 |= v2;
        }

        if((arg13 & 0x6000) == 0) {
            v2_1 = (0x8000 & arg13) == 0 ? arg12.changed(arg11) : arg12.changedInstance(arg11);
            v2 = v2_1 ? 0x4000 : 0x2000;
            v1 |= v2;
        }

        v2_1 = (v1 & 9363) != 9362 ? true : false;
        if(arg12.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.animation.core.UpdateInitialAndTargetValues (Transition.kt:1907)");
            }

            if(arg7.isSeeking()) {
                arg8.updateInitialAndTargetValue$animation_core(arg9, arg10, arg11);
            }
            else {
                arg8.updateTargetValue$animation_core(arg10, arg11);
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_83;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg12.skipToGroupEnd();
        }

    label_83:
        ScopeUpdateScope v12 = arg12.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new TransitionKt$$ExternalSyntheticLambda8(arg7, arg8, arg9, arg10, arg11, arg13));
        }
    }

    static final Unit UpdateInitialAndTargetValues$lambda$0(Transition arg7, TransitionAnimationState arg8, Object arg9, Object arg10, FiniteAnimationSpec arg11, int arg12, Composer arg13, int arg14) {
        TransitionKt.UpdateInitialAndTargetValues(arg7, arg8, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    public static final Function1 access$getSeekableTransitionStateTotalDurationChanged$p() {
        return TransitionKt.SeekableTransitionStateTotalDurationChanged;
    }

    public static final State animateDp(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v7_3;
        State v8_1;
        Object v15;
        Object v12;
        TransitionKt$animateDp$1 v2;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, -89793049, "CC(animateDp)N(transitionSpec,label,targetValueByState)1981@85315L75:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            v2 = TransitionKt$animateDp$1.INSTANCE;
        }
        else {
            Function3 v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "DpAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(v8_1.getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, ((Function3)v2).invoke(v7_3.getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateFloat(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v8_1;
        Object v15;
        Object v12;
        Function3 v2_1;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, 0x32503BCB, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            TransitionKt$animateFloat$1 v2 = TransitionKt$animateFloat$1.INSTANCE;
        }
        else {
            v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "FloatAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(v8_1.getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            State v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, v2_1.invoke(((State)v7_2).getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateInt(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v7_3;
        State v8_1;
        Object v15;
        Object v12;
        Function3 v2_1;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, -230569122, "CC(animateInt)N(transitionSpec,label,targetValueByState)2105@92287L76:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            TransitionKt$animateInt$1 v2 = TransitionKt$animateInt$1.INSTANCE;
        }
        else {
            v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "IntAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(v8_1.getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, v2_1.invoke(v7_3.getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateIntOffset(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v7_3;
        State v8_1;
        Object v15;
        Object v12;
        TransitionKt$animateIntOffset$1 v2;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, 0xB06CCCD1, "CC(animateIntOffset)N(transitionSpec,label,targetValueByState)2075@90580L82:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            v2 = TransitionKt$animateIntOffset$1.INSTANCE;
        }
        else {
            Function3 v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "IntOffsetAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(v8_1.getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, ((Function3)v2).invoke(v7_3.getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateIntSize(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v7_3;
        Object v15;
        Object v12;
        Function3 v2_1;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, 0x8262F57F, "CC(animateIntSize)N(transitionSpec,label,targetValueByState)2136@94040L80:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            TransitionKt$animateIntSize$1 v2 = TransitionKt$animateIntSize$1.INSTANCE;
        }
        else {
            v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "IntSizeAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            State v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(((State)v8).getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, v2_1.invoke(v7_3.getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateOffset(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v7_3;
        Object v15;
        Object v12;
        TransitionKt$animateOffset$1 v2;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, -787164050, "CC(animateOffset)N(transitionSpec,label,targetValueByState)2011@87059L79:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            v2 = TransitionKt$animateOffset$1.INSTANCE;
        }
        else {
            Function3 v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "OffsetAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(Offset.Companion);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            State v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(((State)v8).getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, ((Function3)v2).invoke(v7_3.getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateRect(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v8_1;
        Object v15;
        Object v12;
        TransitionKt$animateRect$1 v2;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, 0x54B019BF, "CC(animateRect)N(transitionSpec,label,targetValueByState)2166@95774L77:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            v2 = TransitionKt$animateRect$1.INSTANCE;
        }
        else {
            Function3 v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "RectAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(Rect.Companion);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(v8_1.getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            State v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, ((Function3)v2).invoke(((State)v7_2).getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateSize(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v7_3;
        Object v15;
        Object v12;
        TransitionKt$animateSize$1 v2;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, 0x39B2405C, "CC(animateSize)N(transitionSpec,label,targetValueByState)2041@88792L77:Transition.kt#pdpnli");
        if((arg22 & 1) != 0) {
            v2 = TransitionKt$animateSize$1.INSTANCE;
        }
        else {
            Function3 v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "SizeAnimation" : arg18;
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(Size.Companion);
        int v7 = arg21 << 3;
        int v3 = arg21 & 14 | v7 & 0x380 | v7 & 0x1C00 | v7 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        String v9 = "CC(remember):Transition.kt#9igjgp";
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v9);
            v7 = (v3 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v7 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v7_1 = Snapshot.Companion;
                Snapshot v12_1 = v7_1.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v7_1.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v7_1.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v7_1.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v7 = v3 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v9);
        int v13_1 = v3 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v8 = v6.rememberedValue();
        if(v15_1 != 0 || v8 == Composer.Companion.getEmpty()) {
            State v8_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(v0));
            v6.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(((State)v8).getValue(), v6, Integer.valueOf(v7));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v9);
        int v8_2 = v14_1 > v10 && (v6.changed(v0)) || (v3 & 6) == v10 ? 1 : 0;
        Object v7_2 = v6.rememberedValue();
        if(v8_2 != 0 || v7_2 == Composer.Companion.getEmpty()) {
            v7_3 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(v0));
            v6.updateRememberedValue(v7_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = TransitionKt.createTransitionAnimation(v0, v12, v1_1, ((Function3)v2).invoke(v7_3.getValue(), v6, Integer.valueOf(v3 >> 3 & 0x70)), v4, v5, v6, v13_1 | v3 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateValue(Transition arg14, TwoWayConverter arg15, Function3 arg16, String arg17, Function3 arg18, Composer arg19, int arg20, int arg21) {
        State v13_1;
        Object v12;
        Object v9;
        int v3;
        Function3 v1_1;
        Function3 v0 = arg18;
        Composer v6 = arg19;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        if((arg21 & 2) != 0) {
            TransitionKt$animateValue$1 v1 = TransitionKt$animateValue$1.INSTANCE;
        }
        else {
            v1_1 = arg16;
        }

        int v2 = 4;
        String v5 = (arg21 & 4) != 0 ? "ValueAnimation" : arg17;
        int v4 = 0;
        String v8 = "CC(remember):Transition.kt#9igjgp";
        if(!arg14.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v8);
            v3 = (arg20 & 14 ^ 6) > v2 && (v6.changed(arg14)) || (arg20 & 6) == v2 ? 1 : 0;
            v9 = v6.rememberedValue();
            if(v3 != 0 || v9 == Composer.Companion.getEmpty()) {
                Companion v3_1 = Snapshot.Companion;
                Snapshot v9_1 = v3_1.getCurrentThreadSnapshot();
                Function1 v10 = v9_1 != null ? v9_1.getReadObserver() : null;
                Snapshot v11 = v3_1.makeCurrentNonObservable(v9_1);
                try {
                    v12 = arg14.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v3_1.restoreNonObservable(v9_1, v11, v10);
                    throw v0_1;
                }

                v3_1.restoreNonObservable(v9_1, v11, v10);
                v6.updateRememberedValue(v12);
                v9 = v12;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v9 = arg14.getCurrentState();
        }

        v3 = arg20 >> 9 & 0x70;
        v9 = v0.invoke(v9, v6, Integer.valueOf(v3));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v8);
        int v10_1 = arg20 & 14;
        int v11_1 = v10_1 ^ 6;
        int v12_1 = v11_1 > v2 && (v6.changed(arg14)) || (arg20 & 6) == v2 ? 1 : 0;
        Object v13 = v6.rememberedValue();
        if(v12_1 != 0 || v13 == Composer.Companion.getEmpty()) {
            v13_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$targetValue$1$1(arg14));
            v6.updateRememberedValue(v13_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v0_2 = v0.invoke(v13_1.getValue(), v6, Integer.valueOf(v3));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v8);
        if(v11_1 > v2 && (v6.changed(arg14)) || (arg20 & 6) == v2) {
            v4 = 1;
        }

        Object v2_1 = v6.rememberedValue();
        if(v4 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            State v2_2 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateValue$animationSpec$1$1(arg14));
            v6.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v14 = TransitionKt.createTransitionAnimation(arg14, v9, v0_2, v1_1.invoke(((State)v2_1).getValue(), v6, Integer.valueOf(arg20 >> 3 & 0x70)), arg15, v5, v6, 0xE000 & arg20 << 9 | v10_1 | 0x70000 & arg20 << 6);
        ComposerKt.sourceInformationMarkerEnd(arg19);
        return v14;
    }

    public static final Transition createChildTransition(Transition arg7, String arg8, Function3 arg9, Composer arg10, int arg11, int arg12) {
        ComposerKt.sourceInformationMarkerStart(arg10, 0xDFDABA57, "CC(createChildTransition)N(label,transformToChildState)1768@75281L36,1769@75341L74,1770@75438L39,1771@75489L63:Transition.kt#pdpnli");
        int v0 = 1;
        if((arg12 & 1) != 0) {
            arg8 = "ChildTransition";
        }

        String v4 = arg8;
        ComposerKt.sourceInformationMarkerStart(arg10, 1410701659, "CC(remember):Transition.kt#9igjgp");
        int v8 = arg11 & 14;
        int v1 = 4;
        if((v8 ^ 6) <= v1 || !arg10.changed(arg7)) {
            if((arg11 & 6) == v1) {
            }
            else {
                v0 = 0;
            }
        }

        Object v12 = arg10.rememberedValue();
        if(v0 != 0 || v12 == Composer.Companion.getEmpty()) {
            v12 = arg7.getCurrentState();
            arg10.updateRememberedValue(v12);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        if(arg7.isSeeking()) {
            v12 = arg7.getCurrentState();
        }

        v0 = arg11 >> 3 & 0x70;
        arg7 = TransitionKt.createChildTransitionInternal(arg7, arg9.invoke(v12, arg10, Integer.valueOf(v0)), arg9.invoke(arg7.getTargetState(), arg10, Integer.valueOf(v0)), v4, arg10, v8 | arg11 << 6 & 0x1C00);
        ComposerKt.sourceInformationMarkerEnd(arg10);
        return arg7;
    }

    public static final Transition createChildTransitionInternal(Transition arg9, Object arg10, Object arg11, String arg12, Composer arg13, int arg14) {
        Transition v6_1;
        int v1 = 0xF42E10CA;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(createChildTransitionInternal)N(initialState,targetState,childLabel)1782@75760L124,1786@75919L92,1786@75890L121:Transition.kt#pdpnli");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1780)");
        }

        String v1_1 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg13, 0xA0ED1BE6, v1_1);
        int v0 = arg14 & 14 ^ 6;
        int v2 = 1;
        int v4 = 4;
        int v5 = v0 > v4 && (arg13.changed(arg9)) || (arg14 & 6) == v4 ? 1 : 0;
        Object v6 = arg13.rememberedValue();
        if(v5 != 0 || v6 == Composer.Companion.getEmpty()) {
            v6_1 = new Transition(new MutableTransitionState(arg10), arg9, arg9.getLabel() + " > " + arg12);
            arg13.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        ComposerKt.sourceInformationMarkerStart(arg13, 0xA0ED2FA6, v1_1);
        if(v0 <= v4 || !arg13.changed(arg9)) {
            if((arg14 & 6) == v4) {
            }
            else {
                v2 = 0;
            }
        }

        int v12 = arg13.changed(v6_1) | v2;
        Object v14 = arg13.rememberedValue();
        if(v12 != 0 || v14 == Composer.Companion.getEmpty()) {
            TransitionKt$$ExternalSyntheticLambda1 v14_1 = new TransitionKt$$ExternalSyntheticLambda1(arg9, v6_1);
            arg13.updateRememberedValue(v14_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        EffectsKt.DisposableEffect(v6_1, ((Function1)v14), arg13, 0);
        if(arg9.isSeeking()) {
            v6_1.seek(arg10, arg11, arg9.getLastSeekedTimeNanos$animation_core());
        }
        else {
            v6_1.updateTarget$animation_core(arg11);
            v6_1.setSeeking$animation_core(false);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
        return v6_1;
    }

    private static final DisposableEffectResult createChildTransitionInternal$lambda$1$0(Transition arg0, Transition arg1, DisposableEffectScope arg2) {
        arg0.addTransition$animation_core(arg1);
        return new TransitionKt$createChildTransitionInternal$lambda$1$0$$inlined$onDispose$1(arg0, arg1);
    }

    public static final DeferredAnimation createDeferredAnimation(Transition arg6, TwoWayConverter arg7, String arg8, Composer arg9, int arg10, int arg11) {
        TransitionKt$$ExternalSyntheticLambda2 v8_1;
        DeferredAnimation v5_1;
        int v1 = 0x99D490E0;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(createDeferredAnimation)N(typeConverter,label)1739@73787L58,1740@73877L43,1740@73850L70:Transition.kt#pdpnli");
        if((arg11 & 2) != 0) {
            arg8 = "DeferredAnimation";
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1738)");
        }

        String v0 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg9, 0x76F3F41A, v0);
        arg11 = arg10 & 14 ^ 6;
        v1 = 1;
        int v3 = 4;
        int v4 = arg11 > v3 && (arg9.changed(arg6)) || (arg10 & 6) == v3 ? 1 : 0;
        Object v5 = arg9.rememberedValue();
        if(v4 != 0 || v5 == Composer.Companion.getEmpty()) {
            v5_1 = new DeferredAnimation(arg6, arg7, arg8);
            arg9.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        ComposerKt.sourceInformationMarkerStart(arg9, 0x76F3FF4B, v0);
        if(arg11 <= v3 || !arg9.changed(arg6)) {
            if((arg10 & 6) == v3) {
            }
            else {
                v1 = 0;
            }
        }

        int v7 = arg9.changedInstance(v5_1) | v1;
        Object v8 = arg9.rememberedValue();
        if(v7 != 0 || v8 == Composer.Companion.getEmpty()) {
            v8_1 = new TransitionKt$$ExternalSyntheticLambda2(arg6, v5_1);
            arg9.updateRememberedValue(v8_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        EffectsKt.DisposableEffect(v5_1, ((Function1)v8_1), arg9, 0);
        if(arg6.isSeeking()) {
            v5_1.setupSeeking$animation_core();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return v5_1;
    }

    private static final DisposableEffectResult createDeferredAnimation$lambda$1$0(Transition arg0, DeferredAnimation arg1, DisposableEffectScope arg2) {
        return new TransitionKt$createDeferredAnimation$lambda$1$0$$inlined$onDispose$1(arg0, arg1);
    }

    public static final State createTransitionAnimation(Transition arg16, Object arg17, Object arg18, FiniteAnimationSpec arg19, TwoWayConverter arg20, String arg21, Composer arg22, int arg23) {
        TransitionAnimationState v0_2;
        Object v12_1;
        String v5;
        Transition v1_2;
        AnimationVector v3;
        Snapshot v12;
        Function1 v11;
        TwoWayConverter v4;
        Transition v0 = arg16;
        Composer v6 = arg22;
        int v7 = arg23;
        int v2 = -304821198;
        ComposerKt.sourceInformationMarkerStart(v6, v2, "C(createTransitionAnimation)N(initialValue,targetValue,animationSpec,typeConverter,label)1871@79670L978,1889@80653L91,1891@80788L108,1891@80750L146:Transition.kt#pdpnli");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v7, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1869)");
        }

        String v8 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v6, 0xCBD2AD44, v8);
        int v9 = v7 & 14;
        int v10 = v9 ^ 6;
        int v13 = 4;
        int v1 = v10 > v13 && (v6.changed(v0)) || (v7 & 6) == v13 ? 1 : 0;
        Object v2_1 = v6.rememberedValue();
        if(v1 != 0 || v2_1 == Composer.Companion.getEmpty()) {
            Companion v14 = Snapshot.Companion;
            Snapshot v15 = v14.getCurrentThreadSnapshot();
            Function1 v1_1 = v15 != null ? v15.getReadObserver() : null;
            Snapshot v2_2 = v14.makeCurrentNonObservable(v15);
            try {
                v4 = arg20;
                v11 = v1_1;
                v12 = v2_2;
                v3 = AnimationStateKt.createZeroVectorFrom(v4, arg18);
                v1_2 = arg16;
                v2_1 = arg17;
                v5 = arg21;
            }
            catch(Throwable v0_1) {
                Transition v11_1 = v1_2;
                v12_1 = v2_1;
                goto label_107;
            }

            try {
                v0_2 = new TransitionAnimationState(v1_2, v2_1, v3, v4, v5);
                goto label_48;
            }
            catch(Throwable v0_1) {
            }

        label_107:
            v14.restoreNonObservable(v15, ((Snapshot)v12_1), v11);
            throw v0_1;
        label_48:
            v14.restoreNonObservable(v15, v12, v11);
            v6.updateRememberedValue(v0_2);
            TransitionAnimationState v2_3 = v0_2;
        }

        Object v1_3 = v2_1;
        ComposerKt.sourceInformationMarkerEnd(v6);
        int v0_3 = v7 >> 3 & 8;
        int v3_1 = v7 << 3;
        Composer v5_1 = v6;
        int v6_1 = v0_3 << 9 | (v0_3 << 6 | v9 | v3_1 & 0x380) | v3_1 & 0x1C00 | 0xE000 & v3_1;
        v0 = arg16;
        TransitionKt.UpdateInitialAndTargetValues(v0, ((TransitionAnimationState)v1_3), arg17, arg18, arg19, v5_1, v6_1);
        ComposerKt.sourceInformationMarkerStart(v5_1, -875350626, v8);
        int v11_2 = v10 > v13 && (v5_1.changed(v0)) || (v7 & 6) == v13 ? 1 : 0;
        v2 = v5_1.changed(v1_3) | v11_2;
        Object v3_2 = v5_1.rememberedValue();
        if(v2 != 0 || v3_2 == Composer.Companion.getEmpty()) {
            TransitionKt$$ExternalSyntheticLambda5 v3_3 = new TransitionKt$$ExternalSyntheticLambda5(v0, ((TransitionAnimationState)v1_3));
            v5_1.updateRememberedValue(v3_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v5_1);
        EffectsKt.DisposableEffect(v1_3, ((Function1)v3_2), v5_1, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5_1);
        return ((State)v1_3);
    }

    private static final DisposableEffectResult createTransitionAnimation$lambda$1$0(Transition arg0, TransitionAnimationState arg1, DisposableEffectScope arg2) {
        arg0.addAnimation$animation_core(arg1);
        return new TransitionKt$createTransitionAnimation$lambda$1$0$$inlined$onDispose$1(arg0, arg1);
    }

    public static final SnapshotStateObserver getSeekableStateObserver() {
        return TransitionKt.SeekableStateObserver$delegate.getValue();
    }

    public static final Transition rememberTransition(TransitionState arg10, String arg11, Composer arg12, int arg13, int arg14) {
        Object v11;
        Transition v6_2;
        Transition v9;
        int v1 = 0x61F14C21;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(rememberTransition)N(transitionState,label)806@34785L472,825@35887L190,825@35858L219:Transition.kt#pdpnli");
        Continuation v0 = null;
        if((arg14 & 2) != 0) {
            arg11 = ((String)v0);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:804)");
        }

        String v1_1 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg12, 0xAACEDBB9, v1_1);
        arg14 = arg13 & 14 ^ 6;
        int v2 = 1;
        int v3 = 4;
        int v5 = arg14 > v3 && (arg12.changed(arg10)) || (arg13 & 6) == v3 ? 1 : 0;
        Object v6 = arg12.rememberedValue();
        if(v5 != 0 || v6 == Composer.Companion.getEmpty()) {
            Companion v5_1 = Snapshot.Companion;
            Snapshot v6_1 = v5_1.getCurrentThreadSnapshot();
            Function1 v7 = v6_1 != null ? v6_1.getReadObserver() : ((Function1)v0);
            Snapshot v8 = v5_1.makeCurrentNonObservable(v6_1);
            try {
                v9 = new Transition(arg10, arg11);
            }
            catch(Throwable v10) {
                v5_1.restoreNonObservable(v6_1, v8, v7);
                throw v10;
            }

            v5_1.restoreNonObservable(v6_1, v8, v7);
            arg12.updateRememberedValue(v9);
            v6_2 = v9;
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        if((arg10 instanceof SeekableTransitionState)) {
            arg12.startReplaceGroup(0xAF148DC9);
            ComposerKt.sourceInformation(arg12, "814@35394L382,814@35320L456");
            Object v5_2 = arg10.getCurrentState();
            v11 = arg10.getTargetState();
            ComposerKt.sourceInformationMarkerStart(arg12, 0xAACF277F, v1_1);
            if(arg14 <= v3 || !arg12.changed(arg10)) {
                if((arg13 & 6) == v3) {
                }
                else {
                    v2 = 0;
                }
            }

            Object v13 = arg12.rememberedValue();
            if(v2 != 0 || v13 == Composer.Companion.getEmpty()) {
                TransitionKt$rememberTransition$1$1 v13_1 = new TransitionKt$rememberTransition$1$1(arg10, v0);
                arg12.updateRememberedValue(v13_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
            EffectsKt.LaunchedEffect(v5_2, v11, ((Function2)v13), arg12, 0);
            arg12.endReplaceGroup();
        }
        else {
            arg12.startReplaceGroup(0xAF1B98C0);
            ComposerKt.sourceInformation(arg12, "823@35809L38");
            v6_2.animateTo$animation_core(arg10.getTargetState(), arg12, 0);
            arg12.endReplaceGroup();
        }

        ComposerKt.sourceInformationMarkerStart(arg12, 0xAACF645F, v1_1);
        boolean v10_1 = arg12.changed(v6_2);
        v11 = arg12.rememberedValue();
        if((v10_1) || v11 == Composer.Companion.getEmpty()) {
            TransitionKt$$ExternalSyntheticLambda0 v11_1 = new TransitionKt$$ExternalSyntheticLambda0(v6_2);
            arg12.updateRememberedValue(v11_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        EffectsKt.DisposableEffect(v6_2, ((Function1)v11), arg12, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return v6_2;
    }

    private static final DisposableEffectResult rememberTransition$lambda$2$0(Transition arg0, DisposableEffectScope arg1) {
        return new TransitionKt$rememberTransition$lambda$2$0$$inlined$onDispose$1(arg0);
    }

    public static final Transition updateTransition(Object arg2, String arg3, Composer arg4, int arg5, int arg6) {
        int v1 = 0x78F2A0AD;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(updateTransition)N(targetState,label)88@3890L51,89@3957L22,90@4013L190,90@3984L219:Transition.kt#pdpnli");
        if((arg6 & 2) != 0) {
            arg3 = null;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:87)");
        }

        String v0 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg4, 0x6CD3660, v0);
        Object v6 = arg4.rememberedValue();
        if(v6 == Composer.Companion.getEmpty()) {
            Transition v6_1 = new Transition(arg2, arg3);
            arg4.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        ((Transition)v6).animateTo$animation_core(arg2, arg4, arg5 & 8 | 0x30 | arg5 & 14);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x6CD464B, v0);
        arg2 = arg4.rememberedValue();
        if(arg2 == Composer.Companion.getEmpty()) {
            TransitionKt$$ExternalSyntheticLambda7 v2 = new TransitionKt$$ExternalSyntheticLambda7(((Transition)v6));
            arg4.updateRememberedValue(v2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        EffectsKt.DisposableEffect(v6, ((Function1)arg2), arg4, 54);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((Transition)v6);
    }

    @Deprecated(message="Use rememberTransition() instead", replaceWith="<_subannotation>") public static final Transition updateTransition(MutableTransitionState arg2, String arg3, Composer arg4, int arg5, int arg6) {
        int v1 = 0x34A03233;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(updateTransition)N(transitionState,label)865@37546L32:Transition.kt#pdpnli");
        if((arg6 & 2) != 0) {
            arg3 = null;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:863)");
        }

        Transition v2 = TransitionKt.rememberTransition(((TransitionState)arg2), arg3, arg4, arg5 & 0x7E, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v2;
    }

    private static final DisposableEffectResult updateTransition$lambda$1$0(Transition arg0, DisposableEffectScope arg1) {
        return new TransitionKt$updateTransition$lambda$1$0$$inlined$onDispose$1(arg0);
    }
}

