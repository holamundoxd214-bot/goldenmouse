package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u000BH\u0014R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\f¨\u0006\u0015"}, d2={"Lkotlinx/coroutines/channels/ProducerCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "isActive", "", "()Z", "onCompleted", "", "value", "(Lkotlin/Unit;)V", "onCancelled", "cause", "", "handled", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ProducerCoroutine extends ChannelCoroutine implements ProducerScope {
    public ProducerCoroutine(CoroutineContext arg2, Channel arg3) {
        super(arg2, arg3, true, true);
    }

    public SendChannel getChannel() {
        return this.getChannel();
    }

    public boolean isActive() {
        return super.isActive();
    }

    protected void onCancelled(Throwable arg2, boolean arg3) {
        if(!this.get_channel().close(arg2) && !arg3) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), arg2);
        }
    }

    public void onCompleted(Object arg1) {
        this.onCompleted(((Unit)arg1));
    }

    protected void onCompleted(Unit arg2) {
        DefaultImpls.close$default(this.get_channel(), null, 1, null);
    }
}

