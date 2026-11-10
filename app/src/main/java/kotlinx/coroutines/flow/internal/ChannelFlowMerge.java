package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BA\u0012\u0012\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\u0006\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000BH\u0014J\u0016\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u001C\u0010\u0013\u001A\u00020\u00142\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0094@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0014R\u001A\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "concurrency", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "create", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "collectTo", "", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "additionalToStringProps", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ChannelFlowMerge extends ChannelFlow {
    private final int concurrency;
    private final Flow flow;

    public ChannelFlowMerge(Flow arg7, int arg8, CoroutineContext arg9, int arg10, BufferOverflow arg11, int arg12, DefaultConstructorMarker arg13) {
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

    public ChannelFlowMerge(Flow arg1, int arg2, CoroutineContext arg3, int arg4, BufferOverflow arg5) {
        super(arg3, arg4, arg5);
        this.flow = arg1;
        this.concurrency = arg2;
    }

    protected String additionalToStringProps() {
        return "concurrency=" + this.concurrency;
    }

    protected Object collectTo(ProducerScope arg5, Continuation arg6) {
        Object v4 = this.flow.collect(new ChannelFlowMerge$collectTo$2(arg6.getContext().get(Job.Key), SemaphoreKt.Semaphore$default(this.concurrency, 0, 2, null), arg5, new SendingCollector(arg5)), arg6);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    protected ChannelFlow create(CoroutineContext arg7, int arg8, BufferOverflow arg9) {
        return new ChannelFlowMerge(this.flow, this.concurrency, arg7, arg8, arg9);
    }

    public ReceiveChannel produceImpl(CoroutineScope arg3) {
        return ProduceKt.produce(arg3, this.context, this.capacity, this.getCollectToFun$kotlinx_coroutines_core());
    }
}

