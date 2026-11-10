package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0012\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0014J\u0016\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u001C\u0010\u0013\u001A\u00020\u00142\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0094@¢\u0006\u0002\u0010\u0016R\u001A\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flows", "", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Ljava/lang/Iterable;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "collectTo", "", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ChannelLimitedFlowMerge extends ChannelFlow {
    private final Iterable flows;

    public ChannelLimitedFlowMerge(Iterable arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4, int arg5, DefaultConstructorMarker arg6) {
        EmptyCoroutineContext v2;
        if((arg5 & 2) != 0) {
            v2 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg5 & 4) != 0) {
            arg3 = -2;
        }

        if((arg5 & 8) != 0) {
            arg4 = BufferOverflow.SUSPEND;
        }

        this(arg1, ((CoroutineContext)v2), arg3, arg4);
    }

    public ChannelLimitedFlowMerge(Iterable arg1, CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        super(arg2, arg3, arg4);
        this.flows = arg1;
    }

    protected Object collectTo(ProducerScope arg8, Continuation arg9) {
        SendingCollector v9 = new SendingCollector(arg8);
        Iterator v7 = this.flows.iterator();
        while(v7.hasNext()) {
            BuildersKt.launch$default(arg8, null, null, new ChannelLimitedFlowMerge$collectTo$2$1(v7.next(), v9, null), 3, null);
        }

        return Unit.INSTANCE;
    }

    protected ChannelFlow create(CoroutineContext arg2, int arg3, BufferOverflow arg4) {
        return new ChannelLimitedFlowMerge(this.flows, arg2, arg3, arg4);
    }

    public ReceiveChannel produceImpl(CoroutineScope arg3) {
        return ProduceKt.produce(arg3, this.context, this.capacity, this.getCollectToFun$kotlinx_coroutines_core());
    }
}

