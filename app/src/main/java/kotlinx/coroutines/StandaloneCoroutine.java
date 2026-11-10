package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000BH\u0014¨\u0006\f"}, d2={"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;Z)V", "handleJobException", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) class StandaloneCoroutine extends AbstractCoroutine {
    public StandaloneCoroutine(CoroutineContext arg2, boolean arg3) {
        super(arg2, true, arg3);
    }

    protected boolean handleJobException(Throwable arg1) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), arg1);
        return 1;
    }
}

