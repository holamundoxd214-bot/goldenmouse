package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AC\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\'\u0010\u0005\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@¢\u0006\u0002\u0010\u000B\u001AC\u0010\u0000\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00042\'\u0010\u0005\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"repeatOnLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class RepeatOnLifecycleKt {
    public static final Object repeatOnLifecycle(Lifecycle arg2, State arg3, Function2 arg4, Continuation arg5) {
        if(arg3 != State.INITIALIZED) {
            if(arg2.getCurrentState() == State.DESTROYED) {
                return Unit.INSTANCE;
            }

            Object v2 = CoroutineScopeKt.coroutineScope(new RepeatOnLifecycleKt$repeatOnLifecycle$3(arg2, arg3, arg4, null), arg5);
            if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v2;
            }

            return Unit.INSTANCE;
        }

        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    }

    public static final Object repeatOnLifecycle(LifecycleOwner arg0, State arg1, Function2 arg2, Continuation arg3) {
        Object v0 = RepeatOnLifecycleKt.repeatOnLifecycle(arg0.getLifecycle(), arg1, arg2, arg3);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

