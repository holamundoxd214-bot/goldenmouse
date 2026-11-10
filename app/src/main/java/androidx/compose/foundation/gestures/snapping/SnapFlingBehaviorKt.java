package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\u001A*\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\b\u001A\u0015\u0010\t\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001Ae\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u00062\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u00122!\u0010\u0013\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010\u0019\u001A(\u0010\u001A\u001A\u0002H\u001B\"\u000E\b\u0000\u0010\u001B*\b\u0012\u0004\u0012\u0002H\u001B0\u001C*\b\u0012\u0004\u0012\u0002H\u001B0\u001DH\u0082\u0002¢\u0006\u0002\u0010\u001E\u001A(\u0010\u001F\u001A\u0002H\u001B\"\u000E\b\u0000\u0010\u001B*\b\u0012\u0004\u0012\u0002H\u001B0\u001C*\b\u0012\u0004\u0012\u0002H\u001B0\u001DH\u0082\u0002¢\u0006\u0002\u0010\u001E\u001Ak\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000E2\u0006\u0010!\u001A\u00020\u00062\u0012\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0#2\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052!\u0010\u0013\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010$\u001As\u0010%\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000E2\u0006\u0010!\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\u00062\u0012\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0#2\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00060\b2!\u0010\u0013\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010(\u001A\u0014\u0010)\u001A\u00020\u0006*\u00020\u00062\u0006\u0010*\u001A\u00020\u0006H\u0002\u001A\'\u00102\u001A\u00020\u00062\u0006\u00103\u001A\u0002042\u0006\u00105\u001A\u00020\u00062\u0006\u00106\u001A\u00020\u0006H\u0000¢\u0006\u0004\b7\u00108\u001A\u0017\u0010;\u001A\u00020\u00182\f\u0010<\u001A\b\u0012\u0004\u0012\u00020>0=H\u0082\b\"\u0016\u0010+\u001A\u00020,X\u0080\u0004¢\u0006\n\n\u0002\u0010/\u001A\u0004\b-\u0010.\"\u000E\u00100\u001A\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u00101\u001A\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u00109\u001A\u00020:X\u0082T¢\u0006\u0002\n\u0000¨\u0006?"}, d2={"snapFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "rememberSnapFlingBehavior", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "approach", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialTargetOffset", "initialVelocity", "animation", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "animateDecay", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateWithTarget", "cancelOffset", "animationSpec", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", "F", "NoDistance", "NoVelocity", "calculateFinalOffset", "snappingOffset", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "lowerBound", "upperBound", "calculateFinalOffset-Fhqu1e0", "(IFF)F", "DEBUG", "", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SnapFlingBehaviorKt {
    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp;
    public static final float NoDistance;
    public static final float NoVelocity;

    static {
        SnapFlingBehaviorKt.MinFlingVelocityDp = Dp.constructor-impl(400f);
    }

    public static final Object access$animateDecay(ScrollScope arg0, float arg1, AnimationState arg2, DecayAnimationSpec arg3, Function1 arg4, Continuation arg5) {
        return SnapFlingBehaviorKt.animateDecay(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Object access$animateWithTarget(ScrollScope arg0, float arg1, float arg2, AnimationState arg3, AnimationSpec arg4, Function1 arg5, Continuation arg6) {
        return SnapFlingBehaviorKt.animateWithTarget(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final Object access$approach(ScrollScope arg0, float arg1, float arg2, ApproachAnimation arg3, Function1 arg4, Continuation arg5) {
        return SnapFlingBehaviorKt.approach(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    private static final Object animateDecay(ScrollScope arg5, float arg6, AnimationState arg7, DecayAnimationSpec arg8, Function1 arg9, Continuation arg10) {
        Object v7;
        Object v5;
        SnapFlingBehaviorKt$animateDecay$1 v0_1;
        int v2;
        if((arg10 instanceof SnapFlingBehaviorKt$animateDecay$1)) {
            Continuation v0 = arg10;
            v2 = 0x80000000;
            if((((SnapFlingBehaviorKt$animateDecay$1)v0).label & v2) != 0) {
                ((SnapFlingBehaviorKt$animateDecay$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SnapFlingBehaviorKt$animateDecay$1(arg10);
        }

        Object v10 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            FloatRef v10_1 = new FloatRef();
            v2 = arg7.getVelocity().floatValue() == 0f ? 1 : 0;
            SnapFlingBehaviorKt$$ExternalSyntheticLambda0 v4 = new SnapFlingBehaviorKt$$ExternalSyntheticLambda0(arg6, v10_1, arg5, arg9);
            v0_1.L$0 = arg7;
            v0_1.L$1 = v10_1;
            v0_1.F$0 = arg6;
            v0_1.label = 1;
            if(SuspendAnimationKt.animateDecay(arg7, arg8, v2 ^ 1, ((Function1)v4), ((Continuation)v0_1)) == v1) {
                return v1;
            }

            FloatRef v5_1 = v10_1;
        }
        else if(v2 == 1) {
            arg6 = v0_1.F$0;
            v5 = v0_1.L$1;
            v7 = v0_1.L$0;
            ResultKt.throwOnFailure(v10);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return new AnimationResult(Boxing.boxFloat(arg6 - ((FloatRef)v5).element), ((AnimationState)v7));
    }

    private static final void animateDecay$consumeDelta(AnimationScope arg1, ScrollScope arg2, Function1 arg3, float arg4) {
        float v2;
        try {
            v2 = arg2.scrollBy(arg4);
        }
        catch(CancellationException ) {
            arg1.cancelAnimation();
            v2 = 0f;
        }

        arg3.invoke(Float.valueOf(v2));
        if(Math.abs(arg4 - v2) > 0.5f) {
            arg1.cancelAnimation();
        }
    }

    static final Unit animateDecay$lambda$0(float arg2, FloatRef arg3, ScrollScope arg4, Function1 arg5, AnimationScope arg6) {
        if(Math.abs(arg6.getValue().floatValue()) >= Math.abs(arg2)) {
            arg2 = SnapFlingBehaviorKt.coerceToTarget(arg6.getValue().floatValue(), arg2);
            SnapFlingBehaviorKt.animateDecay$consumeDelta(arg6, arg4, arg5, arg2 - arg3.element);
            arg6.cancelAnimation();
            arg3.element = arg2;
        }
        else {
            SnapFlingBehaviorKt.animateDecay$consumeDelta(arg6, arg4, arg5, arg6.getValue().floatValue() - arg3.element);
            arg3.element = arg6.getValue().floatValue();
        }

        return Unit.INSTANCE;
    }

    private static final Object animateWithTarget(ScrollScope arg20, float arg21, float arg22, AnimationState arg23, AnimationSpec arg24, Function1 arg25, Continuation arg26) {
        Object v10;
        float v9;
        Object v3_1;
        float v1_3;
        Continuation v1;
        Continuation v0 = arg26;
        if((v0 instanceof SnapFlingBehaviorKt$animateWithTarget$1)) {
            v1 = v0;
            int v3 = 0x80000000;
            if((((SnapFlingBehaviorKt$animateWithTarget$1)v1).label & v3) != 0) {
                ((SnapFlingBehaviorKt$animateWithTarget$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            SnapFlingBehaviorKt$animateWithTarget$1 v1_1 = new SnapFlingBehaviorKt$animateWithTarget$1(v0);
        }

        Continuation v7 = v1;
        Object v0_1 = ((SnapFlingBehaviorKt$animateWithTarget$1)v7).result;
        Object v1_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2 = ((SnapFlingBehaviorKt$animateWithTarget$1)v7).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_1);
            FloatRef v0_2 = new FloatRef();
            float v8 = arg23.getVelocity().floatValue();
            Float v2_2 = Boxing.boxFloat(arg21);
            int v4_1 = arg23.getVelocity().floatValue() == 0f ? 1 : 0;
            SnapFlingBehaviorKt$$ExternalSyntheticLambda1 v6 = new SnapFlingBehaviorKt$$ExternalSyntheticLambda1(arg22, v0_2, arg20, arg25);
            ((SnapFlingBehaviorKt$animateWithTarget$1)v7).L$0 = arg23;
            ((SnapFlingBehaviorKt$animateWithTarget$1)v7).L$1 = v0_2;
            v9 = arg21;
            ((SnapFlingBehaviorKt$animateWithTarget$1)v7).F$0 = v9;
            ((SnapFlingBehaviorKt$animateWithTarget$1)v7).F$1 = v8;
            ((SnapFlingBehaviorKt$animateWithTarget$1)v7).label = 1;
            if(SuspendAnimationKt.animateTo(arg23, v2_2, arg24, v4_1 ^ 1, ((Function1)v6), v7) == v1_2) {
                return v1_2;
            }

            AnimationState v10_1 = arg23;
            FloatRef v3_2 = v0_2;
            v1_3 = v8;
        }
        else if(v2 == 1) {
            v1_3 = ((SnapFlingBehaviorKt$animateWithTarget$1)v7).F$1;
            float v2_1 = ((SnapFlingBehaviorKt$animateWithTarget$1)v7).F$0;
            v3_1 = ((SnapFlingBehaviorKt$animateWithTarget$1)v7).L$1;
            Object v4 = ((SnapFlingBehaviorKt$animateWithTarget$1)v7).L$0;
            ResultKt.throwOnFailure(v0_1);
            v9 = v2_1;
            v10 = v4;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return new AnimationResult(Boxing.boxFloat(v9 - ((FloatRef)v3_1).element), AnimationStateKt.copy$default(((AnimationState)v10), 0f, SnapFlingBehaviorKt.coerceToTarget(((AnimationState)v10).getVelocity().floatValue(), v1_3), 0, 0, false, 29, null));
    }

    static final Unit animateWithTarget$lambda$0(float arg2, FloatRef arg3, ScrollScope arg4, Function1 arg5, AnimationScope arg6) {
        float v4;
        arg2 = SnapFlingBehaviorKt.coerceToTarget(arg6.getValue().floatValue(), arg2);
        float v0 = arg2 - arg3.element;
        try {
            v4 = arg4.scrollBy(v0);
        }
        catch(CancellationException ) {
            arg6.cancelAnimation();
            v4 = 0f;
        }

        arg5.invoke(Float.valueOf(v4));
        if(Math.abs(v0 - v4) > 0.5f || arg2 != arg6.getValue().floatValue()) {
            arg6.cancelAnimation();
        }
        else {
        }

        arg3.element += v4;
        return Unit.INSTANCE;
    }

    private static final Object approach(ScrollScope arg1, float arg2, float arg3, ApproachAnimation arg4, Function1 arg5, Continuation arg6) {
        return arg4.approachAnimation(arg1, Boxing.boxFloat(arg2), Boxing.boxFloat(arg3), arg5, arg6);
    }

    public static final float calculateFinalOffset-Fhqu1e0(int arg2, float arg3, float arg4) {
        if(FinalSnappingItem.equals-impl0(arg2, FinalSnappingItem.Companion.getClosestItem-bbeMdSM())) {
            if(Math.abs(arg4) <= Math.abs(arg3)) {
                goto label_13;
            }
        }
        else if(FinalSnappingItem.equals-impl0(arg2, FinalSnappingItem.Companion.getNextItem-bbeMdSM())) {
        label_13:
            arg3 = arg4;
        }
        else if(FinalSnappingItem.equals-impl0(arg2, FinalSnappingItem.Companion.getPreviousItem-bbeMdSM())) {
        }
        else {
            arg3 = 0f;
        }

        if(SnapFlingBehaviorKt.calculateFinalOffset_Fhqu1e0$isValidDistance(arg3)) {
            return arg3;
        }

        return 0;
    }

    private static final boolean calculateFinalOffset_Fhqu1e0$isValidDistance(float arg1) {
        if(arg1 == Infinityf) {
        }
        else {
            if(arg1 == -Infinityf) {
                return 0;
            }

            return 1;
        }

        return 0;
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

    private static final Comparable component1(ClosedFloatingPointRange arg0) {
        return arg0.getStart();
    }

    private static final Comparable component2(ClosedFloatingPointRange arg0) {
        return arg0.getEndInclusive();
    }

    private static final void debugLog(Function0 arg0) {
    }

    public static final float getMinFlingVelocityDp() {
        return SnapFlingBehaviorKt.MinFlingVelocityDp;
    }

    public static final TargetedFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider arg5, Composer arg6, int arg7) {
        int v1 = 0x8D74ADF2;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(rememberSnapFlingBehavior)N(snapLayoutInfoProvider)231@10249L7,232@10319L26,233@10357L311:SnapFlingBehavior.kt#ppz6w6");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:230)");
        }

        ProvidableCompositionLocal v0 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_1 = arg6.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg6);
        v1 = 0;
        DecayAnimationSpec v2 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(arg6, 0);
        ComposerKt.sourceInformationMarkerStart(arg6, 50403753, "CC(remember):SnapFlingBehavior.kt#9igjgp");
        int v4 = 4;
        if((arg7 & 14 ^ 6) > v4 && (arg6.changed(arg5)) || (arg7 & 6) == v4) {
            v1 = 1;
        }

        arg7 = arg6.changed(v2) | v1 | arg6.changed(v0_1);
        v0_1 = arg6.rememberedValue();
        if(arg7 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            TargetedFlingBehavior v0_2 = SnapFlingBehaviorKt.snapFlingBehavior(arg5, v2, AnimationSpecKt.spring$default(0f, 400f, null, 5, null));
            arg6.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return ((TargetedFlingBehavior)v0_1);
    }

    public static final TargetedFlingBehavior snapFlingBehavior(SnapLayoutInfoProvider arg1, DecayAnimationSpec arg2, AnimationSpec arg3) {
        return new SnapFlingBehavior(arg1, arg2, arg3);
    }
}

