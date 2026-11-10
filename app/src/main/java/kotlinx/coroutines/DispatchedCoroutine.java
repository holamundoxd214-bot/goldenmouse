package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\fH\u0002J\b\u0010\r\u001A\u00020\fH\u0002J\u0012\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0014J\u000F\u0010\u0013\u001A\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0014R\t\u0010\t\u001A\u00020\nX\u0082\u0004¨\u0006\u0015"}, d2={"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "trySuspend", "", "tryResume", "afterCompletion", "", "state", "", "afterResume", "getResult", "getResult$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DispatchedCoroutine extends ScopeCoroutine {
    static {
        DispatchedCoroutine._decision$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision$volatile");
    }

    public DispatchedCoroutine(CoroutineContext arg1, Continuation arg2) {
        super(arg1, arg2);
    }

    protected void afterCompletion(Object arg1) {
        this.afterResume(arg1);
    }

    protected void afterResume(Object arg2) {
        if(this.tryResume()) {
            return;
        }

        DispatchedContinuationKt.resumeCancellableWith(IntrinsicsKt.intercepted(this.uCont), CompletionStateKt.recoverResult(arg2, this.uCont));
    }

    public final Object getResult$kotlinx_coroutines_core() {
        if(this.trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }

        Object v1 = JobSupportKt.unboxState(this.getState$kotlinx_coroutines_core());
        if(!(v1 instanceof CompletedExceptionally)) {
            return v1;
        }

        throw ((CompletedExceptionally)v1).cause;
    }

    private final int get_decision$volatile() {
        return this._decision$volatile;
    }

    private static final AtomicIntegerFieldUpdater get_decision$volatile$FU() {
        return DispatchedCoroutine._decision$volatile$FU;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Int(AtomicIntegerFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(Integer.valueOf(arg1.get(arg2)));
        }
    }

    private final void set_decision$volatile(int arg1) {
        this._decision$volatile = arg1;
    }

    private final boolean tryResume() {
        AtomicIntegerFieldUpdater v0 = DispatchedCoroutine.get_decision$volatile$FU();
        do {
            int v1 = v0.get(this);
            if(v1 != 0) {
                goto label_5;
            }
        }
        while(!DispatchedCoroutine.get_decision$volatile$FU().compareAndSet(this, 0, 2));

        return 1;
    label_5:
        if(v1 == 1) {
            return 0;
        }

        throw new IllegalStateException("Already resumed".toString());
    }

    private final boolean trySuspend() {
        AtomicIntegerFieldUpdater v0 = DispatchedCoroutine.get_decision$volatile$FU();
        do {
            int v1 = v0.get(this);
            if(v1 != 0) {
                goto label_4;
            }
        }
        while(!DispatchedCoroutine.get_decision$volatile$FU().compareAndSet(this, 0, 1));

        return 1;
    label_4:
        if(v1 == 2) {
            return 0;
        }

        throw new IllegalStateException("Already suspended".toString());
    }
}

