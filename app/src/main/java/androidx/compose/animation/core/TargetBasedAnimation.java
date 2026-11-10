package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004BG\b\u0000\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001A\u00028\u0000\u0012\u0006\u0010\n\u001A\u00028\u0000\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00018\u0001¢\u0006\u0004\b\f\u0010\rBG\b\u0016\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001A\u00028\u0000\u0012\u0006\u0010\n\u001A\u00028\u0000\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00018\u0001¢\u0006\u0004\b\f\u0010\u000FJ\u0015\u0010&\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020(H\u0016¢\u0006\u0002\u0010)J\u0015\u00102\u001A\u00028\u00012\u0006\u0010\'\u001A\u00020(H\u0016¢\u0006\u0002\u00103J\b\u00104\u001A\u000205H\u0016R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000@@X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u001A\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001B\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00028\u0000@@X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u001A\u001A\u0004\b\u001C\u0010\u0017\"\u0004\b\u001D\u0010\u0019R\u0011\u0010\t\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0017R\u0014\u0010\n\u001A\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0017R\u0010\u0010 \u001A\u00028\u0001X\u0082\u000E¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001A\u00028\u0001X\u0082\u000E¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\u000B\u001A\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010#\u001A\u00020$8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010%R\u000E\u0010*\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010+\u001A\u00020(8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b,\u0010-R\u0012\u0010.\u001A\u0004\u0018\u00018\u0001X\u0082\u000E¢\u0006\u0004\n\u0002\u0010!R\u0014\u0010/\u001A\u00028\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b0\u00101¨\u00066"}, d2={"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "<init>", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "getAnimationSpec$animation_core", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "mutableTargetValue", "getMutableTargetValue$animation_core", "()Ljava/lang/Object;", "setMutableTargetValue$animation_core", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "mutableInitialValue", "getMutableInitialValue$animation_core", "setMutableInitialValue$animation_core", "getInitialValue", "getTargetValue", "initialValueVector", "Landroidx/compose/animation/core/AnimationVector;", "targetValueVector", "isInfinite", "", "()Z", "getValueFromNanos", "playTimeNanos", "", "(J)Ljava/lang/Object;", "_durationNanos", "durationNanos", "getDurationNanos", "()J", "_endVelocity", "endVelocity", "getEndVelocity", "()Landroidx/compose/animation/core/AnimationVector;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TargetBasedAnimation implements Animation {
    public static final int $stable = 8;
    private long _durationNanos;
    private AnimationVector _endVelocity;
    private final VectorizedAnimationSpec animationSpec;
    private AnimationVector initialValueVector;
    private final AnimationVector initialVelocityVector;
    private Object mutableInitialValue;
    private Object mutableTargetValue;
    private AnimationVector targetValueVector;
    private final TwoWayConverter typeConverter;

    static {
    }

    public TargetBasedAnimation(AnimationSpec arg1, TwoWayConverter arg2, Object arg3, Object arg4, AnimationVector arg5) {
        this(arg1.vectorize(arg2), arg2, arg3, arg4, arg5);
    }

    public TargetBasedAnimation(VectorizedAnimationSpec arg1, TwoWayConverter arg2, Object arg3, Object arg4, AnimationVector arg5) {
        AnimationVector v1;
        super();
        this.animationSpec = arg1;
        this.typeConverter = arg2;
        this.mutableTargetValue = arg4;
        this.mutableInitialValue = arg3;
        this.initialValueVector = this.getTypeConverter().getConvertToVector().invoke(arg3);
        this.targetValueVector = this.getTypeConverter().getConvertToVector().invoke(arg4);
        if(arg5 != null) {
            v1 = AnimationVectorsKt.copy(arg5);
            if(v1 == null) {
                goto label_16;
            }
        }
        else {
        label_16:
            v1 = AnimationVectorsKt.newInstance(this.getTypeConverter().getConvertToVector().invoke(arg3));
        }

        this.initialVelocityVector = v1;
        this._durationNanos = -1;
    }

    public TargetBasedAnimation(AnimationSpec arg7, TwoWayConverter arg8, Object arg9, Object arg10, AnimationVector arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 16) != 0) {
            arg11 = null;
        }

        this(arg7, arg8, arg9, arg10, arg11);
    }

    public TargetBasedAnimation(VectorizedAnimationSpec arg7, TwoWayConverter arg8, Object arg9, Object arg10, AnimationVector arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 16) != 0) {
            arg11 = null;
        }

        this(arg7, arg8, arg9, arg10, arg11);
    }

    public final VectorizedAnimationSpec getAnimationSpec$animation_core() {
        return this.animationSpec;
    }

    public long getDurationNanos() {
        long v0 = this._durationNanos;
        if(v0 < 0) {
            v0 = this.animationSpec.getDurationNanos(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
            this._durationNanos = v0;
        }

        return v0;
    }

    private final AnimationVector getEndVelocity() {
        AnimationVector v0 = this._endVelocity;
        if(v0 == null) {
            v0 = this.animationSpec.getEndVelocity(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
            this._endVelocity = v0;
        }

        return v0;
    }

    public final Object getInitialValue() {
        return this.mutableInitialValue;
    }

    public final Object getMutableInitialValue$animation_core() {
        return this.mutableInitialValue;
    }

    public final Object getMutableTargetValue$animation_core() {
        return this.mutableTargetValue;
    }

    public Object getTargetValue() {
        return this.mutableTargetValue;
    }

    public TwoWayConverter getTypeConverter() {
        return this.typeConverter;
    }

    public Object getValueFromNanos(long arg8) {
        if(!this.isFinishedFromNanos(arg8)) {
            long v2 = arg8;
            AnimationVector v8 = this.animationSpec.getValueFromNanos(v2, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
            int v9 = v8.getSize$animation_core();
            int v0;
            for(v0 = 0; v0 < v9; ++v0) {
                if(Float.isNaN(v8.get$animation_core(v0))) {
                    PreconditionsKt.throwIllegalStateException("AnimationVector cannot contain a NaN. " + v8 + ". Animation: " + this + ", playTimeNanos: " + v2);
                }
            }

            return this.getTypeConverter().getConvertFromVector().invoke(v8);
        }

        return this.getTargetValue();
    }

    public AnimationVector getVelocityVectorFromNanos(long arg8) {
        if(!this.isFinishedFromNanos(arg8)) {
            return this.animationSpec.getVelocityFromNanos(arg8, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }

        return this.getEndVelocity();
    }

    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public final void setMutableInitialValue$animation_core(Object arg3) {
        if(!Intrinsics.areEqual(arg3, this.mutableInitialValue)) {
            this.mutableInitialValue = arg3;
            this.initialValueVector = this.getTypeConverter().getConvertToVector().invoke(arg3);
            this._endVelocity = null;
            this._durationNanos = -1;
        }
    }

    public final void setMutableTargetValue$animation_core(Object arg3) {
        if(!Intrinsics.areEqual(this.mutableTargetValue, arg3)) {
            this.mutableTargetValue = arg3;
            this.targetValueVector = this.getTypeConverter().getConvertToVector().invoke(arg3);
            this._endVelocity = null;
            this._durationNanos = -1;
        }
    }

    public String toString() {
        return "TargetBasedAnimation: " + this.getInitialValue() + " -> " + this.getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }
}

