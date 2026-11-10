package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\n2\u000E\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0096\u0080\u0004¢\u0006\u0002\u0010\rJ\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u00068VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2={"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class CompletedContinuation implements Continuation {
    public static final CompletedContinuation INSTANCE;

    static {
        CompletedContinuation.INSTANCE = new CompletedContinuation();
    }

    private CompletedContinuation() {
        super();
    }

    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public void resumeWith(Object arg1) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}

