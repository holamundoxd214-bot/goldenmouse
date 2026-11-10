package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B-\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u001C\u0010\u000E\u001A\u00020\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H¤@¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001A\u00020\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0014\u001A\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0015J\u001C\u0010\u0016\u001A\u00020\u000F2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0094@¢\u0006\u0002\u0010\u0019J\u001C\u0010\u001A\u001A\u00020\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0085\u0004¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "S", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "flowCollect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectWithContextUndispatched", "newContext", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collect", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ChannelFlowOperator extends ChannelFlow {
    protected final Flow flow;

    public ChannelFlowOperator(Flow arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        super(arg2, arg3, arg4);
        this.flow = arg1;
    }

    public static final Object access$collectWithContextUndispatched(ChannelFlowOperator arg0, FlowCollector arg1, CoroutineContext arg2, Continuation arg3) {
        return arg0.collectWithContextUndispatched(arg1, arg2, arg3);
    }

    public Object collect(FlowCollector arg1, Continuation arg2) {
        return ChannelFlowOperator.collect$suspendImpl(this, arg1, arg2);
    }

    static Object collect$suspendImpl(ChannelFlowOperator arg4, FlowCollector arg5, Continuation arg6) {
        Object v4;
        if(arg4.capacity == -3) {
            CoroutineContext v0 = arg6.getContext();
            CoroutineContext v1 = CoroutineContextKt.newCoroutineContext(v0, arg4.context);
            if(Intrinsics.areEqual(v1, v0)) {
                v4 = arg4.flowCollect(arg5, arg6);
                if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v4;
                }
                else {
                    return Unit.INSTANCE;
                }
            }
            else if(Intrinsics.areEqual(v1.get(ContinuationInterceptor.Key), v0.get(ContinuationInterceptor.Key))) {
                v4 = arg4.collectWithContextUndispatched(arg5, v1, arg6);
                if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v4;
                }
                else {
                    return Unit.INSTANCE;
                }
            }
        }

        v4 = super.collect(arg5, arg6);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    protected Object collectTo(ProducerScope arg1, Continuation arg2) {
        return ChannelFlowOperator.collectTo$suspendImpl(this, arg1, arg2);
    }

    static Object collectTo$suspendImpl(ChannelFlowOperator arg1, ProducerScope arg2, Continuation arg3) {
        Object v1 = arg1.flowCollect(new SendingCollector(((SendChannel)arg2)), arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    private final Object collectWithContextUndispatched(FlowCollector arg9, CoroutineContext arg10, Continuation arg11) {
        return ChannelFlowKt.withContextUndispatched$default(arg10, ChannelFlowKt.withUndispatchedContextCollector(arg9, arg11.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), arg11, 4, null);
    }

    protected abstract Object flowCollect(FlowCollector arg1, Continuation arg2);

    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}

