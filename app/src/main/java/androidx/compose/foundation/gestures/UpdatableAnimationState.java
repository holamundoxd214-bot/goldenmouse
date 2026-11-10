package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006JJ\u0010\u0014\u001A\u00020\u00152!\u0010\u0016\u001A\u001D\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001A\u0012\u0004\u0012\u00020\u00150\u00172\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00150\u001CH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u001DR\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;)V", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastFrameTime", "", "lastVelocity", "isRunning", "", "value", "getValue", "()F", "setValue", "(F)V", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class UpdatableAnimationState {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001A\u00020\u000B*\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\f"}, d2={"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "<init>", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float arg1) {
            if(Math.abs(arg1) < 0.01f) {
                return 1;
            }

            return 0;
        }
    }

    public static final int $stable = 0;
    private static final Companion Companion = null;
    @Deprecated public static final float VisibilityThreshold = 0.01f;
    private static final AnimationVector1D ZeroVector;
    private boolean isRunning;
    private long lastFrameTime;
    private AnimationVector1D lastVelocity;
    private float value;
    private final VectorizedAnimationSpec vectorizedSpec;

    static {
        UpdatableAnimationState.Companion = new Companion(null);
        UpdatableAnimationState.$stable = 8;
        UpdatableAnimationState.ZeroVector = new AnimationVector1D(0f);
    }

    public UpdatableAnimationState(AnimationSpec arg3) {
        super();
        this.vectorizedSpec = arg3.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
        this.lastFrameTime = -9223372036854775808L;
        this.lastVelocity = UpdatableAnimationState.ZeroVector;
    }

    public static final AnimationVector1D access$getZeroVector$cp() {
        return UpdatableAnimationState.ZeroVector;
    }

    public final Object animateToZero(Function1 arg12, Function0 arg13, Continuation arg14) {
        Object v12;
        float v12_2;
        int v2;
        Continuation v0;
        if((arg14 instanceof UpdatableAnimationState$animateToZero$1)) {
            v0 = arg14;
            v2 = 0x80000000;
            if((((UpdatableAnimationState$animateToZero$1)v0).label & v2) != 0) {
                ((UpdatableAnimationState$animateToZero$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            UpdatableAnimationState$animateToZero$1 v0_1 = new UpdatableAnimationState$animateToZero$1(this, arg14);
        }

        Object v14 = ((UpdatableAnimationState$animateToZero$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((UpdatableAnimationState$animateToZero$1)v0).label;
        long v5 = -9223372036854775808L;
        int v7 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v14);
            if(this.isRunning) {
                InlineClassHelperKt.throwIllegalStateException("animateToZero called while previous animation is running");
            }

            Element v14_1 = v0.getContext().get(MotionDurationScale.Key);
            float v14_2 = v14_1 != null ? ((MotionDurationScale)v14_1).getScaleFactor() : 1f;
            this.isRunning = true;
            Function0 v10 = arg13;
            Function1 v13_1 = arg12;
            v12_2 = v14_2;
            Function0 v14_3 = v10;
            goto label_57;
            try {
            label_86:
                ((Function0)v12).invoke();
            }
            catch(Throwable v12_1) {
                goto label_93;
            }

        label_87:
            this.lastFrameTime = v5;
            this.lastVelocity = UpdatableAnimationState.ZeroVector;
            this.isRunning = false;
            return Unit.INSTANCE;
            try {
            label_70:
                v14_3.invoke();
                if(v12_2 == 0f) {
                label_72:
                    v12 = v14_3;
                    if(Math.abs(this.value) == 0f) {
                        goto label_87;
                    }

                    UpdatableAnimationState$$ExternalSyntheticLambda1 v14_4 = new UpdatableAnimationState$$ExternalSyntheticLambda1(this, v13_1);
                    ((UpdatableAnimationState$animateToZero$1)v0).L$0 = v12;
                    ((UpdatableAnimationState$animateToZero$1)v0).L$1 = null;
                    ((UpdatableAnimationState$animateToZero$1)v0).label = v7;
                    if(MonotonicFrameClockKt.withFrameNanos(((Function1)v14_4), v0) != v1) {
                        goto label_86;
                    }

                    return v1;
                }

            label_57:
                if(UpdatableAnimationState.Companion.isZeroish(this.value)) {
                    goto label_72;
                }

                UpdatableAnimationState$$ExternalSyntheticLambda0 v2_2 = new UpdatableAnimationState$$ExternalSyntheticLambda0(this, v12_2, v13_1);
                ((UpdatableAnimationState$animateToZero$1)v0).L$0 = v13_1;
                ((UpdatableAnimationState$animateToZero$1)v0).L$1 = v14_3;
                ((UpdatableAnimationState$animateToZero$1)v0).F$0 = v12_2;
                ((UpdatableAnimationState$animateToZero$1)v0).label = 1;
                if(MonotonicFrameClockKt.withFrameNanos(((Function1)v2_2), v0) != v1) {
                    goto label_70;
                }

                return v1;
            }
            catch(Throwable v12_1) {
            label_93:
                this.lastFrameTime = v5;
                this.lastVelocity = UpdatableAnimationState.ZeroVector;
                this.isRunning = false;
                throw v12_1;
            }
        }
        else if(v2 == 1) {
            v12_2 = ((UpdatableAnimationState$animateToZero$1)v0).F$0;
            Object v13 = ((UpdatableAnimationState$animateToZero$1)v0).L$1;
            Object v2_1 = ((UpdatableAnimationState$animateToZero$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v14);
                v14 = v13;
                v13 = v2_1;
                goto label_70;
            }
            catch(Throwable v12_1) {
                goto label_93;
            }
        }
        else if(v2 == v7) {
            v12 = ((UpdatableAnimationState$animateToZero$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v14);
                goto label_86;
            }
            catch(Throwable v12_1) {
                goto label_93;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        goto label_57;
    }

    static final Unit animateToZero$lambda$1(UpdatableAnimationState arg9, float arg10, Function1 arg11, long arg12) {
        if(arg9.lastFrameTime == -9223372036854775808L) {
            arg9.lastFrameTime = arg12;
        }

        AnimationVector1D v0 = new AnimationVector1D(arg9.value);
        long v1 = arg10 == 0f ? arg9.vectorizedSpec.getDurationNanos(new AnimationVector1D(arg9.value), UpdatableAnimationState.ZeroVector, arg9.lastVelocity) : MathKt.roundToLong((((float)(arg12 - arg9.lastFrameTime))) / arg10);
        VectorizedAnimationSpec v3 = arg9.vectorizedSpec;
        AnimationVector1D v6 = v0;
        AnimationVector1D v10 = UpdatableAnimationState.ZeroVector;
        float v0_1 = v3.getValueFromNanos(v1, ((AnimationVector)v6), v10, arg9.lastVelocity).getValue();
        arg9.lastVelocity = arg9.vectorizedSpec.getVelocityFromNanos(v1, ((AnimationVector)v6), v10, arg9.lastVelocity);
        arg9.lastFrameTime = arg12;
        arg10 = arg9.value - v0_1;
        arg9.value = v0_1;
        arg11.invoke(Float.valueOf(arg10));
        return Unit.INSTANCE;
    }

    static final Unit animateToZero$lambda$2(UpdatableAnimationState arg0, Function1 arg1, long arg2) {
        float v2 = arg0.value;
        arg0.value = 0f;
        arg1.invoke(Float.valueOf(v2));
        return Unit.INSTANCE;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float arg1) {
        this.value = arg1;
    }
}

