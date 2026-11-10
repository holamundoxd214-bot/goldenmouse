package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016R\u0016\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000E"}, d2={"Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "generatedAdapters", "", "Landroidx/lifecycle/GeneratedAdapter;", "<init>", "([Landroidx/lifecycle/GeneratedAdapter;)V", "[Landroidx/lifecycle/GeneratedAdapter;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-common"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    private final GeneratedAdapter[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "generatedAdapters");
        super();
        this.generatedAdapters = arg2;
    }

    public void onStateChanged(LifecycleOwner arg7, Event arg8) {
        Intrinsics.checkNotNullParameter(arg7, "source");
        Intrinsics.checkNotNullParameter(arg8, "event");
        MethodCallsLogger v0 = new MethodCallsLogger();
        GeneratedAdapter[] v1 = this.generatedAdapters;
        int v2 = v1.length;
        int v3 = 0;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            v1[v4].callMethods(arg7, arg8, false, v0);
        }

        GeneratedAdapter[] v6 = this.generatedAdapters;
        int v1_1 = v6.length;
        while(v3 < v1_1) {
            v6[v3].callMethods(arg7, arg8, true, v0);
            ++v3;
        }
    }
}

