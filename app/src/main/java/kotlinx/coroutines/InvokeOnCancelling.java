package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B0\u0012\'\u0010\u0002\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0004\b\n\u0010\u000BJ\u0012\u0010\u0012\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0016R/\u0010\u0002\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\t\u0010\f\u001A\u00020\rX\u0082\u0004R\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2={"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/JobNode;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "_invoked", "Lkotlinx/atomicfu/AtomicBoolean;", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class InvokeOnCancelling extends JobNode {
    private final Function1 handler;

    static {
        InvokeOnCancelling._invoked$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked$volatile");
    }

    public InvokeOnCancelling(Function1 arg1) {
        super();
        this.handler = arg1;
    }

    public boolean getOnCancelling() {
        return 1;
    }

    private final int get_invoked$volatile() {
        return this._invoked$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_invoked$volatile$FU() {
        return InvokeOnCancelling._invoked$volatile$FU;
    }

    public void invoke(Throwable arg4) {
        if(InvokeOnCancelling.get_invoked$volatile$FU().compareAndSet(this, 0, 1)) {
            this.handler.invoke(arg4);
        }
    }

    private final void set_invoked$volatile(int arg1) {
        this._invoked$volatile = arg1;
    }
}

