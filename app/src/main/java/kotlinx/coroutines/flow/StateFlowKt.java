package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001F\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u0002¢\u0006\u0002\u0010\u0004\u001A2\u0010\u0005\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\b\u001A2\u0010\t\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\b\u001A-\u0010\n\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b\u001A6\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0000\"\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "updateAndGet", "function", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getAndUpdate", "update", "", "NONE", "Lkotlinx/coroutines/internal/Symbol;", "PENDING", "fuseStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class StateFlowKt {
    private static final Symbol NONE;
    private static final Symbol PENDING;

    static {
        StateFlowKt.NONE = new Symbol("NONE");
        StateFlowKt.PENDING = new Symbol("PENDING");
    }

    public static final MutableStateFlow MutableStateFlow(Object arg1) {
        Symbol v1;
        if(arg1 == null) {
            v1 = NullSurrogateKt.NULL;
        }

        return new StateFlowImpl(v1);
    }

    public static final Symbol access$getNONE$p() {
        return StateFlowKt.NONE;
    }

    public static final Symbol access$getPENDING$p() {
        return StateFlowKt.PENDING;
    }

    public static final Flow fuseStateFlow(StateFlow arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg3 != -1) {
            }
            else {
                throw new AssertionError();
            }
        }

        if((arg3 >= 0 && arg3 < 2 || arg3 == -2) && arg4 == BufferOverflow.DROP_OLDEST) {
            return arg1;
        }

        return SharedFlowKt.fuseSharedFlow(((SharedFlow)arg1), arg2, arg3, arg4);
    }

    public static final Object getAndUpdate(MutableStateFlow arg2, Function1 arg3) {
        Object v0;
        do {
            v0 = arg2.getValue();
        }
        while(!arg2.compareAndSet(v0, arg3.invoke(v0)));

        return v0;
    }

    public static final void update(MutableStateFlow arg2, Function1 arg3) {
        do {
            Object v0 = arg2.getValue();
        }
        while(!arg2.compareAndSet(v0, arg3.invoke(v0)));
    }

    public static final Object updateAndGet(MutableStateFlow arg2, Function1 arg3) {
        Object v1;
        do {
            Object v0 = arg2.getValue();
            v1 = arg3.invoke(v0);
        }
        while(!arg2.compareAndSet(v0, v1));

        return v1;
    }
}

