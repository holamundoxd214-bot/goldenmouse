package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004J\u001D\u0010\u000F\u001A\u00020\u00022\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00020\nH\u0096\u0080\u0004¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001A\u00020\u0002H\u0086\u0080\u0004R\u0015\u0010\u0005\u001A\u00020\u00068VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR#\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0012"}, d2={"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "resumeWith", "(Ljava/lang/Object;)V", "await", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class RunSuspend implements Continuation {
    private Result result;

    public RunSuspend() {
        super();
    }

    public final void await() {
        Result v0_1;
        __monitor_enter(this);
        try {
            while(true) {
                v0_1 = this.result;
                if(v0_1 != null) {
                    break;
                }

                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                this.wait();
            }

            ResultKt.throwOnFailure(v0_1.unbox-impl());
        }
        catch(Throwable v0) {
            __monitor_exit(this);
            throw v0;
        }

        __monitor_exit(this);
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final Result getResult-xLWZpok() {
        return this.result;
    }

    public void resumeWith(Object arg1) {
        __monitor_enter(this);
        try {
            this.result = Result.box-impl(arg1);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            this.notifyAll();
        }
        catch(Throwable v1) {
            __monitor_exit(this);
            throw v1;
        }

        __monitor_exit(this);
    }

    public final void setResult(Result arg1) {
        this.result = arg1;
    }
}

