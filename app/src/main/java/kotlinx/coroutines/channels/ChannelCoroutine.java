package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B-\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u0011\u001A\u00020\u0003H\u0017J\u0012\u0010\u0011\u001A\u00020\t2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0007J\u001B\u0010\u0011\u001A\u00020\u00032\u000E\u0010\u0012\u001A\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J\u0013\u0010\u0018\u001A\u00020\t2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0096\u0001J.\u0010\u0019\u001A\u00020\u00032#\u0010\u001A\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u001C\u0012\b\b\u001D\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u001BH\u0096\u0001J\u000F\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000\u001FH\u0096\u0003J\u0016\u0010 \u001A\u00020\t2\u0006\u0010!\u001A\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010\"J\u0010\u0010#\u001A\u0004\u0018\u00018\u0000H\u0097\u0001¢\u0006\u0002\u0010$J\u000E\u0010%\u001A\u00028\u0000H\u0096A¢\u0006\u0002\u0010&J\u0016\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000(H\u0096A¢\u0006\u0004\b)\u0010&J\u0010\u0010*\u001A\u0004\u0018\u00018\u0000H\u0097A¢\u0006\u0002\u0010&J\u0016\u0010+\u001A\u00020\u00032\u0006\u0010!\u001A\u00028\u0000H\u0096A¢\u0006\u0002\u0010,J\u0016\u0010-\u001A\b\u0012\u0004\u0012\u00028\u00000(H\u0096\u0001¢\u0006\u0004\b.\u0010$J\u001E\u0010/\u001A\b\u0012\u0004\u0012\u00020\u00030(2\u0006\u0010!\u001A\u00028\u0000H\u0096\u0001¢\u0006\u0004\b0\u00101R\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u000ER\u0014\u00102\u001A\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b2\u00103R\u0014\u00104\u001A\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b4\u00103R\u0014\u00105\u001A\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001A\u0004\b5\u00103R\u0018\u00106\u001A\b\u0012\u0004\u0012\u00028\u000007X\u0096\u0005¢\u0006\u0006\u001A\u0004\b8\u00109R\u001E\u0010:\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(07X\u0096\u0005¢\u0006\u0006\u001A\u0004\b;\u00109R\u001C\u0010<\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000078VX\u0097\u0005¢\u0006\u0006\u001A\u0004\b=\u00109R$\u0010>\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@0?X\u0096\u0005¢\u0006\u0006\u001A\u0004\bA\u0010B¨\u0006C"}, d2={"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "initParentJob", "", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "channel", "getChannel", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "offer", "element", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveOrNull", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive", "tryReceive-PtdJZtk", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosedForReceive", "()Z", "isClosedForSend", "isEmpty", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class ChannelCoroutine extends AbstractCoroutine implements Channel {
    private final Channel _channel;

    public ChannelCoroutine(CoroutineContext arg1, Channel arg2, boolean arg3, boolean arg4) {
        super(arg1, arg3, arg4);
        this._channel = arg2;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public void cancel() {
        this.cancelInternal(new JobCancellationException(this.cancellationExceptionMessage(), null, this));
    }

    public final void cancel(CancellationException arg4) {
        JobCancellationException v4;
        if(this.isCancelled()) {
            return;
        }

        if(arg4 == null) {
            v4 = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }

        this.cancelInternal(((Throwable)v4));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public final boolean cancel(Throwable arg4) {
        this.cancelInternal(new JobCancellationException(this.cancellationExceptionMessage(), null, this));
        return 1;
    }

    public void cancelInternal(Throwable arg4) {
        CancellationException v4 = JobSupport.toCancellationException$default(this, arg4, null, 1, null);
        this._channel.cancel(v4);
        this.cancelCoroutine(((Throwable)v4));
    }

    public boolean close(Throwable arg1) {
        return this._channel.close(arg1);
    }

    public final Channel getChannel() {
        return this;
    }

    public SelectClause1 getOnReceive() {
        return this._channel.getOnReceive();
    }

    public SelectClause1 getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    public SelectClause1 getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    public SelectClause2 getOnSend() {
        return this._channel.getOnSend();
    }

    protected final Channel get_channel() {
        return this._channel;
    }

    public void invokeOnClose(Function1 arg1) {
        this._channel.invokeOnClose(arg1);
    }

    public boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    public boolean isEmpty() {
        return this._channel.isEmpty();
    }

    public ChannelIterator iterator() {
        return this._channel.iterator();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public boolean offer(Object arg1) {
        return this._channel.offer(arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'tryReceive\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'poll\' did, for the precise replacement please refer to the \'poll\' documentation", replaceWith="<_subannotation>") public Object poll() {
        return this._channel.poll();
    }

    public Object receive(Continuation arg1) {
        return this._channel.receive(arg1);
    }

    public Object receiveCatching-JP2dKIU(Continuation arg1) {
        Object v0 = this._channel.receiveCatching-JP2dKIU(arg1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return v0;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of \'receiveCatching\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'receiveOrNull\' did, for the detailed replacement please refer to the \'receiveOrNull\' documentation", replaceWith="<_subannotation>") public Object receiveOrNull(Continuation arg1) {
        return this._channel.receiveOrNull(arg1);
    }

    public Object send(Object arg1, Continuation arg2) {
        return this._channel.send(arg1, arg2);
    }

    public Object tryReceive-PtdJZtk() {
        return this._channel.tryReceive-PtdJZtk();
    }

    public Object trySend-JP2dKIU(Object arg1) {
        return this._channel.trySend-JP2dKIU(arg1);
    }
}

