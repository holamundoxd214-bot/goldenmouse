package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0010¢\u0006\u0002\b\u0018J\r\u0010\u0019\u001A\u00020\u0015H\u0010¢\u0006\u0002\b\u001AR+\u0010\u0007\u001A\u00028\u00002\u0006\u0010\u0006\u001A\u00028\u00008V@PX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R+\u0010\r\u001A\u00028\u00002\u0006\u0010\u0006\u001A\u00028\u00008V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001A\u0004\b\u000E\u0010\t\"\u0004\b\u000F\u0010\u0005R\u0011\u0010\u0011\u001A\u00020\u00128F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0013¨\u0006\u001B"}, d2={"Landroidx/compose/animation/core/MutableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "<init>", "(Ljava/lang/Object;)V", "<set-?>", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "targetState", "getTargetState", "setTargetState", "targetState$delegate", "isIdle", "", "()Z", "transitionConfigured", "", "transition", "Landroidx/compose/animation/core/Transition;", "transitionConfigured$animation_core", "transitionRemoved", "transitionRemoved$animation_core", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MutableTransitionState extends TransitionState {
    public static final int $stable;
    private final MutableState currentState$delegate;
    private final MutableState targetState$delegate;

    static {
    }

    public MutableTransitionState(Object arg4) {
        super(null);
        this.currentState$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
    }

    public Object getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    public Object getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public final boolean isIdle() {
        if((Intrinsics.areEqual(this.getCurrentState(), this.getTargetState())) && !this.isRunning$animation_core()) {
            return 1;
        }

        return 0;
    }

    public void setCurrentState$animation_core(Object arg1) {
        this.currentState$delegate.setValue(arg1);
    }

    public void setTargetState(Object arg1) {
        this.targetState$delegate.setValue(arg1);
    }

    public void setTargetState$animation_core(Object arg1) {
        this.setTargetState(arg1);
    }

    public void transitionConfigured$animation_core(Transition arg1) {
    }

    public void transitionRemoved$animation_core() {
    }
}

