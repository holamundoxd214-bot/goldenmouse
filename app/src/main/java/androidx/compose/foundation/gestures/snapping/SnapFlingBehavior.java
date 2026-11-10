package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nJ.\u0010\u0011\u001A\u00020\u0006*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00062\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001A0\u0019*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00062\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010\u0017JB\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001A0\u001D*\u00020\u00122\u0006\u0010\u001E\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u00062\u0012\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010!JQ\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001A0\u0019*\u00020\u00122\u0006\u0010#\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u00062!\u0010$\u001A\u001D\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@¢\u0006\u0002\u0010!J\u0018\u0010(\u001A\u00020)2\u0006\u0010\u001E\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u0006H\u0002J\u0013\u0010*\u001A\u00020)2\b\u0010+\u001A\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001A\u00020.H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006/"}, d2={"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "<init>", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation", "(Landroidx/compose/ui/MotionDurationScale;)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingDistanceUpdated", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "onRemainingScrollOffsetUpdate", "tryApproach", "Landroidx/compose/animation/core/AnimationState;", "offset", "velocity", "updateRemainingScrollOffset", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runApproach", "initialTargetOffset", "onAnimationStep", "Lkotlin/ParameterName;", "name", "delta", "isDecayApproachPossible", "", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SnapFlingBehavior implements TargetedFlingBehavior {
    public static final int $stable;
    private final DecayAnimationSpec decayAnimationSpec;
    private MotionDurationScale motionScaleDuration;
    private final AnimationSpec snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;

    static {
    }

    public SnapFlingBehavior(SnapLayoutInfoProvider arg1, DecayAnimationSpec arg2, AnimationSpec arg3) {
        super();
        this.snapLayoutInfoProvider = arg1;
        this.decayAnimationSpec = arg2;
        this.snapAnimationSpec = arg3;
        this.motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    }

    public static final Object access$fling(SnapFlingBehavior arg0, ScrollScope arg1, float arg2, Function1 arg3, Continuation arg4) {
        return arg0.fling(arg1, arg2, arg3, arg4);
    }

    public static final DecayAnimationSpec access$getDecayAnimationSpec$p(SnapFlingBehavior arg0) {
        return arg0.decayAnimationSpec;
    }

    public static final AnimationSpec access$getSnapAnimationSpec$p(SnapFlingBehavior arg0) {
        return arg0.snapAnimationSpec;
    }

    public static final SnapLayoutInfoProvider access$getSnapLayoutInfoProvider$p(SnapFlingBehavior arg0) {
        return arg0.snapLayoutInfoProvider;
    }

    public static final Object access$runApproach(SnapFlingBehavior arg0, ScrollScope arg1, float arg2, float arg3, Function1 arg4, Continuation arg5) {
        return arg0.runApproach(arg1, arg2, arg3, arg4, arg5);
    }

    public static final Object access$tryApproach(SnapFlingBehavior arg0, ScrollScope arg1, float arg2, float arg3, Function1 arg4, Continuation arg5) {
        return arg0.tryApproach(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg4) {
        if(((arg4 instanceof SnapFlingBehavior)) && (Intrinsics.areEqual(((SnapFlingBehavior)arg4).snapAnimationSpec, this.snapAnimationSpec)) && (Intrinsics.areEqual(((SnapFlingBehavior)arg4).decayAnimationSpec, this.decayAnimationSpec)) && (Intrinsics.areEqual(((SnapFlingBehavior)arg4).snapLayoutInfoProvider, this.snapLayoutInfoProvider))) {
            return 1;
        }

        return 0;
    }

    private final Object fling(ScrollScope arg11, float arg12, Function1 arg13, Continuation arg14) {
        Object v13;
        SnapFlingBehavior$fling$1 v0_1;
        int v2;
        if((arg14 instanceof SnapFlingBehavior$fling$1)) {
            Continuation v0 = arg14;
            v2 = 0x80000000;
            if((((SnapFlingBehavior$fling$1)v0).label & v2) != 0) {
                ((SnapFlingBehavior$fling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SnapFlingBehavior$fling$1(this, arg14);
        }

        Object v14 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v14);
            MotionDurationScale v14_1 = this.motionScaleDuration;
            Function1 v7 = arg13;
            SnapFlingBehavior$fling$result$1 v4 = new SnapFlingBehavior$fling$result$1(this, arg12, v7, arg11, null);
            v0_1.L$0 = v7;
            v0_1.label = 1;
            v14 = BuildersKt.withContext(((CoroutineContext)v14_1), ((Function2)v4), ((Continuation)v0_1));
            if(v14 == v1) {
                return v1;
            }
            else {
                arg13 = v7;
            }
        }
        else if(v2 == 1) {
            v13 = v0_1.L$0;
            ResultKt.throwOnFailure(v14);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ((Function1)v13).invoke(Boxing.boxFloat(0f));
        return v14;
    }

    public final MotionDurationScale getMotionScaleDuration$foundation() {
        return this.motionScaleDuration;
    }

    public int hashCode() {
        return (this.snapAnimationSpec.hashCode() * 0x1F + this.decayAnimationSpec.hashCode()) * 0x1F + this.snapLayoutInfoProvider.hashCode();
    }

    private final boolean isDecayApproachPossible(float arg2, float arg3) {
        if(Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.decayAnimationSpec, 0f, arg3)) >= Math.abs(arg2)) {
            return 1;
        }

        return 0;
    }

    public Object performFling(ScrollScope arg5, float arg6, Function1 arg7, Continuation arg8) {
        SnapFlingBehavior$performFling$1 v0_1;
        int v2;
        if((arg8 instanceof SnapFlingBehavior$performFling$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((SnapFlingBehavior$performFling$1)v0).label & v2) != 0) {
                ((SnapFlingBehavior$performFling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SnapFlingBehavior$performFling$1(this, arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            v0_1.label = 1;
            v8 = this.fling(arg5, arg6, arg7, ((Continuation)v0_1));
            if(v8 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v8);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        float v4 = ((AnimationResult)v8).component1().floatValue();
        AnimationState v5 = ((AnimationResult)v8).component2();
        arg6 = 0f;
        if(v4 == 0f) {
        }
        else {
            arg6 = v5.getVelocity().floatValue();
        }

        return Boxing.boxFloat(arg6);
    }

    private final Object runApproach(ScrollScope arg2, float arg3, float arg4, Function1 arg5, Continuation arg6) {
        DecayApproachAnimation v0;
        if(this.isDecayApproachPossible(arg3, arg4)) {
            v0 = new DecayApproachAnimation(this.decayAnimationSpec);
        }
        else {
            TargetApproachAnimation v0_1 = new TargetApproachAnimation(this.snapAnimationSpec);
        }

        return SnapFlingBehaviorKt.access$approach(arg2, arg3, arg4, v0, arg5, arg6);
    }

    public final void setMotionScaleDuration$foundation(MotionDurationScale arg1) {
        this.motionScaleDuration = arg1;
    }

    private final Object tryApproach(ScrollScope arg18, float arg19, float arg20, Function1 arg21, Continuation arg22) {
        SnapFlingBehavior$tryApproach$1 v1_1;
        SnapFlingBehavior v2;
        int v3;
        Continuation v0 = arg22;
        if((v0 instanceof SnapFlingBehavior$tryApproach$1)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((SnapFlingBehavior$tryApproach$1)v1).label & v3) != 0) {
                ((SnapFlingBehavior$tryApproach$1)v1).label -= v3;
                v2 = this;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v2 = this;
            v1_1 = new SnapFlingBehavior$tryApproach$1(v2, v0);
        }

        Continuation v7 = ((Continuation)v1_1);
        Object v0_1 = ((SnapFlingBehavior$tryApproach$1)v7).result;
        Object v1_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = ((SnapFlingBehavior$tryApproach$1)v7).label;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            if(Math.abs(arg19) == 0f) {
            }
            else {
                if(Math.abs(arg20) == 0f) {
                    goto label_36;
                }

                goto label_45;
            }

        label_36:
            return AnimationStateKt.AnimationState$default(arg19, arg20, 0, 0, false, 28, null);
        label_45:
            ((SnapFlingBehavior$tryApproach$1)v7).label = 1;
            v0_1 = v2.runApproach(arg18, arg19, arg20, arg21, v7);
            if(v0_1 != v1_2) {
                goto label_53;
            }

            return v1_2;
        }
        else if(v3 == 1) {
            ResultKt.throwOnFailure(v0_1);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_53:
        return ((AnimationResult)v0_1).getCurrentAnimationState();
    }
}

