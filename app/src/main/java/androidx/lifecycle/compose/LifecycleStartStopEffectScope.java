package androidx.lifecycle.compose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001A\u00020\t2\u0019\b\u0004\u0010\n\u001A\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0002\b\rH\u0086\bR\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000E"}, d2={"Landroidx/lifecycle/compose/LifecycleStartStopEffectScope;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onStopOrDispose", "Landroidx/lifecycle/compose/LifecycleStopOrDisposeEffectResult;", "onStopOrDisposeEffect", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "lifecycle-runtime-compose"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LifecycleStartStopEffectScope implements LifecycleOwner {
    public static final int $stable = 8;
    private final Lifecycle lifecycle;

    static {
    }

    public LifecycleStartStopEffectScope(Lifecycle arg1) {
        super();
        this.lifecycle = arg1;
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final LifecycleStopOrDisposeEffectResult onStopOrDispose(Function1 arg2) {
        return new LifecycleStartStopEffectScope$onStopOrDispose$1(arg2, this);
    }
}

