package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B;\b\u0007\u0012\u0006\u0010\u0005\u001A\u00028\u0000\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fB1\b\u0017\u0012\u0006\u0010\u0005\u001A\u00028\u0000\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000B\u0010\rJ#\u0010>\u001A\u00020?2\n\b\u0002\u0010,\u001A\u0004\u0018\u00018\u00002\n\b\u0002\u0010.\u001A\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010@Je\u0010A\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0006\u0010\'\u001A\u00028\u00002\u000E\b\u0002\u0010C\u001A\b\u0012\u0004\u0012\u00028\u00000D2\b\b\u0002\u0010E\u001A\u00028\u00002\'\b\u0002\u0010F\u001A!\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0086@¢\u0006\u0002\u0010IJY\u0010J\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0006\u0010E\u001A\u00028\u00002\f\u0010C\u001A\b\u0012\u0004\u0012\u00028\u00000K2\'\b\u0002\u0010F\u001A!\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0086@¢\u0006\u0002\u0010LJ]\u0010M\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0012\u0010N\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O2\u0006\u0010E\u001A\u00028\u00002%\u0010F\u001A!\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0082@¢\u0006\u0002\u0010PJ\u0015\u0010Q\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010RJ\b\u0010S\u001A\u00020?H\u0002J\u0016\u0010T\u001A\u00020?2\u0006\u0010\'\u001A\u00028\u0000H\u0086@¢\u0006\u0002\u0010UJ\u000E\u0010V\u001A\u00020?H\u0086@¢\u0006\u0002\u0010WJ\f\u0010X\u001A\b\u0012\u0004\u0012\u00028\u00000YR\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\b\u001A\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00028\u00018F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0011\u0010\u001D\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0019R+\u0010!\u001A\u00020 2\u0006\u0010\u001F\u001A\u00020 8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010\'\u001A\u00028\u00002\u0006\u0010\u001F\u001A\u00028\u00008F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b+\u0010&\u001A\u0004\b(\u0010\u0019\"\u0004\b)\u0010*R$\u0010,\u001A\u0004\u0018\u00018\u00002\b\u0010\u0017\u001A\u0004\u0018\u00018\u0000@BX\u0086\u000E¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b-\u0010\u0019R$\u0010.\u001A\u0004\u0018\u00018\u00002\b\u0010\u0017\u001A\u0004\u0018\u00018\u0000@BX\u0086\u000E¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b/\u0010\u0019R\u000E\u00100\u001A\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u00102\u001A\b\u0012\u0004\u0012\u00028\u000003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b4\u00105R\u0016\u00106\u001A\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u00109\u0012\u0004\b7\u00108R\u0016\u0010:\u001A\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u00109\u0012\u0004\b;\u00108R\u0010\u0010<\u001A\u00028\u0001X\u0082\u000E¢\u0006\u0004\n\u0002\u00109R\u0010\u0010=\u001A\u00028\u0001X\u0082\u000E¢\u0006\u0004\n\u0002\u00109¨\u0006Z"}, d2={"Landroidx/compose/animation/core/Animatable;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThreshold", "label", "", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/Object;", "getLabel", "()Ljava/lang/String;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core", "()Landroidx/compose/animation/core/AnimationState;", "value", "getValue", "()Ljava/lang/Object;", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "velocity", "getVelocity", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "targetValue", "getTargetValue", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "lowerBound", "getLowerBound", "upperBound", "getUpperBound", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core", "()Landroidx/compose/animation/core/SpringSpec;", "negativeInfinityBounds", "getNegativeInfinityBounds$annotations", "()V", "Landroidx/compose/animation/core/AnimationVector;", "positiveInfinityBounds", "getPositiveInfinityBounds$annotations", "lowerBoundVector", "upperBoundVector", "updateBounds", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "animateTo", "Landroidx/compose/animation/core/AnimationResult;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "initialVelocity", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runAnimation", "animation", "Landroidx/compose/animation/core/Animation;", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Animatable {
    public static final int $stable = 8;
    private final SpringSpec defaultSpringSpec;
    private final AnimationState internalState;
    private final MutableState isRunning$delegate;
    private final String label;
    private Object lowerBound;
    private AnimationVector lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final AnimationVector negativeInfinityBounds;
    private final AnimationVector positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final TwoWayConverter typeConverter;
    private Object upperBound;
    private AnimationVector upperBoundVector;
    private final Object visibilityThreshold;

    static {
    }

    public Animatable(Object arg1, TwoWayConverter arg2, Object arg3, String arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        if((arg5 & 8) != 0) {
            arg4 = "Animatable";
        }

        this(arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility", replaceWith="<_subannotation>") public Animatable(Object arg2, TwoWayConverter arg3, Object arg4) {
        this(arg2, arg3, arg4, "Animatable");
    }

    public Animatable(Object arg12, TwoWayConverter arg13, Object arg14, String arg15) {
        AnimationVector3D v14_3;
        AnimationVector2D v12_2;
        super();
        this.typeConverter = arg13;
        this.visibilityThreshold = arg14;
        this.label = arg15;
        this.internalState = new AnimationState(arg13, arg12, null, 0, 0, false, 60, null);
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(arg12, null, 2, null);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(0f, 0f, arg14, 3, null);
        AnimationVector v12 = this.getVelocityVector();
        if((v12 instanceof AnimationVector1D)) {
            AnimationVector1D v12_1 = AnimatableKt.access$getNegativeInfinityBounds1D$p();
        }
        else if((v12 instanceof AnimationVector2D)) {
            v12_2 = AnimatableKt.access$getNegativeInfinityBounds2D$p();
        }
        else if((v12 instanceof AnimationVector3D)) {
            AnimationVector3D v12_3 = AnimatableKt.access$getNegativeInfinityBounds3D$p();
        }
        else {
            AnimationVector4D v12_4 = AnimatableKt.access$getNegativeInfinityBounds4D$p();
        }

        String v13 = "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable";
        Intrinsics.checkNotNull(v12_2, v13);
        this.negativeInfinityBounds = ((AnimationVector)v12_2);
        AnimationVector v14 = this.getVelocityVector();
        if((v14 instanceof AnimationVector1D)) {
            AnimationVector1D v14_1 = AnimatableKt.access$getPositiveInfinityBounds1D$p();
        }
        else if((v14 instanceof AnimationVector2D)) {
            AnimationVector2D v14_2 = AnimatableKt.access$getPositiveInfinityBounds2D$p();
        }
        else if((v14 instanceof AnimationVector3D)) {
            v14_3 = AnimatableKt.access$getPositiveInfinityBounds3D$p();
        }
        else {
            AnimationVector4D v14_4 = AnimatableKt.access$getPositiveInfinityBounds4D$p();
        }

        Intrinsics.checkNotNull(v14_3, v13);
        this.positiveInfinityBounds = ((AnimationVector)v14_3);
        this.lowerBoundVector = ((AnimationVector)v12_2);
        this.upperBoundVector = ((AnimationVector)v14_3);
    }

    public Animatable(Object arg1, TwoWayConverter arg2, Object arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public static final Object access$clampToBounds(Animatable arg0, Object arg1) {
        return arg0.clampToBounds(arg1);
    }

    public static final void access$endAnimation(Animatable arg0) {
        arg0.endAnimation();
    }

    public static final Object access$runAnimation(Animatable arg0, Animation arg1, Object arg2, Function1 arg3, Continuation arg4) {
        return arg0.runAnimation(arg1, arg2, arg3, arg4);
    }

    public static final void access$setRunning(Animatable arg0, boolean arg1) {
        arg0.setRunning(arg1);
    }

    public static final void access$setTargetValue(Animatable arg0, Object arg1) {
        arg0.setTargetValue(arg1);
    }

    public final Object animateDecay(Object arg5, DecayAnimationSpec arg6, Function1 arg7, Continuation arg8) {
        return this.runAnimation(new DecayAnimation(arg6, this.typeConverter, this.getValue(), this.typeConverter.getConvertToVector().invoke(arg5)), arg5, arg7, arg8);
    }

    public static Object animateDecay$default(Animatable arg0, Object arg1, DecayAnimationSpec arg2, Function1 arg3, Continuation arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = null;
        }

        return arg0.animateDecay(arg1, arg2, arg3, arg4);
    }

    public final Object animateTo(Object arg3, AnimationSpec arg4, Object arg5, Function1 arg6, Continuation arg7) {
        return this.runAnimation(AnimationKt.TargetBasedAnimation(arg4, this.typeConverter, this.getValue(), arg3, arg5), arg5, arg6, arg7);
    }

    public static Object animateTo$default(Animatable arg6, Object arg7, AnimationSpec arg8, Object arg9, Function1 arg10, Continuation arg11, int arg12, Object arg13) {
        SpringSpec v8;
        if((arg12 & 2) != 0) {
            v8 = arg6.defaultSpringSpec;
        }

        AnimationSpec v2 = ((AnimationSpec)v8);
        if((arg12 & 4) != 0) {
            arg9 = arg6.getVelocity();
        }

        Object v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        return arg6.animateTo(arg7, v2, v3, arg10, arg11);
    }

    public final State asState() {
        return this.internalState;
    }

    private final Object clampToBounds(Object arg7) {
        if(!Intrinsics.areEqual(this.lowerBoundVector, this.negativeInfinityBounds) || !Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds)) {
            Object v0 = this.typeConverter.getConvertToVector().invoke(arg7);
            int v1 = ((AnimationVector)v0).getSize$animation_core();
            int v2 = 0;
            int v3 = 0;
            while(v2 < v1) {
                if(((AnimationVector)v0).get$animation_core(v2) < this.lowerBoundVector.get$animation_core(v2) || ((AnimationVector)v0).get$animation_core(v2) > this.upperBoundVector.get$animation_core(v2)) {
                    ((AnimationVector)v0).set$animation_core(v2, RangesKt.coerceIn(((AnimationVector)v0).get$animation_core(v2), this.lowerBoundVector.get$animation_core(v2), this.upperBoundVector.get$animation_core(v2)));
                    v3 = 1;
                }

                ++v2;
            }

            if(v3 == 0) {
                return arg7;
            }

            return this.typeConverter.getConvertFromVector().invoke(v0);
        }
        else {
        }

        return arg7;
    }

    private final void endAnimation() {
        AnimationState v0 = this.internalState;
        v0.getVelocityVector().reset$animation_core();
        v0.setLastFrameTimeNanos$animation_core(-9223372036854775808L);
        this.setRunning(false);
    }

    public final SpringSpec getDefaultSpringSpec$animation_core() {
        return this.defaultSpringSpec;
    }

    public final AnimationState getInternalState$animation_core() {
        return this.internalState;
    }

    public final String getLabel() {
        return this.label;
    }

    public final Object getLowerBound() {
        return this.lowerBound;
    }

    private static void getNegativeInfinityBounds$annotations() {
    }

    private static void getPositiveInfinityBounds$annotations() {
    }

    public final Object getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final TwoWayConverter getTypeConverter() {
        return this.typeConverter;
    }

    public final Object getUpperBound() {
        return this.upperBound;
    }

    public final Object getValue() {
        return this.internalState.getValue();
    }

    public final Object getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.getVelocityVector());
    }

    public final AnimationVector getVelocityVector() {
        return this.internalState.getVelocityVector();
    }

    public final boolean isRunning() {
        return this.isRunning$delegate.getValue().booleanValue();
    }

    private final Object runAnimation(Animation arg13, Object arg14, Function1 arg15, Continuation arg16) {
        return MutatorMutex.mutate$default(this.mutatorMutex, null, new Animatable$runAnimation$2(this, arg14, arg13, this.internalState.getLastFrameTimeNanos(), arg15, null), arg16, 1, null);
    }

    private final void setRunning(boolean arg1) {
        this.isRunning$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setTargetValue(Object arg1) {
        this.targetValue$delegate.setValue(arg1);
    }

    public final Object snapTo(Object arg7, Continuation arg8) {
        Object v6 = MutatorMutex.mutate$default(this.mutatorMutex, null, new Animatable$snapTo$2(this, arg7, null), arg8, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public final Object stop(Continuation arg7) {
        Object v6 = MutatorMutex.mutate$default(this.mutatorMutex, null, new Animatable$stop$2(this, null), arg7, 1, null);
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    public final void updateBounds(Object arg8, Object arg9) {
        Object v1;
        AnimationVector v0_1;
        if(arg8 != null) {
            Object v0 = this.typeConverter.getConvertToVector().invoke(arg8);
            if(v0 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            v0_1 = this.negativeInfinityBounds;
        }

        if(arg9 != null) {
            v1 = this.typeConverter.getConvertToVector().invoke(arg9);
            if(v1 == null) {
                goto label_11;
            }
        }
        else {
        label_11:
            AnimationVector v1_1 = this.positiveInfinityBounds;
        }

        int v2 = v0_1.getSize$animation_core();
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            int v5 = v0_1.get$animation_core(v4) <= ((AnimationVector)v1).get$animation_core(v4) ? 1 : 0;
            if(v5 == 0) {
                PreconditionsKt.throwIllegalStateException("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + v0_1 + " is greater than upper bound " + v1 + " on index " + v4);
            }
        }

        this.lowerBoundVector = v0_1;
        this.upperBoundVector = ((AnimationVector)v1);
        this.upperBound = arg9;
        this.lowerBound = arg8;
        if(!this.isRunning()) {
            arg8 = this.clampToBounds(this.getValue());
            if(!Intrinsics.areEqual(arg8, this.getValue())) {
                this.internalState.setValue$animation_core(arg8);
            }
        }
    }

    public static void updateBounds$default(Animatable arg0, Object arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.lowerBound;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.upperBound;
        }

        arg0.updateBounds(arg1, arg2);
    }
}

