package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001Ap\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u000726\u0010\b\u001A2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u000E\u001A^\u0010\u000F\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u001026\u0010\b\u001A2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0011\u001A\u0096\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u00142\u0012\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00162\u0006\u0010\u0002\u001A\u0002H\u00122\u0006\u0010\u0004\u001A\u0002H\u00122\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u0001H\u00122\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00120\u000726\u0010\b\u001A2\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\f\u0012\u0013\u0012\u0011H\u0012¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0002\u0010\u0017\u001Aw\u0010\u0018\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192\u0006\u0010\u0004\u001A\u0002H\u00122\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00120\u00072\b\b\u0002\u0010\u001A\u001A\u00020\u001B2%\b\u0002\u0010\b\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D\u0012\u0004\u0012\u00020\u00010\u001C¢\u0006\u0002\b\u001EH\u0086@¢\u0006\u0002\u0010\u001F\u001Am\u0010\u000F\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00120 2\b\b\u0002\u0010\u001A\u001A\u00020\u001B2%\b\u0002\u0010\b\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D\u0012\u0004\u0012\u00020\u00010\u001C¢\u0006\u0002\b\u001EH\u0086@¢\u0006\u0002\u0010!\u001As\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192\u0012\u0010\"\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2\b\b\u0002\u0010$\u001A\u00020%2%\b\u0002\u0010\b\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D\u0012\u0004\u0012\u00020\u00010\u001C¢\u0006\u0002\b\u001EH\u0080@¢\u0006\u0002\u0010&\u001AW\u0010\'\u001A\u0002H(\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010\u0012\"\b\b\u0002\u0010\u0013*\u00020\u0014*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2!\u0010)\u001A\u001D\u0012\u0013\u0012\u00110%¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(*\u0012\u0004\u0012\u0002H(0\u001CH\u0082@¢\u0006\u0002\u0010+\u001A<\u00100\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u0019H\u0000\u001A\u0085\u0001\u00102\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D2\u0006\u0010*\u001A\u00020%2\u0006\u0010,\u001A\u00020\u00032\u0012\u00103\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192#\u0010\b\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D\u0012\u0004\u0012\u00020\u00010\u001C¢\u0006\u0002\b\u001EH\u0002\u001A\u0085\u0001\u00104\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0012\"\b\b\u0001\u0010\u0013*\u00020\u0014*\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D2\u0006\u0010*\u001A\u00020%2\u0006\u00105\u001A\u00020%2\u0012\u00103\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130#2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u00192#\u0010\b\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001D\u0012\u0004\u0012\u00020\u00010\u001C¢\u0006\u0002\b\u001EH\u0002\"\u0018\u0010,\u001A\u00020\u0003*\u00020-8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b.\u0010/¨\u00066"}, d2={"animate", "", "initialValue", "", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "Landroidx/compose/animation/core/AnimationState;", "sequentialAnimation", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "durationScale", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "updateState", "state", "doAnimationFrameWithScale", "anim", "doAnimationFrame", "playTimeNanos", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SuspendAnimationKt {
    public static Unit $r8$lambda$wj4jEldHnQPO7pt5ZRUeFWJ03oc(AnimationState arg0) {
        return SuspendAnimationKt.animate$lambda$3$0(arg0);
    }

    public static final Object access$callWithFrameNanos(Animation arg0, Function1 arg1, Continuation arg2) {
        return SuspendAnimationKt.callWithFrameNanos(arg0, arg1, arg2);
    }

    public static final Object animate(float arg8, float arg9, float arg10, AnimationSpec arg11, Function2 arg12, Continuation arg13) {
        Object v8 = SuspendAnimationKt.animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(arg8), Boxing.boxFloat(arg9), Boxing.boxFloat(arg10), arg11, arg12, arg13);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public static final Object animate(TwoWayConverter arg13, Object arg14, Object arg15, Object arg16, AnimationSpec arg17, Function2 arg18, Continuation arg19) {
        Object v0 = arg16;
        if(v0 != null) {
            v0 = arg13.getConvertToVector().invoke(v0);
            if(v0 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            AnimationVector v0_1 = AnimationVectorsKt.newInstance(arg13.getConvertToVector().invoke(arg14));
        }

        Object v13 = SuspendAnimationKt.animate$default(new AnimationState(arg13, arg14, v0, 0, 0, false, 56, null), new TargetBasedAnimation(arg17, arg13, arg14, arg15, v0), 0, new SuspendAnimationKt$$ExternalSyntheticLambda5(arg18, arg13), arg19, 2, null);
        if(v13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v13;
        }

        return Unit.INSTANCE;
    }

    public static final Object animate(AnimationState arg23, Animation arg24, long arg25, Function1 arg27, Continuation arg28) {
        SuspendAnimationKt$$ExternalSyntheticLambda2 v23;
        Object v27;
        Animation v26;
        Object v28;
        Object v24;
        float v25;
        Function1 v2_1;
        Function1 v6_1;
        AnimationState v4_3;
        ObjectRef v7_1;
        AnimationVector v4_2;
        Function1 v7;
        AnimationState v5;
        float v6;
        Object v4_1;
        Object v3_1;
        Object v2;
        Object v1_3;
        SuspendAnimationKt$animate$4 v1_1;
        Animation v3 = arg24;
        Continuation v0 = arg28;
        if((v0 instanceof SuspendAnimationKt$animate$4)) {
            Continuation v1 = v0;
            int v4 = 0x80000000;
            if((((SuspendAnimationKt$animate$4)v1).label & v4) != 0) {
                ((SuspendAnimationKt$animate$4)v1).label -= v4;
            }
            else {
                goto label_13;
            }
        }
        else {
        label_13:
            v1_1 = new SuspendAnimationKt$animate$4(v0);
        }

        Continuation v8 = ((Continuation)v1_1);
        Object v0_1 = ((SuspendAnimationKt$animate$4)v8).result;
        Object v9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1_2 = ((SuspendAnimationKt$animate$4)v8).label;
        int v10 = 2;
        if(v1_2 != 0) {
            if(v1_2 != 1) {
                if(v1_2 == v10) {
                }
                else {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }

            v1_3 = ((SuspendAnimationKt$animate$4)v8).L$3;
            v2 = ((SuspendAnimationKt$animate$4)v8).L$2;
            v3_1 = ((SuspendAnimationKt$animate$4)v8).L$1;
            v4_1 = ((SuspendAnimationKt$animate$4)v8).L$0;
            try {
                ResultKt.throwOnFailure(v0_1);
                goto label_102;
            }
            catch(CancellationException v0_2) {
                goto label_138;
            }
        }
        else {
            ResultKt.throwOnFailure(v0_1);
            Object v13 = v3.getValueFromNanos(0);
            AnimationVector v15 = v3.getVelocityVectorFromNanos(0);
            ObjectRef v1_4 = new ObjectRef();
            if(arg25 == -9223372036854775808L) {
                try {
                    v6 = SuspendAnimationKt.getDurationScale(v8.getContext());
                    v5 = arg23;
                    v7 = arg27;
                    v2 = v13;
                    v4_2 = v15;
                }
                catch(CancellationException v0_2) {
                    v5 = arg23;
                    goto label_73;
                }

                try {
                    SuspendAnimationKt$$ExternalSyntheticLambda0 v0_3 = new SuspendAnimationKt$$ExternalSyntheticLambda0(v1_4, v2, v3, v4_2, v5, v6, v7);
                    v7_1 = v1_4;
                    goto label_54;
                }
                catch(CancellationException v0_2) {
                }

            label_73:
                v4_3 = v5;
                goto label_138;
                try {
                label_54:
                    ((SuspendAnimationKt$animate$4)v8).L$0 = v5;
                    ((SuspendAnimationKt$animate$4)v8).L$1 = v3;
                    v6_1 = arg27;
                    ((SuspendAnimationKt$animate$4)v8).L$2 = v6_1;
                    ((SuspendAnimationKt$animate$4)v8).L$3 = v7_1;
                    ((SuspendAnimationKt$animate$4)v8).label = 1;
                    if(SuspendAnimationKt.callWithFrameNanos(v3, ((Function1)v0_3), v8) != v9) {
                        goto label_63;
                    }
                }
                catch(CancellationException v0_2) {
                    v4_3 = v5;
                    goto label_137;
                }

                return v9;
            label_63:
                v4_3 = v5;
                v2_1 = v6_1;
            }
            else {
                v5 = arg23;
                v6_1 = arg27;
                v7_1 = v1_4;
                try {
                    AnimationScope v12 = new AnimationScope(v13, v3.getTypeConverter(), v15, arg25, v3.getTargetValue(), arg25, true, new SuspendAnimationKt$$ExternalSyntheticLambda1(v5));
                    SuspendAnimationKt.doAnimationFrameWithScale(v12, arg25, SuspendAnimationKt.getDurationScale(v8.getContext()), v3, v5, v6_1);
                    v7_1.element = v12;
                    v4_3 = arg23;
                    v3 = arg24;
                    v2_1 = arg27;
                    goto label_101;
                }
                catch(CancellationException v0_2) {
                    v4_3 = arg23;
                }

            label_137:
                v1_4 = v7_1;
                goto label_138;
            }

        label_101:
            v1_4 = v7_1;
            try {
                do {
                label_102:
                    v0_1 = ((ObjectRef)v1_3).element;
                    Intrinsics.checkNotNull(v0_1);
                    if(!((AnimationScope)v0_1).isRunning()) {
                        goto label_133;
                    }

                    v25 = SuspendAnimationKt.getDurationScale(v8.getContext());
                    v24 = v1_3;
                    v28 = v2_1;
                    v26 = ((Animation)v3_1);
                    v27 = v4_3;
                    v23 = null;
                    break;
                }
                while(true);
            }
            catch(CancellationException v0_2) {
                goto label_138;
            }

            try {
                super(((ObjectRef)v24), v25, v26, ((AnimationState)v27), ((Function1)v28));
                Function1 v0_4 = ((Function1)v23);
                v1_3 = v24;
                v3 = v26;
                v4_1 = v27;
                v2 = v28;
            }
            catch(CancellationException v0_2) {
                v1_3 = v24;
                v4_1 = v27;
                goto label_138;
            }

            try {
                ((SuspendAnimationKt$animate$4)v8).L$0 = v4_1;
                ((SuspendAnimationKt$animate$4)v8).L$1 = v3;
                ((SuspendAnimationKt$animate$4)v8).L$2 = v2;
                ((SuspendAnimationKt$animate$4)v8).L$3 = v1_3;
                ((SuspendAnimationKt$animate$4)v8).label = v10;
                if(SuspendAnimationKt.callWithFrameNanos(v3, v0_4, v8) != v9) {
                    goto label_102;
                }

                return v9;
            }
            catch(CancellationException v0_2) {
                goto label_138;
            }

        label_133:
            return Unit.INSTANCE;
        }

        return v9;
    label_138:
        v2 = ((ObjectRef)v1_3).element;
        if(v2 != null) {
            ((AnimationScope)v2).setRunning$animation_core(false);
        }

        v1_3 = ((ObjectRef)v1_3).element;
        if(v1_3 != null && ((AnimationScope)v1_3).getLastFrameTimeNanos() == v4_3.getLastFrameTimeNanos()) {
            v4_3.setRunning$animation_core(false);
        }

        throw v0_2;
    }

    public static Object animate$default(AnimationState arg6, Animation arg7, long arg8, Function1 arg10, Continuation arg11, int arg12, Object arg13) {
        SuspendAnimationKt$$ExternalSyntheticLambda8 v10;
        if((arg12 & 2) != 0) {
            arg8 = -9223372036854775808L;
        }

        long v2 = arg8;
        if((arg12 & 4) != 0) {
            v10 = new SuspendAnimationKt$$ExternalSyntheticLambda8();
        }

        return SuspendAnimationKt.animate(arg6, arg7, v2, ((Function1)v10), arg11);
    }

    public static Object animate$default(float arg1, float arg2, float arg3, AnimationSpec arg4, Function2 arg5, Continuation arg6, int arg7, Object arg8) {
        SpringSpec v4;
        if((arg7 & 8) != 0) {
            v4 = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
        }

        return SuspendAnimationKt.animate(arg1, arg2, 0f, ((AnimationSpec)v4), arg5, arg6);
    }

    public static Object animate$default(TwoWayConverter arg1, Object arg2, Object arg3, Object arg4, AnimationSpec arg5, Function2 arg6, Continuation arg7, int arg8, Object arg9) {
        SpringSpec v5;
        Object v0 = null;
        if((arg8 & 8) != 0) {
            arg4 = v0;
        }

        if((arg8 & 16) != 0) {
            v5 = AnimationSpecKt.spring$default(0f, 0f, v0, 7, v0);
        }

        return SuspendAnimationKt.animate(arg1, arg2, arg3, arg4, ((AnimationSpec)v5), arg6, arg7);
    }

    static final Unit animate$lambda$1(Function2 arg1, TwoWayConverter arg2, AnimationScope arg3) {
        arg1.invoke(arg3.getValue(), arg2.getConvertFromVector().invoke(arg3.getVelocityVector()));
        return Unit.INSTANCE;
    }

    static final Unit animate$lambda$2(AnimationScope arg0) {
        return Unit.INSTANCE;
    }

    static final Unit animate$lambda$3(ObjectRef arg12, Object arg13, Animation arg14, AnimationVector arg15, AnimationState arg16, float arg17, Function1 arg18, long arg19) {
        AnimationScope v0 = new AnimationScope(arg13, arg14.getTypeConverter(), arg15, arg19, arg14.getTargetValue(), arg19, true, new SuspendAnimationKt$$ExternalSyntheticLambda4(arg16));
        SuspendAnimationKt.doAnimationFrameWithScale(v0, arg19, arg17, arg14, arg16, arg18);
        arg12.element = v0;
        return Unit.INSTANCE;
    }

    private static final Unit animate$lambda$3$0(AnimationState arg1) {
        arg1.setRunning$animation_core(false);
        return Unit.INSTANCE;
    }

    static final Unit animate$lambda$4(AnimationState arg1) {
        arg1.setRunning$animation_core(false);
        return Unit.INSTANCE;
    }

    static final Unit animate$lambda$6(ObjectRef arg7, float arg8, Animation arg9, AnimationState arg10, Function1 arg11, long arg12) {
        Object v7 = arg7.element;
        Intrinsics.checkNotNull(v7);
        SuspendAnimationKt.doAnimationFrameWithScale(v7, arg12, arg8, arg9, arg10, arg11);
        return Unit.INSTANCE;
    }

    public static final Object animateDecay(float arg18, float arg19, FloatDecayAnimationSpec arg20, Function2 arg21, Continuation arg22) {
        Object v0 = SuspendAnimationKt.animate$default(AnimationStateKt.AnimationState$default(arg18, arg19, 0, 0, false, 28, null), AnimationKt.DecayAnimation(arg20, arg18, arg19), 0, new SuspendAnimationKt$$ExternalSyntheticLambda6(arg21), arg22, 2, null);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }

    public static final Object animateDecay(AnimationState arg10, DecayAnimationSpec arg11, boolean arg12, Function1 arg13, Continuation arg14) {
        DecayAnimation v5 = new DecayAnimation(arg11, arg10.getTypeConverter(), arg10.getValue(), arg10.getVelocityVector());
        long v11 = arg12 ? arg10.getLastFrameTimeNanos() : -9223372036854775808L;
        Object v10 = SuspendAnimationKt.animate(arg10, ((Animation)v5), v11, arg13, arg14);
        if(v10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v10;
        }

        return Unit.INSTANCE;
    }

    public static Object animateDecay$default(AnimationState arg0, DecayAnimationSpec arg1, boolean arg2, Function1 arg3, Continuation arg4, int arg5, Object arg6) {
        SuspendAnimationKt$$ExternalSyntheticLambda3 v3;
        if((arg5 & 4) != 0) {
            v3 = new SuspendAnimationKt$$ExternalSyntheticLambda3();
        }

        return SuspendAnimationKt.animateDecay(arg0, arg1, false, ((Function1)v3), arg4);
    }

    static final Unit animateDecay$lambda$0(Function2 arg1, AnimationScope arg2) {
        arg1.invoke(arg2.getValue(), Float.valueOf(arg2.getVelocityVector().getValue()));
        return Unit.INSTANCE;
    }

    static final Unit animateDecay$lambda$1(AnimationScope arg0) {
        return Unit.INSTANCE;
    }

    public static final Object animateTo(AnimationState arg6, Object arg7, AnimationSpec arg8, boolean arg9, Function1 arg10, Continuation arg11) {
        TargetBasedAnimation v7 = new TargetBasedAnimation(arg8, arg6.getTypeConverter(), arg6.getValue(), arg7, arg6.getVelocityVector());
        long v8 = arg9 ? arg6.getLastFrameTimeNanos() : -9223372036854775808L;
        Object v6 = SuspendAnimationKt.animate(arg6, ((Animation)v7), v8, arg10, arg11);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public static Object animateTo$default(AnimationState arg6, Object arg7, AnimationSpec arg8, boolean arg9, Function1 arg10, Continuation arg11, int arg12, Object arg13) {
        SuspendAnimationKt$$ExternalSyntheticLambda9 v10;
        SpringSpec v8;
        if((arg12 & 2) != 0) {
            v8 = AnimationSpecKt.spring$default(0f, 0f, null, 7, null);
        }

        AnimationSpec v2 = ((AnimationSpec)v8);
        if((arg12 & 8) != 0) {
            v10 = new SuspendAnimationKt$$ExternalSyntheticLambda9();
        }

        return SuspendAnimationKt.animateTo(arg6, arg7, v2, false, ((Function1)v10), arg11);
    }

    static final Unit animateTo$lambda$0(AnimationScope arg0) {
        return Unit.INSTANCE;
    }

    private static final Object callWithFrameNanos(Animation arg0, Function1 arg1, Continuation arg2) {
        if(arg0.isInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(arg1, arg2);
        }

        return MonotonicFrameClockKt.withFrameNanos(new SuspendAnimationKt$$ExternalSyntheticLambda7(arg1), arg2);
    }

    static final Object callWithFrameNanos$lambda$0(Function1 arg0, long arg1) {
        return arg0.invoke(Long.valueOf(arg1));
    }

    private static final void doAnimationFrame(AnimationScope arg0, long arg1, long arg3, Animation arg5, AnimationState arg6, Function1 arg7) {
        arg0.setLastFrameTimeNanos$animation_core(arg1);
        arg0.setValue$animation_core(arg5.getValueFromNanos(arg3));
        arg0.setVelocityVector$animation_core(arg5.getVelocityVectorFromNanos(arg3));
        if(arg5.isFinishedFromNanos(arg3)) {
            arg0.setFinishedTimeNanos$animation_core(arg0.getLastFrameTimeNanos());
            arg0.setRunning$animation_core(false);
        }

        SuspendAnimationKt.updateState(arg0, arg6);
        arg7.invoke(arg0);
    }

    private static final void doAnimationFrameWithScale(AnimationScope arg10, long arg11, float arg13, Animation arg14, AnimationState arg15, Function1 arg16) {
        long v0 = arg13 == 0f ? arg14.getDurationNanos() : ((long)((((float)(arg11 - arg10.getStartTimeNanos()))) / arg13));
        SuspendAnimationKt.doAnimationFrame(arg10, arg11, v0, arg14, arg15, arg16);
    }

    public static final float getDurationScale(CoroutineContext arg1) {
        Element v1 = arg1.get(MotionDurationScale.Key);
        float v1_1 = v1 != null ? ((MotionDurationScale)v1).getScaleFactor() : 1f;
        int v0 = v1_1 >= 0f ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalStateException("negative scale factor");
        }

        return v1_1;
    }

    public static final void updateState(AnimationScope arg2, AnimationState arg3) {
        arg3.setValue$animation_core(arg2.getValue());
        AnimationVectorsKt.copyFrom(arg3.getVelocityVector(), arg2.getVelocityVector());
        arg3.setFinishedTimeNanos$animation_core(arg2.getFinishedTimeNanos());
        arg3.setLastFrameTimeNanos$animation_core(arg2.getLastFrameTimeNanos());
        arg3.setRunning$animation_core(arg2.isRunning());
    }
}

