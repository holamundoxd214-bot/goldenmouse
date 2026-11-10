package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/lifecycle/SingleGeneratedAdapterObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "generatedAdapter", "Landroidx/lifecycle/GeneratedAdapter;", "<init>", "(Landroidx/lifecycle/GeneratedAdapter;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    private final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(GeneratedAdapter arg2) {
        Intrinsics.checkNotNullParameter(arg2, "generatedAdapter");
        super();
        this.generatedAdapter = arg2;
    }

    public void onStateChanged(LifecycleOwner arg4, Event arg5) {
        Intrinsics.checkNotNullParameter(arg4, "source");
        Intrinsics.checkNotNullParameter(arg5, "event");
        this.generatedAdapter.callMethods(arg4, arg5, false, null);
        this.generatedAdapter.callMethods(arg4, arg5, true, null);
    }
}

