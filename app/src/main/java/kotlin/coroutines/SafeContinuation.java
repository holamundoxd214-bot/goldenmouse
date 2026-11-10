package kotlin.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result$Failure;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001B*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001BB!\b@\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0017\bQ\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u001D\u0010\u000F\u001A\u00020\u00102\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0012J\f\u0010\u0013\u001A\u0004\u0018\u00010\u0006H\u0081\u0080\u0004J\f\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001A\u00020\u001AH\u0096\u0080\u0004R\u0015\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\n\u001A\u00020\u000B8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u0004\u0018\u00010\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001A\u0004\u0018\u00010\u00038VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u001C"}, d2={"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "initialResult", "", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "getOrThrow", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class SafeContinuation implements Continuation, CoroutineStackFrame {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003Re\u0010\u0004\u001AR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001 \u0007*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00050\u0005X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003¨\u0006\t"}, d2={"Lkotlin/coroutines/SafeContinuation$Companion;", "", "<init>", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "getRESULT$annotations", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        private static void getRESULT$annotations() {
        }
    }

    private static final Companion Companion;
    private static final AtomicReferenceFieldUpdater RESULT;
    private final Continuation delegate;
    private volatile Object result;

    static {
        SafeContinuation.Companion = new Companion(null);
        SafeContinuation.RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    }

    public SafeContinuation(Continuation arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        super();
        this.delegate = arg2;
        this.result = arg3;
    }

    public SafeContinuation(Continuation arg2) {
        Intrinsics.checkNotNullParameter(arg2, "delegate");
        this(arg2, CoroutineSingletons.UNDECIDED);
    }

    public CoroutineStackFrame getCallerFrame() {
        Continuation v1 = this.delegate;
        if((v1 instanceof CoroutineStackFrame)) {
            return ((CoroutineStackFrame)v1);
        }

        return null;
    }

    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    public final Object getOrThrow() {
        Object v0 = this.result;
        if(v0 == CoroutineSingletons.UNDECIDED) {
            if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SafeContinuation.RESULT, this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            else {
                v0 = this.result;
            }
        }

        if(v0 == CoroutineSingletons.RESUMED) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }

        if(!(v0 instanceof Failure)) {
            return v0;
        }

        throw ((Failure)v0).exception;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object arg4) {
        do {
        label_0:
            Object v0 = this.result;
            if(v0 == CoroutineSingletons.UNDECIDED) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SafeContinuation.RESULT, this, CoroutineSingletons.UNDECIDED, arg4)) {
                    goto label_0;
                }

                return;
            }

            if(v0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                goto label_18;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SafeContinuation.RESULT, this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED));

        this.delegate.resumeWith(arg4);
        return;
    label_18:
        throw new IllegalStateException("Already resumed");
    }

    public String toString() {
        return "SafeContinuation for " + this.delegate;
    }
}

