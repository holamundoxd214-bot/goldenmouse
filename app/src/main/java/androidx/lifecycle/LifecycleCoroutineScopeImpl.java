package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001A\u00020\u000EJ\u0018\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016R\u0014\u0010\u0003\u001A\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0014"}, d2={"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "register", "", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle arg2, CoroutineContext arg3) {
        Intrinsics.checkNotNullParameter(arg2, "lifecycle");
        Intrinsics.checkNotNullParameter(arg3, "coroutineContext");
        super();
        this.lifecycle = arg2;
        this.coroutineContext = arg3;
        if(this.getLifecycle$lifecycle_common().getCurrentState() == State.DESTROYED) {
            JobKt.cancel$default(this.getCoroutineContext(), null, 1, null);
        }
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    public void onStateChanged(LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(this.getLifecycle$lifecycle_common().getCurrentState().compareTo(State.DESTROYED) <= 0) {
            this.getLifecycle$lifecycle_common().removeObserver(this);
            JobKt.cancel$default(this.getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        BuildersKt.launch$default(this, Dispatchers.getMain().getImmediate(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }
}

