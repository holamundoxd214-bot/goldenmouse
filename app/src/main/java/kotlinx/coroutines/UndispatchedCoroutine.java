package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0003\u001A\u00020\u00042\b\u0010\u0011\u001A\u0004\u0018\u00010\fJ\u0006\u0010\u0012\u001A\u00020\u000EJ\b\u0010\u0013\u001A\u00020\u0010H\u0016J\u0012\u0010\u0014\u001A\u00020\u00102\b\u0010\u0015\u001A\u0004\u0018\u00010\fH\u0014J\b\u0010\u0016\u001A\u00020\u0010H\u0002R\"\u0010\t\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000B0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "threadLocalIsSet", "", "saveThreadContext", "", "oldValue", "clearThreadContext", "afterCompletionUndispatched", "afterResume", "state", "clearThreadLocal", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class UndispatchedCoroutine extends ScopeCoroutine {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal threadStateToRecover;

    public UndispatchedCoroutine(CoroutineContext arg2, Continuation arg3) {
        CoroutineContext v0 = arg2.get(UndispatchedMarker.INSTANCE) == null ? arg2.plus(UndispatchedMarker.INSTANCE) : arg2;
        super(v0, arg3);
        this.threadStateToRecover = new ThreadLocal();
        if(!(arg3.getContext().get(ContinuationInterceptor.Key) instanceof CoroutineDispatcher)) {
            Object v3 = ThreadContextKt.updateThreadContext(arg2, null);
            ThreadContextKt.restoreThreadContext(arg2, v3);
            this.saveThreadContext(arg2, v3);
        }
    }

    public void afterCompletionUndispatched() {
        this.clearThreadLocal();
    }

    protected void afterResume(Object arg6) {
        this.clearThreadLocal();
        arg6 = CompletionStateKt.recoverResult(arg6, this.uCont);
        Continuation v0 = this.uCont;
        CoroutineContext v1 = v0.getContext();
        Object v2 = null;
        Object v3 = ThreadContextKt.updateThreadContext(v1, v2);
        if(v3 != ThreadContextKt.NO_THREAD_ELEMENTS) {
            UndispatchedCoroutine v2_1 = CoroutineContextKt.updateUndispatchedCompletion(v0, v1, v3);
        }

        try {
            this.uCont.resumeWith(arg6);
            if(v2_1 == null) {
                goto label_18;
            }
        }
        catch(Throwable v5) {
            if(v2_1 == null || (v2_1.clearThreadContext())) {
                ThreadContextKt.restoreThreadContext(v1, v3);
            }

            throw v5;
        }

        if(v2_1.clearThreadContext()) {
        }
        else {
            return;
        }

    label_18:
        ThreadContextKt.restoreThreadContext(v1, v3);
    }

    public final boolean clearThreadContext() {
        int v0 = !this.threadLocalIsSet || this.threadStateToRecover.get() != null ? 0 : 1;
        this.threadStateToRecover.remove();
        return v0 ^ 1;
    }

    private final void clearThreadLocal() {
        if(this.threadLocalIsSet) {
            Object v0 = this.threadStateToRecover.get();
            if(v0 != null) {
                ThreadContextKt.restoreThreadContext(((Pair)v0).component1(), ((Pair)v0).component2());
            }

            this.threadStateToRecover.remove();
        }
    }

    public final void saveThreadContext(CoroutineContext arg2, Object arg3) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(TuplesKt.to(arg2, arg3));
    }
}

