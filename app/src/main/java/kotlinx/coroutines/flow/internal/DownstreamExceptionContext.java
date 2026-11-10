package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J<\u0010\u0007\u001A\u0002H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\t2\u0006\u0010\n\u001A\u0002H\b2\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\b0\fH\u0096\u0001¢\u0006\u0002\u0010\u000EJ(\u0010\u000F\u001A\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\r2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00100\u0012H\u0096\u0003¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001A\u00020\u00012\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0012H\u0096\u0001J\u0011\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0001H\u0096\u0003R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "Lkotlin/coroutines/CoroutineContext;", "e", "", "originalContext", "<init>", "(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V", "fold", "R", "", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DownstreamExceptionContext implements CoroutineContext {
    public final Throwable e;

    public DownstreamExceptionContext(Throwable arg1, CoroutineContext arg2) {
        super();
        this.$$delegate_0 = arg2;
        this.e = arg1;
    }

    public Object fold(Object arg1, Function2 arg2) {
        return this.$$delegate_0.fold(arg1, arg2);
    }

    public Element get(Key arg1) {
        return this.$$delegate_0.get(arg1);
    }

    public CoroutineContext minusKey(Key arg1) {
        return this.$$delegate_0.minusKey(arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return this.$$delegate_0.plus(arg1);
    }
}

