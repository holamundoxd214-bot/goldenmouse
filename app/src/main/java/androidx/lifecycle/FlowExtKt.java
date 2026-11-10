package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A.\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2={"flowWithLifecycle", "Lkotlinx/coroutines/flow/Flow;", "T", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class FlowExtKt {
    public static final Flow flowWithLifecycle(Flow arg2, Lifecycle arg3, State arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "lifecycle");
        Intrinsics.checkNotNullParameter(arg4, "minActiveState");
        return FlowKt.callbackFlow(new FlowExtKt$flowWithLifecycle$1(arg3, arg4, arg2, null));
    }

    public static Flow flowWithLifecycle$default(Flow arg0, Lifecycle arg1, State arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = State.STARTED;
        }

        return FlowExtKt.flowWithLifecycle(arg0, arg1, arg2);
    }
}

