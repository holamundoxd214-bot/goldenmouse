package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u001E\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004BM\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001A\u00028\u0000\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00018\u0001\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\b\u0010+\u001A\u00020,H\u0016R\u001D\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0012\u001A\u00028\u00008V@PX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u001A\u001A\u00028\u00012\u0006\u0010\u0013\u001A\u00028\u0001@@X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u001F\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER$\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\n@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\n@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010!\"\u0004\b%\u0010#R$\u0010\f\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010&\"\u0004\b\'\u0010(R\u0011\u0010)\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b*\u0010\u0015¨\u0006-"}, d2={"Landroidx/compose/animation/core/AnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocityVector", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "", "<init>", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue$animation_core", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "setVelocityVector$animation_core", "(Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/AnimationVector;", "getLastFrameTimeNanos", "()J", "setLastFrameTimeNanos$animation_core", "(J)V", "getFinishedTimeNanos", "setFinishedTimeNanos$animation_core", "()Z", "setRunning$animation_core", "(Z)V", "velocity", "getVelocity", "toString", "", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimationState implements State {
    public static final int $stable;
    private long finishedTimeNanos;
    private boolean isRunning;
    private long lastFrameTimeNanos;
    private final TwoWayConverter typeConverter;
    private final MutableState value$delegate;
    private AnimationVector velocityVector;

    static {
    }

    public AnimationState(TwoWayConverter arg10, Object arg11, AnimationVector arg12, long arg13, long arg15, boolean arg17, int arg18, DefaultConstructorMarker arg19) {
        if((arg18 & 4) != 0) {
            arg12 = null;
        }

        AnimationVector v3 = arg12;
        long v0 = -9223372036854775808L;
        long v4 = (arg18 & 8) != 0 ? v0 : arg13;
        long v6 = (arg18 & 16) != 0 ? v0 : arg15;
        boolean v8 = (arg18 & 0x20) != 0 ? false : arg17;
        this(arg10, arg11, v3, v4, v6, v8);
    }

    public AnimationState(TwoWayConverter arg3, Object arg4, AnimationVector arg5, long arg6, long arg8, boolean arg10) {
        super();
        this.typeConverter = arg3;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        if(arg5 != null) {
            arg5 = AnimationVectorsKt.copy(arg5);
            if(arg5 == null) {
                goto label_9;
            }
        }
        else {
        label_9:
            arg5 = AnimationStateKt.createZeroVectorFrom(arg3, arg4);
        }

        this.velocityVector = arg5;
        this.lastFrameTimeNanos = arg6;
        this.finishedTimeNanos = arg8;
        this.isRunning = arg10;
    }

    public final long getFinishedTimeNanos() {
        return this.finishedTimeNanos;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final TwoWayConverter getTypeConverter() {
        return this.typeConverter;
    }

    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final Object getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(this.velocityVector);
    }

    public final AnimationVector getVelocityVector() {
        return this.velocityVector;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final void setFinishedTimeNanos$animation_core(long arg1) {
        this.finishedTimeNanos = arg1;
    }

    public final void setLastFrameTimeNanos$animation_core(long arg1) {
        this.lastFrameTimeNanos = arg1;
    }

    public final void setRunning$animation_core(boolean arg1) {
        this.isRunning = arg1;
    }

    public void setValue$animation_core(Object arg1) {
        this.value$delegate.setValue(arg1);
    }

    public final void setVelocityVector$animation_core(AnimationVector arg1) {
        this.velocityVector = arg1;
    }

    public String toString() {
        return "AnimationState(value=" + this.getValue() + ", velocity=" + this.getVelocity() + ", isRunning=" + this.isRunning + ", lastFrameTimeNanos=" + this.lastFrameTimeNanos + ", finishedTimeNanos=" + this.finishedTimeNanos + ')';
    }
}

