package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B[\b\u0000\u0012\u0006\u0010\u0005\u001A\u00028\u0000\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001A\u00028\u0001\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00028\u0000\u0012\u0006\u0010\f\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u00104\u001A\u00020\u0011J\u0012\u00105\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000106R\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000B\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001C\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00028\u00008F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\u001D\u0010\u0017\"\u0004\b\u001E\u0010\u001FR&\u0010\"\u001A\u00028\u00012\u0006\u0010\u001C\u001A\u00028\u0001@@X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\'\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\t\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\n@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u001A\"\u0004\b)\u0010*R$\u0010+\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\n@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u001A\"\u0004\b-\u0010*R+\u0010\r\u001A\u00020\u000E2\u0006\u0010\u001B\u001A\u00020\u000E8F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b1\u0010!\u001A\u0004\b\r\u0010.\"\u0004\b/\u00100R\u0011\u00102\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b3\u0010\u0017¨\u00067"}, d2={"Landroidx/compose/animation/core/AnimationScope;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialVelocityVector", "lastFrameTimeNanos", "", "targetValue", "startTimeNanos", "isRunning", "", "onCancel", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationVector;JLjava/lang/Object;JZLkotlin/jvm/functions/Function0;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getTargetValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStartTimeNanos", "()J", "<set-?>", "value", "getValue", "setValue$animation_core", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "getLastFrameTimeNanos", "setLastFrameTimeNanos$animation_core", "(J)V", "finishedTimeNanos", "getFinishedTimeNanos", "setFinishedTimeNanos$animation_core", "()Z", "setRunning$animation_core", "(Z)V", "isRunning$delegate", "velocity", "getVelocity", "cancelAnimation", "toAnimationState", "Landroidx/compose/animation/core/AnimationState;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimationScope {
    public static final int $stable = 8;
    private long finishedTimeNanos;
    private final MutableState isRunning$delegate;
    private long lastFrameTimeNanos;
    private final Function0 onCancel;
    private final long startTimeNanos;
    private final Object targetValue;
    private final TwoWayConverter typeConverter;
    private final MutableState value$delegate;
    private AnimationVector velocityVector;

    static {
    }

    public AnimationScope(Object arg1, TwoWayConverter arg2, AnimationVector arg3, long arg4, Object arg6, long arg7, boolean arg9, Function0 arg10) {
        super();
        this.typeConverter = arg2;
        this.targetValue = arg6;
        this.startTimeNanos = arg7;
        this.onCancel = arg10;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(arg1, null, 2, null);
        this.velocityVector = AnimationVectorsKt.copy(arg3);
        this.lastFrameTimeNanos = arg4;
        this.finishedTimeNanos = -9223372036854775808L;
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arg9), null, 2, null);
    }

    public final void cancelAnimation() {
        this.setRunning$animation_core(false);
        this.onCancel.invoke();
    }

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final long getStartTimeNanos() {
        return this.startTimeNanos;
    }

    public final Object getTargetValue() {
        return this.targetValue;
    }

    public final TwoWayConverter getTypeConverter() {
        return this.typeConverter;
    }

    public final Object getValue() {
        return this.value$delegate.getValue();
    }

    public final Object getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public final AnimationVector getVelocityVector() {
        return this.velocityVector;
    }

    public final boolean isRunning() {
        return this.isRunning$delegate.getValue().booleanValue();
    }

    public final void setFinishedTimeNanos$animation_core(long arg1) {
        this.finishedTimeNanos = arg1;
    }

    public final void setLastFrameTimeNanos$animation_core(long arg1) {
        this.lastFrameTimeNanos = arg1;
    }

    public final void setRunning$animation_core(boolean arg1) {
        this.isRunning$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setValue$animation_core(Object arg1) {
        this.value$delegate.setValue(arg1);
    }

    public final void setVelocityVector$animation_core(AnimationVector arg1) {
        this.velocityVector = arg1;
    }

    public final AnimationState toAnimationState() {
        return new AnimationState(this.typeConverter, this.getValue(), this.velocityVector, this.lastFrameTimeNanos, this.finishedTimeNanos, this.isRunning());
    }
}

