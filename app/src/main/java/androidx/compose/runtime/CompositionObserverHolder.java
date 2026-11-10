package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001A\u0004\u0018\u00010\u0003R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/CompositionObserverHolder;", "", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "root", "", "parent", "Landroidx/compose/runtime/CompositionContext;", "<init>", "(Landroidx/compose/runtime/tooling/CompositionObserver;ZLandroidx/compose/runtime/CompositionContext;)V", "getObserver", "()Landroidx/compose/runtime/tooling/CompositionObserver;", "setObserver", "(Landroidx/compose/runtime/tooling/CompositionObserver;)V", "getRoot", "()Z", "setRoot", "(Z)V", "current", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionObserverHolder {
    public static final int $stable = 8;
    private CompositionObserver observer;
    private final CompositionContext parent;
    private boolean root;

    static {
    }

    public CompositionObserverHolder(CompositionObserver arg1, boolean arg2, CompositionContext arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = null;
        }

        this(arg1, false, arg3);
    }

    public CompositionObserverHolder(CompositionObserver arg1, boolean arg2, CompositionContext arg3) {
        super();
        this.observer = arg1;
        this.root = arg2;
        this.parent = arg3;
    }

    public final CompositionObserver current() {
        CompositionObserver v0_1;
        if(this.root) {
            return this.observer;
        }

        CompositionObserverHolder v0 = this.parent.getObserverHolder$runtime();
        if(v0 != null) {
            v0_1 = v0.observer;
        }
        else {
            Object v0_2 = null;
        }

        if(!Intrinsics.areEqual(v0_1, this.observer)) {
            this.observer = v0_1;
        }

        return v0_1;
    }

    public final CompositionObserver getObserver() {
        return this.observer;
    }

    public final boolean getRoot() {
        return this.root;
    }

    public final void setObserver(CompositionObserver arg1) {
        this.observer = arg1;
    }

    public final void setRoot(boolean arg1) {
        this.root = arg1;
    }
}

