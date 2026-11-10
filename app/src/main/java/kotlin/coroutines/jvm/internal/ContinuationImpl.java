package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B%\bF\u0012\u0010\u0010\u0002\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001B\bV\u0012\u0010\u0010\u0002\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u0012\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0086\u0080\u0004J\n\u0010\u000E\u001A\u00020\u000FH\u0094\u0080\u0004R\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\n\u001A\u00020\u00068VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0019\u0010\r\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "_context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "(Lkotlin/coroutines/Continuation;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient Continuation intercepted;

    public ContinuationImpl(Continuation arg2) {
        CoroutineContext v0 = arg2 != null ? arg2.getContext() : null;
        this(arg2, v0);
    }

    public ContinuationImpl(Continuation arg1, CoroutineContext arg2) {
        super(arg1);
        this._context = arg2;
    }

    public CoroutineContext getContext() {
        CoroutineContext v0 = this._context;
        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public final Continuation intercepted() {
        ContinuationImpl v0_2;
        Continuation v0 = this.intercepted;
        if(v0 == null) {
            Element v0_1 = this.getContext().get(ContinuationInterceptor.Key);
            if(v0_1 != null) {
                v0 = ((ContinuationInterceptor)v0_1).interceptContinuation(this);
                if(v0 == null) {
                    goto label_9;
                }
            }
            else {
            label_9:
                v0_2 = this;
            }

            this.intercepted = ((Continuation)v0_2);
        }

        return ((Continuation)v0_2);
    }

    protected void releaseIntercepted() {
        Continuation v0 = this.intercepted;
        if(v0 != null && (((ContinuationImpl)v0)) != this) {
            Element v1 = this.getContext().get(ContinuationInterceptor.Key);
            Intrinsics.checkNotNull(v1);
            ((ContinuationInterceptor)v1).releaseInterceptedContinuation(v0);
        }

        this.intercepted = CompletedContinuation.INSTANCE;
    }
}

