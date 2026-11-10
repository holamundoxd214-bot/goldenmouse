package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0002B3\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ&\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0014J\u000E\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001C\u0010\u0010\u001A\u00020\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0094@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowOperatorImpl;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "dropChannelOperators", "flowCollect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ChannelFlowOperatorImpl extends ChannelFlowOperator {
    public ChannelFlowOperatorImpl(Flow arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4, int arg5, DefaultConstructorMarker arg6) {
        EmptyCoroutineContext v2;
        if((arg5 & 2) != 0) {
            v2 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg5 & 4) != 0) {
            arg3 = -3;
        }

        if((arg5 & 8) != 0) {
            arg4 = BufferOverflow.SUSPEND;
        }

        this(arg1, ((CoroutineContext)v2), arg3, arg4);
    }

    public ChannelFlowOperatorImpl(Flow arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        super(arg1, arg2, arg3, arg4);
    }

    protected ChannelFlow create(CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        return new ChannelFlowOperatorImpl(this.flow, arg2, arg3, arg4);
    }

    public Flow dropChannelOperators() {
        return this.flow;
    }

    protected Object flowCollect(FlowCollector arg1, Continuation arg2) {
        Object v0 = this.flow.collect(arg1, arg2);
        if(v0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0;
        }

        return Unit.INSTANCE;
    }
}

