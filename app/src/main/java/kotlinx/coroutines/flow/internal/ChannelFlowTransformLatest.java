package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003Bw\u0012B\u0010\u0004\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005¢\u0006\u0002\b\r\u0012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00010\u001A2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015H\u0014J\u001C\u0010\u001B\u001A\u00020\u000B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0094@¢\u0006\u0002\u0010\u001DRL\u0010\u0004\u001A>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005¢\u0006\u0002\b\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006\u001E"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "transform", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "flow", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function3;", "create", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flowCollect", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ChannelFlowTransformLatest extends ChannelFlowOperator {
    private final Function3 transform;

    public ChannelFlowTransformLatest(Function3 arg7, Flow arg8, CoroutineContext arg9, int arg10, BufferOverflow arg11, int arg12, DefaultConstructorMarker arg13) {
        EmptyCoroutineContext v9;
        if((arg12 & 4) != 0) {
            v9 = EmptyCoroutineContext.INSTANCE;
        }

        CoroutineContext v3 = ((CoroutineContext)v9);
        if((arg12 & 8) != 0) {
            arg10 = -2;
        }

        int v4 = arg10;
        if((arg12 & 16) != 0) {
            arg11 = BufferOverflow.SUSPEND;
        }

        this(arg7, arg8, v3, v4, arg11);
    }

    public ChannelFlowTransformLatest(Function3 arg1, Flow arg2, CoroutineContext arg3, int arg4, BufferOverflow arg5) {
        super(arg2, arg3, arg4, arg5);
        this.transform = arg1;
    }

    public static final Function3 access$getTransform$p(ChannelFlowTransformLatest arg0) {
        return arg0.transform;
    }

    protected ChannelFlow create(CoroutineContext arg7, int arg8, BufferOverflow arg9) {
        return new ChannelFlowTransformLatest(this.transform, this.flow, arg7, arg8, arg9);
    }

    protected Object flowCollect(FlowCollector arg3, Continuation arg4) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if((arg3 instanceof SendingCollector)) {
            }
            else {
                throw new AssertionError();
            }
        }

        Object v2 = CoroutineScopeKt.coroutineScope(new ChannelFlowTransformLatest$flowCollect$3(this, arg3, null), arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }
}

