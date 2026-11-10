package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0012\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0014J\u0010\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\u000FH\u0014¨\u0006\u0012"}, d2={"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "onCancelling", "", "cause", "", "handleJobException", "exception", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) class ActorCoroutine extends ChannelCoroutine implements ActorScope {
    public ActorCoroutine(CoroutineContext arg2, Channel arg3, boolean arg4) {
        super(arg2, arg3, false, arg4);
        this.initParentJob(arg2.get(Job.Key));
    }

    protected boolean handleJobException(Throwable arg1) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), arg1);
        return 1;
    }

    protected void onCancelling(Throwable arg4) {
        Channel v0 = this.get_channel();
        Throwable v1 = null;
        if(arg4 != null) {
            if((arg4 instanceof CancellationException)) {
                v1 = arg4;
            }

            if(v1 != null) {
                goto label_16;
            }

            CancellationException v1_1 = ExceptionsKt.CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled", arg4);
        }

    label_16:
        v0.cancel(((CancellationException)v1));
    }
}

