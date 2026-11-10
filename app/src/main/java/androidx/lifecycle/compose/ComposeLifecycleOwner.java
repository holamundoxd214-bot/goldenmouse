package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014J\b\u0010\u0015\u001A\u00020\u0012H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0016"}, d2={"Landroidx/lifecycle/compose/ComposeLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "parentLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "value", "maxLifecycleState", "getMaxLifecycleState", "()Landroidx/lifecycle/Lifecycle$State;", "setMaxLifecycleState", "(Landroidx/lifecycle/Lifecycle$State;)V", "handleLifecycleEvent", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "updateLifecycleState", "lifecycle-runtime-compose"}, k=1, mv={2, 1, 0}, xi=0x30) final class ComposeLifecycleOwner implements LifecycleOwner {
    private final LifecycleRegistry lifecycleRegistry;
    private State maxLifecycleState;
    private State parentLifecycleState;

    public ComposeLifecycleOwner() {
        super();
        this.lifecycleRegistry = new LifecycleRegistry(this);
        this.parentLifecycleState = State.INITIALIZED;
        this.maxLifecycleState = State.INITIALIZED;
    }

    public Lifecycle getLifecycle() {
        return this.getLifecycle();
    }

    public LifecycleRegistry getLifecycle() {
        return this.lifecycleRegistry;
    }

    public final State getMaxLifecycleState() {
        return this.maxLifecycleState;
    }

    public final void handleLifecycleEvent(Event arg1) {
        this.parentLifecycleState = arg1.getTargetState();
        this.updateLifecycleState();
    }

    public final void setMaxLifecycleState(State arg1) {
        this.maxLifecycleState = arg1;
        this.updateLifecycleState();
    }

    private final void updateLifecycleState() {
        State v0 = this.parentLifecycleState.ordinal() < this.maxLifecycleState.ordinal() ? this.parentLifecycleState : this.maxLifecycleState;
        if(this.lifecycleRegistry.getCurrentState() == State.INITIALIZED && v0 == State.DESTROYED) {
            return;
        }

        this.lifecycleRegistry.setCurrentState(v0);
    }
}

