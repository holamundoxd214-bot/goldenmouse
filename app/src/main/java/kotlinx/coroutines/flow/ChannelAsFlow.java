package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0011\u001A\u00020\u0012H\u0002J&\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0014J\u000E\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001C\u0010\u0016\u001A\u00020\u00122\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0094@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0017\u001A\u00020\u001BH\u0016J\u001C\u0010\u001C\u001A\u00020\u00122\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u001EH\u0096@¢\u0006\u0002\u0010\u001FJ\b\u0010 \u001A\u00020!H\u0014R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¨\u0006\""}, d2={"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "consume", "", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "consumed", "Lkotlinx/atomicfu/AtomicBoolean;", "markConsumed", "", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "collectTo", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceImpl", "Lkotlinx/coroutines/CoroutineScope;", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "additionalToStringProps", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ChannelAsFlow extends ChannelFlow {
    private final ReceiveChannel channel;
    private final boolean consume;

    static {
        ChannelAsFlow.consumed$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed$volatile");
    }

    public ChannelAsFlow(ReceiveChannel arg1, boolean arg2, CoroutineContext arg3, int arg4, BufferOverflow arg5) {
        super(arg3, arg4, arg5);
        this.channel = arg1;
        this.consume = arg2;
    }

    public ChannelAsFlow(ReceiveChannel arg7, boolean arg8, CoroutineContext arg9, int arg10, BufferOverflow arg11, int arg12, DefaultConstructorMarker arg13) {
        EmptyCoroutineContext v9;
        if((arg12 & 4) != 0) {
            v9 = EmptyCoroutineContext.INSTANCE;
        }

        CoroutineContext v3 = ((CoroutineContext)v9);
        if((arg12 & 8) != 0) {
            arg10 = -3;
        }

        int v4 = arg10;
        if((arg12 & 16) != 0) {
            arg11 = BufferOverflow.SUSPEND;
        }

        this(arg7, arg8, v3, v4, arg11);
    }

    protected String additionalToStringProps() {
        return "channel=" + this.channel;
    }

    public Object collect(FlowCollector arg3, Continuation arg4) {
        Object v2;
        if(this.capacity == -3) {
            this.markConsumed();
            v2 = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(arg3, this.channel, this.consume, arg4);
            if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v2;
            }

            return Unit.INSTANCE;
        }

        v2 = super.collect(arg3, arg4);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    protected Object collectTo(ProducerScope arg2, Continuation arg3) {
        Object v1 = FlowKt__ChannelsKt.access$emitAllImpl$FlowKt__ChannelsKt(new SendingCollector(((SendChannel)arg2)), this.channel, this.consume, arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    protected ChannelFlow create(CoroutineContext arg7, int arg8, BufferOverflow arg9) {
        return new ChannelAsFlow(this.channel, this.consume, arg7, arg8, arg9);
    }

    public Flow dropChannelOperators() {
        return new ChannelAsFlow(this.channel, this.consume, null, 0, null, 28, null);
    }

    private final int getConsumed$volatile() {
        return this.consumed$volatile;
    }

    private static final AtomicIntegerFieldUpdater getConsumed$volatile$FU() {
        return ChannelAsFlow.consumed$volatile$FU;
    }

    private final void markConsumed() {
        if(this.consume) {
            if(ChannelAsFlow.getConsumed$volatile$FU().getAndSet(this, 1) != 1) {
                return;
            }

            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
        }
    }

    public ReceiveChannel produceImpl(CoroutineScope arg3) {
        this.markConsumed();
        if(this.capacity == -3) {
            return this.channel;
        }

        return super.produceImpl(arg3);
    }

    private final void setConsumed$volatile(int arg1) {
        this.consumed$volatile = arg1;
    }
}

