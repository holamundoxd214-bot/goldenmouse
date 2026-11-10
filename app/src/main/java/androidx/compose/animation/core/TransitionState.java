package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\u0017\u001A\u00020\u00182\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u001AH ¢\u0006\u0002\b\u001BJ\r\u0010\u001C\u001A\u00020\u0018H ¢\u0006\u0002\b\u001DR\"\u0010\u0006\u001A\u00028\u00002\u0006\u0010\u0005\u001A\u00028\u0000@`X¦\u000E¢\u0006\f\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000B\u001A\u00028\u00002\u0006\u0010\u0005\u001A\u00028\u0000@`X¦\u000E¢\u0006\f\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR+\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u000F8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0082\u0001\u0003\u001E\u001F ¨\u0006!"}, d2={"Landroidx/compose/animation/core/TransitionState;", "S", "", "<init>", "()V", "value", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core", "(Ljava/lang/Object;)V", "targetState", "getTargetState", "setTargetState$animation_core", "<set-?>", "", "isRunning", "isRunning$animation_core", "()Z", "setRunning$animation_core", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "transitionConfigured", "", "transition", "Landroidx/compose/animation/core/Transition;", "transitionConfigured$animation_core", "transitionRemoved", "transitionRemoved$animation_core", "Landroidx/compose/animation/core/MutableTransitionState;", "Landroidx/compose/animation/core/PreventExhaustiveWhenTransitionState;", "Landroidx/compose/animation/core/SeekableTransitionState;", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class TransitionState {
    public static final int $stable;
    private final MutableState isRunning$delegate;

    static {
    }

    private TransitionState() {
        super();
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    public TransitionState(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract Object getCurrentState();

    public abstract Object getTargetState();

    public final boolean isRunning$animation_core() {
        return this.isRunning$delegate.getValue().booleanValue();
    }

    public abstract void setCurrentState$animation_core(Object arg1);

    public final void setRunning$animation_core(boolean arg1) {
        this.isRunning$delegate.setValue(Boolean.valueOf(arg1));
    }

    public abstract void setTargetState$animation_core(Object arg1);

    public abstract void transitionConfigured$animation_core(Transition arg1);

    public abstract void transitionRemoved$animation_core();
}

