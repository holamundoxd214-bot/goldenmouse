package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001AU\u0010\n\u001A\u00020\u000B*\u00020\u00022C\b\u0004\u0010\f\u001A=\u0012\u0004\u0012\u00020\u000B\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\r¢\u0006\u0002\b\u0014H\u0086\bø\u0001\u0000\"\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u001B\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2={"coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/Lifecycle;", "getCoroutineScope", "(Landroidx/lifecycle/Lifecycle;)Landroidx/lifecycle/LifecycleCoroutineScope;", "eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/lifecycle/Lifecycle$Event;", "getEventFlow", "(Landroidx/lifecycle/Lifecycle;)Lkotlinx/coroutines/flow/Flow;", "addObserver", "Landroidx/lifecycle/LifecycleObserver;", "action", "Lkotlin/Function3;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/ParameterName;", "name", "source", "event", "", "Lkotlin/ExtensionFunctionType;", "lifecycle-common"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LifecycleKt {
    public static final LifecycleObserver addObserver(Lifecycle arg1, Function3 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        LifecycleKt$addObserver$observer$1 v0 = new LifecycleKt$addObserver$observer$1(arg2);
        arg1.addObserver(((LifecycleObserver)v0));
        return ((LifecycleObserver)v0);
    }

    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle arg4) {
        LifecycleCoroutineScopeImpl v0_1;
        Object v0;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        do {
            v0 = arg4.getInternalScopeRef().get();
            if(v0 != null) {
                goto label_5;
            }

            v0_1 = new LifecycleCoroutineScopeImpl(arg4, SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        }
        while(!arg4.getInternalScopeRef().compareAndSet(null, v0_1));

        v0_1.register();
        return ((LifecycleCoroutineScope)v0_1);
    label_5:
        return ((LifecycleCoroutineScope)v0);
    }

    public static final Flow getEventFlow(Lifecycle arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return FlowKt.flowOn(FlowKt.callbackFlow(new LifecycleKt$eventFlow$1(arg2, null)), Dispatchers.getMain().getImmediate());
    }
}

