package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B%\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u0012\u0010\u0015\u001A\u00020\n2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0007J\u001B\u0010\u0015\u001A\u00020\u00032\u000E\u0010\u0016\u001A\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019¢\u0006\u0002\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\u0015\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001D\u001A\u00020\u0003H\u0014¢\u0006\u0002\u0010\u001EJ\u0018\u0010\u001F\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010 \u001A\u00020\nH\u0014J\u0012\u0010!\u001A\u00020\n2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0016J.\u0010\"\u001A\u00020\u00032#\u0010#\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030$H\u0096\u0001J\u0016\u0010\'\u001A\u00020\n2\u0006\u0010(\u001A\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010)J\u000F\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00000+H\u0096\u0001J\u0016\u0010,\u001A\u00020\u00032\u0006\u0010(\u001A\u00028\u0000H\u0096A¢\u0006\u0002\u0010-J\u001E\u0010.\u001A\b\u0012\u0004\u0012\u00020\u00030/2\u0006\u0010(\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0004\b0\u00101R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u000F\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0014\u00102\u001A\u00020\n8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b2\u0010\u0010R$\u00103\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001204X\u0096\u0005¢\u0006\u0006\u001A\u0004\b5\u00106¨\u00067"}, d2={"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "isActive", "()Z", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "onCompleted", "value", "(Lkotlin/Unit;)V", "onCancelled", "handled", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosedForSend", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) class BroadcastCoroutine extends AbstractCoroutine implements BroadcastChannel, ProducerScope {
    private final BroadcastChannel _channel;

    public BroadcastCoroutine(CoroutineContext arg2, BroadcastChannel arg3, boolean arg4) {
        super(arg2, false, arg4);
        this._channel = arg3;
        this.initParentJob(arg2.get(Job.Key));
    }

    public final void cancel(CancellationException arg4) {
        JobCancellationException v4;
        if(arg4 == null) {
            v4 = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }

        this.cancelInternal(((Throwable)v4));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public final boolean cancel(Throwable arg4) {
        JobCancellationException v4;
        if(arg4 == null) {
            v4 = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }

        this.cancelInternal(((Throwable)v4));
        return 1;
    }

    public void cancelInternal(Throwable arg4) {
        CancellationException v4 = JobSupport.toCancellationException$default(this, arg4, null, 1, null);
        this._channel.cancel(v4);
        this.cancelCoroutine(((Throwable)v4));
    }

    public boolean close(Throwable arg2) {
        boolean v2 = this._channel.close(arg2);
        this.start();
        return v2;
    }

    public SendChannel getChannel() {
        return this;
    }

    public SelectClause2 getOnSend() {
        return this._channel.getOnSend();
    }

    protected final BroadcastChannel get_channel() {
        return this._channel;
    }

    public void invokeOnClose(Function1 arg1) {
        this._channel.invokeOnClose(arg1);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public boolean offer(Object arg1) {
        return this._channel.offer(arg1);
    }

    protected void onCancelled(Throwable arg2, boolean arg3) {
        if(!this._channel.close(arg2) && !arg3) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), arg2);
        }
    }

    public void onCompleted(Object arg1) {
        this.onCompleted(((Unit)arg1));
    }

    protected void onCompleted(Unit arg2) {
        DefaultImpls.close$default(this._channel, null, 1, null);
    }

    public ReceiveChannel openSubscription() {
        return this._channel.openSubscription();
    }

    public Object send(Object arg1, Continuation arg2) {
        return this._channel.send(arg1, arg2);
    }

    public Object trySend-JP2dKIU(Object arg1) {
        return this._channel.trySend-JP2dKIU(arg1);
    }
}

