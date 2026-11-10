package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001D\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000E\u001A\n\u0018\u00010\u000Fj\u0004\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001A\u00020\u0016H\u0016J\u0012\u0010\u001A\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0014R\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000B\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001A\u00020\u00138DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0014¨\u0006\u001B"}, d2={"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "()Ljava/lang/StackTraceElement;", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "afterCompletionUndispatched", "afterResume", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class ScopeCoroutine extends AbstractCoroutine implements CoroutineStackFrame {
    public final Continuation uCont;

    public ScopeCoroutine(CoroutineContext arg2, Continuation arg3) {
        super(arg2, true, true);
        this.uCont = arg3;
    }

    protected void afterCompletion(Object arg2) {
        DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(this.uCont), CompletionStateKt.recoverResult(arg2, this.uCont));
    }

    public void afterCompletionUndispatched() {
    }

    protected void afterResume(Object arg1) {
        this.uCont.resumeWith(CompletionStateKt.recoverResult(arg1, this.uCont));
    }

    public final CoroutineStackFrame getCallerFrame() {
        Continuation v1 = this.uCont;
        if((v1 instanceof CoroutineStackFrame)) {
            return ((CoroutineStackFrame)v1);
        }

        return null;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    protected final boolean isScopedCoroutine() {
        return 1;
    }
}

