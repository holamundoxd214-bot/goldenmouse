package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0011\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\tH\u0082\bJ\b\u0010\u0010\u001A\u00020\u000FH\u0007R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/lifecycle/LifecycleController;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "parentJob", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "handleDestroy", "", "finish", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle arg2, State arg3, DispatchQueue arg4, Job arg5) {
        Intrinsics.checkNotNullParameter(arg2, "lifecycle");
        Intrinsics.checkNotNullParameter(arg3, "minState");
        Intrinsics.checkNotNullParameter(arg4, "dispatchQueue");
        Intrinsics.checkNotNullParameter(arg5, "parentJob");
        super();
        this.lifecycle = arg2;
        this.minState = arg3;
        this.dispatchQueue = arg4;
        LifecycleController$$ExternalSyntheticLambda0 v3 = new LifecycleController$$ExternalSyntheticLambda0(this, arg5);
        this.observer = ((LifecycleEventObserver)v3);
        if(arg2.getCurrentState() == State.DESTROYED) {
            DefaultImpls.cancel$default(arg5, null, 1, null);
            this.finish();
            return;
        }

        arg2.addObserver(((LifecycleObserver)v3));
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }

    private final void handleDestroy(Job arg3) {
        DefaultImpls.cancel$default(arg3, null, 1, null);
        this.finish();
    }

    static final void observer$lambda$0(LifecycleController arg1, Job arg2, LifecycleOwner arg3, Event arg4) {
        Intrinsics.checkNotNullParameter(arg3, "source");
        Intrinsics.checkNotNullParameter(arg4, "<unused var>");
        if(arg3.getLifecycle().getCurrentState() == State.DESTROYED) {
            DefaultImpls.cancel$default(arg2, null, 1, null);
            arg1.finish();
            return;
        }

        if(arg3.getLifecycle().getCurrentState().compareTo(arg1.minState) < 0) {
            arg1.dispatchQueue.pause();
            return;
        }

        arg1.dispatchQueue.resume();
    }
}

