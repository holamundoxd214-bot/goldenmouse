package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B8\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\'\u0010\u0005\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u000F\u001A\u00020\u000EH\u0014R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lkotlinx/coroutines/LazyDeferredCoroutine;", "T", "Lkotlinx/coroutines/DeferredCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "", "onStart", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class LazyDeferredCoroutine extends DeferredCoroutine {
    private final Continuation continuation;

    public LazyDeferredCoroutine(CoroutineContext arg2, Function2 arg3) {
        super(arg2, false);
        this.continuation = IntrinsicsKt.createCoroutineUnintercepted(arg3, this, this);
    }

    protected void onStart() {
        CancellableKt.startCoroutineCancellable(this.continuation, ((Continuation)this));
    }
}

