package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AS\u0010\u0000\u001A\u00020\u00012K\u0010\u0002\u001AG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0003\u001AZ\u0010\f\u001A\u00020\u00012K\u0010\u0002\u001AG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0003H\u0007¢\u0006\u0002\u0010\r\u001A*\u0010\u000E\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00042\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001A*\u0010\u0013\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u00042\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0002\u0010\u0012\u001A,\u0010\u0015\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\u0016\u001A\u00020\b2\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\b0\u0011H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001A\\\u0010\u0019\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u00042\u000E\b\u0002\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00040\u00112\u000E\b\u0002\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\b0\u00112\u000E\b\u0002\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0086@¢\u0006\u0004\b\u001F\u0010 \u001A\u001A\u0010#\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0004H\u0086@¢\u0006\u0002\u0010$\u001A\u001A\u0010%\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u0004H\u0086@¢\u0006\u0002\u0010$\u001A\u001C\u0010&\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\u0016\u001A\u00020\bH\u0086@¢\u0006\u0004\b\'\u0010(\u001A\u001C\u0010)\u001A\u00020\u000B*\u00020\u00012\b\b\u0002\u0010*\u001A\u00020+H\u0086@¢\u0006\u0002\u0010,\"\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animateZoomBy", "zoomFactor", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "animatePanBy", "offset", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBy", "panOffset", "rotationDegrees", "zoomAnimationSpec", "panAnimationSpec", "rotationAnimationSpec", "animateBy-Su4bsnU", "(Landroidx/compose/foundation/gestures/TransformableState;FJFLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ZeroAnimationVelocity", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TransformableStateKt {
    private static final AnimationData ZeroAnimationVelocity;

    public static Unit $r8$lambda$DNKa2H-wMXURQH9SE3HU_IL4kj0(State arg0, float arg1, Offset arg2, float arg3) {
        return TransformableStateKt.rememberTransformableState$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    static {
        TransformableStateKt.ZeroAnimationVelocity = new AnimationData(0f, Offset.Companion.getZero-F1C5BW0(), 0f, null);
    }

    public static final TransformableState TransformableState(Function3 arg1) {
        return new DefaultTransformableState(arg1);
    }

    public static final AnimationData access$getZeroAnimationVelocity$p() {
        return TransformableStateKt.ZeroAnimationVelocity;
    }

    public static final Object animateBy-Su4bsnU(TransformableState arg8, float arg9, long arg10, float arg12, AnimationSpec arg13, AnimationSpec arg14, AnimationSpec arg15, Continuation arg16) {
        int v0 = arg9 > 0f ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }

        ObjectRef v0_1 = new ObjectRef();
        v0_1.element = new AnimationData(1f, Offset.Companion.getZero-F1C5BW0(), 0f, null);
        Object v0_2 = TransformableState.transform$default(arg8, null, new TransformableStateKt$animateBy$3(v0_1, new AnimationData(arg9, arg10, arg12, null), new DelegatingAnimationSpec(arg13, arg14, arg15), null), arg16, 1, null);
        if(v0_2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0_2;
        }

        return Unit.INSTANCE;
    }

    public static Object animateBy-Su4bsnU$default(TransformableState arg14, float arg15, long arg16, float arg18, AnimationSpec arg19, AnimationSpec arg20, AnimationSpec arg21, Continuation arg22, int arg23, Object arg24) {
        SpringSpec v8;
        SpringSpec v7;
        AnimationSpec v6_1;
        if((arg23 & 8) != 0) {
            SpringSpec v6 = new SpringSpec(0f, 200f, null, 5, null);
        }
        else {
            v6_1 = arg19;
        }

        if((arg23 & 16) != 0) {
            v7 = new SpringSpec(0f, 200f, null, 5, null);
        }
        else {
            AnimationSpec v7_1 = arg20;
        }

        if((arg23 & 0x20) != 0) {
            v8 = new SpringSpec(0f, 200f, null, 5, null);
        }
        else {
            AnimationSpec v8_1 = arg21;
        }

        return TransformableStateKt.animateBy-Su4bsnU(arg14, arg15, arg16, arg18, v6_1, ((AnimationSpec)v7), ((AnimationSpec)v8), arg22);
    }

    public static final Object animatePanBy-ubNVwUQ(TransformableState arg7, long arg8, AnimationSpec arg10, Continuation arg11) {
        LongRef v1 = new LongRef();
        v1.element = Offset.Companion.getZero-F1C5BW0();
        Object v7 = TransformableState.transform$default(arg7, null, new TransformableStateKt$animatePanBy$2(v1, arg8, arg10, null), arg11, 1, null);
        if(v7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v7;
        }

        return Unit.INSTANCE;
    }

    public static Object animatePanBy-ubNVwUQ$default(TransformableState arg6, long arg7, AnimationSpec arg9, Continuation arg10, int arg11, Object arg12) {
        SpringSpec v9;
        if((arg11 & 2) != 0) {
            v9 = new SpringSpec(0f, 200f, null, 5, null);
        }

        return TransformableStateKt.animatePanBy-ubNVwUQ(arg6, arg7, ((AnimationSpec)v9), arg10);
    }

    public static final Object animateRotateBy(TransformableState arg9, float arg10, AnimationSpec arg11, Continuation arg12) {
        Object v9 = TransformableState.transform$default(arg9, null, new TransformableStateKt$animateRotateBy$2(new FloatRef(), arg10, arg11, null), arg12, 1, null);
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v9;
        }

        return Unit.INSTANCE;
    }

    public static Object animateRotateBy$default(TransformableState arg6, float arg7, AnimationSpec arg8, Continuation arg9, int arg10, Object arg11) {
        SpringSpec v8;
        if((arg10 & 2) != 0) {
            v8 = new SpringSpec(0f, 200f, null, 5, null);
        }

        return TransformableStateKt.animateRotateBy(arg6, arg7, ((AnimationSpec)v8), arg9);
    }

    public static final Object animateZoomBy(TransformableState arg9, float arg10, AnimationSpec arg11, Continuation arg12) {
        int v0 = arg10 > 0f ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }

        FloatRef v0_1 = new FloatRef();
        v0_1.element = 1f;
        Object v9 = TransformableState.transform$default(arg9, null, new TransformableStateKt$animateZoomBy$3(v0_1, arg10, arg11, null), arg12, 1, null);
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v9;
        }

        return Unit.INSTANCE;
    }

    public static Object animateZoomBy$default(TransformableState arg6, float arg7, AnimationSpec arg8, Continuation arg9, int arg10, Object arg11) {
        SpringSpec v8;
        if((arg10 & 2) != 0) {
            v8 = new SpringSpec(0f, 200f, null, 5, null);
        }

        return TransformableStateKt.animateZoomBy(arg6, arg7, ((AnimationSpec)v8), arg9);
    }

    public static final Object panBy-d-4ec7I(TransformableState arg8, long arg9, Continuation arg11) {
        Object v8 = TransformableState.transform$default(arg8, null, new TransformableStateKt$panBy$2(arg9, null), arg11, 1, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public static final TransformableState rememberTransformableState(Function3 arg3, Composer arg4, int arg5) {
        int v1 = 0x64386C11;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberTransformableState)N(onTransformation)123@5674L38,124@5724L80:TransformableState.kt#8bwon0");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:122)");
        }

        State v3 = SnapshotStateKt.rememberUpdatedState(arg3, arg4, arg5 & 14);
        ComposerKt.sourceInformationMarkerStart(arg4, 0x37CDC7A1, "CC(remember):TransformableState.kt#9igjgp");
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            TransformableState v5_1 = TransformableStateKt.TransformableState(new TransformableStateKt$$ExternalSyntheticLambda0(v3));
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((TransformableState)v5);
    }

    private static final Unit rememberTransformableState$lambda$0$0(State arg0, float arg1, Offset arg2, float arg3) {
        arg0.getValue().invoke(Float.valueOf(arg1), arg2, Float.valueOf(arg3));
        return Unit.INSTANCE;
    }

    public static final Object rotateBy(TransformableState arg8, float arg9, Continuation arg10) {
        Object v8 = TransformableState.transform$default(arg8, null, new TransformableStateKt$rotateBy$2(arg9, null), arg10, 1, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }

    public static final Object stopTransformation(TransformableState arg2, MutatePriority arg3, Continuation arg4) {
        Object v2 = arg2.transform(arg3, new TransformableStateKt$stopTransformation$2(null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public static Object stopTransformation$default(TransformableState arg0, MutatePriority arg1, Continuation arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = MutatePriority.Default;
        }

        return TransformableStateKt.stopTransformation(arg0, arg1, arg2);
    }

    public static final Object zoomBy(TransformableState arg8, float arg9, Continuation arg10) {
        Object v8 = TransformableState.transform$default(arg8, null, new TransformableStateKt$zoomBy$2(arg9, null), arg10, 1, null);
        if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v8;
        }

        return Unit.INSTANCE;
    }
}

