package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.selects.SelectClause2;

@Deprecated(level=DeprecationLevel.ERROR, message="ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") @Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\b\u0002\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001A\u00028\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0097\u0001J\u001E\u0010\u000E\u001A\u00020\u00122\u000E\u0010\u0010\u001A\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0096\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0096\u0001J.\u0010\u0017\u001A\u00020\u00122#\u0010\u0018\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u001A\u0012\b\b\u001B\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00120\u0019H\u0096\u0001J\u0016\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\u001D\u001A\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010\u001EJ\u000F\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000 H\u0096\u0001J\u0016\u0010!\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00028\u0000H\u0096A¢\u0006\u0002\u0010\"J\u001E\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\u001D\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00028\u00008F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\f\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0014\u0010\'\u001A\u00020\u000F8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b\'\u0010(R$\u0010)\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0*X\u0096\u0005¢\u0006\u0006\u001A\u0004\b,\u0010-¨\u0006."}, d2={"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcast", "Lkotlinx/coroutines/channels/BroadcastChannelImpl;", "<init>", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "()V", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull", "cancel", "", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosedForSend", "()Z", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ConflatedBroadcastChannel implements BroadcastChannel {
    private final BroadcastChannelImpl broadcast;

    public ConflatedBroadcastChannel() {
        this(new BroadcastChannelImpl(-1));
    }

    private ConflatedBroadcastChannel(BroadcastChannelImpl arg1) {
        super();
        this.broadcast = arg1;
    }

    public ConflatedBroadcastChannel(Object arg1) {
        this();
        this.trySend-JP2dKIU(arg1);
    }

    public void cancel(CancellationException arg1) {
        this.broadcast.cancel(arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility only") public boolean cancel(Throwable arg1) {
        return this.broadcast.cancel(arg1);
    }

    public boolean close(Throwable arg1) {
        return this.broadcast.close(arg1);
    }

    public SelectClause2 getOnSend() {
        return this.broadcast.getOnSend();
    }

    public final Object getValue() {
        return this.broadcast.getValue();
    }

    public final Object getValueOrNull() {
        return this.broadcast.getValueOrNull();
    }

    public void invokeOnClose(Function1 arg1) {
        this.broadcast.invokeOnClose(arg1);
    }

    public boolean isClosedForSend() {
        return this.broadcast.isClosedForSend();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public boolean offer(Object arg1) {
        return this.broadcast.offer(arg1);
    }

    public ReceiveChannel openSubscription() {
        return this.broadcast.openSubscription();
    }

    public Object send(Object arg1, Continuation arg2) {
        return this.broadcast.send(arg1, arg2);
    }

    public Object trySend-JP2dKIU(Object arg1) {
        return this.broadcast.trySend-JP2dKIU(arg1);
    }
}

